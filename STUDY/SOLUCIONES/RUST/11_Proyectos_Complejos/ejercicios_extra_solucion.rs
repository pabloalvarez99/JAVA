// ============================================
// SOLUCION EXTRA - PROYECTOS COMPLEJOS
// ============================================

#[derive(Debug, Clone)]
struct Tarea {
    id: u32,
    titulo: String,
    hecha: bool,
}

fn pendientes(tareas: &Vec<Tarea>) -> Vec<Tarea> {
    tareas.iter().filter(|t| !t.hecha).cloned().collect()
}

fn stats(tareas: &Vec<Tarea>) -> (usize, usize) {
    let hechas = tareas.iter().filter(|t| t.hecha).count();
    let pendientes = tareas.len() - hechas;
    (hechas, pendientes)
}

fn buscar_por_id(tareas: &Vec<Tarea>, id: u32) -> Option<Tarea> {
    tareas.iter().find(|t| t.id == id).cloned()
}

fn marcar_hecha(tareas: &mut Vec<Tarea>, id: u32) -> bool {
    for t in tareas.iter_mut() {
        if t.id == id {
            t.hecha = true;
            return true;
        }
    }
    false
}

fn next_id(tareas: &Vec<Tarea>) -> u32 {
    tareas.iter().map(|t| t.id).max().unwrap_or(0) + 1
}

fn agregar_tarea(tareas: &mut Vec<Tarea>, titulo: &str) -> u32 {
    let id = next_id(tareas);
    tareas.push(Tarea { id, titulo: titulo.to_string(), hecha: false });
    id
}

fn titulos_pendientes(tareas: &Vec<Tarea>) -> Vec<String> {
    tareas.iter().filter(|t| !t.hecha).map(|t| t.titulo.clone()).collect()
}


fn eliminar_tarea(tareas: &mut Vec<Tarea>, id: u32) -> bool {
    if let Some(idx) = tareas.iter().position(|t| t.id == id) {
        tareas.remove(idx);
        return true;
    }
    false
}

fn resumen_texto(tareas: &Vec<Tarea>) -> String {
    let (hechas, pendientes) = stats(tareas);
    format!("total: {}, hechas: {}, pendientes: {}", tareas.len(), hechas, pendientes)
}

fn main() {
    let tareas = vec![
        Tarea { id: 1, titulo: "leer".to_string(), hecha: true },
        Tarea { id: 2, titulo: "escribir".to_string(), hecha: false },
    ];
    println!("pendientes: {:?}", pendientes(&tareas));
    println!("stats: {:?}", stats(&tareas));
}

