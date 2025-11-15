/*
 * ========================================
 * DATOS DE PRUEBA - Ejercicios Muy Avanzados (21-36)
 * ========================================
 *
 * Este archivo contiene datos de prueba para ejercicios avanzados que incluyen:
 * - Algoritmos de ordenamiento y búsqueda
 * - Estructuras de datos (pilas, colas, listas enlazadas, árboles)
 * - Patrones de diseño
 * - Manejo de archivos
 * - Concurrencia
 *
 */

import java.util.*;

public class DatosPruebaMuyAvanzados {

    // ========================================
    // EJERCICIOS 21-23: Algoritmos de Ordenamiento
    // ========================================
    public static class AlgoritmosOrdenamiento {

        // Caso de prueba pequeño (para visualizar el proceso)
        public static final int[] ARRAY_PEQUEÑO = {64, 34, 25, 12, 22, 11, 90};

        // Caso de prueba mediano
        public static final int[] ARRAY_MEDIANO = {5, 2, 9, 1, 5, 6, 3, 8, 4, 7};

        // Caso de prueba grande
        public static final int[] ARRAY_GRANDE = {42, 23, 74, 11, 65, 58, 94, 36, 99, 87,
                                                    23, 67, 12, 45, 78, 90, 34, 56, 88, 21};

        // Caso especial: ya ordenado
        public static final int[] ARRAY_ORDENADO = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};

        // Caso especial: orden inverso
        public static final int[] ARRAY_INVERSO = {10, 9, 8, 7, 6, 5, 4, 3, 2, 1};

        // Caso especial: con duplicados
        public static final int[] ARRAY_DUPLICADOS = {5, 3, 8, 3, 9, 1, 5, 3, 8, 1};

