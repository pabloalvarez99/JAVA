# Ejercicio 17: Flota de Transporte de Carga (PRACTICA INDEPENDIENTE)
**Dificultad:** Avanzada
**Tiempo estimado:** 2.5 horas
**Conceptos:** TODOS los patrones combinados (Version simplificada del examen)
**Fase:** 2 (SIN SOLUCIONES - PRACTICA INDEPENDIENTE)

---

## IMPORTANTE

**Este ejercicio es NIVEL EXAMEN. Combina TODOS los patrones vistos.**

**Si te atascas:** Revisa el Ejercicio 08 de la Fase 1 (estructura similar).

---

## CONTEXTO

Una empresa de transporte de carga necesita un sistema para gestionar su flota de vehiculos, calcular costos segun tipo de ruta, y generar estadisticas.

## FORMATO DEL ARCHIVO: flota.txt

```
4
VEH001,Volvo,FH16,Camion,15.5
VEH002,Scania,R450,Camion,14.8
VEH003,Mercedes,Sprinter,Van,12.0
VEH004,Isuzu,NPR,Camioneta,10.5
VEH001,Urbana,120,85,95,110
VEH002,Carretera,450,380,520
VEH003,Urbana,75,65,90,105,80
VEH004,Carretera,280,310,250
```

**Estructura:**
- Linea 1: N vehiculos
- N lineas: VIN,Marca,Modelo,Tipo,CapacidadToneladas
- Lineas restantes: VIN,TipoRuta,Distancia1,...,DistanciaN

## TIPOS DE VEHICULOS (Herencia)

- **Camion:** Capacidad >12 toneladas
- **Van:** Capacidad 5-12 toneladas
- **Camioneta:** Capacidad <5 toneladas

## TIPOS DE RUTA (Strategy)

**Ruta Urbana:**
- Costo base: $100
- Costo por km: $3
- Formula: $100 + ($3 × distancia)

**Ruta Carretera:**
- Costo base: $80
- Costo por km: $2.5
- Formula: $80 + ($2.5 × distancia)

**Ruta Mixta:**
- Costo base: $90
- Costo por km: $2.8
- Formula: $90 + ($2.8 × distancia)

## PATRON VISITOR

**VisitorCalculoCostos:**
- Calcula costo total por vehiculo
- Suma kilometraje total
- Cuenta viajes por vehiculo

**VisitorReporte:**
- Muestra estadisticas formateadas
- Diferencia por tipo de vehiculo

## REQUISITOS FUNCIONALES

1. Leer archivo y crear flota
2. Procesar viajes con estrategia correcta
3. Calcular costos totales por vehiculo
4. Identificar vehiculo con mas kilometros por categoria
5. Calcular costo total de la flota
6. Mostrar vehiculo mas rentable (mayor costo/mayor capacidad)

## FORMATO DE SALIDA ESPERADO

```
=== SISTEMA DE FLOTA DE TRANSPORTE ===
Cargando flota desde: flota.txt
4 vehiculos cargados.

=== ESTADISTICAS POR VEHICULO ===
Volvo FH16 (Camion) COSTO TOTAL: $1330.00 KILOMETROS: 410 VIAJES: 4
Scania R450 (Camion) COSTO TOTAL: $3605.00 KILOMETROS: 1350 VIAJES: 3
Mercedes Sprinter (Van) COSTO TOTAL: $1545.00 KILOMETROS: 415 VIAJES: 5
Isuzu NPR (Camioneta) COSTO TOTAL: $2230.00 KILOMETROS: 840 VIAJES: 3

=== ANALISIS POR CATEGORIA ===
Vehiculo con mas kilometros:
- Camion: VEH002 (1350 km)
- Van: VEH003 (415 km)
- Camioneta: VEH004 (840 km)

Costo total de la flota: $8710.00
Kilometraje total: 3015 km
Vehiculo mas rentable: VEH002 (Scania R450)
```

## REQUISITOS TECNICOS

**OBLIGATORIO:**
- Herencia (Vehiculo abstracto, 3 subclases)
- Strategy (TipoRuta)
- Visitor (2 implementaciones)
- Singleton O Factory para el Sistema
- Lectura de archivo con validaciones
- NO ciclos anidados
- Map para busqueda rapida por VIN

## ESTRUCTURA SUGERIDA

```
Vehiculo (abstract)
├── Camion
├── Van
└── Camioneta

EstrategiaRuta (interface)
├── RutaUrbana
├── RutaCarretera
└── RutaMixta

VisitorVehiculo (interface)
├── VisitorCalculoCostos
└── VisitorReporte

SistemaFlota (Singleton)
├── leerArchivo()
├── procesarViajes()
├── generarEstadisticas()
└── encontrarMasRentable()
```

## CONSIDERACIONES

1. Cada vehiculo puede tener diferente cantidad de viajes
2. Todos los viajes de un vehiculo usan la MISMA estrategia de ruta
3. Los costos se acumulan por cada viaje
4. El vehiculo mas rentable es el que genera mas ingresos en relacion a su capacidad

## CRITERIO DE EXITO

- [x] Salida coincide EXACTAMENTE
- [x] Todos los patrones implementados correctamente
- [x] Lectura de archivo funciona
- [x] Calculos correctos
- [x] Codigo limpio y modular

**TIEMPO MAXIMO:** 2.5 horas.

---

*Ejercicio de Practica Independiente - Fase 2 - NIVEL EXAMEN*
