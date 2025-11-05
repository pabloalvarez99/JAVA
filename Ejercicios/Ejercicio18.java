/*
 * ========================================
 * EJERCICIO 18: HashMap - Sistema de Inventario
 * DIFICULTAD: ⭐⭐⭐⭐⭐⭐ (Muy Difícil)
 * ========================================
 *
 * OBJETIVO:
 * Aprender a usar HASHMAP - una colección que almacena pares clave-valor
 *
 * CONCEPTO CLAVE:
 * HashMap es una estructura de datos que asocia CLAVES únicas con VALORES.
 * Es como un diccionario: buscas por la palabra (clave) y obtienes la definición (valor).
 *
 * DIFERENCIA: ArrayList vs HashMap
 * - ArrayList: Accedes por ÍNDICE numérico (0, 1, 2...)
 * - HashMap: Accedes por CLAVE de cualquier tipo (String, Integer, etc.)
 *
 * VENTAJAS DE HASHMAP:
 * - Búsqueda MUY rápida por clave (O(1) en promedio)
 * - No hay índices, usas claves descriptivas
 * - Perfecto para asociar datos relacionados
 *
 * INSTRUCCIONES:
 * 1. Crea una clase "Producto" con:
 *    - Atributos privados: nombre (String), precio (double), cantidad (int)
 *    - Constructor que reciba nombre, precio y cantidad
 *    - Getters y setters para cantidad (para actualizar stock)
 *    - Método "toString()" que retorne la información formateada
 *    - Método "calcularValorTotal()" que retorne precio * cantidad
 *
 * 2. Crea una clase "Inventario" con:
 *    - Atributo privado: HashMap<String, Producto> productos
 *      (La clave será el código del producto, ej: "P001")
 *    - Constructor que inicialice el HashMap vacío
 *    - Método "agregarProducto(String codigo, Producto producto)"
 *    - Método "buscarProducto(String codigo)" - retorna el Producto o null
 *    - Método "actualizarStock(String codigo, int nuevaCantidad)"
 *    - Método "eliminarProducto(String codigo)"
 *    - Método "mostrarInventario()" - muestra todos los productos
 *    - Método "calcularValorTotalInventario()" - suma el valor de todos los productos
 *    - Método "productosMasCaros(double precioMinimo)" - muestra productos >= precio
 *
 * 3. En el main:
 *    - Crea un inventario
 *    - Agrega 5 productos con códigos (P001, P002, etc.)
 *    - Muestra el inventario completo
 *    - Busca un producto específico por código
 *    - Actualiza el stock de un producto
 *    - Muestra el valor total del inventario
 *    - Filtra productos más caros que cierto precio
 *    - Elimina un producto
 *
 * SALIDA ESPERADA:
 * === SISTEMA DE INVENTARIO ===
 *
 * Producto agregado - Código: P001
 * Producto agregado - Código: P002
 * ...
 *
 * === INVENTARIO COMPLETO ===
 * Código: P001 | Laptop Dell - $899.99 x 15 unidades = $13499.85
 * Código: P002 | Mouse Logitech - $25.50 x 50 unidades = $1275.00
 * ...
 *
 * === BUSCAR PRODUCTO: P003 ===
 * Teclado Mecánico - $75.00 x 30 unidades = $2250.00
 *
 * === ACTUALIZAR STOCK ===
 * Stock de P001 actualizado a 20 unidades
 *
 * === VALOR TOTAL DEL INVENTARIO ===
 * Valor total: $18549.85
 *
 * === PRODUCTOS MÁS CAROS (>= $50.00) ===
 * P001: Laptop Dell - $899.99
 * P003: Teclado Mecánico - $75.00
 *
 * === ELIMINAR PRODUCTO P005 ===
 * Producto P005 eliminado del inventario
 *
 * CONCEPTOS NUEVOS:
 * - HashMap<K, V>: Colección de pares clave-valor
 * - .put(clave, valor): Agrega o actualiza un par
 * - .get(clave): Obtiene el valor asociado a la clave
 * - .containsKey(clave): Verifica si existe la clave
 * - .remove(clave): Elimina el par por clave
 * - .keySet(): Obtiene todas las claves
 * - .values(): Obtiene todos los valores
 * - .entrySet(): Obtiene todos los pares (para iterar)
 *
 * ESTRUCTURA DE ITERACIÓN:
 * for (String clave : mapa.keySet()) {
 *     Producto valor = mapa.get(clave);
 * }
 *
 * O mejor aún:
 * for (Map.Entry<String, Producto> entry : mapa.entrySet()) {
 *     String clave = entry.getKey();
 *     Producto valor = entry.getValue();
 * }
 *
 * PISTA:
 * - Importa: import java.util.HashMap;
 * - Crear: HashMap<String, Producto> productos = new HashMap<>();
 * - Agregar: productos.put("P001", new Producto("Laptop", 899.99, 15));
 * - Buscar: Producto p = productos.get("P001");
 * - Recorrer: for (String codigo : productos.keySet()) { ... }
 */

import java.util.HashMap;
import java.util.Map;

// TODO: Crea la clase Producto
class Producto {
    // Atributos privados
    private String nombre;
    private double precio;
    private int cantidad;

