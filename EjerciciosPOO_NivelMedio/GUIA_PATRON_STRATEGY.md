# GUIA PATRON STRATEGY - Dominando el Cambio de Comportamiento

## Indice
1. [Que es Strategy](#que-es-strategy)
2. [Cuando Usarlo](#cuando-usarlo)
3. [Estructura](#estructura)
4. [Ejemplo Paso a Paso](#ejemplo-paso-a-paso)
5. [Errores Comunes](#errores-comunes)
6. [Patron en el Examen](#patron-en-el-examen)

---

## Que es Strategy

**Strategy** es un patron que permite **cambiar el comportamiento de un objeto en tiempo de ejecucion** sin modificar su codigo.

### Analogia del Mundo Real
Imagina un GPS de tu auto:
- El destino es el mismo (llegar a casa)
- Pero puedes elegir la **estrategia de ruta**:
  - Ruta mas rapida
  - Ruta sin peajes
  - Ruta panoramica

El GPS no cambia, solo cambia **como calcula** la ruta.

---

## Cuando Usarlo

Usa Strategy cuando:
- Un objeto necesita **diferentes formas de hacer algo**
- Quieres **cambiar el comportamiento en runtime**
- Tienes muchos `if/else` o `switch` que hacen cosas parecidas pero diferentes
- NO quieres usar herencia para cada variacion

### Senales de Alarma (Code Smells)
```java
// MAL - Muchos if/else haciendo lo mismo de formas diferentes
public void procesarPago(String tipo, double monto) {
    if (tipo.equals("TARJETA")) {
        // Logica de tarjeta
    } else if (tipo.equals("EFECTIVO")) {
        // Logica de efectivo
    } else if (tipo.equals("TRANSFERENCIA")) {
        // Logica de transferencia
    }
}
```

**Solucion**: Usar Strategy para cada tipo de pago.

---

## Estructura

### Componentes del Patron

```
1. INTERFAZ STRATEGY
   └─> Define el "contrato" del comportamiento

2. ESTRATEGIAS CONCRETAS
   └─> Implementaciones especificas del comportamiento

3. CONTEXTO
   └─> El objeto que USA la estrategia
   └─> Tiene un metodo setStrategy() para cambiarla
```

### Diagrama de Clases Simplificado

```
┌─────────────────┐
│   <<interface>> │
│  IStrategy      │
├─────────────────┤
│ + ejecutar()    │
└─────────────────┘
        △
        │ implements
        │
   ┌────┴────┐
   │         │
┌──┴───┐ ┌──┴────┐
│ EsA  │ │  EsB  │
├──────┤ ├───────┤
│ exec │ │ exec  │
└──────┘ └───────┘

┌─────────────────┐
│   Contexto      │
├─────────────────┤
│ - strategy      │ ◄──── Referencia a Strategy
├─────────────────┤
│ + setStrategy() │
│ + hacerAlgo()   │
└─────────────────┘
```

---

## Ejemplo Paso a Paso

### Problema
Tienes un sistema de envios que puede calcular el costo de 3 formas:
- Envio Standard
- Envio Express
- Envio Internacional

### Paso 1: Crear la Interfaz Strategy

```java
public interface IEstrategiaEnvio {
    double calcularCosto(double peso, double distancia);
}
```

### Paso 2: Crear Estrategias Concretas

```java
public class EnvioStandard implements IEstrategiaEnvio {
    @Override
    public double calcularCosto(double peso, double distancia) {
        return peso * 0.5 + distancia * 0.1;
    }
}

public class EnvioExpress implements IEstrategiaEnvio {
    @Override
    public double calcularCosto(double peso, double distancia) {
        return (peso * 0.5 + distancia * 0.1) * 2; // El doble
    }
}

public class EnvioInternacional implements IEstrategiaEnvio {
    @Override
    public double calcularCosto(double peso, double distancia) {
        return peso * 2.0 + distancia * 0.5 + 50; // Tarifa fija extra
    }
}
```

### Paso 3: Crear el Contexto

```java
public class Paquete {
    private double peso;
    private double distancia;
    private IEstrategiaEnvio estrategia; // CLAVE: Referencia a Strategy

    public Paquete(double peso, double distancia) {
        this.peso = peso;
        this.distancia = distancia;
    }

    // CLAVE: Metodo para cambiar estrategia
    public void setEstrategiaEnvio(IEstrategiaEnvio estrategia) {
        this.estrategia = estrategia;
    }

    // CLAVE: Delega a la estrategia
    public double calcularCosto() {
        if (estrategia == null) {
            throw new IllegalStateException("No hay estrategia definida");
        }
        return estrategia.calcularCosto(peso, distancia);
    }
}
```

### Paso 4: Usar el Patron

```java
public class Main {
    public static void main(String[] args) {
        Paquete paquete = new Paquete(10, 100); // 10 kg, 100 km

        // Probar con envio standard
        paquete.setEstrategiaEnvio(new EnvioStandard());
        System.out.println("Costo Standard: $" + paquete.calcularCosto());

        // CAMBIAR estrategia en runtime
        paquete.setEstrategiaEnvio(new EnvioExpress());
        System.out.println("Costo Express: $" + paquete.calcularCosto());

        // CAMBIAR de nuevo
        paquete.setEstrategiaEnvio(new EnvioInternacional());
        System.out.println("Costo Internacional: $" + paquete.calcularCosto());
    }
}
```

**Salida:**
```
Costo Standard: $15.0
Costo Express: $30.0
Costo Internacional: $120.0
```

---

## Errores Comunes

### Error 1: No Validar la Estrategia

```java
// MAL
public double calcularCosto() {
    return estrategia.calcularCosto(peso, distancia); // NullPointerException!
}

// BIEN
public double calcularCosto() {
    if (estrategia == null) {
        throw new IllegalStateException("Estrategia no definida");
    }
    return estrategia.calcularCosto(peso, distancia);
}
```

### Error 2: Hardcodear la Estrategia

```java
// MAL - Derrota el proposito del patron
public Paquete(double peso, double distancia) {
    this.peso = peso;
    this.distancia = distancia;
    this.estrategia = new EnvioStandard(); // FIJO!
}

// BIEN - Flexibilidad
public Paquete(double peso, double distancia) {
    this.peso = peso;
    this.distancia = distancia;
    // Sin estrategia inicial o pasarla como parametro
}
```

### Error 3: Usar Herencia en lugar de Strategy

```java
// MAL - Explosion de clases
class PaqueteStandard extends Paquete { ... }
class PaqueteExpress extends Paquete { ... }
class PaqueteInternacional extends Paquete { ... }

// BIEN - Una clase, multiples estrategias
class Paquete {
    private IEstrategiaEnvio estrategia;
    ...
}
```

---

## Patron en el Examen

### Ejemplo del Examen Real (Prueba 2 - Rent a Car)

**Problema**: Los vehiculos tienen 3 modos de manejo (Eco, Normal, Sport) que afectan el consumo.

**Solucion con Strategy**:

```java
// INTERFAZ
public interface DrivingStrategy {
    void drive(Vehicle v, int distance);
}

// ESTRATEGIAS CONCRETAS
public class EcoMode implements DrivingStrategy {
    @Override
    public void drive(Vehicle v, int distance) {
        double efficiency = v.getEfficiency() * 0.9; // 10% menos eficiente
        double gas = distance / efficiency;
        v.updateGasUsage(gas);
        v.updateOdo(distance);
    }
}

public class NormalMode implements DrivingStrategy {
    @Override
    public void drive(Vehicle v, int distance) {
        double efficiency = v.getEfficiency(); // Eficiencia nominal
        double gas = distance / efficiency;
        v.updateGasUsage(gas);
        v.updateOdo(distance);
    }
}

public class SportMode implements DrivingStrategy {
    @Override
    public void drive(Vehicle v, int distance) {
        double efficiency = v.getEfficiency() * 1.25; // 25% mas consumo
        double gas = distance / efficiency;
        v.updateGasUsage(gas);
        v.updateOdo(distance);
    }
}

// CONTEXTO
public abstract class Vehicle {
    private DrivingStrategy drivingMode;

    public void setDrivingMode(DrivingStrategy mode) {
        this.drivingMode = mode;
    }

    public void calculateTrip(int distance) {
        drivingMode.drive(this, distance); // DELEGA
    }
}
```

### Checklist para el Examen

Cuando veas que piden Strategy, asegurate de:

- [ ] Crear interfaz `IEstrategia` con metodo(s) abstracto(s)
- [ ] Crear al menos 2-3 clases concretas que implementen la interfaz
- [ ] El contexto (clase principal) tiene un atributo `private IEstrategia estrategia`
- [ ] El contexto tiene `setEstrategia(IEstrategia e)` para cambiarla
- [ ] El contexto DELEGA a la estrategia, no hace la logica el mismo
- [ ] Demostrar en Main que cambias la estrategia en runtime

---

## Resumen en 30 Segundos

**Strategy = Cambiar como se hace algo sin cambiar el objeto**

1. Creas una **interfaz** para el comportamiento variable
2. Creas **clases concretas** para cada variacion
3. El **contexto** guarda una referencia a la estrategia
4. El contexto **delega** el trabajo a la estrategia
5. Puedes **cambiar la estrategia en runtime**

**Ventaja clave**: FLEXIBILIDAD sin modificar codigo existente.

---

## Practica Recomendada

1. Resuelve **Ejercicio02_TiendaStrategy.md**
2. Resuelve **Ejercicio12_TiendaDescuentosStrategy.md**
3. Analiza el codigo del examen real en `materialPOO/p2/p2/src/p2/`
4. Intenta resolver el **Ejercicio20_SimulacroExamen.md**

---

**Tiempo de estudio estimado**: 45-60 minutos para dominar el patron.
