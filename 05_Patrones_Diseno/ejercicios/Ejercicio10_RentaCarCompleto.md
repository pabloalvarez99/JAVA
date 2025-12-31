# Ejercicio 10: Rent a Car - Version Completa (Nivel 4 - EXAMEN)
**Dificultad:** Avanzado (Nivel Examen)
**Tiempo estimado:** 3 horas
**Conceptos:** REPLICA EXACTA del Problema 2 del examen

---

## Contexto

Este ejercicio es una **replica del Problema 2 del examen real**. Una empresa de renta de vehiculos esta haciendo un sistema de seguimiento de su flota.

Los tipos de vehiculos que ofrecen son 3: **Camionetas, SUV y Autos**. De ellos se guarda la informacion del VIN (numero identificador unico de un vehiculo), la marca, modelo y la eficiencia de combustible medida en km/l.

## Modos de Manejo

Todos los vehiculos son automaticos y cuentan con 3 modos de manejo:

| Modo | Efecto en la eficiencia |
|------|------------------------|
| Modo Eco | La eficiencia de combustible es un 10% **menor** que la nominal (consume menos) |
| Modo Normal | La eficiencia de combustible es la nominal |
| Modo Sport | La eficiencia de combustible es un 25% **superior** a la nominal (consume mas) |

**IMPORTANTE:** El enunciado dice "10% menor" refiriendose al CONSUMO (es decir, la eficiencia es MEJOR).
- Eco: eficiencia_real = eficiencia_nominal × 1.10 (rinde mas)
- Normal: eficiencia_real = eficiencia_nominal × 1.00
- Sport: eficiencia_real = eficiencia_nominal × 0.75 (rinde menos)

## Formato del Archivo: fleet.txt

```
N
VIN,Marca,Modelo,Tipo_Vehiculo,Eficiencia
...
VIN,Marca,Modelo,Tipo_Vehiculo,Eficiencia
VIN,Modo_Manejo,Distancia_1,...,Distancia_N
...
VIN,Modo_Manejo,Distancia_1,...,Distancia_N
```

Ejemplo:
```
4
1HGBH41JXMN109186,Dodge,Ram 2500,Camioneta,6.8
WAUHF68P16A397756,Ford,F250,Camioneta,6.8
1FADP3K29EL223451,Ford,F150,Camioneta,8.75
KMHEC4A46CA012345,Mitsubishi,L200,Camioneta,9.45
1HGBH41JXMN109186,Sport,450,380,520,670,890,340,210,560
WAUHF68P16A397756,Normal,865,920,780,450,680,370
```

## Requisitos

### Se necesita lo siguiente:

1. Calcular el kilometraje recorrido de cada vehiculo
2. Calcular cuanto combustible fue utilizado por cada vehiculo (considerar el modo de conduccion)
3. Vehiculos con mayor consumo de combustible por categoria

### Salida esperada (formato exacto):

```
Dodge Ram 2500 CONSUMO: 664.56875 l ODOMETRO: 5020 km
Ford F250 CONSUMO: 715.4142857142857 l ODOMETRO: 4865 km
Ford F150 CONSUMO: 423.0944444444446 l ODOMETRO: 3703 km
Mitsubishi L200 CONSUMO: 387.8 l ODOMETRO: 3665 km
Mazda CX-7 CONSUMO: 300.1541666666667 l ODOMETRO: 3518 km
Ford Explorer CONSUMO: 451.1833333333334 l ODOMETRO: 4109 km
Chevrolet TrailBlazer CONSUMO: 364.945 l ODOMETRO: 3659 km
Chevrolet Tahoe CONSUMO: 513.1624999999999 l ODOMETRO: 3925 km
BMW X6 CONSUMO: 179.855 l ODOMETRO: 1696 km
Audi Q5 CONSUMO: 189.4727272727273 l ODOMETRO: 2189 km
Jeep Grand Cherokee CONSUMO: 234.22777777777776 l ODOMETRO: 1889 km
Chevrolet Aveo CONSUMO: 149.81 l ODOMETRO: 1968 km
Audi A6 CONSUMO: 345.52812500000005 l ODOMETRO: 5621 km
BMW 3 Series CONSUMO: 598.7749999999999 l ODOMETRO: 8132 km
Honda Civic CONSUMO: 432.16944444444465 l ODOMETRO: 7241 km
Honda Accord CONSUMO: 623.2291666666665 l ODOMETRO: 7231 km
Hyundai Sonata CONSUMO: 593.6269230769228 l ODOMETRO: 7314 km
Hyundai Accent CONSUMO: 453.65 l ODOMETRO: 7093 km
Kia Rio CONSUMO: 383.8694444444444 l ODOMETRO: 6544 km
Mazda Mazda6 CONSUMO: 426.03823529411767 l ODOMETRO: 6955 km

Mayor consumo:
Camioneta: WAUHF68P16A397756 (715.4142857142857 litros)
SUV: 1C4RDJEG9DC098442 (513.1624999999999 litros)
Auto: WBAEB53578C709570 (623.2291666666665 litros)
```

