// ============================================
// EJERCICIOS INTERMEDIO - TRAITS Y GENERICS
// ============================================

struct Pila<T> {
    items: Vec<T>,
}

impl<T> Pila<T> {
    fn new() -> Self {
        Pila { items: Vec::new() }
    }

    fn push(&mut self, item: T) {
        // TODO: agrega item
    }

    fn pop(&mut self) -> Option<T> {
        // TODO: retorna item
        None
    }
}

fn main() {
    let mut p = Pila::new();
    p.push(1);
    println!("pop: {:?}", p.pop());
}
