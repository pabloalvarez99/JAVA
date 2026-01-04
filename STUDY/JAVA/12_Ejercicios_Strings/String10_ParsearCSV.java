/**
 * EJERCICIO STRING #10: ParsearCSV
 * Dificultad: ⭐⭐⭐
 *
 * PROBLEMA:
 * Parsear una linea CSV manejando casos especiales:
 * - Campos entre comillas pueden contener comas
 * - Comillas dobles "" representan una comilla literal
 * - Campos vacios son validos
 *
 * EJEMPLOS:
 * "a,b,c"                    -> ["a", "b", "c"]
 * "\"hello, world\",test"    -> ["hello, world", "test"]
 * "a,,c"                     -> ["a", "", "c"]
 * "\"she said \"\"hi\"\"\""  -> ["she said \"hi\""]
 * ""                         -> [""]
 *
 * PISTAS:
 * 1. NO uses split(",") - no maneja comillas
 * 2. Usa una maquina de estados: normal vs dentro de comillas
 * 3. Procesa caracter por caracter
 *
 * CASOS EDGE:
 * - Campo vacio: ,,
 * - Comillas al inicio/final
 * - Comilla escapada: ""
 */

import java.util.*;

public class String10_ParsearCSV {
    public static void main(String[] args) {
        // Casos de prueba
        probar("a,b,c");
        // Esperado: [a, b, c]

        probar("\"hello, world\",test");
        // Esperado: [hello, world, test]

        probar("a,,c");
        // Esperado: [a, , c]

        probar("\"she said \"\"hi\"\"\"");
        // Esperado: [she said "hi"]

        probar("");
        // Esperado: []

        probar("name,age,city");
        // Esperado: [name, age, city]

        probar("\"John Doe\",30,\"New York, NY\"");
        // Esperado: [John Doe, 30, New York, NY]
    }

    static void probar(String linea) {
        System.out.println("Input:  \"" + linea + "\"");
        System.out.println("Output: " + parsearCSV(linea));
        System.out.println();
    }

    public static List<String> parsearCSV(String linea) {
        // TODO: Implementar
        // 1. Iniciar lista de campos y StringBuilder para campo actual
        // 2. Estado: dentrodeComillas (boolean)
        // 3. Para cada caracter:
        //    - Si es " y estamos fuera: entrar a comillas
        //    - Si es " y estamos dentro: ver si es "" (escapado) o cierre
        //    - Si es , y estamos fuera: terminar campo
        //    - Otro caso: agregar al campo actual
        // 4. No olvidar el ultimo campo

        return new ArrayList<>(); // Placeholder
    }
}

/*
 * ============================================
 * SOLUCION (NO MIRAR ANTES DE INTENTAR):
 * ============================================
 *
 * public static List<String> parsearCSV(String linea) {
 *     List<String> campos = new ArrayList<>();
 *
 *     if (linea == null || linea.isEmpty()) {
 *         return campos;
 *     }
 *
 *     StringBuilder campoActual = new StringBuilder();
 *     boolean dentroComillas = false;
 *     int i = 0;
 *
 *     while (i < linea.length()) {
 *         char c = linea.charAt(i);
 *
 *         if (dentroComillas) {
 *             if (c == '"') {
 *                 // Verificar si es comilla escapada ""
 *                 if (i + 1 < linea.length() && linea.charAt(i + 1) == '"') {
 *                     campoActual.append('"');
 *                     i++; // Saltar la segunda comilla
 *                 } else {
 *                     // Fin de campo entrecomillado
 *                     dentroComillas = false;
 *                 }
 *             } else {
 *                 campoActual.append(c);
 *             }
 *         } else {
 *             if (c == '"') {
 *                 // Inicio de campo entrecomillado
 *                 dentroComillas = true;
 *             } else if (c == ',') {
 *                 // Fin del campo
 *                 campos.add(campoActual.toString());
 *                 campoActual = new StringBuilder();
 *             } else {
 *                 campoActual.append(c);
 *             }
 *         }
 *
 *         i++;
 *     }
 *
 *     // Agregar el ultimo campo
 *     campos.add(campoActual.toString());
 *
 *     return campos;
 * }
 *
 * COMPLEJIDAD:
 * - Tiempo: O(n)
 * - Espacio: O(n)
 *
 * NOTA: Esta es una implementacion simplificada.
 * Para CSV robusto, considera usar una libreria como OpenCSV.
 *
 * CASOS NO MANEJADOS:
 * - Saltos de linea dentro de comillas
 * - BOM (Byte Order Mark) al inicio
 * - Diferentes delimitadores (;)
 */
