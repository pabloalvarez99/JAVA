/**
 * EJERCICIO DEBUG #5: ExceptionSwallower
 * Dificultad: ⭐⭐⭐
 *
 * DESCRIPCIÓN:
 * El siguiente código "funciona" pero tiene un bug grave:
 * silenciosamente ignora errores. El archivo nunca se lee.
 *
 * PISTA: Nunca dejes un catch block vacío.
 *
 * SALIDA ESPERADA:
 * Leyendo archivo...
 * Error: archivo.txt (El sistema no puede encontrar el archivo)
 * O bien el contenido del archivo si existe.
 *
 * SALIDA ACTUAL:
 * Leyendo archivo...
 * Lectura completada.
 * Contenido: null
 */

import java.io.*;

public class Debug05_ExceptionSwallower {
    public static void main(String[] args) {
        String contenido = leerArchivo("archivo.txt");
        System.out.println("Lectura completada.");
        System.out.println("Contenido: " + contenido);
    }

    public static String leerArchivo(String nombreArchivo) {
        System.out.println("Leyendo archivo...");
        String resultado = null;

        try {
            BufferedReader reader = new BufferedReader(
                new FileReader(nombreArchivo)
            );
            resultado = reader.readLine();
            reader.close();
        } catch (IOException e) {
            // BUG: Exception "tragada" - no se reporta el error
            // El código continúa como si nada pasara
        }

        return resultado;
    }
}

/*
 * ============================================
 * MALAS PRÁCTICAS A EVITAR:
 * ============================================
 *
 * 1. catch (Exception e) { }  // Vacío - NUNCA
 *
 * 2. catch (Exception e) {
 *        e.printStackTrace();  // Mejor, pero no ideal
 *    }
 *
 * 3. MEJOR:
 *    catch (IOException e) {
 *        System.err.println("Error leyendo archivo: " + e.getMessage());
 *        // O lanzar una RuntimeException
 *        // O retornar un valor por defecto documentado
 *    }
 *
 * ============================================
 * DESPUÉS DE RESOLVER, REFLEXIONA:
 * ============================================
 *
 * 1. ¿Por qué es peligroso ignorar excepciones?
 *
 * 2. ¿Cuándo podría ser aceptable un catch vacío? (muy raro)
 *
 * 3. ¿Qué es "fail fast" y por qué es bueno?
 *
 * SOLUCIÓN: Ver soluciones/Debug05_Solucion.java
 */
