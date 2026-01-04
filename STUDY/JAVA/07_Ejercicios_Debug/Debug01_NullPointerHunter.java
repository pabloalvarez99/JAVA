/**
 * EJERCICIO DEBUG #1: NullPointerHunter
 * Dificultad: ⭐⭐
 *
 * DESCRIPCIÓN:
 * El siguiente código tiene UN BUG que causa NullPointerException.
 * Encuéntralo y corrígelo.
 *
 * PISTA: El problema está en cómo se inicializan los objetos.
 *
 * SALIDA ESPERADA:
 * Estudiante: Juan Garcia
 * Curso: Programación Java
 * Nota: 85
 *
 * SALIDA ACTUAL:
 * Exception in thread "main" java.lang.NullPointerException
 */

public class Debug01_NullPointerHunter {
    public static void main(String[] args) {
        Estudiante est = new Estudiante();
        est.nombre = "Juan";
        est.apellido = "Garcia";

        // BUG: curso nunca fue inicializado
        est.curso.nombre = "Programación Java";
        est.curso.nota = 85;

        System.out.println("Estudiante: " + est.nombre + " " + est.apellido);
        System.out.println("Curso: " + est.curso.nombre);
        System.out.println("Nota: " + est.curso.nota);
    }
}

class Estudiante {
    String nombre;
    String apellido;
    Curso curso;  // Nunca se inicializa - causa NPE
}

class Curso {
    String nombre;
    int nota;
}

/*
 * ============================================
 * DESPUÉS DE RESOLVER, REFLEXIONA:
 * ============================================
 *
 * 1. ¿Por qué ocurrió el NullPointerException?
 *
 * 2. ¿Cómo podrías prevenir esto en el futuro?
 *    - Inicializar en el constructor
 *    - Usar Optional
 *    - Verificar null antes de usar
 *
 * 3. ¿Qué línea del stack trace te indica dónde está el problema?
 *
 * SOLUCIÓN: Ver soluciones/Debug01_Solucion.java
 */
