// ============================================
// EJERCICIOS EXTRA - COLECCIONES
// ============================================

use std::collections::{HashMap, HashSet, VecDeque};

fn frecuencia(texto: &str) -> HashMap<String, usize> {
    // TODO: usa entry
    HashMap::new()
}

fn cola(nums: Vec<i32>) -> Vec<i32> {
    // TODO: usa VecDeque
    Vec::new()
}

fn unique_preserve(nums: Vec<i32>) -> Vec<i32> {
    // TODO: elimina repetidos preservando orden
    Vec::new()
}

fn rotar(nums: Vec<i32>, k: usize) -> Vec<i32> {
    // TODO: rota a la derecha k posiciones con VecDeque
    Vec::new()
}

fn group_by_len(words: Vec<String>) -> HashMap<usize, Vec<String>> {
    // TODO: agrupa por longitud
    HashMap::new()
}

fn merge_counts(a: HashMap<String, usize>, b: HashMap<String, usize>) -> HashMap<String, usize> {
    // TODO: suma valores de claves repetidas
    HashMap::new()
}


fn interseccion(a: &[i32], b: &[i32]) -> Vec<i32> {
    // TODO: retorna interseccion sin duplicados
    Vec::new()
}

fn frecuencia_chars(texto: &str) -> HashMap<char, usize> {
    // TODO: cuenta caracteres
    HashMap::new()
}

fn main() {
    println!("freq: {:?}", frecuencia("hola hola mundo"));
    println!("cola: {:?}", cola(vec![1, 2, 3]));
}

