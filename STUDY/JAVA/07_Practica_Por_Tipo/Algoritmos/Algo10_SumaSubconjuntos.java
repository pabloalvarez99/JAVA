/**
 * EJERCICIO ALGORITMO #10: Suma de Subconjuntos
 * Categoria: DP / Backtracking
 * Dificultad: ⭐⭐⭐⭐
 *
 * PROBLEMA:
 * Dado un conjunto de numeros y un objetivo,
 * determinar si existe un subconjunto que sume exactamente el objetivo.
 *
 * EJEMPLO:
 * nums = [3, 34, 4, 12, 5, 2]
 * objetivo = 9
 * Respuesta: true (subconjunto {4, 5} o {3, 4, 2})
 *
 * ENFOQUES:
 * 1. Backtracking: O(2^n) - explorar todos los subconjuntos
 * 2. DP: O(n * objetivo) - tabla de posibilidades
 *
 * COMPLEJIDAD:
 * - Backtracking: O(2^n)
 * - DP: O(n * objetivo) tiempo y espacio
 */

import java.util.*;

public class Algo10_SumaSubconjuntos {
    public static void main(String[] args) {
        int[] nums = {3, 34, 4, 12, 5, 2};
        int objetivo = 9;

        System.out.println("nums = " + Arrays.toString(nums));
        System.out.println("objetivo = " + objetivo);

        // Verificar si existe
        boolean existe = sumaPosibleDP(nums, objetivo);
        System.out.println("\nExiste subconjunto: " + existe);

        // Encontrar el subconjunto
        List<Integer> subconjunto = encontrarSubconjunto(nums, objetivo);
        if (subconjunto != null) {
            System.out.println("Subconjunto: " + subconjunto);
        }

        // Encontrar TODOS los subconjuntos
        System.out.println("\nTodos los subconjuntos que suman " + objetivo + ":");
        List<List<Integer>> todos = encontrarTodos(nums, objetivo);
        for (List<Integer> sub : todos) {
            System.out.println("  " + sub);
        }
    }

    /**
     * Verifica si existe subconjunto que suma objetivo usando DP.
     */
    public static boolean sumaPosibleDP(int[] nums, int objetivo) {
        // TODO: Implementar
        // dp[i][s] = es posible sumar 's' usando los primeros 'i' elementos
        // dp[i][s] = dp[i-1][s] || dp[i-1][s - nums[i-1]]

        return false; // Placeholder
    }

    /**
     * Encuentra UN subconjunto que suma objetivo.
     */
    public static List<Integer> encontrarSubconjunto(int[] nums, int objetivo) {
        // TODO: Implementar usando backtracking o reconstruccion desde DP

        return null; // Placeholder
    }

    /**
     * Encuentra TODOS los subconjuntos que suman objetivo.
     */
    public static List<List<Integer>> encontrarTodos(int[] nums, int objetivo) {
        List<List<Integer>> resultado = new ArrayList<>();
        backtrackTodos(nums, 0, objetivo, new ArrayList<>(), resultado);
        return resultado;
    }

    private static void backtrackTodos(int[] nums, int idx, int restante,
                                       List<Integer> actual, List<List<Integer>> resultado) {
        // TODO: Implementar backtracking
    }
}

/*
 * ============================================
 * SOLUCION (NO MIRAR ANTES DE INTENTAR):
 * ============================================
 *
 * public static boolean sumaPosibleDP(int[] nums, int objetivo) {
 *     int n = nums.length;
 *
 *     // dp[s] = es posible sumar 's'
 *     boolean[] dp = new boolean[objetivo + 1];
 *     dp[0] = true;  // Suma 0 siempre es posible (conjunto vacio)
 *
 *     for (int num : nums) {
 *         // Recorrer de derecha a izquierda para no reusar el mismo numero
 *         for (int s = objetivo; s >= num; s--) {
 *             if (dp[s - num]) {
 *                 dp[s] = true;
 *             }
 *         }
 *     }
 *
 *     return dp[objetivo];
 * }
 *
 * public static List<Integer> encontrarSubconjunto(int[] nums, int objetivo) {
 *     List<Integer> resultado = new ArrayList<>();
 *     if (backtrackUno(nums, 0, objetivo, resultado)) {
 *         return resultado;
 *     }
 *     return null;
 * }
 *
 * private static boolean backtrackUno(int[] nums, int idx, int restante,
 *                                     List<Integer> actual) {
 *     if (restante == 0) {
 *         return true;  // Encontrado!
 *     }
 *     if (restante < 0 || idx >= nums.length) {
 *         return false;  // No es posible
 *     }
 *
 *     // Opcion 1: incluir nums[idx]
 *     actual.add(nums[idx]);
 *     if (backtrackUno(nums, idx + 1, restante - nums[idx], actual)) {
 *         return true;
 *     }
 *     actual.remove(actual.size() - 1);  // Backtrack
 *
 *     // Opcion 2: no incluir nums[idx]
 *     return backtrackUno(nums, idx + 1, restante, actual);
 * }
 *
 * private static void backtrackTodos(int[] nums, int idx, int restante,
 *                                    List<Integer> actual,
 *                                    List<List<Integer>> resultado) {
 *     if (restante == 0) {
 *         resultado.add(new ArrayList<>(actual));
 *         return;
 *     }
 *     if (restante < 0 || idx >= nums.length) {
 *         return;
 *     }
 *
 *     // Incluir nums[idx]
 *     actual.add(nums[idx]);
 *     backtrackTodos(nums, idx + 1, restante - nums[idx], actual, resultado);
 *     actual.remove(actual.size() - 1);
 *
 *     // No incluir nums[idx]
 *     backtrackTodos(nums, idx + 1, restante, actual, resultado);
 * }
 *
 * ============================================
 * VARIANTES DEL PROBLEMA:
 * ============================================
 *
 * 1. Contar cuantos subconjuntos suman objetivo
 * 2. Mochila 0/1 (cada elemento tiene valor y peso)
 * 3. Partition Problem (dividir en 2 con igual suma)
 * 4. Subset con diferencia minima
 * 5. Con elementos repetibles (Unbounded)
 *
 * ============================================
 * OPTIMIZACIONES:
 * ============================================
 *
 * 1. Ordenar y podar cuando restante < 0
 * 2. Meet in the middle para n > 20
 * 3. Bit manipulation para n pequeno
 */
