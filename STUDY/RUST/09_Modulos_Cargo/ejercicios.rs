// ============================================
// EJERCICIOS - MODULOS Y CARGO
// ============================================

/*
OBJETIVO:
Organizar codigo con modulos.
*/

mod utils {
    pub fn suma(a: i32, b: i32) -> i32 {
        a + b
    }

    pub fn es_par(n: i32) -> bool {
        // TODO: implementa la logica
        false
    }
}

fn main() {
    println!("suma: {}", utils::suma(2, 3));
    println!("par: {}", utils::es_par(4));
}
