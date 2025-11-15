/*
 * ========================================
 * EJERCICIO 20: HashSet y TreeSet - Gestión de Estudiantes Únicos
 * DIFICULTAD: ⭐⭐⭐⭐⭐⭐⭐ (Muy Difícil+)
 * ========================================
 *
 * OBJETIVO:
 * Aprender sobre SET - colecciones que NO permiten elementos duplicados
 *
 * CONCEPTO CLAVE:
 * - Set: Colección de elementos ÚNICOS (sin duplicados)
 * - HashSet: Set sin orden específico, muy rápido
 * - TreeSet: Set ORDENADO automáticamente
 *
 * ANALOGÍA:
 * - Set es como un club exclusivo: cada miembro solo puede estar una vez
 * - HashSet es como una bolsa de canicas únicas (sin orden)
 * - TreeSet es como una fila ordenada de personas por altura
 *
 * DIFERENCIA: List vs Set
 * - List (ArrayList, LinkedList): Permite duplicados, mantiene orden de inserción
 * - Set (HashSet, TreeSet): NO permite duplicados, elimina automáticamente repetidos
 *
 * CUANDO USAR CADA UNO:
 * - HashSet: Elementos únicos, no importa el orden, máxima velocidad
 * - TreeSet: Elementos únicos Y ordenados, un poco más lento
 * - ArrayList: Permite duplicados, necesitas índices
 *
 * INSTRUCCIONES:
 * 1. Crea una clase "Estudiante" con:
 *    - Atributos privados: id (String), nombre (String), edad (int), promedio (double)
 *    - Constructor que reciba todos los atributos
 *    - Getters para todos los atributos
 *    - Método "toString()" formateado
 *    - IMPORTANTE: Sobrescribe "equals()" y "hashCode()" basándote en el ID
 *      (Dos estudiantes con mismo ID son considerados el mismo estudiante)
 *
 * 2. Crea una clase "GestorEstudiantes" con:
 *    - Atributos privados:
 *      * HashSet<Estudiante> estudiantes (sin orden, rápido)
 *      * TreeSet<String> nombresOrdenados (ordenado alfabéticamente)
 *    - Constructor que inicialice ambas colecciones
 *    - Método "agregarEstudiante(Estudiante estudiante)"
 *      - Intenta agregarlo al HashSet
 *      - Si se agrega exitosamente (no era duplicado), agrega el nombre al TreeSet
 *      - Retorna true si se agregó, false si ya existía
 *    - Método "existeEstudiante(String id)" - verifica si existe por ID
 *    - Método "obtenerEstudiante(String id)" - busca y retorna el estudiante
 *    - Método "mostrarEstudiantes()" - muestra todos
 *    - Método "mostrarNombresOrdenados()" - muestra los nombres ordenados
 *    - Método "contarEstudiantes()" - retorna la cantidad
 *    - Método "estudiantesConPromedioAlto(double minimoPromedio)"
 *    - Método "eliminarEstudiante(String id)"
 *
 * 3. En el main:
 *    - Crea el gestor
 *    - Agrega 5 estudiantes
 *    - Intenta agregar un estudiante duplicado (mismo ID)
 *    - Muestra todos los estudiantes
 *    - Muestra los nombres ordenados
 *    - Busca un estudiante específico
 *    - Filtra estudiantes con promedio alto
 *    - Elimina un estudiante
 *    - Muestra el total
 *
 * SALIDA ESPERADA:
 * === GESTIÓN DE ESTUDIANTES ===
 *
 * ✓ Estudiante agregado: E001 - Juan Pérez
 * ✓ Estudiante agregado: E002 - María García
 * ...
 * ✗ Estudiante E002 ya existe (duplicado ignorado)
 *
 * === TODOS LOS ESTUDIANTES ===
 * ID: E001 | Juan Pérez | 20 años | Promedio: 8.5
 * ID: E002 | María García | 22 años | Promedio: 9.2
 * ...
 * Total: 5 estudiantes
 *
 * === NOMBRES ORDENADOS ALFABÉTICAMENTE ===
 * 1. Ana López
 * 2. Carlos Rodríguez
 * 3. Juan Pérez
 * 4. María García
 * 5. Pedro Martínez
 *
 * === BUSCAR ESTUDIANTE: E003 ===
 * Encontrado: Ana López - 21 años - Promedio: 9.5
 *
 * === ESTUDIANTES CON PROMEDIO >= 9.0 ===
 * María García - Promedio: 9.2
 * Ana López - Promedio: 9.5
 *
 * === ELIMINAR ESTUDIANTE E005 ===
 * Estudiante E005 eliminado
 * Total restante: 4 estudiantes
 *
 * CONCEPTOS NUEVOS:
 * - Set<E>: Interface para colecciones sin duplicados
 * - HashSet<E>: Implementación rápida, sin orden
 * - TreeSet<E>: Implementación ordenada automáticamente
 * - .add(elemento): Agrega si no existe (retorna false si era duplicado)
 * - .contains(elemento): Verifica existencia
 * - .remove(elemento): Elimina elemento
 * - equals() y hashCode(): Métodos para definir igualdad de objetos
 *
 * COMPLEJIDAD (Big O):
 * - HashSet add/contains/remove: O(1) promedio
 * - TreeSet add/contains/remove: O(log n)
 * - ArrayList contains: O(n)
 *
 * ¿POR QUÉ SOBRESCRIBIR equals() y hashCode()?
 * - Para que el Set pueda determinar si dos objetos son "el mismo"
 * - Por defecto, Java compara referencias de memoria
 * - Nosotros queremos comparar por ID (contenido)
 *
 */

import java.util.HashSet;
import java.util.TreeSet;
import java.util.Objects;

public class Ejercicio20 {
    // TODO: Lee las instrucciones arriba y escribe TODO el código
    // TODO: Implementa todas las clases, métodos y lógica necesaria
}
