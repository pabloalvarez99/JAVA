package Ay4;

import java.util.ArrayList;

/**
 * Clase UCN - Clase gestora principal
 * Administra todas las personas, unidades y contratos de la universidad.
 */
public class UCN {
    private ArrayList<Persona> personas;
    private ArrayList<Unidad> unidades;
    private ArrayList<Contrato> contratos;
    
    // Constructor
    public UCN() {
        this.personas = new ArrayList<Persona>();
        this.unidades = new ArrayList<Unidad>();
        this.contratos = new ArrayList<Contrato>();
    }
    
    // ==================== MÉTODOS DE AGREGAR ====================
    
    /**
     * Agrega una persona a la UCN
     */
    public void agregarPersona(Persona persona) {
        personas.add(persona);
    }
    
    /**
     * Agrega una unidad a la UCN
     */
    public void agregarUnidad(Unidad unidad) {
        unidades.add(unidad);
    }
    
    /**
     * Asocia una persona a una unidad con un rol entre ciertas fechas
     * Crea el contrato y lo agrega a la persona, unidad y lista general
     */
    public void asociarPersonaUnidad(Persona persona, Unidad unidad, String rol,
                                     Fecha fechaInicio, Fecha fechaTermino) {
        Contrato contrato = new Contrato(persona, unidad, rol, fechaInicio, fechaTermino);
        
        // Agregar el contrato a todos los lugares necesarios
        persona.agregarContrato(contrato);
        unidad.agregarContrato(contrato);
        contratos.add(contrato);
    }
    
    // ==================== MÉTODOS DE BÚSQUEDA ====================
    
    /**
     * Busca una persona por RUT
     */
    public Persona buscarPersonaPorRut(String rut) {
        for (Persona p : personas) {
            if (p.getRut().equals(rut)) {
                return p;
            }
        }
        return null;
    }
    
    /**
     * Busca una unidad por nombre
     */
    public Unidad buscarUnidadPorNombre(String nombre) {
        for (Unidad u : unidades) {
            if (u.getNombre().equalsIgnoreCase(nombre)) {
                return u;
            }
        }
        return null;
    }
    
    // ==================== REPORTABILIDAD ====================
    
    /**
     * i. Dada una fecha, indica el rol que está cumpliendo cada persona registrada,
     * indicando la unidad
     */
    public void reporteRolesPorFecha(Fecha fecha) {
        System.out.println("\n=== ROLES ACTIVOS EN " + fecha + " ===");
        
        for (Persona p : personas) {
            ArrayList<Contrato> contratosActivos = p.getContratosActivosEn(fecha);
            
            if (contratosActivos.isEmpty()) {
                System.out.println(p.getNombre() + " (" + p.getRut() + "): Sin roles activos");
            } else {
                System.out.println(p.getNombre() + " (" + p.getRut() + "):");
                for (Contrato c : contratosActivos) {
                    System.out.println("  - " + c.getRol() + " en " + c.getUnidad().getNombre());
                }
            }
        }
    }
    
    /**
     * ii. Dada una fecha, indica la cantidad de personas en cada unidad
     */
    public void reporteCantidadPersonasPorUnidad(Fecha fecha) {
        System.out.println("\n=== CANTIDAD DE PERSONAS POR UNIDAD EN " + fecha + " ===");
        
        for (Unidad u : unidades) {
            int cantidad = u.getCantidadPersonasEn(fecha);
            System.out.println(u.getNombre() + ": " + cantidad + " persona(s)");
        }
    }
    
