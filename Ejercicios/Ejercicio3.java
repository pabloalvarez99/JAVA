/*
 * ========================================
 * EJERCICIO 3: Intercambiar Variables
 * DIFICULTAD: ⭐⭐ (Fácil)
 * ========================================
 *
 * OBJETIVO:
 * Aprender a intercambiar valores entre variables
 *
 * INSTRUCCIONES:
 * 1. Crea dos variables: a = 10 y b = 20
 * 2. Muestra los valores iniciales
 * 3. Intercambia los valores (a debe tener 20 y b debe tener 10)
 * 4. Muestra los valores finales
 *
 * SALIDA ESPERADA:
 * Antes del intercambio:
 * a = 10
 * b = 20
 *
 * Después del intercambio:
 * a = 20
 * b = 10
 *
 */

public class Ejercicio3 {
    public static void main(String[] args) {
        int a = 10;
        int b = 20;
        int temp = a;
        System.out.println("Antes del intercambio:");
        System.out.println("a = " + a);
        System.out.println("b = " + b);
        a = b;
        b = temp;
        System.out.println("\nDespués del intercambio:");
        System.out.println("a = " + a);
        System.out.println("b = " + b);
    }
}
