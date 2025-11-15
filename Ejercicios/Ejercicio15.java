/*
 * ========================================
 * EJERCICIO 15: Navegación entre Objetos (Referencias Bidireccionales)
 * DIFICULTAD: ⭐⭐⭐⭐⭐ (Avanzado)
 * ========================================
 *
 * OBJETIVO:
 * Practicar la navegación compleja entre objetos donde múltiples objetos
 * se referencian entre sí, creando una red de relaciones.
 *
 * CONCEPTO CLAVE:
 * REFERENCIAS BIDIRECCIONALES:
 * Empleado ↔ Departamento
 * - Un Empleado conoce su Departamento
 * - Un Departamento conoce sus Empleados
 *
 * INSTRUCCIONES:
 * 1. Crea una clase "Departamento" con:
 *    - Atributos privados: nombre (String), empleados (ArrayList<Empleado>)
 *    - Constructor que reciba el nombre
 *    - Método "agregarEmpleado(Empleado emp)" - agrega y establece la relación bidireccional
 *    - Método "calcularNominaTotal()" - suma los salarios de todos los empleados
 *    - Método "getEmpleados()" - retorna la lista de empleados
 *    - Método "getNombre()" - retorna el nombre del departamento
 *    - Método "mostrarEmpleados()" - muestra todos los empleados del departamento
 *
 * 2. Crea una clase "Empleado" con:
 *    - Atributos privados: nombre (String), salario (double), departamento (Departamento)
 *    - Constructor que reciba nombre y salario (departamento empieza en null)
 *    - Getters para todos los atributos
 *    - Método "setDepartamento(Departamento dept)" - establece el departamento
 *    - Método "cambiarDepartamento(Departamento nuevoDept)" - cambia de departamento
 *    - Método "aumentarSalario(double porcentaje)" - aumenta el salario (ej: 10 = 10%)
 *    - Método "mostrarInfo()" - muestra nombre, salario y departamento
 *
 * 3. Crea una clase "Empresa" con:
 *    - Atributo privado: departamentos (ArrayList<Departamento>)
 *    - Constructor sin parámetros
 *    - Método "agregarDepartamento(Departamento dept)"
 *    - Método "buscarEmpleado(String nombre)" - busca en todos los departamentos
 *    - Método "calcularNominaTotal()" - suma la nómina de todos los departamentos
 *    - Método "departamentoConMasEmpleados()" - retorna el departamento más grande
 *    - Método "mostrarEstructura()" - muestra todos los departamentos y sus empleados
 *
 * 4. En el main:
 *    - Crea una empresa
 *    - Crea 3 departamentos (IT, Ventas, RRHH)
 *    - Crea 7 empleados y asígnalos a diferentes departamentos
 *    - Muestra la estructura de la empresa
 *    - Realiza cambios de departamento
 *    - Aumenta salarios
 *    - Muestra estadísticas
 *
 * CONCEPTOS NUEVOS:
 * - Referencias bidireccionales (A conoce a B, B conoce a A)
 * - Uso de "this" para referirse al objeto actual
 * - Navegación compleja entre múltiples niveles
 * - Sincronización de relaciones (mantener consistencia)
 * - Búsqueda en estructuras anidadas
 */

import java.util.ArrayList;

// TODO: Crea la clase Departamento








// TODO: Crea la clase Empleado









// TODO: Crea la clase Empresa









public class Ejercicio15 {
   public static void main(String[] args) {
      // TODO: Crea una empresa y 3 departamentos



      // TODO: Crea 7 empleados y asígnalos a departamentos




      // TODO: Muestra la estructura de la empresa


      // TODO: Realiza cambios de departamento y aumentos de salario



      // TODO: Muestra estadísticas de la empresa



   }
}
