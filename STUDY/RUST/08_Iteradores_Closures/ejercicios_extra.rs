// ============================================
// EJERCICIOS EXTRA - ITERADORES Y CLOSURES
// ============================================

fn even_squares(nums: &[i32]) -> Vec<i32> {
    // TODO: filtra pares y eleva al cuadrado
    Vec::new()
}

fn sum_even(nums: &[i32]) -> i32 {
    // TODO: suma solo pares
    0
}

fn take_while_positive(nums: &[i32]) -> Vec<i32> {
    // TODO: toma mientras sean > 0
    Vec::new()
}

fn pair_sums(nums: &[i32]) -> Vec<i32> {
    // TODO: suma cada par consecutivo
    Vec::new()
}

fn uniq_sorted(nums: &[i32]) -> Vec<i32> {
    // TODO: ordena y elimina duplicados
    Vec::new()
}

fn count_longer(words: &[String], min: usize) -> usize {
    // TODO: cuenta palabras con len > min
    0
}


fn parse_numbers(items: &[String]) -> Vec<i32> {
    // TODO: parsea elementos a i32 si es posible
    Vec::new()
}

fn sum_by<F>(nums: &[i32], f: F) -> i32
where
    F: Fn(i32) -> i32,
{
    // TODO: aplica f y suma
    0
}

fn main() {
    let v = vec![1, 2, 3, 4];
    println!("sq: {:?}", even_squares(&v));
}

