/**
 * EJERCICIO TRACING #7: RecursionTrace
 * Dificultad: ⭐⭐⭐
 *
 * INSTRUCCIONES:
 * 1. Lee el codigo sin ejecutarlo
 * 2. Dibuja la pila de llamadas en papel
 * 3. Escribe tu prediccion abajo
 * 4. Ejecuta y compara
 *
 * CONCEPTOS: Recursion, call stack, caso base
 *
 * ============================================
 * ESCRIBE TU PREDICCION AQUI:
 * ============================================
 * (Escribe cada linea de salida)
 * _______________
 * _______________
 * _______________
 * _______________
 * _______________
 * _______________
 * _______________
 * _______________
 * ============================================
 */

public class Tracing07_RecursionTrace {
    public static void main(String[] args) {
        System.out.println("Resultado: " + misterio(4));
    }

    static int misterio(int n) {
        System.out.println("Entrando: n = " + n);

        if (n <= 1) {
            System.out.println("Caso base: retornando 1");
            return 1;
        }

        int resultado = n * misterio(n - 1);
        System.out.println("Saliendo: n = " + n + ", resultado = " + resultado);

        return resultado;
    }
}

/*
 * ============================================
 * RESPUESTA CORRECTA (NO MIRAR ANTES):
 * ============================================
 *
 * Entrando: n = 4
 * Entrando: n = 3
 * Entrando: n = 2
 * Entrando: n = 1
 * Caso base: retornando 1
 * Saliendo: n = 2, resultado = 2
 * Saliendo: n = 3, resultado = 6
 * Saliendo: n = 4, resultado = 24
 * Resultado: 24
 *
 * ============================================
 * EXPLICACION:
 * ============================================
 *
 * Este es el factorial! misterio(4) = 4!
 *
 * PILA DE LLAMADAS (visualizacion):
 *
 *    misterio(4)           <- espera resultado
 *      misterio(3)         <- espera resultado
 *        misterio(2)       <- espera resultado
 *          misterio(1)     <- caso base, retorna 1
 *        <- 2 * 1 = 2
 *      <- 3 * 2 = 6
 *    <- 4 * 6 = 24
 *
 * CONCEPTO CLAVE:
 * - Cada llamada recursiva ESPERA a que la siguiente termine
 * - Los "Entrando" se imprimen al BAJAR por la pila
 * - Los "Saliendo" se imprimen al SUBIR (desenrollando)
 *
 * EJERCICIO EXTRA:
 * Que pasa con misterio(0)? Y con misterio(-1)?
 */
