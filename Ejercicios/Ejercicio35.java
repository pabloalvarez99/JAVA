/*
 * ========================================
 * EJERCICIO 35: Threads Básicos - Programación Concurrente
 * DIFICULTAD: ⭐⭐⭐⭐⭐⭐⭐⭐⭐⭐ (Experto)
 * ========================================
 *
 * OBJETIVO:
 * Introducción a la programación concurrente en Java: crear, ejecutar y
 * sincronizar threads (hilos) para ejecutar tareas en paralelo
 *
 * CONCEPTO CLAVE:
 * Un THREAD (hilo) es una unidad de ejecución independiente dentro de un
 * programa. Java permite ejecutar múltiples threads simultáneamente para:
 * - Aprovechar múltiples núcleos del CPU
 * - Realizar operaciones en background
 * - Mejorar la responsividad de aplicaciones
 * - Procesar datos en paralelo
 *
 * ========================================
 * THREAD vs PROCESO
 * ========================================
 *
 * PROCESO:
 * - Programa en ejecución completo
 * - Memoria separada
 * - Recursos independientes
 * - Pesado (más overhead)
 *
 * THREAD:
 * - Unidad de ejecución dentro de un proceso
 * - Comparte memoria con otros threads del proceso
 * - Ligero (menos overhead)
 * - Más rápido de crear/destruir
 *
 * ANALOGÍA:
 * Proceso = Restaurante completo
 * Thread = Mesero individual
 * Varios meseros (threads) trabajan en el mismo restaurante (proceso)
 *
 * ========================================
 * CREAR THREADS EN JAVA
 * ========================================
 *
 * MÉTODO 1: Extender Thread
 * class MiThread extends Thread {
 *     @Override
 *     public void run() {
 *         // Código que ejecuta el thread
 *     }
 * }
 *
 * // Usar:
 * MiThread t = new MiThread();
 * t.start(); // Inicia el thread (llama run() en nuevo thread)
 *
 * MÉTODO 2: Implementar Runnable (PREFERIDO)
 * class MiTarea implements Runnable {
 *     @Override
 *     public void run() {
 *         // Código que ejecuta el thread
 *     }
 * }
 *
 * // Usar:
 * Thread t = new Thread(new MiTarea());
 * t.start();
 *
 * MÉTODO 3: Lambda (Java 8+)
 * Thread t = new Thread(() -> {
 *     // Código aquí
 * });
 * t.start();
 *
 * ¿Por qué Runnable es mejor?
 * ✓ Java no permite herencia múltiple, Runnable es interface
 * ✓ Separa tarea de thread (mejor diseño)
 * ✓ Permite usar con ExecutorService
 *
 * ========================================
 * CICLO DE VIDA DE UN THREAD
 * ========================================
 *
 * 1. NEW: Thread creado pero no iniciado
 *    Thread t = new Thread(runnable);
 *
 * 2. RUNNABLE: Thread ejecutándose o listo para ejecutar
 *    t.start();
 *
 * 3. BLOCKED/WAITING: Thread esperando (lock, sleep, wait)
 *    Thread.sleep(1000);
 *
 * 4. TERMINATED: Thread terminó su ejecución
 *    run() completado
 *
 * ========================================
 * MÉTODOS IMPORTANTES
 * ========================================
 *
 * start(): Inicia el thread (crea nuevo thread de ejecución)
 * run(): Método que contiene el código a ejecutar
 * sleep(ms): Pausa el thread por X milisegundos
 * join(): Espera a que el thread termine
 * interrupt(): Interrumpe el thread
 * isAlive(): Verifica si el thread está ejecutándose
 * getName()/setName(): Obtener/establecer nombre del thread
 *
 * IMPORTANTE:
 * ✓ Siempre llama start(), NO run()
 * ✓ start() crea nuevo thread y llama run()
 * ✓ run() ejecuta en el thread actual (no crea thread nuevo)
 *
 * ========================================
 * SINCRONIZACIÓN
 * ========================================
 *
 * PROBLEMA: RACE CONDITION
 * Múltiples threads accediendo al mismo recurso pueden causar
 * inconsistencias si no se sincronizan.
 *
 * Ejemplo sin sincronización:
 * class Contador {
 *     int count = 0;
 *     void incrementar() {
 *         count++; // NO thread-safe
 *     }
 * }
 *
 * SOLUCIÓN: synchronized
 * synchronized void incrementar() {
 *     count++; // Thread-safe
 * }
 *
 * O bloque sincronizado:
 * void incrementar() {
 *     synchronized(this) {
 *         count++;
 *     }
 * }
 *
 * synchronized garantiza que solo UN thread ejecute el código a la vez.
 *
 * ========================================
 * SLEEP vs WAIT vs JOIN
 * ========================================
 *
 * SLEEP: Pausa el thread por X tiempo
 * Thread.sleep(1000); // 1 segundo
 * - NO libera el lock
 * - Thread vuelve a RUNNABLE automáticamente
 *
 * WAIT: Espera hasta que otro thread lo notifique
 * synchronized(obj) {
 *     obj.wait();
 * }
 * - LIBERA el lock
 * - Necesita notify() o notifyAll()
 *
 * JOIN: Espera a que otro thread termine
 * thread.join();
 * - Thread actual espera a que 'thread' termine
 *
 * ========================================
 * DAEMON THREADS
 * ========================================
 *
 * DAEMON THREAD:
 * - Thread de "servicio" en background
 * - JVM termina aunque daemon threads estén ejecutándose
 * - Ejemplo: Garbage Collector
 *
 * thread.setDaemon(true); // ANTES de start()
 *
 * USER THREAD (normal):
 * - JVM espera a que terminen antes de salir
 *
 * INSTRUCCIONES:
 * 1. Crea threads usando Thread y Runnable
 * 2. Implementa ejemplo con múltiples threads ejecutándose
 * 3. Demuestra sleep(), join()
 * 4. Implementa clase thread-safe con synchronized
 * 5. Demuestra race condition y su solución
 * 6. Implementa ejemplo práctico: Descarga de archivos paralela
 *
 * SALIDA ESPERADA:
 * === THREADS BÁSICOS - PROGRAMACIÓN CONCURRENTE ===
 *
 * === CREACIÓN DE THREADS ===
 * Thread principal: main
 *
 * Iniciando threads...
 * [Thread-1] Iniciado
 * [Thread-2] Iniciado
 * [Thread-3] Iniciado
 * [Thread-1] Ejecutando tarea 1/5
 * [Thread-2] Ejecutando tarea 1/5
 * [Thread-3] Ejecutando tarea 1/5
 * [Thread-1] Ejecutando tarea 2/5
 * [Thread-2] Ejecutando tarea 2/5
 * [Thread-3] Ejecutando tarea 2/5
 * ...
 * [Thread-1] Completado
 * [Thread-2] Completado
 * [Thread-3] Completado
 *
 * === RACE CONDITION (SIN SINCRONIZACIÓN) ===
 * Iniciando 10 threads para incrementar contador...
 * Valor final esperado: 10000
 * Valor final obtenido: 9847 ✗ (INCORRECTO - race condition)
 *
 * === CON SINCRONIZACIÓN ===
 * Iniciando 10 threads para incrementar contador sincronizado...
 * Valor final esperado: 10000
 * Valor final obtenido: 10000 ✓ (CORRECTO)
 *
 * === MÉTODO JOIN ===
 * Thread principal esperando a trabajadores...
 * [Trabajador-1] Trabajando...
 * [Trabajador-2] Trabajando...
 * [Trabajador-1] Terminado
 * [Trabajador-2] Terminado
 * Todos los trabajadores terminaron ✓
 *
 * === DESCARGA PARALELA DE ARCHIVOS ===
 * Descargando 5 archivos en paralelo...
 * [Descarga-1] Descargando archivo1.zip... 0%
 * [Descarga-2] Descargando archivo2.zip... 0%
 * [Descarga-3] Descargando archivo3.zip... 0%
 * [Descarga-1] Descargando archivo1.zip... 25%
 * [Descarga-2] Descargando archivo2.zip... 25%
 * ...
 * [Descarga-1] ✓ archivo1.zip completado
 * [Descarga-2] ✓ archivo2.zip completado
 * [Descarga-3] ✓ archivo3.zip completado
 *
 * Todas las descargas completadas en 3.2 segundos
 *
 * CONCEPTOS NUEVOS:
 * - Thread (hilo): Unidad de ejecución independiente
 * - Runnable: Interface para tareas ejecutables
 * - Concurrency: Ejecución simultánea
 * - Parallelism: Múltiples CPUs ejecutando simultáneamente
 * - Race condition: Condición de carrera (bug de concurrencia)
 * - synchronized: Sincronización de threads
 * - Thread-safe: Seguro para múltiples threads
 * - Lock: Candado para sincronización
 * - Daemon thread: Thread de background
 * - join(): Esperar a que thread termine
 * - sleep(): Pausar thread
 *
 * VENTAJAS DE THREADS:
 * ✓ Aprovechar múltiples núcleos de CPU
 * ✓ Mejor responsividad (UI no se congela)
 * ✓ Operaciones en background
 * ✓ Procesamiento paralelo
 * ✓ Mejor rendimiento
 *
 * DESVENTAJAS:
 * ✗ Complejidad (bugs difíciles de reproducir)
 * ✗ Race conditions
 * ✗ Deadlocks (bloqueos mutuos)
 * ✗ Difícil de depurar
 * ✗ Overhead de sincronización
 *
 * CUÁNDO USAR THREADS:
 * ✓ Operaciones I/O (red, archivos)
 * ✓ Procesamiento de múltiples tareas
 * ✓ Interfaces gráficas (no bloquear UI)
 * ✓ Servidores (atender múltiples clientes)
 * ✗ Operaciones simples secuenciales
 * ✗ Si la complejidad no vale la pena
 *
 * PISTAS:
 * - Implementa Runnable en lugar de extender Thread
 * - Usa synchronized para evitar race conditions
 * - join() espera a que el thread termine
 * - sleep() pausa el thread actual
 * - Siempre llama start(), no run()
 */

