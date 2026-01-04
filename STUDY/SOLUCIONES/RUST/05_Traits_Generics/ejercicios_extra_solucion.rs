// ============================================
// SOLUCION EXTRA - TRAITS Y GENERICS
// ============================================

use std::fmt::Debug;

trait Area {
    fn area(&self) -> f64;
}

struct Rect { w: f64, h: f64 }

impl Area for Rect {
    fn area(&self) -> f64 {
        self.w * self.h
    }
}

fn imprimir<T: Debug>(valor: T) {
    println!("{:?}", valor);
}

fn maximo<T: Ord + Copy>(items: &[T]) -> Option<T> {
    if items.is_empty() {
        return None;
    }
    let mut max = items[0];
    for &item in items.iter().skip(1) {
        if item > max {
            max = item;
        }
    }
    Some(max)
}

fn duplicar<T: Clone>(x: T) -> (T, T) {
    (x.clone(), x)
}

trait Resumen {
    fn resumen(&self) -> String;
}

struct Nota {
    titulo: String,
}

impl Resumen for Nota {
    fn resumen(&self) -> String {
        format!("Nota: {}", self.titulo)
    }
}

struct Caja<T> {
    valor: T,
}

impl<T> Caja<T> {
    fn map<U, F: FnOnce(T) -> U>(self, f: F) -> Caja<U> {
        Caja { valor: f(self.valor) }
    }
}


fn imprimir_ref<T: Debug>(valor: &T) {
    println!("{:?}", valor);
}

trait Identificable {
    fn id(&self) -> u32;
}

fn buscar_por_id<T: Identificable>(items: &[T], id: u32) -> Option<&T> {
    items.iter().find(|item| item.id() == id)
}

fn main() {
    let r = Rect { w: 2.0, h: 3.0 };
    println!("area: {}", r.area());
    imprimir(r.w);
}

