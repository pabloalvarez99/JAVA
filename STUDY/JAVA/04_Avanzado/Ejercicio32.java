/*
 * ========================================
 * EJERCICIO 32: Binary Search Tree (BST) - Árbol Binario de Búsqueda
 * DIFICULTAD: ⭐⭐⭐⭐⭐⭐⭐⭐⭐⭐ (Experto)
 * ========================================
 *
 * OBJETIVO:
 * Implementar un Árbol Binario de Búsqueda (BST), una estructura de datos
 * jerárquica que permite búsqueda, inserción y eliminación eficientes
 *
 * CONCEPTO CLAVE:
 * Un Binary Search Tree (BST) es una estructura de datos en forma de árbol donde:
 * - Cada nodo tiene MÁXIMO 2 hijos (left y right)
 * - Subárbol IZQUIERDO contiene valores MENORES
 * - Subárbol DERECHO contiene valores MAYORES
 * - Esta propiedad se cumple para TODOS los nodos
 *
 * ========================================
 * ESTRUCTURA DE UN BST
 * ========================================
 *
 * REPRESENTACIÓN VISUAL:
 *           50
 *         /    \
 *       30      70
 *      /  \    /  \
 *    20   40  60   80
 *
 * Nodo 50: izq(30) < 50 < der(70)
 * Nodo 30: izq(20) < 30 < der(40)
 * Nodo 70: izq(60) < 70 < der(80)
 *
 * PROPIEDADES:
 * ✓ Para cada nodo N:
 *   - Todos los valores en subárbol izquierdo < N
 *   - Todos los valores en subárbol derecho > N
 * ✓ Búsqueda eficiente: O(log n) en promedio
 * ✓ Inserción ordenada automática
 *
 * ========================================
 * OPERACIONES BÁSICAS
 * ========================================
 *
 * 1. INSERCIÓN:
 *    - Si árbol vacío, crear raíz
 *    - Si valor < nodo actual → ir a izquierda
 *    - Si valor > nodo actual → ir a derecha
 *    - Insertar cuando se encuentra posición vacía
 *
 * 2. BÚSQUEDA:
 *    - Comparar con nodo actual
 *    - Si igual → encontrado
 *    - Si menor → buscar en izquierda
 *    - Si mayor → buscar en derecha
 *
 * 3. RECORRIDOS (TRAVERSALS):
 *    - IN-ORDER (izq → raíz → der): muestra valores ORDENADOS
 *    - PRE-ORDER (raíz → izq → der): copiar árbol
 *    - POST-ORDER (izq → der → raíz): eliminar árbol
 *
 * ========================================
 * EJEMPLO DE INSERCIÓN
 * ========================================
 *
 * Insertar: 50, 30, 70, 20, 40, 60, 80
 *
 * Paso 1: Insertar 50
 *   50
 *
 * Paso 2: Insertar 30 (30 < 50 → izquierda)
 *     50
 *    /
 *   30
 *
 * Paso 3: Insertar 70 (70 > 50 → derecha)
 *     50
 *    /  \
 *   30   70
 *
 * Paso 4: Insertar 20 (20 < 50 → izq, 20 < 30 → izq)
 *       50
 *      /  \
 *     30   70
 *    /
 *   20
 *
 * ...y así sucesivamente
 *
 * ========================================
 * RECORRIDO IN-ORDER
 * ========================================
 *
 * Visita: izquierda → raíz → derecha
 * Resultado: valores en orden ascendente
 *
 * void inOrder(Node node) {
 *     if (node != null) {
 *         inOrder(node.left);      // Visitar izquierda
 *         System.out.print(node.data); // Visitar raíz
 *         inOrder(node.right);     // Visitar derecha
 *     }
 * }
 *
 * Para el árbol ejemplo: 20, 30, 40, 50, 60, 70, 80
 *
 * ========================================
 * COMPLEJIDAD
 * ========================================
 *
 * ÁRBOL BALANCEADO (mejor caso):
 * - Búsqueda: O(log n)
 * - Inserción: O(log n)
 * - Eliminación: O(log n)
 *
 * ÁRBOL DESBALANCEADO (peor caso):
 * - Búsqueda: O(n) - como lista enlazada
 * - Inserción: O(n)
 * - Eliminación: O(n)
 *
 * Ejemplo de árbol desbalanceado:
 *   1
 *    \
 *     2
 *      \
 *       3
 *        \
 *         4
 *
 * SOLUCIÓN: Árboles auto-balanceados (AVL, Red-Black)
 *
 * INSTRUCCIONES:
 * 1. Crea clase Node con: data, left, right
 * 2. Crea clase BST con métodos:
 *    - insert(int value): insertar valor
 *    - search(int value): buscar valor
 *    - inOrder(): recorrido in-order
 *    - preOrder(): recorrido pre-order
 *    - postOrder(): recorrido post-order
 *    - min(): encontrar valor mínimo
 *    - max(): encontrar valor máximo
 *    - height(): calcular altura del árbol
 *    - size(): contar nodos
 *
 * 3. Demuestra todas las operaciones
 * 4. Visualiza el árbol
 *
 * SALIDA ESPERADA:
 * === BINARY SEARCH TREE (BST) - ÁRBOL BINARIO DE BÚSQUEDA ===
 *
 * === CONSTRUCCIÓN DEL BST ===
 * Insertando: 50
 * Insertando: 30
 * Insertando: 70
 * Insertando: 20
 * Insertando: 40
 * Insertando: 60
 * Insertando: 80
 *
 * === ESTRUCTURA DEL ÁRBOL ===
 *           50
 *         /    \
 *       30      70
 *      /  \    /  \
 *    20   40  60   80
 *
 * === RECORRIDOS ===
 * In-Order (ascendente):   20 30 40 50 60 70 80
 * Pre-Order (raíz primero): 50 30 20 40 70 60 80
 * Post-Order (raíz último): 20 40 30 60 80 70 50
 *
 * === ESTADÍSTICAS ===
 * Tamaño del árbol: 7 nodos
 * Altura del árbol: 2 niveles
 * Valor mínimo: 20
 * Valor máximo: 80
 *
 * === BÚSQUEDAS ===
 * ¿Existe 40? true ✓
 * ¿Existe 55? false ✗
 * ¿Existe 80? true ✓
 * ¿Existe 10? false ✗
 *
 * === ÁRBOL DESBALANCEADO ===
 * Insertando en orden: 1, 2, 3, 4, 5
 *   1
 *    \
 *     2
 *      \
 *       3
 *        \
 *         4
 *          \
 *           5
 *
 * Altura: 4 (desbalanceado)
 *
 * CONCEPTOS NUEVOS:
 * - Binary Search Tree (BST): Árbol binario de búsqueda
 * - Node: Nodo con valor y referencias left/right
 * - Root: Raíz del árbol (nodo principal)
 * - Leaf: Hoja (nodo sin hijos)
 * - In-Order: Recorrido izq → raíz → der
 * - Pre-Order: Recorrido raíz → izq → der
 * - Post-Order: Recorrido izq → der → raíz
 * - Height: Altura del árbol
 * - Depth: Profundidad de un nodo
 * - Balanced tree: Árbol balanceado
 *
 * VENTAJAS DEL BST:
 * ✓ Búsqueda eficiente O(log n) en promedio
 * ✓ Inserción ordenada automática
 * ✓ Valores siempre ordenados (in-order)
 * ✓ Base para estructuras avanzadas (AVL, Red-Black)
 *
 * DESVENTAJAS:
 * ✗ Puede desbalancearse → O(n) en peor caso
 * ✗ No garantiza balanceo automático
 * ✗ Requiere más memoria que array
 *
 * APLICACIONES:
 * ✓ Implementar TreeSet, TreeMap en Java
 * ✓ Autocompletar en buscadores
 * ✓ Sistemas de archivos
 * ✓ Expresiones aritméticas
 * ✓ Bases de datos (índices B-Tree)
 *
 */

