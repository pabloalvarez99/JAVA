# 05 - Traits y Generics

Definicion:
Traits definen comportamiento. Generics permiten escribir codigo reutilizable
para distintos tipos con limites (trait bounds).

Ejemplos:
```rust
trait Resumir { fn resumen(&self) -> String; }

struct Post { titulo: String }

impl Resumir for Post {
    fn resumen(&self) -> String { self.titulo.clone() }
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







