/**
 * EJERCICIO DEBUG #7: ResourceLeakFinder
 * Dificultad: ⭐⭐⭐⭐
 *
 * DESCRIPCIÓN:
 * El código lee múltiples archivos pero tiene un memory leak.
 * Los recursos no se cierran correctamente.
 *
 * PISTA: ¿Qué pasa si ocurre una excepción antes del close()?
 *
 * PROBLEMA:
 * - Si hay error, el archivo queda abierto
 * - Con muchas iteraciones, se agotan los file handles
 * - Error eventual: "Too many open files"
 */

import java.io.*;

public class Debug07_ResourceLeakFinder {
    public static void main(String[] args) {
        String[] archivos = {"archivo1.txt", "archivo2.txt", "archivo3.txt"};

        for (String archivo : archivos) {
            leerArchivo(archivo);
        }
    }

    // BUG: Si readLine() lanza excepción, close() nunca se ejecuta
    public static void leerArchivo(String nombre) {
        try {
            BufferedReader reader = new BufferedReader(new FileReader(nombre));
            String linea = reader.readLine();
            System.out.println(nombre + ": " + linea);
            reader.close();  // ¡Puede no ejecutarse si hay excepción!
        } catch (IOException e) {
            System.out.println("Error leyendo " + nombre);
            // reader nunca se cierra en caso de error
        }
    }
}

/*
 * ============================================
 * SOLUCIÓN: try-with-resources (Java 7+)
 * ============================================
 *
 * public static void leerArchivo(String nombre) {
 *     try (BufferedReader reader = new BufferedReader(new FileReader(nombre))) {
 *         String linea = reader.readLine();
 *         System.out.println(nombre + ": " + linea);
 *     } catch (IOException e) {
 *         System.out.println("Error leyendo " + nombre);
 *     }
 *     // reader se cierra AUTOMÁTICAMENTE, incluso si hay excepción
 * }
 *
 * ============================================
 * DESPUÉS DE RESOLVER, REFLEXIONA:
 * ============================================
 *
 * 1. ¿Qué recursos necesitan cerrarse? (Files, Connections, Streams)
 *
 * 2. ¿Qué interfaz deben implementar para usar try-with-resources?
 *    (AutoCloseable)
 *
 * 3. ¿Por qué finally no es tan bueno como try-with-resources?
 *
 * SOLUCIÓN: Ver soluciones/Debug07_Solucion.java
 */
