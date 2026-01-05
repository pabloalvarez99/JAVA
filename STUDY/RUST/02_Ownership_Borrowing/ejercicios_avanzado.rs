// ============================================
// EJERCICIOS AVANZADO - OWNERSHIP Y BORROWING
// ============================================

fn longer<'a>(a: &'a str, b: &'a str) -> &'a str {
    // TODO: retorna el mas largo
    a
}


fn longest_in_list<'a>(items: &'a [&'a str]) -> &'a str {
    // TODO: retorna el mas largo o ""
    ""
}

fn first_non_empty<'a>(items: &'a [&'a str]) -> &'a str {
    // TODO: retorna el primero no vacio o ""
    ""
}

fn main() {
    let a = "hola";
    let b = "hola mundo";
    println!("longer: {}", longer(a, b));
}

