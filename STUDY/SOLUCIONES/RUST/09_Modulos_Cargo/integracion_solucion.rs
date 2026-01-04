// ============================================
// SOLUCION - INTEGRACION - MODULOS Y CARGO
// ============================================
mod util {
    pub fn trim_lower(s: &str) -> String {
        s.trim().to_lowercase()
    }
}

mod math {
    pub fn doble(n: i32) -> i32 {
        n * 2
    }
}

mod texto {
    pub fn iniciales(nombre: &str) -> String {
        let mut out = String::new();
        for palabra in nombre.split_whitespace() {
            if let Some(ch) = palabra.chars().next() {
                out.push(ch.to_ascii_uppercase());
            }
        }
        out
    }
}

fn normalizar(nombres: &[String]) -> Vec<String> {
    nombres.iter().map(|n| util::trim_lower(n)).collect()
}

fn resumen(nombre: &str, n: i32) -> String {
    let init = texto::iniciales(nombre);
    let val = math::doble(n);
    format!("{}:{}", init, val)
}

fn main() {
    let nombres = vec![" Ana ".to_string(), "Bob".to_string()];
    println!("norm: {:?}", normalizar(&nombres));
    println!("resumen: {}", resumen("Ana Diaz", 3));
}

