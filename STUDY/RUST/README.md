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
STUDY/RUST/
|
+-- 01_Fundamentos/           Fundamentos y control de flujo
+-- 02_Ownership_Borrowing/   Ownership y borrowing
+-- 03_Structs_Enums/         Tipos personalizados
+-- 04_Pattern_Matching/      match, if let, destructuring
+-- 05_Traits_Generics/       Polimorfismo en Rust
+-- 06_Colecciones/           Vec, HashMap, HashSet
+-- 07_Manejo_Errores/        Result, Option, ?
+-- 08_Iteradores_Closures/   Programacion funcional
+-- 09_Modulos_Cargo/         Organizacion de proyectos
+-- 10_Concurrencia/          Threads, Mutex, Channels
+-- 11_Proyectos_Complejos/   Aplicaciones reales
+-- 12_Ejercicios_Debug/      Encontrar y arreglar bugs
```

Cada carpeta incluye README.md con definicion y ejemplo.
Ejercicios en archivos .rs dentro de cada carpeta.
Soluciones en `STUDY/SOLUCIONES/RUST`.

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
cd STUDY/RUST/01_Fundamentos
rustc ejercicio01_variables.rs && ./ejercicio01_variables
```

Buena suerte!
