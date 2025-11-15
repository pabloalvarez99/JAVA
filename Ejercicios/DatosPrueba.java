/*
 * ========================================
 * DATOS DE PRUEBA - Para todos los ejercicios
 * ========================================
 *
 * Este archivo contiene todos los datos de prueba que necesitas
 * para probar tus ejercicios sin tener que inventar datos cada vez.
 *
 * CÓMO USAR:
 * 1. Copia los datos que necesites de aquí
 * 2. Pégalos en tu ejercicio
 * 3. Verifica que tu código produzca la salida esperada
 *
 */

public class DatosPrueba {

    // ========================================
    // EJERCICIO 1: Variables
    // ========================================
    public static class Ejercicio1 {
        public static final String NOMBRE = "Pablo";
        public static final int EDAD = 20;
        public static final double ALTURA = 1.75;

        public static void mostrarDatos() {
            System.out.println("=== DATOS DE PRUEBA EJERCICIO 1 ===");
            System.out.println("Nombre: " + NOMBRE);
            System.out.println("Edad: " + EDAD);
            System.out.println("Altura: " + ALTURA);
            System.out.println("\nSalida esperada:");
            System.out.println("Hola, me llamo " + NOMBRE);
            System.out.println("Tengo " + EDAD + " años");
            System.out.println("Mido " + ALTURA + " metros");
        }
    }

    // ========================================
    // EJERCICIO 2: Operaciones Matemáticas
    // ========================================
    public static class Ejercicio2 {
        public static final int NUM1 = 10;
        public static final int NUM2 = 3;

        public static void mostrarDatos() {
            System.out.println("=== DATOS DE PRUEBA EJERCICIO 2 ===");
            System.out.println("Número 1: " + NUM1);
            System.out.println("Número 2: " + NUM2);
            System.out.println("\nResultados esperados:");
            System.out.println("Suma: " + (NUM1 + NUM2));
            System.out.println("Resta: " + (NUM1 - NUM2));
            System.out.println("Multiplicación: " + (NUM1 * NUM2));
            System.out.println("División: " + (NUM1 / NUM2));
            System.out.println("Módulo: " + (NUM1 % NUM2));
        }
    }

    // ========================================
    // EJERCICIO 3: Intercambiar Variables
    // ========================================
    public static class Ejercicio3 {
        public static final int A = 5;
        public static final int B = 10;

        public static void mostrarDatos() {
            System.out.println("=== DATOS DE PRUEBA EJERCICIO 3 ===");
            System.out.println("Valor inicial de a: " + A);
            System.out.println("Valor inicial de b: " + B);
            System.out.println("\nDespués del intercambio:");
            System.out.println("Nuevo valor de a: " + B);
            System.out.println("Nuevo valor de b: " + A);
        }
    }

    // ========================================
    // EJERCICIO 4: Condicionales
    // ========================================
    public static class Ejercicio4 {
        public static final int NUMERO_POSITIVO = 10;
        public static final int NUMERO_NEGATIVO = -5;
        public static final int NUMERO_CERO = 0;

        public static void mostrarDatos() {
            System.out.println("=== DATOS DE PRUEBA EJERCICIO 4 ===");
            System.out.println("Prueba 1 con número: " + NUMERO_POSITIVO + " → Es positivo");
            System.out.println("Prueba 2 con número: " + NUMERO_NEGATIVO + " → Es negativo");
            System.out.println("Prueba 3 con número: " + NUMERO_CERO + " → Es cero");
        }
    }

    // ========================================
    // EJERCICIO 6: Tabla de Multiplicar
    // ========================================
    public static class Ejercicio6 {
        public static final int NUMERO = 7;

        public static void mostrarDatos() {
            System.out.println("=== DATOS DE PRUEBA EJERCICIO 6 ===");
            System.out.println("Tabla del: " + NUMERO);
            System.out.println("\nResultados esperados:");
            for (int i = 1; i <= 10; i++) {
                System.out.println(NUMERO + " x " + i + " = " + (NUMERO * i));
            }
        }
    }

    // ========================================
    // EJERCICIO 7: Arrays
    // ========================================
    public static class Ejercicio7 {
        public static final int[] NUMEROS = {5, 12, 8, 23, 15, 7, 19, 4, 11, 16};

