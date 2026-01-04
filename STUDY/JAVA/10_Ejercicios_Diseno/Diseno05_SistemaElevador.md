# EJERCICIO DISENO #5: Sistema de Elevador
**Dificultad: ⭐⭐⭐**

## Requerimientos

Disenar un sistema de control de elevadores:

1. **Edificio**
   - N pisos (configurable)
   - M elevadores
   - Cada piso tiene botones de subir/bajar

2. **Elevador**
   - Piso actual
   - Direccion: Subiendo, Bajando, Detenido
   - Capacidad maxima de personas
   - Panel interno con botones de pisos

3. **Logica de Despacho**
   - Asignar el elevador mas cercano
   - Priorizar solicitudes en la misma direccion
   - Atender todas las solicitudes eventualmente

4. **Estados del Elevador**
   - Moviendose
   - Puertas abiertas
   - Puertas cerradas
   - En mantenimiento

---

## PARTE 1: Tu Diseno

### 1.1 Identificar Clases
```
1. _______________
2. _______________
3. _______________
4. _______________
```

### 1.2 Algoritmo de Despacho
```
Cuando alguien presiona boton en piso 5 (subir):
1. _______________
2. _______________
3. _______________
```

---

## PARTE 2: Preguntas de Diseno

1. **Como priorizas solicitudes?**

2. **Como evitas que un elevador ignore pisos intermedios?**

3. **Patron Observer para notificar llegadas?**

---

## PARTE 3: Solucion Propuesta (NO MIRAR ANTES)

### Diagrama de Clases

```
+------------------+
|    Direccion     | <<enum>>
+------------------+
| SUBIENDO         |
| BAJANDO          |
| DETENIDO         |
+------------------+

+------------------+
|  EstadoElevador  | <<enum>>
+------------------+
| MOVIENDO         |
| PUERTAS_ABIERTAS |
| PUERTAS_CERRADAS |
| MANTENIMIENTO    |
+------------------+

+------------------+
|    Solicitud     |
+------------------+
| - pisoOrigen: int|
| - direccion: Dir |
| - timestamp: long|
+------------------+

+------------------+
|    Elevador      |
+------------------+
| - id: int        |
| - pisoActual: int|
| - direccion: Dir |
| - estado: Estado |
| - destinos: Set  |
| - capacidad: int |
| - personas: int  |
+------------------+
| + mover()        |
| + agregarDestino |
| + abrirPuertas() |
+------------------+

+------------------+
|   Controlador    |
+------------------+
| - elevadores     |
| - solicitudes    |
+------------------+
| + solicitarElev()|
| + asignarElev()  |
| + tick()         |
+------------------+

+------------------+
|    Edificio      |
+------------------+
| - pisos: int     |
| - controlador    |
| - elevadores     |
+------------------+
| + llamarElevador |
+------------------+
```

### Codigo Esqueleto

