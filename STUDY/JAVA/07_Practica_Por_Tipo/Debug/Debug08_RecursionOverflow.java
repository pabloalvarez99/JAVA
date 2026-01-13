/**
 * EJERCICIO DEBUG #8: RecursionOverflow
 * Dificultad: ⭐⭐⭐
 *
 * DESCRIPCIÓN:
 * El código calcula factorial pero causa StackOverflowError.
 * Hay un problema con el caso base.
 *
 * PISTA: ¿Cuándo debe parar la recursión?
 *
 * SALIDA ESPERADA:
 * factorial(5) = 120
 *
 * SALIDA ACTUAL:
 * Exception in thread "main" java.lang.StackOverflowError
 */

public class Debug08_RecursionOverflow {
    public static void main(String[] args) {
        int resultado = factorial(5);
        System.out.println("factorial(5) = " + resultado);
    }

    // BUG: El caso base nunca se alcanza para números positivos
    public static int factorial(int n) {
        if (n == 0) {  // BUG: ¿Qué pasa con n negativos?
            return 1;
        }
        // BUG: Si n es negativo, esto es recursión infinita
        return n * factorial(n - 1);
    }
}

/*
 * ============================================
 * CASOS DE PRUEBA PROBLEMÁTICOS:
 * ============================================
 *
 * factorial(5)  -> 5 * 4 * 3 * 2 * 1 * factorial(0) = 120 ✓
 * factorial(0)  -> 1 ✓
 * factorial(-1) -> -1 * factorial(-2) * factorial(-3)... ¡INFINITO!
 *
 * ============================================
 * SOLUCIÓN ROBUSTA:
 * ============================================
 *
 * public static int factorial(int n) {
 *     if (n < 0) {
 *         throw new IllegalArgumentException("n debe ser >= 0");
 *     }
 *     if (n <= 1) {
 *         return 1;
 *     }
 *     return n * factorial(n - 1);
 * }
 *
 * ============================================
 * DESPUÉS DE RESOLVER, REFLEXIONA:
 * ============================================
 *
 * 1. ¿Qué es un caso base y por qué es esencial?
 *
 * 2. ¿Cómo identificar recursión infinita antes de ejecutar?
 *
 * 3. ¿Cuándo usar iteración vs recursión?
 *
 * SOLUCIÓN: Ver soluciones/Debug08_Solucion.java
 */
