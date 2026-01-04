// ============================================
// SOLUCION BASICO - ITERADORES Y CLOSURES
// ============================================

fn double(nums: &Vec<i32>) -> Vec<i32> {
    nums.iter().map(|n| n * 2).collect()
}


fn filter_gt(nums: &Vec<i32>, threshold: i32) -> Vec<i32> {
    nums.iter().filter(|n| **n > threshold).copied().collect()
}

fn main() {
    let v = vec![1, 2, 3];
    println!("double: {:?}", double(&v));
}

