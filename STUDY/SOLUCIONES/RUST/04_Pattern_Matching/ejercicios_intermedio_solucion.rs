// ============================================
// SOLUCION INTERMEDIO - PATTERN MATCHING
// ============================================

enum Token {
    Num(i32),
    Add,
    Sub,
}

fn eval(tokens: Vec<Token>) -> i32 {
    let mut acc = 0;
    let mut op = 1;
    for t in tokens {
        match t {
            Token::Num(n) => acc += op * n,
            Token::Add => op = 1,
            Token::Sub => op = -1,
        }
    }
    acc
}

fn main() {
    let t = vec![Token::Num(2), Token::Add, Token::Num(3)];
    println!("eval: {}", eval(t));
}
