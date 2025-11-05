/*
 * ========================================
 * EJERCICIO 23: Genéricos Básicos - Caja Genérica
 * DIFICULTAD: ⭐⭐⭐⭐⭐⭐⭐⭐ (Extremadamente Difícil)
 * ========================================
 *
 * OBJETIVO:
 * Aprender sobre GENÉRICOS (Generics) - código que funciona con cualquier tipo de dato
 *
 * CONCEPTO CLAVE:
 * Los genéricos permiten escribir clases y métodos que pueden trabajar con
 * cualquier tipo de objeto, manteniendo la seguridad de tipos en tiempo de compilación.
 *
 * ANTES DE GENÉRICOS (problemático):
 * ArrayList lista = new ArrayList();
 * lista.add("Hola");
 * lista.add(123);
 * String texto = (String) lista.get(0);  // Cast manual, puede fallar
 *
 * CON GENÉRICOS (seguro):
 * ArrayList<String> lista = new ArrayList<>();
 * lista.add("Hola");
 * // lista.add(123);  // ERROR de compilación - ¡bien!
 * String texto = lista.get(0);  // Sin cast, seguro
 *
 * ANALOGÍA:
 * Una caja genérica es como un contenedor que puede guardar cualquier cosa
 * (libros, zapatos, juguetes), pero una vez que defines qué contiene,
 * solo puede guardar ese tipo de cosas.
 *
 * SINTAXIS:
 * - <T> = Type parameter (parámetro de tipo)
 * - T puede ser cualquier nombre: T, E, K, V, etc.
 * - Convenciones: T (Type), E (Element), K (Key), V (Value)
 *
 * INSTRUCCIONES:
 * 1. Crea una clase genérica "Caja<T>" con:
 *    - Atributo privado: contenido de tipo T
 *    - Constructor que reciba el contenido inicial
 *    - Método "guardar(T contenido)" - actualiza el contenido
 *    - Método "obtener()" - retorna el contenido
 *    - Método "estaVacia()" - retorna true si contenido es null
 *    - Método "toString()" - muestra información de la caja
 *
 * 2. Crea una clase genérica "Par<K, V>" con:
 *    - Atributos privados: clave (K) y valor (V)
 *    - Constructor que reciba clave y valor
 *    - Getters para clave y valor
 *    - Método "toString()" formateado
 *    - DESAFÍO: Método estático genérico "crear(K k, V v)" que retorne un nuevo Par
 *
 * 3. Crea una clase "UtilidadesGenericas" con métodos estáticos genéricos:
 *
 *    a) <T> imprimirArray(T[] array):
 *       - Imprime cualquier tipo de array
 *
 *    b) <T> intercambiar(T[] array, int i, int j):
 *       - Intercambia dos elementos de cualquier tipo de array
 *
 *    c) <T extends Comparable<T>> maximo(T a, T b):
 *       - Retorna el mayor de dos elementos comparables
 *       - Usa "bounded type parameter" (T debe implementar Comparable)
 *
 *    d) <T> contarOcurrencias(T[] array, T elemento):
 *       - Cuenta cuántas veces aparece un elemento en el array
 *
 * 4. En el main:
 *    - Crea cajas de diferentes tipos (String, Integer, Double)
 *    - Crea pares de diferentes tipos (String-Integer, Integer-String)
 *    - Prueba los métodos genéricos con diferentes tipos de arrays
 *    - Demuestra que el compilador previene errores de tipos
 *
 * SALIDA ESPERADA:
 * === GENÉRICOS EN JAVA ===
 *
 * === CAJAS GENÉRICAS ===
 * Caja de String: Laptop Dell
 * Caja de Integer: 42
 * Caja de Double: 99.99
 *
 * Actualizando contenido...
 * Caja de String: Teclado Mecánico
 *
 * === PARES GENÉRICOS ===
 * Par<String, Integer>: producto -> 150
 * Par<Integer, String>: 404 -> Not Found
 * Par<String, Double>: precio -> 99.99
 *
 * === MÉTODOS GENÉRICOS ===
 * Array de String: [Java, Python, JavaScript, C++]
 * Array de Integer: [10, 20, 30, 40, 50]
 * Array de Double: [1.5, 2.5, 3.5, 4.5]
 *
 * Intercambiando posiciones 0 y 3 en array de Integer...
 * Array después: [40, 20, 30, 10, 50]
 *
 * Máximo entre 100 y 50: 100
 * Máximo entre "Zebra" y "Aardvark": Zebra
 *
 * Ocurrencias de 20 en [10, 20, 30, 20, 50]: 2
 *
 * CONCEPTOS NUEVOS:
 * - Generics <T>: Parámetros de tipo
 * - Type Safety: Seguridad de tipos en compilación
 * - Type Parameter: T, E, K, V (convenciones)
 * - Bounded Type: <T extends Comparable> (restringe el tipo)
 * - Generic Methods: Métodos que usan genéricos
 * - Generic Classes: Clases que usan genéricos
 * - Type Erasure: Los genéricos se eliminan en tiempo de ejecución
 *
 * VENTAJAS DE GENÉRICOS:
 * ✓ Seguridad de tipos en compilación (previene errores)
 * ✓ Elimina necesidad de casts manuales
 * ✓ Código reutilizable para múltiples tipos
 * ✓ Errores detectados al compilar, no al ejecutar
 * ✓ Código más limpio y legible
 *
 * CONVENCIONES DE NOMBRES:
 * - T = Type (tipo genérico)
 * - E = Element (elemento de una colección)
 * - K = Key (clave de un mapa)
 * - V = Value (valor de un mapa)
 * - N = Number (tipo numérico)
 *
 * LIMITACIONES:
 * - No puedes crear arrays genéricos: new T[10] ❌
 * - No puedes usar tipos primitivos: Box<int> ❌ (usa Box<Integer> ✓)
 * - No puedes usar instanceof con genéricos
 * - Type erasure: en runtime, T se convierte en Object
 *
 * PISTA:
 * - Clase genérica: class Caja<T> { private T contenido; }
 * - Método genérico: public static <T> void imprimir(T elemento) { }
 * - Bounded type: <T extends Comparable<T>>
 * - Crear instancia: Caja<String> caja = new Caja<>("Hola");
 */

