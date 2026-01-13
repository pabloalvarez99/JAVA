/**
 * EJERCICIO TRACING #6: ExceptionFlow
 * Dificultad: ⭐⭐⭐
 *
 * INSTRUCCIONES:
 * 1. Lee el codigo sin ejecutarlo
 * 2. Escribe tu prediccion abajo
 * 3. Ejecuta y compara
 *
 * CONCEPTOS: Try-catch-finally, propagacion de excepciones, return en finally
 *
 * ============================================
 * ESCRIBE TU PREDICCION AQUI:
 * ============================================
 * Linea 1: _______________
 * Linea 2: _______________
 * Linea 3: _______________
 * Linea 4: _______________
 * Linea 5: _______________
 * Linea 6: _______________
 * Resultado metodo2: _______________
 * ============================================
 */

public class Tracing06_ExceptionFlow {
    public static void main(String[] args) {
        System.out.println("=== Test 1: Exception capturada ===");
        metodo1();

        System.out.println("\n=== Test 2: Return en finally ===");
        int resultado = metodo2();
        System.out.println("Resultado: " + resultado);
    }

    static void metodo1() {
        try {
            System.out.println("Try: antes del error");
            int x = 10 / 0;  // ArithmeticException
            System.out.println("Try: despues del error");
        } catch (ArithmeticException e) {
            System.out.println("Catch: capturada!");
        } finally {
            System.out.println("Finally: siempre ejecuta");
        }
        System.out.println("Despues del try-catch");
    }

    static int metodo2() {
        try {
            System.out.println("Try: retornando 1");
            return 1;
        } finally {
            System.out.println("Finally: retornando 2");
            return 2;  // Ojo! Esto sobrescribe el return del try
        }
    }
}

/*
 * ============================================
 * RESPUESTA CORRECTA (NO MIRAR ANTES):
 * ============================================
 *
 * === Test 1: Exception capturada ===
 * Try: antes del error
 * Catch: capturada!
 * Finally: siempre ejecuta
 * Despues del try-catch
 *
 * === Test 2: Return en finally ===
 * Try: retornando 1
 * Finally: retornando 2
 * Resultado: 2
 *
 * ============================================
 * EXPLICACION:
 * ============================================
 *
 * Test 1 (metodo1):
 * - "Try: despues del error" NUNCA se ejecuta (excepcion interrumpe)
 * - catch captura la excepcion, el programa continua normalmente
 * - finally SIEMPRE ejecuta, con o sin excepcion
 *
 * Test 2 (metodo2):
 * - El return en finally SOBRESCRIBE el return en try
 * - Esto es un anti-patron! Nunca hagas return en finally
 * - El compilador no advierte, pero es confuso
 *
 * CONCEPTO CLAVE:
 * - finally ejecuta SIEMPRE (excepto System.exit())
 * - finally puede modificar el flujo de return (malo!)
 */
