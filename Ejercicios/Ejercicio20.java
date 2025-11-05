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
 * PISTA:
 * - Importa: import java.util.HashSet; import java.util.TreeSet;
 * - Crear: HashSet<Estudiante> set = new HashSet<>();
 * - Agregar: boolean agregado = set.add(estudiante); // false si era duplicado
 * - Contiene: boolean existe = set.contains(estudiante);
 * - TreeSet ordena automáticamente Strings alfabéticamente
 */

import java.util.HashSet;
import java.util.TreeSet;
import java.util.Objects;

// TODO: Crea la clase Estudiante
class Estudiante {
    // Atributos privados
    private String id;
    private String nombre;
    private int edad;
    private double promedio;

    // Constructor
    public Estudiante(String id, String nombre, int edad, double promedio) {
        // TODO: Inicializa los atributos





    }

    // Getters
    public String getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public int getEdad() {
        return edad;
    }

    public double getPromedio() {
        return promedio;
    }

    // toString
    @Override
    public String toString() {
        return "ID: " + id + " | " + nombre + " | " + edad + " años | Promedio: " + promedio;
    }

    // IMPORTANTE: Sobrescribe equals() para comparar por ID
    @Override
    public boolean equals(Object obj) {
        // Si es el mismo objeto en memoria, son iguales
        if (this == obj) return true;

        // Si es null o de clase diferente, no son iguales
        if (obj == null || getClass() != obj.getClass()) return false;

        // Convierte a Estudiante y compara IDs
        Estudiante otro = (Estudiante) obj;
        // TODO: Retorna true si los IDs son iguales
        return false; // TEMPORAL: reemplaza con id.equals(otro.id)
    }

    // IMPORTANTE: Sobrescribe hashCode() para que sea consistente con equals()
    @Override
    public int hashCode() {
        // TODO: Retorna el hash del ID
        return 0; // TEMPORAL: reemplaza con Objects.hash(id)
    }
}

// TODO: Crea la clase GestorEstudiantes
class GestorEstudiantes {
    // Atributos privados
    private HashSet<Estudiante> estudiantes;      // Para estudiantes únicos
    private TreeSet<String> nombresOrdenados;      // Para nombres ordenados alfabéticamente

    // Constructor
    public GestorEstudiantes() {
        // TODO: Inicializa ambas colecciones


    }

    // Método agregarEstudiante
    public boolean agregarEstudiante(Estudiante estudiante) {
        // TODO: Intenta agregar al HashSet
        // boolean agregado = estudiantes.add(estudiante);

        // TODO: Si se agregó exitosamente, agrega el nombre al TreeSet
        // if (agregado) {
        //     nombresOrdenados.add(estudiante.getNombre());
        //     System.out.println("✓ Estudiante agregado: " + estudiante.getId() + " - " + estudiante.getNombre());
        // } else {
        //     System.out.println("✗ Estudiante " + estudiante.getId() + " ya existe (duplicado ignorado)");
        // }

        // return agregado;
        return false; // TEMPORAL








    }

    // Método existeEstudiante
    public boolean existeEstudiante(String id) {
        // TODO: Busca si existe un estudiante con ese ID
        // Pista: recorre el HashSet y compara IDs

        return false; // TEMPORAL


    }

    // Método obtenerEstudiante
    public Estudiante obtenerEstudiante(String id) {
        // TODO: Busca y retorna el estudiante con ese ID
        // Retorna null si no se encuentra



        return null;
    }

    // Método mostrarEstudiantes
    public void mostrarEstudiantes() {
        System.out.println("\n=== TODOS LOS ESTUDIANTES ===");
        if (estudiantes.isEmpty()) {
            System.out.println("No hay estudiantes registrados");
            return;
        }

        // TODO: Recorre e imprime cada estudiante



        System.out.println("Total: " + estudiantes.size() + " estudiantes");
    }

