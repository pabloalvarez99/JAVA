/*
 * ========================================
 * EJERCICIO 11: Clase Estudiante con Getters/Setters
 * DIFICULTAD: ⭐⭐⭐⭐ (Medio-Alto)
 * ========================================
 *
 * OBJETIVO:
 * Practicar ENCAPSULACIÓN con getters y setters
 *
 * INSTRUCCIONES:
 * 1. Crea una clase "Estudiante" con:
 *    - Atributos privados: nombre (String), nota1 (double), nota2 (double), nota3 (double)
 *    - Constructor que reciba el nombre (las notas empiezan en 0.0)
 *    - Getters para todos los atributos
 *    - Setters para las 3 notas (valida que sean entre 1.0 y 7.0)
 *    - Método "calcularPromedio()" que retorne el promedio de las 3 notas
 *    - Método "aprobo()" que retorne true si el promedio >= 4.0
 *
 * 2. En el main:
 *    - Crea un estudiante
 * 
 * 
 *    - Asigna las 3 notas usando setters
 *    - Muestra el promedio y si aprobó
 *
 * SALIDA ESPERADA:
 * Estudiante: Juan Pérez
 * Nota 1: 5.5
 * Nota 2: 6.0
 * Nota 3: 4.5
 * Promedio: 5.33
 * ¿Aprobó? true
 *
 */

// TODO: Crea la clase Estudiante
class Estudiante {
    // Atributos privados
    private String nombre;
    private double nota1 = 0.0;
    private double nota2 = 0.0;
    private double nota3 = 0.0;

    // Constructor
    public Estudiante(String nombre) {
        this.nombre = nombre;
    }
    // Getters
    public String getNombre() {
        return nombre;
    }
    public double getNota1() {
        return nota1;
    }
    public double getNota2() {
        return nota2;
    }
    public double getNota3() {
        return nota3;
    }
    // Setters (con validación)
    public void setNota1(double nota) {
        if (nota >= 1.0 && nota <= 7.0) {
            this.nota1 = nota;
        }
    }
    public void setNota2(double nota) {
        if (nota >= 1.0 && nota <= 7.0) {
            this.nota2 = nota;
        } 
    }
    public void setNota3(double nota) {
        if (nota >= 1.0 && nota <= 7.0) {
            this.nota3 = nota;
        } 
    }
    // Método calcularPromedio
    public double calcularPromedio() {
        return (this.nota1 + this.nota2 + this.nota3) / 3;
    } 
    // Método aprobo
    public boolean aprobo() {
        return calcularPromedio() >= 4.0;
    }
}



public class Ejercicio11 {
    public static void main(String[] args) {
        // TODO: Crea un estudiante
        Estudiante estudiante = new Estudiante("Pablo Figueroa"); 
        // TODO: Asigna las notas con setters
        estudiante.setNota1(3.7);
        estudiante.setNota2(3.7);
        estudiante.setNota3(5.2);

        // TODO: Muestra la información
        System.out.println("Estudiante: " + estudiante.getNombre());
        System.out.println("Nota 1: " + estudiante.getNota1());
        System.out.println("Nota 2: " + estudiante.getNota2());
        System.out.println("Nota 3: " + estudiante.getNota3());
        System.out.println("Promedio: " + estudiante.calcularPromedio());
        System.out.println("¿Aprobo? " + estudiante.aprobo());
    }
}
