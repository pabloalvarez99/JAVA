// ============================================
// EJERCICIO 07: STRINGS
// ============================================
// Dificultad: ***
// Tiempo estimado: 25-30 minutos
// Tema: String, &str, push_str, format!
// ============================================

/*
OBJETIVO:
Practicar operaciones basicas con String y &str.

CONCEPTOS CLAVE:
- String (propietario) vs &str (slice)
- push_str y push
- format! para construir strings
- len() y chars().count()

INSTRUCCIONES:
1. Crea un String a partir de un &str
2. Agrega texto usando push_str
3. Combina strings usando format!
4. Calcula longitud en bytes y en chars
5. Convierte a mayusculas

SALIDA ESPERADA:
Original: Rust
Extendida: Rust es genial
Combinada: Hola, Rust es genial!
Longitud bytes: 14
Cantidad chars: 14
Mayusculas: RUST ES GENIAL
*/

fn main() {
    // TODO 1: Crea un String base
    // let original = "Rust";
    // let mut texto = String::from(original);

    // TODO 2: Agrega texto
    // texto.push_str(" es genial");

    // TODO 3: Combina usando format!
    // let combinado = format!("Hola, {}!", texto);

    // TODO 4: Calcula longitudes
    // let longitud_bytes = texto.len();
    // let longitud_chars = texto.chars().count();

    // TODO 5: Mayusculas
    // let mayus = texto.to_uppercase();

    // println!("Original: {}", original);
    // println!("Extendida: {}", texto);
    // println!("Combinada: {}", combinado);
    // println!("Longitud bytes: {}", longitud_bytes);
    // println!("Cantidad chars: {}", longitud_chars);
    // println!("Mayusculas: {}", mayus);

    println!("Completa los TODOs!");
}

// ============================================
// BONUS
// ============================================
// 1. Agrega un caracter con push('!').
// 2. Crea un String vacio y construyelo con pushes.
// 3. Explora la diferencia entre len() y chars().count().

// ============================================
// SOLUCION
// ============================================
/*
fn main() {
    let original = "Rust";
    let mut texto = String::from(original);
    texto.push_str(" es genial");
    let combinado = format!("Hola, {}!", texto);
    let longitud_bytes = texto.len();
    let longitud_chars = texto.chars().count();
    let mayus = texto.to_uppercase();

    println!("Original: {}", original);
    println!("Extendida: {}", texto);
    println!("Combinada: {}", combinado);
    println!("Longitud bytes: {}", longitud_bytes);
    println!("Cantidad chars: {}", longitud_chars);
    println!("Mayusculas: {}", mayus);
}
*/
