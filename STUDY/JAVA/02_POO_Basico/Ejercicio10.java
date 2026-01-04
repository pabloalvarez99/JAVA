/*
 * ========================================
 * EJERCICIO 10: Primera Clase - Persona
 * DIFICULTAD: ⭐⭐⭐⭐ (Medio-Alto)
 * ========================================
 *
 * OBJETIVO:
 * Crear tu primera clase con atributos y métodos
 *
 * INSTRUCCIONES:
 * 1. Crea una clase llamada "Persona" con:
 *    - Atributos privados: nombre (String), edad (int), altura (double)
 *    - Constructor que reciba nombre, edad y altura
 *    - Método "presentarse()" que imprima la información de la persona
 *    - Método "esMayorDeEdad()" que retorne true si la edad >= 18
 *
 * 2. En el main:
 *    - Crea 3 objetos Persona con diferentes datos
 *    - Llama al método presentarse() de cada uno
 *    - Verifica si cada persona es mayor de edad
 *
 * SALIDA ESPERADA:
 * Hola, soy Ana, tengo 25 años y mido 1.65m
 * ¿Es mayor de edad? true
 *
 * Hola, soy Luis, tengo 16 años y mido 1.70m
 * ¿Es mayor de edad? false
 *
 * Hola, soy María, tengo 30 años y mido 1.60m
 * ¿Es mayor de edad? true
 *
 */

// TODO: Crea la clase Persona aquí (ANTES de la clase Ejercicio10)
// La clase debe tener:
// - Atributos privados: nombre (String), edad (int), altura (double)
// - Constructor que reciba nombre, edad y altura
// - Método presentarse() que imprima la información de la persona
// - Método esMayorDeEdad() que retorne true si la edad >= 18
class Persona {
    private String nombre;
    private int edad;
    private double altura;
    
    public void Persona(String nombre, int edad, double altura) {
        this.nombre = nombre;
        this.edad = edad;
        this.altura = altura;
    } 
    public String presentarse() {
        return "Hola, soy " + nombre +", tengo " + edad + "años y mido " + altura + "m"; 
    } 
    public boolean esMayorDeEDad() {
        if (edad > 17) {
            return true;
        } else {return false;}
    }
}

public class Ejercicio10 {
    public static void main() {
        Persona p1 = new Persona("Pablo", 26, 1.75);
        Persona p2 = new Persona
    }
