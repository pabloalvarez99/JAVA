/**
 * Strategy Pattern: Sport driving mode
 * Efficiency is 25% SUPERIOR than nominal (1.25x)
 * Superior efficiency = more km per liter = LESS fuel consumption
 */
public class ModoSport implements ModoManejo {

    @Override
    public double calcularEficienciaAjustada(double eficienciaNominal) {
        return eficienciaNominal * 1.25;
    }

    @Override
    public String getNombre() {
        return "S";
    }
}
