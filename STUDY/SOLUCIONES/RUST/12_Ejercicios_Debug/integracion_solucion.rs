// ============================================
// SOLUCION - INTEGRACION - DEBUG
// ============================================
fn main() {
    let mut nums = vec![1, 2, 3];
    let snapshot = nums.clone();
    for n in snapshot {
        nums.push(n);
    }

    let n = 5;
    let out = match n {
        0 => "cero",
        _ => "otro",
    };
    println!("{}", out);
}

