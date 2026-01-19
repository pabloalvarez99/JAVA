/*
 * EJERCICIO DEBUG: Error de Lógica en Recursión
 * DIFICULTAD: ⭐⭐⭐⭐ (4/10)
 * TIEMPO: 15 minutos
 *
 * INSTRUCCIONES:
 * El siguiente código intenta buscar un elemento en un array usando recursión.
 * El código compila pero produce resultados incorrectos.
 *
 * ENCUENTRA EL BUG:
 * 1. Analiza la lógica del método buscarRecursivo
 * 2. Identifica qué está mal en la llamada recursiva
 * 3. Corrige el error
 *
 * SALIDA ACTUAL (incorrecta):
 * Buscando 30 en el array...
 * Índice encontrado: -1
 *
 * SALIDA ESPERADA (correcta):
 * Buscando 30 en el array...
 * Índice encontrado: 2
 */

public class Debug02_Recursion_LogicError {

    // BUG: Hay un error en la lógica de este método
    public static int buscarRecursivo(int[] array, int elemento, int indice) {
        // Caso base: llegamos al final sin encontrar
        if (indice >= array.length) {
            return -1;
        }

        // Caso base: encontramos el elemento
        if (array[indice] == elemento) {
            return indice;
        }

        // Caso recursivo: seguir buscando
        // BUG AQUÍ: ¿Qué está mal con esta llamada?
        return buscarRecursivo(array, elemento, indice);
    }

    public static void main(String[] args) {
        int[] numeros = {10, 20, 30, 40, 50};

        System.out.println("Buscando 30 en el array...");
        int resultado = buscarRecursivo(numeros, 30, 0);
        System.out.println("Índice encontrado: " + resultado);

        System.out.println("\nBuscando 50 en el array...");
        resultado = buscarRecursivo(numeros, 50, 0);
        System.out.println("Índice encontrado: " + resultado);

        System.out.println("\nBuscando 99 en el array...");
        resultado = buscarRecursivo(numeros, 99, 0);
        System.out.println("Índice encontrado: " + resultado);
    }
}

/*
 * PISTAS:
 *
 * Pista 1: ¿El índice está cambiando en cada llamada recursiva?
 *
 * Pista 2: Para avanzar en el array, ¿qué debería pasar con el índice?
 *
 * Pista 3: La llamada recursiva debería ser:
 *          return buscarRecursivo(array, elemento, indice + 1);
 *
 * CONCEPTO CLAVE:
 * En recursión sobre arrays, cada llamada debe:
 * - Verificar caso base (fin del array o elemento encontrado)
 * - Avanzar el índice en la llamada recursiva (indice + 1)
 *
 * Sin el incremento, la recursión se queda en el mismo índice
 * y nunca termina (o devuelve -1 inmediatamente si el primer
 * elemento no coincide).
 */
