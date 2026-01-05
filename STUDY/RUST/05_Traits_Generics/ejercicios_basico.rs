// ============================================
// EJERCICIOS BASICO - TRAITS Y GENERICS
// ============================================

trait Describe {
    fn describe(&self) -> String {
        // TODO: implementa por defecto
        String::new()
    }
}

struct Item {
    name: String,
}

impl Describe for Item {}


fn identity<T>(x: T) -> T {
    // TODO: retorna x
    x
}

fn swap<T>(a: T, b: T) -> (T, T) {
    // TODO: retorna (b, a)
    (a, b)
}

fn main() {
    let i = Item { name: "A".to_string() };
    println!("{}", i.describe());
}

