# Resumen: Nuevos Ejercicios Intermedios (12-17)

## Objetivo
Crear una progresión gradual entre la **encapsulación básica** (Ejercicio 11) y las **listas enlazadas** (ahora Ejercicio 18).

---

## Ejercicios Creados

### ✅ Ejercicio 12: Múltiples Objetos Interactuando
**Archivo:** `C:\Users\Pablo\Documents\Build\1\Ejercicios\Ejercicio12.java`
**Dificultad:** ⭐⭐⭐⭐ (Medio-Alto)
**Conceptos:**
- Arrays de objetos (Estudiante[])
- Clase Aula que contiene múltiples Estudiantes
- Operaciones agregadas (promedio del aula, contar aprobados)
- Gestión manual de contador de elementos

**Estructura:**
```java
class Estudiante { /* reutilizada del Ejercicio 11 */ }
class Aula {
    private Estudiante[] estudiantes; // Array de objetos
    private int cantidadEstudiantes;

    void agregarEstudiante(Estudiante est);
    void mostrarEstudiantes();
    double calcularPromedioAula();
    int contarAprobados();
}
```

---

### ✅ Ejercicio 13: Relaciones entre Objetos (Composición)
**Archivo:** `C:\Users\Pablo\Documents\Build\1\Ejercicios\Ejercicio13.java`
**Dificultad:** ⭐⭐⭐⭐ (Medio-Alto)
**Conceptos:**
- Composición: "tiene un" (has-a relationship)
- Navegación entre objetos: `libro.getAutor().getNombre()`
- Búsqueda en estructuras anidadas
- Referencias entre objetos

**Estructura:**
```java
class Autor {
    private String nombre;
    private String nacionalidad;
}

class Libro {
    private String titulo;
    private Autor autor; // ← Composición
    private int anio;
    private int paginas;
}

class Biblioteca {
    private Libro[] libros;
    void buscarPorAutor(String nombreAutor);
    Libro libroMasAntiguo();
}
```

---

### ✅ Ejercicio 14: Introducción a ArrayList
**Archivo:** `C:\Users\Pablo\Documents\Build\1\Ejercicios\Ejercicio14.java`
**Dificultad:** ⭐⭐⭐⭐⭐ (Avanzado)
**Conceptos:**
- ArrayList vs Arrays tradicionales
- Listas dinámicas (crecen automáticamente)
- Genéricos básicos: `ArrayList<Tarea>`
- Métodos: add(), get(), remove(), size()
- Eliminación segura durante iteración

**Estructura:**
```java
import java.util.ArrayList;

class Tarea {
    private String descripcion;
    private boolean completada;

    void completar();
    String toString(); // "[X] ..." o "[ ] ..."
}

class ListaTareas {
    private ArrayList<Tarea> tareas; // ← Tamaño dinámico

    void agregarTarea(String desc);
    void completarTarea(int indice);
    void eliminarTarea(int indice);
    void limpiarCompletadas();
}
```

---

### ✅ Ejercicio 15: Navegación entre Objetos (Referencias Bidireccionales)
**Archivo:** `C:\Users\Pablo\Documents\Build\1\Ejercicios\Ejercicio15.java`
**Dificultad:** ⭐⭐⭐⭐⭐ (Avanzado)
**Conceptos:**
- Referencias bidireccionales (Empleado ↔ Departamento)
- Keyword "this"
- Sincronización de relaciones
- Búsqueda en estructuras multi-nivel

**Estructura:**
```java
class Departamento {
    private String nombre;
    private ArrayList<Empleado> empleados;

    void agregarEmpleado(Empleado emp) {
        empleados.add(emp);
        emp.setDepartamento(this); // ← Bidireccional
    }
}

class Empleado {
    private String nombre;
    private double salario;
    private Departamento departamento; // ← Referencia al contenedor

    void cambiarDepartamento(Departamento nuevoDept);
}

class Empresa {
    private ArrayList<Departamento> departamentos;
    Empleado buscarEmpleado(String nombre); // Búsqueda anidada
}
```

---

### ✅ Ejercicio 16: Arrays de Objetos con Operaciones Complejas
**Archivo:** `C:\Users\Pablo\Documents\Build\1\Ejercicios\Ejercicio16.java`
**Dificultad:** ⭐⭐⭐⭐⭐ (Avanzado)
**Conceptos:**
- Búsqueda lineal en arrays de objetos
- Filtrado y creación de subarrays
- Ordenamiento (Bubble Sort)
- Operaciones agregadas: MAX, MIN, SUM
- Transformaciones sobre colecciones

