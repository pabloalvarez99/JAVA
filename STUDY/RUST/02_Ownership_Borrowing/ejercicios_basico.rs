// ============================================
// EJERCICIOS BASICO - OWNERSHIP Y BORROWING
// ============================================

fn len_str(s: &str) -> usize {
    // TODO: retorna longitud
    0
}


fn first_char(s: &str) -> Option<char> {
    // TODO: retorna primer char si existe
    None
}

fn make_owned(s: &str) -> String {
    // TODO: retorna String
    String::new()
}

fn main() {
    let s = String::from("hola");
    println!("len: {}", len_str(&s));

    // TODO: muestra move y usa clone para evitarlo
}