```java
import java.util.*;

enum Direccion { SUBIENDO, BAJANDO, DETENIDO }
enum EstadoElevador { MOVIENDO, PUERTAS_ABIERTAS, PUERTAS_CERRADAS, MANTENIMIENTO }

class Solicitud implements Comparable<Solicitud> {
    private int pisoOrigen;
    private Direccion direccionDeseada;
    private long timestamp;

    public Solicitud(int piso, Direccion direccion) {
        this.pisoOrigen = piso;
        this.direccionDeseada = direccion;
        this.timestamp = System.currentTimeMillis();
    }

    @Override
    public int compareTo(Solicitud otra) {
        return Long.compare(this.timestamp, otra.timestamp);
    }

    // getters...
}

class Elevador {
    private int id;
    private int pisoActual;
    private Direccion direccion;
    private EstadoElevador estado;
    private TreeSet<Integer> destinos; // Ordenados
    private int capacidad;
    private int personasActuales;

    public Elevador(int id, int capacidad) {
        this.id = id;
        this.capacidad = capacidad;
        this.pisoActual = 1;
        this.direccion = Direccion.DETENIDO;
        this.estado = EstadoElevador.PUERTAS_CERRADAS;
        this.destinos = new TreeSet<>();
    }

    public void agregarDestino(int piso) {
        destinos.add(piso);
        actualizarDireccion();
    }

    private void actualizarDireccion() {
        if (destinos.isEmpty()) {
            direccion = Direccion.DETENIDO;
        } else {
            int proximoDestino = getProximoDestino();
            direccion = proximoDestino > pisoActual ?
                Direccion.SUBIENDO : Direccion.BAJANDO;
        }
    }

    private int getProximoDestino() {
        if (direccion == Direccion.SUBIENDO) {
            // Buscar siguiente piso arriba
            Integer siguiente = destinos.ceiling(pisoActual + 1);
            if (siguiente != null) return siguiente;
        } else if (direccion == Direccion.BAJANDO) {
            // Buscar siguiente piso abajo
            Integer siguiente = destinos.floor(pisoActual - 1);
            if (siguiente != null) return siguiente;
        }
        // Si no hay en la direccion actual, ir al mas cercano
        return destinos.first();
    }

    public void mover() {
        if (destinos.isEmpty() || estado == EstadoElevador.MANTENIMIENTO) {
            return;
        }

        int proximoDestino = getProximoDestino();

        if (pisoActual < proximoDestino) {
            pisoActual++;
            direccion = Direccion.SUBIENDO;
        } else if (pisoActual > proximoDestino) {
            pisoActual--;
            direccion = Direccion.BAJANDO;
        }

        // Si llegamos al destino
        if (pisoActual == proximoDestino) {
            destinos.remove(pisoActual);
            abrirPuertas();
        }

        estado = EstadoElevador.MOVIENDO;
    }

    public void abrirPuertas() {
        estado = EstadoElevador.PUERTAS_ABIERTAS;
        // Simular tiempo de puertas abiertas
    }

    public void cerrarPuertas() {
        estado = EstadoElevador.PUERTAS_CERRADAS;
    }

    public int distanciaA(int piso) {
        return Math.abs(pisoActual - piso);
    }

    public boolean vaHacia(int piso) {
        if (direccion == Direccion.DETENIDO) return true;
        if (direccion == Direccion.SUBIENDO) return piso >= pisoActual;
        return piso <= pisoActual;
    }

    public boolean tieneCapacidad() {
        return personasActuales < capacidad;
    }

    // getters...
}

class ControladorElevadores {
    private List<Elevador> elevadores;
    private Queue<Solicitud> solicitudesPendientes;

    public ControladorElevadores(List<Elevador> elevadores) {
        this.elevadores = elevadores;
        this.solicitudesPendientes = new PriorityQueue<>();
    }

    public void solicitarElevador(int piso, Direccion direccion) {
        Solicitud solicitud = new Solicitud(piso, direccion);

        // Intentar asignar inmediatamente
        Elevador mejor = encontrarMejorElevador(solicitud);
        if (mejor != null) {
            mejor.agregarDestino(piso);
        } else {
            solicitudesPendientes.add(solicitud);
        }
    }

    private Elevador encontrarMejorElevador(Solicitud solicitud) {
        return elevadores.stream()
            .filter(e -> e.getEstado() != EstadoElevador.MANTENIMIENTO)
            .filter(Elevador::tieneCapacidad)
            .filter(e -> e.vaHacia(solicitud.getPisoOrigen()))
            .min(Comparator.comparingInt(e -> e.distanciaA(solicitud.getPisoOrigen())))
            .orElse(null);
    }

    // Llamar periodicamente para avanzar la simulacion
    public void tick() {
        // Mover todos los elevadores
        for (Elevador elevador : elevadores) {
            elevador.mover();
        }

        // Procesar solicitudes pendientes
        procesarSolicitudesPendientes();
    }

    private void procesarSolicitudesPendientes() {
        Iterator<Solicitud> it = solicitudesPendientes.iterator();
        while (it.hasNext()) {
            Solicitud solicitud = it.next();
            Elevador mejor = encontrarMejorElevador(solicitud);
            if (mejor != null) {
                mejor.agregarDestino(solicitud.getPisoOrigen());
                it.remove();
            }
        }
    }
}

class Edificio {
    private int numeroPisos;
    private ControladorElevadores controlador;

    public Edificio(int pisos, int numElevadores) {
        this.numeroPisos = pisos;

        List<Elevador> elevadores = new ArrayList<>();
        for (int i = 0; i < numElevadores; i++) {
            elevadores.add(new Elevador(i, 10)); // Capacidad 10
        }

        this.controlador = new ControladorElevadores(elevadores);
    }

    public void llamarElevador(int piso, boolean subir) {
        Direccion dir = subir ? Direccion.SUBIENDO : Direccion.BAJANDO;
        controlador.solicitarElevador(piso, dir);
    }
}
```

### Patrones Aplicados
- **State Pattern**: Estados del elevador
- **Strategy (implicit)**: Algoritmo de despacho intercambiable
- **Observer**: Podria notificar llegadas a pisos

### Algoritmo SCAN (Elevator Algorithm)
```
El elevador se mueve en una direccion atendiendo todas las
solicitudes hasta llegar al extremo, luego cambia de direccion.

Similar al algoritmo de disco duro para optimizar movimientos.
```

### Extensiones Posibles
- Elevadores express (solo ciertos pisos)
- Prioridad VIP
- Modo incendio/emergencia
- Prediccion de demanda por hora
