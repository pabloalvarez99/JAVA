// ============================================
// INTEGRACION - PATTERN MATCHING
// ============================================
enum Msg {
    Text(String),
    Quit,
    Move(i32, i32),
}

fn describe(msg: &Msg) -> String {
    // TODO: describe el mensaje
    String::new()
}

fn count_moves(msgs: &[Msg]) -> usize {
    // TODO: cuenta mensajes Move
    0
}

fn main() {
    let msgs = vec![Msg::Text("hola".to_string()), Msg::Move(1, 2), Msg::Quit];
    println!("desc: {}", describe(&msgs[0]));
    println!("moves: {}", count_moves(&msgs));
}

