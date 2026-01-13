/*
 * ============================================================================
 * CHEAT SHEET DE JAVA - REFERENCIA RÁPIDA
 * ============================================================================
 *
 * Este archivo contiene ejemplos de todos los conceptos que necesitas
 * para resolver los ejercicios. Úsalo como referencia.
 *
 * NO EJECUTES ESTE ARCHIVO - es solo una guía de consulta.
 * ============================================================================
 */

public class CheatSheet {

    // ========================================================================
    // 1. TIPOS DE DATOS PRIMITIVOS
    // ========================================================================

    // Enteros
    byte numeroPequeno = 100;           // -128 a 127
    short numeroCorto = 32000;          // -32,768 a 32,767
    int numeroNormal = 2000000000;      // -2,147,483,648 a 2,147,483,647
    long numeroGrande = 9000000000L;    // Rango muy grande (nota la L al final)

    // Decimales
    float decimal1 = 3.14f;             // Precisión simple (nota la f al final)
    double decimal2 = 3.14159265359;    // Precisión doble (más usado)

    // Otros
    boolean esVerdadero = true;         // true o false
    char letra = 'A';                   // Un solo carácter (con comillas simples)

    // No primitivos
    String texto = "Hola mundo";        // Cadena de texto (con comillas dobles)

    // ========================================================================
    // 2. OPERADORES ARITMÉTICOS
    // ========================================================================

    void operadoresAritmeticos() {
        int a = 10, b = 3;

        int suma = a + b;           // 13
        int resta = a - b;          // 7
        int multiplicacion = a * b; // 30
        int division = a / b;       // 3 (división entera)
        int modulo = a % b;         // 1 (residuo de la división)

        // División con decimales
        double divisionReal = (double) a / b;  // 3.333... (casting)
    }

    // ========================================================================
    // 3. OPERADORES DE COMPARACIÓN
    // ========================================================================

    void operadoresComparacion() {
        int x = 5, y = 10;

        boolean igual = (x == y);           // false (igual a)
        boolean diferente = (x != y);       // true (diferente de)
        boolean menor = (x < y);            // true (menor que)
        boolean mayor = (x > y);            // false (mayor que)
        boolean menorIgual = (x <= y);      // true (menor o igual)
        boolean mayorIgual = (x >= y);      // false (mayor o igual)
    }

    // ========================================================================
    // 4. OPERADORES LÓGICOS
    // ========================================================================

    void operadoresLogicos() {
        boolean a = true, b = false;

        boolean and = a && b;       // false (ambos deben ser true)
        boolean or = a || b;        // true (al menos uno debe ser true)
        boolean not = !a;           // false (invierte el valor)

        // Ejemplo práctico
        int edad = 20;
        boolean esMayorYMenor65 = (edad >= 18) && (edad < 65);  // true
    }

    // ========================================================================
    // 5. CONDICIONALES IF-ELSE
    // ========================================================================

    void condicionales() {
        int edad = 20;

        // IF simple
        if (edad >= 18) {
            System.out.println("Eres mayor de edad");
        }

        // IF-ELSE
        if (edad >= 18) {
            System.out.println("Eres mayor de edad");
        } else {
            System.out.println("Eres menor de edad");
        }

        // IF-ELSE IF-ELSE
        if (edad < 18) {
            System.out.println("Eres menor de edad");
        } else if (edad < 65) {
            System.out.println("Eres adulto");
        } else {
            System.out.println("Eres adulto mayor");
        }

        // Operador ternario (IF corto)
        String mensaje = (edad >= 18) ? "Mayor" : "Menor";
    }

    // ========================================================================
    // 6. SWITCH-CASE
    // ========================================================================

    void switchCase() {
        int dia = 3;

        switch (dia) {
            case 1:
                System.out.println("Lunes");
                break;
            case 2:
                System.out.println("Martes");
                break;
            case 3:
                System.out.println("Miércoles");
                break;
            default:
                System.out.println("Otro día");
        }
    }

    // ========================================================================
    // 7. LOOPS (BUCLES)
    // ========================================================================

    void loops() {
        // FOR - cuando sabes cuántas veces iterar
        for (int i = 0; i < 10; i++) {
            System.out.println(i);
        }

        // FOR en reversa
        for (int i = 10; i >= 0; i--) {
            System.out.println(i);
        }

        // FOR con saltos
        for (int i = 0; i <= 20; i += 2) {  // Solo pares
            System.out.println(i);
        }

        // WHILE - cuando no sabes cuántas veces iterar
        int contador = 0;
        while (contador < 10) {
            System.out.println(contador);
            contador++;
        }

        // DO-WHILE - ejecuta al menos una vez
        int x = 0;
        do {
            System.out.println(x);
            x++;
        } while (x < 10);

        // BREAK y CONTINUE
        for (int i = 0; i < 10; i++) {
            if (i == 5) break;      // Sale del loop
            if (i == 3) continue;   // Salta a la siguiente iteración
            System.out.println(i);
        }
    }

    // ========================================================================
    // 8. ARRAYS (ARREGLOS)
    // ========================================================================

    void arrays() {
        // Declaración e inicialización
        int[] numeros = {1, 2, 3, 4, 5};
        String[] nombres = {"Ana", "Luis", "María"};

        // Crear array de tamaño fijo
        int[] otrosNumeros = new int[10];  // Array de 10 elementos

        // Acceder a elementos (índice empieza en 0)
        int primero = numeros[0];       // 1
        String segundo = nombres[1];    // "Luis"

        // Modificar elementos
        numeros[0] = 100;

        // Longitud del array
        int longitud = numeros.length;  // 5

        // Recorrer con FOR tradicional
        for (int i = 0; i < numeros.length; i++) {
            System.out.println(numeros[i]);
        }

        // Recorrer con FOR-EACH
        for (int numero : numeros) {
            System.out.println(numero);
        }

        // Array 2D (matriz)
        int[][] matriz = {
            {1, 2, 3},
            {4, 5, 6}
        };
        int valor = matriz[0][1];  // 2
    }

    // ========================================================================
    // 9. STRINGS (CADENAS DE TEXTO)
    // ========================================================================

    void strings() {
        String texto = "Hola Mundo";

        // Longitud
        int longitud = texto.length();              // 10

        // Obtener carácter
        char letra = texto.charAt(0);               // 'H'

        // Substring
        String sub = texto.substring(0, 4);         // "Hola"

        // Convertir a mayúsculas/minúsculas
        String mayus = texto.toUpperCase();         // "HOLA MUNDO"
        String minus = texto.toLowerCase();         // "hola mundo"

        // Comparar strings
        boolean igual = texto.equals("Hola Mundo"); // true (NO uses ==)
        boolean igualIgnoraCase = texto.equalsIgnoreCase("hola mundo"); // true

        // Contiene
        boolean contiene = texto.contains("Mundo"); // true

        // Reemplazar
        String nuevo = texto.replace("Mundo", "Java"); // "Hola Java"

        // Dividir
        String[] palabras = texto.split(" ");       // ["Hola", "Mundo"]

        // Concatenar
        String completo = texto + " en Java";       // "Hola Mundo en Java"
        String completo2 = texto.concat(" en Java"); // Alternativa

        // Eliminar espacios
        String conEspacios = "  texto  ";
        String sinEspacios = conEspacios.trim();    // "texto"
    }

    // ========================================================================
    // 10. MÉTODOS (FUNCIONES)
    // ========================================================================

    // Método que NO retorna nada (void)
    public static void saludar() {
        System.out.println("Hola!");
    }

    // Método con parámetros
    public static void saludarPersona(String nombre) {
        System.out.println("Hola " + nombre);
    }

    // Método que RETORNA un valor
    public static int sumar(int a, int b) {
        return a + b;
    }

    // Método con múltiples parámetros y return
    public static double calcularPromedio(double n1, double n2, double n3) {
        return (n1 + n2 + n3) / 3.0;
    }

    // Método que retorna boolean
    public static boolean esPar(int numero) {
        return numero % 2 == 0;
    }

    // Uso de los métodos
    void usarMetodos() {
        saludar();                          // Hola!
        saludarPersona("Ana");              // Hola Ana

        int resultado = sumar(5, 3);        // 8
        double promedio = calcularPromedio(5.5, 6.0, 4.5);  // 5.33
        boolean par = esPar(10);            // true
    }

    // ========================================================================
    // 11. CLASES Y OBJETOS (POO)
    // ========================================================================

    // EJEMPLO DE CLASE SIMPLE
    class Persona {
        // Atributos (privados para encapsulación)
        private String nombre;
        private int edad;

        // Constructor
        public Persona(String nombre, int edad) {
            this.nombre = nombre;
            this.edad = edad;
        }

        // Getters
        public String getNombre() {
            return nombre;
        }

        public int getEdad() {
            return edad;
        }

        // Setters
        public void setNombre(String nombre) {
            this.nombre = nombre;
        }

        public void setEdad(int edad) {
            if (edad > 0) {  // Validación
                this.edad = edad;
            }
        }

        // Método normal
        public void presentarse() {
            System.out.println("Hola, soy " + nombre + " y tengo " + edad + " años");
        }

        // Método que retorna algo
        public boolean esMayorDeEdad() {
            return edad >= 18;
        }
    }

    // Usar la clase
    void usarClase() {
        // Crear objeto
        Persona p1 = new Persona("Ana", 25);

        // Usar métodos
        p1.presentarse();               // Hola, soy Ana y tengo 25 años
        boolean mayor = p1.esMayorDeEdad();  // true

        // Usar getters
        String nombre = p1.getNombre(); // "Ana"
        int edad = p1.getEdad();        // 25

        // Usar setters
        p1.setNombre("María");
        p1.setEdad(30);
    }

    // ========================================================================
    // 12. INPUT DEL USUARIO (Scanner)
    // ========================================================================

    void inputUsuario() {
        // Importar: import java.util.Scanner;

        // Crear scanner
        java.util.Scanner scanner = new java.util.Scanner(System.in);

        // Leer String
        System.out.print("Ingresa tu nombre: ");
        String nombre = scanner.nextLine();

        // Leer int
        System.out.print("Ingresa tu edad: ");
        int edad = scanner.nextInt();

        // Leer double
        System.out.print("Ingresa tu altura: ");
        double altura = scanner.nextDouble();

        // Cerrar scanner
        scanner.close();
    }

    // ========================================================================
    // 13. IMPRESIÓN EN CONSOLA
    // ========================================================================

    void impresion() {
        // println - con salto de línea
        System.out.println("Hola");
        System.out.println("Mundo");
        // Salida:
        // Hola
        // Mundo

        // print - sin salto de línea
        System.out.print("Hola ");
        System.out.print("Mundo");
        // Salida: Hola Mundo

        // printf - con formato
        String nombre = "Ana";
        int edad = 25;
        double altura = 1.65;

        System.out.printf("Nombre: %s, Edad: %d, Altura: %.2f\n", nombre, edad, altura);
        // Salida: Nombre: Ana, Edad: 25, Altura: 1.65

        // Concatenación
        System.out.println("Hola " + nombre + ", tienes " + edad + " años");
    }

    // ========================================================================
    // 14. CONVERSIÓN DE TIPOS (CASTING)
    // ========================================================================

    void casting() {
        // Automático (de menor a mayor)
        int entero = 10;
        double decimal = entero;        // 10.0

        // Manual (de mayor a menor) - puede perder información
        double pi = 3.14159;
        int piEntero = (int) pi;        // 3 (pierde decimales)

        // String a int
        String textoNumero = "123";
        int numero = Integer.parseInt(textoNumero);  // 123

        // String a double
        String textoDecimal = "3.14";
        double dec = Double.parseDouble(textoDecimal);  // 3.14

        // int a String
        int num = 42;
        String texto1 = String.valueOf(num);    // "42"
        String texto2 = Integer.toString(num);  // "42"
        String texto3 = "" + num;               // "42" (concatenación)
    }

    // ========================================================================
    // 15. MATH (OPERACIONES MATEMÁTICAS)
    // ========================================================================

    void operacionesMatematicas() {
        // Valor absoluto
        int abs = Math.abs(-10);            // 10

        // Potencia
        double potencia = Math.pow(2, 3);   // 8.0 (2^3)

        // Raíz cuadrada
        double raiz = Math.sqrt(16);        // 4.0

        // Redondeo
        double redondeado = Math.round(3.7); // 4.0
        double arriba = Math.ceil(3.1);      // 4.0
        double abajo = Math.floor(3.9);      // 3.0

        // Máximo y mínimo
        int max = Math.max(10, 20);         // 20
        int min = Math.min(10, 20);         // 10

        // Número aleatorio (0.0 a 1.0)
        double random = Math.random();

        // Número aleatorio en rango (ej: 1-100)
        int randomRango = (int) (Math.random() * 100) + 1;
    }

    // ========================================================================
    // 16. EXCEPCIONES (TRY-CATCH)
    // ========================================================================

    void excepciones() {
        try {
            // Código que puede fallar
            int resultado = 10 / 0;  // Error: división por cero

        } catch (ArithmeticException e) {
            // Manejo del error
            System.out.println("Error: " + e.getMessage());

        } finally {
            // Se ejecuta siempre (opcional)
            System.out.println("Fin del bloque try-catch");
        }

        // Lanzar excepción manualmente
        // throw new IllegalArgumentException("Mensaje de error");
    }

    // ========================================================================
    // 17. ARRAYLIST (LISTAS DINÁMICAS)
    // ========================================================================

    void arrayLists() {
        // Importar: import java.util.ArrayList;

        // Crear ArrayList
        java.util.ArrayList<String> nombres = new java.util.ArrayList<>();
        java.util.ArrayList<Integer> numeros = new java.util.ArrayList<>();

        // Agregar elementos
        nombres.add("Ana");
        nombres.add("Luis");
        nombres.add("María");

        // Obtener elemento
        String primero = nombres.get(0);        // "Ana"

        // Tamaño
        int size = nombres.size();              // 3

        // Modificar elemento
        nombres.set(0, "Juan");                 // Reemplaza "Ana" por "Juan"

        // Eliminar elemento
        nombres.remove(1);                      // Elimina "Luis"
        nombres.remove("María");                // Elimina por valor

        // Verificar si contiene
        boolean contiene = nombres.contains("Ana");  // true/false

        // Limpiar todo
        nombres.clear();

        // Verificar si está vacío
        boolean vacio = nombres.isEmpty();      // true

        // Recorrer con for tradicional
        for (int i = 0; i < nombres.size(); i++) {
            System.out.println(nombres.get(i));
        }

        // Recorrer con for-each
        for (String nombre : nombres) {
            System.out.println(nombre);
        }

        // Convertir a array
        String[] array = nombres.toArray(new String[0]);
    }

    // ========================================================================
    // 18. HERENCIA (EXTENDS)
    // ========================================================================

    // Clase padre (superclase)
    class Animal {
        protected String nombre;    // protected: accesible en subclases
        protected int edad;

        public Animal(String nombre, int edad) {
            this.nombre = nombre;
            this.edad = edad;
        }

        public void hacerSonido() {
            System.out.println("El animal hace un sonido");
        }

