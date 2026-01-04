// ============================================
// SOLUCION - INTEGRACION - MANEJO DE ERRORES
// ============================================
#[derive(Debug)]
enum AppError {
    ParseError,
    DivisionPorCero,
}

fn parse_list(texto: &str) -> Result<Vec<i32>, AppError> {
    let mut out = Vec::new();
    let limpio = texto.trim();
    if limpio.is_empty() {
        return Ok(out);
    }
    for part in limpio.split(',') {
        match part.trim().parse::<i32>() {
            Ok(n) => out.push(n),
            Err(_) => return Err(AppError::ParseError),
        }
    }
    Ok(out)
}

fn safe_div(a: i32, b: i32) -> Result<i32, AppError> {
    if b == 0 {
        return Err(AppError::DivisionPorCero);
    }
    Ok(a / b)
}

fn main() {
    println!("parse: {:?}", parse_list("1,2,3"));
    println!("div: {:?}", safe_div(10, 0));
}

