/**
 * EJERCICIO TRACING #2: MethodOverloading
 * Dificultad: ⭐⭐
 *
 * INSTRUCCIONES:
 * 1. Lee el codigo sin ejecutarlo
 * 2. Escribe tu prediccion abajo
 * 3. Ejecuta y compara
 *
 * CONCEPTOS: Sobrecarga, resolucion en tiempo de compilacion
 *
 * ============================================
 * ESCRIBE TU PREDICCION AQUI:
 * ============================================
 * Linea 1: _______________
 * Linea 2: _______________
 * Linea 3: _______________
 * Linea 4: _______________
 * Linea 5: _______________
 * ============================================
 */

public class Tracing02_MethodOverloading {
    public static void main(String[] args) {
        print(5);
        print(5.0);
        print("5");
        print(5, 10);
        print((short) 5);
    }

    static void print(int x) {
        System.out.println("int: " + x);
    }

    static void print(double x) {
        System.out.println("double: " + x);
    }

    static void print(String x) {
        System.out.println("String: " + x);
    }

    static void print(int x, int y) {
        System.out.println("dos ints: " + x + ", " + y);
    }

    // NO hay metodo print(short)
}

/*
 * ============================================
 * RESPUESTA CORRECTA (NO MIRAR ANTES):
 * ============================================
 *
 * Linea 1: int: 5
 * Linea 2: double: 5.0
 * Linea 3: String: 5
 * Linea 4: dos ints: 5, 10
 * Linea 5: int: 5
 *
 * ============================================
 * EXPLICACION:
 * ============================================
 *
 * - print(5): 5 es int literal -> print(int)
 * - print(5.0): 5.0 es double literal -> print(double)
 * - print("5"): "5" es String -> print(String)
 * - print(5, 10): dos argumentos int -> print(int, int)
 * - print((short) 5): short se PROMUEVE a int (no hay print(short))
 *
 * CONCEPTO CLAVE: Promocion automatica
 * - byte -> short -> int -> long -> float -> double
 * - Si no existe metodo exacto, Java busca el mas cercano
 *
 * PREGUNTA: Que pasa si agregas print(long)?
 * - print((short) 5) iria a print(int) (promocion mas cercana)
 */
