/**
 * EJERCICIO TRACING #10: ThreadInterleaving
 * Dificultad: ⭐⭐⭐⭐⭐
 *
 * INSTRUCCIONES:
 * 1. Lee el codigo sin ejecutarlo
 * 2. Escribe TODAS las posibles salidas
 * 3. Ejecuta VARIAS veces y observa
 *
 * CONCEPTOS: Threads, concurrencia, no-determinismo, race conditions
 *
 * ============================================
 * ESCRIBE TU PREDICCION AQUI:
 * ============================================
 * Posible salida 1:
 * _______________
 * _______________
 * _______________
 * _______________
 *
 * Posible salida 2:
 * _______________
 * _______________
 * _______________
 * _______________
 *
 * Posible salida 3:
 * _______________
 * _______________
 * _______________
 * _______________
 * ============================================
 */

public class Tracing10_ThreadInterleaving {
    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(() -> {
            System.out.println("A1");
            System.out.println("A2");
        });

        Thread t2 = new Thread(() -> {
            System.out.println("B1");
            System.out.println("B2");
        });

        t1.start();
        t2.start();

        t1.join();
        t2.join();

        System.out.println("FIN");
    }
}

/*
 * ============================================
 * RESPUESTAS CORRECTAS (NO MIRAR ANTES):
 * ============================================
 *
 * HAY MULTIPLES SALIDAS VALIDAS! Ejemplos:
 *
 * Caso 1:    Caso 2:    Caso 3:    Caso 4:
 * A1         B1         A1         B1
 * A2         B2         B1         A1
 * B1         A1         A2         B2
 * B2         A2         B2         A2
 * FIN        FIN        FIN        FIN
 *
 * Caso 5:    Caso 6:
 * A1         B1
 * B1         A1
 * B2         A2
 * A2         B2
 * FIN        FIN
 *
 * ============================================
 * EXPLICACION:
 * ============================================
 *
 * GARANTIAS:
 * - A1 siempre antes que A2 (mismo thread)
 * - B1 siempre antes que B2 (mismo thread)
 * - FIN siempre al final (join espera a ambos)
 *
 * NO GARANTIZADO:
 * - El orden relativo entre A y B es IMPREDECIBLE
 * - Depende del scheduler del sistema operativo
 *
 * CONCEPTO CLAVE: No-determinismo
 * - El mismo programa puede dar diferentes salidas
 * - NUNCA asumas un orden entre threads sin sincronizacion
 *
 * POSIBLES INTERCALADOS:
 * A1-A2-B1-B2, A1-B1-A2-B2, A1-B1-B2-A2,
 * B1-A1-A2-B2, B1-A1-B2-A2, B1-B2-A1-A2
 *
 * = 6 combinaciones validas (mas FIN al final)
 *
 * EJERCICIO EXTRA:
 * Como garantizarias que A1-A2 siempre va antes que B1-B2?
 * Pista: t1.join() antes de t2.start()
 */
