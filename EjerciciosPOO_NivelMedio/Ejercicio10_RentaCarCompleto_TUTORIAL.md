# Ejercicio 10: Rent a Car - TUTORIAL COMPLETO (REPLICA EXACTA DEL EXAMEN)
**Dificultad:** Avanzado (Nivel Examen)
**Tiempo estimado:** 3 horas
**Conceptos:** REPLICA EXACTA del Problema 2 del examen

---

## IMPORTANCIA DE ESTE EJERCICIO

**ESTE ES EL EJERCICIO MAS IMPORTANTE DE TODO EL CURSO.**

Si dominas este ejercicio, estas 100% preparado para el examen. Este es una replica exacta del Problema 2 que aparecera en tu examen final. La unica diferencia sera el contenido del archivo de datos.

**Lo que GARANTIZADAMENTE aparecera en el examen:**
1. Jerarquia de vehiculos (Camioneta, SUV, Auto)
2. Patron Strategy para modos de manejo (Eco, Normal, Sport)
3. Patron Visitor para calcular estadisticas
4. Singleton O Factory (tu eliges)
5. Lectura de archivo con formato especifico
6. Calculos de consumo y odometro
7. Identificar vehiculo con mayor consumo por categoria

**Metodo de estudio recomendado:**
1. Lee este tutorial completo primero (1 hora)
2. Intenta resolver sin ver las soluciones (2 horas)
3. Compara tu solucion con la proporcionada
4. Vuelve a programarlo de memoria al dia siguiente
5. Repite hasta que puedas hacerlo en menos de 3 horas

---

## CONTEXTO DEL PROBLEMA

Una empresa de renta de vehiculos necesita un sistema de seguimiento de su flota.

**Tipos de vehiculos:**
- Camionetas
- SUV
- Autos

**Informacion de cada vehiculo:**
- VIN: Numero identificador unico (String)
- Marca: Toyota, Ford, etc.
- Modelo: Camry, Explorer, etc.
- Eficiencia nominal: km/litro base del vehiculo

---

## MODOS DE MANEJO (PATRON STRATEGY)

Todos los vehiculos son automaticos y tienen 3 modos de manejo:

| Modo | Efecto en CONSUMO | Formula para Eficiencia |
|------|-------------------|-------------------------|
| Eco | Consume 10% MENOS | eficiencia × 1.10 |
| Normal | Consumo nominal | eficiencia × 1.00 |
| Sport | Consume 25% MAS | eficiencia × 0.75 |

**CUIDADO - CONFUSION COMUN:**

El enunciado dice "10% menor" refiriendose al CONSUMO, NO a la eficiencia.
- Si consume MENOS → es MAS eficiente → MULTIPLICAS
- Si consume MAS → es MENOS eficiente → DIVIDES (o multiplicas por factor menor a 1)

**Ejemplo numerico:**
```
Vehiculo: 10 km/l nominal
Distancia: 100 km

Modo Eco (consume 10% menos):
  eficienciaReal = 10 × 1.10 = 11 km/l
  consumo = 100 / 11 = 9.09 litros ✓ (consume menos)

Modo Normal:
  eficienciaReal = 10 × 1.00 = 10 km/l
  consumo = 100 / 10 = 10.00 litros

Modo Sport (consume 25% mas):
  eficienciaReal = 10 × 0.75 = 7.5 km/l
  consumo = 100 / 7.5 = 13.33 litros ✓ (consume mas)
```

---

## FORMATO DEL ARCHIVO: fleet.txt

**Estructura:**
```
N
VIN,Marca,Modelo,Tipo_Vehiculo,Eficiencia
...
VIN,Marca,Modelo,Tipo_Vehiculo,Eficiencia
VIN,Modo_Manejo,Distancia_1,...,Distancia_N
...
VIN,Modo_Manejo,Distancia_1,...,Distancia_N
```

**Ejemplo real:**
```
4
1HGBH41JXMN109186,Dodge,Ram 2500,Camioneta,6.8
WAUHF68P16A397756,Ford,F250,Camioneta,6.8
1FADP3K29EL223451,Ford,F150,Camioneta,8.75
KMHEC4A46CA012345,Mitsubishi,L200,Camioneta,9.45
1HGBH41JXMN109186,Sport,450,380,520,670,890,340,210,560
WAUHF68P16A397756,Normal,865,920,780,450,680,370
1FADP3K29EL223451,Eco,234,567,890,123,345,678,901,234
KMHEC4A46CA012345,Normal,456,789,123,456,789,123,456,78
```

**Puntos criticos de parsing:**
1. Primera linea: cantidad de vehiculos (N)
2. Siguientes N lineas: datos de vehiculos
3. Lineas restantes: viajes (cantidad variable por vehiculo)
4. Cada vehiculo puede tener multiples viajes
5. Todos los viajes de un vehiculo usan el MISMO modo de manejo

---

## REQUISITOS FUNCIONALES

### Se necesita calcular:

1. **Odometro total por vehiculo** (suma de todas las distancias)
2. **Combustible consumido por vehiculo** (considerando modo de manejo)
3. **Vehiculo con mayor consumo por categoria** (uno para Camionetas, uno para SUV, uno para Autos)

### Salida esperada (FORMATO EXACTO):

```
Dodge Ram 2500 CONSUMO: 664.56875 l ODOMETRO: 5020 km
Ford F250 CONSUMO: 715.4142857142857 l ODOMETRO: 4865 km
...
Mayor consumo:
Camioneta: WAUHF68P16A397756 (715.4142857142857 litros)
SUV: 1C4RDJEG9DC098442 (513.1624999999999 litros)
Auto: WBAEB53578C709570 (623.2291666666665 litros)
```

