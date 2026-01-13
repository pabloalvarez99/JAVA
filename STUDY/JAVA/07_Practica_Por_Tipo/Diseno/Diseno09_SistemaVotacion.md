# EJERCICIO DISENO #9: Sistema de Votacion
**Dificultad: ⭐⭐⭐**

## Requerimientos

Disenar un sistema de votacion electronica:

1. **Elecciones**
   - Nombre y descripcion
   - Fecha inicio y fin
   - Estados: Programada, Activa, Cerrada, Resultados

2. **Candidatos/Opciones**
   - Nombre
   - Descripcion/propuesta
   - Asociado a una eleccion

3. **Votantes**
   - Identificacion unica
   - Solo puede votar una vez por eleccion
   - Voto es secreto (no vincular votante con opcion)

4. **Reglas**
   - Solo votar durante periodo activo
   - Resultados solo visibles cuando cierra
   - Auditoria de participacion (quien voto, NO que voto)

---

## PARTE 1: Tu Diseno

### 1.1 Secreto del Voto
```
Como registrar QUE alguien voto sin guardar POR QUIEN voto?

Opcion: _______________
```

### 1.2 Integridad
```
Como evitar:
- Votos duplicados
- Votos fuera de periodo
- Manipulacion de resultados
```

---

## PARTE 2: Solucion Propuesta (NO MIRAR ANTES)

### Codigo Esqueleto

