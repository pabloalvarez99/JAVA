// ============================================
// SOLUCION BASICO - CONCURRENCIA
// ============================================

use std::thread;


fn spawn_sum(nums: Vec<i32>) -> i32 {
    let h = thread::spawn(move || nums.iter().sum::<i32>());
    h.join().unwrap_or(0)
}

fn main() {
    let h = thread::spawn(|| {
        (1..=5).sum::<i32>()
    });

    let result = h.join().unwrap();
    println!("suma: {}", result);
}

