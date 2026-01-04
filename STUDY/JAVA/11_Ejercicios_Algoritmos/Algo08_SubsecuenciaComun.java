/**
 * EJERCICIO ALGORITMO #8: Subsecuencia Comun Mas Larga (LCS)
 * Categoria: Programacion Dinamica
 * Dificultad: ⭐⭐⭐⭐
 *
 * PROBLEMA:
 * Dadas dos cadenas, encontrar la longitud de la subsecuencia
 * comun mas larga.
 *
 * SUBSECUENCIA vs SUBSTRING:
 * - Subsecuencia: caracteres en orden pero no necesariamente consecutivos
 * - Substring: caracteres consecutivos
 *
 * EJEMPLO:
 * s1 = "ABCDGH"
 * s2 = "AEDFHR"
 * LCS = "ADH" (longitud 3)
 *
 * RECURRENCIA:
 * Si s1[i] == s2[j]: LCS(i,j) = 1 + LCS(i-1, j-1)
 * Si s1[i] != s2[j]: LCS(i,j) = max(LCS(i-1,j), LCS(i,j-1))
 *
 * COMPLEJIDAD:
 * - Tiempo: O(n * m)
 * - Espacio: O(n * m), optimizable a O(min(n,m))
 */

public class Algo08_SubsecuenciaComun {
    public static void main(String[] args) {
        String s1 = "ABCDGH";
        String s2 = "AEDFHR";

        System.out.println("s1 = \"" + s1 + "\"");
        System.out.println("s2 = \"" + s2 + "\"");

        int longitud = lcs(s1, s2);
        System.out.println("\nLongitud LCS: " + longitud);

        String secuencia = obtenerLCS(s1, s2);
        System.out.println("LCS: \"" + secuencia + "\"");

        // Otro ejemplo
        System.out.println("\n--- Otro ejemplo ---");
        s1 = "AGGTAB";
        s2 = "GXTXAYB";
        System.out.println("s1 = \"" + s1 + "\"");
        System.out.println("s2 = \"" + s2 + "\"");
        System.out.println("LCS: \"" + obtenerLCS(s1, s2) + "\" (longitud " + lcs(s1, s2) + ")");
    }

    /**
     * Calcula la longitud de la LCS usando DP.
     */
    public static int lcs(String s1, String s2) {
        int n = s1.length();
        int m = s2.length();

        // TODO: Implementar
        // 1. Crear tabla dp[n+1][m+1]
        // 2. Caso base: dp[0][j] = dp[i][0] = 0
        // 3. Llenar tabla segun recurrencia

        return 0; // Placeholder
    }

    /**
     * Obtiene la LCS como string (no solo la longitud).
     */
    public static String obtenerLCS(String s1, String s2) {
        // TODO: Implementar
        // 1. Construir tabla dp
        // 2. Recorrer desde dp[n][m] hacia atras
        // 3. Si caracteres iguales: agregar y diagonal
        // 4. Si diferentes: ir hacia el mayor

        return ""; // Placeholder
    }
}

/*
 * ============================================
 * SOLUCION (NO MIRAR ANTES DE INTENTAR):
 * ============================================
 *
 * public static int lcs(String s1, String s2) {
 *     int n = s1.length();
 *     int m = s2.length();
 *
 *     int[][] dp = new int[n + 1][m + 1];
 *
 *     // Los casos base dp[0][j] y dp[i][0] ya son 0
 *
 *     for (int i = 1; i <= n; i++) {
 *         for (int j = 1; j <= m; j++) {
 *             if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
 *                 dp[i][j] = 1 + dp[i - 1][j - 1];
 *             } else {
 *                 dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
 *             }
 *         }
 *     }
 *
 *     return dp[n][m];
 * }
 *
 * public static String obtenerLCS(String s1, String s2) {
 *     int n = s1.length();
 *     int m = s2.length();
 *
 *     // Construir tabla
 *     int[][] dp = new int[n + 1][m + 1];
 *     for (int i = 1; i <= n; i++) {
 *         for (int j = 1; j <= m; j++) {
 *             if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
 *                 dp[i][j] = 1 + dp[i - 1][j - 1];
 *             } else {
 *                 dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
 *             }
 *         }
 *     }
 *
 *     // Reconstruir LCS
 *     StringBuilder lcs = new StringBuilder();
 *     int i = n, j = m;
 *
 *     while (i > 0 && j > 0) {
 *         if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
 *             lcs.insert(0, s1.charAt(i - 1));
 *             i--;
 *             j--;
 *         } else if (dp[i - 1][j] > dp[i][j - 1]) {
 *             i--;
 *         } else {
 *             j--;
 *         }
 *     }
 *
 *     return lcs.toString();
 * }
 *
 * ============================================
 * VISUALIZACION TABLA:
 * ============================================
 *
 *     ""  A  E  D  F  H  R
 * ""   0  0  0  0  0  0  0
 * A    0  1  1  1  1  1  1
 * B    0  1  1  1  1  1  1
 * C    0  1  1  1  1  1  1
 * D    0  1  1  2  2  2  2
 * G    0  1  1  2  2  2  2
 * H    0  1  1  2  2  3  3
 *
 * LCS = "ADH" (longitud 3)
 *
 * ============================================
 * APLICACIONES:
 * ============================================
 *
 * - Diff de archivos (git diff)
 * - Comparacion de ADN
 * - Correccion ortografica
 * - Plagiarism detection
 */
