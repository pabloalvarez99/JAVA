/**
 * EJERCICIO ALGORITMO #1: Torres de Hanoi
 * Categoria: Recursion
 * Dificultad: ⭐⭐
 *
 * PROBLEMA:
 * Mover N discos de torre A a torre C usando torre B como auxiliar.
 *
 * REGLAS:
 * 1. Solo mover un disco a la vez
 * 2. Un disco solo puede estar sobre uno mas grande
 * 3. Solo mover el disco de arriba de una torre
 *
 * EJEMPLO (N=3):
 * Movimientos: 2^3 - 1 = 7
 *
 * COMPLEJIDAD:
 * - Tiempo: O(2^n)
 * - Espacio: O(n) por la pila de recursion
 *
 * PISTAS:
 * 1. Para mover N discos de A a C:
 *    - Mover N-1 discos de A a B
 *    - Mover disco N de A a C
 *    - Mover N-1 discos de B a C
 * 2. Caso base: N=1, mover directamente
 */

public class Algo01_TorresHanoi {
    static int contadorMovimientos = 0;

    public static void main(String[] args) {
        int numDiscos = 3;

        System.out.println("=== Torres de Hanoi con " + numDiscos + " discos ===\n");

        hanoi(numDiscos, 'A', 'C', 'B');

        System.out.println("\nTotal movimientos: " + contadorMovimientos);
        System.out.println("Formula: 2^" + numDiscos + " - 1 = " +
            ((int) Math.pow(2, numDiscos) - 1));
    }

    /**
     * Resuelve Torres de Hanoi recursivamente.
     *
     * @param n Numero de discos a mover
     * @param origen Torre origen
     * @param destino Torre destino
     * @param auxiliar Torre auxiliar
     */
    public static void hanoi(int n, char origen, char destino, char auxiliar) {
        // TODO: Implementar
        // Caso base: n == 1

        // Caso recursivo:
        // 1. Mover n-1 discos de origen a auxiliar (usando destino)
        // 2. Mover disco n de origen a destino
        // 3. Mover n-1 discos de auxiliar a destino (usando origen)
    }

    private static void moverDisco(int disco, char origen, char destino) {
        contadorMovimientos++;
        System.out.printf("Movimiento %d: Disco %d de %c a %c%n",
            contadorMovimientos, disco, origen, destino);
    }
}

/*
 * ============================================
 * SOLUCION (NO MIRAR ANTES DE INTENTAR):
 * ============================================
 *
 * public static void hanoi(int n, char origen, char destino, char auxiliar) {
 *     if (n == 1) {
 *         moverDisco(1, origen, destino);
 *         return;
 *     }
 *
 *     // Mover n-1 discos de origen a auxiliar
 *     hanoi(n - 1, origen, auxiliar, destino);
 *
 *     // Mover disco grande de origen a destino
 *     moverDisco(n, origen, destino);
 *
 *     // Mover n-1 discos de auxiliar a destino
 *     hanoi(n - 1, auxiliar, destino, origen);
 * }
 *
 * ============================================
 * VISUALIZACION (N=3):
 * ============================================
 *
 * hanoi(3, A, C, B)
 *   hanoi(2, A, B, C)
 *     hanoi(1, A, C, B) -> Disco 1: A->C
 *     Disco 2: A->B
 *     hanoi(1, C, B, A) -> Disco 1: C->B
 *   Disco 3: A->C
 *   hanoi(2, B, C, A)
 *     hanoi(1, B, A, C) -> Disco 1: B->A
 *     Disco 2: B->C
 *     hanoi(1, A, C, B) -> Disco 1: A->C
 *
 * Resultado: 7 movimientos
 *
 * ============================================
 * EXTENSION: Version iterativa
 * ============================================
 *
 * Es posible resolver iterativamente usando una pila
 * para simular la recursion. La idea es alternar
 * movimientos entre el disco mas pequeno y otro disco.
 */
