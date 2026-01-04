/*
 * ========================================
 * EJERCICIO 16: Arrays de Objetos con Operaciones Complejas
 * DIFICULTAD: ⭐⭐⭐⭐⭐ (Avanzado)
 * ========================================
 *
 * OBJETIVO:
 * Dominar el manejo de arrays de objetos con operaciones más avanzadas:
 * búsqueda, filtrado, ordenamiento y transformaciones.
 *
 * CONCEPTO CLAVE:
 * Los arrays de objetos son fundamentales en programación. Debes ser capaz de:
 * - Buscar objetos que cumplan condiciones específicas
 * - Filtrar y crear nuevos arrays con subconjuntos
 * - Ordenar objetos según diferentes criterios
 * - Realizar transformaciones sobre colecciones
 *
 * Estas operaciones son la base de procesamiento de datos y se usan
 * en TODAS las aplicaciones reales.
 *
 * INSTRUCCIONES:
 * 1. Crea una clase "Producto" con:
 *    - Atributos privados: nombre (String), precio (double), stock (int), categoria (String)
 *    - Constructor con todos los parámetros
 *    - Getters para todos los atributos
 *    - Método "setStock(int stock)" - actualiza el stock
 *    - Método "setPrecio(double precio)" - actualiza el precio
 *    - Método "aplicarDescuento(double porcentaje)" - reduce el precio
 *    - Método "estaDisponible()" - retorna true si stock > 0
 *    - Método "mostrarInfo()" - muestra toda la información
 *
 * 2. Crea una clase "Inventario" con:
 *    - Atributo privado: productos (Producto[]) - máximo 50 productos
 *    - Atributo privado: cantidadProductos (int)
 *    - Constructor sin parámetros
 *    - Método "agregarProducto(Producto p)"
 *    - Método "buscarPorNombre(String nombre)" - retorna el Producto o null
 *    - Método "buscarPorCategoria(String categoria)" - retorna array con productos de esa categoría
 *    - Método "productoMasCaro()" - retorna el producto de mayor precio
 *    - Método "productoMasBarato()" - retorna el producto de menor precio
 *    - Método "calcularValorInventario()" - suma precio * stock de todos los productos
 *    - Método "productosConBajoStock(int minimo)" - retorna productos con stock <= minimo
 *    - Método "aplicarDescuentoCategoria(String categoria, double porcentaje)" - descuento a categoría
 *    - Método "ordenarPorPrecio()" - ordena el array de productos por precio (menor a mayor)
 *    - Método "mostrarInventario()" - muestra todos los productos
 *
 * 3. En el main:
 *    - Crea un inventario
 *    - Agrega 8 productos de diferentes categorías
 *    - Realiza búsquedas por nombre y categoría
 *    - Muestra el producto más caro y más barato
 *    - Calcula el valor total del inventario
 *    - Encuentra productos con bajo stock
 *    - Aplica descuentos a una categoría específica
 *    - Ordena por precio y muestra el inventario
 *
 * SALIDA ESPERADA:
 * ====== Inventario TechStore ======
 * Total de productos: 8
 *
 * Laptop HP - $899.99 - Stock: 5 - Categoría: Electrónica
 * Mouse Logitech - $25.50 - Stock: 15 - Categoría: Accesorios
 * [... más productos ...]
 *
 * ====== Búsquedas ======
 * Buscando 'Laptop HP': Encontrado - $899.99 (5 unidades)
 *
 * Productos en categoría 'Accesorios':
 *   - Mouse Logitech ($25.50)
 *   - Teclado Mecánico ($75.00)
 *   - Audífonos Sony ($120.00)
 *
 * ====== Análisis de Precios ======
 * Producto más caro: Monitor 4K ($549.99)
 * Producto más barato: Cable USB-C ($8.99)
 *
 * ====== Análisis de Inventario ======
 * Valor total del inventario: $15,234.50
 *
 * Productos con bajo stock (<= 3):
 *   - Webcam Logitech (2 unidades)
 *   - Cable USB-C (1 unidad)
 *
 * ====== Aplicando 20% de descuento a 'Accesorios' ======
 * 3 productos actualizados.
 *
 * ====== Inventario Ordenado por Precio ======
 * Cable USB-C - $7.19 - Stock: 1 - Categoría: Accesorios
 * Mouse Logitech - $20.40 - Stock: 15 - Categoría: Accesorios
 * [... productos en orden de precio ...]
 *
 * CONCEPTOS NUEVOS:
 * - Búsqueda en arrays de objetos
 * - Filtrado y creación de subarrays
 * - Ordenamiento de objetos (Bubble Sort)
 * - Operaciones agregadas (sum, max, min)
 * - Transformaciones sobre colecciones (aplicar descuento)
 */
