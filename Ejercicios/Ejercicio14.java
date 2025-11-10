/*
 * ========================================
 * EJERCICIO 14: Introducción a ArrayList (Listas Dinámicas)
 * DIFICULTAD: ⭐⭐⭐⭐⭐ (Avanzado)
 * ========================================
 *
 * OBJETIVO:
 * Aprender a usar ArrayList, la estructura de datos más común en Java.
 * ArrayList es una lista dinámica que crece automáticamente.
 *
 * CONCEPTO CLAVE:
 * ARRAYS VS ARRAYLIST:
 *
 * Arrays normales (int[], String[], etc.):
 *   ✓ Tamaño FIJO - debes definirlo al crear: new int[10]
 *   ✓ Rápido acceso por índice
 *   ✗ No puedes cambiar el tamaño después
 *   ✗ Debes manejar manualmente cuántos elementos usas
 *
 * ArrayList<T>:
 *   ✓ Tamaño DINÁMICO - crece automáticamente
 *   ✓ Métodos útiles: add(), remove(), get(), size()
 *   ✓ Más fácil de usar para colecciones que cambian
 *   ✗ Solo puede almacenar OBJETOS (no primitivos directos)
 *   ✗ Ligeramente más lento que arrays normales
 *
 * INSTRUCCIONES:
 * 1. Importa ArrayList: import java.util.ArrayList;
 *
 * 2. Crea una clase "Tarea" con:
 *    - Atributos privados: descripcion (String), completada (boolean)
 *    - Constructor que reciba la descripción (completada empieza en false)
 *    - Getter para descripcion
 *    - Getter para completada
 *    - Método "completar()" - marca la tarea como completada
 *    - Método "toString()" - retorna "[X] descripcion" si está completada, "[ ] descripcion" si no
 *
 * 3. Crea una clase "ListaTareas" con:
 *    - Atributo privado: tareas (ArrayList<Tarea>)
 *    - Constructor sin parámetros (inicializa el ArrayList vacío)
 *    - Método "agregarTarea(String descripcion)" - crea y agrega una nueva tarea
 *    - Método "completarTarea(int indice)" - marca la tarea en ese índice como completada
 *    - Método "eliminarTarea(int indice)" - elimina la tarea en ese índice
 *    - Método "mostrarTareas()" - muestra todas las tareas con su índice
 *    - Método "cantidadPendientes()" - retorna cuántas tareas NO están completadas
 *    - Método "limpiarCompletadas()" - elimina todas las tareas completadas
 *
 * 4. En el main:
 *    - Crea una lista de tareas
 *    - Agrega 5 tareas
 *    - Completa algunas tareas
 *    - Muestra la lista
 *    - Muestra estadísticas
 *    - Limpia las completadas
 *    - Muestra la lista nuevamente
 *
 * SALIDA ESPERADA:
 * ====== Mi Lista de Tareas ======
 * 0. [ ] Estudiar POO en Java
 * 1. [X] Completar Ejercicio 13
 * 2. [ ] Leer documentación de ArrayList
 * 3. [X] Practicar con objetos
 * 4. [ ] Hacer proyecto final
 *
 * Tareas pendientes: 3 de 5
 *
 * ====== Limpiando tareas completadas... ======
 *
 * ====== Lista Actualizada ======
 * 0. [ ] Estudiar POO en Java
 * 1. [ ] Leer documentación de ArrayList
 * 2. [ ] Hacer proyecto final
 *
 * Tareas pendientes: 3 de 3
 *
 * PISTAS:
 * - Crear ArrayList: ArrayList<Tarea> tareas = new ArrayList<>();
 * - Agregar: tareas.add(nuevaTarea);
 * - Obtener: tareas.get(indice);
 * - Tamaño: tareas.size();
 * - Eliminar: tareas.remove(indice);
 * - Para eliminar múltiples, recorre de ATRÁS hacia ADELANTE:
 *   for (int i = tareas.size() - 1; i >= 0; i--)
 *
 * CONCEPTOS NUEVOS:
 * - ArrayList<T> (colección dinámica)
 * - Genéricos básicos: <Tarea>
 * - Importar clases: import java.util.ArrayList
 * - Métodos de ArrayList: add(), get(), remove(), size()
 * - Recorrido inverso para eliminar durante iteración
 */

import java.util.ArrayList;

// TODO: Crea la clase Tarea
class Tarea {
    // TODO: Atributos privados
    private String descripcion;
    private boolean completada = false;
    // TODO: Constructor
    public Tarea(String descripcion) {
        this.descripcion = descripcion;
    }
    // TODO: Getters
    public String getDescripcion() {
        return descripcion;
    }
    public boolean getCompletada() {
        return completada;
    }
    // TODO: Método completar()
    public void completar() {
        this.completada = true;
    }

    // TODO: Método toString()
    public String toString() {
        if (completada) {
            return "[X] " + descripcion;
        } else {return "[ ] " + descripcion;}
    }
}
// TODO: Crea la clase ListaTareas
class ListaTareas {
    // TODO: Atributo privado (ArrayList<Tarea>)
    private ArrayList<Tarea> tareas;

    // TODO: Constructor
    public ListaTareas() {
        this.tareas = new ArrayList<>();
    } 

