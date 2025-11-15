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
