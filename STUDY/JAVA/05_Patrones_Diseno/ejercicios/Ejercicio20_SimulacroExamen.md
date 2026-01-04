# Ejercicio 20: SIMULACRO DE EXAMEN COMPLETO (Nivel 4)
**Dificultad:** Nivel Examen Real
**Tiempo estimado:** 3 horas (limite de tiempo del examen)
**Conceptos:** TODOS (Strategy, Visitor, Singleton/Factory, Herencia, File I/O, Collections)

---

## INSTRUCCIONES IMPORTANTES

Este ejercicio es un **SIMULACRO COMPLETO** del examen real. Debes resolverlo en condiciones de examen:

1. **Tiempo limite:** 3 horas exactas
2. **Sin consultar soluciones** de otros ejercicios
3. **Puedes consultar:** GUIA_ESTUDIO.md y REFERENCIA_RAPIDA.md
4. **Objetivo:** Resolver al menos 60% correctamente (equivalente a nota 4.0)
5. **Entregable:** Codigo Java exportado como .zip

---

## PROBLEMA: Sistema de Gestion de Flota de Transporte

Una empresa de transporte necesita gestionar su flota de vehiculos, calcular costos operacionales y generar estadisticas. Los datos se cargan desde un archivo.

---

## PARTE 1: Lectura del Archivo (20 puntos)

### Formato del archivo: fleet_transport.txt

```
N
VIN,Tipo,Marca,Modelo,CapacidadCarga,ConsumoCombustible
...
VIN,Tipo,Marca,Modelo,CapacidadCarga,ConsumoCombustible
VIN,TipoRuta,Distancia_1,Distancia_2,...,Distancia_N
...
VIN,TipoRuta,Distancia_1,Distancia_2,...,Distancia_N
```

### Estructura:
- **Linea 1:** N = cantidad de vehiculos
- **Lineas 2 a N+1:** Informacion de cada vehiculo
- **Lineas N+2 en adelante:** Viajes realizados (cantidad variable)

### Campos de Vehiculos:
- **VIN:** Codigo unico (17 caracteres)
- **Tipo:** "Camion", "Camioneta", "Furgon"
- **Marca:** String
- **Modelo:** String
- **CapacidadCarga:** En kg (int)
- **ConsumoCombustible:** En km/litro (double)

### Campos de Viajes:
- **VIN:** Vehiculo que realizo los viajes
- **TipoRuta:** "Urbana", "Interurbana", "Carretera"
- **Distancias:** Lista variable de distancias en km (cada una es un viaje)

### Ejemplo de fleet_transport.txt:
```
3
1HGBH41JXMN109186,Camion,Volvo,FH16,25000,6.5
WAUHF68P16A397756,Camioneta,Ford,Ranger,1500,12.0
1FADP3K29EL223451,Furgon,Mercedes,Sprinter,3500,10.5
1HGBH41JXMN109186,Carretera,450,380,520
WAUHF68P16A397756,Urbana,45,38,52,60
WAUHF68P16A397756,Interurbana,180,220
1FADP3K29EL223451,Urbana,30,25,35,40,28
```

**REQUISITO:** Debes leer el archivo, crear los objetos vehiculo correctos segun el tipo, y almacenar los viajes.

**Puntos:** 20
- Lectura correcta del archivo: 8 pts
- Creacion de objetos segun tipo: 6 pts
- Almacenamiento de viajes: 6 pts

---

## PARTE 2: Jerarquia de Clases (15 puntos)

### Clase abstracta Vehiculo:
- Atributos comunes
- Metodo abstracto: `String getTipo()`
- Metodo abstracto: `double getFactorDesgaste()`
- Metodos concretos: getters, constructor

### Clases concretas:

**Camion:**
- FactorDesgaste = 2.5 (desgaste alto por carga pesada)

**Camioneta:**
- FactorDesgaste = 1.2 (desgaste medio)

**Furgon:**
- FactorDesgaste = 1.5 (desgaste medio-alto)

**Puntos:** 15
- Jerarquia correcta con herencia: 6 pts
- Polimorfismo aplicado: 5 pts
- Una sola lista para todos los vehiculos: 4 pts

