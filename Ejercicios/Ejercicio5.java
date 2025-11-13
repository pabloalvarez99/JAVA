/*
 * ========================================
 * EJERCICIO 5: Loop FOR
 * DIFICULTAD: ⭐⭐ (Fácil)
 * ========================================
 *
 * OBJETIVO:
 * Aprender a usar el loop for para repetir acciones
 *
 * INSTRUCCIONES:
 * 1. Usa un loop for para imprimir los números del 1 al 10
 * 2. Usa otro loop for para imprimir los números pares del 2 al 20
 * 3. Usa otro loop for para imprimir la cuenta regresiva del 5 al 1
 *
 * SALIDA ESPERADA:
 * Números del 1 al 10:
 * 1 2 3 4 5 6 7 8 9 10
 *
 * Números pares del 2 al 20:
 * 2 4 6 8 10 12 14 16 18 20
 *
 * Cuenta regresiva:
 * 5 4 3 2 1 ¡Despegue!
 *
 */

public class Ejercicio5 {
    public static void main(String[] args) {
        // TODO: Loop 1 - Números del 1 al 10
        System.out.println("Números del 1 al 10:");
        for (int i = 1; i < 11; i++) {
            System.out.print(i+" ");
        }
        System.out.println("\nNúmeros pares del 2 al 20:");
        for (int i = 2; i < 21; i+=2) {
            System.out.print(i + " ");
        }

        // TODO: Loop 3 - Cuenta regresiva del 5 al 1
        System.out.println("\nCuenta regresiva:");
        for (int i = 5; i > 0; i--) {
            System.out.print(i + " ");
        }
        System.out.print("¡Despegue!");
    }
}
