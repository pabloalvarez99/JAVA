/**
 * EJERCICIO TRACING #8: StreamPipeline
 * Dificultad: ⭐⭐⭐⭐
 *
 * INSTRUCCIONES:
 * 1. Lee el codigo sin ejecutarlo
 * 2. Escribe tu prediccion abajo
 * 3. Ejecuta y compara
 *
 * CONCEPTOS: Streams, evaluacion perezosa, operaciones intermedias vs terminales
 *
 * ============================================
 * ESCRIBE TU PREDICCION AQUI:
 * ============================================
 * (Escribe cada linea de salida EN ORDEN)
 * _______________
 * _______________
 * _______________
 * _______________
 * _______________
 * _______________
 * ============================================
 */

import java.util.Arrays;
import java.util.List;

public class Tracing08_StreamPipeline {
    public static void main(String[] args) {
        List<Integer> numeros = Arrays.asList(1, 2, 3, 4, 5, 6);

        System.out.println("=== Creando pipeline ===");

        long count = numeros.stream()
            .filter(n -> {
                System.out.println("filter: " + n);
                return n % 2 == 0;
            })
            .map(n -> {
                System.out.println("map: " + n);
                return n * 10;
            })
            .limit(2)
            .count();

        System.out.println("=== Resultado: " + count + " ===");
    }
}

/*
 * ============================================
 * RESPUESTA CORRECTA (NO MIRAR ANTES):
 * ============================================
 *
 * === Creando pipeline ===
 * filter: 1
 * filter: 2
 * map: 2
 * filter: 3
 * filter: 4
 * map: 4
 * === Resultado: 2 ===
 *
 * ============================================
 * EXPLICACION:
 * ============================================
 *
 * SORPRESA! El orden NO es:
 * - Todos los filter
 * - Todos los map
 *
 * El stream procesa ELEMENTO POR ELEMENTO:
 *
 * 1 -> filter(1): false, descartado
 * 2 -> filter(2): true -> map(2): 20 -> limit cuenta 1
 * 3 -> filter(3): false, descartado
 * 4 -> filter(4): true -> map(4): 40 -> limit cuenta 2
 * 5, 6 -> NUNCA SE PROCESAN (limit ya tiene 2)
 *
 * CONCEPTOS CLAVE:
 *
 * 1. Evaluacion PEREZOSA:
 *    - El pipeline NO ejecuta nada hasta la operacion terminal (count)
 *
 * 2. Evaluacion VERTICAL:
 *    - Cada elemento pasa por TODO el pipeline antes del siguiente
 *
 * 3. SHORT-CIRCUIT:
 *    - limit(2) detiene el procesamiento cuando tiene 2 elementos
 *    - Por eso 5 y 6 nunca se tocan
 */