---

## PARTE 3: PATRON STRATEGY - Calculo de Costos por Ruta (25 puntos)

Diferentes tipos de ruta tienen diferentes costos operacionales.

### Interface IEstrategiaRuta:
```java
double calcularCostoOperacional(Vehiculo v, List<Integer> distancias);
```

### Estrategias a Implementar:

**1. RutaUrbana:**
- Costo base: $500 por viaje
- Costo combustible: (distancia / consumo) × $1.200/litro
- Costo desgaste: distancia × factorDesgaste × $80
- Total por viaje: suma de los 3 costos
- Retorna: suma de todos los viajes

**2. RutaInterurbana:**
- Costo base: $800 por viaje
- Costo combustible: (distancia / consumo) × $1.200/litro
- Costo desgaste: distancia × factorDesgaste × $60
- Total por viaje: suma de los 3 costos

**3. RutaCarretera:**
- Costo base: $1.200 por viaje
- Costo combustible: (distancia / consumo) × $1.100/litro (mas eficiente)
- Costo desgaste: distancia × factorDesgaste × $50 (menos desgaste)
- Total por viaje: suma de los 3 costos

**Puntos:** 25
- Interface correcta: 5 pts
- 3 estrategias implementadas correctamente: 12 pts
- Calculo preciso de costos: 8 pts

---

## PARTE 4: PATRON VISITOR - Estadisticas (25 puntos)

### Interface IVisitorVehiculo:
```java
void visitarCamion(Camion c);
void visitarCamioneta(Camioneta c);
void visitarFurgon(Furgon f);
```

### Visitors a Implementar:

**1. VisitorKilometraje:**
- Acumula kilometraje total por tipo de vehiculo
- Calcula kilometraje promedio
- Identifica vehiculo con mas km recorridos

**2. VisitorConsumoTotal:**
- Calcula litros de combustible consumidos por vehiculo
- Formula: suma de (distancia / consumo) para cada viaje
- Total general de combustible

**3. VisitorCapacidadUtilizada:**
- Calcula capacidad total disponible de la flota
- Por tipo de vehiculo
- Total general

Todos los vehiculos deben implementar:
```java
void accept(IVisitorVehiculo visitor);
```

**Puntos:** 25
- Interface Visitor correcta: 5 pts
- 3 visitors implementados: 12 pts
- Double dispatch correcto: 8 pts

---

## PARTE 5: PATRON SINGLETON o FACTORY (10 puntos)

**OPCION A: Singleton - SistemaFlota**
- Constructor privado
- getInstance()
- Gestiona lista de vehiculos
- Aplica estrategias y visitors

**OPCION B: Factory - VehiculoFactory**
- Metodo: `crearVehiculo(String tipo, ...)`
- Validaciones de tipo
- Generacion automatica de codigo interno

Debes implementar **UNO** de los dos.

**Puntos:** 10
- Implementacion correcta del patron elegido: 10 pts

---

## PARTE 6: Salida Esperada (5 puntos)

```
=== SISTEMA DE GESTION DE FLOTA ===

Leyendo archivo: fleet_transport.txt...
Vehiculos cargados: 3
Viajes registrados: 5

=== VEHICULOS ===
1. [1HGBH41JXMN109186] Volvo FH16 (Camion)
   Capacidad: 25000 kg, Consumo: 6.5 km/l
   Viajes: 1 (3 trayectos)

2. [WAUHF68P16A397756] Ford Ranger (Camioneta)
   Capacidad: 1500 kg, Consumo: 12.0 km/l
   Viajes: 2 (6 trayectos)

3. [1FADP3K29EL223451] Mercedes Sprinter (Furgon)
   Capacidad: 3500 kg, Consumo: 10.5 km/l
   Viajes: 1 (5 trayectos)

=== COSTOS OPERACIONALES ===

Vehiculo: 1HGBH41JXMN109186 (Camion)
  Ruta Carretera - 3 viajes: $XXX.XXX

Vehiculo: WAUHF68P16A397756 (Camioneta)
  Ruta Urbana - 4 viajes: $XXX.XXX
  Ruta Interurbana - 2 viajes: $XXX.XXX

Vehiculo: 1FADP3K29EL223451 (Furgon)
  Ruta Urbana - 5 viajes: $XXX.XXX

COSTO TOTAL OPERACIONAL: $XXX.XXX

=== ESTADISTICAS (Visitor) ===

Kilometraje:
- Camion: XXX km
- Camioneta: XXX km
- Furgon: XXX km
Total: XXX km
Vehiculo con mas km: [VIN] (XXX km)

Consumo Combustible:
- Camion: XXX litros
- Camioneta: XXX litros
- Furgon: XXX litros
Total: XXX litros

Capacidad Flota:
- Camion: 25000 kg
- Camioneta: 1500 kg
- Furgon: 3500 kg
Total: 30000 kg
```

