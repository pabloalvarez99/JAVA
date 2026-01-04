// ============================================
// SOLUCION AVANZADO - FUNDAMENTOS
// ============================================

fn bubble_sort(mut nums: Vec<i32>) -> Vec<i32> {
    let n = nums.len();
    for i in 0..n {
        for j in 0..(n.saturating_sub(i + 1)) {
            if nums[j] > nums[j + 1] {
                nums.swap(j, j + 1);
            }
        }
    }
    nums
}

fn avg(nums: &Vec<i32>) -> f64 {
    if nums.is_empty() {
        return 0.0;
    }
    let sum: i32 = nums.iter().sum();
    sum as f64 / nums.len() as f64
}

fn main() {
    println!("sort: {:?}", bubble_sort(vec![3, 2, 1]));
    println!("avg: {}", avg(&vec![1, 2, 3]));
}
