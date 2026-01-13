/*
 * ========================================
 * EJERCICIO 21: Algoritmos de Ordenamiento - BubbleSort y SelectionSort
 * DIFICULTAD: ⭐⭐⭐⭐⭐⭐⭐ (Muy Difícil+)
 * ========================================
 *
 * OBJETIVO:
 * Aprender algoritmos de ORDENAMIENTO - cómo organizar datos de menor a mayor
 *
 * CONCEPTO CLAVE:
 * Los algoritmos de ordenamiento son fundamentales en programación.
 * Organizan datos para búsquedas más eficientes y mejor presentación.
 *
 * BUBBLE SORT (Ordenamiento Burbuja):
 * - Compara elementos adyacentes y los intercambia si están en orden incorrecto
 * - Repite el proceso hasta que no haya más intercambios
 * - Los elementos "burbujean" hacia su posición correcta
 * - Complejidad: O(n²) - lento, pero fácil de entender
 *
 * ANALOGÍA BUBBLE SORT:
 * Como ordenar cartas: comparas dos cartas seguidas, si la de la izquierda es
 * mayor, las intercambias. Repites hasta que todas estén ordenadas.
 *
 * SELECTION SORT (Ordenamiento por Selección):
 * - Encuentra el elemento más pequeño y lo coloca al inicio
 * - Luego encuentra el segundo más pequeño y lo coloca en segunda posición
 * - Repite hasta ordenar todo
 * - Complejidad: O(n²) - similar a Bubble Sort
 *
 * ANALOGÍA SELECTION SORT:
 * Como ordenar personas por altura: encuentras al más bajo y lo pones primero,
 * luego encuentras al siguiente más bajo, y así sucesivamente.
 *
 * INSTRUCCIONES:
 * 1. Crea una clase "AlgoritmosOrdenamiento" con métodos estáticos:
 *
 *    a) bubbleSort(int[] array):
 *       - Recorre el array múltiples veces
 *       - En cada pasada, compara elementos adyacentes
 *       - Si array[i] > array[i+1], intercámbialos
 *       - Muestra el estado del array después de cada pasada
 *       - Cuenta los intercambios realizados
 *
 *    b) selectionSort(int[] array):
 *       - Para cada posición i, busca el elemento más pequeño desde i hasta el final
 *       - Intercambia el elemento en posición i con el más pequeño encontrado
 *       - Muestra el estado del array después de cada selección
 *       - Cuenta los intercambios realizados
 *
 *    c) intercambiar(int[] array, int i, int j):
 *       - Método auxiliar que intercambia dos elementos del array
 *
 *    d) imprimirArray(int[] array):
 *       - Método auxiliar que imprime el array de forma legible
 *
 *    e) copiarArray(int[] original):
 *       - Método auxiliar que crea una copia del array
 *       - Necesario para ordenar el mismo array con diferentes algoritmos
 *
 * 2. En el main:
 *    - Crea un array desordenado: {64, 34, 25, 12, 22, 11, 90}
 *    - Prueba Bubble Sort con una copia del array
 *    - Prueba Selection Sort con otra copia del array
 *    - Compara el número de intercambios de cada algoritmo
 *    - Prueba con un array ya ordenado
 *    - Prueba con un array en orden inverso
 *
 * SALIDA ESPERADA:
 * === ALGORITMOS DE ORDENAMIENTO ===
 *
 * Array original: [64, 34, 25, 12, 22, 11, 90]
 *
 * === BUBBLE SORT ===
 * Pasada 1: [34, 25, 12, 22, 11, 64, 90]
 * Pasada 2: [25, 12, 22, 11, 34, 64, 90]
 * Pasada 3: [12, 22, 11, 25, 34, 64, 90]
 * Pasada 4: [12, 11, 22, 25, 34, 64, 90]
 * Pasada 5: [11, 12, 22, 25, 34, 64, 90]
 * Array ordenado: [11, 12, 22, 25, 34, 64, 90]
 * Total de intercambios: 12
 *
 * === SELECTION SORT ===
 * Paso 1 - Mínimo encontrado: 11 -> [11, 34, 25, 12, 22, 64, 90]
 * Paso 2 - Mínimo encontrado: 12 -> [11, 12, 25, 34, 22, 64, 90]
 * Paso 3 - Mínimo encontrado: 22 -> [11, 12, 22, 34, 25, 64, 90]
 * Paso 4 - Mínimo encontrado: 25 -> [11, 12, 22, 25, 34, 64, 90]
 * Paso 5 - Mínimo encontrado: 34 -> [11, 12, 22, 25, 34, 64, 90]
 * Paso 6 - Mínimo encontrado: 64 -> [11, 12, 22, 25, 34, 64, 90]
 * Array ordenado: [11, 12, 22, 25, 34, 64, 90]
 * Total de intercambios: 6
 *
 * CONCEPTOS NUEVOS:
 * - Algoritmos de ordenamiento
 * - Bubble Sort: Compara e intercambia adyacentes
 * - Selection Sort: Encuentra mínimo y lo coloca en posición
 * - Complejidad temporal: O(n²) para ambos
 * - Intercambio de elementos en array
 * - Visualización paso a paso del algoritmo
 *
 * COMPARACIÓN:
 * - Bubble Sort: Más intercambios, pero detecta arrays ordenados más rápido
 * - Selection Sort: Menos intercambios, pero siempre hace n² comparaciones
 * - Ambos son O(n²), por lo que son lentos para arrays grandes
 * - En la práctica se usan algoritmos más eficientes (QuickSort, MergeSort)
 *
 * MEJORA BUBBLE SORT:
 * - Optimización: Si en una pasada no hay intercambios, el array está ordenado
 *
 */

import java.util.Arrays;

public class Ejercicio21 {
    // TODO: Lee las instrucciones arriba y escribe TODO el código
    // TODO: Implementa todas las clases, métodos y lógica necesaria
}
