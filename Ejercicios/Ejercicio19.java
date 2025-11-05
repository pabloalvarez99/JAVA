/*
 * ========================================
 * EJERCICIO 19: LinkedList y Queue - Sistema de Turnos
 * DIFICULTAD: ⭐⭐⭐⭐⭐⭐⭐ (Muy Difícil+)
 * ========================================
 *
 * OBJETIVO:
 * Aprender sobre LINKEDLIST y QUEUE (cola) - estructuras de datos dinámicas
 *
 * CONCEPTO CLAVE:
 * - LinkedList: Lista enlazada donde cada elemento apunta al siguiente
 * - Queue (Cola): Estructura FIFO (First In, First Out) - el primero en entrar es el primero en salir
 *
 * ANALOGÍA:
 * - Queue es como una fila en el banco: el primero en llegar es el primero en ser atendido
 * - LinkedList es como una cadena: cada eslabón está conectado al siguiente
 *
 * DIFERENCIA: ArrayList vs LinkedList
 * - ArrayList: Basado en array, acceso rápido por índice, lento para insertar/eliminar al inicio
 * - LinkedList: Basado en nodos enlazados, rápido para insertar/eliminar, lento para acceso aleatorio
 *
 * OPERACIONES DE QUEUE:
 * - offer(elemento): Agrega al final de la cola
 * - poll(): Remueve y retorna el primero de la cola (o null si está vacía)
 * - peek(): Consulta el primero sin removerlo (o null si está vacía)
 * - isEmpty(): Verifica si la cola está vacía
 *
 * INSTRUCCIONES:
 * 1. Crea una clase "Cliente" con:
 *    - Atributos privados: nombre (String), numeroTicket (int), tipoServicio (String)
 *    - Constructor que reciba todos los atributos
 *    - Getters para todos los atributos
 *    - toString() que retorne la información formateada
 *
 * 2. Crea una clase "SistemaTurnos" con:
 *    - Atributos privados:
 *      * Queue<Cliente> colaEspera (usa LinkedList como implementación)
 *      * LinkedList<Cliente> clientesAtendidos
 *      * int siguienteTicket (empieza en 1)
 *    - Constructor que inicialice las colecciones y el contador
 *    - Método "agregarCliente(String nombre, String tipoServicio)"
 *      - Crea un cliente con el siguiente ticket disponible
 *      - Lo agrega a la cola
 *      - Incrementa el contador de tickets
 *    - Método "atenderSiguiente()"
 *      - Remueve el primer cliente de la cola
 *      - Lo agrega a clientesAtendidos
 *      - Muestra mensaje de atención
 *    - Método "verSiguiente()" - muestra el siguiente sin removerlo
 *    - Método "mostrarCola()" - muestra todos los clientes en espera
 *    - Método "mostrarAtendidos()" - muestra todos los clientes atendidos
 *    - Método "cantidadEnEspera()" - retorna el tamaño de la cola
 *    - Método "buscarEnCola(int numeroTicket)" - busca un cliente en la cola
 *
 * 3. En el main:
 *    - Crea un sistema de turnos
 *    - Agrega 6 clientes con diferentes servicios
 *    - Muestra la cola completa
 *    - Atiende a 3 clientes
 *    - Muestra el siguiente sin atenderlo
 *    - Muestra los clientes atendidos
 *    - Agrega 2 clientes más
 *    - Busca un cliente por ticket
 *    - Atiende a todos los restantes
 *
 * SALIDA ESPERADA:
 * === SISTEMA DE TURNOS ===
 *
 * Cliente agregado: María (Ticket #1) - Consulta General
 * Cliente agregado: Juan (Ticket #2) - Retiro
 * ...
 *
 * === COLA DE ESPERA ===
 * 1. Ticket #1: María - Consulta General
 * 2. Ticket #2: Juan - Retiro
 * ...
 * Total en espera: 6
 *
 * === ATENDIENDO CLIENTES ===
 * ATENDIENDO -> Ticket #1: María - Consulta General
 * ATENDIENDO -> Ticket #2: Juan - Retiro
 * ATENDIENDO -> Ticket #3: Ana - Depósito
 *
 * === SIGUIENTE EN LA COLA ===
 * Próximo: Ticket #4: Carlos - Transferencia
 *
 * === CLIENTES ATENDIDOS ===
 * 1. Ticket #1: María - Consulta General
 * 2. Ticket #2: Juan - Retiro
 * 3. Ticket #3: Ana - Depósito
 *
 * CONCEPTOS NUEVOS:
 * - LinkedList<E>: Lista doblemente enlazada
 * - Queue<E>: Interface para estructuras de cola (FIFO)
 * - offer(e): Agrega elemento al final
 * - poll(): Remueve y retorna el primero
 * - peek(): Consulta el primero sin remover
 * - FIFO: First In First Out
 *
 * CUANDO USAR CADA ESTRUCTURA:
 * - ArrayList: Acceso frecuente por índice, pocos inserts/deletes
 * - LinkedList: Muchos inserts/deletes al inicio/final, poco acceso aleatorio
 * - Queue: Procesamiento en orden de llegada (FIFO)
 * - Stack: Procesamiento en orden inverso (LIFO - Last In First Out)
 *
 * PISTA:
 * - Importa: import java.util.LinkedList; import java.util.Queue;
 * - Crear Queue: Queue<Cliente> cola = new LinkedList<>();
 * - Crear LinkedList: LinkedList<Cliente> lista = new LinkedList<>();
 * - Agregar a Queue: cola.offer(cliente);
 * - Atender (remover): Cliente c = cola.poll();
 * - Ver siguiente: Cliente c = cola.peek();
 */

