/**
 * EJERCICIO ALGORITMO #2: Laberinto con Backtracking
 * Categoria: Backtracking
 * Dificultad: ⭐⭐⭐
 *
 * PROBLEMA:
 * Encontrar un camino desde la entrada (0,0) hasta la salida (n-1, m-1)
 * en un laberinto representado como matriz.
 *
 * REPRESENTACION:
 * 0 = Camino libre
 * 1 = Pared
 * 2 = Visitado (para marcar el camino)
 *
 * EJEMPLO:
 * {0, 1, 0, 0}
 * {0, 0, 0, 1}
 * {1, 0, 1, 0}
 * {0, 0, 0, 0}
 *
 * MOVIMIENTOS: arriba, abajo, izquierda, derecha
 *
 * COMPLEJIDAD:
 * - Tiempo: O(4^(n*m)) peor caso
 * - Espacio: O(n*m) para recursion
 */

public class Algo02_LaberintoBacktrack {
    // Direcciones: arriba, abajo, izquierda, derecha
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) {
        int[][] laberinto = {
            {0, 1, 0, 0},
            {0, 0, 0, 1},
            {1, 0, 1, 0},
            {0, 0, 0, 0}
        };

        System.out.println("Laberinto original:");
        imprimirLaberinto(laberinto);

        if (resolverLaberinto(laberinto, 0, 0)) {
            System.out.println("\nSolucion encontrada:");
            imprimirLaberinto(laberinto);
        } else {
            System.out.println("\nNo hay solucion");
        }
    }

    /**
     * Resuelve el laberinto usando backtracking.
     *
     * @param lab Matriz del laberinto
     * @param x Fila actual
     * @param y Columna actual
     * @return true si se encontro solucion
     */
    public static boolean resolverLaberinto(int[][] lab, int x, int y) {
        int n = lab.length;
        int m = lab[0].length;

        // TODO: Implementar
        // 1. Verificar si llegamos al destino
        // 2. Verificar si posicion es valida y libre
        // 3. Marcar como visitado
        // 4. Intentar cada direccion recursivamente
        // 5. Si ninguna funciona, desmarcar (backtrack)

        return false; // Placeholder
    }

    private static boolean esValido(int[][] lab, int x, int y) {
        int n = lab.length;
        int m = lab[0].length;
        return x >= 0 && x < n && y >= 0 && y < m && lab[x][y] == 0;
    }

    private static void imprimirLaberinto(int[][] lab) {
        for (int[] fila : lab) {
            for (int celda : fila) {
                char c = celda == 0 ? '.' : (celda == 1 ? '#' : '*');
                System.out.print(c + " ");
            }
            System.out.println();
        }
    }
}

/*
 * ============================================
 * SOLUCION (NO MIRAR ANTES DE INTENTAR):
 * ============================================
 *
 * public static boolean resolverLaberinto(int[][] lab, int x, int y) {
 *     int n = lab.length;
 *     int m = lab[0].length;
 *
 *     // Destino alcanzado
 *     if (x == n - 1 && y == m - 1) {
 *         lab[x][y] = 2;  // Marcar salida
 *         return true;
 *     }
 *
 *     // Verificar si podemos estar aqui
 *     if (!esValido(lab, x, y)) {
 *         return false;
 *     }
 *
 *     // Marcar como visitado
 *     lab[x][y] = 2;
 *
 *     // Intentar cada direccion
 *     for (int i = 0; i < 4; i++) {
 *         int nuevoX = x + dx[i];
 *         int nuevoY = y + dy[i];
 *
 *         if (resolverLaberinto(lab, nuevoX, nuevoY)) {
 *             return true;
 *         }
 *     }
 *
 *     // Backtrack: desmarcar
 *     lab[x][y] = 0;
 *     return false;
 * }
 *
 * ============================================
 * EXTENSION: Encontrar TODOS los caminos
 * ============================================
 *
 * static List<List<int[]>> todosLosCaminos = new ArrayList<>();
 *
 * void encontrarTodos(int[][] lab, int x, int y, List<int[]> camino) {
 *     if (x == n-1 && y == m-1) {
 *         camino.add(new int[]{x, y});
 *         todosLosCaminos.add(new ArrayList<>(camino));
 *         camino.remove(camino.size() - 1);
 *         return;
 *     }
 *
 *     if (!esValido(lab, x, y)) return;
 *
 *     lab[x][y] = 2;
 *     camino.add(new int[]{x, y});
 *
 *     for (int i = 0; i < 4; i++) {
 *         encontrarTodos(lab, x + dx[i], y + dy[i], camino);
 *     }
 *
 *     lab[x][y] = 0;
 *     camino.remove(camino.size() - 1);
 * }
 *
 * ============================================
 * EXTENSION: Camino mas corto (usar BFS)
 * ============================================
 */
