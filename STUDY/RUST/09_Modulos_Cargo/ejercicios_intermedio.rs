// ============================================
// EJERCICIOS INTERMEDIO - MODULOS Y CARGO
// ============================================
mod utils {
    pub fn triple(n: i32) -> i32 {
        // TODO: retorna triple
        0
    }
    pub fn square(n: i32) -> i32 {
        // TODO: retorna cuadrado
        0
    }
}

pub use utils::triple;

fn main() {
    println!("triple: {}", triple(3));
}