## Debe entregar:

- Codigo Java (100%)

## Consideraciones (IMPORTANTE - LEER TODO):

1. **Considere que los vehiculos de la flota deben estar almacenados en una sola lista.**

2. **Debe usar orientacion al objeto. Debe usar herencia.**

3. **Debe utilizar 3 patrones, de manera obligatoria el patron Visitor y Strategy, pero puede elegir entre Singleton o Factory.**

4. **Obtendra puntaje extra si la salida por pantalla aparece en una GUI.**

5. **Use la arquitectura vista en clase: DEBE crear un "Sistema".**

6. **No se deben utilizar ciclos dentro de ciclos. Use funciones para hacerse la vida mas facil.**

7. **El codigo fuente debe exportarlo como .zip y subirlo a Campus Virtual.**

## Arquitectura Sugerida:

```
Sistema (Singleton o creado por Factory)
├── List<Vehiculo> flota
├── leerArchivo()
├── procesarViajes()
├── mostrarEstadisticas()
└── calcularMayorConsumoPorCategoria()

Vehiculo (clase abstracta)
├── Camioneta
├── SUV
└── Auto

ModoManejoStrategy (interface)
├── ModoEco
├── ModoNormal
└── ModoSport

VisitorVehiculo (interface)
├── visitarCamioneta(Camioneta c)
├── visitarSUV(SUV s)
└── visitarAuto(Auto a)

Implementaciones Visitor:
├── CalculadorEstadisticas
└── MostradorResultados
```

## Formulas Clave:

**Calculo de eficiencia segun modo:**
```java
// Eco: consume 10% menos (es mas eficiente)
eficienciaReal = eficienciaNominal * 1.10;

// Normal: consume lo nominal
eficienciaReal = eficienciaNominal * 1.00;

// Sport: consume 25% mas (es menos eficiente)
eficienciaReal = eficienciaNominal * 0.75;
```

**Calculo de consumo por viaje:**
```java
consumo = distancia / eficienciaReal;
```

**Ejemplo completo:**
- Vehiculo: 10 km/l nominal
- Modo: Sport
- Distancias: [100, 150, 200]

Calculos:
```
eficienciaReal = 10 * 0.75 = 7.5 km/l
consumo1 = 100 / 7.5 = 13.33 litros
consumo2 = 150 / 7.5 = 20.00 litros
consumo3 = 200 / 7.5 = 26.67 litros
consumoTotal = 60.00 litros
odometro = 450 km
```

## Consejos para el Examen:

1. **Lee TODO el enunciado DOS veces** antes de empezar a programar
2. **Planifica tu arquitectura** en papel primero
3. **Implementa por fases:**
   - Fase 1: Jerarquia de vehiculos
   - Fase 2: Lectura de archivo
   - Fase 3: Patron Strategy
   - Fase 4: Patron Visitor
   - Fase 5: Sistema y estadisticas
4. **Compila frecuentemente** para detectar errores temprano
5. **Usa nombres descriptivos** - el codigo debe ser legible
6. **No uses ciclos anidados** - separa logica en metodos
7. **Maneja excepciones** apropiadamente

## Tiempo Sugerido:

- Analisis y planificacion: 15-20 minutos
- Implementacion: 2 horas - 2 horas 20 minutos
- Pruebas y depuracion: 20-30 minutos
- **Total: ~3 horas**

---

**ESTE ES EL EJERCICIO MAS IMPORTANTE. Replicalo completamente para estar preparado para el examen.**

---

# 📚 PASO A PASO: SOLUCION COMPLETA Y TUTORIAL EXHAUSTIVO

Este tutorial te guiará paso por paso para resolver el problema más importante: **la réplica exacta del examen**. Sigue cada sección cuidadosamente.

---

## 🎯 ENTENDIENDO LA ARQUITECTURA COMPLETA

Antes de programar, entiende qué componentes necesitas y cómo interactúan:

