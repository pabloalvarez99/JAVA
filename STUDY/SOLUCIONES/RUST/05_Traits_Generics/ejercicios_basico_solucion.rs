// ============================================
// SOLUCION BASICO - TRAITS Y GENERICS
// ============================================

trait Describe {
    fn describe(&self) -> String {
        String::from("item")
    }
}

struct Item {
    name: String,
}

impl Describe for Item {
    fn describe(&self) -> String {
        self.name.clone()
    }
}

fn main() {
    let i = Item { name: "A".to_string() };
    println!("{}", i.describe());
}
