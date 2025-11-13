/*
 * ========================================
 * EJERCICIO 22: Recursividad - Factorial, Fibonacci y Suma
 * DIFICULTAD: ⭐⭐⭐⭐⭐⭐⭐⭐ (Extremadamente Difícil)
 * ========================================
 *
 * OBJETIVO:
 * Aprender RECURSIVIDAD - cuando una función se llama a sí misma
 *
 * CONCEPTO CLAVE:
 * Recursividad es una técnica donde un método se llama a sí mismo para resolver
 * un problema dividiéndolo en subproblemas más pequeños del mismo tipo.
 *
 * ESTRUCTURA DE UNA FUNCIÓN RECURSIVA:
 * 1. CASO BASE: Condición que detiene la recursión (¡MUY IMPORTANTE!)
 * 2. CASO RECURSIVO: La función se llama a sí misma con un problema más pequeño
 *
 * ANALOGÍA:
 * Es como matrioskas (muñecas rusas): cada muñeca contiene una más pequeña
 * hasta llegar a la más pequeña (caso base).
 *
 * EJEMPLO SIMPLE:
 * Factorial de 5 = 5! = 5 × 4 × 3 × 2 × 1 = 120
 * Recursivamente: 5! = 5 × 4! = 5 × (4 × 3!) = 5 × (4 × (3 × 2!)) = ...
 *
 * FIBONACCI:
 * Secuencia: 0, 1, 1, 2, 3, 5, 8, 13, 21, 34...
 * Regla: fib(n) = fib(n-1) + fib(n-2)
 * Caso base: fib(0) = 0, fib(1) = 1
 *
 * ⚠️ ADVERTENCIA:
 * La recursión puede ser PELIGROSA si no tiene caso base -> StackOverflowError
 *
 * INSTRUCCIONES:
 * 1. Crea una clase "Recursividad" con métodos estáticos:
 *
 *    a) factorial(int n):
 *       - Calcula n! = n × (n-1) × (n-2) × ... × 1
 *       - Caso base: factorial(0) = 1, factorial(1) = 1
 *       - Caso recursivo: factorial(n) = n × factorial(n-1)
 *       - Muestra cada llamada recursiva para visualizar el proceso
 *
 *    b) fibonacci(int n):
 *       - Calcula el n-ésimo número de Fibonacci
 *       - Caso base: fib(0) = 0, fib(1) = 1
 *       - Caso recursivo: fib(n) = fib(n-1) + fib(n-2)
 *       - Cuenta las llamadas recursivas totales
 *
 *    c) sumaDigitos(int numero):
 *       - Suma los dígitos de un número
 *       - Ejemplo: 1234 -> 1 + 2 + 3 + 4 = 10
 *       - Caso base: si numero < 10, retorna el número
 *       - Caso recursivo: (numero % 10) + sumaDigitos(numero / 10)
 *
 *    d) potencia(int base, int exponente):
 *       - Calcula base^exponente usando recursión
 *       - Ejemplo: 2^3 = 2 × 2 × 2 = 8
 *       - Caso base: potencia(base, 0) = 1
 *       - Caso recursivo: potencia(base, exp) = base × potencia(base, exp-1)
 *
 *    e) contarDigitos(int numero):
 *       - Cuenta cuántos dígitos tiene un número
 *       - Ejemplo: 12345 tiene 5 dígitos
 *       - Caso base: si numero < 10, retorna 1
 *       - Caso recursivo: 1 + contarDigitos(numero / 10)
 *
 *    f) invertirNumero(int numero, int invertido):
 *       - Invierte los dígitos de un número
 *       - Ejemplo: 1234 -> 4321
 *       - Usa un parámetro acumulador
 *
 * 2. En el main:
 *    - Prueba factorial con varios números
 *    - Prueba Fibonacci con varios valores
 *    - Prueba suma de dígitos
 *    - Prueba potencia
 *    - Prueba contar dígitos
 *    - Prueba invertir número
 *    - Compara versión recursiva vs iterativa (bucle)
 *
 * SALIDA ESPERADA:
 * === RECURSIVIDAD EN JAVA ===
 *
 * === FACTORIAL ===
 * factorial(5) = 5 × factorial(4)
 * factorial(4) = 4 × factorial(3)
 * factorial(3) = 3 × factorial(2)
 * factorial(2) = 2 × factorial(1)
 * factorial(1) = 1 (caso base)
 * Resultado: 5! = 120
 *
 * === FIBONACCI ===
 * Fibonacci(7) = 13
 * Total de llamadas recursivas: 41
 *
 * === SUMA DE DÍGITOS ===
 * Suma de dígitos de 1234 = 10
 *
 * === POTENCIA ===
 * 2^8 = 256
 *
 * === CONTAR DÍGITOS ===
 * 12345 tiene 5 dígitos
 *
 * === INVERTIR NÚMERO ===
 * 1234 invertido = 4321
 *
 * === COMPARACIÓN: RECURSIVO VS ITERATIVO ===
 * Factorial recursivo de 10: 3628800
 * Factorial iterativo de 10: 3628800
 *
 * CONCEPTOS NUEVOS:
 * - Recursividad: Función que se llama a sí misma
 * - Caso base: Condición de parada (¡obligatoria!)
 * - Caso recursivo: Llamada a sí misma con problema más pequeño
 * - Call stack: Pila de llamadas (cada llamada se apila)
 * - StackOverflowError: Error cuando hay demasiadas llamadas recursivas
 * - Recursión vs Iteración: Dos formas de resolver el mismo problema
 *
 * VENTAJAS DE RECURSIÓN:
 * - Código más limpio y elegante
 * - Natural para problemas divididos en subproblemas (árboles, fractales)
 * - Más fácil de entender para ciertos algoritmos
 *
 * DESVENTAJAS DE RECURSIÓN:
 * - Consume más memoria (call stack)
 * - Puede ser más lenta que iteración
 * - Riesgo de StackOverflowError
 * - Difícil de debuggear
 *
 * CUÁNDO USAR RECURSIÓN:
 * - Problemas naturalmente recursivos (árboles, grafos)
 * - Divide y conquista (QuickSort, MergeSort)
 * - Backtracking (laberintos, sudoku)
 * - Estructuras recursivas (listas enlazadas, árboles)
 *
 * OPTIMIZACIÓN:
 * - Fibonacci recursivo es ineficiente (O(2^n))
 * - Solución: Memoization o Dynamic Programming
 * - O usar versión iterativa
 *
 */

