// ============================================
// EJERCICIOS AVANZADO - CONCURRENCIA
// ============================================

use std::sync::{Arc, Mutex};
use std::thread;


fn counter(n_threads: usize, increments: i32) -> i32 {
    // TODO: contador con threads
    0
}

fn main() {
    let total = Arc::new(Mutex::new(0));
    let mut handles = Vec::new();

    for _ in 0..2 {
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

