// ============================================
// EJERCICIOS AVANZADO - PROYECTOS COMPLEJOS
// ============================================

#[derive(Debug)]
struct Tarea {
    id: u32,
    titulo: String,
}

fn buscar(tareas: &Vec<Tarea>, id: u32) -> Option<Tarea> {
    // TODO: retorna tarea por id
    None
}


fn titulos(tareas: &Vec<Tarea>) -> Vec<String> {
    // TODO: retorna titulos
    Vec::new()
}

fn main() {
    let tareas = vec![
        Tarea { id: 1, titulo: "leer".to_string() },
        Tarea { id: 2, titulo: "escribir".to_string() },
    ];
    println!("buscar: {:?}", buscar(&tareas, 2));
}

