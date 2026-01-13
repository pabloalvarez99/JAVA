package Biblioteca;

import java.util.ArrayList;

/**
 * Clase Socio - Representa un socio de la biblioteca
 */
public class Socio {
    private String rut;
    private String nombre;
    private ArrayList<Prestamo> prestamos;
    
    public Socio(String rut, String nombre) {
        this.rut = rut;
        this.nombre = nombre;
        this.prestamos = new ArrayList<Prestamo>();
    }
    
    // Getters
    public String getRut() { return rut; }
    public String getNombre() { return nombre; }
    public ArrayList<Prestamo> getPrestamos() { return prestamos; }
    
    // Setters
    public void setRut(String rut) { this.rut = rut; }
    public void setNombre(String nombre) { this.nombre = nombre; }
    
    /**
     * Agrega un préstamo a este socio
     */
    public void agregarPrestamo(Prestamo p) {
        prestamos.add(p);
    }
    
    /**
     * Retorna la cantidad total de préstamos que ha hecho
     */
    public int getCantidadPrestamos() {
        return prestamos.size();
    }
    
    /**
     * Retorna los préstamos ordenados por fecha de inicio (menor a mayor)
     */
    public ArrayList<Prestamo> getHistorialOrdenado() {
        ArrayList<Prestamo> ordenado = new ArrayList<Prestamo>(prestamos);
        
        // Ordenamiento burbuja
        for (int i = 0; i < ordenado.size() - 1; i++) {
            for (int j = 0; j < ordenado.size() - i - 1; j++) {
                if (ordenado.get(j).getFechaInicio().esPosterior(
                    ordenado.get(j + 1).getFechaInicio())) {
                    Prestamo temp = ordenado.get(j);
                    ordenado.set(j, ordenado.get(j + 1));
                    ordenado.set(j + 1, temp);
                }
            }
        }
        return ordenado;
    }
    
    @Override
    public String toString() {
        return rut + " - " + nombre;
    }
}
