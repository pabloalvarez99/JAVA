// ============================================
// SOLUCION AVANZADO - STRUCTS Y ENUMS
// ============================================

fn parse_int(texto: &str) -> Result<i32, String> {
    texto.parse::<i32>().map_err(|_| "parse error".to_string())
}

fn main() {
    println!("parse: {:?}", parse_int("42"));
}
