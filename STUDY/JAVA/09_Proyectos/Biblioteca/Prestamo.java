package Biblioteca;

/**
 * Clase Prestamo - CLASE DE ASOCIACIÓN
 * Vincula un Socio con un Libro durante un período de tiempo
 */
public class Prestamo {
    private Socio socio;
    private Libro libro;
    private Fecha fechaInicio;
    private Fecha fechaDevolucion;
    
    public Prestamo(Socio socio, Libro libro, Fecha fechaInicio, Fecha fechaDevolucion) {
        this.socio = socio;
        this.libro = libro;
        this.fechaInicio = fechaInicio;
        this.fechaDevolucion = fechaDevolucion;
    }
    
    // Getters
    public Socio getSocio() { return socio; }
    public Libro getLibro() { return libro; }
    public Fecha getFechaInicio() { return fechaInicio; }
    public Fecha getFechaDevolucion() { return fechaDevolucion; }
    
    // Setters
    public void setSocio(Socio socio) { this.socio = socio; }
    public void setLibro(Libro libro) { this.libro = libro; }
    public void setFechaInicio(Fecha fechaInicio) { this.fechaInicio = fechaInicio; }
    public void setFechaDevolucion(Fecha fechaDevolucion) { this.fechaDevolucion = fechaDevolucion; }
    
    /**
     * Verifica si el préstamo está activo en una fecha dada
     * @param fecha La fecha a verificar
     * @return true si la fecha está entre fechaInicio y fechaDevolucion
     */
    public boolean estaActivoEn(Fecha fecha) {
        return fecha.estaEntre(fechaInicio, fechaDevolucion);
    }
    
    @Override
    public String toString() {
        return "\"" + libro.getTitulo() + "\" prestado a " + socio.getNombre() + 
               " (" + fechaInicio + " - " + fechaDevolucion + ")";
    }
}
