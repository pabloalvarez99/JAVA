/*
 * ========================================
 * EJERCICIO 15: Interfaces - Dispositivos Electrónicos
 * DIFICULTAD: ⭐⭐⭐⭐⭐ (Difícil)
 * ========================================
 *
 * OBJETIVO:
 * Aprender sobre INTERFACES - contratos que las clases deben cumplir
 *
 * CONCEPTO CLAVE:
 * Una interface define QUÉ debe hacer una clase, pero no CÓMO lo hace.
 * Es como un contrato: "Si implementas esta interface, debes tener estos métodos"
 *
 * DIFERENCIA entre Interface y Clase Abstracta:
 * - Interface: Solo define métodos (qué hacer) - "puede hacer esto"
 * - Clase Abstracta: Puede tener atributos y métodos implementados - "es un tipo de esto"
 * - Una clase puede implementar MÚLTIPLES interfaces pero solo extender UNA clase
 *
 * INSTRUCCIONES:
 * 1. Crea una interface "Encendible" con:
 *    - Método "encender()"
 *    - Método "apagar()"
 *    - Método "estaEncendido()" que retorne boolean
 *
 * 2. Crea una interface "Conectable" con:
 *    - Método "conectarWifi(String red)"
 *    - Método "desconectarWifi()"
 *
 * 3. Crea una clase "Television" que implemente Encendible:
 *    - Atributos privados: marca (String), pulgadas (int), encendida (boolean)
 *    - Constructor que reciba marca y pulgadas
 *    - Implementa los 3 métodos de Encendible
 *    - Método propio "cambiarCanal(int canal)"
 *
 * 4. Crea una clase "Laptop" que implemente Encendible Y Conectable:
 *    - Atributos privados: marca, ram (int), encendida (boolean), wifiConectado (boolean)
 *    - Constructor que reciba marca y ram
 *    - Implementa los métodos de AMBAS interfaces
 *    - Método propio "instalarPrograma(String programa)"
 *
 * 5. En el main:
 *    - Crea una TV y una Laptop
 *    - Enciende ambos dispositivos
 *    - Conecta la laptop al WiFi
 *    - Usa sus métodos propios
 *
 * SALIDA ESPERADA:
 * === TELEVISIÓN ===
 * Encendiendo TV Samsung de 55 pulgadas...
 * ¿Está encendida? true
 * Cambiando a canal 5
 * Apagando TV...
 *
 * === LAPTOP ===
 * Encendiendo laptop HP con 16GB RAM...
 * ¿Está encendida? true
 * Conectando al WiFi: MiCasa123
 * Instalando programa: Visual Studio Code
 * Desconectando WiFi...
 * Apagando laptop...
 *
 * CONCEPTOS NUEVOS:
 * - interface: Define un contrato (qué debe hacer)
 * - implements: Indica que una clase cumple con el contrato
 * - Una clase puede: implements Interface1, Interface2 (múltiples interfaces)
 * - Todos los métodos de una interface son públicos y abstractos por defecto
 *
 * PISTA:
 * - Interface: interface Encendible { void encender(); }
 * - Implementar: class Television implements Encendible { ... }
 * - Múltiples: class Laptop implements Encendible, Conectable { ... }
 */

// TODO: Crea la interface Encendible
interface Encendible {
    // Métodos (sin implementación, sin cuerpo)
    void encender();
    void apagar();
    boolean estaEncendido();
}

// TODO: Crea la interface Conectable
interface Conectable {
    // Métodos
    void conectarWifi(String red);
    void desconectarWifi();
}

// TODO: Crea la clase Television que implemente Encendible
class Television implements Encendible {
    // Atributos privados
    private String marca;
    private int pulgadas;
    private boolean encendida;

    // Constructor
    public Television(String marca, int pulgadas) {
        // TODO: Inicializa atributos



    }

    // Implementa encender
    @Override
    public void encender() {
        // TODO: Cambia encendida a true e imprime mensaje


    }

    // Implementa apagar
    @Override
    public void apagar() {
        // TODO: Cambia encendida a false e imprime mensaje


    }

    // Implementa estaEncendido
    @Override
    public boolean estaEncendido() {
        // TODO: Retorna el estado
        return false; // TEMPORAL: reemplaza esto con 'return encendida;'
    }

    // Método propio
    public void cambiarCanal(int canal) {
        if (encendida) {
            System.out.println("Cambiando a canal " + canal);
        } else {
            System.out.println("La TV está apagada");
        }
    }
}

// TODO: Crea la clase Laptop que implemente Encendible Y Conectable
class Laptop implements Encendible, Conectable {
    // Atributos privados
    private String marca;
    private int ram;
    private boolean encendida;
    private boolean wifiConectado;

    // Constructor
    public Laptop(String marca, int ram) {
        // TODO: Inicializa los atributos



    }

    // Implementa métodos de Encendible
    @Override
    public void encender() {
        // TODO: Implementa

    }

    @Override
    public void apagar() {
        // TODO: Implementa

    }

    @Override
    public boolean estaEncendido() {
        // TODO: Implementa
        return false; // TEMPORAL
    }

    // Implementa métodos de Conectable
    @Override
    public void conectarWifi(String red) {
        // TODO: Implementa

    }

    @Override
    public void desconectarWifi() {
        // TODO: Implementa

    }

    // Método propio
    public void instalarPrograma(String programa) {
        // TODO: Implementa

    }
}

public class Ejercicio15 {
    public static void main(String[] args) {
        System.out.println("=== INTERFACES EN JAVA ===\n");

        // TODO: Crea una televisión
        System.out.println("=== TELEVISIÓN ===");
        // Television tv = new Television("Samsung", 55);


        // TODO: Enciende la TV


        // TODO: Verifica si está encendida


        // TODO: Cambia de canal


        // TODO: Apaga la TV


        System.out.println();

        // TODO: Crea una laptop
        System.out.println("=== LAPTOP ===");
        // Laptop laptop = new Laptop("HP", 16);


        // TODO: Enciende la laptop


        // TODO: Conecta al WiFi


        // TODO: Instala un programa


        // TODO: Desconecta WiFi


        // TODO: Apaga la laptop


        // REFLEXIÓN:
        // ¿Por qué usar interfaces?
        // - Permiten que clases no relacionadas compartan comportamiento
        // - Una clase puede implementar múltiples interfaces
        // - Facilitan el testing y el diseño flexible
        // - TV y Laptop no están relacionadas, pero ambas son "Encendibles"
    }
}
