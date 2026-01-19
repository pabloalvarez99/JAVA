# Ejercicio: Sistema de Personas y Roles UCN

## 🎯 RÉPLICA EXACTA DE EXAMEN - Problema 2 (60 puntos)

**Dificultad:** ⭐⭐⭐⭐⭐⭐⭐ (7/10)
**Tiempo estimado:** 2 horas
**Tipo:** Implementación completa con menú interactivo

---

## 📋 Contexto

En la UCN hay muchas personas que cumplen diferentes roles: hay personas funcionarias, hay profesores, hay estudiantes. Pero, puede suceder que una persona cumpla más de un rol en forma simultánea. Además, cuando una persona tiene un "rol", lo tiene durante una cierta cantidad de tiempo, o sea, tienen una **fecha de inicio** y una **fecha de término**. Las fechas se identifican por su año, mes y día.

Cuando las personas cumplen un "rol" en la UCN, automáticamente quedan relacionadas con una **unidad** de la UCN. Por ejemplo:
- Cuando es "estudiante", se asocian a una carrera (considere que las carreras son unidades también)
- Cuando son funcionarios a una unidad (por ejemplo, "Servicio de Obras", "Escuela de Ingeniería")
- Los profesores se asocian a una unidad también

---

## 🎯 Qué debe hacer

Construya un programa en Java que presente un **menú de opciones** que permita realizar las siguientes acciones:

### Operaciones CRUD básicas:
- **a.** Agregar una persona
- **b.** Agregar una unidad
- **c.** Asociar una persona a una unidad entre ciertas fechas

### Reportabilidad:
- **d.i.** Dada una fecha (año, mes, día), indicar el rol que está cumpliendo cada persona registrada, indicando la unidad
- **d.ii.** Dada una fecha (año, mes, día), indicar la cantidad de personas en cada unidad
- **d.iii.** Dado un RUT de una persona, indicar su "historia de roles", o sea, los roles que ha cumplido en la UCN, ordenados de menor a mayor por fecha
- **d.iv.** Dada una unidad, mostrar el "historial de roles", o sea, los diferentes roles que han trabajado en esa unidad, especificando la persona que cumplió ese rol

### Estadísticas generales:
- **d.v.1.** La persona con más antigüedad en la UCN
- **d.v.2.** La persona que ha tenido más roles

---

## 📦 Debe entregar

| Entregable | Porcentaje |
|------------|------------|
| Modelo de Dominio | 10% |
| Diagrama de Clases | 20% |
| Código Java | 70% |

---

## ⚠️ Consideraciones

- Debe usar **orientación al objeto**
- En el diagrama de clases debe especificar **TODO** (atributos, métodos, visibilidad, relaciones)
- Tanto el modelo del dominio como el diagrama de clases debe escribirlos en papel y entregarlos junto a la prueba
- El código fuente debe comprimirlo en un solo archivo .zip y subirlo a Campus Virtual
- **Hojas sin nombre no se revisarán**

---

## 🏗️ Modelo de Dominio Sugerido

```
ENTIDADES:
- Persona (RUT, nombre, fecha nacimiento)
- Unidad (código, nombre, tipo)
- Rol (tipo: ESTUDIANTE, PROFESOR, FUNCIONARIO)
- AsignacionRol (persona, unidad, rol, fechaInicio, fechaTermino)
- Fecha (año, mes, día)
- Sistema (singleton que gestiona todo)

RELACIONES:
- Persona tiene muchas AsignacionRol (1..*)
- Unidad tiene muchas AsignacionRol (1..*)
- AsignacionRol tiene una Persona, una Unidad, un Rol, dos Fechas
```

---

## 📐 Diagrama de Clases Esperado

```
┌─────────────────────┐
│      Sistema        │ <<Singleton>>
├─────────────────────┤
│ - instancia: Sistema│
│ - personas: ArrayList<Persona>
│ - unidades: ArrayList<Unidad>
│ - asignaciones: ArrayList<AsignacionRol>
├─────────────────────┤
│ + getInstance()     │
│ + agregarPersona()  │
│ + agregarUnidad()   │
│ + asociarPersonaUnidad()
│ + rolesEnFecha()    │
│ + personasPorUnidad()│
│ + historiaRoles()   │
│ + historialUnidad() │
│ + personaMasAntigua()│
│ + personaMasRoles() │
└─────────────────────┘
         │
         │ gestiona
         ▼
┌─────────────────────┐     ┌─────────────────────┐
│      Persona        │     │       Unidad        │
├─────────────────────┤     ├─────────────────────┤
│ - rut: String       │     │ - codigo: String    │
│ - nombre: String    │     │ - nombre: String    │
│ - fechaNacimiento   │     │ - tipo: TipoUnidad  │
├─────────────────────┤     ├─────────────────────┤
│ + getters/setters   │     │ + getters/setters   │
└─────────────────────┘     └─────────────────────┘
         │                           │
         │                           │
         └───────────┬───────────────┘
                     │
                     ▼
         ┌─────────────────────┐
         │   AsignacionRol     │
         ├─────────────────────┤
         │ - persona: Persona  │
         │ - unidad: Unidad    │
         │ - rol: TipoRol      │
         │ - fechaInicio: Fecha│
         │ - fechaTermino: Fecha
         ├─────────────────────┤
         │ + estaActivoEn(Fecha)│
         │ + getters/setters   │
         └─────────────────────┘

┌─────────────────────┐     ┌─────────────────────┐
│       Fecha         │     │  <<enum>> TipoRol   │
├─────────────────────┤     ├─────────────────────┤
│ - año: int          │     │ ESTUDIANTE          │
│ - mes: int          │     │ PROFESOR            │
│ - dia: int          │     │ FUNCIONARIO         │
├─────────────────────┤     └─────────────────────┘
│ + esAnteriorA(Fecha)│
│ + esPosteriorA(Fecha)│
│ + compareTo(Fecha)  │
└─────────────────────┘
```

