// ============================================
// SOLUCION INTERMEDIO - STRUCTS Y ENUMS
// ============================================

enum Estado {
    Ok(i32),
    Err(String),
}

fn describe(e: Estado) -> String {
    match e {
        Estado::Ok(n) => format!("ok: {}", n),
        Estado::Err(msg) => format!("err: {}", msg),
    }
}

fn main() {
    println!("desc: {}", describe(Estado::Ok(3)));
}
