// ============================================
// EJERCICIO 02: TIPOS DE DATOS ESCALARES
// ============================================
// Dificultad: *
// Tiempo estimado: 15-20 minutos
// Tema: Enteros, flotantes, booleanos, caracteres
// ============================================

/*
OBJETIVO:
Conocer y practicar los tipos de datos escalares en Rust.

TIPOS ESCALARES:
- Enteros: i8, i16, i32, i64, i128, isize (con signo)
          u8, u16, u32, u64, u128, usize (sin signo)
- Flotantes: f32, f64
- Booleano: bool (true/false)
- Caracter: char (Unicode, 4 bytes)

INSTRUCCIONES:
1. Declara variables de cada tipo escalar
2. Realiza operaciones aritmeticas basicas
3. Experimenta con overflow (desbordamiento)
4. Usa literales numericos con separadores

SALIDA ESPERADA:
Entero i32: -42
Entero u8: 255
Flotante: 3.14159
Es verdadero: true
Caracter: R
Emoji: [cara sonriente]
Suma: 15
Division entera: 3
Division flotante: 3.5
Numero grande: 1_000_000
*/

fn main() {
    // TODO 1: Declara un entero con signo de 32 bits
    // let entero_con_signo: i32 = ...;

    // TODO 2: Declara el maximo valor de u8 (0-255)
    // let maximo_u8: u8 = ...;

    // TODO 3: Declara un flotante de 64 bits con PI
    // let pi: f64 = ...;

    // TODO 4: Declara un booleano
    // let es_rust_genial: bool = ...;

    // TODO 5: Declara un caracter (nota: usa comillas simples)
    // let letra: char = ...;

    // TODO 6: Declara un emoji (char soporta Unicode!)
    // let emoji: char = ...;

    // TODO 7: Operaciones aritmeticas
    // let suma = 10 + 5;
    // let division_entera = 7 / 2;      // Resultado: 3
    // let division_flotante = 7.0 / 2.0; // Resultado: 3.5

    // TODO 8: Usa separadores para numeros grandes (legibilidad)
    // let millon: i32 = 1_000_000;

    // Imprime los resultados
    // println!("Entero i32: {}", entero_con_signo);
    // println!("Entero u8: {}", maximo_u8);
    // ... etc

    println!("Completa los TODOs!");
}

// ============================================
// BONUS: Experimenta con estos conceptos
// ============================================
// 1. Que pasa si asignas 256 a un u8?
// 2. Cual es la diferencia entre i32 e isize?
// 3. Puedes mezclar tipos en operaciones? (ej: i32 + f64)

// ============================================
// SOLUCION
// ============================================
/*
fn main() {
    let entero_con_signo: i32 = -42;
    let maximo_u8: u8 = 255;
    let pi: f64 = 3.14159;
    let es_rust_genial: bool = true;
    let letra: char = 'R';
    let emoji: char = '😊';

    let suma = 10 + 5;
    let division_entera = 7 / 2;
    let division_flotante = 7.0 / 2.0;
    let millon: i32 = 1_000_000;

    println!("Entero i32: {}", entero_con_signo);
    println!("Entero u8: {}", maximo_u8);
    println!("Flotante: {}", pi);
    println!("Es verdadero: {}", es_rust_genial);
    println!("Caracter: {}", letra);
    println!("Emoji: {}", emoji);
    println!("Suma: {}", suma);
    println!("Division entera: {}", division_entera);
    println!("Division flotante: {}", division_flotante);
    println!("Numero grande: {}", millon);
}
*/
