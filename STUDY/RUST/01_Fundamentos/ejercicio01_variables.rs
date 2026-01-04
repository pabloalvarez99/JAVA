// ============================================
// EJERCICIO 01: VARIABLES Y MUTABILIDAD
// ============================================
// Dificultad: *
// Tiempo estimado: 10-15 minutos
// Tema: Variables, mut, const, shadowing
// ============================================

/*
OBJETIVO:
Entender como funcionan las variables en Rust y la diferencia
entre variables inmutables, mutables y constantes.

CONCEPTOS CLAVE:
- En Rust, las variables son INMUTABLES por defecto
- Usar `mut` para hacer una variable mutable
- `const` para constantes (siempre inmutables, tipo requerido)
- Shadowing: redeclarar una variable con el mismo nombre

INSTRUCCIONES:
1. Declara una variable inmutable `nombre` con tu nombre
2. Declara una variable mutable `edad` con tu edad
3. Incrementa `edad` en 1
4. Declara una constante `ANIO_ACTUAL` con el valor 2025
5. Usa shadowing para cambiar el tipo de una variable

SALIDA ESPERADA:
Nombre: [tu nombre]
Edad actual: [tu edad]
Edad siguiente: [tu edad + 1]
Anio: 2025
Numero como string: 42
*/

fn main() {
    // TODO 1: Declara una variable inmutable con tu nombre
    // let nombre = ...;

    // TODO 2: Declara una variable mutable con tu edad
    // let mut edad = ...;

    // TODO 3: Incrementa edad en 1
    // edad = ...;

    // TODO 4: Declara una constante para el anio actual
    // const ANIO_ACTUAL: i32 = ...;

    // TODO 5: Shadowing - declara `numero` como i32, luego como String
    // let numero = 42;
    // let numero = numero.to_string();

    // Imprime los resultados
    // println!("Nombre: {}", nombre);
    // println!("Edad actual: {}", edad - 1);
    // println!("Edad siguiente: {}", edad);
    // println!("Anio: {}", ANIO_ACTUAL);
    // println!("Numero como string: {}", numero);

    println!("Completa los TODOs y descomenta el codigo!");
}

// ============================================
// BONUS: Intenta lo siguiente
// ============================================
// 1. Que pasa si intentas cambiar una variable inmutable?
// 2. Que pasa si declaras una constante sin tipo?
// 3. Puedes hacer shadowing con un tipo diferente?

// ============================================
// SOLUCION (no mirar hasta intentarlo!)
// ============================================
/*
fn main() {
    let nombre = "Pablo";
    let mut edad = 25;
    edad = edad + 1;
    const ANIO_ACTUAL: i32 = 2025;
    let numero = 42;
    let numero = numero.to_string();

    println!("Nombre: {}", nombre);
    println!("Edad actual: {}", edad - 1);
    println!("Edad siguiente: {}", edad);
    println!("Anio: {}", ANIO_ACTUAL);
    println!("Numero como string: {}", numero);
}
*/
