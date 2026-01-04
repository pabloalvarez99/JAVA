# 10 - Concurrencia

Definicion:
Rust permite concurrencia segura con threads, channels, mutexes y `Arc`.
El compilador ayuda a evitar data races.

Ejemplos:
```rust
use std::thread;

fn main() {
    let h = thread::spawn(|| println!("hola"));
    h.join().unwrap();
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







