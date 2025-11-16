# Ejercicio 17: Sistema Hospitalario con Multiples Patrones (Nivel 3)
**Dificultad:** Avanzado
**Tiempo estimado:** 120 minutos
**Conceptos:** Strategy, Visitor, Singleton, Herencia, File I/O, Collections

---

## Contexto

Un hospital necesita un sistema completo para gestionar pacientes, calcular costos de atencion segun diferentes planes de salud, y generar estadisticas medicas. Deberas combinar TRES patrones de diseno.

---

## Requisitos

### Jerarquia de Pacientes:

Todos los pacientes tienen:
- ID (String)
- Nombre (String)
- Edad (int)
- Dias hospitalizados (int)

Tipos de pacientes:

**PacienteEmergencia:**
- Nivel de gravedad (int): 1-5 (5 es mas grave)
- Requiere UCI (boolean)

**PacienteCirugia:**
- Tipo de cirugia (String): "menor", "mayor", "compleja"
- Anestesia utilizada (String): "local", "general"

**PacienteObservacion:**
- Diagnostico (String)
- Requiere examenes (boolean)

---

## PATRON 1: SINGLETON - Sistema Hospital

El `SistemaHospital` debe ser Singleton y gestionar:
- Lista de todos los pacientes
- Estrategia de cobro actual
- Metodos de gestion (agregar, buscar, estadisticas)

**Metodos requeridos:**
- `getInstance()`
- `agregarPaciente(Paciente p)`
- `setPlanCobro(IEstrategiaCobro plan)`
- `calcularCostoTotal()` usando estrategia actual
- `aplicarVisitor(IVisitorPaciente visitor)` a todos los pacientes
- `mostrarEstadisticas()`

---

## PATRON 2: STRATEGY - Planes de Salud

Diferentes planes de salud calculan costos de manera diferente.

### Interface IEstrategiaCobro:
```java
double calcularCosto(PacienteEmergencia p);
double calcularCosto(PacienteCirugia p);
double calcularCosto(PacienteObservacion p);
```

### Estrategias a Implementar:

**1. PlanBasico:**
- Emergencia: $50.000/dia + $100.000 extra si requiere UCI + ($20.000 × nivel gravedad)
- Cirugia: $200.000 base + $100.000 si mayor + $150.000 si compleja + $50.000 si anestesia general
- Observacion: $30.000/dia + $40.000 si requiere examenes

**2. PlanPremium:**
- Emergencia: $30.000/dia + $50.000 extra si UCI + ($10.000 × nivel gravedad)
- Cirugia: $150.000 base + $70.000 si mayor + $100.000 si compleja + $30.000 si anestesia general
- Observacion: $20.000/dia + $25.000 si requiere examenes

**3. PlanCatastrofico:**
- Solo cubre emergencias graves (nivel >= 4) y cirugias complejas
- Emergencia: Si nivel >= 4: $10.000/dia. Sino: $80.000/dia
- Cirugia: Si compleja: $100.000 total. Sino: $300.000 base
- Observacion: $40.000/dia (sin descuentos)

---

## PATRON 3: VISITOR - Estadisticas Medicas

### Interface IVisitorPaciente:
```java
void visitarEmergencia(PacienteEmergencia p);
void visitarCirugia(PacienteCirugia p);
void visitarObservacion(PacienteObservacion p);
```

### Visitors a Implementar:

**1. VisitorDiasHospitalizacion:**
- Acumula total de dias de hospitalizacion
- Calcula promedio por tipo de paciente

**2. VisitorCasosCriticos:**
- Cuenta emergencias con nivel >= 4
- Cuenta cirugias complejas
- Cuenta pacientes con UCI

**3. VisitorEstimacionAlta:**
- Emergencia: dias_actuales + (nivel_gravedad × 2) dias mas
- Cirugia: menor=2 dias, mayor=5 dias, compleja=10 dias
- Observacion: 3 dias si requiere examenes, 1 dia si no

---

## Ejemplo de Ejecucion

