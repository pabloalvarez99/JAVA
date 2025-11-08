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
 * PISTA:
 * - Clase dentro del mismo archivo (antes o después de la clase principal)
 * - Constructor: public Persona(String nombre, int edad, double altura) { this.nombre = nombre; ... }
 * - Crear objeto: Persona p1 = new Persona("Ana", 25, 1.65);
 */

// TODO: Crea la clase Persona aquí (ANTES de la clase Ejercicio10)
class Persona {
    // Atributos privados
    private String nombre;
    private int edad;
    private double altura;
    // Constructor
    public Persona(String nombre, int edad, double altura) {
        this.nombre = nombre;       
        this.edad = edad;
        this.altura = altura;
    }
    // Método presentarse
    public static void presentarse(Persona p) {
        System.out.println("Hola, soy " + p.nombre + ", tengo " + p.edad + " años y mido " + p.altura + "m");

    }
    // Método esMayorDeEdad
    public String esMayorDeEdad(Persona p) {
        System.out.print("¿Es mayor de edad? ");
        if (p.edad >= 18) {
            return "true";
        } else {
            return "false";
        }
    }

}

public class Ejercicio10 {
    public static void main(String[] args) {
        // TODO: Crea 3 objetos Persona
        Persona p1 =  new Persona("Pablo", 25, 1.75);
        Persona p2 =  new Persona("Juana", 17, 1.40);
        Persona p3 =  new Persona("Ernesto", 69, 1.50);

        // TODO: Llama a presentarse() y esMayorDeEdad() para cada persona
        Persona.presentarse(p1);
        System.out.println(p1.esMayorDeEdad(p1));
        Persona.presentarse(p2);
        System.out.println(p2.esMayorDeEdad(p2));
        Persona.presentarse(p3);
        System.out.println(p3.esMayorDeEdad(p3));
    }
}
