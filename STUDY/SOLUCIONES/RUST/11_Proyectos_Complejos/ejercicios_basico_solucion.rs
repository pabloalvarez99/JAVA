// ============================================
// SOLUCION BASICO - PROYECTOS COMPLEJOS
// ============================================

#[derive(Debug)]
struct Tarea {
    id: u32,
    titulo: String,
}

fn agregar(tareas: &mut Vec<Tarea>, titulo: &str) {
    let id = (tareas.len() as u32) + 1;
    tareas.push(Tarea { id, titulo: titulo.to_string() });
}


fn listar_ids(tareas: &Vec<Tarea>) -> Vec<u32> {
    tareas.iter().map(|t| t.id).collect()
}

fn main() {
    let mut tareas = Vec::new();
    agregar(&mut tareas, "leer");
    println!("tareas: {:?}", tareas);
}

