/**
 * Strategy Pattern: Interface for driving modes
 * Defines how each mode affects fuel efficiency
 */
public interface ModoManejo {
    /**
     * Calculates adjusted efficiency based on driving mode
     * @param eficienciaNominal The vehicle's nominal efficiency in km/l
     * @return Adjusted efficiency for this driving mode
     */
    double calcularEficienciaAjustada(double eficienciaNominal);

    /**
     * Gets the mode name for display purposes
     * @return Mode name (E, N, or S)
     */
    String getNombre();
}
