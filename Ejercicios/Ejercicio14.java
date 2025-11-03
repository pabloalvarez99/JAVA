/*
 * ========================================
 * EJERCICIO 14: Polimorfismo - Figuras Geométricas
 * DIFICULTAD: ⭐⭐⭐⭐⭐ (Difícil)
 * ========================================
 *
 * OBJETIVO:
 * Entender el POLIMORFISMO - "muchas formas"
 *
 * CONCEPTO CLAVE:
 * El polimorfismo permite que un objeto de la clase padre pueda tomar
 * la forma de cualquier clase hija. Es como decir:
 * "Todas son Figuras, pero cada una se comporta diferente"
 *
 * INSTRUCCIONES:
 * 1. Crea una clase abstracta "Figura" con:
 *    - Atributo protegido: nombre (String)
 *    - Constructor que reciba el nombre
 *    - Método abstracto "calcularArea()" que retorne double
 *    - Método abstracto "calcularPerimetro()" que retorne double
 *    - Método "mostrarInfo()" que imprima el nombre
 *
 * 2. Crea una clase "Rectangulo" que extienda Figura:
 *    - Atributos privados: base (double), altura (double)
 *    - Constructor que reciba base y altura
 *    - Implementa calcularArea(): base * altura
 *    - Implementa calcularPerimetro(): 2 * (base + altura)
 *
 * 3. Crea una clase "Circulo" que extienda Figura:
 *    - Atributo privado: radio (double)
 *    - Constante: PI = 3.14159
 *    - Constructor que reciba el radio
 *    - Implementa calcularArea(): PI * radio * radio
 *    - Implementa calcularPerimetro(): 2 * PI * radio
 *
 * 4. Crea una clase "Triangulo" que extienda Figura:
 *    - Atributos privados: base (double), altura (double), lado1, lado2, lado3
 *    - Constructor que reciba base, altura y los 3 lados
 *    - Implementa calcularArea(): (base * altura) / 2
 *    - Implementa calcularPerimetro(): lado1 + lado2 + lado3
 *
 * 5. En el main:
 *    - Crea un array de tipo Figura con las 3 figuras
 *    - Usa un bucle para mostrar el área y perímetro de cada una
 *
 * SALIDA ESPERADA:
 * === CALCULADORA DE FIGURAS ===
 *
 * Figura: Rectángulo
 * Área: 50.00
 * Perímetro: 30.00
 *
 * Figura: Círculo
 * Área: 78.54
 * Perímetro: 31.42
 *
 * Figura: Triángulo
 * Área: 12.00
 * Perímetro: 12.00
 *
 * CONCEPTOS NUEVOS:
 * - abstract class: Clase que no se puede instanciar directamente
 * - abstract method: Método sin implementación que debe ser sobrescrito
 * - Polimorfismo: Figura[] figuras = {new Rectangulo(...), new Circulo(...)};
 * - Cada figura calcula su área de manera diferente (muchas formas)
 *
 * PISTA:
 * - Clase abstracta: abstract class Figura { ... }
 * - Método abstracto: public abstract double calcularArea();
 * - Array polimórfico: Figura[] figuras = new Figura[3];
 */

// TODO: Crea la clase abstracta Figura
abstract class Figura {
    // Atributo protegido
    protected String nombre;

    // Constructor
    public Figura(String nombre) {
        // TODO: Inicializa el nombre

    }

    // Métodos abstractos (sin implementación)
    public abstract double calcularArea();
    public abstract double calcularPerimetro();

    // Método concreto
    public void mostrarInfo() {
        // TODO: Imprime el nombre de la figura

    }
}

// TODO: Crea la clase Rectangulo que extienda Figura
class Rectangulo extends Figura {
    // Atributos privados
    private double base;
    private double altura;

    // Constructor
    public Rectangulo(double base, double altura) {
        super("Rectángulo");
        // TODO: Inicializa base y altura


    }

    // Implementa calcularArea
    @Override
    public double calcularArea() {
        // TODO: Retorna base * altura
        return 0.0; // TEMPORAL: reemplaza esto
    }

    // Implementa calcularPerimetro
    @Override
    public double calcularPerimetro() {
        // TODO: Retorna 2 * (base + altura)
        return 0.0; // TEMPORAL: reemplaza esto
    }
}

// TODO: Crea la clase Circulo que extienda Figura
class Circulo extends Figura {
    // Atributos
    private double radio;
    private static final double PI = 3.14159;

    // Constructor
    public Circulo(double radio) {
        super("Círculo");
        // TODO: Inicializa el radio

    }

    // Implementa calcularArea
    @Override
    public double calcularArea() {
        // TODO: Retorna PI * radio * radio
        return 0.0; // TEMPORAL: reemplaza esto
    }

    // Implementa calcularPerimetro
    @Override
    public double calcularPerimetro() {
        // TODO: Retorna 2 * PI * radio
        return 0.0; // TEMPORAL: reemplaza esto
    }
}

// TODO: Crea la clase Triangulo que extienda Figura
class Triangulo extends Figura {
    // Atributos
    private double base;
    private double altura;
    private double lado1, lado2, lado3;

    // Constructor
    public Triangulo(double base, double altura, double lado1, double lado2, double lado3) {
        super("Triángulo");
        // TODO: Inicializa todos los atributos




    }

    // Implementa calcularArea
    @Override
    public double calcularArea() {
        // TODO: Retorna (base * altura) / 2
        return 0.0; // TEMPORAL: reemplaza esto
    }

    // Implementa calcularPerimetro
    @Override
    public double calcularPerimetro() {
        // TODO: Retorna lado1 + lado2 + lado3
        return 0.0; // TEMPORAL: reemplaza esto
    }
}

public class Ejercicio14 {
    public static void main(String[] args) {
        System.out.println("=== CALCULADORA DE FIGURAS ===\n");

        // TODO: Crea un array polimórfico de Figura
        // Figura[] figuras = new Figura[3];
        // figuras[0] = new Rectangulo(10, 5);
        // figuras[1] = new Circulo(5);
        // figuras[2] = new Triangulo(6, 4, 3, 4, 5);


        // TODO: Recorre el array e imprime información de cada figura
        // for (Figura figura : figuras) {
        //     System.out.println("Figura: " + figura.nombre);
        //     System.out.printf("Área: %.2f\n", figura.calcularArea());
        //     System.out.printf("Perímetro: %.2f\n\n", figura.calcularPerimetro());
        // }


        // REFLEXIÓN:
        // ¿Qué es el polimorfismo?
        // - Un array de tipo Figura puede contener Rectángulos, Círculos y Triángulos
        // - Cada uno calcula su área de manera diferente
        // - El mismo método (calcularArea) tiene "muchas formas" de comportarse
        // - Esto hace el código más flexible y escalable
    }
}
