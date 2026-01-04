// ============================================
// SOLUCION - INTEGRACION - CONCURRENCIA
// ============================================
use std::sync::{mpsc, Arc, Mutex};
use std::thread;

fn sum_threads(nums: Vec<i32>, parts: usize) -> i32 {
    if parts == 0 || nums.is_empty() {
        return 0;
    }
    let chunk_size = (nums.len() + parts - 1) / parts;
    let mut handles = Vec::new();
    for chunk in nums.chunks(chunk_size) {
        let data = chunk.to_vec();
        let h = thread::spawn(move || data.iter().sum::<i32>());
        handles.push(h);
    }
    let mut total = 0;
    for h in handles {
        total += h.join().unwrap_or(0);
    }
    total
}

fn send_words(words: Vec<String>) -> usize {
    let (tx, rx) = mpsc::channel();
    let h = thread::spawn(move || {
        for w in words {
            let _ = tx.send(w);
        }
    });
    let _ = h.join();
    let mut count = 0;
    while rx.recv().is_ok() {
        count += 1;
    }
    count
}

fn main() {
    println!("sum: {}", sum_threads(vec![1, 2, 3, 4], 2));
    println!("count: {}", send_words(vec!["a".to_string(), "b".to_string()]));
}

