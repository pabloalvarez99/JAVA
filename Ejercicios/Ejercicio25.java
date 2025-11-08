/*
 * ========================================
 * EJERCICIO 25: Búsqueda Binaria (Binary Search)
 * DIFICULTAD: ⭐⭐⭐⭐⭐⭐⭐⭐ (Extremadamente Difícil)
 * ========================================
 *
 * OBJETIVO:
 * Implementar el algoritmo de Búsqueda Binaria (Binary Search) y entender
 * cómo funciona un algoritmo de búsqueda eficiente O(log n)
 *
 * CONCEPTO CLAVE:
 * La Búsqueda Binaria es un algoritmo EFICIENTE para encontrar un elemento
 * en un array ORDENADO. Divide el espacio de búsqueda a la mitad en cada paso.
 *
 * ANALOGÍA:
 * Es como buscar una palabra en un diccionario:
 * 1. Abres el diccionario por la mitad
 * 2. Si la palabra está antes, buscas en la mitad izquierda
 * 3. Si está después, buscas en la mitad derecha
 * 4. Repites hasta encontrarla
 *
 * REQUISITO FUNDAMENTAL:
 * ⚠️ EL ARRAY DEBE ESTAR ORDENADO ⚠️
 * La búsqueda binaria NO funciona en arrays desordenados
 *
 * COMPARACIÓN CON BÚSQUEDA LINEAL:
 *
 * Búsqueda Lineal (uno por uno):
 * Array: [1, 3, 5, 7, 9, 11, 13, 15, 17, 19]
 * Buscar 15: Revisa 1, 3, 5, 7, 9, 11, 13, 15 ✓ (8 comparaciones)
 * Complejidad: O(n) - lineal
 *
 * Búsqueda Binaria (divide y conquista):
 * Array: [1, 3, 5, 7, 9, 11, 13, 15, 17, 19]
 * Buscar 15:
 *   1. Mitad = 9 (posición 4), 15 > 9 → busca derecha
 *   2. Mitad = 13 (posición 6), 15 > 13 → busca derecha
 *   3. Mitad = 15 (posición 7) ✓ (3 comparaciones)
 * Complejidad: O(log n) - logarítmica
 *
 * VENTAJA:
 * En un array de 1,000,000 elementos:
 * - Búsqueda lineal: hasta 1,000,000 comparaciones
 * - Búsqueda binaria: máximo 20 comparaciones ⚡
 *
 * ALGORITMO:
 * 1. Define inicio = 0, fin = array.length - 1
 * 2. Mientras inicio <= fin:
 *    a) Calcula mitad = (inicio + fin) / 2
 *    b) Si array[mitad] == objetivo → encontrado
 *    c) Si array[mitad] < objetivo → busca derecha (inicio = mitad + 1)
 *    d) Si array[mitad] > objetivo → busca izquierda (fin = mitad - 1)
 * 3. Si no se encuentra, retorna -1
 *
 * INSTRUCCIONES:
 * 1. Implementa busquedaBinaria(int[] array, int objetivo)
 *    - Versión ITERATIVA (con while loop)
 *    - Retorna el índice si encuentra, -1 si no
 *
 * 2. Implementa busquedaBinariaRecursiva(int[] array, int objetivo, int inicio, int fin)
 *    - Versión RECURSIVA
 *    - Retorna el índice si encuentra, -1 si no
 *
 * 3. Implementa buscarPrimerOcurrencia(int[] array, int objetivo)
 *    - Encuentra la PRIMERA ocurrencia en array con duplicados
 *    - Ejemplo: [1, 2, 2, 2, 3, 4] buscar 2 → índice 1 (no 2 o 3)
 *
 * 4. Implementa contarComparaciones(int[] array, int objetivo)
 *    - Cuenta cuántas comparaciones hace la búsqueda binaria
 *    - Compara con búsqueda lineal
 *
 * SALIDA ESPERADA:
 * === BÚSQUEDA BINARIA (BINARY SEARCH) ===
 *
 * Array ordenado: [1, 3, 5, 7, 9, 11, 13, 15, 17, 19]
 *
 * === BÚSQUEDA ITERATIVA ===
 * Buscar 15: encontrado en índice 7
 * Buscar 1: encontrado en índice 0
 * Buscar 19: encontrado en índice 9
 * Buscar 10: NO encontrado (retorna -1)
 *
 * === BÚSQUEDA RECURSIVA ===
 * Buscar 15: encontrado en índice 7
 * Buscar 7: encontrado en índice 3
 * Buscar 20: NO encontrado (retorna -1)
 *
 * === BÚSQUEDA CON DUPLICADOS ===
 * Array con duplicados: [1, 2, 2, 2, 3, 4, 4, 5]
 * Primera ocurrencia de 2: índice 1
 * Primera ocurrencia de 4: índice 5
 *
 * === COMPARACIÓN DE EFICIENCIA ===
 * Array grande (100 elementos): [1, 2, 3, ..., 100]
 * Buscar 87:
 * - Búsqueda Lineal: 87 comparaciones
 * - Búsqueda Binaria: 7 comparaciones
 * ⚡ Búsqueda Binaria es 12.4x más rápida
 *
 * CONCEPTOS NUEVOS:
 * - Binary Search: Búsqueda binaria
 * - O(log n): Complejidad logarítmica
 * - Divide y conquista: Estrategia de dividir el problema
 * - Array ordenado: Requisito para búsqueda binaria
 * - Iterativo vs Recursivo: Dos implementaciones del mismo algoritmo
 * - Peor caso vs caso promedio: Análisis de complejidad
 *
 * COMPLEJIDAD TEMPORAL:
 * - Búsqueda Binaria: O(log n) - logarítmica
 * - Búsqueda Lineal: O(n) - lineal
 *
 * EJEMPLO O(log n):
 * n = 10 → máximo 4 comparaciones
 * n = 100 → máximo 7 comparaciones
 * n = 1,000 → máximo 10 comparaciones
 * n = 1,000,000 → máximo 20 comparaciones
 *
 * VENTAJAS:
 * ✓ Muy rápido para arrays grandes
 * ✓ Predecible (siempre O(log n))
 * ✓ Mejor que búsqueda lineal O(n)
 *
 * DESVENTAJAS:
 * ✗ Requiere array ordenado
 * ✗ No funciona con listas enlazadas eficientemente
 *
 * PISTAS:
 * - Siempre calcula el punto medio: medio = (inicio + fin) / 2
 * - Cuidado con overflow: mejor usar medio = inicio + (fin - inicio) / 2
 * - Actualiza inicio o fin según la comparación
 * - Versión recursiva: llama a sí misma con inicio/fin actualizado
 */

