/*
 * ========================================
 * DATOS DE PRUEBA - Ejercicios Avanzados (11-20)
 * ========================================
 *
 * Este archivo contiene datos de prueba predefinidos para los ejercicios
 * más avanzados que involucran clases, objetos y estructuras de datos.
 *
 */

import java.util.*;

public class DatosPruebaAvanzados {

    // ========================================
    // EJERCICIO 11: Estudiante con Getters/Setters
    // ========================================
    public static class Ejercicio11 {
        public static class DatosEstudiante {
            public String nombre;
            public double nota1, nota2, nota3;
            public double promedio;
            public boolean aprobo;

            public DatosEstudiante(String nombre, double nota1, double nota2, double nota3) {
                this.nombre = nombre;
                this.nota1 = nota1;
                this.nota2 = nota2;
                this.nota3 = nota3;
                this.promedio = (nota1 + nota2 + nota3) / 3.0;
                this.aprobo = promedio >= 4.0;
            }
        }

        public static final DatosEstudiante ESTUDIANTE_1 = new DatosEstudiante("Juan Pérez", 5.5, 6.0, 4.5);
        public static final DatosEstudiante ESTUDIANTE_2 = new DatosEstudiante("María González", 6.5, 6.2, 5.9);
        public static final DatosEstudiante ESTUDIANTE_3 = new DatosEstudiante("Pedro López", 3.2, 3.5, 3.8);

        public static void mostrarDatos() {
            System.out.println("=== DATOS DE PRUEBA EJERCICIO 11 ===\n");
            DatosEstudiante[] estudiantes = {ESTUDIANTE_1, ESTUDIANTE_2, ESTUDIANTE_3};

            for (DatosEstudiante e : estudiantes) {
                System.out.println("Estudiante: " + e.nombre);
                System.out.println("  Nota 1: " + e.nota1);
                System.out.println("  Nota 2: " + e.nota2);
                System.out.println("  Nota 3: " + e.nota3);
                System.out.printf("  Promedio: %.2f\n", e.promedio);
                System.out.println("  ¿Aprobó?: " + e.aprobo);
                System.out.println();
            }
        }
    }

    // ========================================
    // EJERCICIO 12: Aula con Estudiantes
    // ========================================
    public static class Ejercicio12 {
        public static final String NOMBRE_AULA = "Programación Java 101";

        public static class DatosEstudiante {
            public String nombre;
            public double nota1, nota2, nota3;

            public DatosEstudiante(String nombre, double nota1, double nota2, double nota3) {
                this.nombre = nombre;
                this.nota1 = nota1;
                this.nota2 = nota2;
                this.nota3 = nota3;
            }

            public double promedio() {
                return (nota1 + nota2 + nota3) / 3.0;
            }
        }

        public static final DatosEstudiante[] ESTUDIANTES = {
            new DatosEstudiante("Juan Pérez", 5.5, 6.0, 4.5),
            new DatosEstudiante("María González", 6.5, 6.2, 5.9),
            new DatosEstudiante("Pedro López", 3.2, 3.5, 3.8),
            new DatosEstudiante("Ana Martínez", 6.0, 5.8, 5.6)
        };

        public static void mostrarDatos() {
            System.out.println("=== DATOS DE PRUEBA EJERCICIO 12 ===\n");
            System.out.println("Nombre del aula: " + NOMBRE_AULA);
            System.out.println("Número de estudiantes: " + ESTUDIANTES.length);
            System.out.println();

            double sumaPromedios = 0;
            int aprobados = 0;

            for (DatosEstudiante e : ESTUDIANTES) {
                double prom = e.promedio();
                sumaPromedios += prom;
                if (prom >= 4.0) aprobados++;

                System.out.println("Estudiante: " + e.nombre);
                System.out.printf("  Notas: %.1f, %.1f, %.1f\n", e.nota1, e.nota2, e.nota3);
                System.out.printf("  Promedio: %.2f - Aprobó: %b\n", prom, prom >= 4.0);
                System.out.println();
            }

            System.out.println("Estadísticas esperadas:");
            System.out.printf("  Promedio del aula: %.2f\n", sumaPromedios / ESTUDIANTES.length);
            System.out.println("  Aprobados: " + aprobados + " de " + ESTUDIANTES.length);
            System.out.printf("  Porcentaje: %.2f%%\n", (aprobados * 100.0 / ESTUDIANTES.length));
        }
    }

    // ========================================
    // EJERCICIO 13: Biblioteca con Autor y Libro
    // ========================================
    public static class Ejercicio13 {
        public static class DatosAutor {
            public String nombre;
            public String nacionalidad;

            public DatosAutor(String nombre, String nacionalidad) {
                this.nombre = nombre;
                this.nacionalidad = nacionalidad;
            }
        }

        public static class DatosLibro {
            public String titulo;
            public DatosAutor autor;
            public int año;

            public DatosLibro(String titulo, DatosAutor autor, int año) {
                this.titulo = titulo;
                this.autor = autor;
                this.año = año;
            }
        }

        public static final DatosAutor[] AUTORES = {
            new DatosAutor("Gabriel García Márquez", "Colombiana"),
            new DatosAutor("Isabel Allende", "Chilena"),
            new DatosAutor("Mario Vargas Llosa", "Peruana")
        };

        public static final DatosLibro[] LIBROS = {
            new DatosLibro("Cien años de soledad", AUTORES[0], 1967),
            new DatosLibro("El amor en los tiempos del cólera", AUTORES[0], 1985),
            new DatosLibro("La casa de los espíritus", AUTORES[1], 1982),
            new DatosLibro("Eva Luna", AUTORES[1], 1987),
            new DatosLibro("La ciudad y los perros", AUTORES[2], 1963)
        };