// TODO: Crea la clase Recursividad
class Recursividad {

    // Variable para contar llamadas en Fibonacci
    private static int contadorLlamadas = 0;

    // FACTORIAL RECURSIVO
    public static int factorial(int n) {
        // TODO: Implementa factorial recursivo

        // Caso base
        if (n == 0 || n == 1) {
            System.out.println("factorial(" + n + ") = 1 (caso base)");
            return 1;
        }

        // Caso recursivo
        System.out.println("factorial(" + n + ") = " + n + " × factorial(" + (n - 1) + ")");
        // TODO: Retorna n * factorial(n - 1)
        return 0; // TEMPORAL




    }

    // FIBONACCI RECURSIVO
    public static int fibonacci(int n) {
        contadorLlamadas++;

        // TODO: Implementa Fibonacci recursivo

        // Caso base
        if (n == 0) {
            return 0;
        }
        if (n == 1) {
            return 1;
        }

        // Caso recursivo: fib(n) = fib(n-1) + fib(n-2)
        // TODO: Retorna fibonacci(n - 1) + fibonacci(n - 2)
        return 0; // TEMPORAL






    }

    // Método auxiliar para Fibonacci que reinicia el contador
    public static int fibonacciConContador(int n) {
        contadorLlamadas = 0;
        int resultado = fibonacci(n);
        System.out.println("Total de llamadas recursivas: " + contadorLlamadas);
        return resultado;
    }

    // SUMA DE DÍGITOS
    public static int sumaDigitos(int numero) {
        // TODO: Implementa suma de dígitos recursivo

        // Caso base: si el número es menor a 10, es de un solo dígito



        // Caso recursivo: último dígito + suma del resto
        // Último dígito: numero % 10
        // Resto: numero / 10
        return 0; // TEMPORAL






    }

    // POTENCIA RECURSIVA
    public static int potencia(int base, int exponente) {
        // TODO: Implementa potencia recursiva

        // Caso base: cualquier número elevado a 0 es 1



        // Caso recursivo: base × potencia(base, exponente - 1)
        return 0; // TEMPORAL




    }

    // CONTAR DÍGITOS
    public static int contarDigitos(int numero) {
        // TODO: Implementa contar dígitos recursivo

        // Caso base: si numero < 10, tiene 1 dígito



        // Caso recursivo: 1 + contarDigitos(numero / 10)
        return 0; // TEMPORAL




    }

    // INVERTIR NÚMERO (usando parámetro acumulador)
    public static int invertirNumero(int numero, int invertido) {
        // TODO: Implementa invertir número recursivo

        // Caso base: si numero es 0, retorna el invertido



        // Caso recursivo:
        // 1. Toma el último dígito: numero % 10
        // 2. Agrégalo al invertido: invertido * 10 + último dígito
        // 3. Llama recursivamente con: (numero / 10, nuevo invertido)
        return 0; // TEMPORAL






    }

    // Sobrecarga para facilitar el uso
    public static int invertirNumero(int numero) {
        return invertirNumero(numero, 0);
    }

