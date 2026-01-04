// ============================================
// EJERCICIOS EXTRA - TRAITS Y GENERICS
// ============================================

use std::fmt::Debug;

trait Area {
    fn area(&self) -> f64;
}

struct Rect { w: f64, h: f64 }

impl Area for Rect {
    fn area(&self) -> f64 {
        // TODO: w * h
        0.0
    }
}

fn imprimir<T: Debug>(valor: T) {
    // TODO: imprime con debug
}

fn maximo<T: Ord + Copy>(items: &[T]) -> Option<T> {
    // TODO: retorna el mayor o None
    None
}

fn duplicar<T: Clone>(x: T) -> (T, T) {
    // TODO: retorna dos copias
    unimplemented!()
}

trait Resumen {
    fn resumen(&self) -> String;
}

struct Nota {
    titulo: String,
}

impl Resumen for Nota {
    fn resumen(&self) -> String {
        // TODO: retorna string con titulo
        String::new()
    }
}

struct Caja<T> {
    valor: T,
}

impl<T> Caja<T> {
    fn map<U, F: FnOnce(T) -> U>(self, f: F) -> Caja<U> {
        // TODO: aplica f y retorna Caja<U>
        unimplemented!()
    }
}


fn imprimir_ref<T: Debug>(valor: &T) {
    // TODO: imprime con debug
}

trait Identificable {
    fn id(&self) -> u32;
}

fn buscar_por_id<T: Identificable>(items: &[T], id: u32) -> Option<&T> {
    // TODO: retorna referencia por id
    None
}

fn main() {
    let r = Rect { w: 2.0, h: 3.0 };
    println!("area: {}", r.area());
    imprimir(r.w);
}

