/*
 * ========================================
 * EJEMPLO DE USO DEL SISTEMA DE PRUEBAS
 * ========================================
 *
 * Este archivo demuestra cómo usar los archivos de datos de prueba
 * para verificar tu código sin tener que escribir datos manualmente.
 *
 * CÓMO EJECUTAR:
 * 1. javac EjemploPrueba.java TestRunner.java DatosPrueba.java
 * 2. java EjemploPrueba
 *
 */

import java.util.Arrays;

public class EjemploPrueba {

    public static void main(String[] args) {
        System.out.println("=== EJEMPLOS DE USO DEL SISTEMA DE PRUEBAS ===\n");

        // Ejemplo 1: Ver datos disponibles
        ejemplo1_VerDatos();

        // Ejemplo 2: Usar datos en cálculos
        ejemplo2_UsarDatos();

        // Ejemplo 3: Verificar con TestRunner
        ejemplo3_VerificarConTests();

        // Resumen final
        TestRunner.imprimirResumen();
    }

    /**
     * EJEMPLO 1: Ver qué datos están disponibles
     */
    static void ejemplo1_VerDatos() {
        TestRunner.printHeader("EJEMPLO 1: Ver Datos Disponibles");

        System.out.println("Datos del Ejercicio 1 (Variables):");
        System.out.println("  Nombre: " + DatosPrueba.Ejercicio1.NOMBRE);
        System.out.println("  Edad: " + DatosPrueba.Ejercicio1.EDAD);
        System.out.println("  Altura: " + DatosPrueba.Ejercicio1.ALTURA);

        System.out.println("\nDatos del Ejercicio 7 (Arrays):");
        System.out.println("  Array: " + Arrays.toString(DatosPrueba.Ejercicio7.NUMEROS));

        System.out.println("\nTambién puedes llamar a mostrarDatos() para ver más detalles:");
        System.out.println("(Descomenta la siguiente línea para probar)");
        // DatosPrueba.Ejercicio7.mostrarDatos();
    }

    /**
     * EJEMPLO 2: Usar los datos en tus cálculos
     */
    static void ejemplo2_UsarDatos() {
        TestRunner.printHeader("EJEMPLO 2: Usar Datos en Cálculos");

        // Obtener array de prueba
        int[] numeros = DatosPrueba.Ejercicio7.NUMEROS;

        System.out.println("Array: " + Arrays.toString(numeros));

        // Calcular suma
        int suma = 0;
        for (int num : numeros) {
            suma += num;
        }
        System.out.println("Suma calculada: " + suma);

        // Calcular promedio
        double promedio = suma / (double) numeros.length;
        System.out.printf("Promedio calculado: %.2f\n", promedio);

        // Encontrar máximo
        int maximo = numeros[0];
        for (int num : numeros) {
            if (num > maximo) {
                maximo = num;
            }
        }
        System.out.println("Máximo encontrado: " + maximo);

        // Encontrar mínimo
        int minimo = numeros[0];
        for (int num : numeros) {
            if (num < minimo) {
                minimo = num;
            }
        }
        System.out.println("Mínimo encontrado: " + minimo);
    }

    /**
     * EJEMPLO 3: Verificar resultados con TestRunner
     */
    static void ejemplo3_VerificarConTests() {
        TestRunner.printHeader("EJEMPLO 3: Verificar con TestRunner");

        // Obtener datos de prueba
        int num1 = DatosPrueba.Ejercicio2.NUM1; // 10
        int num2 = DatosPrueba.Ejercicio2.NUM2; // 3

        System.out.println("Probando operaciones matemáticas:");
        System.out.println("  num1 = " + num1);
        System.out.println("  num2 = " + num2);
        System.out.println();

        // Probar suma
        int suma = num1 + num2;
        TestRunner.assertEquals("Suma: 10 + 3", 13, suma);

        // Probar resta
        int resta = num1 - num2;
        TestRunner.assertEquals("Resta: 10 - 3", 7, resta);

        // Probar multiplicación
        int mult = num1 * num2;
        TestRunner.assertEquals("Multiplicación: 10 * 3", 30, mult);

        // Probar división
        int div = num1 / num2;
        TestRunner.assertEquals("División: 10 / 3", 3, div);

        // Probar módulo
        int mod = num1 % num2;
        TestRunner.assertEquals("Módulo: 10 % 3", 1, mod);

        System.out.println();

        // Probar condiciones booleanas
        System.out.println("Probando condiciones booleanas:");
        TestRunner.assertTrue("10 > 3", num1 > num2);
        TestRunner.assertFalse("10 < 3", num1 < num2);
        TestRunner.assertTrue("10 != 3", num1 != num2);
    }

    /**
     * EJEMPLO BONUS: Cómo usar datos de ejercicios avanzados
     */
    static void ejemploBonus_DatosAvanzados() {
        TestRunner.printHeader("EJEMPLO BONUS: Datos Avanzados");

        System.out.println("Para ejercicios avanzados, usa DatosPruebaAvanzados:");
        System.out.println("Ejemplo:");
        System.out.println("  DatosPruebaAvanzados.Ejercicio11.mostrarDatos();");
        System.out.println();

        System.out.println("Para ejercicios muy avanzados, usa DatosPruebaMuyAvanzados:");
        System.out.println("Ejemplo:");
        System.out.println("  int[] array = DatosPruebaMuyAvanzados.AlgoritmosOrdenamiento.ARRAY_PEQUEÑO;");
    }
}
