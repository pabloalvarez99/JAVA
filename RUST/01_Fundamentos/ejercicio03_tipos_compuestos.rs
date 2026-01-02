// ============================================
// EJERCICIO 03: TIPOS COMPUESTOS
// ============================================
// Dificultad: **
// Tiempo estimado: 20-25 minutos
// Tema: Tuplas y Arrays
// ============================================

/*
OBJETIVO:
Aprender a usar tuplas y arrays, los dos tipos compuestos
primitivos de Rust.

CONCEPTOS:
- Tupla: agrupa valores de DIFERENTES tipos, tamano fijo
- Array: agrupa valores del MISMO tipo, tamano fijo

INSTRUCCIONES:
1. Crea una tupla con diferentes tipos de datos
2. Accede a elementos de la tupla por indice y destructuring
3. Crea un array de enteros
4. Itera sobre el array
5. Crea un array con valores repetidos

SALIDA ESPERADA:
Tupla completa: (42, 3.14, true)
Primer elemento: 42
Destructuring - x: 42, y: 3.14, z: true
Array: [1, 2, 3, 4, 5]
Primer elemento del array: 1
Ultimo elemento: 5
Longitud del array: 5
Array de ceros: [0, 0, 0, 0, 0, 0, 0, 0, 0, 0]
*/

fn main() {
    // ========== TUPLAS ==========

    // TODO 1: Crea una tupla con un i32, un f64 y un bool
    // let mi_tupla: (i32, f64, bool) = ...;

    // TODO 2: Accede al primer elemento usando .0
    // let primer_elemento = mi_tupla.0;

    // TODO 3: Usa destructuring para extraer todos los valores
    // let (x, y, z) = mi_tupla;

    // ========== ARRAYS ==========

    // TODO 4: Crea un array de 5 enteros
    // let numeros: [i32; 5] = [1, 2, 3, 4, 5];

    // TODO 5: Accede a elementos por indice
    // let primero = numeros[0];
    // let ultimo = numeros[4];  // o numeros[numeros.len() - 1]

    // TODO 6: Obtener la longitud del array
    // let longitud = numeros.len();

    // TODO 7: Crea un array de 10 ceros usando la sintaxis [valor; cantidad]
    // let ceros: [i32; 10] = [0; 10];

    // TODO 8: Itera sobre el array e imprime cada elemento
    // for numero in numeros.iter() {
    //     println!("Numero: {}", numero);
    // }

    println!("Completa los TODOs!");
}

// ============================================
// BONUS
// ============================================
// 1. Que pasa si accedes a un indice fuera de rango?
// 2. Puedes modificar un elemento de un array inmutable?
// 3. Cual es el tipo de una tupla vacia ()? (se llama "unit")

// ============================================
// SOLUCION
// ============================================
/*
fn main() {
    // Tuplas
    let mi_tupla: (i32, f64, bool) = (42, 3.14, true);
    let primer_elemento = mi_tupla.0;
    let (x, y, z) = mi_tupla;

    println!("Tupla completa: ({}, {}, {})", mi_tupla.0, mi_tupla.1, mi_tupla.2);
    println!("Primer elemento: {}", primer_elemento);
    println!("Destructuring - x: {}, y: {}, z: {}", x, y, z);

    // Arrays
    let numeros: [i32; 5] = [1, 2, 3, 4, 5];
    let primero = numeros[0];
    let ultimo = numeros[4];
    let longitud = numeros.len();
    let ceros: [i32; 10] = [0; 10];

    println!("Array: {:?}", numeros);
    println!("Primer elemento del array: {}", primero);
    println!("Ultimo elemento: {}", ultimo);
    println!("Longitud del array: {}", longitud);
    println!("Array de ceros: {:?}", ceros);

    println!("\nIterando sobre el array:");
    for numero in numeros.iter() {
        println!("  Numero: {}", numero);
    }
}
*/
