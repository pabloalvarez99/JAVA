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

public class Ejercicio22 {
    // TODO: Lee las instrucciones arriba y escribe TODO el código
    // TODO: Implementa todas las clases, métodos y lógica necesaria
}