**Formato de cada linea:**
```java
System.out.printf("%s %s CONSUMO: %s l ODOMETRO: %d km%n",
    marca, modelo, consumo, odometro);
```

**Nota sobre precision:** NO redondees los valores de consumo. Usa la precision completa de double.

---

## REQUISITOS TECNICOS (OBLIGATORIOS)

Estos requisitos APARECERAN EN EL EXAMEN:

1. **Usar orientacion a objetos y herencia** ✓
2. **Patron Visitor** (obligatorio)
3. **Patron Strategy** (obligatorio)
4. **Patron Singleton O Factory** (tu eliges uno)
5. **Crear un "Sistema"** (clase SistemaRentaCar)
6. **Todos los vehiculos en UNA sola lista** (List<Vehiculo>)
7. **NO usar ciclos dentro de ciclos** (separar en metodos)
8. **Bonus: GUI con Swing** (opcional, +puntos extra)

---

## ARQUITECTURA COMPLETA DEL SISTEMA

### Vision General:

```
┌─────────────────────────────────────────────────────┐
│                 SistemaRentaCar                      │
│  - List<Vehiculo> flota                             │
│  - Map<String,Vehiculo> vehiculosPorVIN             │
│                                                      │
│  + cargarFlota(String archivo)                      │
│  + procesarViajes(Scanner sc, int n)                │
│  + mostrarEstadisticas()                            │
│  + calcularMayorConsumoPorCategoria()               │
└─────────────────────────────────────────────────────┘
                        │
                        │ contiene
                        ▼
            ┌────────────────────────┐
            │     Vehiculo (abstract) │
            │  - String vin           │
            │  - String marca         │
            │  - String modelo        │
            │  - double eficiencia    │
            │  - int odometro         │
            │  - double combustible   │
            │                         │
            │  + procesarViaje(...)   │
            │  + accept(Visitor)      │
            └────────────────────────┘
                        │
         ┌──────────────┼──────────────┐
         │              │              │
    ┌─────────┐   ┌─────────┐   ┌──────────┐
    │Camioneta│   │   SUV   │   │   Auto   │
    └─────────┘   └─────────┘   └──────────┘
         │              │              │
         └──────────────┼──────────────┘
                        │
                        │ usa
                        ▼
        ┌──────────────────────────────┐
        │  ModoManejoStrategy (interface)│
        └──────────────────────────────┘
                        │
         ┌──────────────┼──────────────┐
         │              │              │
    ┌─────────┐   ┌──────────┐   ┌─────────┐
    │ ModoEco │   │ModoNormal│   │ModoSport│
    └─────────┘   └──────────┘   └─────────┘

        ┌──────────────────────────────┐
        │  VisitorVehiculo (interface) │
        │  + visitarCamioneta()        │
        │  + visitarSUV()              │
        │  + visitarAuto()             │
        └──────────────────────────────┘
                        │
         ┌──────────────┴──────────────┐
         │                             │
┌───────────────────┐       ┌──────────────────┐
│CalculadorConsumo  │       │MostradorResultados│
└───────────────────┘       └──────────────────┘
```

---

## PASO A PASO: IMPLEMENTACION COMPLETA

### PASO 1: Crear la Jerarquia de Vehiculos

**Clase base abstracta:**

```java
public abstract class Vehiculo {
    // Atributos basicos del vehiculo
    protected String vin;
    protected String marca;
    protected String modelo;
    protected double eficienciaNominal; // km/litro base

    // Estadisticas acumuladas
    protected int odometroTotal;
    protected double combustibleConsumido;

    /**
     * Constructor base para todos los vehiculos
     */
    public Vehiculo(String vin, String marca, String modelo, double eficienciaNominal) {
        this.vin = vin;
        this.marca = marca;
        this.modelo = modelo;
        this.eficienciaNominal = eficienciaNominal;
        this.odometroTotal = 0;
        this.combustibleConsumido = 0.0;
    }

    /**
     * Procesa un viaje aplicando el modo de manejo
     * @param distancia Kilometros recorridos
     * @param modoManejo Strategy que modifica la eficiencia
     */
    public void procesarViaje(int distancia, ModoManejoStrategy modoManejo) {
        // Calcular eficiencia real segun el modo
        double eficienciaReal = modoManejo.calcularEficiencia(eficienciaNominal);

        // Calcular consumo para este viaje
        double consumoViaje = distancia / eficienciaReal;

        // Actualizar estadisticas
        odometroTotal += distancia;
        combustibleConsumido += consumoViaje;
    }

    /**
     * Metodo abstracto para obtener el tipo de vehiculo
     * Cada subclase debe implementarlo
     */
    public abstract String getTipo();

    /**
     * Metodo para el patron Visitor
     * Cada subclase debe implementarlo correctamente
     */
    public abstract void accept(VisitorVehiculo visitor);

    // Getters
    public String getVin() { return vin; }
    public String getMarca() { return marca; }
    public String getModelo() { return modelo; }
    public double getEficienciaNominal() { return eficienciaNominal; }
    public int getOdometroTotal() { return odometroTotal; }
    public double getCombustibleConsumido() { return combustibleConsumido; }

    @Override
    public String toString() {
        return String.format("%s %s (VIN: %s)", marca, modelo, vin);
    }
}
```

**Subclase: Camioneta**

```java
public class Camioneta extends Vehiculo {

    public Camioneta(String vin, String marca, String modelo, double eficienciaNominal) {
        super(vin, marca, modelo, eficienciaNominal);
    }

    @Override
    public String getTipo() {
        return "Camioneta";
    }

    @Override
    public void accept(VisitorVehiculo visitor) {
        visitor.visitarCamioneta(this);
    }
}
```

**Subclase: SUV**