    // ====== VERSIÓN ITERATIVA PARA COMPARAR ======

    // FACTORIAL ITERATIVO (con bucle)
    public static int factorialIterativo(int n) {
        int resultado = 1;
        for (int i = 2; i <= n; i++) {
            resultado *= i;
        }
        return resultado;
    }

    // FIBONACCI ITERATIVO (mucho más eficiente)
    public static int fibonacciIterativo(int n) {
        if (n == 0) return 0;
        if (n == 1) return 1;

        int anterior = 0;
        int actual = 1;

        for (int i = 2; i <= n; i++) {
            int siguiente = anterior + actual;
            anterior = actual;
            actual = siguiente;
        }

        return actual;
    }
}

public class Ejercicio22 {
    public static void main(String[] args) {
        System.out.println("=== RECURSIVIDAD EN JAVA ===\n");

        // === FACTORIAL ===
        System.out.println("=== FACTORIAL ===");
        // TODO: Prueba factorial con 5
        // int fact5 = Recursividad.factorial(5);
        // System.out.println("Resultado: 5! = " + fact5);



        System.out.println();

        // === FIBONACCI ===
        System.out.println("=== FIBONACCI ===");
        // TODO: Prueba Fibonacci con 7
        // int fib7 = Recursividad.fibonacciConContador(7);
        // System.out.println("Fibonacci(7) = " + fib7);



        System.out.println();

        // === SUMA DE DÍGITOS ===
        System.out.println("=== SUMA DE DÍGITOS ===");
        // TODO: Suma los dígitos de 1234
        // int suma = Recursividad.sumaDigitos(1234);
        // System.out.println("Suma de dígitos de 1234 = " + suma);



        System.out.println();

        // === POTENCIA ===
        System.out.println("=== POTENCIA ===");
        // TODO: Calcula 2^8
        // int pot = Recursividad.potencia(2, 8);
        // System.out.println("2^8 = " + pot);



        System.out.println();

        // === CONTAR DÍGITOS ===
        System.out.println("=== CONTAR DÍGITOS ===");
        // TODO: Cuenta los dígitos de 12345
        // int digitos = Recursividad.contarDigitos(12345);
        // System.out.println("12345 tiene " + digitos + " dígitos");



        System.out.println();

        // === INVERTIR NÚMERO ===
        System.out.println("=== INVERTIR NÚMERO ===");
        // TODO: Invierte 1234
        // int invertido = Recursividad.invertirNumero(1234);
        // System.out.println("1234 invertido = " + invertido);



        System.out.println();

        // === COMPARACIÓN: RECURSIVO VS ITERATIVO ===
        System.out.println("=== COMPARACIÓN: RECURSIVO VS ITERATIVO ===");

        // Factorial
        // TODO: Compara factorial recursivo e iterativo
        // int factRec = Recursividad.factorial(10);
        // int factIter = Recursividad.factorialIterativo(10);
        // System.out.println("Factorial recursivo de 10: " + factRec);
        // System.out.println("Factorial iterativo de 10: " + factIter);





        System.out.println();

        // Fibonacci (nota la diferencia de eficiencia)
        System.out.println("Fibonacci recursivo vs iterativo:");
        // TODO: Prueba ambos con un número no muy grande (ej: 10)
        // System.out.println("Recursivo - fib(10) = " + Recursividad.fibonacciConContador(10));
        // System.out.println("Iterativo - fib(10) = " + Recursividad.fibonacciIterativo(10));



        // DESAFÍO: ¿Te animas a probar fib(40) con ambos métodos?
        // ¡Verás una ENORME diferencia de velocidad!

        // REFLEXIÓN:
        // ¿Cuándo usar recursión?
        // ✓ Problemas naturalmente recursivos (árboles, grafos)
        // ✓ Código más limpio y fácil de leer
        // ✓ Estructuras recursivas
        //
        // ¿Cuándo NO usar recursión?
        // ✗ Cuando la versión iterativa es más eficiente
        // ✗ Fibonacci recursivo (usa iterativo o memoization)
        // ✗ Cuando puede haber muchas llamadas (riesgo de StackOverflow)
        //
        // RECURSIÓN FAMOSA EN ALGORITMOS:
        // - QuickSort y MergeSort (ordenamiento eficiente)
        // - Recorrido de árboles binarios (preorder, inorder, postorder)
        // - Backtracking (resolver sudoku, laberintos)
        // - Divide y conquista (búsqueda binaria puede ser recursiva)
        //
        // ERROR COMÚN: Olvidar el caso base -> StackOverflowError
        // Ejemplo:
        // public static int malo(int n) {
        //     return malo(n - 1);  // ¡NUNCA se detiene!
        // }
    }
}
