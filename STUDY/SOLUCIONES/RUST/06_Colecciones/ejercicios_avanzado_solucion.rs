// ============================================
// SOLUCION AVANZADO - COLECCIONES
// ============================================

use std::collections::VecDeque;

fn queue_process(items: Vec<i32>) -> Vec<i32> {
    let mut q = VecDeque::from(items);
    let mut out = Vec::new();
    while let Some(v) = q.pop_front() {
        out.push(v);
    }
    out
}

fn main() {
    println!("queue: {:?}", queue_process(vec![1, 2, 3]));
}
