// ============================================
// SOLUCION - INTEGRACION - PROYECTOS COMPLEJOS
// ============================================
#[derive(Debug, Clone)]
struct Tarea {
    id: u32,
    titulo: String,
    hecha: bool,
}

fn buscar(tareas: &[Tarea], id: u32) -> Option<Tarea> {
    tareas.iter().find(|t| t.id == id).cloned()
}

fn marcar(tareas: &mut Vec<Tarea>, id: u32) -> bool {
    for t in tareas.iter_mut() {
        if t.id == id {
            t.hecha = true;
            return true;
        }
    }
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

