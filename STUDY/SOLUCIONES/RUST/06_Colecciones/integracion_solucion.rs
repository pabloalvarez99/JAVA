// ============================================
// SOLUCION - INTEGRACION - COLECCIONES
// ============================================
use std::collections::{HashMap, HashSet};

fn word_count(text: &str) -> HashMap<String, usize> {
    let mut map = HashMap::new();
    for palabra in text.split_whitespace() {
        let entry = map.entry(palabra.to_string()).or_insert(0);
        *entry += 1;
    }
    map
}

fn unique(nums: &[i32]) -> Vec<i32> {
    let mut seen = HashSet::new();
    let mut out = Vec::new();
    for &n in nums {
        if seen.insert(n) {
            out.push(n);
        }
    }
    out
}

fn main() {
    println!("count: {:?}", word_count("hola hola mundo"));
    println!("unique: {:?}", unique(&[1, 2, 2, 3]));
}

