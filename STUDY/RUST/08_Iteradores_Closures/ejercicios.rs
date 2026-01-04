// ============================================
// EJERCICIOS - ITERADORES Y CLOSURES
// ============================================

/*
OBJETIVO:
Usar iteradores y closures.
*/

fn duplicar_pares(nums: &[i32]) -> Vec<i32> {
    // TODO: map + filter
    Vec::new()
}

fn main() {
    let v = vec![1, 2, 3, 4, 5, 6];
    println!("pares: {:?}", duplicar_pares(&v));

    let base = 10;
    let sumar = |n: i32| n + base;
    // TODO: usa la closure
    println!("sumar: {}", sumar(5));
}
