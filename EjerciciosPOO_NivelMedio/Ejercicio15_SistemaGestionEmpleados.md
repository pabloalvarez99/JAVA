# Ejercicio 15: Sistema de Gestion de Empleados con Singleton (Nivel 2)
**Dificultad:** Intermedio
**Tiempo estimado:** 70 minutos
**Conceptos:** Singleton Pattern, Herencia, Collections, Busqueda y Filtrado

---

## Contexto

Una empresa necesita un sistema centralizado para gestionar sus empleados. Solo debe existir UNA instancia del sistema de gestion para garantizar consistencia de datos.

---

## Requisitos

### Jerarquia de Empleados:

Todos los empleados tienen:
- ID unico (String)
- Nombre completo (String)
- Salario base (double)
- Departamento (String): "Ventas", "Desarrollo", "Administracion"

Tipos especificos:

**EmpleadoTiempoCompleto:**
- Anos de experiencia (int)
- Tiene seguro medico (boolean)
- Salario final = base + (base × 0.05 × anos experiencia)

**EmpleadoContratista:**
- Horas trabajadas en el mes (int)
- Tarifa por hora (double)
- Salario final = tarifa × horas trabajadas

**EmpleadoPasante:**
- Universidad (String)
- Semestre (int)
- Salario final = salario base (fijo, sin bonos)

### Clase SistemaGestion (SINGLETON):

Debe ser un Singleton que gestione:
- Lista de todos los empleados
- Metodos para agregar empleados
- Busqueda por ID
- Filtrado por departamento
- Calculo de nomina total
- Estadisticas

**Requisitos del Singleton:**
- Constructor privado
- Instancia estatica privada
- Metodo `getInstance()` publico estatico

---

## Funcionalidades Requeridas:

1. **agregarEmpleado(Empleado e):** Agrega empleado a la lista
2. **buscarPorID(String id):** Retorna empleado o null
3. **obtenerPorDepartamento(String depto):** Retorna lista de empleados de ese departamento
4. **calcularNominaTotal():** Suma de salarios finales de TODOS los empleados
5. **calcularNominaPorDepartamento(String depto):** Suma de salarios del departamento
6. **obtenerEmpleadoMejorPagado():** Retorna el empleado con mayor salario final
7. **mostrarEstadisticas():** Muestra resumen completo

---

## Ejemplo de Ejecucion

```
=== SISTEMA DE GESTION DE EMPLEADOS ===
Instancia del sistema creada (Singleton)

Agregando empleados...
[OK] Empleado E001 agregado: Juan Perez (Tiempo Completo - Desarrollo)
[OK] Empleado E002 agregado: Maria Gomez (Contratista - Ventas)
[OK] Empleado E003 agregado: Pedro Lopez (Pasante - Desarrollo)
[OK] Empleado E004 agregado: Ana Torres (Tiempo Completo - Administracion)
[OK] Empleado E005 agregado: Luis Martinez (Contratista - Desarrollo)

=== BUSQUEDA POR ID ===
Buscando E003:
[E003] Pedro Lopez - Pasante
  Departamento: Desarrollo
  Universidad: Universidad Tecnica
  Semestre: 6
  Salario: $400.000

=== EMPLEADOS POR DEPARTAMENTO ===

Departamento: Desarrollo (3 empleados)
1. [E001] Juan Perez - Tiempo Completo
   Experiencia: 5 anos, Seguro: SI
   Salario: $1.250.000 ($1.000.000 + $250.000 por experiencia)

2. [E003] Pedro Lopez - Pasante
   Universidad: Universidad Tecnica, Semestre: 6
   Salario: $400.000

3. [E005] Luis Martinez - Contratista
   Horas: 160h, Tarifa: $8.000/h
   Salario: $1.280.000

Departamento: Ventas (1 empleado)
1. [E002] Maria Gomez - Contratista
   Horas: 180h, Tarifa: $10.000/h
   Salario: $1.800.000

Departamento: Administracion (1 empleado)
1. [E004] Ana Torres - Tiempo Completo
   Experiencia: 3 anos, Seguro: SI
   Salario: $945.000 ($900.000 + $45.000 por experiencia)

=== NOMINA ===
Nomina Total: $5.675.000
Nomina Desarrollo: $2.930.000
Nomina Ventas: $1.800.000
Nomina Administracion: $945.000

=== EMPLEADO MEJOR PAGADO ===
[E002] Maria Gomez (Contratista - Ventas)
Salario: $1.800.000

=== ESTADISTICAS GENERALES ===
Total empleados: 5
- Tiempo Completo: 2 (40.0%)
- Contratistas: 2 (40.0%)
- Pasantes: 1 (20.0%)

Por departamento:
- Desarrollo: 3 empleados (60.0%)
- Ventas: 1 empleados (20.0%)
- Administracion: 1 empleados (20.0%)

Salario promedio: $1.135.000
Salario mas alto: $1.800.000
Salario mas bajo: $400.000
```

---

## Debe entregar:

1. **Clase abstracta Empleado** con:
   - Atributos comunes
   - Metodo abstracto: `double calcularSalarioFinal()`
   - Metodo abstracto: `String getTipo()`
   - Metodo concreto: `mostrarInfo()`

2. **3 clases concretas:**
   - EmpleadoTiempoCompleto
   - EmpleadoContratista
   - EmpleadoPasante

3. **Clase SistemaGestion (SINGLETON):**
   - Implementacion correcta del patron Singleton
   - Todos los metodos requeridos
   - Lista de empleados

4. **Clase Main** que demuestre:
   - Acceso al Singleton desde multiples lugares
   - Agregar empleados de diferentes tipos
   - Todas las funcionalidades (busqueda, filtrado, estadisticas)

---

## Consideraciones:

- DEBE ser Singleton: solo UNA instancia posible
- Constructor DEBE ser privado
- Usar herencia y polimorfismo correctamente
- Todos los empleados en una sola lista
- Calculos de salario deben ser precisos
- Manejar caso cuando no se encuentra empleado (retornar null o mensaje)
- Usar ArrayList para listas dinamicas

---

## Pistas:

1. Patron Singleton:
   ```java
   public class SistemaGestion {
       private static SistemaGestion instance;
       private List<Empleado> empleados;

       private SistemaGestion() {
           empleados = new ArrayList<>();
       }

       public static SistemaGestion getInstance() {
           if (instance == null) {
               instance = new SistemaGestion();
           }
           return instance;
       }
   }
   ```

2. Para filtrar por departamento, itera y agrega a lista temporal
3. Para encontrar mejor pagado, compara salarios finales
4. Las estadisticas requieren contar tipos (usa instanceof o metodo getTipo())

---

## Desafio Extra (Opcional):

1. Agrega metodo para aumentar salario base de todos los empleados de un departamento
2. Implementa ordenamiento de empleados por salario
3. Agrega validacion: no permitir IDs duplicados
4. Crea reporte exportable a archivo de texto

---

**NOTA:** Este es un ejercicio de PRACTICA INDEPENDIENTE. NO hay solucion incluida.
Si te atascas:
- Revisa Ejercicio 3 (Singleton basico)
- Revisa Ejercicio 1 (Herencia con multiples tipos)
- GUIA_ESTUDIO.md seccion Singleton Pattern
