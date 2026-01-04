// ============================================
// EJERCICIOS - PROYECTOS COMPLEJOS
// ============================================

/*
OBJETIVO:
Construir un mini gestor de tareas en memoria.
*/

#[derive(Debug, Clone)]
struct Tarea {
    id: u32,
    titulo: String,
    hecha: bool,
}

fn agregar(tareas: &mut Vec<Tarea>, titulo: &str) {
    // TODO: agrega nueva tarea con id incremental
}

fn completar(tareas: &mut Vec<Tarea>, id: u32) -> bool {
    // TODO: marca la tarea como hecha
    false
}

fn listar(tareas: &Vec<Tarea>) {
    for t in tareas {
        println!("{} {} {}", t.id, t.titulo, t.hecha);
    }
}

fn main() {
    let mut tareas = Vec::new();
    agregar(&mut tareas, "leer");
    agregar(&mut tareas, "escribir");
    completar(&mut tareas, 1);
    listar(&tareas);
}
