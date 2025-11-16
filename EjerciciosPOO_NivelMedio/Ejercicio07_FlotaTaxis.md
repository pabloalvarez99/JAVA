# Ejercicio 7: Sistema de Flota de Taxis (Nivel 3)
**Dificultad:** Medio-Avanzado
**Tiempo estimado:** 90 minutos
**Conceptos:** File I/O, Strategy, Visitor, Collections

---

## Contexto

Una empresa de taxis necesita un sistema para gestionar su flota y calcular ganancias. Los taxis tienen diferentes tarifas segun su categoria y los calculos varian segun el metodo aplicado.

## Formato del Archivo: flota.txt

```
4
T001,Toyota,Prius,Hibrido,15.5
T002,Nissan,Sentra,Estandar,18.2
T003,Toyota,Corolla,Estandar,17.8
T004,Tesla,Model 3,Electrico,12.3
T001,25,30,15,40
T002,35,20,25,30,10
T003,40,35,28
T004,50,45,38,42,35,28
```

**Estructura:**
- Primera linea: N (cantidad de taxis)
- Siguientes N lineas: ID,Marca,Modelo,Categoria,ConsumoKmL
  - Categoria: "Estandar", "Hibrido", "Electrico"
  - Consumo: km/litro para Estandar e Hibrido, km/kWh para Electrico
- Siguientes N lineas (variable): ID,Distancia1,Distancia2,...,DistanciaN
  - Cada distancia es un viaje en kilometros

## Requisitos

### Jerarquia de Taxis:

**Clase base Taxi:**
- ID (String)
- Marca (String)
- Modelo (String)
- Consumo (double)
- Lista de viajes realizados (ArrayList<Double>)

**Subclases:**
- `TaxiEstandar`: consume gasolina ($1.50/litro)
- `TaxiHibrido`: consume gasolina ($1.50/litro) pero 20% mas eficiente
- `TaxiElectrico`: consume electricidad ($0.12/kWh)

### Strategy Pattern - Tarifas:

**Interface TarifaStrategy** con dos implementaciones:

**1. TarifaDiurna:**
- Estandar: $0.80 por km
- Hibrido: $0.90 por km
- Electrico: $1.00 por km

**2. TarifaNocturna:**
- Estandar: $1.20 por km
- Hibrido: $1.35 por km
- Electrico: $1.50 por km

### Visitor Pattern - Calculos:

**Interface VisitorCalculos** con dos visitors:

**1. CalculadorGanancias:**
- Calcula ganancia total usando la tarifa actual
- Formula: suma(distancia × tarifa) para todos los viajes

**2. CalculadorCostos:**
- Calcula costo de combustible/electricidad
- TaxiEstandar: suma(distancia) / consumo × $1.50
- TaxiHibrido: suma(distancia) / (consumo × 1.2) × $1.50
- TaxiElectrico: suma(distancia) / consumo × $0.12

### Funcionalidades:

1. Leer archivo y crear taxis
2. Calcular kilometraje total por taxi
3. Calcular ganancias (con tarifa diurna y nocturna)
4. Calcular costos de operacion
5. Calcular ganancia neta (ganancias - costos)
6. Taxi mas rentable de la flota

## Ejemplo de Ejecucion

```
=== CARGANDO FLOTA ===
Archivo: flota.txt
4 taxis cargados exitosamente.

=== RESUMEN DE FLOTA ===
[T001] Toyota Prius (Hibrido) - 15.5 km/l
Viajes: [25, 30, 15, 40] - Total: 110 km

[T002] Nissan Sentra (Estandar) - 18.2 km/l
Viajes: [35, 20, 25, 30, 10] - Total: 120 km

[T003] Toyota Corolla (Estandar) - 17.8 km/l
Viajes: [40, 35, 28] - Total: 103 km

[T004] Tesla Model 3 (Electrico) - 12.3 km/kWh
Viajes: [50, 45, 38, 42, 35, 28] - Total: 238 km

=== ANALISIS CON TARIFA DIURNA ===
[T001] Ganancias: $99.00 | Costos: $7.44 | Neto: $91.56
[T002] Ganancias: $96.00 | Costos: $9.89 | Neto: $86.11
[T003] Ganancias: $82.40 | Costos: $8.69 | Neto: $73.71
[T004] Ganancias: $238.00 | Costos: $2.32 | Neto: $235.68

Ganancia total flota: $515.40
Costo total flota: $28.34
Ganancia neta total: $487.06

=== ANALISIS CON TARIFA NOCTURNA ===
[T001] Ganancias: $148.50 | Costos: $7.44 | Neto: $141.06
[T002] Ganancias: $144.00 | Costos: $9.89 | Neto: $134.11
[T003] Ganancias: $123.60 | Costos: $8.69 | Neto: $114.91
[T004] Ganancias: $357.00 | Costos: $2.32 | Neto: $354.68

Ganancia total flota: $773.10
Costo total flota: $28.34
Ganancia neta total: $744.76

=== TAXI MAS RENTABLE ===
Tarifa Diurna: [T004] Tesla Model 3 ($235.68 neto)
Tarifa Nocturna: [T004] Tesla Model 3 ($354.68 neto)
```

