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


fn split_at_space(s: &str) -> (&str, &str) {
    // TODO: separa en dos partes
    ("", "")
}

fn trim_len(s: &str) -> usize {
    // TODO: longitud sin espacios extremos
    0
}

fn main() {
    let mut s = String::from("rust");
    append_text(&mut s, " lang");
    println!("s: {}", s);
    println!("first: {}", first_word("hola mundo"));
}

