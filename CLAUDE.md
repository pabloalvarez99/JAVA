# CLAUDE.md - Guía de Contexto para Claude Code

## Descripción del Proyecto

Este es un **repositorio de estudio multilenguaje** diseñado para aprender programación progresivamente. El proyecto cubre **Java, Python y Rust** con énfasis especial en:

- Preparación para exámenes universitarios de **POO (Programación Orientada a Objetos)**
- Patrones de diseño (Strategy, Visitor, Singleton, Factory, Builder, Observer)
- Algoritmos y estructuras de datos
- Ejercicios progresivos de menor a mayor dificultad

**Usuario objetivo**: Estudiante universitario preparándose para exámenes de programación.

---

## Estructura del Repositorio

```
JAVA/
├── STUDY/
│   ├── JAVA/                    # Curso completo de Java (68 ejercicios + proyectos)
│   │   ├── 01_Fundamentos/      # Variables, loops, arrays, métodos (Ej. 1-9)
│   │   ├── 02_POO_Basico/       # Clases, herencia, polimorfismo (Ej. 10-15)
│   │   ├── 03_Colecciones/      # ArrayList, HashMap, excepciones (Ej. 16-20)
│   │   ├── 04_Avanzado/         # Algoritmos, Streams, Generics (Ej. 21-36)
│   │   ├── 05_Patrones_Diseno/  # 22 ejercicios de patrones + preparación examen
│   │   ├── 06_Proyectos_Complejos/  # 10 proyectos de sistemas completos
│   │   ├── 07_Ejercicios_Debug/ # Ejercicios para encontrar bugs
│   │   ├── 09_Ejercicios_Tracing/   # Code tracing
│   │   ├── 10_Ejercicios_Diseno/    # Diseño de sistemas
│   │   ├── 11_Ejercicios_Algoritmos/ # Algoritmos puros
│   │   ├── 12_Ejercicios_Strings/   # Manipulación de strings
│   │   ├── Proyectos/           # Proyectos implementados (RentaCar, SistemaChat, SistemaMetro)
│   │   ├── Documentacion/       # Guías, PDFs de exámenes, CheatSheets
│   │   └── Utilidades/          # Scripts de ayuda
│   │
│   ├── PYTHON/                  # Curso de Python (12 módulos)
│   │   ├── 01_Entorno_Ejecucion/ a 12_Proyecto_Integrador/
│   │   └── PLAN_APRENDIZAJE_AUTONOMO.md
│   │
│   ├── RUST/                    # Curso de Rust (12 módulos)
│   │   ├── 01_Fundamentos/ a 12_Ejercicios_Debug/
│   │   └── PLAN_APRENDIZAJE_AUTONOMO.md
│   │
│   └── SOLUCIONES/              # Soluciones de Python y Rust
│       ├── PYTHON/
│       └── RUST/
│
├── bin/                         # Archivos compilados (.class)
└── 07_Ejercicios_Debug/soluciones/  # Soluciones de debug
```

---

## Archivos Clave de Referencia

| Archivo | Propósito |
|---------|-----------|
| `STUDY/JAVA/README.md` | Vista general del curso Java |
| `STUDY/JAVA/PROGRESO.md` | Tracker de ejercicios completados |
| `STUDY/JAVA/REFERENCIA_RAPIDA.md` | Sintaxis Java completa |
| `STUDY/JAVA/MAPA_APRENDIZAJE.md` | Mapa de dependencias de conceptos |
| `STUDY/JAVA/ERRORES_COMUNES.md` | Troubleshooting de errores típicos |
| `STUDY/JAVA/05_Patrones_Diseno/INICIO_AQUI.md` | Guía de preparación para examen POO |

---

## Convenciones del Proyecto

### Nomenclatura de Ejercicios
- **Java**: `EjercicioN.java` donde N es número secuencial (1-36+)
- **Python**: `ejercicios_*.py` por nivel (basico, intermedio, avanzado)
- **Rust**: `ejercicioN.rs` por módulo

