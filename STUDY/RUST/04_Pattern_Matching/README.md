# 04 - Pattern Matching

Definicion:
`match` permite evaluar patrones sobre enums, structs y valores. `if let` y
`while let` simplifican casos comunes.

Ejemplos:
```rust
fn main() {
    let n = 3;
    let texto = match n {
        1 => "uno",
        2 => "dos",
        _ => "otro",
    };
    println!("{}", texto);
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