## Debe entregar:

- Jerarquia de clases `Taxi` con subclases
- Interface `TarifaStrategy` con `TarifaDiurna` y `TarifaNocturna`
- Interface `VisitorCalculos` con `CalculadorGanancias` y `CalculadorCostos`
- Clase `SistemaFlota` que:
  - Lee el archivo
  - Gestiona la lista de taxis
  - Aplica estrategias y visitors
  - Genera estadisticas
- Clase `Main`
- Archivo `flota.txt` de prueba

## Consideraciones:

- **Usar TRES patrones:** Herencia + Strategy + Visitor
- Validar que el archivo exista
- Manejar excepciones apropiadamente
- Los taxis hibridos son 20% mas eficientes (consumen menos)
- Evitar ciclos anidados
- Formatear numeros a 2 decimales

## Formulas Importantes:

**Costo Gasolina (Estandar):**
```
costoTotal = (kilometraje / kmPorLitro) * 1.50
```

**Costo Gasolina (Hibrido - 20% mas eficiente):**
```
costoTotal = (kilometraje / (kmPorLitro * 1.2)) * 1.50
```

**Costo Electricidad:**
```
costoTotal = (kilometraje / kmPorKWh) * 0.12
```

---

**Este ejercicio combina multiples conceptos del examen. Es uno de los mas importantes.**

---

## PASO A PASO: COMO RESOLVER ESTE EJERCICIO

Este ejercicio combina TRES patrones de diseno. Es complejo pero sigue una estructura clara.

### PASO 1: Arquitectura General

Necesitas combinar:
1. **Herencia:** TaxiEstandar, TaxiHibrido, TaxiElectrico extienden Taxi
2. **Strategy:** Diferentes tarifas (Diurna/Nocturna) intercambiables
3. **Visitor:** Diferentes calculos (Ganancias/Costos) sobre los taxis

### PASO 2: Crear Jerarquia de Taxis

```java
// Clase abstracta base
public abstract class Taxi {
    protected String id;
    protected String marca;
    protected String modelo;
    protected double consumo;
    protected ArrayList<Double> viajes;
    protected TarifaStrategy tarifa;  // Strategy

    public Taxi(String id, String marca, String modelo, double consumo) {
        this.id = id;
        this.marca = marca;
        this.modelo = modelo;
        this.consumo = consumo;
        this.viajes = new ArrayList<>();
    }

    public void setTarifa(TarifaStrategy tarifa) {
        this.tarifa = tarifa;
    }

    public void agregarViaje(double distancia) {
        viajes.add(distancia);
    }

    public double getTotalKilometros() {
        double total = 0;
        for (double km : viajes) {
            total += km;
        }
        return total;
    }

    // Metodo para Visitor pattern
    public abstract double accept(VisitorCalculos visitor);

    // Metodo abstracto - cada tipo calcula diferente
    public abstract double calcularCostoCombustible();

    // Getters
    public String getId() { return id; }
    public double getConsumo() { return consumo; }
    public ArrayList<Double> getViajes() { return viajes; }
    public TarifaStrategy getTarifa() { return tarifa; }
}
```

### PASO 3: Implementar Subclases de Taxi

