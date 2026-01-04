// ============================================
// SOLUCION BASICO - PATTERN MATCHING
// ============================================

fn classify(n: i32) -> &'static str {
    match n {
        0..=4 => "bajo",
        5..=7 => "medio",
        _ => "alto",
    }
}

fn main() {
    println!("c: {}", classify(7));
}
