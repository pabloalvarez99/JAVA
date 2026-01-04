/*
 * ========================================
 * EJERCICIO 31: QuickSort - Algoritmo de Ordenamiento Eficiente
 * DIFICULTAD: ⭐⭐⭐⭐⭐⭐⭐⭐⭐⭐ (Experto)
 * ========================================
 *
 * OBJETIVO:
 * Implementar y entender QuickSort, uno de los algoritmos de ordenamiento
 * más eficientes y utilizados en la industria
 *
 * CONCEPTO CLAVE:
 * QuickSort es un algoritmo de ordenamiento basado en "Divide y Conquista"
 * que selecciona un elemento "pivote" y particiona el array en dos subarrays:
 * - Elementos MENORES que el pivote (izquierda)
 * - Elementos MAYORES que el pivote (derecha)
 * Luego ordena recursivamente cada subarray.
 *
 * ========================================
 * CÓMO FUNCIONA QUICKSORT
 * ========================================
 *
 * PASOS:
 * 1. ELEGIR un pivote (usualmente el último elemento)
 * 2. PARTICIONAR el array:
 *    - Elementos < pivote van a la izquierda
 *    - Elementos > pivote van a la derecha
 * 3. COLOCAR el pivote en su posición final
 * 4. APLICAR recursivamente QuickSort a las dos mitades
 *
 * EJEMPLO VISUAL:
 * Array inicial: [8, 3, 1, 7, 0, 10, 2]
 * Pivote: 2 (último elemento)
 *
 * Paso 1 - Particionar:
 * [1, 0] | 2 | [3, 8, 7, 10]
 *  menor     mayor
 *
 * Paso 2 - Recursión izquierda [1, 0]:
 * Pivote: 0
 * [] | 0 | [1]
 *
 * Paso 3 - Recursión derecha [3, 8, 7, 10]:
 * Pivote: 10
 * [3, 8, 7] | 10 | []
 *
 * ...continúa hasta que todo está ordenado
 *
 * Resultado: [0, 1, 2, 3, 7, 8, 10]
 *
 * ========================================
 * ALGORITMO DE PARTICIÓN (HOARE/LOMUTO)
 * ========================================
 *
 * PARTICIÓN LOMUTO (más simple):
 * - Pivote: último elemento
 * - Mantiene índice de "frontera" entre menor y mayor
 *
 * int partition(int[] arr, int low, int high) {
 *     int pivot = arr[high];
 *     int i = low - 1; // Índice de elementos menores
 *
 *     for (int j = low; j < high; j++) {
 *         if (arr[j] < pivot) {
 *             i++;
 *             swap(arr, i, j);
 *         }
 *     }
 *     swap(arr, i + 1, high); // Colocar pivote en posición final
 *     return i + 1;
 * }
 *
 * ========================================
 * COMPLEJIDAD
 * ========================================
 *
 * TIEMPO:
 * - Mejor caso: O(n log n) - pivote divide siempre a la mitad
 * - Caso promedio: O(n log n) - en la mayoría de casos
 * - Peor caso: O(n²) - array ya ordenado con pivote mal elegido
 *
 * ESPACIO:
 * - O(log n) - por la recursión (stack frames)
 *
 * COMPARACIÓN:
 * | Algoritmo    | Mejor       | Promedio    | Peor    | Espacio |
 * |--------------|-------------|-------------|---------|---------|
 * | BubbleSort   | O(n)        | O(n²)       | O(n²)   | O(1)    |
 * | SelectionSort| O(n²)       | O(n²)       | O(n²)   | O(1)    |
 * | MergeSort    | O(n log n)  | O(n log n)  | O(n log n) | O(n) |
 * | QuickSort    | O(n log n)  | O(n log n)  | O(n²)   | O(log n)|
 *
 * ========================================
 * VENTAJAS Y DESVENTAJAS
 * ========================================
 *
 * VENTAJAS:
 * ✓ MUY RÁPIDO en la práctica (caso promedio)
 * ✓ Ordenamiento in-place (no requiere array adicional)
 * ✓ Eficiente en memoria O(log n)
 * ✓ Cache-friendly (buena localidad de datos)
 * ✓ Usado en la librería estándar de Java (Arrays.sort para primitivos)
 *
 * DESVENTAJAS:
 * ✗ Peor caso O(n²) si el pivote es malo
 * ✗ NO es estable (puede cambiar orden de elementos iguales)
 * ✗ Recursivo (puede causar stack overflow con arrays muy grandes)
 * ✗ Rendimiento depende de la elección del pivote
 *
 * ========================================
 * OPTIMIZACIONES
 * ========================================
 *
 * 1. PIVOTE ALEATORIO: Evita el peor caso
 * 2. MEDIANA DE TRES: Pivote = mediana(primero, medio, último)
 * 3. INSERTION SORT: Para subarrays pequeños (<10 elementos)
 * 4. TAIL RECURSION: Eliminar una llamada recursiva
 * 5. DUAL-PIVOT: Java usa dual-pivot QuickSort (más rápido)
 *
 * INSTRUCCIONES:
 * 1. Implementa QuickSort con el algoritmo de partición Lomuto
 * 2. Implementa método swap para intercambiar elementos
 * 3. Implementa visualización paso a paso del ordenamiento
 * 4. Compara rendimiento con otros algoritmos
 * 5. Demuestra con diferentes casos (aleatorio, ordenado, inverso)
 *
 * SALIDA ESPERADA:
 * === QUICKSORT - ALGORITMO DE ORDENAMIENTO EFICIENTE ===
 *
 * === CASO 1: Array Aleatorio ===
 * Array original: [8, 3, 1, 7, 0, 10, 2]
 *
 * Iniciando QuickSort...
 * [8, 3, 1, 7, 0, 10, 2] | Pivote: 2
 * [1, 0, 2, 7, 3, 10, 8] | Pivote colocado en índice 2
 * [0, 1, 2, 7, 3, 10, 8] | Ordenando izquierda [0, 1]
 * [0, 1, 2, 3, 7, 10, 8] | Ordenando derecha [7, 3, 10, 8]
 * [0, 1, 2, 3, 7, 8, 10] | Array ordenado!
 *
 * Array ordenado: [0, 1, 2, 3, 7, 8, 10]
 *
 * === CASO 2: Array Ya Ordenado ===
 * Array original: [1, 2, 3, 4, 5]
 * Array ordenado: [1, 2, 3, 4, 5]
 *
 * === CASO 3: Array Inversamente Ordenado ===
 * Array original: [9, 7, 5, 3, 1]
 * Array ordenado: [1, 3, 5, 7, 9]
 *
 * === CASO 4: Array con Duplicados ===
 * Array original: [5, 2, 8, 2, 9, 1, 5, 5]
 * Array ordenado: [1, 2, 2, 5, 5, 5, 8, 9]
 *
 * === COMPARACIÓN DE RENDIMIENTO ===
 * Tamaño del array: 1000 elementos
 *
 * BubbleSort: 12.5 ms
 * SelectionSort: 8.3 ms
 * MergeSort: 2.1 ms
 * QuickSort: 1.8 ms ← MÁS RÁPIDO
 *
 * CONCEPTOS NUEVOS:
 * - QuickSort: Algoritmo divide y conquista
 * - Pivote: Elemento de referencia para particionar
 * - Partición: Dividir array en menores y mayores
 * - In-place: Ordenamiento sin array adicional
 * - Lomuto partition: Esquema de partición simple
 * - Dual-pivot: Optimización con dos pivotes
 * - Cache-friendly: Eficiente con memoria caché
 *
 * VENTAJAS DE QUICKSORT:
 * ✓ Uno de los más rápidos en la práctica
 * ✓ Usado en implementaciones estándar (Arrays.sort)
 * ✓ Eficiente en memoria
 * ✓ Buen rendimiento con datos aleatorios
 *
 * CUÁNDO USAR QUICKSORT:
 * ✓ Arrays grandes con datos aleatorios
 * ✓ Cuando la memoria es limitada
 * ✓ Cuando el rendimiento promedio es importante
 * ✗ Cuando necesitas estabilidad (usa MergeSort)
 * ✗ Cuando el peor caso debe ser O(n log n) (usa HeapSort)
 *
 */

