/**
 * EJERCICIO STRING #2: ContarVocales
 * Dificultad: ⭐
 *
 * PROBLEMA:
 * Contar el numero de vocales (a, e, i, o, u) en un string.
 * Debe funcionar con mayusculas y minusculas.
 *
 * EJEMPLOS:
 * "Hola Mundo"    -> 4 (o, a, u, o)
 * "AEIOU"         -> 5
 * "xyz"           -> 0
 * "Programacion"  -> 5 (o, a, a, i, o)
 *
 * PISTAS:
 * 1. Convierte a minusculas para simplificar
 * 2. Usa un Set o String con las vocales
 * 3. Recorre caracter por caracter
 *
 * METODOS UTILES:
 * - String.toLowerCase()
 * - String.toCharArray()
 * - String.indexOf(char)
 */

public class String02_ContarVocales {
    public static void main(String[] args) {
        // Casos de prueba
        System.out.println(contarVocales("Hola Mundo"));    // Esperado: 4
        System.out.println(contarVocales("AEIOU"));         // Esperado: 5
        System.out.println(contarVocales("xyz"));           // Esperado: 0
        System.out.println(contarVocales("Programacion"));  // Esperado: 5
        System.out.println(contarVocales(""));              // Esperado: 0

        // Bonus: Tambien contar cada vocal individualmente
        System.out.println("\n=== Conteo detallado ===");
        contarVocalesDetallado("Programacion");
    }

    public static int contarVocales(String texto) {
        // TODO: Implementar
        // 1. Manejar null/vacio
        // 2. Convertir a minusculas
        // 3. Recorrer y contar vocales

        return 0; // Placeholder
    }

    public static void contarVocalesDetallado(String texto) {
        // TODO: Implementar (bonus)
        // Imprimir cuantas de cada vocal hay
        // Ejemplo: "a: 2, e: 0, i: 1, o: 2, u: 0"
    }
}

/*
 * ============================================
 * SOLUCION (NO MIRAR ANTES DE INTENTAR):
 * ============================================
 *
 * public static int contarVocales(String texto) {
 *     if (texto == null || texto.isEmpty()) {
 *         return 0;
 *     }
 *
 *     String vocales = "aeiou";
 *     int contador = 0;
 *
 *     for (char c : texto.toLowerCase().toCharArray()) {
 *         if (vocales.indexOf(c) != -1) {
 *             contador++;
 *         }
 *     }
 *
 *     return contador;
 * }
 *
 * // Alternativa con Set:
 * public static int contarVocales2(String texto) {
 *     if (texto == null) return 0;
 *
 *     Set<Character> vocales = Set.of('a', 'e', 'i', 'o', 'u');
 *     return (int) texto.toLowerCase().chars()
 *         .filter(c -> vocales.contains((char) c))
 *         .count();
 * }
 *
 * public static void contarVocalesDetallado(String texto) {
 *     String lower = texto.toLowerCase();
 *     System.out.println("a: " + contarCaracter(lower, 'a'));
 *     System.out.println("e: " + contarCaracter(lower, 'e'));
 *     System.out.println("i: " + contarCaracter(lower, 'i'));
 *     System.out.println("o: " + contarCaracter(lower, 'o'));
 *     System.out.println("u: " + contarCaracter(lower, 'u'));
 * }
 *
 * private static long contarCaracter(String s, char c) {
 *     return s.chars().filter(ch -> ch == c).count();
 * }
 *
 * COMPLEJIDAD:
 * - Tiempo: O(n)
 * - Espacio: O(1)
 */