// ========================================
// CLASE NODE (NODO DEL ÁRBOL)
// ========================================

// TODO: Implementa clase Node
class Node {
    int data;
    Node left;
    Node right;

    public Node(int data) {
        this.data = data;
        this.left = null;
        this.right = null;
    }
}

// ========================================
// CLASE BST (ÁRBOL BINARIO DE BÚSQUEDA)
// ========================================

// TODO: Implementa clase BST
class BST {
    Node root;

    public BST() {
        this.root = null;
    }

    // ========================================
    // INSERCIÓN
    // ========================================

    // TODO: Método público para insertar
    public void insert(int value) {
        root = insertRecursive(root, value);
    }

    // TODO: Método recursivo para insertar
    private Node insertRecursive(Node current, int value) {
        // Caso base: posición vacía encontrada
        if (current == null) {
            return new Node(value);
        }

        // Decidir si ir a izquierda o derecha
        if (value < current.data) {
            current.left = insertRecursive(current.left, value);
        } else if (value > current.data) {
            current.right = insertRecursive(current.right, value);
        }
        // Si value == current.data, no insertar (no duplicados)

        return current;
    }

    // ========================================
    // BÚSQUEDA
    // ========================================

    // TODO: Método público para buscar
    public boolean search(int value) {
        return searchRecursive(root, value);
    }

