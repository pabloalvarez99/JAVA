# Sistema de Rent a Car - Prueba 2 POO

## Descripcion del Problema
Sistema de seguimiento de flota de vehiculos que calcula:
- Kilometraje total (odometro) de cada vehiculo
- Consumo de combustible considerando modos de manejo
- Vehiculos con mayor consumo por categoria

## Arquitectura y Patrones de Diseno

### 1. Pattern Strategy (OBLIGATORIO)
**Objetivo**: Modelar los diferentes modos de manejo y su impacto en la eficiencia

**Implementacion**:
- `ModoManejo` (interface): Define el contrato para calcular eficiencia ajustada
- `ModoEco`: Eficiencia 10% menor (0.9x nominal) - MAYOR consumo
- `ModoNormal`: Eficiencia nominal (1.0x nominal)
- `ModoSport`: Eficiencia 25% superior (1.25x nominal) - MENOR consumo

### 2. Pattern Visitor (OBLIGATORIO)
**Objetivo**: Realizar operaciones sobre vehiculos sin modificar sus clases

**Implementacion**:
- `VehicleVisitor` (interface): Define operaciones visitables
- `ConsumoCalculator`: Visitor concreto que encuentra el vehiculo con mayor consumo por categoria
- Metodo `accept()` en `Vehiculo` para double dispatch

### 3. Pattern Singleton (ELEGIDO)
**Objetivo**: Garantizar una unica instancia del Sistema

**Implementacion**:
- `Sistema`: Clase Singleton que coordina toda la aplicacion
- Constructor privado
- Metodo `getInstance()` para acceso global

## Jerarquia de Clases (Herencia)

```
Vehiculo (abstract)
├── Camioneta (P)
├── SUV (S)
└── Auto (C)
```

**Clase Base `Vehiculo`**:
- Atributos: VIN, marca, modelo, eficienciaNominal
- Lista unificada de viajes con modo y distancia
- Metodos: `calcularOdometro()`, `calcularConsumo()`, `accept()`

## Estructura de Archivos

```
Prueba2/
├── Sistema.java              (Main + Singleton)
├── Vehiculo.java             (Abstract base class)
├── Camioneta.java            (Concrete vehicle)
├── SUV.java                  (Concrete vehicle)
├── Auto.java                 (Concrete vehicle)
├── ModoManejo.java           (Strategy interface)
├── ModoEco.java              (Concrete strategy)
├── ModoNormal.java           (Concrete strategy)
├── ModoSport.java            (Concrete strategy)
├── VehicleVisitor.java       (Visitor interface)
├── ConsumoCalculator.java    (Concrete visitor)
└── README.md                 (This file)
```

## Formula de Calculo

**Consumo Total** = Σ (distancia / eficiencia_ajustada)

Donde:
- **eficiencia_ajustada** = eficiencia_nominal * factor_modo
- **factor_modo**: 0.9 (Eco), 1.0 (Normal), 1.25 (Sport)

## Compilacion y Ejecucion

```bash
cd Prueba2
javac *.java
java Sistema
```

## Requisitos Cumplidos

✓ Herencia (Vehiculo como clase base abstracta)
✓ Una sola lista para todos los vehiculos
✓ Pattern Strategy (modos de manejo)
✓ Pattern Visitor (calculo de mayor consumo)
✓ Pattern Singleton (Sistema)
✓ Arquitectura "Sistema" vista en clase
✓ Sin ciclos anidados (uso de metodos)
✓ Calculo de odometro por vehiculo
✓ Calculo de consumo considerando modo de manejo
✓ Mayor consumo por categoria

## Principios SOLID Aplicados

- **Single Responsibility**: Cada clase tiene una responsabilidad unica
- **Open/Closed**: Visitor permite agregar operaciones sin modificar vehiculos
- **Liskov Substitution**: Todas las subclases de Vehiculo son intercambiables
- **Interface Segregation**: Interfaces pequeñas y especificas
- **Dependency Inversion**: Dependencias en abstracciones (interfaces)

## Notas Tecnicas

- Todos los vehiculos se almacenan polimorficamente en `List<Vehiculo>`
- El modo de manejo se aplica dinamicamente usando Strategy
- El calculo de consumo maximo usa Visitor para evitar instanceof
- Inner class `Viaje` encapsula la relacion modo-distancia
- No se usan ciclos anidados: metodos `leerVehiculos()`, `leerViajes()`, `agregarDistancias()`, etc.
