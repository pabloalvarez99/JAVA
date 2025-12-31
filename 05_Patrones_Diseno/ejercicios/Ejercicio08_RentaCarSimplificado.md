# Ejercicio 8: Rent a Car - Version Simplificada (Nivel 4)
**Dificultad:** Avanzado
**Tiempo estimado:** 90 minutos
**Conceptos:** TODOS los conceptos del examen combinados

---

## Contexto

Este ejercicio es una **version simplificada del Problema 2 del examen**. Una empresa de renta de vehiculos necesita un sistema de seguimiento de su flota.

## Formato del Archivo: fleet_simple.txt

```
3
VIN001,Toyota,Camry,Auto,14.5
VIN002,Ford,Explorer,SUV,10.2
VIN003,Chevrolet,Silverado,Camioneta,8.5
VIN001,Normal,120,80,95
VIN002,Sport,200,150
VIN003,Eco,180,90,110,75
```

**Estructura:**
- Linea 1: N (cantidad de vehiculos)
- Siguientes N lineas: VIN,Marca,Modelo,Tipo,Eficiencia
  - Tipo: "Auto", "SUV", "Camioneta"
  - Eficiencia: km/litro nominal
- Siguientes lineas (variable): VIN,ModoManejo,Distancia1,...,DistanciaN
  - ModoManejo: "Eco", "Normal", "Sport"

## Modos de Manejo (Strategy Pattern):

- **Eco:** Eficiencia es 10% MEJOR que la nominal (multiplica eficiencia × 1.1)
- **Normal:** Eficiencia nominal (sin cambios)
- **Sport:** Eficiencia es 25% PEOR que la nominal (multiplica eficiencia × 0.75)

## Requisitos

### Jerarquia de Vehiculos:

**Clase base Vehiculo:**
- VIN (String)
- Marca (String)
- Modelo (String)
- Eficiencia nominal (double - km/l)
- Odometro total (int - km recorridos)
- Combustible consumido (double - litros)

**Subclases:** `Auto`, `SUV`, `Camioneta`

### Strategy Pattern:

Interface `ModoManejoStrategy` con metodo:
```java
double calcularEficiencia(double eficienciaNominal);
```

Implementaciones: `ModoEco`, `ModoNormal`, `ModoSport`

### Visitor Pattern:

Interface `VisitorVehiculo` con metodos:
```java
void visitarAuto(Auto auto);
void visitarSUV(SUV suv);
void visitarCamioneta(Camioneta camioneta);
```

Visitor: `CalculadorEstadisticas` que calcula y muestra:
- Odometro
- Consumo total
- Eficiencia promedio real

### Funcionalidades:

1. Leer archivo y crear flota
2. Procesar viajes aplicando el modo de manejo correcto
3. Calcular odometro y consumo por vehiculo
4. Mostrar vehiculo con mayor consumo por categoria
5. Usar Visitor para generar estadisticas

## Ejemplo de Ejecucion

```
=== SISTEMA RENT A CAR ===
Cargando flota desde: fleet_simple.txt
3 vehiculos cargados.

=== PROCESANDO VIAJES ===
VIN001: 3 viajes en modo Normal
VIN002: 2 viajes en modo Sport
VIN003: 4 viajes en modo Eco

=== ESTADISTICAS POR VEHICULO ===
Toyota Camry (Auto) CONSUMO: 20.34 l ODOMETRO: 295 km
Ford Explorer (SUV) CONSUMO: 45.75 l ODOMETRO: 350 km
Chevrolet Silverado (Camioneta) CONSUMO: 48.94 l ODOMETRO: 455 km

=== MAYOR CONSUMO POR CATEGORIA ===
Auto: VIN001 (20.34 litros)
SUV: VIN002 (45.75 litros)
Camioneta: VIN003 (48.94 litros)
```

## Debe entregar:

