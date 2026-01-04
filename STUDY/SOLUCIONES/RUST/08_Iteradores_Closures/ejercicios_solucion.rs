// ============================================
// SOLUCION - ITERADORES Y CLOSURES
// ============================================

fn duplicar_pares(nums: &[i32]) -> Vec<i32> {
    nums.iter().filter(|n| *n % 2 == 0).map(|n| n * 2).collect()
}

fn main() {
    let v = vec![1, 2, 3, 4, 5, 6];
    println!("pares: {:?}", duplicar_pares(&v));

    let base = 10;
    let sumar = |n: i32| n + base;
    println!("sumar: {}", sumar(5));
}
