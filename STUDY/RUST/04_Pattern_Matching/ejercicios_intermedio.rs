// ============================================
// EJERCICIOS INTERMEDIO - PATTERN MATCHING
// ============================================

enum Token {
    Num(i32),
    Add,
    Sub,
}

fn eval(tokens: Vec<Token>) -> i32 {
    // TODO: procesa tokens
    0
}


fn count_ops(tokens: &[Token]) -> usize {
    // TODO: cuenta Add/Sub
    0
}

fn collect_nums(tokens: &[Token]) -> Vec<i32> {
    // TODO: extrae numeros
    Vec::new()
}

fn main() {
    let t = vec![Token::Num(2), Token::Add, Token::Num(3)];
    println!("eval: {}", eval(t));
}

