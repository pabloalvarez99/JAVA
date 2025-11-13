/*
 * ========================================
 * EJERCICIO 6: Tabla de Multiplicar
 * DIFICULTAD: ⭐⭐ (Fácil)
 * ========================================
 *
 * OBJETIVO:
 * Combinar loops con operaciones matemáticas
 *
 * INSTRUCCIONES:
 * 1. Crea una variable "numero" con el valor 7
 * 2. Usa un loop for para imprimir la tabla de multiplicar del 7
 * 3. Muestra desde 7 x 1 hasta 7 x 10
 *
 * SALIDA ESPERADA:
 * Tabla de multiplicar del 7:
 * 7 x 1 = 7
 * 7 x 2 = 14
 * 7 x 3 = 21
 * 7 x 4 = 28
 * 7 x 5 = 35
 * 7 x 6 = 42
 * 7 x 7 = 49
 * 7 x 8 = 56
 * 7 x 9 = 63
 * 7 x 10 = 70
 *
 */

public class Ejercicio6 {
    public static void main(String[] args) {
        // TODO: Declara la variable numero
        int numero = 7;  // Cambia este valor para otras tablas

        System.out.println("Tabla de multiplicar del " + numero + ":");

        // TODO: Escribe el loop for para la tabla de multiplicar
        for (int i = 1; i <= 10; i++) {
            System.out.println(numero + " x " + i + " = " + (numero * i));
        }
    }
}
