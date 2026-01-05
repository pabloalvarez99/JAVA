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


fn map_vec<T, U, F>(items: Vec<T>, f: F) -> Vec<U>
where
    F: Fn(T) -> U,
{
    // TODO: aplica f a cada item
    Vec::new()
}

fn repeat_item<T: Clone>(item: T, n: usize) -> Vec<T> {
    // TODO: repite item n veces
    Vec::new()
}

fn main() {
    let mut p = Pila::new();
    p.push(1);
    println!("pop: {:?}", p.pop());
}

