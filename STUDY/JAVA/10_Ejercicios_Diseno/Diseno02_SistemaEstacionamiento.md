# EJERCICIO DISENO #2: Sistema de Estacionamiento
**Dificultad: ⭐⭐**

## Requerimientos

Disenar un sistema de estacionamiento que permita:

1. **Espacios de Estacionamiento**
   - Diferentes tamanos: Moto, Auto, Camioneta
   - Cada espacio tiene un numero unico
   - Estado: Libre u Ocupado

2. **Vehiculos**
   - Tipos: Moto, Auto, Camioneta
   - Cada vehiculo tiene placa unica
   - Un vehiculo solo puede ocupar un espacio de su tamano o mayor

3. **Tickets**
   - Se genera al entrar
   - Registra: vehiculo, espacio, hora entrada
   - Al salir: calcular monto a pagar

4. **Tarifas**
   - Moto: $5/hora
   - Auto: $10/hora
   - Camioneta: $15/hora
   - Primera hora completa, luego por fraccion de 30 min

---

## PARTE 1: Tu Diseno

### 1.1 Identifica las Clases y Enums
```
Clases:
1. _______________
2. _______________
3. _______________
4. _______________

Enums:
1. _______________
```

### 1.2 Relaciones Entre Clases
```
(Describe las relaciones)
- Estacionamiento TIENE muchos _______________
- Ticket REFERENCIA a _______________
```

### 1.3 Metodos Principales
```
Estacionamiento:
+ estacionar(vehiculo): _______________
+ salir(ticket): _______________

Ticket:
+ calcularMonto(): _______________
```

---

## PARTE 2: Preguntas de Diseno

1. **Como asignas el espacio optimo?**
   (Moto en espacio de moto, no en camioneta)

2. **Como manejas el caso de estacionamiento lleno?**

3. **Necesitas una clase Tarifa separada?**

---

## PARTE 3: Solucion Propuesta (NO MIRAR ANTES)

### Diagrama de Clases

```
+------------------+
|  TipoVehiculo    |  <<enum>>
+------------------+
| MOTO             |
| AUTO             |
| CAMIONETA        |
+------------------+

+------------------+        +------------------+
|    Vehiculo      |        |     Espacio      |
+------------------+        +------------------+
| - placa: String  |        | - numero: int    |
| - tipo: TipoVeh  |        | - tipo: TipoVeh  |
+------------------+        | - ocupado: bool  |
                            | - vehiculo: Veh  |
                            +------------------+
        |                           |
        +-------------+-------------+
                      |
              +------------------+
              |     Ticket       |
              +------------------+
              | - id: String     |
              | - vehiculo       |
              | - espacio        |
              | - horaEntrada    |
              | - horaSalida     |
              +------------------+
              | + calcularMonto()|
              +------------------+
                      |
              +------------------+
              | Estacionamiento  |
              +------------------+
              | - espacios: List |
              | - ticketsActivos |
              | - tarifas: Map   |
              +------------------+
              | + estacionar()   |
              | + salir()        |
              | + espaciosLibres |
              +------------------+
```

### Codigo Esqueleto

```java
import java.time.*;
import java.util.*;

enum TipoVehiculo {
    MOTO(1, 5.0),
    AUTO(2, 10.0),
    CAMIONETA(3, 15.0);

    private int tamano;
    private double tarifaHora;

    TipoVehiculo(int tamano, double tarifaHora) {
        this.tamano = tamano;
        this.tarifaHora = tarifaHora;
    }

    public boolean cabEn(TipoVehiculo espacio) {
        return this.tamano <= espacio.tamano;
    }

    public double getTarifaHora() { return tarifaHora; }
}

class Vehiculo {
    private String placa;
    private TipoVehiculo tipo;

    public Vehiculo(String placa, TipoVehiculo tipo) {
        this.placa = placa;
        this.tipo = tipo;
    }

    // getters...
}

class Espacio {
    private int numero;
    private TipoVehiculo tipo;
    private Vehiculo vehiculo;

    public boolean estaLibre() { return vehiculo == null; }

    public boolean puedeAceptar(Vehiculo v) {
        return estaLibre() && v.getTipo().cabEn(this.tipo);
    }

    public void ocupar(Vehiculo v) {
        if (!puedeAceptar(v)) throw new IllegalStateException();
        this.vehiculo = v;
    }

    public void liberar() {
        this.vehiculo = null;
    }
}

class Ticket {
    private String id;
    private Vehiculo vehiculo;
    private Espacio espacio;
    private LocalDateTime horaEntrada;
    private LocalDateTime horaSalida;

    public Ticket(Vehiculo vehiculo, Espacio espacio) {
        this.id = UUID.randomUUID().toString().substring(0, 8);
        this.vehiculo = vehiculo;
        this.espacio = espacio;
        this.horaEntrada = LocalDateTime.now();
    }

    public double calcularMonto() {
        if (horaSalida == null) {
            horaSalida = LocalDateTime.now();
        }

        long minutos = Duration.between(horaEntrada, horaSalida).toMinutes();

        // Primera hora completa
        if (minutos <= 60) {
            return vehiculo.getTipo().getTarifaHora();
        }

        // Horas adicionales por fraccion de 30 min
        double monto = vehiculo.getTipo().getTarifaHora();
        minutos -= 60;

        int fraccionesDe30 = (int) Math.ceil(minutos / 30.0);
        monto += fraccionesDe30 * (vehiculo.getTipo().getTarifaHora() / 2);

        return monto;
    }
}

class Estacionamiento {
    private List<Espacio> espacios;
    private Map<String, Ticket> ticketsActivos = new HashMap<>();

    public Estacionamiento(int motos, int autos, int camionetas) {
        espacios = new ArrayList<>();
        int numero = 1;

        for (int i = 0; i < motos; i++)
            espacios.add(new Espacio(numero++, TipoVehiculo.MOTO));
        for (int i = 0; i < autos; i++)
            espacios.add(new Espacio(numero++, TipoVehiculo.AUTO));
        for (int i = 0; i < camionetas; i++)
            espacios.add(new Espacio(numero++, TipoVehiculo.CAMIONETA));
    }

    public Ticket estacionar(Vehiculo vehiculo) {
        // Buscar espacio optimo (del tamano exacto primero)
        Espacio espacio = espacios.stream()
            .filter(e -> e.puedeAceptar(vehiculo))
            .min(Comparator.comparing(e -> e.getTipo().ordinal()))
            .orElseThrow(() -> new IllegalStateException("No hay espacio"));

        espacio.ocupar(vehiculo);
        Ticket ticket = new Ticket(vehiculo, espacio);
        ticketsActivos.put(ticket.getId(), ticket);

        return ticket;
    }

    public double salir(String ticketId) {
        Ticket ticket = ticketsActivos.remove(ticketId);
        if (ticket == null) throw new IllegalArgumentException("Ticket no valido");

        double monto = ticket.calcularMonto();
        ticket.getEspacio().liberar();

        return monto;
    }
}
```

### Patrones Aplicados
- **Strategy (implicit)**: TipoVehiculo encapsula tarifa
- **Factory method**: Estacionamiento crea espacios

### Extensiones Posibles
- Suscripciones mensuales
- Diferentes tarifas por hora del dia
- Reservas anticipadas
- Multiples pisos/zonas
