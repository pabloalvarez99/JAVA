/*
 * ========================================
 * EJERCICIO 36: Collections Avanzadas - TreeMap, PriorityQueue, Deque
 * DIFICULTAD: ⭐⭐⭐⭐⭐⭐⭐⭐⭐⭐ (Experto)
 * ========================================
 *
 * OBJETIVO:
 * Dominar colecciones avanzadas de Java: TreeMap (mapa ordenado),
 * PriorityQueue (cola de prioridad) y Deque (cola de doble extremo)
 *
 * ========================================
 * TREEMAP - MAPA ORDENADO
 * ========================================
 *
 * CONCEPTO CLAVE:
 * TreeMap es un Map que mantiene sus keys ORDENADOS automáticamente.
 * Internamente usa un Red-Black Tree (árbol binario de búsqueda balanceado).
 *
 * CARACTERÍSTICAS:
 * ✓ Keys siempre ordenados (orden natural o Comparator)
 * ✓ NO permite keys null
 * ✓ Permite values null
 * ✓ Operaciones O(log n): get, put, remove
 * ✓ Thread-unsafe (usar Collections.synchronizedMap si necesario)
 *
 * COMPARACIÓN:
 * | Operación | HashMap | TreeMap |
 * |-----------|---------|---------|
 * | get/put   | O(1)    | O(log n)|
 * | Ordenado  | NO      | SÍ      |
 * | Null key  | 1 null  | NO      |
 *
 * CUÁNDO USAR:
 * ✓ Necesitas keys ordenados
 * ✓ Range queries (subMap, headMap, tailMap)
 * ✓ Primero/último elemento frecuentemente
 * ✗ Si el orden no importa (usa HashMap, más rápido)
 *
 * MÉTODOS ESPECIALES:
 * - firstKey() / lastKey(): primer/último key
 * - higherKey(key) / lowerKey(key): siguiente/anterior key
 * - subMap(from, to): rango de keys
 * - headMap(toKey): keys menores que toKey
 * - tailMap(fromKey): keys mayores o iguales que fromKey
 *
 * EJEMPLO:
 * TreeMap<Integer, String> map = new TreeMap<>();
 * map.put(3, "tres");
 * map.put(1, "uno");
 * map.put(2, "dos");
 * // Orden automático: {1=uno, 2=dos, 3=tres}
 *
 * ========================================
 * PRIORITYQUEUE - COLA DE PRIORIDAD
 * ========================================
 *
 * CONCEPTO CLAVE:
 * PriorityQueue es una cola donde los elementos se extraen según su
 * PRIORIDAD, no según el orden de inserción (FIFO).
 * Implementada con un heap (montículo).
 *
 * CARACTERÍSTICAS:
 * ✓ Orden por prioridad (natural o Comparator)
 * ✓ Elemento de mayor prioridad siempre al frente
 * ✓ NO permite elementos null
 * ✓ Operaciones O(log n): add, poll
 * ✓ peek() es O(1)
 * ✓ Thread-unsafe
 *
 * HEAP (MIN-HEAP por defecto):
 * Árbol binario donde cada padre es MENOR que sus hijos
 *
 *       1
 *      / \
 *     3   2
 *    / \
 *   4   5
 *
 * ORDEN NATURAL (números):
 * Menor valor = Mayor prioridad (min-heap)
 *
 * CUÁNDO USAR:
 * ✓ Necesitas procesar elementos por prioridad
 * ✓ Algoritmos: Dijkstra, A*, Huffman coding
 * ✓ Task scheduling (tareas con prioridades)
 * ✓ Encontrar K elementos más grandes/pequeños
 * ✗ Si necesitas orden FIFO simple (usa Queue)
 * ✗ Si necesitas acceso aleatorio (usa List)
 *
 * MÉTODOS:
 * - add(e) / offer(e): agregar elemento
 * - poll(): remover y retornar elemento de mayor prioridad
 * - peek(): ver elemento de mayor prioridad sin remover
 * - size(): tamaño
 *
 * EJEMPLO:
 * PriorityQueue<Integer> pq = new PriorityQueue<>();
 * pq.add(5);
 * pq.add(1);
 * pq.add(3);
 * pq.poll(); // Retorna 1 (menor valor = mayor prioridad)
 * pq.poll(); // Retorna 3
 * pq.poll(); // Retorna 5
 *
 * ========================================
 * DEQUE - DOUBLE-ENDED QUEUE
 * ========================================
 *
 * CONCEPTO CLAVE:
 * Deque (se pronuncia "deck") es una cola donde puedes agregar/remover
 * elementos desde AMBOS extremos (inicio y fin).
 *
 * CARACTERÍSTICAS:
 * ✓ Insertar/remover en ambos extremos: O(1)
 * ✓ Puede usarse como Stack (LIFO) o Queue (FIFO)
 * ✓ Implementación: ArrayDeque o LinkedList
 * ✓ ArrayDeque es más eficiente que LinkedList
 * ✓ NO permite elementos null (ArrayDeque)
 *
 * USOS:
 * 1. Como Queue (FIFO): addLast() + removeFirst()
 * 2. Como Stack (LIFO): addFirst() + removeFirst()
 * 3. Como Deque: operaciones en ambos extremos
 *
 * COMPARACIÓN ArrayDeque vs LinkedList:
 * ArrayDeque:
 * ✓ Más rápido (array circular)
 * ✓ Menos memoria (no tiene nodos)
 * ✗ No permite null
 *
 * LinkedList:
 * ✓ Permite null
 * ✗ Más lento (overhead de nodos)
 * ✗ Más memoria
 *
 * MÉTODOS (dos convenciones):
 * First/Last (lanza excepción):
 * - addFirst(e) / addLast(e)
 * - removeFirst() / removeLast()
 * - getFirst() / getLast()
 *
 * Offer/Poll (retorna null/false):
 * - offerFirst(e) / offerLast(e)
 * - pollFirst() / pollLast()
 * - peekFirst() / peekLast()
 *
 * COMO STACK:
 * push(e) → addFirst(e)
 * pop() → removeFirst()
 * peek() → peekFirst()
 *
 * EJEMPLO:
 * Deque<String> deque = new ArrayDeque<>();
 * deque.addFirst("A");  // [A]
 * deque.addLast("B");   // [A, B]
 * deque.addFirst("C");  // [C, A, B]
 * deque.pollLast();     // Retorna "B" → [C, A]
 *
 * INSTRUCCIONES:
 * 1. Implementa ejemplos con TreeMap:
 *    - Mapa de estudiantes ordenado por nombre
 *    - Range queries (subMap, headMap, tailMap)
 *    - Navegación (firstKey, lastKey, higherKey, lowerKey)
 *
 * 2. Implementa sistema de tareas con PriorityQueue:
 *    - Tareas con diferentes prioridades
 *    - Procesar tareas por prioridad
 *    - Comparator personalizado
 *
 * 3. Implementa ejemplos con Deque:
 *    - Uso como Queue (FIFO)
 *    - Uso como Stack (LIFO)
 *    - Operaciones en ambos extremos
 *
 * 4. Implementa aplicación práctica que use las tres colecciones
 *
 * SALIDA ESPERADA:
 * === COLLECTIONS AVANZADAS - TREEMAP, PRIORITYQUEUE, DEQUE ===
 *
 * === TREEMAP: MAPA ORDENADO ===
 * Insertando estudiantes en orden aleatorio...
 * Agregado: Juan (85.5)
 * Agregado: María (92.0)
 * Agregado: Carlos (78.5)
 * Agregado: Ana (95.0)
 *
 * TreeMap (ordenado por nombre):
 * Ana → 95.0
 * Carlos → 78.5
 * Juan → 85.5
 * María → 92.0
 *
 * Navegación:
 * Primer estudiante: Ana
 * Último estudiante: María
 * Después de Carlos: Juan
 * Antes de María: Juan
 *
 * Range queries:
 * Estudiantes desde B hasta K:
 * Carlos → 78.5
 * Juan → 85.5
 *
 * === PRIORITYQUEUE: COLA DE PRIORIDAD ===
 * Sistema de tareas con prioridades...
 *
 * Agregando tareas:
 * - Tarea: Bug crítico (Prioridad: ALTA)
 * - Tarea: Documentación (Prioridad: BAJA)
 * - Tarea: Feature nuevo (Prioridad: MEDIA)
 * - Tarea: Optimización (Prioridad: MEDIA)
 *
 * Procesando tareas por prioridad:
 * 1. [ALTA] Bug crítico
 * 2. [MEDIA] Feature nuevo
 * 3. [MEDIA] Optimización
 * 4. [BAJA] Documentación
 *
 * === DEQUE: COLA DE DOBLE EXTREMO ===
 * Operaciones básicas:
 * Agregar al inicio: [C, B, A]
 * Agregar al final: [C, B, A, D, E]
 * Remover del inicio: C → [B, A, D, E]
 * Remover del final: E → [B, A, D]
 *
 * Uso como Stack (LIFO):
 * Push: 1, 2, 3
 * Pop: 3, 2, 1
 *
 * Uso como Queue (FIFO):
 * Enqueue: A, B, C
 * Dequeue: A, B, C
 *
 * === APLICACIÓN PRÁCTICA: SISTEMA DE HOSPITAL ===
 * 📋 Sistema de emergencias médicas
 *
 * Pacientes registrados:
 * ✓ Juan (Prioridad: MEDIA)
 * ✓ María (Prioridad: ALTA)
 * ✓ Carlos (Prioridad: BAJA)
 * ✓ Ana (Prioridad: ALTA)
 *
 * Atendiendo pacientes por prioridad:
 * 🏥 Atendiendo: María (ALTA)
 * 🏥 Atendiendo: Ana (ALTA)
 * 🏥 Atendiendo: Juan (MEDIA)
 * 🏥 Atendiendo: Carlos (BAJA)
 *
 * Historial de atención (Deque):
 * 1. María
 * 2. Ana
 * 3. Juan
 * 4. Carlos
 *
 * CONCEPTOS NUEVOS:
 * - TreeMap: Map ordenado con Red-Black Tree
 * - NavigableMap: Interface con métodos de navegación
 * - PriorityQueue: Cola de prioridad con heap
 * - Heap: Árbol binario especial (min-heap/max-heap)
 * - Deque: Cola de doble extremo
 * - ArrayDeque: Implementación eficiente de Deque
 * - Range queries: Consultas de rango
 * - firstKey/lastKey: Primer/último elemento
 * - higherKey/lowerKey: Navegación en TreeMap
 * - Comparator personalizado: Orden no natural
 *
 * COMPARACIÓN DE COLECCIONES:
 *
 * Map implementations:
 * - HashMap: O(1), desordenado, permite null key
 * - TreeMap: O(log n), ordenado, NO null key
 * - LinkedHashMap: O(1), orden de inserción
 *
 * Queue implementations:
 * - LinkedList: FIFO simple
 * - PriorityQueue: Por prioridad
 * - ArrayDeque: Doble extremo
 *
 * CUÁNDO USAR CADA UNA:
 *
 * TreeMap:
 * ✓ Necesitas keys ordenados
 * ✓ Range queries
 * ✓ Navegación (primero, último, siguiente)
 *
 * PriorityQueue:
 * ✓ Procesar elementos por prioridad
 * ✓ Algoritmos de grafos (Dijkstra)
 * ✓ Scheduling de tareas
 *
 * Deque:
 * ✓ Stack (en lugar de Stack legacy)
 * ✓ Queue con operaciones en ambos extremos
 * ✓ Sliding window algorithms
 *
 */

