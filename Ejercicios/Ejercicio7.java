/*
 * ========================================
 * EJERCICIO 7: Arrays Básicos
 * DIFICULTAD: ⭐⭐⭐ (Medio)
 * ========================================
 *
 * OBJETIVO:
 * Aprender a trabajar con arrays (arreglos)
 *
 * INSTRUCCIONES:
 * 1. Crea un array de int con los valores: {5, 12, 8, 3, 20, 15}
 * 2. Imprime todos los elementos del array
 * 3. Calcula e imprime la suma de todos los elementos
 * 4. Encuentra e imprime el número más grande del array
 *
 * SALIDA ESPERADA:
 * Elementos del array:
 * 5 12 8 3 20 15
 *
 * Suma total: 63
 * Número más grande: 20
 *
 * PISTA:
 * - Declarar array: int[] numeros = {5, 12, 8, 3, 20, 15};
 * - Obtener longitud: numeros.length
 * - Acceder elemento: numeros[i]
 * - Para el máximo, usa una variable que vaya guardando el mayor
 */

public class Ejercicio7 {
    public static void main(String[] args) {
        int[] numeros = {5, 12, 8, 3, 20, 15};
        int suma = 0;
        int mayor = 0;
        System.out.println("Elementos del array:");
        for (int i = 0; i < numeros.length; i++) {
            System.out.print(numeros[i] + " ");
            suma += numeros[i];
            if (numeros[i] > mayor) {
                mayor = numeros[i];
            }
        }
        System.out.println("\nSuma total: " + suma);
        System.out.println("Numero mas grande: " + mayor);

    }
}
