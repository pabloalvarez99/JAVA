// ============================================
// SOLUCION AVANZADO - DEBUG
// ============================================

fn longer<'a>(a: &'a str, b: &'a str) -> &'a str {
    if a.len() >= b.len() { a } else { b }
}


fn concat(a: &str, b: &str) -> String {
    format!("{}{}", a, b)
}

fn main() {
    let a = "hola";
    let b = "hola mundo";
    println!("longer: {}", longer(a, b));
}

