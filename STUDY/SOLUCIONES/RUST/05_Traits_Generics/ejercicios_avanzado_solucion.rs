// ============================================
// SOLUCION AVANZADO - TRAITS Y GENERICS
// ============================================

trait Shape {
    fn area(&self) -> f64;
}

struct Rect {
    w: f64,
    h: f64,
}

impl Shape for Rect {
    fn area(&self) -> f64 {
        self.w * self.h
    }
}

fn total_area(shapes: Vec<Box<dyn Shape>>) -> f64 {
    shapes.iter().map(|s| s.area()).sum()
}

fn main() {
    let r = Rect { w: 2.0, h: 3.0 };
    let shapes: Vec<Box<dyn Shape>> = vec![Box::new(r)];
    println!("total: {}", total_area(shapes));
}
