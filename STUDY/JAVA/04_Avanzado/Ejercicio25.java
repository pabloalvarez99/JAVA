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
 */

public class Ejercicio25 {
    // TODO: Lee las instrucciones arriba y escribe TODO el código
    // TODO: Implementa todas las clases, métodos y lógica necesaria
}
