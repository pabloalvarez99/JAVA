// ============================================
// EJERCICIOS AVANZADO - MANEJO DE ERRORES
// ============================================

use std::fs::File;
use std::io::{self, Read};

fn read_file(path: &str) -> Result<String, io::Error> {
    // TODO: usa ?
    Ok(String::new())
}


fn read_file_len(path: &str) -> Result<usize, io::Error> {
    // TODO: retorna longitud del archivo
    Ok(0)
}

fn main() {
    println!("file: {:?}", read_file("no_existe.txt"));
}

