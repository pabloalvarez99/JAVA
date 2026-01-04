// ============================================
// EJERCICIOS AVANZADO - DEBUG
// ============================================

fn longer<'a>(a: &'a str, b: &'a str) -> &'a str {
    // TODO: retorna el mas largo
    a
}


fn concat(a: &str, b: &str) -> String {
    // TODO: concatena a y b
    String::new()
}

fn main() {
    let a = "hola";
    let b = "hola mundo";
    println!("longer: {}", longer(a, b));
}