import java.util.LinkedList;
import java.util.Queue;

// TODO: Crea la clase Cliente
class Cliente {
    // Atributos privados
    private String nombre;
    private int numeroTicket;
    private String tipoServicio;

    // Constructor
    public Cliente(String nombre, int numeroTicket, String tipoServicio) {
        // TODO: Inicializa los atributos




    }

    // Getters
    public String getNombre() {
        return nombre;
    }

    public int getNumeroTicket() {
        return numeroTicket;
    }

    public String getTipoServicio() {
        return tipoServicio;
    }

    // toString
    @Override
    public String toString() {
        return "Ticket #" + numeroTicket + ": " + nombre + " - " + tipoServicio;
    }
}

// TODO: Crea la clase SistemaTurnos
class SistemaTurnos {
    // Atributos privados
    private Queue<Cliente> colaEspera;           // Cola FIFO para clientes en espera
    private LinkedList<Cliente> clientesAtendidos;  // Lista de clientes ya atendidos
    private int siguienteTicket;                 // Contador de tickets

    // Constructor
    public SistemaTurnos() {
        // TODO: Inicializa las colecciones
        // colaEspera = new LinkedList<>();  (LinkedList implementa Queue)
        // clientesAtendidos = new LinkedList<>();
        // siguienteTicket = 1;




    }

    // Método agregarCliente
    public void agregarCliente(String nombre, String tipoServicio) {
        // TODO: Crea un cliente con el ticket actual
        // Cliente cliente = new Cliente(nombre, siguienteTicket, tipoServicio);

        // TODO: Agrega el cliente a la cola usando offer()

        // TODO: Incrementa siguienteTicket

        // Mensaje de confirmación
        // System.out.println("Cliente agregado: " + nombre + " (Ticket #" + (siguienteTicket - 1) + ") - " + tipoServicio);





    }

    // Método atenderSiguiente
    public void atenderSiguiente() {
        // TODO: Verifica si la cola está vacía
        if (colaEspera.isEmpty()) {
            System.out.println("No hay clientes en espera");
            return;
        }

        // TODO: Remueve el primer cliente usando poll()

        // TODO: Agrégalo a clientesAtendidos

        // TODO: Muestra mensaje
        // System.out.println("ATENDIENDO -> " + cliente);




    }

