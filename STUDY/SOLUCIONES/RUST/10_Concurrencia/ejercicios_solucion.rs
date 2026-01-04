// ============================================
// SOLUCION - CONCURRENCIA
// ============================================

use std::sync::mpsc;
use std::thread;

fn main() {
    let h = thread::spawn(|| {
        let mut suma = 0;
        for n in 1..=5 {
            suma += n;
        }
        suma
    });

    let result = h.join().unwrap();
    println!("suma: {}", result);

    let (tx, rx) = mpsc::channel();
    thread::spawn(move || {
        tx.send("hola".to_string()).unwrap();
    });

    let msg = rx.recv().unwrap();
    println!("msg: {}", msg);
}