**Puntos:** 5 pts por formato claro y completo

---

## CONSIDERACIONES OBLIGATORIAS:

1. **Todos los vehiculos en UNA SOLA LISTA** ✓
2. **DEBE usar orientacion a objetos y herencia** ✓
3. **DEBE implementar Visitor Y Strategy OBLIGATORIAMENTE** ✓
4. **DEBE elegir Singleton O Factory** ✓
5. **NO usar ciclos dentro de ciclos** - usar metodos auxiliares ✓
6. **Usar nombres descriptivos** ✓
7. **Manejo de excepciones para File I/O** ✓
8. **Codigo exportado como .zip** ✓

---

## DISTRIBUCION DE PUNTAJE:

| Parte | Puntos | Porcentaje |
|-------|--------|------------|
| Lectura de Archivo | 20 | 20% |
| Jerarquia de Clases | 15 | 15% |
| Strategy Pattern | 25 | 25% |
| Visitor Pattern | 25 | 25% |
| Singleton/Factory | 10 | 10% |
| Salida/Formato | 5 | 5% |
| **TOTAL** | **100** | **100%** |

**Puntaje aprobatorio:** 60 puntos = 60% = Nota 4.0

---

## ARCHIVO DE DATOS: fleet_transport.txt

Crea tu propio archivo con al menos:
- 5 vehiculos (minimo 1 de cada tipo, puede repetir)
- 8 registros de viajes
- Distancias variables por viaje

---

## TIEMPO RECOMENDADO POR PARTE:

```
Minutos 0-20:   Leer problema, planificar estructura
Minutos 20-40:  Crear jerarquia de clases y lectura de archivo
Minutos 40-70:  Implementar Strategy Pattern
Minutos 70-110: Implementar Visitor Pattern
Minutos 110-140: Implementar Singleton/Factory
Minutos 140-170: Integracion, pruebas, correccion de bugs
Minutos 170-180: Revision final, exportar .zip
```

---

## CRITERIOS DE EVALUACION:

- **Compilacion:** Si no compila = nota 1.0
- **Patrones:** Si falta Strategy o Visitor = maximo nota 3.5
- **File I/O:** Si no lee archivo = maximo nota 3.0
- **Herencia:** Si no usa herencia = maximo nota 4.0
- **Excepciones:** Si el programa crashea = penalizacion -10 pts

---

## TIPS FINALES:

1. **Lee el enunciado DOS veces antes de programar**
2. **Compila frecuentemente** - no esperes al final
3. **Implementa por partes** - primero clases, luego patrones
4. **Prueba con pocos datos** antes de usar archivo completo
5. **Comenta codigo complejo** - ayuda al revisor
6. **Gestiona bien el tiempo** - no te atasques en una parte
7. **Si algo no funciona, continua** - puntos parciales cuentan

---

**NOTA:** Este es el ejercicio FINAL de practica. Simula condiciones reales de examen.

**OBJETIVO:** Completar en 3 horas con al menos 60% correcto.

**CUANDO TERMINES:**
1. Compila todo
2. Ejecuta y verifica salida
3. Exporta como .zip (Click derecho > Export > Archive File)
4. Anota tu tiempo real
5. Auto-evalua con la rubrica

**MUCHA SUERTE! Este es tu ultimo ensayo antes del examen real.**
