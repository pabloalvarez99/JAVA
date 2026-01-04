// ============================================
// EJERCICIOS INTERMEDIO - OWNERSHIP Y BORROWING
// ============================================

fn append_text(s: &mut String, extra: &str) {
    // TODO: agrega extra al string
}

fn first_word(s: &str) -> &str {
    // TODO: retorna el primer word slice
    ""
}

fn main() {
    let mut s = String::from("rust");
    append_text(&mut s, " lang");
    println!("s: {}", s);
    println!("first: {}", first_word("hola mundo"));
}