        public void mostrarInfo() {
            System.out.println("Nombre: " + nombre + ", Edad: " + edad);
        }
    }

    // Clase hija (subclase) - HEREDA de Animal
    class Perro extends Animal {
        private String raza;

        public Perro(String nombre, int edad, String raza) {
            super(nombre, edad);    // Llama al constructor del padre
            this.raza = raza;
        }

        // OVERRIDE - Sobrescribir método del padre
        @Override
        public void hacerSonido() {
            System.out.println("Guau guau!");
        }

        // Método propio del Perro
        public void moverCola() {
            System.out.println(nombre + " mueve la cola");
        }
    }

    class Gato extends Animal {
        public Gato(String nombre, int edad) {
            super(nombre, edad);
        }

        @Override
        public void hacerSonido() {
            System.out.println("Miau miau!");
        }
    }

    // Uso de herencia
    void usarHerencia() {
        Perro perro = new Perro("Firulais", 3, "Labrador");
        perro.hacerSonido();        // Guau guau!
        perro.mostrarInfo();        // Heredado de Animal
        perro.moverCola();          // Propio de Perro

        Gato gato = new Gato("Michi", 2);
        gato.hacerSonido();         // Miau miau!
    }

    // ========================================================================
    // 19. CLASES ABSTRACTAS
    // ========================================================================

    // No se pueden instanciar directamente
    abstract class Vehiculo {
        protected String vin;
        protected String marca;
        protected double eficiencia;

        public Vehiculo(String vin, String marca, double eficiencia) {
            this.vin = vin;
            this.marca = marca;
            this.eficiencia = eficiencia;
        }

        // Método concreto (con implementación)
        public void mostrarInfo() {
            System.out.println("Marca: " + marca + ", VIN: " + vin);
        }

        // Método abstracto (sin implementación)
        // Las subclases DEBEN implementarlo
        public abstract double calcularConsumo();
        public abstract String getCategoria();
    }

    // Subclases concretas
    class Auto extends Vehiculo {
        public Auto(String vin, String marca, double eficiencia) {
            super(vin, marca, eficiencia);
        }

        @Override
        public double calcularConsumo() {
            return 100 / eficiencia;  // Ejemplo
        }

        @Override
        public String getCategoria() {
            return "Auto";
        }
    }

    class Camioneta extends Vehiculo {
        public Camioneta(String vin, String marca, double eficiencia) {
            super(vin, marca, eficiencia);
        }

        @Override
        public double calcularConsumo() {
            return 100 / eficiencia;
        }

        @Override
        public String getCategoria() {
            return "Camioneta";
        }
    }

    // Uso con polimorfismo
    void usarClasesAbstractas() {
        // Lista polimórfica - puede contener cualquier Vehiculo
        java.util.ArrayList<Vehiculo> flota = new java.util.ArrayList<>();

        flota.add(new Auto("VIN123", "Honda", 15.5));
        flota.add(new Camioneta("VIN456", "Ford", 12.0));

        // Procesar todos polimórficamente
        for (Vehiculo v : flota) {
            v.mostrarInfo();              // Método concreto
            System.out.println("Consumo: " + v.calcularConsumo());  // Método abstracto
            System.out.println("Categoría: " + v.getCategoria());
        }
    }

    // ========================================================================
    // 20. INTERFACES
    // ========================================================================

    // Una clase puede implementar múltiples interfaces
    interface ModoManejo {
        double calcularEficiencia(double eficienciaNominal);
    }

    class ModoEco implements ModoManejo {
        @Override
        public double calcularEficiencia(double eficienciaNominal) {
            return eficienciaNominal * 0.9;  // 10% menos eficiente
        }
    }

    class ModoNormal implements ModoManejo {
        @Override
        public double calcularEficiencia(double eficienciaNominal) {
            return eficienciaNominal;  // Eficiencia nominal
        }
    }

    class ModoSport implements ModoManejo {
        @Override
        public double calcularEficiencia(double eficienciaNominal) {
            return eficienciaNominal * 1.25;  // 25% más eficiente
        }
    }

    // ========================================================================
    // 21. PATTERN STRATEGY (OBLIGATORIO EN PRUEBA)
    // ========================================================================

    // Permite cambiar el comportamiento en tiempo de ejecución

    class VehiculoConModo {
        private String marca;
        private double eficienciaNominal;
        private ModoManejo modoActual;  // Strategy

        public VehiculoConModo(String marca, double eficienciaNominal) {
            this.marca = marca;
            this.eficienciaNominal = eficienciaNominal;
            this.modoActual = new ModoNormal();  // Por defecto
        }

        // Cambiar estrategia en runtime
        public void setModo(ModoManejo modo) {
            this.modoActual = modo;
        }

        public double getEficienciaActual() {
            return modoActual.calcularEficiencia(eficienciaNominal);
        }
    }

    void usarStrategy() {
        VehiculoConModo vehiculo = new VehiculoConModo("Honda", 15.0);

        System.out.println(vehiculo.getEficienciaActual());  // 15.0 (Normal)

        vehiculo.setModo(new ModoEco());
        System.out.println(vehiculo.getEficienciaActual());  // 13.5 (Eco)

        vehiculo.setModo(new ModoSport());
        System.out.println(vehiculo.getEficienciaActual());  // 18.75 (Sport)
    }

    // ========================================================================
    // 22. PATTERN VISITOR (OBLIGATORIO EN PRUEBA)
    // ========================================================================

    // Permite agregar operaciones a clases sin modificarlas

    // Interfaz Visitor
    interface VehicleVisitor {
        void visitAuto(Auto auto);
        void visitCamioneta(Camioneta camioneta);
    }

    // Visitor concreto
    class ConsumoCalculator implements VehicleVisitor {
        private double maxConsumoAuto = 0;
        private double maxConsumoCamioneta = 0;
        private String vinMaxAuto = "";
        private String vinMaxCamioneta = "";

        @Override
        public void visitAuto(Auto auto) {
            double consumo = auto.calcularConsumo();
            if (consumo > maxConsumoAuto) {
                maxConsumoAuto = consumo;
                vinMaxAuto = auto.vin;
            }
        }

        @Override
        public void visitCamioneta(Camioneta camioneta) {
            double consumo = camioneta.calcularConsumo();
            if (consumo > maxConsumoCamioneta) {
                maxConsumoCamioneta = consumo;
                vinMaxCamioneta = camioneta.vin;
            }
        }

        public void mostrarResultados() {
            System.out.println("Auto: " + vinMaxAuto + " (" + maxConsumoAuto + " litros)");
            System.out.println("Camioneta: " + vinMaxCamioneta + " (" + maxConsumoCamioneta + " litros)");
        }
    }

    // Las clases Vehiculo necesitan el método accept
    // En Auto: public void accept(VehicleVisitor visitor) { visitor.visitAuto(this); }
    // En Camioneta: public void accept(VehicleVisitor visitor) { visitor.visitCamioneta(this); }

    // ========================================================================
    // 23. PATTERN SINGLETON (OPCIÓN EN PRUEBA)
    // ========================================================================

    // Garantiza una única instancia de la clase
    class Sistema {
        // Instancia única (privada y estática)
        private static Sistema instance = null;

        // Constructor privado (no se puede instanciar desde fuera)
        private Sistema() {
            System.out.println("Sistema inicializado");
        }

        // Método público para obtener la instancia
        public static Sistema getInstance() {
            if (instance == null) {
                instance = new Sistema();
            }
            return instance;
        }

        public void ejecutar() {
            System.out.println("Sistema ejecutándose...");
        }
    }

    void usarSingleton() {
        // No se puede: Sistema s = new Sistema();  // Error: constructor privado

        // Única forma de obtener la instancia
        Sistema sistema1 = Sistema.getInstance();
        Sistema sistema2 = Sistema.getInstance();

        // sistema1 y sistema2 son la MISMA instancia
        System.out.println(sistema1 == sistema2);  // true
    }

    // ========================================================================
    // 24. PATTERN FACTORY (OPCIÓN EN PRUEBA)
    // ========================================================================

    // Crea objetos sin exponer la lógica de creación

    class VehiculoFactory {
        public static Vehiculo crearVehiculo(String tipo, String vin, String marca, double eficiencia) {
            switch (tipo.toUpperCase()) {
                case "AUTO":
                case "C":
                    return new Auto(vin, marca, eficiencia);
                case "CAMIONETA":
                case "P":
                    return new Camioneta(vin, marca, eficiencia);
                case "SUV":
                case "S":
                    return new SUV(vin, marca, eficiencia);
                default:
                    throw new IllegalArgumentException("Tipo de vehículo desconocido: " + tipo);
            }
        }
    }

    class SUV extends Vehiculo {
        public SUV(String vin, String marca, double eficiencia) {
            super(vin, marca, eficiencia);
        }

        @Override
        public double calcularConsumo() {
            return 100 / eficiencia;
        }

        @Override
        public String getCategoria() {
            return "SUV";
        }
    }

    void usarFactory() {
        // Crear vehículos sin usar "new" directamente
        Vehiculo v1 = VehiculoFactory.crearVehiculo("Auto", "VIN123", "Honda", 15.0);
        Vehiculo v2 = VehiculoFactory.crearVehiculo("Camioneta", "VIN456", "Ford", 12.0);
        Vehiculo v3 = VehiculoFactory.crearVehiculo("SUV", "VIN789", "Jeep", 13.5);
    }

    // ========================================================================
    // 25. FILE I/O - LECTURA DE ARCHIVOS
    // ========================================================================

