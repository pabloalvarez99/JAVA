// ============================================
// SOLUCION AVANZADO - ITERADORES Y CLOSURES
// ============================================

fn fold_product(nums: &Vec<i32>) -> i32 {
    nums.iter().fold(1, |acc, x| acc * x)
}


fn take_n(nums: &Vec<i32>, n: usize) -> Vec<i32> {
    nums.iter().take(n).copied().collect()
}

fn main() {
    let v = vec![1, 2, 3, 4];
    println!("prod: {}", fold_product(&v));
}

