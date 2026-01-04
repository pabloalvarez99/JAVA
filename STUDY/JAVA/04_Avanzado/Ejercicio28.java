/*
 * ========================================
 * EJERCICIO 28: Streams y Lambdas - Programación Funcional (Java 8+)
 * DIFICULTAD: ⭐⭐⭐⭐⭐⭐⭐⭐⭐ (Maestro)
 * ========================================
 *
 * OBJETIVO:
 * Dominar Streams y expresiones Lambda, las características más poderosas
 * de Java moderno para procesamiento de colecciones de forma funcional
 *
 * CONCEPTO CLAVE 1: LAMBDAS
 * Una lambda es una función anónima (sin nombre) que puedes pasar como argumento.
 * Es una forma concisa de escribir funciones pequeñas.
 *
 * ANTES (Java 7 - clase anónima):
 * lista.forEach(new Consumer<String>() {
 *     @Override
 *     public void accept(String s) {
 *         System.out.println(s);
 *     }
 * });
 *
 * CON LAMBDAS (Java 8+):
 * lista.forEach(s -> System.out.println(s));
 * // O más conciso:
 * lista.forEach(System.out::println);
 *
 * SINTAXIS LAMBDA:
 * (parametros) -> expresion
 * (parametros) -> { bloque de código }
 *
 * Ejemplos:
 * () -> 42                          // Sin parámetros
 * x -> x * 2                        // Un parámetro
 * (x, y) -> x + y                   // Múltiples parámetros
 * (x, y) -> { return x + y; }       // Con bloque
 *
 * CONCEPTO CLAVE 2: STREAMS
 * Un Stream es una secuencia de elementos que soporta operaciones funcionales.
 * Es como una "cinta transportadora" de datos que puedes transformar.
 *
 * ANALOGÍA:
 * Imagina una fábrica con una cinta transportadora:
 * 1. filter(): Elimina productos defectuosos
 * 2. map(): Transforma productos (pinta, empaca)
 * 3. sorted(): Ordena por tamaño
 * 4. collect(): Agrupa en cajas
 *
 * OPERACIONES DE STREAM:
 *
 * INTERMEDIAS (retornan Stream):
 * - filter(Predicate): Filtra elementos que cumplen condición
 * - map(Function): Transforma cada elemento
 * - flatMap(Function): Aplana streams anidados
 * - sorted(): Ordena elementos
 * - distinct(): Elimina duplicados
 * - limit(n): Toma solo los primeros n elementos
 * - skip(n): Salta los primeros n elementos
 *
 * TERMINALES (producen resultado):
 * - forEach(Consumer): Ejecuta acción en cada elemento
 * - collect(Collector): Agrupa en colección
 * - reduce(BinaryOperator): Combina elementos
 * - count(): Cuenta elementos
 * - anyMatch/allMatch/noneMatch: Verificaciones
 * - findFirst/findAny: Encuentra elemento
 * - min/max: Encuentra mínimo/máximo
 *
 * VENTAJAS:
 * ✓ Código más conciso y legible
 * ✓ Menos propenso a errores
 * ✓ Fácilmente paralelizable (.parallelStream())
 * ✓ Operaciones lazy (se ejecutan solo cuando es necesario)
 * ✓ Composición de operaciones
 *
 * INSTRUCCIONES:
 * 1. Crea una clase Producto con: id, nombre, precio, categoria, stock
 *
 * 2. Implementa métodos que usen Streams:
 *    a) filtrarPorPrecio(min, max): Productos en rango de precio
 *    b) obtenerNombres(): Lista de nombres
 *    c) precioPromedio(): Precio promedio de todos los productos
 *    d) productoCaro(): Producto más caro
 *    e) agruparPorCategoria(): Map agrupado por categoría
 *    f) contarPorCategoria(): Map con conteos por categoría
 *    g) productosEnStock(): Solo productos con stock > 0
 *    h) ordenarPorPrecio(): Lista ordenada por precio
 *
 * 3. Demuestra diferentes operaciones de Streams:
 *    - filter, map, reduce, collect
 *    - sorted, distinct, limit
 *    - anyMatch, allMatch, count
 *    - groupingBy, joining
 *
 * SALIDA ESPERADA:
 * === STREAMS Y LAMBDAS - PROGRAMACIÓN FUNCIONAL ===
 *
 * === PRODUCTOS ORIGINALES ===
 * Laptop - $1200.00 [ELECTRONICA] stock: 5
 * Mouse - $25.00 [ELECTRONICA] stock: 50
 * Teclado - $75.00 [ELECTRONICA] stock: 30
 * Silla - $150.00 [MUEBLES] stock: 10
 * Escritorio - $300.00 [MUEBLES] stock: 0
 * Monitor - $400.00 [ELECTRONICA] stock: 15
 * Lámpara - $45.00 [MUEBLES] stock: 20
 *
 * === FILTRAR POR PRECIO ($50 - $500) ===
 * Teclado - $75.00
 * Silla - $150.00
 * Escritorio - $300.00
 * Monitor - $400.00
 *
 * === NOMBRES DE PRODUCTOS ===
 * [Laptop, Mouse, Teclado, Silla, Escritorio, Monitor, Lámpara]
 *
 * === ESTADÍSTICAS ===
 * Precio promedio: $313.57
 * Producto más caro: Laptop ($1200.00)
 * Total de productos: 7
 * Productos en stock: 6
 *
 * === ORDENAR POR PRECIO (ASC) ===
 * Mouse - $25.00
 * Lámpara - $45.00
 * Teclado - $75.00
 * Silla - $150.00
 * Escritorio - $300.00
 * Monitor - $400.00
 * Laptop - $1200.00
 *
 * === AGRUPAR POR CATEGORÍA ===
 * ELECTRONICA: [Laptop, Mouse, Teclado, Monitor]
 * MUEBLES: [Silla, Escritorio, Lámpara]
 *
 * === CONTAR POR CATEGORÍA ===
 * ELECTRONICA: 4 productos
 * MUEBLES: 3 productos
 *
 * === VERIFICACIONES ===
 * ¿Hay productos caros (>$1000)? true
 * ¿Todos tienen stock? false
 * ¿Ninguno cuesta más de $2000? true
 *
 * === SUMA TOTAL (REDUCE) ===
 * Valor total inventario: $2195.00
 *
 * CONCEPTOS NUEVOS:
 * - Lambda expressions: Funciones anónimas
 * - Stream API: Procesamiento funcional de colecciones
 * - Method references: Referencia a métodos (::)
 * - Functional interfaces: Interfaces con un solo método abstracto
 * - Collectors: Herramientas para recolectar resultados
 * - Programación declarativa: Qué hacer, no cómo hacerlo
 *
 * INTERFACES FUNCIONALES COMUNES:
 * - Predicate<T>: T -> boolean (filter)
 * - Function<T,R>: T -> R (map)
 * - Consumer<T>: T -> void (forEach)
 * - Supplier<T>: () -> T (generate)
 * - BinaryOperator<T>: (T, T) -> T (reduce)
 *
 */