        public static void mostrarDatos() {
            System.out.println("=== DATOS DE PRUEBA EJERCICIO 7 ===");
            System.out.print("Array: [");
            for (int i = 0; i < NUMEROS.length; i++) {
                System.out.print(NUMEROS[i]);
                if (i < NUMEROS.length - 1) System.out.print(", ");
            }
            System.out.println("]");

            int suma = 0;
            int maximo = NUMEROS[0];
            int minimo = NUMEROS[0];

            for (int num : NUMEROS) {
                suma += num;
                if (num > maximo) maximo = num;
                if (num < minimo) minimo = num;
            }

            System.out.println("\nResultados esperados:");
            System.out.println("Suma: " + suma);
            System.out.println("Promedio: " + (suma / (double)NUMEROS.length));
            System.out.println("Máximo: " + maximo);
            System.out.println("Mínimo: " + minimo);
        }
    }

    // ========================================
    // EJERCICIO 8: Métodos
    // ========================================
    public static class Ejercicio8 {
        public static final int BASE = 5;
        public static final int ALTURA = 3;
        public static final int LADO1 = 3;
        public static final int LADO2 = 4;
        public static final int LADO3 = 5;

        public static void mostrarDatos() {
            System.out.println("=== DATOS DE PRUEBA EJERCICIO 8 ===");
            System.out.println("Área rectángulo (base=" + BASE + ", altura=" + ALTURA + "): " + (BASE * ALTURA));
            System.out.println("Perímetro triángulo (" + LADO1 + ", " + LADO2 + ", " + LADO3 + "): " + (LADO1 + LADO2 + LADO3));
        }
    }

    // ========================================
    // EJERCICIO 9: Arrays de Strings
    // ========================================
    public static class Ejercicio9 {
        public static final String[] NOMBRES = {"Ana", "Luis", "María", "Carlos", "Sofía"};

        public static void mostrarDatos() {
            System.out.println("=== DATOS DE PRUEBA EJERCICIO 9 ===");
            System.out.print("Nombres: [");
            for (int i = 0; i < NOMBRES.length; i++) {
                System.out.print("\"" + NOMBRES[i] + "\"");
                if (i < NOMBRES.length - 1) System.out.print(", ");
            }
            System.out.println("]");

            int totalLetras = 0;
            String masLargo = NOMBRES[0];

            for (String nombre : NOMBRES) {
                totalLetras += nombre.length();
                if (nombre.length() > masLargo.length()) {
                    masLargo = nombre;
                }
            }

            System.out.println("\nResultados esperados:");
            System.out.println("Total de nombres: " + NOMBRES.length);
            System.out.println("Total de letras: " + totalLetras);
            System.out.println("Nombre más largo: " + masLargo);
        }
    }

    // ========================================
    // EJERCICIO 10: Clase Persona
    // ========================================
    public static class Ejercicio10 {
        public static class DatosPersona {
            public String nombre;
            public int edad;
            public double altura;
            public boolean mayorDeEdad;

            public DatosPersona(String nombre, int edad, double altura) {
                this.nombre = nombre;
                this.edad = edad;
                this.altura = altura;
                this.mayorDeEdad = edad >= 18;
            }
        }

        public static final DatosPersona[] PERSONAS = {
            new DatosPersona("Ana", 25, 1.65),
            new DatosPersona("Luis", 16, 1.70),
            new DatosPersona("María", 30, 1.60)
        };

        public static void mostrarDatos() {
            System.out.println("=== DATOS DE PRUEBA EJERCICIO 10 ===");
            for (DatosPersona p : PERSONAS) {
                System.out.println("\nPersona: " + p.nombre);
                System.out.println("  Edad: " + p.edad);
                System.out.println("  Altura: " + p.altura);
                System.out.println("  Mayor de edad: " + p.mayorDeEdad);
                System.out.println("  Salida esperada: Hola, soy " + p.nombre + ", tengo " + p.edad + " años y mido " + p.altura + "m");
            }
        }
    }

    // ========================================
    // MAIN - Para ver todos los datos
    // ========================================
    public static void main(String[] args) {
        System.out.println("=== DATOS DE PRUEBA PARA TODOS LOS EJERCICIOS ===\n");

        String[] opciones = {
            "1 - Variables",
            "2 - Operaciones Matemáticas",
            "3 - Intercambiar Variables",
            "4 - Condicionales",
            "6 - Tabla de Multiplicar",
            "7 - Arrays",
            "8 - Métodos",
            "9 - Arrays de Strings",
            "10 - Clase Persona"
        };

        System.out.println("Ejercicios disponibles:");
        for (String opcion : opciones) {
            System.out.println("  " + opcion);
        }

        System.out.println("\nPara ver los datos de un ejercicio específico,");
        System.out.println("llama al método mostrarDatos() de la clase correspondiente.");
        System.out.println("Ejemplo: DatosPrueba.Ejercicio1.mostrarDatos();");
    }
}
