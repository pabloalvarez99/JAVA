/**
 * EJERCICIO STRING #5: CompresionBasica
 * Dificultad: ⭐⭐⭐
 *
 * PROBLEMA:
 * Implementar compresion basica de strings usando conteo de caracteres repetidos.
 * Si el string comprimido no es mas corto, retornar el original.
 *
 * EJEMPLOS:
 * "aabcccccaaa" -> "a2b1c5a3"
 * "abcd"        -> "abcd" (comprimido seria "a1b1c1d1", mas largo)
 * "aaa"         -> "a3"
 * "a"           -> "a" (original mas corto)
 * "aaAAaa"      -> "a2A2a2" (case-sensitive)
 *
 * PISTAS:
 * 1. Usa StringBuilder para construir resultado
 * 2. Recorre contando caracteres consecutivos iguales
 * 3. Al final, compara longitudes
 *
 * METODOS UTILES:
 * - StringBuilder.append()
 * - Character comparison: c1 == c2
 */

public class String05_CompresionBasica {
    public static void main(String[] args) {
        // Casos de prueba
        System.out.println(comprimir("aabcccccaaa")); // "a2b1c5a3"
        System.out.println(comprimir("abcd"));        // "abcd" (original)
        System.out.println(comprimir("aaa"));         // "a3"
        System.out.println(comprimir("a"));           // "a"
        System.out.println(comprimir("aaAAaa"));      // "a2A2a2"
        System.out.println(comprimir(""));            // ""

        // Bonus: descompresion
        System.out.println("\n=== Descompresion ===");
        System.out.println(descomprimir("a2b1c5a3")); // "aabcccccaaa"
    }

    public static String comprimir(String s) {
        // TODO: Implementar
        // 1. Caso base: string vacio o null
        // 2. Recorrer contando caracteres consecutivos
        // 3. Construir string comprimido
        // 4. Retornar el mas corto

        return ""; // Placeholder
    }

    public static String descomprimir(String s) {
        // TODO: Implementar (bonus)
        // 1. Leer caracter
        // 2. Leer numero (puede ser mas de un digito)
        // 3. Repetir caracter ese numero de veces

        return ""; // Placeholder
    }
}

/*
 * ============================================
 * SOLUCION (NO MIRAR ANTES DE INTENTAR):
 * ============================================
 *
 * public static String comprimir(String s) {
 *     if (s == null || s.length() <= 1) {
 *         return s == null ? "" : s;
 *     }
 *
 *     StringBuilder sb = new StringBuilder();
 *     int contador = 1;
 *
 *     for (int i = 1; i <= s.length(); i++) {
 *         // Si llegamos al final o el caracter cambio
 *         if (i == s.length() || s.charAt(i) != s.charAt(i - 1)) {
 *             sb.append(s.charAt(i - 1));
 *             sb.append(contador);
 *             contador = 1;
 *         } else {
 *             contador++;
 *         }
 *     }
 *
 *     // Retornar el mas corto
 *     return sb.length() < s.length() ? sb.toString() : s;
 * }
 *
 * public static String descomprimir(String s) {
 *     if (s == null || s.isEmpty()) {
 *         return s == null ? "" : s;
 *     }
 *
 *     StringBuilder sb = new StringBuilder();
 *     int i = 0;
 *
 *     while (i < s.length()) {
 *         char c = s.charAt(i);
 *         i++;
 *
 *         // Leer numero (puede tener multiples digitos)
 *         StringBuilder numStr = new StringBuilder();
 *         while (i < s.length() && Character.isDigit(s.charAt(i))) {
 *             numStr.append(s.charAt(i));
 *             i++;
 *         }
 *
 *         int repeticiones = Integer.parseInt(numStr.toString());
 *         for (int j = 0; j < repeticiones; j++) {
 *             sb.append(c);
 *         }
 *     }
 *
 *     return sb.toString();
 * }
 *
 * COMPLEJIDAD:
 * - Comprimir: O(n) tiempo, O(n) espacio
 * - Descomprimir: O(n) tiempo, O(m) espacio (m = longitud descomprimida)
 */
