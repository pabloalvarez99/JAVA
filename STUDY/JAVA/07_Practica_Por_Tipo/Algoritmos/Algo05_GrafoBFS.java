/**
 * EJERCICIO ALGORITMO #5: BFS en Grafos
 * Categoria: Grafos
 * Dificultad: ⭐⭐⭐
 *
 * PROBLEMA:
 * Implementar Breadth-First Search (busqueda en anchura).
 * Encontrar el camino mas corto (en numero de aristas)
 * desde un nodo origen a todos los demas.
 *
 * BFS CARACTERISTICAS:
 * - Explora por niveles (primero vecinos, luego vecinos de vecinos)
 * - Usa una COLA (Queue)
 * - Encuentra camino mas corto en grafos sin peso
 *
 * COMPLEJIDAD:
 * - Tiempo: O(V + E) donde V=vertices, E=aristas
 * - Espacio: O(V)
 *
 * EJEMPLO:
 *     0 --- 1 --- 2
 *     |     |
 *     3 --- 4
 *
 * BFS desde 0: [0, 1, 3, 2, 4]
 * Distancias: 0->0, 1->1, 2->2, 3->1, 4->2
 */

import java.util.*;

public class Algo05_GrafoBFS {
    public static void main(String[] args) {
        // Grafo como lista de adyacencia
        int numNodos = 5;
        List<List<Integer>> grafo = new ArrayList<>();
        for (int i = 0; i < numNodos; i++) {
            grafo.add(new ArrayList<>());
        }

        // Agregar aristas (no dirigido)
        agregarArista(grafo, 0, 1);
        agregarArista(grafo, 0, 3);
        agregarArista(grafo, 1, 2);
        agregarArista(grafo, 1, 4);
        agregarArista(grafo, 3, 4);

        System.out.println("=== BFS desde nodo 0 ===");
        int[] distancias = bfs(grafo, 0);

        System.out.println("\nDistancias desde 0:");
        for (int i = 0; i < numNodos; i++) {
            System.out.printf("  Nodo %d: %d%n", i, distancias[i]);
        }

        // Encontrar camino mas corto
        System.out.println("\nCamino de 0 a 2:");
        List<Integer> camino = encontrarCamino(grafo, 0, 2);
        System.out.println(camino);
    }

    private static void agregarArista(List<List<Integer>> grafo, int u, int v) {
        grafo.get(u).add(v);
        grafo.get(v).add(u);  // No dirigido
    }

    /**
     * BFS que retorna distancias desde origen.
     */
    public static int[] bfs(List<List<Integer>> grafo, int origen) {
        int n = grafo.size();
        int[] distancias = new int[n];
        Arrays.fill(distancias, -1);  // -1 = no alcanzado

        // TODO: Implementar
        // 1. Crear cola y agregar origen
        // 2. Marcar origen con distancia 0
        // 3. Mientras cola no vacia:
        //    - Sacar nodo actual
        //    - Para cada vecino no visitado:
        //      - Marcar distancia = distancia[actual] + 1
        //      - Agregar a cola

        return distancias;
    }

    /**
     * Encuentra el camino mas corto entre dos nodos.
     */
    public static List<Integer> encontrarCamino(List<List<Integer>> grafo,
                                                int origen, int destino) {
        // TODO: Implementar usando BFS con array de padres

        return new ArrayList<>(); // Placeholder
    }
}

/*
 * ============================================
 * SOLUCION (NO MIRAR ANTES DE INTENTAR):
 * ============================================
 *
 * public static int[] bfs(List<List<Integer>> grafo, int origen) {
 *     int n = grafo.size();
 *     int[] distancias = new int[n];
 *     Arrays.fill(distancias, -1);
 *
 *     Queue<Integer> cola = new LinkedList<>();
 *     cola.add(origen);
 *     distancias[origen] = 0;
 *
 *     System.out.print("Orden BFS: ");
 *
 *     while (!cola.isEmpty()) {
 *         int actual = cola.poll();
 *         System.out.print(actual + " ");
 *
 *         for (int vecino : grafo.get(actual)) {
 *             if (distancias[vecino] == -1) {  // No visitado
 *                 distancias[vecino] = distancias[actual] + 1;
 *                 cola.add(vecino);
 *             }
 *         }
 *     }
 *     System.out.println();
 *
 *     return distancias;
 * }
 *
 * public static List<Integer> encontrarCamino(List<List<Integer>> grafo,
 *                                             int origen, int destino) {
 *     int n = grafo.size();
 *     int[] padre = new int[n];
 *     Arrays.fill(padre, -1);
 *
 *     Queue<Integer> cola = new LinkedList<>();
 *     cola.add(origen);
 *     padre[origen] = origen;  // Marca como visitado
 *
 *     while (!cola.isEmpty()) {
 *         int actual = cola.poll();
 *
 *         if (actual == destino) break;
 *
 *         for (int vecino : grafo.get(actual)) {
 *             if (padre[vecino] == -1) {
 *                 padre[vecino] = actual;
 *                 cola.add(vecino);
 *             }
 *         }
 *     }
 *
 *     // Reconstruir camino
 *     List<Integer> camino = new ArrayList<>();
 *     if (padre[destino] == -1) return camino;  // No hay camino
 *
 *     int actual = destino;
 *     while (actual != origen) {
 *         camino.add(0, actual);
 *         actual = padre[actual];
 *     }
 *     camino.add(0, origen);
 *
 *     return camino;
 * }
 *
 * ============================================
 * APLICACIONES DE BFS:
 * ============================================
 *
 * 1. Camino mas corto (sin pesos)
 * 2. Detectar ciclos
 * 3. Componentes conexas
 * 4. Bipartito check
 * 5. Crawler web (niveles de profundidad)
 */