    // TODO: Método recursivo para buscar
    private boolean searchRecursive(Node current, int value) {
        // Caso base: no encontrado
        if (current == null) {
            return false;
        }

        // Caso base: encontrado
        if (value == current.data) {
            return true;
        }

        // Buscar en subárbol correcto
        if (value < current.data) {
            return searchRecursive(current.left, value);
        } else {
            return searchRecursive(current.right, value);
        }
    }

    // ========================================
    // RECORRIDOS (TRAVERSALS)
    // ========================================

    // TODO: In-Order (izquierda → raíz → derecha)
    public void inOrder() {
        inOrderRecursive(root);
        System.out.println();
    }

    private void inOrderRecursive(Node node) {
        if (node != null) {
            inOrderRecursive(node.left);
            System.out.print(node.data + " ");
            inOrderRecursive(node.right);
        }
    }

    // TODO: Pre-Order (raíz → izquierda → derecha)
    public void preOrder() {
        preOrderRecursive(root);
        System.out.println();
    }

    private void preOrderRecursive(Node node) {
        if (node != null) {
            System.out.print(node.data + " ");
            preOrderRecursive(node.left);
            preOrderRecursive(node.right);
        }
    }

    // TODO: Post-Order (izquierda → derecha → raíz)
    public void postOrder() {
        postOrderRecursive(root);
        System.out.println();
    }

    private void postOrderRecursive(Node node) {
        if (node != null) {
            postOrderRecursive(node.left);
            postOrderRecursive(node.right);
            System.out.print(node.data + " ");
        }
    }

    // ========================================
    // ESTADÍSTICAS DEL ÁRBOL
    // ========================================

    // TODO: Encontrar valor mínimo
    public int min() {
        if (root == null) {
            throw new IllegalStateException("El árbol está vacío");
        }
        return minRecursive(root);
    }

    private int minRecursive(Node node) {
        // El mínimo está siempre a la izquierda
        if (node.left == null) {
            return node.data;
        }
        return minRecursive(node.left);
    }

    // TODO: Encontrar valor máximo
    public int max() {
        if (root == null) {
            throw new IllegalStateException("El árbol está vacío");
        }
        return maxRecursive(root);
    }

    private int maxRecursive(Node node) {
        // El máximo está siempre a la derecha
        if (node.right == null) {
            return node.data;
        }
        return maxRecursive(node.right);
    }

    // TODO: Calcular altura del árbol
    public int height() {
        return heightRecursive(root);
    }

    private int heightRecursive(Node node) {
        if (node == null) {
            return -1; // Árbol vacío tiene altura -1
        }

        int leftHeight = heightRecursive(node.left);
        int rightHeight = heightRecursive(node.right);

        return 1 + Math.max(leftHeight, rightHeight);
    }