import java.util.Arrays;
import java.util.Random;

public class Ejercicio31 {

    // Variable para contar pasos (visualización)
    private static int pasoActual = 0;

    // ========================================
    // QUICKSORT - ALGORITMO PRINCIPAL
    // ========================================

    // TODO: Implementa QuickSort
    public static void quickSort(int[] arr, int low, int high) {
        // Caso base: si low >= high, ya está ordenado
        if (low < high) {
            // Particionar y obtener índice del pivote
            int pivotIndex = partition(arr, low, high);

            // Ordenar recursivamente la parte izquierda
            quickSort(arr, low, pivotIndex - 1);

            // Ordenar recursivamente la parte derecha
            quickSort(arr, pivotIndex + 1, high);
        }
    }

    // TODO: Implementa el algoritmo de partición (Lomuto)
    private static int partition(int[] arr, int low, int high) {
        // Elegir el último elemento como pivote
        int pivot = arr[high];

        // Índice de elementos menores
        int i = low - 1;

        // Recorrer el array
        for (int j = low; j < high; j++) {
            // Si el elemento actual es menor que el pivote
            if (arr[j] < pivot) {
                i++;
                swap(arr, i, j);
            }
        }

        // Colocar el pivote en su posición final
        swap(arr, i + 1, high);

        // Retornar el índice del pivote
        return i + 1;
    }