```java
public class TaxiEstandar extends Taxi {
    public TaxiEstandar(String id, String marca, String modelo, double consumo) {
        super(id, marca, modelo, consumo);
    }

    @Override
    public double calcularCostoCombustible() {
        double totalKm = getTotalKilometros();
        return (totalKm / consumo) * 1.50;
    }

    @Override
    public double accept(VisitorCalculos visitor) {
        return visitor.visitarEstandar(this);
    }
}

public class TaxiHibrido extends Taxi {
    public TaxiHibrido(String id, String marca, String modelo, double consumo) {
        super(id, marca, modelo, consumo);
    }

    @Override
    public double calcularCostoCombustible() {
        double totalKm = getTotalKilometros();
        // 20% mas eficiente
        return (totalKm / (consumo * 1.2)) * 1.50;
    }

    @Override
    public double accept(VisitorCalculos visitor) {
        return visitor.visitarHibrido(this);
    }
}

public class TaxiElectrico extends Taxi {
    public TaxiElectrico(String id, String marca, String modelo, double consumo) {
        super(id, marca, modelo, consumo);
    }

    @Override
    public double calcularCostoCombustible() {
        double totalKm = getTotalKilometros();
        return (totalKm / consumo) * 0.12;  // Electricidad
    }

    @Override
    public double accept(VisitorCalculos visitor) {
        return visitor.visitarElectrico(this);
    }
}
```

### PASO 4: Implementar Strategy Pattern (Tarifas)

```java
public interface TarifaStrategy {
    double calcularTarifa(Taxi taxi);
}

public class TarifaDiurna implements TarifaStrategy {
    @Override
    public double calcularTarifa(Taxi taxi) {
        double totalKm = taxi.getTotalKilometros();

        if (taxi instanceof TaxiEstandar) {
            return totalKm * 0.80;
        } else if (taxi instanceof TaxiHibrido) {
            return totalKm * 0.90;
        } else if (taxi instanceof TaxiElectrico) {
            return totalKm * 1.00;
        }
        return 0;
    }
}

public class TarifaNocturna implements TarifaStrategy {
    @Override
    public double calcularTarifa(Taxi taxi) {
        double totalKm = taxi.getTotalKilometros();

        if (taxi instanceof TaxiEstandar) {
            return totalKm * 1.20;
        } else if (taxi instanceof TaxiHibrido) {
            return totalKm * 1.35;
        } else if (taxi instanceof TaxiElectrico) {
            return totalKm * 1.50;
        }
        return 0;
    }
}
```

### PASO 5: Implementar Visitor Pattern (Calculos)

```java
public interface VisitorCalculos {
    double visitarEstandar(TaxiEstandar taxi);
    double visitarHibrido(TaxiHibrido taxi);
    double visitarElectrico(TaxiElectrico taxi);
}

public class CalculadorGanancias implements VisitorCalculos {
    @Override
    public double visitarEstandar(TaxiEstandar taxi) {
        return taxi.getTarifa().calcularTarifa(taxi);
    }

    @Override
    public double visitarHibrido(TaxiHibrido taxi) {
        return taxi.getTarifa().calcularTarifa(taxi);
    }

    @Override
    public double visitarElectrico(TaxiElectrico taxi) {
        return taxi.getTarifa().calcularTarifa(taxi);
    }
}

public class CalculadorCostos implements VisitorCalculos {
    @Override
    public double visitarEstandar(TaxiEstandar taxi) {
        return taxi.calcularCostoCombustible();
    }

    @Override
    public double visitarHibrido(TaxiHibrido taxi) {
        return taxi.calcularCostoCombustible();
    }

    @Override
    public double visitarElectrico(TaxiElectrico taxi) {
        return taxi.calcularCostoCombustible();
    }
}
```

### PASO 6: Sistema de Gestion con Lectura de Archivo

