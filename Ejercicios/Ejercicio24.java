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
 * PISTAS:
 * - Usa ArrayList<T> como almacenamiento interno
 * - push(): usa add() del ArrayList
 * - pop(): usa remove(size() - 1)
 * - peek(): usa get(size() - 1)
 * - Para validar paréntesis: push cuando abres, pop cuando cierras
 * - Para postfijo: números van al stack, operadores combinan los últimos 2
 */

import java.util.ArrayList;
import java.util.EmptyStackException;

// TODO: Implementa la clase genérica Stack<T>
class Stack<T> {
    // Usamos ArrayList como almacenamiento interno
    private ArrayList<T> elementos;

    // Constructor
    public Stack() {
        // TODO: Inicializa el ArrayList
        elementos = new ArrayList<>();
    }

    // Método push: añade elemento al tope
    public void push(T elemento) {
        // TODO: Añade el elemento al final del ArrayList
        elementos.add(elemento);
    }

    // Método pop: remueve y retorna el elemento del tope
    public T pop() {
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        // TODO: Remueve y retorna el último elemento
        return elementos.remove(elementos.size() - 1);
    }

    // Método peek: retorna el tope sin remover
    public T peek() {
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        // TODO: Retorna el último elemento sin removerlo
        return elementos.get(elementos.size() - 1);
    }

    // Método isEmpty: verifica si está vacía
    public boolean isEmpty() {
        // TODO: Retorna true si no hay elementos
        return elementos.isEmpty();
    }

    // Método size: retorna el tamaño
    public int size() {
        // TODO: Retorna el número de elementos
        return elementos.size();
    }

    // Método clear: limpia la pila
    public void clear() {
        // TODO: Limpia todos los elementos
        elementos.clear();
    }

    // toString: muestra el estado de la pila
    @Override
    public String toString() {
        if (isEmpty()) {
            return "[]";
        }
        return elementos.toString() + " (tope: " + peek() + ")";
    }
}

public class Ejercicio24 {

    // TODO: Implementa validarParentesis
    public static boolean validarParentesis(String expresion) {
        Stack<Character> pila = new Stack<>();

        for (int i = 0; i < expresion.length(); i++) {
            char c = expresion.charAt(i);

            // Si es un símbolo de apertura, push
            if (c == '(' || c == '[' || c == '{') {
                // TODO: Añade el símbolo a la pila
                pila.push(c);
            }
            // Si es un símbolo de cierre
            else if (c == ')' || c == ']' || c == '}') {
                // Si la pila está vacía, no hay símbolo de apertura correspondiente
                if (pila.isEmpty()) {
                    return false;
                }

                // TODO: Verifica que el símbolo de apertura coincida con el de cierre
                char apertura = pila.pop();

                // Verifica coincidencia
                if (c == ')' && apertura != '(') return false;
                if (c == ']' && apertura != '[') return false;
                if (c == '}' && apertura != '{') return false;
            }
        }

        // Al final, la pila debe estar vacía
        return pila.isEmpty();
    }

    // TODO: Implementa invertirString
    public static String invertirString(String texto) {
        Stack<Character> pila = new Stack<>();

        // TODO: Push cada carácter a la pila
        for (int i = 0; i < texto.length(); i++) {
            pila.push(texto.charAt(i));
        }

        // TODO: Pop cada carácter y construye el string invertido
        StringBuilder invertido = new StringBuilder();
        while (!pila.isEmpty()) {
            invertido.append(pila.pop());
        }

        return invertido.toString();
    }

    // TODO: Implementa evaluarPostfijo
    public static int evaluarPostfijo(String expresion) {
        Stack<Integer> pila = new Stack<>();
        String[] tokens = expresion.split(" ");

        for (String token : tokens) {
            // Si es un número, push
            if (esNumero(token)) {
                // TODO: Convierte a entero y push
                pila.push(Integer.parseInt(token));
            }
            // Si es un operador
            else {
                // TODO: Pop dos números, opera, y push el resultado
                int b = pila.pop();  // Segundo operando
                int a = pila.pop();  // Primer operando

                switch (token) {
                    case "+":
                        pila.push(a + b);
                        break;
                    case "-":
                        pila.push(a - b);
                        break;
                    case "*":
                        pila.push(a * b);
                        break;
                    case "/":
                        pila.push(a / b);
                        break;
                }
            }
        }

        // El resultado final está en el tope
        return pila.pop();
    }

