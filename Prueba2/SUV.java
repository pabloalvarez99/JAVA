/**
 * Concrete vehicle class: SUV
 */
public class SUV extends Vehiculo {

    public SUV(String vin, String marca, String modelo, double eficienciaNominal) {
        super(vin, marca, modelo, eficienciaNominal);
    }

    @Override
    public void accept(VehicleVisitor visitor) {
        visitor.visitSUV(this);
    }

    @Override
    public String getCategoria() {
        return "SUV";
    }
}