---

## 💻 Estructura de Código Sugerida

### Clase Fecha (comparación de fechas)
```java
public class Fecha implements Comparable<Fecha> {
    private int año;
    private int mes;
    private int dia;

    public Fecha(int año, int mes, int dia) {
        this.año = año;
        this.mes = mes;
        this.dia = dia;
    }

    // Convierte a número para comparar: 20231215 vs 20240101
    public int toNumero() {
        return año * 10000 + mes * 100 + dia;
    }

    public boolean esAnteriorOIgualA(Fecha otra) {
        return this.toNumero() <= otra.toNumero();
    }

    public boolean esPosteriorOIgualA(Fecha otra) {
        return this.toNumero() >= otra.toNumero();
    }

    @Override
    public int compareTo(Fecha otra) {
        return Integer.compare(this.toNumero(), otra.toNumero());
    }

    @Override
    public String toString() {
        return dia + "/" + mes + "/" + año;
    }
}
```

### Clase AsignacionRol (verificar si está activo en fecha)
```java
public class AsignacionRol {
    private Persona persona;
    private Unidad unidad;
    private TipoRol rol;
    private Fecha fechaInicio;
    private Fecha fechaTermino;

    // Verifica si la asignación está activa en una fecha dada
    public boolean estaActivoEn(Fecha fecha) {
        return fecha.esPosteriorOIgualA(fechaInicio) &&
               fecha.esAnteriorOIgualA(fechaTermino);
    }
}
```

### Método: Roles en una fecha específica (d.i)
```java
public void mostrarRolesEnFecha(Fecha fecha) {
    System.out.println("Roles activos en " + fecha + ":");
    for (AsignacionRol asig : asignaciones) {
        if (asig.estaActivoEn(fecha)) {
            System.out.println("- " + asig.getPersona().getNombre() +
                             " es " + asig.getRol() +
                             " en " + asig.getUnidad().getNombre());
        }
    }
}
```

### Método: Persona con más antigüedad (d.v.1)
```java
public Persona personaMasAntigua() {
    Persona masAntigua = null;
    Fecha fechaMasAntigua = null;

    for (AsignacionRol asig : asignaciones) {
        if (fechaMasAntigua == null ||
            asig.getFechaInicio().esAnteriorOIgualA(fechaMasAntigua)) {
            fechaMasAntigua = asig.getFechaInicio();
            masAntigua = asig.getPersona();
        }
    }
    return masAntigua;
}
```

### Método: Persona con más roles (d.v.2)
```java
public Persona personaConMasRoles() {
    // Usar HashMap para contar roles por persona
    HashMap<String, Integer> conteoRoles = new HashMap<>();

    for (AsignacionRol asig : asignaciones) {
        String rut = asig.getPersona().getRut();
        conteoRoles.put(rut, conteoRoles.getOrDefault(rut, 0) + 1);
    }

    // Encontrar el máximo
    String rutMasRoles = null;
    int maxRoles = 0;

    for (Map.Entry<String, Integer> entry : conteoRoles.entrySet()) {
        if (entry.getValue() > maxRoles) {
            maxRoles = entry.getValue();
            rutMasRoles = entry.getKey();
        }
    }

    return buscarPersonaPorRut(rutMasRoles);
}
```

---

## 📝 Ejemplo de Ejecución