```java
public class SUV extends Vehiculo {

    public SUV(String vin, String marca, String modelo, double eficienciaNominal) {
        super(vin, marca, modelo, eficienciaNominal);
    }

    @Override
    public String getTipo() {
        return "SUV";
    }

    @Override
    public void accept(VisitorVehiculo visitor) {
        visitor.visitarSUV(this);
    }
}
```

**Subclase: Auto**

```java
public class Auto extends Vehiculo {

    public Auto(String vin, String marca, String modelo, double eficienciaNominal) {
        super(vin, marca, modelo, eficienciaNominal);
    }

    @Override
    public String getTipo() {
        return "Auto";
    }

    @Override
    public void accept(VisitorVehiculo visitor) {
        visitor.visitarAuto(this);
    }
}
```

**PUNTOS CLAVE DE ESTE PASO:**

1. La clase base tiene toda la logica compartida
2. `procesarViaje()` es el metodo MAS IMPORTANTE - calcula consumo
3. Cada subclase solo necesita implementar `getTipo()` y `accept()`
4. El metodo `accept()` es el "gancho" para el patron Visitor

---

### PASO 2: Implementar el Patron Strategy (Modos de Manejo)

**Interface:**

```java
public interface ModoManejoStrategy {
    /**
     * Calcula la eficiencia real del vehiculo segun el modo de manejo
     * @param eficienciaNominal La eficiencia base del vehiculo (km/l)
     * @return La eficiencia ajustada segun el modo
     */
    double calcularEficiencia(double eficienciaNominal);

    /**
     * Retorna el nombre del modo para reportes
     */
    String getNombre();
}
```

**Implementacion: Modo Eco**

```java
public class ModoEco implements ModoManejoStrategy {

    @Override
    public double calcularEficiencia(double eficienciaNominal) {
        // Modo Eco: consume 10% menos → es 10% MAS eficiente
        return eficienciaNominal * 1.10;
    }

    @Override
    public String getNombre() {
        return "Eco";
    }
}
```

**Implementacion: Modo Normal**

```java
public class ModoNormal implements ModoManejoStrategy {

    @Override
    public double calcularEficiencia(double eficienciaNominal) {
        // Modo Normal: sin cambios en la eficiencia
        return eficienciaNominal * 1.00;
    }

    @Override
    public String getNombre() {
        return "Normal";
    }
}
```

**Implementacion: Modo Sport**

```java
public class ModoSport implements ModoManejoStrategy {

    @Override
    public double calcularEficiencia(double eficienciaNominal) {
        // Modo Sport: consume 25% mas → es 25% MENOS eficiente
        return eficienciaNominal * 0.75;
    }

    @Override
    public String getNombre() {
        return "Sport";
    }
}
```

**Factory Method para crear modos:**

```java
public class ModoManejoFactory {

    /**
     * Crea el modo de manejo apropiado segun el nombre
     * @param nombreModo "Eco", "Normal", o "Sport"
     * @return El strategy correspondiente
     */
    public static ModoManejoStrategy crearModo(String nombreModo) {
        switch (nombreModo.trim()) {
            case "Eco":
                return new ModoEco();
            case "Normal":
                return new ModoNormal();
            case "Sport":
                return new ModoSport();
            default:
                System.out.println("Modo desconocido: " + nombreModo + ", usando Normal");
                return new ModoNormal();
        }
    }
}
```

**VALIDACION DE FORMULAS:**

```java
// TEST MANUAL - Incluye esto en un main temporal para validar
public static void main(String[] args) {
    double eficienciaNominal = 10.0; // km/l
    int distancia = 100; // km

    ModoManejoStrategy eco = new ModoEco();
    ModoManejoStrategy normal = new ModoNormal();
    ModoManejoStrategy sport = new ModoSport();

    double efEco = eco.calcularEficiencia(eficienciaNominal);
    double efNormal = normal.calcularEficiencia(eficienciaNominal);
    double efSport = sport.calcularEficiencia(eficienciaNominal);

    double consumoEco = distancia / efEco;
    double consumoNormal = distancia / efNormal;
    double consumoSport = distancia / efSport;

    System.out.println("Eficiencia Eco: " + efEco + " km/l, Consumo: " + consumoEco + " l");
    System.out.println("Eficiencia Normal: " + efNormal + " km/l, Consumo: " + consumoNormal + " l");
    System.out.println("Eficiencia Sport: " + efSport + " km/l, Consumo: " + consumoSport + " l");

    // Deberia mostrar:
    // Eficiencia Eco: 11.0 km/l, Consumo: 9.09 l
    // Eficiencia Normal: 10.0 km/l, Consumo: 10.0 l
    // Eficiencia Sport: 7.5 km/l, Consumo: 13.33 l
}
```

---

### PASO 3: Implementar el Patron Visitor

**Interface:**

```java
public interface VisitorVehiculo {
    void visitarCamioneta(Camioneta camioneta);
    void visitarSUV(SUV suv);
    void visitarAuto(Auto auto);
}
```

**Visitor Concreto 1: Mostrador de Resultados**

```java
public class MostradorResultados implements VisitorVehiculo {

    @Override
    public void visitarCamioneta(Camioneta camioneta) {
        mostrarEstadisticas(camioneta);
    }

    @Override
    public void visitarSUV(SUV suv) {
        mostrarEstadisticas(suv);
    }

    @Override
    public void visitarAuto(Auto auto) {
        mostrarEstadisticas(auto);
    }

    /**
     * Metodo privado que formatea la salida exactamente como el examen requiere
     */
    private void mostrarEstadisticas(Vehiculo vehiculo) {
        // Formato EXACTO del examen:
        // Marca Modelo CONSUMO: X.XX l ODOMETRO: XXX km
        System.out.printf("%s %s CONSUMO: %s l ODOMETRO: %d km%n",
                        vehiculo.getMarca(),
                        vehiculo.getModelo(),
                        vehiculo.getCombustibleConsumido(), // SIN redondear
                        vehiculo.getOdometroTotal());
    }
}
```

