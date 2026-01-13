/**
 * ========================================
 * EJERCICIO TRACING #3: Recursión con Math.pow()
 * Dificultad: ⭐⭐⭐⭐⭐
 * ========================================
 *
 * REPLICA EXACTA: Problema 1 del examen real (20 puntos)
 * Universidad de Coquimbo - Examen POO
 *
 * INSTRUCCIONES:
 * 1. Lee el código sin ejecutarlo
 * 2. Escribe tu predicción de la salida abajo
 * 3. Ejecuta y compara tu respuesta
 *
 * CONCEPTOS: Recursión, Math.pow(), operaciones aritméticas, orden de evaluación
 * TIEMPO ESTIMADO: 45 minutos
 *
 * ============================================
 * ESCRIBE TU PREDICCIÓN AQUI (sin ejecutar):
 * ============================================
 *
 * r = proc(25, 1);
 *
 * Predicción del valor de r: _______________
 *
 * ============================================
 * IMPORTANTE: No ejecutes el código hasta haber escrito tu predicción
 * ============================================
 */

public class Tracing03_MathPow {
    public static void main(String[] args) {
        // Llamada principal
        int k = 25;
        double r = proc(k, 1);
        System.out.println("r = " + r);
    }

    /**
     * Método recursivo con Math.pow()
     *
     * ANALIZA CUIDADOSAMENTE:
     * - ¿Cuál es el caso base?
     * - ¿Qué pasa en cada llamada recursiva?
     * - ¿Cómo se calcula el retorno?
     */
    public static double proc(int m, int n) {
        if (m == 0) {
            // Caso base
            return Math.pow(10, n-1);
        } else {
            // Caso recursivo
            n++;
            return ((m/10), n) + Math.pow(m, n-1);
        }
    }
}

