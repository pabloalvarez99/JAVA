// ============================================
// SOLUCION AVANZADO - PATTERN MATCHING
// ============================================

fn point_label(p: (i32, i32)) -> &'static str {
    match p {
        (0, 0) => "origen",
        (0, _) => "eje y",
        (_, 0) => "eje x",
        _ => "cuadrante",
    }
}

fn main() {
    println!("label: {}", point_label((0, 5)));
}
