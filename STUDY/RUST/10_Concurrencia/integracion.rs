// ============================================
// INTEGRACION - CONCURRENCIA
// ============================================
use std::sync::{mpsc, Arc, Mutex};
use std::thread;

fn sum_threads(nums: Vec<i32>, parts: usize) -> i32 {
    // TODO: suma en threads por partes
    0
}

fn send_words(words: Vec<String>) -> usize {
    // TODO: envia palabras por canal y cuenta
    0
}

fn main() {
    println!("sum: {}", sum_threads(vec![1, 2, 3, 4], 2));
    println!("count: {}", send_words(vec!["a".to_string(), "b".to_string()]));
}

