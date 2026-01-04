// ============================================
// SOLUCION - PROYECTOS COMPLEJOS
// ============================================

#[derive(Debug, Clone)]
struct Tarea {
    id: u32,
    titulo: String,
    hecha: bool,
}

fn agregar(tareas: &mut Vec<Tarea>, titulo: &str) {
    let id = (tareas.len() as u32) + 1;
    tareas.push(Tarea { id, titulo: titulo.to_string(), hecha: false });
}

fn completar(tareas: &mut Vec<Tarea>, id: u32) -> bool {
    for t in tareas.iter_mut() {
        if t.id == id {
            t.hecha = true;
            return true;
        }
    }
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
