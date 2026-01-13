# EJERCICIO DISENO #6: Sistema de Reservas
**Dificultad: ⭐⭐⭐**

## Requerimientos

Disenar un sistema generico de reservas (aplicable a: salas de reunion, canchas deportivas, citas medicas):

1. **Recursos**
   - Identificador unico
   - Nombre y descripcion
   - Horario de disponibilidad
   - Tiempo minimo/maximo de reserva

2. **Franjas Horarias (TimeSlots)**
   - Fecha y hora inicio
   - Duracion
   - Estado: Disponible, Reservado, Bloqueado

3. **Reservas**
   - Usuario que reserva
   - Recurso reservado
   - Franja horaria
   - Estados: Pendiente, Confirmada, Cancelada, Completada

4. **Reglas**
   - No solapar reservas
   - Reserva con minimo 24h anticipacion
   - Cancelacion hasta 2h antes
   - Limite de reservas activas por usuario

---

## PARTE 1: Tu Diseno

### 1.1 Como evitar solapamientos?
```
Si recurso X tiene reserva de 10:00-11:00,
como rechazas reserva de 10:30-11:30?

Opcion A: _______________
Opcion B: _______________
```

### 1.2 Flexibilidad del Sistema
```
Como harias el sistema generico para diferentes
tipos de recursos (salas, canchas, doctores)?
```

---

## PARTE 2: Solucion Propuesta (NO MIRAR ANTES)

### Codigo Esqueleto