```
=== SISTEMA DE GESTIÓN UCN ===

1. Agregar persona
2. Agregar unidad
3. Asociar persona a unidad
4. Reportes
5. Salir

Seleccione opción: 1
Ingrese RUT: 12345678-9
Ingrese nombre: Juan Pérez
Persona agregada exitosamente.

Seleccione opción: 2
Ingrese código de unidad: ICI
Ingrese nombre: Ingeniería Civil Informática
Ingrese tipo (CARRERA/DEPARTAMENTO/SERVICIO): CARRERA
Unidad agregada exitosamente.

Seleccione opción: 3
Ingrese RUT de persona: 12345678-9
Ingrese código de unidad: ICI
Ingrese tipo de rol (ESTUDIANTE/PROFESOR/FUNCIONARIO): ESTUDIANTE
Fecha de inicio (año mes día): 2020 3 1
Fecha de término (año mes día): 2025 12 31
Asociación creada exitosamente.

Seleccione opción: 4
=== SUBMENÚ REPORTES ===
1. Roles en una fecha
2. Cantidad de personas por unidad
3. Historia de roles de persona
4. Historial de roles de unidad
5. Estadísticas generales
6. Volver

Seleccione: 1
Ingrese fecha (año mes día): 2023 6 15

Roles activos en 15/6/2023:
- Juan Pérez es ESTUDIANTE en Ingeniería Civil Informática
- María González es PROFESOR en Ingeniería Civil Informática
- Carlos López es FUNCIONARIO en Servicio de Obras
```

---

## ✅ Checklist de Implementación

### Clases base:
- [ ] Clase `Fecha` con comparación
- [ ] Clase `Persona` con RUT y nombre
- [ ] Clase `Unidad` con código, nombre y tipo
- [ ] Enum `TipoRol` (ESTUDIANTE, PROFESOR, FUNCIONARIO)
- [ ] Enum `TipoUnidad` (CARRERA, DEPARTAMENTO, SERVICIO)
- [ ] Clase `AsignacionRol` con método `estaActivoEn()`

### Sistema (Singleton):
- [ ] Patrón Singleton implementado
- [ ] ArrayList para personas, unidades, asignaciones
- [ ] Método `agregarPersona()`
- [ ] Método `agregarUnidad()`
- [ ] Método `asociarPersonaUnidad()`

### Reportes:
- [ ] d.i: Roles en fecha específica
- [ ] d.ii: Cantidad personas por unidad en fecha
- [ ] d.iii: Historia de roles por RUT (ordenada por fecha)
- [ ] d.iv: Historial de unidad (quién trabajó ahí)
- [ ] d.v.1: Persona más antigua
- [ ] d.v.2: Persona con más roles

### Menú:
- [ ] Menú principal con opciones
- [ ] Submenú de reportes
- [ ] Validación de entrada
- [ ] Manejo de Scanner

---

## 💡 Pistas Progresivas

<details>
<summary>Pista 1: Estructura inicial</summary>

Empieza creando las clases en este orden:
1. `Fecha` (necesaria para todo)
2. Enums `TipoRol` y `TipoUnidad`
3. `Persona` y `Unidad`
4. `AsignacionRol`
5. `Sistema` (Singleton)
6. `Main` con menú

</details>

<details>
<summary>Pista 2: Comparación de fechas</summary>

Para comparar fechas, convierte a un número entero:
```java
int numero = año * 10000 + mes * 100 + dia;
// 2023-12-15 → 20231215
// 2024-01-01 → 20240101
// Así puedes comparar con < > ==
```

</details>

<details>
<summary>Pista 3: Verificar si un rol está activo</summary>

Un rol está activo en una fecha si:
- La fecha es >= fechaInicio
- La fecha es <= fechaTermino

```java
public boolean estaActivoEn(Fecha fecha) {
    return fecha.toNumero() >= fechaInicio.toNumero() &&
           fecha.toNumero() <= fechaTermino.toNumero();
}
```

</details>

<details>
<summary>Pista 4: Ordenar por fecha</summary>

Para ordenar la historia de roles, usa `Collections.sort()`:
```java
ArrayList<AsignacionRol> historia = obtenerRolesDePersona(rut);
Collections.sort(historia, (a, b) ->
    a.getFechaInicio().compareTo(b.getFechaInicio()));
```

</details>

<details>
<summary>Pista 5: Contar roles por persona</summary>

Usa un `HashMap<String, Integer>` donde:
- Key = RUT de la persona
- Value = cantidad de roles

```java
HashMap<String, Integer> conteo = new HashMap<>();
for (AsignacionRol asig : asignaciones) {
    String rut = asig.getPersona().getRut();
    conteo.put(rut, conteo.getOrDefault(rut, 0) + 1);
}
```

</details>

---

## 🔗 Relación con el Examen

Este ejercicio evalúa:
- **Diseño OO**: Identificar entidades y relaciones
- **Singleton**: Sistema centralizado
- **Colecciones**: ArrayList y HashMap
- **Fechas**: Comparación y rangos
- **Menú interactivo**: Scanner y control de flujo
- **Estadísticas**: Búsqueda de máximo/mínimo

**Patrón típico de examen UCN**: Sistema con menú + múltiples reportes + estadísticas

---

## 📚 Ejercicios Relacionados

- `05_File_IO_Persistencia/Ej03_Lectura_MultiArchivo_Mapaches.md` - Similar estructura de menú
- `08_Estructuras_Datos/Ej05_Arbol_Promedio_SinDescendientes.md` - Estadísticas sobre estructuras
- `02_Herencia/Implementacion/Ej01_Jerarquia_Empleados.md` - Herencia con tipos
