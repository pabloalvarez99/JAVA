// ============================================
// INTEGRACION - OWNERSHIP Y BORROWING
// ============================================
fn split_first_word(s: &str) -> (&str, &str) {
    // TODO: retorna primer palabra y resto
    ("", "")
}

fn append_suffix(s: &mut String, suf: &str) {
    // TODO: agrega suf al final
}

fn main() {
    let texto = "hola mundo";
    let (a, b) = split_first_word(texto);
    println!("a: {} b: {}", a, b);

    let mut base = String::from("rust");
    append_suffix(&mut base, " lang");
    println!("base: {}", base);
}

