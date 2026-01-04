// ============================================
// EJERCICIO 10: MINI PROYECTO - CALCULADORA
// ============================================
// Dificultad: ****
// Tiempo estimado: 30-40 minutos
// Tema: input, parse, match, control de flujo
// ============================================

/*
OBJETIVO:
Construir una calculadora basica que opere con dos numeros.

CONCEPTOS CLAVE:
- Lectura de entrada con stdin
- parse a f64
- match para operadores
- Validacion basica

INSTRUCCIONES:
1. Pide el primer numero
2. Pide el operador (+, -, *, /)
3. Pide el segundo numero
4. Calcula el resultado y muestralo
5. Maneja operadores invalidos

SALIDA ESPERADA (ejemplo):
Primer numero: 8
Operador: +
Segundo numero: 2
Resultado: 10
*/

use std::io::{self, Write};

fn leer_linea(mensaje: &str) -> String {
    print!("{}", mensaje);
    io::stdout().flush().unwrap();
    let mut entrada = String::new();
    io::stdin().read_line(&mut entrada).expect("Error leyendo entrada");
    entrada.trim().to_string()
}

fn main() {
    // TODO 1: Leer primer numero
    // let a_texto = leer_linea("Primer numero: ");
    // let a: f64 = a_texto.parse().expect("Numero invalido");

    // TODO 2: Leer operador
    // let operador = leer_linea("Operador (+, -, *, /): ");

    // TODO 3: Leer segundo numero
    // let b_texto = leer_linea("Segundo numero: ");
    // let b: f64 = b_texto.parse().expect("Numero invalido");

    // TODO 4: Calcular resultado con match
    // let resultado = match operador.as_str() {
    //     "+" => a + b,
    //     "-" => a - b,
    //     "*" => a * b,
    //     "/" => {
    //         if b == 0.0 {
    //             println!("Division por cero");
    //             return;
    //         }
    //         a / b
    //     }
    //     _ => {
    //         println!("Operador invalido");
    //         return;
    //     }
    // };

    // println!("Resultado: {}", resultado);

    println!("Completa los TODOs!");
}

// ============================================
// BONUS
// ============================================
// 1. Acepta espacios en la entrada y limpialos.
// 2. Permite repetir la operacion hasta que el usuario escriba "salir".
// 3. Agrega el operador de potencia (^).

// ============================================
// SOLUCION
// ============================================
/*
use std::io::{self, Write};

fn leer_linea(mensaje: &str) -> String {
    print!("{}", mensaje);
    io::stdout().flush().unwrap();
    let mut entrada = String::new();
    io::stdin().read_line(&mut entrada).expect("Error leyendo entrada");
    entrada.trim().to_string()
}

fn main() {
    let a_texto = leer_linea("Primer numero: ");
    let a: f64 = a_texto.parse().expect("Numero invalido");
    let operador = leer_linea("Operador (+, -, *, /): ");
    let b_texto = leer_linea("Segundo numero: ");
    let b: f64 = b_texto.parse().expect("Numero invalido");

    let resultado = match operador.as_str() {
        "+" => a + b,
        "-" => a - b,
        "*" => a * b,
        "/" => {
            if b == 0.0 {
                println!("Division por cero");
                return;
            }
            a / b
        }
        _ => {
            println!("Operador invalido");
            return;
        }
    };

    println!("Resultado: {}", resultado);
}
*/
