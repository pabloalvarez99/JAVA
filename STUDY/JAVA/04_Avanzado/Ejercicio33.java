/*
 * ========================================
 * EJERCICIO 33: File I/O y Serialización - Lectura/Escritura de Archivos
 * DIFICULTAD: ⭐⭐⭐⭐⭐⭐⭐⭐⭐⭐ (Experto)
 * ========================================
 *
 * OBJETIVO:
 * Dominar la lectura y escritura de archivos en Java, incluyendo texto plano,
 * serialización de objetos y manejo robusto de excepciones
 *
 * CONCEPTO CLAVE:
 * File I/O (Input/Output) permite que los programas Java interactúen con
 * el sistema de archivos para:
 * - LEER datos desde archivos (persistencia → memoria)
 * - ESCRIBIR datos a archivos (memoria → persistencia)
 * - SERIALIZAR objetos (convertir objeto → bytes)
 * - DESERIALIZAR objetos (convertir bytes → objeto)
 *
 * ========================================
 * CLASES PRINCIPALES PARA FILE I/O
 * ========================================
 *
 * 1. TEXTO PLANO:
 *    - FileWriter / FileReader: Escritura/lectura de caracteres
 *    - BufferedWriter / BufferedReader: Con buffer (más eficiente)
 *    - PrintWriter: Escritura formateada (como System.out)
 *
 * 2. BYTES:
 *    - FileInputStream / FileOutputStream: Lectura/escritura de bytes
 *    - BufferedInputStream / BufferedOutputStream: Con buffer
 *
 * 3. SERIALIZACIÓN:
 *    - ObjectOutputStream: Escribir objetos
 *    - ObjectInputStream: Leer objetos
 *    - Serializable: Interface que debe implementar la clase
 *
 * ========================================
 * ESCRIBIR ARCHIVO DE TEXTO
 * ========================================
 *
 * MÉTODO 1: FileWriter (simple)
 * try (FileWriter writer = new FileWriter("archivo.txt")) {
 *     writer.write("Hola Mundo\n");
 * } catch (IOException e) {
 *     e.printStackTrace();
 * }
 *
 * MÉTODO 2: BufferedWriter (eficiente)
 * try (BufferedWriter writer = new BufferedWriter(new FileWriter("archivo.txt"))) {
 *     writer.write("Línea 1");
 *     writer.newLine();
 *     writer.write("Línea 2");
 * } catch (IOException e) {
 *     e.printStackTrace();
 * }
 *
 * MÉTODO 3: PrintWriter (conveniente)
 * try (PrintWriter writer = new PrintWriter("archivo.txt")) {
 *     writer.println("Línea 1");
 *     writer.printf("Número: %d\n", 42);
 * } catch (IOException e) {
 *     e.printStackTrace();
 * }
 *
 * ========================================
 * LEER ARCHIVO DE TEXTO
 * ========================================
 *
 * MÉTODO 1: BufferedReader (línea por línea)
 * try (BufferedReader reader = new BufferedReader(new FileReader("archivo.txt"))) {
 *     String linea;
 *     while ((linea = reader.readLine()) != null) {
 *         System.out.println(linea);
 *     }
 * } catch (IOException e) {
 *     e.printStackTrace();
 * }
 *
 * MÉTODO 2: Scanner (más fácil)
 * try (Scanner scanner = new Scanner(new File("archivo.txt"))) {
 *     while (scanner.hasNextLine()) {
 *         System.out.println(scanner.nextLine());
 *     }
 * } catch (IOException e) {
 *     e.printStackTrace();
 * }
 *
 * ========================================
 * SERIALIZACIÓN DE OBJETOS
 * ========================================
 *
 * PROPÓSITO:
 * Convertir un objeto Java a bytes para guardarlo en archivo o enviarlo por red.
 *
 * REQUISITO:
 * La clase debe implementar Serializable (interface marcador, sin métodos)
 *
 * EJEMPLO:
 * class Persona implements Serializable {
 *     private static final long serialVersionUID = 1L;
 *     String nombre;
 *     int edad;
 * }
 *
 * ESCRIBIR OBJETO:
 * try (ObjectOutputStream oos = new ObjectOutputStream(
 *         new FileOutputStream("persona.dat"))) {
 *     Persona p = new Persona("Juan", 25);
 *     oos.writeObject(p);
 * }
 *
 * LEER OBJETO:
 * try (ObjectInputStream ois = new ObjectInputStream(
 *         new FileInputStream("persona.dat"))) {
 *     Persona p = (Persona) ois.readObject();
 * }
 *
 * ========================================
 * TRY-WITH-RESOURCES
 * ========================================
 *
 * Java 7+ permite cerrar recursos automáticamente:
 *
 * SIN try-with-resources (antiguo):
 * BufferedReader reader = null;
 * try {
 *     reader = new BufferedReader(new FileReader("file.txt"));
 *     // usar reader
 * } catch (IOException e) {
 *     e.printStackTrace();
 * } finally {
 *     if (reader != null) {
 *         reader.close(); // ¡Puede lanzar IOException!
 *     }
 * }
 *
 * CON try-with-resources (moderno):
 * try (BufferedReader reader = new BufferedReader(new FileReader("file.txt"))) {
 *     // usar reader
 * } catch (IOException e) {
 *     e.printStackTrace();
 * } // reader.close() se llama automáticamente
 *
 * ========================================
 * MANEJO DE RUTAS
 * ========================================
 *
 * RUTAS RELATIVAS vs ABSOLUTAS:
 *
 * Relativa: "datos.txt" → en directorio actual
 * Absoluta: "C:/Users/Usuario/datos.txt" → ruta completa
 *
 * SEPARADORES:
 * Windows: \ (pero usa \\ en strings, o mejor File.separator)
 * Unix/Mac: /
 *
 * MULTIPLATAFORMA:
 * String ruta = "carpeta" + File.separator + "archivo.txt";
 *
 * INSTRUCCIONES:
 * 1. Implementa clase Estudiante serializable con: nombre, edad, promedio, carrera
 * 2. Crea métodos para:
 *    - Escribir texto plano a archivo
 *    - Leer texto plano desde archivo
 *    - Serializar lista de estudiantes
 *    - Deserializar lista de estudiantes
 *    - Agregar datos a archivo existente (append)
 * 3. Maneja excepciones apropiadamente
 * 4. Demuestra todas las operaciones
 *
 * SALIDA ESPERADA:
 * === FILE I/O Y SERIALIZACIÓN ===
 *
 * === ESCRITURA DE ARCHIVO DE TEXTO ===
 * Escribiendo datos a 'estudiantes.txt'...
 * ✓ Archivo escrito exitosamente
 *
 * === LECTURA DE ARCHIVO DE TEXTO ===
 * Contenido de 'estudiantes.txt':
 * =====================================
 * LISTA DE ESTUDIANTES
 * =====================================
 * 1. Ana García - 20 años - Promedio: 9.5
 * 2. Juan López - 22 años - Promedio: 8.8
 * 3. María Pérez - 21 años - Promedio: 9.2
 * =====================================
 *
 * === SERIALIZACIÓN DE OBJETOS ===
 * Creando lista de estudiantes...
 * Serializando a 'estudiantes.dat'...
 * ✓ 3 estudiantes serializados exitosamente
 *
 * === DESERIALIZACIÓN DE OBJETOS ===
 * Deserializando desde 'estudiantes.dat'...
 * ✓ Objetos recuperados exitosamente
 *
 * Estudiantes deserializados:
 * 1. Estudiante{nombre='Ana García', edad=20, promedio=9.5, carrera='Ingeniería'}
 * 2. Estudiante{nombre='Juan López', edad=22, promedio=8.8, carrera='Medicina'}
 * 3. Estudiante{nombre='María Pérez', edad=21, promedio=9.2, carrera='Derecho'}
 *
 * === AGREGAR A ARCHIVO EXISTENTE ===
 * Agregando nuevo estudiante al archivo...
 * ✓ Datos agregados exitosamente
 *
 * Contenido actualizado:
 * [... contenido anterior ...]
 * 4. Carlos Ruiz - 23 años - Promedio: 8.5
 *
 * === MANEJO DE ERRORES ===
 * Intentando leer archivo inexistente...
 * ✗ Error: archivo_inexistente.txt (No such file or directory)
 *
 * CONCEPTOS NUEVOS:
 * - File I/O: Entrada/salida de archivos
 * - FileWriter/FileReader: Escritura/lectura de caracteres
 * - BufferedWriter/BufferedReader: I/O con buffer
 * - PrintWriter: Escritura formateada
 * - Serializable: Interface para serialización
 * - ObjectOutputStream/ObjectInputStream: Serialización de objetos
 * - try-with-resources: Cierre automático de recursos
 * - serialVersionUID: Control de versiones de serialización
 * - Append mode: Agregar a archivo existente
 *
 * VENTAJAS DE FILE I/O:
 * ✓ Persistencia de datos entre ejecuciones
 * ✓ Compartir datos entre aplicaciones
 * ✓ Guardar configuraciones
 * ✓ Logs y auditoría
 * ✓ Backup de datos
 *
 * SERIALIZACIÓN - VENTAJAS:
 * ✓ Guardar objetos completos (estado completo)
 * ✓ Fácil de implementar (implements Serializable)
 * ✓ Maneja referencias entre objetos
 * ✓ Usado en caching, sesiones, RMI
 *
 * SERIALIZACIÓN - DESVENTAJAS:
 * ✗ Específico de Java (no portable a otros lenguajes)
 * ✗ Problemas de versiones (serialVersionUID)
 * ✗ No human-readable (binario)
 * ✗ Alternativas modernas: JSON, XML, Protobuf
 *
 * MEJORES PRÁCTICAS:
 * ✓ Siempre usa try-with-resources
 * ✓ Maneja FileNotFoundException e IOException
 * ✓ Cierra recursos (automático con try-with-resources)
 * ✓ Usa BufferedReader/Writer para eficiencia
 * ✓ Define serialVersionUID en clases Serializable
 * ✓ Marca campos sensibles como transient
 *
 */

