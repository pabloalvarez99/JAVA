/*
 * ========================================
 * EJERCICIO 4: Condicional IF
 * DIFICULTAD: ⭐⭐ (Fácil)
 * ========================================
 *
 * OBJETIVO:
 * Aprender a usar condicionales if-else
 *
 * INSTRUCCIONES:
 * 1. Crea una variable "edad" con un valor numérico
 * 2. Si la edad es menor a 18, imprime "Eres menor de edad"
 * 3. Si la edad es entre 18 y 65, imprime "Eres adulto"
 * 4. Si la edad es mayor a 65, imprime "Eres adulto mayor"
 *
 * SALIDA ESPERADA (con edad = 25):
 * Eres adulto
 *
 * SALIDA ESPERADA (con edad = 15):
 * Eres menor de edad
 *
 * SALIDA ESPERADA (con edad = 70):
 * Eres adulto mayor
 *
 * PISTA:
 * - Usa if, else if, else
 * - Usa operadores de comparación: <, >, <=, >=, ==
 * - Usa operadores lógicos: && (y), || (o)
 */

public class Ejercicio4 {
    public static void main(String[] args) {
        // TODO: Declara la variable edad
        int edad = 25;  // Cambia este valor para probar
        if (edad < 18) {
            System.out.println("Eres menor de edad");
        }
        if (edad > 18 && edad < 65) {
            System.out.println("Eres adulto");
        }
        if (edad > 65 ) {
            System.out.println("Eres adulto mayor");
        }                
        
    }
}
