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
 * PISTAS:
 * - En Libro, guarda una referencia al objeto Autor: private Autor autor;
 * - En Biblioteca, recorre el array y compara: libro.getAutor().getNombre()
 * - Para el libro más antiguo, recorre y mantén el de menor año
 * - toString() sobrescribe un método heredado de Object (lo verás más adelante)
 *
 * CONCEPTOS NUEVOS:
 * - Composición: objetos dentro de objetos
 * - Referencias entre objetos
 * - Navegación entre objetos (libro.getAutor().getNombre())
 * - Búsqueda y filtrado en colecciones de objetos
 */

// TODO: Crea la clase Autor
class Autor {
    // TODO: Atributos privados
    private String autor;
    private String nacionalidad;

    // TODO: Constructor
    public Autor(String autor, String nacionalidad) {
        this.autor = autor;
        this.nacionalidad = nacionalidad;
    }

    // TODO: Getters
    public String getAutor() {
        return this.autor;
    }
    public String getNacionalidad() {
        return this.nacionalidad;
    }
    // TODO: Método toString()
    public String toString(Autor autor) {
        return autor.autor + " (" + autor.nacionalidad + ")";
    }
}

// TODO: Crea la clase Libro
class Libro {
    // TODO: Atributos privados
    private String titulo;
    private Autor autor;
    private int año;
    private int paginas;

    // TODO: Constructor
    public Libro(String titulo, Autor autor, int año, int paginas) {
        this.titulo = titulo;
        this.autor = autor;
        this.año = año;
        this.paginas = paginas;
    }

    // TODO: Getters
    public String getTitulo() {
        return this.titulo;
    }
    public Autor getAutor() {
        return this.autor;
    }
    public int getAño() {
        return this.año;
    }
    public int getPaginas() {
        return this.paginas;
    }
    // TODO: Método esLargo()
    public boolean esLargo(Libro libro) {
        if (libro.getPaginas() > 300) {
            return true;
        } else {
            return false;
        }
    } 

    // TODO: Método mostrarInfo()
    public static void mostrarInfo(Libro libro) {
        System.out.println(libro.getTitulo() + " (" + libro.getAño() + ") - " + libro.getAño() + " paginas\n  Autor:" + libro.getAutor() + " (" + libro.autor.getNacionalidad() +")");
    }
}

// TODO: Crea la clase Biblioteca
class Biblioteca {
    // TODO: Atributos privados
    private Libro[] libros = new Libro[100];
    private int cantidadLibros;
    // TODO: Constructor
    public Biblioteca() {
        this.cantidadLibros = cantidadLibros;
        this.libros =libros;
    }

    // TODO: Método agregarLibro
    public Libro agregarLibro(Libro[] libro) {
        for (libros : Libro[] libros ) {

        }
    }

    // TODO: Método buscarPorAutor


    // TODO: Método contarLibrosLargos


    // TODO: Método libroMasAntiguo

}

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

/*
 * ========================================
 * REFLEXIÓN Y PROFUNDIZACIÓN
 * ========================================
 *
 * ¿QUÉ APRENDISTE EN ESTE EJERCICIO?
 *
 * 1. COMPOSICIÓN VS HERENCIA:
 *    - Composición: "tiene un" (has-a) → Un Libro TIENE UN Autor
 *    - Herencia: "es un" (is-a) → Un Perro ES UN Animal (lo verás después)
 *    La composición es más flexible y se usa más en aplicaciones reales.
 *
 * 2. NAVEGACIÓN ENTRE OBJETOS:
 *    libro.getAutor().getNombre()
 *         ↓         ↓
 *    Objeto Libro → Objeto Autor → String nombre
 *
 *    Este "encadenamiento" es común en POO. Navegas a través de la
 *    estructura de objetos usando getters.
 *
 * 3. REFERENCIAS VS COPIAS:
 *    Cuando haces: Libro libro1 = new Libro("...", autor1, ...);
 *    El libro NO copia el autor - guarda una REFERENCIA al mismo objeto Autor.
 *    Si modificas el autor después, todos los libros de ese autor se ven afectados.
 *
 * 4. NULL SAFETY:
 *    ¿Qué pasa si haces libro.getAutor().getNombre() pero autor es null?
 *    ¡NullPointerException! Siempre valida antes:
 *    if (libro.getAutor() != null) { ... }
 *
 * CASOS DE USO EN EL MUNDO REAL:
 *
 * 1. SISTEMA DE PEDIDOS (E-COMMERCE):
 *    class Pedido {
 *        private Cliente cliente;
 *        private Producto[] productos;
 *        private DireccionEnvio direccion;
 *
 *        public double calcularTotal() {
 *            // Navega por productos y suma precios
 *        }
 *    }
 *
 * 2. RED SOCIAL:
 *    class Publicacion {
 *        private Usuario autor;
 *        private Comentario[] comentarios;
 *        private Like[] likes;
 *
 *        public boolean esPopular() {
 *            return likes.length > 100;
 *        }
 *    }
 *
 * 3. SISTEMA MÉDICO:
 *    class Paciente {
 *        private String nombre;
 *        private Medico[] medicos;
 *        private Cita[] citas;
 *        private HistoriaClinica historia;
 *    }
 *
 * 4. EMPRESA:
 *    class Empleado {
 * - Herencia para reutilizar código
 *        private Departamento departamento;
 *        private Cargo cargo;
 *        private Proyecto[] proyectos;
 *    }
 *
 * PATRONES DE DISEÑO:
 * Este ejercicio es la base para patrones como:
 * - Composite Pattern (estructuras de árbol)
 * - Facade Pattern (simplificar interfaces complejas)
 * - Decorator Pattern (agregar funcionalidad dinámicamente)
 *
 * MEJORA FUTURA:
 * Más adelante aprenderás sobre:
 * - ArrayList para colecciones dinámicas
 * - Interfaces para definir contratos
 */