import java.util.*;

// ========================================
// CLASE TAREA (Para PriorityQueue)
// ========================================

enum Prioridad {
    BAJA(3), MEDIA(2), ALTA(1);

    private int nivel;

    Prioridad(int nivel) {
        this.nivel = nivel;
    }

    public int getNivel() {
        return nivel;
    }
}

// TODO: Implementa clase Tarea con Comparable
class Tarea implements Comparable<Tarea> {
    private String descripcion;
    private Prioridad prioridad;

    public Tarea(String descripcion, Prioridad prioridad) {
        this.descripcion = descripcion;
        this.prioridad = prioridad;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public Prioridad getPrioridad() {
        return prioridad;
    }

    @Override
    public int compareTo(Tarea otra) {
        // Comparar por nivel de prioridad (menor número = mayor prioridad)
        return Integer.compare(this.prioridad.getNivel(), otra.prioridad.getNivel());
    }

    @Override
    public String toString() {
        return String.format("[%s] %s", prioridad, descripcion);
    }
}

// ========================================
// CLASE PACIENTE (Para sistema de hospital)
// ========================================

class Paciente implements Comparable<Paciente> {
    private String nombre;
    private Prioridad prioridad;
    private int numeroLlegada; // Para desempate

    private static int contadorLlegada = 0;