import java.util.ArrayList;
class Producto{
    private String nombre;
    private double precio;
    private int stock;
    private String categoria;
    public Producto(String nombre, double precio, int stock, String categoria) {
        this.nombre = nombre;
        this.precio = precio;
        this.stock = stock;
        this.categoria = categoria;
    }
    public String getNombre() {
        return nombre;
    }
    public double getPrecio() {
        return precio;
    }
    public int getStock() {
        return stock;
    }
    public String getCategoria() {
        return categoria;
    }
    public void setStock(int stock) {
        this.stock = stock;
    }
    public void setPrecio(double precio) {
        this.precio = precio;
    }
    public double aplicarDescuento(double porcentaje) {
        return precio*(porcentaje/100);
    }
    public boolean estaDisponible() {
        if (stock > 0) {
            return true;
        } else {
            return false;
        }
    }
    public void mostrarInfo() {
        System.out.println(nombre + " Laptop HP - $" + precio + " Strock:" + stock + " - Categoria: " + categoria);
    }
}
class Inventario {
    ArrayList<Producto> productos = new ArrayList<>();
    int cantidadProductos = 0;
    public Inventario() {}
    public ArrayList<Producto> agregarProducto(Producto p) {
        productos.add(p);
        return productos;
    }
    public Producto buscarPorNombre(String nombre) {
        System.out.println("====== Búsquedas ======");
        System.out.println("Buscando '" + nombre + "': ");
        for (int i = 0; i < productos.size(); i++) {
            if (productos.get(i).getNombre() == nombre) {
                System.out.print("Encontrado - $" + productos.get(i).getPrecio() + " (" + productos.get(i).getStock() + " unidades)");
                Producto x = productos.get(i);
                return x;
            }
        }
        return null;
    }
    public ArrayList<Producto> buscarPorCategoria(String cat) {
        ArrayList<Producto> x = new ArrayList<>();
        for (int i = 0; i < productos.size(); i++) {
            if (productos.get(i).getCategoria() == cat) {
                x.add(productos.get(i));
            }
        }
        return x;
    }
    public Producto productoMasCaro() {
        double x = 0;
        Producto p = null;
        for (int i = 0; i < productos.size(); i++) {
            if (productos.get(i).getPrecio() > x) {
                x = productos.get(i).getPrecio();
                p = productos.get(i);
            }
        }
        return p;
    }
    public Producto productoMasBarato() {
        double x = 9999999;
        Producto p = null;
        for (int i = 0; i < productos.size(); i++) {
            if (productos.get(i).getPrecio() < x) {
                x = productos.get(i).getPrecio();
                p = productos.get(i);
            }
        }
        return p;
    }
    public double calcularValorInventario() {
        double x = 0;
        for (int i = 0; i < productos.size(); i++) {;
            x += productos.get(i).getPrecio() * productos.get(i).getStock();
        }
        return (x/productos.size());
    }
    public ArrayList<Producto> productosConBajoStock(int minimo) {
        ArrayList<Producto> p = new ArrayList<>();
        for (int i = 0; i < productos.size(); i++) {
            if (productos.get(i).getStock() >= minimo) {
                p.add(productos.get(i));
            }
        }
        return p;
    }
    public ArrayList<Producto> aplicarDescuentoCategoria(String categoria, double porcentaje) {
        ArrayList<Producto> p = new ArrayList<>();
        for (int i = 0; i < productos.size(); i++) {
            if (productos.get(i).getCategoria().equals(categoria)) {
                productos.get(i).setPrecio(productos.get(i).getPrecio()-(productos.get(i).getPrecio()*(porcentaje/100)));
                p.add(productos.get(i));
            }
        }
        return p;
    }
    public ArrayList<Producto> ordenarPorPrecio() {
        ArrayList<Producto> aux = productos;
        for(int i = 0; i < productos.size(); i++) {
            
        }
    }
}
public class Ejercicio16 {
    // TODO: Lee las instrucciones arriba y escribe TODO el código
    // TODO: Implementa todas las clases, métodos y lógica necesaria
}

