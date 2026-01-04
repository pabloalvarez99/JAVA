// ============================================
// SOLUCION - PATTERN MATCHING
// ============================================

enum Comando {
    Suma(i32, i32),
    Multiplica(i32, i32),
    Salir,
}

fn ejecutar(cmd: Comando) -> i32 {
    match cmd {
        Comando::Suma(a, b) => a + b,
        Comando::Multiplica(a, b) => a * b,
        Comando::Salir => 0,
    }
}

fn main() {
    println!("suma: {}", ejecutar(Comando::Suma(2, 3)));
    println!("mul: {}", ejecutar(Comando::Multiplica(2, 4)));
}
