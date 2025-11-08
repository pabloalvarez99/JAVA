/*
 * ========================================
 * EJERCICIO 30: Comparator y Comparable - Ordenamiento Personalizado
 * DIFICULTAD: ⭐⭐⭐⭐⭐⭐⭐⭐⭐⭐ (Experto)
 * ========================================
 *
 * OBJETIVO:
 * Dominar el ordenamiento personalizado en Java usando Comparable (orden natural)
 * y Comparator (múltiples criterios de ordenamiento)
 *
 * CONCEPTO CLAVE:
 * En Java, podemos ordenar objetos de dos maneras:
 *
 * 1. COMPARABLE: Define el orden "natural" de una clase
 *    - Interface con método: int compareTo(T other)
 *    - Se implementa EN la clase que queremos ordenar
 *    - Solo permite UNA forma de ordenar
 *
 * 2. COMPARATOR: Define órdenes alternativos
 *    - Interface con método: int compare(T o1, T o2)
 *    - Se implementa en clases separadas
 *    - Permite MÚLTIPLES formas de ordenar
 *
 * ========================================
 * COMPARABLE - ORDEN NATURAL
 * ========================================
 *
 * ANALOGÍA:
 * Es como la forma "predeterminada" de ordenar algo.
 * Ejemplo: Los números se ordenan de menor a mayor (orden natural).
 *
 * IMPLEMENTACIÓN:
 * class Persona implements Comparable<Persona> {
 *     String nombre;
 *     int edad;
 *
 *     @Override
 *     public int compareTo(Persona otra) {
 *         // Retornar:
 *         // NEGATIVO si this < otra
 *         // CERO si this == otra
 *         // POSITIVO si this > otra
 *         return this.edad - otra.edad; // Orden por edad
 *     }
 * }
 *
 * USO:
 * List<Persona> personas = new ArrayList<>();
 * Collections.sort(personas); // Usa compareTo()
 *
 * ========================================
 * COMPARATOR - ÓRDENES ALTERNATIVOS
 * ========================================
 *
 * ANALOGÍA:
 * Es como tener diferentes "reglas de ordenamiento".
 * Ejemplo: Ordenar canciones por título, por artista, por duración, etc.
 *
 * IMPLEMENTACIÓN:
 * class OrdenarPorNombre implements Comparator<Persona> {
 *     @Override
 *     public int compare(Persona p1, Persona p2) {
 *         return p1.nombre.compareTo(p2.nombre);
 *     }
 * }
 *
 * // Con Lambda (Java 8+)
 * Comparator<Persona> porNombre = (p1, p2) -> p1.nombre.compareTo(p2.nombre);
 *
 * USO:
 * Collections.sort(personas, new OrdenarPorNombre());
 * Collections.sort(personas, porNombre);
 *
 * ========================================
 * COMPARATOR CON LAMBDAS (MODERNO)
 * ========================================
 *
 * Java 8+ proporciona métodos helper para crear Comparators fácilmente:
 *
 * // Comparar por un campo
 * Comparator<Persona> porEdad = Comparator.comparing(p -> p.edad);
 *
 * // Comparar por método getter
 * Comparator<Persona> porNombre = Comparator.comparing(Persona::getNombre);
 *
 * // Orden reverso
 * Comparator<Persona> porEdadDesc = Comparator.comparing(Persona::getEdad).reversed();
 *
 * // Múltiples criterios (thenComparing)
 * Comparator<Persona> complejo = Comparator
 *     .comparing(Persona::getCiudad)
 *     .thenComparing(Persona::getEdad)
 *     .thenComparing(Persona::getNombre);
 *
 * ========================================
 * VALORES DE RETORNO
 * ========================================
 *
 * compareTo(other) y compare(o1, o2) retornan int:
 *
 * < 0  (negativo):  this < other  (o  o1 < o2)
 * = 0  (cero):      this == other (o  o1 == o2)
 * > 0  (positivo):  this > other  (o  o1 > o2)
 *
 * EJEMPLOS:
 * // Orden ascendente (menor a mayor)
 * return this.edad - otra.edad;
 *
 * // Orden descendente (mayor a menor)
 * return otra.edad - this.edad;
 *
 * // Orden alfabético
 * return this.nombre.compareTo(otra.nombre);
 *
 * INSTRUCCIONES:
 * 1. Crea clase Producto con: id, nombre, precio, categoria, stock
 *    - Implementa Comparable para orden por precio (ascendente)
 *
 * 2. Crea Comparators personalizados:
 *    - OrdenarPorNombre: alfabético por nombre
 *    - OrdenarPorStock: de mayor a menor stock
 *    - OrdenarPorCategoria: por categoría y luego por precio
 *
 * 3. Crea clase Estudiante con: nombre, promedio, edad, carrera
 *    - Implementa Comparable para orden por promedio (descendente)
 *
 * 4. Demuestra todos los ordenamientos con ejemplos prácticos
 *
 * SALIDA ESPERADA:
 * === COMPARATOR Y COMPARABLE - ORDENAMIENTO PERSONALIZADO ===
 *
 * === PRODUCTOS ORIGINALES ===
 * 1. Laptop (Electrónica) - $999.99 | Stock: 15
 * 2. Mouse (Electrónica) - $25.50 | Stock: 50
 * 3. Escritorio (Muebles) - $299.00 | Stock: 8
 * 4. Silla (Muebles) - $150.00 | Stock: 12
 * 5. Teclado (Electrónica) - $75.00 | Stock: 30
 *
 * === ORDEN NATURAL: Por Precio (Comparable) ===
 * 1. Mouse (Electrónica) - $25.50 | Stock: 50
 * 2. Teclado (Electrónica) - $75.00 | Stock: 30
 * 3. Silla (Muebles) - $150.00 | Stock: 12
 * 4. Escritorio (Muebles) - $299.00 | Stock: 8
 * 5. Laptop (Electrónica) - $999.99 | Stock: 15
 *
 * === ORDENAR POR: Nombre (A-Z) ===
 * 1. Escritorio (Muebles) - $299.00 | Stock: 8
 * 2. Laptop (Electrónica) - $999.99 | Stock: 15
 * 3. Mouse (Electrónica) - $25.50 | Stock: 50
 * 4. Silla (Muebles) - $150.00 | Stock: 12
 * 5. Teclado (Electrónica) - $75.00 | Stock: 30
 *
 * === ORDENAR POR: Stock (Mayor a Menor) ===
 * 1. Mouse (Electrónica) - $25.50 | Stock: 50
 * 2. Teclado (Electrónica) - $75.00 | Stock: 30
 * 3. Laptop (Electrónica) - $999.99 | Stock: 15
 * 4. Silla (Muebles) - $150.00 | Stock: 12
 * 5. Escritorio (Muebles) - $299.00 | Stock: 8
 *
 * === ORDENAR POR: Categoría y luego Precio ===
 * 1. Mouse (Electrónica) - $25.50 | Stock: 50
 * 2. Teclado (Electrónica) - $75.00 | Stock: 30
 * 3. Laptop (Electrónica) - $999.99 | Stock: 15
 * 4. Silla (Muebles) - $150.00 | Stock: 12
 * 5. Escritorio (Muebles) - $299.00 | Stock: 8
 *
 * === ESTUDIANTES: Orden Natural (Por Promedio - Mayor a Menor) ===
 * 1. Ana García - Promedio: 9.5 (20 años) - Ingeniería
 * 2. Carlos López - Promedio: 8.8 (22 años) - Medicina
 * 3. María Pérez - Promedio: 8.2 (21 años) - Derecho
 * 4. Juan Rodríguez - Promedio: 7.5 (23 años) - Arquitectura
 *
 * === COMPARACIÓN DE RENDIMIENTO ===
 * Productos antes de ordenar: [Laptop, Mouse, Escritorio, Silla, Teclado]
 * Productos después de ordenar: [Mouse, Teclado, Silla, Escritorio, Laptop]
 *
 * CONCEPTOS NUEVOS:
 * - Comparable<T>: Interface para orden natural
 * - Comparator<T>: Interface para órdenes personalizados
 * - compareTo(): Método de Comparable
 * - compare(): Método de Comparator
 * - Collections.sort(): Ordenamiento de listas
 * - Lambdas para Comparators
 * - Comparator.comparing(): Factory method
 * - thenComparing(): Encadenamiento de criterios
 * - reversed(): Orden inverso
 *
 * COMPARABLE vs COMPARATOR:
 *
 * COMPARABLE:
 * ✓ Una sola forma de ordenar (orden natural)
 * ✓ Se implementa en la clase misma
 * ✓ Modifica la clase original
 * ✓ Uso: Collections.sort(lista)
 * ✗ No permite múltiples ordenamientos
 *
 * COMPARATOR:
 * ✓ Múltiples formas de ordenar
 * ✓ No modifica la clase original
 * ✓ Se puede crear sin acceso al código fuente
 * ✓ Uso: Collections.sort(lista, comparator)
 * ✓ Flexible y reutilizable
 *
 * CUÁNDO USAR CADA UNO:
 *
 * USA COMPARABLE si:
 * - Hay una forma "obvia" de ordenar (ej: números, fechas)
 * - Controlas el código fuente de la clase
 * - Solo necesitas un criterio de ordenamiento
 *
 * USA COMPARATOR si:
 * - Necesitas múltiples criterios de ordenamiento
 * - No controlas el código fuente
 * - Quieres ordenamientos opcionales/dinámicos
 * - Necesitas ordenar de diferentes formas en diferentes contextos
 *
 * PISTAS:
 * - Comparable: implements Comparable<Producto>
 * - compareTo: return this.precio.compareTo(otro.precio)
 * - Comparator: implements Comparator<Producto>
 * - compare: return p1.nombre.compareTo(p2.nombre)
 * - Orden descendente: intercambia p1 y p2
 * - Para números: Integer.compare(a, b) o Double.compare(a, b)
 * - Collections.sort() modifica la lista original
 */

