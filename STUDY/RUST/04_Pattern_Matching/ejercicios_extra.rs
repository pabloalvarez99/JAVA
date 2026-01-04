// ============================================
// EJERCICIOS EXTRA - PATTERN MATCHING
// ============================================

enum Token {
    Numero(i32),
    Suma,
    Resta,
}

fn eval(tokens: Vec<Token>) -> i32 {
    // TODO: suma o resta segun tokens
    0
}

fn describe_range(n: i32) -> &'static str {
    // TODO: usa match con guards
    ""
}

fn sum_options(a: Option<i32>, b: Option<i32>) -> i32 {
    // TODO: combina opciones
    0
}

fn count_tokens(tokens: &[Token]) -> (usize, usize) {
    // TODO: retorna (numeros, operadores)
    (0, 0)
}

fn token_to_str(t: &Token) -> &'static str {
    // TODO: retorna "num", "suma" o "resta"
    ""
}


fn sum_present(nums: &[Option<i32>]) -> i32 {
    // TODO: suma solo valores Some
    0
}

fn classify_pair(pair: (i32, i32)) -> &'static str {
    // TODO: usa match con patrones
    ""
}

fn main() {
    let tokens = vec![Token::Numero(10), Token::Suma, Token::Numero(5)];
    println!("eval: {}", eval(tokens));
}

