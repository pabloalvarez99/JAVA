// ============================================
// SOLUCION - INTEGRACION - PATTERN MATCHING
// ============================================
enum Msg {
    Text(String),
    Quit,
    Move(i32, i32),
}

fn describe(msg: &Msg) -> String {
    match msg {
        Msg::Text(t) => format!("text: {}", t),
        Msg::Quit => "quit".to_string(),
        Msg::Move(x, y) => format!("move {},{}", x, y),
    }
}

fn count_moves(msgs: &[Msg]) -> usize {
    msgs.iter().filter(|m| matches!(m, Msg::Move(_, _))).count()
}

fn main() {
    let msgs = vec![Msg::Text("hola".to_string()), Msg::Move(1, 2), Msg::Quit];
    println!("desc: {}", describe(&msgs[0]));
    println!("moves: {}", count_moves(&msgs));
}