```java
import java.io.*;
import java.util.*;

public class SistemaFlotaTaxis {
    private ArrayList<Taxi> flota;

    public SistemaFlotaTaxis() {
        flota = new ArrayList<>();
    }

    public void cargarFlota(String archivo) {
        try (Scanner sc = new Scanner(new File(archivo))) {
            int n = Integer.parseInt(sc.nextLine().trim());

            // Leer datos de taxis
            Map<String, Taxi> mapaTaxis = new HashMap<>();
            for (int i = 0; i < n; i++) {
                String linea = sc.nextLine();
                String[] datos = linea.split(",");

                String id = datos[0].trim();
                String marca = datos[1].trim();
                String modelo = datos[2].trim();
                String categoria = datos[3].trim();
                double consumo = Double.parseDouble(datos[4].trim());

                Taxi taxi;
                if (categoria.equals("Estandar")) {
                    taxi = new TaxiEstandar(id, marca, modelo, consumo);
                } else if (categoria.equals("Hibrido")) {
                    taxi = new TaxiHibrido(id, marca, modelo, consumo);
                } else {
                    taxi = new TaxiElectrico(id, marca, modelo, consumo);
                }

                mapaTaxis.put(id, taxi);
                flota.add(taxi);
            }

            // Leer viajes
            for (int i = 0; i < n; i++) {
                String linea = sc.nextLine();
                String[] partes = linea.split(",");
                String id = partes[0].trim();
                Taxi taxi = mapaTaxis.get(id);

                for (int j = 1; j < partes.length; j++) {
                    double distancia = Double.parseDouble(partes[j].trim());
                    taxi.agregarViaje(distancia);
                }
            }

        } catch (FileNotFoundException e) {
            System.out.println("Error: Archivo no encontrado");
        }
    }

    public void establecerTarifa(TarifaStrategy tarifa) {
        for (Taxi taxi : flota) {
            taxi.setTarifa(tarifa);
        }
    }

    public void mostrarReporte(VisitorCalculos visitor, String concepto) {
        System.out.printf("\n=== %s ===%n", concepto.toUpperCase());
        double total = 0;
        for (Taxi taxi : flota) {
            double valor = taxi.accept(visitor);
            System.out.printf("[%s] %.2f km - $%.2f%n",
                            taxi.getId(), taxi.getTotalKilometros(), valor);
            total += valor;
        }
        System.out.printf("TOTAL: $%.2f%n", total);
    }
}
```

### PASO 7: Main con Demostracion Completa

```java
public class Main {
    public static void main(String[] args) {
        SistemaFlotaTaxis sistema = new SistemaFlotaTaxis();
        sistema.cargarFlota("flota.txt");

        // Strategy: Establecer tarifa diurna
        sistema.establecerTarifa(new TarifaDiurna());

        // Visitor: Calcular ganancias con tarifa diurna
        sistema.mostrarReporte(new CalculadorGanancias(), "Ganancias Diurnas");

        // Strategy: Cambiar a tarifa nocturna
        sistema.establecerTarifa(new TarifaNocturna());

        // Visitor: Calcular ganancias con tarifa nocturna
        sistema.mostrarReporte(new CalculadorGanancias(), "Ganancias Nocturnas");

        // Visitor: Calcular costos de combustible
        sistema.mostrarReporte(new CalculadorCostos(), "Costos de Combustible");
    }
}
```

### CONCEPTOS CLAVE

1. **Herencia:** Jerarquia Taxi -> TaxiEstandar/Hibrido/Electrico
2. **Strategy:** Tarifas intercambiables en tiempo de ejecucion
3. **Visitor:** Operaciones externas sobre la jerarquia de taxis
4. **File I/O:** Lectura estructurada con Scanner
5. **Collections:** ArrayList para flota, HashMap para busqueda rapida por ID

### PUNTOS CRITICOS

- **Factory en carga:** El if-else que crea taxis segun categoria es un Factory Method implicito
- **Combinacion Strategy + Visitor:** El visitor de ganancias usa la strategy actual
- **Eficiencia hibrida:** Multiplica consumo por 1.2 (consume MENOS por km)

---

**Dominar la combinacion de patrones es esencial para el examen.**

---

## 🎓 VENTAJAS DE ESTA ARQUITECTURA

### Sin patrones de diseño (enfoque ingenuo):

