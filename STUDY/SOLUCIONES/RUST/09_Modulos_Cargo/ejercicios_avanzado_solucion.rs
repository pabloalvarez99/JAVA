// ============================================
// SOLUCION AVANZADO - MODULOS Y CARGO
// ============================================

fn normalize(texto: &str) -> String {
    texto.trim().to_lowercase()
}


fn is_palindrome(texto: &str) -> bool {
    let chars: Vec<char> = texto.chars().collect();
    chars.iter().eq(chars.iter().rev())
}

fn main() {
    println!("norm: {}", normalize(" Hola "));
}

