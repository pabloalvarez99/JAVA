// ============================================
// SOLUCION EXTRA - ITERADORES Y CLOSURES
// ============================================

fn even_squares(nums: &[i32]) -> Vec<i32> {
    nums.iter().filter(|n| *n % 2 == 0).map(|n| n * n).collect()
}

fn sum_even(nums: &[i32]) -> i32 {
    nums.iter().filter(|n| *n % 2 == 0).sum()
}

fn take_while_positive(nums: &[i32]) -> Vec<i32> {
    nums.iter().take_while(|n| **n > 0).copied().collect()
}

fn pair_sums(nums: &[i32]) -> Vec<i32> {
    nums.windows(2).map(|w| w[0] + w[1]).collect()
}

fn uniq_sorted(nums: &[i32]) -> Vec<i32> {
    let mut out: Vec<i32> = nums.to_vec();
    out.sort();
    out.dedup();
    out
}

fn count_longer(words: &[String], min: usize) -> usize {
    words.iter().filter(|w| w.len() > min).count()
}


fn parse_numbers(items: &[String]) -> Vec<i32> {
    items.iter().filter_map(|s| s.parse::<i32>().ok()).collect()
}

fn sum_by<F>(nums: &[i32], f: F) -> i32
where
    F: Fn(i32) -> i32,
{
    nums.iter().map(|&n| f(n)).sum()
}

fn main() {
    let v = vec![1, 2, 3, 4];
    println!("sq: {:?}", even_squares(&v));
}

