# Tabla Resumen: Ejercicios 10-21

## Comparación ANTES vs DESPUÉS

### ANTES (Progresión con salto grande)
```
Ejercicio 10: Clases y Objetos ⭐⭐⭐⭐
Ejercicio 11: Encapsulación ⭐⭐⭐⭐
    ↓
    ↓ ⚠️ SALTO DEMASIADO GRANDE
    ↓
Ejercicio 12: Lista Enlazada ⭐⭐⭐⭐⭐ ← Estudiantes se frustraban aquí
Ejercicio 13: Herencia ⭐⭐⭐⭐⭐⭐
Ejercicio 14: Polimorfismo ⭐⭐⭐⭐⭐⭐
Ejercicio 15: Interfaces ⭐⭐⭐⭐⭐⭐
```

### DESPUÉS (Progresión suave con 6 nuevos ejercicios)
```
Ejercicio 10: Clases y Objetos ⭐⭐⭐⭐
Ejercicio 11: Encapsulación ⭐⭐⭐⭐
    ↓
    ↓ ✅ PROGRESIÓN GRADUAL (6 nuevos ejercicios)
    ↓
Ejercicio 12: Arrays de Objetos ⭐⭐⭐⭐ ← NUEVO
Ejercicio 13: Composición ⭐⭐⭐⭐ ← NUEVO
Ejercicio 14: ArrayList ⭐⭐⭐⭐⭐ ← NUEVO
Ejercicio 15: Referencias Bidireccionales ⭐⭐⭐⭐⭐ ← NUEVO
Ejercicio 16: Operaciones Complejas ⭐⭐⭐⭐⭐ ← NUEVO
Ejercicio 17: Concepto de Nodo ⭐⭐⭐⭐⭐ ← NUEVO
    ↓
Ejercicio 18: Lista Enlazada ⭐⭐⭐⭐⭐ ← Ahora más fácil de entender
Ejercicio 19: Herencia ⭐⭐⭐⭐⭐⭐
Ejercicio 20: Polimorfismo ⭐⭐⭐⭐⭐⭐
Ejercicio 21: Interfaces ⭐⭐⭐⭐⭐⭐
```

---

## Tabla Detallada de Ejercicios 10-21

| # | Ejercicio | Dificultad | Conceptos Clave | Estado |
|---|-----------|------------|-----------------|--------|
| **10** | Clases y Objetos | ⭐⭐⭐⭐ | Definición de clases, atributos, métodos, objetos | Existente |
| **11** | Encapsulación (Getters/Setters) | ⭐⭐⭐⭐ | Atributos privados, getters/setters, validación | Existente |
| **12** | Múltiples Objetos Interactuando | ⭐⭐⭐⭐ | Arrays de objetos, Aula con Estudiantes, operaciones agregadas | **NUEVO** ✨ |
| **13** | Relaciones entre Objetos | ⭐⭐⭐⭐ | Composición (has-a), navegación entre objetos, Biblioteca | **NUEVO** ✨ |
| **14** | Introducción a ArrayList | ⭐⭐⭐⭐⭐ | ArrayList, listas dinámicas, add/get/remove, genéricos | **NUEVO** ✨ |
| **15** | Navegación entre Objetos | ⭐⭐⭐⭐⭐ | Referencias bidireccionales, this, Empresa/Empleados | **NUEVO** ✨ |
| **16** | Arrays de Objetos - Operaciones Complejas | ⭐⭐⭐⭐⭐ | Búsqueda, filtrado, Bubble Sort, operaciones agregadas | **NUEVO** ✨ |
| **17** | Introducción al Concepto de Nodo | ⭐⭐⭐⭐⭐ | Nodo, auto-referencia, recorrido, preparación listas | **NUEVO** ✨ |
| **18** | Lista Enlazada Simple | ⭐⭐⭐⭐⭐ | Nodos conectados, estructura de datos, complejidad O(n) | Renombrado (era 12) |
| **19** | Herencia | ⭐⭐⭐⭐⭐⭐ | extends, super, IS-A relationship, jerarquías | Pendiente renombrar (era 13) |
| **20** | Polimorfismo y Clases Abstractas | ⭐⭐⭐⭐⭐⭐ | abstract, override, polimorfismo | Pendiente renombrar (era 14) |
| **21** | Interfaces | ⭐⭐⭐⭐⭐⭐ | interface, implements, contratos de comportamiento | Pendiente renombrar (era 15) |

---

## Mapa de Conceptos

