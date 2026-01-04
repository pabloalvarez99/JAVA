// ============================================
// SOLUCION - FUNDAMENTOS
// ============================================

fn es_par(n: i32) -> bool {
    n % 2 == 0
}

fn suma_hasta(n: i32) -> i32 {
    (1..=n).sum()
}

fn main() {
    let x = 10;
    println!("{} es par: {}", x, es_par(x));
    println!("suma hasta 5: {}", suma_hasta(5));
}
