/*
 * ========================================
 * EJERCICIO 9: Array de Strings + Métodos
 * DIFICULTAD: ⭐⭐⭐ (Medio)
 * ========================================
 *
 * OBJETIVO:
 * Combinar arrays, Strings y métodos
 *
 * INSTRUCCIONES:
 * 1. Crea un array de String con 5 nombres: {"Ana", "Luis", "María", "Carlos", "Elena"}
 * 2. Crea un método "imprimirNombres" que reciba el array e imprima todos los nombres
 * 3. Crea un método "contarLetras" que reciba un String y retorne la cantidad de letras
 * 4. Crea un método "nombreMasLargo" que reciba el array y retorne el nombre más largo
 *
 * SALIDA ESPERADA:
 * Lista de nombres:
 * 1. Ana
 * 2. Luis
 * 3. María
 * 4. Carlos
 * 5. Elena
 *
 * El nombre "María" tiene 5 letras
 * El nombre más largo es: Carlos (6 letras)
 *
 */

public class Ejercicio9 {
    // TODO: Crea el método imprimirNombres
    public static void imprimirNombres(String[] nombres) {
        System.out.println("Lista de nombres:");
        for (int i = 0; i < nombres.length; i++) {
            System.out.println((i+1) + ". " + nombres[i]);
        }
    }

    // TODO: Crea el método contarLetras
    public static int contarLetras(String nombre) {
        return nombre.length();
    }


    // TODO: Crea el método nombreMasLargo
    public static String nombreMasLargo(String[] nombres) {
        String masLargo = nombres[0];
        // Completa aquí
        for (int i = 0; i < nombres.length;i++) {
            int cantLetras = contarLetras(nombres[i]);
            if (cantLetras > contarLetras(masLargo)) {
                masLargo = nombres[i];
            }
        }
        return masLargo;
    }

    public static void main(String[] args) {
        // TODO: Crea el array de nombres
        String[] nombres = {"Ana", "Luis", "María", "Carlos", "Elena"};

        // TODO: Llama a imprimirNombres
        imprimirNombres(nombres);

        // TODO: Llama a contarLetras para "María"
        contarLetras("Maria");

        System.out.println("El nombre \"Maria\" tiene " + contarLetras("Maria") + " letras");

        // TODO: Llama a nombreMasLargo

        System.out.println("El nombre mas largo es: " + nombreMasLargo(nombres) + " (" + nombreMasLargo(nombres).length() + " letras)");


    }
}
