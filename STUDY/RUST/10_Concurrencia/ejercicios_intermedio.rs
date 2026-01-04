// ============================================
// EJERCICIOS INTERMEDIO - CONCURRENCIA
// ============================================

use std::sync::mpsc;
use std::thread;


fn send_numbers(nums: Vec<i32>) -> i32 {
    // TODO: envia numeros por canal y suma
    0
}

fn main() {
    let (tx, rx) = mpsc::channel();

    thread::spawn(move || {
        // TODO: envia un mensaje
        let _ = tx;
    });

    // TODO: recibe y muestra
    let _ = rx;
}

