package Biblioteca;

import java.util.Scanner;

/**
 * Clase Main - Programa principal con menú interactivo
 */
public class Main {
    private static Biblioteca biblioteca = new Biblioteca();
    private static Scanner scanner = new Scanner(System.in);
    
    public static void main(String[] args) {
        cargarDatosPrueba();
        
        int opcion;
        do {
            mostrarMenu();
            opcion = leerEntero("Seleccione una opción: ");
            procesarOpcion(opcion);
        } while (opcion != 0);
        
        System.out.println("¡Hasta luego!");
        scanner.close();
    }
    
    private static void mostrarMenu() {
        System.out.println("\n╔════════════════════════════════════════╗");
        System.out.println("║       SISTEMA DE BIBLIOTECA            ║");
        System.out.println("╠════════════════════════════════════════╣");
        System.out.println("║  1. Agregar libro                      ║");
        System.out.println("║  2. Agregar socio                      ║");
        System.out.println("║  3. Registrar préstamo                 ║");
        System.out.println("╠════════════════════════════════════════╣");
        System.out.println("║         REPORTABILIDAD                 ║");
        System.out.println("╠════════════════════════════════════════╣");
        System.out.println("║  4. Libros prestados por fecha         ║");
        System.out.println("║  5. Libros disponibles por fecha       ║");
        System.out.println("║  6. Historial de un socio              ║");
        System.out.println("║  7. Historial de un libro              ║");
        System.out.println("║  8. Estadísticas generales             ║");
        System.out.println("╠════════════════════════════════════════╣");
        System.out.println("║  9. Listar libros                      ║");
        System.out.println("║ 10. Listar socios                      ║");
        System.out.println("║  0. Salir                              ║");
        System.out.println("╚════════════════════════════════════════╝");
    }
    
    private static void procesarOpcion(int opcion) {
        switch (opcion) {
            case 1: agregarLibro(); break;
            case 2: agregarSocio(); break;
            case 3: registrarPrestamo(); break;
            case 4: librosPrestados(); break;
            case 5: librosDisponibles(); break;
            case 6: historialSocio(); break;
            case 7: historialLibro(); break;
            case 8: biblioteca.reporteEstadisticas(); break;
            case 9: listarLibros(); break;
            case 10: listarSocios(); break;
            case 0: break;
            default: System.out.println("Opción no válida.");
        }
    }
    
    // ==================== OPCIONES DEL MENÚ ====================
    
    private static void agregarLibro() {
        System.out.println("\n--- AGREGAR LIBRO ---");
        String isbn = leerTexto("ISBN: ");
        String titulo = leerTexto("Título: ");
        String autor = leerTexto("Autor: ");
        
        Libro libro = new Libro(isbn, titulo, autor);
        biblioteca.agregarLibro(libro);
        System.out.println("✓ Libro agregado exitosamente.");
    }
    
    private static void agregarSocio() {
        System.out.println("\n--- AGREGAR SOCIO ---");
        String rut = leerTexto("RUT: ");
        String nombre = leerTexto("Nombre: ");
        
        Socio socio = new Socio(rut, nombre);
        biblioteca.agregarSocio(socio);
        System.out.println("✓ Socio agregado exitosamente.");
    }
    
    private static void registrarPrestamo() {
        System.out.println("\n--- REGISTRAR PRÉSTAMO ---");
        
        // Buscar socio
        String rut = leerTexto("RUT del socio: ");
        Socio socio = biblioteca.buscarSocioPorRut(rut);
        if (socio == null) {
            System.out.println("✗ No se encontró socio con ese RUT.");
            return;
        }
        System.out.println("  Socio: " + socio.getNombre());
        
        // Buscar libro
        String isbn = leerTexto("ISBN del libro: ");
        Libro libro = biblioteca.buscarLibroPorIsbn(isbn);
        if (libro == null) {
            System.out.println("✗ No se encontró libro con ese ISBN.");
            return;
        }
        System.out.println("  Libro: " + libro.getTitulo());
        
        // Leer fechas
        System.out.println("Fecha de préstamo:");
        Fecha fechaInicio = leerFecha();
        
        System.out.println("Fecha de devolución esperada:");
        Fecha fechaDevolucion = leerFecha();
        
        // Registrar
        if (biblioteca.registrarPrestamo(socio, libro, fechaInicio, fechaDevolucion)) {
            System.out.println("✓ Préstamo registrado exitosamente.");
        }
    }
    
    private static void librosPrestados() {
        System.out.println("\n--- LIBROS PRESTADOS POR FECHA ---");
        System.out.println("Ingrese la fecha:");
        Fecha fecha = leerFecha();
        biblioteca.reporteLibrosPrestados(fecha);
    }
    
    private static void librosDisponibles() {
        System.out.println("\n--- LIBROS DISPONIBLES POR FECHA ---");
        System.out.println("Ingrese la fecha:");
        Fecha fecha = leerFecha();
        biblioteca.reporteLibrosDisponibles(fecha);
    }
    
