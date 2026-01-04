// ============================================
// SOLUCION - INTEGRACION - TRAITS Y GENERICS
// ============================================
trait Resumen {
    fn resumen(&self) -> String;
}

struct Articulo {
    titulo: String,
}

impl Resumen for Articulo {
    fn resumen(&self) -> String {
        format!("Articulo: {}", self.titulo)
    }
}

fn imprimir_resumen<T: Resumen>(item: &T) -> String {
    item.resumen()
}

fn maximo_generico<T: Ord + Copy>(items: &[T]) -> Option<T> {
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

fn main() {
    let a = Articulo { titulo: "Rust".to_string() };
    println!("resumen: {}", imprimir_resumen(&a));
    println!("max: {:?}", maximo_generico(&[1, 3, 2]));
}

