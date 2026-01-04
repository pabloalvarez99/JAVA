/**
 * EJERCICIO TRACING #5: StaticVsInstance
 * Dificultad: ⭐⭐⭐
 *
 * INSTRUCCIONES:
 * 1. Lee el codigo sin ejecutarlo
 * 2. Escribe tu prediccion abajo
 * 3. Ejecuta y compara
 *
 * CONCEPTOS: Static vs instance, orden de inicializacion, bloques estaticos
 *
 * ============================================
 * ESCRIBE TU PREDICCION AQUI:
 * ============================================
 * Linea 1: _______________
 * Linea 2: _______________
 * Linea 3: _______________
 * Linea 4: _______________
 * Linea 5: _______________
 * Linea 6: _______________
 * Linea 7: _______________
 * ============================================
 */

public class Tracing05_StaticVsInstance {
    static int estatica = initEstatica();
    int instancia = initInstancia();

    static {
        System.out.println("Bloque estatico");
    }

    {
        System.out.println("Bloque de instancia");
    }

    Tracing05_StaticVsInstance() {
        System.out.println("Constructor");
    }

    static int initEstatica() {
        System.out.println("Inicializando variable estatica");
        return 1;
    }

    int initInstancia() {
        System.out.println("Inicializando variable de instancia");
        return 2;
    }

    public static void main(String[] args) {
        System.out.println("=== Main inicio ===");
        new Tracing05_StaticVsInstance();
        System.out.println("---");
        new Tracing05_StaticVsInstance();
    }
}

/*
 * ============================================
 * RESPUESTA CORRECTA (NO MIRAR ANTES):
 * ============================================
 *
 * Linea 1: Inicializando variable estatica
 * Linea 2: Bloque estatico
 * Linea 3: === Main inicio ===
 * Linea 4: Inicializando variable de instancia
 * Linea 5: Bloque de instancia
 * Linea 6: Constructor
 * Linea 7: ---
 * Linea 8: Inicializando variable de instancia
 * Linea 9: Bloque de instancia
 * Linea 10: Constructor
 *
 * ============================================
 * EXPLICACION:
 * ============================================
 *
 * ORDEN DE INICIALIZACION:
 *
 * 1. Variables estaticas + bloques estaticos (una vez, al cargar clase)
 *    - En orden de aparicion en el codigo
 *
 * 2. Variables de instancia + bloques de instancia (cada new)
 *    - En orden de aparicion en el codigo
 *
 * 3. Constructor (cada new)
 *
 * NOTA: Los estaticos se ejecutan ANTES de main()!
 * NOTA: Los estaticos solo se ejecutan UNA VEZ
 *
 * CONCEPTO CLAVE:
 * - static = pertenece a la CLASE (una copia)
 * - instance = pertenece al OBJETO (una por instancia)
 */
