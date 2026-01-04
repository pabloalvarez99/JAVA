# 09 - Modulos y Cargo

Definicion:
Los modulos organizan el codigo. Cargo gestiona dependencias, builds y tests.

Ejemplos:
```rust
mod utils {
    pub fn suma(a: i32, b: i32) -> i32 { a + b }
}

fn main() {
    println!("{}", utils::suma(2, 3));
}
```

Archivos:
- README.md
- ejercicios.rs
- ejercicios_extra.rs
- ejercicios_basico.rs
- ejercicios_intermedio.rs
- ejercicios_avanzado.rs

Ejercicios:
- Ver `ejercicios.rs`, `ejercicios_extra.rs`, `ejercicios_basico.rs`, `ejercicios_intermedio.rs`, `ejercicios_avanzado.rs`.







