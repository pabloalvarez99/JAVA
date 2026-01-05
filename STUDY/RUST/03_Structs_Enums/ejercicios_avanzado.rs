// ============================================
// EJERCICIOS AVANZADO - STRUCTS Y ENUMS
// ============================================

fn parse_int(texto: &str) -> Result<i32, String> {
    // TODO: parsea o retorna Err
    Ok(0)
}


struct Producto {
    nombre: String,
    precio: f64,
}

impl Producto {
    fn con_iva(&self, tasa: f64) -> f64 {
        // TODO: aplica tasa
        0.0
    }
}

enum Estado {
    Activo,
    Inactivo,
}

fn toggle_estado(e: Estado) -> Estado {
    // TODO: cambia estado
    e
}

fn main() {
    println!("parse: {:?}", parse_int("42"));
}

