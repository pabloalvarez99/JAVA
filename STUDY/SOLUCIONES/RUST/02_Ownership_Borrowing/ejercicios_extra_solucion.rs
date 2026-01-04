// ============================================
// SOLUCION EXTRA - OWNERSHIP Y BORROWING
// ============================================

fn first_word(s: &str) -> &str {
    let bytes = s.as_bytes();
    for (i, &b) in bytes.iter().enumerate() {
        if b == b' ' {
            return &s[0..i];
        }
    }
    s
}

fn append_in_place(s: &mut String, extra: &str) {
    s.push_str(extra);
}

fn take_and_return(s: String) -> String {
    s
}

fn longest<'a>(a: &'a str, b: &'a str) -> &'a str {
    if a.len() >= b.len() {
        a
    } else {
        b
    }
}

fn split_at_first_space(s: &str) -> (&str, &str) {
    match s.find(' ') {
        Some(idx) => (&s[..idx], &s[idx + 1..]),
        None => (s, ""),
    }
}

fn sum_slice(nums: &[i32]) -> i32 {
    nums.iter().sum()
}

fn push_clone(vec: &mut Vec<String>, value: &str) {
    vec.push(value.to_string());
}


fn first_char(s: &str) -> Option<char> {
    s.chars().next()
}

fn join_words(words: &[String]) -> String {
    words.join(" ")
}

fn main() {
    let texto = String::from("hola mundo");
    println!("first: {}", first_word(&texto));

    let mut base = String::from("rust");
    append_in_place(&mut base, " lang");
    println!("base: {}", base);

    let t = take_and_return(String::from("move"));
    println!("t: {}", t);
}

