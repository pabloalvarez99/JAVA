# 08 - Iteradores y Closures

Definicion:
Los iteradores permiten procesar colecciones de forma lazily. Closures capturan
variables del entorno y pueden ser Fn/FnMut/FnOnce.

Ejemplos:
```rust
fn main() {
    let v = vec![1, 2, 3];
    let suma: i32 = v.iter().map(|x| x * 2).sum();
    println!("{}", suma);
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







