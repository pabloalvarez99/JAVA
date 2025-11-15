# Ejercicio 19: Gestion de Proyectos de Software (PRACTICA INDEPENDIENTE)
**Dificultad:** Avanzada
**Tiempo estimado:** 2.5 horas
**Conceptos:** Todos los patrones + Estadisticas complejas
**Fase:** 2 (SIN SOLUCIONES - PRACTICA INDEPENDIENTE)

---

## IMPORTANTE

**Este ejercicio tiene complejidad similar al examen real con calculos estadisticos avanzados.**

**Si te atascas:** Revisa el Ejercicio 10 de la Fase 1 (mismo nivel).

---

## CONTEXTO

Una consultora de software necesita un sistema para gestionar proyectos, asignar desarrolladores segun tecnologia, y calcular costos y rentabilidad.

## FORMATO DEL ARCHIVO: proyectos.txt

```
5
PROJ001,Sistema Bancario,Web,12000.00
PROJ002,App Movil,Mobile,8000.00
PROJ003,Dashboard Analytics,Web,15000.00
PROJ004,Juego 3D,Desktop,20000.00
PROJ005,E-commerce,Web,10000.00
PROJ001,Senior,320,280,350,400
PROJ002,Junior,180,160,200,220,190
PROJ003,Senior,450,380,420
PROJ004,Senior,520,480,510,490,530
PROJ005,Mid,280,310,290,300
```

**Estructura:**
- N proyectos
- N lineas: Codigo,Nombre,Tipo,PresupuestoUSD
- Lineas restantes: Codigo,NivelDev,Horas1,...,HorasN

## TIPOS DE PROYECTOS (Herencia)

**Web:**
- Framework: "React", "Angular", "Vue"
- Backend: "Node", "Java", "Python"

**Mobile:**
- Plataforma: "iOS", "Android", "Cross-platform"
- Lenguaje: "Swift", "Kotlin", "React Native"

**Desktop:**
- SO: "Windows", "Mac", "Linux"
- Framework: "Electron", "JavaFX", "Qt"

## ESTRATEGIAS DE COSTO (Strategy)

Costo por hora segun nivel de desarrollador:

**Developer Junior:**
- Costo: $25/hora

**Developer Mid:**
- Costo: $45/hora

**Developer Senior:**
- Costo: $75/hora

**Calculo:**
- Costo total = suma(horas × costo_por_hora)
- Rentabilidad = Presupuesto - Costo total
- Margen = (Rentabilidad / Presupuesto) × 100

## PATRON VISITOR

**VisitorAnalisisFinanciero:**
- Calcula costos totales
- Identifica proyectos con perdida
- Calcula margen promedio

**VisitorReporteDetallado:**
- Muestra informacion completa
- Incluye desglose de horas
- Formatea segun tipo de proyecto

## REQUISITOS FUNCIONALES

1. Leer archivo y crear proyectos
2. Calcular horas totales por proyecto
3. Calcular costo total segun nivel de developer
4. Calcular rentabilidad (presupuesto - costo)
5. Identificar:
   - Proyecto mas rentable
   - Proyecto con perdida (costo > presupuesto)
   - Tipo de proyecto mas comun
   - Promedio de horas por proyecto
6. Mostrar ranking de rentabilidad

## FORMATO DE SALIDA ESPERADO

```
=== SISTEMA DE GESTION DE PROYECTOS ===
Cargando proyectos desde: proyectos.txt
5 proyectos cargados.

=== ANALISIS FINANCIERO ===
PROJ001 - Sistema Bancario (Web)
  Presupuesto: $12000.00
  Horas trabajadas: 1350 hrs (Senior - $75/hr)
  Costo real: $101250.00
  Rentabilidad: -$89250.00 *** PERDIDA ***
  Margen: -743.75%

PROJ002 - App Movil (Mobile)
  Presupuesto: $8000.00
  Horas trabajadas: 950 hrs (Junior - $25/hr)
  Costo real: $23750.00
  Rentabilidad: -$15750.00 *** PERDIDA ***
  Margen: -196.88%

PROJ003 - Dashboard Analytics (Web)
  Presupuesto: $15000.00
  Horas trabajadas: 1250 hrs (Senior - $75/hr)
  Costo real: $93750.00
  Rentabilidad: -$78750.00 *** PERDIDA ***
  Margen: -525.00%

PROJ004 - Juego 3D (Desktop)
  Presupuesto: $20000.00
  Horas trabajadas: 2530 hrs (Senior - $75/hr)
  Costo real: $189750.00
  Rentabilidad: -$169750.00 *** PERDIDA ***
  Margen: -848.75%

PROJ005 - E-commerce (Web)
  Presupuesto: $10000.00
  Horas trabajadas: 1180 hrs (Mid - $45/hr)
  Costo real: $53100.00
  Rentabilidad: -$43100.00 *** PERDIDA ***
  Margen: -431.00%

=== ESTADISTICAS GENERALES ===
Total de proyectos: 5
Proyectos con perdida: 5
Proyectos rentables: 0

Tipo de proyecto mas comun: Web (3 proyectos)
Promedio de horas por proyecto: 1452 hrs

Proyecto mas rentable: PROJ001 (menor perdida: -$89250.00)

Inversion total: $65000.00
Costo total real: $461600.00
Deficit total: -$396600.00

RECOMENDACION: Revisar urgentemente la estimacion de presupuestos.
```

## REQUISITOS TECNICOS

**OBLIGATORIO:**
- Herencia (Proyecto abstracto, 3 tipos)
- Strategy (Nivel de developer)
- Visitor (2 implementaciones)
- Singleton para el Sistema
- File I/O con validaciones
- Calculos precisos (usar double, no redondear prematuramente)
- Identificar casos especiales (perdidas, rentabilidad negativa)

## ESTRUCTURA SUGERIDA

```
Proyecto (abstract)
├── ProyectoWeb
├── ProyectoMobile
└── ProyectoDesktop

EstrategiaCosto (interface)
├── CostoJunior
├── CostoMid
└── CostoSenior

VisitorProyecto (interface)
├── VisitorAnalisisFinanciero
└── VisitorReporteDetallado

SistemaProyectos (Singleton)
├── leerProyectos()
├── procesarHoras()
├── calcularRentabilidad()
├── generarRanking()
└── mostrarRecomendaciones()
```

## CONSIDERACIONES IMPORTANTES

1. Los presupuestos pueden ser menores que los costos (perdidas)
2. El margen puede ser negativo
3. El "proyecto mas rentable" puede tener rentabilidad negativa
4. Debes mostrar advertencias cuando hay perdidas
5. Los calculos deben ser precisos (no redondear hasta el final)

## CRITERIO DE EXITO

- [x] Salida coincide EXACTAMENTE
- [x] Calculos financieros correctos
- [x] Identifica perdidas correctamente
- [x] Estadisticas precisas
- [x] Recomendaciones apropiadas
- [x] Codigo profesional y bien estructurado

**TIEMPO MAXIMO:** 2.5 horas.

**NOTA:** Este ejercicio tiene calculos complejos. Valida cada formula cuidadosamente.

---

*Ejercicio de Practica Independiente - Fase 2 - NIVEL EXAMEN COMPLETO*
