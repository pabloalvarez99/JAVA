// ============================================
// SOLUCION EXTRA - PATTERN MATCHING
// ============================================

enum Token {
    Numero(i32),
    Suma,
    Resta,
}

fn eval(tokens: Vec<Token>) -> i32 {
    let mut acc = 0;
    let mut op = 1;
    for t in tokens {
        match t {
            Token::Numero(n) => acc += op * n,
            Token::Suma => op = 1,
            Token::Resta => op = -1,
        }
    }
    acc
}

fn describe_range(n: i32) -> &'static str {
    match n {
        n if n < 0 => "negativo",
        0 => "cero",
        1..=9 => "un_digito",
        10..=99 => "dos_digitos",
        _ => "grande",
    }
}

fn sum_options(a: Option<i32>, b: Option<i32>) -> i32 {
    match (a, b) {
        (Some(x), Some(y)) => x + y,
        (Some(x), None) => x,
        (None, Some(y)) => y,
        (None, None) => 0,
    }
}

fn count_tokens(tokens: &[Token]) -> (usize, usize) {
    let mut nums = 0;
    let mut ops = 0;
    for t in tokens {
        match t {
            Token::Numero(_) => nums += 1,
            Token::Suma | Token::Resta => ops += 1,
        }
    }
    (nums, ops)
}

fn token_to_str(t: &Token) -> &'static str {
    match t {
        Token::Numero(_) => "num",
        Token::Suma => "suma",
        Token::Resta => "resta",
    }
}


fn sum_present(nums: &[Option<i32>]) -> i32 {
    nums.iter().filter_map(|n| *n).sum()
}

fn classify_pair(pair: (i32, i32)) -> &'static str {
    match pair {
        (0, 0) => "cero",
        (0, _) => "eje_y",
        (_, 0) => "eje_x",
        (a, b) if a == b => "diagonal",
        _ => "otro",
    }
}

fn main() {
    let tokens = vec![Token::Numero(10), Token::Suma, Token::Numero(5)];
    println!("eval: {}", eval(tokens));
}