**Estructura:**
```java
class Producto {
    private String nombre;
    private double precio;
    private int stock;
    private String categoria;

    void aplicarDescuento(double porcentaje);
}

class Inventario {
    private Producto[] productos;
    private int cantidadProductos;

    Producto buscarPorNombre(String nombre);
    Producto[] buscarPorCategoria(String cat); // Retorna subarray
    Producto productoMasCaro(); // MAX
    Producto productoMasBarato(); // MIN
    double calcularValorInventario(); // SUM
    void ordenarPorPrecio(); // Bubble Sort
}
```

---

### ✅ Ejercicio 17: Introducción al Concepto de Nodo
**Archivo:** `C:\Users\Pablo\Documents\Build\1\Ejercicios\Ejercicio17.java`
**Dificultad:** ⭐⭐⭐⭐⭐ (Avanzado)
**Conceptos:**
- Concepto de Nodo: dato + referencia
- Auto-referencia: `NodoSimple` contiene `NodoSimple`
- Recorrido de nodos
- Inserción al inicio O(1) vs al final O(n)
- Preparación para listas enlazadas

**Estructura:**
```java
class NodoSimple {
    private int dato;
    private NodoSimple siguiente; // ← Auto-referencia
}

class CadenaDeNodos {
    private NodoSimple primero; // Cabeza de la cadena

    void agregarAlInicio(int dato);  // O(1) - rápido
    void agregarAlFinal(int dato);   // O(n) - recorre
    void imprimir();
    int contar();
    boolean buscar(int dato);
    int obtener(int indice);
}
```

**Visualización:**
```
primero → [10|→] → [20|→] → [30|null]
```

---

## Cambios Realizados

### Archivos Creados:
```
✅ Ejercicios/Ejercicio12.java  (Múltiples Objetos)
✅ Ejercicios/Ejercicio13.java  (Composición)
✅ Ejercicios/Ejercicio14.java  (ArrayList)
✅ Ejercicios/Ejercicio15.java  (Referencias Bidireccionales)
✅ Ejercicios/Ejercicio16.java  (Operaciones Complejas)
✅ Ejercicios/Ejercicio17.java  (Concepto de Nodo)
```

### Archivos Renombrados:
```
✅ Ejercicio12.java → Ejercicio18.java (Lista Enlazada)
```

### Documentación:
```
✅ EJERCICIOS_RENUMERACION.md (Guía completa de cambios)
✅ README_SECCION_ACTUALIZADA.md (Sección actualizada para README)
✅ RESUMEN_EJERCICIOS_NUEVOS.md (Este archivo)
```

---

## Progresión de Dificultad

```
Ejercicio 11: Encapsulación ⭐⭐⭐⭐
    ↓
    ↓ (Era un salto DEMASIADO grande)
    ↓
Ejercicio 12 ANTIGUO: Lista Enlazada ⭐⭐⭐⭐⭐
```

**AHORA:**

```
Ejercicio 11: Encapsulación ⭐⭐⭐⭐
    ↓
Ejercicio 12: Arrays de Objetos ⭐⭐⭐⭐
    ↓
Ejercicio 13: Composición ⭐⭐⭐⭐
    ↓
Ejercicio 14: ArrayList ⭐⭐⭐⭐⭐
    ↓
Ejercicio 15: Referencias Bidireccionales ⭐⭐⭐⭐⭐
    ↓
Ejercicio 16: Operaciones Complejas ⭐⭐⭐⭐⭐
    ↓
Ejercicio 17: Concepto de Nodo ⭐⭐⭐⭐⭐
    ↓
Ejercicio 18: Lista Enlazada Completa ⭐⭐⭐⭐⭐
```

---

## Conceptos Introducidos Progresivamente

| Ejercicio | Concepto Clave | Preparación Para |
|-----------|----------------|------------------|
| 12 | Arrays de objetos | Manejar colecciones de objetos |
| 13 | Composición (has-a) | Relaciones entre objetos |
| 14 | ArrayList | Colecciones dinámicas de Java |
| 15 | Referencias bidireccionales | Navegación compleja |
| 16 | Búsqueda/ordenamiento | Algoritmos sobre objetos |
| 17 | Nodos y auto-referencia | Listas enlazadas |
| 18 | Lista enlazada completa | Estructuras de datos avanzadas |

---

## Tabla de Equivalencias (OLD vs NEW)

| OLD | NEW | Ejercicio |
|-----|-----|-----------|
| - | **12** | **Múltiples Objetos (NUEVO)** |
| - | **13** | **Composición (NUEVO)** |
| - | **14** | **ArrayList (NUEVO)** |
| - | **15** | **Referencias Bidireccionales (NUEVO)** |
| - | **16** | **Operaciones Complejas (NUEVO)** |
| - | **17** | **Concepto de Nodo (NUEVO)** |
| 12 | **18** | Lista Enlazada (RENOMBRADO) |
| 13 | 19* | Herencia |
| 14 | 20* | Polimorfismo |
| 15 | 21* | Interfaces |
| ... | ... | ... |