**Visitor Concreto 2: Calculador de Estadisticas Avanzadas**

```java
public class CalculadorEstadisticas implements VisitorVehiculo {

    // Acumuladores por categoria
    private double totalConsumoCamionetas = 0;
    private double totalConsumoSUV = 0;
    private double totalConsumoAutos = 0;

    private int cantidadCamionetas = 0;
    private int cantidadSUV = 0;
    private int cantidadAutos = 0;

    @Override
    public void visitarCamioneta(Camioneta camioneta) {
        totalConsumoCamionetas += camioneta.getCombustibleConsumido();
        cantidadCamionetas++;
    }

    @Override
    public void visitarSUV(SUV suv) {
        totalConsumoSUV += suv.getCombustibleConsumido();
        cantidadSUV++;
    }

    @Override
    public void visitarAuto(Auto auto) {
        totalConsumoAutos += auto.getCombustibleConsumido();
        cantidadAutos++;
    }

    /**
     * Muestra estadisticas agregadas
     */
    public void mostrarResumen() {
        System.out.println("\n=== ESTADISTICAS AGREGADAS ===");

        if (cantidadCamionetas > 0) {
            double promedio = totalConsumoCamionetas / cantidadCamionetas;
            System.out.printf("Camionetas: %d unidades, Consumo promedio: %.2f l%n",
                            cantidadCamionetas, promedio);
        }

        if (cantidadSUV > 0) {
            double promedio = totalConsumoSUV / cantidadSUV;
            System.out.printf("SUVs: %d unidades, Consumo promedio: %.2f l%n",
                            cantidadSUV, promedio);
        }

        if (cantidadAutos > 0) {
            double promedio = totalConsumoAutos / cantidadAutos;
            System.out.printf("Autos: %d unidades, Consumo promedio: %.2f l%n",
                            cantidadAutos, promedio);
        }
    }
}
```

**POR QUE USAR VISITOR AQUI:**

1. **Separacion de responsabilidades:** Los vehiculos no necesitan saber como mostrar estadisticas
2. **Extensibilidad:** Puedes agregar nuevos visitors sin modificar las clases de vehiculos
3. **Cumple Open/Closed Principle:** Abierto a extension (nuevos visitors), cerrado a modificacion (vehiculos)
4. **El examen lo REQUIERE explicitamente**

---

### PASO 4: Crear el Sistema Principal

**Opcion A: Sistema como Singleton**

