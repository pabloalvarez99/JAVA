// ============================================
// EJERCICIO 05: CONTROL DE FLUJO
// ============================================
// Dificultad: **
// Tiempo estimado: 20-25 minutos
// Tema: if/else, comparaciones, logica booleana
// ============================================

/*
OBJETIVO:
Practicar condicionales y logica booleana en Rust.

CONCEPTOS CLAVE:
- if / else if / else
- Operadores de comparacion: ==, !=, <, >, <=, >=
- Operadores logicos: &&, ||, !
- if como expresion para asignar valores

INSTRUCCIONES:
1. Declara `edad` y determina si es adulto (>= 18)
2. Declara `temperatura` y clasifica el clima
3. Usa if como expresion para crear `mensaje_edad`
4. Determina si un numero es par
5. Verifica si un valor esta en el rango 1..=10

SALIDA ESPERADA:
Edad: 20
Adulto: true
Clima: Templado
Mensaje edad: Mayor de edad
Numero 42 es par: true
En rango (1..=10): false
*/

fn main() {
    // TODO 1: Declara edad y determina si es adulto
    // let edad: i32 = 20;
    // let es_adulto = edad >= 18;

    // TODO 2: Clasifica temperatura en "Frio", "Templado", "Calor"
    // let temperatura: i32 = 18;
    // let clima = if temperatura < 10 {
    //     "Frio"
    // } else if temperatura < 25 {
    //     "Templado"
    // } else {
    //     "Calor"
    // };

    // TODO 3: Usa if como expresion para crear mensaje_edad
    // let mensaje_edad = if es_adulto { "Mayor de edad" } else { "Menor de edad" };

    // TODO 4: Determina si un numero es par
    // let numero: i32 = 42;
    // let es_par = numero % 2 == 0;

    // TODO 5: Verifica si un valor esta en rango 1..=10
    // let valor: i32 = 15;
    // let en_rango = valor >= 1 && valor <= 10;

    // println!("Edad: {}", edad);
    // println!("Adulto: {}", es_adulto);
    // println!("Clima: {}", clima);
    // println!("Mensaje edad: {}", mensaje_edad);
    // println!("Numero {} es par: {}", numero, es_par);
    // println!("En rango (1..=10): {}", en_rango);

    println!("Completa los TODOs!");
}

// ============================================
// BONUS
// ============================================
// 1. Agrega un caso para temperatura bajo cero.
// 2. Crea una variable `tiene_permiso` y combinala con `es_adulto`.
// 3. Usa el operador ! para invertir una condicion.

// ============================================
// SOLUCION
// ============================================
/*
fn main() {
    let edad: i32 = 20;
    let es_adulto = edad >= 18;

    let temperatura: i32 = 18;
    let clima = if temperatura < 10 {
        "Frio"
    } else if temperatura < 25 {
        "Templado"
    } else {
        "Calor"
    };

    let mensaje_edad = if es_adulto { "Mayor de edad" } else { "Menor de edad" };

    let numero: i32 = 42;
    let es_par = numero % 2 == 0;

    let valor: i32 = 15;
    let en_rango = valor >= 1 && valor <= 10;

    println!("Edad: {}", edad);
    println!("Adulto: {}", es_adulto);
    println!("Clima: {}", clima);
    println!("Mensaje edad: {}", mensaje_edad);
    println!("Numero {} es par: {}", numero, es_par);
    println!("En rango (1..=10): {}", en_rango);
}
*/
