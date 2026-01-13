package Ay4;

import java.util.ArrayList;

/**
 * Clase Unidad - Representa una unidad de la UCN
 * Puede ser una carrera, departamento, escuela, etc.
 * Ejemplos: "Servicio de Obras", "Escuela de Ingeniería", "Ingeniería Civil Informática"
 */
public class Unidad {
    private String nombre;
    private ArrayList<Contrato> contratos;  // Lista de contratos asociados a esta unidad
    
    // Constructor
    public Unidad(String nombre) {
        this.nombre = nombre;
        this.contratos = new ArrayList<Contrato>();
    }
    
    // Getters
    public String getNombre() {
        return nombre;
    }
    
    public ArrayList<Contrato> getContratos() {
        return contratos;
    }
    
    // Setters
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    /**
     * Agrega un contrato a esta unidad
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
     * Retorna la cantidad de personas en esta unidad en una fecha dada
     */
    public int getCantidadPersonasEn(Fecha fecha) {
        return getContratosActivosEn(fecha).size();
    }
    
    /**
     * Retorna el historial de roles de esta unidad
     * (todos los contratos que han existido, con la persona que los cumplió)
     */
    public ArrayList<Contrato> getHistorialRoles() {
        return contratos;
    }
    
    /**
     * Retorna el historial de roles ordenado por fecha de inicio
     */
    public ArrayList<Contrato> getHistorialRolesOrdenado() {
        ArrayList<Contrato> ordenados = new ArrayList<Contrato>(contratos);
        
        // Ordenar por fecha de inicio (burbuja)
        for (int i = 0; i < ordenados.size() - 1; i++) {
            for (int j = 0; j < ordenados.size() - i - 1; j++) {
                if (ordenados.get(j).getFechaInicio().esPosterior(ordenados.get(j + 1).getFechaInicio())) {
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
        return nombre;
    }
}
