/**
 * EJERCICIO DEBUG #2: InfiniteLoopBreaker
 * Dificultad: ⭐⭐
 *
 * DESCRIPCIÓN:
 * El siguiente código entra en un loop infinito.
 * Encuentra el bug y corrígelo.
 *
 * PISTA: Revisa las condiciones del loop y las variables de control.
 *
 * SALIDA ESPERADA:
 * Procesando: 1
 * Procesando: 2
 * Procesando: 3
 * Procesando: 4
 * Procesando: 5
 * Total procesados: 5
 *
 * SALIDA ACTUAL:
 * Procesando: 1
 * Procesando: 1
 * Procesando: 1
 * ... (nunca termina)
 */

public class Debug02_InfiniteLoopBreaker {
    public static void main(String[] args) {
        int[] numeros = {1, 2, 3, 4, 5};
        int i = 0;
        int contador = 0;

        // BUG: La variable 'i' nunca se incrementa dentro del loop
        while (i < numeros.length) {
            System.out.println("Procesando: " + numeros[i]);
            contador++;
            // Falta: i++;
        }

        System.out.println("Total procesados: " + contador);
    }
}

/*
 * ============================================
 * DESPUÉS DE RESOLVER, REFLEXIONA:
 * ============================================
 *
 * 1. ¿Por qué es fácil olvidar incrementar la variable?
 *
 * 2. ¿Cómo un loop 'for' previene este error?
 *
 * 3. ¿Cómo un enhanced for loop (for-each) lo previene?
 *
 * 4. ¿Qué harías si el programa se congela? (Ctrl+C para terminar)
 *
 * SOLUCIÓN: Ver soluciones/Debug02_Solucion.java
 */
