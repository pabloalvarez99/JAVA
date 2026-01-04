// ============================================
// EJERCICIOS EXTRA - PROYECTOS COMPLEJOS
// ============================================

#[derive(Debug, Clone)]
struct Tarea {
    id: u32,
    titulo: String,
    hecha: bool,
}

fn pendientes(tareas: &Vec<Tarea>) -> Vec<Tarea> {
    // TODO: filtra tareas no hechas
    Vec::new()
}

fn stats(tareas: &Vec<Tarea>) -> (usize, usize) {
    // TODO: retorna (hechas, pendientes)
    (0, 0)
}

fn buscar_por_id(tareas: &Vec<Tarea>, id: u32) -> Option<Tarea> {
    // TODO: retorna tarea clonada por id
    None
}

fn marcar_hecha(tareas: &mut Vec<Tarea>, id: u32) -> bool {
    // TODO: marca hecha y retorna True/False
    false
}

fn next_id(tareas: &Vec<Tarea>) -> u32 {
    // TODO: retorna siguiente id
    1
}

fn agregar_tarea(tareas: &mut Vec<Tarea>, titulo: &str) -> u32 {
    // TODO: agrega tarea con id nuevo y retorna id
    0
}

fn titulos_pendientes(tareas: &Vec<Tarea>) -> Vec<String> {
    // TODO: retorna titulos de pendientes
    Vec::new()
}


fn eliminar_tarea(tareas: &mut Vec<Tarea>, id: u32) -> bool {
    // TODO: elimina tarea por id
    false
}

fn resumen_texto(tareas: &Vec<Tarea>) -> String {
    // TODO: retorna resumen en texto
    String::new()
}

fn main() {
    let tareas = vec![
        Tarea { id: 1, titulo: "leer".to_string(), hecha: true },
        Tarea { id: 2, titulo: "escribir".to_string(), hecha: false },
    ];
    println!("pendientes: {:?}", pendientes(&tareas));
    println!("stats: {:?}", stats(&tareas));
}

