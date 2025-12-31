/*
 * ========================================
 * VER DATOS DE PRUEBA - Herramienta Rápida
 * ========================================
 *
 * Ejecuta este archivo para ver rápidamente los datos de prueba
 * disponibles para cualquier ejercicio.
 *
 * USO:
 * 1. Compila: javac VerDatosPrueba.java DatosPrueba*.java
 * 2. Ejecuta: java VerDatosPrueba
 * 3. Selecciona el ejercicio que quieras ver
 *
 */

import java.util.Scanner;

public class VerDatosPrueba {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("=".repeat(60));
        System.out.println("  VISOR DE DATOS DE PRUEBA");
        System.out.println("=".repeat(60));
        System.out.println();

        while (true) {
            System.out.println("\nSelecciona un rango de ejercicios:");
            System.out.println("  1. Ejercicios Básicos (1-10)");
            System.out.println("  2. Ejercicios Intermedios (11-20)");
            System.out.println("  3. Ejercicios Avanzados (21-36)");
            System.out.println("  0. Salir");
            System.out.print("\nOpción: ");

            int opcion = scanner.nextInt();

            if (opcion == 0) {
                System.out.println("\n¡Hasta luego!");
                break;
            }

            switch (opcion) {
                case 1:
                    mostrarEjerciciosBasicos(scanner);
                    break;
                case 2:
                    mostrarEjerciciosIntermedios(scanner);
                    break;
                case 3:
                    mostrarEjerciciosAvanzados(scanner);
                    break;
                default:
                    System.out.println("Opción inválida");
            }
        }

        scanner.close();
    }

    static void mostrarEjerciciosBasicos(Scanner scanner) {
        System.out.println("\n" + "=".repeat(60));
        System.out.println("  EJERCICIOS BÁSICOS (1-10)");
        System.out.println("=".repeat(60));
        System.out.println("\n1 - Variables");
        System.out.println("2 - Operaciones Matemáticas");
        System.out.println("3 - Intercambiar Variables");
        System.out.println("4 - Condicionales");
        System.out.println("6 - Tabla de Multiplicar");
        System.out.println("7 - Arrays");
        System.out.println("8 - Métodos");
        System.out.println("9 - Arrays de Strings");
        System.out.println("10 - Clase Persona");
        System.out.println("0 - Volver");

        System.out.print("\nSelecciona ejercicio: ");
        int ej = scanner.nextInt();

        System.out.println();
        switch (ej) {
            case 1: DatosPrueba.Ejercicio1.mostrarDatos(); break;
            case 2: DatosPrueba.Ejercicio2.mostrarDatos(); break;
            case 3: DatosPrueba.Ejercicio3.mostrarDatos(); break;
            case 4: DatosPrueba.Ejercicio4.mostrarDatos(); break;
            case 6: DatosPrueba.Ejercicio6.mostrarDatos(); break;
            case 7: DatosPrueba.Ejercicio7.mostrarDatos(); break;
            case 8: DatosPrueba.Ejercicio8.mostrarDatos(); break;
            case 9: DatosPrueba.Ejercicio9.mostrarDatos(); break;
            case 10: DatosPrueba.Ejercicio10.mostrarDatos(); break;
            case 0: return;
            default: System.out.println("Ejercicio no disponible");
        }
    }

    static void mostrarEjerciciosIntermedios(Scanner scanner) {
        System.out.println("\n" + "=".repeat(60));
        System.out.println("  EJERCICIOS INTERMEDIOS (11-20)");
        System.out.println("=".repeat(60));
        System.out.println("\n11 - Estudiante con Getters/Setters");
        System.out.println("12 - Aula con Estudiantes");
        System.out.println("13 - Biblioteca con Autor y Libro");
        System.out.println("14 - ArrayList y ListaTareas");
        System.out.println("15 - Empresa, Departamento y Empleado");
        System.out.println("0 - Volver");

        System.out.print("\nSelecciona ejercicio: ");
        int ej = scanner.nextInt();

        System.out.println();
        switch (ej) {
            case 11: DatosPruebaAvanzados.Ejercicio11.mostrarDatos(); break;
            case 12: DatosPruebaAvanzados.Ejercicio12.mostrarDatos(); break;
            case 13: DatosPruebaAvanzados.Ejercicio13.mostrarDatos(); break;
            case 14: DatosPruebaAvanzados.Ejercicio14.mostrarDatos(); break;
            case 15: DatosPruebaAvanzados.Ejercicio15.mostrarDatos(); break;
            case 0: return;
            default: System.out.println("Ejercicio no disponible");
        }
    }

    static void mostrarEjerciciosAvanzados(Scanner scanner) {
        System.out.println("\n" + "=".repeat(60));
        System.out.println("  EJERCICIOS AVANZADOS (21-36)");
        System.out.println("=".repeat(60));
        System.out.println("\n1 - Algoritmos de Ordenamiento");
        System.out.println("2 - Algoritmos de Búsqueda");
        System.out.println("3 - Listas Enlazadas");
        System.out.println("4 - Colecciones (LinkedList, Queue, Set)");
        System.out.println("5 - Estructuras Avanzadas (BST)");
        System.out.println("6 - File I/O");
        System.out.println("7 - Patrones de Diseño");
        System.out.println("8 - Threads");
        System.out.println("9 - Collections Avanzadas");
        System.out.println("0 - Volver");

        System.out.print("\nSelecciona categoría: ");
        int cat = scanner.nextInt();

        System.out.println();
        switch (cat) {
            case 1: DatosPruebaMuyAvanzados.AlgoritmosOrdenamiento.mostrarDatos(); break;
            case 2: DatosPruebaMuyAvanzados.AlgoritmosBusqueda.mostrarDatos(); break;
            case 3: DatosPruebaMuyAvanzados.ListasEnlazadas.mostrarDatos(); break;
            case 4: DatosPruebaMuyAvanzados.Colecciones.mostrarDatos(); break;
            case 5: DatosPruebaMuyAvanzados.EstructurasAvanzadas.mostrarDatos(); break;
            case 6: DatosPruebaMuyAvanzados.FileIO.mostrarDatos(); break;
            case 7: DatosPruebaMuyAvanzados.PatronesDiseno.mostrarDatos(); break;
            case 8: DatosPruebaMuyAvanzados.Threads.mostrarDatos(); break;
            case 9: DatosPruebaMuyAvanzados.CollectionsAvanzadas.mostrarDatos(); break;
            case 0: return;
            default: System.out.println("Categoría no disponible");
        }
    }
}
