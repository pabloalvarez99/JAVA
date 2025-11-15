/*

 * ========================================
 * EJERCICIO 13: Relaciones entre Objetos (Composición)
 * DIFICULTAD: ⭐⭐⭐⭐ (Medio-Alto)
 * ========================================
 *
 * OBJETIVO:
 * Aprender a crear relaciones más complejas entre objetos donde un objeto
 * contiene referencias a otros objetos y pueden comunicarse entre sí.
 *
 * CONCEPTO CLAVE:
 * COMPOSICIÓN: "tiene un" (has-a relationship)
 * - Un Libro TIENE UN Autor
 * - Una Biblioteca TIENE MUCHOS Libros
 * - Un Autor puede escribir MUCHOS Libros
 *
 * Este tipo de relación es fundamental en POO. Los objetos del mundo real
 * están interconectados, y tu código debe reflejar estas conexiones.
 *
 * INSTRUCCIONES:
 * 1. Crea una clase "Autor" con:
 *    - Atributos privados: nombre (String), nacionalidad (String)
 *    - Constructor que reciba nombre y nacionalidad
 *    - Getters para ambos atributos
 *    - Método "toString()" que retorne: "Nombre (Nacionalidad)"
 *
 * 2. Crea una clase "Libro" con:
 *    - Atributos privados: titulo (String), autor (Autor), anio (int), paginas (int)
 *    - Constructor que reciba todos los parámetros
 *    - Getters para todos los atributos
 *    - Método "esLargo()" - retorna true si tiene más de 300 páginas
 *    - Método "mostrarInfo()" - muestra toda la información del libro
 *
 * 3. Crea una clase "Biblioteca" con:
 *    - Atributo privado: libros (Libro[]) - máximo 100 libros
 *    - Atributo privado: cantidadLibros (int)
 *    - Constructor sin parámetros
 *    - Método "agregarLibro(Libro libro)"
 *    - Método "buscarPorAutor(String nombreAutor)" - imprime libros de ese autor
 *    - Método "contarLibrosLargos()" - cuenta cuántos libros son largos
 *    - Método "libroMasAntiguo()" - retorna el libro con menor año
 *
 * 4. En el main:
 *    - Crea 3 autores
 *    - Crea 5 libros de diferentes autores
 *    - Crea una biblioteca
 *    - Agrega todos los libros
 *    - Busca libros por autor
 *    - Muestra estadísticas
 *
 * SALIDA ESPERADA:
 * ====== Biblioteca Digital ======
 * Se agregaron 5 libros a la biblioteca.
 *
 * ====== Libros de Gabriel García Márquez ======
 * Cien años de soledad (1967) - 417 páginas
 *   Autor: Gabriel García Márquez (Colombiana)
 *
 * El amor en los tiempos del cólera (1985) - 368 páginas
 *   Autor: Gabriel García Márquez (Colombiana)
 *
 * ====== Estadísticas ======
 * Libros largos (>300 pág): 3 de 5
 * Libro más antiguo: Don Quijote de la Mancha (1605)
 *
 * CONCEPTOS NUEVOS:
 * - Composición: objetos dentro de objetos
 * - Referencias entre objetos
 * - Navegación entre objetos (libro.getAutor().getNombre())
 * - Búsqueda y filtrado en colecciones de objetos
 */

// TODO: Crea la clase Autor







// TODO: Crea la clase Libro









// TODO: Crea la clase Biblioteca









public class Ejercicio13 {
    public static void main(String[] args) {
        // TODO: Crea autores
        // Ejemplo: Autor autor1 = new Autor("Gabriel García Márquez", "Colombiana");




        // TODO: Crea libros con sus autores
        // Ejemplo: Libro libro1 = new Libro("Cien años de soledad", autor1, 1967, 417);






        // TODO: Crea biblioteca y agrega libros
        // Biblioteca biblioteca = new Biblioteca();
        // biblioteca.agregarLibro(libro1);





        // TODO: Busca libros por autor



        // TODO: Muestra estadísticas




    }
}
