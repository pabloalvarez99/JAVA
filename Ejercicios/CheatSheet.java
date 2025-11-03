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
    // MAIN - Punto de entrada del programa
    // ========================================================================

    public static void main(String[] args) {
        System.out.println("Este archivo es solo una referencia.");
        System.out.println("Consulta los ejercicios para practicar.");
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
 */