    void leerArchivo() {
        // Importar: import java.io.*;

        // OPCIÓN 1: Scanner con File
        try {
            java.io.File archivo = new java.io.File("fleet.txt");
            java.util.Scanner scanner = new java.util.Scanner(archivo);

            // Leer línea por línea
            while (scanner.hasNextLine()) {
                String linea = scanner.nextLine();
                System.out.println(linea);

                // Parsear CSV
                String[] partes = linea.split(",");
                String vin = partes[0];
                String marca = partes[1];
                // etc...
            }

            scanner.close();

        } catch (java.io.FileNotFoundException e) {
            System.out.println("Archivo no encontrado: " + e.getMessage());
        }

        // OPCIÓN 2: BufferedReader (más eficiente)
        try {
            java.io.BufferedReader br = new java.io.BufferedReader(
                new java.io.FileReader("fleet.txt")
            );

            String linea;
            while ((linea = br.readLine()) != null) {
                System.out.println(linea);
            }

            br.close();

        } catch (java.io.IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    // ========================================================================
    // 26. PARSING CSV Y STRING MANIPULATION
    // ========================================================================

    void parsearCSV() {
        // Ejemplo de línea CSV del problema
        String linea = "VIN123,Honda,Civic,Auto,15.5";

        // Split por coma
        String[] partes = linea.split(",");

        String vin = partes[0];          // "VIN123"
        String marca = partes[1];        // "Honda"
        String modelo = partes[2];       // "Civic"
        String tipo = partes[3];         // "Auto"
        double eficiencia = Double.parseDouble(partes[4]);  // 15.5

        // Línea de viajes con distancias variables
        String lineaViajes = "VIN123,ModoEco,150.5,200.3,180.7";
        String[] partesViajes = lineaViajes.split(",");

        String vinViaje = partesViajes[0];
        String modo = partesViajes[1];

        // Procesar todas las distancias (desde índice 2 en adelante)
        for (int i = 2; i < partesViajes.length; i++) {
            double distancia = Double.parseDouble(partesViajes[i]);
            System.out.println("Distancia: " + distancia);
        }
    }

    // ========================================================================
    // 27. CHARACTER METHODS (PARA PROBLEMA 1)
    // ========================================================================

    void characterMethods() {
        char c = '5';

        // Verificar si es dígito
        boolean esDigito = Character.isDigit(c);        // true

        // Obtener valor numérico
        int valor = Character.getNumericValue(c);       // 5

        // Verificar si es letra
        boolean esLetra = Character.isLetter('A');      // true

        // Convertir a mayúscula/minúscula
        char mayus = Character.toUpperCase('a');        // 'A'
        char minus = Character.toLowerCase('A');        // 'a'

        // Ejemplo: Validar RUT (último dígito debe ser dígito)
        String rut = "12345678-9";
        char ultimoChar = rut.charAt(rut.length() - 5);  // Cuarto desde el final
        if (!Character.isDigit(ultimoChar)) {
            // throw new IllegalArgumentException("...");
        }
    }

    // ========================================================================
    // 28. SWING GUI BÁSICO (PARA PROBLEMA 1 Y BONUS)
    // ========================================================================

    void swingBasico() {
        // Importar: import javax.swing.*;

        // Crear ventana (JFrame)
        javax.swing.JFrame frame = new javax.swing.JFrame("Título Ventana");
        frame.setSize(400, 400);
        frame.setDefaultCloseOperation(javax.swing.JFrame.EXIT_ON_CLOSE);

        // Crear panel (JPanel)
        javax.swing.JPanel panel = new javax.swing.JPanel();

        // Layouts
        panel.setLayout(new java.awt.BoxLayout(panel, java.awt.BoxLayout.X_AXIS));  // Horizontal
        // panel.setLayout(new java.awt.BoxLayout(panel, java.awt.BoxLayout.Y_AXIS));  // Vertical

        // Crear botones
        for (int i = 1; i <= 5; i++) {
            javax.swing.JButton boton = new javax.swing.JButton("Botón " + i);
            panel.add(boton);
        }

        // Agregar panel al frame
        frame.add(panel);

        // Hacer visible
        frame.setVisible(true);
    }

    // ========================================================================
    // 29. BÚSQUEDA DE MÁXIMOS/MÍNIMOS EN LISTAS
    // ========================================================================

    void buscarMaximos() {
        java.util.ArrayList<Vehiculo> flota = new java.util.ArrayList<>();
        // ... agregar vehículos ...

        // Encontrar vehículo con mayor consumo
        double maxConsumo = 0;
        Vehiculo vehiculoMax = null;

        for (Vehiculo v : flota) {
            double consumo = v.calcularConsumo();
            if (consumo > maxConsumo) {
                maxConsumo = consumo;
                vehiculoMax = v;
            }
        }

        System.out.println("Mayor consumo: " + maxConsumo);

        // Agrupar por categoría y encontrar máximo por categoría
        java.util.ArrayList<Vehiculo> autos = new java.util.ArrayList<>();
        java.util.ArrayList<Vehiculo> camionetas = new java.util.ArrayList<>();
        java.util.ArrayList<Vehiculo> suvs = new java.util.ArrayList<>();

        for (Vehiculo v : flota) {
            if (v.getCategoria().equals("Auto")) {
                autos.add(v);
            } else if (v.getCategoria().equals("Camioneta")) {
                camionetas.add(v);
            } else if (v.getCategoria().equals("SUV")) {
                suvs.add(v);
            }
        }

        // Ahora buscar máximo en cada categoría
        // ... (mismo proceso de arriba)
    }

    // ========================================================================
    // 30. FORMATO DE SALIDA (PRINTF)
    // ========================================================================

    void formatoSalida() {
        String marca = "Honda";
        double consumo = 345.52812500000005;
        int odometro = 5621;

        // Formato básico
        System.out.printf("%s CONSUMO: %.2f l ODÓMETRO: %d km\n", marca, consumo, odometro);
        // Salida: Honda CONSUMO: 345.53 l ODÓMETRO: 5621 km

        // Formatos útiles:
        // %s = String
        // %d = int
        // %f = float/double
        // %.2f = float con 2 decimales
        // %n = nueva línea (portable)

        // Alinear texto
        System.out.printf("%-20s", "Honda");  // Alineado a izquierda, 20 caracteres
        System.out.printf("%20s", "Honda");   // Alineado a derecha, 20 caracteres
    }

    // ========================================================================
    // 31. PRINCIPIOS SOLID
    // ========================================================================

    /*
     * Los principios SOLID son 5 principios fundamentales de diseño orientado a objetos
     * que nos ayudan a escribir código más mantenible, flexible y escalable.
     */

    // ========================================================================
    // 31.1 SINGLE RESPONSIBILITY PRINCIPLE (SRP)
    // ========================================================================
    /*
     * Principio: Una clase debe tener una única razón para cambiar.
     * Cada clase debe tener una única responsabilidad.
     *
     * ❌ INCORRECTO: Clase con múltiples responsabilidades
     */
    class EmpleadoMalo {
        private String nombre;
        private double salario;

        public EmpleadoMalo(String nombre, double salario) {
            this.nombre = nombre;
            this.salario = salario;
        }

        // Responsabilidad 1: Calcular pago
        public double calcularPago() {
            return salario * 1.1;
        }

        // Responsabilidad 2: Guardar en base de datos
        public void guardarEnBaseDatos() {
            // código de BD...
        }

        // Responsabilidad 3: Generar reporte
        public String generarReporte() {
            return "Reporte de " + nombre;
        }
    }

    /*
     * ✅ CORRECTO: Separar responsabilidades en clases diferentes
     */
    class Empleado {
        private String nombre;
        private double salario;

        public Empleado(String nombre, double salario) {
            this.nombre = nombre;
            this.salario = salario;
        }

        public String getNombre() { return nombre; }
        public double getSalario() { return salario; }
    }

    class CalculadoraSalario {
        public double calcularPago(Empleado empleado) {
            return empleado.getSalario() * 1.1;
        }
    }

    class EmpleadoRepositorio {
        public void guardar(Empleado empleado) {
            // código de BD...
        }
    }

    class GeneradorReportes {
        public String generar(Empleado empleado) {
            return "Reporte de " + empleado.getNombre();
        }
    }

    // ========================================================================
    // 31.2 OPEN/CLOSED PRINCIPLE (OCP)
    // ========================================================================
    /*
     * Principio: Las clases deben estar abiertas para extensión pero cerradas para modificación.
     * Debes poder agregar nueva funcionalidad sin cambiar el código existente.
     *
     * ❌ INCORRECTO: Necesitas modificar la clase cada vez que agregas un nuevo tipo
     */
    class CalculadoraAreaMala {
        public double calcularArea(Object forma) {
            if (forma instanceof Circulo) {
                Circulo c = (Circulo) forma;
                return Math.PI * c.radio * c.radio;
            } else if (forma instanceof Rectangulo) {
                Rectangulo r = (Rectangulo) forma;
                return r.ancho * r.alto;
            }
            // Si quieres agregar Triangulo, debes MODIFICAR esta clase ❌
            return 0;
        }
    }

    /*
     * ✅ CORRECTO: Usa polimorfismo - puedes agregar nuevas formas sin modificar código existente
     */
    interface Forma {
        double calcularArea();
    }

    class Circulo implements Forma {
        private double radio;

        public Circulo(double radio) {
            this.radio = radio;
        }

        @Override
        public double calcularArea() {
            return Math.PI * radio * radio;
        }
    }

    class Rectangulo implements Forma {
        private double ancho;
        private double alto;

        public Rectangulo(double ancho, double alto) {
            this.ancho = ancho;
            this.alto = alto;
        }

        @Override
        public double calcularArea() {
            return ancho * alto;
        }
    }

    class Triangulo implements Forma {
        private double base;
        private double altura;

        public Triangulo(double base, double altura) {
            this.base = base;
            this.altura = altura;
        }

        @Override
        public double calcularArea() {
            return (base * altura) / 2;
        }
    }

    class CalculadoraArea {
        public double calcular(Forma forma) {
            return forma.calcularArea();  // No necesita modificarse para nuevas formas ✅
        }
    }

    // ========================================================================
    // 31.3 LISKOV SUBSTITUTION PRINCIPLE (LSP)
    // ========================================================================
    /*
     * Principio: Los objetos de una subclase deben poder reemplazar a los de la superclase
     * sin romper la funcionalidad del programa.
     *
     * ❌ INCORRECTO: La subclase rompe el comportamiento esperado
     */
    class Ave {
        public void volar() {
            System.out.println("El ave vuela");
        }
    }

    class Pinguino extends Ave {
        @Override
        public void volar() {
            throw new UnsupportedOperationException("Los pingüinos no vuelan");
            // Esto rompe LSP porque no puedes reemplazar Ave con Pinguino ❌
        }
    }

    /*
     * ✅ CORRECTO: Diseño que respeta LSP
     */
    abstract class AveCorrecta {
        protected String nombre;

        public AveCorrecta(String nombre) {
            this.nombre = nombre;
        }

        public abstract void moverse();
    }

    class AveVoladora extends AveCorrecta {
        public AveVoladora(String nombre) {
            super(nombre);
        }

        @Override
        public void moverse() {
            System.out.println(nombre + " vuela");
        }
    }

    class PinguinoCorrector extends AveCorrecta {
        public PinguinoCorrector(String nombre) {
            super(nombre);
        }

        @Override
        public void moverse() {
            System.out.println(nombre + " nada");
        }
    }

    void usarLSP() {
        java.util.ArrayList<AveCorrecta> aves = new java.util.ArrayList<>();
        aves.add(new AveVoladora("Águila"));
        aves.add(new PinguinoCorrector("Pingüino"));

        for (AveCorrecta ave : aves) {
            ave.moverse();  // Funciona correctamente para todas ✅
        }
    }

    // ========================================================================
    // 31.4 INTERFACE SEGREGATION PRINCIPLE (ISP)
    // ========================================================================
    /*
     * Principio: Los clientes no deben verse obligados a depender de interfaces que no usan.
     * Es mejor tener varias interfaces específicas que una general.
     *
     * ❌ INCORRECTO: Interfaz demasiado grande
     */
    interface TrabajadorMalo {
        void trabajar();
        void comer();
        void cobrarSalario();
        void programar();      // No todos los trabajadores programan
        void atenderClientes();  // No todos atienden clientes
    }

    class Programador implements TrabajadorMalo {
        public void trabajar() { /* código */ }
        public void comer() { /* código */ }
        public void cobrarSalario() { /* código */ }
        public void programar() { /* código */ }
        public void atenderClientes() {
            // Programador NO atiende clientes, pero se ve forzado a implementar esto ❌
        }
    }

    /*
     * ✅ CORRECTO: Interfaces segregadas (pequeñas y específicas)
     */
    interface Trabajador {
        void trabajar();
        void comer();
        void cobrarSalario();
    }

    interface Programable {
        void programar();
    }

    interface AtiendeClientes {
        void atenderClientes();
    }

    class ProgramadorCorrector implements Trabajador, Programable {
        public void trabajar() { System.out.println("Trabajando..."); }
        public void comer() { System.out.println("Comiendo..."); }
        public void cobrarSalario() { System.out.println("Cobrando..."); }
        public void programar() { System.out.println("Programando..."); }
        // No implementa AtiendeClientes porque no lo necesita ✅
    }

    class VendedorCorrector implements Trabajador, AtiendeClientes {
        public void trabajar() { System.out.println("Trabajando..."); }
        public void comer() { System.out.println("Comiendo..."); }
        public void cobrarSalario() { System.out.println("Cobrando..."); }
        public void atenderClientes() { System.out.println("Atendiendo..."); }
        // No implementa Programable porque no lo necesita ✅
    }

    // ========================================================================
    // 31.5 DEPENDENCY INVERSION PRINCIPLE (DIP)
    // ========================================================================
    /*
     * Principio: Las clases de alto nivel no deben depender de las de bajo nivel.
     * Ambas deben depender de abstracciones (interfaces/clases abstractas).
     *
     * ❌ INCORRECTO: Dependencia directa de clase concreta
     */
    class MySQLDatabase {
        public void guardar(String datos) {
            System.out.println("Guardando en MySQL: " + datos);
        }
    }

    class ServicioUsuarioMalo {
        private MySQLDatabase database;  // Dependencia directa de clase concreta ❌

        public ServicioUsuarioMalo() {
            this.database = new MySQLDatabase();  // Acoplamiento fuerte ❌
        }

        public void guardarUsuario(String usuario) {
            database.guardar(usuario);
            // Si quieres cambiar a PostgreSQL, debes modificar esta clase ❌
        }
    }

    /*
     * ✅ CORRECTO: Depender de abstracción (interface)
     */
    interface Database {
        void guardar(String datos);
    }

    class MySQLDatabaseImpl implements Database {
        @Override
        public void guardar(String datos) {
            System.out.println("Guardando en MySQL: " + datos);
        }
    }

    class PostgreSQLDatabase implements Database {
        @Override
        public void guardar(String datos) {
            System.out.println("Guardando en PostgreSQL: " + datos);
        }
    }

    class ServicioUsuario {
        private Database database;  // Depende de abstracción ✅

        // Dependency Injection - inyectas la dependencia desde fuera
        public ServicioUsuario(Database database) {
            this.database = database;
        }

        public void guardarUsuario(String usuario) {
            database.guardar(usuario);
            // Puedes cambiar la implementación sin modificar esta clase ✅
        }
    }

    void usarDIP() {
        // Puedes cambiar fácilmente la implementación
        ServicioUsuario servicio1 = new ServicioUsuario(new MySQLDatabaseImpl());
        ServicioUsuario servicio2 = new ServicioUsuario(new PostgreSQLDatabase());

        servicio1.guardarUsuario("Juan");
        servicio2.guardarUsuario("María");
    }

    // ========================================================================
    // 32. PATRONES DE DISEÑO - CREACIONALES (FALTANTES)
    // ========================================================================

    // ========================================================================
    // 32.1 ABSTRACT FACTORY PATTERN
    // ========================================================================
    /*
     * Propósito: Proporciona una interfaz para crear familias de objetos relacionados
     * sin especificar sus clases concretas.
     *
     * Cuándo usarlo: Cuando necesitas crear grupos de objetos relacionados que deben
     * trabajar juntos (ej: botones y checkboxes del mismo estilo).
     */

    // Productos abstractos
    interface Boton {
        void renderizar();
    }

    interface Checkbox {
        void renderizar();
    }

    // Productos concretos - Estilo Windows
    class BotonWindows implements Boton {
        @Override
        public void renderizar() {
            System.out.println("Renderizando botón estilo Windows");
        }
    }

    class CheckboxWindows implements Checkbox {
        @Override
        public void renderizar() {
            System.out.println("Renderizando checkbox estilo Windows");
        }
    }

    // Productos concretos - Estilo Mac
    class BotonMac implements Boton {
        @Override
        public void renderizar() {
            System.out.println("Renderizando botón estilo Mac");
        }
    }

    class CheckboxMac implements Checkbox {
        @Override
        public void renderizar() {
            System.out.println("Renderizando checkbox estilo Mac");
        }
    }

    // Abstract Factory
    interface GUIFactory {
        Boton crearBoton();
        Checkbox crearCheckbox();
    }

    // Factory concreta - Windows
    class WindowsFactory implements GUIFactory {
        @Override
        public Boton crearBoton() {
            return new BotonWindows();
        }

        @Override
        public Checkbox crearCheckbox() {
            return new CheckboxWindows();
        }
    }

    // Factory concreta - Mac
    class MacFactory implements GUIFactory {
        @Override
        public Boton crearBoton() {
            return new BotonMac();
        }

        @Override
        public Checkbox crearCheckbox() {
            return new CheckboxMac();
        }
    }

    // Cliente que usa el factory
    class Aplicacion {
        private Boton boton;
        private Checkbox checkbox;

        public Aplicacion(GUIFactory factory) {
            boton = factory.crearBoton();
            checkbox = factory.crearCheckbox();
        }

        public void renderizar() {
            boton.renderizar();
            checkbox.renderizar();
        }
    }

    void usarAbstractFactory() {
        String sistemaOperativo = "Windows";
        GUIFactory factory;

        if (sistemaOperativo.equals("Windows")) {
            factory = new WindowsFactory();
        } else {
            factory = new MacFactory();
        }

        Aplicacion app = new Aplicacion(factory);
        app.renderizar();  // Renderiza componentes del estilo correcto
    }

    // ========================================================================
    // 32.2 BUILDER PATTERN
    // ========================================================================
    /*
     * Propósito: Permite construir objetos complejos paso a paso.
     * Útil cuando un objeto tiene muchos parámetros opcionales.
     *
     * Cuándo usarlo: Cuando tienes constructores con muchos parámetros,
     * especialmente si algunos son opcionales.
     */

    class Pizza {
        // Atributos obligatorios
        private String masa;
        private String salsa;

        // Atributos opcionales
        private boolean queso;
        private boolean pepperoni;
        private boolean champinones;
        private boolean aceitunas;
        private boolean cebolla;

        // Constructor privado - solo Builder puede crear Pizza
        private Pizza(PizzaBuilder builder) {
            this.masa = builder.masa;
            this.salsa = builder.salsa;
            this.queso = builder.queso;
            this.pepperoni = builder.pepperoni;
            this.champinones = builder.champinones;
            this.aceitunas = builder.aceitunas;
            this.cebolla = builder.cebolla;
        }

        @Override
        public String toString() {
            return "Pizza con: masa=" + masa + ", salsa=" + salsa +
                   (queso ? ", queso" : "") +
                   (pepperoni ? ", pepperoni" : "") +
                   (champinones ? ", champiñones" : "") +
                   (aceitunas ? ", aceitunas" : "") +
                   (cebolla ? ", cebolla" : "");
        }

        // Builder interno
        static class PizzaBuilder {
            // Atributos obligatorios
            private String masa;
            private String salsa;

            // Atributos opcionales - valores por defecto
            private boolean queso = false;
            private boolean pepperoni = false;
            private boolean champinones = false;
            private boolean aceitunas = false;
            private boolean cebolla = false;

            public PizzaBuilder(String masa, String salsa) {
                this.masa = masa;
                this.salsa = salsa;
            }

            public PizzaBuilder conQueso() {
                this.queso = true;
                return this;  // Retorna this para encadenar
            }

            public PizzaBuilder conPepperoni() {
                this.pepperoni = true;
                return this;
            }

            public PizzaBuilder conChampinones() {
                this.champinones = true;
                return this;
            }

            public PizzaBuilder conAceitunas() {
                this.aceitunas = true;
                return this;
            }

            public PizzaBuilder conCebolla() {
                this.cebolla = true;
                return this;
            }

            public Pizza build() {
                return new Pizza(this);
            }
        }
    }

    void usarBuilder() {
        // Constructor tradicional sería:
        // Pizza pizza = new Pizza("delgada", "tomate", true, true, false, false, true);
        // ¿Qué significan esos true/false? 😵

        // Con Builder es mucho más legible:
        Pizza pizza1 = new Pizza.PizzaBuilder("delgada", "tomate")
                .conQueso()
                .conPepperoni()
                .conCebolla()
                .build();

        Pizza pizza2 = new Pizza.PizzaBuilder("gruesa", "BBQ")
                .conQueso()
                .conChampinones()
                .conAceitunas()
                .build();

        System.out.println(pizza1);
        System.out.println(pizza2);
    }

    // ========================================================================
    // 32.3 PROTOTYPE PATTERN
    // ========================================================================
    /*
     * Propósito: Permite copiar objetos existentes sin hacer que el código dependa
     * de sus clases concretas.
     *
     * Cuándo usarlo: Cuando crear un objeto nuevo es costoso y es más eficiente
     * clonar uno existente.
     */

    interface Prototipo extends Cloneable {
        Prototipo clonar();
    }

    class Documento implements Prototipo {
        private String titulo;
        private String contenido;
        private java.util.ArrayList<String> imagenes;

        public Documento(String titulo, String contenido) {
            this.titulo = titulo;
            this.contenido = contenido;
            this.imagenes = new java.util.ArrayList<>();
        }

        public void agregarImagen(String imagen) {
            imagenes.add(imagen);
        }

        @Override
        public Documento clonar() {
            try {
                Documento clon = (Documento) super.clone();
                // Deep copy de la lista
                clon.imagenes = new java.util.ArrayList<>(this.imagenes);
                return clon;
            } catch (CloneNotSupportedException e) {
                return null;
            }
        }

        public void setTitulo(String titulo) {
            this.titulo = titulo;
        }

        @Override
        public String toString() {
            return "Documento: " + titulo + " - " + contenido +
                   " - Imágenes: " + imagenes.size();
        }
    }

    void usarPrototype() {
        // Crear documento original
        Documento original = new Documento("Plantilla", "Este es el contenido base");
        original.agregarImagen("logo.png");
        original.agregarImagen("banner.jpg");

        // Clonar documento (más rápido que crear desde cero)
        Documento copia1 = original.clonar();
        copia1.setTitulo("Documento 1");

        Documento copia2 = original.clonar();
        copia2.setTitulo("Documento 2");

        System.out.println(original);
        System.out.println(copia1);
        System.out.println(copia2);
    }

    // ========================================================================
    // 33. PATRONES DE DISEÑO - ESTRUCTURALES
    // ========================================================================

    // ========================================================================
    // 33.1 ADAPTER PATTERN
    // ========================================================================
    /*
     * Propósito: Permite que objetos con interfaces incompatibles trabajen juntos.
     * Actúa como un "traductor" entre dos interfaces.
     *
     * Cuándo usarlo: Cuando quieres usar una clase existente pero su interfaz
     * no es compatible con el resto de tu código.
     */

    // Sistema antiguo
    class ReproductorMP3 {
        public void reproducirMP3(String archivo) {
            System.out.println("Reproduciendo MP3: " + archivo);
        }
    }

    // Nueva interfaz que queremos usar
    interface ReproductorMultimedia {
        void reproducir(String tipo, String archivo);
    }

    // Clase avanzada que implementa la nueva interfaz
    class ReproductorAvanzado implements ReproductorMultimedia {
        @Override
        public void reproducir(String tipo, String archivo) {
            if (tipo.equalsIgnoreCase("MP4")) {
                System.out.println("Reproduciendo MP4: " + archivo);
            } else if (tipo.equalsIgnoreCase("VLC")) {
                System.out.println("Reproduciendo VLC: " + archivo);
            }
        }
    }

    // ADAPTER - Adapta ReproductorMP3 a la interfaz ReproductorMultimedia
    class AdaptadorReproductor implements ReproductorMultimedia {
        private ReproductorMP3 reproductorMP3;

        public AdaptadorReproductor(ReproductorMP3 reproductorMP3) {
            this.reproductorMP3 = reproductorMP3;
        }

        @Override
        public void reproducir(String tipo, String archivo) {
            if (tipo.equalsIgnoreCase("MP3")) {
                reproductorMP3.reproducirMP3(archivo);  // Adaptación
            } else if (tipo.equalsIgnoreCase("MP4") || tipo.equalsIgnoreCase("VLC")) {
                ReproductorAvanzado avanzado = new ReproductorAvanzado();
                avanzado.reproducir(tipo, archivo);
            }
        }
    }

    class ReproductorAudio {
        private ReproductorMultimedia reproductor;

        public ReproductorAudio() {
            // Usamos el adapter para que el reproductor viejo funcione con la nueva interfaz
            reproductor = new AdaptadorReproductor(new ReproductorMP3());
        }

        public void reproducir(String tipo, String archivo) {
            reproductor.reproducir(tipo, archivo);
        }
    }

    void usarAdapter() {
        ReproductorAudio audio = new ReproductorAudio();
        audio.reproducir("MP3", "cancion.mp3");
        audio.reproducir("MP4", "video.mp4");
        audio.reproducir("VLC", "pelicula.vlc");
    }

    // ========================================================================
    // 33.2 COMPOSITE PATTERN
    // ========================================================================
    /*
     * Propósito: Permite componer objetos en estructuras de árbol para representar
     * jerarquías parte-todo. Los clientes pueden tratar objetos individuales
     * y composiciones de manera uniforme.
     *
     * Cuándo usarlo: Cuando tienes estructuras de árbol (ej: sistema de archivos,
     * menús, organizaciones jerárquicas).
     */

    interface ComponenteGrafico {
        void dibujar();
        void agregar(ComponenteGrafico componente);  // Solo para composites
        void remover(ComponenteGrafico componente);
    }

    // Hoja (leaf) - no tiene hijos
    class Circulo2 implements ComponenteGrafico {
        private String nombre;

        public Circulo2(String nombre) {
            this.nombre = nombre;
        }

        @Override
        public void dibujar() {
            System.out.println("Dibujando círculo: " + nombre);
        }

        @Override
        public void agregar(ComponenteGrafico componente) {
            // Las hojas no pueden agregar componentes
        }

        @Override
        public void remover(ComponenteGrafico componente) {
            // Las hojas no pueden remover componentes
        }
    }

    class Cuadrado implements ComponenteGrafico {
        private String nombre;

        public Cuadrado(String nombre) {
            this.nombre = nombre;
        }

        @Override
        public void dibujar() {
            System.out.println("Dibujando cuadrado: " + nombre);
        }

        @Override
        public void agregar(ComponenteGrafico componente) { }

        @Override
        public void remover(ComponenteGrafico componente) { }
    }

    // Composite - puede contener otros componentes
    class GrupoGrafico implements ComponenteGrafico {
        private String nombre;
        private java.util.ArrayList<ComponenteGrafico> componentes;

        public GrupoGrafico(String nombre) {
            this.nombre = nombre;
            this.componentes = new java.util.ArrayList<>();
        }

        @Override
        public void dibujar() {
            System.out.println("Dibujando grupo: " + nombre);
            for (ComponenteGrafico componente : componentes) {
                componente.dibujar();  // Dibuja todos los componentes del grupo
            }
        }

        @Override
        public void agregar(ComponenteGrafico componente) {
            componentes.add(componente);
        }

        @Override
        public void remover(ComponenteGrafico componente) {
            componentes.remove(componente);
        }
    }

    void usarComposite() {
        // Crear componentes individuales
        ComponenteGrafico circulo1 = new Circulo2("Círculo 1");
        ComponenteGrafico circulo2 = new Circulo2("Círculo 2");
        ComponenteGrafico cuadrado1 = new Cuadrado("Cuadrado 1");
        ComponenteGrafico cuadrado2 = new Cuadrado("Cuadrado 2");

        // Crear grupos
        GrupoGrafico grupo1 = new GrupoGrafico("Grupo 1");
        grupo1.agregar(circulo1);
        grupo1.agregar(cuadrado1);

        GrupoGrafico grupo2 = new GrupoGrafico("Grupo 2");
        grupo2.agregar(circulo2);
        grupo2.agregar(cuadrado2);

        // Crear grupo principal que contiene otros grupos
        GrupoGrafico grupoPrincipal = new GrupoGrafico("Grupo Principal");
        grupoPrincipal.agregar(grupo1);
        grupoPrincipal.agregar(grupo2);

        // Dibujar todo de una vez
        grupoPrincipal.dibujar();
    }

    // ========================================================================
    // 33.3 PROXY PATTERN
    // ========================================================================
    /*
     * Propósito: Proporciona un sustituto o marcador de posición para otro objeto
     * para controlar el acceso a él.
     *
     * Cuándo usarlo: Lazy initialization, control de acceso, logging, caching.
     */

    interface Imagen {
        void mostrar();
    }

    // Objeto real (costoso de crear)
    class ImagenReal implements Imagen {
        private String archivo;

        public ImagenReal(String archivo) {
            this.archivo = archivo;
            cargarDesdeDisc();  // Operación costosa
        }

        private void cargarDesdeDisc() {
            System.out.println("Cargando imagen desde disco: " + archivo);
        }

        @Override
        public void mostrar() {
            System.out.println("Mostrando imagen: " + archivo);
        }
    }

    // Proxy - retrasa la creación del objeto real
    class ImagenProxy implements Imagen {
        private String archivo;
        private ImagenReal imagenReal;

        public ImagenProxy(String archivo) {
            this.archivo = archivo;
        }

        @Override
        public void mostrar() {
            // Lazy initialization - solo carga cuando se necesita
            if (imagenReal == null) {
                imagenReal = new ImagenReal(archivo);
            }
            imagenReal.mostrar();
        }
    }

    void usarProxy() {
        // Crear proxies - NO carga las imágenes todavía
        Imagen imagen1 = new ImagenProxy("foto1.jpg");
        Imagen imagen2 = new ImagenProxy("foto2.jpg");

        System.out.println("Imágenes creadas (pero no cargadas)");

        // La imagen solo se carga cuando se muestra por primera vez
        imagen1.mostrar();  // Carga y muestra
        imagen1.mostrar();  // Solo muestra (ya está cargada)

        imagen2.mostrar();  // Carga y muestra
    }

    // ========================================================================
    // 33.4 DECORATOR PATTERN
    // ========================================================================
    /*
     * Propósito: Permite agregar nuevas funcionalidades a objetos de forma dinámica
     * colocándolos dentro de objetos contenedores especiales (decoradores).
     *
     * Cuándo usarlo: Cuando quieres agregar responsabilidades a objetos individuales
     * sin afectar a otros objetos de la misma clase.
     */

    interface Cafe {
        String getDescripcion();
        double getCosto();
    }

    // Componente base
    class CafeSimple implements Cafe {
        @Override
        public String getDescripcion() {
            return "Café simple";
        }

        @Override
        public double getCosto() {
            return 2.0;
        }
    }

    // Decorador abstracto
    abstract class CafeDecorador implements Cafe {
        protected Cafe cafeDecorado;

        public CafeDecorador(Cafe cafe) {
            this.cafeDecorado = cafe;
        }

        @Override
        public String getDescripcion() {
            return cafeDecorado.getDescripcion();
        }

        @Override
        public double getCosto() {
            return cafeDecorado.getCosto();
        }
    }

    // Decoradores concretos
    class ConLeche extends CafeDecorador {
        public ConLeche(Cafe cafe) {
            super(cafe);
        }

        @Override
        public String getDescripcion() {
            return cafeDecorado.getDescripcion() + ", con leche";
        }

        @Override
        public double getCosto() {
            return cafeDecorado.getCosto() + 0.5;
        }
    }

    class ConChocolate extends CafeDecorador {
        public ConChocolate(Cafe cafe) {
            super(cafe);
        }

        @Override
        public String getDescripcion() {
            return cafeDecorado.getDescripcion() + ", con chocolate";
        }

        @Override
        public double getCosto() {
            return cafeDecorado.getCosto() + 0.7;
        }
    }

    class ConCrema extends CafeDecorador {
        public ConCrema(Cafe cafe) {
            super(cafe);
        }

        @Override
        public String getDescripcion() {
            return cafeDecorado.getDescripcion() + ", con crema";
        }

        @Override
        public double getCosto() {
            return cafeDecorado.getCosto() + 0.6;
        }
    }

    void usarDecorator() {
        // Café simple
        Cafe cafe1 = new CafeSimple();
        System.out.println(cafe1.getDescripcion() + " = $" + cafe1.getCosto());

        // Café con leche
        Cafe cafe2 = new ConLeche(new CafeSimple());
        System.out.println(cafe2.getDescripcion() + " = $" + cafe2.getCosto());

        // Café con leche y chocolate
        Cafe cafe3 = new ConChocolate(new ConLeche(new CafeSimple()));
        System.out.println(cafe3.getDescripcion() + " = $" + cafe3.getCosto());

        // Café completo: con leche, chocolate y crema
        Cafe cafe4 = new ConCrema(new ConChocolate(new ConLeche(new CafeSimple())));
        System.out.println(cafe4.getDescripcion() + " = $" + cafe4.getCosto());
    }

    // ========================================================================
    // 33.5 FACADE PATTERN
    // ========================================================================
    /*
     * Propósito: Proporciona una interfaz simplificada a un sistema complejo.
     *
     * Cuándo usarlo: Cuando quieres ocultar la complejidad de un subsistema
     * detrás de una interfaz simple.
     */

    // Subsistemas complejos
    class CPU {
        public void freeze() { System.out.println("CPU: Congelando..."); }
        public void jump(long position) { System.out.println("CPU: Saltando a " + position); }
        public void execute() { System.out.println("CPU: Ejecutando..."); }
    }

    class Memoria {
        public void load(long position, byte[] data) {
            System.out.println("Memoria: Cargando datos en " + position);
        }
    }

    class DiscoDuro {
        public byte[] read(long lba, int size) {
            System.out.println("Disco: Leyendo " + size + " bytes desde " + lba);
            return new byte[size];
        }
    }

    // FACADE - Simplifica el uso de los subsistemas
    class ComputadoraFacade {
        private CPU cpu;
        private Memoria memoria;
        private DiscoDuro disco;

        public ComputadoraFacade() {
            this.cpu = new CPU();
            this.memoria = new Memoria();
            this.disco = new DiscoDuro();
        }

        // Método simple que oculta la complejidad
        public void iniciar() {
            System.out.println("Iniciando computadora...");
            cpu.freeze();
            memoria.load(0, disco.read(0, 1024));
            cpu.jump(0);
            cpu.execute();
            System.out.println("Computadora iniciada!");
        }
    }

    void usarFacade() {
        // Sin facade necesitarías:
        // CPU cpu = new CPU();
        // Memoria mem = new Memoria();
        // DiscoDuro disco = new DiscoDuro();
        // cpu.freeze();
        // mem.load(0, disco.read(0, 1024));
        // cpu.jump(0);
        // cpu.execute();

        // Con facade es mucho más simple:
        ComputadoraFacade computadora = new ComputadoraFacade();
        computadora.iniciar();
    }

    // ========================================================================
    // 33.6 BRIDGE PATTERN
    // ========================================================================
    /*
     * Propósito: Separa una abstracción de su implementación para que ambas
     * puedan variar independientemente.
     *
     * Cuándo usarlo: Cuando quieres evitar una explosión de subclases debido
     * a múltiples dimensiones de variación.
     */

    // Implementación (la parte que varía)
    interface DispositivoSalida {
        void mostrar(String mensaje);
    }

    class Monitor implements DispositivoSalida {
        @Override
        public void mostrar(String mensaje) {
            System.out.println("Monitor: " + mensaje);
        }
    }

    class Proyector implements DispositivoSalida {
        @Override
        public void mostrar(String mensaje) {
            System.out.println("Proyector: " + mensaje);
        }
    }

    class Impresora implements DispositivoSalida {
        @Override
        public void mostrar(String mensaje) {
            System.out.println("Impresora: " + mensaje);
        }
    }

    // Abstracción (lo que usa la implementación)
    abstract class Presentacion {
        protected DispositivoSalida dispositivo;

        public Presentacion(DispositivoSalida dispositivo) {
            this.dispositivo = dispositivo;
        }

        public abstract void mostrar();
    }

    class PresentacionNegocios extends Presentacion {
        public PresentacionNegocios(DispositivoSalida dispositivo) {
            super(dispositivo);
        }

        @Override
        public void mostrar() {
            dispositivo.mostrar("=== PRESENTACIÓN DE NEGOCIOS ===");
            dispositivo.mostrar("Ventas, gráficos, proyecciones...");
        }
    }

    class PresentacionEducativa extends Presentacion {
        public PresentacionEducativa(DispositivoSalida dispositivo) {
            super(dispositivo);
        }

        @Override
        public void mostrar() {
            dispositivo.mostrar("=== PRESENTACIÓN EDUCATIVA ===");
            dispositivo.mostrar("Lecciones, ejemplos, ejercicios...");
        }
    }

    void usarBridge() {
        // Sin Bridge necesitarías clases como:
        // PresentacionNegociosMonitor, PresentacionNegociosProyector, etc.
        // Con 2 tipos de presentación y 3 dispositivos = 6 clases! 😱

        // Con Bridge puedes combinar libremente:
        Presentacion pres1 = new PresentacionNegocios(new Monitor());
        pres1.mostrar();

        Presentacion pres2 = new PresentacionEducativa(new Proyector());
        pres2.mostrar();

        Presentacion pres3 = new PresentacionNegocios(new Impresora());
        pres3.mostrar();
    }

    // ========================================================================
    // 33.7 FLYWEIGHT PATTERN
    // ========================================================================
    /*
     * Propósito: Permite mantener más objetos en memoria compartiendo partes
     * comunes del estado entre múltiples objetos.
     *
     * Cuándo usarlo: Cuando necesitas crear una gran cantidad de objetos similares
     * y quieres ahorrar memoria.
     */

    class ArbolTipo {
        private String nombre;
        private String color;
        private String textura;

        public ArbolTipo(String nombre, String color, String textura) {
            this.nombre = nombre;
            this.color = color;
            this.textura = textura;
        }

        public void dibujar(int x, int y) {
            System.out.println("Dibujando " + nombre + " en (" + x + "," + y + ")");
        }
    }

    // Factory de Flyweights
    class FabricaArboles {
        private static java.util.HashMap<String, ArbolTipo> tiposArboles =
                new java.util.HashMap<>();

        public static ArbolTipo obtenerTipoArbol(String nombre, String color, String textura) {
            String clave = nombre + "-" + color + "-" + textura;

            ArbolTipo tipo = tiposArboles.get(clave);

            if (tipo == null) {
                tipo = new ArbolTipo(nombre, color, textura);
                tiposArboles.put(clave, tipo);
                System.out.println("Creando nuevo tipo de árbol: " + nombre);
            }

            return tipo;
        }

        public static int getCantidadTipos() {
            return tiposArboles.size();
        }
    }

    class Arbol {
        private int x;
        private int y;
        private ArbolTipo tipo;  // Estado compartido (Flyweight)

        public Arbol(int x, int y, ArbolTipo tipo) {
            this.x = x;
            this.y = y;
            this.tipo = tipo;
        }

        public void dibujar() {
            tipo.dibujar(x, y);
        }
    }

    void usarFlyweight() {
        java.util.ArrayList<Arbol> bosque = new java.util.ArrayList<>();

        // Crear 10,000 árboles de solo 3 tipos
        for (int i = 0; i < 10000; i++) {
            String tipo = (i % 3 == 0) ? "Roble" : (i % 3 == 1) ? "Pino" : "Abedul";
            ArbolTipo tipoArbol = FabricaArboles.obtenerTipoArbol(tipo, "Verde", "Rugosa");
            bosque.add(new Arbol(i, i * 2, tipoArbol));
        }

        System.out.println("Árboles creados: " + bosque.size());
        System.out.println("Tipos de árbol únicos: " + FabricaArboles.getCantidadTipos());
        // En vez de 10,000 objetos ArbolTipo, solo tenemos 3! Ahorro de memoria ✅
    }

    // ========================================================================
    // 34. PATRONES DE DISEÑO - COMPORTAMIENTO (FALTANTES)
    // ========================================================================

    // ========================================================================
    // 34.1 TEMPLATE METHOD PATTERN
    // ========================================================================
    /*
     * Propósito: Define el esqueleto de un algoritmo en un método, dejando que
     * las subclases redefinan ciertos pasos sin cambiar la estructura.
     *
     * Cuándo usarlo: Cuando tienes algoritmos similares con pequeñas variaciones.
     */

    abstract class PreparadorBebida {
        // Template Method - define el algoritmo
        public final void prepararBebida() {
            hervirAgua();
            agregarIngredientePrincipal();
            verterEnTaza();
            agregarCondimentos();
        }

        // Pasos comunes (implementados)
        private void hervirAgua() {
            System.out.println("Hirviendo agua...");
        }

        private void verterEnTaza() {
            System.out.println("Vertiendo en taza...");
        }

        // Pasos que varían (abstractos - las subclases los implementan)
        protected abstract void agregarIngredientePrincipal();
        protected abstract void agregarCondimentos();
    }

    class PreparadorTe extends PreparadorBebida {
        @Override
        protected void agregarIngredientePrincipal() {
            System.out.println("Agregando bolsita de té");
        }

        @Override
        protected void agregarCondimentos() {
            System.out.println("Agregando limón");
        }
    }

    class PreparadorCafe2 extends PreparadorBebida {
        @Override
        protected void agregarIngredientePrincipal() {
            System.out.println("Agregando café molido");
        }

        @Override
        protected void agregarCondimentos() {
            System.out.println("Agregando azúcar y leche");
        }
    }

    void usarTemplateMethod() {
        System.out.println("Preparando té:");
        PreparadorBebida te = new PreparadorTe();
        te.prepararBebida();

        System.out.println("\nPreparando café:");
        PreparadorBebida cafe = new PreparadorCafe2();
        cafe.prepararBebida();
    }

    // ========================================================================
    // 34.2 MEDIATOR PATTERN
    // ========================================================================
    /*
     * Propósito: Reduce las dependencias caóticas entre objetos haciendo que
     * se comuniquen indirectamente a través de un objeto mediador.
     *
     * Cuándo usarlo: Cuando tienes muchos objetos que necesitan comunicarse
     * entre sí y quieres reducir el acoplamiento.
     */

    interface ChatMediator {
        void enviarMensaje(String mensaje, Usuario usuario);
        void agregarUsuario(Usuario usuario);
    }

    class ChatRoom implements ChatMediator {
        private java.util.ArrayList<Usuario> usuarios;

        public ChatRoom() {
            this.usuarios = new java.util.ArrayList<>();
        }

        @Override
        public void agregarUsuario(Usuario usuario) {
            usuarios.add(usuario);
        }

        @Override
        public void enviarMensaje(String mensaje, Usuario remitente) {
            for (Usuario usuario : usuarios) {
                // No enviar al remitente
                if (usuario != remitente) {
                    usuario.recibir(mensaje);
                }
            }
        }
    }

    abstract class Usuario {
        protected ChatMediator mediator;
        protected String nombre;

        public Usuario(ChatMediator mediator, String nombre) {
            this.mediator = mediator;
            this.nombre = nombre;
        }

        public abstract void enviar(String mensaje);
        public abstract void recibir(String mensaje);
    }

    class UsuarioConcretoChat extends Usuario {
        public UsuarioConcretoChat(ChatMediator mediator, String nombre) {
            super(mediator, nombre);
        }

        @Override
        public void enviar(String mensaje) {
            System.out.println(nombre + " envía: " + mensaje);
            mediator.enviarMensaje(mensaje, this);
        }

        @Override
        public void recibir(String mensaje) {
            System.out.println(nombre + " recibe: " + mensaje);
        }
    }

    void usarMediator() {
        ChatMediator chatRoom = new ChatRoom();

        Usuario juan = new UsuarioConcretoChat(chatRoom, "Juan");
        Usuario maria = new UsuarioConcretoChat(chatRoom, "María");
        Usuario pedro = new UsuarioConcretoChat(chatRoom, "Pedro");

        chatRoom.agregarUsuario(juan);
        chatRoom.agregarUsuario(maria);
        chatRoom.agregarUsuario(pedro);

        juan.enviar("Hola a todos!");
        // María y Pedro reciben el mensaje (Juan no recibe su propio mensaje)
    }

    // ========================================================================
    // 34.3 CHAIN OF RESPONSIBILITY PATTERN
    // ========================================================================
    /*
     * Propósito: Permite pasar solicitudes a lo largo de una cadena de manejadores.
     * Cada manejador decide si procesa la solicitud o la pasa al siguiente.
     *
     * Cuándo usarlo: Cuando tienes múltiples objetos que pueden manejar una
     * solicitud y el manejador se determina en tiempo de ejecución.
     */

    abstract class ManejadorSoporte {
        protected ManejadorSoporte siguiente;

        public void setSiguiente(ManejadorSoporte siguiente) {
            this.siguiente = siguiente;
        }

        public abstract void manejarSolicitud(String solicitud, int prioridad);
    }

    class SoporteNivel1 extends ManejadorSoporte {
        @Override
        public void manejarSolicitud(String solicitud, int prioridad) {
            if (prioridad <= 1) {
                System.out.println("Soporte Nivel 1 maneja: " + solicitud);
            } else if (siguiente != null) {
                siguiente.manejarSolicitud(solicitud, prioridad);
            }
        }
    }

    class SoporteNivel2 extends ManejadorSoporte {
        @Override
        public void manejarSolicitud(String solicitud, int prioridad) {
            if (prioridad == 2) {
                System.out.println("Soporte Nivel 2 maneja: " + solicitud);
            } else if (siguiente != null) {
                siguiente.manejarSolicitud(solicitud, prioridad);
            }
        }
    }

    class SoporteNivel3 extends ManejadorSoporte {
        @Override
        public void manejarSolicitud(String solicitud, int prioridad) {
            if (prioridad >= 3) {
                System.out.println("Soporte Nivel 3 (experto) maneja: " + solicitud);
            } else if (siguiente != null) {
                siguiente.manejarSolicitud(solicitud, prioridad);
            }
        }
    }

    void usarChainOfResponsibility() {
        // Configurar la cadena
        ManejadorSoporte nivel1 = new SoporteNivel1();
        ManejadorSoporte nivel2 = new SoporteNivel2();
        ManejadorSoporte nivel3 = new SoporteNivel3();

        nivel1.setSiguiente(nivel2);
        nivel2.setSiguiente(nivel3);

        // Enviar solicitudes - cada una es manejada por el nivel apropiado
        nivel1.manejarSolicitud("Resetear contraseña", 1);
        nivel1.manejarSolicitud("Error en aplicación", 2);
        nivel1.manejarSolicitud("Servidor caído", 3);
    }

    // ========================================================================
    // 34.4 OBSERVER PATTERN
    // ========================================================================
    /*
     * Propósito: Define una dependencia uno-a-muchos entre objetos de modo que
     * cuando un objeto cambia de estado, todos sus dependientes son notificados.
     *
     * Cuándo usarlo: Implementar sistemas de eventos, notificaciones, listeners.
     */

    interface Observer {
        void actualizar(String mensaje);
    }

    class Suscriptor implements Observer {
        private String nombre;

        public Suscriptor(String nombre) {
            this.nombre = nombre;
        }

        @Override
        public void actualizar(String mensaje) {
            System.out.println(nombre + " recibió notificación: " + mensaje);
        }
    }

    class Canal {
        private java.util.ArrayList<Observer> suscriptores;
        private String ultimoVideo;

        public Canal() {
            this.suscriptores = new java.util.ArrayList<>();
        }

        public void suscribir(Observer observer) {
            suscriptores.add(observer);
        }

        public void desuscribir(Observer observer) {
            suscriptores.remove(observer);
        }

        public void subirVideo(String titulo) {
            this.ultimoVideo = titulo;
            notificarSuscriptores();
        }

        private void notificarSuscriptores() {
            for (Observer observer : suscriptores) {
                observer.actualizar("Nuevo video: " + ultimoVideo);
            }
        }
    }

    void usarObserver() {
        Canal canalJava = new Canal();

        Observer sub1 = new Suscriptor("Ana");
        Observer sub2 = new Suscriptor("Luis");
        Observer sub3 = new Suscriptor("María");

        canalJava.suscribir(sub1);
        canalJava.suscribir(sub2);
        canalJava.suscribir(sub3);

        canalJava.subirVideo("Tutorial Java POO");
        // Todos los suscriptores reciben notificación

        canalJava.desuscribir(sub2);
        canalJava.subirVideo("Patrones de Diseño");
        // Solo Ana y María reciben esta notificación
    }

    // ========================================================================
    // 34.5 COMMAND PATTERN
    // ========================================================================
    /*
     * Propósito: Encapsula una solicitud como un objeto, permitiendo parametrizar
     * clientes con diferentes solicitudes, encolar solicitudes y hacer deshacer.
     *
     * Cuándo usarlo: Implementar undo/redo, macros, transacciones.
     */

    interface Comando {
        void ejecutar();
        void deshacer();
    }

    class Luz {
        public void encender() {
            System.out.println("Luz encendida");
        }

        public void apagar() {
            System.out.println("Luz apagada");
        }
    }

    class ComandoEncenderLuz implements Comando {
        private Luz luz;

        public ComandoEncenderLuz(Luz luz) {
            this.luz = luz;
        }

        @Override
        public void ejecutar() {
            luz.encender();
        }

        @Override
        public void deshacer() {
            luz.apagar();
        }
    }

    class ComandoApagarLuz implements Comando {
        private Luz luz;

        public ComandoApagarLuz(Luz luz) {
            this.luz = luz;
        }

        @Override
        public void ejecutar() {
            luz.apagar();
        }

        @Override
        public void deshacer() {
            luz.encender();
        }
    }

    class ControlRemoto {
        private Comando comando;
        private java.util.Stack<Comando> historial;

        public ControlRemoto() {
            this.historial = new java.util.Stack<>();
        }

        public void setComando(Comando comando) {
            this.comando = comando;
        }

        public void presionarBoton() {
            comando.ejecutar();
            historial.push(comando);
        }

        public void presionarDeshacer() {
            if (!historial.isEmpty()) {
                Comando ultimoComando = historial.pop();
                ultimoComando.deshacer();
            }
        }
    }

    void usarCommand() {
        Luz luz = new Luz();
        Comando encender = new ComandoEncenderLuz(luz);
        Comando apagar = new ComandoApagarLuz(luz);

        ControlRemoto control = new ControlRemoto();

        control.setComando(encender);
        control.presionarBoton();  // Luz encendida

        control.setComando(apagar);
        control.presionarBoton();  // Luz apagada

        control.presionarDeshacer();  // Deshacer apagar -> Luz encendida
        control.presionarDeshacer();  // Deshacer encender -> Luz apagada
    }

    // ========================================================================
    // 34.6 STATE PATTERN
    // ========================================================================
    /*
     * Propósito: Permite a un objeto alterar su comportamiento cuando su estado
     * interno cambia. Parece que el objeto cambió su clase.
     *
     * Cuándo usarlo: Cuando un objeto tiene muchos estados y su comportamiento
     * cambia según el estado.
     */

    interface Estado {
        void manejar(Contexto contexto);
    }

    class EstadoNuevo implements Estado {
        @Override
        public void manejar(Contexto contexto) {
            System.out.println("Orden nueva - Procesando...");
            contexto.setEstado(new EstadoProcesando());
        }
    }

    class EstadoProcesando implements Estado {
        @Override
        public void manejar(Contexto contexto) {
            System.out.println("Orden procesada - Enviando...");
            contexto.setEstado(new EstadoEnviado());
        }
    }

    class EstadoEnviado implements Estado {
        @Override
        public void manejar(Contexto contexto) {
            System.out.println("Orden enviada - Entregando...");
            contexto.setEstado(new EstadoEntregado());
        }
    }

    class EstadoEntregado implements Estado {
        @Override
        public void manejar(Contexto contexto) {
            System.out.println("Orden entregada - Proceso completado");
        }
    }

    class Contexto {
        private Estado estado;

        public Contexto() {
            this.estado = new EstadoNuevo();
        }

        public void setEstado(Estado estado) {
            this.estado = estado;
        }

        public void solicitar() {
            estado.manejar(this);
        }
    }

    void usarState() {
        Contexto orden = new Contexto();

        orden.solicitar();  // Nuevo -> Procesando
        orden.solicitar();  // Procesando -> Enviado
        orden.solicitar();  // Enviado -> Entregado
        orden.solicitar();  // Entregado (no cambia más)
    }

    // ========================================================================
    // 34.7 ITERATOR PATTERN
    // ========================================================================
    /*
     * Propósito: Proporciona una manera de acceder secuencialmente a los elementos
     * de un objeto agregado sin exponer su representación interna.
     *
     * Cuándo usarlo: Java ya lo implementa con Iterator<T>, pero es útil entenderlo.
     */

    interface IteradorPersonalizado<T> {
        boolean tieneSiguiente();
        T siguiente();
    }

    class ColeccionLibros {
        private String[] libros;
        private int indice = 0;

        public ColeccionLibros(int tamaño) {
            libros = new String[tamaño];
        }

        public void agregarLibro(String libro) {
            if (indice < libros.length) {
                libros[indice] = libro;
                indice++;
            }
        }

        public IteradorPersonalizado<String> crearIterador() {
            return new IteradorLibros();
        }

        private class IteradorLibros implements IteradorPersonalizado<String> {
            private int posicion = 0;

            @Override
            public boolean tieneSiguiente() {
                return posicion < libros.length && libros[posicion] != null;
            }

            @Override
            public String siguiente() {
                String libro = libros[posicion];
                posicion++;
                return libro;
            }
        }
    }

    void usarIterator() {
        ColeccionLibros biblioteca = new ColeccionLibros(5);
        biblioteca.agregarLibro("1984");
        biblioteca.agregarLibro("El Quijote");
        biblioteca.agregarLibro("Cien Años de Soledad");

        IteradorPersonalizado<String> iterador = biblioteca.crearIterador();

        while (iterador.tieneSiguiente()) {
            System.out.println("Libro: " + iterador.siguiente());
        }
    }

    // ========================================================================
    // 34.8 MEMENTO PATTERN
    // ========================================================================
    /*
     * Propósito: Permite guardar y restaurar el estado previo de un objeto
     * sin revelar los detalles de su implementación.
     *
     * Cuándo usarlo: Implementar undo/redo, checkpoints, snapshots.
     */

    // Memento - guarda el estado
    class EditorMemento {
        private final String contenido;
        private final int cursor;

        public EditorMemento(String contenido, int cursor) {
            this.contenido = contenido;
            this.cursor = cursor;
        }

        public String getContenido() {
            return contenido;
        }

        public int getCursor() {
            return cursor;
        }
    }

    // Originator - crea y restaura mementos
    class EditorTexto {
        private String contenido;
        private int cursor;

        public EditorTexto() {
            this.contenido = "";
            this.cursor = 0;
        }

        public void escribir(String texto) {
            contenido += texto;
            cursor = contenido.length();
        }

        public void setCursor(int posicion) {
            this.cursor = posicion;
        }

        public void mostrarEstado() {
            System.out.println("Contenido: '" + contenido + "' | Cursor: " + cursor);
        }

        // Guardar estado
        public EditorMemento guardar() {
            return new EditorMemento(contenido, cursor);
        }

        // Restaurar estado
        public void restaurar(EditorMemento memento) {
            this.contenido = memento.getContenido();
            this.cursor = memento.getCursor();
        }
    }

    // Caretaker - maneja los mementos
    class HistorialEditor {
        private java.util.Stack<EditorMemento> historial;

        public HistorialEditor() {
            this.historial = new java.util.Stack<>();
        }

        public void guardar(EditorMemento memento) {
            historial.push(memento);
        }

        public EditorMemento deshacer() {
            if (!historial.isEmpty()) {
                return historial.pop();
            }
            return null;
        }
    }

    void usarMemento() {
        EditorTexto editor = new EditorTexto();
        HistorialEditor historial = new HistorialEditor();

        editor.escribir("Hola ");
        editor.mostrarEstado();
        historial.guardar(editor.guardar());  // Checkpoint

        editor.escribir("Mundo");
        editor.mostrarEstado();
        historial.guardar(editor.guardar());  // Checkpoint

        editor.escribir("!");
        editor.mostrarEstado();

        // Deshacer 2 veces
        editor.restaurar(historial.deshacer());
        editor.mostrarEstado();  // "Hola Mundo"

        editor.restaurar(historial.deshacer());
        editor.mostrarEstado();  // "Hola "
    }

    // ========================================================================
    // 34.9 INTERPRETER PATTERN
    // ========================================================================
    /*
     * Propósito: Define una representación para la gramática de un lenguaje
     * y un intérprete que usa la representación para interpretar sentencias.
     *
     * Cuándo usarlo: Implementar lenguajes simples, expresiones matemáticas,
     * reglas de negocio.
     */

    interface Expresion {
        int interpretar();
    }

    class Numero implements Expresion {
        private int numero;

        public Numero(int numero) {
            this.numero = numero;
        }

        @Override
        public int interpretar() {
            return numero;
        }
    }

    class Suma implements Expresion {
        private Expresion izquierda;
        private Expresion derecha;

        public Suma(Expresion izquierda, Expresion derecha) {
            this.izquierda = izquierda;
            this.derecha = derecha;
        }

        @Override
        public int interpretar() {
            return izquierda.interpretar() + derecha.interpretar();
        }
    }

    class Resta implements Expresion {
        private Expresion izquierda;
        private Expresion derecha;

        public Resta(Expresion izquierda, Expresion derecha) {
            this.izquierda = izquierda;
            this.derecha = derecha;
        }

        @Override
        public int interpretar() {
            return izquierda.interpretar() - derecha.interpretar();
        }
    }

    class Multiplicacion implements Expresion {
        private Expresion izquierda;
        private Expresion derecha;

        public Multiplicacion(Expresion izquierda, Expresion derecha) {
            this.izquierda = izquierda;
            this.derecha = derecha;
        }

        @Override
        public int interpretar() {
            return izquierda.interpretar() * derecha.interpretar();
        }
    }

    void usarInterpreter() {
        // Expresión: (5 + 3) * (10 - 2)
        Expresion expr = new Multiplicacion(
            new Suma(new Numero(5), new Numero(3)),
            new Resta(new Numero(10), new Numero(2))
        );

        System.out.println("Resultado: " + expr.interpretar());  // 64
    }

    // ========================================================================
    // 35. UTILIDADES AVANZADAS
    // ========================================================================

    // ========================================================================
    // 35.1 STRINGBUILDER - Manejo eficiente de Strings
    // ========================================================================
    /*
     * Propósito: Crear y modificar strings de forma eficiente.
     * Los Strings son INMUTABLES - cada concatenación crea un nuevo objeto.
     * StringBuilder es MUTABLE - modificas el mismo objeto.
     *
     * Cuándo usarlo: Cuando necesitas concatenar muchos strings en un loop.
     */

    void ejemploStringBuilder() {
        // ❌ INEFICIENTE - crea un nuevo String en cada iteración
        String resultado = "";
        for (int i = 0; i < 1000; i++) {
            resultado += i + ",";  // Muy lento con muchas iteraciones
        }

        // ✅ EFICIENTE - modifica el mismo StringBuilder
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 1000; i++) {
            sb.append(i).append(",");  // Mucho más rápido
        }
        String resultado2 = sb.toString();

        // Métodos útiles de StringBuilder
        StringBuilder builder = new StringBuilder("Hola");
        builder.append(" Mundo");           // "Hola Mundo"
        builder.insert(5, " Java");         // "Hola Java Mundo"
        builder.delete(5, 10);              // "Hola Mundo"
        builder.reverse();                  // "odnuM aloH"
        builder.replace(0, 5, "Hola");      // "Hola aloH"

        String final_str = builder.toString();

        // StringBuilder vs StringBuffer
        // StringBuilder: NO thread-safe, más rápido (usa este normalmente)
        // StringBuffer: Thread-safe, más lento (solo si necesitas sincronización)
    }

    // ========================================================================
    // 35.2 HASHMAP - Estructuras clave-valor
    // ========================================================================
    /*
     * Propósito: Almacenar pares clave-valor para búsqueda rápida O(1).
     *
     * Cuándo usarlo: Cuando necesitas buscar valores por una clave única.
     */

    void ejemploHashMap() {
        // Importar: import java.util.HashMap;

        // Crear HashMap<TipoClave, TipoValor>
        java.util.HashMap<String, Integer> edades = new java.util.HashMap<>();

        // Agregar elementos (put)
        edades.put("Ana", 25);
        edades.put("Luis", 30);
        edades.put("María", 28);

        // Obtener valor por clave (get)
        int edadAna = edades.get("Ana");  // 25

        // Verificar si existe una clave
        boolean existe = edades.containsKey("Pedro");  // false

        // Verificar si existe un valor
        boolean tieneEdad25 = edades.containsValue(25);  // true

        // Eliminar
        edades.remove("Luis");

        // Tamaño
        int size = edades.size();  // 2

        // Recorrer claves
        for (String nombre : edades.keySet()) {
            System.out.println(nombre);
        }

        // Recorrer valores
        for (int edad : edades.values()) {
            System.out.println(edad);
        }

        // Recorrer pares clave-valor
        for (java.util.Map.Entry<String, Integer> entry : edades.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }

        // getOrDefault - evita NullPointerException
        int edadPedro = edades.getOrDefault("Pedro", 0);  // 0 (no existe)

        // putIfAbsent - solo agrega si la clave no existe
        edades.putIfAbsent("Ana", 50);  // No hace nada, Ana ya existe con 25
    }

    void ejemploHashMapAvanzado() {
        // HashMap de objetos
        java.util.HashMap<String, Persona> personas = new java.util.HashMap<>();
        personas.put("001", new Persona("Ana", 25));
        personas.put("002", new Persona("Luis", 30));

        Persona p = personas.get("001");

        // HashMap de listas
        java.util.HashMap<String, java.util.ArrayList<String>> gruposCursos =
                new java.util.HashMap<>();

        java.util.ArrayList<String> cursosAna = new java.util.ArrayList<>();
        cursosAna.add("Java");
        cursosAna.add("Python");
        gruposCursos.put("Ana", cursosAna);
    }

    // ========================================================================
    // 35.3 COMPARABLE - Comparación natural
    // ========================================================================
    /*
     * Propósito: Define el orden "natural" de los objetos de una clase.
     * Implementa un único método: compareTo()
     *
     * Cuándo usarlo: Cuando hay UNA forma obvia de ordenar objetos
     * (ej: Personas por edad, Strings alfabéticamente).
     */

    class Estudiante implements Comparable<Estudiante> {
        private String nombre;
        private double promedio;

        public Estudiante(String nombre, double promedio) {
            this.nombre = nombre;
            this.promedio = promedio;
        }

        public String getNombre() { return nombre; }
        public double getPromedio() { return promedio; }

        @Override
        public int compareTo(Estudiante otro) {
            // Retorna:
            // negativo si this < otro
            // cero si this == otro
            // positivo si this > otro

            // Ordenar por promedio (ascendente)
            return Double.compare(this.promedio, otro.promedio);

            // Para orden descendente:
            // return Double.compare(otro.promedio, this.promedio);
        }

        @Override
        public String toString() {
            return nombre + " (" + promedio + ")";
        }
    }

    void usarComparable() {
        java.util.ArrayList<Estudiante> estudiantes = new java.util.ArrayList<>();
        estudiantes.add(new Estudiante("Ana", 8.5));
        estudiantes.add(new Estudiante("Luis", 9.2));
        estudiantes.add(new Estudiante("María", 7.8));

        // Ordenar usando el orden natural (compareTo)
        java.util.Collections.sort(estudiantes);

        System.out.println("Ordenados por promedio:");
        for (Estudiante e : estudiantes) {
            System.out.println(e);
        }
    }

    // ========================================================================
    // 35.4 COMPARATOR - Comparación personalizada
    // ========================================================================
    /*
     * Propósito: Define múltiples formas de ordenar objetos.
     * Creas diferentes Comparators para diferentes criterios de ordenamiento.
     *
     * Cuándo usarlo: Cuando necesitas MÚLTIPLES formas de ordenar
     * (ej: Personas por edad, por nombre, por salario).
     */

    class Producto {
        private String nombre;
        private double precio;
        private int stock;

        public Producto(String nombre, double precio, int stock) {
            this.nombre = nombre;
            this.precio = precio;
            this.stock = stock;
        }

        public String getNombre() { return nombre; }
        public double getPrecio() { return precio; }
        public int getStock() { return stock; }

        @Override
        public String toString() {
            return nombre + " - $" + precio + " (Stock: " + stock + ")";
        }
    }

    // Comparador por precio
    class ComparadorPorPrecio implements java.util.Comparator<Producto> {
        @Override
        public int compare(Producto p1, Producto p2) {
            return Double.compare(p1.getPrecio(), p2.getPrecio());
        }
    }

    // Comparador por nombre
    class ComparadorPorNombre implements java.util.Comparator<Producto> {
        @Override
        public int compare(Producto p1, Producto p2) {
            return p1.getNombre().compareTo(p2.getNombre());
        }
    }

    // Comparador por stock
    class ComparadorPorStock implements java.util.Comparator<Producto> {
        @Override
        public int compare(Producto p1, Producto p2) {
            return Integer.compare(p1.getStock(), p2.getStock());
        }
    }

    void usarComparator() {
        java.util.ArrayList<Producto> productos = new java.util.ArrayList<>();
        productos.add(new Producto("Laptop", 1200.0, 5));
        productos.add(new Producto("Mouse", 25.0, 50));
        productos.add(new Producto("Teclado", 80.0, 20));

        System.out.println("Ordenados por precio:");
        java.util.Collections.sort(productos, new ComparadorPorPrecio());
        for (Producto p : productos) {
            System.out.println(p);
        }

        System.out.println("\nOrdenados por nombre:");
        java.util.Collections.sort(productos, new ComparadorPorNombre());
        for (Producto p : productos) {
            System.out.println(p);
        }

        System.out.println("\nOrdenados por stock:");
        java.util.Collections.sort(productos, new ComparadorPorStock());
        for (Producto p : productos) {
            System.out.println(p);
        }
    }

    // ========================================================================
    // 35.5 LAMBDA EXPRESSIONS - Sintaxis moderna
    // ========================================================================
    /*
     * Propósito: Forma concisa de implementar interfaces funcionales (1 solo método).
     * Sintaxis: (parametros) -> expresion
     *
     * Introducido en Java 8.
     */

    void ejemplosLambdas() {
        // Sin lambdas (forma antigua):
        java.util.Comparator<Integer> comparadorViejo = new java.util.Comparator<Integer>() {
            @Override
            public int compare(Integer a, Integer b) {
                return a.compareTo(b);
            }
        };

        // Con lambdas (forma moderna):
        java.util.Comparator<Integer> comparadorNuevo = (a, b) -> a.compareTo(b);

        // Ejemplos de sintaxis lambda:

        // Sin parámetros
        Runnable r1 = () -> System.out.println("Hola");

        // Un parámetro (paréntesis opcionales)
        java.util.function.Consumer<String> c1 = mensaje -> System.out.println(mensaje);
        java.util.function.Consumer<String> c2 = (mensaje) -> System.out.println(mensaje);

        // Múltiples parámetros
        java.util.Comparator<Integer> comp = (a, b) -> a - b;

        // Bloque de código (necesita llaves y return explícito)
        java.util.Comparator<Integer> comp2 = (a, b) -> {
            System.out.println("Comparando " + a + " y " + b);
            return a - b;
        };

        // USO PRÁCTICO: Ordenar con lambdas
        java.util.ArrayList<Producto> productos = new java.util.ArrayList<>();
        productos.add(new Producto("Laptop", 1200.0, 5));
        productos.add(new Producto("Mouse", 25.0, 50));

        // Ordenar por precio (lambda en lugar de crear clase Comparator)
        productos.sort((p1, p2) -> Double.compare(p1.getPrecio(), p2.getPrecio()));

        // Ordenar por nombre
        productos.sort((p1, p2) -> p1.getNombre().compareTo(p2.getNombre()));

        // forEach con lambda
        productos.forEach(p -> System.out.println(p));

        // removeIf con lambda
        productos.removeIf(p -> p.getPrecio() < 30);
    }

    // ========================================================================
    // 35.6 STREAMS API - Programación funcional
    // ========================================================================
    /*
     * Propósito: Procesar colecciones de forma declarativa (qué hacer, no cómo hacerlo).
     * Operaciones: filter, map, reduce, collect, etc.
     *
     * Introducido en Java 8.
     */

    void ejemplosStreams() {
        java.util.ArrayList<Integer> numeros = new java.util.ArrayList<>();
        for (int i = 1; i <= 10; i++) {
            numeros.add(i);
        }

        // ========== FILTER - Filtrar elementos ==========
        // Sin streams (forma imperativa):
        java.util.ArrayList<Integer> pares = new java.util.ArrayList<>();
        for (int n : numeros) {
            if (n % 2 == 0) {
                pares.add(n);
            }
        }

        // Con streams (forma declarativa):
        java.util.List<Integer> paresStream = numeros.stream()
                .filter(n -> n % 2 == 0)
                .collect(java.util.stream.Collectors.toList());

        // ========== MAP - Transformar elementos ==========
        // Duplicar cada número
        java.util.List<Integer> duplicados = numeros.stream()
                .map(n -> n * 2)
                .collect(java.util.stream.Collectors.toList());

        // ========== REDUCE - Reducir a un solo valor ==========
        // Sumar todos los números
        int suma = numeros.stream()
                .reduce(0, (a, b) -> a + b);

        // ========== SORTED - Ordenar ==========
        java.util.List<Integer> ordenados = numeros.stream()
                .sorted()
                .collect(java.util.stream.Collectors.toList());

        // Ordenar descendente
        java.util.List<Integer> descendente = numeros.stream()
                .sorted((a, b) -> b - a)
                .collect(java.util.stream.Collectors.toList());

        // ========== LIMIT y SKIP ==========
        // Primeros 5 elementos
        java.util.List<Integer> primeros5 = numeros.stream()
                .limit(5)
                .collect(java.util.stream.Collectors.toList());

        // Saltar los primeros 3 y tomar el resto
        java.util.List<Integer> sin3Primeros = numeros.stream()
                .skip(3)
                .collect(java.util.stream.Collectors.toList());

        // ========== DISTINCT - Eliminar duplicados ==========
        java.util.ArrayList<Integer> conDuplicados = new java.util.ArrayList<>();
        conDuplicados.add(1);
        conDuplicados.add(2);
        conDuplicados.add(2);
        conDuplicados.add(3);

        java.util.List<Integer> sinDuplicados = conDuplicados.stream()
                .distinct()
                .collect(java.util.stream.Collectors.toList());

        // ========== Encadenar operaciones ==========
        // Filtrar pares, duplicarlos, ordenar descendente, tomar primeros 3
        java.util.List<Integer> resultado = numeros.stream()
                .filter(n -> n % 2 == 0)
                .map(n -> n * 2)
                .sorted((a, b) -> b - a)
                .limit(3)
                .collect(java.util.stream.Collectors.toList());

        // ========== anyMatch, allMatch, noneMatch ==========
        boolean hayPares = numeros.stream().anyMatch(n -> n % 2 == 0);
        boolean todosPares = numeros.stream().allMatch(n -> n % 2 == 0);
        boolean ningunoNegativo = numeros.stream().noneMatch(n -> n < 0);

        // ========== forEach - Acción para cada elemento ==========
        numeros.stream()
                .filter(n -> n > 5)
                .forEach(n -> System.out.println("Número: " + n));
    }

    void ejemplosStreamsConObjetos() {
        java.util.ArrayList<Producto> productos = new java.util.ArrayList<>();
        productos.add(new Producto("Laptop", 1200.0, 5));
        productos.add(new Producto("Mouse", 25.0, 50));
        productos.add(new Producto("Teclado", 80.0, 20));
        productos.add(new Producto("Monitor", 300.0, 10));

        // Filtrar productos con precio > 100
        java.util.List<Producto> caros = productos.stream()
                .filter(p -> p.getPrecio() > 100)
                .collect(java.util.stream.Collectors.toList());

        // Obtener solo los nombres
        java.util.List<String> nombres = productos.stream()
                .map(p -> p.getNombre())
                .collect(java.util.stream.Collectors.toList());

        // Calcular precio total del inventario
        double precioTotal = productos.stream()
                .mapToDouble(p -> p.getPrecio() * p.getStock())
                .sum();

        // Producto más caro
        java.util.Optional<Producto> masCaro = productos.stream()
                .max((p1, p2) -> Double.compare(p1.getPrecio(), p2.getPrecio()));

        if (masCaro.isPresent()) {
            System.out.println("Más caro: " + masCaro.get());
        }
    }

    // ========================================================================
    // 36. JAVADOC - Documentación de código
    // ========================================================================
    /*
     * Propósito: Documentar clases, métodos y atributos de forma estandarizada.
     * Genera documentación HTML automáticamente.
     */

    /**
     * Clase que representa un rectángulo con ancho y alto.
     *
     * <p>Esta clase proporciona métodos para calcular el área y perímetro
     * del rectángulo.</p>
     *
     * @author Tu Nombre
     * @version 1.0
     * @since 2024
     */
    class RectanguloDocumentado {
        /**
         * Ancho del rectángulo en unidades.
         */
        private double ancho;

        /**
         * Alto del rectángulo en unidades.
         */
        private double alto;

        /**
         * Construye un nuevo rectángulo con el ancho y alto especificados.
         *
         * @param ancho el ancho del rectángulo, debe ser positivo
         * @param alto el alto del rectángulo, debe ser positivo
         * @throws IllegalArgumentException si ancho o alto son negativos o cero
         */
        public RectanguloDocumentado(double ancho, double alto) {
            if (ancho <= 0 || alto <= 0) {
                throw new IllegalArgumentException("Ancho y alto deben ser positivos");
            }
            this.ancho = ancho;
            this.alto = alto;
        }

        /**
         * Calcula el área del rectángulo.
         *
         * <p>El área se calcula multiplicando el ancho por el alto.</p>
         *
         * @return el área del rectángulo
         * @see #calcularPerimetro()
         */
        public double calcularArea() {
            return ancho * alto;
        }

        /**
         * Calcula el perímetro del rectángulo.
         *
         * @return el perímetro del rectángulo
         */
        public double calcularPerimetro() {
            return 2 * (ancho + alto);
        }

        /**
         * Verifica si este rectángulo es un cuadrado.
         *
         * <p>Un rectángulo es un cuadrado si su ancho es igual a su alto.</p>
         *
         * @return {@code true} si es un cuadrado, {@code false} en caso contrario
         */
        public boolean esCuadrado() {
            return ancho == alto;
        }

        /**
         * Redimensiona el rectángulo por un factor dado.
         *
         * @param factor el factor de escala (ej: 2.0 duplica el tamaño)
         * @throws IllegalArgumentException si el factor es negativo o cero
         * @deprecated Usar {@link #redimensionarPorAncho(double)} o
         *             {@link #redimensionarPorAlto(double)} en su lugar
         */
        @Deprecated
        public void redimensionar(double factor) {
            if (factor <= 0) {
                throw new IllegalArgumentException("Factor debe ser positivo");
            }
            this.ancho *= factor;
            this.alto *= factor;
        }

        /**
         * Redimensiona el rectángulo estableciendo un nuevo ancho.
         * El alto se ajusta proporcionalmente.
         *
         * @param nuevoAncho el nuevo ancho del rectángulo
         */
        public void redimensionarPorAncho(double nuevoAncho) {
            double factor = nuevoAncho / this.ancho;
            this.ancho = nuevoAncho;
            this.alto *= factor;
        }

        /**
         * Redimensiona el rectángulo estableciendo un nuevo alto.
         * El ancho se ajusta proporcionalmente.
         *
         * @param nuevoAlto el nuevo alto del rectángulo
         */
        public void redimensionarPorAlto(double nuevoAlto) {
            double factor = nuevoAlto / this.alto;
            this.alto *= factor;
            this.ancho *= factor;
        }
    }

    /*
     * TAGS COMUNES DE JAVADOC:
     *
     * @author       - Autor de la clase
     * @version      - Versión de la clase
     * @since        - Desde qué versión existe
     * @param        - Parámetro de un método
     * @return       - Valor de retorno
     * @throws       - Excepción que puede lanzar
     * @see          - Referencia a otra clase/método
     * @deprecated   - Indica que está obsoleto
     * {@code}       - Código en línea
     * {@link}       - Link a otra clase/método
     * <p>           - Párrafo
     * <ul><li>      - Lista
     */

    // ========================================================================
    // 37. EXCEPCIONES AVANZADAS
    // ========================================================================

    // ========================================================================
    // 37.1 CHECKED vs UNCHECKED EXCEPTIONS
    // ========================================================================
    /*
     * CHECKED EXCEPTIONS (Exception):
     * - Deben ser manejadas obligatoriamente (try-catch o throws)
     * - Representan condiciones recuperables
     * - Ejemplos: IOException, SQLException, FileNotFoundException
     *
     * UNCHECKED EXCEPTIONS (RuntimeException):
     * - No es obligatorio manejarlas
     * - Representan errores de programación
     * - Ejemplos: NullPointerException, ArrayIndexOutOfBoundsException
     */

    // Checked Exception - DEBE ser manejada
    class MiExcepcionChecked extends Exception {
        public MiExcepcionChecked(String mensaje) {
            super(mensaje);
        }
    }

    // Unchecked Exception - NO es obligatorio manejarla
    class MiExcepcionUnchecked extends RuntimeException {
        public MiExcepcionUnchecked(String mensaje) {
            super(mensaje);
        }
    }

    void ejemploCheckedUnchecked() {
        // ❌ No compila - checked exception no manejada
        // leerArchivoChecked("archivo.txt");

        // ✅ Debes manejarla con try-catch o declarar throws
        try {
            leerArchivoChecked("archivo.txt");
        } catch (MiExcepcionChecked e) {
            System.out.println("Error: " + e.getMessage());
        }

        // Unchecked - compila sin problemas (aunque puede fallar en runtime)
        leerArchivoUnchecked("archivo.txt");
    }

    void leerArchivoChecked(String ruta) throws MiExcepcionChecked {
        if (ruta == null) {
            throw new MiExcepcionChecked("Ruta no puede ser null");
        }
        // ... leer archivo ...
    }

    void leerArchivoUnchecked(String ruta) {
        if (ruta == null) {
            throw new MiExcepcionUnchecked("Ruta no puede ser null");
        }
        // ... leer archivo ...
    }

    // ========================================================================
    // 37.2 EXCEPCIONES PERSONALIZADAS
    // ========================================================================
    /*
     * Propósito: Crear excepciones específicas para tu dominio de aplicación.
     */

    class SaldoInsuficienteException extends Exception {
        private double saldoActual;
        private double montoSolicitado;

        public SaldoInsuficienteException(double saldoActual, double montoSolicitado) {
            super("Saldo insuficiente. Saldo: " + saldoActual + ", Solicitado: " + montoSolicitado);
            this.saldoActual = saldoActual;
            this.montoSolicitado = montoSolicitado;
        }

        public double getSaldoActual() {
            return saldoActual;
        }

        public double getMontoSolicitado() {
            return montoSolicitado;
        }

        public double getFaltante() {
            return montoSolicitado - saldoActual;
        }
    }

    class CuentaBancaria {
        private double saldo;

        public CuentaBancaria(double saldoInicial) {
            this.saldo = saldoInicial;
        }

        public void retirar(double monto) throws SaldoInsuficienteException {
            if (monto > saldo) {
                throw new SaldoInsuficienteException(saldo, monto);
            }
            saldo -= monto;
        }

        public double getSaldo() {
            return saldo;
        }
    }

    void usarExcepcionPersonalizada() {
        CuentaBancaria cuenta = new CuentaBancaria(1000);

        try {
            cuenta.retirar(1500);
        } catch (SaldoInsuficienteException e) {
            System.out.println("Error: " + e.getMessage());
            System.out.println("Faltante: $" + e.getFaltante());
        }
    }

    // ========================================================================
    // 37.3 BEST PRACTICES CON EXCEPCIONES
    // ========================================================================

    void bestPracticesExcepciones() {
        // ✅ 1. Catch excepciones específicas primero, genéricas después
        try {
            // código...
        } catch (java.io.FileNotFoundException e) {
            // Específica
        } catch (java.io.IOException e) {
            // Más general
        } catch (Exception e) {
            // La más general
        }

        // ✅ 2. No dejes catch vacíos
        try {
            // código...
        } catch (Exception e) {
            // ❌ MAL - traga la excepción silenciosamente
        }

        try {
            // código...
        } catch (Exception e) {
            // ✅ BIEN - al menos logea el error
            System.err.println("Error: " + e.getMessage());
            e.printStackTrace();
        }

        // ✅ 3. Usa finally para limpieza
        java.util.Scanner scanner = null;
        try {
            scanner = new java.util.Scanner(System.in);
            // usar scanner...
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // Se ejecuta SIEMPRE, incluso si hay return o excepción
            if (scanner != null) {
                scanner.close();
            }
        }

        // ✅ 4. Try-with-resources (Java 7+) - mejor que finally
        try (java.util.Scanner sc = new java.util.Scanner(System.in)) {
            // usar sc...
        } catch (Exception e) {
            e.printStackTrace();
        }
        // sc.close() se llama automáticamente
    }

    // ========================================================================
    // 38. CONCEPTOS DE ARQUITECTURA
    // ========================================================================

    // ========================================================================
    // 38.1 CONTRATOS - Precondiciones y Postcondiciones
    // ========================================================================
    /*
     * CONTRATO: Acuerdo entre quien llama a un método y el método mismo.
     *
     * PRECONDICIÓN: Lo que debe ser cierto ANTES de llamar al método.
     *               Responsabilidad del CLIENTE (quien llama).
     *
     * POSTCONDICIÓN: Lo que será cierto DESPUÉS de que el método termine.
     *                Responsabilidad del MÉTODO.
     *
     * INVARIANTE: Lo que debe ser cierto SIEMPRE (antes y después).
     */

    class RectanguloConContrato {
        private double ancho;
        private double alto;

        // INVARIANTE: ancho y alto siempre deben ser > 0

        /**
         * Establece el ancho del rectángulo.
         *
         * PRECONDICIÓN: nuevoAncho > 0
         * POSTCONDICIÓN: ancho == nuevoAncho
         *
         * @param nuevoAncho el nuevo ancho
         */
        public void setAncho(double nuevoAncho) {
            // Validar precondición
            if (nuevoAncho <= 0) {
                throw new IllegalArgumentException("Precondición violada: ancho debe ser > 0");
            }

            this.ancho = nuevoAncho;

            // Verificar postcondición (en desarrollo/testing)
            assert this.ancho == nuevoAncho : "Postcondición violada";
        }

        /**
         * Calcula el área.
         *
         * PRECONDICIÓN: ancho > 0 y alto > 0 (invariante)
         * POSTCONDICIÓN: retorna ancho * alto
         */
        public double calcularArea() {
            assert ancho > 0 && alto > 0 : "Invariante violada";

            double area = ancho * alto;

            assert area > 0 : "Postcondición violada: área debe ser positiva";
            return area;
        }
    }

    // ========================================================================
    // 38.2 ASERCIONES (ASSERTIONS)
    // ========================================================================
    /*
     * Propósito: Verificar suposiciones durante el desarrollo.
     * Se deshabilitan en producción con: java -da MiPrograma
     * Se habilitan con: java -ea MiPrograma
     *
     * Cuándo usarlas:
     * - Verificar precondiciones/postcondiciones/invariantes
     * - Detectar bugs durante desarrollo
     * - Documentar suposiciones del código
     *
     * Cuándo NO usarlas:
     * - NO para validar entrada del usuario (usa if/throw)
     * - NO para lógica de negocio crítica
     */

    void ejemplosAserciones() {
        int edad = 25;

        // Sintaxis básica
        assert edad >= 0;  // Falla si edad < 0

        // Con mensaje
        assert edad >= 0 : "Edad no puede ser negativa, era: " + edad;

        // Verificar precondición
        double raiz = calcularRaizCuadrada(16);

        // Verificar invariante en loop
        int suma = 0;
        for (int i = 1; i <= 10; i++) {
            suma += i;
            assert suma == i * (i + 1) / 2 : "Invariante violada en i=" + i;
        }
    }

    double calcularRaizCuadrada(double numero) {
        // Precondición
        assert numero >= 0 : "Precondición: número debe ser no negativo";

        double resultado = Math.sqrt(numero);

        // Postcondición
        assert resultado * resultado == numero : "Postcondición violada";

        return resultado;
    }

    // ========================================================================
    // 38.3 VALIDACIÓN DE DATOS
    // ========================================================================
    /*
     * Diferencia entre ASERCIONES y VALIDACIÓN:
     * - Aserciones: Para bugs internos, se desactivan en producción
     * - Validación: Para datos externos (usuario, archivo, red), SIEMPRE activa
     */

    class UsuarioConValidacion {
        private String nombre;
        private int edad;
        private String email;

        public UsuarioConValidacion(String nombre, int edad, String email) {
            // VALIDACIÓN (siempre activa)
            validarNombre(nombre);
            validarEdad(edad);
            validarEmail(email);

            this.nombre = nombre;
            this.edad = edad;
            this.email = email;

            // ASERCIÓN (solo en desarrollo)
            assert invariante() : "Invariante violada después del constructor";
        }

        private void validarNombre(String nombre) {
            if (nombre == null || nombre.trim().isEmpty()) {
                throw new IllegalArgumentException("Nombre no puede estar vacío");
            }
            if (nombre.length() < 2 || nombre.length() > 50) {
                throw new IllegalArgumentException("Nombre debe tener entre 2 y 50 caracteres");
            }
        }

        private void validarEdad(int edad) {
            if (edad < 0 || edad > 150) {
                throw new IllegalArgumentException("Edad debe estar entre 0 y 150");
            }
        }

        private void validarEmail(String email) {
            if (email == null || !email.contains("@")) {
                throw new IllegalArgumentException("Email inválido");
            }
        }

        // Invariante: verifica que el objeto siempre está en estado válido
        private boolean invariante() {
            return nombre != null && !nombre.trim().isEmpty() &&
                   edad >= 0 && edad <= 150 &&
                   email != null && email.contains("@");
        }

        public void setEdad(int nuevaEdad) {
            validarEdad(nuevaEdad);
            this.edad = nuevaEdad;
            assert invariante() : "Invariante violada después de setEdad";
        }
    }

    void usarValidacion() {
        try {
            // ✅ Válido
            UsuarioConValidacion u1 = new UsuarioConValidacion("Juan", 25, "juan@email.com");

            // ❌ Lanza excepción - nombre vacío
            UsuarioConValidacion u2 = new UsuarioConValidacion("", 25, "juan@email.com");
        } catch (IllegalArgumentException e) {
            System.out.println("Error de validación: " + e.getMessage());
        }
    }

    // ========================================================================
    // MAIN - Punto de entrada del programa
    // ========================================================================

    public static void main(String[] args) {
        System.out.println("==============================================");
        System.out.println("  CHEAT SHEET COMPLETO DE JAVA - POO");
        System.out.println("==============================================");
        System.out.println();
        System.out.println("Este archivo contiene:");
        System.out.println("  ✓ Fundamentos de Java (tipos, operadores, control de flujo)");
        System.out.println("  ✓ POO completo (clases, herencia, polimorfismo)");
        System.out.println("  ✓ Principios SOLID (todos con ejemplos)");
        System.out.println("  ✓ 23 Patrones de Diseño GoF completos:");
        System.out.println("      - Creacionales: Singleton, Factory, Abstract Factory, Builder, Prototype");
        System.out.println("      - Estructurales: Adapter, Composite, Proxy, Decorator, Facade, Bridge, Flyweight");
        System.out.println("      - Comportamiento: Strategy, Observer, Command, State, Template Method,");
        System.out.println("                        Chain of Responsibility, Mediator, Visitor, Iterator,");
        System.out.println("                        Memento, Interpreter");
        System.out.println("  ✓ Utilidades avanzadas (StringBuilder, HashMap, Comparable, Comparator)");
        System.out.println("  ✓ Lambdas y Streams API");
        System.out.println("  ✓ JavaDoc completo");
        System.out.println("  ✓ Excepciones avanzadas");
        System.out.println("  ✓ Contratos y aserciones");
        System.out.println();
        System.out.println("Este archivo es tu referencia completa para el curso de POO.");
        System.out.println("¡Úsalo para estudiar, repasar y consultar durante tus ejercicios!");
        System.out.println("==============================================");
    }
}

/*
 * ============================================================================
 * CONSEJOS FINALES
 * ============================================================================
 *
 * 1. NOMBRAMIENTO DE VARIABLES:
 *    - camelCase para variables y métodos: miVariable, calcularPromedio()
 *    - PascalCase para clases: MiClase, Persona
 *    - MAYUSCULAS_CON_GUION para constantes: MAX_VALUE, PI
 *
 * 2. BUENAS PRÁCTICAS:
 *    - Usa nombres descriptivos: edad en vez de e
 *    - Indenta correctamente tu código
 *    - Comenta código complejo
 *    - Una responsabilidad por método
 *
 * 3. ERRORES COMUNES:
 *    - Usar == para comparar Strings (usa .equals())
 *    - Olvidar break en switch-case
 *    - ArrayIndexOutOfBoundsException (índice fuera de rango)
 *    - NullPointerException (objeto null)
 *    - Dividir por cero
 *
 * 4. ATAJOS DE TECLADO (IDE):
 *    - Ctrl + Space: Autocompletar
 *    - Ctrl + /: Comentar/descomentar línea
 *    - Ctrl + D: Duplicar línea
 *    - Ctrl + Z: Deshacer
 *
 * ============================================================================
 * TIPS ESPECÍFICOS PARA PRUEBA 2 DE POO
 * ============================================================================
 *
 * PROBLEMA 1 - RUTEO (0.3 puntos):
 *
 * ¿Qué es rutear código?
 * - Seguir la ejecución línea por línea mentalmente
 * - Anotar el valor de cada variable en cada paso
 * - Identificar qué se imprime en consola
 * - Dibujar la interfaz gráfica resultante
 *
 * Pasos para rutear:
 * 1. Empieza en main()
 * 2. Sigue cada llamada a método
 * 3. Si es Singleton, la primera llamada a getInstance() crea la instancia
 * 4. Si hay Strategy, identifica qué estrategia se usa
 * 5. Si hay GUI, dibuja ventana, panel, botones según el layout
 * 6. Identifica EXIT_ON_CLOSE (cierra app) vs DISPOSE_ON_CLOSE
 * 7. BoxLayout.X_AXIS = horizontal, Y_AXIS = vertical
 *
 * ============================================================================
 * PROBLEMA 2 - RENT A CAR (0.7 puntos)
 * ============================================================================
 *
 * ARQUITECTURA OBLIGATORIA:
 * - Clase "Sistema" (usar Singleton)
 * - Herencia: Vehiculo (abstract) -> Auto, Camioneta, SUV
 * - Una sola lista: ArrayList<Vehiculo> para toda la flota
 * - Pattern Strategy: ModoManejo -> ModoEco, ModoNormal, ModoSport
 * - Pattern Visitor: VehicleVisitor -> ConsumoCalculator
 * - NO ciclos anidados (usa métodos auxiliares)
 *
 * ESTRUCTURA DE ARCHIVOS:
 * 1. Sistema.java           - Main + Singleton
 * 2. Vehiculo.java          - Clase abstracta base
 * 3. Auto.java              - extends Vehiculo
 * 4. Camioneta.java         - extends Vehiculo
 * 5. SUV.java               - extends Vehiculo
 * 6. ModoManejo.java        - interface Strategy
 * 7. ModoEco.java           - implements ModoManejo (0.9x)
 * 8. ModoNormal.java        - implements ModoManejo (1.0x)
 * 9. ModoSport.java         - implements ModoManejo (1.25x)
 * 10. VehicleVisitor.java   - interface Visitor
 * 11. ConsumoCalculator.java - implements VehicleVisitor
 *
 * LECTURA DEL ARCHIVO fleet.txt:
 * Línea 1: N (cantidad de vehículos)
 * Líneas 2 a N+1: VIN,Marca,Modelo,Tipo,Eficiencia
 * Resto: VIN,ModoManejo,Dist1,Dist2,...,DistN
 *
 * CÁLCULO DE CONSUMO:
 * consumo = distancia / eficiencia_ajustada
 *
 * Eficiencia ajustada por modo:
 * - ModoEco: eficienciaNominal * 0.9 (10% MENOS = MÁS consumo)
 * - ModoNormal: eficienciaNominal * 1.0
 * - ModoSport: eficienciaNominal * 1.25 (25% MÁS = MENOS consumo)
 *
 * PATTERN VISITOR - Implementación:
 *
 * En Vehiculo.java (abstracta):
 * public abstract void accept(VehicleVisitor visitor);
 *
 * En Auto.java:
 * @Override
 * public void accept(VehicleVisitor visitor) {
 *     visitor.visitAuto(this);
 * }
 *
 * Uso:
 * ConsumoCalculator calc = new ConsumoCalculator();
 * for (Vehiculo v : flota) {
 *     v.accept(calc);
 * }
 * calc.mostrarResultados();
 *
 * EVITAR CICLOS ANIDADOS - Usa métodos auxiliares:
 *
 * private Vehiculo buscarVehiculoPorVin(String vin) {
 *     for (Vehiculo v : flota) {
 *         if (v.getVin().equals(vin)) return v;
 *     }
 *     return null;
 * }
 *
 * FORMATO DE SALIDA:
 * System.out.printf("%s %s CONSUMO: %.2f l ODÓMETRO: %d km\n",
 *                   marca, modelo, consumo, odometro);
 *
 * CHECKLIST ANTES DE ENTREGAR:
 * - ¿Usaste Singleton en Sistema?
 * - ¿Vehiculo es abstract?
 * - ¿UNA SOLA lista ArrayList<Vehiculo>?
 * - ¿Strategy para modos de manejo?
 * - ¿Visitor para mayor consumo?
 * - ¿NO hay ciclos anidados?
 * - ¿La salida coincide con el ejemplo?
 * - ¿Exportaste como .zip?
 * - ¿Pusiste tu nombre en las hojas?
 *
 * GESTIÓN DEL TIEMPO (3 horas):
 * 0:00-0:20 → Leer 2 veces, planificar
 * 0:20-0:40 → Problema 1 (Ruteo)
 * 0:40-2:30 → Problema 2 (Rent a Car)
 * 2:30-2:50 → Testing y correcciones
 * 2:50-3:00 → Exportar .zip y subir
 *
 * ¡ÉXITO EN TU PRUEBA!
 * ============================================================================
 */
