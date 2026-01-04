// ============================================
// EJERCICIOS EXTRA - STRUCTS Y ENUMS
// ============================================

#[derive(Debug)]
struct Producto {
    nombre: String,
    precio: f64,
}

impl Producto {
    fn aplicar_descuento(&mut self, pct: f64) {
        // TODO: reduce el precio
    }
}

enum Resultado {
    Ok(i32),
    Err(String),
}

fn parse_int(texto: &str) -> Resultado {
    // TODO: intenta parsear
    Resultado::Err("".to_string())
}

#[derive(Debug)]
struct Punto {
    x: f64,
    y: f64,
}

impl Punto {
    fn distancia_origen(&self) -> f64 {
        // TODO: sqrt(x^2 + y^2)
        0.0
    }
}

enum Estado {
    On,
    Off,
}

fn toggle_estado(e: Estado) -> Estado {
    // TODO: cambia On <-> Off
    e
}

fn total_precio(items: &[Producto]) -> f64 {
    // TODO: suma de precios
    0.0
}

fn resultado_a_option(r: Resultado) -> Option<i32> {
    // TODO: Ok -> Some, Err -> None
    None
}


fn listar_nombres(items: &[Producto]) -> Vec<String> {
    // TODO: retorna nombres de productos
    Vec::new()
}

fn resultado_descripcion(r: Resultado) -> String {
    // TODO: retorna descripcion de Resultado
    String::new()
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