        public static void mostrarDatos() {
            System.out.println("=== DATOS DE PRUEBA - ALGORITMOS DE ORDENAMIENTO ===\n");

            System.out.println("Array pequeño (visualización): " + Arrays.toString(ARRAY_PEQUEÑO));
            System.out.println("Array mediano: " + Arrays.toString(ARRAY_MEDIANO));
            System.out.println("Array grande (" + ARRAY_GRANDE.length + " elementos)");
            System.out.println("Array ya ordenado: " + Arrays.toString(ARRAY_ORDENADO));
            System.out.println("Array en orden inverso: " + Arrays.toString(ARRAY_INVERSO));
            System.out.println("Array con duplicados: " + Arrays.toString(ARRAY_DUPLICADOS));

            System.out.println("\nResultado esperado (array pequeño ordenado):");
            int[] copia = ARRAY_PEQUEÑO.clone();
            Arrays.sort(copia);
            System.out.println(Arrays.toString(copia));
        }
    }

    // ========================================
    // EJERCICIOS 24-25: Algoritmos de Búsqueda
    // ========================================
    public static class AlgoritmosBusqueda {

        public static final int[] ARRAY_ORDENADO = {2, 5, 8, 12, 16, 23, 38, 45, 56, 67, 78};

        public static final int VALOR_PRESENTE = 23; // Índice esperado: 5
        public static final int VALOR_AUSENTE = 30;  // No está en el array
        public static final int VALOR_PRIMERO = 2;   // Índice esperado: 0
        public static final int VALOR_ULTIMO = 78;   // Índice esperado: 10

        public static void mostrarDatos() {
            System.out.println("=== DATOS DE PRUEBA - ALGORITMOS DE BÚSQUEDA ===\n");

            System.out.println("Array ordenado: " + Arrays.toString(ARRAY_ORDENADO));
            System.out.println();

            System.out.println("Pruebas:");
            System.out.println("  Buscar " + VALOR_PRESENTE + " → Índice esperado: 5");
            System.out.println("  Buscar " + VALOR_AUSENTE + " → Índice esperado: -1 (no encontrado)");
            System.out.println("  Buscar " + VALOR_PRIMERO + " → Índice esperado: 0");
            System.out.println("  Buscar " + VALOR_ULTIMO + " → Índice esperado: " + (ARRAY_ORDENADO.length - 1));
        }
    }

    // ========================================
    // EJERCICIOS 17-18: Nodos y Listas Enlazadas
    // ========================================
    public static class ListasEnlazadas {

        public static final int[] VALORES_LISTA = {10, 20, 30, 40, 50};

        public static final int VALOR_AGREGAR_INICIO = 5;
        public static final int VALOR_AGREGAR_FINAL = 60;
        public static final int VALOR_BUSCAR_EXISTE = 30;
        public static final int VALOR_BUSCAR_NO_EXISTE = 99;
        public static final int VALOR_ELIMINAR = 30;

        public static void mostrarDatos() {
            System.out.println("=== DATOS DE PRUEBA - LISTAS ENLAZADAS ===\n");

            System.out.println("Valores iniciales: " + Arrays.toString(VALORES_LISTA));
            System.out.println();

            System.out.println("Operaciones:");
            System.out.println("  Agregar al inicio: " + VALOR_AGREGAR_INICIO);
            System.out.println("  Agregar al final: " + VALOR_AGREGAR_FINAL);
            System.out.println("  Buscar (existe): " + VALOR_BUSCAR_EXISTE + " → true");
            System.out.println("  Buscar (no existe): " + VALOR_BUSCAR_NO_EXISTE + " → false");
            System.out.println("  Eliminar: " + VALOR_ELIMINAR);

            System.out.println("\nLista esperada después de todas las operaciones:");
            System.out.println("[5, 10, 20, 40, 50, 60]");
        }
    }

    // ========================================
    // EJERCICIOS 19-20: Colecciones (LinkedList, Queue, Set)
    // ========================================
    public static class Colecciones {

        public static final String[] TAREAS_COLA = {
            "Tarea 1: Diseñar interfaz",
            "Tarea 2: Implementar backend",
            "Tarea 3: Escribir tests",
            "Tarea 4: Hacer deployment"
        };

        public static final Integer[] NUMEROS_SET = {5, 2, 8, 2, 9, 1, 5, 3, 8, 1, 7};
        public static final Integer[] RESULTADO_HASHSET = {1, 2, 3, 5, 7, 8, 9}; // Sin orden garantizado
        public static final Integer[] RESULTADO_TREESET = {1, 2, 3, 5, 7, 8, 9}; // Ordenado

        public static void mostrarDatos() {
            System.out.println("=== DATOS DE PRUEBA - COLECCIONES ===\n");

            System.out.println("Cola de tareas:");
            for (String tarea : TAREAS_COLA) {
                System.out.println("  " + tarea);
            }

            System.out.println("\nNúmeros con duplicados: " + Arrays.toString(NUMEROS_SET));
            System.out.println("Resultado en HashSet (sin duplicados): " + Arrays.toString(RESULTADO_HASHSET));
            System.out.println("Resultado en TreeSet (sin duplicados, ordenado): " + Arrays.toString(RESULTADO_TREESET));
        }
    }

    // ========================================
    // EJERCICIOS 32-34: Estructuras de Datos Avanzadas
    // ========================================
    public static class EstructurasAvanzadas {

        // Datos para Binary Search Tree
        public static final int[] VALORES_BST = {50, 30, 70, 20, 40, 60, 80};

        public static void mostrarDatos() {
            System.out.println("=== DATOS DE PRUEBA - ESTRUCTURAS AVANZADAS ===\n");

            System.out.println("Binary Search Tree - Valores de inserción:");
            System.out.println(Arrays.toString(VALORES_BST));
            System.out.println("\nEstructura esperada del árbol:");
            System.out.println("        50");
            System.out.println("       /  \\");
            System.out.println("      30   70");
            System.out.println("     / \\   / \\");
            System.out.println("    20 40 60 80");

            System.out.println("\nRecorridos esperados:");
            System.out.println("  In-order:    20, 30, 40, 50, 60, 70, 80");
            System.out.println("  Pre-order:   50, 30, 20, 40, 70, 60, 80");
            System.out.println("  Post-order:  20, 40, 30, 60, 80, 70, 50");
        }
    }

    // ========================================
    // EJERCICIO 33: File I/O
    // ========================================
    public static class FileIO {

        public static final String NOMBRE_ARCHIVO = "datos_prueba.txt";

        public static final String[] LINEAS_ESCRIBIR = {
            "Línea 1: Esto es una prueba",
            "Línea 2: De lectura y escritura de archivos",
            "Línea 3: En Java",
            "Línea 4: ¡Funciona correctamente!"
        };

        public static class Estudiante {
            public String nombre;
            public int edad;
            public double promedio;

            public Estudiante(String nombre, int edad, double promedio) {
                this.nombre = nombre;
                this.edad = edad;
                this.promedio = promedio;
            }
        }

        public static final Estudiante[] ESTUDIANTES_SERIALIZAR = {
            new Estudiante("Ana García", 20, 8.5),
            new Estudiante("Carlos López", 22, 7.8),
            new Estudiante("María Rodríguez", 21, 9.2)
        };

        public static void mostrarDatos() {
            System.out.println("=== DATOS DE PRUEBA - FILE I/O ===\n");

            System.out.println("Archivo de texto: " + NOMBRE_ARCHIVO);
            System.out.println("Contenido a escribir:");
            for (String linea : LINEAS_ESCRIBIR) {
                System.out.println("  " + linea);
            }

            System.out.println("\nObjetos a serializar:");
            for (Estudiante e : ESTUDIANTES_SERIALIZAR) {
                System.out.println("  " + e.nombre + ", " + e.edad + " años, promedio: " + e.promedio);
            }
        }
    }

    // ========================================
    // EJERCICIO 34: Patrones de Diseño
    // ========================================
    public static class PatronesDiseno {

        public static class DatosUsuario {
            public String nombre;
            public String email;
            public int edad;

            public DatosUsuario(String nombre, String email, int edad) {
                this.nombre = nombre;
                this.email = email;
                this.edad = edad;
            }
        }

        public static final DatosUsuario USUARIO_BUILDER =
            new DatosUsuario("Juan Pérez", "juan@example.com", 25);

        public static void mostrarDatos() {
            System.out.println("=== DATOS DE PRUEBA - PATRONES DE DISEÑO ===\n");

            System.out.println("Patrón Builder - Construir usuario:");
            System.out.println("  Nombre: " + USUARIO_BUILDER.nombre);
            System.out.println("  Email: " + USUARIO_BUILDER.email);
            System.out.println("  Edad: " + USUARIO_BUILDER.edad);

            System.out.println("\nPatrón Observer - Eventos a simular:");
            System.out.println("  1. Cambio de temperatura: 20°C → 25°C");
            System.out.println("  2. Cambio de temperatura: 25°C → 18°C");
        }
    }

    // ========================================
    // EJERCICIO 35: Threads (Concurrencia)
    // ========================================
    public static class Threads {

        public static final int NUMERO_THREADS = 3;
        public static final int ITERACIONES_POR_THREAD = 5;

        public static class DatosTarea {
            public String nombre;
            public int duracionMs;

            public DatosTarea(String nombre, int duracionMs) {
                this.nombre = nombre;
                this.duracionMs = duracionMs;
            }
        }

        public static final DatosTarea[] TAREAS = {
            new DatosTarea("Tarea A", 1000),
            new DatosTarea("Tarea B", 1500),
            new DatosTarea("Tarea C", 800)
        };

        public static void mostrarDatos() {
            System.out.println("=== DATOS DE PRUEBA - THREADS ===\n");

            System.out.println("Número de threads: " + NUMERO_THREADS);
            System.out.println("Iteraciones por thread: " + ITERACIONES_POR_THREAD);
            System.out.println();

            System.out.println("Tareas concurrentes:");
            for (DatosTarea t : TAREAS) {
                System.out.println("  " + t.nombre + " - Duración: " + t.duracionMs + "ms");
            }
        }
    }

    // ========================================
    // EJERCICIO 36: Collections Avanzadas
    // ========================================
    public static class CollectionsAvanzadas {

        public static class Producto {
            public String nombre;
            public double precio;
            public int prioridad;

            public Producto(String nombre, double precio, int prioridad) {
                this.nombre = nombre;
                this.precio = precio;
                this.prioridad = prioridad;
            }
        }

        public static final Producto[] PRODUCTOS = {
            new Producto("Laptop", 1200.0, 1),
            new Producto("Mouse", 25.0, 3),
            new Producto("Teclado", 80.0, 2),
            new Producto("Monitor", 300.0, 1),
            new Producto("Webcam", 60.0, 3)
        };

        public static final Map<String, Integer> INVENTARIO = new HashMap<>() {{
            put("Laptop", 5);
            put("Mouse", 20);
            put("Teclado", 15);
            put("Monitor", 8);
            put("Webcam", 12);
        }};

        public static void mostrarDatos() {
            System.out.println("=== DATOS DE PRUEBA - COLLECTIONS AVANZADAS ===\n");

            System.out.println("Productos (TreeMap - ordenados por nombre):");
            for (Producto p : PRODUCTOS) {
                System.out.println("  " + p.nombre + " - $" + p.precio + " (Prioridad: " + p.prioridad + ")");
            }

            System.out.println("\nInventario inicial:");
            for (Map.Entry<String, Integer> entry : INVENTARIO.entrySet()) {
                System.out.println("  " + entry.getKey() + ": " + entry.getValue() + " unidades");
            }

            System.out.println("\nPriorityQueue - Orden esperado por prioridad:");
            System.out.println("  1. Laptop, Monitor (prioridad 1)");
            System.out.println("  2. Teclado (prioridad 2)");
            System.out.println("  3. Mouse, Webcam (prioridad 3)");
        }
    }

    // ========================================
    // MAIN - Para ver todos los datos
    // ========================================
    public static void main(String[] args) {
        System.out.println("=== DATOS DE PRUEBA EJERCICIOS MUY AVANZADOS (21-36) ===\n");

        String[] secciones = {
            "Algoritmos de Ordenamiento",
            "Algoritmos de Búsqueda",
            "Listas Enlazadas",
            "Colecciones",
            "Estructuras Avanzadas",
            "File I/O",
            "Patrones de Diseño",
            "Threads",
            "Collections Avanzadas"
        };

        System.out.println("Secciones disponibles:");
        for (int i = 0; i < secciones.length; i++) {
            System.out.println("  " + (i + 1) + ". " + secciones[i]);
        }

        System.out.println("\nPara ver los datos de una sección, llama al método mostrarDatos()");
        System.out.println("Ejemplos:");
        System.out.println("  DatosPruebaMuyAvanzados.AlgoritmosOrdenamiento.mostrarDatos();");
        System.out.println("  DatosPruebaMuyAvanzados.Threads.mostrarDatos();");
    }
}
