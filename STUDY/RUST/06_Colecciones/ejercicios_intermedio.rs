// ============================================
// EJERCICIOS INTERMEDIO - COLECCIONES
// ============================================

use std::collections::HashMap;

fn contar(texto: &str) -> HashMap<String, usize> {
    // TODO: usa entry
    HashMap::new()
}


fn group_by_len(words: Vec<String>) -> HashMap<usize, Vec<String>> {
    // TODO: agrupa por longitud
    HashMap::new()
}

fn invert_count(map: HashMap<String, usize>) -> HashMap<usize, Vec<String>> {
    // TODO: invierte conteos
    HashMap::new()
}

fn main() {
    println!("count: {:?}", contar("hola hola"));
}

