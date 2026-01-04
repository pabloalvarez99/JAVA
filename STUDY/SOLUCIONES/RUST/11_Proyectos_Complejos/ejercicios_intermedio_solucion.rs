// ============================================
// SOLUCION INTERMEDIO - PROYECTOS COMPLEJOS
// ============================================

#[derive(Debug)]
struct Tarea {
    id: u32,
    hecha: bool,
}

fn stats(tareas: &Vec<Tarea>) -> (usize, usize) {
    let hechas = tareas.iter().filter(|t| t.hecha).count();
    let pendientes = tareas.len() - hechas;
    (hechas, pendientes)
}


fn pendientes(tareas: &Vec<Tarea>) -> Vec<u32> {
    tareas.iter().filter(|t| !t.hecha).map(|t| t.id).collect()
}

fn main() {
    let tareas = vec![
        Tarea { id: 1, hecha: true },
        Tarea { id: 2, hecha: false },
    ];
    println!("stats: {:?}", stats(&tareas));
}

