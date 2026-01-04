// ============================================
// SOLUCION AVANZADO - PROYECTOS COMPLEJOS
// ============================================

#[derive(Debug, Clone)]
struct Tarea {
    id: u32,
    titulo: String,
}

fn buscar(tareas: &Vec<Tarea>, id: u32) -> Option<Tarea> {
    tareas.iter().find(|t| t.id == id).cloned()
}


fn titulos(tareas: &Vec<Tarea>) -> Vec<String> {
    tareas.iter().map(|t| t.titulo.clone()).collect()
}

fn main() {
    let tareas = vec![
        Tarea { id: 1, titulo: "leer".to_string() },
        Tarea { id: 2, titulo: "escribir".to_string() },
    ];
    println!("buscar: {:?}", buscar(&tareas, 2));
}

