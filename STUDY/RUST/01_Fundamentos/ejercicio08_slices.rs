// ============================================
// EJERCICIO 08: SLICES
// ============================================
// Dificultad: ***
// Tiempo estimado: 25-30 minutos
// Tema: slices de arrays y strings
// ============================================

/*
OBJETIVO:
Practicar el uso de slices en arrays y strings.

CONCEPTOS CLAVE:
- &[T] para slices de arrays
- &str como slice de String
- Pasar slices a funciones

INSTRUCCIONES:
1. Crea un array y toma un slice del medio
2. Implementa una funcion que sume un slice de i32
3. Toma un slice de una palabra

SALIDA ESPERADA:
Slice array: [20, 30, 40]
Suma slice: 90
Palabra: Rust
*/

fn sumar_slice(numeros: &[i32]) -> i32 {
    // TODO: Suma todos los elementos del slice
    // let mut total = 0;
    // for n in numeros {
    //     total += n;
    // }
    // total
    0
}

fn main() {
    // TODO 1: Crea array y slice
    // let numeros = [10, 20, 30, 40, 50];
    // let parte = &numeros[1..4];

    // TODO 2: Usa la funcion sumar_slice
    // let suma = sumar_slice(parte);

    // TODO 3: Slice de string
    // let palabra = "Rustacean";
    // let sub = &palabra[0..4];

    // println!("Slice array: {:?}", parte);
    // println!("Suma slice: {}", suma);
    // println!("Palabra: {}", sub);

    println!("Completa los TODOs!");
}

// ============================================
// BONUS
// ============================================
// 1. Toma un slice desde el inicio hasta el final.
// 2. Crea una funcion que reciba &str y devuelva el primer caracter.
// 3. Experimenta con slices vacios.

// ============================================
// SOLUCION
// ============================================
/*
fn sumar_slice(numeros: &[i32]) -> i32 {
    let mut total = 0;
    for n in numeros {
        total += n;
    }
    total
}

fn main() {
    let numeros = [10, 20, 30, 40, 50];
    let parte = &numeros[1..4];
    let suma = sumar_slice(parte);
    let palabra = "Rustacean";
    let sub = &palabra[0..4];

    println!("Slice array: {:?}", parte);
    println!("Suma slice: {}", suma);
    println!("Palabra: {}", sub);
}
*/