### Estructura de Ejercicios Java
Cada archivo `.java` sigue este patrón:
```java
/*
 * EJERCICIO N: Título
 * DIFICULTAD: ⭐ a ⭐⭐⭐⭐⭐
 *
 * OBJETIVO: Descripción del ejercicio
 * INSTRUCCIONES: Pasos a seguir
 * SALIDA ESPERADA: Ejemplo de output
 */

public class EjercicioN {
    public static void main(String[] args) {
        // TODO: Implementar aquí
    }
}
```

### Idioma
- **Comentarios y documentación**: Español
- **Código**: Español para variables/métodos (nombres descriptivos)
- **Keywords**: Inglés (Java standard)

---

## Patrones de Diseño Cubiertos

### Patrones principales (nivel examen)
1. **Strategy**: Cambiar comportamiento en runtime (descuentos, modos de manejo)
2. **Visitor**: Operaciones sobre jerarquía sin modificar clases
3. **Singleton**: Instancia única (Sistema, Configuración)
4. **Factory**: Crear objetos sin exponer lógica

### Patrones secundarios
5. **Builder**: Construcción paso a paso de objetos complejos
6. **Observer**: Notificación de cambios a múltiples objetos

---

## Tecnologías y Requisitos

### Java
- **Versión**: JDK 17+ recomendado
- **Características usadas**: Streams, Lambdas, Optional, Switch expressions (Java 14+)
- **Sin dependencias externas** (solo Java estándar)

### Python
- **Versión**: Python 3.9+
- **Bibliotecas**: stdlib principalmente, algunas para datos/visualización

### Rust
- **Versión**: Rust 2021 edition
- **Cargo**: Para gestión de proyectos

---

## Comandos de Compilación y Ejecución

### Java
```bash
# Desde carpeta STUDY/JAVA/
# Usando scripts batch (Windows)
compilar.bat 01_Fundamentos 1    # Compila y ejecuta Ejercicio1
verificar.bat all                 # Verifica que todo compile
limpiar.bat                       # Elimina archivos .class

# Manual
cd 01_Fundamentos
javac Ejercicio1.java
java Ejercicio1
```

### Python
```bash
cd STUDY/PYTHON/01_Entorno_Ejecucion
python ejercicios.py
```

### Rust
```bash
cd STUDY/RUST/01_Fundamentos
rustc ejercicio1.rs && ./ejercicio1
# O con Cargo si hay proyecto configurado
```

---

## Guías para Asistencia

### Al ayudar con ejercicios:
1. **No dar soluciones completas directamente** - guiar con pistas progresivas
2. **Verificar prerequisitos** según `MAPA_APRENDIZAJE.md`
3. **Usar la sintaxis de `REFERENCIA_RAPIDA.md`** para consistencia
4. **Referir a `ERRORES_COMUNES.md`** para debugging

### Al explicar patrones de diseño:
1. Usar ejemplos del contexto del estudiante (tienda, vehículos, biblioteca)
2. Mostrar primero la estructura, luego la implementación
3. Relacionar con el examen de POO cuando sea relevante

### Al crear nuevos ejercicios:
1. Seguir la estructura existente con header comentado
2. Incluir OBJETIVO, INSTRUCCIONES, SALIDA ESPERADA
3. Dificultad apropiada al módulo
4. Usar `// TODO:` para marcar código a implementar

---

## Proyecto Clave: RentaCar

El proyecto `Proyectos/RentaCar/` es una **réplica del examen de POO** y demuestra:
- Herencia: `Vehiculo` (abstracta) → `Auto`, `SUV`, `Camioneta`
- Strategy: `ModoManejo` → `ModoEco`, `ModoNormal`, `ModoSport`
- Visitor: `VehicleVisitor` → `ConsumoCalculator`
- Singleton: `Sistema`

**Usar como referencia** para entender la arquitectura esperada en exámenes.

---

## Notas Importantes