*Pendiente de renombrar (opcional)

---

## Formato de Cada Ejercicio

Todos los nuevos ejercicios siguen el mismo formato que los existentes:

```java
/*
 * ========================================
 * EJERCICIO X: Título del Ejercicio
 * DIFICULTAD: ⭐⭐⭐⭐⭐ (Nivel)
 * ========================================
 *
 * OBJETIVO:
 * [Qué aprenderás]
 *
 * CONCEPTO CLAVE:
 * [Explicación teórica]
 *
 * INSTRUCCIONES:
 * [Paso a paso]
 *
 * SALIDA ESPERADA:
 * [Ejemplo de ejecución]
 *
 * PISTAS:
 * [Ayudas para empezar]
 *
 * CONCEPTOS NUEVOS:
 * [Lista de nuevos temas]
 */

// TODO: Comentarios para el estudiante

class ClaseEjemplo {
    // TODO: Espacios para completar
}

/*
 * ========================================
 * REFLEXIÓN Y PROFUNDIZACIÓN
 * ========================================
 *
 * [Explicación detallada de conceptos]
 * [Casos de uso en el mundo real]
 * [Errores comunes]
 * [Mejores prácticas]
 */
```

---

## Características de los Ejercicios

### Todos los ejercicios incluyen:
- ✅ Comentarios en español (instrucciones)
- ✅ Código en inglés (mejores prácticas)
- ✅ Secciones TODO para el estudiante
- ✅ Salida esperada clara
- ✅ Pistas para comenzar
- ✅ Reflexión profunda al final
- ✅ Casos de uso del mundo real
- ✅ Errores comunes a evitar
- ✅ Dificultad graduada

### Progresión pedagógica:
1. **Ejercicio 12:** Primer contacto con arrays de objetos
2. **Ejercicio 13:** Añade composición y navegación
3. **Ejercicio 14:** Introduce ArrayList (más fácil que arrays)
4. **Ejercicio 15:** Complejiza con referencias bidireccionales
5. **Ejercicio 16:** Domina operaciones sobre colecciones
6. **Ejercicio 17:** Introduce el concepto crítico de Nodo
7. **Ejercicio 18:** Usa nodos para crear lista enlazada completa

---

## Tiempo Estimado de Completación

| Ejercicio | Tiempo Estimado |
|-----------|-----------------|
| 12 | 2 horas |
| 13 | 2-3 horas |
| 14 | 2-3 horas |
| 15 | 3 horas |
| 16 | 3-4 horas |
| 17 | 2-3 horas |
| **Total** | **14-18 horas** |

---

## Beneficios de Esta Restructuración

### Para Estudiantes:
✅ Progresión más suave y natural
✅ Menos frustración y abandono
✅ Mejor comprensión de conceptos
✅ Preparación sólida para temas avanzados
✅ Más práctica con objetos antes de estructuras complejas

### Para Profesores:
✅ Material más estructurado
✅ Menor tasa de abandono esperada
✅ Mejor alineación con objetivos pedagógicos
✅ Ejercicios de refuerzo disponibles
✅ Progresión documentada y justificada

---

## Próximos Pasos Sugeridos

### Inmediato:
1. ✅ Los 6 nuevos ejercicios están listos para usar
2. ✅ El Ejercicio 18 (lista enlazada) está renombrado
3. ⏳ Opcional: Renombrar ejercicios 13-36 → 19-42

### Mediano Plazo:
1. Actualizar el README.md principal con la sección de `README_SECCION_ACTUALIZADA.md`
2. Informar a los estudiantes del cambio
3. Monitorear feedback y ajustar si es necesario

### Largo Plazo:
1. Considerar crear ejercicios similares para otros "saltos" de dificultad
2. Recopilar estadísticas de completación
3. Ajustar dificultades según feedback

---

## Archivos de Referencia

- **Guía completa de cambios:** `EJERCICIOS_RENUMERACION.md`
- **Sección actualizada para README:** `README_SECCION_ACTUALIZADA.md`
- **Este resumen:** `RESUMEN_EJERCICIOS_NUEVOS.md`

---

## Contacto y Feedback

Si encuentras errores, tienes sugerencias o quieres reportar resultados, por favor documenta:
- Qué ejercicio
- Qué problema
- Qué mejora propones

---

**¡Los nuevos ejercicios están listos para usar! 🚀**

**Progresión: 11 → 12 → 13 → 14 → 15 → 16 → 17 → 18**

*"El mejor código es el que enseña mientras funciona"* ☕
