// ============================================
// EJERCICIO 04: FUNCIONES Y EXPRESIONES
// ============================================
// Dificultad: **
// Tiempo estimado: 20-25 minutos
// Tema: Funciones, parametros, retorno, expresiones vs statements
// ============================================

/*
OBJETIVO:
Aprender a definir y usar funciones en Rust, y entender
la diferencia entre expresiones y statements.

CONCEPTOS CLAVE:
- fn para definir funciones
- Parametros con tipo explicito
- Tipo de retorno despues de ->
- La ultima expresion (sin ;) es el valor de retorno
- return explicito es opcional

DIFERENCIA IMPORTANTE:
- Statement: realiza accion, NO retorna valor (termina con ;)
- Expresion: evalua a un valor (NO termina con ;)

INSTRUCCIONES:
1. Crea una funcion que sume dos numeros
2. Crea una funcion que calcule el area de un rectangulo
3. Crea una funcion que retorne true si un numero es par
4. Crea una funcion que use expresiones como retorno
5. Crea una funcion que no retorne nada (unit type)

SALIDA ESPERADA:
5 + 3 = 8
Area del rectangulo: 50
Es 4 par? true
Es 7 par? false
El mayor entre 10 y 20 es: 20
Saludando...
Hola, Rust!
*/

fn main() {
    // Prueba las funciones aqui

    // TODO: Llama a sumar(5, 3)
    // let resultado = sumar(5, 3);
    // println!("5 + 3 = {}", resultado);

    // TODO: Llama a area_rectangulo(10, 5)
    // let area = area_rectangulo(10, 5);
    // println!("Area del rectangulo: {}", area);

    // TODO: Llama a es_par con diferentes numeros
    // println!("Es 4 par? {}", es_par(4));
    // println!("Es 7 par? {}", es_par(7));

    // TODO: Llama a mayor(10, 20)
    // println!("El mayor entre 10 y 20 es: {}", mayor(10, 20));

    // TODO: Llama a saludar("Rust")
    // println!("Saludando...");
    // saludar("Rust");

    println!("Completa los TODOs y define las funciones!");
}

// TODO 1: Define una funcion que sume dos i32 y retorne i32
// fn sumar(a: i32, b: i32) -> i32 {
//     ...
// }

// TODO 2: Define una funcion que calcule el area de un rectangulo
// fn area_rectangulo(base: i32, altura: i32) -> i32 {
//     ...
// }

// TODO 3: Define una funcion que retorne true si el numero es par
// fn es_par(numero: i32) -> bool {
//     ...
// }

// TODO 4: Define una funcion que retorne el mayor de dos numeros
// Usa una expresion if como valor de retorno (sin return explicito)
// fn mayor(a: i32, b: i32) -> i32 {
//     if a > b {
//         a  // sin punto y coma = expresion que retorna
//     } else {
//         b
//     }
// }

// TODO 5: Define una funcion que imprima un saludo (no retorna nada)
// fn saludar(nombre: &str) {
//     ...
// }

// ============================================
// BONUS
// ============================================
// 1. Que pasa si pones ; al final de la expresion de retorno?
// 2. Puedes usar return explicito? Cuando es util?
// 3. Que es el tipo de retorno "()" (unit)?

// ============================================
// SOLUCION
// ============================================
/*
fn main() {
    let resultado = sumar(5, 3);
    println!("5 + 3 = {}", resultado);

    let area = area_rectangulo(10, 5);
    println!("Area del rectangulo: {}", area);

    println!("Es 4 par? {}", es_par(4));
    println!("Es 7 par? {}", es_par(7));

    println!("El mayor entre 10 y 20 es: {}", mayor(10, 20));

    println!("Saludando...");
    saludar("Rust");
}

fn sumar(a: i32, b: i32) -> i32 {
    a + b  // expresion - retorna el valor
}

fn area_rectangulo(base: i32, altura: i32) -> i32 {
    base * altura
}

fn es_par(numero: i32) -> bool {
    numero % 2 == 0
}

fn mayor(a: i32, b: i32) -> i32 {
    if a > b {
        a
    } else {
        b
    }
}

fn saludar(nombre: &str) {
    println!("Hola, {}!", nombre);
}
*/
