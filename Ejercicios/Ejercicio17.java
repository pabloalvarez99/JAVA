/*
 * ========================================
 * EJERCICIO 17: Introducción al Concepto de Nodo
 * DIFICULTAD: ⭐⭐⭐⭐⭐ (Avanzado)
 * ========================================
 *
 * OBJETIVO:
 * Entender el concepto fundamental de NODO: un objeto que contiene datos
 * y una referencia a otro objeto del mismo tipo. Esta es la base para
 * estructuras de datos como listas enlazadas, árboles y grafos.
 *
 * CONCEPTO CLAVE:
 * ¿QUÉ ES UN NODO?
 *
 * Un NODO es un objeto que tiene:
 * 1. DATOS: información que almacena (int, String, Object, etc.)
 * 2. REFERENCIA: un "puntero" a otro Nodo del mismo tipo
 *
 * Ejemplo visual:
 *   [Dato: 5 | Siguiente: →] → [Dato: 10 | Siguiente: →] → [Dato: 15 | Siguiente: null]
 *
 * Esto permite crear CADENAS de objetos conectados, donde cada objeto
 * "conoce" al siguiente. Es como un tren: cada vagón está conectado al siguiente.
 *
 * ¿POR QUÉ ES IMPORTANTE?
 * - ArrayList internamente usa un array que se redimensiona
 * - LinkedList usa nodos conectados (más eficiente para insertar/eliminar)
 * - Árboles binarios usan nodos con 2 referencias (izquierda/derecha)
 * - Grafos usan nodos con múltiples referencias
 *
 * INSTRUCCIONES:
 * 1. Crea una clase "NodoSimple" con:
 *    - Atributo privado: dato (int)
 *    - Atributo privado: siguiente (NodoSimple) - referencia al siguiente nodo
 *    - Constructor que reciba el dato (siguiente empieza en null)
 *    - Getters y setters para ambos atributos
 *
 * 2. Crea una clase "CadenaDeNodos" con:
 *    - Atributo privado: primero (NodoSimple) - el primer nodo de la cadena
 *    - Constructor sin parámetros (primero empieza en null)
 *    - Método "agregarAlInicio(int dato)" - crea un nodo y lo pone al principio
 *    - Método "agregarAlFinal(int dato)" - crea un nodo y lo pone al final
 *    - Método "imprimir()" - imprime todos los nodos en orden
 *    - Método "contar()" - cuenta cuántos nodos hay
 *    - Método "buscar(int dato)" - retorna true si el dato existe
 *    - Método "obtener(int indice)" - retorna el dato en esa posición (0-indexed)
 *    - Método "eliminarPrimero()" - elimina el primer nodo
 *    - Método "imprimirConFlechas()" - imprime visualmente: 5 → 10 → 15 → null
 *
 * 3. En el main:
 *    - Crea una cadena de nodos
 *    - Agrega varios nodos al inicio y al final
 *    - Imprime la cadena
 *    - Cuenta los nodos
 *    - Busca valores específicos
 *    - Obtiene valores por índice
 *    - Elimina el primer nodo
 *    - Muestra la cadena visualmente con flechas
 *
 * SALIDA ESPERADA:
 * ====== Cadena de Nodos ======
 *
 * Agregando al inicio: 30
 * Agregando al inicio: 20
 * Agregando al inicio: 10
 *
 * Cadena actual: 10 20 30
 *
 * Agregando al final: 40
 * Agregando al final: 50
 *
 * Cadena actual: 10 20 30 40 50
 * Visualización: 10 → 20 → 30 → 40 → 50 → null
 *
 * Total de nodos: 5
 *
 * ¿Está el 30? true
 * ¿Está el 100? false
 *
 * Dato en índice 0: 10
 * Dato en índice 2: 30
 * Dato en índice 4: 50
 *
 * Eliminando el primer nodo...
 * Cadena después de eliminar: 20 30 40 50
 * Visualización: 20 → 30 → 40 → 50 → null
 *
 * CONCEPTOS NUEVOS:
 * - Nodo: objeto con referencia a otro del mismo tipo
 * - Auto-referencia: NodoSimple contiene NodoSimple
 * - Recorrido de nodos con puntero "actual"
 * - Inserción al inicio (O(1) - muy rápida)
 * - Inserción al final (O(n) - requiere recorrer)
 * - Concepto de "cabeza" o "primero" de la lista
 */

