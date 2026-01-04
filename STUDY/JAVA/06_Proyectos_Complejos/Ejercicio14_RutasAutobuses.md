# Ejercicio 14: Sistema de Rutas de Autobuses (PRACTICA INDEPENDIENTE)
**Dificultad:** Media
**Tiempo estimado:** 75 minutos
**Conceptos:** Strategy Pattern, File I/O, Collections
**Fase:** 2 (SIN SOLUCIONES - PRACTICA INDEPENDIENTE)

---

## IMPORTANTE

**Este ejercicio NO incluye soluciones ni tutoriales paso a paso.**

Debes resolverlo de forma independiente aplicando los conceptos aprendidos en la Fase 1.

**Si te atascas:** Revisa el Ejercicio 05 (File I/O) y Ejercicio 02 (Strategy) de la Fase 1.

---

## CONTEXTO

Una empresa de transporte urbano necesita un sistema para calcular el costo de pasajes segun diferentes tipos de tarifa y procesar datos de rutas desde un archivo.

## FORMATO DEL ARCHIVO: rutas.txt

```
4
RutaA,Centro-Norte,25,45
RutaB,Este-Oeste,18,35
RutaC,Sur-Centro,30,50
RutaD,Express-Centro,12,20
RutaA,120
RutaB,85
RutaC,150
RutaD,60
```

**Estructura:**
- Linea 1: N (cantidad de rutas)
- Siguientes N lineas: CodigoRuta,Nombre,DistanciaKm,DuracionMin
- Siguientes N lineas: CodigoRuta,CantidadPasajeros

## TIPOS DE TARIFA (STRATEGY PATTERN)

El sistema tiene 3 estrategias de tarifa:

**Tarifa Normal:**
- Calculo: $50 + ($5 × kilometros)
- Ejemplo: 25 km = $50 + ($5 × 25) = $175

**Tarifa Estudiante:** (descuento 40%)
- Calculo: ($50 + ($5 × kilometros)) × 0.60
- Ejemplo: 25 km = $175 × 0.60 = $105

**Tarifa Adulto Mayor:** (descuento 50%)
- Calculo: ($50 + ($5 × kilometros)) × 0.50
- Ejemplo: 25 km = $175 × 0.50 = $87.50

## REQUISITOS FUNCIONALES

1. Leer archivo rutas.txt
2. Crear objetos Ruta con su informacion
3. Procesar cantidad de pasajeros de la segunda seccion del archivo
4. Calcular costo de pasaje para cada ruta segun estrategia
5. Calcular ingresos totales por ruta (pasaje × cantidad_pasajeros)
6. Mostrar estadisticas:
   - Ruta con mas pasajeros
   - Ruta con mayor ingreso (usando tarifa normal)
   - Ingresos totales de todas las rutas
   - Promedio de kilometros por ruta

## REQUISITOS TECNICOS

**OBLIGATORIO:**
- Implementar Strategy Pattern para las tarifas
- Interface EstrategiaTarifa con metodo: `double calcularPasaje(int kilometros)`
- Leer archivo con Scanner
- Manejo de excepciones (FileNotFoundException)
- Validar que el archivo exista
- Todas las rutas en una sola lista

## FORMATO DE SALIDA ESPERADO

```
=== SISTEMA DE RUTAS - TRANSPORTE URBANO ===
Leyendo archivo: rutas.txt
4 rutas cargadas exitosamente.

=== TARIFAS CON ESTRATEGIA NORMAL ===
RutaA (Centro-Norte): 25 km, 45 min - Pasajeros: 120
  Pasaje: $175.00 - Ingresos: $21000.00

RutaB (Este-Oeste): 18 km, 35 min - Pasajeros: 85
  Pasaje: $140.00 - Ingresos: $11900.00

RutaC (Sur-Centro): 30 km, 50 min - Pasajeros: 150
  Pasaje: $200.00 - Ingresos: $30000.00

RutaD (Express-Centro): 12 km, 20 min - Pasajeros: 60
  Pasaje: $110.00 - Ingresos: $6600.00

=== TARIFAS CON ESTRATEGIA ESTUDIANTE ===
RutaA: Pasaje Estudiante: $105.00 - Ingresos: $12600.00
RutaB: Pasaje Estudiante: $84.00 - Ingresos: $7140.00
RutaC: Pasaje Estudiante: $120.00 - Ingresos: $18000.00
RutaD: Pasaje Estudiante: $66.00 - Ingresos: $3960.00

=== TARIFAS CON ESTRATEGIA ADULTO MAYOR ===
RutaA: Pasaje Adulto Mayor: $87.50 - Ingresos: $10500.00
RutaB: Pasaje Adulto Mayor: $70.00 - Ingresos: $5950.00
RutaC: Pasaje Adulto Mayor: $100.00 - Ingresos: $15000.00
RutaD: Pasaje Adulto Mayor: $55.00 - Ingresos: $3300.00

=== ESTADISTICAS ===
Ruta con mas pasajeros: RutaC (150 pasajeros)
Ruta con mayor ingreso: RutaC ($30000.00)
Ingresos totales (tarifa normal): $69500.00
Promedio de kilometros: 21.25 km
```

## DATOS DE PRUEBA (rutas.txt)

Crea el archivo `datos/rutas.txt` con el siguiente contenido:

```
4
RutaA,Centro-Norte,25,45
RutaB,Este-Oeste,18,35
RutaC,Sur-Centro,30,50
RutaD,Express-Centro,12,20
RutaA,120
RutaB,85
RutaC,150
RutaD,60
```

## CONSIDERACIONES

1. Tarifa base es siempre $50
2. Costo por kilometro es $5
3. Los descuentos se aplican sobre el costo total
4. Los ingresos = pasaje × cantidad_pasajeros
5. NO usar ciclos anidados
6. Usar un Map<String, Ruta> para busqueda rapida por codigo

## ESTRUCTURA SUGERIDA

```
Ruta
├── String codigo
├── String nombre
├── int distanciaKm
├── int duracionMin
├── int cantidadPasajeros
└── calcularIngresos(EstrategiaTarifa tarifa)

EstrategiaTarifa (interface)
└── double calcularPasaje(int kilometros)

TarifaNormal implements EstrategiaTarifa
TarifaEstudiante implements EstrategiaTarifa
TarifaAdultoMayor implements EstrategiaTarifa

SistemaRutas
├── List<Ruta> rutas
├── Map<String, Ruta> rutasPorCodigo
├── leerArchivo(String nombreArchivo)
├── mostrarTarifas(EstrategiaTarifa tarifa)
├── calcularEstadisticas()
└── encontrarRutaMasPasajeros()
```

## CRITERIO DE EXITO

Tu programa funciona correctamente si:
- [x] Lee correctamente el archivo rutas.txt
- [x] La salida coincide EXACTAMENTE con la esperada
- [x] Los calculos de tarifas son correctos para las 3 estrategias
- [x] Los ingresos se calculan correctamente
- [x] Las estadisticas son correctas
- [x] Maneja correctamente el error si el archivo no existe
- [x] El codigo compila sin errores

---

**RECUERDA:** Este es un ejercicio de PRACTICA INDEPENDIENTE. No hay soluciones proporcionadas.

**TIEMPO MAXIMO:** 75 minutos.

---

*Ejercicio de Practica Independiente - Fase 2*