// TODO: Crea la clase genérica Caja<T>
class Caja<T> {
    // Atributo privado genérico
    private T contenido;

    // Constructor
    public Caja(T contenido) {
        // TODO: Inicializa el contenido

    }

    // Método guardar
    public void guardar(T contenido) {
        // TODO: Actualiza el contenido

    }

    // Método obtener
    public T obtener() {
        // TODO: Retorna el contenido
        return null; // TEMPORAL

    }

    // Método estaVacia
    public boolean estaVacia() {
        // TODO: Retorna true si contenido es null
        return false; // TEMPORAL

    }

    // toString
    @Override
    public String toString() {
        if (estaVacia()) {
            return "Caja vacía";
        }
        // Muestra el tipo y el contenido
        return "Caja de " + contenido.getClass().getSimpleName() + ": " + contenido;
    }
}

// TODO: Crea la clase genérica Par<K, V>
class Par<K, V> {
    // Atributos privados genéricos
    private K clave;
    private V valor;

    // Constructor
    public Par(K clave, V valor) {
        // TODO: Inicializa clave y valor


    }

    // Getters
    public K getClave() {
        return clave;
    }

    public V getValor() {
        return valor;
    }

    // toString
    @Override
    public String toString() {
        return "Par<" + clave.getClass().getSimpleName() + ", " +
               valor.getClass().getSimpleName() + ">: " + clave + " -> " + valor;
    }

    // DESAFÍO: Método estático genérico
    public static <K, V> Par<K, V> crear(K clave, V valor) {
        // TODO: Retorna un nuevo Par
        return null; // TEMPORAL

    }
}

// TODO: Crea la clase UtilidadesGenericas
class UtilidadesGenericas {

    // Método genérico: imprimirArray
    public static <T> void imprimirArray(T[] array) {
        // TODO: Imprime el array
        System.out.print("[");
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i]);
            if (i < array.length - 1) {
                System.out.print(", ");
            }
        }
        System.out.println("]");
    }

    // Método genérico: intercambiar
    public static <T> void intercambiar(T[] array, int i, int j) {
        // TODO: Intercambia elementos en posiciones i y j




    }

    // Método genérico con bounded type: maximo
    public static <T extends Comparable<T>> T maximo(T a, T b) {
        // TODO: Retorna el mayor usando compareTo
        // a.compareTo(b) retorna:
        //   > 0 si a > b
        //   < 0 si a < b
        //   = 0 si a == b
        return null; // TEMPORAL




    }

    // Método genérico: contarOcurrencias
    public static <T> int contarOcurrencias(T[] array, T elemento) {
        // TODO: Cuenta cuántas veces aparece el elemento
        int contador = 0;



        return contador;
    }
}

