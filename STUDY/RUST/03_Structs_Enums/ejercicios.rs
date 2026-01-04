// ============================================
// EJERCICIOS - STRUCTS Y ENUMS
// ============================================

/*
OBJETIVO:
Definir structs, enums y usar impl.
*/

struct Usuario {
    nombre: String,
    edad: u32,
}

impl Usuario {
    fn saludo(&self) -> String {
        // TODO: retorna un saludo con nombre y edad
        String::new()
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