```
┌─────────────────────────────────────────────────────────┐
│                    SISTEMA (Singleton)                   │
│  ┌────────────────────────────────────────────────┐     │
│  │  List<Vehiculo> flota  (UNA SOLA LISTA)       │     │
│  │  HashMap<String, Vehiculo> busquedaVIN        │     │
│  └────────────────────────────────────────────────┘     │
│                                                          │
│  Métodos:                                                │
│  - leerArchivo("fleet.txt")                             │
│  - procesarViajes()                                      │
│  - mostrarEstadisticas()                                 │
│  - calcularMayorConsumoPorCategoria()                   │
└─────────────────────────────────────────────────────────┘
            ↓ contiene                    ↓ usa
    ┌──────────────┐            ┌───────────────────┐
    │   VEHICULO   │            │  VISITOR PATTERN  │
    │  (abstract)  │←──────────│  VisitorVehiculo  │
    └──────────────┘  acepta    └───────────────────┘
            ↑                            ↑
      hereda de                   implementan
            │                            │
    ┌───────┴────────┐         ┌────────┴──────────┐
    │                │         │                    │
┌───────┐  ┌─────┐  ┌────┐  ┌──────────┐  ┌──────────────┐
│ Auto  │  │ SUV │  │Cam.│  │Calculador│  │   Mostrador  │
└───────┘  └─────┘  └────┘  │Estadist. │  │  Resultados  │
                             └──────────┘  └──────────────┘

    ┌────────────────────────────┐
    │   STRATEGY PATTERN         │
    │  ModoManejoStrategy        │
    └────────────────────────────┘
              ↑
       implementan
              │
    ┌─────────┴──────────┐
    │                    │
┌────────┐  ┌────────┐  ┌────────┐
│ModoEco │  │ModoNorm│  │ModoSport│
└────────┘  └────────┘  └────────┘
```

### Flujo de Datos:

1. **Sistema lee fleet.txt** → Crea objetos Vehiculo (Auto/SUV/Camioneta)
2. **Sistema lee líneas de viajes** → Aplica Strategy (ModoManejo)
3. **Sistema calcula consumo** → Acumula en cada Vehiculo
4. **Sistema usa Visitor** → Muestra estadísticas
5. **Sistema encuentra máximos** → Por categoría

---

## PASO 1: Crear Jerarquía de Vehículos

### Clase Base Abstracta: Vehiculo.java

```java
/**
 * Clase abstracta base para todos los vehículos de la flota.
 * Implementa la interfaz VehiculoVisitable para el patrón Visitor.
 */
public abstract class Vehiculo implements VehiculoVisitable {
    // Atributos protegidos (accesibles desde subclases)
    protected String vin;           // Identificador único
    protected String marca;
    protected String modelo;
    protected double eficienciaNominal;  // km/litro nominal

    // Estadísticas acumuladas
    protected double odometro;       // Total km recorridos
    protected double consumoTotal;   // Total litros consumidos

    /**
     * Constructor con todos los atributos del vehículo
     */
    public Vehiculo(String vin, String marca, String modelo, double eficiencia) {
        this.vin = vin;
        this.marca = marca;
        this.modelo = modelo;
        this.eficienciaNominal = eficiencia;
        this.odometro = 0;
        this.consumoTotal = 0;
    }

    /**
     * Procesa un viaje aplicando el modo de manejo correspondiente.
     * Este método EVITA ciclos anidados al separar la lógica.
     *
     * @param modo Estrategia de manejo (Eco/Normal/Sport)
     * @param distancias Array de distancias recorridas
     */
    public void procesarViaje(ModoManejoStrategy modo, double[] distancias) {
        // Calcular eficiencia real según el modo
        double eficienciaReal = modo.calcularEficiencia(this.eficienciaNominal);

        // Procesar cada distancia
        for (double distancia : distancias) {
            // Acumular kilómetros
            this.odometro += distancia;

            // Calcular y acumular consumo
            double consumo = distancia / eficienciaReal;
            this.consumoTotal += consumo;
        }
    }

    // Getters
    public String getVIN() { return vin; }
    public String getMarca() { return marca; }
    public String getModelo() { return modelo; }
    public double getEficienciaNominal() { return eficienciaNominal; }
    public double getOdometro() { return odometro; }
    public double getConsumoTotal() { return consumoTotal; }

    /**
     * Obtiene el tipo de vehículo (Auto/SUV/Camioneta)
     * Cada subclase debe implementar esto.
     */
    public abstract String getTipo();

    /**
     * Método accept del patrón Visitor.
     * Cada subclase debe implementar double dispatch.
     */
    @Override
    public abstract void aceptar(VisitorVehiculo visitor);
}
```

### Subclases Concretas:

