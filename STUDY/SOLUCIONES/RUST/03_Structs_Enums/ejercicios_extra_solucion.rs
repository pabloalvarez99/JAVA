// ============================================
// SOLUCION EXTRA - STRUCTS Y ENUMS
// ============================================

#[derive(Debug)]
struct Producto {
    nombre: String,
    precio: f64,
}

impl Producto {
    fn aplicar_descuento(&mut self, pct: f64) {
        self.precio = self.precio * (1.0 - pct / 100.0);
    }
}

enum Resultado {
    Ok(i32),
    Err(String),
}

fn parse_int(texto: &str) -> Resultado {
    match texto.parse::<i32>() {
        Ok(n) => Resultado::Ok(n),
        Err(_) => Resultado::Err("parse error".to_string()),
    }
}

#[derive(Debug)]
struct Punto {
    x: f64,
    y: f64,
}

impl Punto {
    fn distancia_origen(&self) -> f64 {
        (self.x * self.x + self.y * self.y).sqrt()
    }
}

enum Estado {
    On,
    Off,
}

fn toggle_estado(e: Estado) -> Estado {
    match e {
        Estado::On => Estado::Off,
        Estado::Off => Estado::On,
    }
}

fn total_precio(items: &[Producto]) -> f64 {
    items.iter().map(|p| p.precio).sum()
}

fn resultado_a_option(r: Resultado) -> Option<i32> {
    match r {
        Resultado::Ok(n) => Some(n),
        Resultado::Err(_) => None,
    }
}


fn listar_nombres(items: &[Producto]) -> Vec<String> {
    items.iter().map(|p| p.nombre.clone()).collect()
}

fn resultado_descripcion(r: Resultado) -> String {
    match r {
        Resultado::Ok(n) => format!("ok {}", n),
        Resultado::Err(e) => format!("err {}", e),
    }
}

fn main() {
    let mut p = Producto { nombre: "A".to_string(), precio: 10.0 };
    p.aplicar_descuento(10.0);
    println!("producto: {:?}", p);

    let r = parse_int("42");
    match r {
        Resultado::Ok(n) => println!("ok: {}", n),
        Resultado::Err(e) => println!("err: {}", e),
    }
}

