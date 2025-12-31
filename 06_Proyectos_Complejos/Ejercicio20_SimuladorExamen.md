# Ejercicio 20: SIMULADOR COMPLETO DE EXAMEN (PRACTICA INDEPENDIENTE)
**Dificultad:** EXAMEN REAL
**Tiempo estimado:** 3 horas (LIMITE ESTRICTO)
**Conceptos:** SIMULACRO COMPLETO - Todos los patrones y requisitos del examen
**Fase:** 2 (SIN SOLUCIONES - EVALUACION FINAL)

---

## ATENCION - SIMULACRO DE EXAMEN

**Este es un SIMULADOR REAL del examen. Trátalo como tal:**
- Tienes EXACTAMENTE 3 horas
- NO consultes soluciones ni tutoriales durante el simulacro
- Anota el tiempo que tardas en cada parte
- Al finalizar, compara tu salida con la esperada
- Si no logras 100% correcto en 3 horas, necesitas mas practica

**Objetivo:** Sacar 100% en menos de 3 horas antes del examen real.

---

## PROBLEMA: Sistema de Gestion de Flota Aerea

Una aerolinea necesita un sistema para gestionar su flota de aviones, calcular costos operativos segun tipo de vuelo, y generar estadisticas detalladas.

## FORMATO DEL ARCHIVO: flota_aerea.txt

```
8
N12345,Boeing,737-800,Comercial,8500
N67890,Airbus,A320,Comercial,6800
N11111,Cessna,Citation X,Privado,3200
N22222,Boeing,787-9,Comercial,14200
N33333,Gulfstream,G650,Privado,7500
N44444,Embraer,E190,Regional,5600
N55555,Bombardier,CRJ900,Regional,4900
N66666,Boeing,747-8,Comercial,16800
N12345,Internacional,4500,5200,3800,6100
N67890,Nacional,1200,980,1450,1100
N11111,Charter,850,920,780
N22222,Internacional,8900,9500,8200,9100,8700
N33333,Charter,1800,2100,1650,1900
N44444,Nacional,890,950,820,1050
N55555,Nacional,780,850,920,800,870
N66666,Internacional,12000,11500,13000,11200
```

**Estructura:**
- Linea 1: N (cantidad de aviones)
- Siguientes N lineas: Matricula,Fabricante,Modelo,Tipo,CapacidadCombustibleLitros
  - Tipo: "Comercial", "Privado", "Regional"
- Siguientes lineas (variable): Matricula,TipoVuelo,DistanciaKm_1,...,DistanciaKm_N
  - TipoVuelo: "Internacional", "Nacional", "Charter"

## TIPOS DE AVIONES (HERENCIA)

**Avion (clase abstracta base):**
- Matricula (String)
- Fabricante (String)
- Modelo (String)
- Capacidad de combustible (int - litros)
- Consumo base (double - litros/km)
- Horas de vuelo acumuladas (int)
- Distancia total recorrida (int - km)
- Combustible total consumido (double - litros)

**AvionComercial:**
- Consumo base: 3.5 litros/km
- Pasajeros maximos: 180

**AvionPrivado:**
- Consumo base: 2.8 litros/km
- Numero de tripulantes: 2-4

**AvionRegional:**
- Consumo base: 2.2 litros/km
- Alcance maximo: 3000 km

## TIPOS DE VUELO (PATRON STRATEGY)

El consumo real depende del tipo de vuelo:

**Vuelo Internacional:**
- Consumo = consumo_base × 1.25 (consume 25% mas)
- Razon: Mayor altitud, tiempo de crucero largo

**Vuelo Nacional:**
- Consumo = consumo_base × 1.00 (consumo nominal)

**Vuelo Charter:**
- Consumo = consumo_base × 0.90 (consume 10% menos)
- Razon: Rutas optimizadas, menos peso

**Formula general:**
```java
consumoLitros = distancia_km × consumo_base × factor_tipo_vuelo
```

**Calculo de horas de vuelo:**
- Velocidad promedio: 800 km/h para todos los aviones
- Horas = distancia / 800

## PATRON VISITOR (OBLIGATORIO)

Implementar 2 Visitors:

**VisitorEstadisticasOperacionales:**
- Calcula consumo total por avion
- Calcula horas de vuelo por avion
- Suma kilometros recorridos
- Identifica aviones que exceden capacidad de combustible

**VisitorReporteFlota:**
- Muestra informacion formateada por tipo de avion
- Incluye estadisticas especificas por categoria
- Formato profesional

## PATRON SINGLETON O FACTORY (ELIGE UNO)

El sistema debe usar:
- **Opcion A:** Singleton para SistemaFlotaAerea
- **Opcion B:** Factory para crear aviones segun tipo

