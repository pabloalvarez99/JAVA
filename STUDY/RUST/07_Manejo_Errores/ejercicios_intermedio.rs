// ============================================
// EJERCICIOS INTERMEDIO - MANEJO DE ERRORES
// ============================================

#[derive(Debug)]
enum AppError {
    Parse,
    Division,
}

fn dividir(a: i32, b: i32) -> Result<i32, AppError> {
    // TODO: valida b != 0
    Ok(0)
}


fn parse_pair(texto: &str) -> Result<(i32, i32), AppError> {
    // TODO: parsea "a,b" a dos numeros
    Ok((0, 0))
}

fn main() {
    println!("div: {:?}", dividir(10, 0));
}