public class Ejercicio25 {

    // TODO: Implementa búsqueda binaria ITERATIVA
    public static int busquedaBinaria(int[] array, int objetivo) {
        int inicio = 0;
        int fin = array.length - 1;

        while (inicio <= fin) {
            // Calcula el punto medio
            // Usa esta fórmula para evitar overflow en arrays grandes
            int medio = inicio + (fin - inicio) / 2;

            // TODO: Si encontramos el objetivo, retorna el índice
            if (array[medio] == objetivo) {
                return medio;
            }

            // TODO: Si el objetivo es mayor, busca en la mitad derecha
            if (array[medio] < objetivo) {
                inicio = medio + 1;
            }
            // TODO: Si el objetivo es menor, busca en la mitad izquierda
            else {
                fin = medio - 1;
            }
        }

        // No se encontró
        return -1;
    }

    // TODO: Implementa búsqueda binaria RECURSIVA
    public static int busquedaBinariaRecursiva(int[] array, int objetivo, int inicio, int fin) {
        // Caso base: no se encontró
        if (inicio > fin) {
            return -1;
        }

        // Calcula el punto medio
        int medio = inicio + (fin - inicio) / 2;

        // TODO: Si encontramos el objetivo, retorna el índice
        if (array[medio] == objetivo) {
            return medio;
        }

        // TODO: Si el objetivo es mayor, busca recursivamente en la mitad derecha
        if (array[medio] < objetivo) {
            return busquedaBinariaRecursiva(array, objetivo, medio + 1, fin);
        }

        // TODO: Si el objetivo es menor, busca recursivamente en la mitad izquierda
        return busquedaBinariaRecursiva(array, objetivo, inicio, medio - 1);
    }

