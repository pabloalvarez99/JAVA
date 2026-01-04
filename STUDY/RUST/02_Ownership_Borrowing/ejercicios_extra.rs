// ============================================
// EJERCICIOS EXTRA - OWNERSHIP Y BORROWING
// ============================================

fn first_word(s: &str) -> &str {
    // TODO: retorna el primer word slice
    ""
}

fn append_in_place(s: &mut String, extra: &str) {
    // TODO: agrega extra al final
}

fn take_and_return(s: String) -> String {
    // TODO: retorna el mismo string
    s
}

fn longest(a: &str, b: &str) -> &str {
    // TODO: retorna el string mas largo
    ""
}

fn split_at_first_space(s: &str) -> (&str, &str) {
    // TODO: retorna antes y despues del primer espacio
    ("", "")
}

fn sum_slice(nums: &[i32]) -> i32 {
    // TODO: suma todos los valores
    0
}

fn push_clone(vec: &mut Vec<String>, value: &str) {
    // TODO: agrega value como String
}


fn first_char(s: &str) -> Option<char> {
    // TODO: retorna primer char si existe
    None
}

fn join_words(words: &[String]) -> String {
    // TODO: une palabras con espacios
    String::new()
}

fn main() {
    let texto = String::from("hola mundo");
    println!("first: {}", first_word(&texto));

    let mut base = String::from("rust");
    append_in_place(&mut base, " lang");
    println!("base: {}", base);

    let t = take_and_return(String::from("move"));
    println!("t: {}", t);
}

