// ============================================
// EJERCICIOS INTERMEDIO - STRUCTS Y ENUMS
// ============================================

enum Estado {
    Ok(i32),
    Err(String),
}

fn describe(e: Estado) -> String {
    // TODO: usa match
    String::new()
}


struct Usuario {
    nombre: String,
    activo: bool,
}

impl Usuario {
    fn activar(&mut self) {
        // TODO: marca activo
    }

    fn is_active(&self) -> bool {
        // TODO: retorna estado
        false
    }
}

fn main() {
    println!("desc: {}", describe(Estado::Ok(3)));
}