    // TODO: Implementa buscar PRIMERA ocurrencia (con duplicados)
    public static int buscarPrimerOcurrencia(int[] array, int objetivo) {
        int inicio = 0;
        int fin = array.length - 1;
        int resultado = -1;  // Guarda la posición encontrada

        while (inicio <= fin) {
            int medio = inicio + (fin - inicio) / 2;

            if (array[medio] == objetivo) {
                // Encontramos el objetivo, pero podría haber uno antes
                resultado = medio;
                // TODO: Continúa buscando hacia la IZQUIERDA
                fin = medio - 1;
            }
            else if (array[medio] < objetivo) {
                inicio = medio + 1;
            }
            else {
                fin = medio - 1;
            }
        }

        return resultado;
    }

    // TODO: Implementa búsqueda lineal (para comparar)
    public static int busquedaLineal(int[] array, int objetivo) {
        // TODO: Busca elemento por elemento
        for (int i = 0; i < array.length; i++) {
            if (array[i] == objetivo) {
                return i;
            }
        }
        return -1;
    }

    // TODO: Cuenta comparaciones en búsqueda binaria
    public static int contarComparacionesBinaria(int[] array, int objetivo) {
        int inicio = 0;
        int fin = array.length - 1;
        int comparaciones = 0;

        while (inicio <= fin) {
            int medio = inicio + (fin - inicio) / 2;
            comparaciones++;

            if (array[medio] == objetivo) {
                return comparaciones;
            }

            if (array[medio] < objetivo) {
                inicio = medio + 1;
            } else {
                fin = medio - 1;
            }
        }

        return comparaciones;
    }

