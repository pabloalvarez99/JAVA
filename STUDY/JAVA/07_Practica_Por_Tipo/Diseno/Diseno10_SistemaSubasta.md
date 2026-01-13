# EJERCICIO DISENO #10: Sistema de Subastas
**Dificultad: ⭐⭐⭐⭐**

## Requerimientos

Disenar un sistema de subastas online:

1. **Articulos**
   - Descripcion, fotos, categoria
   - Precio base (minimo)
   - Incremento minimo entre pujas

2. **Subastas**
   - Fecha/hora inicio y fin
   - Estados: Programada, Activa, Cerrada, Adjudicada
   - Extension automatica si hay puja en ultimos 5 min

3. **Usuarios**
   - Pueden ser vendedores y compradores
   - Historial de subastas
   - Reputacion/calificacion

4. **Pujas**
   - Monto debe superar puja actual + incremento minimo
   - Notificar al anterior mejor postor
   - Puja maxima automatica (proxy bidding)

---

## PARTE 1: Tu Diseno

### 1.1 Proxy Bidding
```
Usuario pone puja maxima de $100.
Si puja actual es $50, sistema puja $51 (minimo necesario).
Si otro puja $60, sistema automaticamente puja $61.

Como implementar?
_______________
```

### 1.2 Extension Automatica
```
Si alguien puja en los ultimos 5 min, extender fin.
Como evitar subastas infinitas?
_______________
```

---

## PARTE 2: Solucion Propuesta (NO MIRAR ANTES)

### Codigo Esqueleto

