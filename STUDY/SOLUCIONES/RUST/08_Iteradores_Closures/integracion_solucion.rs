// ============================================
// SOLUCION - INTEGRACION - ITERADORES Y CLOSURES
// ============================================
fn pipeline(nums: &[i32]) -> Vec<i32> {
    nums.iter().filter(|n| *n % 2 == 0).map(|n| n * n).collect()
}

fn sum_squares(nums: &[i32]) -> i32 {
    nums.iter().map(|n| n * n).sum()
}

fn main() {
    let v = vec![1, 2, 3, 4];
    println!("pipe: {:?}", pipeline(&v));
    println!("sum: {}", sum_squares(&v));
}

