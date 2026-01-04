// ============================================
// INTEGRACION - PROYECTOS COMPLEJOS
// ============================================
#[derive(Debug, Clone)]
struct Tarea {
    id: u32,
    titulo: String,
    hecha: bool,
}

fn buscar(tareas: &[Tarea], id: u32) -> Option<Tarea> {
    // TODO: retorna tarea clonada
    None
}

fn marcar(tareas: &mut Vec<Tarea>, id: u32) -> bool {
    // TODO: marca como hecha
    false
}

fn main() {
    let mut tareas = vec![
        Tarea { id: 1, titulo: "leer".to_string(), hecha: false },
        Tarea { id: 2, titulo: "escribir".to_string(), hecha: false },
    ];
    println!("buscar: {:?}", buscar(&tareas, 2));
    println!("marcar: {}", marcar(&mut tareas, 1));
}

