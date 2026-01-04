// ============================================
// SOLUCION - TRAITS Y GENERICS
// ============================================

trait Resumen {
    fn resumen(&self) -> String;
}

struct Post {
    titulo: String,
    cuerpo: String,
}

impl Resumen for Post {
    fn resumen(&self) -> String {
        format!("{}: {}", self.titulo, self.cuerpo)
    }
}

fn maximo<T: PartialOrd + Copy>(a: T, b: T) -> T {
    if a > b { a } else { b }
}

fn main() {
    let p = Post {
        titulo: String::from("Hola"),
        cuerpo: String::from("Contenido"),
    };
    println!("{}", p.resumen());
    println!("max: {}", maximo(5, 9));
}
