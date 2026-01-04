// ============================================
// INTEGRACION - MODULOS Y CARGO
// ============================================
mod util {
    pub fn trim_lower(s: &str) -> String {
        // TODO: limpia y pasa a minusculas
        String::new()
    }
}

mod math {
    pub fn doble(n: i32) -> i32 {
        // TODO: retorna doble
        0
    }
}

mod texto {
    pub fn iniciales(nombre: &str) -> String {
        // TODO: retorna iniciales
        String::new()
    }
}

fn normalizar(nombres: &[String]) -> Vec<String> {
    // TODO: usa util::trim_lower
    Vec::new()
}

fn resumen(nombre: &str, n: i32) -> String {
    // TODO: usa math::doble y texto::iniciales
    String::new()
}

fn main() {
    let nombres = vec![" Ana ".to_string(), "Bob".to_string()];
    println!("norm: {:?}", normalizar(&nombres));
    println!("resumen: {}", resumen("Ana Diaz", 3));
}