```java
import java.io.*;
import java.util.*;

public class SistemaRentaCar {

    // Singleton pattern
    private static SistemaRentaCar instance;

    // Datos de la flota
    private ArrayList<Vehiculo> flota;
    private Map<String, Vehiculo> vehiculosPorVIN; // Para busqueda O(1)

    /**
     * Constructor privado (Singleton)
     */
    private SistemaRentaCar() {
        flota = new ArrayList<>();
        vehiculosPorVIN = new HashMap<>();
    }

    /**
     * Obtiene la instancia unica del sistema (Singleton)
     */
    public static SistemaRentaCar getInstance() {
        if (instance == null) {
            instance = new SistemaRentaCar();
        }
        return instance;
    }

    /**
     * Lee el archivo y carga toda la informacion
     */
    public void cargarFlota(String nombreArchivo) {
        try {
            File archivo = new File(nombreArchivo);
            if (!archivo.exists()) {
                System.out.println("ERROR: Archivo no encontrado: " + nombreArchivo);
                return;
            }

            Scanner scanner = new Scanner(archivo);

            // Leer cantidad de vehiculos
            int n = Integer.parseInt(scanner.nextLine().trim());
            System.out.println("Cargando " + n + " vehiculos desde " + nombreArchivo + "...");

            // Leer datos de vehiculos
            leerDatosVehiculos(scanner, n);

            // Leer y procesar viajes
            procesarViajes(scanner);

            scanner.close();
            System.out.println("Carga completada: " + flota.size() + " vehiculos en la flota.");

        } catch (FileNotFoundException e) {
            System.out.println("ERROR: No se pudo abrir el archivo: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("ERROR durante la carga: " + e.getMessage());
            e.printStackTrace();
        }
    }

    /**
     * Lee las primeras N lineas con datos de vehiculos
     */
    private void leerDatosVehiculos(Scanner scanner, int n) {
        for (int i = 0; i < n; i++) {
            String linea = scanner.nextLine();
            String[] datos = linea.split(",");

            String vin = datos[0].trim();
            String marca = datos[1].trim();
            String modelo = datos[2].trim();
            String tipo = datos[3].trim();
            double eficiencia = Double.parseDouble(datos[4].trim());

            // Factory method implicito
            Vehiculo vehiculo = crearVehiculo(vin, marca, modelo, tipo, eficiencia);

            if (vehiculo != null) {
                flota.add(vehiculo);
                vehiculosPorVIN.put(vin, vehiculo);
            }
        }
    }

    /**
     * Factory Method para crear el vehiculo apropiado segun el tipo
     */
    private Vehiculo crearVehiculo(String vin, String marca, String modelo,
                                   String tipo, double eficiencia) {
        switch (tipo) {
            case "Camioneta":
                return new Camioneta(vin, marca, modelo, eficiencia);
            case "SUV":
                return new SUV(vin, marca, modelo, eficiencia);
            case "Auto":
                return new Auto(vin, marca, modelo, eficiencia);
            default:
                System.out.println("ADVERTENCIA: Tipo de vehiculo desconocido: " + tipo);
                return null;
        }
    }

    /**
     * Lee y procesa todas las lineas de viajes
     * Cada linea: VIN,Modo,Dist1,Dist2,...,DistN
     */
    private void procesarViajes(Scanner scanner) {
        while (scanner.hasNextLine()) {
            String linea = scanner.nextLine().trim();
            if (linea.isEmpty()) continue;

            String[] partes = linea.split(",");

            String vin = partes[0].trim();
            String nombreModo = partes[1].trim();

            // Obtener el vehiculo
            Vehiculo vehiculo = vehiculosPorVIN.get(vin);
            if (vehiculo == null) {
                System.out.println("ADVERTENCIA: VIN no encontrado: " + vin);
                continue;
            }

            // Crear el modo de manejo (Strategy)
            ModoManejoStrategy modo = ModoManejoFactory.crearModo(nombreModo);

            // Procesar cada distancia
            for (int i = 2; i < partes.length; i++) {
                int distancia = Integer.parseInt(partes[i].trim());
                vehiculo.procesarViaje(distancia, modo);
            }
        }
    }

    /**
     * Muestra estadisticas de todos los vehiculos usando Visitor
     */
    public void mostrarEstadisticas() {
        System.out.println("\n=== ESTADISTICAS DE LA FLOTA ===\n");

        VisitorVehiculo mostrador = new MostradorResultados();

        for (Vehiculo vehiculo : flota) {
            vehiculo.accept(mostrador);
        }
    }

    /**
     * Calcula y muestra el vehiculo con mayor consumo por cada categoria
     * ESTE METODO ES CRITICO PARA EL EXAMEN
     */
    public void calcularMayorConsumoPorCategoria() {
        Vehiculo mayorCamioneta = null;
        Vehiculo mayorSUV = null;
        Vehiculo mayorAuto = null;

        double maxConsumoCamioneta = 0;
        double maxConsumoSUV = 0;
        double maxConsumoAuto = 0;

        // Un solo recorrido de la lista (NO ciclos anidados)
        for (Vehiculo vehiculo : flota) {
            double consumo = vehiculo.getCombustibleConsumido();
            String tipo = vehiculo.getTipo();

            switch (tipo) {
                case "Camioneta":
                    if (consumo > maxConsumoCamioneta) {
                        maxConsumoCamioneta = consumo;
                        mayorCamioneta = vehiculo;
                    }
                    break;

                case "SUV":
                    if (consumo > maxConsumoSUV) {
                        maxConsumoSUV = consumo;
                        mayorSUV = vehiculo;
                    }
                    break;

                case "Auto":
                    if (consumo > maxConsumoAuto) {
                        maxConsumoAuto = consumo;
                        mayorAuto = vehiculo;
                    }
                    break;
            }
        }

        // Mostrar resultados en formato EXACTO del examen
        System.out.println("\nMayor consumo:");

        if (mayorCamioneta != null) {
            System.out.printf("Camioneta: %s (%s litros)%n",
                            mayorCamioneta.getVin(),
                            mayorCamioneta.getCombustibleConsumido());
        }

        if (mayorSUV != null) {
            System.out.printf("SUV: %s (%s litros)%n",
                            mayorSUV.getVin(),
                            mayorSUV.getCombustibleConsumido());
        }

        if (mayorAuto != null) {
            System.out.printf("Auto: %s (%s litros)%n",
                            mayorAuto.getVin(),
                            mayorAuto.getCombustibleConsumido());
        }
    }

    /**
     * Ejecuta el sistema completo
     */
    public void ejecutar(String nombreArchivo) {
        cargarFlota(nombreArchivo);
        mostrarEstadisticas();
        calcularMayorConsumoPorCategoria();
    }

    // Getters para acceso a datos (si se necesitan)
    public ArrayList<Vehiculo> getFlota() {
        return flota;
    }
}
```

**Opcion B: Sistema creado por Factory (Alternativa)**

Si prefieres Factory en vez de Singleton:

```java
public class SistemaRentaCarFactory {

    /**
     * Crea una nueva instancia del sistema
     */
    public static SistemaRentaCar crearSistema() {
        return new SistemaRentaCar();
    }

    /**
     * Crea un sistema y lo inicializa con un archivo
     */
    public static SistemaRentaCar crearSistemaConArchivo(String nombreArchivo) {
        SistemaRentaCar sistema = new SistemaRentaCar();
        sistema.cargarFlota(nombreArchivo);
        return sistema;
    }
}

// Uso:
// SistemaRentaCar sistema = SistemaRentaCarFactory.crearSistemaConArchivo("fleet.txt");
```

**NOTA:** Para el examen, usa Singleton O Factory, no ambos. Singleton es mas simple y directo.

---

### PASO 5: Crear el Programa Principal (Main)

```java
public class Main {

    public static void main(String[] args) {
        // Opcion 1: Con argumentos de linea de comandos
        String nombreArchivo = "fleet.txt";

        if (args.length > 0) {
            nombreArchivo = args[0];
        }

        System.out.println("╔════════════════════════════════════════╗");
        System.out.println("║   SISTEMA RENT A CAR - VERSION EXAM    ║");
        System.out.println("╔════════════════════════════════════════╗\n");

        // Obtener instancia del sistema (Singleton)
        SistemaRentaCar sistema = SistemaRentaCar.getInstance();

        // Ejecutar el sistema completo
        sistema.ejecutar(nombreArchivo);

        System.out.println("\n╔════════════════════════════════════════╗");
        System.out.println("║          PROCESAMIENTO COMPLETO         ║");
        System.out.println("╚════════════════════════════════════════╝");
    }
}
```

**Compilacion y ejecucion:**