    // TODO: Contar número de nodos
    public int size() {
        return sizeRecursive(root);
    }

    private int sizeRecursive(Node node) {
        if (node == null) {
            return 0;
        }

        return 1 + sizeRecursive(node.left) + sizeRecursive(node.right);
    }

    // ========================================
    // VISUALIZACIÓN DEL ÁRBOL
    // ========================================

    public void visualizar() {
        visualizarRecursivo(root, "", true);
    }

    private void visualizarRecursivo(Node node, String prefijo, boolean esUltimo) {
        if (node != null) {
            System.out.println(prefijo + (esUltimo ? "└── " : "├── ") + node.data);

            String nuevoPrefijo = prefijo + (esUltimo ? "    " : "│   ");

            if (node.left != null || node.right != null) {
                if (node.left != null) {
                    visualizarRecursivo(node.left, nuevoPrefijo, node.right == null);
                }
                if (node.right != null) {
                    visualizarRecursivo(node.right, nuevoPrefijo, true);
                }
            }
        }
    }
}

// ========================================
// CLASE PRINCIPAL
// ========================================

public class Ejercicio32 {
    public static void main(String[] args) {
        System.out.println("=== BINARY SEARCH TREE (BST) - ÁRBOL BINARIO DE BÚSQUEDA ===\n");

        // ========================================
        // CONSTRUCCIÓN DEL BST
        // ========================================
        System.out.println("=== CONSTRUCCIÓN DEL BST ===");
        BST bst = new BST();

        int[] valores = {50, 30, 70, 20, 40, 60, 80};
        for (int valor : valores) {
            System.out.println("Insertando: " + valor);
            bst.insert(valor);
        }

        // ========================================
        // VISUALIZACIÓN
        // ========================================
        System.out.println("\n=== ESTRUCTURA DEL ÁRBOL ===");
        bst.visualizar();

        // ========================================
        // RECORRIDOS
        // ========================================
        System.out.println("\n=== RECORRIDOS ===");
        System.out.print("In-Order (ascendente):   ");
        bst.inOrder();

        System.out.print("Pre-Order (raíz primero): ");
        bst.preOrder();

        System.out.print("Post-Order (raíz último): ");
        bst.postOrder();

        // ========================================
        // ESTADÍSTICAS
        // ========================================
        System.out.println("\n=== ESTADÍSTICAS ===");
        System.out.println("Tamaño del árbol: " + bst.size() + " nodos");
        System.out.println("Altura del árbol: " + bst.height() + " niveles");
        System.out.println("Valor mínimo: " + bst.min());
        System.out.println("Valor máximo: " + bst.max());

        // ========================================
        // BÚSQUEDAS
        // ========================================
        System.out.println("\n=== BÚSQUEDAS ===");
        int[] busquedas = {40, 55, 80, 10};
        for (int valor : busquedas) {
            boolean encontrado = bst.search(valor);
            System.out.println("¿Existe " + valor + "? " + encontrado +
                             (encontrado ? " ✓" : " ✗"));
        }

        // ========================================
        // ÁRBOL DESBALANCEADO
        // ========================================
        System.out.println("\n=== ÁRBOL DESBALANCEADO ===");
        BST bstDesbalanceado = new BST();
        System.out.println("Insertando en orden: 1, 2, 3, 4, 5");
        for (int i = 1; i <= 5; i++) {
            bstDesbalanceado.insert(i);
        }

        System.out.println("\nEstructura:");
        bstDesbalanceado.visualizar();

        System.out.println("\nAltura: " + bstDesbalanceado.height() + " (desbalanceado)");
        System.out.println("Nota: Un árbol balanceado de 5 nodos tendría altura 2");

        // ========================================
        // ÁRBOL BALANCEADO VS DESBALANCEADO
        // ========================================
        System.out.println("\n=== COMPARACIÓN: BALANCEADO VS DESBALANCEADO ===");

        // Árbol balanceado
        BST balanceado = new BST();
        balanceado.insert(50);
        balanceado.insert(25);
        balanceado.insert(75);
        balanceado.insert(12);
        balanceado.insert(37);
        balanceado.insert(62);
        balanceado.insert(87);

        System.out.println("Árbol BALANCEADO (7 nodos):");
        balanceado.visualizar();
        System.out.println("Altura: " + balanceado.height());

        System.out.println("\nÁrbol DESBALANCEADO (7 nodos):");
        bstDesbalanceado.insert(6);
        bstDesbalanceado.insert(7);
        bstDesbalanceado.visualizar();
        System.out.println("Altura: " + bstDesbalanceado.height());

        // REFLEXIÓN FINAL:
        // ¿Por qué usar un BST?
        // ✓ Búsqueda eficiente: O(log n) en promedio
        // ✓ Mantiene datos ordenados automáticamente
        // ✓ Inserción y búsqueda más rápidas que array
        // ✓ Base para estructuras avanzadas
        //
        // EN LA VIDA REAL:
        // - TreeSet y TreeMap en Java usan Red-Black Tree (BST balanceado)
        // - Bases de datos: índices B-Tree (variante de BST)
        // - Autocompletado: Trie (árbol especializado)
        // - Compiladores: árbol de sintaxis abstracta (AST)
        // - Sistemas de archivos: estructura jerárquica
        //
        // TIPOS DE ÁRBOLES BINARIOS:
        //
        // 1. BST (Binary Search Tree):
        //    - Izquierda < Raíz < Derecha
        //    - No garantiza balanceo
        //
        // 2. AVL Tree:
        //    - BST auto-balanceado
        //    - Diferencia de altura entre subárboles ≤ 1
        //    - Garantiza O(log n)
        //
        // 3. Red-Black Tree:
        //    - BST auto-balanceado
        //    - Nodos rojos y negros con reglas
        //    - Usado en TreeMap, TreeSet
        //
        // 4. B-Tree:
        //    - Árbol de múltiples hijos (no binario)
        //    - Usado en bases de datos
        //    - Optimizado para disco
        //
        // OPERACIONES ADICIONALES (NO IMPLEMENTADAS):
        //
        // DELETE (eliminar nodo):
        // - Caso 1: Nodo hoja → simplemente eliminar
        // - Caso 2: Nodo con 1 hijo → reemplazar con hijo
        // - Caso 3: Nodo con 2 hijos → reemplazar con sucesor in-order
        //
        // BALANCED CHECK (verificar si está balanceado):
        // - Para cada nodo, |altura_izq - altura_der| ≤ 1
        //
        // LEVEL-ORDER (recorrido por niveles):
        // - Usar Queue (BFS)
        // - Útil para imprimir árbol nivel por nivel
        //
        // CUÁNDO USAR BST:
        // ✓ Necesitas datos ordenados dinámicamente
        // ✓ Búsquedas frecuentes
        // ✓ Inserciones y eliminaciones frecuentes
        // ✗ Datos aleatorios pequeños (usa array/ArrayList)
        // ✗ Necesitas acceso por índice (usa ArrayList)
        //
        // COMPARACIÓN:
        //
        // Array ordenado:
        // - Búsqueda: O(log n) con binary search
        // - Inserción: O(n) - desplazar elementos
        //
        // ArrayList:
        // - Búsqueda: O(n) lineal
        // - Inserción al final: O(1)
        //
        // BST:
        // - Búsqueda: O(log n) promedio, O(n) peor caso
        // - Inserción: O(log n) promedio, O(n) peor caso
        //
        // AVL/Red-Black Tree:
        // - Búsqueda: O(log n) garantizado
        // - Inserción: O(log n) garantizado
        //
        // IMPORTANTE:
        // En Java, usa TreeSet/TreeMap en lugar de implementar tu propio BST
        // para producción. Ellos usan Red-Black Tree (garantiza O(log n)).
    }
}
