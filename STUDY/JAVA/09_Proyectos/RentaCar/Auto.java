/**
 * Concrete vehicle class: Car (Auto)
 */
public class Auto extends Vehiculo {

    public Auto(String vin, String marca, String modelo, double eficienciaNominal) {
        super(vin, marca, modelo, eficienciaNominal);
    }

    @Override
    public void accept(VehicleVisitor visitor) {
        visitor.visitAuto(this);
    }

    @Override
    public String getCategoria() {
        return "Auto";
    }
}
