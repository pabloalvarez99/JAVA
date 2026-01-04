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

// TODO: Crea la clase Estudiante con:
// - Atributos privados: nombre (String), nota1 (double), nota2 (double), nota3 (double)
// - Constructor que reciba el nombre (las notas empiezan en 0.0)
// - Getters para todos los atributos
// - Setters para las 3 notas (valida que sean entre 1.0 y 7.0)
// - Método calcularPromedio() que retorne el promedio de las 3 notas
// - Método aprobo() que retorne true si el promedio >= 4.0

class Estudiante {
    private String nombre;
    private double nota1;
    private double nota2;
    private double nota3;

    public Estudiante(String nombre) {
        this.nombre = nombre;
        this.nota1 = 0.0;
        this.nota2 = 0.0;
        this.nota3 = 0.0;
    }

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

    public void setNota1(double nota) {
        this.nota1 = nota;
    }

    public void setNota2(double nota) {
        this.nota2 = nota;
    }

    public void setNota3(double nota) {
        this.nota3 = nota;
    }
    public double calcularPromedio() {
        return (nota1 + nota2 + nota3) / 3.0;
    }

    public boolean aprobo() {
        if (calcularPromedio() >= 4.0) {
            return true;
        } else {
            return false;
        }
    }
}

public class Ejercicio11 {
    public static void main(String[] args) {
        Estudiante est1 = new Estudiante("Pablo");
        est1.setNota1(5.8);
        est1.setNota2(3.3);
        est1.setNota3(6.3);
        System.out.println("Estudiante: " + est1.getNombre());
        System.out.println("Nota 1: " + est1.getNota1());
        System.out.println("Nota 2: " + est1.getNota2());
        System.out.println("Nota 3: " + est1.getNota3());
        System.out.println("Promedio: " + est1.calcularPromedio());
        System.out.println("¿Aprobo? " + est1.aprobo());
    }
}
    