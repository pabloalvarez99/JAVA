// ============================================
// SOLUCION - MANEJO DE ERRORES
// ============================================

fn leer_numero(texto: &str) -> Result<i32, String> {
    texto.parse::<i32>().map_err(|_| "parse error".to_string())
}

fn dividir(a: i32, b: i32) -> Result<i32, String> {
    if b == 0 {
        return Err("division por cero".to_string());
    }
    Ok(a / b)
}

fn main() {
    println!("num: {:?}", leer_numero("42"));
    println!("div: {:?}", dividir(10, 2));
}
