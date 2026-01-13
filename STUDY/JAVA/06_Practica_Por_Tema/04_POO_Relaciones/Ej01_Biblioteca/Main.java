package Biblioteca;

import java.util.Scanner;

/**
 * Clase Main - COMPLETA EL MENÚ
 */
public class Main {
    private static Biblioteca biblioteca = new Biblioteca();
    private static Scanner scanner = new Scanner(System.in);
    
    public static void main(String[] args) {
        cargarDatosPrueba();
        
        int opcion;
        do {
            mostrarMenu();
            opcion = leerEntero("Opción: ");
            procesarOpcion(opcion);
        } while (opcion != 0);
        
        scanner.close();
    }
    
    private static void mostrarMenu() {
        System.out.println("\n==============================");
        System.out.println("   SISTEMA DE BIBLIOTECA");
        System.out.println("==============================");
        System.out.println("1. Agregar libro");
        System.out.println("2. Agregar socio");
        System.out.println("3. Registrar préstamo");
        System.out.println("------------------------------");
        System.out.println("4. Libros prestados por fecha");
        System.out.println("5. Libros disponibles por fecha");
        System.out.println("6. Historial de socio");
        System.out.println("7. Historial de libro");
        System.out.println("8. Estadísticas");
        System.out.println("------------------------------");
        System.out.println("0. Salir");
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
            case 0: System.out.println("¡Hasta luego!"); break;
            default: System.out.println("Opción inválida");
        }
    }
    
    // TODO: Implementar cada método del menú
    
    private static void agregarLibro() {
        System.out.println("\n--- AGREGAR LIBRO ---");
        // TODO: Leer datos y crear libro
    }
    
    private static void agregarSocio() {
        System.out.println("\n--- AGREGAR SOCIO ---");
        // TODO: Leer datos y crear socio
    }
    
    private static void registrarPrestamo() {
        System.out.println("\n--- REGISTRAR PRÉSTAMO ---");
        // TODO: Buscar socio, buscar libro, leer fechas, registrar
    }
    
    private static void librosPrestados() {
        System.out.println("Ingrese fecha:");
        Fecha fecha = leerFecha();
        biblioteca.reporteLibrosPrestados(fecha);
    }
    
    private static void librosDisponibles() {
        System.out.println("Ingrese fecha:");
        Fecha fecha = leerFecha();
        biblioteca.reporteLibrosDisponibles(fecha);
    }
    
    private static void historialSocio() {
        String rut = leerTexto("RUT del socio: ");
        biblioteca.reporteHistorialSocio(rut);
    }
    
    private static void historialLibro() {
        String isbn = leerTexto("ISBN del libro: ");
        biblioteca.reporteHistorialLibro(isbn);
    }
    
    // ============ MÉTODOS AUXILIARES ============
    
    private static String leerTexto(String msg) {
        System.out.print(msg);
        return scanner.nextLine();
    }
    
    private static int leerEntero(String msg) {
        System.out.print(msg);
        while (!scanner.hasNextInt()) {
            System.out.print("Número inválido. " + msg);
            scanner.next();
        }
        int valor = scanner.nextInt();
        scanner.nextLine();
        return valor;
    }
    
    private static Fecha leerFecha() {
        int anio = leerEntero("  Año: ");
        int mes = leerEntero("  Mes: ");
        int dia = leerEntero("  Día: ");
        return new Fecha(anio, mes, dia);
    }
    
    // ============ DATOS DE PRUEBA ============
    
    private static void cargarDatosPrueba() {
        // TODO: Agregar datos de prueba
        // Ejemplo:
        // Libro l1 = new Libro("978-1234", "Don Quijote", "Cervantes");
        // biblioteca.agregarLibro(l1);
        // ...
        
        System.out.println("Datos de prueba cargados.");
    }
}