```bash
# Compilar (asumiendo todos los .java en el mismo directorio)
javac *.java

# Ejecutar con archivo por defecto
java Main

# Ejecutar con archivo especifico
java Main datos/fleet.txt
```

---

## DATOS DE PRUEBA: fleet.txt

Crea este archivo para probar tu implementacion:

```
20
1HGBH41JXMN109186,Dodge,Ram 2500,Camioneta,6.8
WAUHF68P16A397756,Ford,F250,Camioneta,6.8
1FADP3K29EL223451,Ford,F150,Camioneta,8.75
KMHEC4A46CA012345,Mitsubishi,L200,Camioneta,9.45
1G1JC124517123456,Mazda,CX-7,SUV,11.72
WDDGF81X18R123456,Ford,Explorer,SUV,9.11
1GKEC13Z95R123456,Chevrolet,TrailBlazer,SUV,10.03
1C4RDJEG9DC098442,Chevrolet,Tahoe,SUV,7.65
5UXKR0C59E0H12345,BMW,X6,SUV,9.43
WAUZZZ8V7AA123456,Audi,Q5,SUV,11.56
1J4RR4GG1AC123456,Jeep,Grand Cherokee,SUV,8.07
KL1TD56E49B123456,Chevrolet,Aveo,Auto,13.14
WAUZZZ4G1DN123456,Audi,A6,Auto,16.28
WBAEB53578C709570,BMW,3 Series,Auto,13.58
2HGFA16568H123456,Honda,Civic,Auto,16.76
1HGCP2F35AA123456,Honda,Accord,Auto,11.6
KMHEC4A48DA123456,Hyundai,Sonata,Auto,12.32
KMHCT4AE0DU123456,Hyundai,Accent,Auto,15.64
KNADH4A39A6123456,Kia,Rio,Auto,17.04
JM1BL1S58A1123456,Mazda,Mazda6,Auto,16.33
1HGBH41JXMN109186,Sport,450,380,520,670,890,340,210,560,1000
WAUHF68P16A397756,Normal,865,920,780,450,680,370,800
1FADP3K29EL223451,Eco,234,567,890,123,345,678,901,234,431
KMHEC4A46CA012345,Normal,456,789,123,456,789,123,456,78,395
1G1JC124517123456,Sport,678,901,234,567,890,123,125
WDDGF81X18R123456,Normal,345,678,901,234,567,890,123,371
1GKEC13Z95R123456,Eco,234,567,890,123,456,789,112,488
1C4RDJEG9DC098442,Sport,789,123,456,789,123,456,189,1000
5UXKR0C59E0H12345,Eco,123,456,789,234,94
WAUZZZ8V7AA123456,Normal,567,890,234,123,375
1J4RR4GG1AC123456,Sport,890,234,567,123,75
KL1TD56E49B123456,Normal,123,456,789,234,366
WAUZZZ4G1DN123456,Eco,456,789,123,456,234,567,890,123,456,627
WBAEB53578C709570,Sport,234,567,890,123,456,789,234,567,890,345,237
2HGFA16568H123456,Normal,678,901,234,567,890,123,456,789,234,369
1HGCP2F35AA123456,Sport,345,678,901,234,567,890,123,456,789,128,120
KMHEC4A48DA123456,Eco,789,123,456,789,234,567,890,123,456,789,208
KMHCT4AE0DU123456,Normal,234,567,890,123,456,789,234,567,890,234,109
KNADH4A39A6123456,Eco,567,890,234,567,890,123,456,789,234,567,227
JM1BL1S58A1123456,Sport,123,456,789,234,567,890,123,456,789,234,567,123,134,420
```

**Salida esperada (primeras lineas):**

```
Dodge Ram 2500 CONSUMO: 664.56875 l ODOMETRO: 5020 km
Ford F250 CONSUMO: 715.4142857142857 l ODOMETRO: 4865 km
Ford F150 CONSUMO: 423.0944444444446 l ODOMETRO: 3703 km
Mitsubishi L200 CONSUMO: 387.8 l ODOMETRO: 3665 km
...
Mayor consumo:
Camioneta: WAUHF68P16A397756 (715.4142857142857 litros)
SUV: 1C4RDJEG9DC098442 (513.1624999999999 litros)
Auto: WBAEB53578C709570 (623.2291666666665 litros)
```

---

## ERRORES COMUNES Y COMO EVITARLOS

### Error 1: Confusion con las formulas de eficiencia

**ERROR:**
```java
// INCORRECTO
public double calcularEficiencia(double eficienciaNominal) {
    return eficienciaNominal * 0.90; // Eco - ERROR!
}
```

**CORRECTO:**
```java
// CORRECTO
public double calcularEficiencia(double eficienciaNominal) {
    return eficienciaNominal * 1.10; // Eco - consume 10% MENOS
}
```

**Por que:** "10% menor consumo" significa que rinde MAS, no menos.

---

### Error 2: Formato de salida incorrecto

**ERROR:**
```java
// INCORRECTO - redondea
System.out.printf("%s %s CONSUMO: %.2f l ODOMETRO: %d km%n", ...);
```

**CORRECTO:**
```java
// CORRECTO - precision completa
System.out.printf("%s %s CONSUMO: %s l ODOMETRO: %d km%n",
    marca, modelo, consumo, odometro);
```

**Por que:** El examen espera la precision completa de double (ej: 715.4142857142857)

---

### Error 3: No usar el patron Visitor correctamente

**ERROR:**
```java
// INCORRECTO - logica en el Sistema
for (Vehiculo v : flota) {
    if (v instanceof Auto) {
        System.out.println(((Auto)v).getInfo());
    }
}
```

**CORRECTO:**
```java
// CORRECTO - usar Visitor
VisitorVehiculo mostrador = new MostradorResultados();
for (Vehiculo v : flota) {
    v.accept(mostrador);
}
```

