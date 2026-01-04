// ============================================
// SOLUCION EXTRA - MANEJO DE ERRORES
// ============================================

#[derive(Debug)]
enum AppError {
    ParseError,
    DivisionPorCero,
    IndexError,
    Negativo,
}

fn parse_num(texto: &str) -> Result<i32, AppError> {
    texto.parse::<i32>().map_err(|_| AppError::ParseError)
}

fn dividir(a: i32, b: i32) -> Result<i32, AppError> {
    if b == 0 {
        return Err(AppError::DivisionPorCero);
    }
    Ok(a / b)
}

fn parse_and_divide(a: &str, b: &str) -> Result<i32, AppError> {
    let a_num = parse_num(a)?;
    let b_num = parse_num(b)?;
    dividir(a_num, b_num)
}

fn safe_index(nums: &[i32], idx: usize) -> Result<i32, AppError> {
    nums.get(idx).copied().ok_or(AppError::IndexError)
}

fn ensure_positive(n: i32) -> Result<i32, AppError> {
    if n < 0 {
        Err(AppError::Negativo)
    } else {
        Ok(n)
    }
}

fn to_result(opt: Option<i32>) -> Result<i32, AppError> {
    opt.ok_or(AppError::ParseError)
}


fn parse_vec(texto: &str) -> Result<Vec<i32>, AppError> {
    let mut out = Vec::new();
    let limpio = texto.trim();
    if limpio.is_empty() {
        return Ok(out);
    }
    for part in limpio.split(',') {
        let num = parse_num(part.trim())?;
        out.push(num);
    }
    Ok(out)
}

fn divide_all(nums: &[i32], divisor: i32) -> Result<Vec<i32>, AppError> {
    if divisor == 0 {
        return Err(AppError::DivisionPorCero);
    }
    Ok(nums.iter().map(|n| n / divisor).collect())
}

fn main() {
    println!("parse: {:?}", parse_num("7"));
    println!("div: {:?}", dividir(10, 0));
}