```java
import java.time.*;
import java.util.*;

enum EstadoReserva { PENDIENTE, CONFIRMADA, CANCELADA, COMPLETADA }

class Recurso {
    private String id;
    private String nombre;
    private String descripcion;
    private LocalTime horaApertura;
    private LocalTime horaCierre;
    private Duration duracionMinima;
    private Duration duracionMaxima;

    public Recurso(String id, String nombre) {
        this.id = id;
        this.nombre = nombre;
        this.horaApertura = LocalTime.of(8, 0);
        this.horaCierre = LocalTime.of(20, 0);
        this.duracionMinima = Duration.ofMinutes(30);
        this.duracionMaxima = Duration.ofHours(4);
    }

    public boolean estaEnHorario(LocalTime inicio, LocalTime fin) {
        return !inicio.isBefore(horaApertura) && !fin.isAfter(horaCierre);
    }

    public boolean duracionValida(Duration duracion) {
        return duracion.compareTo(duracionMinima) >= 0 &&
               duracion.compareTo(duracionMaxima) <= 0;
    }
}

class FranjaHoraria {
    private LocalDateTime inicio;
    private LocalDateTime fin;

    public FranjaHoraria(LocalDateTime inicio, LocalDateTime fin) {
        if (fin.isBefore(inicio)) {
            throw new IllegalArgumentException("Fin debe ser despues de inicio");
        }
        this.inicio = inicio;
        this.fin = fin;
    }

    public Duration getDuracion() {
        return Duration.between(inicio, fin);
    }

    public boolean seSolapaCon(FranjaHoraria otra) {
        // Dos franjas se solapan si una empieza antes de que termine la otra
        return inicio.isBefore(otra.fin) && fin.isAfter(otra.inicio);
    }

    // getters...
}

class Reserva {
    private String id;
    private String usuarioId;
    private Recurso recurso;
    private FranjaHoraria franja;
    private EstadoReserva estado;
    private LocalDateTime fechaCreacion;

    public Reserva(String usuarioId, Recurso recurso, FranjaHoraria franja) {
        this.id = "RES-" + System.currentTimeMillis();
        this.usuarioId = usuarioId;
        this.recurso = recurso;
        this.franja = franja;
        this.estado = EstadoReserva.PENDIENTE;
        this.fechaCreacion = LocalDateTime.now();
    }

    public void confirmar() {
        if (estado != EstadoReserva.PENDIENTE) {
            throw new IllegalStateException("Solo se puede confirmar reserva pendiente");
        }
        estado = EstadoReserva.CONFIRMADA;
    }

    public void cancelar() {
        if (estado == EstadoReserva.COMPLETADA || estado == EstadoReserva.CANCELADA) {
            throw new IllegalStateException("No se puede cancelar");
        }

        // Validar tiempo minimo para cancelar (2 horas antes)
        LocalDateTime limiteCancel = franja.getInicio().minusHours(2);
        if (LocalDateTime.now().isAfter(limiteCancel)) {
            throw new IllegalStateException("Muy tarde para cancelar (limite: 2h antes)");
        }

        estado = EstadoReserva.CANCELADA;
    }

    public boolean estaActiva() {
        return estado == EstadoReserva.PENDIENTE || estado == EstadoReserva.CONFIRMADA;
    }

    // getters...
}

class SistemaReservas {
    private Map<String, Recurso> recursos = new HashMap<>();
    private List<Reserva> reservas = new ArrayList<>();
    private Map<String, List<Reserva>> reservasPorUsuario = new HashMap<>();
    private static final int MAX_RESERVAS_POR_USUARIO = 3;
    private static final Duration ANTICIPACION_MINIMA = Duration.ofHours(24);

    public void agregarRecurso(Recurso recurso) {
        recursos.put(recurso.getId(), recurso);
    }

    public Reserva crearReserva(String usuarioId, String recursoId,
                                LocalDateTime inicio, LocalDateTime fin) {

        Recurso recurso = recursos.get(recursoId);
        if (recurso == null) {
            throw new IllegalArgumentException("Recurso no encontrado");
        }

        FranjaHoraria franja = new FranjaHoraria(inicio, fin);

        // Validaciones
        validarAnticipacion(inicio);
        validarHorario(recurso, franja);
        validarDuracion(recurso, franja.getDuracion());
        validarDisponibilidad(recursoId, franja);
        validarLimiteUsuario(usuarioId);

        // Crear reserva
        Reserva reserva = new Reserva(usuarioId, recurso, franja);
        reservas.add(reserva);
        reservasPorUsuario
            .computeIfAbsent(usuarioId, k -> new ArrayList<>())
            .add(reserva);

        return reserva;
    }

    private void validarAnticipacion(LocalDateTime inicio) {
        LocalDateTime minimo = LocalDateTime.now().plus(ANTICIPACION_MINIMA);
        if (inicio.isBefore(minimo)) {
            throw new IllegalStateException(
                "Reserva debe hacerse con al menos 24h de anticipacion"
            );
        }
    }

    private void validarHorario(Recurso recurso, FranjaHoraria franja) {
        LocalTime horaInicio = franja.getInicio().toLocalTime();
        LocalTime horaFin = franja.getFin().toLocalTime();

        if (!recurso.estaEnHorario(horaInicio, horaFin)) {
            throw new IllegalStateException("Fuera del horario del recurso");
        }
    }

    private void validarDuracion(Recurso recurso, Duration duracion) {
        if (!recurso.duracionValida(duracion)) {
            throw new IllegalStateException("Duracion fuera de rango permitido");
        }
    }

    private void validarDisponibilidad(String recursoId, FranjaHoraria franja) {
        boolean hayConflicto = reservas.stream()
            .filter(r -> r.getRecurso().getId().equals(recursoId))
            .filter(Reserva::estaActiva)
            .anyMatch(r -> r.getFranja().seSolapaCon(franja));

        if (hayConflicto) {
            throw new IllegalStateException("Ya existe una reserva en ese horario");
        }
    }

    private void validarLimiteUsuario(String usuarioId) {
        long activas = reservasPorUsuario
            .getOrDefault(usuarioId, Collections.emptyList())
            .stream()
            .filter(Reserva::estaActiva)
            .count();

        if (activas >= MAX_RESERVAS_POR_USUARIO) {
            throw new IllegalStateException(
                "Limite de reservas activas alcanzado (" + MAX_RESERVAS_POR_USUARIO + ")"
            );
        }
    }

    public List<FranjaHoraria> obtenerDisponibilidad(String recursoId, LocalDate fecha) {
        List<FranjaHoraria> disponibles = new ArrayList<>();
        Recurso recurso = recursos.get(recursoId);

        // Obtener reservas del dia
        List<FranjaHoraria> ocupados = reservas.stream()
            .filter(r -> r.getRecurso().getId().equals(recursoId))
            .filter(Reserva::estaActiva)
            .filter(r -> r.getFranja().getInicio().toLocalDate().equals(fecha))
            .map(Reserva::getFranja)
            .sorted(Comparator.comparing(FranjaHoraria::getInicio))
            .toList();

        // Calcular huecos disponibles (simplificado)
        LocalDateTime actual = fecha.atTime(recurso.getHoraApertura());
        LocalDateTime cierre = fecha.atTime(recurso.getHoraCierre());

        for (FranjaHoraria ocupado : ocupados) {
            if (actual.isBefore(ocupado.getInicio())) {
                disponibles.add(new FranjaHoraria(actual, ocupado.getInicio()));
            }
            actual = ocupado.getFin();
        }

        if (actual.isBefore(cierre)) {
            disponibles.add(new FranjaHoraria(actual, cierre));
        }

        return disponibles;
    }
}
```

### Patrones Aplicados
- **Value Object**: FranjaHoraria inmutable
- **Repository Pattern**: Gestion centralizada de reservas
- **Specification (implicit)**: Validaciones encapsuladas

### Extensiones
- Reservas recurrentes (todos los lunes)
- Lista de espera
- Notificaciones
- Precios por franja horaria
