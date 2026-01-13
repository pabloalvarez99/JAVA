/**
 * EJERCICIO STRING #3: Palindromo
 * Dificultad: ⭐⭐
 *
 * PROBLEMA:
 * Determinar si un string es palindromo (se lee igual al reves).
 * Ignorar espacios, puntuacion y mayusculas/minusculas.
 *
 * EJEMPLOS:
 * "ana"                    -> true
 * "Anita lava la tina"     -> true
 * "A man a plan a canal Panama" -> true
 * "hello"                  -> false
 * "race car"               -> true (ignorando espacio)
 *
 * PISTAS:
 * 1. Limpia el string: solo letras, en minuscula
 * 2. Tecnica two-pointer: compara inicio con final
 * 3. O invierte y compara
 *
 * METODOS UTILES:
 * - Character.isLetterOrDigit(c)
 * - Character.toLowerCase(c)
 * - StringBuilder.reverse()
 */

public class String03_Palindromo {
    public static void main(String[] args) {
        // Casos de prueba
        System.out.println(esPalindromo("ana"));                          // true
        System.out.println(esPalindromo("Anita lava la tina"));           // true
        System.out.println(esPalindromo("A man a plan a canal Panama"));  // true
        System.out.println(esPalindromo("hello"));                        // false
        System.out.println(esPalindromo("race car"));                     // true
        System.out.println(esPalindromo("Was it a car or a cat I saw?")); // true
        System.out.println(esPalindromo(""));                             // true (vacio es palindromo)
    }

    public static boolean esPalindromo(String texto) {
        // TODO: Implementar usando two-pointer
        // 1. Limpiar: solo letras/digitos, en minuscula
        // 2. Comparar desde los extremos hacia el centro

        return false; // Placeholder
    }

    // Metodo alternativo usando reverse
    public static boolean esPalindromoReverse(String texto) {
        // TODO: Implementar usando StringBuilder.reverse()

        return false; // Placeholder
    }
}

/*
 * ============================================
 * SOLUCION (NO MIRAR ANTES DE INTENTAR):
 * ============================================
 *
 * // Solucion 1: Two-pointer (mas eficiente en espacio)
 * public static boolean esPalindromo(String texto) {
 *     if (texto == null) return false;
 *     if (texto.isEmpty()) return true;
 *
 *     int izq = 0;
 *     int der = texto.length() - 1;
 *
 *     while (izq < der) {
 *         // Saltar no-alfanumericos desde la izquierda
 *         while (izq < der && !Character.isLetterOrDigit(texto.charAt(izq))) {
 *             izq++;
 *         }
 *         // Saltar no-alfanumericos desde la derecha
 *         while (izq < der && !Character.isLetterOrDigit(texto.charAt(der))) {
 *             der--;
 *         }
 *
 *         // Comparar caracteres (ignorando caso)
 *         if (Character.toLowerCase(texto.charAt(izq)) !=
 *             Character.toLowerCase(texto.charAt(der))) {
 *             return false;
 *         }
 *
 *         izq++;
 *         der--;
 *     }
 *
 *     return true;
 * }
 *
 * // Solucion 2: Usando reverse (mas simple, menos eficiente)
 * public static boolean esPalindromoReverse(String texto) {
 *     if (texto == null) return false;
 *
 *     // Limpiar: solo letras/digitos en minuscula
 *     String limpio = texto.toLowerCase()
 *         .replaceAll("[^a-z0-9]", "");
 *
 *     // Invertir y comparar
 *     String invertido = new StringBuilder(limpio).reverse().toString();
 *     return limpio.equals(invertido);
 * }
 *
 * COMPLEJIDAD:
 * - Two-pointer: O(n) tiempo, O(1) espacio
 * - Reverse: O(n) tiempo, O(n) espacio
 */