import java.io.*;
import java.util.*;

// ========================================
// CLASE ESTUDIANTE (SERIALIZABLE)
// ========================================

// TODO: Implementa Estudiante serializable
class EstudianteArchivo implements Serializable {
    // serialVersionUID para control de versiones
    private static final long serialVersionUID = 1L;

    private String nombre;
    private int edad;
    private double promedio;
    private String carrera;

    public EstudianteArchivo(String nombre, int edad, double promedio, String carrera) {
        this.nombre = nombre;
        this.edad = edad;
        this.promedio = promedio;
        this.carrera = carrera;
    }

    // Getters
    public String getNombre() { return nombre; }
    public int getEdad() { return edad; }
    public double getPromedio() { return promedio; }
    public String getCarrera() { return carrera; }

    @Override
    public String toString() {
        return String.format("EstudianteArchivo{nombre='%s', edad=%d, promedio=%.1f, carrera='%s'}",
            nombre, edad, promedio, carrera);
    }

    public String toTextoPlano() {
        return String.format("%s - %d años - Promedio: %.1f - %s",
            nombre, edad, promedio, carrera);
    }
}

// ========================================
// CLASE GESTORA DE ARCHIVOS
// ========================================

class GestorArchivos {

    // ========================================
    // ESCRITURA DE TEXTO PLANO
    // ========================================