import java.util.*;
import java.util.stream.*;

// TODO: Crea la clase Producto
class Producto {
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

    @Override
    public String toString() {
        return String.format("%s - $%.2f [%s] stock: %d",
                           nombre, precio, categoria, stock);
    }
}

public class Ejercicio28 {

    // TODO: Filtrar productos por rango de precio
    public static List<Producto> filtrarPorPrecio(List<Producto> productos, double min, double max) {
        return productos.stream()
                       .filter(p -> p.getPrecio() >= min && p.getPrecio() <= max)
                       .collect(Collectors.toList());
    }

    // TODO: Obtener lista de nombres
    public static List<String> obtenerNombres(List<Producto> productos) {
        return productos.stream()
                       .map(Producto::getNombre)
                       .collect(Collectors.toList());
    }

    // TODO: Calcular precio promedio
    public static double precioPromedio(List<Producto> productos) {
        return productos.stream()
                       .mapToDouble(Producto::getPrecio)
                       .average()
                       .orElse(0.0);
    }

    // TODO: Encontrar producto más caro
    public static Optional<Producto> productoCaro(List<Producto> productos) {
        return productos.stream()
                       .max(Comparator.comparingDouble(Producto::getPrecio));
    }

    // TODO: Agrupar por categoría
    public static Map<String, List<Producto>> agruparPorCategoria(List<Producto> productos) {
        return productos.stream()
                       .collect(Collectors.groupingBy(Producto::getCategoria));
    }

    // TODO: Contar por categoría
    public static Map<String, Long> contarPorCategoria(List<Producto> productos) {
        return productos.stream()
                       .collect(Collectors.groupingBy(
                           Producto::getCategoria,
                           Collectors.counting()
                       ));
    }

