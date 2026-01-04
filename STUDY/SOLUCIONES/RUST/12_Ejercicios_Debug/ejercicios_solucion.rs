// ============================================
// SOLUCION - DEBUG
// ============================================

fn main() {
    let v = vec![1, 2, 3];
    println!("{}", v[2]);

    let s = String::from("hola");
    let t = s.clone();
    println!("{}", s);
    println!("{}", t);

    let mut texto = String::from("rust");
    {
        let a = &mut texto;
        a.push('!');
    }
    println!("{}", texto);
}
