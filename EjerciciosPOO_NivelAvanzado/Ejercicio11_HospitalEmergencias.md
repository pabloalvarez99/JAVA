# Ejercicio 11: Sistema de Emergencias de Hospital (PRACTICA INDEPENDIENTE)
**Dificultad:** Basica
**Tiempo estimado:** 40 minutos
**Conceptos:** Strategy Pattern, Herencia
**Fase:** 2 (SIN SOLUCIONES - PRACTICA INDEPENDIENTE)

---

## IMPORTANTE

**Este ejercicio NO incluye soluciones ni tutoriales paso a paso.**

Debes resolverlo de forma independiente aplicando los conceptos aprendidos en la Fase 1.

**Si te atascas:** Revisa el Ejercicio 02 (Strategy Pattern) de la Fase 1.

---

## CONTEXTO

Un hospital necesita un sistema para priorizar la atencion de pacientes en la sala de emergencias segun su nivel de urgencia.

## TIPOS DE PACIENTES

Todos los pacientes tienen:
- Nombre (String)
- Edad (int)
- Sintomas (String)
- Hora de llegada (String) - formato "HH:MM"

Categorias de pacientes:
1. **Critico:** Requiere atencion inmediata (prioridad 1)
2. **Urgente:** Requiere atencion en <30 minutos (prioridad 2)
3. **Estable:** Puede esperar (prioridad 3)

## ESTRATEGIAS DE ATENCION (PATRON STRATEGY)

El hospital tiene 3 estrategias para calcular el tiempo de espera:

**Estrategia Normal:**
- Critico: 0 minutos (inmediato)
- Urgente: 15 minutos
- Estable: 45 minutos

**Estrategia Sobrecarga:** (cuando hay muchos pacientes)
- Critico: 5 minutos
- Urgente: 30 minutos
- Estable: 90 minutos

**Estrategia Nocturna:** (menos personal)
- Critico: 2 minutos
- Urgente: 25 minutos
- Estable: 60 minutos

## REQUISITOS FUNCIONALES

1. Crear jerarquia de pacientes (clase base Paciente, subclases Critico, Urgente, Estable)
2. Implementar patron Strategy para calcular tiempos de espera
3. Crear sistema que gestione la lista de pacientes
4. Calcular tiempo de espera para cada paciente segun la estrategia activa
5. Mostrar lista de pacientes ordenada por prioridad
6. Identificar el paciente critico mas joven

## REQUISITOS TECNICOS

**OBLIGATORIO:**
- Usar herencia (clase base abstracta Paciente)
- Implementar Strategy Pattern correctamente
- Interface EstrategiaAtencion con metodo: `int calcularTiempoEspera(int prioridad)`
- Tres implementaciones: Normal, Sobrecarga, Nocturna
- Cada paciente debe tener metodo `getPrioridad()` que retorna 1, 2 o 3

## FORMATO DE SALIDA ESPERADO

```
=== SISTEMA DE EMERGENCIAS - HOSPITAL CENTRAL ===
Estrategia activa: Normal

=== PACIENTES EN ESPERA ===
[CRITICO] Juan Perez (65 años) - Dolor toracico - Llegada: 14:30 - Espera: 0 min
[CRITICO] Maria Lopez (42 años) - Sangrado severo - Llegada: 14:35 - Espera: 0 min
[URGENTE] Carlos Ruiz (28 años) - Fractura - Llegada: 14:20 - Espera: 15 min
[URGENTE] Ana Martinez (55 años) - Fiebre alta - Llegada: 14:45 - Espera: 15 min
[ESTABLE] Luis Gomez (35 años) - Resfriado - Llegada: 14:15 - Espera: 45 min

Paciente critico mas joven: Maria Lopez (42 años)

--- Cambiando estrategia a SOBRECARGA ---

=== PACIENTES EN ESPERA ===
[CRITICO] Juan Perez (65 años) - Dolor toracico - Llegada: 14:30 - Espera: 5 min
[CRITICO] Maria Lopez (42 años) - Sangrado severo - Llegada: 14:35 - Espera: 5 min
[URGENTE] Carlos Ruiz (28 años) - Fractura - Llegada: 14:20 - Espera: 30 min
[URGENTE] Ana Martinez (55 años) - Fiebre alta - Llegada: 14:45 - Espera: 30 min
[ESTABLE] Luis Gomez (35 años) - Resfriado - Llegada: 14:15 - Espera: 90 min

Paciente critico mas joven: Maria Lopez (42 años)
```

## DATOS DE PRUEBA

Crear los siguientes pacientes en tu Main:

```java
// Pacientes criticos
Paciente p1 = new Critico("Juan Perez", 65, "Dolor toracico", "14:30");
Paciente p2 = new Critico("Maria Lopez", 42, "Sangrado severo", "14:35");

// Pacientes urgentes
Paciente p3 = new Urgente("Carlos Ruiz", 28, "Fractura", "14:20");
Paciente p4 = new Urgente("Ana Martinez", 55, "Fiebre alta", "14:45");

// Pacientes estables
Paciente p5 = new Estable("Luis Gomez", 35, "Resfriado", "14:15");
```

## CONSIDERACIONES

1. Los pacientes DEBEN estar en una sola lista (List<Paciente>)
2. El orden de impresion debe ser: Criticos primero, luego Urgentes, luego Estables
3. La estrategia se puede cambiar en tiempo de ejecucion
4. Validar que no haya valores negativos para edad

## ESTRUCTURA SUGERIDA

```
Paciente (abstract)
├── Critico (prioridad = 1)
├── Urgente (prioridad = 2)
└── Estable (prioridad = 3)

EstrategiaAtencion (interface)
├── EstrategiaNormal
├── EstrategiaSobrecarga
└── EstrategiaNocturna

SistemaEmergencias
├── List<Paciente> pacientes
├── EstrategiaAtencion estrategia
├── agregarPaciente()
├── cambiarEstrategia()
├── mostrarPacientes()
└── encontrarCriticoMasJoven()
```

## CRITERIO DE EXITO

Tu programa funciona correctamente si:
- [x] La salida coincide EXACTAMENTE con la esperada
- [x] Puedes cambiar la estrategia sin modificar la clase Paciente
- [x] Los tiempos de espera cambian correctamente al cambiar la estrategia
- [x] El paciente critico mas joven se identifica correctamente
- [x] El codigo compila sin errores ni warnings

---

**RECUERDA:** Este es un ejercicio de PRACTICA INDEPENDIENTE. No hay soluciones proporcionadas. Debes aplicar lo aprendido en la Fase 1 por tu cuenta.

**TIEMPO MAXIMO:** 40 minutos. Si tardas mas, necesitas repasar el Ejercicio 02 de Fase 1.

---

*Ejercicio de Practica Independiente - Fase 2*
