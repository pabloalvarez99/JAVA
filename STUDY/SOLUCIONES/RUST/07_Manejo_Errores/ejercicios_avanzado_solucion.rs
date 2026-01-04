// ============================================
// SOLUCION AVANZADO - MANEJO DE ERRORES
// ============================================

use std::fs::File;
use std::io::{self, Read};

fn read_file(path: &str) -> Result<String, io::Error> {
    let mut f = File::open(path)?;
    let mut buf = String::new();
    f.read_to_string(&mut buf)?;
    Ok(buf)
}


fn read_file_len(path: &str) -> Result<usize, io::Error> {
    let contenido = read_file(path)?;
    Ok(contenido.len())
}

fn main() {
    println!("file: {:?}", read_file("no_existe.txt"));
}