### Ejercicio 12: Múltiples Objetos Interactuando
```java
class Estudiante {
    private String nombre;
    private double nota1, nota2, nota3;
}

class Aula {
    private Estudiante[] estudiantes; // ← Primera vez con array de objetos
    private int cantidadEstudiantes;

    void agregarEstudiante(Estudiante est);
    double calcularPromedioAula(); // ← Operación agregada
}
```
**Aprende:** Arrays de objetos, gestión manual de contador

---

### Ejercicio 13: Relaciones entre Objetos (Composición)
```java
class Autor {
    String nombre, nacionalidad;
}

class Libro {
    String titulo;
    Autor autor; // ← Composición: Libro TIENE UN Autor
}

class Biblioteca {
    Libro[] libros;
    void buscarPorAutor(String autor); // ← Navegación anidada
}
```
**Aprende:** Has-a relationship, navegación entre objetos

---

### Ejercicio 14: Introducción a ArrayList
```java
import java.util.ArrayList;

class Tarea {
    private String descripcion;
    private boolean completada;
}

class ListaTareas {
    private ArrayList<Tarea> tareas; // ← Tamaño dinámico!

    void agregarTarea(String desc);
    void eliminarTarea(int indice);
    void limpiarCompletadas(); // ← Eliminación durante iteración
}
```
**Aprende:** Listas dinámicas, ArrayList<T>, add/get/remove/size

---

### Ejercicio 15: Navegación entre Objetos (Bidireccional)
```java
class Departamento {
    ArrayList<Empleado> empleados;

    void agregarEmpleado(Empleado emp) {
        empleados.add(emp);
        emp.setDepartamento(this); // ← Bidireccional!
    }
}

class Empleado {
    private Departamento departamento; // ← Conoce su contenedor
}

class Empresa {
    ArrayList<Departamento> departamentos;
    Empleado buscarEmpleado(String nombre); // ← Búsqueda multi-nivel
}
```
**Aprende:** Referencias bidireccionales, keyword "this", sincronización

---

### Ejercicio 16: Arrays de Objetos - Operaciones Complejas
```java
class Producto {
    String nombre;
    double precio;
    int stock;
    String categoria;
}

class Inventario {
    Producto[] productos;

    Producto buscarPorNombre(String nombre);
    Producto[] buscarPorCategoria(String cat); // ← Retorna subarray
    Producto productoMasCaro(); // ← Operación MAX
    void ordenarPorPrecio(); // ← Bubble Sort
}
```
**Aprende:** Búsqueda, filtrado, ordenamiento, operaciones agregadas

---

### Ejercicio 17: Introducción al Concepto de Nodo
```java
class NodoSimple {
    private int dato;
    private NodoSimple siguiente; // ← Auto-referencia!
}

class CadenaDeNodos {
    private NodoSimple primero; // Cabeza

    void agregarAlInicio(int dato); // ← O(1) muy rápido
    void agregarAlFinal(int dato);  // ← O(n) debe recorrer
}
```
**Aprende:** Nodo (dato + referencia), recorrido, preparación para listas

**Visualización:**
```
primero → [10|→] → [20|→] → [30|null]
```

---

### Ejercicio 18: Lista Enlazada Simple (Ahora más fácil!)
```java
class Nodo {
    int valor;
    Nodo siguiente;
}

class ListaEnlazada {
    private Nodo cabeza;

    void agregar(int valor);
    void imprimir();
    int contar();
}
```
**Aprende:** Lista enlazada completa, estructura de datos

**Ventaja:** Después de hacer los ejercicios 12-17, este ejercicio es mucho más comprensible.

---

## Progresión Pedagógica (Lo que el estudiante aprende paso a paso)

| Paso | Ejercicio | Concepto Principal | Prepara para |
|------|-----------|-------------------|--------------|
| 1 | 10 | Clases básicas | Trabajar con objetos |
| 2 | 11 | Encapsulación | Diseño robusto |
| 3 | **12** | **Arrays de objetos** | **Colecciones de objetos** |
| 4 | **13** | **Composición** | **Relaciones entre clases** |
| 5 | **14** | **ArrayList** | **Colecciones dinámicas** |
| 6 | **15** | **Referencias bidireccionales** | **Navegación compleja** |
| 7 | **16** | **Operaciones sobre colecciones** | **Algoritmos básicos** |
| 8 | **17** | **Concepto de Nodo** | **Listas enlazadas** |
| 9 | 18 | Lista enlazada completa | Estructuras de datos avanzadas |
| 10 | 19 | Herencia | Jerarquías de clases |

---

## Tiempo Estimado de Completación

| Rango | Ejercicios | Tiempo Estimado |
|-------|------------|-----------------|
| 10-11 | POO Básico | 6-8 horas |
| **12-17** | **POO Intermedio (NUEVOS)** | **14-18 horas** |
| 18-21 | POO Avanzado | 10-12 horas |
| **TOTAL** | **10-21** | **30-38 horas** |

