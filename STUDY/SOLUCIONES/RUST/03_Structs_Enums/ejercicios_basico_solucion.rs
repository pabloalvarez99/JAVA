// ============================================
// SOLUCION BASICO - STRUCTS Y ENUMS
// ============================================

struct Punto {
    x: i32,
    y: i32,
}

impl Punto {
    fn norma(&self) -> i32 {
        self.x + self.y
    }
}

fn main() {
    let p = Punto { x: 2, y: 3 };
    println!("norma: {}", p.norma());
}
