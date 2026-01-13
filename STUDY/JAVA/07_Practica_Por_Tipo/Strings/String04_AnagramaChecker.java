/**
 * EJERCICIO STRING #4: AnagramaChecker
 * Dificultad: ⭐⭐
 *
 * PROBLEMA:
 * Determinar si dos strings son anagramas (mismas letras, diferente orden).
 * Ignorar espacios y mayusculas.
 *
 * EJEMPLOS:
 * "listen", "silent"       -> true
 * "Dormitory", "Dirty room" -> true
 * "hello", "world"         -> false
 * "anagram", "nagaram"     -> true
 * "rat", "car"             -> false
 *
 * PISTAS:
 * 1. Ordena ambos strings y compara
 * 2. O usa un array/map para contar caracteres
 * 3. Primero limpia los strings (solo letras, minusculas)
 *
 * METODOS UTILES:
 * - Arrays.sort(charArray)
 * - HashMap para conteo de frecuencias
 */

import java.util.*;

public class String04_AnagramaChecker {
    public static void main(String[] args) {
        // Casos de prueba
        System.out.println(sonAnagramas("listen", "silent"));        // true
        System.out.println(sonAnagramas("Dormitory", "Dirty room")); // true
        System.out.println(sonAnagramas("hello", "world"));          // false
        System.out.println(sonAnagramas("anagram", "nagaram"));      // true
        System.out.println(sonAnagramas("rat", "car"));              // false
        System.out.println(sonAnagramas("", ""));                    // true
        System.out.println(sonAnagramas("a", "a"));                  // true
    }

    // Metodo 1: Usando ordenamiento
    public static boolean sonAnagramas(String s1, String s2) {
        // TODO: Implementar
        // 1. Limpiar ambos strings
        // 2. Ordenar caracteres
        // 3. Comparar

        return false; // Placeholder
    }

    // Metodo 2: Usando conteo de caracteres (bonus)
    public static boolean sonAnagramasConteo(String s1, String s2) {
        // TODO: Implementar
        // 1. Contar frecuencia de cada caracter en s1
        // 2. Restar frecuencia por cada caracter en s2
        // 3. Verificar que todos los conteos sean 0

        return false; // Placeholder
    }
}

/*
 * ============================================
 * SOLUCION (NO MIRAR ANTES DE INTENTAR):
 * ============================================
 *
 * // Solucion 1: Ordenamiento O(n log n)
 * public static boolean sonAnagramas(String s1, String s2) {
 *     // Limpiar: solo letras en minuscula
 *     String clean1 = s1.toLowerCase().replaceAll("[^a-z]", "");
 *     String clean2 = s2.toLowerCase().replaceAll("[^a-z]", "");
 *
 *     if (clean1.length() != clean2.length()) {
 *         return false;
 *     }
 *
 *     // Ordenar y comparar
 *     char[] arr1 = clean1.toCharArray();
 *     char[] arr2 = clean2.toCharArray();
 *     Arrays.sort(arr1);
 *     Arrays.sort(arr2);
 *
 *     return Arrays.equals(arr1, arr2);
 * }
 *
 * // Solucion 2: Conteo O(n) - mas eficiente
 * public static boolean sonAnagramasConteo(String s1, String s2) {
 *     String clean1 = s1.toLowerCase().replaceAll("[^a-z]", "");
 *     String clean2 = s2.toLowerCase().replaceAll("[^a-z]", "");
 *
 *     if (clean1.length() != clean2.length()) {
 *         return false;
 *     }
 *
 *     // Usar array de 26 para letras a-z
 *     int[] conteo = new int[26];
 *
 *     for (char c : clean1.toCharArray()) {
 *         conteo[c - 'a']++;
 *     }
 *
 *     for (char c : clean2.toCharArray()) {
 *         conteo[c - 'a']--;
 *         if (conteo[c - 'a'] < 0) {
 *             return false;
 *         }
 *     }
 *
 *     return true;
 * }
 *
 * COMPLEJIDAD:
 * - Ordenamiento: O(n log n) tiempo, O(n) espacio
 * - Conteo: O(n) tiempo, O(1) espacio (26 es constante)
 */
