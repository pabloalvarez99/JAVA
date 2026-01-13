import java.util.HashMap;
import java.util.Map;

/**
 * Visitor Pattern: Concrete visitor to calculate consumption by category
 * Tracks the vehicle with highest consumption in each category
 */
public class ConsumoCalculator implements VehicleVisitor {

    private Map<String, Vehiculo> maxConsumoPorCategoria;
    private Map<String, Double> maxConsumoValores;

    public ConsumoCalculator() {
        maxConsumoPorCategoria = new HashMap<>();
        maxConsumoValores = new HashMap<>();
    }

    @Override
    public void visitCamioneta(Camioneta camioneta) {
        procesarVehiculo(camioneta);
    }

    @Override
    public void visitSUV(SUV suv) {
        procesarVehiculo(suv);
    }

    @Override
    public void visitAuto(Auto auto) {
        procesarVehiculo(auto);
    }

    /**
     * Processes a vehicle and updates max consumption tracking
     */
    private void procesarVehiculo(Vehiculo vehiculo) {
        String categoria = vehiculo.getCategoria();
        double consumo = vehiculo.calcularConsumo();

        // Update if this vehicle has higher consumption than current max
        if (!maxConsumoValores.containsKey(categoria) ||
            consumo > maxConsumoValores.get(categoria)) {
            maxConsumoPorCategoria.put(categoria, vehiculo);
            maxConsumoValores.put(categoria, consumo);
        }
    }

    /**
     * Returns the map of vehicles with maximum consumption per category
     */
    public Map<String, Vehiculo> getMaxConsumoPorCategoria() {
        return maxConsumoPorCategoria;
    }
}
