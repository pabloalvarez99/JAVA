// ============================================
// SOLUCION INTERMEDIO - CONCURRENCIA
// ============================================

use std::sync::mpsc;
use std::thread;


fn send_numbers(nums: Vec<i32>) -> i32 {
    let (tx, rx) = mpsc::channel();
    let h = thread::spawn(move || {
        for n in nums {
            let _ = tx.send(n);
        }
    });
    let _ = h.join();
    let mut total = 0;
    while let Ok(n) = rx.recv() {
        total += n;
    }
    total
}

fn main() {
    let (tx, rx) = mpsc::channel();

    thread::spawn(move || {
        tx.send("ping".to_string()).unwrap();
    });

    let msg = rx.recv().unwrap();
    println!("msg: {}", msg);
}

