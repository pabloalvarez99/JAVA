// ============================================
// EJERCICIOS AVANZADO - OWNERSHIP Y BORROWING
// ============================================

fn longer<'a>(a: &'a str, b: &'a str) -> &'a str {
    // TODO: retorna el mas largo
    a
}

fn main() {
    let a = "hola";
    let b = "hola mundo";
    println!("longer: {}", longer(a, b));
}
