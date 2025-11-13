/*
 * ========================================
 * EJERCICIO 18: Lista Enlazada Simple (Nodos)
 * DIFICULTAD: ⭐⭐⭐⭐⭐ (Difícil)
 * ========================================
 *
 * OBJETIVO:
 * Crear una lista enlazada simple (similar al ejercicio del metro)
 *
 * INSTRUCCIONES:
 * 1. Crea una clase "Nodo" con:
 *    - Atributo privado: valor (int)
 *    - Atributo privado: siguiente (Nodo)
 *    - Constructor que reciba el valor
 *    - Getters y setters para ambos atributos
 *
 * 2. Crea una clase "ListaEnlazada" con:
 *    - Atributo privado: cabeza (Nodo) - primer nodo de la lista
 *    - Método "agregar(int valor)" - agrega un nodo al final
 *    - Método "imprimir()" - imprime todos los valores
 *    - Método "contar()" - retorna cuántos nodos hay
 *
 * 3. En el main:
 *    - Crea una lista enlazada
 *    - Agrega los valores: 10, 20, 30, 40, 50
 *    - Imprime la lista
 *    - Muestra cuántos elementos hay
 *
 * SALIDA ESPERADA:
 * Lista: 10 -> 20 -> 30 -> 40 -> 50
 * Total de elementos: 5
 *
 * VISUALIZACIÓN:
 * cabeza -> [10|next] -> [20|next] -> [30|next] -> [40|next] -> [50|null]
 *
 */

// TODO: Crea la clase Nodo
class Nodo {
    // Atributos privados
    private int valor;
    private Nodo siguiente;

    // Constructor
    public Nodo(int valor) {
        this.valor = valor;
        this.siguiente = null;
    }

    // Getters y setters
    public int getValor() {
        return valor;
    }

    public Nodo getSiguiente() {
        return siguiente;
    }

    public void setSiguiente(Nodo siguiente) {
        this.siguiente = siguiente;
    }

    public void setValor(int valor) {
        this.valor = valor;
    }
}

// TODO: Crea la clase ListaEnlazada
class ListaEnlazada {
    // Atributo privado
    private Nodo cabeza;

    // Constructor
    public ListaEnlazada() {
        this.cabeza = null;
    }


    // Método agregar
    public void agregar(int valor) {
        Nodo nuevoNodo = new Nodo(valor);

        // Si la lista está vacía
        if (cabeza == null) {
            cabeza = ListaEnlazada.getValor(nuevoNodo);
        } else {
            // Recorrer hasta el último nodo
            


            // Agregar el nuevo nodo al final

        }
    }

    // Método imprimir
    public void imprimir() {
        System.out.print("Lista: ");
        Nodo actual = cabeza;

        // Recorrer e imprimir




        System.out.println();
    }

    // Método contar
    public int contar() {
        int contador = 0;
        // Recorre y cuenta



        return contador;
    }
}

public class Ejercicio18 {
    public static void main(String[] args) {
        // TODO: Crea una lista enlazada


        // TODO: Agrega los valores 10, 20, 30, 40, 50






        // TODO: Imprime la lista


        // TODO: Muestra el total de elementos


    }
}
