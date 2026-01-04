// ============================================
// SOLUCION INTERMEDIO - DEBUG
// ============================================


fn duplicate(texto: &str) -> String {
    texto.repeat(2)
}

fn main() {
    let s = String::from("hola");
    let t = s.clone();
    println!("{}", s);
    println!("{}", t);
}

