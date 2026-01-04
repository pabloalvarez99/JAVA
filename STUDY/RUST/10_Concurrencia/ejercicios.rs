// ============================================
// EJERCICIOS - CONCURRENCIA
// ============================================

/*
OBJETIVO:
Usar threads y channels.
*/

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

    // TODO: join y imprime el resultado
    let _ = h;

    let (tx, rx) = mpsc::channel();
    thread::spawn(move || {
        // TODO: envia un mensaje
        let _ = tx;
    });

    // TODO: recibe y muestra el mensaje
    let _ = rx;

    println!("Completa los TODOs!");
}
