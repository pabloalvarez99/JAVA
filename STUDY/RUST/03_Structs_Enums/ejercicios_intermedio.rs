// ============================================
// EJERCICIOS INTERMEDIO - STRUCTS Y ENUMS
// ============================================

enum Estado {
    Ok(i32),
    Err(String),
}

fn describe(e: Estado) -> String {
    // TODO: usa match
    String::new()
}

fn main() {
    println!("desc: {}", describe(Estado::Ok(3)));
}
