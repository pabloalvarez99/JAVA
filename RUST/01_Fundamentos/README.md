# 01 - Fundamentos de Rust

## Objetivos de Aprendizaje
- Entender variables y mutabilidad
- Conocer los tipos de datos basicos
- Dominar el control de flujo
- Trabajar con funciones y expresiones

## Ejercicios

| # | Archivo | Tema | Dificultad |
|---|---------|------|------------|
| 01 | `ejercicio01_variables.rs` | Variables y Mutabilidad | * |
| 02 | `ejercicio02_tipos_escalares.rs` | Tipos de Datos Escalares | * |
| 03 | `ejercicio03_tipos_compuestos.rs` | Tuplas y Arrays | ** |
| 04 | `ejercicio04_funciones.rs` | Funciones y Expresiones | ** |
| 05 | `ejercicio05_control_flujo.rs` | if/else | ** |
| 06 | `ejercicio06_loops.rs` | loop, while, for | *** |
| 07 | `ejercicio07_strings.rs` | String y &str | *** |
| 08 | `ejercicio08_slices.rs` | Slices | *** |
| 09 | `ejercicio09_input.rs` | Input del Usuario | *** |
| 10 | `ejercicio10_calculadora.rs` | Mini Proyecto | **** |

## Conceptos Clave

### Variables en Rust
```rust
let x = 5;          // Inmutable por defecto
let mut y = 10;     // Mutable (puede cambiar)
const PI: f64 = 3.14159;  // Constante (siempre inmutable)
```

### Tipos Basicos
```rust
// Enteros
let a: i32 = -42;    // Con signo (i8, i16, i32, i64, i128)
let b: u32 = 42;     // Sin signo (u8, u16, u32, u64, u128)

// Flotantes
let c: f64 = 3.14;   // f32 o f64

// Booleano
let d: bool = true;

// Caracter (Unicode)
let e: char = 'A';
```

### Tuplas y Arrays
```rust
// Tupla: tipos diferentes, tamano fijo
let tupla: (i32, f64, char) = (42, 3.14, 'x');
let (x, y, z) = tupla;  // Destructuring

// Array: mismo tipo, tamano fijo
let arr: [i32; 5] = [1, 2, 3, 4, 5];
let primero = arr[0];
```

## Como ejecutar
```bash
rustc ejercicio01_variables.rs && ./ejercicio01_variables
```

## Siguiente
Una vez completes estos ejercicios, pasa a `02_Ownership_Borrowing/`
