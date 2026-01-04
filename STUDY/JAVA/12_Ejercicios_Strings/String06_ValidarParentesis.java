/**
 * EJERCICIO STRING #6: ValidarParentesis
 * Dificultad: ⭐⭐⭐
 *
 * PROBLEMA:
 * Verificar si una expresion tiene parentesis/corchetes/llaves balanceados.
 * Cada apertura debe tener su cierre correspondiente en el orden correcto.
 *
 * EJEMPLOS:
 * "()"           -> true
 * "()[]{}"       -> true
 * "(]"           -> false
 * "([)]"         -> false (mal orden)
 * "{[]}"         -> true
 * "((()))"       -> true
 * "(()"          -> false (falta cierre)
 * ")("           -> false (mal orden)
 *
 * PISTAS:
 * 1. Usa una pila (Stack)
 * 2. Push para aperturas, pop para cierres
 * 3. Verifica que el pop corresponda al cierre
 *
 * METODOS UTILES:
 * - Stack.push(), Stack.pop(), Stack.isEmpty()
 * - Map para emparejar aperturas con cierres
 */

import java.util.*;

public class String06_ValidarParentesis {
    public static void main(String[] args) {
        // Casos de prueba
        System.out.println(esValido("()"));       // true
        System.out.println(esValido("()[]{}"));   // true
        System.out.println(esValido("(]"));       // false
        System.out.println(esValido("([)]"));     // false
        System.out.println(esValido("{[]}"));     // true
        System.out.println(esValido("((()))"));   // true
        System.out.println(esValido("(()"));      // false
        System.out.println(esValido(")("));       // false
        System.out.println(esValido(""));         // true
        System.out.println(esValido("a(b)c"));    // true (ignora otros chars)
    }

    public static boolean esValido(String s) {
        // TODO: Implementar
        // 1. Crear pila
        // 2. Para cada caracter:
        //    - Si es apertura: push
        //    - Si es cierre: verificar que el top sea su pareja y pop
        // 3. Al final, la pila debe estar vacia

        return false; // Placeholder
    }
}

/*
 * ============================================
 * SOLUCION (NO MIRAR ANTES DE INTENTAR):
 * ============================================
 *
 * public static boolean esValido(String s) {
 *     if (s == null) return false;
 *
 *     Stack<Character> pila = new Stack<>();
 *
 *     // Mapa de cierre -> apertura
 *     Map<Character, Character> parejas = Map.of(
 *         ')', '(',
 *         ']', '[',
 *         '}', '{'
 *     );
 *
 *     Set<Character> aperturas = Set.of('(', '[', '{');
 *
 *     for (char c : s.toCharArray()) {
 *         if (aperturas.contains(c)) {
 *             // Es apertura: push
 *             pila.push(c);
 *         } else if (parejas.containsKey(c)) {
 *             // Es cierre: verificar
 *             if (pila.isEmpty()) {
 *                 return false; // Cierre sin apertura
 *             }
 *             if (pila.pop() != parejas.get(c)) {
 *                 return false; // No corresponde
 *             }
 *         }
 *         // Ignorar otros caracteres
 *     }
 *
 *     return pila.isEmpty(); // Todas las aperturas cerradas?
 * }
 *
 * // Alternativa mas compacta:
 * public static boolean esValido2(String s) {
 *     Stack<Character> pila = new Stack<>();
 *
 *     for (char c : s.toCharArray()) {
 *         switch (c) {
 *             case '(': pila.push(')'); break;
 *             case '[': pila.push(']'); break;
 *             case '{': pila.push('}'); break;
 *             case ')': case ']': case '}':
 *                 if (pila.isEmpty() || pila.pop() != c) {
 *                     return false;
 *                 }
 *         }
 *     }
 *
 *     return pila.isEmpty();
 * }
 *
 * COMPLEJIDAD:
 * - Tiempo: O(n)
 * - Espacio: O(n) en el peor caso (todos aperturas)
 */
