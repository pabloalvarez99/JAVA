# Ejercicio 16: Inventario de Farmacia (PRACTICA INDEPENDIENTE)
**Dificultad:** Media
**Tiempo estimado:** 90 minutos
**Conceptos:** Strategy + Visitor + File I/O
**Fase:** 2 (SIN SOLUCIONES - PRACTICA INDEPENDIENTE)

---

## IMPORTANTE

**Este ejercicio combina MULTIPLES patrones. Es un nivel similar al examen.**

**Si te atascas:** Revisa el Ejercicio 07 (combinacion de patrones) de la Fase 1.

---

## CONTEXTO

Una farmacia necesita un sistema para gestionar su inventario de medicamentos, calcular precios segun descuentos, y generar reportes.

## FORMATO DEL ARCHIVO: inventario.txt

```
5
MED001,Paracetamol,Analgesico,5.50,100
MED002,Amoxicilina,Antibiotico,12.00,50
MED003,Ibuprofeno,Analgesico,8.00,75
MED004,Omeprazol,Gastrico,15.00,30
MED005,Loratadina,Antihistaminico,6.50,60
```

**Estructura:** Codigo,Nombre,Categoria,PrecioBase,Stock

## CATEGORIAS DE MEDICAMENTOS (Herencia)

**Analgesico:**
- Requiere receta: NO
- Via: "Oral"

**Antibiotico:**
- Requiere receta: SI
- Duracion tratamiento (dias): Variable

**Gastrico:**
- Requiere receta: NO
- Tomar con comida: SI/NO

**Antihistaminico:**
- Requiere receta: NO
- Causa somnolencia: SI/NO

## ESTRATEGIAS DE DESCUENTO (Strategy)

**Sin Descuento:**
- Precio = Precio base

**Descuento Tercera Edad:** (15%)
- Precio = Precio base × 0.85

**Descuento Empleado:** (25%)
- Precio = Precio base × 0.75

## VISITORS

**VisitorReporte:**
- Muestra informacion detallada por categoria

**VisitorEstadisticas:**
- Cuenta medicamentos por categoria
- Calcula valor total del inventario
- Identifica medicamentos con stock bajo (<40)
- Calcula precio promedio

## FORMATO DE SALIDA ESPERADO

```
=== SISTEMA DE FARMACIA ===
Cargando inventario desde: inventario.txt
5 medicamentos cargados.

=== REPORTE DE INVENTARIO ===
[ANALGESICO] MED001 - Paracetamol
  Precio: $5.50 | Stock: 100 | Receta: No | Via: Oral

[ANTIBIOTICO] MED002 - Amoxicilina
  Precio: $12.00 | Stock: 50 | Receta: Si | Tratamiento: 7 dias

[ANALGESICO] MED003 - Ibuprofeno
  Precio: $8.00 | Stock: 75 | Receta: No | Via: Oral

[GASTRICO] MED004 - Omeprazol
  Precio: $15.00 | Stock: 30 | Receta: No | Con comida: Si

[ANTIHISTAMINICO] MED005 - Loratadina
  Precio: $6.50 | Stock: 60 | Receta: No | Somnolencia: No

=== PRECIOS CON DESCUENTO TERCERA EDAD ===
Paracetamol: $4.68
Amoxicilina: $10.20
Ibuprofeno: $6.80
Omeprazol: $12.75
Loratadina: $5.53

=== ESTADISTICAS ===
Total medicamentos: 5
- Analgesicos: 2
- Antibioticos: 1
- Gastricos: 1
- Antihistaminicos: 1

Valor total inventario: $2707.50
Precio promedio: $9.40
Medicamentos con stock bajo: 1 (Omeprazol)
```

## REQUISITOS TECNICOS

**OBLIGATORIO:**
- Herencia (clase abstracta Medicamento)
- Strategy para descuentos
- Visitor para reportes y estadisticas
- Lectura de archivo
- Todas las validaciones necesarias

## ESTRUCTURA SUGERIDA

```
Medicamento (abstract)
├── Analgesico
├── Antibiotico
├── Gastrico
└── Antihistaminico

EstrategiaDescuento (interface)
├── SinDescuento
├── DescuentoTerceraEdad
└── DescuentoEmpleado

VisitorMedicamento (interface)
├── VisitorReporte
└── VisitorEstadisticas

SistemaFarmacia
├── leerInventario()
├── aplicarDescuentos()
└── generarReportes()
```

**TIEMPO MAXIMO:** 90 minutos.

---

*Ejercicio de Practica Independiente - Fase 2*
