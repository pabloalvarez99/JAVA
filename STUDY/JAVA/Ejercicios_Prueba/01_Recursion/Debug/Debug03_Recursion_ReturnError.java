/*
 * EJERCICIO DEBUG: Error en Valor de Retorno Recursivo
 * DIFICULTAD: ⭐⭐⭐⭐⭐ (5/10)
 * TIEMPO: 20 minutos
 *
 * INSTRUCCIONES:
 * El siguiente código intenta calcular la potencia usando recursión (base^exponente).
 * El código compila pero produce resultados incorrectos.
 *
 * ENCUENTRA EL BUG:
 * 1. Traza manualmente potencia(2, 3) - debería dar 8
 * 2. Identifica qué está mal con el valor de retorno
 * 3. Corrige el error
 *
 * SALIDA ACTUAL (incorrecta):
 * 2^3 = 6
 * 5^2 = 10
 * 3^4 = 12
 *
 * SALIDA ESPERADA (correcta):
 * 2^3 = 8
 * 5^2 = 25
 * 3^4 = 81
 */

public class Debug03_Recursion_ReturnError {

    // BUG: Hay un error en el cálculo del valor de retorno
    public static int potencia(int base, int exponente) {
        // Caso base: cualquier número elevado a 0 es 1
        if (exponente == 0) {
            return 1;
        }

        // Caso recursivo
        // BUG: ¿Qué operación debería ser?
        return base + potencia(base, exponente - 1);
    }

    public static void main(String[] args) {
        System.out.println("2^3 = " + potencia(2, 3));  // Debería ser 8
        System.out.println("5^2 = " + potencia(5, 2));  // Debería ser 25
        System.out.println("3^4 = " + potencia(3, 4));  // Debería ser 81
        System.out.println("10^0 = " + potencia(10, 0)); // Debería ser 1
        System.out.println("7^1 = " + potencia(7, 1));  // Debería ser 7
    }
}

/*
 * ANÁLISIS DEL BUG:
 *
 * Traza de potencia(2, 3) con el código bugueado:
 * potencia(2, 3) = 2 + potencia(2, 2)
 * potencia(2, 2) = 2 + potencia(2, 1)
 * potencia(2, 1) = 2 + potencia(2, 0)
 * potencia(2, 0) = 1  (caso base)
 *
 * Desenrollando:
 * potencia(2, 1) = 2 + 1 = 3
 * potencia(2, 2) = 2 + 3 = 5
 * potencia(2, 3) = 2 + 5 = 7  ❌ (debería ser 8)
 *
 * SOLUCIÓN:
 * El operador debería ser * (multiplicación), no + (suma)
 *
 * 2^3 = 2 * 2 * 2 = 8
 * NO es 2 + 2 + 2 + 1 = 7
 *
 * Línea corregida:
 * return base * potencia(base, exponente - 1);
 *
 * CONCEPTO CLAVE:
 * En recursión matemática, la operación debe coincidir con la
 * definición matemática:
 * - Potencia: base^n = base * base^(n-1) → multiplicación
 * - Factorial: n! = n * (n-1)! → multiplicación
 * - Suma: sum(n) = n + sum(n-1) → suma
 */
