// ============================================
// SOLUCION INTERMEDIO - MODULOS Y CARGO
// ============================================
mod utils {
    pub fn triple(n: i32) -> i32 {
        n * 3
    }
    pub fn square(n: i32) -> i32 {
        n * n
    }
}

pub use utils::triple;

fn main() {
    println!("triple: {}", triple(3));
}