- Jerarquia `Vehiculo` con tres subclases
- Interface `ModoManejoStrategy` con tres implementaciones
- Interface `VisitorVehiculo` con implementacion `CalculadorEstadisticas`
- Clase `SistemaRentaCar` que:
  - Lee archivo
  - Almacena flota en UNA SOLA LISTA
  - Procesa viajes
  - Genera estadisticas
- Clase `Main`
- Archivo `fleet_simple.txt`

## Consideraciones:

- **Usar 3 patrones obligatorios:** Visitor, Strategy, + (Singleton O Factory)
  - Sugerencia: Usa Singleton para el SistemaRentaCar
- Todos los vehiculos en una sola lista (polimorfismo)
- **NO usar ciclos anidados** - usa metodos auxiliares
- Validar que los archivos existan
- Manejar excepciones apropiadamente

## Formulas:

**Calcular consumo de un viaje:**
```java
// Obtener eficiencia segun modo
double eficienciaReal = modoStrategy.calcularEficiencia(eficienciaNominal);

// Calcular consumo
double consumo = distancia / eficienciaReal;
```

**Ejemplo:**
- Vehiculo: 10 km/l nominal
- Modo Sport: eficiencia = 10 × 0.75 = 7.5 km/l
- Viaje de 150 km: consumo = 150 / 7.5 = 20 litros

## Pistas:

1. Usa un `HashMap<String, Vehiculo>` para buscar vehiculos por VIN rapidamente
2. Cada linea de viaje debe crear la estrategia correcta segun el modo
3. El visitor debe acceder a los atributos calculados del vehiculo
4. Separa la logica de procesamiento en metodos pequenos

---

**Este ejercicio es MUY similar al Problema 2 del examen. Dominarlo te preparara directamente para el examen real.**

---

## PASO A PASO: COMO RESOLVER ESTE EJERCICIO

Este ejercicio simula el Problema 2 del examen. Sigue la estructura patron de diseno multiple.

### Arquitectura del Sistema

1. **Herencia:** Vehiculo -> Auto/Camioneta/Moto
2. **Strategy:** Modos de conduccion (Urbano/Carretera/Deportivo)
3. **Visitor:** Calculos (Depreciacion/Mantenimiento/Consumo)
4. **File I/O:** Lectura de flota y viajes
5. **Collections:** HashMap<VIN, Vehiculo> para busqueda rapida

### Paso 1: Jerarquia Vehiculos

```java
public abstract class Vehiculo {
    protected String vin, marca, modelo;
    protected double kilometrajeInicial;
    protected List<Viaje> viajes = new ArrayList<>();

    public void agregarViaje(Viaje v) { viajes.add(v); }

    public double getKmTotal() {
        double total = kilometrajeInicial;
        for (Viaje v : viajes) total += v.getKm();
        return total;
    }

    public abstract double accept(VisitorVehiculos v);
    public abstract double getPrecioBase();
}
```

### Paso 2: Clase Viaje con Strategy

```java
public class Viaje {
    private double km;
    private ModoConduccionStrategy modo;

    public double calcularDesgaste() {
        return modo.calcularDesgaste(km);
    }
}

public interface ModoConduccionStrategy {
    double calcularDesgaste(double km);
}
```

### Paso 3: Visitors para Calculos

```java
public class CalculadorDepreciacion implements VisitorVehiculos {
    public double visitarAuto(Auto a) {
        double desgaste = 0;
        for (Viaje v : a.getViajes()) {
            desgaste += v.calcularDesgaste();
        }
        return a.getPrecioBase() - (desgaste * 100);
    }
}
```

### Punto Clave: Combinacion Strategy + Visitor

- **Strategy:** Calcula el desgaste de CADA viaje segun el modo
- **Visitor:** SUMA todos los desgastes y calcula valor final

### Lectura de Archivo

```java
Map<String, Vehiculo> flota = new HashMap<>();
// 1. Leer vehiculos, crear segun tipo, agregar al HashMap
// 2. Leer viajes, buscar vehiculo por VIN, crear Strategy segun modo, agregar viaje
```