// TODO: Crea la clase NodoSimple
class NodoSimple {
    // TODO: Atributos privados (dato y siguiente)


    // TODO: Constructor


    // TODO: Getters y setters

}

// TODO: Crea la clase CadenaDeNodos
class CadenaDeNodos {
    // TODO: Atributo privado (primero)


    // TODO: Constructor


    // TODO: Método agregarAlInicio


    // TODO: Método agregarAlFinal


    // TODO: Método imprimir


    // TODO: Método contar


    // TODO: Método buscar


    // TODO: Método obtener (por índice)


    // TODO: Método eliminarPrimero


    // TODO: Método imprimirConFlechas

}

public class Ejercicio17 {
    public static void main(String[] args) {
        // TODO: Crea una cadena de nodos


        // TODO: Agrega varios nodos al inicio
        System.out.println("====== Cadena de Nodos ======\n");




        // TODO: Imprime la cadena


        // TODO: Agrega nodos al final



        // TODO: Imprime la cadena y visualización


        // TODO: Cuenta los nodos


        // TODO: Busca valores


        // TODO: Obtén valores por índice


        // TODO: Elimina el primero y muestra


    }
}

/*
 * ========================================
 * REFLEXIÓN Y PROFUNDIZACIÓN
 * ========================================
 *
 * ¿QUÉ ACABAS DE APRENDER?
 *
 * 1. AUTO-REFERENCIA:
 *    class NodoSimple {
 *        private NodoSimple siguiente; // ¡Un NodoSimple contiene un NodoSimple!
 *    }
 *
 *    Esto parece recursivo, ¿verdad? Es la base de estructuras recursivas.
 *    No hay problema porque cada nodo es un objeto SEPARADO en memoria.
 *
 * 2. DIFERENCIA CON ARRAYS:
 *
 *    ARRAY:
 *    [10][20][30][40][50] ← Bloque continuo en memoria
 *     ↑   ↑   ↑   ↑   ↑
 *     0   1   2   3   4   ← Índices directos
 *
 *    NODOS ENLAZADOS:
 *    [10|→] → [20|→] → [30|→] → [40|→] → [50|null]
 *    ↑
 *    primero
 *
 *    Los nodos pueden estar DISPERSOS en memoria.
 *    No hay índices directos - debes RECORRER para llegar a una posición.
 *
 * 3. VENTAJAS DE NODOS:
 *    ✓ Insertar al inicio es O(1) - instantáneo
 *    ✓ No necesitas definir tamaño máximo
 *    ✓ No hay desperdicio de memoria (solo usas lo que necesitas)
 *    ✓ Fácil eliminar elementos (solo cambias referencias)
 *
 * 4. DESVENTAJAS DE NODOS:
 *    ✗ Acceso por índice es O(n) - debes recorrer
 *    ✗ Más memoria por elemento (guardas dato + referencia)
 *    ✗ Más complejo de implementar
 *    ✗ No aprovechas cache locality (los datos están dispersos)
 *
 * COMPLEJIDAD TEMPORAL:
 *
 * Operación           | Array | Nodos Enlazados
 * --------------------|-------|----------------
 * Acceso por índice   | O(1)  | O(n)
 * Insertar al inicio  | O(n)  | O(1) ← ¡Mucho mejor!
 * Insertar al final   | O(1)  | O(n)
 * Buscar elemento     | O(n)  | O(n)
 * Eliminar primero    | O(n)  | O(1) ← ¡Mucho mejor!
 *
 * VISUALIZACIÓN DETALLADA:
 *
 * agregarAlInicio(10):
 *   primero = null
 *   ↓
 *   primero → [10|null]
 *
 * agregarAlInicio(20):
 *   primero → [10|null]
 *   ↓
 *   primero → [20|→] → [10|null]
 *
 * agregarAlFinal(30):
 *   primero → [20|→] → [10|null]
 *   ↓
 *   primero → [20|→] → [10|→] → [30|null]
 *
 * eliminarPrimero():
 *   primero → [20|→] → [10|→] → [30|null]
 *   ↓
 *   primero → [10|→] → [30|null]  (el 20 queda sin referencias → garbage collected)
 *
 * CASOS DE USO EN EL MUNDO REAL:
 *
 * 1. HISTORIAL DE NAVEGADOR:
 *    Cada página visitada es un nodo que apunta a la anterior.
 *    El botón "Atrás" simplemente sigue las referencias.
 *
 * 2. UNDO/REDO EN EDITORES:
 *    Cada acción es un nodo. Undo retrocede, Redo avanza.
 *
 * 3. PLAYLIST DE MÚSICA:
 *    Cada canción es un nodo que apunta a la siguiente.
 *    "Siguiente canción" = siguiente.getDato()
 *
 * 4. BLOCKCHAIN:
 *    ¡Cada bloque es un nodo que apunta al bloque anterior!
 *    Es literalmente una cadena de nodos.
 *
 * 5. SISTEMA DE ARCHIVOS:
 *    Los enlaces simbólicos son como nodos que apuntan a otros archivos.
 *
 * ESTRUCTURAS RELACIONADAS:
 *
 * 1. LISTA DOBLEMENTE ENLAZADA:
 *    Cada nodo tiene referencias a siguiente Y anterior:
 *    null ← [10|↔] ↔ [20|↔] ↔ [30|↔] → null
 *    Puedes recorrer en ambas direcciones.
 *
 * 2. LISTA CIRCULAR:
 *    El último nodo apunta al primero:
 *    [10|→] → [20|→] → [30|→] ┐
 *     ↑________________________┘
 *
 * 3. ÁRBOL BINARIO:
 *    Cada nodo tiene DOS referencias (izquierda y derecha):
 *            [10]
 *           /    \
 *        [5]      [15]
 *       /   \     /   \
 *     [3]  [7] [12]  [20]
 *
 * 4. GRAFO:
 *    Cada nodo puede tener MÚLTIPLES referencias a otros nodos.
 *    Como una red social: cada usuario conecta con sus amigos.
 *
 * ERROR COMÚN: NULL POINTER EXCEPTION
 *
 * Si intentas hacer:
 *   NodoSimple nodo = null;
 *   nodo.getDato(); // ¡CRASH! nodo es null
 *
 * SIEMPRE verifica:
 *   if (nodo != null) {
 *       nodo.getDato();
 *   }
 *
 * ERROR COMÚN 2: CICLOS INFINITOS
 *
 * Si accidentalmente creas un ciclo:
 *   nodo1.setSiguiente(nodo2);
 *   nodo2.setSiguiente(nodo1); // ¡Ciclo!
 *
 * Y luego intentas recorrer:
 *   while (actual != null) { // ¡Nunca será null! Loop infinito
 *       actual = actual.getSiguiente();
 *   }
 *
 * MEMORIA Y GARBAGE COLLECTION:
 *
 * Cuando eliminas un nodo (pierdes la referencia), Java automáticamente
 * libera esa memoria (garbage collection). Esto NO pasa en C/C++ donde
 * debes liberar manualmente (free/delete).
 *
 * SIGUIENTE PASO:
 *
 * ¡Felicitaciones! Ahora entiendes el concepto de Nodo.
 * En el próximo ejercicio, usarás nodos para implementar una
 * LISTA ENLAZADA completa, con todos los métodos que esperarías
 * de una estructura de datos profesional.
 *
 * La lista enlazada es la base para entender:
 * - LinkedList de Java Collections
 * - Árboles binarios
 * - Grafos
 * - Algoritmos avanzados
 */
