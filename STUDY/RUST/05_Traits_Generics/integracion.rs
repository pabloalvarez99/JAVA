// ============================================
// INTEGRACION - TRAITS Y GENERICS
// ============================================
trait Resumen {
    fn resumen(&self) -> String;
}

struct Articulo {
    titulo: String,
}

impl Resumen for Articulo {
    fn resumen(&self) -> String {
        // TODO: retorna resumen
        String::new()
    }
}

fn imprimir_resumen<T: Resumen>(item: &T) -> String {
    // TODO: retorna resumen
    String::new()
}

fn maximo_generico<T: Ord + Copy>(items: &[T]) -> Option<T> {
    // TODO: retorna maximo
    None
}

fn main() {
    let a = Articulo { titulo: "Rust".to_string() };
    println!("resumen: {}", imprimir_resumen(&a));
    println!("max: {:?}", maximo_generico(&[1, 3, 2]));
}

