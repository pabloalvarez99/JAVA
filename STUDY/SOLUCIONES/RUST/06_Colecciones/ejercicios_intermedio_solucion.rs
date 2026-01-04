// ============================================
// SOLUCION INTERMEDIO - COLECCIONES
// ============================================

use std::collections::HashMap;

fn contar(texto: &str) -> HashMap<String, usize> {
    let mut map = HashMap::new();
    for palabra in texto.split_whitespace() {
        let entry = map.entry(palabra.to_string()).or_insert(0);
        *entry += 1;
    }
    map
}

fn main() {
    println!("count: {:?}", contar("hola hola"));
}