    // TODO: Cuenta comparaciones en búsqueda lineal
    public static int contarComparacionesLineal(int[] array, int objetivo) {
        int comparaciones = 0;

        for (int i = 0; i < array.length; i++) {
            comparaciones++;
            if (array[i] == objetivo) {
                return comparaciones;
            }
        }

        return comparaciones;
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

    public static void main(String[] args) {
        System.out.println("=== BÚSQUEDA BINARIA (BINARY SEARCH) ===\n");

        // Array ordenado (¡requisito fundamental!)
        int[] array = {1, 3, 5, 7, 9, 11, 13, 15, 17, 19};
        System.out.print("Array ordenado: ");
        imprimirArray(array);
        System.out.println();

        // === BÚSQUEDA ITERATIVA ===
        System.out.println("=== BÚSQUEDA ITERATIVA ===");
        int[] objetivos1 = {15, 1, 19, 10};
        for (int objetivo : objetivos1) {
            int indice = busquedaBinaria(array, objetivo);
            if (indice != -1) {
                System.out.println("Buscar " + objetivo + ": encontrado en índice " + indice);
            } else {
                System.out.println("Buscar " + objetivo + ": NO encontrado (retorna -1)");
            }
        }
        System.out.println();

        // === BÚSQUEDA RECURSIVA ===
        System.out.println("=== BÚSQUEDA RECURSIVA ===");
        int[] objetivos2 = {15, 7, 20};
        for (int objetivo : objetivos2) {
            int indice = busquedaBinariaRecursiva(array, objetivo, 0, array.length - 1);
            if (indice != -1) {
                System.out.println("Buscar " + objetivo + ": encontrado en índice " + indice);
            } else {
                System.out.println("Buscar " + objetivo + ": NO encontrado (retorna -1)");
            }
        }
        System.out.println();

        // === BÚSQUEDA CON DUPLICADOS ===
        System.out.println("=== BÚSQUEDA CON DUPLICADOS ===");
        int[] arrayDuplicados = {1, 2, 2, 2, 3, 4, 4, 5};
        System.out.print("Array con duplicados: ");
        imprimirArray(arrayDuplicados);
        System.out.println("Primera ocurrencia de 2: índice " + buscarPrimerOcurrencia(arrayDuplicados, 2));
        System.out.println("Primera ocurrencia de 4: índice " + buscarPrimerOcurrencia(arrayDuplicados, 4));
        System.out.println();

        // === COMPARACIÓN DE EFICIENCIA ===
        System.out.println("=== COMPARACIÓN DE EFICIENCIA ===");
        // Crea array grande [1, 2, 3, ..., 100]
        int[] arrayGrande = new int[100];
        for (int i = 0; i < arrayGrande.length; i++) {
            arrayGrande[i] = i + 1;
        }

        System.out.println("Array grande (100 elementos): [1, 2, 3, ..., 100]");
        int objetivoBuscar = 87;
        System.out.println("Buscar " + objetivoBuscar + ":");

        int compLineal = contarComparacionesLineal(arrayGrande, objetivoBuscar);
        int compBinaria = contarComparacionesBinaria(arrayGrande, objetivoBuscar);

        System.out.println("- Búsqueda Lineal: " + compLineal + " comparaciones");
        System.out.println("- Búsqueda Binaria: " + compBinaria + " comparaciones");
        System.out.printf("⚡ Búsqueda Binaria es %.1fx más rápida\n", (double)compLineal / compBinaria);
        System.out.println();

        // REFLEXIÓN:
        // ¿Por qué es tan importante Binary Search?
        // ✓ Es uno de los algoritmos más importantes en programación
        // ✓ Base de muchos otros algoritmos eficientes
        // ✓ Usado en bases de datos para búsquedas rápidas
        // ✓ Ejemplo perfecto de "divide y conquista"
        //
        // BINARY SEARCH EN LA VIDA REAL:
        // - Bases de datos: Búsqueda en índices
        // - Git bisect: Encuentra el commit que introdujo un bug
        // - Diccionarios: Buscar palabras
        // - Librerías: Arrays.binarySearch() en Java
        //
        // REQUISITOS CRÍTICOS:
        // 1. Array DEBE estar ordenado
        // 2. Acceso aleatorio (arrays, no listas enlazadas)
        //
        // CUÁNDO USAR:
        // ✓ Array grande y ordenado
        // ✓ Búsquedas frecuentes
        // ✓ Necesitas O(log n)
        //
        // CUÁNDO NO USAR:
        // ✗ Array desordenado (ordena primero o usa lineal)
        // ✗ Array pequeño (< 10 elementos, lineal es suficiente)
        // ✗ Listas enlazadas (no hay acceso O(1) al medio)
        //
        // COMPARACIÓN CON OTROS ALGORITMOS:
        // Binary Search:    O(log n) - requiere ordenado
        // Linear Search:    O(n) - funciona sin ordenar
        // Hash Table:       O(1) - más rápido, pero usa más memoria
        //
        // EJEMPLO MATEMÁTICO O(log n):
        // Array de 1,000,000 elementos:
        // log₂(1,000,000) ≈ 20 comparaciones máximo
        //
        // Cada paso reduce el espacio de búsqueda a la mitad:
        // 1,000,000 → 500,000 → 250,000 → 125,000 → ...
        //
        // VARIANTES:
        // - Buscar primera/última ocurrencia
        // - Buscar rango de valores
        // - Búsqueda interpolada (para datos uniformemente distribuidos)
        // - Búsqueda exponencial (para búsquedas en ranges infinitos)
    }
}
