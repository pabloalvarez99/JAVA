// ============================================
// SOLUCION BASICO - COLECCIONES
// ============================================

fn sum_vec(v: &Vec<i32>) -> i32 {
    v.iter().sum()
}

fn max_vec(v: &Vec<i32>) -> i32 {
    v.iter().copied().max().unwrap_or(0)
}

fn main() {
    let v = vec![1, 2, 3];
    println!("sum: {}", sum_vec(&v));
    println!("max: {}", max_vec(&v));
}
