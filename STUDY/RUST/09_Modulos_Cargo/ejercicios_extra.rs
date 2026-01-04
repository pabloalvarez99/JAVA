// ============================================
// EJERCICIOS EXTRA - MODULOS Y CARGO
// ============================================

mod math {
    pub fn doble(n: i32) -> i32 {
        // TODO: retorna doble
        0
    }

    pub fn cuadrado(n: i32) -> i32 {
        // TODO: retorna cuadrado
        0
    }
}

mod utils {
    pub fn clamp(n: i32, min: i32, max: i32) -> i32 {
        // TODO: limita n entre min y max
        0
    }
}

mod texto {
    pub fn iniciales(nombre: &str) -> String {
        // TODO: retorna iniciales en mayusculas
        String::new()
    }
}

fn usar_math(n: i32) -> i32 {
    // TODO: usa math::doble y math::cuadrado
    0
}

fn usar_utils(n: i32) -> i32 {
    // TODO: usa utils::clamp
    0
}


fn usar_texto(nombre: &str) -> String {
    // TODO: usa texto::iniciales
    String::new()
}

fn aplicar_todo(n: i32, nombre: &str) -> (i32, String) {
    // TODO: usa math::doble, utils::clamp y texto::iniciales
    (0, String::new())
}

fn main() {
    println!("doble: {}", math::doble(4));
}

