package Ay4;

/**
 * Clase Fecha - Representa una fecha con año, mes y día
 * Las fechas se identifican por su año, mes y día.
 */
public class Fecha {
    private int anio;
    private int mes;
    private int dia;
    
    // Constructor
    public Fecha(int anio, int mes, int dia) {
        this.anio = anio;
        this.mes = mes;
        this.dia = dia;
    }
    
    // Getters
    public int getAnio() {
        return anio;
    }
    
    public int getMes() {
        return mes;
    }
    
    public int getDia() {
        return dia;
    }
    
    // Setters
    public void setAnio(int anio) {
        this.anio = anio;
    }
    
    public void setMes(int mes) {
        this.mes = mes;
    }
    
    public void setDia(int dia) {
        this.dia = dia;
    }
    
    /**
     * Compara esta fecha con otra fecha
     * @param otra La fecha a comparar
     * @return -1 si esta fecha es anterior, 0 si son iguales, 1 si esta fecha es posterior
     */
    public int comparar(Fecha otra) {
        // Comparar por año
        if (this.anio < otra.anio) return -1;
        if (this.anio > otra.anio) return 1;
        
        // Mismo año, comparar por mes
        if (this.mes < otra.mes) return -1;
        if (this.mes > otra.mes) return 1;
        
        // Mismo año y mes, comparar por día
        if (this.dia < otra.dia) return -1;
        if (this.dia > otra.dia) return 1;
        
        // Son iguales
        return 0;
    }
    
    /**
     * Verifica si esta fecha es anterior a otra
     */
    public boolean esAnterior(Fecha otra) {
        return comparar(otra) < 0;
    }
    
    /**
     * Verifica si esta fecha es posterior a otra
     */
    public boolean esPosterior(Fecha otra) {
        return comparar(otra) > 0;
    }
    
    /**
     * Verifica si esta fecha está entre dos fechas (inclusive)
     */
    public boolean estaEntre(Fecha inicio, Fecha termino) {
        return comparar(inicio) >= 0 && comparar(termino) <= 0;
    }
    
    /**
     * Verifica si dos fechas son iguales
     */
    public boolean esIgual(Fecha otra) {
        return comparar(otra) == 0;
    }
    
    @Override
    public String toString() {
        return String.format("%02d/%02d/%04d", dia, mes, anio);
    }
}
