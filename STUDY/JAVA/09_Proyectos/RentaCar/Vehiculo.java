import java.util.ArrayList;
import java.util.List;

/**
 * Abstract base class for all vehicles
 * Implements inheritance as required
 */
public abstract class Vehiculo {
    protected String vin;
    protected String marca;
    protected String modelo;
    protected double eficienciaNominal; // km/l
    protected List<Viaje> viajes;

    /**
     * Inner class to store trip information
     */
    public static class Viaje {
        private ModoManejo modo;
        private double distancia;

        public Viaje(ModoManejo modo, double distancia) {
            this.modo = modo;
            this.distancia = distancia;
        }

        public ModoManejo getModo() {
            return modo;
        }

        public double getDistancia() {
            return distancia;
        }
    }

    public Vehiculo(String vin, String marca, String modelo, double eficienciaNominal) {
        this.vin = vin;
        this.marca = marca;
        this.modelo = modelo;
        this.eficienciaNominal = eficienciaNominal;
        this.viajes = new ArrayList<>();
    }

    /**
     * Adds a trip to this vehicle's history
     */
    public void agregarViaje(ModoManejo modo, double distancia) {
        viajes.add(new Viaje(modo, distancia));
    }

    /**
     * Calculates total odometer reading (sum of all distances)
     */
    public int calcularOdometro() {
        double total = 0;
        for (Viaje viaje : viajes) {
            total += viaje.getDistancia();
        }
        return (int) total;
    }

    /**
     * Calculates total fuel consumption considering driving modes
     * Formula: distancia / eficiencia_ajustada
     */
    public double calcularConsumo() {
        double consumoTotal = 0;
        for (Viaje viaje : viajes) {
            double eficienciaAjustada = viaje.getModo().calcularEficienciaAjustada(eficienciaNominal);
            consumoTotal += viaje.getDistancia() / eficienciaAjustada;
        }
        return consumoTotal;
    }

    /**
     * Visitor pattern: Accept method for double dispatch
     */
    public abstract void accept(VehicleVisitor visitor);

    /**
     * Returns the vehicle category for classification
     */
    public abstract String getCategoria();

    // Getters
    public String getVin() {
        return vin;
    }

    public String getMarca() {
        return marca;
    }

    public String getModelo() {
        return modelo;
    }

    public double getEficienciaNominal() {
        return eficienciaNominal;
    }

    public List<Viaje> getViajes() {
        return viajes;
    }
}
