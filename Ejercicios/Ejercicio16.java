/*
 * ========================================
 * EJERCICIO 16: ArrayList - Sistema de Biblioteca
 * DIFICULTAD: ⭐⭐⭐⭐⭐⭐ (Muy Difícil)
 * ========================================
 *
 * OBJETIVO:
 * Aprender a usar ARRAYLIST - una lista dinámica de Java
 *
 * CONCEPTO CLAVE:
 * ArrayList es una estructura de datos que puede crecer y encogerse dinámicamente.
 * A diferencia de los arrays normales, no necesitas definir el tamaño inicial.
 *
 * DIFERENCIA: Array vs ArrayList
 * - Array: Tamaño FIJO, más rápido, sintaxis: int[] numeros = new int[5];
 * - ArrayList: Tamaño DINÁMICO, más flexible, sintaxis: ArrayList<Integer> numeros = new ArrayList<>();
 *
 * INSTRUCCIONES:
 * 1. Crea una clase "Libro" con:
 *    - Atributos privados: titulo (String), autor (String), anio (int), prestado (boolean)
 *    - Constructor que reciba título, autor y año (prestado empieza en false)
 *    - Getters para todos los atributos
 *    - Métodos "prestar()" y "devolver()" que cambien el estado de prestado
 *    - Método "toString()" que retorne la información del libro formateada
 *
 * 2. Crea una clase "Biblioteca" con:
 *    - Atributo privado: ArrayList<Libro> libros
 *    - Constructor que inicialice el ArrayList vacío
 *    - Método "agregarLibro(Libro libro)" - agrega un libro a la colección
 *    - Método "mostrarTodosLosLibros()" - muestra todos los libros
 *    - Método "buscarPorTitulo(String titulo)" - busca y retorna un libro (o null)
 *    - Método "mostrarLibrosDisponibles()" - muestra solo los no prestados
 *    - Método "contarLibros()" - retorna el total de libros
 *    - Método "eliminarLibro(String titulo)" - elimina un libro por título
 *
 * 3. En el main:
 *    - Crea una biblioteca
 *    - Agrega 5 libros
 *    - Muestra todos los libros
 *    - Presta 2 libros
 *    - Muestra solo los disponibles
 *    - Busca un libro por título
 *    - Devuelve un libro
 *    - Elimina un libro
 *    - Muestra el total de libros
 *
 * SALIDA ESPERADA:
 * === SISTEMA DE BIBLIOTECA ===
 *
 * Libro agregado: Cien años de soledad
 * Libro agregado: Don Quijote
 * ...
 *
 * === TODOS LOS LIBROS ===
 * 1. Cien años de soledad - Gabriel García Márquez (1967) [Disponible]
 * 2. Don Quijote - Miguel de Cervantes (1605) [Disponible]
 * ...
 *
 * Prestando: Cien años de soledad
 * Prestando: Don Quijote
 *
 * === LIBROS DISPONIBLES ===
 * 1. El principito - Antoine de Saint-Exupéry (1943) [Disponible]
 * ...
 *
 * Total de libros en la biblioteca: 4
 *
 * CONCEPTOS NUEVOS:
 * - ArrayList<Tipo>: Colección dinámica de objetos
 * - .add(elemento): Agrega un elemento al final
 * - .get(índice): Obtiene un elemento por posición
 * - .size(): Retorna el tamaño actual
 * - .remove(índice): Elimina un elemento
 * - .contains(elemento): Verifica si existe un elemento
 * - Enhanced for: for (Libro libro : libros) { ... }
 *
 * PISTA:
 * - Importa: import java.util.ArrayList;
 * - Crear: ArrayList<Libro> libros = new ArrayList<>();
 * - Agregar: libros.add(new Libro("Titulo", "Autor", 2020));
 * - Recorrer: for (Libro libro : libros) { System.out.println(libro); }
 */

import java.util.ArrayList;

// TODO: Crea la clase Libro
class Libro {
    // Atributos privados
    private String titulo;
    private String autor;
    private int anio;
    private boolean prestado;

