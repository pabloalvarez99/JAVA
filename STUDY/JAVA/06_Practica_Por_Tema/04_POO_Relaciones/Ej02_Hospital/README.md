# Ejercicio 2: Sistema de Hospital

## Clases a crear:

1. **Fecha.java** - Copiar del ejercicio anterior
2. **Medico.java** - RUT, nombre, especialidad, lista de atenciones
3. **Paciente.java** - RUT, nombre, fechaNacimiento, lista de atenciones
4. **Atencion.java** - CLASE DE ASOCIACIÓN (medico, paciente, fecha, diagnostico, tratamiento)
5. **Hospital.java** - Clase gestora
6. **Main.java** - Menú

## Diagrama de clases:

```
┌─────────────┐        ┌─────────────────┐        ┌─────────────┐
│   Medico    │───────<│    Atencion     │>───────│  Paciente   │
├─────────────┤    *   ├─────────────────┤    *   ├─────────────┤
│ - rut       │        │ - medico        │        │ - rut       │
│ - nombre    │        │ - paciente      │        │ - nombre    │
│ - especial. │        │ - fecha         │        │ - fechaNac  │
│ - atenciones│        │ - diagnostico   │        │ - atenciones│
└─────────────┘        │ - tratamiento   │        └─────────────┘
                       └─────────────────┘
```

## Tips:
- La especialidad del médico puede ser: "Cardiología", "Pediatría", "Traumatología", etc.
- El diagnóstico es un String descriptivo
- El tratamiento indica qué debe hacer el paciente

## Comienza creando las clases en este orden:
1. Fecha (ya la tienes)
2. Medico (sin la lista de atenciones primero)
3. Paciente (sin la lista de atenciones primero)
4. Atencion (con referencias a Medico y Paciente)
5. Agrega ArrayList<Atencion> a Medico y Paciente
6. Hospital
7. Main
