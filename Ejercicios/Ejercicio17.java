/*
 * ========================================
 * EJERCICIO 17: Manejo de Excepciones - Calculadora Segura
 * DIFICULTAD: ⭐⭐⭐⭐⭐⭐ (Muy Difícil)
 * ========================================
 *
 * OBJETIVO:
 * Aprender a manejar EXCEPCIONES para crear programas robustos
 *
 * CONCEPTO CLAVE:
 * Las excepciones son eventos que interrumpen el flujo normal del programa.
 * El manejo de excepciones permite que el programa responda a errores sin "romperse".
 *
 * TIPOS DE EXCEPCIONES:
 * - Checked Exceptions: El compilador te obliga a manejarlas (ej: IOException)
 * - Unchecked Exceptions: No es obligatorio manejarlas (ej: NullPointerException)
 * - Custom Exceptions: Excepciones que tú defines
 *
 * INSTRUCCIONES:
 * 1. Crea una excepción personalizada "OperacionInvalidaException":
 *    - Extiende de Exception
 *    - Constructor que reciba un mensaje
 *    - Usa super(mensaje) para pasar el mensaje al padre
 *
 * 2. Crea una clase "CalculadoraSegura" con:
 *    - Método "dividir(int a, int b)" que lance OperacionInvalidaException si b es 0
 *    - Método "raizCuadrada(double numero)" que lance OperacionInvalidaException si numero < 0
 *    - Método "calcularPromedio(int[] numeros)" que lance OperacionInvalidaException si el array está vacío
 *    - Método "obtenerElemento(int[] array, int indice)" que maneje ArrayIndexOutOfBoundsException
 *
 * 3. En el main:
 *    - Crea varios bloques try-catch para probar cada método
 *    - Intenta operaciones válidas e inválidas
 *    - Captura y maneja las excepciones apropiadamente
 *    - Usa finally para mostrar mensajes de limpieza
 *
 * SALIDA ESPERADA:
 * === CALCULADORA SEGURA CON EXCEPCIONES ===
 *
 * --- Prueba 1: División válida ---
 * 10 / 2 = 5.0
 *
 * --- Prueba 2: División por cero ---
 * Error: No se puede dividir por cero
 * Operación completada
 *
 * --- Prueba 3: Raíz cuadrada válida ---
 * Raíz cuadrada de 25.0 = 5.0
 *
 * --- Prueba 4: Raíz cuadrada de número negativo ---
 * Error: No se puede calcular la raíz cuadrada de un número negativo
 *
 * --- Prueba 5: Promedio válido ---
 * Promedio: 35.0
 *
 * --- Prueba 6: Promedio de array vacío ---
 * Error: El array está vacío
 *
 * --- Prueba 7: Acceso a índice válido ---
 * Elemento en índice 2: 30
 *
 * --- Prueba 8: Acceso a índice inválido ---
 * Error: Índice fuera de rango
 *
 * CONCEPTOS NUEVOS:
 * - try-catch-finally: Estructura para manejar excepciones
 * - throw: Lanza una excepción
 * - throws: Declara que un método puede lanzar una excepción
 * - Custom Exception: Crear tus propias excepciones
 * - Multiple catch: Capturar diferentes tipos de excepciones
 *
 * ESTRUCTURA:
 * try {
 *     // Código que puede fallar
 * } catch (TipoExcepcion e) {
 *     // Qué hacer si falla
 * } finally {
 *     // Siempre se ejecuta (opcional)
 * }
 *
 * PISTA:
 * - Lanzar: throw new OperacionInvalidaException("Mensaje");
 * - Declarar: public void metodo() throws OperacionInvalidaException { ... }
 * - Capturar: catch (OperacionInvalidaException e) { System.out.println(e.getMessage()); }
 */

// TODO: Crea la excepción personalizada OperacionInvalidaException
class OperacionInvalidaException extends Exception {
    // Constructor que recibe un mensaje
    public OperacionInvalidaException(String mensaje) {
        // TODO: Llama al constructor del padre (Exception)

    }
}

// TODO: Crea la clase CalculadoraSegura
class CalculadoraSegura {

    // Método dividir - lanza excepción si b es 0
    public double dividir(int a, int b) throws OperacionInvalidaException {
        // TODO: Si b es 0, lanza la excepción
        if (b == 0) {
            throw new OperacionInvalidaException("No se puede dividir por cero");
        }

        // TODO: Retorna la división
        return 0.0; // TEMPORAL: reemplaza esto con (double) a / b
    }

