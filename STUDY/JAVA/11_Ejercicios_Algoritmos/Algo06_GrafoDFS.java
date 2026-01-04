/**
 * EJERCICIO ALGORITMO #6: DFS en Grafos
 * Categoria: Grafos
 * Dificultad: ⭐⭐⭐
 *
 * PROBLEMA:
 * Implementar Depth-First Search (busqueda en profundidad).
 * Explorar lo mas profundo posible antes de retroceder.
 *
 * DFS CARACTERISTICAS:
 * - Explora en profundidad primero
 * - Usa PILA (recursion implicita o explicita)
 * - Util para: ciclos, orden topologico, componentes
 *
 * COMPLEJIDAD:
 * - Tiempo: O(V + E)
 * - Espacio: O(V) por la pila de recursion
 *
 * EJEMPLO:
 *     0 --- 1 --- 2
 *     |     |
 *     3 --- 4
 *
 * DFS desde 0: [0, 1, 2, 4, 3] o [0, 3, 4, 1, 2]
 * (depende del orden de vecinos)
 */

import java.util.*;

public class Algo06_GrafoDFS {
    public static void main(String[] args) {
        int numNodos = 6;
        List<List<Integer>> grafo = new ArrayList<>();
        for (int i = 0; i < numNodos; i++) {
            grafo.add(new ArrayList<>());
        }

        // Grafo con 2 componentes
        agregarArista(grafo, 0, 1);
        agregarArista(grafo, 0, 2);
        agregarArista(grafo, 1, 2);
        agregarArista(grafo, 3, 4);
        agregarArista(grafo, 4, 5);

        System.out.println("=== DFS Recursivo desde 0 ===");
        boolean[] visitado = new boolean[numNodos];
        dfsRecursivo(grafo, 0, visitado);

        System.out.println("\n\n=== DFS Iterativo desde 0 ===");
        dfsIterativo(grafo, 0);

        System.out.println("\n\n=== Componentes Conexas ===");
        int numComponentes = contarComponentes(grafo);
        System.out.println("Numero de componentes: " + numComponentes);

        System.out.println("\n=== Detectar Ciclo ===");
        boolean tieneCiclo = tieneCiclo(grafo);
        System.out.println("Tiene ciclo: " + tieneCiclo);
    }

    private static void agregarArista(List<List<Integer>> grafo, int u, int v) {
        grafo.get(u).add(v);
        grafo.get(v).add(u);
    }

    /**
     * DFS recursivo.
     */
    public static void dfsRecursivo(List<List<Integer>> grafo, int nodo, boolean[] visitado) {
        // TODO: Implementar
        // 1. Marcar como visitado
        // 2. Procesar nodo (imprimir)
        // 3. Para cada vecino no visitado, llamar recursivamente
    }

    /**
     * DFS iterativo usando pila explicita.
     */
    public static void dfsIterativo(List<List<Integer>> grafo, int origen) {
        // TODO: Implementar
        // 1. Crear pila y agregar origen
        // 2. Mientras pila no vacia:
        //    - Pop nodo
        //    - Si no visitado: marcar, procesar, push vecinos
    }

    /**
     * Cuenta componentes conexas usando DFS.
     */
    public static int contarComponentes(List<List<Integer>> grafo) {
        // TODO: Implementar
        // DFS desde cada nodo no visitado = nueva componente

        return 0; // Placeholder
    }

    /**
     * Detecta si hay ciclo en grafo no dirigido.
     */
    public static boolean tieneCiclo(List<List<Integer>> grafo) {
        // TODO: Implementar
        // Durante DFS, si encontramos vecino visitado que no es padre -> ciclo

        return false; // Placeholder
    }
}

/*
 * ============================================
 * SOLUCION (NO MIRAR ANTES DE INTENTAR):
 * ============================================
 *
 * public static void dfsRecursivo(List<List<Integer>> grafo, int nodo,
 *                                 boolean[] visitado) {
 *     visitado[nodo] = true;
 *     System.out.print(nodo + " ");
 *
 *     for (int vecino : grafo.get(nodo)) {
 *         if (!visitado[vecino]) {
 *             dfsRecursivo(grafo, vecino, visitado);
 *         }
 *     }
 * }
 *
 * public static void dfsIterativo(List<List<Integer>> grafo, int origen) {
 *     boolean[] visitado = new boolean[grafo.size()];
 *     Stack<Integer> pila = new Stack<>();
 *
 *     pila.push(origen);
 *
 *     while (!pila.isEmpty()) {
 *         int nodo = pila.pop();
 *
 *         if (!visitado[nodo]) {
 *             visitado[nodo] = true;
 *             System.out.print(nodo + " ");
 *
 *             // Agregar vecinos en orden inverso para mismo orden que recursivo
 *             List<Integer> vecinos = grafo.get(nodo);
 *             for (int i = vecinos.size() - 1; i >= 0; i--) {
 *                 if (!visitado[vecinos.get(i)]) {
 *                     pila.push(vecinos.get(i));
 *                 }
 *             }
 *         }
 *     }
 * }
 *
 * public static int contarComponentes(List<List<Integer>> grafo) {
 *     int n = grafo.size();
 *     boolean[] visitado = new boolean[n];
 *     int componentes = 0;
 *
 *     for (int i = 0; i < n; i++) {
 *         if (!visitado[i]) {
 *             dfsRecursivo(grafo, i, visitado);
 *             componentes++;
 *             System.out.println(" <- Componente " + componentes);
 *         }
 *     }
 *
 *     return componentes;
 * }
 *
 * public static boolean tieneCiclo(List<List<Integer>> grafo) {
 *     int n = grafo.size();
 *     boolean[] visitado = new boolean[n];
 *
 *     for (int i = 0; i < n; i++) {
 *         if (!visitado[i]) {
 *             if (dfsCiclo(grafo, i, -1, visitado)) {
 *                 return true;
 *             }
 *         }
 *     }
 *     return false;
 * }
 *
 * private static boolean dfsCiclo(List<List<Integer>> grafo, int nodo,
 *                                 int padre, boolean[] visitado) {
 *     visitado[nodo] = true;
 *
 *     for (int vecino : grafo.get(nodo)) {
 *         if (!visitado[vecino]) {
 *             if (dfsCiclo(grafo, vecino, nodo, visitado)) {
 *                 return true;
 *             }
 *         } else if (vecino != padre) {
 *             // Vecino visitado que no es padre = ciclo
 *             return true;
 *         }
 *     }
 *     return false;
 * }
 */
