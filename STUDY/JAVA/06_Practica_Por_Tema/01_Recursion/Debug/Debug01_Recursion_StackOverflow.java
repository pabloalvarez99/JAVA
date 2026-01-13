/**
 * ========================================
 * EJERCICIO DEBUG #1: StackOverflow - Falta Caso Base
 * Dificultad: ⭐⭐⭐
 * ========================================
 *
 * DESCRIPCIÓN:
 * El siguiente código tiene UN BUG que causa StackOverflowError.
 * El programa intenta calcular la suma de 1 hasta N, pero falla.
 *
 * PISTA: El problema está en la recursión - falta algo fundamental.
 *
 * SALIDA ESPERADA:
 * Suma de 1 a 5: 15
 * Suma de 1 a 10: 55
 * Suma de 1 a 1: 1
 * Suma de 1 a 0: 0
 *
 * SALIDA ACTUAL:
 * Exception in thread "main" java.lang.StackOverflowError
 */

public class Debug01_Recursion_StackOverflow {
    public static void main(String[] args) {
        System.out.println("Suma de 1 a 5: " + suma(5));
        System.out.println("Suma de 1 a 10: " + suma(10));
        System.out.println("Suma de 1 a 1: " + suma(1));
        System.out.println("Suma de 1 a 0: " + suma(0));
    }

    /**
     * BUG: Este método causa StackOverflowError
     * ¿Por qué? ¿Qué falta?
     */
    public static int suma(int n) {
        // Caso recursivo
        return n + suma(n - 1);
    }
}

/*
 * ============================================
 * DESPUÉS DE RESOLVER, REFLEXIONA:
 * ============================================
 *
 * 1. ¿Por qué ocurrió el StackOverflowError?
 *    Respuesta: Falta el caso base. La recursión nunca termina.
 *
 * 2. ¿Cuándo debe detenerse la recursión?
 *    Respuesta: Cuando n == 0 (o n <= 0 para ser más robusto)
 *
 * 3. ¿Qué línea del stack trace te indica el problema?
 *    Respuesta: Se repite "at Debug01_Recursion_StackOverflow.suma()"
 *    muchas veces, indicando recursión infinita
 *
 * 4. ¿Cómo verificar si una recursión es correcta?
 *    - Verificar que existe un caso base
 *    - Verificar que la recursión converge al caso base
 *    - Verificar que el caso base retorna un valor (no hace llamada recursiva)
 *
 * SOLUCIÓN:
 *
 * public static int suma(int n) {
 *     // Caso base: cuando n es 0, la suma es 0
 *     if (n <= 0) {
 *         return 0;
 *     }
 *
 *     // Caso recursivo
 *     return n + suma(n - 1);
 * }
 *
 * ============================================
 * CONCEPTO CLAVE:
 * ============================================
 *
 * Toda función recursiva DEBE tener:
 * 1. Caso base (condición de parada)
 * 2. Caso recursivo (que converge al caso base)
 *
 * Sin caso base → recursión infinita → StackOverflowError
 *
 * ============================================
 * EJERCICIOS RELACIONADOS:
 * ============================================
 *
 * - Ej01_Factorial_Fibonacci.md (recursión correcta con caso base)
 * - Debug02_Recursion_LogicError.java (otro tipo de error recursivo)
 */
