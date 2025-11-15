/*
 * ========================================
 * EJERCICIO 12: Múltiples Objetos Interactuando (Aula con Estudiantes)
 * DIFICULTAD: ⭐⭐⭐⭐ (Medio-Alto)
 * ========================================
 *
 * OBJETIVO:
 * Aprender a trabajar con múltiples objetos que interactúan entre sí
 * y practicar el manejo de colecciones de objetos (arrays de objetos)
 *
 * CONCEPTO CLAVE:
 * En el mundo real, los objetos no existen aislados - interactúan entre sí.
 * Por ejemplo, un Aula contiene múltiples Estudiantes. Esta es una relación
 * de "contención" - un objeto contiene una colección de otros objetos.
 *
 * INSTRUCCIONES:
 * 1. REUTILIZA la clase "Estudiante" del ejercicio anterior (copia el código)
 *    - Ya tiene: nombre, nota1, nota2, nota3
 *    - Ya tiene: getters, setters, calcularPromedio(), aprobo()
 *
 * 2. Crea una clase "Aula" con:
 *    - Atributo privado: nombre (String) - ej: "Programación Java 101"
 *    - Atributo privado: estudiantes (Estudiante[]) - array de máximo 30 estudiantes
 *    - Atributo privado: cantidadEstudiantes (int) - cuántos hay actualmente
 *    - Constructor que reciba el nombre del aula (inicializa array vacío)
 *    - Método "agregarEstudiante(Estudiante est)" - agrega un estudiante al aula
 *    - Método "mostrarEstudiantes()" - muestra todos los estudiantes y sus promedios
 *    - Método "calcularPromedioAula()" - calcula el promedio general del aula
 *    - Método "contarAprobados()" - retorna cuántos estudiantes aprobaron
 *
 * 3. En el main:
 *    - Crea un aula
 *    - Crea 4 estudiantes con diferentes notas
 *    - Agrégalos al aula
 *    - Muestra todos los estudiantes
 *    - Muestra estadísticas del aula
 *
 * SALIDA ESPERADA:
 * ====== Aula: Programación Java 101 ======
 *
 * Estudiante: Juan Pérez
 *   Promedio: 5.33 - Aprobó: true
 *
 * Estudiante: María González
 *   Promedio: 6.20 - Aprobó: true
 *
 * Estudiante: Pedro López
 *   Promedio: 3.50 - Aprobó: false
 *
 * Estudiante: Ana Martínez
 *   Promedio: 5.80 - Aprobó: true
 *
 * ====== Estadísticas del Aula ======
 * Promedio General: 5.21
 * Estudiantes Aprobados: 3 de 4
 * Porcentaje de Aprobación: 75.00%
 *
 * CONCEPTOS NUEVOS:
 * - Arrays de objetos (no primitivos)
 * - Objetos que contienen otros objetos
 * - Relaciones entre clases (composición)
 * - Cálculos agregados sobre colecciones
 */

// TODO: Copia la clase Estudiante del ejercicio anterior (Ejercicio11)







// TODO: Crea la clase Aula
// La clase debe tener los atributos y métodos descritos arriba











public class Ejercicio12 {
    public static void main(String[] args) {
        // TODO: Crea un aula


        // TODO: Crea 4 estudiantes con diferentes notas





        // TODO: Agrega los estudiantes al aula





        // TODO: Muestra todos los estudiantes


        // TODO: Muestra estadísticas (promedio general, aprobados, porcentaje)




    }
}
