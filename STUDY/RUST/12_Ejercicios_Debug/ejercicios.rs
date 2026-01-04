// ============================================
// EJERCICIOS - DEBUG
// ============================================

/*
OBJETIVO:
Corregir errores comunes de Rust.
*/

fn main() {
    let v = vec![1, 2, 3];

    // TODO 1: corrige el indice fuera de rango
    // println!("{}", v[3]);

    let s = String::from("hola");

    // TODO 2: corrige el move para poder usar s
    // let t = s;
    // println!("{}", s);

    // TODO 3: corrige el doble borrow mutable
    let mut texto = String::from("rust");
    // let a = &mut texto;
    // let b = &mut texto;
    // println!("{} {}", a, b);

    println!("Completa los TODOs!");
}