```java
// CODIGO MALO: Todo mezclado, sin patrones
public class Taxi {
    private String id;
    private String tipo;  // "estandar", "hibrido", "electrico"
    private double consumo;
    private ArrayList<Double> viajes;

    // PROBLEMA 1: If-else gigante para cada calculo
    public double calcularGanancias(String tipoCobro) {
        double total = 0;
        for (double km : viajes) {
            // If anidados horribles
            if (tipoCobro.equals("diurno")) {
                if (tipo.equals("estandar")) {
                    total += km * 0.80;
                } else if (tipo.equals("hibrido")) {
                    total += km * 0.90;
                } else if (tipo.equals("electrico")) {
                    total += km * 1.00;
                }
            } else if (tipoCobro.equals("nocturno")) {
                if (tipo.equals("estandar")) {
                    total += km * 1.20;
                } else if (tipo.equals("hibrido")) {
                    total += km * 1.35;
                } else if (tipo.equals("electrico")) {
                    total += km * 1.50;
                }
            }
        }
        return total;
    }

    // PROBLEMA 2: Mas if-else para costos
    public double calcularCostos() {
        double totalKm = 0;
        for (double km : viajes) {
            totalKm += km;
        }

        if (tipo.equals("estandar")) {
            return (totalKm / consumo) * 1.50;
        } else if (tipo.equals("hibrido")) {
            return (totalKm / (consumo * 1.2)) * 1.50;
        } else if (tipo.equals("electrico")) {
            return (totalKm / consumo) * 0.12;
        }
        return 0;
    }

    // PROBLEMA 3: Datos hardcodeados
    // No hay lectura de archivo - todo en el codigo
}

// En Main.java - horror absoluto
public class Main {
    public static void main(String[] args) {
        ArrayList<Taxi> taxis = new ArrayList<>();

        // PROBLEMA 4: Crear taxis manualmente
        Taxi t1 = new Taxi("T001", "hibrido", 15.5);
        t1.agregarViaje(25);
        t1.agregarViaje(30);
        // ... agregar cada viaje manualmente

        // PROBLEMA 5: Calcular todo manualmente
        double gananciasDiurnas = 0;
        double gananciasNocturnas = 0;
        double costos = 0;

        for (Taxi t : taxis) {
            gananciasDiurnas += t.calcularGanancias("diurno");
            gananciasNocturnas += t.calcularGanancias("nocturno");
            costos += t.calcularCostos();
        }

        // PROBLEMA 6: Para agregar nueva tarifa, modificas TODAS las clases
        // PROBLEMA 7: Para agregar nuevo calculo, modificas TODAS las clases
    }
}
```

**Problemas criticos:**
- If-else masivo (codigo espagueti)
- Logica dispersa y duplicada
- Datos hardcodeados (no escalable)
- Viola Open/Closed Principle
- Imposible agregar tarifas sin modificar codigo
- Imposible agregar calculos sin modificar codigo
- No reutilizable ni testeable

### Con 3 patrones combinados (nuestra solucion):

```java
// CODIGO BUENO: Herencia + Strategy + Visitor + File I/O

// 1. HERENCIA: Jerarquia clara
public abstract class Taxi {
    protected String id;
    protected double consumo;
    protected ArrayList<Double> viajes;
    protected TarifaStrategy tarifa;  // STRATEGY

    public abstract double accept(VisitorCalculos visitor);  // VISITOR
}

public class TaxiHibrido extends Taxi {
    @Override
    public double accept(VisitorCalculos visitor) {
        return visitor.visitarHibrido(this);
    }

    @Override
    public double calcularCostoCombustible() {
        return (getTotalKilometros() / (consumo * 1.2)) * 1.50;
    }
}

// 2. STRATEGY: Tarifas intercambiables
public interface TarifaStrategy {
    double calcularTarifa(Taxi taxi);
}

public class TarifaDiurna implements TarifaStrategy {
    @Override
    public double calcularTarifa(Taxi taxi) {
        double km = taxi.getTotalKilometros();
        if (taxi instanceof TaxiHibrido) {
            return km * 0.90;
        }
        // ... otros tipos
    }
}

// 3. VISITOR: Calculos separados
public interface VisitorCalculos {
    double visitarEstandar(TaxiEstandar taxi);
    double visitarHibrido(TaxiHibrido taxi);
    double visitarElectrico(TaxiElectrico taxi);
}

public class CalculadorGanancias implements VisitorCalculos {
    @Override
    public double visitarHibrido(TaxiHibrido taxi) {
        return taxi.getTarifa().calcularTarifa(taxi);  // Usa Strategy!
    }
}

// 4. FILE I/O: Datos externos
public class SistemaFlotaTaxis {
    public void cargarFlota(String archivo) {
        try (Scanner sc = new Scanner(new File(archivo))) {
            int n = Integer.parseInt(sc.nextLine().trim());
            // ... leer y crear taxis
        }
    }
}

// En Main.java - codigo elegante
public class Main {
    public static void main(String[] args) {
        SistemaFlotaTaxis sistema = new SistemaFlotaTaxis();

        // FILE I/O: Una linea carga todo
        sistema.cargarFlota("flota.txt");

        // STRATEGY: Cambiar tarifa es trivial
        sistema.establecerTarifa(new TarifaDiurna());

        // VISITOR: Aplicar calculos es simple
        sistema.mostrarReporte(new CalculadorGanancias(), "Ganancias Diurnas");

        // Cambiar estrategia - una sola linea
        sistema.establecerTarifa(new TarifaNocturna());
        sistema.mostrarReporte(new CalculadorGanancias(), "Ganancias Nocturnas");

        // Otro visitor - misma simplicidad
        sistema.mostrarReporte(new CalculadorCostos(), "Costos");
    }
}
```

