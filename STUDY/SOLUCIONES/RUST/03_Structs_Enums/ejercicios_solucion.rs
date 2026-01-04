// ============================================
// SOLUCION - STRUCTS Y ENUMS
// ============================================

struct Usuario {
    nombre: String,
    edad: u32,
}

impl Usuario {
    fn saludo(&self) -> String {
        format!("Hola {}, edad {}", self.nombre, self.edad)
    }
}

enum Estado {
    Activo,
    Inactivo,
}

fn main() {
    let u = Usuario {
        nombre: String::from("Ana"),
        edad: 20,
    };
    println!("{}", u.saludo());

    let estado = Estado::Activo;
    let texto = match estado {
        Estado::Activo => "activo",
        Estado::Inactivo => "inactivo",
    };
    println!("estado: {}", texto);
}