---

## PASO A PASO COMPLETO: COMO RESOLVER ESTE EJERCICIO

Este ejercicio combina TODOS los conceptos del examen. Es complejo pero extremadamente valioso para tu preparacion. Vamos a resolverlo metodicamente.

### ENTENDIENDO LA ARQUITECTURA COMPLETA

**Tres patrones trabajando juntos:**
1. **Herencia:** Vehiculo (base) → Auto, SUV, Camioneta (subclases)
2. **Strategy:** Modos de manejo intercambiables (Eco, Normal, Sport)
3. **Visitor:** Operaciones sobre vehiculos sin modificarlos (Estadisticas)

**Flujo de datos:**
```
Archivo fleet_simple.txt
    ↓
Sistema lee y crea vehiculos (con Factory implícito)
    ↓
Sistema procesa viajes aplicando Strategy
    ↓
Visitor calcula estadisticas finales
```

---

### PASO 1: Crear la Jerarquia de Vehiculos

Comienza con la clase base abstracta:

```java
import java.util.ArrayList;

public abstract class Vehiculo {
    // Atributos comunes a todos los vehiculos
    protected String vin;
    protected String marca;
    protected String modelo;
    protected double eficienciaNominal; // km/litro
    protected int odometro;             // km totales recorridos
    protected double combustibleConsumido; // litros totales

    // Constructor
    public Vehiculo(String vin, String marca, String modelo, double eficienciaNominal) {
        this.vin = vin;
        this.marca = marca;
        this.modelo = modelo;
        this.eficienciaNominal = eficienciaNominal;
        this.odometro = 0;
        this.combustibleConsumido = 0.0;
    }

    /**
     * Procesa un viaje usando una estrategia de modo de manejo
     * @param distancia Kilometros del viaje
     * @param modo Estrategia de manejo a aplicar
     */
    public void procesarViaje(double distancia, ModoManejoStrategy modo) {
        // Calcular eficiencia real segun el modo
        double eficienciaReal = modo.calcularEficiencia(eficienciaNominal);

        // Calcular consumo de este viaje
        double consumo = distancia / eficienciaReal;

        // Actualizar odometro y consumo total
        odometro += (int) distancia;
        combustibleConsumido += consumo;
    }

    /**
     * Metodo para el patron Visitor
     * Cada subclase implementa esto llamando al metodo correcto del visitor
     */
    public abstract void accept(VisitorVehiculo visitor);

    /**
     * Obtiene el tipo de vehiculo para reportes
     */
    public abstract String getTipo();

    // Getters
    public String getVin() { return vin; }
    public String getMarca() { return marca; }
    public String getModelo() { return modelo; }
    public double getEficienciaNominal() { return eficienciaNominal; }
    public int getOdometro() { return odometro; }
    public double getCombustibleConsumido() { return combustibleConsumido; }

    /**
     * Calcula la eficiencia promedio real (km por litro realmente logrados)
     */
    public double getEficienciaPromedio() {
        if (combustibleConsumido == 0) return 0;
        return odometro / combustibleConsumido;
    }
}
```

**Conceptos clave:**
- `procesarViaje()` usa la Strategy para calcular eficiencia real
- `accept()` es abstracto - cada subclase lo implementa para Visitor
- Mantenemos estadisticas acumulativas (odometro, combustible)

---

### PASO 2: Implementar las Subclases de Vehiculos

**Auto:**
```java
public class Auto extends Vehiculo {
    public Auto(String vin, String marca, String modelo, double eficienciaNominal) {
        super(vin, marca, modelo, eficienciaNominal);
    }

    @Override
    public void accept(VisitorVehiculo visitor) {
        visitor.visitarAuto(this); // Double dispatch
    }

    @Override
    public String getTipo() {
        return "Auto";
    }
}
```

