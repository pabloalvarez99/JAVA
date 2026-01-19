/*
 * EJERCICIO TRACING: Recursión con Doble Llamada
 * DIFICULTAD: ⭐⭐⭐⭐⭐ (5/10)
 * TIEMPO: 20 minutos
 *
 * INSTRUCCIONES:
 * Este ejercicio tiene DOS llamadas recursivas (como Fibonacci).
 * Sin ejecutar el código, predice la salida del programa.
 *
 * TÉCNICA PARA DOBLE RECURSIÓN:
 * 1. Dibuja un árbol de llamadas (no una pila)
 * 2. Procesa primero la rama izquierda completa
 * 3. Luego la rama derecha
 * 4. Combina los resultados al subir
 */

public class Tracing02_Recursion_DobleCall {

    public static int arbol(int n) {
        System.out.println("Entrando: arbol(" + n + ")");

        if (n <= 1) {
            System.out.println("Base: arbol(" + n + ") = " + n);
            return n;
        }

        int izq = arbol(n - 1);
        int der = arbol(n - 2);
        int resultado = izq + der;

        System.out.println("arbol(" + n + ") = " + izq + " + " + der + " = " + resultado);
        return resultado;
    }

    public static void main(String[] args) {
        System.out.println("=== Calculando arbol(4) ===\n");
        int valor = arbol(4);
        System.out.println("\n=== Valor final: " + valor + " ===");
    }
}

/*
 * ╔══════════════════════════════════════════════════════════════╗
 * ║                    SECCIÓN DE PREDICCIÓN                      ║
 * ║         (Completa ANTES de ejecutar el código)                ║
 * ╚══════════════════════════════════════════════════════════════╝
 *
 * PASO 1: Dibuja el árbol de llamadas
 *
 *                    arbol(4)
 *                   /        \
 *              arbol(?)     arbol(?)
 *              /    \         /    \
 *          arbol(?) arbol(?) arbol(?) ...
 *
 * PASO 2: ¿Cuántas veces se llama arbol() en total?
 * Tu respuesta: ____
 *
 * PASO 3: ¿Cuántas veces se alcanza el caso base?
 * Tu respuesta: ____
 *
 * PASO 4: ¿En qué orden se procesan las llamadas?
 * (Pista: primero toda la rama izquierda, luego la derecha)
 *
 * PASO 5: Predice el valor final de arbol(4):
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
 * ÁRBOL COMPLETO:
 *
 *                    arbol(4)
 *                   /        \
 *              arbol(3)     arbol(2)
 *              /    \         /    \
 *         arbol(2) arbol(1) arbol(1) arbol(0)
 *          /    \
 *     arbol(1) arbol(0)
 *
 * ORDEN DE PROCESAMIENTO (profundidad primero, izquierda primero):
 * 1. arbol(4) - entra
 * 2.   arbol(3) - entra (izq de 4)
 * 3.     arbol(2) - entra (izq de 3)
 * 4.       arbol(1) - BASE = 1
 * 5.       arbol(0) - BASE = 0
 * 6.     arbol(2) = 1 + 0 = 1
 * 7.     arbol(1) - BASE = 1 (der de 3)
 * 8.   arbol(3) = 1 + 1 = 2
 * 9.   arbol(2) - entra (der de 4)
 * 10.    arbol(1) - BASE = 1
 * 11.    arbol(0) - BASE = 0
 * 12.  arbol(2) = 1 + 0 = 1
 * 13. arbol(4) = 2 + 1 = 3
 *
 * SALIDA COMPLETA:
 * === Calculando arbol(4) ===
 *
 * Entrando: arbol(4)
 * Entrando: arbol(3)
 * Entrando: arbol(2)
 * Entrando: arbol(1)
 * Base: arbol(1) = 1
 * Entrando: arbol(0)
 * Base: arbol(0) = 0
 * arbol(2) = 1 + 0 = 1
 * Entrando: arbol(1)
 * Base: arbol(1) = 1
 * arbol(3) = 1 + 1 = 2
 * Entrando: arbol(2)
 * Entrando: arbol(1)
 * Base: arbol(1) = 1
 * Entrando: arbol(0)
 * Base: arbol(0) = 0
 * arbol(2) = 1 + 0 = 1
 * arbol(4) = 2 + 1 = 3
 *
 * === Valor final: 3 ===
 *
 * ESTADÍSTICAS:
 * - Total de llamadas: 9
 * - Casos base alcanzados: 5 (tres arbol(1) y dos arbol(0))
 * - Valor final: 3 (es Fibonacci de 4!)
 *
 * CONCEPTO CLAVE:
 * Este código calcula Fibonacci. La cantidad de llamadas crece
 * exponencialmente: O(2^n). Por eso Fibonacci recursivo simple
 * es muy ineficiente para valores grandes de n.
 */
