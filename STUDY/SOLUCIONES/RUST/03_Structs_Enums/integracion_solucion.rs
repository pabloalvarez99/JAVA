// ============================================
// SOLUCION - INTEGRACION - STRUCTS Y ENUMS
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
    user.active
}

fn role_label(role: &Role) -> &'static str {
    match role {
        Role::Admin => "admin",
        Role::User => "user",
    }
}

fn main() {
    let u = User { name: "Ana".to_string(), active: true };
    println!("active: {}", is_active(&u));
    println!("role: {}", role_label(&Role::Admin));
}

