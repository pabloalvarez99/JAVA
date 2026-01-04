# 07 - Manejo de errores

Definicion:
Rust usa `Result<T, E>` para errores recuperables y `panic!` para fallos no
recuperables. El operador `?` propaga errores.

Ejemplos:
```rust
use std::fs::File;

fn abrir() -> Result<File, std::io::Error> {
    let f = File::open("datos.txt")?;
    Ok(f)
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







