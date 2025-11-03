/*
 * ========================================
 * EJERCICIO 13: Herencia - Animales
 * DIFICULTAD: ⭐⭐⭐⭐⭐ (Difícil)
 * ========================================
 *
 * OBJETIVO:
 * Aprender sobre HERENCIA creando una jerarquía de clases
 *
 * CONCEPTO CLAVE:
 * La herencia permite que una clase "herede" atributos y métodos de otra clase.
 * - Clase PADRE (superclase): Animal
 * - Clases HIJAS (subclases): Perro, Gato
 * - Se usa la palabra clave "extends"
 *
 * INSTRUCCIONES:
 * 1. Crea una clase "Animal" (clase padre) con:
 *    - Atributos protegidos: nombre (String), edad (int)
 *    - Constructor que reciba nombre y edad
 *    - Método "hacerSonido()" que imprima "El animal hace un sonido"
 *    - Método "mostrarInfo()" que imprima nombre y edad
 *
 * 2. Crea una clase "Perro" que EXTIENDA de Animal:
 *    - Atributo privado: raza (String)
 *    - Constructor que reciba nombre, edad y raza
 *    - Sobrescribe el método "hacerSonido()" para que imprima "Guau guau!"
 *    - Método propio "traerPelota()" que imprima "[nombre] está trayendo la pelota"
 *
 * 3. Crea una clase "Gato" que EXTIENDA de Animal:
 *    - Atributo privado: color (String)
 *    - Constructor que reciba nombre, edad y color
 *    - Sobrescribe el método "hacerSonido()" para que imprima "Miau miau!"
 *    - Método propio "arañar()" que imprima "[nombre] está arañando el sofá"
 *
 * 4. En el main:
 *    - Crea un perro y un gato
 *    - Muestra la información de ambos
 *    - Haz que hagan sus sonidos
 *    - Llama a sus métodos propios
 *
 * SALIDA ESPERADA:
 * === PERRO ===
 * Nombre: Rex, Edad: 5 años
 * Guau guau!
 * Rex está trayendo la pelota
 *
 * === GATO ===
 * Nombre: Michi, Edad: 3 años
 * Miau miau!
 * Michi está arañando el sofá
 *
 * CONCEPTOS NUEVOS:
 * - extends: Indica que una clase hereda de otra
 * - super(): Llama al constructor de la clase padre
 * - @Override: Indica que estamos sobrescribiendo un método del padre
 * - protected: Permite que las clases hijas accedan a los atributos
 *
 * PISTA:
 * - Perro: class Perro extends Animal { ... }
 * - En el constructor del hijo: super(nombre, edad);
 * - @Override marca que estás reemplazando un método del padre
 */

// TODO: Crea la clase Animal (clase padre)
class Animal {
    // Atributos PROTEGIDOS (para que las clases hijas puedan acceder)
    protected String nombre;
    protected int edad;

    // Constructor
    public Animal(String nombre, int edad) {
        // TODO: Inicializa los atributos

    }

    // Método hacerSonido (será sobrescrito por las clases hijas)
    public void hacerSonido() {
        // TODO: Imprime "El animal hace un sonido"

    }

    // Método mostrarInfo
    public void mostrarInfo() {
        // TODO: Imprime el nombre y edad del animal

    }
}

// TODO: Crea la clase Perro que EXTIENDA de Animal
class Perro extends Animal {
    // Atributo privado propio de Perro
    private String raza;

    // Constructor
    public Perro(String nombre, int edad, String raza) {
        // TODO: Llama al constructor del padre con super()
        super(nombre, edad); // EJEMPLO: así se llama al constructor del padre
        // TODO: Inicializa la raza

    }

    // Sobrescribe el método hacerSonido
    @Override
    public void hacerSonido() {
        // TODO: Imprime "Guau guau!"

    }

    // Método propio de Perro
    public void traerPelota() {
        // TODO: Imprime que el perro está trayendo la pelota

    }
}

// TODO: Crea la clase Gato que EXTIENDA de Animal
class Gato extends Animal {
    // Atributo privado propio de Gato
    private String color;

    // Constructor
    public Gato(String nombre, int edad, String color) {
        super(nombre, edad); // EJEMPLO: llamada al padre
        // TODO: Inicializa el color

    }

    // Sobrescribe el método hacerSonido
    @Override
    public void hacerSonido() {
        // TODO: Imprime "Miau miau!"

    }

    // Método propio de Gato
    public void arañar() {
        // TODO: Imprime que el gato está arañando

    }
}

public class Ejercicio13 {
    public static void main(String[] args) {
        System.out.println("=== HERENCIA EN JAVA ===\n");

        // TODO: Crea un perro
        // Perro miPerro = new Perro("Rex", 5, "Labrador");


        // TODO: Muestra la información del perro
        System.out.println("=== PERRO ===");


        // TODO: Haz que el perro haga su sonido


        // TODO: Haz que traiga la pelota


        System.out.println();

        // TODO: Crea un gato
        // Gato miGato = new Gato("Michi", 3, "Naranja");


        // TODO: Muestra la información del gato
        System.out.println("=== GATO ===");


        // TODO: Haz que el gato haga su sonido


        // TODO: Haz que el gato arañe


        // REFLEXIÓN:
        // ¿Qué ventajas tiene usar herencia?
        // - Reutilización de código (no repetimos nombre y edad)
        // - Organización lógica (Perro y Gato SON animales)
        // - Cada clase hija puede tener su propio comportamiento
    }
}
