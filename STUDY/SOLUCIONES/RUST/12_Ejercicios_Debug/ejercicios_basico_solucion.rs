// ============================================
// SOLUCION BASICO - DEBUG
// ============================================


fn safe_get(nums: &Vec<i32>, idx: usize) -> Option<i32> {
    nums.get(idx).copied()
}

fn main() {
    let v = vec![1, 2, 3];
    println!("{}", v[2]);
}

