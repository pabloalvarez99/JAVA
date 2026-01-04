// ============================================
// SOLUCION BASICO - MODULOS Y CARGO
// ============================================
mod math {
    pub fn add(a: i32, b: i32) -> i32 {
        a + b
    }
    pub fn mul(a: i32, b: i32) -> i32 {
        a * b
    }
}

fn main() {
    println!("add: {}", math::add(2, 3));
}