    // TODO: Escribir texto a archivo
    public static void escribirTexto(String nombreArchivo, List<String> lineas) throws IOException {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(nombreArchivo))) {
            for (String linea : lineas) {
                writer.write(linea);
                writer.newLine();
            }
        }
    }

    // TODO: Agregar texto a archivo existente (append)
    public static void agregarTexto(String nombreArchivo, String texto) throws IOException {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(nombreArchivo, true))) {
            writer.write(texto);
            writer.newLine();
        }
    }

    // ========================================
    // LECTURA DE TEXTO PLANO
    // ========================================

    // TODO: Leer todas las líneas de un archivo
    public static List<String> leerTexto(String nombreArchivo) throws IOException {
        List<String> lineas = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(nombreArchivo))) {
            String linea;
            while ((linea = reader.readLine()) != null) {
                lineas.add(linea);
            }
        }

        return lineas;
    }

    // ========================================
    // SERIALIZACIÓN DE OBJETOS
    // ========================================

    // TODO: Serializar lista de objetos
    public static void serializarObjetos(String nombreArchivo, List<EstudianteArchivo> estudiantes)
            throws IOException {
        try (ObjectOutputStream oos = new ObjectOutputStream(
                new FileOutputStream(nombreArchivo))) {
            oos.writeObject(estudiantes);
        }
    }

    // ========================================
    // DESERIALIZACIÓN DE OBJETOS
    // ========================================

    // TODO: Deserializar lista de objetos
    @SuppressWarnings("unchecked")
    public static List<EstudianteArchivo> deserializarObjetos(String nombreArchivo)
            throws IOException, ClassNotFoundException {
        try (ObjectInputStream ois = new ObjectInputStream(
                new FileInputStream(nombreArchivo))) {
            return (List<EstudianteArchivo>) ois.readObject();
        }
    }

    // ========================================
    // UTILIDADES
    // ========================================

    public static boolean archivoExiste(String nombreArchivo) {
        File archivo = new File(nombreArchivo);
        return archivo.exists();
    }

    public static void eliminarArchivo(String nombreArchivo) {
        File archivo = new File(nombreArchivo);
        if (archivo.exists()) {
            archivo.delete();
        }
    }
}

