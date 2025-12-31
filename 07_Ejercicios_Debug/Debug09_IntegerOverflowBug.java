/**
 * EJERCICIO DEBUG #9: IntegerOverflowBug
 * Dificultad: ⭐⭐⭐
 *
 * DESCRIPCIÓN:
 * El código calcula el factorial de 20, pero da resultado incorrecto.
 * No hay excepción, simplemente el número es wrong.
 *
 * PISTA: ¿Cuál es el valor máximo de un int en Java?
 *
 * SALIDA ESPERADA:
 * factorial(20) = 2432902008176640000
 *
 * SALIDA ACTUAL:
 * factorial(20) = -2102132736  (¡Número negativo incorrecto!)
 */

public class Debug09_IntegerOverflowBug {
    public static void main(String[] args) {
        // BUG: int no puede almacenar factorial(20)
        int resultado = factorial(20);
        System.out.println("factorial(20) = " + resultado);

        // Mostrar el problema
        System.out.println("\nDemostrando overflow:");
        System.out.println("Integer.MAX_VALUE = " + Integer.MAX_VALUE);
        System.out.println("Integer.MAX_VALUE + 1 = " + (Integer.MAX_VALUE + 1));
    }

    public static int factorial(int n) {
        int resultado = 1;
        for (int i = 2; i <= n; i++) {
            resultado *= i;  // Overflow silencioso cuando resultado > MAX_VALUE
        }
        return resultado;
    }
}

/*
 * ============================================
 * LÍMITES DE TIPOS NUMÉRICOS:
 * ============================================
 *
 * int:  -2,147,483,648 a 2,147,483,647 (2^31 - 1)
 * long: -9,223,372,036,854,775,808 a 9,223,372,036,854,775,807
 *
 * factorial(12) = 479,001,600      (cabe en int)
 * factorial(13) = 6,227,020,800    (overflow en int!)
 * factorial(20) = 2,432,902,008,176,640,000 (cabe en long)
 * factorial(21) = overflow en long también
 *
 * ============================================
 * SOLUCIÓN:
 * ============================================
 *
 * Usar long para factoriales pequeños:
 * public static long factorial(int n) { ... }
 *
 * Usar BigInteger para factoriales grandes:
 * import java.math.BigInteger;
 * BigInteger.valueOf(n).multiply(...)
 *
 * ============================================
 * DESPUÉS DE RESOLVER, REFLEXIONA:
 * ============================================
 *
 * 1. ¿Por qué Java no lanza excepción en overflow?
 *
 * 2. ¿Cómo detectar overflow antes de que ocurra?
 *
 * 3. ¿Cuándo usar int vs long vs BigInteger?
 *
 * SOLUCIÓN: Ver soluciones/Debug09_Solucion.java
 */
