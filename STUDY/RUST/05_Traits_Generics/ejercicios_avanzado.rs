// ============================================
// EJERCICIOS AVANZADO - TRAITS Y GENERICS
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
        // TODO: w * h
        0.0
    }
}

fn total_area(shapes: Vec<Box<dyn Shape>>) -> f64 {
    // TODO: suma areas
    0.0
}


struct Circle {
    r: f64,
}

impl Shape for Circle {
    fn area(&self) -> f64 {
        // TODO: area del circulo
        0.0
    }
}

fn largest_area(shapes: Vec<Box<dyn Shape>>) -> Option<f64> {
    // TODO: retorna la mayor area
    None
}

fn main() {
    let r = Rect { w: 2.0, h: 3.0 };
    let shapes: Vec<Box<dyn Shape>> = vec![Box::new(r)];
    println!("total: {}", total_area(shapes));
}

