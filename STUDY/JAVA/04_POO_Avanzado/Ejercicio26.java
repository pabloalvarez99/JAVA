/*
 * ========================================
 * EJERCICIO 26: MergeSort - Algoritmo de Ordenamiento Eficiente
 * DIFICULTAD: ⭐⭐⭐⭐⭐⭐⭐⭐⭐ (Maestro)
 * ========================================
 *
 * OBJETIVO:
 * Implementar MergeSort, uno de los algoritmos de ordenamiento más eficientes
 * y entender la estrategia "Divide y Conquista"
 *
 * CONCEPTO CLAVE:
 * MergeSort es un algoritmo que ordena dividiendo el array en mitades,
 * ordenando cada mitad recursivamente, y luego COMBINANDO (merging) las
 * mitades ordenadas.
 *
 * COMPARACIÓN DE ALGORITMOS DE ORDENAMIENTO:
 *
 * Bubble Sort / Selection Sort:  O(n²) - lento para arrays grandes
 * MergeSort / QuickSort:         O(n log n) - rápido y eficiente
 *
 * Ejemplo con n = 1,000,000 elementos:
 * - Bubble Sort: ~1,000,000,000,000 operaciones (1 billón) ❌ LENTO
 * - MergeSort:   ~20,000,000 operaciones (20 millones) ✓ RÁPIDO
 *
 * ESTRATEGIA: DIVIDE Y CONQUISTA
 * 1. DIVIDE: Divide el array en dos mitades
 * 2. CONQUISTA: Ordena recursivamente cada mitad
 * 3. COMBINA: Merge (fusiona) las dos mitades ordenadas
 *
 * ANALOGÍA:
 * Es como ordenar un mazo de cartas:
 * 1. Divide el mazo en dos montones
 * 2. Ordena cada montón por separado
 * 3. Combina los dos montones ordenados tomando siempre la carta menor
 *
 * EJEMPLO PASO A PASO:
 * Array original: [38, 27, 43, 3, 9, 82, 10]
 *
 * PASO 1 - DIVIDE:
 *   [38, 27, 43, 3, 9, 82, 10]
 *        ↓
 *   [38, 27, 43]  |  [3, 9, 82, 10]
 *        ↓                  ↓
 *   [38] [27, 43]  |  [3, 9] [82, 10]
 *         ↓                ↓      ↓
 *   [38] [27][43]  |  [3][9] [82][10]
 *
 * PASO 2 - MERGE (combina):
 *   [38] [27][43]  →  [38] [27,43]  →  [27,38,43]
 *   [3][9] [82][10] →  [3,9] [10,82] →  [3,9,10,82]
 *
 * PASO 3 - MERGE FINAL:
 *   [27,38,43] y [3,9,10,82]
 *   Compara: 27 vs 3  → toma 3
 *   Compara: 27 vs 9  → toma 9
 *   Compara: 27 vs 10 → toma 10
 *   Compara: 27 vs 82 → toma 27
 *   ... continúa ...
 *   Resultado: [3, 9, 10, 27, 38, 43, 82]
 *
 * PROCESO MERGE:
 * Tenemos dos arrays ordenados: [27, 38, 43] y [3, 9, 10, 82]
 * Comparamos elemento por elemento y tomamos el menor:
 *   i=0, j=0: 27 vs 3  → agrega 3  → [3]
 *   i=0, j=1: 27 vs 9  → agrega 9  → [3, 9]
 *   i=0, j=2: 27 vs 10 → agrega 10 → [3, 9, 10]
 *   i=0, j=3: 27 vs 82 → agrega 27 → [3, 9, 10, 27]
 *   ... y así sucesivamente
 *
 * INSTRUCCIONES:
 * 1. Implementa mergeSort(int[] array, int izquierda, int derecha)
 *    - Método recursivo principal
 *    - Divide el array en mitades
 *    - Llama recursivamente a sí mismo
 *    - Llama a merge para combinar
 *
 * 2. Implementa merge(int[] array, int izq, int medio, int der)
 *    - Combina dos subarrays ordenados
 *    - Usa arrays temporales
 *    - Compara elementos y coloca en orden
 *
 * 3. Crea un método auxiliar para contar comparaciones
 *    - Para visualizar la eficiencia
 *
 * 4. Compara con Bubble Sort
 *    - Mide tiempo y comparaciones
 *
 * SALIDA ESPERADA:
 * === MERGESORT - ALGORITMO O(n log n) ===
 *
 * Array original: [38, 27, 43, 3, 9, 82, 10]
 *
 * === PROCESO DE DIVISIÓN ===
 * Dividiendo: [38, 27, 43, 3, 9, 82, 10]
 * Dividiendo: [38, 27, 43]
 * Dividiendo: [38, 27]
 * Combinando: [27, 38]
 * Combinando: [27, 38, 43]
 * Dividiendo: [3, 9, 82, 10]
 * Dividiendo: [3, 9]
 * Combinando: [3, 9]
 * Dividiendo: [82, 10]
 * Combinando: [10, 82]
 * Combinando: [3, 9, 10, 82]
 * Combinando: [3, 9, 10, 27, 38, 43, 82]
 *
 * Array ordenado: [3, 9, 10, 27, 38, 43, 82]
 *
 * === COMPARACIÓN: MERGESORT VS BUBBLESORT ===
 * Array grande (1000 elementos aleatorios)
 *
 * BubbleSort:
 * - Tiempo: 15 ms
 * - Comparaciones: 499,500
 *
 * MergeSort:
 * - Tiempo: 2 ms
 * - Comparaciones: 8,985
 * - ⚡ 7.5x más rápido
 * - ⚡ 55x menos comparaciones
 *
 * CONCEPTOS NUEVOS:
 * - MergeSort: Algoritmo de ordenamiento eficiente
 * - Divide y Conquista: Estrategia de dividir el problema
 * - O(n log n): Complejidad cuasi-lineal
 * - Merge: Combinar dos arrays ordenados
 * - Recursión profunda: Múltiples niveles recursivos
 * - Stable sort: Mantiene el orden relativo de elementos iguales
 *
 * COMPLEJIDAD:
 * - Tiempo: O(n log n) en TODOS los casos (mejor, promedio, peor)
 * - Espacio: O(n) - necesita arrays temporales
 *
 * VENTAJAS:
 * ✓ Muy eficiente O(n log n)
 * ✓ Predecible (siempre O(n log n))
 * ✓ Stable (mantiene orden relativo)
 * ✓ Funciona bien con listas enlazadas
 * ✓ Paralelizable (se puede hacer en paralelo)
 *
 * DESVENTAJAS:
 * ✗ Usa O(n) espacio adicional
 * ✗ No es in-place (necesita copiar datos)
 * ✗ Overhead de recursión
 *
 * CUÁNDO USAR MERGESORT:
 * ✓ Arrays grandes (> 100 elementos)
 * ✓ Necesitas stable sort
 * ✓ Rendimiento predecible
 * ✓ Listas enlazadas (eficiente sin acceso aleatorio)
 *
 */

public class Ejercicio26 {
    // TODO: Lee las instrucciones arriba y escribe TODO el código
    // TODO: Implementa todas las clases, métodos y lógica necesaria
}
