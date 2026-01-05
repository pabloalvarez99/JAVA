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
 * CONCEPTOS NUEVOS:
 * - ArrayList<T> (colección dinámica)
 * - Genéricos básicos: <Tarea>
 * - Importar clases: import java.util.ArrayList
 * - Métodos de ArrayList: add(), get(), remove(), size()
 * - Recorrido inverso para eliminar durante iteración
 */





import java.util.ArrayList;
class Tarea {
    private String descripcion;
    private boolean completada;
    public Tarea(String descripcion) {
        this.descripcion = descripcion;
        this.completada = false;
    }
    public String getDescripcion() {return descripcion;}
    public boolean getCompletada() {return completada;}
    public void completar() {
        completada = true;
    }
    public String toString() {
        if (completada == true) {
            return "[X] " + descripcion;
        } else {
            return "[ ] " + descripcion;
        }
    }
}
class ListaTareas {
    private ArrayList<Tarea> tareas;
    public ListaTareas() {
        tareas = new ArrayList<>();
    }
    public void agregarTarea(String descripcion) {
        Tarea tarea = new Tarea(descripcion);
        tareas.add(tarea);
    }
    public void completarTarea(int indice) {
        tareas.get(indice).completar();
    }
    public void eliminarTarea(int indice) {
        tareas.remove(indice);
    }
    public void mostrarTareas() {
        for (int i = 0; i < tareas.size(); i ++) {
            System.out.println(tareas.get(i).toString());
        }
    }
    public void cantidadPendientes() {
        int cantidadPendientes = 0;
        for (int i = 0; i < tareas.size(); i++) {
            
        }
    }
}
