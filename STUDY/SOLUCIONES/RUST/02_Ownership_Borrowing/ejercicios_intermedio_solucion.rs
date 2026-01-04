// ============================================
// SOLUCION INTERMEDIO - OWNERSHIP Y BORROWING
// ============================================

fn append_text(s: &mut String, extra: &str) {
    s.push_str(extra);
}

fn first_word(s: &str) -> &str {
    let bytes = s.as_bytes();
    for (i, &b) in bytes.iter().enumerate() {
        if b == b' ' {
            return &s[0..i];
        }
    }
    s
}

fn main() {
    let mut s = String::from("rust");
    append_text(&mut s, " lang");
    println!("s: {}", s);
    println!("first: {}", first_word("hola mundo"));
}
