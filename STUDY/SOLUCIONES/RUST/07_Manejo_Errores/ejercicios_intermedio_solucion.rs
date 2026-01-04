// ============================================
// SOLUCION INTERMEDIO - MANEJO DE ERRORES
// ============================================

#[derive(Debug)]
enum AppError {
    Parse,
    Division,
}

fn dividir(a: i32, b: i32) -> Result<i32, AppError> {
    if b == 0 {
        return Err(AppError::Division);
    }
    Ok(a / b)
}


fn parse_pair(texto: &str) -> Result<(i32, i32), AppError> {
    let parts: Vec<&str> = texto.split(',').collect();
    if parts.len() != 2 {
        return Err(AppError::Parse);
    }
    let a = parts[0].trim().parse::<i32>().map_err(|_| AppError::Parse)?;
    let b = parts[1].trim().parse::<i32>().map_err(|_| AppError::Parse)?;
    Ok((a, b))
}

fn main() {
    println!("div: {:?}", dividir(10, 0));
}

