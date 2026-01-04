// ============================================
// EJERCICIOS - TRAITS Y GENERICS
// ============================================

/*
OBJETIVO:
Definir traits e implementar generics.
*/

trait Resumen {
    fn resumen(&self) -> String;
}

struct Post {
    titulo: String,
    cuerpo: String,
}

impl Resumen for Post {
    fn resumen(&self) -> String {
        // TODO: retorna un resumen del post
        String::new()
    }
}

fn maximo<T: PartialOrd + Copy>(a: T, b: T) -> T {
    // TODO: retorna el mayor
    a
}

fn main() {
    let p = Post {
        titulo: String::from("Hola"),
        cuerpo: String::from("Contenido"),
    };
    println!("{}", p.resumen());
    println!("max: {}", maximo(5, 9));
}