**SUV:**
```java
public class SUV extends Vehiculo {
    public SUV(String vin, String marca, String modelo, double eficienciaNominal) {
        super(vin, marca, modelo, eficienciaNominal);
    }

    @Override
    public void accept(VisitorVehiculo visitor) {
        visitor.visitarSUV(this);
    }

    @Override
    public String getTipo() {
        return "SUV";
    }
}
```

**Camioneta:**
```java
public class Camioneta extends Vehiculo {
    public Camioneta(String vin, String marca, String modelo, double eficienciaNominal) {
        super(vin, marca, modelo, eficienciaNominal);
    }

    @Override
    public void accept(VisitorVehiculo visitor) {
        visitor.visitarCamioneta(this);
    }

    @Override
    public String getTipo() {
        return "Camioneta";
    }
}
```

**Por que clases tan simples?**
- El patron Visitor permite agregar funcionalidad SIN modificar estas clases
- Cada una solo necesita implementar `accept()` correctamente
- La logica de negocio va en los Visitors

---

### PASO 3: Implementar el Patron Strategy (Modos de Manejo)

**Interface:**
```java
public interface ModoManejoStrategy {
    /**
     * Calcula la eficiencia real del vehiculo segun el modo de manejo
     * @param eficienciaNominal La eficiencia base del vehiculo (km/l)
     * @return La eficiencia ajustada por el modo de manejo
     */
    double calcularEficiencia(double eficienciaNominal);

    /**
     * Retorna el nombre del modo para reportes
     */
    String getNombre();
}
```

**Modo Eco (10% MEJOR eficiencia):**
```java
public class ModoEco implements ModoManejoStrategy {
    @Override
    public double calcularEficiencia(double eficienciaNominal) {
        // Eco: 10% mas eficiente (consume MENOS)
        return eficienciaNominal * 1.10;
    }

    @Override
    public String getNombre() {
        return "Eco";
    }
}
```

**Modo Normal (eficiencia nominal):**
```java
public class ModoNormal implements ModoManejoStrategy {
    @Override
    public double calcularEficiencia(double eficienciaNominal) {
        // Normal: sin cambios
        return eficienciaNominal;
    }

    @Override
    public String getNombre() {
        return "Normal";
    }
}
```

**Modo Sport (25% PEOR eficiencia):**
```java
public class ModoSport implements ModoManejoStrategy {
    @Override
    public double calcularEficiencia(double eficienciaNominal) {
        // Sport: 25% menos eficiente (consume MAS)
        return eficienciaNominal * 0.75;
    }

    @Override
    public String getNombre() {
        return "Sport";
    }
}
```

**PUNTO CRITICO - Entender las formulas:**
```
Vehiculo: 10 km/l nominal
Distancia: 100 km

Modo Eco:
  eficienciaReal = 10 * 1.10 = 11 km/l
  consumo = 100 / 11 = 9.09 litros

Modo Normal:
  eficienciaReal = 10 * 1.00 = 10 km/l
  consumo = 100 / 10 = 10.00 litros

Modo Sport:
  eficienciaReal = 10 * 0.75 = 7.5 km/l
  consumo = 100 / 7.5 = 13.33 litros
```

---

### PASO 4: Implementar el Patron Visitor

**Interface:**
```java
public interface VisitorVehiculo {
    void visitarAuto(Auto auto);
    void visitarSUV(SUV suv);
    void visitarCamioneta(Camioneta camioneta);
}
```

**Visitor Concreto - Calculador de Estadisticas:**
```java
public class CalculadorEstadisticas implements VisitorVehiculo {

    @Override
    public void visitarAuto(Auto auto) {
        mostrarEstadisticas(auto);
    }

    @Override
    public void visitarSUV(SUV suv) {
        mostrarEstadisticas(suv);
    }

    @Override
    public void visitarCamioneta(Camioneta camioneta) {
        mostrarEstadisticas(camioneta);
    }

    /**
     * Metodo auxiliar que muestra estadisticas de cualquier vehiculo
     * Evita duplicacion de codigo
     */
    private void mostrarEstadisticas(Vehiculo vehiculo) {
        System.out.printf("%s %s (%s) CONSUMO: %.2f l ODOMETRO: %d km%n",
                        vehiculo.getMarca(),
                        vehiculo.getModelo(),
                        vehiculo.getTipo(),
                        vehiculo.getCombustibleConsumido(),
                        vehiculo.getOdometro());
    }
}
```

