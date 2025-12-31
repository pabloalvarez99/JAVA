/*
 * ========================================
 * EJERCICIO 24: Stack (Pila) - Estructura de Datos LIFO
 * DIFICULTAD: ⭐⭐⭐⭐⭐⭐⭐⭐ (Extremadamente Difícil)
 * ========================================
 *
 * OBJETIVO:
 * Implementar una estructura de datos STACK (Pila) desde cero y entender
 * el principio LIFO (Last In, First Out - Último en Entrar, Primero en Salir)
 *
 * CONCEPTO CLAVE:
 * Un Stack es como una pila de platos: solo puedes añadir o quitar platos
 * desde la parte superior. El último plato que pusiste es el primero que sacas.
 *
 * OPERACIONES PRINCIPALES:
 * - push(elemento): Añade un elemento al tope de la pila
 * - pop(): Remueve y retorna el elemento del tope
 * - peek(): Retorna el elemento del tope SIN removerlo
 * - isEmpty(): Verifica si la pila está vacía
 * - size(): Retorna el número de elementos
 *
 * ANALOGÍA:
 * Imagina una pila de libros en tu escritorio:
 * 1. Pones el libro A (push)
 * 2. Pones el libro B encima (push)
 * 3. Pones el libro C encima (push)
 * 4. Para tomar el libro A, PRIMERO debes quitar C, luego B
 *
 * LIFO: El libro C (último en entrar) es el primero que sale
 *
 * DIFERENCIA CON QUEUE:
 * - Stack (Pila): LIFO - Último en entrar, primero en salir
 * - Queue (Cola): FIFO - Primero en entrar, primero en salir
 *
 * APLICACIONES REALES:
 * ✓ Deshacer/Rehacer en editores (Ctrl+Z)
 * ✓ Navegación de páginas web (botón "Atrás")
 * ✓ Evaluación de expresiones matemáticas
 * ✓ Call Stack (pila de llamadas de funciones)
 * ✓ Validación de paréntesis balanceados
 * ✓ Algoritmos de backtracking
 *
 * INSTRUCCIONES:
 * 1. Implementa una clase Stack<T> genérica usando un ArrayList interno
 *    Métodos:
 *    - push(T elemento): Añade elemento al tope
 *    - pop(): Remueve y retorna el elemento del tope (lanza excepción si vacía)
 *    - peek(): Retorna el tope sin remover (lanza excepción si vacía)
 *    - isEmpty(): Retorna true si está vacía
 *    - size(): Retorna el tamaño
 *    - clear(): Limpia toda la pila
 *
 * 2. Implementa un método estático "validarParentesis(String expresion)"
 *    - Valida si los paréntesis (), corchetes [] y llaves {} están balanceados
 *    - Ejemplos:
 *      * "()" → true
 *      * "()[]{}" → true
 *      * "(]" → false
 *      * "([)]" → false
 *      * "{[]}" → true
 *
 * 3. Implementa un método "invertirString(String texto)"
 *    - Usa un Stack para invertir un String
 *
 * 4. Implementa un método "evaluarPostfijo(String expresion)"
 *    - Evalúa una expresión en notación postfija (Reverse Polish Notation)
 *    - Ejemplo: "5 3 + 2 *" = (5 + 3) * 2 = 16
 *
 * SALIDA ESPERADA:
 * === STACK (PILA) - ESTRUCTURA LIFO ===
 *
 * === OPERACIONES BÁSICAS ===
 * Push: A
 * Push: B
 * Push: C
 * Push: D
 *
 * Estado actual: [A, B, C, D] (tope: D)
 * Tamaño: 4
 * Tope (peek): D
 *
 * Pop: D
 * Pop: C
 *
 * Estado actual: [A, B] (tope: B)
 * Tamaño: 2
 *
 * === VALIDACIÓN DE PARÉNTESIS ===
 * "()" → BALANCEADO
 * "()[]{}" → BALANCEADO
 * "(]" → NO BALANCEADO
 * "([)]" → NO BALANCEADO
 * "{[]}" → BALANCEADO
 * "(((" → NO BALANCEADO
 *
 * === INVERTIR STRING ===
 * Original: "Java"
 * Invertido: "avaJ"
 *
 * Original: "Stack"
 * Invertido: "kcatS"
 *
 * === EVALUACIÓN POSTFIJA ===
 * Expresión: "5 3 +"
 * Resultado: 8
 *
 * Expresión: "5 3 + 2 *"
 * Resultado: 16
 *
 * Expresión: "10 5 / 2 +"
 * Resultado: 4
 *
 * CONCEPTOS NUEVOS:
 * - Stack (Pila): Estructura de datos LIFO
 * - LIFO: Last In, First Out
 * - push/pop/peek: Operaciones básicas de pila
 * - Balanceo de símbolos: Validación de paréntesis
 * - Notación postfija: Evaluación de expresiones
 * - Aplicaciones de Stack en algoritmos
 *
 * COMPLEJIDAD:
 * - push(): O(1) - constante
 * - pop(): O(1) - constante
 * - peek(): O(1) - constante
 * - isEmpty(): O(1) - constante
 *
 * VENTAJAS DEL STACK:
 * ✓ Operaciones muy rápidas O(1)
 * ✓ Fácil de implementar
 * ✓ Útil para deshacer/rehacer
 * ✓ Natural para recursión (call stack)
 *
 */

import java.util.ArrayList;
import java.util.EmptyStackException;

public class Ejercicio24 {
    // TODO: Lee las instrucciones arriba y escribe TODO el código
    // TODO: Implementa todas las clases, métodos y lógica necesaria
}
