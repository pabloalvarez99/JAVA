package Biblioteca;

import java.util.ArrayList;

/**
 * Clase Biblioteca - CLASE GESTORA
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
    
    // ==================== AGREGAR ====================
    
    public void agregarLibro(Libro libro) {
        libros.add(libro);
    }
    
    public void agregarSocio(Socio socio) {
        socios.add(socio);
    }
    
    /**
     * Registra un préstamo (crea la asociación)
     * IMPORTANTE: Agrega a las 3 listas
     */
    public boolean registrarPrestamo(Socio socio, Libro libro, 
                                     Fecha fechaInicio, Fecha fechaDevolucion) {
        // Verificar que el libro esté disponible
        if (!libro.estaDisponibleEn(fechaInicio)) {
            System.out.println("El libro no está disponible en esa fecha.");
            return false;
        }
        
        // Crear el préstamo
        Prestamo prestamo = new Prestamo(socio, libro, fechaInicio, fechaDevolucion);
        
        // Agregar a las 3 listas
        socio.agregarPrestamo(prestamo);
        libro.agregarPrestamo(prestamo);
        prestamos.add(prestamo);
        
        return true;
    }
    
    // ==================== BUSCAR ====================
    
    public Libro buscarLibroPorIsbn(String isbn) {
        for (Libro l : libros) {
            if (l.getIsbn().equals(isbn)) {
                return l;
            }
        }
        return null;
    }
    
    public Socio buscarSocioPorRut(String rut) {
        for (Socio s : socios) {
            if (s.getRut().equals(rut)) {
                return s;
            }
        }
        return null;
    }
    
    // ==================== REPORTABILIDAD ====================
    
    /**
     * i. Dada una fecha, mostrar todos los libros prestados
     */
    public void reporteLibrosPrestados(Fecha fecha) {
        System.out.println("\n=== LIBROS PRESTADOS EN " + fecha + " ===");
        
        boolean hayPrestados = false;
        for (Prestamo p : prestamos) {
            if (p.estaActivoEn(fecha)) {
                System.out.println("- " + p.getLibro().getTitulo() + 
                                   " → prestado a " + p.getSocio().getNombre());
                hayPrestados = true;
            }
        }
        
        if (!hayPrestados) {
            System.out.println("No hay libros prestados en esa fecha.");
        }
    }
    
    /**
     * ii. Dada una fecha, mostrar libros disponibles
     */
    public void reporteLibrosDisponibles(Fecha fecha) {
        System.out.println("\n=== LIBROS DISPONIBLES EN " + fecha + " ===");
        
        boolean hayDisponibles = false;
        for (Libro l : libros) {
            if (l.estaDisponibleEn(fecha)) {
                System.out.println("- " + l);
                hayDisponibles = true;
            }
        }
        
        if (!hayDisponibles) {
            System.out.println("No hay libros disponibles en esa fecha.");
        }
    }
    
    /**
     * iii. Historial de préstamos de un socio
     */
    public void reporteHistorialSocio(String rut) {
        Socio socio = buscarSocioPorRut(rut);
        
        if (socio == null) {
            System.out.println("No se encontró socio con RUT: " + rut);
            return;
        }
        
        System.out.println("\n=== HISTORIAL DE " + socio.getNombre() + " ===");
        
        ArrayList<Prestamo> historial = socio.getHistorialOrdenado();
        
        if (historial.isEmpty()) {
            System.out.println("No tiene préstamos registrados.");
        } else {
            for (Prestamo p : historial) {
                System.out.println("- " + p.getFechaInicio() + " al " + p.getFechaDevolucion() + 
                                   ": \"" + p.getLibro().getTitulo() + "\"");
            }
            System.out.println("Total de préstamos: " + historial.size());
        }
    }
    
    /**
     * iv. Historial de un libro
     */
    public void reporteHistorialLibro(String isbn) {
        Libro libro = buscarLibroPorIsbn(isbn);
        
        if (libro == null) {
            System.out.println("No se encontró libro con ISBN: " + isbn);
            return;
        }
        
        System.out.println("\n=== HISTORIAL DE \"" + libro.getTitulo() + "\" ===");
        
        ArrayList<Prestamo> historial = libro.getPrestamos();
        
        if (historial.isEmpty()) {
            System.out.println("Este libro nunca ha sido prestado.");
        } else {
            for (Prestamo p : historial) {
                System.out.println("- " + p.getFechaInicio() + " al " + p.getFechaDevolucion() + 
                                   ": " + p.getSocio().getNombre());
            }
            System.out.println("Total de veces prestado: " + historial.size());
        }
    }
    
    /**
     * v.1 Socio con más préstamos
     */
    public Socio getSocioConMasPrestamos() {
        if (socios.isEmpty()) return null;
        
        Socio maximo = socios.get(0);
        for (Socio s : socios) {
            if (s.getCantidadPrestamos() > maximo.getCantidadPrestamos()) {
                maximo = s;
            }
        }
        return maximo;
    }
    
    /**
     * v.2 Libro más popular (más veces prestado)
     */
    public Libro getLibroMasPopular() {
        if (libros.isEmpty()) return null;
        
        Libro maximo = libros.get(0);
        for (Libro l : libros) {
            if (l.getCantidadPrestamos() > maximo.getCantidadPrestamos()) {
                maximo = l;
            }
        }
        return maximo;
    }
    
    /**
     * v. Estadísticas generales
     */
    public void reporteEstadisticas() {
        System.out.println("\n=== ESTADÍSTICAS GENERALES ===");
        
        // Socio con más préstamos
        Socio socioTop = getSocioConMasPrestamos();
        if (socioTop != null && socioTop.getCantidadPrestamos() > 0) {
            System.out.println("1. Socio con más préstamos: " + socioTop.getNombre() + 
                               " (" + socioTop.getCantidadPrestamos() + " préstamos)");
        } else {
            System.out.println("1. No hay socios con préstamos.");
        }
        
        // Libro más popular
        Libro libroTop = getLibroMasPopular();
        if (libroTop != null && libroTop.getCantidadPrestamos() > 0) {
            System.out.println("2. Libro más popular: \"" + libroTop.getTitulo() + 
                               "\" (" + libroTop.getCantidadPrestamos() + " préstamos)");
        } else {
            System.out.println("2. No hay libros prestados.");
        }
        
        // Totales
        System.out.println("\nResumen:");
        System.out.println("- Total de libros: " + libros.size());
        System.out.println("- Total de socios: " + socios.size());
        System.out.println("- Total de préstamos: " + prestamos.size());
    }
    
    // ==================== GETTERS ====================
    
    public ArrayList<Libro> getLibros() { return libros; }
    public ArrayList<Socio> getSocios() { return socios; }
    public ArrayList<Prestamo> getPrestamos() { return prestamos; }
}
