/**
 * EJERCICIO STRING #1: InvertirPalabras
 * Dificultad: ⭐⭐
 *
 * PROBLEMA:
 * Dada una oracion, invertir el orden de las palabras.
 * Los espacios multiples deben reducirse a uno.
 *
 * EJEMPLOS:
 * "Hola mundo"           -> "mundo Hola"
 * "  Java   es  genial " -> "genial es Java"
 * "Palabra"              -> "Palabra"
 *
 * PISTAS:
 * 1. split() con regex "\\s+" divide por uno o mas espacios
 * 2. Puedes usar un bucle inverso o Collections.reverse()
 * 3. String.join() une un array con un separador
 *
 * METODOS UTILES:
 * - String.split(regex)
 * - String.trim()
 * - String.join(delimiter, elements)
 * - Collections.reverse(list)
 */

import java.util.*;

public class String01_InvertirPalabras {
    public static void main(String[] args) {
        // Casos de prueba
        System.out.println(invertirPalabras("Hola mundo"));
        // Esperado: "mundo Hola"

        System.out.println(invertirPalabras("  Java   es  genial "));
        // Esperado: "genial es Java"

        System.out.println(invertirPalabras("Palabra"));
        // Esperado: "Palabra"

        System.out.println(invertirPalabras(""));
        // Esperado: ""
    }

    public static String invertirPalabras(String oracion) {
        // TODO: Implementar
        // 1. Manejar caso vacio
        // 2. Dividir por espacios
        // 3. Invertir el orden
        // 4. Unir con espacio simple

        return ""; // Placeholder
    }
}

/*
 * ============================================
 * SOLUCION (NO MIRAR ANTES DE INTENTAR):
 * ============================================
 *
 * public static String invertirPalabras(String oracion) {
 *     if (oracion == null || oracion.trim().isEmpty()) {
 *         return "";
 *     }
 *
 *     // Dividir por uno o mas espacios
 *     String[] palabras = oracion.trim().split("\\s+");
 *
 *     // Invertir usando Collections
 *     List<String> lista = Arrays.asList(palabras);
 *     Collections.reverse(lista);
 *
 *     // Unir con espacio
 *     return String.join(" ", lista);
 * }
 *
 * // Alternativa sin Collections:
 * public static String invertirPalabras2(String oracion) {
 *     if (oracion == null || oracion.trim().isEmpty()) {
 *         return "";
 *     }
 *
 *     String[] palabras = oracion.trim().split("\\s+");
 *     StringBuilder sb = new StringBuilder();
 *
 *     for (int i = palabras.length - 1; i >= 0; i--) {
 *         sb.append(palabras[i]);
 *         if (i > 0) sb.append(" ");
 *     }
 *
 *     return sb.toString();
 * }
 *
 * COMPLEJIDAD:
 * - Tiempo: O(n) donde n es la longitud del string
 * - Espacio: O(n) para almacenar las palabras
 */
