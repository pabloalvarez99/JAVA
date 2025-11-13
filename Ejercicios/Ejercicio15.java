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
 * Hasta ahora has visto relaciones unidireccionales:
 *   Libro → Autor (el libro conoce a su autor)
 *
 * Pero en el mundo real, las relaciones suelen ser bidireccionales:
 *   Empleado ↔ Departamento
 *   - Un Empleado conoce su Departamento
 *   - Un Departamento conoce sus Empleados
 *
 * Esto permite navegar en ambas direcciones:
 *   empleado.getDepartamento().getNombre()
 *   departamento.getEmpleados().get(0).getNombre()
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
 * SALIDA ESPERADA:
 * ====== Empresa TechCorp ======
 *
 * Departamento: IT
 *   - Juan Pérez ($3500.00)
 *   - María González ($3800.00)
 *   - Pedro López ($3200.00)
 *   Nómina Departamental: $10500.00
 *
 * Departamento: Ventas
 *   - Ana Martínez ($2800.00)
 *   - Luis Rodríguez ($2600.00)
 *   Nómina Departamental: $5400.00
 *
 * Departamento: RRHH
 *   - Carmen Silva ($3000.00)
 *   - Roberto Díaz ($2900.00)
 *   Nómina Departamental: $5900.00
 *
 * ====== Estadísticas ======
 * Nómina Total Empresa: $21800.00
 * Departamento más grande: IT (3 empleados)
 *
 * ====== Realizando cambios... ======
 * María González se traslada de IT a Ventas
 * Aumentando salarios del departamento Ventas en 15%
 *
 * ====== Estructura Actualizada ======
 * [Muestra la nueva estructura]
 *
 * CONCEPTOS NUEVOS:
 * - Referencias bidireccionales (A conoce a B, B conoce a A)
 * - Uso de "this" para referirse al objeto actual
 * - Navegación compleja entre múltiples niveles
 * - Sincronización de relaciones (mantener consistencia)
 * - Búsqueda en estructuras anidadas
 */

/*
 * ========================================
 * REFLEXIÓN Y PROFUNDIZACIÓN
 * ========================================
 *
 * ¿QUÉ ES LO COMPLEJO DE ESTE EJERCICIO?
 *
 * 1. RELACIONES BIDIRECCIONALES:
 *    Empleado → Departamento (empleado.getDepartamento())
 *    Departamento → Empleado (departamento.getEmpleados())
 *
 *    El RETO: mantener la CONSISTENCIA de ambos lados.
 *    Si agregas un empleado a un departamento, debes:
 *      a) Agregar el empleado a la lista del departamento
 *      b) Actualizar el departamento del empleado
 *
 *    Si olvidas uno de los dos, la relación queda INCONSISTENTE.
 *
 * 2. KEYWORD "this":
 *    En agregarEmpleado():
 *      empleados.add(emp);
 *      emp.setDepartamento(this); // "this" = el departamento actual
 *
 *    "this" es una referencia al objeto actual. Permite que un objeto
 *    se pase a sí mismo como parámetro.
 *
 * 3. CAMBIAR RELACIONES:
 *    cambiarDepartamento() es complejo porque debe:
 *      1. Eliminar el empleado del departamento antiguo
 *      2. Agregar el empleado al nuevo departamento
 *      3. Actualizar la referencia en el empleado
 *
 *    CUIDADO: ¿Qué pasa si el empleado no tiene departamento actual?
 *    Debes validar: if (departamento != null) { ... }
 *
 * 4. NAVEGACIÓN PROFUNDA:
 *    empresa.getDepartamentos().get(0).getEmpleados().get(0).getNombre()
 *         ↓              ↓                ↓             ↓          ↓
 *      Empresa → List<Dept> → Dept → List<Emp> → Emp → String
 *
 *    Cada paso puede retornar null. En producción, siempre valida:
 *    if (dept != null && dept.getEmpleados() != null && !dept.getEmpleados().isEmpty())
 *
 * CASOS DE USO EN EL MUNDO REAL:
 *
 * 1. RED SOCIAL:
 *    Usuario ↔ Usuario (amigos)
 *    - usuario.getAmigos() retorna lista de amigos
 *    - amigo.getAmigos() incluye al usuario original
 *    - Debe ser bidireccional: si A es amigo de B, B es amigo de A
 *
 * 2. SISTEMA DE CURSOS:
 *    Estudiante ↔ Curso
 *    - estudiante.getCursos() retorna cursos inscritos
 *    - curso.getEstudiantes() retorna estudiantes inscritos
 *    - Inscribir: agregar en ambas direcciones
 *
 * 3. E-COMMERCE:
 *    Producto ↔ Categoría
 *    - producto.getCategoria()
 *    - categoria.getProductos()
 *
 * 4. PROYECTOS DE SOFTWARE:
 *    Desarrollador ↔ Proyecto
 *    - desarrollador.getProyectos()
 *    - proyecto.getDesarrolladores()
 *
 * PATRONES DE DISEÑO RELACIONADOS:
 *
 * 1. OBSERVER PATTERN:
 *    Cuando A cambia, B debe ser notificado automáticamente.
 *    Relaciones bidireccionales son la base de este patrón.
 *
 * 2. MEDIATOR PATTERN:
 *    Cuando las relaciones bidireccionales se vuelven muy complejas,
 *    un "mediador" coordina todas las interacciones.
 *
 * ERRORES COMUNES:
 *
 * 1. CICLOS INFINITOS EN toString():
 *    Si Empleado.toString() llama a Departamento.toString()
 *    Y Departamento.toString() llama a Empleado.toString()
 *    → Stack Overflow!
 *
 *    SOLUCIÓN: No incluir la referencia circular completa en toString()
 *
 * 2. MEMORY LEAKS:
 *    Si eliminas un empleado pero no lo quitas de su departamento,
 *    el empleado sigue en memoria (el departamento lo referencia).
 *
 * 3. INCONSISTENCIA:
 *    emp.setDepartamento(dept) pero NO dept.agregarEmpleado(emp)
 *    → El empleado cree que está en el departamento
 *    → El departamento no sabe que el empleado existe
 *
 * MEJORES PRÁCTICAS:
 *
 * 1. Encapsular la lógica de relaciones en métodos específicos
 *    (agregarEmpleado, cambiarDepartamento) en lugar de setters simples.
 *
 * 2. Validar siempre null antes de navegar.
 *
 * 3. Documentar claramente qué lado de la relación es "dueño".
 *
 * 4. Considerar usar Collections.unmodifiableList() para getters
 *    que retornan listas internas (evita modificaciones externas).
 *
 * SIGUIENTE NIVEL:
 * Ahora estás listo para estructuras más complejas como:
 * - Árboles (padre ↔ hijos)
 * - Grafos (nodo ↔ nodos conectados)
 * - Listas enlazadas (nodo ↔ siguiente nodo)
*/
import java.util.ArrayList;

