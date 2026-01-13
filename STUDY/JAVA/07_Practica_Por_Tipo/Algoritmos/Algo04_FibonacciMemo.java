/**
 * EJERCICIO ALGORITMO #4: Fibonacci con Memoization
 * Categoria: Programacion Dinamica
 * Dificultad: ⭐⭐
 *
 * PROBLEMA:
 * Calcular el N-esimo numero de Fibonacci eficientemente.
 * F(0)=0, F(1)=1, F(n)=F(n-1)+F(n-2)
 *
 * VERSIONES:
 * 1. Recursiva naive: O(2^n) - MUY LENTA
 * 2. Top-down (memo): O(n)
 * 3. Bottom-up (tabla): O(n)
 * 4. Optimizada espacio: O(n) tiempo, O(1) espacio
 *
 * EJEMPLO:
 * F(0)=0, F(1)=1, F(2)=1, F(3)=2, F(4)=3, F(5)=5
 * F(10)=55, F(20)=6765, F(45)=1134903170
 */

import java.util.*;

public class Algo04_FibonacciMemo {
    // Cache para memoization
    static Map<Integer, Long> memo = new HashMap<>();

    public static void main(String[] args) {
        int n = 45;

        System.out.println("=== Fibonacci de " + n + " ===\n");

        // Version naive (NO ejecutar con n > 40!)
        // System.out.println("Naive: " + fibNaive(n));

        // Version memoization
        long inicio = System.nanoTime();
        long resultado = fibMemo(n);
        long fin = System.nanoTime();
        System.out.printf("Memoization: %d (%.3f ms)%n",
            resultado, (fin - inicio) / 1_000_000.0);

        // Version bottom-up
        inicio = System.nanoTime();
        resultado = fibBottomUp(n);
        fin = System.nanoTime();
        System.out.printf("Bottom-up:   %d (%.3f ms)%n",
            resultado, (fin - inicio) / 1_000_000.0);

        // Version espacio optimizado
        inicio = System.nanoTime();
        resultado = fibOptimizado(n);
        fin = System.nanoTime();
        System.out.printf("Optimizado:  %d (%.3f ms)%n",
            resultado, (fin - inicio) / 1_000_000.0);
    }

    /**
     * Fibonacci recursivo naive - O(2^n)
     * NO USAR para n > 40
     */
    public static long fibNaive(int n) {
        if (n <= 1) return n;
        return fibNaive(n - 1) + fibNaive(n - 2);
    }

    /**
     * Fibonacci con memoization (top-down) - O(n)
     */
    public static long fibMemo(int n) {
        // TODO: Implementar
        // 1. Verificar si ya esta en memo
        // 2. Caso base
        // 3. Calcular y guardar en memo

        return 0; // Placeholder
    }

    /**
     * Fibonacci bottom-up (tabulation) - O(n)
     */
    public static long fibBottomUp(int n) {
        // TODO: Implementar
        // 1. Crear array dp[n+1]
        // 2. Casos base: dp[0]=0, dp[1]=1
        // 3. Llenar de 2 a n

        return 0; // Placeholder
    }

    /**
     * Fibonacci espacio optimizado - O(n) tiempo, O(1) espacio
     */
    public static long fibOptimizado(int n) {
        // TODO: Implementar
        // Solo necesitas los 2 valores anteriores

        return 0; // Placeholder
    }
}

/*
 * ============================================
 * SOLUCION (NO MIRAR ANTES DE INTENTAR):
 * ============================================
 *
 * public static long fibMemo(int n) {
 *     if (memo.containsKey(n)) {
 *         return memo.get(n);
 *     }
 *
 *     if (n <= 1) {
 *         return n;
 *     }
 *
 *     long resultado = fibMemo(n - 1) + fibMemo(n - 2);
 *     memo.put(n, resultado);
 *     return resultado;
 * }
 *
 * public static long fibBottomUp(int n) {
 *     if (n <= 1) return n;
 *
 *     long[] dp = new long[n + 1];
 *     dp[0] = 0;
 *     dp[1] = 1;
 *
 *     for (int i = 2; i <= n; i++) {
 *         dp[i] = dp[i - 1] + dp[i - 2];
 *     }
 *
 *     return dp[n];
 * }
 *
 * public static long fibOptimizado(int n) {
 *     if (n <= 1) return n;
 *
 *     long prev2 = 0;  // F(i-2)
 *     long prev1 = 1;  // F(i-1)
 *
 *     for (int i = 2; i <= n; i++) {
 *         long actual = prev1 + prev2;
 *         prev2 = prev1;
 *         prev1 = actual;
 *     }
 *
 *     return prev1;
 * }
 *
 * ============================================
 * COMPARACION DE TIEMPOS (n=45):
 * ============================================
 *
 * Naive:      ~6 segundos (6 billones de operaciones!)
 * Memoization: < 1 ms
 * Bottom-up:   < 1 ms
 * Optimizado:  < 1 ms
 *
 * ============================================
 * FORMULA CERRADA (Binet):
 * ============================================
 *
 * F(n) = (phi^n - psi^n) / sqrt(5)
 * phi = (1 + sqrt(5)) / 2  (golden ratio)
 * psi = (1 - sqrt(5)) / 2
 *
 * Tiempo O(1), pero problemas de precision flotante
 * para n grande.
 */