    // Método mostrarNombresOrdenados
    public void mostrarNombresOrdenados() {
        System.out.println("\n=== NOMBRES ORDENADOS ALFABÉTICAMENTE ===");
        // TODO: Recorre el TreeSet (ya está ordenado) e imprime cada nombre
        int posicion = 1;




    }

    // Método contarEstudiantes
    public int contarEstudiantes() {
        // TODO: Retorna el tamaño del HashSet
        return 0; // TEMPORAL
    }

    // Método estudiantesConPromedioAlto
    public void estudiantesConPromedioAlto(double minimoPromedio) {
        System.out.println("\n=== ESTUDIANTES CON PROMEDIO >= " + minimoPromedio + " ===");
        // TODO: Recorre e imprime solo estudiantes con promedio >= minimoPromedio




    }

    // Método eliminarEstudiante
    public void eliminarEstudiante(String id) {
        // TODO: Busca el estudiante

        // TODO: Si existe, elimínalo del HashSet y su nombre del TreeSet




    }
}

public class Ejercicio20 {
    public static void main(String[] args) {
        System.out.println("=== GESTIÓN DE ESTUDIANTES ===\n");

        // TODO: Crea el gestor
        GestorEstudiantes gestor = new GestorEstudiantes();

        // TODO: Agrega 5 estudiantes
        // gestor.agregarEstudiante(new Estudiante("E001", "Juan Pérez", 20, 8.5));
        // gestor.agregarEstudiante(new Estudiante("E002", "María García", 22, 9.2));
        // gestor.agregarEstudiante(new Estudiante("E003", "Ana López", 21, 9.5));
        // gestor.agregarEstudiante(new Estudiante("E004", "Carlos Rodríguez", 23, 7.8));
        // gestor.agregarEstudiante(new Estudiante("E005", "Pedro Martínez", 20, 8.9));






        // TODO: Intenta agregar un duplicado (mismo ID)
        System.out.println();
        // gestor.agregarEstudiante(new Estudiante("E002", "María García", 22, 9.2));


        // TODO: Muestra todos los estudiantes


        // TODO: Muestra los nombres ordenados


        // TODO: Busca un estudiante específico
        System.out.println("\n=== BUSCAR ESTUDIANTE: E003 ===");
        // Estudiante buscado = gestor.obtenerEstudiante("E003");
        // if (buscado != null) {
        //     System.out.println("Encontrado: " + buscado.getNombre() + " - " +
        //                        buscado.getEdad() + " años - Promedio: " + buscado.getPromedio());
        // } else {
        //     System.out.println("Estudiante no encontrado");
        // }






        // TODO: Filtra estudiantes con promedio alto


        // TODO: Elimina un estudiante
        System.out.println("\n=== ELIMINAR ESTUDIANTE E005 ===");


        System.out.println("Total restante: " + gestor.contarEstudiantes() + " estudiantes");

        // REFLEXIÓN:
        // ¿Por qué usar Set en vez de List?
        // - Garantiza unicidad automáticamente
        // - Más eficiente para búsquedas (HashSet es O(1))
        // - TreeSet mantiene orden automático sin sort()
        // - Previene errores por duplicados
        //
        // CASOS DE USO REALES:
        // - IDs únicos (usuarios, productos, documentos)
        // - Eliminar duplicados de una colección
        // - Membresías (un usuario solo puede estar una vez)
        // - Tags o etiquetas únicas
        // - Palabras únicas en un texto
        //
        // CONVERSIÓN ÚTIL:
        // List con duplicados -> Set sin duplicados:
        // ArrayList<String> listaDuplicados = new ArrayList<>();
        // HashSet<String> setSinDuplicados = new HashSet<>(listaDuplicados);
        //
        // ¿POR QUÉ equals() y hashCode()?
        // Sin ellos, Set comparará por referencia de memoria
        // Con ellos, Set compara por contenido (nuestro criterio: ID)
    }
}