class Departamento {
   // Atributos
   private String nombre;
   private ArrayList<Empleado> empleados = new ArrayList<>();

   // Constructor
   public Departamento(String nombre) {
      this.nombre = nombre;
      empleados = new ArrayList<>();
   }

   // Agregar Empleado
   public void agregarEmpleado(Empleado emp) {
      empleados.add(emp);
   }

   // Salario total
   public double calcularNominaTotal() {
      double sumaTotal = 0;
      for (int i = 0; i < empleados.size(); i++) {
         sumaTotal += empleados.get(i).getSalario();
      }
      return sumaTotal;
   }
   // Getters
   public ArrayList<Empleado> getEmpleados() {
      return empleados;
   }
   public String getNombre() {
      return nombre;
   }
   public void mostrarEmpleados() {
      for (int i = 0; i < empleados.size(); i++) {
         System.out.println("Departamento: " + nombre);
         empleados.get(i).mostrarInfo();
      }
   } 
}

class Empleado {
   // Atributos
   private String nombre;
   private double salario;
   private Departamento departamento;

   // Constructor
   public Empleado(String nombre, double salario) {
      this.nombre = nombre;
      this.salario = salario;
      departamento = null;
   }
   // Getters
   public double getSalario() {
      return salario;
   }
   public String getNombre() {
      return nombre;
   }
   // Metodos
   public void setDepartamento(Departamento dept) {
      departamento = dept;
   }
   public void cambiarDepartamento(Departamento nuevoDept) {
      departamento = nuevoDept;
   }
   public void aumentarSalario(double porcentaje) {
      salario += (salario * porcentaje);
   }
   public void mostrarInfo() {
      System.out.println(" - " + nombre + " ($" + salario + ")");
   }
}

class Empresa {
   private String nombre;
   private ArrayList<Departamento> departamentos = new ArrayList<>();

   public Empresa() {
      this.nombre = nombre;
      this.departamentos = new ArrayList<>();
   }

   public void agregarDepartamento(Departamento dept) {
      departamentos.add(dept);
   }
   public double calcularNominaTotal() {
      double nominaTotal = 0;
      for (int i = 0; i < departamentos.size(); i++) {  
         nominaTotal += departamentos.get(i).calcularNominaTotal();
      }
      return nominaTotal;
   }

   public Departamento departamentoConMasEmpleados() {
      int masEmpleados = -1;
      Departamento deptMasEmp = new Departamento(null);
      for (int i = 0; i < departamentos.size();i++) {
         if (departamentos.size() >= masEmpleados ) {
            masEmpleados = departamentos.size();
            deptMasEmp = departamentos.get(i);
         }
      }
      return deptMasEmp;
   }
   public void mostrarEstructura() {
      for (int i = 0; i < departamentos.size(); i++) {
         System.out.println("====== " + nombre + " ======");
      }
   }
}
public class Ejercicio15 {
   public static void main(String[] args) {
      System.out.println("hola");
   }
}