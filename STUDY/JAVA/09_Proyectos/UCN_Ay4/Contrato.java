package Ay4;

/**
 * Clase Contrato - Vincula una Persona con una Unidad
 * Representa el rol que una persona cumple en una unidad de la UCN,
 * con fecha de inicio y fecha de término.
 */
public class Contrato {
    private Persona persona;      // La persona que tiene el contrato
    private Unidad unidad;        // La unidad donde trabaja/estudia
    private String rol;           // El rol que cumple (funcionario, profesor, estudiante)
    private Fecha fechaInicio;    // Cuándo comenzó
    private Fecha fechaTermino;   // Cuándo termina
    
    // Constructor completo
    public Contrato(Persona persona, Unidad unidad, String rol, 
                    Fecha fechaInicio, Fecha fechaTermino) {
        this.persona = persona;
        this.unidad = unidad;
        this.rol = rol;
        this.fechaInicio = fechaInicio;
        this.fechaTermino = fechaTermino;
    }
    
    // Getters
    public Persona getPersona() {
        return persona;
    }
    
    public Unidad getUnidad() {
        return unidad;
    }
    
    public String getRol() {
        return rol;
    }
    
    public Fecha getFechaInicio() {
        return fechaInicio;
    }
    
    public Fecha getFechaTermino() {
        return fechaTermino;
    }
    
    // Setters
    public void setPersona(Persona persona) {
        this.persona = persona;
    }
    
    public void setUnidad(Unidad unidad) {
        this.unidad = unidad;
    }
    
    public void setRol(String rol) {
        this.rol = rol;
    }
    
    public void setFechaInicio(Fecha fechaInicio) {
        this.fechaInicio = fechaInicio;
    }
    
    public void setFechaTermino(Fecha fechaTermino) {
        this.fechaTermino = fechaTermino;
    }
    
    /**
     * Verifica si el contrato está activo en una fecha dada
     * @param fecha La fecha a verificar
     * @return true si la fecha está entre fechaInicio y fechaTermino
     */
    public boolean estaActivoEn(Fecha fecha) {
        return fecha.estaEntre(fechaInicio, fechaTermino);
    }
    
    @Override
    public String toString() {
        return persona.getNombre() + " - " + rol + " en " + unidad.getNombre() + 
               " (" + fechaInicio + " al " + fechaTermino + ")";
    }
}
