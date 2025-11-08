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
 * PISTAS:
 * - Caso base de recursión: si izq >= der, ya está ordenado
 * - Calcula medio: medio = izq + (der - izq) / 2
 * - Merge usa dos punteros: uno para cada subarray
 * - Copia elementos restantes después del merge
 */

public class Ejercicio26 {

    private static int comparaciones = 0;  // Contador para análisis

    // TODO: Implementa mergeSort recursivo
    public static void mergeSort(int[] array, int izquierda, int derecha) {
        // Caso base: si hay 0 o 1 elemento, ya está ordenado
        if (izquierda >= derecha) {
            return;
        }

        // PASO 1: DIVIDE - encuentra el punto medio
        int medio = izquierda + (derecha - izquierda) / 2;

        // PASO 2: CONQUISTA - ordena recursivamente cada mitad
        // TODO: Llama recursivamente para la mitad izquierda
        mergeSort(array, izquierda, medio);

        // TODO: Llama recursivamente para la mitad derecha
        mergeSort(array, medio + 1, derecha);

        // PASO 3: COMBINA - merge las dos mitades ordenadas
        // TODO: Llama a merge para combinar
        merge(array, izquierda, medio, derecha);
    }

    // TODO: Implementa merge (combinar dos subarrays ordenados)
    public static void merge(int[] array, int izq, int medio, int der) {
        // Calcula tamaños de los subarrays
        int n1 = medio - izq + 1;  // Tamaño del subarray izquierdo
        int n2 = der - medio;      // Tamaño del subarray derecho

        // Crea arrays temporales
        int[] izquierdo = new int[n1];
        int[] derecho = new int[n2];

        // TODO: Copia datos a los arrays temporales
        for (int i = 0; i < n1; i++) {
            izquierdo[i] = array[izq + i];
        }
        for (int j = 0; j < n2; j++) {
            derecho[j] = array[medio + 1 + j];
        }

        // TODO: Merge (combina) los arrays temporales de vuelta al array original

        // Índices iniciales
        int i = 0;     // Índice para array izquierdo
        int j = 0;     // Índice para array derecho
        int k = izq;   // Índice para array original

        // Compara elementos de ambos arrays y coloca el menor
        while (i < n1 && j < n2) {
            comparaciones++;
            if (izquierdo[i] <= derecho[j]) {
                array[k] = izquierdo[i];
                i++;
            } else {
                array[k] = derecho[j];
                j++;
            }
            k++;
        }

        // TODO: Copia los elementos restantes del array izquierdo (si hay)
        while (i < n1) {
            array[k] = izquierdo[i];
            i++;
            k++;
        }

        // TODO: Copia los elementos restantes del array derecho (si hay)
        while (j < n2) {
            array[k] = derecho[j];
            j++;
            k++;
        }
    }

    // Versión con visualización del proceso
    public static void mergeSortVisual(int[] array, int izquierda, int derecha, int nivel) {
        if (izquierda >= derecha) {
            return;
        }

        // Imprime indentación según nivel de recursión
        String indent = "  ".repeat(nivel);

        // Imprime el subarray actual
        System.out.print(indent + "Dividiendo: [");
        for (int i = izquierda; i <= derecha; i++) {
            System.out.print(array[i]);
            if (i < derecha) System.out.print(", ");
        }
        System.out.println("]");

        int medio = izquierda + (derecha - izquierda) / 2;

        mergeSortVisual(array, izquierda, medio, nivel + 1);
        mergeSortVisual(array, medio + 1, derecha, nivel + 1);

        merge(array, izquierda, medio, derecha);

        // Imprime el resultado del merge
        System.out.print(indent + "Combinando: [");
        for (int i = izquierda; i <= derecha; i++) {
            System.out.print(array[i]);
            if (i < derecha) System.out.print(", ");
        }
        System.out.println("]");
    }