    // TODO: Método agregarTarea
    public void agregarTarea(String descripcion) {
        Tarea tarea = new Tarea(descripcion);
        this.tareas.add(tarea);
    }
    // TODO: Método completarTarea
    public void completarTarea(int indice) {
        this.tareas.get(indice).completar();
    }
    // TODO: Método eliminarTarea
    public void eliminarTarea(int indice) {
        this.tareas.remove(indice);
    }
    // TODO: Método mostrarTareas
    public void mostrarTareas() {
        for (int i = 0; i < tareas.size(); i++) {
            System.out.println(i + ". " + this.tareas.get(i).toString());
        }
    }
    // TODO: Método cantidadPendientes
    public int cantidadPendientes() {
        int pendientes = 0;
        for(int i = 0; i < this.tareas.size(); i++) {
            if (this.tareas.get(i).getCompletada() == false) {
                pendientes++;
            }
        }
        return pendientes;
    }

    // TODO: Método limpiarCompletadas
    // PISTA: Recorre de atrás hacia adelante
    public void limpiarCompletadas() {
        for (int i = tareas.size()-1; i < 0; i--) {
            if (!tareas.get(i).getCompletada()) {
                tareas.eliminarTarea(i);
            }
        }
    }
}

public class Ejercicio14 {
    public static void main(String[] args) {
        // TODO: Crea una lista de tareas


        // TODO: Agrega 5 tareas




        // TODO: Completa algunas tareas (índices 1 y 3)


        // TODO: Muestra la lista


        // TODO: Muestra estadísticas


        // TODO: Limpia las completadas


        // TODO: Muestra la lista actualizada

    }
}

/*
 * ========================================
 * REFLEXIÓN Y PROFUNDIZACIÓN
 * ========================================
 *
 * ¿POR QUÉ ARRAYLIST ES TAN IMPORTANTE?
 *
 * 1. TAMAÑO DINÁMICO:
 *    Con arrays normales:
 *      String[] nombres = new String[10]; // ¿Qué pasa si necesitas 11?
 *
 *    Con ArrayList:
 *      ArrayList<String> nombres = new ArrayList<>();
 *      nombres.add("Juan");  // Se agranda automáticamente
 *      nombres.add("María"); // Sin límite (hasta memoria disponible)
 *
 * 2. MÉTODOS ÚTILES:
 *    ArrayList viene con muchos métodos útiles:
 *    - add(elemento) - agrega al final
 *    - add(indice, elemento) - inserta en posición específica
 *    - get(indice) - obtiene elemento
 *    - set(indice, elemento) - reemplaza elemento
 *    - remove(indice) - elimina por índice
 *    - remove(objeto) - elimina por valor
 *    - size() - cantidad de elementos
 *    - clear() - vacía la lista
 *    - contains(elemento) - verifica si existe
 *    - indexOf(elemento) - encuentra la posición
 *
 * 3. GENERICS <T>:
 *    ArrayList<Tarea> significa "una lista que solo contiene objetos Tarea"
 *    El compilador verifica que no agregues tipos incorrectos:
 *
 *    ArrayList<Tarea> tareas = new ArrayList<>();
 *    tareas.add(new Tarea("Estudiar"));  // ✓ OK
 *    tareas.add("Hola");                 // ✗ ERROR de compilación!
 *
 * 4. AUTOBOXING:
 *    Para primitivos, usa las clases wrapper:
 *    ArrayList<Integer> numeros = new ArrayList<>();  // int → Integer
 *    ArrayList<Double> precios = new ArrayList<>();   // double → Double
 *    ArrayList<Boolean> flags = new ArrayList<>();    // boolean → Boolean
 *
 * 5. IMPLEMENTACIÓN INTERNA:
 *    ArrayList usa un array interno que se redimensiona automáticamente:
 *    - Empieza con capacidad inicial (ej: 10 elementos)
 *    - Cuando se llena, crea un array más grande (1.5x el tamaño)
 *    - Copia todos los elementos al nuevo array
 *    - Por eso add() es O(1) en promedio, pero ocasionalmente O(n)
 *
 * CASOS DE USO EN EL MUNDO REAL:
 *
 * 1. LISTA DE PRODUCTOS EN CARRITO:
 *    class CarritoCompras {
 *        private ArrayList<Producto> productos;
 *
 *        public void agregarProducto(Producto p) {
 *            productos.add(p);
 *        }
 *    }
 *
 * 2. HISTORIAL DE NAVEGACIÓN:
 *    class Navegador {
 *        private ArrayList<String> historial;
 *
 *        public void visitarPagina(String url) {
 *            historial.add(url);
 *        }
 *    }
 *
 * 3. LISTA DE CONTACTOS:
 *    class Telefono {
 *        private ArrayList<Contacto> contactos;
 *
 *        public void agregarContacto(Contacto c) {
 *            contactos.add(c);
 *        }
 *    }
 *
 * ¿CUÁNDO USAR ARRAY VS ARRAYLIST?
 *
 * USA ARRAY NORMAL (int[], String[]) SI:
 * - Conoces el tamaño exacto de antemano
 * - Necesitas máximo rendimiento
 * - Trabajas con primitivos en bucles intensivos
 *
 * USA ARRAYLIST SI:
 * - El tamaño puede cambiar
 * - Necesitas agregar/eliminar elementos frecuentemente
 * - Prefieres código más limpio y legible
 * - Trabajas con objetos
 *
 * ERROR COMÚN: MODIFICAR DURANTE ITERACIÓN
 * ✗ INCORRECTO:
 *   for (int i = 0; i < lista.size(); i++) {
 *       lista.remove(i); // Los índices cambian!
 *   }
 *
 * ✓ CORRECTO (recorrer al revés):
 *   for (int i = lista.size() - 1; i >= 0; i--) {
 *       lista.remove(i); // Safe!
 *   }
 *
 * SIGUIENTE PASO:
 * Ahora que conoces ArrayList, estás listo para estructuras más
 * avanzadas como LinkedList, HashMap, y finalmente, implementar
 * tu propia lista enlazada con Nodos!
 */