    /**
     * iii. Dado un RUT, indica la "historia de roles" de la persona,
     * ordenados de menor a mayor por fecha
     */
    public void reporteHistoriaRolesPersona(String rut) {
        Persona persona = buscarPersonaPorRut(rut);
        
        if (persona == null) {
            System.out.println("No se encontró persona con RUT: " + rut);
            return;
        }
        
        System.out.println("\n=== HISTORIA DE ROLES DE " + persona.getNombre() + " ===");
        
        ArrayList<Contrato> historia = persona.getHistoriaRolesOrdenada();
        
        if (historia.isEmpty()) {
            System.out.println("No tiene roles registrados.");
        } else {
            for (Contrato c : historia) {
                System.out.println("- " + c.getRol() + " en " + c.getUnidad().getNombre() +
                                   " (" + c.getFechaInicio() + " al " + c.getFechaTermino() + ")");
            }
        }
    }
    
    /**
     * iv. Dada una unidad, muestra el "historial de roles",
     * los diferentes roles que han trabajado en esa unidad,
     * especificando la persona que cumplió ese rol
     */
    public void reporteHistorialRolesUnidad(String nombreUnidad) {
        Unidad unidad = buscarUnidadPorNombre(nombreUnidad);
        
        if (unidad == null) {
            System.out.println("No se encontró unidad: " + nombreUnidad);
            return;
        }
        
        System.out.println("\n=== HISTORIAL DE ROLES DE " + unidad.getNombre() + " ===");
        
        ArrayList<Contrato> historial = unidad.getHistorialRolesOrdenado();
        
        if (historial.isEmpty()) {
            System.out.println("No hay roles registrados en esta unidad.");
        } else {
            for (Contrato c : historial) {
                System.out.println("- " + c.getRol() + ": " + c.getPersona().getNombre() +
                                   " (" + c.getFechaInicio() + " al " + c.getFechaTermino() + ")");
            }
        }
    }
    
    /**
     * v.1. La persona con más antigüedad en la UCN
     */
    public Persona getPersonaMasAntigua() {
        if (personas.isEmpty()) {
            return null;
        }
        
        Persona masAntigua = null;
        Fecha fechaMasAntigua = null;
        
        for (Persona p : personas) {
            Fecha fechaPersona = p.getFechaMasAntigua();
            
            if (fechaPersona != null) {
                if (fechaMasAntigua == null || fechaPersona.esAnterior(fechaMasAntigua)) {
                    masAntigua = p;
                    fechaMasAntigua = fechaPersona;
                }
            }
        }
        
        return masAntigua;
    }
    
    /**
     * v.2. La persona que ha tenido más roles
     */
    public Persona getPersonaConMasRoles() {
        if (personas.isEmpty()) {
            return null;
        }
        
        Persona conMasRoles = personas.get(0);
        
        for (Persona p : personas) {
            if (p.getCantidadRoles() > conMasRoles.getCantidadRoles()) {
                conMasRoles = p;
            }
        }
        
        return conMasRoles;
    }
    
    /**
     * v. Muestra las estadísticas generales
     */
    public void reporteEstadisticasGenerales() {
        System.out.println("\n=== ESTADÍSTICAS GENERALES ===");
        
        // Persona más antigua
        Persona masAntigua = getPersonaMasAntigua();
        if (masAntigua != null) {
            System.out.println("1. Persona con más antigüedad: " + masAntigua.getNombre() +
                               " (" + masAntigua.getRut() + ") desde " + masAntigua.getFechaMasAntigua());
        } else {
            System.out.println("1. No hay personas con contratos registrados.");
        }
        
        // Persona con más roles
        Persona conMasRoles = getPersonaConMasRoles();
        if (conMasRoles != null && conMasRoles.getCantidadRoles() > 0) {
            System.out.println("2. Persona con más roles: " + conMasRoles.getNombre() +
                               " (" + conMasRoles.getRut() + ") con " + conMasRoles.getCantidadRoles() + " rol(es)");
        } else {
            System.out.println("2. No hay personas con roles registrados.");
        }
    }
    
    // ==================== GETTERS ====================
    
    public ArrayList<Persona> getPersonas() {
        return personas;
    }
    
    public ArrayList<Unidad> getUnidades() {
        return unidades;
    }
    
    public ArrayList<Contrato> getContratos() {
        return contratos;
    }
}
