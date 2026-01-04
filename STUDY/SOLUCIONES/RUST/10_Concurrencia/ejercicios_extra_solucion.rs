// ============================================
// SOLUCION EXTRA - CONCURRENCIA
// ============================================

use std::sync::{mpsc, Arc, Mutex};
use std::thread;

fn sum_parallel(chunks: Vec<Vec<i32>>) -> i32 {
    let mut handles = Vec::new();
    for chunk in chunks {
        let h = thread::spawn(move || chunk.iter().sum::<i32>());
        handles.push(h);
    }
    let mut total = 0;
    for h in handles {
        total += h.join().unwrap();
    }
    total
}

fn spawn_print(words: Vec<String>) {
    let mut handles = Vec::new();
    for w in words {
        let h = thread::spawn(move || {
            println!("{}", w);
        });
        handles.push(h);
    }
    for h in handles {
        let _ = h.join();
    }
}

fn channel_sum(nums: Vec<i32>) -> i32 {
    let (tx, rx) = mpsc::channel();
    let h = thread::spawn(move || {
        let total: i32 = nums.iter().sum();
        let _ = tx.send(total);
    });
    let _ = h.join();
    rx.recv().unwrap_or(0)
}


fn counter_threads(n_threads: usize, increments: i32) -> i32 {
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

fn parallel_max(chunks: Vec<Vec<i32>>) -> i32 {
    if chunks.is_empty() {
        return 0;
    }
    let mut handles = Vec::new();
    for chunk in chunks {
        let h = thread::spawn(move || chunk.into_iter().max().unwrap_or(i32::MIN));
        handles.push(h);
    }
    let mut max = i32::MIN;
    for h in handles {
        if let Ok(val) = h.join() {
            if val > max {
                max = val;
            }
        }
    }
    if max == i32::MIN { 0 } else { max }
}

fn main() {
    let total = Arc::new(Mutex::new(0));
    let mut handles = Vec::new();

    for _ in 0..3 {
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