1. **Las soluciones de Java NO están en SOLUCIONES/** - el estudiante debe intentar primero
2. **SOLUCIONES/PYTHON y SOLUCIONES/RUST** existen para autocorrección
3. **05_Patrones_Diseno/Ejercicio10** es réplica exacta del examen
4. **Evitar ciclos anidados** - usar métodos auxiliares (convención del curso)
5. El proyecto sigue principios **SOLID** especialmente en patrones de diseño

---

## Flujo de Trabajo Recomendado

```
1. Leer enunciado completo 2 veces
2. Planificar en papel (clases, relaciones, patrones)
3. Implementar por fases:
   a. Clases base (herencia)
   b. Patrones de diseño
   c. Lógica principal
4. Compilar frecuentemente
5. Probar con datos pequeños
6. Refactorizar código repetido
```

---

## Patrones de Código del Estudiante

### Estilo de Programación Típico

El estudiante usa estas convenciones y patrones que Claude Code debe reconocer y mantener:

### 1. Arrays con Contador Manual
En lugar de ArrayList, a veces usa arrays con contador para gestionar capacidad:

```java
public class Tienda {
    private Producto[] productos;
    private int cantidadProductos;  // Contador manual
    
    public Tienda(int capacidad) {
        this.productos = new Producto[capacidad];
        this.cantidadProductos = 0;
    }
    
    public void agregarProducto(Producto p) {
        if (cantidadProductos < productos.length) {
            productos[cantidadProductos] = p;
            cantidadProductos++;
        }
    }
}
```

### 2. Patrón de Búsqueda de Máximo/Mínimo
Iteración con variable de seguimiento:

```java
public Producto productoMasCaro() {
    double mayorPrecio = 0;
    Producto productoMasCaro = null;
    for (int i = 0; i < cantidadProductos; i++) {
        if (productos[i].getPrecio() >= mayorPrecio) {
            mayorPrecio = productos[i].getPrecio();
            productoMasCaro = productos[i];
        }
    }
    return productoMasCaro;
}
```

### 3. Patrón de Búsqueda por Criterio
```java
public Producto buscarPorNombre(String nombre) {
    for (int i = 0; i < cantidadProductos; i++) {
        if (productos[i].getNombre().equals(nombre)) {
            return productos[i];
        }
    }
    return null;
}
```

### 4. Patrón de Filtrado/Conteo
```java
public int contarProductosCaros(double umbral) {
    int contador = 0;
    for (int i = 0; i < cantidadProductos; i++) {
        if (productos[i].getPrecio() > umbral) {
            contador++;
        }
    }
    return contador;
}
```

### 5. Estructura de Clase Típica (POO)
```java
public class Producto {
    // Atributos privados (encapsulación)
    private String nombre;
    private double precio;
    private int stock;
    
    // Constructor
    public Producto(String nombre, double precio, int stock) {
        this.nombre = nombre;
        this.precio = precio;
        this.stock = stock;
    }
    
    // Getters
    public String getNombre() { return nombre; }
    public double getPrecio() { return precio; }
    public int getStock() { return stock; }
    
    // Setters con validación
    public void setPrecio(double precio) {
        if (precio >= 0) {
            this.precio = precio;
        }
    }
    
    // toString para debugging
    @Override
    public String toString() {
        return "Producto{nombre='" + nombre + "', precio=" + precio + "}";
    }
}
```

### 6. Patrón de Cálculo Agregado
```java
public double calcularTotal() {
    double total = 0;
    for (int i = 0; i < cantidadProductos; i++) {
        total += productos[i].getPrecio() * productos[i].getStock();
    }
    return total;
}
```

### 7. Jerarquía de Herencia Típica
```java
// Clase abstracta base
public abstract class Empleado {
    protected String nombre;
    protected double salarioBase;
    
    public Empleado(String nombre, double salarioBase) {
        this.nombre = nombre;
        this.salarioBase = salarioBase;
    }
    
    public abstract double calcularSueldo();
}

// Clase concreta
public class EmpleadoTiempoCompleto extends Empleado {
    private double bono;
    
    public EmpleadoTiempoCompleto(String nombre, double salarioBase, double bono) {
        super(nombre, salarioBase);
        this.bono = bono;
    }
    
    @Override
    public double calcularSueldo() {
        return salarioBase + bono;
    }
}
```

### 8. Uso de Interfaces
```java
public interface Exportable {
    String exportarCSV();
    String exportarJSON();
}

public class Producto implements Exportable {
    // ... atributos y constructor ...
    
    @Override
    public String exportarCSV() {
        return nombre + "," + precio + "," + stock;
    }
    
    @Override
    public String exportarJSON() {
        return "{\"nombre\":\"" + nombre + "\",\"precio\":" + precio + "}";
    }
}
```

---

## Preferencias de Estilo

| Aspecto | Preferencia |
|---------|-------------|
| Iteración arrays | `for (int i = 0; i < cantidad; i++)` |
| Comparación strings | `.equals()` siempre |
| Encapsulación | Atributos `private`, getters/setters |
| Validación | En setters cuando sea necesario |
| Null handling | Retornar `null` y verificar en llamador |
| Nombres | Español descriptivo (`productoMasCaro`, `calcularTotal`) |
| Bucles | Simples, evitar anidados cuando posible |

---

## Errores Comunes a Vigilar

1. **Off-by-one**: `i <= cantidadProductos` en lugar de `<`
2. **NullPointer**: No verificar si el array tiene elementos antes de buscar
3. **Comparación strings**: Usar `==` en lugar de `.equals()`
4. **División entera**: `5/2` da `2`, no `2.5`
5. **Scope de variables**: Declarar fuera del loop si se necesita después

---

## Contexto de Examen

### Estructura típica de examen POO:
1. **Problema 1**: Code tracing (seguir ejecución de código)
2. **Problema 2**: Implementar sistema completo con patrones

### Tiempo típico: 3 horas
### Patrones obligatorios: Strategy + Visitor + (Singleton o Factory)

### Arquitectura esperada:
```
Sistema (Singleton)
├── List<EntidadBase> entidades
├── cargarDesdeArchivo(String path)
├── procesarConVisitor(Visitor v)
└── main()

EntidadBase (abstract)
├── Tipo1 extends EntidadBase
├── Tipo2 extends EntidadBase
└── accept(Visitor v)

EstrategiaInterface
├── EstrategiaConcreta1
└── EstrategiaConcreta2

VisitorInterface
└── VisitorConcreto
```

---

## Contacto y Contexto

**Propósito principal**: Preparación para examen universitario de POO
**Horas estimadas**: ~80-100 horas para el curso completo de Java
**Progresión**: Semanas 1-2 Fundamentos → Semanas 3-6 POO/Colecciones → Semanas 7-10 Avanzado/Patrones

---

## Para Claude Code: Punto de Inicio

Si empiezas desde cero sin contexto previo:

1. **Lee primero**: `STUDY/JAVA/README.md` para visión general
2. **Revisa progreso**: `STUDY/JAVA/PROGRESO.md` para ver qué está completado
3. **Referencia**: `STUDY/JAVA/REFERENCIA_RAPIDA.md` para sintaxis
4. **Examen**: `STUDY/JAVA/05_Patrones_Diseno/INICIO_AQUI.md` si prepara examen
5. **Proyecto ejemplo**: `STUDY/JAVA/Proyectos/RentaCar/` como arquitectura modelo

**Nivel actual del estudiante**: Intermedio-Avanzado en Java, preparando examen POO universitario.

---

## Prioridad del Proyecto

- **Activo**: Java (examen POO próximo) → STUDY/JAVA/05_Patrones_Diseno y Proyectos/
- **Secundario**: Python, Rust (módulos progresivos)
- **Código nuevo por defecto**: STUDY/<lenguaje>/<modulo>/ siguiendo nomenclatura existente (`EjercicioN.java`, `ejercicios_*.py`, `ejercicioN.rs`)
- **Sin deps externas**: stdlib only en los 3 lenguajes

## Bitácora Obligatoria

`bitacora.md` en root = único doc durable de contexto del proyecto. Se actualiza:
- Final de sesión
- Después de completar ejercicio/proyecto significativo
- Después de cambio estructural (nuevo módulo, refactor, soluciones añadidas)

Formato: fecha, qué se hizo, qué quedó pendiente, errores notables.

## Ciclo de Cierre Obligatorio

Orden fijo, sin pedir confirmación, para features/fixes/proyectos visibles. NO aplica a WIP/lectura/debug puro:

1. Actualizar `bitacora.md`
2. Verificar: compilar Java tocado (`javac`), `python -m py_compile`, `cargo check` o `rustc` según stack tocado
3. Commit Conventional Commits (`feat:`, `fix:`, `docs:`, `refactor:`) con `Co-Authored-By: Claude`
4. Push a `origin/main`
5. Segunda pasada bitácora con SHA del commit

## Workflow

- Plan mode para tareas de 3+ pasos o diseño de sistemas
- Subagentes (Explore) para research paralelo en módulos grandes
- Verificación antes de declarar done: compilar el archivo tocado
- Fix root cause, no parches — si un ejercicio falla, entender por qué antes de cambiar

## Core Principles

- **Simplicity first**: el estudiante prefiere bucles simples sobre Streams complejos en ejercicios básicos
- **No laziness**: no dar solución completa sin pista progresiva
- **Minimal impact**: editar archivo existente sobre crear uno nuevo

## Stack Overview

| Lenguaje | Build | Test/Run | Convención |
|----------|-------|----------|------------|
| Java     | `javac EjercicioN.java` o `compilar.bat` | `java EjercicioN` | `EjercicioN.java`, español |
| Python   | n/a (interpretado) | `python ejercicios.py` | `ejercicios_<nivel>.py` |
| Rust     | `rustc ejercicioN.rs` o `cargo build` | `./ejercicioN` o `cargo run` | `ejercicioN.rs` |

Scripts útiles en `STUDY/JAVA/`: `compilar.bat`, `verificar.bat`, `limpiar.bat`.

---

## Obsidian Mind Vault (Segundo Cerebro Compartido)

**Path**: `C:\Users\Administrator\Documents\obsidian-mind\`

**Mapa**:
- `brain/Gotchas.md` — trampas y bugs frecuentes
- `brain/Patterns.md` — patrones reutilizables (>2 usos)
- `brain/Key Decisions.md` — decisiones irreversibles
- `brain/North Star.md` — objetivos de largo plazo
- `brain/Skills.md` — capacidades del usuario
- `brain/Memories.md` — contexto personal
- `reference/Grind Architecture.md` — snapshot estructural de este repo
- `work/active/` — features en curso
- `work/archive/` — features cerrados
- `work/incidents/` — incidentes/bugs resueltos

**Protocolo inicio sesión**:
1. Leer `brain/Gotchas.md` filtrando `## Grind — *`
2. Leer `brain/Key Decisions.md` si toca arquitectura/patrones
3. Leer `work/active/<feature>.md` si feature continúa

**Cierre sesión** (APPEND, no sobrescribir):
- Trampas nuevas → `brain/Gotchas.md` bajo header `## Grind — <tema>`
- Decisiones irreversibles → `brain/Key Decisions.md`
- Patrones usados >2 veces → `brain/Patterns.md`
- Features abiertos → `work/active/<feature>.md`
- Cambios estructurales → `reference/Grind Architecture.md`

**Formato caveman comprimido**: bullets/líneas, sin artículos, `X → Y` para causalidad, abreviaciones (DB/auth/cfg/fn/impl), errores exactos en backticks.

**Reglas**:
- APPEND no sobrescribir
- Header `## Grind — <tema>` separa contextos de otros proyectos
- Verificar antes de citar (vault puede estar stale)
- No duplicar con `bitacora.md` (vault = transversal, bitácora = cronológica del proyecto)
- Paths con espacios entre comillas

---

## Reglas CLI Globales

- Leer archivos antes de editar; no re-leer salvo cambio
- Skip archivos >100KB salvo necesario
- Preferir CLI directo (`gh`, `git`, `javac`, `python`, `cargo`) sobre MCP equivalents
- Errores: citar mensaje exacto, root cause, fix una vez — no retry ciego
- Output: sin saludos/recaps/sign-offs, code blocks con language tag, edits solo líneas cambiadas
- Accuracy: nunca adivinar APIs/versiones/flags/SHAs — leer código o docs primero
