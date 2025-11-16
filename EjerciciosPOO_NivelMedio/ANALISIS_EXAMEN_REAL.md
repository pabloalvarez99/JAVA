# ANALISIS DETALLADO DEL EXAMEN REAL - Prueba 2 POO

**Basado en**: Prueba 2 - POO (28 noviembre 2024)
**Archivo**: `materialPOO/Prueba 2 - POO (1).pdf`

---

## INDICE

1. [Estructura General](#estructura-general)
2. [Problema 1: Ruteo Detallado](#problema-1-ruteo-detallado)
3. [Problema 2: Rent a Car Detallado](#problema-2-rent-a-car-detallado)
4. [Estrategia de Resolucion](#estrategia-de-resolucion)
5. [Soluciones Paso a Paso](#soluciones-paso-a-paso)

---

## Estructura General

### Distribucion de Puntaje

| Problema | Puntaje | Tiempo Sugerido |
|----------|---------|-----------------|
| Problema 1: Ruteo GUI | 0.3 (30%) | 30-40 min |
| Problema 2: Rent a Car | 0.7 (70%) | 140-150 min |
| **TOTAL** | **1.0 (100%)** | **3 horas** |

### Patrones Obligatorios (Problema 2)

- **Visitor**: OBLIGATORIO
- **Strategy**: OBLIGATORIO
- **Singleton O Factory**: ELEGIR UNO

### Puntaje Extra

- **GUI**: Puntaje adicional si implementas interfaz grafica

---

## Problema 1: Ruteo Detallado

### Codigo a Rutear

El codigo implementa:
1. **Patron Singleton**: `Configurator.getInstance()`
2. **Patron Strategy**: Estrategias de layout (Horizontal vs Vertical)
3. **GUI con Swing**: JFrame, JPanel, JButton
4. **Validacion de RUT**: Basado en el 4to digito

### Analisis Linea por Linea

#### Main (lineas 6-12)

```java
public static void main(String[] args) {
    Configurator configurator = Configurator.getInstance(); // Singleton
    configurator.setStrategyBasedOnRut();                   // Pide RUT
    configurator.applyLayout();                             // Crea GUI
}
```

**Flujo**:
1. Obtiene instancia unica de `Configurator`
2. Llama a `setStrategyBasedOnRut()` que:
   - Pide RUT al usuario con `Scanner`
   - Valida formato (minimo 4 digitos)
   - Extrae 4to digito
   - Asigna estrategia segun el digito
3. Llama a `applyLayout()` que crea la ventana

#### Configurator (lineas 14-26)

```java
class Configurator {
    private static Configurator instance; // Singleton
    private LayoutStrategy strategy;

    private Configurator() {} // Constructor privado

    public static Configurator getInstance() {
        if (instance == null) {
            instance = new Configurator();
        }
        return instance;
    }
}
```

**Patron**: Singleton clasico

#### setStrategyBasedOnRut (lineas 28-39)

```java
public void setStrategyBasedOnRut() {
    int fourthDigit = askForFourthRutDigit();

    if (fourthDigit >= 0 && fourthDigit <= 5) {
        strategy = new HorizontalLayoutStrategy();
    } else if (fourthDigit >= 6 && fourthDigit <= 9) {
        strategy = new VerticalLayoutStrategy();
    } else {
        System.out.println("Digito invalido. Se usara layout horizontal por defecto.");
        strategy = new HorizontalLayoutStrategy();
    }
}
```

**Logica de Asignacion**:
- Digitos 0-5: `HorizontalLayoutStrategy`
- Digitos 6-9: `VerticalLayoutStrategy`
- Otro: Mensaje de error + `HorizontalLayoutStrategy`

#### askForFourthRutDigit (lineas 57-72)

```java
private int askForFourthRutDigit() {
    System.out.print("Ingresa tu RUT (sin puntos ni guion, ejemplo: 12345678-9): ");
    String rut = new java.util.Scanner(System.in).nextLine();

    if (rut.length() < 4) {
        throw new IllegalArgumentException("El RUT debe tener al menos 4 digitos.");
    }

    char fourthChar = rut.charAt(rut.length() - 5); // Cuarto digito de derecha a izquierda
    return Character.getNumericValue(fourthChar);
}
```

**CLAVE**: El "cuarto digito" es el cuarto desde la DERECHA (antes del guion).

**Ejemplo**:
- RUT: `12345678-9`
- Indice: `rut.length() - 5 = 9 - 5 = 4`
- Caracter en posicion 4: `5`
- Resultado: `5`

**IMPORTANTE**: Si tu RUT real es `20123456-7`, el 4to digito seria `3`.

#### applyLayout (lineas 41-55)

```java
public void applyLayout() {
    if (strategy == null) {
        System.out.println("Estrategia no configurada. Usa setStrategyBasedOnRut() primero.");
        return;
    }

    JFrame frame = new JFrame("Ventana con Layout");
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setSize(400, 400);

    JPanel panel = strategy.createLayout();
    frame.add(panel);

    frame.setVisible(true);
}
```

**Crea**:
- JFrame de 400x400
- JPanel usando la estrategia seleccionada
- `EXIT_ON_CLOSE`: Cierra la aplicacion al presionar X

#### HorizontalLayoutStrategy (lineas 74-80)

```java
public JPanel createLayout() {
    JPanel panel = new JPanel();
    panel.setLayout(new BoxLayout(panel, BoxLayout.X_AXIS)); // HORIZONTAL
    addButtons(panel);
    return panel;
}
```

**Layout**: `BoxLayout.X_AXIS` = Horizontal

#### VerticalLayoutStrategy (lineas 93-99)

```java
public JPanel createLayout() {
    JPanel panel = new JPanel();
    panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS)); // VERTICAL
    addButtons(panel);
    return panel;
}
```

**Layout**: `BoxLayout.Y_AXIS` = Vertical

#### addButtons (lineas 82-87 y 101-106)

```java
private void addButtons(JPanel panel) {
    for (int i = 1; i <= 5; i++) {
        panel.add(new JButton("Boton " + i));
    }
}
```

**Crea**: 5 botones numerados del 1 al 5

### Ruteo Completo con RUT Ejemplo

**Ejemplo**: Usuario ingresa RUT `12345678-9`

1. `main()` inicia
2. `getInstance()`: Crea instancia de Configurator
3. `setStrategyBasedOnRut()`:
   - `askForFourthRutDigit()`:
     - Pide RUT: `12345678-9`
     - Extrae posicion 4: `5`
     - Retorna: `5`
   - `5 >= 0 && 5 <= 5`: TRUE
   - Asigna: `strategy = new HorizontalLayoutStrategy()`
4. `applyLayout()`:
   - Crea JFrame "Ventana con Layout", 400x400
   - `strategy.createLayout()`: Crea JPanel horizontal
   - `addButtons()`: Agrega 5 botones horizontales
   - Muestra ventana

**Resultado Visual**:

```
┌──────────────────────────────────────┐
│    Ventana con Layout            [_][□][X]│
├──────────────────────────────────────┤
│                                      │
│  [Boton 1][Boton 2][Boton 3][Boton 4][Boton 5] │
│                                      │
│                                      │
└──────────────────────────────────────┘
        (Layout Horizontal)
```

### Preguntas del Examen

**Pregunta 1**: "Dibuje la interfaz grafica resultante al ejecutar el codigo y despues de haber ingresado su RUT"

**Respuesta**: Depende de tu RUT real. Calcula el 4to digito y dibuja horizontal (0-5) o vertical (6-9).

**Pregunta 2**: "Al presionar que boton aparece un mensaje por la pantalla?"

**Respuesta**: **NINGUN BOTON**. Los botones NO tienen `ActionListener` asociado, por lo tanto no hacen nada.

**Pregunta 3**: "Indique lo que sucede al presionar el boton X de la ventana principal"

**Respuesta**: **La aplicacion se cierra completamente** porque `setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE)`.

---

## Problema 2: Rent a Car Detallado

### Enunciado Resumido

**Objetivo**: Sistema de seguimiento de flota de vehiculos.

**Tipos de vehiculos**: Camioneta (Pickup), SUV, Auto (Car)

**Atributos**: VIN, marca, modelo, eficiencia (km/l)

**Modos de manejo** (Strategy):
- **Eco**: Eficiencia 10% MENOR que nominal (consume MAS)
- **Normal**: Eficiencia nominal
- **Sport**: Eficiencia 25% SUPERIOR que nominal (consume MAS)

**Calculos requeridos**:
1. Kilometraje total por vehiculo
2. Combustible total consumido por vehiculo
3. Vehiculo con mayor consumo POR CATEGORIA (Visitor)

### Formato del Archivo `fleet.txt`

```
N                                    <- Cantidad de vehiculos
VIN,Marca,Modelo,Tipo,Eficiencia     <- N lineas de vehiculos
...
VIN,Modo,Dist1,Dist2,...,DistN       <- Viajes (cantidad variable)
...
```

**Tipos de vehiculo**:
- `P`: Pickup (Camioneta)
- `S`: SUV
- `C`: Car (Auto)

**Modos de manejo**:
- `E`: Eco
- `N`: Normal
- `S`: Sport

### Ejemplo de Datos

```
3
1GYS3DEF8DR108608,Dodge,Ram 2500,P,8
1G6DV57V390564047,Mazda,CX-7,S,12
1N6AA0EC7DN505995,Chevrolet,Aveo,C,15
1GYS3DEF8DR108608,N,66,141,144
1G6DV57V390564047,S,36,30,116
1N6AA0EC7DN505995,E,72,175,151
```

**Interpretacion**:
- 3 vehiculos
- Primer vehiculo: Pickup Dodge Ram con eficiencia 8 km/l
- Segundo vehiculo: SUV Mazda CX-7 con eficiencia 12 km/l
- Tercer vehiculo: Car Chevrolet Aveo con eficiencia 15 km/l
- Primer viaje: Dodge Ram en modo Normal, 3 distancias (66, 141, 144 km)
- Segundo viaje: Mazda CX-7 en modo Sport, 3 distancias
- Tercer viaje: Chevrolet Aveo en modo Eco, 3 distancias

### Calculos

#### Viaje 1: Dodge Ram, Modo Normal, distancias [66, 141, 144]

```
Kilometraje total: 66 + 141 + 144 = 351 km
Eficiencia en modo Normal: 8 km/l (nominal)
Combustible: 351 / 8 = 43.875 litros
```

#### Viaje 2: Mazda CX-7, Modo Sport, distancias [36, 30, 116]

```
Kilometraje total: 36 + 30 + 116 = 182 km
Eficiencia en modo Sport: 12 * 1.25 = 15 km/l (25% MAS consumo)
Combustible: 182 / 15 = 12.133 litros
```

**ATENCION**: Sport aumenta el CONSUMO, no la eficiencia. La formula correcta es:
```
Consumo = distancia / (eficiencia / 1.25)
        = distancia / eficiencia * 1.25
```

O mas simple: dividir por la eficiencia ajustada.

#### Viaje 3: Chevrolet Aveo, Modo Eco, distancias [72, 175, 151]

```
Kilometraje total: 72 + 175 + 151 = 398 km
Eficiencia en modo Eco: 15 * 0.9 = 13.5 km/l (10% MENOS eficiente)
Combustible: 398 / 13.5 = 29.481 litros
```

### Arquitectura de la Solucion

#### Jerarquia de Clases

```
Vehicle (abstract)
├─ Car
├─ SUV
└─ Pickup
```

**Atributos de Vehicle**:
- `String registration` (VIN)
- `String make` (marca)
- `String model` (modelo)
- `int efficiency` (eficiencia nominal)
- `double gasUsage` (acumulador de combustible)
- `long odo` (odometro, acumulador de distancia)
- `DrivingStrategy drivingMode` (estrategia actual)

#### Patron Strategy

```
DrivingStrategy (interface)
├─ EcoMode
├─ NormalMode
└─ SportMode
```

**Metodo**: `void drive(Vehicle v, int distance)`

**Implementacion de EcoMode**:
```java
public void drive(Vehicle v, int distance) {
    double adjustedEfficiency = v.getEfficiency() * 0.9; // 10% menos
    double gas = distance / adjustedEfficiency;
    v.updateGasUsage(gas);
    v.updateOdo(distance);
}
```

**Implementacion de NormalMode**:
```java
public void drive(Vehicle v, int distance) {
    double gas = distance / v.getEfficiency();
    v.updateGasUsage(gas);
    v.updateOdo(distance);
}
```

**Implementacion de SportMode**:
```java
public void drive(Vehicle v, int distance) {
    double adjustedEfficiency = v.getEfficiency() / 1.25; // 25% mas consumo
    double gas = distance / adjustedEfficiency;
    v.updateGasUsage(gas);
    v.updateOdo(distance);
}
```

#### Patron Visitor

```
Visitor (interface)
├─ UsageVisitor
```

**Metodos de Visitor**:
```java
void visit(Car c);
void visit(SUV s);
void visit(Pickup p);
```

**Implementacion de UsageVisitor**:
```java
public class UsageVisitor implements Visitor {
    double maxCarUsage, maxPickupUsage, maxSUVUsage;
    String VINCarUsage, VINPickupUsage, VINSUVUsage;

    @Override
    public void visit(Car v) {
        if (v.getGasUsage() > maxCarUsage) {
            maxCarUsage = v.getGasUsage();
            VINCarUsage = v.getRegistration();
        }
    }

    // Similar para SUV y Pickup

    public String showInfo() {
        return "Mayor consumo: \n"
            + "Camioneta: " + VINPickupUsage + " (" + maxPickupUsage + " litros)\n"
            + "SUV: " + VINSUVUsage + " (" + maxSUVUsage + " litros)\n"
            + "Auto: " + VINCarUsage + " (" + maxCarUsage + " litros)";
    }
}
```

#### Sistema

```
FleetSystem (interface)
└─ SystemImpl
```

**Metodos**:
```java
void registerVehicle(String[] parts);
void addTrip(String[] parts);
String showStats();
String maxUsage();
```

### Lectura del Archivo

```java
public static void readFile(FleetSystem s) throws IOException {
    Scanner scanner = new Scanner(new File("fleet.txt"));

    // Leer cantidad de vehiculos
    int fleetCount = Integer.parseInt(scanner.nextLine());

    // Registrar vehiculos
    for (int i = 0; i < fleetCount; i++) {
        String line = scanner.nextLine();
        String[] parts = line.split(",");
        s.registerVehicle(parts);
    }

    // Procesar viajes
    while (scanner.hasNext()) {
        String line = scanner.nextLine();
        String[] parts = line.split(",");
        s.addTrip(parts);
    }

    scanner.close();
}
```

### Implementacion de registerVehicle

```java
public void registerVehicle(String[] parts) {
    // parts[0] = VIN
    // parts[1] = Marca
    // parts[2] = Modelo
    // parts[3] = Tipo (P/S/C)
    // parts[4] = Eficiencia

    String vin = parts[0];
    String make = parts[1];
    String model = parts[2];
    String type = parts[3];
    int efficiency = Integer.parseInt(parts[4]);

    Vehicle v;
    switch (type) {
        case "P":
            v = new Pickup(vin, make, model, efficiency);
            break;
        case "S":
            v = new SUV(vin, make, model, efficiency);
            break;
        case "C":
            v = new Car(vin, make, model, efficiency);
            break;
        default:
            throw new IllegalArgumentException("Tipo desconocido: " + type);
    }

    vehicles.add(v);
}
```

### Implementacion de addTrip

```java
public void addTrip(String[] parts) {
    // parts[0] = VIN
    // parts[1] = Modo (E/N/S)
    // parts[2..n] = Distancias

    String vin = parts[0];
    String mode = parts[1];

    // Buscar vehiculo por VIN
    Vehicle vehicle = null;
    for (Vehicle v : vehicles) {
        if (v.checkRegistration(vin)) {
            vehicle = v;
            break;
        }
    }

    if (vehicle == null) {
        throw new IllegalArgumentException("Vehiculo no encontrado: " + vin);
    }

    // Setear estrategia segun modo
    DrivingStrategy strategy;
    switch (mode) {
        case "E":
            strategy = new EcoMode();
            break;
        case "N":
            strategy = new NormalMode();
            break;
        case "S":
            strategy = new SportMode();
            break;
        default:
            throw new IllegalArgumentException("Modo desconocido: " + mode);
    }

    vehicle.setDrivingMode(strategy);

    // Procesar cada distancia
    for (int i = 2; i < parts.length; i++) {
        int distance = Integer.parseInt(parts[i]);
        vehicle.calculateTrip(distance);
    }
}
```

---

## Estrategia de Resolucion

### Orden Recomendado

1. **Crear jerarquia Vehicle** (15 min)
   - Clase abstracta Vehicle
   - Clases Car, SUV, Pickup

2. **Implementar DrivingStrategy** (15 min)
   - Interface
   - 3 implementaciones

3. **Implementar Visitor** (20 min)
   - Interface Visitor
   - UsageVisitor

4. **Implementar Sistema** (20 min)
   - Interface FleetSystem
   - SystemImpl

5. **Main y lectura** (15 min)
   - readFile()
   - Mostrar stats
   - Aplicar visitor

6. **Testing** (15 min)
   - Comparar con salida esperada

---

## Soluciones Paso a Paso

### Codigo Completo de Vehicle

```java
public abstract class Vehicle {
    private String registration, make, model;
    private double gasUsage;
    private long odo;
    private int efficiency;
    private DrivingStrategy drivingMode;

    public Vehicle(String registration, String make, String model, int efficiency) {
        this.registration = registration;
        this.make = make;
        this.model = model;
        this.efficiency = efficiency;
        this.gasUsage = 0;
        this.odo = 0;
    }

    public abstract void accept(Visitor v);

    public void setDrivingMode(DrivingStrategy mode) {
        this.drivingMode = mode;
    }

    public void calculateTrip(int distance) {
        if (drivingMode == null) {
            throw new IllegalStateException("Modo de manejo no configurado");
        }
        drivingMode.drive(this, distance);
    }

    public void updateGasUsage(double gas) {
        this.gasUsage += gas;
    }

    public void updateOdo(long distance) {
        this.odo += distance;
    }

    // Getters
    public String getRegistration() { return registration; }
    public String getMake() { return make; }
    public String getModel() { return model; }
    public int getEfficiency() { return efficiency; }
    public double getGasUsage() { return gasUsage; }
    public long getOdo() { return odo; }

    public boolean checkRegistration(String vin) {
        return registration.equals(vin);
    }

    @Override
    public String toString() {
        return make + " " + model + " CONSUMO: " + gasUsage + " l ODOMETRO: " + odo + " km";
    }
}
```

### Codigo de Car, SUV, Pickup

```java
public class Car extends Vehicle {
    public Car(String vin, String make, String model, int efficiency) {
        super(vin, make, model, efficiency);
    }

    @Override
    public void accept(Visitor v) {
        v.visit(this);
    }
}

public class SUV extends Vehicle {
    public SUV(String vin, String make, String model, int efficiency) {
        super(vin, make, model, efficiency);
    }

    @Override
    public void accept(Visitor v) {
        v.visit(this);
    }
}

public class Pickup extends Vehicle {
    public Pickup(String vin, String make, String model, int efficiency) {
        super(vin, make, model, efficiency);
    }

    @Override
    public void accept(Visitor v) {
        v.visit(this);
    }
}
```

---

## Checklist Final

### Para Problema 1 (Ruteo)
- [ ] Identificar patron Singleton
- [ ] Identificar patron Strategy
- [ ] Calcular 4to digito del RUT correctamente
- [ ] Determinar estrategia segun digito
- [ ] Dibujar GUI con orientacion correcta
- [ ] Responder preguntas con fundamento

### Para Problema 2 (Rent a Car)
- [ ] Jerarquia Vehicle con 3 tipos
- [ ] DrivingStrategy con 3 modos
- [ ] Formulas de consumo correctas
- [ ] Visitor para max consumo por categoria
- [ ] Sistema con interface
- [ ] Lectura correcta del archivo
- [ ] Salida formateada similar al ejemplo
- [ ] Codigo compila y ejecuta
- [ ] Exportar como .zip

---

**Tiempo de estudio de este analisis**: 45-60 minutos
**Relee antes del examen**: 20 minutos
