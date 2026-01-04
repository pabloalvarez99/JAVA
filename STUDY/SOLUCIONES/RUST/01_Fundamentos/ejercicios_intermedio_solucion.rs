// ============================================
// SOLUCION INTERMEDIO - FUNDAMENTOS
// ============================================

fn factorial(n: u32) -> u32 {
    let mut acc = 1;
    for i in 1..=n {
        acc *= i;
    }
    acc
}

fn fizzbuzz(n: i32) -> Vec<String> {
    let mut out = Vec::new();
    for i in 1..=n {
        if i % 15 == 0 {
            out.push("fizzbuzz".to_string());
        } else if i % 3 == 0 {
            out.push("fizz".to_string());
        } else if i % 5 == 0 {
            out.push("buzz".to_string());
        } else {
            out.push(i.to_string());
        }
    }
    out
}

fn main() {
    println!("fact: {}", factorial(5));
    println!("fizz: {:?}", fizzbuzz(15));
}
