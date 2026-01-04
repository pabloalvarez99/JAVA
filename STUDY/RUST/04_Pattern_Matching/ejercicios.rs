// ============================================
// EJERCICIOS - PATTERN MATCHING
// ============================================

/*
OBJETIVO:
Usar match para procesar enums y valores.
*/

enum Comando {
    Suma(i32, i32),
    Multiplica(i32, i32),
    Salir,
}

fn ejecutar(cmd: Comando) -> i32 {
    // TODO: implementa match para cada comando
    0
}

fn main() {
    println!("suma: {}", ejecutar(Comando::Suma(2, 3)));
    println!("mul: {}", ejecutar(Comando::Multiplica(2, 4)));
}