**Auto.java:**
```java
public class Auto extends Vehiculo {

    public Auto(String vin, String marca, String modelo, double eficiencia) {
        super(vin, marca, modelo, eficiencia);
    }

    @Override
    public String getTipo() {
        return "Auto";
    }

    @Override
    public void aceptar(VisitorVehiculo visitor) {
        visitor.visitarAuto(this);  // Double dispatch
    }
}
```

**SUV.java:**
```java
public class SUV extends Vehiculo {

    public SUV(String vin, String marca, String modelo, double eficiencia) {
        super(vin, marca, modelo, eficiencia);
    }

    @Override
    public String getTipo() {
        return "SUV";
    }

    @Override
    public void aceptar(VisitorVehiculo visitor) {
        visitor.visitarSUV(this);  // Double dispatch
    }
}
```

**Camioneta.java:**
```java
public class Camioneta extends Vehiculo {

    public Camioneta(String vin, String marca, String modelo, double eficiencia) {
        super(vin, marca, modelo, eficiencia);
    }

    @Override
    public String getTipo() {
        return "Camioneta";
    }

    @Override
    public void aceptar(VisitorVehiculo visitor) {
        visitor.visitarCamioneta(this);  // Double dispatch
    }
}
```

---

## PASO 2: Implementar Strategy Pattern (Modos de Manejo)

### Interface: ModoManejoStrategy.java

```java
/**
 * Interface para el patrón Strategy.
 * Permite cambiar el comportamiento de cálculo de eficiencia dinámicamente.
 */
public interface ModoManejoStrategy {
    /**
     * Calcula la eficiencia real basándose en la eficiencia nominal
     * y las características del modo de manejo.
     *
     * @param eficienciaNominal Eficiencia base del vehículo (km/l)
     * @return Eficiencia real ajustada por el modo
     */
    double calcularEficiencia(double eficienciaNominal);

    /**
     * Obtiene el nombre del modo para logging/debugging
     */
    String getNombre();
}
```

### Implementación 1: ModoEco.java

```java
/**
 * Modo Eco: Consume 10% MENOS combustible.
 * Esto significa que la eficiencia es 10% MEJOR.
 * Fórmula: eficiencia_real = eficiencia_nominal × 1.10
 */
public class ModoEco implements ModoManejoStrategy {

    @Override
    public double calcularEficiencia(double eficienciaNominal) {
        // 10% mejor eficiencia = multiplicar por 1.10
        return eficienciaNominal * 1.10;
    }

    @Override
    public String getNombre() {
        return "Eco";
    }
}
```

### Implementación 2: ModoNormal.java

```java
/**
 * Modo Normal: Eficiencia nominal sin cambios.
 * Fórmula: eficiencia_real = eficiencia_nominal × 1.00
 */
public class ModoNormal implements ModoManejoStrategy {

    @Override
    public double calcularEficiencia(double eficienciaNominal) {
        // Sin cambios
        return eficienciaNominal * 1.00;
    }

    @Override
    public String getNombre() {
        return "Normal";
    }
}
```

### Implementación 3: ModoSport.java

```java
/**
 * Modo Sport: Consume 25% MÁS combustible.
 * Esto significa que la eficiencia es 25% PEOR.
 * Fórmula: eficiencia_real = eficiencia_nominal × 0.75
 */
public class ModoSport implements ModoManejoStrategy {

    @Override
    public double calcularEficiencia(double eficienciaNominal) {
        // 25% peor eficiencia = multiplicar por 0.75
        return eficienciaNominal * 0.75;
    }

    @Override
    public String getNombre() {
        return "Sport";
    }
}
```

---

## PASO 3: Implementar Visitor Pattern

### Interface: VehiculoVisitable.java

```java
/**
 * Interface que deben implementar los elementos visitables.
 */
public interface VehiculoVisitable {
    void aceptar(VisitorVehiculo visitor);
}
```

### Interface: VisitorVehiculo.java

```java
/**
 * Interface del patrón Visitor.
 * Define una operación para cada tipo concreto de vehículo.
 */
public interface VisitorVehiculo {
    void visitarAuto(Auto auto);
    void visitarSUV(SUV suv);
    void visitarCamioneta(Camioneta camioneta);
}
```

### Implementación: MostradorResultados.java

```java
/**
 * Visitor que muestra los resultados de cada vehículo.
 * Formato: Marca Modelo CONSUMO: X litros ODOMETRO: Y km
 */
public class MostradorResultados implements VisitorVehiculo {

    @Override
    public void visitarAuto(Auto auto) {
        mostrarVehiculo(auto);
    }

    @Override
    public void visitarSUV(SUV suv) {
        mostrarVehiculo(suv);
    }

    @Override
    public void visitarCamioneta(Camioneta camioneta) {
        mostrarVehiculo(camioneta);
    }

    /**
     * Método auxiliar para evitar duplicación de código.
     * Muestra la información en el formato requerido por el examen.
     */
    private void mostrarVehiculo(Vehiculo v) {
        System.out.printf("%s %s CONSUMO: %s l ODOMETRO: %.0f km%n",
            v.getMarca(),
            v.getModelo(),
            v.getConsumoTotal(),
            v.getOdometro()
        );
    }
}
```

