// ============================================
// SOLUCION BASICO - OWNERSHIP Y BORROWING
// ============================================

fn len_str(s: &str) -> usize {
    s.len()
}

fn main() {
    let s = String::from("hola");
    println!("len: {}", len_str(&s));

    let a = String::from("move");
    let b = a.clone();
    println!("a: {}", a);
    println!("b: {}", b);
}