/*
 * ========================================
 * REFLEXIÓN Y PROFUNDIZACIÓN
 * ========================================
 *
 * ¿POR QUÉ ESTE EJERCICIO ES IMPORTANTE?
 *
 * 1. OPERACIONES CRUD:
 *    Create (agregar), Read (buscar), Update (actualizar), Delete (eliminar)
 *    Son las operaciones básicas de TODA aplicación con datos.
 *    Este ejercicio practica todas excepto Delete.
 *
 * 2. BÚSQUEDA Y FILTRADO:
 *    En aplicaciones reales constantemente buscas datos:
 *    - Buscar usuario por email
 *    - Filtrar productos por categoría
 *    - Encontrar pedidos de un cliente
 *
 *    Dos enfoques:
 *    a) Retornar UN objeto (buscarPorNombre) → retorna null si no existe
 *    b) Retornar MÚLTIPLES objetos (buscarPorCategoria) → retorna array
 *
 * 3. AGREGACIONES:
 *    Cálculos sobre colecciones:
 *    - MAX: productoMasCaro()
 *    - MIN: productoMasBarato()
 *    - SUM: calcularValorInventario()
 *    - COUNT: cantidadProductos
 *
 *    En SQL serían: SELECT MAX(precio), SELECT SUM(precio * stock)
 *    En Java, los haces recorriendo el array.
 *
 * 4. ORDENAMIENTO:
 *    Aquí usas Bubble Sort (simple pero lento O(n²)).
 *    En producción usarías:
 *    - Arrays.sort() para arrays primitivos
 *    - Collections.sort() para ArrayList
 *    - Implementar Comparable/Comparator para objetos personalizados
 *
 * 5. TRANSFORMACIONES:
 *    aplicarDescuentoCategoria() transforma el estado de múltiples objetos.
 *    Es como hacer: UPDATE productos SET precio = precio * 0.8 WHERE categoria = 'X'
 *
 * TÉCNICAS DE BÚSQUEDA:
 *
 * 1. BÚSQUEDA LINEAL (lo que hiciste aquí):
 *    Recorrer todo el array elemento por elemento.
 *    Complejidad: O(n) - lento para arrays grandes
 *    Ventaja: funciona en arrays desordenados
 *
 * 2. BÚSQUEDA BINARIA (más adelante): 
 *    Requiere array ordenado.
 *    Complejidad: O(log n) - mucho más rápido
 *    Desventaja: el array DEBE estar ordenado
 *
 * 3. HASHTABLE (HashMap - más adelante):
 *    Usa una estructura de datos especial.
 *    Complejidad: O(1) - casi instantánea
 *    La mejor opción para búsquedas frecuentes
 *
 * BUBBLE SORT EXPLICADO:
 *
 * El algoritmo compara pares adyacentes y los intercambia si están en orden incorrecto:
 *
 * Pasada 1: [5, 2, 8, 1] → [2, 5, 1, 8] (el 8 "sube")
 * Pasada 2: [2, 5, 1, 8] → [2, 1, 5, 8] (el 5 "sube")
 * Pasada 3: [2, 1, 5, 8] → [1, 2, 5, 8] (el 2 "sube")
 *
 * Después de cada pasada, el elemento más grande está en su posición final.
 *
 * CASOS DE USO EN EL MUNDO REAL:
 *
 * 1. E-COMMERCE:
 *    class ProductoCatalogo {
 *        public Producto[] buscarPorCategoria(String cat);
 *        public Producto[] ordenarPorPrecio();
 *        public Producto[] filtrarPorRango(double min, double max);
 *    }
 *
 * 2. SISTEMA DE BIBLIOTECA:
 *    class Biblioteca {
 *        public Libro[] buscarPorAutor(String autor);
 *        public Libro[] buscarPorISBN(String isbn);
 *        public Libro[] librosPorAnio(int anio);
 *    }
 *
 * 3. SISTEMA DE EMPLEADOS:
 *    class RRHH {
 *        public Empleado[] empleadosPorDepartamento(String dept);
 *        public Empleado[] empleadosConSalarioMayor(double minimo);
 *        public Empleado empleadoMejorPagado();
 *    }
 *
 * 4. STREAMING (Netflix/Spotify):
 *    class Catalogo {
 *        public Pelicula[] buscarPorGenero(String genero);
 *        public Pelicula[] ordenarPorCalificacion();
 *        public Pelicula[] recomendaciones(Usuario u);
 *    }
 *
 * OPTIMIZACIONES POSIBLES:
 *
 * 1. ÍNDICES:
 *    Mantener arrays auxiliares ordenados por diferentes criterios
 *    (por nombre, por precio, etc.) para búsquedas más rápidas.
 *
 * 2. CACHÉ:
 *    Guardar resultados de búsquedas frecuentes.
 *
 * 3. ALGORITMOS MÁS EFICIENTES:
 *    - QuickSort o MergeSort en lugar de Bubble Sort
 *    - Binary Search en lugar de linear search
 *
 * 4. ESTRUCTURAS DE DATOS AVANZADAS:
 *    - HashMap para búsquedas O(1)
 *    - TreeMap para datos ordenados
 *    - ArrayList en lugar de arrays fijos
 *
 * ERROR COMÚN: NULL POINTER EXCEPTION
 *
 * Si buscarPorNombre() retorna null y luego haces:
 *   Producto p = inv.buscarPorNombre("NoExiste");
 *   System.out.println(p.getNombre()); // ¡CRASH! p es null
 *
 * SIEMPRE VALIDA:
 *   Producto p = inv.buscarPorNombre("...");
 *   if (p != null) {
 *       System.out.println(p.getNombre());
 *   } else {
 *       System.out.println("Producto no encontrado");
 *   }
 *
 * SIGUIENTE PASO:
 * Ahora que dominas operaciones complejas sobre arrays de objetos,
 * estás listo para aprender sobre NODOS y LISTAS ENLAZADAS, donde
 * los objetos se conectan entre sí mediante referencias.
 */
