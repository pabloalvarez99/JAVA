// ============================================
// EJERCICIO 06: LOOPS
// ============================================
// Dificultad: ***
// Tiempo estimado: 25-30 minutos
// Tema: loop, while, for, break, continue
// ============================================

/*
OBJETIVO:
Practicar los tres tipos de bucles en Rust.

CONCEPTOS CLAVE:
- loop (bucle infinito con break)
- while (condicion)
- for (iterar rangos y colecciones)
- break y continue

INSTRUCCIONES:
1. Usa loop para contar del 1 al 5
2. Usa while para sumar los numeros del 1 al 5
3. Usa for para sumar un array del 1 al 10
4. Usa for + continue para imprimir solo pares hasta 10

SALIDA ESPERADA:
Loop contador: 1 2 3 4 5
Suma con while: 15
Suma array: 55
Pares hasta 10: 2 4 6 8 10
*/

fn main() {
    // TODO 1: loop para contar del 1 al 5
    // let mut contador = 1;
    // let mut lista = Vec::new();
    // loop {
    //     lista.push(contador.to_string());
    //     if contador == 5 {
    //         break;
    //     }
    //     contador += 1;
    // }
    // let texto = lista.join(" ");
    // println!("Loop contador: {}", texto);

    // TODO 2: while para sumar 1..=5
    // let mut n = 1;
    // let mut suma = 0;
    // while n <= 5 {
    //     suma += n;
    //     n += 1;
    // }
    // println!("Suma con while: {}", suma);

    // TODO 3: for para sumar un array 1..=10
    // let numeros = [1, 2, 3, 4, 5, 6, 7, 8, 9, 10];
    // let mut suma_array = 0;
    // for valor in numeros {
    //     suma_array += valor;
    // }
    // println!("Suma array: {}", suma_array);

    // TODO 4: for + continue para pares
    // let mut pares = Vec::new();
    // for valor in 1..=10 {
    //     if valor % 2 != 0 {
    //         continue;
    //     }
    //     pares.push(valor.to_string());
    // }
    // println!("Pares hasta 10: {}", pares.join(" "));

    println!("Completa los TODOs!");
}

// ============================================
// BONUS
// ============================================
// 1. Usa break con valor para salir de un loop y devolver un resultado.
// 2. Crea un bucle que encuentre el primer multiplo de 7.
// 3. Repite el ejercicio con un rango 1..=100.

// ============================================
// SOLUCION
// ============================================
/*
fn main() {
    let mut contador = 1;
    let mut lista = Vec::new();
    loop {
        lista.push(contador.to_string());
        if contador == 5 {
            break;
        }
        contador += 1;
    }
    let texto = lista.join(" ");
    println!("Loop contador: {}", texto);

    let mut n = 1;
    let mut suma = 0;
    while n <= 5 {
        suma += n;
        n += 1;
    }
    println!("Suma con while: {}", suma);

    let numeros = [1, 2, 3, 4, 5, 6, 7, 8, 9, 10];
    let mut suma_array = 0;
    for valor in numeros {
        suma_array += valor;
    }
    println!("Suma array: {}", suma_array);

    let mut pares = Vec::new();
    for valor in 1..=10 {
        if valor % 2 != 0 {
            continue;
        }
        pares.push(valor.to_string());
    }
    println!("Pares hasta 10: {}", pares.join(" "));
}
*/