import java.util.*;

// ========================================
// EJEMPLO 1: Thread simple
// ========================================

// TODO: Implementa Runnable para tarea simple
class TareaSimple implements Runnable {
    private String nombre;
    private int numTareas;

    public TareaSimple(String nombre, int numTareas) {
        this.nombre = nombre;
        this.numTareas = numTareas;
    }

    @Override
    public void run() {
        System.out.println("[" + nombre + "] Iniciado");

        for (int i = 1; i <= numTareas; i++) {
            System.out.println("[" + nombre + "] Ejecutando tarea " + i + "/" + numTareas);

            try {
                Thread.sleep(500); // Simular trabajo
            } catch (InterruptedException e) {
                System.out.println("[" + nombre + "] Interrumpido");
                return;
            }
        }

        System.out.println("[" + nombre + "] Completado");
    }
}

// ========================================
// EJEMPLO 2: Contador sin sincronización (race condition)
// ========================================

// TODO: Contador NO thread-safe
class ContadorNoSeguro {
    private int count = 0;

    public void incrementar() {
        // Esta operación NO es atómica
        // Puede haber race condition
        count++;
    }

    public int getCount() {
        return count;
    }
}

// ========================================
// EJEMPLO 3: Contador con sincronización
// ========================================

// TODO: Contador thread-safe
class ContadorSeguro {
    private int count = 0;

