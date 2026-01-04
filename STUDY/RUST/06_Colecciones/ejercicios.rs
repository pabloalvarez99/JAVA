// ============================================
// EJERCICIOS - COLECCIONES
// ============================================

/*
OBJETIVO:
Usar Vec, HashMap y HashSet.
*/

use std::collections::{HashMap, HashSet};

fn suma_vec(v: &Vec<i32>) -> i32 {
    // TODO: suma elementos
    0
}

fn contar_palabras(texto: &str) -> HashMap<String, usize> {
    // TODO: cuenta palabras
    HashMap::new()
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
