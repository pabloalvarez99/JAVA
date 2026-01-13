package Biblioteca;

import java.util.ArrayList;

/**
 * Clase Biblioteca - CLASE GESTORA - COMPLETA ESTA CLASE
 * 
 * Administra todos los libros, socios y préstamos
 */
public class Biblioteca {
    private ArrayList<Libro> libros;
    private ArrayList<Socio> socios;
    private ArrayList<Prestamo> prestamos;
    
    public Biblioteca() {
        this.libros = new ArrayList<Libro>();
        this.socios = new ArrayList<Socio>();
        this.prestamos = new ArrayList<Prestamo>();
    }
    
    // ============ MÉTODOS DE AGREGAR ============
    
    public void agregarLibro(Libro libro) {
        libros.add(libro);
    }
    
    public void agregarSocio(Socio socio) {
        socios.add(socio);
    }
    
    /**
     * TODO: Registrar préstamo
     * Debe crear el préstamo y agregarlo a:
     * - La lista de préstamos del socio
     * - La lista de préstamos del libro
     * - La lista general de préstamos
     */
    public void registrarPrestamo(Socio socio, Libro libro, Fecha fechaInicio, Fecha fechaDevolucion) {
        // TODO: Implementar
    }
    
    // ============ MÉTODOS DE BÚSQUEDA ============
    
    public Libro buscarLibroPorIsbn(String isbn) {
        // TODO: Implementar
        return null;
    }
    
    public Socio buscarSocioPorRut(String rut) {
        // TODO: Implementar
        return null;
    }
    
    // ============ REPORTABILIDAD ============
    
    /**
     * i. Dada una fecha, mostrar todos los libros prestados
     */
    public void reporteLibrosPrestados(Fecha fecha) {
        System.out.println("\n=== LIBROS PRESTADOS EN " + fecha + " ===");
        // TODO: Implementar
        // Recorrer préstamos, si estaActivoEn(fecha), mostrar libro y socio
    }
    
    /**
     * ii. Dada una fecha, mostrar libros disponibles
     */
    public void reporteLibrosDisponibles(Fecha fecha) {
        System.out.println("\n=== LIBROS DISPONIBLES EN " + fecha + " ===");
        // TODO: Implementar
        // Recorrer libros, si estaDisponibleEn(fecha), mostrarlo
    }
    
    /**
     * iii. Historial de préstamos de un socio
     */
    public void reporteHistorialSocio(String rut) {
        // TODO: Implementar
    }
    
    /**
     * iv. Historial de un libro
     */
    public void reporteHistorialLibro(String isbn) {
        // TODO: Implementar
    }
    
    /**
     * v.1 Socio con más préstamos
     */
    public Socio getSocioConMasPrestamos() {
        // TODO: Implementar
        return null;
    }
    
    /**
     * v.2 Libro más popular
     */
    public Libro getLibroMasPopular() {
        // TODO: Implementar
        return null;
    }
    
    public void reporteEstadisticas() {
        System.out.println("\n=== ESTADÍSTICAS ===");
        // TODO: Implementar usando los métodos anteriores
    }
    
    // ============ GETTERS ============
    
    public ArrayList<Libro> getLibros() { return libros; }
    public ArrayList<Socio> getSocios() { return socios; }
    public ArrayList<Prestamo> getPrestamos() { return prestamos; }
}
