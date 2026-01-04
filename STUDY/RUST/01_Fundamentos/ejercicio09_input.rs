// ============================================
// EJERCICIO 09: INPUT DEL USUARIO
// ============================================
// Dificultad: ***
// Tiempo estimado: 25-30 minutos
// Tema: stdin, read_line, parse
// ============================================

/*
OBJETIVO:
Leer datos del usuario desde la consola y procesarlos.

CONCEPTOS CLAVE:
- std::io::stdin().read_line()
- trim() para limpiar saltos de linea
- parse() para convertir strings

INSTRUCCIONES:
1. Pide el nombre del usuario y guardalo
2. Pide la edad y conviertela a numero
3. Calcula cuantos anos faltan para llegar a 100

SALIDA ESPERADA (ejemplo):
Nombre: Ana
Edad: 30
Te faltan 70 anos para 100.
*/

use std::io::{self, Write};

fn main() {
    // TODO 1: Leer nombre
    // print!("Ingresa tu nombre: ");
    // io::stdout().flush().unwrap();
    // let mut nombre = String::new();
    // io::stdin().read_line(&mut nombre).expect("Error leyendo nombre");
    // let nombre = nombre.trim();

    // TODO 2: Leer edad
    // print!("Ingresa tu edad: ");
    // io::stdout().flush().unwrap();
    // let mut edad_texto = String::new();
    // io::stdin().read_line(&mut edad_texto).expect("Error leyendo edad");
    // let edad: u32 = edad_texto.trim().parse().expect("Edad invalida");

    // TODO 3: Calcular anos para 100
    // let faltan = 100 - edad;

    // println!("Nombre: {}", nombre);
    // println!("Edad: {}", edad);
    // println!("Te faltan {} anos para 100.", faltan);

    println!("Completa los TODOs!");
}

// ============================================
// BONUS
// ============================================
// 1. Maneja el caso en que la edad no sea un numero valido.
// 2. Pide dos numeros y muestra su suma.
// 3. Convierte la edad a f64 y calcula el doble.

// ============================================
// SOLUCION
// ============================================
/*
use std::io::{self, Write};

fn main() {
    print!("Ingresa tu nombre: ");
    io::stdout().flush().unwrap();
    let mut nombre = String::new();
    io::stdin().read_line(&mut nombre).expect("Error leyendo nombre");
    let nombre = nombre.trim();

    print!("Ingresa tu edad: ");
    io::stdout().flush().unwrap();
    let mut edad_texto = String::new();
    io::stdin().read_line(&mut edad_texto).expect("Error leyendo edad");
    let edad: u32 = edad_texto.trim().parse().expect("Edad invalida");

    let faltan = 100 - edad;

    println!("Nombre: {}", nombre);
    println!("Edad: {}", edad);
    println!("Te faltan {} anos para 100.", faltan);
}
*/
