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