---

## Beneficios de la Nueva Progresión

### Antes (con el salto grande):
- ❌ Estudiantes se frustraban en el Ejercicio 12
- ❌ Alta tasa de abandono
- ❌ Muchos no entendían nodos/referencias
- ❌ Falta de práctica con objetos complejos

### Después (con los 6 nuevos ejercicios):
- ✅ Progresión natural y gradual
- ✅ Cada ejercicio construye sobre el anterior
- ✅ Más práctica con diferentes tipos de relaciones
- ✅ Preparación sólida para listas enlazadas
- ✅ Mejor comprensión de estructuras de datos

---

## Archivos Creados

### Nuevos Ejercicios (Listos para usar):
```
✅ C:\Users\Pablo\Documents\Build\1\Ejercicios\Ejercicio12.java
✅ C:\Users\Pablo\Documents\Build\1\Ejercicios\Ejercicio13.java
✅ C:\Users\Pablo\Documents\Build\1\Ejercicios\Ejercicio14.java
✅ C:\Users\Pablo\Documents\Build\1\Ejercicios\Ejercicio15.java
✅ C:\Users\Pablo\Documents\Build\1\Ejercicios\Ejercicio16.java
✅ C:\Users\Pablo\Documents\Build\1\Ejercicios\Ejercicio17.java
```

### Renombrados:
```
✅ C:\Users\Pablo\Documents\Build\1\Ejercicios\Ejercicio18.java (antes era Ejercicio12.java)
```

### Documentación:
```
✅ C:\Users\Pablo\Documents\Build\1\EJERCICIOS_RENUMERACION.md
✅ C:\Users\Pablo\Documents\Build\1\README_SECCION_ACTUALIZADA.md
✅ C:\Users\Pablo\Documents\Build\1\RESUMEN_EJERCICIOS_NUEVOS.md
✅ C:\Users\Pablo\Documents\Build\1\TABLA_RESUMEN.md (este archivo)
```

---

## Estado de Compilación

```bash
# Verificado - Todos los ejercicios compilan correctamente
javac Ejercicio12.java ✅
javac Ejercicio13.java ✅
javac Ejercicio14.java ✅
javac Ejercicio15.java ✅
javac Ejercicio16.java ✅
javac Ejercicio17.java ✅
```

---

## Instrucciones para el Estudiante

### Si estás en Ejercicio 11 o antes:
👉 Continúa normalmente. Cuando llegues al 12, tendrás una mejor experiencia.

### Si estabas trabado en el antiguo Ejercicio 12:
👉 ¡Buenas noticias! Ahora ese ejercicio es el 18.
👉 Empieza con el NUEVO Ejercicio 12 y avanza gradualmente.
👉 Verás que el 18 (lista enlazada) será mucho más fácil después de los 12-17.

### Si ya completaste el antiguo Ejercicio 12:
👉 Tu trabajo ahora está en Ejercicio18.java
👉 Puedes hacer los ejercicios 12-17 como refuerzo y práctica adicional.

---

## Próximos Pasos

1. ✅ Los 6 nuevos ejercicios están creados y compilando
2. ✅ Ejercicio 12 renombrado a Ejercicio 18
3. ⏳ Opcional: Actualizar README.md con la sección de README_SECCION_ACTUALIZADA.md
4. ⏳ Opcional: Renombrar ejercicios 13-36 a 19-42 (cuando sea conveniente)

---

## Resumen Visual de la Progresión

```
📘 Básico (1-3): Variables, condicionales
    ↓
📗 Intermedio (4-6): Loops, switch
    ↓
📙 Avanzado (7-9): Arrays, métodos, matrices
    ↓
📕 POO Básico (10-11): Clases, objetos, encapsulación
    ↓
🎯 POO Intermedio (12-17): ← NUEVOS EJERCICIOS
    ├─ 12: Arrays de objetos
    ├─ 13: Composición
    ├─ 14: ArrayList
    ├─ 15: Referencias bidireccionales
    ├─ 16: Operaciones complejas
    └─ 17: Concepto de Nodo
    ↓
📔 POO Avanzado (18-21): Lista enlazada, herencia, polimorfismo, interfaces
    ↓
📓 Profesional (22+): Collections, algoritmos, recursividad...
```

---

**¡Los ejercicios están listos! 🚀☕**

**Ruta recomendada: 10 → 11 → 12 → 13 → 14 → 15 → 16 → 17 → 18**

*"La práctica progresiva lleva a la maestría"*