    // Constructor
    public Producto(String nombre, double precio, int cantidad) {
        // TODO: Inicializa los atributos




    }

    // Getters
    public String getNombre() {
        return nombre;
    }

    public double getPrecio() {
        return precio;
    }

    public int getCantidad() {
        return cantidad;
    }

    // Setter para cantidad (para actualizar stock)
    public void setCantidad(int cantidad) {
        // TODO: Actualiza la cantidad

    }

    // Método calcularValorTotal
    public double calcularValorTotal() {
        // TODO: Retorna precio * cantidad
        return 0.0; // TEMPORAL: reemplaza esto
    }

    // toString
    @Override
    public String toString() {
        return nombre + " - $" + String.format("%.2f", precio) +
               " x " + cantidad + " unidades = $" + String.format("%.2f", calcularValorTotal());
    }
}

// TODO: Crea la clase Inventario
class Inventario {
    // Atributo: HashMap con clave String (código) y valor Producto
    private HashMap<String, Producto> productos;

    // Constructor
    public Inventario() {
        // TODO: Inicializa el HashMap vacío
        productos = new HashMap<>();
    }

    // Método agregarProducto
    public void agregarProducto(String codigo, Producto producto) {
        // TODO: Agrega el producto al HashMap usando put()

        System.out.println("Producto agregado - Código: " + codigo);
    }

    // Método buscarProducto
    public Producto buscarProducto(String codigo) {
        // TODO: Busca y retorna el producto usando get()
        // Retorna null si no existe
        return null; // TEMPORAL: reemplaza esto
    }

    // Método actualizarStock
    public void actualizarStock(String codigo, int nuevaCantidad) {
        // TODO: Busca el producto y actualiza su cantidad
        // Si no existe, muestra un mensaje de error



    }

    // Método eliminarProducto
    public void eliminarProducto(String codigo) {
        // TODO: Elimina el producto usando remove()
        // Verifica si existe primero



    }

    // Método mostrarInventario
    public void mostrarInventario() {
        System.out.println("\n=== INVENTARIO COMPLETO ===");
        // TODO: Recorre el HashMap e imprime cada producto
        // Opción 1: for (String codigo : productos.keySet()) { ... }
        // Opción 2: for (Map.Entry<String, Producto> entry : productos.entrySet()) { ... }




    }

    // Método calcularValorTotalInventario
    public double calcularValorTotalInventario() {
        // TODO: Suma el valor total de todos los productos
        double total = 0;


        return total;
    }

    // Método productosMasCaros
    public void productosMasCaros(double precioMinimo) {
        System.out.println("\n=== PRODUCTOS MÁS CAROS (>= $" + String.format("%.2f", precioMinimo) + ") ===");
        // TODO: Recorre e imprime solo los productos con precio >= precioMinimo





    }
}

public class Ejercicio18 {
    public static void main(String[] args) {
        System.out.println("=== SISTEMA DE INVENTARIO ===\n");

        // TODO: Crea un inventario
        Inventario inventario = new Inventario();

        // TODO: Agrega 5 productos con códigos
        // inventario.agregarProducto("P001", new Producto("Laptop Dell", 899.99, 15));
        // inventario.agregarProducto("P002", new Producto("Mouse Logitech", 25.50, 50));
        // inventario.agregarProducto("P003", new Producto("Teclado Mecánico", 75.00, 30));
        // inventario.agregarProducto("P004", new Producto("Monitor Samsung", 299.99, 10));
        // inventario.agregarProducto("P005", new Producto("Webcam HD", 45.00, 25));






        // TODO: Muestra el inventario completo


        // TODO: Busca un producto específico
        System.out.println("\n=== BUSCAR PRODUCTO: P003 ===");
        // Producto encontrado = inventario.buscarProducto("P003");
        // if (encontrado != null) {
        //     System.out.println(encontrado);
        // } else {
        //     System.out.println("Producto no encontrado");
        // }



        // TODO: Actualiza el stock de un producto
        System.out.println("\n=== ACTUALIZAR STOCK ===");


        // TODO: Muestra el valor total del inventario
        System.out.println("\n=== VALOR TOTAL DEL INVENTARIO ===");
        // double valorTotal = inventario.calcularValorTotalInventario();
        // System.out.println("Valor total: $" + String.format("%.2f", valorTotal));


        // TODO: Filtra productos más caros que cierto precio


        // TODO: Elimina un producto
        System.out.println("\n=== ELIMINAR PRODUCTO P005 ===");


        // REFLEXIÓN:
        // ¿Cuándo usar HashMap?
        // - Cuando necesitas buscar elementos por una clave única
        // - Para asociar datos relacionados (ej: código -> producto)
        // - Cuando la búsqueda rápida es importante
        // - Para evitar búsquedas lineales lentas
        //
        // COMPARACIÓN DE COMPLEJIDAD:
        // ArrayList búsqueda: O(n) - debe revisar todos los elementos
        // HashMap búsqueda: O(1) - acceso directo por clave
        //
        // USO COMÚN:
        // - Cachés y diccionarios
        // - Índices y catálogos
        // - Configuraciones (clave-valor)
        // - Contadores (palabra -> frecuencia)
    }
}