```java
import java.time.*;
import java.util.*;

enum EstadoEleccion { PROGRAMADA, ACTIVA, CERRADA, RESULTADOS_PUBLICADOS }

class Candidato {
    private String id;
    private String nombre;
    private String descripcion;
    private String eleccionId;

    public Candidato(String nombre, String descripcion, String eleccionId) {
        this.id = UUID.randomUUID().toString();
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.eleccionId = eleccionId;
    }

    // getters...
}

class Votante {
    private String id;
    private String nombre;
    private String documentoIdentidad;

    public Votante(String nombre, String documento) {
        this.id = UUID.randomUUID().toString();
        this.nombre = nombre;
        this.documentoIdentidad = documento;
    }

    // getters...
}

// Registro de participacion (SIN el voto)
record RegistroParticipacion(
    String votanteId,
    String eleccionId,
    LocalDateTime timestamp
) {}

// Voto anonimo (SIN el votante)
record VotoAnonimo(
    String id,
    String candidatoId,
    String eleccionId,
    LocalDateTime timestamp
) {
    public VotoAnonimo {
        if (id == null) id = UUID.randomUUID().toString();
        if (timestamp == null) timestamp = LocalDateTime.now();
    }
}

class Eleccion {
    private String id;
    private String nombre;
    private String descripcion;
    private LocalDateTime fechaInicio;
    private LocalDateTime fechaFin;
    private EstadoEleccion estado;
    private List<Candidato> candidatos = new ArrayList<>();

    // Separacion clave: participacion vs votos
    private Set<String> votantesQueParticiparon = new HashSet<>();
    private List<VotoAnonimo> votos = new ArrayList<>();

    public Eleccion(String nombre, LocalDateTime inicio, LocalDateTime fin) {
        this.id = UUID.randomUUID().toString();
        this.nombre = nombre;
        this.fechaInicio = inicio;
        this.fechaFin = fin;
        this.estado = EstadoEleccion.PROGRAMADA;
    }

    public void agregarCandidato(String nombre, String descripcion) {
        if (estado != EstadoEleccion.PROGRAMADA) {
            throw new IllegalStateException("No se pueden agregar candidatos");
        }
        candidatos.add(new Candidato(nombre, descripcion, this.id));
    }

    public void activar() {
        if (LocalDateTime.now().isBefore(fechaInicio)) {
            throw new IllegalStateException("Aun no es la fecha de inicio");
        }
        estado = EstadoEleccion.ACTIVA;
    }

    public void cerrar() {
        estado = EstadoEleccion.CERRADA;
    }

    public void publicarResultados() {
        if (estado != EstadoEleccion.CERRADA) {
            throw new IllegalStateException("Eleccion debe estar cerrada");
        }
        estado = EstadoEleccion.RESULTADOS_PUBLICADOS;
    }

    public VotoAnonimo emitirVoto(String votanteId, String candidatoId) {
        // Validaciones
        if (estado != EstadoEleccion.ACTIVA) {
            throw new IllegalStateException("Eleccion no esta activa");
        }

        if (LocalDateTime.now().isAfter(fechaFin)) {
            cerrar();
            throw new IllegalStateException("Periodo de votacion terminado");
        }

        if (votantesQueParticiparon.contains(votanteId)) {
            throw new IllegalStateException("Votante ya emitio su voto");
        }

        boolean candidatoValido = candidatos.stream()
            .anyMatch(c -> c.getId().equals(candidatoId));
        if (!candidatoValido) {
            throw new IllegalArgumentException("Candidato no valido");
        }

        // Registrar participacion (sin el voto)
        votantesQueParticiparon.add(votanteId);

        // Crear voto anonimo (sin el votante)
        VotoAnonimo voto = new VotoAnonimo(null, candidatoId, this.id, null);
        votos.add(voto);

        return voto;
    }

    public Map<String, Long> getResultados() {
        if (estado != EstadoEleccion.RESULTADOS_PUBLICADOS) {
            throw new IllegalStateException("Resultados no disponibles aun");
        }

        Map<String, Long> conteo = new HashMap<>();

        // Inicializar con 0 para todos los candidatos
        for (Candidato c : candidatos) {
            conteo.put(c.getId(), 0L);
        }

        // Contar votos
        for (VotoAnonimo voto : votos) {
            conteo.merge(voto.candidatoId(), 1L, Long::sum);
        }

        return conteo;
    }

    public int getTotalVotos() {
        return votos.size();
    }

    public int getTotalParticipantes() {
        return votantesQueParticiparon.size();
    }

    public boolean yaVoto(String votanteId) {
        return votantesQueParticiparon.contains(votanteId);
    }

    // getters...
}

// Resultados formateados
class ResultadoEleccion {
    private Eleccion eleccion;
    private Map<Candidato, Long> votosPorCandidato;
    private long totalVotos;
    private Candidato ganador;

    public ResultadoEleccion(Eleccion eleccion) {
        this.eleccion = eleccion;
        calcular();
    }

    private void calcular() {
        Map<String, Long> conteo = eleccion.getResultados();
        this.votosPorCandidato = new LinkedHashMap<>();
        this.totalVotos = 0;

        long maxVotos = 0;
        for (Candidato c : eleccion.getCandidatos()) {
            long votos = conteo.get(c.getId());
            votosPorCandidato.put(c, votos);
            totalVotos += votos;

            if (votos > maxVotos) {
                maxVotos = votos;
                ganador = c;
            }
        }
    }

    public double getPorcentaje(Candidato candidato) {
        if (totalVotos == 0) return 0;
        return (votosPorCandidato.get(candidato) * 100.0) / totalVotos;
    }

    public void imprimir() {
        System.out.println("=== RESULTADOS: " + eleccion.getNombre() + " ===");
        System.out.println("Total votos: " + totalVotos);
        System.out.println("Participacion: " + eleccion.getTotalParticipantes() + " votantes");
        System.out.println();

        for (Map.Entry<Candidato, Long> entry : votosPorCandidato.entrySet()) {
            Candidato c = entry.getKey();
            long votos = entry.getValue();
            System.out.printf("%s: %d votos (%.1f%%)%n",
                c.getNombre(), votos, getPorcentaje(c));
        }

        System.out.println();
        System.out.println("GANADOR: " + ganador.getNombre());
    }
}

class SistemaVotacion {
    private Map<String, Eleccion> elecciones = new HashMap<>();
    private Map<String, Votante> votantes = new HashMap<>();
    private List<RegistroParticipacion> registrosParticipacion = new ArrayList<>();

    public Eleccion crearEleccion(String nombre, LocalDateTime inicio, LocalDateTime fin) {
        Eleccion eleccion = new Eleccion(nombre, inicio, fin);
        elecciones.put(eleccion.getId(), eleccion);
        return eleccion;
    }

    public void registrarVotante(Votante votante) {
        votantes.put(votante.getId(), votante);
    }

    public VotoAnonimo votar(String votanteId, String eleccionId, String candidatoId) {
        Votante votante = votantes.get(votanteId);
        if (votante == null) {
            throw new IllegalArgumentException("Votante no registrado");
        }

        Eleccion eleccion = elecciones.get(eleccionId);
        if (eleccion == null) {
            throw new IllegalArgumentException("Eleccion no existe");
        }

        VotoAnonimo voto = eleccion.emitirVoto(votanteId, candidatoId);

        // Registrar participacion para auditoria
        registrosParticipacion.add(new RegistroParticipacion(
            votanteId, eleccionId, LocalDateTime.now()
        ));

        return voto;
    }

    public ResultadoEleccion obtenerResultados(String eleccionId) {
        Eleccion eleccion = elecciones.get(eleccionId);
        return new ResultadoEleccion(eleccion);
    }
}
```

### Patrones Aplicados
- **Separation of Concerns**: Participacion vs Voto separados
- **Immutable Records**: VotoAnonimo y RegistroParticipacion

### Consideraciones de Seguridad
- En sistema real: encriptacion, firmas digitales
- Blockchain para inmutabilidad
- Verificacion de identidad
- Auditoria independiente