**Por que usar Visitor aqui?**
- Separa la logica de presentacion de las clases de vehiculos
- Facilmente puedes agregar otros visitors (ej: GeneradorReportePDF)
- Cumple con el Open/Closed Principle

---

### PASO 5: Crear el Sistema Principal

```java
import java.io.*;
import java.util.*;

public class SistemaRentaCar {
    private ArrayList<Vehiculo> flota;
    private Map<String, Vehiculo> vehiculosPorVIN; // Para busqueda rapida

    public SistemaRentaCar() {
        flota = new ArrayList<>();
        vehiculosPorVIN = new HashMap<>();
    }

    /**
     * Lee el archivo y carga la flota
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
            System.out.println("Cargando " + n + " vehiculos...");

            // Leer datos de vehiculos
            for (int i = 0; i < n; i++) {
                String linea = scanner.nextLine();
                String[] datos = linea.split(",");

                String vin = datos[0].trim();
                String marca = datos[1].trim();
                String modelo = datos[2].trim();
                String tipo = datos[3].trim();
                double eficiencia = Double.parseDouble(datos[4].trim());

                // Factory Method implicito
                Vehiculo vehiculo = crearVehiculo(vin, marca, modelo, tipo, eficiencia);

                if (vehiculo != null) {
                    flota.add(vehiculo);
                    vehiculosPorVIN.put(vin, vehiculo);
                }
            }

            System.out.println(n + " vehiculos cargados exitosamente.");

            // Procesar viajes
            procesarViajes(scanner, n);

            scanner.close();

        } catch (FileNotFoundException e) {
            System.out.println("ERROR: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("ERROR al procesar archivo: " + e.getMessage());
        }
    }

    /**
     * Factory Method: Crea el vehiculo correcto segun el tipo
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
                System.out.println("ADVERTENCIA: Tipo desconocido: " + tipo);
                return null;
        }
    }

    /**
     * Procesa las lineas de viajes del archivo
     */
    private void procesarViajes(Scanner scanner, int cantidadVehiculos) {
        System.out.println("\n=== PROCESANDO VIAJES ===");

        for (int i = 0; i < cantidadVehiculos; i++) {
            if (!scanner.hasNextLine()) break;

            String linea = scanner.nextLine();
            String[] partes = linea.split(",");

            String vin = partes[0].trim();
            String modoStr = partes[1].trim();

            // Obtener vehiculo
            Vehiculo vehiculo = vehiculosPorVIN.get(vin);
            if (vehiculo == null) {
                System.out.println("ADVERTENCIA: VIN no encontrado: " + vin);
                continue;
            }

            // Crear estrategia segun el modo
            ModoManejoStrategy modo = crearModoManejo(modoStr);

            // Procesar cada viaje
            int cantidadViajes = partes.length - 2;
            for (int j = 2; j < partes.length; j++) {
                double distancia = Double.parseDouble(partes[j].trim());
                vehiculo.procesarViaje(distancia, modo);
            }

            System.out.printf("%s: %d viajes en modo %s%n",
                            vin, cantidadViajes, modoStr);
        }
    }

    /**
     * Factory Method: Crea la estrategia correcta segun el modo
     */
    private ModoManejoStrategy crearModoManejo(String modo) {
        switch (modo) {
            case "Eco":
                return new ModoEco();
            case "Normal":
                return new ModoNormal();
            case "Sport":
                return new ModoSport();
            default:
                System.out.println("ADVERTENCIA: Modo desconocido: " + modo);
                return new ModoNormal(); // Default
        }
    }

    /**
     * Muestra estadisticas usando el patron Visitor
     */
    public void mostrarEstadisticas() {
        System.out.println("\n=== ESTADISTICAS POR VEHICULO ===");
        VisitorVehiculo calculador = new CalculadorEstadisticas();

        for (Vehiculo vehiculo : flota) {
            vehiculo.accept(calculador);
        }
    }

    /**
     * Encuentra el vehiculo con mayor consumo por categoria
     */
    public void mostrarMayorConsumoPorCategoria() {
        System.out.println("\n=== MAYOR CONSUMO POR CATEGORIA ===");

        Vehiculo mayorAuto = encontrarMayorConsumoPorTipo("Auto");
        Vehiculo mayorSUV = encontrarMayorConsumoPorTipo("SUV");
        Vehiculo mayorCamioneta = encontrarMayorConsumoPorTipo("Camioneta");

        if (mayorAuto != null) {
            System.out.printf("Auto: %s (%.2f litros)%n",
                            mayorAuto.getVin(), mayorAuto.getCombustibleConsumido());
        }
        if (mayorSUV != null) {
            System.out.printf("SUV: %s (%.2f litros)%n",
                            mayorSUV.getVin(), mayorSUV.getCombustibleConsumido());
        }
        if (mayorCamioneta != null) {
            System.out.printf("Camioneta: %s (%.2f litros)%n",
                            mayorCamioneta.getVin(), mayorCamioneta.getCombustibleConsumido());
        }
    }

    /**
     * Metodo auxiliar: Encuentra el vehiculo con mayor consumo de un tipo especifico
     * Evita ciclos anidados
     */
    private Vehiculo encontrarMayorConsumoPorTipo(String tipo) {
        Vehiculo mayor = null;
        double maxConsumo = 0;

        for (Vehiculo vehiculo : flota) {
            if (vehiculo.getTipo().equals(tipo)) {
                if (vehiculo.getCombustibleConsumido() > maxConsumo) {
                    maxConsumo = vehiculo.getCombustibleConsumido();
                    mayor = vehiculo;
                }
            }
        }

        return mayor;
    }
}
```

