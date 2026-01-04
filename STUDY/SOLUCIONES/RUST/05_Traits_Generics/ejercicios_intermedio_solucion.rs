// ============================================
// SOLUCION INTERMEDIO - TRAITS Y GENERICS
// ============================================

struct Pila<T> {
    items: Vec<T>,
}

impl<T> Pila<T> {
    fn new() -> Self {
        Pila { items: Vec::new() }
    }

    fn push(&mut self, item: T) {
        self.items.push(item);
    }

    fn pop(&mut self) -> Option<T> {
        self.items.pop()
    }
}

fn main() {
    let mut p = Pila::new();
    p.push(1);
    println!("pop: {:?}", p.pop());
}