// ========================================
// CLASE PRINCIPAL
// ========================================

public class Ejercicio33 {
    public static void main(String[] args) {
        System.out.println("=== FILE I/O Y SERIALIZACIÓN ===\n");

        // Nombres de archivos
        String archivoTexto = "estudiantes.txt";
        String archivoBinario = "estudiantes.dat";

        // ========================================
        // ESCRITURA DE ARCHIVO DE TEXTO
        // ========================================
        System.out.println("=== ESCRITURA DE ARCHIVO DE TEXTO ===");
        System.out.println("Escribiendo datos a '" + archivoTexto + "'...");

        List<String> lineas = new ArrayList<>();
        lineas.add("=====================================");
        lineas.add("LISTA DE ESTUDIANTES");
        lineas.add("=====================================");
        lineas.add("1. Ana García - 20 años - Promedio: 9.5 - Ingeniería");
        lineas.add("2. Juan López - 22 años - Promedio: 8.8 - Medicina");
        lineas.add("3. María Pérez - 21 años - Promedio: 9.2 - Derecho");
        lineas.add("=====================================");

        try {
            GestorArchivos.escribirTexto(archivoTexto, lineas);
            System.out.println("✓ Archivo escrito exitosamente\n");
        } catch (IOException e) {
            System.out.println("✗ Error al escribir archivo: " + e.getMessage());
        }

        // ========================================
        // LECTURA DE ARCHIVO DE TEXTO
        // ========================================
        System.out.println("=== LECTURA DE ARCHIVO DE TEXTO ===");
        System.out.println("Contenido de '" + archivoTexto + "':");

        try {
            List<String> contenido = GestorArchivos.leerTexto(archivoTexto);
            for (String linea : contenido) {
                System.out.println(linea);
            }
            System.out.println();
        } catch (IOException e) {
            System.out.println("✗ Error al leer archivo: " + e.getMessage());
        }

        // ========================================
        // CREAR LISTA DE ESTUDIANTES
        // ========================================
        List<EstudianteArchivo> estudiantes = new ArrayList<>();
        estudiantes.add(new EstudianteArchivo("Ana García", 20, 9.5, "Ingeniería"));
        estudiantes.add(new EstudianteArchivo("Juan López", 22, 8.8, "Medicina"));
        estudiantes.add(new EstudianteArchivo("María Pérez", 21, 9.2, "Derecho"));

        // ========================================
        // SERIALIZACIÓN DE OBJETOS
        // ========================================
        System.out.println("=== SERIALIZACIÓN DE OBJETOS ===");
        System.out.println("Creando lista de estudiantes...");
        System.out.println("Serializando a '" + archivoBinario + "'...");

        try {
            GestorArchivos.serializarObjetos(archivoBinario, estudiantes);
            System.out.println("✓ " + estudiantes.size() + " estudiantes serializados exitosamente\n");
        } catch (IOException e) {
            System.out.println("✗ Error al serializar: " + e.getMessage());
        }

        // ========================================
        // DESERIALIZACIÓN DE OBJETOS
        // ========================================
        System.out.println("=== DESERIALIZACIÓN DE OBJETOS ===");
        System.out.println("Deserializando desde '" + archivoBinario + "'...");

        try {
            List<EstudianteArchivo> estudiantesRecuperados =
                GestorArchivos.deserializarObjetos(archivoBinario);

            System.out.println("✓ Objetos recuperados exitosamente\n");
            System.out.println("Estudiantes deserializados:");

            int i = 1;
            for (EstudianteArchivo e : estudiantesRecuperados) {
                System.out.println(i++ + ". " + e);
            }
            System.out.println();
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("✗ Error al deserializar: " + e.getMessage());
        }

        // ========================================
        // AGREGAR A ARCHIVO EXISTENTE
        // ========================================
        System.out.println("=== AGREGAR A ARCHIVO EXISTENTE ===");
        System.out.println("Agregando nuevo estudiante al archivo...");

        try {
            GestorArchivos.agregarTexto(archivoTexto,
                "4. Carlos Ruiz - 23 años - Promedio: 8.5 - Arquitectura");
            System.out.println("✓ Datos agregados exitosamente\n");

            System.out.println("Contenido actualizado:");
            List<String> contenidoActualizado = GestorArchivos.leerTexto(archivoTexto);
            for (String linea : contenidoActualizado) {
                System.out.println(linea);
            }
            System.out.println();
        } catch (IOException e) {
            System.out.println("✗ Error: " + e.getMessage());
        }

        // ========================================
        // MANEJO DE ERRORES
        // ========================================
        System.out.println("=== MANEJO DE ERRORES ===");
        System.out.println("Intentando leer archivo inexistente...");

        try {
            GestorArchivos.leerTexto("archivo_inexistente.txt");
        } catch (IOException e) {
            System.out.println("✗ Error: " + e.getMessage());
        }

        System.out.println();

        // ========================================
        // ESCRITURA CON PrintWriter
        // ========================================
        System.out.println("=== ESCRITURA CON PRINTWRITER ===");
        String archivoReporte = "reporte.txt";

        try (PrintWriter writer = new PrintWriter(archivoReporte)) {
            writer.println("REPORTE DE ESTUDIANTES");
            writer.println("======================");
            writer.println();

            for (EstudianteArchivo e : estudiantes) {
                writer.printf("Nombre: %-20s | Edad: %2d | Promedio: %.1f%n",
                    e.getNombre(), e.getEdad(), e.getPromedio());
            }

            writer.println();
            writer.println("Total de estudiantes: " + estudiantes.size());
            writer.println("Promedio general: " + calcularPromedioGeneral(estudiantes));

            System.out.println("✓ Reporte generado en '" + archivoReporte + "'");
        } catch (IOException e) {
            System.out.println("✗ Error al crear reporte: " + e.getMessage());
        }

        System.out.println();

        // ========================================
        // LECTURA CON Scanner
        // ========================================
        System.out.println("=== LECTURA CON SCANNER ===");
        System.out.println("Contenido de '" + archivoReporte + "':");

        try (Scanner scanner = new Scanner(new File(archivoReporte))) {
            while (scanner.hasNextLine()) {
                System.out.println(scanner.nextLine());
            }
        } catch (FileNotFoundException e) {
            System.out.println("✗ Error: " + e.getMessage());
        }

        // ========================================
        // LIMPIEZA (OPCIONAL)
        // ========================================
        System.out.println("\n=== LIMPIEZA DE ARCHIVOS TEMPORALES ===");
        System.out.println("Archivos creados durante la demostración:");
        System.out.println("- " + archivoTexto);
        System.out.println("- " + archivoBinario);
        System.out.println("- " + archivoReporte);
        System.out.println("\n(Los archivos permanecen para inspección)");

        // REFLEXIÓN FINAL:
        // ¿Por qué usar File I/O?
        // ✓ Persistencia: datos sobreviven entre ejecuciones
        // ✓ Compartir datos entre aplicaciones
        // ✓ Configuraciones: guardar preferencias del usuario
        // ✓ Logs: registrar eventos y errores
        // ✓ Backup: copias de seguridad
        //
        // EN LA VIDA REAL:
        // - Aplicaciones de escritorio: guardar configuración
        // - Servidores: logs de acceso, errores
        // - Bases de datos: archivos CSV para import/export
        // - Caching: guardar datos temporalmente
        // - Sesiones web: serializar objetos de sesión
        //
        // FORMATOS DE ARCHIVO:
        //
        // TEXTO PLANO (.txt, .csv, .log):
        // ✓ Human-readable (legible por humanos)
        // ✓ Fácil de editar manualmente
        // ✓ Portable entre sistemas
        // ✗ Más grande que binario
        // ✗ Parsing manual necesario
        //
        // SERIALIZACIÓN JAVA (.dat, .ser):
        // ✓ Guarda objetos completos
        // ✓ Fácil de implementar
        // ✓ Maneja referencias entre objetos
        // ✗ Específico de Java
        // ✗ No human-readable
        // ✗ Problemas de versiones
        //
        // JSON (.json):
        // ✓ Human-readable
        // ✓ Portable (todos los lenguajes)
        // ✓ Estándar web
        // ✗ Requiere librería (Gson, Jackson)
        // ✗ Más grande que binario
        //
        // XML (.xml):
        // ✓ Estándar establecido
        // ✓ Auto-descriptivo
        // ✗ Verboso (mucho texto)
        // ✗ Complejo de parsear
        //
        // ALTERNATIVAS MODERNAS:
        // - JSON: Gson, Jackson, org.json
        // - XML: JAXB, DOM, SAX
        // - Protobuf: Google Protocol Buffers
        // - MessagePack: formato binario compacto
        // - YAML: configuraciones legibles
        //
        // TRANSIENT KEYWORD:
        // Marca campos que NO se deben serializar:
        //
        // class Usuario implements Serializable {
        //     String username;
        //     transient String password; // NO se serializa (seguridad)
        // }
        //
        // SERIALVERSIONUID:
        // Control de versiones de serialización:
        //
        // private static final long serialVersionUID = 1L;
        //
        // Si la clase cambia y el UID no coincide, lanza InvalidClassException
        //
        // BUFFERED vs NO BUFFERED:
        //
        // FileWriter (sin buffer):
        // - Escribe directamente al disco
        // - Más lento (muchas operaciones I/O)
        //
        // BufferedWriter (con buffer):
        // - Escribe a memoria (buffer) primero
        // - Escribe al disco cuando el buffer está lleno
        // - MÁS RÁPIDO (menos operaciones I/O)
        //
        // MEJORES PRÁCTICAS:
        // ✓ Siempre usa try-with-resources
        // ✓ Maneja excepciones específicas
        // ✓ Usa Buffered* para archivos grandes
        // ✓ Valida que el archivo existe antes de leer
        // ✓ Define serialVersionUID en clases Serializable
        // ✓ Usa transient para datos sensibles
        // ✓ Considera JSON en lugar de serialización Java
        //
        // SEGURIDAD:
        // ✗ NUNCA serialices contraseñas sin encriptar
        // ✗ Ten cuidado con deserialización de fuentes no confiables
        // ✓ Usa transient para datos sensibles
        // ✓ Considera encriptación para archivos críticos
        //
        // JAVA NIO (NEW I/O):
        // Java 7+ introduce java.nio.file.Files con APIs más modernas:
        //
        // // Leer todas las líneas
        // List<String> lines = Files.readAllLines(Paths.get("file.txt"));
        //
        // // Escribir todas las líneas
        // Files.write(Paths.get("file.txt"), lines);
        //
        // Más simple, pero menos control que streams tradicionales.
    }

    // Método auxiliar para calcular promedio general
    private static double calcularPromedioGeneral(List<EstudianteArchivo> estudiantes) {
        double suma = 0;
        for (EstudianteArchivo e : estudiantes) {
            suma += e.getPromedio();
        }
        return suma / estudiantes.size();
    }
}