---

## PASO 4: Implementar Sistema Principal (Singleton)

### Sistema.java

```java
import java.io.*;
import java.util.*;

/**
 * Clase Sistema implementando el patrón Singleton.
 * Gestiona toda la lógica del sistema Rent a Car.
 */
public class Sistema {
    // Instancia única (Singleton)
    private static Sistema instancia;

    // Flota: UNA SOLA LISTA (polimorfismo)
    private List<Vehiculo> flota;

    // HashMap para búsqueda rápida por VIN
    private HashMap<String, Vehiculo> busquedaVIN;

    /**
     * Constructor privado (patrón Singleton)
     */
    private Sistema() {
        this.flota = new ArrayList<>();
        this.busquedaVIN = new HashMap<>();
    }

    /**
     * Obtener la instancia única del sistema
     */
    public static Sistema getInstance() {
        if (instancia == null) {
            instancia = new Sistema();
        }
        return instancia;
    }

    /**
     * Lee el archivo fleet.txt y carga la flota.
     *
     * Formato:
     * N
     * VIN,Marca,Modelo,Tipo,Eficiencia
     * ...
     * VIN,Modo,Dist1,Dist2,...
     * ...
     */
    public void leerArchivo(String nombreArchivo) {
        try (Scanner scanner = new Scanner(new File(nombreArchivo))) {
            // Leer cantidad de vehículos
            int N = Integer.parseInt(scanner.nextLine().trim());

            // Leer N vehículos
            for (int i = 0; i < N; i++) {
                String linea = scanner.nextLine();
                String[] datos = linea.split(",");

                String vin = datos[0].trim();
                String marca = datos[1].trim();
                String modelo = datos[2].trim();
                String tipo = datos[3].trim();
                double eficiencia = Double.parseDouble(datos[4].trim());

                // Factory Method implícito según el tipo
                Vehiculo vehiculo = crearVehiculo(vin, marca, modelo, tipo, eficiencia);

                // Agregar a AMBAS estructuras
                flota.add(vehiculo);
                busquedaVIN.put(vin, vehiculo);
            }

            // Leer líneas de viajes
            while (scanner.hasNextLine()) {
                String linea = scanner.nextLine().trim();
                if (linea.isEmpty()) continue;

                procesarLineaViaje(linea);
            }

            System.out.println("Archivo cargado exitosamente: " + N + " vehículos.");

        } catch (FileNotFoundException e) {
            System.err.println("ERROR: Archivo no encontrado: " + nombreArchivo);
            System.exit(1);
        } catch (Exception e) {
            System.err.println("ERROR al leer archivo: " + e.getMessage());
            e.printStackTrace();
            System.exit(1);
        }
    }

    /**
     * Factory Method: Crea el tipo correcto de vehículo.
     * Esto es una variante del patrón Factory.
     */
    private Vehiculo crearVehiculo(String vin, String marca, String modelo,
                                    String tipo, double eficiencia) {
        switch (tipo) {
            case "Auto":
                return new Auto(vin, marca, modelo, eficiencia);
            case "SUV":
                return new SUV(vin, marca, modelo, eficiencia);
            case "Camioneta":
                return new Camioneta(vin, marca, modelo, eficiencia);
            default:
                throw new IllegalArgumentException("Tipo de vehículo desconocido: " + tipo);
        }
    }

    /**
     * Procesa una línea de viaje.
     * Formato: VIN,Modo,Dist1,Dist2,...,DistN
     */
    private void procesarLineaViaje(String linea) {
        String[] datos = linea.split(",");

        // Extraer VIN y modo
        String vin = datos[0].trim();
        String modoStr = datos[1].trim();

        // Buscar vehículo (O(1) gracias al HashMap)
        Vehiculo vehiculo = busquedaVIN.get(vin);
        if (vehiculo == null) {
            System.err.println("ADVERTENCIA: VIN no encontrado: " + vin);
            return;
        }

        // Crear estrategia según el modo
        ModoManejoStrategy modo = crearModo(modoStr);

        // Extraer distancias
        double[] distancias = new double[datos.length - 2];
        for (int i = 2; i < datos.length; i++) {
            distancias[i - 2] = Double.parseDouble(datos[i].trim());
        }

        // Procesar viaje (EVITA ciclo anidado - delegado al vehículo)
        vehiculo.procesarViaje(modo, distancias);
    }

    /**
     * Factory Method: Crea la estrategia correcta según el modo.
     */
    private ModoManejoStrategy crearModo(String modoStr) {
        switch (modoStr) {
            case "Eco":
                return new ModoEco();
            case "Normal":
                return new ModoNormal();
            case "Sport":
                return new ModoSport();
            default:
                throw new IllegalArgumentException("Modo desconocido: " + modoStr);
        }
    }

    /**
     * Muestra estadísticas de todos los vehículos usando el Visitor.
     * NO usa ciclos anidados.
     */
    public void mostrarEstadisticas() {
        VisitorVehiculo mostrador = new MostradorResultados();

        // Visitar cada vehículo (patrón Visitor)
        for (Vehiculo vehiculo : flota) {
            vehiculo.aceptar(mostrador);
        }
    }

    /**
     * Calcula y muestra el vehículo con mayor consumo por categoría.
     * NO usa ciclos anidados.
     */
    public void calcularMayorConsumoPorCategoria() {
        // HashMaps para almacenar el máximo por categoría
        HashMap<String, Vehiculo> maximos = new HashMap<>();

        // Un solo ciclo: recorrer flota
        for (Vehiculo vehiculo : flota) {
            String tipo = vehiculo.getTipo();

            // Si no existe o es mayor que el actual
            if (!maximos.containsKey(tipo) ||
                vehiculo.getConsumoTotal() > maximos.get(tipo).getConsumoTotal()) {
                maximos.put(tipo, vehiculo);
            }
        }

        // Mostrar resultados
        System.out.println("\nMayor consumo:");
        if (maximos.containsKey("Camioneta")) {
            Vehiculo v = maximos.get("Camioneta");
            System.out.printf("Camioneta: %s (%s litros)%n", v.getVIN(), v.getConsumoTotal());
        }
        if (maximos.containsKey("SUV")) {
            Vehiculo v = maximos.get("SUV");
            System.out.printf("SUV: %s (%s litros)%n", v.getVIN(), v.getConsumoTotal());
        }
        if (maximos.containsKey("Auto")) {
            Vehiculo v = maximos.get("Auto");
            System.out.printf("Auto: %s (%s litros)%n", v.getVIN(), v.getConsumoTotal());
        }
    }
}
```

