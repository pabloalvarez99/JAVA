// ============================================
// SOLUCION BASICO - FUNDAMENTOS
// ============================================

fn sum_range(n: i32) -> i32 {
    (1..=n).sum()
}

fn is_even(n: i32) -> bool {
    n % 2 == 0
}

fn main() {
    println!("sum: {}", sum_range(5));
    println!("even: {}", is_even(4));
}
