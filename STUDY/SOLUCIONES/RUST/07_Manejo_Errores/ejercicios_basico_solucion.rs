// ============================================
// SOLUCION BASICO - MANEJO DE ERRORES
// ============================================

fn parse_num(texto: &str) -> Result<i32, String> {
    texto.parse::<i32>().map_err(|_| "parse error".to_string())
}


fn safe_div(a: i32, b: i32) -> Result<i32, String> {
    if b == 0 {
        return Err("division".to_string());
    }
    Ok(a / b)
}

fn main() {
    println!("parse: {:?}", parse_num("10"));
}

