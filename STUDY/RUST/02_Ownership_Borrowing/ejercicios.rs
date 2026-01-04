// ============================================
// EJERCICIOS - OWNERSHIP Y BORROWING
// ============================================

/*
OBJETIVO:
Practicar ownership, borrowing y lifetimes basicos.
*/

fn longitud(s: &String) -> usize {
    // TODO: retorna la longitud
    0
}

fn agregar_texto(s: &mut String) {
    // TODO: agrega " mundo" al string
}

fn main() {
    let s = String::from("hola");
    let len = longitud(&s);
    println!("len: {}", len);

    let mut t = String::from("rust");
    agregar_texto(&mut t);
    println!("t: {}", t);

    // TODO: muestra un move y como evitarlo con clone
    println!("Completa los TODOs!");
}