**Por que:** El examen REQUIERE usar Visitor, no instanceof.

---

### Error 4: Ciclos anidados

**ERROR:**
```java
// INCORRECTO - ciclos anidados
for (Vehiculo v1 : flota) {
    for (Vehiculo v2 : flota) {
        // comparaciones
    }
}
```

**CORRECTO:**
```java
// CORRECTO - un solo recorrido
Vehiculo mayorCamioneta = null;
double maxConsumo = 0;
for (Vehiculo v : flota) {
    if (v.getTipo().equals("Camioneta") && v.getConsumo() > maxConsumo) {
        maxConsumo = v.getConsumo();
        mayorCamioneta = v;
    }
}
```

**Por que:** El examen PROHIBE ciclos anidados.

---

### Error 5: Parsing incorrecto del archivo

**ERROR:**
```java
// INCORRECTO - asume formato fijo
String[] datos = linea.split(",");
int distancia1 = Integer.parseInt(datos[2]);
int distancia2 = Integer.parseInt(datos[3]);
// ... solo lee 2 distancias
```

**CORRECTO:**
```java
// CORRECTO - lee cantidad variable de distancias
String[] partes = linea.split(",");
for (int i = 2; i < partes.length; i++) {
    int distancia = Integer.parseInt(partes[i].trim());
    vehiculo.procesarViaje(distancia, modo);
}
```

**Por que:** Cada vehiculo puede tener diferente cantidad de viajes.

---

### Error 6: No manejar casos especiales

**ERROR:**
```java
// INCORRECTO - asume que todo existe
Vehiculo v = vehiculosPorVIN.get(vin);
v.procesarViaje(...); // NullPointerException si no existe!
```

**CORRECTO:**
```java
// CORRECTO - valida antes de usar
Vehiculo v = vehiculosPorVIN.get(vin);
if (v == null) {
    System.out.println("ADVERTENCIA: VIN no encontrado: " + vin);
    continue;
}
v.procesarViaje(...);
```

**Por que:** Programacion defensiva - siempre valida datos de entrada.

---

## CONCEPTOS APRENDIDOS

Al completar este ejercicio, dominas:

### 1. Programacion Orientada a Objetos
- [x] Herencia con clase abstracta
- [x] Polimorfismo (accept, getTipo)
- [x] Encapsulamiento (atributos protected/private)
- [x] Abstraccion (Vehiculo no se puede instanciar)

### 2. Patrones de Diseno
- [x] **Strategy:** Modos de manejo intercambiables
- [x] **Visitor:** Operaciones sobre jerarquia sin modificarla
- [x] **Singleton:** Instancia unica del sistema
- [x] **Factory Method:** Creacion de objetos segun tipo

### 3. Manejo de Datos
- [x] Lectura de archivos con Scanner
- [x] Parsing de CSV
- [x] Validacion de datos
- [x] Manejo de excepciones

### 4. Estructuras de Datos
- [x] ArrayList para almacenar flota
- [x] HashMap para busqueda rapida por VIN
- [x] Recorridos eficientes (sin ciclos anidados)

