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
 */

import java.util.LinkedList;
import java.util.Queue;

public class Ejercicio19 {
    // TODO: Lee las instrucciones arriba y escribe TODO el código
    // TODO: Implementa todas las clases, métodos y lógica necesaria
}
