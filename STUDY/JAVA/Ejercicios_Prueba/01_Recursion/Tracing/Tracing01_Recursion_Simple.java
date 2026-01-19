/*
 * EJERCICIO TRACING: Recursión Simple
 * DIFICULTAD: ⭐⭐⭐ (3/10)
 * TIEMPO: 10 minutos
 *
 * INSTRUCCIONES:
 * Sin ejecutar el código, predice la salida del programa.
 * Traza cada llamada recursiva en papel.
 *
 * TÉCNICA DE TRACING:
 * 1. Dibuja una pila de llamadas
 * 2. Anota los parámetros de cada llamada
 * 3. Marca cuándo se alcanza el caso base
 * 4. Desenrolla la pila anotando los valores de retorno
 */

public class Tracing01_Recursion_Simple {

    public static int misterio(int n) {
        System.out.println("Entrando con n = " + n);

        if (n <= 0) {
            System.out.println("Caso base alcanzado, retornando 0");
            return 0;
        }

        int resultado = n + misterio(n - 2);
        System.out.println("n = " + n + ", resultado = " + resultado);
        return resultado;
    }

    public static void main(String[] args) {
        System.out.println("=== Llamada misterio(5) ===");
        int valor = misterio(5);
        System.out.println("Valor final: " + valor);
    }
}

/*
 * ╔══════════════════════════════════════════════════════════════╗
 * ║                    SECCIÓN DE PREDICCIÓN                      ║
 * ║         (Completa ANTES de ejecutar el código)                ║
 * ╚══════════════════════════════════════════════════════════════╝
 *
 * PASO 1: Dibuja la pila de llamadas
 *
 * Llamada 1: misterio(5)
 *     └── Llamada 2: misterio(?)
 *         └── Llamada 3: misterio(?)
 *             └── Llamada 4: misterio(?)
 *
 * PASO 2: ¿Cuántas veces se imprime "Entrando con n = "?
 * Tu respuesta: ____
 *
 * PASO 3: ¿Cuál es el valor de n cuando se alcanza el caso base?
 * Tu respuesta: ____
 *
 * PASO 4: Predice la salida completa del programa:
 * _______________________________________
 * _______________________________________
 * _______________________________________
 * _______________________________________
 * _______________________________________
 * _______________________________________
 * _______________________________________
 * _______________________________________
 *
 * PASO 5: ¿Cuál es el valor final retornado?
 * Tu respuesta: ____
 *
 * ══════════════════════════════════════════════════════════════
 *
 * SOLUCIÓN (no mirar hasta completar arriba):
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 * PILA DE LLAMADAS:
 * misterio(5) → espera misterio(3)
 *   misterio(3) → espera misterio(1)
 *     misterio(1) → espera misterio(-1)
 *       misterio(-1) → caso base, retorna 0
 *
 * DESENROLLANDO:
 * misterio(-1) = 0
 * misterio(1) = 1 + 0 = 1
 * misterio(3) = 3 + 1 = 4
 * misterio(5) = 5 + 4 = 9
 *
 * SALIDA COMPLETA:
 * === Llamada misterio(5) ===
 * Entrando con n = 5
 * Entrando con n = 3
 * Entrando con n = 1
 * Entrando con n = -1
 * Caso base alcanzado, retornando 0
 * n = 1, resultado = 1
 * n = 3, resultado = 4
 * n = 5, resultado = 9
 * Valor final: 9
 *
 * ANÁLISIS:
 * - 4 llamadas en total (5, 3, 1, -1)
 * - Caso base cuando n = -1 (n <= 0)
 * - Suma solo números impares positivos: 5 + 3 + 1 = 9
 */
