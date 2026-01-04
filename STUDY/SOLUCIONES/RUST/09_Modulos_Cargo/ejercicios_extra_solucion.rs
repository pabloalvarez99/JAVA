// ============================================
// SOLUCION EXTRA - MODULOS Y CARGO
// ============================================

mod math {
    pub fn doble(n: i32) -> i32 {
        n * 2
    }

    pub fn cuadrado(n: i32) -> i32 {
        n * n
    }
}

mod utils {
    pub fn clamp(n: i32, min: i32, max: i32) -> i32 {
        if n < min {
            min
        } else if n > max {
            max
        } else {
            n
        }
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

fn usar_math(n: i32) -> i32 {
    math::doble(n) + math::cuadrado(n)
}

fn usar_utils(n: i32) -> i32 {
    utils::clamp(n, 0, 10)
}


fn usar_texto(nombre: &str) -> String {
    texto::iniciales(nombre)
}

fn aplicar_todo(n: i32, nombre: &str) -> (i32, String) {
    let valor = math::doble(n);
    let valor = utils::clamp(valor, 0, 10);
    let init = texto::iniciales(nombre);
    (valor, init)
}

fn main() {
    println!("doble: {}", math::doble(4));
}

