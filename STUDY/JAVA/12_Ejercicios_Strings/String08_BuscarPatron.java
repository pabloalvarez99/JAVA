/**
 * EJERCICIO STRING #8: BuscarPatron
 * Dificultad: ⭐⭐⭐
 *
 * PROBLEMA:
 * Implementar busqueda de patron en texto (sin usar regex).
 * Encontrar todas las ocurrencias de un patron en el texto.
 *
 * EJEMPLOS:
 * texto="AABAACAADAABAAABAA", patron="AABA"
 * -> Encontrado en posiciones: [0, 9, 13]
 *
 * texto="hello hello hello", patron="hello"
 * -> Encontrado en posiciones: [0, 6, 12]
 *
 * PISTAS:
 * 1. Algoritmo naive: comparar en cada posicion
 * 2. Optimizacion: si hay mismatch, saltar inteligentemente
 * 3. Para version avanzada: investigar KMP o Boyer-Moore
 *
 * METODOS UTILES:
 * - String.charAt(i)
 * - String.substring(start, end)
 */

import java.util.*;

public class String08_BuscarPatron {
    public static void main(String[] args) {
        // Casos de prueba
        String texto1 = "AABAACAADAABAAABAA";
        String patron1 = "AABA";
        System.out.println("Texto: " + texto1);
        System.out.println("Patron: " + patron1);
        System.out.println("Posiciones: " + buscarPatron(texto1, patron1));
        // Esperado: [0, 9, 13]

        System.out.println();

        String texto2 = "hello hello hello";
        String patron2 = "hello";
        System.out.println("Texto: " + texto2);
        System.out.println("Patron: " + patron2);
        System.out.println("Posiciones: " + buscarPatron(texto2, patron2));
        // Esperado: [0, 6, 12]

        System.out.println();

        String texto3 = "aaaaa";
        String patron3 = "aa";
        System.out.println("Texto: " + texto3);
        System.out.println("Patron: " + patron3);
        System.out.println("Posiciones: " + buscarPatron(texto3, patron3));
        // Esperado: [0, 1, 2, 3] (ocurrencias superpuestas)
    }

    // Algoritmo naive O(n*m)
    public static List<Integer> buscarPatron(String texto, String patron) {
        // TODO: Implementar
        // 1. Para cada posicion i en texto
        // 2. Verificar si patron coincide empezando en i
        // 3. Si coincide, agregar i a la lista

        return new ArrayList<>(); // Placeholder
    }

    // Bonus: contar ocurrencias (sin superposicion)
    public static int contarOcurrencias(String texto, String patron) {
        // TODO: Implementar

        return 0; // Placeholder
    }
}

/*
 * ============================================
 * SOLUCION (NO MIRAR ANTES DE INTENTAR):
 * ============================================
 *
 * // Algoritmo naive
 * public static List<Integer> buscarPatron(String texto, String patron) {
 *     List<Integer> posiciones = new ArrayList<>();
 *
 *     if (texto == null || patron == null || patron.isEmpty()) {
 *         return posiciones;
 *     }
 *
 *     int n = texto.length();
 *     int m = patron.length();
 *
 *     for (int i = 0; i <= n - m; i++) {
 *         boolean coincide = true;
 *
 *         for (int j = 0; j < m; j++) {
 *             if (texto.charAt(i + j) != patron.charAt(j)) {
 *                 coincide = false;
 *                 break;
 *             }
 *         }
 *
 *         if (coincide) {
 *             posiciones.add(i);
 *         }
 *     }
 *
 *     return posiciones;
 * }
 *
 * // Alternativa usando substring
 * public static List<Integer> buscarPatron2(String texto, String patron) {
 *     List<Integer> posiciones = new ArrayList<>();
 *     int m = patron.length();
 *
 *     for (int i = 0; i <= texto.length() - m; i++) {
 *         if (texto.substring(i, i + m).equals(patron)) {
 *             posiciones.add(i);
 *         }
 *     }
 *
 *     return posiciones;
 * }
 *
 * public static int contarOcurrencias(String texto, String patron) {
 *     int count = 0;
 *     int index = 0;
 *
 *     while ((index = texto.indexOf(patron, index)) != -1) {
 *         count++;
 *         index += patron.length(); // Sin superposicion
 *     }
 *
 *     return count;
 * }
 *
 * COMPLEJIDAD:
 * - Naive: O(n*m) tiempo, O(1) espacio (mas posiciones encontradas)
 * - KMP (avanzado): O(n+m) tiempo
 */
