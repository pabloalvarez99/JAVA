/**
 * EJERCICIO DEBUG #4: StringComparisonTrap
 * Dificultad: ⭐⭐
 *
 * DESCRIPCIÓN:
 * El siguiente código de autenticación tiene un bug clásico de Java.
 * El login nunca funciona aunque la contraseña sea correcta.
 *
 * PISTA: ¿Cómo se comparan Strings en Java?
 *
 * SALIDA ESPERADA (con input "secreto123"):
 * Ingrese contraseña: secreto123
 * ¡Acceso concedido!
 *
 * SALIDA ACTUAL:
 * Ingrese contraseña: secreto123
 * Acceso denegado.
 */

import java.util.Scanner;

public class Debug04_StringComparisonTrap {
    public static void main(String[] args) {
        String passwordCorrecta = "secreto123";

        Scanner scanner = new Scanner(System.in);
        System.out.print("Ingrese contraseña: ");
        String passwordIngresada = scanner.nextLine();

        // BUG: == compara referencias, no contenido
        if (passwordIngresada == passwordCorrecta) {
            System.out.println("¡Acceso concedido!");
        } else {
            System.out.println("Acceso denegado.");
        }

        scanner.close();
    }
}

/*
 * ============================================
 * EXPLICACIÓN TÉCNICA:
 * ============================================
 *
 * En Java, == compara REFERENCIAS (direcciones de memoria).
 * .equals() compara CONTENIDO.
 *
 * String a = "hola";
 * String b = "hola";       // Puede ser la misma referencia (string pool)
 * String c = new String("hola");  // Siempre nueva referencia
 *
 * a == b     // Puede ser true (string pool)
 * a == c     // false (diferentes objetos)
 * a.equals(c) // true (mismo contenido)
 *
 * ============================================
 * DESPUÉS DE RESOLVER, REFLEXIONA:
 * ============================================
 *
 * 1. ¿Por qué a veces == funciona con Strings literales?
 *
 * 2. ¿Qué pasa si passwordIngresada es null y usas .equals()?
 *
 * 3. ¿Cómo Objects.equals() resuelve el problema del null?
 *
 * SOLUCIÓN: Ver soluciones/Debug04_Solucion.java
 */