```java
import java.time.*;
import java.util.*;

enum EstadoSubasta { PROGRAMADA, ACTIVA, CERRADA, ADJUDICADA, CANCELADA }

class Articulo {
    private String id;
    private String titulo;
    private String descripcion;
    private String categoria;
    private List<String> fotos;
    private String vendedorId;

    public Articulo(String titulo, String descripcion, String vendedorId) {
        this.id = UUID.randomUUID().toString();
        this.titulo = titulo;
        this.descripcion = descripcion;
        this.vendedorId = vendedorId;
        this.fotos = new ArrayList<>();
    }

    // getters, setters...
}

class Usuario {
    private String id;
    private String nombre;
    private String email;
    private double reputacion; // 1-5 estrellas
    private int totalVentas;
    private int totalCompras;

    public Usuario(String nombre, String email) {
        this.id = UUID.randomUUID().toString();
        this.nombre = nombre;
        this.email = email;
        this.reputacion = 0;
    }

    public void recibirCalificacion(int estrellas) {
        int totalOps = totalVentas + totalCompras;
        this.reputacion = ((reputacion * totalOps) + estrellas) / (totalOps + 1);
    }

    // getters...
}

class Puja {
    private String id;
    private String usuarioId;
    private double monto;
    private LocalDateTime timestamp;
    private boolean esAutomatica; // Generada por proxy bidding

    public Puja(String usuarioId, double monto, boolean automatica) {
        this.id = UUID.randomUUID().toString();
        this.usuarioId = usuarioId;
        this.monto = monto;
        this.timestamp = LocalDateTime.now();
        this.esAutomatica = automatica;
    }

    // getters...
}

// Puja maxima secreta del usuario
class PujaProxy {
    private String usuarioId;
    private double montoMaximo;

    public PujaProxy(String usuarioId, double montoMaximo) {
        this.usuarioId = usuarioId;
        this.montoMaximo = montoMaximo;
    }

    public boolean puedeSuperar(double monto, double incremento) {
        return montoMaximo >= monto + incremento;
    }

    // getters...
}

interface SubastaObserver {
    void onNuevaPuja(Subasta subasta, Puja puja);
    void onSuperado(Subasta subasta, String usuarioId);
    void onSubastaTerminada(Subasta subasta);
    void onExtension(Subasta subasta, LocalDateTime nuevoFin);
}

class Subasta {
    private String id;
    private Articulo articulo;
    private double precioBase;
    private double incrementoMinimo;
    private LocalDateTime fechaInicio;
    private LocalDateTime fechaFin;
    private LocalDateTime fechaFinOriginal;
    private EstadoSubasta estado;

    private List<Puja> pujas = new ArrayList<>();
    private Map<String, PujaProxy> pujasProxy = new HashMap<>();
    private Puja pujaGanadora;

    private List<SubastaObserver> observers = new ArrayList<>();

    private static final Duration TIEMPO_EXTENSION = Duration.ofMinutes(5);
    private static final int MAX_EXTENSIONES = 10;
    private int extensionesUsadas = 0;

    public Subasta(Articulo articulo, double precioBase, double incremento,
                   LocalDateTime inicio, LocalDateTime fin) {
        this.id = UUID.randomUUID().toString();
        this.articulo = articulo;
        this.precioBase = precioBase;
        this.incrementoMinimo = incremento;
        this.fechaInicio = inicio;
        this.fechaFin = fin;
        this.fechaFinOriginal = fin;
        this.estado = EstadoSubasta.PROGRAMADA;
    }

    public void activar() {
        if (LocalDateTime.now().isBefore(fechaInicio)) {
            throw new IllegalStateException("Aun no es hora de inicio");
        }
        estado = EstadoSubasta.ACTIVA;
    }

    public Puja pujar(String usuarioId, double monto) {
        return pujar(usuarioId, monto, null);
    }

    public Puja pujar(String usuarioId, double monto, Double montoMaximoProxy) {
        validarPuja(usuarioId, monto);

        // Registrar proxy bidding si se especifica
        if (montoMaximoProxy != null && montoMaximoProxy > monto) {
            pujasProxy.put(usuarioId, new PujaProxy(usuarioId, montoMaximoProxy));
        }

        // Crear puja
        Puja puja = new Puja(usuarioId, monto, false);
        String usuarioSuperado = pujaGanadora != null ? pujaGanadora.getUsuarioId() : null;

        pujas.add(puja);
        pujaGanadora = puja;

        // Notificar al superado
        if (usuarioSuperado != null && !usuarioSuperado.equals(usuarioId)) {
            notificarSuperado(usuarioSuperado);
        }

        // Verificar extension
        verificarExtension();

        // Notificar nueva puja
        notificarNuevaPuja(puja);

        // Activar proxy bidding de otros usuarios
        procesarProxyBidding(usuarioId);

        return puja;
    }

    private void validarPuja(String usuarioId, double monto) {
        if (estado != EstadoSubasta.ACTIVA) {
            throw new IllegalStateException("Subasta no activa");
        }

        if (LocalDateTime.now().isAfter(fechaFin)) {
            cerrar();
            throw new IllegalStateException("Subasta terminada");
        }

        // No puede pujar el vendedor
        if (usuarioId.equals(articulo.getVendedorId())) {
            throw new IllegalStateException("Vendedor no puede pujar");
        }

        double minimo = pujaGanadora != null ?
            pujaGanadora.getMonto() + incrementoMinimo : precioBase;

        if (monto < minimo) {
            throw new IllegalArgumentException(
                "Puja minima requerida: $" + minimo
            );
        }
    }

    private void verificarExtension() {
        LocalDateTime ahora = LocalDateTime.now();
        Duration tiempoRestante = Duration.between(ahora, fechaFin);

        if (tiempoRestante.compareTo(TIEMPO_EXTENSION) < 0 &&
            extensionesUsadas < MAX_EXTENSIONES) {

            fechaFin = ahora.plus(TIEMPO_EXTENSION);
            extensionesUsadas++;

            for (SubastaObserver obs : observers) {
                obs.onExtension(this, fechaFin);
            }
        }
    }

    private void procesarProxyBidding(String usuarioQueAcabaDePujar) {
        for (Map.Entry<String, PujaProxy> entry : pujasProxy.entrySet()) {
            String usuarioProxy = entry.getKey();
            PujaProxy proxy = entry.getValue();

            // No procesar el proxy del usuario que acaba de pujar
            if (usuarioProxy.equals(usuarioQueAcabaDePujar)) continue;

            // Verificar si el proxy puede superar la puja actual
            double montoNecesario = pujaGanadora.getMonto() + incrementoMinimo;
            if (proxy.puedeSuperar(pujaGanadora.getMonto(), incrementoMinimo)) {
                // Calcular monto optimo (minimo necesario)
                double montoPuja = Math.min(proxy.getMontoMaximo(), montoNecesario);

                Puja pujaAuto = new Puja(usuarioProxy, montoPuja, true);
                pujas.add(pujaAuto);
                pujaGanadora = pujaAuto;

                notificarNuevaPuja(pujaAuto);
                notificarSuperado(usuarioQueAcabaDePujar);

                // Recursivamente procesar otros proxies
                procesarProxyBidding(usuarioProxy);
                break;
            }
        }
    }

    public void cerrar() {
        estado = EstadoSubasta.CERRADA;

        for (SubastaObserver obs : observers) {
            obs.onSubastaTerminada(this);
        }
    }

    public void adjudicar() {
        if (estado != EstadoSubasta.CERRADA) {
            throw new IllegalStateException("Subasta debe estar cerrada");
        }

        if (pujaGanadora == null) {
            estado = EstadoSubasta.CANCELADA;
        } else {
            estado = EstadoSubasta.ADJUDICADA;
        }
    }

    private void notificarNuevaPuja(Puja puja) {
        for (SubastaObserver obs : observers) {
            obs.onNuevaPuja(this, puja);
        }
    }

    private void notificarSuperado(String usuarioId) {
        for (SubastaObserver obs : observers) {
            obs.onSuperado(this, usuarioId);
        }
    }

    public double getPrecioActual() {
        return pujaGanadora != null ? pujaGanadora.getMonto() : precioBase;
    }

    public int getNumeroPujas() {
        return pujas.size();
    }

    public void agregarObserver(SubastaObserver observer) {
        observers.add(observer);
    }

    // getters...
}

class SistemaSubastas {
    private Map<String, Usuario> usuarios = new HashMap<>();
    private Map<String, Subasta> subastas = new HashMap<>();

    public Subasta crearSubasta(String vendedorId, Articulo articulo,
                                double precioBase, double incremento,
                                LocalDateTime inicio, LocalDateTime fin) {

        if (!usuarios.containsKey(vendedorId)) {
            throw new IllegalArgumentException("Usuario no registrado");
        }

        Subasta subasta = new Subasta(articulo, precioBase, incremento, inicio, fin);
        subastas.put(subasta.getId(), subasta);

        return subasta;
    }

    public List<Subasta> buscarSubastasActivas(String categoria) {
        return subastas.values().stream()
            .filter(s -> s.getEstado() == EstadoSubasta.ACTIVA)
            .filter(s -> categoria == null ||
                        s.getArticulo().getCategoria().equals(categoria))
            .sorted((s1, s2) -> s1.getFechaFin().compareTo(s2.getFechaFin()))
            .toList();
    }

    public List<Subasta> getSubastasDeUsuario(String usuarioId, boolean comoVendedor) {
        return subastas.values().stream()
            .filter(s -> comoVendedor ?
                s.getArticulo().getVendedorId().equals(usuarioId) :
                s.getPujas().stream().anyMatch(p -> p.getUsuarioId().equals(usuarioId)))
            .toList();
    }
}
```

### Patrones Aplicados
- **Observer**: Notificaciones en tiempo real
- **Proxy Pattern (conceptual)**: Proxy bidding
- **State Pattern (implicit)**: Estados de la subasta

### Extensiones
- Subastas inversas (precio baja)
- Compra inmediata ("Buy Now")
- Reservas (precio minimo secreto)
- Historial de precios
- Integracion con pagos
- Envios
