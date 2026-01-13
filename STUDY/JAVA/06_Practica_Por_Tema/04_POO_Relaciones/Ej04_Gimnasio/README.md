# Ejercicio 4: Sistema de Gimnasio

## Clases a crear:

1. **Fecha.java** - Copiar del ejercicio anterior
2. **Entrenador.java** - RUT, nombre, especialidad, lista de sesiones
3. **Cliente.java** - RUT, nombre, fechaInscripcion, lista de sesiones
4. **Sesion.java** - CLASE DE ASOCIACIÓN (entrenador, cliente, fecha, horaInicio, duracionMinutos)
5. **Gimnasio.java** - Clase gestora
6. **Main.java** - Menú

## Diagrama de clases:

```
┌─────────────┐        ┌─────────────────┐        ┌─────────────┐
│ Entrenador  │───────<│     Sesion      │>───────│  Cliente    │
├─────────────┤    *   ├─────────────────┤    *   ├─────────────┤
│ - rut       │        │ - entrenador    │        │ - rut       │
│ - nombre    │        │ - cliente       │        │ - nombre    │
│ - especial. │        │ - fecha         │        │ - fechaInsc │
│ - sesiones  │        │ - horaInicio    │        │ - sesiones  │
└─────────────┘        │ - duracion      │        └─────────────┘
                       └─────────────────┘
```

## Clase Hora sugerida:
```java
public class Hora {
    private int hora;    // 0-23
    private int minuto;  // 0-59
    
    public boolean seSolapaCon(Hora otra, int duracionMinutos) {
        int inicioThis = this.hora * 60 + this.minuto;
        int finThis = inicioThis + duracionMinutos;
        int inicioOtra = otra.hora * 60 + otra.minuto;
        // Verificar solapamiento
        return inicioThis < (inicioOtra + duracionMinutos) && inicioOtra < finThis;
    }
}
```

## Especialidades típicas:
- Musculación
- Cardio
- Yoga
- Pilates
- CrossFit
- Funcional

## Validación importante:
Un entrenador no puede tener dos sesiones que se solapen en horario el mismo día.