    // Bubble Sort para comparar
    public static void bubbleSort(int[] array) {
        int n = array.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                comparaciones++;
                if (array[j] > array[j + 1]) {
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
            }
        }
    }

    // Método auxiliar para imprimir array
    public static void imprimirArray(int[] array) {
        System.out.print("[");
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i]);
            if (i < array.length - 1) {
                System.out.print(", ");
            }
        }
        System.out.println("]");
    }

    // Método para copiar array
    public static int[] copiarArray(int[] original) {
        int[] copia = new int[original.length];
        for (int i = 0; i < original.length; i++) {
            copia[i] = original[i];
        }
        return copia;
    }

    public static void main(String[] args) {
        System.out.println("=== MERGESORT - ALGORITMO O(n log n) ===\n");

        // Array de ejemplo
        int[] array = {38, 27, 43, 3, 9, 82, 10};
        System.out.print("Array original: ");
        imprimirArray(array);
        System.out.println();

        // === VISUALIZACIÓN DEL PROCESO ===
        System.out.println("=== PROCESO DE DIVISIÓN Y COMBINACIÓN ===");
        int[] arrayVisual = copiarArray(array);
        mergeSortVisual(arrayVisual, 0, arrayVisual.length - 1, 0);
        System.out.println();

        System.out.print("Array ordenado: ");
        imprimirArray(arrayVisual);
        System.out.println();

        // === COMPARACIÓN CON BUBBLE SORT ===
        System.out.println("=== COMPARACIÓN: MERGESORT VS BUBBLESORT ===");

        // Crea array grande aleatorio
        int tamaño = 1000;
        int[] arrayGrande = new int[tamaño];
        for (int i = 0; i < tamaño; i++) {
            arrayGrande[i] = (int)(Math.random() * 1000);
        }

        System.out.println("Array grande (" + tamaño + " elementos aleatorios)\n");

        // Test BubbleSort
        int[] array1 = copiarArray(arrayGrande);
        comparaciones = 0;
        long inicio1 = System.currentTimeMillis();
        bubbleSort(array1);
        long fin1 = System.currentTimeMillis();
        int compBubble = comparaciones;

        System.out.println("BubbleSort:");
        System.out.println("- Tiempo: " + (fin1 - inicio1) + " ms");
        System.out.println("- Comparaciones: " + compBubble);
        System.out.println();

        // Test MergeSort
        int[] array2 = copiarArray(arrayGrande);
        comparaciones = 0;
        long inicio2 = System.currentTimeMillis();
        mergeSort(array2, 0, array2.length - 1);
        long fin2 = System.currentTimeMillis();
        int compMerge = comparaciones;

        System.out.println("MergeSort:");
        System.out.println("- Tiempo: " + (fin2 - inicio2) + " ms");
        System.out.println("- Comparaciones: " + compMerge);

        if (fin2 - inicio2 > 0) {
            System.out.printf("- ⚡ %.1fx más rápido\n", (double)(fin1 - inicio1) / (fin2 - inicio2));
        }
        System.out.printf("- ⚡ %.1fx menos comparaciones\n", (double)compBubble / compMerge);
        System.out.println();

        // REFLEXIÓN:
        // ¿Por qué MergeSort es tan importante?
        // ✓ Uno de los algoritmos más eficientes O(n log n)
        // ✓ Ejemplo perfecto de "divide y conquista"
        // ✓ Usado en muchas librerías estándar (Arrays.sort en Java para objetos)
        // ✓ Base de algoritmos externos de ordenamiento (archivos grandes)
        //
        // MERGESORT EN LA VIDA REAL:
        // - Java Collections: Arrays.sort() usa variante de MergeSort para objetos
        // - Python: sorted() usa Timsort (basado en MergeSort)
        // - Bases de datos: Ordenamiento externo de grandes datasets
        // - Git: Merge de archivos usa conceptos similares
        //
        // DIVIDE Y CONQUISTA:
        // Esta estrategia se usa en muchos algoritmos:
        // - MergeSort: Ordenamiento
        // - QuickSort: Ordenamiento
        // - Binary Search: Búsqueda
        // - Karatsuba: Multiplicación rápida
        // - Strassen: Multiplicación de matrices
        //
        // ANÁLISIS O(n log n):
        // ¿Por qué O(n log n)?
        // - Dividimos el array log₂(n) veces (cada vez a la mitad)
        // - En cada nivel hacemos n comparaciones (merge)
        // - Total: n × log₂(n)
        //
        // Ejemplo con n = 8 elementos:
        // Nivel 0: [8 elementos] → 8 comparaciones
        // Nivel 1: [4] [4]       → 8 comparaciones
        // Nivel 2: [2] [2] [2] [2] → 8 comparaciones
        // Nivel 3: [1] [1] [1] [1] [1] [1] [1] [1] → 0 comparaciones
        // Total niveles: log₂(8) = 3
        // Total comparaciones: 8 × 3 = 24 ≈ n log n
        //
        // COMPARACIÓN DE ALGORITMOS:
        // Bubble Sort:     O(n²)     - Simple pero lento
        // Selection Sort:  O(n²)     - Simple pero lento
        // Insertion Sort:  O(n²)     - Rápido para arrays casi ordenados
        // MergeSort:       O(n log n) - Eficiente, estable, necesita espacio
        // QuickSort:       O(n log n) - Muy rápido en promedio, in-place
        // HeapSort:        O(n log n) - Eficiente, in-place, no estable
        //
        // STABLE SORT:
        // MergeSort es "stable": mantiene el orden relativo de elementos iguales
        // Ejemplo:
        // Input:  [(5,A), (3,B), (5,C), (2,D)]
        // Output: [(2,D), (3,B), (5,A), (5,C)]
        //         ↑ (5,A) sigue antes que (5,C)
        //
        // MERGESORT VS QUICKSORT:
        // MergeSort:
        // - Siempre O(n log n) - predecible
        // - Stable
        // - Necesita O(n) espacio extra
        // - Mejor para listas enlazadas
        //
        // QuickSort:
        // - Promedio O(n log n), peor caso O(n²)
        // - No stable
        // - In-place O(log n) espacio (recursión)
        // - Más rápido en la práctica para arrays
        //
        // OPTIMIZACIONES POSIBLES:
        // - Usar Insertion Sort para subarrays pequeños (< 10)
        // - Bottom-up MergeSort (iterativo, no recursivo)
        // - Natural MergeSort (aprovecha runs ordenados)
        // - Timsort (Python): Combina MergeSort + InsertionSort
    }
}