    // Método raizCuadrada - lanza excepción si numero es negativo
    public double raizCuadrada(double numero) throws OperacionInvalidaException {
        // TODO: Si numero < 0, lanza la excepción


        // TODO: Retorna la raíz cuadrada (Math.sqrt)
        return 0.0; // TEMPORAL: reemplaza esto con Math.sqrt(numero)
    }

    // Método calcularPromedio - lanza excepción si el array está vacío
    public double calcularPromedio(int[] numeros) throws OperacionInvalidaException {
        // TODO: Si el array está vacío o es null, lanza la excepción


        // TODO: Calcula y retorna el promedio
        return 0.0; // TEMPORAL: reemplaza esto

    }

    // Método obtenerElemento - maneja ArrayIndexOutOfBoundsException internamente
    public int obtenerElemento(int[] array, int indice) {
        try {
            // TODO: Intenta obtener el elemento
            return 0; // TEMPORAL: reemplaza esto con array[indice]
        } catch (ArrayIndexOutOfBoundsException e) {
            // TODO: Captura la excepción y retorna un valor por defecto
            System.out.println("Error: Índice fuera de rango");
            return -1;
        }
    }
}

public class Ejercicio17 {
    public static void main(String[] args) {
        System.out.println("=== CALCULADORA SEGURA CON EXCEPCIONES ===\n");

        CalculadoraSegura calc = new CalculadoraSegura();

        // --- PRUEBA 1: División válida ---
        System.out.println("--- Prueba 1: División válida ---");
        try {
            double resultado = calc.dividir(10, 2);
            System.out.println("10 / 2 = " + resultado);
        } catch (OperacionInvalidaException e) {
            System.out.println("Error: " + e.getMessage());
        }
        System.out.println();

        // --- PRUEBA 2: División por cero ---
        System.out.println("--- Prueba 2: División por cero ---");
        // TODO: Descomenta el try-catch de abajo
        /*
        try {
            double resultado = calc.dividir(10, 0);
            System.out.println(resultado);
        } catch (OperacionInvalidaException e) {
            System.out.println("Error: " + e.getMessage());
        } finally {
            System.out.println("Operación completada");
        }
        */
        System.out.println();

        // --- PRUEBA 3: Raíz cuadrada válida ---
        System.out.println("--- Prueba 3: Raíz cuadrada válida ---");
        // TODO: Descomenta el try-catch de abajo
        /*
        try {
            double raiz = calc.raizCuadrada(25);
            System.out.println("Raíz cuadrada de 25.0 = " + raiz);
        } catch (OperacionInvalidaException e) {
            System.out.println("Error: " + e.getMessage());
        }
        */
        System.out.println();

        // --- PRUEBA 4: Raíz cuadrada de número negativo ---
        System.out.println("--- Prueba 4: Raíz cuadrada de número negativo ---");
        // TODO: Intenta calcular la raíz de -16


        System.out.println();

        // --- PRUEBA 5: Promedio válido ---
        System.out.println("--- Prueba 5: Promedio válido ---");
        int[] numeros = {10, 20, 30, 40, 50};
        // TODO: Calcula el promedio


        System.out.println();

        // --- PRUEBA 6: Promedio de array vacío ---
        System.out.println("--- Prueba 6: Promedio de array vacío ---");
        int[] numerosVacio = {};
        // TODO: Intenta calcular el promedio de un array vacío


        System.out.println();

        // --- PRUEBA 7: Acceso a índice válido ---
        System.out.println("--- Prueba 7: Acceso a índice válido ---");
        int elemento = calc.obtenerElemento(numeros, 2);
        if (elemento != -1) {
            System.out.println("Elemento en índice 2: " + elemento);
        }
        System.out.println();

        // --- PRUEBA 8: Acceso a índice inválido ---
        System.out.println("--- Prueba 8: Acceso a índice inválido ---");
        // TODO: Intenta acceder a un índice que no existe


        // REFLEXIÓN:
        // ¿Por qué manejar excepciones?
        // - Evita que el programa se "rompa" inesperadamente
        // - Permite responder de manera controlada a errores
        // - Mejora la experiencia del usuario
        // - Facilita el debugging al tener mensajes claros
        // - Hace el código más robusto y profesional
        //
        // EXCEPCIONES COMUNES EN JAVA:
        // - NullPointerException: Intentar usar un objeto null
        // - ArrayIndexOutOfBoundsException: Índice fuera del rango del array
        // - NumberFormatException: Error al convertir String a número
        // - ArithmeticException: Error aritmético (ej: división por cero)
        // - FileNotFoundException: Archivo no encontrado
    }
}