---

## PASO 5: Clase Main

```java
/**
 * Clase principal para ejecutar el sistema Rent a Car.
 */
public class Main {
    public static void main(String[] args) {
        // Obtener instancia única del sistema (Singleton)
        Sistema sistema = Sistema.getInstance();

        // Leer archivo y procesar datos
        sistema.leerArchivo("fleet.txt");

        // Mostrar estadísticas de todos los vehículos
        sistema.mostrarEstadisticas();

        // Mostrar vehículos con mayor consumo por categoría
        sistema.calcularMayorConsumoPorCategoria();
    }
}
```

---

## PASO 6: Crear Archivo de Datos fleet.txt

Copia el archivo proporcionado en el examen. Ejemplo simplificado:

```
4
1HGBH41JXMN109186,Dodge,Ram 2500,Camioneta,6.8
WAUHF68P16A397756,Ford,F250,Camioneta,6.8
1FADP3K29EL223451,Ford,F150,Camioneta,8.75
KMHEC4A46CA012345,Mitsubishi,L200,Camioneta,9.45
1HGBH41JXMN109186,Sport,450,380,520,670,890,340,210,560
WAUHF68P16A397756,Normal,865,920,780,450,680,370
1FADP3K29EL223451,Eco,690,780,560,490,320,560,303
KMHEC4A46CA012345,Eco,870,690,560,490,320,560,175
```

---

## PASO 7: Compilar y Ejecutar

```bash
# Compilar todos los archivos
javac *.java

# Ejecutar
java Main
```

---

## PASO 8: Verificar Salida

La salida debe coincidir EXACTAMENTE con el formato del examen:

```
Dodge Ram 2500 CONSUMO: 664.56875 l ODOMETRO: 5020 km
Ford F250 CONSUMO: 715.4142857142857 l ODOMETRO: 4865 km
Ford F150 CONSUMO: 423.0944444444446 l ODOMETRO: 3703 km
Mitsubishi L200 CONSUMO: 387.8 l ODOMETRO: 3665 km

Mayor consumo:
Camioneta: WAUHF68P16A397756 (715.4142857142857 litros)
```

---

## ⚠️ ERRORES COMUNES A EVITAR

