// ============================================
// INTEGRACION - MANEJO DE ERRORES
// ============================================
#[derive(Debug)]
enum AppError {
    ParseError,
    DivisionPorCero,
}

fn parse_list(texto: &str) -> Result<Vec<i32>, AppError> {
    // TODO: parsea "1,2,3" a Vec<i32>
    Ok(Vec::new())
}

fn safe_div(a: i32, b: i32) -> Result<i32, AppError> {
    // TODO: divide o retorna error
    Ok(0)
}

fn main() {
    println!("parse: {:?}", parse_list("1,2,3"));
    println!("div: {:?}", safe_div(10, 0));
}

