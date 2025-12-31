/*
 * ========================================
 * TEST RUNNER - Sistema de Pruebas Automatizado
 * ========================================
 *
 * Este archivo proporciona utilidades para probar tus ejercicios
 * de manera automática sin tener que escribir datos de prueba manualmente.
 *
 * USO:
 * 1. Compila tu ejercicio normalmente
 * 2. Ejecuta el TestRunner correspondiente
 * 3. Verifica que todas las pruebas pasen
 *
 */

public class TestRunner {

    private static int testsPasados = 0;
    private static int testsFallidos = 0;

    /**
     * Verifica si un valor esperado coincide con un valor actual
     */
    public static void assertEquals(String mensaje, Object esperado, Object actual) {
        if (esperado.equals(actual)) {
            System.out.println("✓ PASS: " + mensaje);
            testsPasados++;
        } else {
            System.out.println("✗ FAIL: " + mensaje);
            System.out.println("  Esperado: " + esperado);
            System.out.println("  Actual:   " + actual);
            testsFallidos++;
        }
    }

    /**
     * Verifica si una condición es verdadera
     */
    public static void assertTrue(String mensaje, boolean condicion) {
        if (condicion) {
            System.out.println("✓ PASS: " + mensaje);
            testsPasados++;
        } else {
            System.out.println("✗ FAIL: " + mensaje);
            System.out.println("  Se esperaba: true");
            System.out.println("  Se obtuvo:   false");
            testsFallidos++;
        }
    }

    /**
     * Verifica si una condición es falsa
     */
    public static void assertFalse(String mensaje, boolean condicion) {
        if (!condicion) {
            System.out.println("✓ PASS: " + mensaje);
            testsPasados++;
        } else {
            System.out.println("✗ FAIL: " + mensaje);
            System.out.println("  Se esperaba: false");
            System.out.println("  Se obtuvo:   true");
            testsFallidos++;
        }
    }

    /**
     * Imprime el resumen final de las pruebas
     */
    public static void imprimirResumen() {
        System.out.println("\n" + "=".repeat(50));
        System.out.println("RESUMEN DE PRUEBAS");
        System.out.println("=".repeat(50));
        System.out.println("Tests pasados:  " + testsPasados);
        System.out.println("Tests fallidos: " + testsFallidos);
        System.out.println("Total:          " + (testsPasados + testsFallidos));

        if (testsFallidos == 0) {
            System.out.println("\n🎉 ¡EXCELENTE! Todos los tests pasaron");
        } else {
            System.out.println("\n⚠ Hay tests que fallaron. Revisa tu código.");
        }
    }

    /**
     * Resetea los contadores
     */
    public static void resetear() {
        testsPasados = 0;
        testsFallidos = 0;
    }

    /**
     * Imprime un encabezado de sección
     */
    public static void printHeader(String titulo) {
        System.out.println("\n" + "=".repeat(50));
        System.out.println(titulo);
        System.out.println("=".repeat(50));
    }
}
