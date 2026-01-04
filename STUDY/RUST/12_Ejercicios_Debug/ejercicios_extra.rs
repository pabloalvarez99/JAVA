// ============================================
// EJERCICIOS EXTRA - DEBUG
// ============================================


fn main() {
    let mut nums = vec![1, 2, 3];

    // TODO 1: corrige el error de borrow al modificar en iteracion
    // for n in &nums {
    //     nums.push(*n);
    // }

    let texto = String::from("hola");

    // TODO 2: evita mover texto en el match
    // match texto {
    //     _ => println!("{}", texto),
    // }

    let mut datos = vec![1, 2, 3];
    // TODO 3: corrige el error por prestamo mutable y prestamo inmutable
    // let primero = &datos[0];
    // datos.push(4);
    // println!("{}", primero);

    // TODO 4: corrige el error de tipo en unwrap
    // let valor: Option<i32> = Some(5);
    // println!("{}", valor.unwrap_or("0"));

    // TODO 5: corrige el error de move en el closure
    // let texto2 = String::from("hola");
    // let f = move || println!("{}", texto2);
    // println!("{}", texto2);

    // TODO 6: corrige el error por prestamos mutables simultaneos
    // let mut valores = vec![1, 2, 3];
    // let a = &mut valores[0];
    // let b = &mut valores[1];
    // *a += *b;

    // TODO 7: corrige el error de tipos en match
    // let n = 5;
    // let out = match n {
    //     0 => "cero",
    //     _ => 1,
    // };

    println!("Completa los TODOs!");
}

