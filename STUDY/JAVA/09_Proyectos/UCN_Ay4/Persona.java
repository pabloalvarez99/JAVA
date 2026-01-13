package Ay4;

import java.util.ArrayList;

/**
 * Clase Persona - Representa una persona de la UCN
 * Una persona puede cumplir más de un rol en forma simultánea.
 */
public class Persona {
    private String rut;
    private String nombre;
    private ArrayList<Contrato> contratos;  // Lista de contratos de esta persona
    
    // Constructor
    public Persona(String rut, String nombre) {
        this.rut = rut;
        this.nombre = nombre;
        this.contratos = new ArrayList<Contrato>();
    }
    
    // Getters
    public String getRut() {
        return rut;
    }
    
    public String getNombre() {
        return nombre;
    }
    
    public ArrayList<Contrato> getContratos() {
        return contratos;
    }
    
    // Setters
    public void setRut(String rut) {
        this.rut = rut;
    }
    
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    /**
     * Agrega un contrato a esta persona
     */
    public void agregarContrato(Contrato contrato) {
        contratos.add(contrato);
    }
    
    /**
     * Retorna los contratos activos en una fecha dada
     */
    public ArrayList<Contrato> getContratosActivosEn(Fecha fecha) {
        ArrayList<Contrato> activos = new ArrayList<Contrato>();
        for (Contrato c : contratos) {
            if (c.estaActivoEn(fecha)) {
                activos.add(c);
            }
        }
        return activos;
    }
    
    /**
     * Retorna la cantidad total de roles que ha tenido la persona
     */
    public int getCantidadRoles() {
        return contratos.size();
    }
    
    /**
     * Retorna la fecha de inicio más antigua (primera fecha de contrato)
     * para calcular antigüedad
     */
    public Fecha getFechaMasAntigua() {
        if (contratos.isEmpty()) {
            return null;
        }
        
        Fecha masAntigua = contratos.get(0).getFechaInicio();
        for (Contrato c : contratos) {
            if (c.getFechaInicio().esAnterior(masAntigua)) {
                masAntigua = c.getFechaInicio();
            }
        }
        return masAntigua;
    }
    
    /**
     * Retorna la historia de roles ordenados por fecha de inicio (menor a mayor)
     */
    public ArrayList<Contrato> getHistoriaRolesOrdenada() {
        ArrayList<Contrato> ordenados = new ArrayList<Contrato>(contratos);
        
        // Ordenar por fecha de inicio (burbuja)
        for (int i = 0; i < ordenados.size() - 1; i++) {
            for (int j = 0; j < ordenados.size() - i - 1; j++) {
                if (ordenados.get(j).getFechaInicio().esPosterior(ordenados.get(j + 1).getFechaInicio())) {
                    // Intercambiar
                    Contrato temp = ordenados.get(j);
                    ordenados.set(j, ordenados.get(j + 1));
                    ordenados.set(j + 1, temp);
                }
            }
        }
        return ordenados;
    }
    
    @Override
    public String toString() {
        return rut + " - " + nombre;
    }
}
