// ============================================
// SOLUCION INTERMEDIO - ITERADORES Y CLOSURES
// ============================================

fn even_sum(nums: &Vec<i32>) -> i32 {
    nums.iter().filter(|n| *n % 2 == 0).sum()
}


fn count_even(nums: &Vec<i32>) -> usize {
    nums.iter().filter(|n| **n % 2 == 0).count()
}

fn main() {
    let v = vec![1, 2, 3, 4];
    println!("sum: {}", even_sum(&v));
}

