# Ejercicio 13: Sistema de Reservas de Hotel (PRACTICA INDEPENDIENTE)
**Dificultad:** Basica
**Tiempo estimado:** 45 minutos
**Conceptos:** Singleton Pattern, Collections, Validacion
**Fase:** 2 (SIN SOLUCIONES - PRACTICA INDEPENDIENTE)

---

## IMPORTANTE

**Este ejercicio NO incluye soluciones ni tutoriales paso a paso.**

Debes resolverlo de forma independiente aplicando los conceptos aprendidos en la Fase 1.

**Si te atascas:** Revisa el Ejercicio 03 (Singleton Pattern) de la Fase 1.

---

## CONTEXTO

Una cadena hotelera necesita un sistema centralizado para gestionar reservas. Solo debe existir UNA instancia del sistema de reservas en toda la aplicacion (Singleton).

## TIPOS DE HABITACIONES

El hotel tiene 3 tipos de habitaciones:

**Habitacion Simple:**
- Capacidad: 1 persona
- Precio por noche: $50
- Servicios: WiFi

**Habitacion Doble:**
- Capacidad: 2 personas
- Precio por noche: $80
- Servicios: WiFi, TV Cable

**Habitacion Suite:**
- Capacidad: 4 personas
- Precio por noche: $150
- Servicios: WiFi, TV Cable, Minibar, Jacuzzi

## RESERVA

Cada reserva tiene:
- Codigo unico (String) - ejemplo: "RES001"
- Nombre del huesped (String)
- Tipo de habitacion (String): "Simple", "Doble", "Suite"
- Numero de noches (int)
- Numero de personas (int)

## SISTEMA DE RESERVAS (SINGLETON)

El sistema debe:
1. Ser unico en toda la aplicacion (patron Singleton)
2. Almacenar todas las reservas en una lista
3. Crear nuevas reservas (validando codigo unico y capacidad)
4. Cancelar reservas por codigo
5. Buscar reserva por codigo
6. Calcular costo total de una reserva
7. Mostrar todas las reservas
8. Calcular ingresos totales del hotel
9. Contar reservas por tipo de habitacion

## REQUISITOS FUNCIONALES

1. Implementar clase Reserva con todos sus atributos
2. Implementar SistemaReservas como Singleton
3. Validar que el numero de personas no exceda la capacidad
4. Validar que no existan codigos duplicados
5. Calcular correctamente el costo (precio_por_noche × numero_de_noches)
6. Permitir cancelacion de reservas

## REQUISITOS TECNICOS

**OBLIGATORIO:**
- Implementar Singleton correctamente (constructor privado, getInstance())
- Usar ArrayList para almacenar reservas
- Validar TODOS los datos antes de crear reserva
- Manejo de errores con mensajes claros

## FORMATO DE SALIDA ESPERADO

```
=== SISTEMA DE RESERVAS - HOTEL PARADISE ===

--- CREANDO RESERVAS ---
Reserva creada: RES001 - Juan Perez - Suite - 3 noches - Costo: $450.00
Reserva creada: RES002 - Maria Lopez - Doble - 5 noches - Costo: $400.00
Reserva creada: RES003 - Carlos Ruiz - Simple - 2 noches - Costo: $100.00
ERROR: El codigo RES001 ya existe
ERROR: La habitacion Simple solo acepta 1 persona (solicitadas: 3)

--- TODAS LAS RESERVAS ---
RES001: Juan Perez - Suite - 3 noches - 4 personas - $450.00
RES002: Maria Lopez - Doble - 5 noches - 2 personas - $400.00
RES003: Carlos Ruiz - Simple - 2 noches - 1 persona - $100.00

--- ESTADISTICAS ---
Total de reservas: 3
Ingresos totales: $950.00

Reservas por tipo:
- Simple: 1 reserva(s)
- Doble: 1 reserva(s)
- Suite: 1 reserva(s)

--- CANCELANDO RESERVA ---
Reserva RES002 cancelada exitosamente
ERROR: No existe reserva con codigo RES999

--- RESERVAS ACTUALES ---
RES001: Juan Perez - Suite - 3 noches - 4 personas - $450.00
RES003: Carlos Ruiz - Simple - 2 noches - 1 persona - $100.00

Ingresos totales actualizados: $550.00

--- VERIFICACION SINGLETON ---
Sistema 1: SistemaReservas@1a2b3c4d
Sistema 2: SistemaReservas@1a2b3c4d
Son la misma instancia: true
```

## DATOS DE PRUEBA

```java
SistemaReservas sistema = SistemaReservas.getInstance();

// Crear reservas validas
sistema.crearReserva("RES001", "Juan Perez", "Suite", 3, 4);
sistema.crearReserva("RES002", "Maria Lopez", "Doble", 5, 2);
sistema.crearReserva("RES003", "Carlos Ruiz", "Simple", 2, 1);

// Intentar crear reserva duplicada
sistema.crearReserva("RES001", "Ana Martinez", "Doble", 2, 2);

// Intentar crear reserva que excede capacidad
sistema.crearReserva("RES004", "Luis Gomez", "Simple", 4, 3);

// Mostrar todas
sistema.mostrarReservas();
sistema.mostrarEstadisticas();

// Cancelar reserva
sistema.cancelarReserva("RES002");
sistema.cancelarReserva("RES999"); // No existe

// Mostrar actualizadas
sistema.mostrarReservas();
sistema.mostrarEstadisticas();

// Verificar Singleton
SistemaReservas sistema2 = SistemaReservas.getInstance();
System.out.println("Sistema 1: " + sistema);
System.out.println("Sistema 2: " + sistema2);
System.out.println("Son la misma instancia: " + (sistema == sistema2));
```

## CONSIDERACIONES

1. Los precios por noche son FIJOS por tipo de habitacion
2. El costo total = precio_por_noche × numero_de_noches
3. Validar capacidad ANTES de crear la reserva
4. Al cancelar una reserva, debe eliminarse de la lista
5. Los ingresos totales deben recalcularse correctamente

## CAPACIDADES POR TIPO

```java
// En tu codigo, define estas capacidades
Simple: 1 persona
Doble: 2 personas
Suite: 4 personas
```

## ESTRUCTURA SUGERIDA

```
Reserva
├── String codigo
├── String huesped
├── String tipoHabitacion
├── int noches
├── int personas
├── calcularCosto()
└── toString()

SistemaReservas (Singleton)
├── static SistemaReservas instance
├── List<Reserva> reservas
├── private SistemaReservas() (constructor)
├── static getInstance()
├── crearReserva()
├── cancelarReserva()
├── buscarReserva()
├── validarCapacidad()
├── mostrarReservas()
└── mostrarEstadisticas()
```

## CRITERIO DE EXITO

Tu programa funciona correctamente si:
- [x] La salida coincide EXACTAMENTE con la esperada
- [x] Solo existe UNA instancia del sistema (Singleton verificado)
- [x] Las validaciones funcionan correctamente
- [x] Los calculos de costos e ingresos son correctos
- [x] Las cancelaciones funcionan
- [x] El codigo compila sin errores

---

**RECUERDA:** Este es un ejercicio de PRACTICA INDEPENDIENTE. No hay soluciones proporcionadas.

**TIEMPO MAXIMO:** 45 minutos.

---

*Ejercicio de Practica Independiente - Fase 2*