        public static void mostrarDatos() {
            System.out.println("=== DATOS DE PRUEBA EJERCICIO 13 ===\n");

            System.out.println("Autores:");
            for (DatosAutor a : AUTORES) {
                System.out.println("  - " + a.nombre + " (" + a.nacionalidad + ")");
            }

            System.out.println("\nLibros:");
            for (DatosLibro l : LIBROS) {
                System.out.println("  - " + l.titulo);
                System.out.println("    Autor: " + l.autor.nombre);
                System.out.println("    Año: " + l.año);
                System.out.println();
            }
        }
    }

    // ========================================
    // EJERCICIO 14: ArrayList y ListaTareas
    // ========================================
    public static class Ejercicio14 {
        public static final String[] TAREAS = {
            "Estudiar para el examen de Java",
            "Completar ejercicios de programación",
            "Leer documentación de ArrayList",
            "Practicar debugging",
            "Revisar código de compañeros"
        };

        public static final int[] INDICES_COMPLETAR = {1, 3}; // Completar tareas en índices 1 y 3

        public static void mostrarDatos() {
            System.out.println("=== DATOS DE PRUEBA EJERCICIO 14 ===\n");

            System.out.println("Tareas a agregar:");
            for (int i = 0; i < TAREAS.length; i++) {
                System.out.println("  " + i + ". " + TAREAS[i]);
            }

            System.out.println("\nAcciones:");
            System.out.print("  Completar tareas en índices: ");
            for (int i : INDICES_COMPLETAR) {
                System.out.print(i + " ");
            }
            System.out.println();

            System.out.println("\nSalida esperada después de completar:");
            for (int i = 0; i < TAREAS.length; i++) {
                boolean completada = false;
                for (int idx : INDICES_COMPLETAR) {
                    if (idx == i) {
                        completada = true;
                        break;
                    }
                }
                String estado = completada ? "[X]" : "[ ]";
                System.out.println("  " + i + ". " + estado + " " + TAREAS[i]);
            }

            int pendientes = TAREAS.length - INDICES_COMPLETAR.length;
            System.out.println("\nTareas pendientes: " + pendientes);
        }
    }

    // ========================================
    // EJERCICIO 15: Empresa, Departamento y Empleado
    // ========================================
    public static class Ejercicio15 {
        public static class DatosEmpleado {
            public String nombre;
            public String cargo;
            public double salario;

            public DatosEmpleado(String nombre, String cargo, double salario) {
                this.nombre = nombre;
                this.cargo = cargo;
                this.salario = salario;
            }
        }

        public static class DatosDepartamento {
            public String nombre;
            public DatosEmpleado[] empleados;

            public DatosDepartamento(String nombre, DatosEmpleado[] empleados) {
                this.nombre = nombre;
                this.empleados = empleados;
            }

            public double salarioPromedio() {
                double suma = 0;
                for (DatosEmpleado e : empleados) {
                    suma += e.salario;
                }
                return suma / empleados.length;
            }
        }

        public static final String NOMBRE_EMPRESA = "TechCorp S.A.";

        public static final DatosDepartamento[] DEPARTAMENTOS = {
            new DatosDepartamento("Desarrollo", new DatosEmpleado[] {
                new DatosEmpleado("Carlos López", "Desarrollador Senior", 1800.0),
                new DatosEmpleado("Ana Martínez", "Desarrollador Junior", 1200.0),
                new DatosEmpleado("Luis García", "Tech Lead", 2500.0)
            }),
            new DatosDepartamento("Ventas", new DatosEmpleado[] {
                new DatosEmpleado("María Rodríguez", "Vendedor", 1000.0),
                new DatosEmpleado("Pedro Sánchez", "Gerente de Ventas", 2000.0)
            })
        };

        public static void mostrarDatos() {
            System.out.println("=== DATOS DE PRUEBA EJERCICIO 15 ===\n");
            System.out.println("Empresa: " + NOMBRE_EMPRESA);
            System.out.println("Número de departamentos: " + DEPARTAMENTOS.length);
            System.out.println();

            for (DatosDepartamento dept : DEPARTAMENTOS) {
                System.out.println("Departamento: " + dept.nombre);
                System.out.println("  Empleados: " + dept.empleados.length);

                for (DatosEmpleado emp : dept.empleados) {
                    System.out.println("    - " + emp.nombre + " (" + emp.cargo + ") - $" + emp.salario);
                }

                System.out.printf("  Salario promedio: $%.2f\n", dept.salarioPromedio());
                System.out.println();
            }
        }
    }

    // ========================================
    // MAIN - Para ver todos los datos
    // ========================================
    public static void main(String[] args) {
        System.out.println("=== DATOS DE PRUEBA EJERCICIOS AVANZADOS (11-20) ===\n");

        String[] opciones = {
            "11 - Estudiante con Getters/Setters",
            "12 - Aula con Estudiantes",
            "13 - Biblioteca con Autor y Libro",
            "14 - ArrayList y ListaTareas",
            "15 - Empresa, Departamento y Empleado"
        };

        System.out.println("Ejercicios disponibles:");
        for (String opcion : opciones) {
            System.out.println("  " + opcion);
        }

        System.out.println("\nPara ver los datos de un ejercicio específico,");
        System.out.println("llama al método mostrarDatos() de la clase correspondiente.");
        System.out.println("Ejemplo: DatosPruebaAvanzados.Ejercicio11.mostrarDatos();");
    }
}
