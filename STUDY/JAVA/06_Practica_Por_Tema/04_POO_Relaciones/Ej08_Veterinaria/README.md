# Ejercicio 20: Sistema de Clínica Veterinaria

## Clases a crear:

1. **Fecha.java** - Manejo de fechas
2. **Dueno.java** - RUT, nombre, teléfono
3. **Mascota.java** - código, nombre, especie, raza, fechaNacimiento, dueño
4. **Veterinario.java** - RUT, nombre, especialidad
5. **Consulta.java** - ASOCIACIÓN (mascota, veterinario, fecha, motivo, diagnóstico, tratamiento, costo)
6. **Vacuna.java** - ASOCIACIÓN (mascota, nombre, fecha, próximaDosis)
7. **Clinica.java** - Clase gestora
8. **Main.java** - Menú

## Diagrama de clases:

```
┌─────────────────┐        ┌─────────────────┐
│     Dueno       │───────>│    Mascota      │
├─────────────────┤    1:* ├─────────────────┤
│ - rut           │        │ - codigo        │
│ - nombre        │        │ - nombre        │
│ - telefono      │        │ - especie       │
│ - mascotas      │        │ - raza          │
└─────────────────┘        │ - fechaNac      │
                           │ - dueno         │
                           │ - consultas     │
                           │ - vacunas       │
                           └───────┬─────────┘
                                   │
                    ┌──────────────┼──────────────┐
                    │              │              │
                    ▼              ▼              ▼
           ┌────────────┐  ┌────────────┐  ┌─────────────────┐
           │  Consulta  │  │   Vacuna   │  │  Veterinario    │
           ├────────────┤  ├────────────┤  ├─────────────────┤
           │ - mascota  │  │ - mascota  │  │ - rut           │
           │ - veterin. │  │ - nombre   │  │ - nombre        │
           │ - fecha    │  │ - fecha    │  │ - especialidad  │
           │ - motivo   │  │ - proxDosis│  │ - consultas     │
           │ - diagnos. │  └────────────┘  └─────────────────┘
           │ - tratam.  │
           │ - costo    │
           └────────────┘
```

## Relación Dueño-Mascota:
Un dueño tiene muchas mascotas (1 a *). Cada mascota tiene exactamente un dueño.

```java
public class Dueno {
    private ArrayList<Mascota> mascotas;
    
    public void agregarMascota(Mascota m) {
        mascotas.add(m);
        m.setDueno(this);  // Establecer relación bidireccional
    }
}
```

## Especies comunes:
- Perro
- Gato
- Conejo
- Hámster
- Ave
- Tortuga

## Especialidades veterinarias:
- General
- Cirugía
- Dermatología
- Cardiología
- Odontología
- Oftalmología

## Vacunas comunes:
- Antirrábica (anual)
- Parvovirus (anual)
- Moquillo (anual)
- Triple felina (anual)
- Leucemia felina (anual)

## Verificar vacunas pendientes:
```java
public ArrayList<Vacuna> getVacunasPendientes(Fecha fechaActual) {
    ArrayList<Vacuna> pendientes = new ArrayList<>();
    for (Vacuna v : vacunas) {
        if (v.getProximaDosis() != null && 
            v.getProximaDosis().esAnterior(fechaActual)) {
            pendientes.add(v);
        }
    }
    return pendientes;
}
```

## Historial médico de mascota:
```java
public void mostrarHistorialMedico(String codigoMascota) {
    Mascota m = buscarMascota(codigoMascota);
    
    System.out.println("=== HISTORIAL DE " + m.getNombre() + " ===");
    System.out.println("Especie: " + m.getEspecie());
    System.out.println("Raza: " + m.getRaza());
    System.out.println("Dueño: " + m.getDueno().getNombre());
    
    System.out.println("\n--- CONSULTAS ---");
    for (Consulta c : m.getConsultas()) {
        System.out.println(c.getFecha() + " - " + c.getMotivo());
        System.out.println("  Diagnóstico: " + c.getDiagnostico());
        System.out.println("  Tratamiento: " + c.getTratamiento());
    }
    
    System.out.println("\n--- VACUNAS ---");
    for (Vacuna v : m.getVacunas()) {
        System.out.println(v.getNombre() + " - " + v.getFecha());
        if (v.getProximaDosis() != null) {
            System.out.println("  Próxima: " + v.getProximaDosis());
        }
    }
}
```

## Calcular edad de mascota:
```java
public int getEdadEnAnios(Fecha fechaActual) {
    return fechaActual.getAnio() - fechaNacimiento.getAnio();
}
```
