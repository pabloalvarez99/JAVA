// ============================================
// SOLUCION EXTRA - DEBUG
// ============================================

fn main() {
    let mut nums = vec![1, 2, 3];
    let snapshot = nums.clone();
    for n in snapshot {
        nums.push(n);
    }

    let texto = String::from("hola");
    match texto.as_str() {
        _ => println!("{}", texto),
    }

    let mut datos = vec![1, 2, 3];
    let primero = datos[0];
    datos.push(4);
    println!("{}", primero);

    let valor: Option<i32> = Some(5);
    println!("{}", valor.unwrap_or(0));

    let texto2 = String::from("hola");
    let texto2_clon = texto2.clone();
    let f = move || println!("{}", texto2_clon);
    f();
    println!("{}", texto2);

    let mut valores = vec![1, 2, 3];
    let (left, right) = valores.split_at_mut(1);
    let a = &mut left[0];
    let b = &mut right[0];
    *a += *b;

    let n = 5;
    let out = match n {
        0 => "cero",
        _ => "otro",
    };
    println!("{}", out);
}