import java.util.*;

// ========================================
// CLASE PRODUCTO (con Comparable)
// ========================================

// TODO: Implementa Producto con Comparable para ordenar por precio
class Producto implements Comparable<Producto> {
    private int id;
    private String nombre;
    private double precio;
    private String categoria;
    private int stock;

    public Producto(int id, String nombre, double precio, String categoria, int stock) {
        this.id = id;
        this.nombre = nombre;
        this.precio = precio;
        this.categoria = categoria;
        this.stock = stock;
    }

    // Getters
    public int getId() { return id; }
    public String getNombre() { return nombre; }
    public double getPrecio() { return precio; }
    public String getCategoria() { return categoria; }
    public int getStock() { return stock; }

    // TODO: Implementa compareTo para orden natural por precio (ascendente)
    @Override
    public int compareTo(Producto otro) {
        // Comparar precios (menor a mayor)
        return Double.compare(this.precio, otro.precio);
    }

    @Override
    public String toString() {
        return String.format("%s (%s) - $%.2f | Stock: %d",
            nombre, categoria, precio, stock);
    }
}

// ========================================
// COMPARATORS PERSONALIZADOS
// ========================================

// TODO: Comparator para ordenar por nombre alfabéticamente
class OrdenarPorNombre implements Comparator<Producto> {
    @Override
    public int compare(Producto p1, Producto p2) {
        return p1.getNombre().compareTo(p2.getNombre());
    }
}

