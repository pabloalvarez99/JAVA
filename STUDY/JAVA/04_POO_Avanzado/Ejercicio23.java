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
 */

public class Ejercicio23 {
    // TODO: Lee las instrucciones arriba y escribe TODO el código
    // TODO: Implementa todas las clases, métodos y lógica necesaria
}