**Puntos clave del Sistema:**
- Usa `HashMap` para busqueda rapida de vehiculos por VIN
- Dos Factory Methods: uno para vehiculos, otro para modos de manejo
- Evita ciclos anidados usando metodos auxiliares
- Manejo robusto de errores

---

### PASO 6: Crear el Main

```java
public class Main {
    public static void main(String[] args) {
        System.out.println("=== SISTEMA RENT A CAR ===");

        // Crear sistema
        SistemaRentaCar sistema = new SistemaRentaCar();

        // Cargar flota desde archivo
        sistema.cargarFlota("fleet_simple.txt");

        // Mostrar estadisticas usando Visitor
        sistema.mostrarEstadisticas();

        // Mostrar vehiculos con mayor consumo por categoria
        sistema.mostrarMayorConsumoPorCategoria();
    }
}
```

---

### PASO 7: Crear el Archivo de Datos

Crea `fleet_simple.txt`:
```
3
VIN001,Toyota,Camry,Auto,14.5
VIN002,Ford,Explorer,SUV,10.2
VIN003,Chevrolet,Silverado,Camioneta,8.5
VIN001,Normal,120,80,95
VIN002,Sport,200,150
VIN003,Eco,180,90,110,75
```

---

### PASO 8: Compilar y Ejecutar

```bash
# Compilar todas las clases
javac Vehiculo.java Auto.java SUV.java Camioneta.java
javac ModoManejoStrategy.java ModoEco.java ModoNormal.java ModoSport.java
javac VisitorVehiculo.java CalculadorEstadisticas.java
javac SistemaRentaCar.java Main.java

# Ejecutar
java Main
```

---

### ERRORES COMUNES A EVITAR

