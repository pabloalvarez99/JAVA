/**
 * EJERCICIO ALGORITMO #7: Dijkstra Basico
 * Categoria: Grafos - Camino mas corto
 * Dificultad: ⭐⭐⭐⭐
 *
 * PROBLEMA:
 * Encontrar el camino mas corto desde un nodo origen
 * a todos los demas en un grafo con pesos positivos.
 *
 * ALGORITMO:
 * 1. Inicializar distancias (origen=0, resto=infinito)
 * 2. Usar cola de prioridad (min-heap)
 * 3. Siempre procesar el nodo con menor distancia conocida
 * 4. Para cada vecino, actualizar si encontramos camino mas corto
 *
 * COMPLEJIDAD:
 * - Con array: O(V^2)
 * - Con priority queue: O((V+E) log V)
 *
 * EJEMPLO:
 *       1
 *   0 -----> 1
 *   |        |
 *  4|       2|
 *   v        v
 *   3 <----- 2
 *       1
 *
 * Desde 0: d[0]=0, d[1]=1, d[2]=3, d[3]=4
 */

import java.util.*;

public class Algo07_DijkstraBasico {
    public static void main(String[] args) {
        int numNodos = 4;

        // Grafo como lista de adyacencia con pesos
        // Cada elemento es {destino, peso}
        List<List<int[]>> grafo = new ArrayList<>();
        for (int i = 0; i < numNodos; i++) {
            grafo.add(new ArrayList<>());
        }

        // Agregar aristas dirigidas con peso
        grafo.get(0).add(new int[]{1, 1});
        grafo.get(0).add(new int[]{3, 4});
        grafo.get(1).add(new int[]{2, 2});
        grafo.get(2).add(new int[]{3, 1});

        System.out.println("=== Dijkstra desde nodo 0 ===\n");

        int[] distancias = dijkstra(grafo, 0);

        System.out.println("Distancias minimas:");
        for (int i = 0; i < numNodos; i++) {
            System.out.printf("  0 -> %d: %d%n", i, distancias[i]);
        }
    }

    /**
     * Algoritmo de Dijkstra.
     *
     * @param grafo Lista de adyacencia con pesos {destino, peso}
     * @param origen Nodo origen
     * @return Array de distancias minimas desde origen
     */
    public static int[] dijkstra(List<List<int[]>> grafo, int origen) {
        int n = grafo.size();
        int[] dist = new int[n];
        Arrays.fill(dist, Integer.MAX_VALUE);

        // TODO: Implementar
        // 1. dist[origen] = 0
        // 2. PriorityQueue con {distancia, nodo}
        // 3. Mientras cola no vacia:
        //    - Extraer nodo con menor distancia
        //    - Si ya procesado (dist < actual), skip
        //    - Para cada vecino, relajar arista

        return dist;
    }
}

/*
 * ============================================
 * SOLUCION (NO MIRAR ANTES DE INTENTAR):
 * ============================================
 *
 * public static int[] dijkstra(List<List<int[]>> grafo, int origen) {
 *     int n = grafo.size();
 *     int[] dist = new int[n];
 *     Arrays.fill(dist, Integer.MAX_VALUE);
 *     dist[origen] = 0;
 *
 *     // PriorityQueue: {distancia, nodo}
 *     PriorityQueue<int[]> pq = new PriorityQueue<>(
 *         Comparator.comparingInt(a -> a[0])
 *     );
 *     pq.offer(new int[]{0, origen});
 *
 *     while (!pq.isEmpty()) {
 *         int[] actual = pq.poll();
 *         int d = actual[0];
 *         int u = actual[1];
 *
 *         // Si ya encontramos un camino mejor, skip
 *         if (d > dist[u]) continue;
 *
 *         System.out.printf("Procesando nodo %d (dist=%d)%n", u, d);
 *
 *         // Relajar aristas
 *         for (int[] arista : grafo.get(u)) {
 *             int v = arista[0];
 *             int peso = arista[1];
 *
 *             if (dist[u] + peso < dist[v]) {
 *                 dist[v] = dist[u] + peso;
 *                 pq.offer(new int[]{dist[v], v});
 *                 System.out.printf("  Actualizado: dist[%d] = %d%n", v, dist[v]);
 *             }
 *         }
 *     }
 *
 *     return dist;
 * }
 *
 * ============================================
 * RECONSTRUIR CAMINO:
 * ============================================
 *
 * int[] padre = new int[n];
 * Arrays.fill(padre, -1);
 *
 * // En la relajacion:
 * if (dist[u] + peso < dist[v]) {
 *     dist[v] = dist[u] + peso;
 *     padre[v] = u;  // Guardar de donde venimos
 *     pq.offer(...);
 * }
 *
 * // Reconstruir:
 * List<Integer> camino = new ArrayList<>();
 * int actual = destino;
 * while (actual != -1) {
 *     camino.add(0, actual);
 *     actual = padre[actual];
 * }
 *
 * ============================================
 * LIMITACIONES:
 * ============================================
 *
 * - NO funciona con pesos negativos
 * - Para pesos negativos: usar Bellman-Ford
 * - Para todos los pares: usar Floyd-Warshall
 */
