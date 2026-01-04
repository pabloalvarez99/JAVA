// ============================================
// SOLUCION - COLECCIONES
// ============================================

use std::collections::{HashMap, HashSet};

fn suma_vec(v: &Vec<i32>) -> i32 {
    v.iter().sum()
}

fn contar_palabras(texto: &str) -> HashMap<String, usize> {
    let mut map = HashMap::new();
    for palabra in texto.split_whitespace() {
        let entry = map.entry(palabra.to_string()).or_insert(0);
        *entry += 1;
    }
    map
}

fn main() {
    let v = vec![1, 2, 3, 4];
    println!("suma: {}", suma_vec(&v));

    let conteo = contar_palabras("hola mundo hola");
    println!("conteo: {:?}", conteo);

    let mut set = HashSet::new();
    set.insert(1);
    set.insert(1);
    set.insert(2);
    println!("set: {:?}", set);
}
