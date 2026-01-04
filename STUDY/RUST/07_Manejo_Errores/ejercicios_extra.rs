// ============================================
// EJERCICIOS EXTRA - MANEJO DE ERRORES
// ============================================

#[derive(Debug)]
enum AppError {
    ParseError,
    DivisionPorCero,
    IndexError,
    Negativo,
}

fn parse_num(texto: &str) -> Result<i32, AppError> {
    // TODO: parsea o retorna ParseError
    Ok(0)
}

fn dividir(a: i32, b: i32) -> Result<i32, AppError> {
    // TODO: valida b != 0
    Ok(0)
}

fn parse_and_divide(a: &str, b: &str) -> Result<i32, AppError> {
    // TODO: parsea ambos y divide
    Ok(0)
}

fn safe_index(nums: &[i32], idx: usize) -> Result<i32, AppError> {
    // TODO: retorna nums[idx] o IndexError
    Ok(0)
}

fn ensure_positive(n: i32) -> Result<i32, AppError> {
    // TODO: retorna Err si n < 0
    Ok(n)
}

fn to_result(opt: Option<i32>) -> Result<i32, AppError> {
    // TODO: Some -> Ok, None -> ParseError
    Ok(0)
}


fn parse_vec(texto: &str) -> Result<Vec<i32>, AppError> {
    // TODO: parsea "1,2,3" a Vec<i32>
    Ok(Vec::new())
}

fn divide_all(nums: &[i32], divisor: i32) -> Result<Vec<i32>, AppError> {
    // TODO: divide todos los elementos
    Ok(Vec::new())
}

fn main() {
    println!("parse: {:?}", parse_num("7"));
    println!("div: {:?}", dividir(10, 0));
}

