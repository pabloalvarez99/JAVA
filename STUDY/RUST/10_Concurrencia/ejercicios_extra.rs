// ============================================
// EJERCICIOS EXTRA - CONCURRENCIA
// ============================================

use std::sync::{mpsc, Arc, Mutex};
use std::thread;

fn sum_parallel(chunks: Vec<Vec<i32>>) -> i32 {
    // TODO: suma cada chunk en un thread y acumula resultados
    0
}

fn spawn_print(words: Vec<String>) {
    // TODO: imprime cada palabra en threads y espera join
}

fn channel_sum(nums: Vec<i32>) -> i32 {
    // TODO: usa mpsc para sumar en otro thread
    0
}


fn counter_threads(n_threads: usize, increments: i32) -> i32 {
    // TODO: incrementa contador en varios threads
    0
}

fn parallel_max(chunks: Vec<Vec<i32>>) -> i32 {
    // TODO: calcula maximo por chunk en threads
    0
}

fn main() {
    let total = Arc::new(Mutex::new(0));
    let mut handles = Vec::new();

    for _ in 0..3 {
        let t = Arc::clone(&total);
        let h = thread::spawn(move || {
            // TODO: incrementa el contador
            let _ = t;
        });
        handles.push(h);
    }

    for h in handles {
        let _ = h.join();
    }

    println!("total: {}", *total.lock().unwrap());
}

