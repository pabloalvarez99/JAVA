// ============================================
// SOLUCION - INTEGRACION - FUNDAMENTOS
// ============================================
fn stats(nums: &[i32]) -> (i32, i32, f64) {
    if nums.is_empty() {
        return (0, 0, 0.0);
    }
    let mut min = nums[0];
    let mut max = nums[0];
    let mut suma = 0;
    for &n in nums {
        if n < min {
            min = n;
        }
        if n > max {
            max = n;
        }
        suma += n;
    }
    (min, max, suma as f64 / nums.len() as f64)
}

fn reverse_words(texto: &str) -> String {
    texto.split_whitespace().rev().collect::<Vec<&str>>().join(" ")
}

fn main() {
    let nums = vec![1, 2, 3, 4];
    println!("stats: {:?}", stats(&nums));
    println!("reverse: {}", reverse_words("hola mundo"));
}

