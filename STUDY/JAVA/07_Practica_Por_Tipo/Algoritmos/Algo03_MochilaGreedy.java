/**
 * EJERCICIO ALGORITMO #3: Problema de la Mochila (Greedy)
 * Categoria: Greedy (Voraz)
 * Dificultad: ⭐⭐
 *
 * PROBLEMA:
 * Tienes una mochila con capacidad W y N objetos.
 * Cada objeto tiene peso y valor.
 * Maximizar el valor total sin exceder la capacidad.
 *
 * VERSION FRACCIONARIA:
 * Puedes tomar fracciones de objetos.
 * Greedy funciona optimamente aqui.
 *
 * ESTRATEGIA GREEDY:
 * Ordenar por valor/peso (ratio) descendente.
 * Tomar objetos en ese orden hasta llenar.
 *
 * EJEMPLO:
 * Capacidad: 50
 * Objetos: [(60,10), (100,20), (120,30)] (valor, peso)
 * Ratios: [6, 5, 4]
 * Tomar: todo de (60,10), todo de (100,20), 2/3 de (120,30)
 * Valor: 60 + 100 + 80 = 240
 *
 * COMPLEJIDAD:
 * - Tiempo: O(n log n) por ordenamiento
 * - Espacio: O(1)
 */

import java.util.*;

public class Algo03_MochilaGreedy {
    public static void main(String[] args) {
        // Objetos: {valor, peso}
        int[][] objetos = {
            {60, 10},   // ratio 6
            {100, 20},  // ratio 5
            {120, 30}   // ratio 4
        };
        int capacidad = 50;

        double valorTotal = mochilaFraccionaria(objetos, capacidad);
        System.out.printf("Valor maximo: %.2f%n", valorTotal);
        // Esperado: 240.00
    }

    /**
     * Resuelve el problema de la mochila fraccionaria.
     *
     * @param objetos Array de {valor, peso}
     * @param capacidad Capacidad de la mochila
     * @return Valor maximo posible
     */
    public static double mochilaFraccionaria(int[][] objetos, int capacidad) {
        // TODO: Implementar
        // 1. Crear lista con ratios valor/peso
        // 2. Ordenar por ratio descendente
        // 3. Tomar objetos en orden hasta llenar

        return 0; // Placeholder
    }
}

/*
 * ============================================
 * SOLUCION (NO MIRAR ANTES DE INTENTAR):
 * ============================================
 *
 * public static double mochilaFraccionaria(int[][] objetos, int capacidad) {
 *     int n = objetos.length;
 *
 *     // Crear array de indices ordenados por ratio
 *     Integer[] indices = new Integer[n];
 *     for (int i = 0; i < n; i++) indices[i] = i;
 *
 *     // Ordenar por ratio valor/peso descendente
 *     Arrays.sort(indices, (a, b) -> {
 *         double ratioA = (double) objetos[a][0] / objetos[a][1];
 *         double ratioB = (double) objetos[b][0] / objetos[b][1];
 *         return Double.compare(ratioB, ratioA);
 *     });
 *
 *     double valorTotal = 0;
 *     int capacidadRestante = capacidad;
 *
 *     for (int i : indices) {
 *         int valor = objetos[i][0];
 *         int peso = objetos[i][1];
 *
 *         if (capacidadRestante >= peso) {
 *             // Tomar objeto completo
 *             valorTotal += valor;
 *             capacidadRestante -= peso;
 *             System.out.printf("Tomando objeto completo: valor=%d, peso=%d%n",
 *                 valor, peso);
 *         } else if (capacidadRestante > 0) {
 *             // Tomar fraccion
 *             double fraccion = (double) capacidadRestante / peso;
 *             valorTotal += valor * fraccion;
 *             System.out.printf("Tomando %.2f del objeto: valor=%.2f, peso=%d%n",
 *                 fraccion, valor * fraccion, capacidadRestante);
 *             capacidadRestante = 0;
 *         }
 *
 *         if (capacidadRestante == 0) break;
 *     }
 *
 *     return valorTotal;
 * }
 *
 * ============================================
 * NOTA: Mochila 0/1 (sin fracciones)
 * ============================================
 *
 * Para la version donde NO puedes tomar fracciones,
 * Greedy NO funciona optimamente.
 * Se necesita Programacion Dinamica.
 *
 * Ejemplo donde Greedy falla:
 * Objetos: [(10,5), (8,4), (8,4)]
 * Capacidad: 8
 *
 * Greedy: toma (10,5), no cabe mas -> valor 10
 * Optimo: toma (8,4) + (8,4) -> valor 16
 *
 * Ver: Algo04 para DP o versiones mas avanzadas
 */