    // Constructor
    public Libro(String titulo, String autor, int anio) {
        // TODO: Inicializa los atributos



    }

    // Getters
    public String getTitulo() {
        return titulo;
    }

    public String getAutor() {
        return autor;
    }

    public int getAnio() {
        return anio;
    }

    public boolean isPrestado() {
        return prestado;
    }

    // Métodos para prestar y devolver
    public void prestar() {
        // TODO: Cambia prestado a true

    }

    public void devolver() {
        // TODO: Cambia prestado a false

    }

    // toString: representa el objeto como String
    @Override
    public String toString() {
        String estado = prestado ? "Prestado" : "Disponible";
        return titulo + " - " + autor + " (" + anio + ") [" + estado + "]";
    }
}

// TODO: Crea la clase Biblioteca
class Biblioteca {
    // Atributo: ArrayList de Libros
    private ArrayList<Libro> libros;

    // Constructor
    public Biblioteca() {
        // TODO: Inicializa el ArrayList vacío
        libros = new ArrayList<>();
    }

    // Método agregarLibro
    public void agregarLibro(Libro libro) {
        // TODO: Agrega el libro al ArrayList

        System.out.println("Libro agregado: " + libro.getTitulo());
    }

    // Método mostrarTodosLosLibros
    public void mostrarTodosLosLibros() {
        System.out.println("\n=== TODOS LOS LIBROS ===");
        // TODO: Recorre el ArrayList e imprime cada libro
        // for (int i = 0; i < libros.size(); i++) {
        //     System.out.println((i + 1) + ". " + libros.get(i));
        // }


    }

    // Método mostrarLibrosDisponibles
    public void mostrarLibrosDisponibles() {
        System.out.println("\n=== LIBROS DISPONIBLES ===");
        // TODO: Recorre e imprime solo los no prestados
        int contador = 1;


    }

    // Método buscarPorTitulo
    public Libro buscarPorTitulo(String titulo) {
        // TODO: Busca y retorna el libro (o null si no existe)


        return null; // Si no se encuentra
    }

    // Método contarLibros
    public int contarLibros() {
        // TODO: Retorna el tamaño del ArrayList
        return 0; // TEMPORAL: reemplaza esto con libros.size()
    }

    // Método eliminarLibro
    public void eliminarLibro(String titulo) {
        // TODO: Busca el libro y elimínalo del ArrayList
        // Pista: primero búscalo, luego usa libros.remove(libro)


    }
}

public class Ejercicio16 {
    public static void main(String[] args) {
        System.out.println("=== SISTEMA DE BIBLIOTECA ===\n");

        // TODO: Crea una biblioteca
        Biblioteca biblioteca = new Biblioteca();

        // TODO: Crea y agrega 5 libros
        // biblioteca.agregarLibro(new Libro("Cien años de soledad", "Gabriel García Márquez", 1967));
        // biblioteca.agregarLibro(new Libro("Don Quijote", "Miguel de Cervantes", 1605));
        // ... etc




        // TODO: Muestra todos los libros


        // TODO: Presta 2 libros
        System.out.println("\n=== PRESTANDO LIBROS ===");
        // Libro libro1 = biblioteca.buscarPorTitulo("Cien años de soledad");
        // if (libro1 != null) {
        //     libro1.prestar();
        //     System.out.println("Prestando: " + libro1.getTitulo());
        // }



        // TODO: Muestra solo los disponibles


        // TODO: Devuelve un libro
        System.out.println("\n=== DEVOLVIENDO LIBRO ===");


        // TODO: Elimina un libro
        System.out.println("\n=== ELIMINANDO LIBRO ===");


        // TODO: Muestra el total de libros
        System.out.println("\nTotal de libros en la biblioteca: " + biblioteca.contarLibros());

        // REFLEXIÓN:
        // ¿Cuándo usar ArrayList en vez de Array?
        // - Cuando no sabes cuántos elementos tendrás
        // - Cuando necesitas agregar/eliminar elementos frecuentemente
        // - Cuando quieres métodos útiles como .contains(), .indexOf(), etc.
        // - Para colecciones de objetos es más conveniente
    }
}