```
=== SISTEMA HOSPITALARIO ===
[SINGLETON] Sistema inicializado

Cargando pacientes...
[+] P001 - Juan Perez (Emergencia, nivel 5, UCI)
[+] P002 - Maria Lopez (Cirugia compleja, anestesia general)
[+] P003 - Pedro Gomez (Observacion, con examenes)
[+] P004 - Ana Torres (Emergencia, nivel 2, sin UCI)
[+] P005 - Luis Diaz (Cirugia menor, anestesia local)

Total pacientes: 5

=== CALCULO DE COSTOS ===

--- Plan Basico ---
P001 (Emergencia): $420.000 (5 dias × $50k + $100k UCI + $100k gravedad)
P002 (Cirugia): $500.000 ($200k base + $150k compleja + $50k anestesia)
P003 (Observacion): $130.000 (3 dias × $30k + $40k examenes)
P004 (Emergencia): $190.000 (3 dias × $50k + $40k gravedad)
P005 (Cirugia): $250.000 ($200k base + $50k anestesia)
TOTAL PLAN BASICO: $1.490.000

--- Plan Premium ---
P001 (Emergencia): $250.000 (5 dias × $30k + $50k UCI + $50k gravedad)
P002 (Cirugia): $380.000 ($150k base + $100k compleja + $30k anestesia)
P003 (Observacion): $85.000 (3 dias × $20k + $25k examenes)
P004 (Emergencia): $110.000 (3 dias × $30k + $20k gravedad)
P005 (Cirugia): $180.000 ($150k base + $30k anestesia)
TOTAL PLAN PREMIUM: $1.005.000
Ahorro vs Basico: $485.000 (32.6%)

--- Plan Catastrofico ---
P001 (Emergencia): $50.000 (nivel >= 4, $10k/dia × 5 dias)
P002 (Cirugia): $100.000 (compleja, tarifa especial)
P003 (Observacion): $120.000 (3 dias × $40k, sin descuento)
P004 (Emergencia): $240.000 (nivel < 4, $80k/dia × 3 dias)
P005 (Cirugia): $600.000 (no compleja, tarifa alta)
TOTAL PLAN CATASTROFICO: $1.110.000

=== ESTADISTICAS MEDICAS ===

--- Dias de Hospitalizacion (VisitorDiasHospitalizacion) ---
Total dias: 19 dias
Promedio Emergencias: 4.0 dias/paciente
Promedio Cirugias: 2.5 dias/paciente
Promedio Observacion: 3.0 dias/paciente

--- Casos Criticos (VisitorCasosCriticos) ---
Emergencias graves (nivel >= 4): 1 caso
Cirugias complejas: 1 caso
Pacientes en UCI: 1 paciente
TOTAL CRITICOS: 3 casos

--- Estimacion de Alta (VisitorEstimacionAlta) ---
P001 (Emergencia): 15 dias mas estimados (5 actual + 10 por gravedad 5)
P002 (Cirugia): 10 dias mas (cirugia compleja)
P003 (Observacion): 3 dias mas (requiere examenes)
P004 (Emergencia): 4 dias mas (3 actual + 4 por gravedad 2)
P005 (Cirugia): 2 dias mas (cirugia menor)
TOTAL: 34 dias de hospitalizacion adicional estimados

=== RESUMEN EJECUTIVO ===
Pacientes activos: 5
Plan recomendado: Premium (mejor costo-beneficio)
Casos criticos: 3 (60% de los pacientes)
Dias hospitalizacion actual: 19 dias
Dias adicionales estimados: 34 dias
Ocupacion proyectada: 53 dias-paciente
```

---

## Debe entregar:

### Singleton:
1. **Clase SistemaHospital (Singleton)** con todos los metodos requeridos

### Herencia:
2. **Clase abstracta Paciente** con metodo `double accept(IEstrategiaCobro plan)`
3. **3 clases concretas:** PacienteEmergencia, PacienteCirugia, PacienteObservacion

### Strategy:
4. **Interface IEstrategiaCobro** con 3 metodos sobrecargados
5. **3 estrategias:** PlanBasico, PlanPremium, PlanCatastrofico

### Visitor:
6. **Interface IVisitorPaciente** con 3 metodos visit
7. **3 visitors:** VisitorDiasHospitalizacion, VisitorCasosCriticos, VisitorEstimacionAlta

### Main:
8. **Clase Main** que demuestre TODO el sistema

---

## Consideraciones:

- DEBE implementar los 3 patrones correctamente
- Singleton: solo una instancia del sistema
- Strategy: costos calculados segun plan activo
- Visitor: estadisticas independientes de logica de cobro
- Todos los pacientes en una sola lista
- Calculos precisos con double
- Formato de salida claro y organizado

---

## Pistas:

1. SistemaHospital guarda la estrategia y la aplica a cada paciente
2. Cada paciente implementa accept() que llama al metodo correcto de la estrategia
3. Los visitors acumulan datos iterando sobre la lista de pacientes
4. Usa sobrecarga de metodos en IEstrategiaCobro (mismo nombre, diferentes parametros)
5. Para comparar planes, calcula el costo con cada estrategia

---

**NOTA:** Este es un ejercicio AVANZADO de practica independiente. NO hay solucion.
Si te atascas, revisa los ejercicios 3, 6, 7, 8 y el material de la GUIA_ESTUDIO.md
