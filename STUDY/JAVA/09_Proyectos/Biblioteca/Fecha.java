package Biblioteca;

/**
 * Clase Fecha - Representa una fecha con año, mes y día
 */
public class Fecha {
    private int anio;
    private int mes;
    private int dia;
    
    public Fecha(int anio, int mes, int dia) {
        this.anio = anio;
        this.mes = mes;
        this.dia = dia;
    }
    
    // Getters
    public int getAnio() { return anio; }
    public int getMes() { return mes; }
    public int getDia() { return dia; }
    
    // Setters
    public void setAnio(int anio) { this.anio = anio; }
    public void setMes(int mes) { this.mes = mes; }
    public void setDia(int dia) { this.dia = dia; }
    
    /**
     * Compara esta fecha con otra
     * @return negativo si this < otra, 0 si iguales, positivo si this > otra
     */
    public int comparar(Fecha otra) {
        if (this.anio != otra.anio) return this.anio - otra.anio;
        if (this.mes != otra.mes) return this.mes - otra.mes;
        return this.dia - otra.dia;
    }
    
    public boolean esAnterior(Fecha otra) {
        return comparar(otra) < 0;
    }
    
    public boolean esPosterior(Fecha otra) {
        return comparar(otra) > 0;
    }
    
    public boolean esIgual(Fecha otra) {
        return comparar(otra) == 0;
    }
    
    public boolean estaEntre(Fecha inicio, Fecha fin) {
        return comparar(inicio) >= 0 && comparar(fin) <= 0;
    }
    
    @Override
    public String toString() {
        return String.format("%02d/%02d/%04d", dia, mes, anio);
    }
}