// TODO: Comparator para ordenar por stock (mayor a menor)
class OrdenarPorStock implements Comparator<Producto> {
    @Override
    public int compare(Producto p1, Producto p2) {
        // Mayor a menor (orden descendente)
        return Integer.compare(p2.getStock(), p1.getStock());
    }
}

// TODO: Comparator para ordenar por categoría y luego por precio
class OrdenarPorCategoriaYPrecio implements Comparator<Producto> {
    @Override
    public int compare(Producto p1, Producto p2) {
        // Primero por categoría
        int categoriaComparacion = p1.getCategoria().compareTo(p2.getCategoria());

        // Si las categorías son iguales, ordenar por precio
        if (categoriaComparacion == 0) {
            return Double.compare(p1.getPrecio(), p2.getPrecio());
        }

        return categoriaComparacion;
    }
}

// ========================================
// CLASE ESTUDIANTE (con Comparable)
// ========================================

// TODO: Implementa Estudiante con Comparable para ordenar por promedio (descendente)
class Estudiante implements Comparable<Estudiante> {
    private String nombre;
    private double promedio;
    private int edad;
    private String carrera;

    public Estudiante(String nombre, double promedio, int edad, String carrera) {
        this.nombre = nombre;
        this.promedio = promedio;
        this.edad = edad;
        this.carrera = carrera;
    }

    // Getters
    public String getNombre() { return nombre; }
    public double getPromedio() { return promedio; }
    public int getEdad() { return edad; }
    public String getCarrera() { return carrera; }

