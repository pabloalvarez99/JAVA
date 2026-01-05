// ============================================
// EJERCICIOS BASICO - STRUCTS Y ENUMS
// ============================================

struct Punto {
    x: i32,
    y: i32,
}

impl Punto {
    fn norma(&self) -> i32 {
        // TODO: retorna x + y
        0
    }
}


struct Rect {
    w: i32,
    h: i32,
}

impl Rect {
    fn area(&self) -> i32 {
        // TODO: retorna area
        0
    }
}

fn main() {
    let p = Punto { x: 2, y: 3 };
    println!("norma: {}", p.norma());
}

