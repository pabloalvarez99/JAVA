// ============================================
// SOLUCION EXTRA - COLECCIONES
// ============================================

use std::collections::{HashMap, HashSet, VecDeque};

fn frecuencia(texto: &str) -> HashMap<String, usize> {
    let mut map = HashMap::new();
    for palabra in texto.split_whitespace() {
        let entry = map.entry(palabra.to_string()).or_insert(0);
        *entry += 1;
    }
    map
}

fn cola(nums: Vec<i32>) -> Vec<i32> {
    let mut q = VecDeque::from(nums);
    let mut out = Vec::new();
    while let Some(v) = q.pop_front() {
        out.push(v);
    }
    out
}

fn unique_preserve(nums: Vec<i32>) -> Vec<i32> {
    let mut seen = HashSet::new();
    let mut out = Vec::new();
    for n in nums {
        if seen.insert(n) {
            out.push(n);
        }
    }
    out
}

fn rotar(nums: Vec<i32>, k: usize) -> Vec<i32> {
    if nums.is_empty() {
        return Vec::new();
    }
    let mut q = VecDeque::from(nums);
    let pasos = k % q.len();
    for _ in 0..pasos {
        if let Some(v) = q.pop_back() {
            q.push_front(v);
        }
    }
    q.into_iter().collect()
}

fn group_by_len(words: Vec<String>) -> HashMap<usize, Vec<String>> {
    let mut map = HashMap::new();
    for w in words {
        map.entry(w.len()).or_insert_with(Vec::new).push(w);
    }
    map
}

fn merge_counts(a: HashMap<String, usize>, b: HashMap<String, usize>) -> HashMap<String, usize> {
    let mut out = a;
    for (k, v) in b {
        *out.entry(k).or_insert(0) += v;
    }
    out
}


fn interseccion(a: &[i32], b: &[i32]) -> Vec<i32> {
    let set_b: HashSet<i32> = b.iter().copied().collect();
    let mut seen = HashSet::new();
    let mut out = Vec::new();
    for &n in a {
        if set_b.contains(&n) && seen.insert(n) {
            out.push(n);
        }
    }
    out
}

fn frecuencia_chars(texto: &str) -> HashMap<char, usize> {
    let mut map = HashMap::new();
    for ch in texto.chars() {
        let entry = map.entry(ch).or_insert(0);
        *entry += 1;
    }
    map
}

fn main() {
    println!("freq: {:?}", frecuencia("hola hola mundo"));
    println!("cola: {:?}", cola(vec![1, 2, 3]));
}

