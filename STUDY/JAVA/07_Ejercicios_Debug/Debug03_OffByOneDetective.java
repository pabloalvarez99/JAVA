/**
 * EJERCICIO DEBUG #3: OffByOneDetective
 * Dificultad: ⭐⭐⭐
 *
 * DESCRIPCIÓN:
 * El siguiente código tiene un error "off-by-one".
 * Encuentra y corrige el bug.
 *
 * PISTA: Los índices de arrays en Java empiezan en 0.
 *
 * SALIDA ESPERADA:
 * Promedio de notas: 82.0
 *
 * SALIDA ACTUAL:
 * Exception in thread "main" java.lang.ArrayIndexOutOfBoundsException:
 * Index 5 out of bounds for length 5
 */

public class Debug03_OffByOneDetective {
    public static void main(String[] args) {
        int[] notas = {75, 88, 92, 78, 77};

        int suma = 0;
        // BUG: <= debería ser <
        for (int i = 0; i <= notas.length; i++) {
            suma += notas[i];
        }

        double promedio = (double) suma / notas.length;
        System.out.println("Promedio de notas: " + promedio);
    }
}

/*
 * ============================================
 * VARIANTE ADICIONAL:
 * ============================================
 *
 * Este código también tiene un off-by-one, pero diferente:
 *
 * int[] arr = {1, 2, 3, 4, 5};
 * for (int i = 1; i < arr.length; i++) {  // Empieza en 1, salta el primero
 *     System.out.println(arr[i]);
 * }
 *
 * ============================================
 * DESPUÉS DE RESOLVER, REFLEXIONA:
 * ============================================
 *
 * 1. ¿Cuál es el índice válido más alto para un array de tamaño N?
 *
 * 2. ¿Por qué el enhanced for loop evita este error?
 *
 * 3. ¿En qué otras situaciones ocurren errores off-by-one?
 *
 * SOLUCIÓN: Ver soluciones/Debug03_Solucion.java
 */
