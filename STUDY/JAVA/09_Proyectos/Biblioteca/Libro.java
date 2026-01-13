package Biblioteca;

import java.util.ArrayList;

/**
 * Clase Libro - Representa un libro de la biblioteca
 */
public class Libro {
    private String isbn;
    private String titulo;
    private String autor;
    private ArrayList<Prestamo> prestamos;
    
    public Libro(String isbn, String titulo, String autor) {
        this.isbn = isbn;
        this.titulo = titulo;
        this.autor = autor;
        this.prestamos = new ArrayList<Prestamo>();
    }
    
    // Getters
    public String getIsbn() { return isbn; }
    public String getTitulo() { return titulo; }
    public String getAutor() { return autor; }
    public ArrayList<Prestamo> getPrestamos() { return prestamos; }
    
    // Setters
    public void setIsbn(String isbn) { this.isbn = isbn; }
    public void setTitulo(String titulo) { this.titulo = titulo; }
    public void setAutor(String autor) { this.autor = autor; }
    
    /**
     * Agrega un préstamo a este libro
     */
    public void agregarPrestamo(Prestamo p) {
        prestamos.add(p);
    }
    
    /**
     * Verifica si el libro está disponible en una fecha dada
     * (no está prestado a nadie en esa fecha)
     */
    public boolean estaDisponibleEn(Fecha fecha) {
        for (Prestamo p : prestamos) {
            if (p.estaActivoEn(fecha)) {
                return false;
            }
        }
        return true;
    }
    
    /**
     * Retorna la cantidad total de veces que ha sido prestado
     */
    public int getCantidadPrestamos() {
        return prestamos.size();
    }
    
    /**
     * Obtiene el préstamo activo en una fecha (si existe)
     */
    public Prestamo getPrestamoActivoEn(Fecha fecha) {
        for (Prestamo p : prestamos) {
            if (p.estaActivoEn(fecha)) {
                return p;
            }
        }
        return null;
    }
    
    @Override
    public String toString() {
        return isbn + " - \"" + titulo + "\" por " + autor;
    }
}