### Error 1: Confundir "10% menor consumo" con "10% menor eficiencia"

❌ **INCORRECTO:**
```java
// Modo Eco
return eficienciaNominal * 0.90;  // ¡ERROR! Esto empeora la eficiencia
```

✅ **CORRECTO:**
```java
// Modo Eco: consume 10% MENOS = eficiencia 10% MEJOR
return eficienciaNominal * 1.10;
```

**Explicación:** Si consume MENOS, significa que rinde MÁS kilómetros por litro.

---

### Error 2: Usar ciclos anidados

❌ **INCORRECTO:**
```java
for (Vehiculo v : flota) {
    for (Viaje viaje : viajes) {  // ¡CICLO ANIDADO!
        if (viaje.getVIN().equals(v.getVIN())) {
            v.procesarViaje(viaje);
        }
    }
}
```

✅ **CORRECTO:**
```java
// Usar HashMap para búsqueda O(1)
HashMap<String, Vehiculo> busqueda = new HashMap<>();
for (Vehiculo v : flota) {
    busqueda.put(v.getVIN(), v);
}

// Procesar viajes sin ciclo anidado
for (String lineaViaje : lineasViajes) {
    String vin = extraerVIN(lineaViaje);
    Vehiculo v = busqueda.get(vin);  // O(1) - sin ciclo
    v.procesarViaje(lineaViaje);
}
```

---

### Error 3: No implementar correctamente el Visitor (olvidar double dispatch)

❌ **INCORRECTO:**
```java
public class Auto extends Vehiculo {
    @Override
    public void aceptar(VisitorVehiculo visitor) {
        // ¡FALTA EL DOUBLE DISPATCH!
        // No hace nada
    }
}
```

✅ **CORRECTO:**
```java
public class Auto extends Vehiculo {
    @Override
    public void aceptar(VisitorVehiculo visitor) {
        visitor.visitarAuto(this);  // Double dispatch correcto
    }
}
```

---

### Error 4: No usar UNA SOLA lista

❌ **INCORRECTO:**
```java
class Sistema {
    private List<Auto> autos;
    private List<SUV> suvs;
    private List<Camioneta> camionetas;
}
```

✅ **CORRECTO:**
```java
class Sistema {
    private List<Vehiculo> flota;  // UNA SOLA lista polimórfica
}
```

---

### Error 5: No validar que el archivo existe

❌ **INCORRECTO:**
```java
Scanner scanner = new Scanner(new File("fleet.txt"));
// Si no existe, el programa crashea sin mensaje claro
```

✅ **CORRECTO:**
```java
try (Scanner scanner = new Scanner(new File("fleet.txt"))) {
    // ...
} catch (FileNotFoundException e) {
    System.err.println("ERROR: Archivo no encontrado");
    System.exit(1);
}
```

---

## 📖 CONCEPTOS APRENDIDOS

Al completar este ejercicio habrás dominado:

1. **Herencia y Polimorfismo:**
   - Clase abstracta Vehiculo
   - Subclases Auto, SUV, Camioneta
   - Lista polimórfica `List<Vehiculo>`

2. **Patrón Strategy:**
   - Interface `ModoManejoStrategy`
   - Tres implementaciones: ModoEco, ModoNormal, ModoSport
   - Cambio dinámico de comportamiento

3. **Patrón Visitor:**
   - Interface `VisitorVehiculo`
   - Double dispatch con `aceptar(visitor)`
   - Separación de operaciones de la estructura

4. **Patrón Singleton:**
   - Instancia única del Sistema
   - Constructor privado
   - Método `getInstance()`

5. **Factory Method (implícito):**
   - Creación de vehículos según tipo
   - Creación de modos según string

6. **File I/O:**
   - Lectura de archivo estructurado
   - Parsing de CSV
   - Manejo de excepciones

7. **Collections avanzadas:**
   - `ArrayList` para flota
   - `HashMap` para búsqueda rápida por VIN
   - Evitar ciclos anidados

8. **Arquitectura limpia:**
   - Separación de responsabilidades
   - Métodos auxiliares para evitar duplicación
   - Código legible y mantenible

---

## ✅ CHECKLIST DE DOMINIO

Puedes considerar que dominas este ejercicio cuando:

- [ ] Entiendes por qué Eco multiplica por 1.10 (no 0.90)
- [ ] Puedes explicar el flujo completo desde leer archivo hasta mostrar resultados
- [ ] Sabes por qué se usa HashMap en vez de ciclos anidados
- [ ] Puedes implementar el patrón Visitor de memoria
- [ ] Entiendes cómo funciona el double dispatch
- [ ] Puedes agregar un nuevo tipo de vehículo (ej: Moto) fácilmente
- [ ] Puedes agregar un nuevo modo de manejo (ej: Racing) fácilmente
- [ ] Puedes agregar un nuevo Visitor (ej: CalculadorMantenimiento) fácilmente
- [ ] Implementas la solución completa en menos de 2.5 horas
- [ ] Tu código compila sin errores y produce la salida correcta

