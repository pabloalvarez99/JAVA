// ============================================
// EJERCICIOS INTERMEDIO - COLECCIONES
// ============================================

use std::collections::HashMap;

fn contar(texto: &str) -> HashMap<String, usize> {
    // TODO: usa entry
    HashMap::new()
}

fn main() {
    println!("count: {:?}", contar("hola hola"));
}