public class Ejercicio23 {
    public static void main(String[] args) {
        System.out.println("=== GENÉRICOS EN JAVA ===\n");

        // === CAJAS GENÉRICAS ===
        System.out.println("=== CAJAS GENÉRICAS ===");

        // TODO: Crea cajas de diferentes tipos
        // Caja<String> cajaTexto = new Caja<>("Laptop Dell");
        // System.out.println(cajaTexto);

        // Caja<Integer> cajaNumero = new Caja<>(42);
        // System.out.println(cajaNumero);

        // Caja<Double> cajaPrecio = new Caja<>(99.99);
        // System.out.println(cajaPrecio);







        System.out.println();

        // Actualizar contenido
        System.out.println("Actualizando contenido...");
        // cajaTexto.guardar("Teclado Mecánico");
        // System.out.println(cajaTexto);



        System.out.println();

        // === PARES GENÉRICOS ===
        System.out.println("=== PARES GENÉRICOS ===");

        // TODO: Crea pares de diferentes tipos
        // Par<String, Integer> parProducto = new Par<>("producto", 150);
        // System.out.println(parProducto);

        // Par<Integer, String> parError = new Par<>(404, "Not Found");
        // System.out.println(parError);

        // Par<String, Double> parPrecio = Par.crear("precio", 99.99);  // Usando método estático
        // System.out.println(parPrecio);







        System.out.println();

        // === MÉTODOS GENÉRICOS ===
        System.out.println("=== MÉTODOS GENÉRICOS ===");

        // Arrays de diferentes tipos
        String[] lenguajes = {"Java", "Python", "JavaScript", "C++"};
        Integer[] numeros = {10, 20, 30, 40, 50};
        Double[] decimales = {1.5, 2.5, 3.5, 4.5};

        // TODO: Imprime los arrays usando el método genérico
        System.out.print("Array de String: ");
        // UtilidadesGenericas.imprimirArray(lenguajes);




        System.out.print("Array de Integer: ");


        System.out.print("Array de Double: ");


        System.out.println();

        // TODO: Intercambia elementos
        System.out.println("Intercambiando posiciones 0 y 3 en array de Integer...");
        // UtilidadesGenericas.intercambiar(numeros, 0, 3);
        System.out.print("Array después: ");
        // UtilidadesGenericas.imprimirArray(numeros);





        System.out.println();

        // TODO: Encuentra el máximo
        // Integer maxNum = UtilidadesGenericas.maximo(100, 50);
        // System.out.println("Máximo entre 100 y 50: " + maxNum);

        // String maxStr = UtilidadesGenericas.maximo("Zebra", "Aardvark");
        // System.out.println("Máximo entre \"Zebra\" y \"Aardvark\": " + maxStr);





        System.out.println();

        // TODO: Cuenta ocurrencias
        Integer[] numerosRepetidos = {10, 20, 30, 20, 50};
        // int ocurrencias = UtilidadesGenericas.contarOcurrencias(numerosRepetidos, 20);
        System.out.print("Ocurrencias de 20 en ");
        // UtilidadesGenericas.imprimirArray(numerosRepetidos);
        // System.out.println("Resultado: " + ocurrencias);





        System.out.println();

        // DEMOSTRACIÓN: El compilador previene errores
        System.out.println("=== SEGURIDAD DE TIPOS ===");
        Caja<String> cajaString = new Caja<>("Solo String");

        // Esto compilaría sin error:
        // String texto = cajaString.obtener();
        // System.out.println(texto);

        // Pero esto daría ERROR de compilación (¡bien!):
        // cajaString.guardar(123);  // ❌ Error: no puedes guardar Integer en Caja<String>

        // Sin genéricos (antes):
        // Object obj = cajaString.obtener();
        // String texto = (String) obj;  // Cast manual - riesgoso

        // Con genéricos (ahora):
        // String texto = cajaString.obtener();  // Sin cast - seguro

        System.out.println("✓ El compilador previene errores de tipos");
        System.out.println("✓ No necesitas casts manuales");
        System.out.println("✓ Errores detectados al compilar, no al ejecutar");

        // REFLEXIÓN:
        // ¿Por qué usar genéricos?
        // ✓ Código más seguro (errores en compilación)
        // ✓ Código más limpio (sin casts)
        // ✓ Código reutilizable (funciona con cualquier tipo)
        // ✓ Mejor rendimiento (no hay boxing/unboxing innecesario)
        //
        // GENÉRICOS EN LA VIDA REAL:
        // - ArrayList<E>, LinkedList<E>, HashMap<K,V>
        // - Optional<T> (Java 8+)
        // - Stream<T> (Java 8+)
        // - CompletableFuture<T>
        // - ResponseEntity<T> (Spring)
        //
        // COMPARACIÓN:
        // Sin genéricos:
        //   ArrayList lista = new ArrayList();
        //   lista.add("texto");
        //   lista.add(123);  // ¡Acepta cualquier cosa!
        //   String s = (String) lista.get(0);  // Cast manual
        //
        // Con genéricos:
        //   ArrayList<String> lista = new ArrayList<>();
        //   lista.add("texto");
        //   // lista.add(123);  // ERROR de compilación
        //   String s = lista.get(0);  // Sin cast
        //
        // WILDCARDS (avanzado):
        // - <?> = wildcard (cualquier tipo)
        // - <? extends T> = upper bound (T o subclases)
        // - <? super T> = lower bound (T o superclases)
    }
}