    // Método verSiguiente
    public void verSiguiente() {
        // TODO: Usa peek() para ver el siguiente sin removerlo
        Cliente siguiente = null; // TEMPORAL

        if (siguiente != null) {
            System.out.println("Próximo: " + siguiente);
        } else {
            System.out.println("No hay clientes en espera");
        }
    }

    // Método mostrarCola
    public void mostrarCola() {
        System.out.println("\n=== COLA DE ESPERA ===");
        if (colaEspera.isEmpty()) {
            System.out.println("No hay clientes en espera");
            return;
        }

        // TODO: Recorre la cola e imprime cada cliente
        int posicion = 1;
        // for (Cliente cliente : colaEspera) {
        //     System.out.println(posicion + ". " + cliente);
        //     posicion++;
        // }




        System.out.println("Total en espera: " + colaEspera.size());
    }

    // Método mostrarAtendidos
    public void mostrarAtendidos() {
        System.out.println("\n=== CLIENTES ATENDIDOS ===");
        if (clientesAtendidos.isEmpty()) {
            System.out.println("Aún no se han atendido clientes");
            return;
        }

        // TODO: Recorre clientesAtendidos e imprime cada uno
        int posicion = 1;




    }

    // Método cantidadEnEspera
    public int cantidadEnEspera() {
        // TODO: Retorna el tamaño de la cola
        return 0; // TEMPORAL
    }

    // Método buscarEnCola
    public Cliente buscarEnCola(int numeroTicket) {
        // TODO: Recorre la cola y busca el cliente con ese ticket
        // Retorna el cliente o null si no se encuentra


        return null;
    }
}

public class Ejercicio19 {
    public static void main(String[] args) {
        System.out.println("=== SISTEMA DE TURNOS ===\n");

        // TODO: Crea el sistema de turnos
        SistemaTurnos sistema = new SistemaTurnos();

        // TODO: Agrega 6 clientes
        // sistema.agregarCliente("María", "Consulta General");
        // sistema.agregarCliente("Juan", "Retiro");
        // sistema.agregarCliente("Ana", "Depósito");
        // sistema.agregarCliente("Carlos", "Transferencia");
        // sistema.agregarCliente("Laura", "Consulta General");
        // sistema.agregarCliente("Pedro", "Apertura de Cuenta");







        // TODO: Muestra la cola completa


        // TODO: Atiende a 3 clientes
        System.out.println("\n=== ATENDIENDO CLIENTES ===");




        // TODO: Muestra el siguiente sin atenderlo
        System.out.println("\n=== SIGUIENTE EN LA COLA ===");


        // TODO: Muestra los clientes atendidos


        // TODO: Agrega 2 clientes más
        System.out.println("\n=== NUEVOS CLIENTES ===");



        // TODO: Busca un cliente por ticket
        System.out.println("\n=== BUSCAR CLIENTE ===");
        // Cliente buscado = sistema.buscarEnCola(5);
        // if (buscado != null) {
        //     System.out.println("Cliente encontrado: " + buscado);
        // } else {
        //     System.out.println("Cliente no encontrado en la cola");
        // }




        // TODO: Atiende a todos los restantes
        System.out.println("\n=== ATENDIENDO RESTANTES ===");
        // while (sistema.cantidadEnEspera() > 0) {
        //     sistema.atenderSiguiente();
        // }



        // Mostrar resumen final


        // REFLEXIÓN:
        // ¿Por qué Queue es perfecta para este caso?
        // - Garantiza orden de atención (FIFO)
        // - Operaciones eficientes en ambos extremos
        // - Semántica clara: offer (agregar), poll (atender), peek (consultar)
        //
        // APLICACIONES REALES DE QUEUE:
        // - Sistemas de turnos (bancos, hospitales, call centers)
        // - Procesamiento de tareas en orden de llegada
        // - Buffer de impresión (print queue)
        // - Manejo de eventos en interfaces gráficas
        // - Algoritmos de búsqueda (BFS - Breadth First Search)
        //
        // LinkedList vs ArrayList para Queue:
        // - LinkedList: Mejor para Queue (inserts/deletes eficientes)
        // - ArrayList: No es ideal para Queue (costoso remover del inicio)
    }
}