**Ventajas:**
- Separacion de responsabilidades perfecta
- Open/Closed: agregar tarifas/calculos sin modificar existentes
- Datos externos (escalable a miles de taxis)
- Codigo limpio y mantenible
- Altamente testeable
- Reutilizable
- Profesional (asi funcionan sistemas reales)

---

## ✅ CHECKLIST DE DOMINIO

Puedes considerar que dominas este ejercicio cuando:

### Integracion de Patrones:
- [ ] Entiendes COMO los 3 patrones trabajan juntos
- [ ] Identificas que hace cada patron (Herencia, Strategy, Visitor)
- [ ] Sabes CUANDO usar cada patron
- [ ] Puedes explicar el flujo completo del sistema

### Herencia:
- [ ] Creas jerarquia Taxi → TaxiEstandar/Hibrido/Electrico
- [ ] Usas clase abstracta base correctamente
- [ ] Cada subclase implementa calcularCostoCombustible()
- [ ] Cada subclase implementa accept() para Visitor

### Strategy Pattern:
- [ ] Creas interface TarifaStrategy
- [ ] Implementas TarifaDiurna y TarifaNocturna
- [ ] Cambias estrategia en tiempo de ejecucion
- [ ] Cada taxi usa la tarifa actual

### Visitor Pattern:
- [ ] Creas interface VisitorCalculos
- [ ] Implementas CalculadorGanancias y CalculadorCostos
- [ ] CalculadorGanancias usa la Strategy actual
- [ ] Aplicas visitors sobre la flota completa

### File I/O:
- [ ] Lees archivo flota.txt correctamente
- [ ] Parseas datos de taxis y viajes
- [ ] Manejas excepciones apropiadamente
- [ ] Creas taxis dinamicamente segun tipo

### Logica de Negocio:
- [ ] Calculas kilometraje total por taxi
- [ ] Calculas ganancias usando tarifa actual
- [ ] Calculas costos de combustible/electricidad
- [ ] Calculas ganancia neta (ganancias - costos)
- [ ] Encuentras taxi mas rentable

### Tiempo:
- [ ] Implementas la solucion completa en < 90 minutos
- [ ] Puedes agregar nueva tarifa en < 10 minutos
- [ ] Puedes agregar nuevo visitor en < 15 minutos
- [ ] Explicas la interaccion entre patrones

---

## 🔗 RELACION CON EL EXAMEN

Este ejercicio es el MAS CERCANO al examen real - practica integracion de patrones.

### Comparacion: Este Ejercicio vs Examen

| Aspecto | Ejercicio 07 | Examen Real (Ejercicio 10) |
|---------|--------------|----------------------------|
| **Patrones combinados** | 3 (Herencia + Strategy + Visitor) | 3-4 (+ Singleton/Factory) |
| | Flota de Taxis | Sistema Renta de Vehiculos |
| **File I/O** | Si (flota.txt) | Si (datos.txt) |
| **Jerarquia** | Taxi → 3 tipos | Vehiculo → 3 tipos |
| **Strategy** | Tarifa Diurna/Nocturna | Tarifa Diurna/Nocturna (identico) |
| **Visitor** | Ganancias, Costos | Ganancias, Costos (identico) |
| **Complejidad** | Alta | Alta |
| **Tiempo estimado** | 90 minutos | 90-120 minutos |
| **Porcentaje del examen** | ~85% | Este es ~85% del examen |

### Como se compara con el examen:

**Similitudes (casi identico):**
1. Lee archivo con datos de vehiculos y viajes
2. Crea jerarquia de 3 tipos
3. Usa Strategy para tarifas intercambiables
4. Usa Visitor para calculos (Ganancias y Costos)
5. Calcula ganancia neta
6. Encuentra vehiculo mas rentable

**Diferencias minimas:**
1. Examen: Agrega Singleton o Factory
2. Examen: Puede tener un Visitor adicional
3. Examen: Formato de salida especifico

