// ============================================
// SOLUCION - INTEGRACION - OWNERSHIP Y BORROWING
// ============================================
fn split_first_word(s: &str) -> (&str, &str) {
    match s.find(' ') {
        Some(idx) => (&s[..idx], &s[idx + 1..]),
        None => (s, ""),
    }
}

fn append_suffix(s: &mut String, suf: &str) {
    s.push_str(suf);
}

fn main() {
    let texto = "hola mundo";
    let (a, b) = split_first_word(texto);
    println!("a: {} b: {}", a, b);

    let mut base = String::from("rust");
    append_suffix(&mut base, " lang");
    println!("base: {}", base);
}