(Elige el que prefieras, pero implementalo CORRECTAMENTE)

## REQUISITOS FUNCIONALES (TODOS OBLIGATORIOS)

1. Leer el archivo flota_aerea.txt
2. Crear la flota de aviones (herencia correcta)
3. Procesar todos los vuelos aplicando la estrategia correcta
4. Calcular para cada avion:
   - Distancia total recorrida
   - Combustible total consumido
   - Horas de vuelo totales
5. Mostrar estadisticas de TODOS los aviones
6. Identificar:
   - Avion con mas horas de vuelo por categoria (Comercial, Privado, Regional)
   - Avion con mayor consumo total por categoria
   - Avion mas eficiente (menor consumo por km)
7. Calcular totales de la flota:
   - Horas totales de vuelo
   - Kilometros totales
   - Combustible total consumido
   - Costo operativo total (combustible a $2.50/litro)

## FORMATO DE SALIDA ESPERADO (EXACTO)

```
=== SISTEMA DE GESTION DE FLOTA AEREA ===
Cargando flota desde: flota_aerea.txt
8 aviones cargados exitosamente.

=== PROCESANDO VUELOS ===
N12345: 4 vuelos internacionales procesados
N67890: 4 vuelos nacionales procesados
N11111: 3 vuelos charter procesados
N22222: 5 vuelos internacionales procesados
N33333: 4 vuelos charter procesados
N44444: 4 vuelos nacionales procesados
N55555: 5 vuelos nacionales procesados
N66666: 4 vuelos internacionales procesados

=== ESTADISTICAS POR AVION ===
Boeing 737-800 CONSUMO: 85137.5 l DISTANCIA: 19600 km HORAS: 24.5
Airbus A320 CONSUMO: 16275.0 l DISTANCIA: 4730 km HORAS: 5.91
Cessna Citation X CONSUMO: 8820.72 l DISTANCIA: 3500 km HORAS: 4.38
Boeing 787-9 CONSUMO: 199062.5 l DISTANCIA: 45400 km HORAS: 56.75
Gulfstream G650 CONSUMO: 17829.6 l DISTANCIA: 7050 km HORAS: 8.81
Embraer E190 CONSUMO: 8151.6 l DISTANCIA: 3710 km HORAS: 4.64
Bombardier CRJ900 CONSUMO: 8899.2 l DISTANCIA: 4220 km HORAS: 5.28
Boeing 747-8 CONSUMO: 216562.5 l DISTANCIA: 47700 km HORAS: 59.63

=== ANALISIS POR CATEGORIA ===

Mayor consumo por categoria:
- Comercial: N66666 (216562.5 litros)
- Privado: N33333 (17829.6 litros)
- Regional: N55555 (8899.2 litros)

Mas horas de vuelo por categoria:
- Comercial: N66666 (59.63 horas)
- Privado: N33333 (8.81 horas)
- Regional: N55555 (5.28 horas)

Avion mas eficiente: N55555 (2.11 litros/km)

=== TOTALES DE LA FLOTA ===
Total de aviones: 8
Kilometros totales: 135910 km
Horas totales de vuelo: 169.89 hrs
Combustible total consumido: 560738.12 litros
Costo operativo total: $1401845.30 USD

=== ALERTAS ===
Aviones que exceden capacidad de combustible en vuelo unico:
- N22222: Consumo max por vuelo 39187.5 l > Capacidad 14200 l
- N66666: Consumo max por vuelo 56875.0 l > Capacidad 16800 l
```

## REQUISITOS TECNICOS (OBLIGATORIOS)

1. **Herencia:** Clase abstracta Avion con 3 subclases
2. **Strategy:** Interface TipoVuelo con 3 implementaciones
3. **Visitor:** Interface VisitorAvion con 2 implementaciones
4. **Singleton O Factory:** (elige uno, implementa correctamente)
5. **File I/O:** Leer archivo con Scanner, manejo de excepciones
6. **Collections:**
   - List<Avion> para la flota
   - Map<String, Avion> para busqueda rapida
7. **NO ciclos anidados:** Separa logica en metodos
8. **Arquitectura limpia:** Codigo modular y bien estructurado

## VALIDACIONES REQUERIDAS

1. Verificar que el archivo existe
2. Validar que los datos sean numericos donde corresponde
3. Verificar que el tipo de avion sea valido
4. Verificar que el tipo de vuelo sea valido
5. Identificar aviones que exceden capacidad de combustible
6. Manejo de excepciones apropiado

## ESTRUCTURA DE CLASES SUGERIDA

