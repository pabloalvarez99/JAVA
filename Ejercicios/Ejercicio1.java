/*
 * ========================================
 * EJERCICIO 1: Hola Mundo y Variables
 * DIFICULTAD: ⭐ (Muy Fácil)
 * ========================================
 *
 * OBJETIVO:
 * Aprender a declarar variables y mostrar valores en consola
 *
 * INSTRUCCIONES:
 * 1. Crea una variable llamada "nombre" de tipo String con tu nombre
 * 2. Crea una variable llamada "edad" de tipo int con tu edad
 * 3. Crea una variable llamada "altura" de tipo double con tu altura en metros (ej: 1.75)
 * 4. Imprime estos valores con el formato mostrado abajo
 *
 * SALIDA ESPERADA:
 * Hola, me llamo Pablo
 * Tengo 20 años
 * Mido 1.75 metros
 *
 * PISTA:
 * - Usa String para texto
 * - Usa int para números enteros
 * - Usa double para números decimales
 * - Usa System.out.println() para imprimir
 */

public class Ejercicio1 {
    public static void main(String[] args) {
        String nombre = "Pablo";
        int edad = 20;
        double altura = 1.75;
        System.out.println("Hola me llamo " + nombre);
        System.out.println("Tengo " + edad + " años");
        System.out.println("Mido " + altura + " metros");
    }
}
