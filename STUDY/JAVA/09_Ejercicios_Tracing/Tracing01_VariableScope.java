/**
 * EJERCICIO TRACING #1: VariableScope
 * Dificultad: ⭐⭐
 *
 * INSTRUCCIONES:
 * 1. Lee el codigo sin ejecutarlo
 * 2. Escribe tu prediccion abajo
 * 3. Ejecuta y compara
 *
 * CONCEPTOS: Ambito de variables, shadowing, bloques
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

public class Tracing01_VariableScope {
    static int x = 10;

    public static void main(String[] args) {
        int x = 20;
        System.out.println("1: " + x);

        {
            int y = 30;
            x = 25;
            System.out.println("2: " + x);
            System.out.println("3: " + y);
        }

        System.out.println("4: " + x);
        System.out.println("5: " + Tracing01_VariableScope.x);
    }
}

/*
 * ============================================
 * RESPUESTA CORRECTA (NO MIRAR ANTES):
 * ============================================
 *
 * Linea 1: 20
 * Linea 2: 25
 * Linea 3: 30
 * Linea 4: 25
 * Linea 5: 10
 *
 * ============================================
 * EXPLICACION:
 * ============================================
 *
 * - La variable local 'x' (20) oculta (shadows) la estatica (10)
 * - Dentro del bloque, se modifica la 'x' local a 25
 * - 'y' solo existe dentro del bloque
 * - Fuera del bloque, 'x' sigue siendo 25 (la local modificada)
 * - Tracing01_VariableScope.x accede a la estatica (10)
 *
 * CONCEPTO CLAVE: Shadowing
 * - Una variable local puede "ocultar" una de mayor alcance
 * - Para acceder a la oculta, usa el nombre de clase (si es static)
 */