    // TODO: Filtrar productos en stock
    public static List<Producto> productosEnStock(List<Producto> productos) {
        return productos.stream()
                       .filter(p -> p.getStock() > 0)
                       .collect(Collectors.toList());
    }

    // TODO: Ordenar por precio
    public static List<Producto> ordenarPorPrecio(List<Producto> productos) {
        return productos.stream()
                       .sorted(Comparator.comparingDouble(Producto::getPrecio))
                       .collect(Collectors.toList());
    }

    public static void main(String[] args) {
        System.out.println("=== STREAMS Y LAMBDAS - PROGRAMACIÓN FUNCIONAL ===\n");

        // Crear lista de productos
        List<Producto> productos = Arrays.asList(
            new Producto(1, "Laptop", 1200.0, "ELECTRONICA", 5),
            new Producto(2, "Mouse", 25.0, "ELECTRONICA", 50),
            new Producto(3, "Teclado", 75.0, "ELECTRONICA", 30),
            new Producto(4, "Silla", 150.0, "MUEBLES", 10),
            new Producto(5, "Escritorio", 300.0, "MUEBLES", 0),
            new Producto(6, "Monitor", 400.0, "ELECTRONICA", 15),
            new Producto(7, "Lámpara", 45.0, "MUEBLES", 20)
        );

        // === PRODUCTOS ORIGINALES ===
        System.out.println("=== PRODUCTOS ORIGINALES ===");
        productos.forEach(System.out::println);
        System.out.println();

        // === FILTRAR POR PRECIO ===
        System.out.println("=== FILTRAR POR PRECIO ($50 - $500) ===");
        List<Producto> filtrados = filtrarPorPrecio(productos, 50, 500);
        filtrados.forEach(p -> System.out.println(p.getNombre() + " - $" + p.getPrecio()));
        System.out.println();

        // === NOMBRES DE PRODUCTOS ===
        System.out.println("=== NOMBRES DE PRODUCTOS ===");
        List<String> nombres = obtenerNombres(productos);
        System.out.println(nombres);
        System.out.println();

        // === ESTADÍSTICAS ===
        System.out.println("=== ESTADÍSTICAS ===");
        double promedio = precioPromedio(productos);
        System.out.printf("Precio promedio: $%.2f\n", promedio);

        productoCaro(productos).ifPresent(p ->
            System.out.printf("Producto más caro: %s ($%.2f)\n", p.getNombre(), p.getPrecio())
        );

        long total = productos.stream().count();
        System.out.println("Total de productos: " + total);

        long enStock = productosEnStock(productos).size();
        System.out.println("Productos en stock: " + enStock);
        System.out.println();

        // === ORDENAR POR PRECIO ===
        System.out.println("=== ORDENAR POR PRECIO (ASC) ===");
        List<Producto> ordenados = ordenarPorPrecio(productos);
        ordenados.forEach(p -> System.out.println(p.getNombre() + " - $" + p.getPrecio()));
        System.out.println();

        // === AGRUPAR POR CATEGORÍA ===
        System.out.println("=== AGRUPAR POR CATEGORÍA ===");
        Map<String, List<Producto>> porCategoria = agruparPorCategoria(productos);
        porCategoria.forEach((categoria, prods) -> {
            String nombresProd = prods.stream()
                                     .map(Producto::getNombre)
                                     .collect(Collectors.joining(", "));
            System.out.println(categoria + ": [" + nombresProd + "]");
        });
        System.out.println();

        // === CONTAR POR CATEGORÍA ===
        System.out.println("=== CONTAR POR CATEGORÍA ===");
        Map<String, Long> conteos = contarPorCategoria(productos);
        conteos.forEach((categoria, count) ->
            System.out.println(categoria + ": " + count + " productos")
        );
        System.out.println();

        // === VERIFICACIONES ===
        System.out.println("=== VERIFICACIONES ===");

        boolean hayCaros = productos.stream()
                                   .anyMatch(p -> p.getPrecio() > 1000);
        System.out.println("¿Hay productos caros (>$1000)? " + hayCaros);

        boolean todosTienenStock = productos.stream()
                                           .allMatch(p -> p.getStock() > 0);
        System.out.println("¿Todos tienen stock? " + todosTienenStock);

        boolean ningunoCaro = productos.stream()
                                      .noneMatch(p -> p.getPrecio() > 2000);
        System.out.println("¿Ninguno cuesta más de $2000? " + ningunoCaro);
        System.out.println();

        // === REDUCE (SUMA TOTAL) ===
        System.out.println("=== SUMA TOTAL (REDUCE) ===");
        double sumaTotal = productos.stream()
                                   .map(Producto::getPrecio)
                                   .reduce(0.0, (a, b) -> a + b);
        System.out.printf("Valor total inventario: $%.2f\n", sumaTotal);
        System.out.println();

        // === OPERACIONES AVANZADAS ===
        System.out.println("=== OPERACIONES AVANZADAS ===");

        // Nombres de productos electrónicos en mayúsculas, ordenados
        String electronicos = productos.stream()
                                      .filter(p -> p.getCategoria().equals("ELECTRONICA"))
                                      .map(Producto::getNombre)
                                      .map(String::toUpperCase)
                                      .sorted()
                                      .collect(Collectors.joining(", "));
        System.out.println("Electrónicos (ordenados): " + electronicos);

        // Top 3 productos más caros
        System.out.println("\nTop 3 productos más caros:");
        productos.stream()
                .sorted(Comparator.comparingDouble(Producto::getPrecio).reversed())
                .limit(3)
                .forEach(p -> System.out.println("  " + p.getNombre() + " - $" + p.getPrecio()));

        // Suma de stock por categoría
        System.out.println("\nStock total por categoría:");
        Map<String, Integer> stockPorCategoria = productos.stream()
            .collect(Collectors.groupingBy(
                Producto::getCategoria,
                Collectors.summingInt(Producto::getStock)
            ));
        stockPorCategoria.forEach((cat, stock) ->
            System.out.println("  " + cat + ": " + stock + " unidades")
        );
        System.out.println();

        // REFLEXIÓN:
        // ¿Por qué usar Streams y Lambdas?
        // ✓ Código más conciso y legible
        // ✓ Menos código boilerplate
        // ✓ Fácil de paralelizar
        // ✓ Operaciones composables
        // ✓ Inmutabilidad (no modifica la colección original)
        //
        // STREAMS EN LA VIDA REAL:
        // - Procesamiento de datos: ETL, transformaciones
        // - APIs REST: Filtrado, paginación, ordenamiento
        // - Análisis de datos: Agregaciones, estadísticas
        // - Validaciones: Verificar condiciones en colecciones
        //
        // COMPARACIÓN: IMPERATIVO vs FUNCIONAL
        //
        // IMPERATIVO (antes):
        // List<String> nombres = new ArrayList<>();
        // for (Producto p : productos) {
        //     if (p.getPrecio() > 100) {
        //         nombres.add(p.getNombre());
        //     }
        // }
        //
        // FUNCIONAL (ahora):
        // List<String> nombres = productos.stream()
        //     .filter(p -> p.getPrecio() > 100)
        //     .map(Producto::getNombre)
        //     .collect(Collectors.toList());
        //
        // METHOD REFERENCES (::):
        // Lambda:             p -> p.getNombre()
        // Method reference:   Producto::getNombre
        //
        // Lambda:             s -> System.out.println(s)
        // Method reference:   System.out::println
        //
        // INTERFACES FUNCIONALES:
        // @FunctionalInterface - interfaz con UN solo método abstracto
        // Predicate<T>:    T -> boolean
        // Function<T,R>:   T -> R
        // Consumer<T>:     T -> void
        // Supplier<T>:     () -> T
        // BinaryOperator:  (T, T) -> T
        //
        // OPERACIONES LAZY:
        // Las operaciones intermedias (filter, map) NO se ejecutan hasta
        // que se llama a una operación terminal (collect, forEach)
        //
        // productos.stream()
        //     .filter(p -> { System.out.println("Filtrando"); return true; })
        //     .map(p -> { System.out.println("Mapeando"); return p; });
        // // NO imprime nada porque no hay operación terminal
        //
        // productos.stream()
        //     .filter(p -> { System.out.println("Filtrando"); return true; })
        //     .map(p -> { System.out.println("Mapeando"); return p; })
        //     .collect(Collectors.toList());
        // // AHORA SÍ imprime porque hay collect()
        //
        // PARALLEL STREAMS:
        // productos.parallelStream()  // Usa múltiples threads
        //     .filter(p -> p.getPrecio() > 100)
        //     .collect(Collectors.toList());
        //
        // MEJORES PRÁCTICAS:
        // ✓ Usa method references cuando sea posible
        // ✓ Prefiere filter antes de map
        // ✓ No modifiques estado externo en lambdas
        // ✓ Usa parallel streams solo para colecciones grandes
        // ✓ Evita side effects en operaciones intermedias
    }
}