    // TODO: Implementa swap para intercambiar elementos
    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    // ========================================
    // QUICKSORT CON VISUALIZACIÓN
    // ========================================

    public static void quickSortVisualizado(int[] arr, int low, int high, boolean mostrar) {
        if (low < high) {
            if (mostrar) {
                System.out.printf("Ordenando rango [%d, %d]: ", low, high);
                imprimirArray(arr);
            }

            int pivotIndex = partition(arr, low, high);

            if (mostrar) {
                System.out.printf("Pivote %d colocado en índice %d: ", arr[pivotIndex], pivotIndex);
                imprimirArray(arr);
            }

            quickSortVisualizado(arr, low, pivotIndex - 1, mostrar);
            quickSortVisualizado(arr, pivotIndex + 1, high, mostrar);
        }
    }

    // ========================================
    // MÉTODOS AUXILIARES
    // ========================================

    private static void imprimirArray(int[] arr) {
        System.out.println(Arrays.toString(arr));
    }

    private static int[] copiarArray(int[] arr) {
        return Arrays.copyOf(arr, arr.length);
    }

    // ========================================
    // OTROS ALGORITMOS PARA COMPARACIÓN
    // ========================================

    // BubbleSort (para comparación)
    private static void bubbleSort(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    swap(arr, j, j + 1);
                }
            }
        }
    }

    // SelectionSort (para comparación)
    private static void selectionSort(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            int minIdx = i;
            for (int j = i + 1; j < n; j++) {
                if (arr[j] < arr[minIdx]) {
                    minIdx = j;
                }
            }
            swap(arr, i, minIdx);
        }
    }

    // MergeSort (para comparación)
    private static void mergeSort(int[] arr, int left, int right) {
        if (left < right) {
            int mid = left + (right - left) / 2;
            mergeSort(arr, left, mid);
            mergeSort(arr, mid + 1, right);
            merge(arr, left, mid, right);
        }
    }

    private static void merge(int[] arr, int left, int mid, int right) {
        int n1 = mid - left + 1;
        int n2 = right - mid;

        int[] L = new int[n1];
        int[] R = new int[n2];

        System.arraycopy(arr, left, L, 0, n1);
        System.arraycopy(arr, mid + 1, R, 0, n2);

        int i = 0, j = 0, k = left;
        while (i < n1 && j < n2) {
            if (L[i] <= R[j]) {
                arr[k++] = L[i++];
            } else {
                arr[k++] = R[j++];
            }
        }

        while (i < n1) arr[k++] = L[i++];
        while (j < n2) arr[k++] = R[j++];
    }

    // ========================================
    // MÉTODO PRINCIPAL
    // ========================================

    public static void main(String[] args) {
        System.out.println("=== QUICKSORT - ALGORITMO DE ORDENAMIENTO EFICIENTE ===\n");

        // ========================================
        // CASO 1: Array Aleatorio
        // ========================================
        System.out.println("=== CASO 1: Array Aleatorio ===");
        int[] arr1 = {8, 3, 1, 7, 0, 10, 2};
        System.out.print("Array original: ");
        imprimirArray(arr1);
        System.out.println("\nProceso de ordenamiento:");
        quickSortVisualizado(arr1, 0, arr1.length - 1, true);
        System.out.print("\nArray ordenado: ");
        imprimirArray(arr1);

        // ========================================
        // CASO 2: Array Ya Ordenado
        // ========================================
        System.out.println("\n=== CASO 2: Array Ya Ordenado ===");
        int[] arr2 = {1, 2, 3, 4, 5};
        System.out.print("Array original: ");
        imprimirArray(arr2);
        quickSort(arr2, 0, arr2.length - 1);
        System.out.print("Array ordenado: ");
        imprimirArray(arr2);

        // ========================================
        // CASO 3: Array Inversamente Ordenado
        // ========================================
        System.out.println("\n=== CASO 3: Array Inversamente Ordenado ===");
        int[] arr3 = {9, 7, 5, 3, 1};
        System.out.print("Array original: ");
        imprimirArray(arr3);
        quickSort(arr3, 0, arr3.length - 1);
        System.out.print("Array ordenado: ");
        imprimirArray(arr3);

        // ========================================
        // CASO 4: Array con Duplicados
        // ========================================
        System.out.println("\n=== CASO 4: Array con Duplicados ===");
        int[] arr4 = {5, 2, 8, 2, 9, 1, 5, 5};
        System.out.print("Array original: ");
        imprimirArray(arr4);
        quickSort(arr4, 0, arr4.length - 1);
        System.out.print("Array ordenado: ");
        imprimirArray(arr4);

        // ========================================
        // COMPARACIÓN DE RENDIMIENTO
        // ========================================
        System.out.println("\n=== COMPARACIÓN DE RENDIMIENTO ===");
        int tamano = 10000;
        System.out.println("Tamaño del array: " + tamano + " elementos\n");

        // Generar array aleatorio
        Random random = new Random();
        int[] arrOriginal = new int[tamano];
        for (int i = 0; i < tamano; i++) {
            arrOriginal[i] = random.nextInt(1000);
        }

        // BubbleSort
        int[] arrBubble = copiarArray(arrOriginal);
        long inicioBubble = System.nanoTime();
        bubbleSort(arrBubble);
        long finBubble = System.nanoTime();
        double tiempoBubble = (finBubble - inicioBubble) / 1_000_000.0;
        System.out.printf("BubbleSort: %.2f ms\n", tiempoBubble);

        // SelectionSort
        int[] arrSelection = copiarArray(arrOriginal);
        long inicioSelection = System.nanoTime();
        selectionSort(arrSelection);
        long finSelection = System.nanoTime();
        double tiempoSelection = (finSelection - inicioSelection) / 1_000_000.0;
        System.out.printf("SelectionSort: %.2f ms\n", tiempoSelection);

        // MergeSort
        int[] arrMerge = copiarArray(arrOriginal);
        long inicioMerge = System.nanoTime();
        mergeSort(arrMerge, 0, arrMerge.length - 1);
        long finMerge = System.nanoTime();
        double tiempoMerge = (finMerge - inicioMerge) / 1_000_000.0;
        System.out.printf("MergeSort: %.2f ms\n", tiempoMerge);

        // QuickSort
        int[] arrQuick = copiarArray(arrOriginal);
        long inicioQuick = System.nanoTime();
        quickSort(arrQuick, 0, arrQuick.length - 1);
        long finQuick = System.nanoTime();
        double tiempoQuick = (finQuick - inicioQuick) / 1_000_000.0;
        System.out.printf("QuickSort: %.2f ms ← MÁS RÁPIDO\n", tiempoQuick);

        // Determinar el más rápido
        double tiempoMinimo = Math.min(Math.min(tiempoBubble, tiempoSelection),
                                        Math.min(tiempoMerge, tiempoQuick));

        System.out.println("\n=== ANÁLISIS DE RENDIMIENTO ===");
        System.out.printf("QuickSort es %.2fx más rápido que BubbleSort\n",
                          tiempoBubble / tiempoQuick);
        System.out.printf("QuickSort es %.2fx más rápido que SelectionSort\n",
                          tiempoSelection / tiempoQuick);
        System.out.printf("QuickSort vs MergeSort: %.2fx\n",
                          tiempoMerge / tiempoQuick);

        // REFLEXIÓN FINAL:
        // ¿Por qué QuickSort es tan popular?
        // ✓ Excelente rendimiento promedio O(n log n)
        // ✓ Ordenamiento in-place (ahorra memoria)
        // ✓ Cache-friendly (accesos locales a memoria)
        // ✓ Fácil de implementar
        // ✓ Usado en la librería estándar de Java
        //
        // EN LA VIDA REAL:
        // - Arrays.sort() en Java usa Dual-Pivot QuickSort
        // - Bases de datos: ordenar resultados de consultas
        // - Compiladores: optimización de código
        // - Sistemas operativos: scheduling de procesos
        // - Algoritmos de búsqueda: requieren datos ordenados
        //
        // VARIACIONES DE QUICKSORT:
        //
        // 1. RANDOMIZED QUICKSORT:
        //    Elige pivote aleatorio para evitar peor caso
        //
        // 2. DUAL-PIVOT QUICKSORT (Java usa esto):
        //    Usa DOS pivotes en lugar de uno
        //    Más rápido en arrays grandes
        //
        // 3. THREE-WAY QUICKSORT:
        //    Maneja duplicados eficientemente
        //    Útil cuando hay muchos elementos iguales
        //
        // 4. INTROSORT:
        //    Híbrido QuickSort + HeapSort
        //    Garantiza O(n log n) en el peor caso
        //
        // ELECCIÓN DEL PIVOTE:
        //
        // ÚLTIMO ELEMENTO (lo que usamos):
        // ✓ Simple de implementar
        // ✗ Peor caso con arrays ordenados
        //
        // ALEATORIO:
        // ✓ Evita peor caso
        // ✓ Buen rendimiento promedio
        //
        // MEDIANA DE TRES:
        // ✓ Mejor elección que aleatorio
        // ✓ Evita peor caso en arrays parcialmente ordenados
        //
        // QUICKSORT vs MERGESORT:
        //
        // QuickSort:
        // ✓ Más rápido en promedio
        // ✓ In-place (O(log n) espacio)
        // ✗ No estable
        // ✗ Peor caso O(n²)
        //
        // MergeSort:
        // ✓ Siempre O(n log n)
        // ✓ Estable
        // ✗ Requiere O(n) espacio extra
        // ✗ Más lento en promedio
        //
        // CUÁNDO USAR QUICKSORT:
        // ✓ Arrays grandes con datos aleatorios
        // ✓ Memoria limitada
        // ✓ No necesitas estabilidad
        // ✓ Rendimiento promedio es importante
        //
        // CUÁNDO NO USAR QUICKSORT:
        // ✗ Necesitas garantía O(n log n) en peor caso
        // ✗ Necesitas ordenamiento estable
        // ✗ Arrays casi ordenados (sin pivote aleatorio)
        // ✗ Datos críticos donde el peor caso es inaceptable
        //
        // OPTIMIZACIONES ADICIONALES:
        // 1. Usar InsertionSort para subarrays pequeños (<10 elementos)
        // 2. Eliminar recursión de cola (tail recursion)
        // 3. Usar stack iterativo en lugar de recursión
        // 4. Implementar three-way partitioning para duplicados
        //
        // COMPLEJIDAD ESPACIAL:
        // - Mejor caso: O(log n) - árbol balanceado de recursión
        // - Peor caso: O(n) - árbol degenerado (array ordenado)
        //
        // EN JAVA:
        // Arrays.sort(primitivos) → Dual-Pivot QuickSort
        // Arrays.sort(objetos) → TimSort (híbrido MergeSort)
        // Collections.sort() → TimSort
        //
        // ¿Por qué Java usa diferentes algoritmos?
        // - Primitivos: QuickSort es más rápido (in-place)
        // - Objetos: TimSort es estable (preserva orden de iguales)
    }
}
