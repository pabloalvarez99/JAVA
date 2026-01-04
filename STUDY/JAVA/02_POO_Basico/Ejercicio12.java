/*
 * ========================================
 * EJERCICIO 12: Múltiples Objetos Interactuando (Aula con Estudiantes)
 * DIFICULTAD: ⭐⭐⭐⭐ (Medio-Alto)
 * ========================================
 *
 * OBJETIVO:
 * Aprender a trabajar con múltiples objetos que interactúan entre sí
 * y practicar el manejo de colecciones de objetos (arrays de objetos)
 *
 * CONCEPTO CLAVE:
 * En el mundo real, los objetos no existen aislados - interactúan entre sí.
 * Por ejemplo, un Aula contiene múltiples Estudiantes. Esta es una relación
 * de "contención" - un objeto contiene una colección de otros objetos.
 *
 * INSTRUCCIONES:
 * 1. REUTILIZA la clase "Estudiante" del ejercicio anterior (copia el código)
 *    - Ya tiene: nombre, nota1, nota2, nota3
 *    - Ya tiene: getters, setters, calcularPromedio(), aprobo()
 *
 * 2. Crea una clase "Aula" con:
 *    - Atributo privado: nombre (String) - ej: "Programación Java 101"
 *    - Atributo privado: estudiantes (Estudiante[]) - array de máximo 30 estudiantes
 *    - Atributo privado: cantidadEstudiantes (int) - cuántos hay actualmente
 *    - Constructor que reciba el nombre del aula (inicializa array vacío)
 *    - Método "agregarEstudiante(Estudiante est)" - agrega un estudiante al aula
 *    - Método "mostrarEstudiantes()" - muestra todos los estudiantes y sus promedios
 *    - Método "calcularPromedioAula()" - calcula el promedio general del aula
 *    - Método "contarAprobados()" - retorna cuántos estudiantes aprobaron
 *
 * 3. En el main:
 *    - Crea un aula
 *    - Crea 4 estudiantes con diferentes not
 *    - Agrégalos al aula
 *    - Muestra todos los estudiantes
 *    - Muestra estadísticas del aula
 *
 * SALIDA ESPERADA:
 * ====== Aula: Programación Java 101 ======
 *
 * Estudiante: Juan Pérez
 *   Promedio: 5.33 - Aprobó: true
 *
 * Estudiante: María González
 *   Promedio: 6.20 - Aprobó: true
 *
 * Estudiante: Pedro López
 *   Promedio: 3.50 - Aprobó: false
 *
 * Estudiante: Ana Martínez
 *   Promedio: 5.80 - Aprobó: true
 *
 * ====== Estadísticas del Aula ======
 * Promedio General: 5.21
 * Estudiantes Aprobados: 3 de 4
 * Porcentaje de Aprobación: 75.00%
 *
 * CONCEPTOS NUEVOS:
 * - Arrays de objetos (no primitivos)
 * - Objetos que contienen otros objetos
 * - Relaciones entre clases (composición)
 * - Cálculos agregados sobre colecciones
 */

// TODO: Copia la clase Estudiante del ejercicio anterior (Ejercicio11)

import java.util.ArrayList;

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
// TODO: Crea la clase Aula
class Aula {
    private String nombre;
    private Estudiante[] estudiantes;
    private int cantidadEstudiantes;
    
    public Aula(String nombre) {
        estudiantes = new Estudiante[30];
        this.nombre = nombre;
        cantidadEstudiantes = 0;
    }

    public int getCantidadEstudiantes() {
        return cantidadEstudiantes;
    }

    public void agregarEstudiante(Estudiante est) {
        if (cantidadEstudiantes < estudiantes.length) {
            estudiantes[cantidadEstudiantes] = est;
            cantidadEstudiantes++;
        } else {
            System.out.println("Aula lleno");
        }
    }

    public void mostrarEstudiantes() {
        for (int i = 0; i < cantidadEstudiantes; i++) {
            System.out.println("Estudiante: " + estudiantes[i].getNombre());
            System.out.println("  Promedio: " + estudiantes[i].calcularPromedio() + "- Aprobó: " + estudiantes[i].aprobo());
        }
    }

    public double calcularPromedioAula() {
        double suma = 0;
        for (int i = 0; i < cantidadEstudiantes; i++) {
            suma += estudiantes[i].calcularPromedio();
        }
        return suma/cantidadEstudiantes;
    }
    
    public int contarAprobados() {
        int aprobados = 0;
        for (int i = 0; i < cantidadEstudiantes; i++) {
            if (estudiantes[i].aprobo() == true) {
                aprobados++;
            }
        }
        return aprobados;
    }
}


public class Ejercicio12 {
    public static void main(String[] args) {
        // TODO: Crea un aula
        Aula aula = new Aula("programacion Java 1010");
        // TODO: Crea 4 estudiantes con diferentes notas
        Estudiante est1 = new Estudiante("Juan Perez");
        est1.setNota1(5.2);
        est1.setNota2(4.2);
        est1.setNota3(6.2);
        Estudiante est2 = new Estudiante("Maria Gonzales");
        est2.setNota1(3.2);
        est2.setNota2(4.2);
        est2.setNota3(5.2);
        Estudiante est3 = new Estudiante("Pedro Lopez");
        est3.setNota1(2.2);
        est3.setNota2(4.2);
        est3.setNota3(1.2);
        Estudiante est4 = new Estudiante("Ana Martinez");
        est4.setNota1(2.2);
        est4.setNota2(4.2);
        est4.setNota3(3.2);
        // TODO: Agrega los estudiantes al aula
        aula.agregarEstudiante(est1);
        aula.agregarEstudiante(est2);
        aula.agregarEstudiante(est3);
        aula.agregarEstudiante(est4);
        // TODO: Muestra todos los estudiantes
        aula.mostrarEstudiantes();
        // TODO: Muestra estadísticas (promedio general, aprobados, porcentaje)
        System.out.println("Estadisticas del Aula");
        System.out.println("Promedio General: " + aula.calcularPromedioAula());
        System.out.println("Estudiantes Aprobados: " + aula.contarAprobados() + " de " + aula.getCantidadEstudiantes());
        double porcentaje = (aula.getCantidadEstudiantes() == 0) ? 0.0 : (((double) aula.contarAprobados() / aula.getCantidadEstudiantes())*100);
        System.out.printf("Porcentaje de Aprobacion: %.2f%%%n",porcentaje);



    }
}