    // TODO: Implementa compareTo para orden por promedio (mayor a menor)
    @Override
    public int compareTo(Estudiante otro) {
        // Mayor a menor (orden descendente)
        return Double.compare(otro.promedio, this.promedio);
    }

    @Override
    public String toString() {
        return String.format("%s - Promedio: %.1f (%d años) - %s",
            nombre, promedio, edad, carrera);
    }
}

public class Ejercicio30 {
    public static void main(String[] args) {
        System.out.println("=== COMPARATOR Y COMPARABLE - ORDENAMIENTO PERSONALIZADO ===\n");

        // ========================================
        // CREAR LISTA DE PRODUCTOS
        // ========================================
        List<Producto> productos = new ArrayList<>();
        productos.add(new Producto(1, "Laptop", 999.99, "Electrónica", 15));
        productos.add(new Producto(2, "Mouse", 25.50, "Electrónica", 50));
        productos.add(new Producto(3, "Escritorio", 299.00, "Muebles", 8));
        productos.add(new Producto(4, "Silla", 150.00, "Muebles", 12));
        productos.add(new Producto(5, "Teclado", 75.00, "Electrónica", 30));

        // Mostrar productos originales
        System.out.println("=== PRODUCTOS ORIGINALES ===");
        mostrarProductos(productos);

        // ========================================
        // ORDEN NATURAL (Comparable - Por Precio)
        // ========================================
        System.out.println("\n=== ORDEN NATURAL: Por Precio (Comparable) ===");
        List<Producto> porPrecio = new ArrayList<>(productos);
        Collections.sort(porPrecio); // Usa compareTo()
        mostrarProductos(porPrecio);

        // ========================================
        // ORDENAR POR NOMBRE (Comparator)
        // ========================================
        System.out.println("\n=== ORDENAR POR: Nombre (A-Z) ===");
        List<Producto> porNombre = new ArrayList<>(productos);
        Collections.sort(porNombre, new OrdenarPorNombre());
        mostrarProductos(porNombre);

        // ========================================
        // ORDENAR POR STOCK (Comparator)
        // ========================================
        System.out.println("\n=== ORDENAR POR: Stock (Mayor a Menor) ===");
        List<Producto> porStock = new ArrayList<>(productos);
        Collections.sort(porStock, new OrdenarPorStock());
        mostrarProductos(porStock);

        // ========================================
        // ORDENAR POR CATEGORÍA Y PRECIO (Comparator)
        // ========================================
        System.out.println("\n=== ORDENAR POR: Categoría y luego Precio ===");
        List<Producto> porCategoriaYPrecio = new ArrayList<>(productos);
        Collections.sort(porCategoriaYPrecio, new OrdenarPorCategoriaYPrecio());
        mostrarProductos(porCategoriaYPrecio);

        // ========================================
        // ESTUDIANTES CON COMPARABLE
        // ========================================
        System.out.println("\n=== ESTUDIANTES: Orden Natural (Por Promedio - Mayor a Menor) ===");
        List<Estudiante> estudiantes = new ArrayList<>();
        estudiantes.add(new Estudiante("Juan Rodríguez", 7.5, 23, "Arquitectura"));
        estudiantes.add(new Estudiante("María Pérez", 8.2, 21, "Derecho"));
        estudiantes.add(new Estudiante("Carlos López", 8.8, 22, "Medicina"));
        estudiantes.add(new Estudiante("Ana García", 9.5, 20, "Ingeniería"));

        Collections.sort(estudiantes); // Usa compareTo()
        mostrarEstudiantes(estudiantes);

        // ========================================
        // COMPARATORS CON LAMBDAS (JAVA 8+)
        // ========================================
        System.out.println("\n=== USANDO LAMBDAS (Java 8+) ===");

        // Ordenar por precio con lambda
        System.out.println("\nPor precio (con lambda):");
        List<Producto> porPrecioLambda = new ArrayList<>(productos);
        porPrecioLambda.sort((p1, p2) -> Double.compare(p1.getPrecio(), p2.getPrecio()));
        mostrarProductos(porPrecioLambda);

        // Ordenar por nombre con Comparator.comparing()
        System.out.println("\nPor nombre (con Comparator.comparing):");
        List<Producto> porNombreLambda = new ArrayList<>(productos);
        porNombreLambda.sort(Comparator.comparing(Producto::getNombre));
        mostrarProductos(porNombreLambda);

        // Ordenar por categoría y luego precio con thenComparing()
        System.out.println("\nPor categoría y precio (con thenComparing):");
        List<Producto> multiCriterio = new ArrayList<>(productos);
        multiCriterio.sort(Comparator.comparing(Producto::getCategoria)
                                      .thenComparing(Producto::getPrecio));
        mostrarProductos(multiCriterio);

        // Ordenar por precio descendente con reversed()
        System.out.println("\nPor precio descendente (con reversed):");
        List<Producto> precioDesc = new ArrayList<>(productos);
        precioDesc.sort(Comparator.comparing(Producto::getPrecio).reversed());
        mostrarProductos(precioDesc);

        // ========================================
        // DEMOSTRACIÓN DE COMPARACIÓN
        // ========================================
        System.out.println("\n=== COMPARACIÓN DE RENDIMIENTO ===");
        Producto p1 = productos.get(0); // Laptop
        Producto p2 = productos.get(1); // Mouse

        int resultado = p1.compareTo(p2);
        System.out.println("Comparar: " + p1.getNombre() + " vs " + p2.getNombre());
        System.out.println("Resultado: " + resultado);
        if (resultado < 0) {
            System.out.println(p1.getNombre() + " es MENOR que " + p2.getNombre());
        } else if (resultado > 0) {
            System.out.println(p1.getNombre() + " es MAYOR que " + p2.getNombre());
        } else {
            System.out.println(p1.getNombre() + " es IGUAL a " + p2.getNombre());
        }

        // REFLEXIÓN FINAL:
        // ¿Por qué usar Comparable y Comparator?
        // ✓ Permite ordenar objetos personalizados
        // ✓ Flexible: un orden natural + múltiples ordenamientos
        // ✓ Funciona con Collections.sort(), Arrays.sort(), TreeSet, TreeMap
        // ✓ Es el estándar de Java para ordenamiento
        // ✓ Lambdas hacen el código más conciso (Java 8+)
        //
        // EN LA VIDA REAL:
        // - E-commerce: ordenar productos por precio, popularidad, rating
        // - Redes sociales: ordenar posts por fecha, likes, comentarios
        // - Gestión de empleados: por salario, antigüedad, departamento
        // - Bibliotecas: ordenar libros por título, autor, año
        // - Reportes: ordenar transacciones por monto, fecha, cliente
        //
        // COMPARABLE EN JAVA:
        // String, Integer, Double, Date, BigDecimal ya implementan Comparable
        //
        // TREESET Y TREEMAP:
        // Estas colecciones REQUIEREN que los elementos sean Comparable
        // o que se proporcione un Comparator al crearlas:
        //   Set<Producto> set = new TreeSet<>(); // Usa Comparable
        //   Set<Producto> set = new TreeSet<>(comparator); // Usa Comparator
        //
        // MEJORES PRÁCTICAS:
        // 1. Implementa Comparable si hay un orden "natural" obvio
        // 2. Usa Comparator para ordenamientos adicionales
        // 3. Considera null: lanza NullPointerException o manejar especialmente
        // 4. Sé consistente con equals(): si a.equals(b) entonces a.compareTo(b) == 0
        // 5. Usa lambdas para Comparators simples (más legible)
        //
        // COMPLEJIDAD:
        // Collections.sort() usa TimSort (híbrido MergeSort/InsertionSort)
        // - Complejidad: O(n log n) en el peor caso
        // - Estable: mantiene el orden relativo de elementos iguales
        //
        // ERRORES COMUNES:
        // ✗ No ser consistente con equals()
        // ✗ Retornar valores incorrectos (solo usa <0, 0, >0)
        // ✗ No manejar null
        // ✗ Overflow al restar números grandes (usa Integer.compare en su lugar)
    }

    // Método auxiliar para mostrar productos
    private static void mostrarProductos(List<Producto> productos) {
        int i = 1;
        for (Producto p : productos) {
            System.out.println(i++ + ". " + p);
        }
    }

    // Método auxiliar para mostrar estudiantes
    private static void mostrarEstudiantes(List<Estudiante> estudiantes) {
        int i = 1;
        for (Estudiante e : estudiantes) {
            System.out.println(i++ + ". " + e);
        }
    }
}