/*
 * ============================================
 * PISTAS (solo si estás muy atascado):
 * ============================================
 *
 * PISTA 1: Traza las llamadas recursivas
 * ----------------------
 * proc(25, 1) llama a...
 * proc(?, ?) llama a...
 * proc(?, ?) llega al caso base
 *
 * PISTA 2: ¿Qué hace m/10?
 * ----------------------
 * Si m = 25, entonces m/10 = 2 (división entera!)
 * Si m = 2, entonces m/10 = 0 (llega al caso base)
 *
 * PISTA 3: ¿Qué valor tiene n en cada llamada?
 * ----------------------
 * proc(25, 1) → n se incrementa a 2 antes de la llamada recursiva
 * proc(2, 2)  → n se incrementa a 3 antes de la llamada recursiva
 * proc(0, 3)  → caso base, retorna Math.pow(10, 3-1) = 100
 *
 * PISTA 4: ¿Cómo se calcula el retorno?
 * ----------------------
 * Cada llamada retorna: proc(m/10, n) + Math.pow(m, n-1)
 * Pero ¡CUIDADO! n ya fue incrementado en la línea anterior
 *
 * ============================================
 * RESPUESTA CORRECTA (NO MIRAR ANTES):
 * ============================================
 *
 * Traza completa de ejecución:
 *
 * 1. proc(25, 1)
 *    - m = 25, n = 1
 *    - m != 0, entonces caso recursivo
 *    - n++ → n = 2
 *    - Calcula: proc(25/10, 2) + Math.pow(25, 2-1)
 *    - Calcula: proc(2, 2) + Math.pow(25, 1)
 *    - Calcula: proc(2, 2) + 25
 *
 * 2. proc(2, 2)
 *    - m = 2, n = 2
 *    - m != 0, entonces caso recursivo
 *    - n++ → n = 3
 *    - Calcula: proc(2/10, 3) + Math.pow(2, 3-1)
 *    - Calcula: proc(0, 3) + Math.pow(2, 2)
 *    - Calcula: proc(0, 3) + 4
 *
 * 3. proc(0, 3)
 *    - m = 0, n = 3
 *    - m == 0, entonces caso base
 *    - Retorna: Math.pow(10, 3-1) = Math.pow(10, 2) = 100
 *
 * Ahora desenrollamos la pila de llamadas:
 *
 * proc(0, 3) retorna 100
 * proc(2, 2) retorna 100 + 4 = 104
 * proc(25, 1) retorna 104 + 25 = 129
 *
 * **RESPUESTA FINAL: r = 129.0**
 *
 * ============================================
 * EXPLICACIÓN DETALLADA:
 * ============================================
 *
 * CONCEPTO CLAVE: Recursión con división entera
 *
 * 1. División entera en Java:
 *    - 25 / 10 = 2 (no 2.5)
 *    - 2 / 10 = 0
 *    - Esto es lo que hace converger la recursión al caso base
 *
 * 2. Incremento de n:
 *    - En cada llamada recursiva, n se incrementa ANTES de la llamada
 *    - Esto significa que n crece: 1 → 2 → 3
 *
 * 3. Math.pow():
 *    - Math.pow(25, 1) = 25^1 = 25
 *    - Math.pow(2, 2) = 2^2 = 4
 *    - Math.pow(10, 2) = 10^2 = 100
 *
 * 4. Orden de evaluación:
 *    - Primero se evalúa la llamada recursiva (izquierda)
 *    - Luego se suma Math.pow() (derecha)
 *    - Finalmente se retorna la suma
 *
 * ERRORES COMUNES:
 *
 * Error 1: Olvidar que m/10 es división entera
 * - Incorrecto: Pensar que 25/10 = 2.5
 * - Correcto: 25/10 = 2 (trunca la parte decimal)
 *
 * Error 2: No actualizar n antes de usarlo
 * - La línea n++ ejecuta ANTES de la llamada recursiva
 * - Entonces proc(m/10, n) usa el n ya incrementado
 *
 * Error 3: Calcular Math.pow(m, n) en lugar de Math.pow(m, n-1)
 * - El exponente es n-1, no n
 * - Con m=25, n=2: Math.pow(25, 2-1) = Math.pow(25, 1) = 25
 *
 * Error 4: Confundir el orden de las sumas
 * - La suma se hace desde el caso base hacia arriba
 * - proc(0,3)=100 → proc(2,2)=104 → proc(25,1)=129
 *
 * ============================================
 * PREGUNTA DE REFLEXIÓN:
 * ============================================
 *
 * 1. ¿Qué pasaría si la llamada recursiva fuera proc(m/10, n+1) en lugar de incrementar n antes?
 *    Respuesta: El comportamiento sería el mismo, pero menos legible
 *
 * 2. ¿Qué pasaría si el caso base fuera (m <= 0) en lugar de (m == 0)?
 *    Respuesta: Funcionaría igual, pero sería más robusto para números negativos
 *
 * 3. ¿Cuántas llamadas recursivas se hacen en total?
 *    Respuesta: 3 llamadas (proc(25,1), proc(2,2), proc(0,3))
 *
 * 4. ¿Cuál es la profundidad de la pila de llamadas?
 *    Respuesta: 3 niveles
 *
 * 5. ¿Qué valor tendría proc(100, 1)?
 *    Respuesta: Traza las llamadas: proc(100,1) → proc(10,2) → proc(1,3) → proc(0,4)
 *    - proc(0,4) = 1000
 *    - proc(1,3) = 1000 + 1 = 1001
 *    - proc(10,2) = 1001 + 10 = 1011
 *    - proc(100,1) = 1011 + 100 = 1111
 *
 * ============================================
 * RELACIÓN CON EL EXAMEN:
 * ============================================
 *
 * Este ejercicio es una REPLICA EXACTA del Problema 1 del examen real.
 *
 * En el examen, este tipo de problema vale 20 puntos y debes resolverlo
 * en 30-45 minutos.
 *
 * Habilidades que se evalúan:
 * 1. Entender recursión
 * 2. Trazar ejecución con pila de llamadas
 * 3. Operaciones aritméticas (división entera, potencia)
 * 4. Atención al detalle (n++ antes de llamada, n-1 en Math.pow)
 *
 * ESTRATEGIA EN EL EXAMEN:
 * 1. [Minutos 0-5] Leer código 2 veces sin escribir
 * 2. [Minutos 5-10] Crear tabla de pila de llamadas
 * 3. [Minutos 10-30] Ejecutar mentalmente línea por línea
 * 4. [Minutos 30-40] Escribir respuesta final
 * 5. [Minutos 40-45] Verificar cálculos una última vez
 *
 * ============================================
 * EJERCICIOS RELACIONADOS:
 * ============================================
 *
 * Para practicar más:
 * - Tracing01_Recursion_Simple.java (más fácil)
 * - Tracing02_Recursion_DobleCall.java (similar)
 * - Ej03_Palindromo_Recursivo.md (implementación)
 * - Ej04_Matriz_DivideConquer.md (recursión avanzada)
 *
 * ============================================
 * SOLUCIÓN:
 * ============================================
 *
 * Ver: Soluciones/01_Recursion/Tracing/Tracing03_Solucion.md
 */