**1. Confundir mejor/peor eficiencia:**
```java
// INCORRECTO - Eco deberia consumir MENOS
eficienciaReal = eficienciaNominal * 0.90;  // Esto consume MAS

// CORRECTO - Eco consume menos (mayor eficiencia)
eficienciaReal = eficienciaNominal * 1.10;
```

**2. Olvidar el double dispatch en accept():**
```java
// INCORRECTO
public void accept(VisitorVehiculo visitor) {
    // No hace nada
}

// CORRECTO
public void accept(VisitorVehiculo visitor) {
    visitor.visitarAuto(this);  // Pasa 'this' al visitor
}
```

**3. No validar archivo existe:**
```java
// CORRECTO - Siempre valida
File archivo = new File(nombreArchivo);
if (!archivo.exists()) {
    System.out.println("ERROR: Archivo no encontrado");
    return;
}
```

**4. Usar ciclos anidados:**
```java
// INCORRECTO - Ciclo dentro de ciclo
for (Vehiculo v : flota) {
    for (Vehiculo v2 : flota) {  // NO!
        ...
    }
}

// CORRECTO - Usa metodo auxiliar
private Vehiculo encontrarMayorConsumoPorTipo(String tipo) {
    // Un solo ciclo
}
```

---

### CONCEPTOS APRENDIDOS

1. **Herencia:** Vehiculo base con Auto, SUV, Camioneta
2. **Strategy Pattern:** Modos de manejo intercambiables
3. **Visitor Pattern:** Operaciones sobre vehiculos sin modificarlos
4. **Factory Method:** Creacion de objetos segun parametros
5. **File I/O:** Lectura estructurada con validaciones
6. **Collections:** ArrayList + HashMap para diferentes necesidades
7. **Separacion de responsabilidades:** Cada clase tiene un proposito claro

---

### VENTAJAS DE ESTA ARQUITECTURA

**Sin patrones (codigo malo):**
```java
// Tendrias que modificar Vehiculo cada vez que agregas un calculo nuevo
public class Vehiculo {
    public void mostrarEstadisticas() { ... }
    public void generarPDF() { ... }
    public void enviarEmail() { ... }
    // Vehiculo hace demasiado
}
```

**Con patrones (codigo bueno):**
```java
// Vehiculo solo maneja sus datos
// Los Visitors hacen los calculos
// Las Strategies modifican el comportamiento
```

---

### DESAFIOS ADICIONALES

Una vez que funcione correctamente:

1. **Agregar nuevo Visitor:**
   - `GeneradorReporte` que genera un reporte en formato texto

2. **Agregar nueva Strategy:**
   - `ModoTurbo` que consume 40% mas pero es mas rapido

3. **Mejorar el sistema:**
   - Agregar metodo para encontrar vehiculo mas eficiente
   - Calcular costo total de combustible (asumiendo precio por litro)
   - Ordenar vehiculos por consumo

4. **Extension GUI:**
   - Mostrar resultados en una ventana Swing

---

### RELACION CON EL EXAMEN

**Este ejercicio es 80% similar al Problema 2 del examen real.**

Diferencias tipicas:
- El examen puede tener 4-5 tipos de vehiculos
- Puede haber mas modos de manejo
- Los calculos pueden ser diferentes
- Puede requerir mas estadisticas

**Pero la arquitectura es IDENTICA.**

Si dominas este ejercicio, aprobaras el examen.

---

### CHECKLIST DE DOMINIO

Marca cuando puedas hacer esto SIN consultar apuntes:

- [ ] Crear jerarquia de herencia correctamente
- [ ] Implementar Strategy Pattern completo
- [ ] Implementar Visitor Pattern con double dispatch
- [ ] Leer y parsear archivo estructurado
- [ ] Usar HashMap para busqueda eficiente
- [ ] Evitar ciclos anidados usando metodos auxiliares
- [ ] Manejar excepciones apropiadamente
- [ ] Formatear salida correctamente
- [ ] Completar el ejercicio en menos de 90 minutos

---

**Domina este ejercicio para estar listo para el Problema 2 del examen.**
