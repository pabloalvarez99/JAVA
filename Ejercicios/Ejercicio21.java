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

// TODO: Crea la clase AlgoritmosOrdenamiento
class AlgoritmosOrdenamiento {

    // Método auxiliar: imprimirArray
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

    // Método auxiliar: intercambiar dos elementos
    public static void intercambiar(int[] array, int i, int j) {
        // TODO: Intercambia los elementos en posiciones i y j
        // int temp = array[i];
        // array[i] = array[j];
        // array[j] = temp;




    }

    // Método auxiliar: copiar array
    public static int[] copiarArray(int[] original) {
        // TODO: Crea y retorna una copia del array
        // return original.clone();
        return null; // TEMPORAL

    }

    // BUBBLE SORT
    public static int bubbleSort(int[] array) {
        System.out.println("\n=== BUBBLE SORT ===");
        int n = array.length;
        int totalIntercambios = 0;

        // TODO: Implementa Bubble Sort
        // Pista: necesitas dos loops anidados
        //
        // for (int i = 0; i < n - 1; i++) {              // Pasadas
        //     boolean huboIntercambio = false;
        //
        //     for (int j = 0; j < n - i - 1; j++) {      // Comparaciones en esta pasada
        //         // Si el elemento actual es mayor que el siguiente
        //         if (array[j] > array[j + 1]) {
        //             // Intercámbialos
        //             intercambiar(array, j, j + 1);
        //             totalIntercambios++;
        //             huboIntercambio = true;
        //         }
        //     }
        //
        //     // Muestra el estado después de cada pasada
        //     System.out.print("Pasada " + (i + 1) + ": ");
        //     imprimirArray(array);
        //
        //     // OPTIMIZACIÓN: Si no hubo intercambios, ya está ordenado
        //     if (!huboIntercambio) {
        //         break;
        //     }
        // }

























        System.out.print("Array ordenado: ");
        imprimirArray(array);
        System.out.println("Total de intercambios: " + totalIntercambios);
        return totalIntercambios;
    }

    // SELECTION SORT
    public static int selectionSort(int[] array) {
        System.out.println("\n=== SELECTION SORT ===");
        int n = array.length;
        int totalIntercambios = 0;

        // TODO: Implementa Selection Sort
        // Pista: para cada posición, busca el mínimo en el resto del array
        //
        // for (int i = 0; i < n - 1; i++) {              // Para cada posición
        //     int indiceMinimo = i;
        //
        //     // Busca el elemento más pequeño desde i+1 hasta el final
        //     for (int j = i + 1; j < n; j++) {
        //         if (array[j] < array[indiceMinimo]) {
        //             indiceMinimo = j;
        //         }
        //     }
        //
        //     // Si encontraste un mínimo diferente, intercambia
        //     if (indiceMinimo != i) {
        //         System.out.print("Paso " + (i + 1) + " - Mínimo encontrado: " + array[indiceMinimo] + " -> ");
        //         intercambiar(array, i, indiceMinimo);
        //         imprimirArray(array);
        //         totalIntercambios++;
        //     }
        // }






















        System.out.print("Array ordenado: ");
        imprimirArray(array);
        System.out.println("Total de intercambios: " + totalIntercambios);
        return totalIntercambios;
    }
}

public class Ejercicio21 {
    public static void main(String[] args) {
        System.out.println("=== ALGORITMOS DE ORDENAMIENTO ===");

        // TODO: Crea el array original desordenado
        int[] arrayOriginal = {64, 34, 25, 12, 22, 11, 90};

        System.out.print("\nArray original: ");
        AlgoritmosOrdenamiento.imprimirArray(arrayOriginal);

        // TODO: Prueba Bubble Sort
        // int[] arrayBubble = AlgoritmosOrdenamiento.copiarArray(arrayOriginal);
        // int intercambiosBubble = AlgoritmosOrdenamiento.bubbleSort(arrayBubble);



        // TODO: Prueba Selection Sort
        // int[] arraySelection = AlgoritmosOrdenamiento.copiarArray(arrayOriginal);
        // int intercambiosSelection = AlgoritmosOrdenamiento.selectionSort(arraySelection);



        // Comparación
        System.out.println("\n=== COMPARACIÓN ===");
        // System.out.println("Bubble Sort - Intercambios: " + intercambiosBubble);
        // System.out.println("Selection Sort - Intercambios: " + intercambiosSelection);


        // === PRUEBA ADICIONAL: Array ya ordenado ===
        System.out.println("\n\n=== PRUEBA: ARRAY YA ORDENADO ===");
        int[] arrayOrdenado = {11, 12, 22, 25, 34, 64, 90};
        System.out.print("Array original: ");
        AlgoritmosOrdenamiento.imprimirArray(arrayOrdenado);

        // TODO: Prueba ambos algoritmos con array ordenado
        // int[] arrayOrdenadoBubble = AlgoritmosOrdenamiento.copiarArray(arrayOrdenado);
        // AlgoritmosOrdenamiento.bubbleSort(arrayOrdenadoBubble);

        // int[] arrayOrdenadoSelection = AlgoritmosOrdenamiento.copiarArray(arrayOrdenado);
        // AlgoritmosOrdenamiento.selectionSort(arrayOrdenadoSelection);






        // === PRUEBA ADICIONAL: Array en orden inverso ===
        System.out.println("\n\n=== PRUEBA: ARRAY EN ORDEN INVERSO ===");
        int[] arrayInverso = {90, 64, 34, 25, 22, 12, 11};
        System.out.print("Array original: ");
        AlgoritmosOrdenamiento.imprimirArray(arrayInverso);

        // TODO: Prueba ambos algoritmos con array inverso
        // int[] arrayInversoBubble = AlgoritmosOrdenamiento.copiarArray(arrayInverso);
        // AlgoritmosOrdenamiento.bubbleSort(arrayInversoBubble);

        // int[] arrayInversoSelection = AlgoritmosOrdenamiento.copiarArray(arrayInverso);
        // AlgoritmosOrdenamiento.selectionSort(arrayInversoSelection);






        // REFLEXIÓN:
        // ¿Cuándo usar cada algoritmo?
        // - Bubble Sort: Útil para arrays casi ordenados (con optimización)
        // - Selection Sort: Útil cuando los intercambios son costosos
        // - En la práctica: Usa Arrays.sort() que implementa algoritmos más eficientes
        //
        // OTROS ALGORITMOS DE ORDENAMIENTO:
        // - QuickSort: O(n log n) - muy rápido en la práctica
        // - MergeSort: O(n log n) - estable, bueno para listas enlazadas
        // - HeapSort: O(n log n) - no usa memoria extra
        // - InsertionSort: O(n²) - muy rápido para arrays pequeños o casi ordenados
        //
        // COMPLEJIDAD TEMPORAL:
        // - Bubble Sort: O(n²) peor caso, O(n) mejor caso (con optimización)
        // - Selection Sort: O(n²) siempre
        // - QuickSort: O(n log n) promedio, O(n²) peor caso
        // - MergeSort: O(n log n) siempre
        //
        // USO PRÁCTICO:
        // Arrays.sort(array);  // Usa DualPivotQuicksort (muy eficiente)
        // Collections.sort(lista);  // Usa TimSort (híbrido de MergeSort e InsertionSort)
    }
}