---

## 🎓 VENTAJAS DE ESTA ARQUITECTURA

### Sin Patrones (enfoque ingenuo):

```java
// Código horrible con if-else gigantes
for (Vehiculo v : flota) {
    if (v.getTipo().equals("Auto")) {
        if (modo.equals("Eco")) {
            eficiencia = v.getEficiencia() * 1.10;
        } else if (modo.equals("Normal")) {
            eficiencia = v.getEficiencia();
        } else if (modo.equals("Sport")) {
            eficiencia = v.getEficiencia() * 0.75;
        }
        // Cálculos específicos de Auto...
    } else if (v.getTipo().equals("SUV")) {
        // Repetir todo para SUV...
    }
    // ... más duplicación
}
```

**Problemas:**
- Código duplicado
- Difícil de mantener
- Viola Open/Closed Principle
- Ciclos anidados

### Con Patrones (nuestra solución):

```java
// Código limpio y extensible
for (Vehiculo v : flota) {
    v.aceptar(visitor);  // Polimorfismo + Visitor
}
```

**Ventajas:**
- Sin duplicación
- Fácil agregar nuevos tipos
- Fácil agregar nuevas operaciones
- Sigue SOLID principles
- Sin ciclos anidados

---

## 🚀 DESAFIOS ADICIONALES

Si terminas antes de tiempo en el examen, intenta:

1. **GUI (puntaje extra):**
   - Mostrar resultados en JFrame con JTable
   - Botones para cargar archivo y calcular

2. **Visitor adicional:**
   - `VisitorEficienciaPromedio`: Calcula km/l promedio real
   - `VisitorCO2`: Calcula emisiones según consumo

3. **Exportar resultados:**
   - Guardar estadísticas en archivo CSV
   - Formato: VIN,Marca,Modelo,Tipo,Consumo,Odometro

4. **Validaciones:**
   - Detectar VINs duplicados
   - Validar que eficiencia > 0
   - Validar que distancias > 0

---

## 🔗 RELACIÓN CON EL EXAMEN

Este ejercicio es la **REPLICA EXACTA** del Problema 2 del examen (70% del puntaje).

**Similitudes:**
- ✅ Formato idéntico de archivo fleet.txt
- ✅ Mismos cálculos de eficiencia
- ✅ Mismos patrones requeridos (Strategy + Visitor + Singleton/Factory)
- ✅ Misma arquitectura con Sistema
- ✅ Misma restricción: NO ciclos anidados
- ✅ Mismo formato de salida

**Diferencias:**
- Ninguna significativa (solo datos diferentes)

**Conclusión:** Si dominas este ejercicio, dominas el 70% del examen.

---

## ⏱️ DISTRIBUCIÓN DE TIEMPO SUGERIDA (Examen 3 horas)

| Fase | Tiempo | Actividad |
|------|--------|-----------|
| 1 | 15 min | Leer enunciado completo 2 veces + planificar arquitectura |
| 2 | 30 min | Jerarquía Vehiculo + subclases |
| 3 | 20 min | Strategy Pattern (ModoManejo) |
| 4 | 25 min | Visitor Pattern |
| 5 | 40 min | Sistema (Singleton) + lectura archivo |
| 6 | 30 min | Procesamiento de viajes + cálculos |
| 7 | 10 min | Main + compilar |
| 8 | 20 min | Pruebas + corrección de errores |
| 9 | 10 min | Verificar salida + documentar código |

**Total:** 3 horas

---

## 📝 NOTAS FINALES

**Para aprobar el examen:**
1. Lee TODO el enunciado antes de programar
2. Dibuja la arquitectura en papel
3. Implementa paso a paso (no intentes hacer todo a la vez)
4. Compila frecuentemente
5. Prueba con datos pequeños primero
6. Verifica que la salida coincida EXACTAMENTE

**Criterios de evaluación típicos:**
- Herencia correcta: 10%
- Strategy implementado: 20%
- Visitor implementado: 20%
- Lectura de archivo: 15%
- Cálculos correctos: 20%
- Sin ciclos anidados: 10%
- Código limpio y compilable: 5%

---

**¡Este es el ejercicio más importante de todos! Practícalo hasta que puedas resolverlo en menos de 2.5 horas sin consultar referencias.**
