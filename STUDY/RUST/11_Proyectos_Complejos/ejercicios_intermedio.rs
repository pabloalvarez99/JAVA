// ============================================
// EJERCICIOS INTERMEDIO - PROYECTOS COMPLEJOS
// ============================================

#[derive(Debug)]
struct Tarea {
    id: u32,
    hecha: bool,
}

fn stats(tareas: &Vec<Tarea>) -> (usize, usize) {
    // TODO: retorna (hechas, pendientes)
    (0, 0)
}


fn pendientes(tareas: &Vec<Tarea>) -> Vec<u32> {
    // TODO: retorna ids pendientes
    Vec::new()
}

fn main() {
    let tareas = vec![
        Tarea { id: 1, hecha: true },
        Tarea { id: 2, hecha: false },
    ];
    println!("stats: {:?}", stats(&tareas));
}