    // synchronized garantiza que solo un thread ejecute a la vez
    public synchronized void incrementar() {
        count++;
    }

    public synchronized int getCount() {
        return count;
    }
}

// ========================================
// EJEMPLO 4: Trabajador con join
// ========================================

class Trabajador implements Runnable {
    private String nombre;

    public Trabajador(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public void run() {
        System.out.println("[" + nombre + "] Trabajando...");

        try {
            Thread.sleep(2000); // Simular trabajo
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("[" + nombre + "] Terminado");
    }
}

// ========================================
// EJEMPLO 5: Descarga de archivos
// ========================================

class DescargaArchivo implements Runnable {
    private String nombreArchivo;
    private int tamanoMB;

    public DescargaArchivo(String nombreArchivo, int tamanoMB) {
        this.nombreArchivo = nombreArchivo;
        this.tamanoMB = tamanoMB;
    }

    @Override
    public void run() {
        String threadName = Thread.currentThread().getName();

        for (int porcentaje = 0; porcentaje <= 100; porcentaje += 25) {
            System.out.printf("[%s] Descargando %s... %d%%%n",
                threadName, nombreArchivo, porcentaje);

            try {
                Thread.sleep(500); // Simular descarga
            } catch (InterruptedException e) {
                System.out.println("[" + threadName + "] Descarga interrumpida");
                return;
            }
        }

        System.out.println("[" + threadName + "] ✓ " + nombreArchivo + " completado");
    }
}

// ========================================
// CLASE PRINCIPAL
// ========================================

public class Ejercicio35 {
    public static void main(String[] args) {
        System.out.println("=== THREADS BÁSICOS - PROGRAMACIÓN CONCURRENTE ===\n");

        // ========================================
        // CREACIÓN DE THREADS
        // ========================================
        System.out.println("=== CREACIÓN DE THREADS ===");
        System.out.println("Thread principal: " + Thread.currentThread().getName());
        System.out.println();

        System.out.println("Iniciando threads...");

        // Crear y lanzar 3 threads
        Thread t1 = new Thread(new TareaSimple("Thread-1", 5));
        Thread t2 = new Thread(new TareaSimple("Thread-2", 5));
        Thread t3 = new Thread(new TareaSimple("Thread-3", 5));

        t1.start();
        t2.start();
        t3.start();

        // Esperar a que terminen
        try {
            t1.join();
            t2.join();
            t3.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println();

        // ========================================
        // RACE CONDITION (SIN SINCRONIZACIÓN)
        // ========================================
        System.out.println("=== RACE CONDITION (SIN SINCRONIZACIÓN) ===");
        System.out.println("Iniciando 10 threads para incrementar contador...");

        ContadorNoSeguro contadorNoSeguro = new ContadorNoSeguro();
        Thread[] threadsNoSeguros = new Thread[10];

        // Crear 10 threads que incrementan 1000 veces cada uno
        for (int i = 0; i < 10; i++) {
            threadsNoSeguros[i] = new Thread(() -> {
                for (int j = 0; j < 1000; j++) {
                    contadorNoSeguro.incrementar();
                }
            });
            threadsNoSeguros[i].start();
        }

        // Esperar a que todos terminen
        for (Thread t : threadsNoSeguros) {
            try {
                t.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        System.out.println("Valor final esperado: 10000");
        System.out.println("Valor final obtenido: " + contadorNoSeguro.getCount() +
            (contadorNoSeguro.getCount() == 10000 ? " ✓ (CORRECTO)" : " ✗ (INCORRECTO - race condition)"));
        System.out.println();

        // ========================================
        // CON SINCRONIZACIÓN
        // ========================================
        System.out.println("=== CON SINCRONIZACIÓN ===");
        System.out.println("Iniciando 10 threads para incrementar contador sincronizado...");

        ContadorSeguro contadorSeguro = new ContadorSeguro();
        Thread[] threadsSeguros = new Thread[10];

        // Crear 10 threads que incrementan 1000 veces cada uno
        for (int i = 0; i < 10; i++) {
            threadsSeguros[i] = new Thread(() -> {
                for (int j = 0; j < 1000; j++) {
                    contadorSeguro.incrementar();
                }
            });
            threadsSeguros[i].start();
        }

        // Esperar a que todos terminen
        for (Thread t : threadsSeguros) {
            try {
                t.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        System.out.println("Valor final esperado: 10000");
        System.out.println("Valor final obtenido: " + contadorSeguro.getCount() +
            (contadorSeguro.getCount() == 10000 ? " ✓ (CORRECTO)" : " ✗ (INCORRECTO)"));
        System.out.println();

        // ========================================
        // MÉTODO JOIN
        // ========================================
        System.out.println("=== MÉTODO JOIN ===");
        System.out.println("Thread principal esperando a trabajadores...");

        Thread trabajador1 = new Thread(new Trabajador("Trabajador-1"));
        Thread trabajador2 = new Thread(new Trabajador("Trabajador-2"));

        trabajador1.start();
        trabajador2.start();

        // join() hace que el thread principal espere
        try {
            trabajador1.join();
            trabajador2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Todos los trabajadores terminaron ✓");
        System.out.println();

        // ========================================
        // DESCARGA PARALELA
        // ========================================
        System.out.println("=== DESCARGA PARALELA DE ARCHIVOS ===");
        System.out.println("Descargando 5 archivos en paralelo...");

        long inicio = System.currentTimeMillis();

        Thread[] descargas = new Thread[5];
        for (int i = 0; i < 5; i++) {
            descargas[i] = new Thread(
                new DescargaArchivo("archivo" + (i + 1) + ".zip", 100),
                "Descarga-" + (i + 1)
            );
            descargas[i].start();
        }

        // Esperar a que todas las descargas terminen
        for (Thread descarga : descargas) {
            try {
                descarga.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        long fin = System.currentTimeMillis();
        double tiempoSegundos = (fin - inicio) / 1000.0;

        System.out.println("\nTodas las descargas completadas en " + tiempoSegundos + " segundos");
        System.out.println();

        // ========================================
        // LAMBDA THREADS
        // ========================================
        System.out.println("=== THREADS CON LAMBDAS (Java 8+) ===");

        Thread lambdaThread = new Thread(() -> {
            System.out.println("Thread ejecutado con lambda");
            System.out.println("Thread actual: " + Thread.currentThread().getName());
        });

        lambdaThread.setName("Lambda-Thread");
        lambdaThread.start();

        try {
            lambdaThread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println();

        // ========================================
        // DAEMON THREADS
        // ========================================
        System.out.println("=== DAEMON THREADS ===");

        Thread daemonThread = new Thread(() -> {
            System.out.println("Daemon thread iniciado");
            try {
                Thread.sleep(5000); // Dormir 5 segundos
                System.out.println("Daemon thread terminado");
            } catch (InterruptedException e) {
                System.out.println("Daemon interrumpido");
            }
        });

        daemonThread.setDaemon(true); // Marcar como daemon ANTES de start()
        daemonThread.start();

        System.out.println("Thread principal terminando...");
        System.out.println("(JVM no esperará al daemon thread)");

        // REFLEXIÓN FINAL:
        // ¿Por qué usar threads?
        // ✓ Aprovechar múltiples cores de CPU
        // ✓ Mejorar responsividad de aplicaciones
        // ✓ Operaciones en background (I/O, red)
        // ✓ Procesamiento paralelo de datos
        // ✓ Servidores: atender múltiples clientes
        //
        // EN LA VIDA REAL:
        // - Servidores web: thread por request
        // - Aplicaciones de escritorio: UI en thread principal, operaciones pesadas en background
        // - Procesamiento de imágenes: paralelo por secciones
        // - Bases de datos: múltiples conexiones simultáneas
        // - Descarga de archivos: múltiples descargas paralelas
        //
        // PROBLEMAS DE CONCURRENCIA:
        //
        // 1. RACE CONDITION:
        //    Múltiples threads acceden al mismo dato sin sincronización
        //    Resultado: valores incorrectos, comportamiento impredecible
        //
        // 2. DEADLOCK:
        //    Dos threads esperando recursos que el otro tiene
        //    Thread A espera lock de B, Thread B espera lock de A
        //    Resultado: ambos threads bloqueados permanentemente
        //
        // 3. STARVATION:
        //    Thread nunca obtiene el recurso que necesita
        //    Otros threads tienen prioridad más alta
        //
        // 4. LIVELOCK:
        //    Threads cambian estado en respuesta a otros
        //    Pero ninguno progresa (como dos personas bloqueándose mutuamente)
        //
        // SYNCHRONIZED - CÓMO FUNCIONA:
        // Cada objeto en Java tiene un "intrinsic lock" (monitor)
        // synchronized adquiere el lock antes de ejecutar
        // Solo UN thread puede tener el lock a la vez
        // Otros threads esperan hasta que se libere
        //
        // ALTERNATIVAS A synchronized:
        // - ReentrantLock: lock explícito con más control
        // - ReadWriteLock: múltiples lectores, un escritor
        // - Atomic classes: AtomicInteger, AtomicLong (lock-free)
        // - Concurrent collections: ConcurrentHashMap
        //
        // EXECUTOR FRAMEWORK (MODERNO):
        // En lugar de crear threads manualmente:
        //
        // ExecutorService executor = Executors.newFixedThreadPool(10);
        // executor.submit(() -> {
        //     // tarea aquí
        // });
        // executor.shutdown();
        //
        // Ventajas:
        // ✓ Pool de threads reutilizables
        // ✓ Mejor manejo de recursos
        // ✓ Fácil de escalar
        // ✓ Futures para resultados
        //
        // MEJORES PRÁCTICAS:
        // ✓ Usa Runnable en lugar de extender Thread
        // ✓ Usa ExecutorService en lugar de threads manuales
        // ✓ Minimiza uso de synchronized (overhead)
        // ✓ Usa concurrent collections cuando sea posible
        // ✓ Evita compartir estado mutable
        // ✓ Documenta qué es thread-safe
        // ✓ Usa herramientas de análisis (FindBugs, SpotBugs)
        //
        // THREAD-SAFE COLLECTIONS:
        // - Vector, Hashtable: sincronizados (legacy, lentos)
        // - Collections.synchronizedList(): wrapper sincronizado
        // - ConcurrentHashMap: optimizado para concurrencia
        // - CopyOnWriteArrayList: para más lecturas que escrituras
        //
        // VOLATILE KEYWORD:
        // Asegura visibilidad entre threads
        //
        // private volatile boolean running = true;
        //
        // Sin volatile, un thread puede cachear el valor
        // y no ver cambios hechos por otros threads
        //
        // JAVA MEMORY MODEL:
        // Define cómo threads interactúan a través de memoria
        // - Cada thread tiene cache local
        // - synchronized y volatile aseguran visibilidad
        //
        // CUÁNDO NO USAR THREADS:
        // ✗ Operaciones simples y rápidas
        // ✗ Datos deben procesarse en orden estricto
        // ✗ Complejidad no vale la pena
        // ✗ Hardware con un solo core (no hay paralelismo real)
        //
        // DEPURACIÓN DE THREADS:
        // - jstack: dump de threads
        // - jconsole: monitor de threads
        // - IDE debuggers: pausa todos los threads
        // - Logs con thread name para identificar problemas
        //
        // RECURSOS AVANZADOS:
        // - java.util.concurrent: paquete de utilidades
        // - ForkJoinPool: trabajo paralelo divide-y-conquista
        // - CompletableFuture: programación asíncrona
        // - Parallel Streams: paralelismo automático
        //
        // CONCLUSIÓN:
        // Threads son poderosos pero complejos. Usarlos correctamente
        // requiere entender sincronización, race conditions, y deadlocks.
        // En aplicaciones modernas, usa ExecutorService y concurrent
        // collections en lugar de threads manuales y synchronized.
    }
}
