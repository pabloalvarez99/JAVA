// ============================================
// SOLUCION AVANZADO - CONCURRENCIA
// ============================================

use std::sync::{Arc, Mutex};
use std::thread;


fn counter(n_threads: usize, increments: i32) -> i32 {
    let total = Arc::new(Mutex::new(0));
    let mut handles = Vec::new();
    for _ in 0..n_threads {
        let t = Arc::clone(&total);
        let h = thread::spawn(move || {
            let mut guard = t.lock().unwrap();
            *guard += increments;
        });
        handles.push(h);
    }
    for h in handles {
        let _ = h.join();
    }
    *total.lock().unwrap()
}

fn main() {
    let total = Arc::new(Mutex::new(0));
    let mut handles = Vec::new();

    for _ in 0..2 {
        let t = Arc::clone(&total);
        let h = thread::spawn(move || {
            let mut guard = t.lock().unwrap();
            *guard += 1;
        });
        handles.push(h);
    }

    for h in handles {
        let _ = h.join();
    }

    println!("total: {}", *total.lock().unwrap());
}

