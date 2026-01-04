// ============================================
// INTEGRACION - FUNDAMENTOS
// ============================================
fn stats(nums: &[i32]) -> (i32, i32, f64) {
    // TODO: retorna (min, max, promedio)
    (0, 0, 0.0)
}

fn reverse_words(texto: &str) -> String {
    // TODO: invierte orden de palabras
    String::new()
}

fn main() {
    let nums = vec![1, 2, 3, 4];
    println!("stats: {:?}", stats(&nums));
    println!("reverse: {}", reverse_words("hola mundo"));
}

