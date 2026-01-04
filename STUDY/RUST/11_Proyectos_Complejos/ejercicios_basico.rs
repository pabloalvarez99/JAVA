// ============================================
// EJERCICIOS BASICO - PROYECTOS COMPLEJOS
// ============================================

#[derive(Debug)]
struct Tarea {
    id: u32,
    titulo: String,
}

fn agregar(tareas: &mut Vec<Tarea>, titulo: &str) {
    // TODO: agrega tarea con id incremental
}


fn listar_ids(tareas: &Vec<Tarea>) -> Vec<u32> {
    // TODO: retorna ids
    Vec::new()
}

fn main() {
    let mut tareas = Vec::new();
    agregar(&mut tareas, "leer");
    println!("tareas: {:?}", tareas);
}