```
Avion (abstract)
├── AvionComercial
├── AvionPrivado
└── AvionRegional

TipoVuelo (interface)
├── VueloInternacional
├── VueloNacional
└── VueloCharter

VisitorAvion (interface)
├── VisitorEstadisticasOperacionales
└── VisitorReporteFlota

SistemaFlotaAerea (Singleton)
├── List<Avion> flota
├── Map<String, Avion> avionesPorMatricula
├── leerArchivo(String)
├── procesarVuelos(Scanner)
├── mostrarEstadisticas()
├── analizarPorCategoria()
├── calcularTotales()
└── generarAlertas()

Main
└── main(String[] args)
```

## DATOS DE PRUEBA

Crear archivo `datos/flota_aerea.txt` con el contenido especificado arriba.

## CRITERIOS DE EVALUACION (COMO EN EL EXAMEN REAL)

**Compilacion (20%):**
- [ ] El codigo compila sin errores
- [ ] No hay warnings criticos

**Implementacion de Patrones (40%):**
- [ ] Herencia correcta (10%)
- [ ] Strategy implementado (10%)
- [ ] Visitor implementado (10%)
- [ ] Singleton/Factory correcto (10%)

**Funcionalidad (30%):**
- [ ] Lee archivo correctamente (5%)
- [ ] Procesa vuelos correctamente (10%)
- [ ] Calculos correctos (10%)
- [ ] Estadisticas correctas (5%)

**Calidad de Codigo (10%):**
- [ ] Codigo limpio y legible (3%)
- [ ] Sin ciclos anidados (3%)
- [ ] Manejo de excepciones (2%)
- [ ] Comentarios apropiados (2%)

**TOTAL: 100 puntos**

**Nota minima para aprobar: 60 puntos**
**Nota para excelencia: 85+ puntos**

## INSTRUCCIONES DE SIMULACRO

1. **ANTES DE EMPEZAR:**
   - Cierra todos los tutoriales y soluciones
   - Prepara tu IDE
   - Crea el archivo de datos
   - Pon un temporizador de 3 horas

2. **DURANTE EL SIMULACRO:**
   - NO consultes soluciones
   - Si te atascas >20 min, salta esa parte y continua
   - Compila frecuentemente
   - Anota dudas para revisar despues

3. **AL FINALIZAR:**
   - Ejecuta tu programa
   - Compara salida con la esperada
   - Calcula tu puntaje segun criterios arriba
   - Identifica areas de mejora

4. **SI NO LOGRAS 85+ PUNTOS:**
   - Identifica que fallo
   - Repasa el ejercicio equivalente de Fase 1
   - Reintenta el simulacro en 2-3 dias

## GESTION DEL TIEMPO RECOMENDADA

```
00:00 - 00:15  Analisis y planificacion (diagramas en papel)
00:15 - 00:45  Jerarquia de aviones + Strategy
00:45 - 01:15  Lectura de archivo y parsing
01:15 - 01:45  Procesamiento de vuelos
01:45 - 02:15  Patron Visitor
02:15 - 02:40  Estadisticas y calculos
02:40 - 03:00  Pruebas, ajustes finales, validacion
```

Si vas atrasado, PRIORIZA:
1. Que compile
2. Que lea el archivo
3. Que aplique Strategy
4. Que use Visitor
5. Que las estadisticas basicas funcionen

## AUTOEVALUACION POST-SIMULACRO

Completa esto HONESTAMENTE despues del simulacro:

**Tiempo utilizado:** ___ horas ___ minutos

**Puntaje obtenido:** ___ / 100

**Problemas encontrados:**
- [ ] No compile
- [ ] Errores de lectura de archivo
- [ ] Strategy mal implementado
- [ ] Visitor mal implementado
- [ ] Calculos incorrectos
- [ ] Salida no coincide
- [ ] Me quede sin tiempo

**Que necesito repasar:**
- [ ] Herencia y polimorfismo
- [ ] Strategy Pattern
- [ ] Visitor Pattern
- [ ] File I/O
- [ ] Manejo de Collections
- [ ] Calculos y formulas
- [ ] Gestion del tiempo

**Proximos pasos:**
- [ ] Repetir simulacro en ___ dias
- [ ] Repasar ejercicio ___ de Fase 1
- [ ] Practicar _____________

---

## MENSAJE FINAL

**Si logras 85+ puntos en este simulacro en menos de 3 horas, ESTAS LISTO para el examen real.**

Si no, identifica debilidades, practica, y reintenta.

**El examen real tendra un problema MUY similar a este. Si dominas este simulacro, aprobaras.**

---

**SUERTE. Ahora demuestra todo lo que has aprendido.**

---

*SIMULADOR DE EXAMEN COMPLETO - Fase 2 - EVALUACION FINAL*
*Use este ejercicio para medir tu preparacion real para el examen*
