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

fn main() {
    let i = Item { name: "A".to_string() };
    println!("{}", i.describe());
}
