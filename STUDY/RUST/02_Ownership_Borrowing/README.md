# 02 - Ownership y Borrowing

Definicion:
Ownership define quien posee la memoria. Borrowing permite referencias
inmutables o mutables con reglas claras para evitar errores.

Ejemplos:
```rust
fn main() {
    let s = String::from("hola");
    let r = &s;
    println!("{}", r);
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







