// ============================================
// EJERCICIOS - MANEJO DE ERRORES
// ============================================

/*
OBJETIVO:
Usar Result y propagar errores.
*/

fn leer_numero(texto: &str) -> Result<i32, String> {
    // TODO: parsea y retorna Result
    Ok(0)
}

fn dividir(a: i32, b: i32) -> Result<i32, String> {
    // TODO: valida b != 0
    Ok(0)
}

fn main() {
    println!("num: {:?}", leer_numero("42"));
    println!("div: {:?}", dividir(10, 2));
}
