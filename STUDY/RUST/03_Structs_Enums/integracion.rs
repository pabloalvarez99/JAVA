// ============================================
// INTEGRACION - STRUCTS Y ENUMS
// ============================================
#[derive(Debug)]
struct User {
    name: String,
    active: bool,
}

enum Role {
    Admin,
    User,
}

fn is_active(user: &User) -> bool {
    // TODO: retorna estado
    false
}

fn role_label(role: &Role) -> &'static str {
    // TODO: retorna etiqueta
    ""
}

fn main() {
    let u = User { name: "Ana".to_string(), active: true };
    println!("active: {}", is_active(&u));
    println!("role: {}", role_label(&Role::Admin));
}