    private static void historialSocio() {
        System.out.println("\n--- HISTORIAL DE SOCIO ---");
        String rut = leerTexto("RUT del socio: ");
        biblioteca.reporteHistorialSocio(rut);
    }
    
    private static void historialLibro() {
        System.out.println("\n--- HISTORIAL DE LIBRO ---");
        String isbn = leerTexto("ISBN del libro: ");
        biblioteca.reporteHistorialLibro(isbn);
    }
    
    private static void listarLibros() {
        System.out.println("\n=== LIBROS REGISTRADOS ===");
        for (Libro l : biblioteca.getLibros()) {
            System.out.println("- " + l);
        }
    }
    
    private static void listarSocios() {
        System.out.println("\n=== SOCIOS REGISTRADOS ===");
        for (Socio s : biblioteca.getSocios()) {
            System.out.println("- " + s);
        }
    }
    
    // ==================== MÉTODOS AUXILIARES ====================
    
    private static String leerTexto(String mensaje) {
        System.out.print(mensaje);
        return scanner.nextLine();
    }
    
    private static int leerEntero(String mensaje) {
        System.out.print(mensaje);
        while (!scanner.hasNextInt()) {
            System.out.print("Ingrese un número válido: ");
            scanner.next();
        }
        int valor = scanner.nextInt();
        scanner.nextLine(); // Limpiar buffer
        return valor;
    }
    
    private static Fecha leerFecha() {
        int anio = leerEntero("  Año: ");
        int mes = leerEntero("  Mes: ");
        int dia = leerEntero("  Día: ");
        return new Fecha(anio, mes, dia);
    }
    
    // ==================== DATOS DE PRUEBA ====================
    
    private static void cargarDatosPrueba() {
        System.out.println("Cargando datos de prueba...");
        
        // Crear libros
        Libro l1 = new Libro("978-0-13-468599-1", "Clean Code", "Robert C. Martin");
        Libro l2 = new Libro("978-0-201-63361-0", "Design Patterns", "Gang of Four");
        Libro l3 = new Libro("978-0-596-51774-8", "JavaScript: The Good Parts", "Douglas Crockford");
        Libro l4 = new Libro("978-0-13-235088-4", "The Pragmatic Programmer", "David Thomas");
        Libro l5 = new Libro("978-0-06-112008-4", "Cien años de soledad", "Gabriel García Márquez");
        
        biblioteca.agregarLibro(l1);
        biblioteca.agregarLibro(l2);
        biblioteca.agregarLibro(l3);
        biblioteca.agregarLibro(l4);
        biblioteca.agregarLibro(l5);
        
        // Crear socios
        Socio s1 = new Socio("12345678-9", "Juan Pérez");
        Socio s2 = new Socio("98765432-1", "María González");
        Socio s3 = new Socio("11111111-1", "Carlos López");
        Socio s4 = new Socio("22222222-2", "Ana Martínez");
        
        biblioteca.agregarSocio(s1);
        biblioteca.agregarSocio(s2);
        biblioteca.agregarSocio(s3);
        biblioteca.agregarSocio(s4);
        
        // Crear préstamos
        // Juan pidió Clean Code (activo)
        biblioteca.registrarPrestamo(s1, l1, 
            new Fecha(2026, 1, 5), new Fecha(2026, 1, 20));
        
        // Juan también pidió Design Patterns antes
        biblioteca.registrarPrestamo(s1, l2, 
            new Fecha(2025, 11, 1), new Fecha(2025, 11, 15));
        
        // María pidió JavaScript (activo)
        biblioteca.registrarPrestamo(s2, l3, 
            new Fecha(2026, 1, 10), new Fecha(2026, 1, 25));
        
        // María pidió Cien años antes
        biblioteca.registrarPrestamo(s2, l5, 
            new Fecha(2025, 12, 1), new Fecha(2025, 12, 20));
        
        // Carlos pidió Pragmatic Programmer (activo)
        biblioteca.registrarPrestamo(s3, l4, 
            new Fecha(2026, 1, 8), new Fecha(2026, 1, 22));
        
        // Carlos también tiene Design Patterns ahora
        biblioteca.registrarPrestamo(s3, l2, 
            new Fecha(2026, 1, 12), new Fecha(2026, 1, 26));
        
        // Clean Code fue prestado antes a Ana
        biblioteca.registrarPrestamo(s4, l1, 
            new Fecha(2025, 10, 1), new Fecha(2025, 10, 15));
        
        System.out.println("✓ Datos de prueba cargados.");
        System.out.println("  - " + biblioteca.getLibros().size() + " libros");
        System.out.println("  - " + biblioteca.getSocios().size() + " socios");
        System.out.println("  - " + biblioteca.getPrestamos().size() + " préstamos");
    }
}
