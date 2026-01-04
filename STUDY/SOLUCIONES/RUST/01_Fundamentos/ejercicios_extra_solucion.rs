// ============================================
// SOLUCION EXTRA - FUNDAMENTOS
// ============================================

fn celsius_a_fahrenheit(c: f64) -> f64 {
    (c * 9.0 / 5.0) + 32.0
}

fn contar_vocales(texto: &str) -> usize {
    let mut total = 0;
    for ch in texto.chars() {
        match ch.to_ascii_lowercase() {
            'a' | 'e' | 'i' | 'o' | 'u' => total += 1,
            _ => {}
        }
    }
    total
}

fn factorial(n: u32) -> u32 {
    let mut acc = 1;
    for i in 1..=n {
        acc *= i;
    }
    acc
}

fn es_par(n: i32) -> bool {
    n % 2 == 0
}

fn suma_hasta(n: u32) -> u32 {
    let mut acc = 0;
    for i in 1..=n {
        acc += i;
    }
    acc
}

fn maximo(nums: &[i32]) -> i32 {
    let mut max = nums[0];
    for &n in nums.iter().skip(1) {
        if n > max {
            max = n;
        }
    }
    max
}

fn invertir(texto: &str) -> String {
    texto.chars().rev().collect()
}


fn promedio(nums: &[i32]) -> f64 {
    if nums.is_empty() {
        return 0.0;
    }
    let suma: i32 = nums.iter().sum();
    suma as f64 / nums.len() as f64
}

fn es_palindromo(texto: &str) -> bool {
    let chars: Vec<char> = texto.chars().collect();
    chars.iter().eq(chars.iter().rev())
}

fn main() {
    println!("f: {}", celsius_a_fahrenheit(0.0));
    println!("vocales: {}", contar_vocales("rust"));
    println!("fact: {}", factorial(5));
}

