// ============================================
// SOLUCION - OWNERSHIP Y BORROWING
// ============================================

fn longitud(s: &String) -> usize {
    s.len()
}

fn agregar_texto(s: &mut String) {
    s.push_str(" mundo");
}

fn main() {
    let s = String::from("hola");
    let len = longitud(&s);
    println!("len: {}", len);

    let mut t = String::from("rust");
    agregar_texto(&mut t);
    println!("t: {}", t);

    let a = String::from("move");
    let b = a.clone();
    println!("a: {}", a);
    println!("b: {}", b);
}
