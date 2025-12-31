/**
 * Concrete vehicle class: Pickup Truck (Camioneta)
 */
public class Camioneta extends Vehiculo {

    public Camioneta(String vin, String marca, String modelo, double eficienciaNominal) {
        super(vin, marca, modelo, eficienciaNominal);
    }

    @Override
    public void accept(VehicleVisitor visitor) {
        visitor.visitCamioneta(this);
    }

    @Override
    public String getCategoria() {
        return "Camioneta";
    }
}