### Que cubre este ejercicio:

- ✅ **85% del examen:** Casi todo el examen esta aqui
- ✅ **Herencia:** Jerarquia completa
- ✅ **Strategy:** Tarifas intercambiables
- ✅ **Visitor:** Calculos separados
- ✅ **File I/O:** Lectura y parsing
- ✅ **Integracion:** Como los patrones trabajan juntos
- ❌ **Solo falta:** Singleton o Factory (~15% restante)

### Flujo completo del sistema (CRITICO entender esto):

```
PASO 1: CARGAR DATOS (File I/O)
├─ Leer flota.txt
├─ Parsear lineas de datos
├─ Crear objetos Taxi (TaxiEstandar/Hibrido/Electrico)
└─ Agregar viajes a cada taxi

PASO 2: ESTABLECER ESTRATEGIA (Strategy)
├─ Crear TarifaDiurna o TarifaNocturna
└─ Asignar a todos los taxis

PASO 3: APLICAR VISITOR GANANCIAS (Visitor + Strategy)
├─ Crear CalculadorGanancias
├─ Para cada taxi: taxi.accept(visitor)
│   ├─ Taxi llama visitor.visitarXXX(this)
│   ├─ Visitor obtiene tarifa: taxi.getTarifa()
│   ├─ Tarifa calcula: tarifa.calcularTarifa(taxi)
│   └─ Visitor retorna resultado
└─ Sumar todas las ganancias

PASO 4: APLICAR VISITOR COSTOS (Visitor)
├─ Crear CalculadorCostos
├─ Para cada taxi: taxi.accept(visitor)
│   ├─ Taxi llama visitor.visitarXXX(this)
│   ├─ Visitor llama: taxi.calcularCostoCombustible()
│   └─ Visitor retorna resultado
└─ Sumar todos los costos

PASO 5: CALCULAR GANANCIA NETA
└─ Ganancia neta = Ganancias - Costos
```

### Proximos pasos sugeridos:

1. **Ruta final hacia el examen:**
   - ✅ Ejercicio 07 (este) - Dominar integracion completa
   - ➡️ Agregar Singleton (envolver sistema en Singleton)
   - ➡️ Ejercicio 10 - Simulacro examen completo
   - 🔁 Repetir Ejercicio 07 al menos 2 veces

2. **Practica CRITICA para el examen:**
   - Implementa TODO desde cero SIN mirar la solucion
   - Cronometrate (objetivo: < 90 minutos)
   - Crea variantes del archivo flota.txt
   - Agrega un tercer Visitor (ej: CalculadorDistanciaTotal)
   - Agrega una tercera Strategy (ej: TarifaFinDeSemana)

### Errores CRITICOS en el examen (relacionados con este ejercicio):

1. **No integrar Strategy con Visitor** → Ganancias mal calculadas → 0 puntos
2. **Olvidar setTarifa() antes de calcular** → Visitor no tiene tarifa → NullPointerException
3. **No parsear viajes correctamente** → Datos incorrectos → Calculos mal → 0 puntos
4. **Confundir orden de operaciones** → Aplicar Visitor antes de leer archivo → Crash
5. **No retornar valor de accept()** → Visitor no funciona → 0 puntos

### Tips para el examen:

- ⏱️ **Tiempo:** Dedica 90 minutos completos a implementar todo
- 📝 **Orden:** File I/O → Herencia → Strategy → Visitor → Main
- ✅ **Verificacion:** Prueba cada patron ANTES de integrar
- 🔍 **Prioridad:** Visitor (35%) > Strategy (20%) > File I/O (20%) > Factory/Singleton (15%)
- 💡 **Debug:** Si falla, verifica la integracion Strategy-Visitor primero

### Como se relacionan los patrones en el examen:

```
SINGLETON/FACTORY (15%):
└─ Contiene la lista de vehiculos
   └─ Carga vehiculos con File I/O (20%)
      └─ Cada vehiculo es parte de HERENCIA (10%)
         └─ Cada vehiculo tiene STRATEGY (20%)
            └─ VISITOR usa la Strategy para calcular (35%)

TODO CONECTADO - SI FALLA UNO, FALLA TODO
```

---

**Si dominas este ejercicio, tienes el 85% del examen garantizado. Solo falta agregar Singleton/Factory (15%). Este es tu ejercicio MAS IMPORTANTE - repitelo hasta que sea automatico.**