    // Método auxiliar para verificar si un string es número
    private static boolean esNumero(String str) {
        try {
            Integer.parseInt(str);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    public static void main(String[] args) {
        System.out.println("=== STACK (PILA) - ESTRUCTURA LIFO ===\n");

        // === OPERACIONES BÁSICAS ===
        System.out.println("=== OPERACIONES BÁSICAS ===");
        Stack<String> pilaLetras = new Stack<>();

        // Push elementos
        System.out.println("Push: A");
        pilaLetras.push("A");
        System.out.println("Push: B");
        pilaLetras.push("B");
        System.out.println("Push: C");
        pilaLetras.push("C");
        System.out.println("Push: D");
        pilaLetras.push("D");
        System.out.println();

        System.out.println("Estado actual: " + pilaLetras);
        System.out.println("Tamaño: " + pilaLetras.size());
        System.out.println("Tope (peek): " + pilaLetras.peek());
        System.out.println();

        // Pop elementos
        System.out.println("Pop: " + pilaLetras.pop());
        System.out.println("Pop: " + pilaLetras.pop());
        System.out.println();

        System.out.println("Estado actual: " + pilaLetras);
        System.out.println("Tamaño: " + pilaLetras.size());
        System.out.println();

        // === VALIDACIÓN DE PARÉNTESIS ===
        System.out.println("=== VALIDACIÓN DE PARÉNTESIS ===");
        String[] expresiones = {
            "()",
            "()[]{}",
            "(]",
            "([)]",
            "{[]}",
            "((("
        };

        for (String expr : expresiones) {
            boolean valido = validarParentesis(expr);
            System.out.println("\"" + expr + "\" → " + (valido ? "BALANCEADO" : "NO BALANCEADO"));
        }
        System.out.println();

        // === INVERTIR STRING ===
        System.out.println("=== INVERTIR STRING ===");
        String[] palabras = {"Java", "Stack"};
        for (String palabra : palabras) {
            String invertida = invertirString(palabra);
            System.out.println("Original: \"" + palabra + "\"");
            System.out.println("Invertido: \"" + invertida + "\"");
            System.out.println();
        }

        // === EVALUACIÓN POSTFIJA ===
        System.out.println("=== EVALUACIÓN POSTFIJA ===");
        String[] expresionesPostfijas = {
            "5 3 +",           // 8
            "5 3 + 2 *",       // 16
            "10 5 / 2 +"       // 4
        };

        for (String expr : expresionesPostfijas) {
            int resultado = evaluarPostfijo(expr);
            System.out.println("Expresión: \"" + expr + "\"");
            System.out.println("Resultado: " + resultado);
            System.out.println();
        }

        // REFLEXIÓN:
        // ¿Por qué es importante el Stack?
        // ✓ Patrón LIFO fundamental en programación
        // ✓ Usado internamente por el JVM (call stack)
        // ✓ Esencial para implementar deshacer/rehacer
        // ✓ Permite resolver problemas de balanceo y validación
        //
        // STACK EN LA VIDA REAL:
        // - Call Stack: Java usa un stack para las llamadas de métodos
        // - Deshacer/Rehacer: Editores de texto usan dos stacks
        // - Navegación: Browsers usan stack para el botón "Atrás"
        // - Compiladores: Validación de sintaxis (paréntesis)
        // - Algoritmos: DFS (Depth-First Search) usa stack
        //
        // EJEMPLO CALL STACK:
        // main() llama a metodoA()
        //   metodoA() llama a metodoB()
        //     metodoB() llama a metodoC()
        //       metodoC() termina ← Pop
        //     metodoB() termina ← Pop
        //   metodoA() termina ← Pop
        // main() continúa
        //
        // DIFERENCIA STACK vs QUEUE:
        // Stack (LIFO):  [A, B, C, D] → pop() → D (último)
        // Queue (FIFO):  [A, B, C, D] → poll() → A (primero)
        //
        // RECURSIÓN = STACK IMPLÍCITO:
        // Cada llamada recursiva se apila en el call stack
        // Por eso puede causar StackOverflowError si es muy profunda
        //
        // APLICACIÓN: VALIDAR HTML:
        // <div><p>texto</p></div>  → VÁLIDO
        // <div><p>texto</div></p>  → INVÁLIDO (orden incorrecto)
    }
}
