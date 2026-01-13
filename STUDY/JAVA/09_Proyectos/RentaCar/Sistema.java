import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Singleton Pattern: Central system to manage the vehicle fleet
 * Coordinates all operations: file reading, vehicle management, and reporting
 */
public class Sistema {

    private static Sistema instance;
    private List<Vehiculo> flota;
    private Map<String, ModoManejo> modos;

    /**
     * Private constructor for Singleton pattern
     */
    private Sistema() {
        flota = new ArrayList<>();
        modos = new HashMap<>();
        inicializarModos();
    }

    /**
     * Singleton: Get the unique instance
     */
    public static Sistema getInstance() {
        if (instance == null) {
            instance = new Sistema();
        }
        return instance;
    }

    /**
     * Initializes the driving modes map
     */
    private void inicializarModos() {
        modos.put("E", new ModoEco());
        modos.put("N", new ModoNormal());
        modos.put("S", new ModoSport());
    }

    /**
     * Loads fleet data from file
     */
    public void cargarFlota(String rutaArchivo) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader(rutaArchivo));
        String linea;

        // Read number of vehicles
        int numVehiculos = Integer.parseInt(br.readLine().trim());

        // Read vehicle information
        leerVehiculos(br, numVehiculos);

        // Read trip records
        leerViajes(br);

        br.close();
    }

    /**
     * Reads vehicle information from file
     */
    private void leerVehiculos(BufferedReader br, int numVehiculos) throws IOException {
        for (int i = 0; i < numVehiculos; i++) {
            String linea = br.readLine();
            String[] datos = linea.split(",");

            String vin = datos[0];
            String marca = datos[1];
            String modelo = datos[2];
            String tipo = datos[3];
            double eficiencia = Double.parseDouble(datos[4]);

            Vehiculo vehiculo = crearVehiculo(vin, marca, modelo, tipo, eficiencia);
            flota.add(vehiculo);
        }
    }

    /**
     * Factory method to create vehicles based on type
     */
    private Vehiculo crearVehiculo(String vin, String marca, String modelo, String tipo, double eficiencia) {
        switch (tipo) {
            case "P":
                return new Camioneta(vin, marca, modelo, eficiencia);
            case "S":
                return new SUV(vin, marca, modelo, eficiencia);
            case "C":
                return new Auto(vin, marca, modelo, eficiencia);
            default:
                throw new IllegalArgumentException("Tipo de vehiculo desconocido: " + tipo);
        }
    }

    /**
     * Reads trip records from file
     */
    private void leerViajes(BufferedReader br) throws IOException {
        String linea;
        while ((linea = br.readLine()) != null) {
            procesarViaje(linea);
        }
    }

    /**
     * Processes a single trip line
     */
    private void procesarViaje(String linea) {
        String[] datos = linea.split(",");
        String vin = datos[0];
        String modoStr = datos[1];

        Vehiculo vehiculo = buscarVehiculo(vin);
        ModoManejo modo = modos.get(modoStr);

        if (vehiculo != null && modo != null) {
            agregarDistancias(vehiculo, modo, datos);
        }
    }

    /**
     * Adds all distances from a trip record to the vehicle
     */
    private void agregarDistancias(Vehiculo vehiculo, ModoManejo modo, String[] datos) {
        for (int i = 2; i < datos.length; i++) {
            double distancia = Double.parseDouble(datos[i]);
            vehiculo.agregarViaje(modo, distancia);
        }
    }

    /**
     * Finds a vehicle by VIN
     */
    private Vehiculo buscarVehiculo(String vin) {
        for (Vehiculo v : flota) {
            if (v.getVin().equals(vin)) {
                return v;
            }
        }
        return null;
    }

    /**
     * Displays all vehicle information
     */
    public void mostrarInformacion() {
        mostrarDetalleVehiculos();
        System.out.println();
        mostrarMayoresConsumos();
    }

    /**
     * Displays detailed information for each vehicle
     */
    private void mostrarDetalleVehiculos() {
        for (Vehiculo vehiculo : flota) {
            double consumo = vehiculo.calcularConsumo();
            int odometro = vehiculo.calcularOdometro();
            System.out.println(vehiculo.getMarca() + " " + vehiculo.getModelo() +
                             " CONSUMO: " + consumo + " l ODOMETRO: " + odometro + " km");
        }
    }

    /**
     * Displays vehicles with highest consumption per category using Visitor pattern
     */
    private void mostrarMayoresConsumos() {
        ConsumoCalculator visitor = new ConsumoCalculator();

        // Apply visitor to all vehicles
        aplicarVisitor(visitor);

        // Display results
        System.out.println("Mayor consumo: ");
        Map<String, Vehiculo> maxConsumos = visitor.getMaxConsumoPorCategoria();

        imprimirMaximoConsumo(maxConsumos, "Camioneta");
        imprimirMaximoConsumo(maxConsumos, "SUV");
        imprimirMaximoConsumo(maxConsumos, "Auto");
    }

    /**
     * Applies visitor to all vehicles in the fleet
     */
    private void aplicarVisitor(VehicleVisitor visitor) {
        for (Vehiculo vehiculo : flota) {
            vehiculo.accept(visitor);
        }
    }

    /**
     * Prints maximum consumption for a category
     */
    private void imprimirMaximoConsumo(Map<String, Vehiculo> maxConsumos, String categoria) {
        if (maxConsumos.containsKey(categoria)) {
            Vehiculo v = maxConsumos.get(categoria);
            System.out.println(categoria + ": " + v.getVin() +
                             " (" + v.calcularConsumo() + " litros)");
        }
    }

    /**
     * Main method to run the system
     */
    public static void main(String[] args) {
        Sistema sistema = Sistema.getInstance();

        try {
            // Load fleet data from file
            String rutaArchivo = "C:\\Users\\Pablo\\Documents\\Build\\1\\fleet.txt";
            sistema.cargarFlota(rutaArchivo);

            // Display results
            sistema.mostrarInformacion();

        } catch (IOException e) {
            System.err.println("Error al leer el archivo: " + e.getMessage());
        } catch (Exception e) {
            System.err.println("Error: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
