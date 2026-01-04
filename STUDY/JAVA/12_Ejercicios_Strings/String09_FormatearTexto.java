/**
 * EJERCICIO STRING #9: FormatearTexto
 * Dificultad: ⭐⭐⭐
 *
 * PROBLEMA:
 * Implementar word wrap: dividir texto en lineas de maximo N caracteres,
 * sin cortar palabras a la mitad.
 *
 * EJEMPLOS:
 * texto = "El rapido zorro marron salta sobre el perro perezoso"
 * ancho = 20
 *
 * Resultado:
 * "El rapido zorro"
 * "marron salta sobre"
 * "el perro perezoso"
 *
 * REGLAS:
 * - No cortar palabras
 * - No dejar espacios al inicio/final de linea
 * - Si una palabra es mas larga que ancho, ponerla sola en su linea
 *
 * PISTAS:
 * 1. Divide el texto en palabras
 * 2. Acumula palabras hasta que excedan el ancho
 * 3. Cuando exceda, guarda la linea y empieza una nueva
 */

import java.util.*;

public class String09_FormatearTexto {
    public static void main(String[] args) {
        String texto = "El rapido zorro marron salta sobre el perro perezoso";

        System.out.println("=== Ancho 20 ===");
        List<String> lineas = wordWrap(texto, 20);
        for (String linea : lineas) {
            System.out.println("|" + linea + "|");
        }

        System.out.println("\n=== Ancho 15 ===");
        lineas = wordWrap(texto, 15);
        for (String linea : lineas) {
            System.out.println("|" + linea + "|");
        }

        System.out.println("\n=== Ancho 10 (con palabra larga) ===");
        lineas = wordWrap("Una superlargapalabra aqui", 10);
        for (String linea : lineas) {
            System.out.println("|" + linea + "|");
        }
    }

    public static List<String> wordWrap(String texto, int ancho) {
        // TODO: Implementar
        // 1. Dividir en palabras
        // 2. Acumular palabras en linea actual
        // 3. Cuando exceda ancho, guardar y empezar nueva
        // 4. Manejar palabras mas largas que ancho

        return new ArrayList<>(); // Placeholder
    }

    // Bonus: justificar texto (espacios distribuidos uniformemente)
    public static List<String> justificar(String texto, int ancho) {
        // TODO: Implementar
        // Similar a wordWrap pero agregando espacios extra

        return new ArrayList<>(); // Placeholder
    }
}

/*
 * ============================================
 * SOLUCION (NO MIRAR ANTES DE INTENTAR):
 * ============================================
 *
 * public static List<String> wordWrap(String texto, int ancho) {
 *     List<String> resultado = new ArrayList<>();
 *
 *     if (texto == null || texto.isEmpty() || ancho <= 0) {
 *         return resultado;
 *     }
 *
 *     String[] palabras = texto.split("\\s+");
 *     StringBuilder lineaActual = new StringBuilder();
 *
 *     for (String palabra : palabras) {
 *         // Si la palabra sola es mas larga que el ancho
 *         if (palabra.length() > ancho) {
 *             // Guardar linea actual si tiene contenido
 *             if (lineaActual.length() > 0) {
 *                 resultado.add(lineaActual.toString());
 *                 lineaActual = new StringBuilder();
 *             }
 *             // Poner la palabra larga sola
 *             resultado.add(palabra);
 *             continue;
 *         }
 *
 *         // Si agregar la palabra excede el ancho
 *         if (lineaActual.length() + palabra.length() +
 *             (lineaActual.length() > 0 ? 1 : 0) > ancho) {
 *             // Guardar linea actual
 *             resultado.add(lineaActual.toString());
 *             lineaActual = new StringBuilder();
 *         }
 *
 *         // Agregar palabra a linea actual
 *         if (lineaActual.length() > 0) {
 *             lineaActual.append(" ");
 *         }
 *         lineaActual.append(palabra);
 *     }
 *
 *     // No olvidar la ultima linea
 *     if (lineaActual.length() > 0) {
 *         resultado.add(lineaActual.toString());
 *     }
 *
 *     return resultado;
 * }
 *
 * public static List<String> justificar(String texto, int ancho) {
 *     List<String> wrapped = wordWrap(texto, ancho);
 *     List<String> resultado = new ArrayList<>();
 *
 *     for (int i = 0; i < wrapped.size(); i++) {
 *         String linea = wrapped.get(i);
 *
 *         // No justificar la ultima linea
 *         if (i == wrapped.size() - 1) {
 *             resultado.add(linea);
 *             continue;
 *         }
 *
 *         String[] palabras = linea.split(" ");
 *         if (palabras.length == 1) {
 *             resultado.add(linea);
 *             continue;
 *         }
 *
 *         int espaciosExtra = ancho - linea.length() + (palabras.length - 1);
 *         int espaciosPorGap = espaciosExtra / (palabras.length - 1);
 *         int espaciosSobrantes = espaciosExtra % (palabras.length - 1);
 *
 *         StringBuilder sb = new StringBuilder();
 *         for (int j = 0; j < palabras.length - 1; j++) {
 *             sb.append(palabras[j]);
 *             int espacios = espaciosPorGap + (j < espaciosSobrantes ? 1 : 0);
 *             for (int k = 0; k < espacios; k++) sb.append(" ");
 *         }
 *         sb.append(palabras[palabras.length - 1]);
 *
 *         resultado.add(sb.toString());
 *     }
 *
 *     return resultado;
 * }
 *
 * COMPLEJIDAD:
 * - Tiempo: O(n) donde n es el numero de caracteres
 * - Espacio: O(n)
 */