    public Paciente(String nombre, Prioridad prioridad) {
        this.nombre = nombre;
        this.prioridad = prioridad;
        this.numeroLlegada = contadorLlegada++;
    }

    public String getNombre() {
        return nombre;
    }

    public Prioridad getPrioridad() {
        return prioridad;
    }

    @Override
    public int compareTo(Paciente otro) {
        // Primero por prioridad
        int compPrioridad = this.prioridad.getNivel() - otro.prioridad.getNivel();
        if (compPrioridad != 0) {
            return compPrioridad;
        }
        // Si misma prioridad, por orden de llegada
        return this.numeroLlegada - otro.numeroLlegada;
    }

    @Override
    public String toString() {
        return String.format("%s (Prioridad: %s)", nombre, prioridad);
    }
}

// ========================================
// CLASE PRINCIPAL
// ========================================

public class Ejercicio36 {
    public static void main(String[] args) {
        System.out.println("=== COLLECTIONS AVANZADAS - TREEMAP, PRIORITYQUEUE, DEQUE ===\n");

        // ========================================
        // TREEMAP: MAPA ORDENADO
        // ========================================
        System.out.println("=== TREEMAP: MAPA ORDENADO ===");
        System.out.println("Insertando estudiantes en orden aleatorio...");

        TreeMap<String, Double> estudiantes = new TreeMap<>();
        estudiantes.put("Juan", 85.5);
        System.out.println("Agregado: Juan (85.5)");
        estudiantes.put("María", 92.0);
        System.out.println("Agregado: María (92.0)");
        estudiantes.put("Carlos", 78.5);
        System.out.println("Agregado: Carlos (78.5)");
        estudiantes.put("Ana", 95.0);
        System.out.println("Agregado: Ana (95.0)");

        System.out.println("\nTreeMap (ordenado por nombre):");
        for (Map.Entry<String, Double> entry : estudiantes.entrySet()) {
            System.out.println(entry.getKey() + " → " + entry.getValue());
        }

        // Navegación
        System.out.println("\nNavegación:");
        System.out.println("Primer estudiante: " + estudiantes.firstKey());
        System.out.println("Último estudiante: " + estudiantes.lastKey());
        System.out.println("Después de Carlos: " + estudiantes.higherKey("Carlos"));
        System.out.println("Antes de María: " + estudiantes.lowerKey("María"));

        // Range queries
        System.out.println("\nRange queries:");
        System.out.println("Estudiantes desde B hasta K:");
        Map<String, Double> rango = estudiantes.subMap("B", "K");
        for (Map.Entry<String, Double> entry : rango.entrySet()) {
            System.out.println(entry.getKey() + " → " + entry.getValue());
        }

        System.out.println();

        // ========================================
        // PRIORITYQUEUE: COLA DE PRIORIDAD
        // ========================================
        System.out.println("=== PRIORITYQUEUE: COLA DE PRIORIDAD ===");
        System.out.println("Sistema de tareas con prioridades...\n");

        PriorityQueue<Tarea> tareas = new PriorityQueue<>();

        System.out.println("Agregando tareas:");
        tareas.add(new Tarea("Bug crítico", Prioridad.ALTA));
        System.out.println("- Tarea: Bug crítico (Prioridad: ALTA)");

        tareas.add(new Tarea("Documentación", Prioridad.BAJA));
        System.out.println("- Tarea: Documentación (Prioridad: BAJA)");

        tareas.add(new Tarea("Feature nuevo", Prioridad.MEDIA));
        System.out.println("- Tarea: Feature nuevo (Prioridad: MEDIA)");

        tareas.add(new Tarea("Optimización", Prioridad.MEDIA));
        System.out.println("- Tarea: Optimización (Prioridad: MEDIA)");

        System.out.println("\nProcesando tareas por prioridad:");
        int contador = 1;
        while (!tareas.isEmpty()) {
            Tarea tarea = tareas.poll();
            System.out.println(contador++ + ". " + tarea);
        }

        System.out.println();

        // ========================================
        // PRIORITYQUEUE: Top K elementos
        // ========================================
        System.out.println("=== PRIORITYQUEUE: TOP 3 NÚMEROS MÁS GRANDES ===");
        int[] numeros = {5, 2, 8, 1, 9, 3, 7, 4, 6};

        // Min-heap de tamaño 3 para encontrar los 3 más grandes
        PriorityQueue<Integer> topK = new PriorityQueue<>(3);

        System.out.print("Array: ");
        for (int num : numeros) {
            System.out.print(num + " ");

            topK.offer(num);
            if (topK.size() > 3) {
                topK.poll(); // Remover el más pequeño
            }
        }

        System.out.println("\n\nTop 3 números más grandes:");
        List<Integer> resultado = new ArrayList<>(topK);
        Collections.sort(resultado, Collections.reverseOrder());
        for (int i = 0; i < resultado.size(); i++) {
            System.out.println((i + 1) + ". " + resultado.get(i));
        }

        System.out.println();

        // ========================================
        // DEQUE: COLA DE DOBLE EXTREMO
        // ========================================
        System.out.println("=== DEQUE: COLA DE DOBLE EXTREMO ===");
        System.out.println("Operaciones básicas:");

        Deque<String> deque = new ArrayDeque<>();

        // Agregar en ambos extremos
        deque.addLast("A");
        deque.addLast("B");
        deque.addFirst("C");
        System.out.print("Agregar al inicio: [");
        System.out.print(String.join(", ", deque));
        System.out.println("]");

        deque.addLast("D");
        deque.addLast("E");
        System.out.print("Agregar al final: [");
        System.out.print(String.join(", ", deque));
        System.out.println("]");

        // Remover en ambos extremos
        String primero = deque.removeFirst();
        System.out.print("Remover del inicio: " + primero + " → [");
        System.out.print(String.join(", ", deque));
        System.out.println("]");

        String ultimo = deque.removeLast();
        System.out.print("Remover del final: " + ultimo + " → [");
        System.out.print(String.join(", ", deque));
        System.out.println("]");

        System.out.println();

        // ========================================
        // DEQUE COMO STACK
        // ========================================
        System.out.println("Uso como Stack (LIFO):");
        Deque<Integer> stack = new ArrayDeque<>();

        System.out.print("Push: ");
        for (int i = 1; i <= 3; i++) {
            stack.push(i);
            System.out.print(i + (i < 3 ? ", " : ""));
        }
        System.out.println();

        System.out.print("Pop: ");
        while (!stack.isEmpty()) {
            System.out.print(stack.pop());
            if (!stack.isEmpty()) System.out.print(", ");
        }
        System.out.println("\n");

        // ========================================
        // DEQUE COMO QUEUE
        // ========================================
        System.out.println("Uso como Queue (FIFO):");
        Deque<String> queue = new ArrayDeque<>();

        System.out.print("Enqueue: ");
        String[] elementos = {"A", "B", "C"};
        for (String elem : elementos) {
            queue.offerLast(elem);
            System.out.print(elem + (elem.equals("C") ? "" : ", "));
        }
        System.out.println();

        System.out.print("Dequeue: ");
        while (!queue.isEmpty()) {
            System.out.print(queue.pollFirst());
            if (!queue.isEmpty()) System.out.print(", ");
        }
        System.out.println("\n");

        // ========================================
        // APLICACIÓN PRÁCTICA: SISTEMA DE HOSPITAL
        // ========================================
        System.out.println("=== APLICACIÓN PRÁCTICA: SISTEMA DE HOSPITAL ===");
        System.out.println("📋 Sistema de emergencias médicas\n");

        // PriorityQueue para pacientes (por prioridad)
        PriorityQueue<Paciente> colaEmergencia = new PriorityQueue<>();

        // TreeMap para registro de pacientes (ordenado por nombre)
        TreeMap<String, String> registroPacientes = new TreeMap<>();

        // Deque para historial de atención
        Deque<String> historialAtencion = new ArrayDeque<>();

        // Registrar pacientes
        System.out.println("Pacientes registrados:");
        Paciente[] pacientes = {
            new Paciente("Juan", Prioridad.MEDIA),
            new Paciente("María", Prioridad.ALTA),
            new Paciente("Carlos", Prioridad.BAJA),
            new Paciente("Ana", Prioridad.ALTA)
        };

        for (Paciente p : pacientes) {
            colaEmergencia.offer(p);
            registroPacientes.put(p.getNombre(), p.getPrioridad().toString());
            System.out.println("✓ " + p);
        }

        // Atender pacientes por prioridad
        System.out.println("\nAtendiendo pacientes por prioridad:");
        while (!colaEmergencia.isEmpty()) {
            Paciente p = colaEmergencia.poll();
            System.out.println("🏥 Atendiendo: " + p.getNombre() + " (" + p.getPrioridad() + ")");
            historialAtencion.addLast(p.getNombre());
        }

        // Mostrar historial
        System.out.println("\nHistorial de atención (Deque):");
        int i = 1;
        for (String nombre : historialAtencion) {
            System.out.println(i++ + ". " + nombre);
        }

        System.out.println("\nRegistro completo (TreeMap ordenado):");
        for (Map.Entry<String, String> entry : registroPacientes.entrySet()) {
            System.out.println("- " + entry.getKey() + ": " + entry.getValue());
        }

        // REFLEXIÓN FINAL:
        // ¿Por qué usar collections avanzadas?
        // ✓ TreeMap: cuando necesitas keys ordenados automáticamente
        // ✓ PriorityQueue: para procesar por prioridad eficientemente
        // ✓ Deque: para Stack moderno o Queue con doble extremo
        //
        // EN LA VIDA REAL:
        //
        // TREEMAP:
        // - Diccionarios ordenados
        // - Índices de bases de datos
        // - Caché con orden temporal
        // - Sistemas de archivos (directorios ordenados)
        // - Gestión de configuraciones ordenadas
        //
        // PRIORITYQUEUE:
        // - Algoritmos de grafos (Dijkstra, A*)
        // - Task scheduling (cron jobs)
        // - Sistemas de emergencias médicas
        // - Event-driven simulation
        // - Huffman coding (compresión)
        // - Operating systems (process scheduling)
        //
        // DEQUE:
        // - Implementar Stack (reemplaza java.util.Stack)
        // - Algoritmos BFS (breadth-first search)
        // - Sliding window algorithms
        // - Undo/Redo functionality
        // - Browser history (forward/back)
        //
        // COMPLEJIDAD:
        //
        // TreeMap:
        // - get/put/remove: O(log n)
        // - firstKey/lastKey: O(1)
        // - Basado en Red-Black Tree
        //
        // PriorityQueue:
        // - offer/add: O(log n)
        // - poll/remove: O(log n)
        // - peek: O(1)
        // - Basado en binary heap
        //
        // ArrayDeque:
        // - addFirst/addLast: O(1) amortizado
        // - removeFirst/removeLast: O(1)
        // - get(index): O(1)
        // - Basado en array circular
        //
        // HEAP (detrás de PriorityQueue):
        //
        // MIN-HEAP (default):
        // Padre < Hijos (elemento más pequeño al tope)
        //
        // MAX-HEAP:
        // Padre > Hijos (elemento más grande al tope)
        // PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        //
        // PROPIEDADES DEL HEAP:
        // 1. Complete binary tree (todos los niveles llenos excepto último)
        // 2. Heap property (min-heap o max-heap)
        // 3. Implementación eficiente con array
        //
        // TREEMAP - MÉTODOS AVANZADOS:
        //
        // ceilingKey(key): Menor key >= key dado
        // floorKey(key): Mayor key <= key dado
        // higherKey(key): Menor key > key dado
        // lowerKey(key): Mayor key < key dado
        //
        // subMap(from, to): Vista de rango [from, to)
        // headMap(toKey): Vista de keys < toKey
        // tailMap(fromKey): Vista de keys >= fromKey
        //
        // descendingMap(): Vista en orden inverso
        //
        // DEQUE - CASOS DE USO:
        //
        // 1. STACK (LIFO):
        //    push(), pop(), peek()
        //
        // 2. QUEUE (FIFO):
        //    offerLast(), pollFirst(), peekFirst()
        //
        // 3. DEQUE (ambos extremos):
        //    offerFirst/Last(), pollFirst/Last()
        //
        // 4. SLIDING WINDOW:
        //    Algoritmo que mantiene ventana de elementos
        //
        // THREAD-SAFETY:
        // Ninguna de estas colecciones es thread-safe por defecto
        //
        // Para thread-safety:
        // - ConcurrentSkipListMap (similar a TreeMap)
        // - PriorityBlockingQueue (thread-safe PriorityQueue)
        // - ConcurrentLinkedDeque (thread-safe Deque)
        //
        // O usar:
        // Map<K,V> syncMap = Collections.synchronizedMap(new TreeMap<>());
        //
        // COMPARACIÓN CON ALTERNATIVAS:
        //
        // TreeMap vs HashMap:
        // TreeMap: O(log n), ordenado
        // HashMap: O(1), desordenado
        //
        // PriorityQueue vs TreeSet:
        // PriorityQueue: duplicados permitidos, heap
        // TreeSet: sin duplicados, Red-Black Tree
        //
        // ArrayDeque vs LinkedList:
        // ArrayDeque: más rápido, no permite null
        // LinkedList: permite null, más overhead
        //
        // ArrayDeque vs Stack:
        // ArrayDeque: moderno, más rápido
        // Stack: legacy, synchronized (más lento)
        //
        // MEJORES PRÁCTICAS:
        // ✓ Usa TreeMap cuando necesites orden de keys
        // ✓ Usa PriorityQueue para algoritmos con prioridades
        // ✓ Usa ArrayDeque en lugar de Stack
        // ✓ Define Comparator cuando el orden natural no es suficiente
        // ✓ No asumas orden de iteración en PriorityQueue (solo poll() garantiza orden)
        // ✓ Considera thread-safety en entornos concurrentes
        //
        // ERRORES COMUNES:
        // ✗ Asumir que PriorityQueue itera en orden (NO lo hace)
        // ✗ Usar LinkedList como Deque (ArrayDeque es mejor)
        // ✗ Usar Stack legacy (usa ArrayDeque.push/pop)
        // ✗ Insertar null en TreeMap, PriorityQueue, ArrayDeque
        // ✗ No considerar thread-safety en aplicaciones concurrentes
        //
        // CONCLUSIÓN:
        // TreeMap, PriorityQueue y Deque son colecciones avanzadas
        // que resuelven problemas específicos eficientemente.
        // Conocerlas te permite elegir la estructura correcta para cada caso.
    }
}
