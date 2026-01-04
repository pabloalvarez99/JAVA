// ============================================
// INTEGRACION - COLECCIONES
// ============================================
use std::collections::{HashMap, HashSet};

fn word_count(text: &str) -> HashMap<String, usize> {
    // TODO: cuenta palabras
    HashMap::new()
}

fn unique(nums: &[i32]) -> Vec<i32> {
    // TODO: elimina duplicados preservando orden
    Vec::new()
}

fn main() {
    println!("count: {:?}", word_count("hola hola mundo"));
    println!("unique: {:?}", unique(&[1, 2, 2, 3]));
}

