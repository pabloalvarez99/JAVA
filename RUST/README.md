# Curso Practico de Rust

> De cero a sistemas seguros y concurrentes

```
    ____  __  _______ ______
   / __ \/ / / / ___/_  __/
  / /_/ / / / /\__ \ / /
 / _, _/ /_/ /___/ // /
/_/ |_|\____//____//_/
```

## Requisitos Previos

### Instalar Rust
```bash
# Windows (PowerShell)
winget install Rustlang.Rust.MSVC

# O descarga desde: https://rustup.rs
```

### Verificar instalacion
```bash
rustc --version
cargo --version
```

---

## Estructura del Curso

```
RUST/
|
+-- 01_Fundamentos/           [10 ejercicios] Variables, tipos, control de flujo
|
+-- 02_Ownership_Borrowing/   [10 ejercicios] EL CONCEPTO MAS IMPORTANTE
|
+-- 03_Structs_Enums/         [8 ejercicios]  Tipos personalizados
|
+-- 04_Pattern_Matching/      [6 ejercicios]  match, if let, destructuring
|
+-- 05_Traits_Generics/       [8 ejercicios]  Polimorfismo en Rust
|
+-- 06_Colecciones/           [8 ejercicios]  Vec, HashMap, HashSet
|
+-- 07_Manejo_Errores/        [6 ejercicios]  Result, Option, ?
|
+-- 08_Iteradores_Closures/   [8 ejercicios]  Programacion funcional
|
+-- 09_Modulos_Cargo/         [6 ejercicios]  Organizacion de proyectos
|
+-- 10_Concurrencia/          [8 ejercicios]  Threads, Mutex, Channels
|
+-- 11_Proyectos_Complejos/   [10 proyectos] Aplicaciones reales
|
+-- 12_Ejercicios_Debug/      [10 ejercicios] Encontrar y arreglar bugs
```

---

## Roadmap Visual

```
NIVEL PRINCIPIANTE                    NIVEL INTERMEDIO                      NIVEL AVANZADO
==================                    ================                      ==============

[01_Fundamentos]                      [05_Traits_Generics]                  [10_Concurrencia]
      |                                      |                                    |
      v                                      v                                    v
[02_Ownership] -----> CRITICO!        [06_Colecciones]                      [11_Proyectos]
      |                                      |                                    |
      v                                      v                                    v
[03_Structs_Enums]                    [07_Manejo_Errores]                   [12_Debug]
      |                                      |
      v                                      v
[04_Pattern_Matching]                 [08_Iteradores]
                                            |
                                            v
                                      [09_Modulos_Cargo]
```

---

## Como Ejecutar los Ejercicios

### Opcion 1: Archivo individual
```bash
# Compilar y ejecutar
rustc ejercicio01.rs -o ejercicio01
./ejercicio01

# O en un solo paso
rustc ejercicio01.rs && ./ejercicio01
```

### Opcion 2: Con Cargo (recomendado para proyectos)
```bash
cargo new mi_proyecto
cd mi_proyecto
cargo run
```

### Opcion 3: Rust Playground (online)
https://play.rust-lang.org/

---

## Progresion de Dificultad

| Carpeta | Dificultad | Tiempo Est. | Prerequisitos |
|---------|------------|-------------|---------------|
| 01_Fundamentos | * | 4-5h | Ninguno |
| 02_Ownership | *** | 6-8h | 01 |
| 03_Structs_Enums | ** | 4-5h | 01, 02 |
| 04_Pattern_Matching | *** | 3-4h | 03 |
| 05_Traits_Generics | **** | 5-6h | 01-04 |
| 06_Colecciones | *** | 4-5h | 01-03 |
| 07_Manejo_Errores | *** | 3-4h | 03-04 |
| 08_Iteradores | **** | 4-5h | 05-07 |
| 09_Modulos_Cargo | ** | 3-4h | 01-08 |
| 10_Concurrencia | ***** | 6-8h | 01-09 |
| 11_Proyectos | ***** | 15-20h | Todo |
| 12_Debug | *** | 4-5h | Transversal |

**Total estimado: 60-80 horas**

---

## Comparacion Java vs Rust

| Concepto Java | Equivalente Rust | Carpeta |
|---------------|------------------|---------|
| Garbage Collection | Ownership + Borrowing | 02 |
| `class` | `struct` + `impl` | 03 |
| `interface` | `trait` | 05 |
| `null` | `Option<T>` | 03 |
| `try/catch` | `Result<T,E>` + `?` | 07 |
| `ArrayList` | `Vec<T>` | 06 |
| `HashMap` | `HashMap<K,V>` | 06 |
| `synchronized` | `Mutex<T>` / `RwLock<T>` | 10 |
| Generics `<T>` | Generics + Trait Bounds | 05 |

---

## Tips para Aprender Rust

### 1. El compilador es tu amigo
Los errores del compilador de Rust son MUY descriptivos. Leelos con atencion.

### 2. Ownership es fundamental
No avances a la carpeta 03 hasta entender bien ownership y borrowing.

### 3. Practica con el REPL
```bash
# Instalar evcxr (REPL para Rust)
cargo install evcxr_repl
evcxr
```

### 4. Recursos adicionales
- The Rust Book: https://doc.rust-lang.org/book/
- Rust by Example: https://doc.rust-lang.org/rust-by-example/
- Rustlings: https://github.com/rust-lang/rustlings

---

## Guias Incluidas

- `02_Ownership_Borrowing/GUIA_OWNERSHIP.md` - Concepto mas importante
- `05_Traits_Generics/GUIA_TRAITS.md` - Sistema de tipos
- `07_Manejo_Errores/GUIA_ERRORES.md` - Manejo idiomatico de errores
- `10_Concurrencia/GUIA_CONCURRENCIA.md` - Fearless concurrency
- `CHEAT_SHEET_RUST.md` - Referencia rapida de sintaxis

---

## Comienza Aqui

```
cd 01_Fundamentos
rustc ejercicio01_variables.rs && ./ejercicio01_variables
```

Buena suerte!
