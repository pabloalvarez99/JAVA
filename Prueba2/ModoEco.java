/**
 * Strategy Pattern: Eco driving mode
 * Efficiency is 10% LOWER than nominal (0.9x)
 * Lower efficiency = less km per liter = MORE fuel consumption
 */
public class ModoEco implements ModoManejo {

    @Override
    public double calcularEficienciaAjustada(double eficienciaNominal) {
        return eficienciaNominal * 0.9;
    }

    @Override
    public String getNombre() {
        return "E";
    }
}