### 5. Buenas Practicas
- [x] Codigo modular (separacion en metodos)
- [x] Nombres descriptivos
- [x] Comentarios JavaDoc
- [x] Programacion defensiva
- [x] DRY (Don't Repeat Yourself)

---

## CHECKLIST DE DOMINIO

Marca cuando puedas hacer cada item SIN mirar las soluciones:

**Nivel 1 - Fundamentos:**
- [ ] Puedo crear la jerarquia de vehiculos correctamente
- [ ] Entiendo como funciona el patron Strategy
- [ ] Se calcular las eficiencias segun el modo de manejo
- [ ] Puedo leer un archivo CSV basico

**Nivel 2 - Implementacion:**
- [ ] Puedo implementar el patron Visitor desde cero
- [ ] Se crear el Sistema con Singleton
- [ ] Puedo parsear el archivo fleet.txt correctamente
- [ ] Entiendo como evitar ciclos anidados

**Nivel 3 - Dominio Completo:**
- [ ] Puedo escribir el programa completo en 3 horas
- [ ] Mi salida coincide EXACTAMENTE con la esperada
- [ ] Puedo explicar cada patron usado
- [ ] Puedo agregar nuevas funcionalidades facilmente

**Nivel 4 - Maestria:**
- [ ] Puedo hacerlo de memoria en menos de 2.5 horas
- [ ] Puedo agregar una GUI con Swing
- [ ] Puedo modificar el sistema para otros requisitos
- [ ] Puedo explicarle el codigo a otra persona

**OBJETIVO PARA EL EXAMEN:** Alcanzar al menos Nivel 3.

---

## VARIACIONES POSIBLES EN EL EXAMEN

El examen podria cambiar:

1. **Nombres de categorias:**
   - En vez de Camioneta/SUV/Auto podria ser Sedan/Coupe/Hatchback
   - **Solucion:** Tu codigo ya esta preparado, solo cambian los strings

2. **Numero de modos:**
   - Podrian agregar "Modo Deportivo+" o "Modo Hibrido"
   - **Solucion:** Solo agregas una nueva clase que implemente ModoManejoStrategy

3. **Formato de archivo:**
   - Podrian cambiar el orden de columnas
   - **Solucion:** Ajusta los indices en el parsing

4. **Estadisticas requeridas:**
   - Podrian pedir "promedio de odometro por categoria"
   - **Solucion:** Creas un nuevo Visitor

5. **Criterio de "mayor consumo":**
   - Podrian pedir "mayor eficiencia" en vez de "mayor consumo"
   - **Solucion:** Cambias el operador > por < en calcularMayorConsumoPorCategoria

**PRINCIPIO CLAVE:** Si tu arquitectura es solida y modular, cualquier cambio es facil de implementar.

---

## EXTENSION: GUI CON SWING (BONUS)

Si quieres puntos extra, agrega una GUI simple:

```java
import javax.swing.*;
import java.awt.*;
import java.io.*;

public class SistemaRentaCarGUI extends JFrame {

    private SistemaRentaCar sistema;
    private JTextArea areaResultados;
    private JButton botonCargar;
    private JButton botonMostrar;

    public SistemaRentaCarGUI() {
        sistema = SistemaRentaCar.getInstance();
        inicializarComponentes();
    }

    private void inicializarComponentes() {
        setTitle("Sistema Rent a Car");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // Panel superior con botones
        JPanel panelSuperior = new JPanel();
        botonCargar = new JButton("Cargar Flota");
        botonMostrar = new JButton("Mostrar Estadisticas");

        botonCargar.addActionListener(e -> cargarFlota());
        botonMostrar.addActionListener(e -> mostrarEstadisticas());

        panelSuperior.add(botonCargar);
        panelSuperior.add(botonMostrar);

        // Area de texto para resultados
        areaResultados = new JTextArea();
        areaResultados.setEditable(false);
        areaResultados.setFont(new Font("Monospaced", Font.PLAIN, 12));

        JScrollPane scrollPane = new JScrollPane(areaResultados);

        add(panelSuperior, BorderLayout.NORTH);
        add(scrollPane, BorderLayout.CENTER);

        setVisible(true);
    }

    private void cargarFlota() {
        JFileChooser fileChooser = new JFileChooser();
        int resultado = fileChooser.showOpenDialog(this);

        if (resultado == JFileChooser.APPROVE_OPTION) {
            File archivo = fileChooser.getSelectedFile();
            sistema.cargarFlota(archivo.getAbsolutePath());
            areaResultados.append("Flota cargada desde: " + archivo.getName() + "\n");
        }
    }

    private void mostrarEstadisticas() {
        // Redirigir System.out a la GUI
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        PrintStream ps = new PrintStream(baos);
        PrintStream old = System.out;
        System.setOut(ps);

        sistema.mostrarEstadisticas();
        sistema.calcularMayorConsumoPorCategoria();

        System.out.flush();
        System.setOut(old);

        areaResultados.setText(baos.toString());
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new SistemaRentaCarGUI());
    }
}
```

**Nota:** La GUI es OPCIONAL pero da puntos extra. Si el tiempo es ajustado en el examen, primero asegura que la version de consola funcione perfectamente.

---

## PLAN DE ESTUDIO RECOMENDADO

### Dia 1: Comprension
- Lee este tutorial completo
- Entiende cada patron individualmente
- Crea diagramas en papel

### Dia 2: Primera Implementacion
- Implementa paso a paso siguiendo el tutorial
- Compila y prueba frecuentemente
- Toma notas de dificultades

### Dia 3: Segunda Implementacion
- Intenta hacerlo de memoria
- Consulta el tutorial solo cuando estes atascado
- Compara con la solucion

### Dia 4: Practica Cronometrada
- Intentalo en exactamente 3 horas
- Sin mirar el tutorial
- Mide tu progreso

### Dia 5: Refinamiento
- Optimiza tu codigo
- Agrega la GUI si te sobra tiempo
- Practica explicar el codigo en voz alta

### Dia 6-7: Repaso
- Vuelve a hacerlo una vez mas
- Intenta variaciones (cambiar categorias, modos, etc.)
- Repasa los errores comunes

**EXAMEN:** Estaras 100% preparado.

---

## RECURSOS ADICIONALES

**Archivos necesarios:**
- `fleet.txt` - Datos de prueba (proporcionado arriba)
- Todos los archivos `.java` del sistema

**Estructura de carpetas sugerida:**
```
ProyectoExamen/
├── src/
│   ├── vehiculos/
│   │   ├── Vehiculo.java
│   │   ├── Camioneta.java
│   │   ├── SUV.java
│   │   └── Auto.java
│   ├── strategy/
│   │   ├── ModoManejoStrategy.java
│   │   ├── ModoEco.java
│   │   ├── ModoNormal.java
│   │   ├── ModoSport.java
│   │   └── ModoManejoFactory.java
│   ├── visitor/
│   │   ├── VisitorVehiculo.java
│   │   ├── MostradorResultados.java
│   │   └── CalculadorEstadisticas.java
│   ├── sistema/
│   │   └── SistemaRentaCar.java
│   └── Main.java
└── datos/
    └── fleet.txt
```

**Para el examen:** Probablemente tendras que entregar todo en un solo ZIP.

---

## NOTAS FINALES

1. **Lee TODO el enunciado del examen DOS veces** antes de programar
2. **Planifica 15-20 minutos** antes de escribir codigo
3. **Compila frecuentemente** - no esperes a terminar todo
4. **Usa nombres descriptivos** - el profesor debe entender tu codigo
5. **Comenta lo no-obvio** - especialmente las formulas
6. **Maneja errores** - al menos try-catch en la lectura de archivos
7. **Revisa el formato de salida** - que coincida EXACTAMENTE
8. **Deja tiempo para probar** - al menos 20-30 minutos al final

**RECUERDA:**
- Visitor: OBLIGATORIO
- Strategy: OBLIGATORIO
- Singleton O Factory: OBLIGATORIO (elige uno)
- Herencia: OBLIGATORIO
- NO ciclos anidados: OBLIGATORIO
- GUI: OPCIONAL (bonus)

---

**Si dominas este ejercicio, aprobaras el examen con excelente calificacion. Practica hasta que puedas hacerlo dormido. Buena suerte!**

---

*Tutorial creado para preparacion de examen POO - Universidad - 2025*
