/**
 * EJERCICIO ALGORITMO #9: Problema de las N Reinas
 * Categoria: Backtracking
 * Dificultad: ⭐⭐⭐⭐
 *
 * PROBLEMA:
 * Colocar N reinas en un tablero NxN de forma que
 * ninguna reina pueda atacar a otra.
 *
 * REGLAS DEL AJEDREZ:
 * Una reina ataca en su fila, columna y diagonales.
 *
 * EJEMPLO (N=4):
 * . Q . .
 * . . . Q
 * Q . . .
 * . . Q .
 *
 * ESTRATEGIA BACKTRACKING:
 * 1. Colocar reinas fila por fila
 * 2. Para cada fila, probar cada columna
 * 3. Si es segura, avanzar a siguiente fila
 * 4. Si no hay columna segura, retroceder (backtrack)
 *
 * COMPLEJIDAD:
 * - Tiempo: O(N!)
 * - Espacio: O(N)
 */

import java.util.*;

public class Algo09_NReinas {
    static int soluciones = 0;

    public static void main(String[] args) {
        int n = 8;  // Tablero 8x8

        System.out.println("=== Problema de las " + n + " Reinas ===\n");

        // Encontrar una solucion
        int[] tablero = new int[n];  // tablero[fila] = columna de la reina
        Arrays.fill(tablero, -1);

        if (resolverNReinas(tablero, 0)) {
            System.out.println("Una solucion:");
            imprimirTablero(tablero);
        }

        // Contar todas las soluciones
        soluciones = 0;
        contarSoluciones(new int[n], 0);
        System.out.println("\nTotal de soluciones para N=" + n + ": " + soluciones);
    }

    /**
     * Encuentra UNA solucion al problema de N reinas.
     *
     * @param tablero tablero[fila] = columna donde esta la reina
     * @param fila Fila actual a llenar
     * @return true si se encontro solucion
     */
    public static boolean resolverNReinas(int[] tablero, int fila) {
        int n = tablero.length;

        // TODO: Implementar
        // 1. Caso base: todas las filas llenas
        // 2. Para cada columna en esta fila:
        //    - Si es segura: colocar reina, recurrir
        //    - Si recursion exitosa: return true
        //    - Si no: backtrack (quitar reina)
        // 3. Ninguna columna funciono: return false

        return false; // Placeholder
    }

    /**
     * Cuenta TODAS las soluciones.
     */
    public static void contarSoluciones(int[] tablero, int fila) {
        int n = tablero.length;

        // TODO: Implementar similar pero sin return early
    }

    /**
     * Verifica si es seguro colocar reina en (fila, col).
     */
    public static boolean esSeguro(int[] tablero, int fila, int col) {
        // TODO: Implementar
        // Verificar filas anteriores:
        // - Misma columna?
        // - Misma diagonal?

        return false; // Placeholder
    }

    private static void imprimirTablero(int[] tablero) {
        int n = tablero.length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(tablero[i] == j ? "Q " : ". ");
            }
            System.out.println();
        }
    }
}

/*
 * ============================================
 * SOLUCION (NO MIRAR ANTES DE INTENTAR):
 * ============================================
 *
 * public static boolean resolverNReinas(int[] tablero, int fila) {
 *     int n = tablero.length;
 *
 *     // Caso base: todas las reinas colocadas
 *     if (fila == n) {
 *         return true;
 *     }
 *
 *     // Probar cada columna en esta fila
 *     for (int col = 0; col < n; col++) {
 *         if (esSeguro(tablero, fila, col)) {
 *             tablero[fila] = col;  // Colocar reina
 *
 *             if (resolverNReinas(tablero, fila + 1)) {
 *                 return true;  // Solucion encontrada
 *             }
 *
 *             tablero[fila] = -1;  // Backtrack
 *         }
 *     }
 *
 *     return false;  // No hay solucion desde aqui
 * }
 *
 * public static void contarSoluciones(int[] tablero, int fila) {
 *     int n = tablero.length;
 *
 *     if (fila == n) {
 *         soluciones++;
 *         return;
 *     }
 *
 *     for (int col = 0; col < n; col++) {
 *         if (esSeguro(tablero, fila, col)) {
 *             tablero[fila] = col;
 *             contarSoluciones(tablero, fila + 1);
 *             tablero[fila] = -1;
 *         }
 *     }
 * }
 *
 * public static boolean esSeguro(int[] tablero, int fila, int col) {
 *     for (int i = 0; i < fila; i++) {
 *         // Misma columna
 *         if (tablero[i] == col) return false;
 *
 *         // Misma diagonal (diferencia de filas == diferencia de columnas)
 *         if (Math.abs(tablero[i] - col) == Math.abs(i - fila)) {
 *             return false;
 *         }
 *     }
 *     return true;
 * }
 *
 * ============================================
 * NUMERO DE SOLUCIONES:
 * ============================================
 *
 * N=1: 1 solucion
 * N=2: 0 soluciones (imposible)
 * N=3: 0 soluciones (imposible)
 * N=4: 2 soluciones
 * N=5: 10 soluciones
 * N=6: 4 soluciones
 * N=7: 40 soluciones
 * N=8: 92 soluciones
 *
 * ============================================
 * OPTIMIZACIONES:
 * ============================================
 *
 * 1. Usar bitsets para marcar columnas/diagonales ocupadas
 * 2. Simetria: solo calcular mitad y multiplicar
 * 3. Pruning mas agresivo
 */
