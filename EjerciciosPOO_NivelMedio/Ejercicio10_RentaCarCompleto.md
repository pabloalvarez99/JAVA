# Ejercicio 10: Rent a Car - Version Completa (Nivel 4 - EXAMEN)
**Dificultad:** Avanzado (Nivel Examen)
**Tiempo estimado:** 3 horas
**Conceptos:** REPLICA EXACTA del Problema 2 del examen

---

## Contexto

Este ejercicio es una **replica del Problema 2 del examen real**. Una empresa de renta de vehiculos esta haciendo un sistema de seguimiento de su flota.

Los tipos de vehiculos que ofrecen son 3: **Camionetas, SUV y Autos**. De ellos se guarda la informacion del VIN (numero identificador unico de un vehiculo), la marca, modelo y la eficiencia de combustible medida en km/l.

## Modos de Manejo

Todos los vehiculos son automaticos y cuentan con 3 modos de manejo:

| Modo | Efecto en la eficiencia |
|------|------------------------|
| Modo Eco | La eficiencia de combustible es un 10% **menor** que la nominal (consume menos) |
| Modo Normal | La eficiencia de combustible es la nominal |
| Modo Sport | La eficiencia de combustible es un 25% **superior** a la nominal (consume mas) |

**IMPORTANTE:** El enunciado dice "10% menor" refiriendose al CONSUMO (es decir, la eficiencia es MEJOR).
- Eco: eficiencia_real = eficiencia_nominal × 1.10 (rinde mas)
- Normal: eficiencia_real = eficiencia_nominal × 1.00
- Sport: eficiencia_real = eficiencia_nominal × 0.75 (rinde menos)

## Formato del Archivo: fleet.txt

```
N
VIN,Marca,Modelo,Tipo_Vehiculo,Eficiencia
...
VIN,Marca,Modelo,Tipo_Vehiculo,Eficiencia
VIN,Modo_Manejo,Distancia_1,...,Distancia_N
...
VIN,Modo_Manejo,Distancia_1,...,Distancia_N
```

Ejemplo:
```
4
1HGBH41JXMN109186,Dodge,Ram 2500,Camioneta,6.8
WAUHF68P16A397756,Ford,F250,Camioneta,6.8
1FADP3K29EL223451,Ford,F150,Camioneta,8.75
KMHEC4A46CA012345,Mitsubishi,L200,Camioneta,9.45
1HGBH41JXMN109186,Sport,450,380,520,670,890,340,210,560
WAUHF68P16A397756,Normal,865,920,780,450,680,370
```

## Requisitos

### Se necesita lo siguiente:

1. Calcular el kilometraje recorrido de cada vehiculo
2. Calcular cuanto combustible fue utilizado por cada vehiculo (considerar el modo de conduccion)
3. Vehiculos con mayor consumo de combustible por categoria

### Salida esperada (formato exacto):

```
Dodge Ram 2500 CONSUMO: 664.56875 l ODOMETRO: 5020 km
Ford F250 CONSUMO: 715.4142857142857 l ODOMETRO: 4865 km
Ford F150 CONSUMO: 423.0944444444446 l ODOMETRO: 3703 km
Mitsubishi L200 CONSUMO: 387.8 l ODOMETRO: 3665 km
Mazda CX-7 CONSUMO: 300.1541666666667 l ODOMETRO: 3518 km
Ford Explorer CONSUMO: 451.1833333333334 l ODOMETRO: 4109 km
Chevrolet TrailBlazer CONSUMO: 364.945 l ODOMETRO: 3659 km
Chevrolet Tahoe CONSUMO: 513.1624999999999 l ODOMETRO: 3925 km
BMW X6 CONSUMO: 179.855 l ODOMETRO: 1696 km
Audi Q5 CONSUMO: 189.4727272727273 l ODOMETRO: 2189 km
Jeep Grand Cherokee CONSUMO: 234.22777777777776 l ODOMETRO: 1889 km
Chevrolet Aveo CONSUMO: 149.81 l ODOMETRO: 1968 km
Audi A6 CONSUMO: 345.52812500000005 l ODOMETRO: 5621 km
BMW 3 Series CONSUMO: 598.7749999999999 l ODOMETRO: 8132 km
Honda Civic CONSUMO: 432.16944444444465 l ODOMETRO: 7241 km
Honda Accord CONSUMO: 623.2291666666665 l ODOMETRO: 7231 km
Hyundai Sonata CONSUMO: 593.6269230769228 l ODOMETRO: 7314 km
Hyundai Accent CONSUMO: 453.65 l ODOMETRO: 7093 km
Kia Rio CONSUMO: 383.8694444444444 l ODOMETRO: 6544 km
Mazda Mazda6 CONSUMO: 426.03823529411767 l ODOMETRO: 6955 km

Mayor consumo:
Camioneta: WAUHF68P16A397756 (715.4142857142857 litros)
SUV: 1C4RDJEG9DC098442 (513.1624999999999 litros)
Auto: WBAEB53578C709570 (623.2291666666665 litros)
```

## Debe entregar:

- Codigo Java (100%)

## Consideraciones (IMPORTANTE - LEER TODO):

1. **Considere que los vehiculos de la flota deben estar almacenados en una sola lista.**

2. **Debe usar orientacion al objeto. Debe usar herencia.**

3. **Debe utilizar 3 patrones, de manera obligatoria el patron Visitor y Strategy, pero puede elegir entre Singleton o Factory.**

4. **Obtendra puntaje extra si la salida por pantalla aparece en una GUI.**

5. **Use la arquitectura vista en clase: DEBE crear un "Sistema".**

6. **No se deben utilizar ciclos dentro de ciclos. Use funciones para hacerse la vida mas facil.**

7. **El codigo fuente debe exportarlo como .zip y subirlo a Campus Virtual.**

## Arquitectura Sugerida:

```
Sistema (Singleton o creado por Factory)
├── List<Vehiculo> flota
├── leerArchivo()
├── procesarViajes()
├── mostrarEstadisticas()
└── calcularMayorConsumoPorCategoria()

Vehiculo (clase abstracta)
├── Camioneta
├── SUV
└── Auto

ModoManejoStrategy (interface)
├── ModoEco
├── ModoNormal
└── ModoSport

VisitorVehiculo (interface)
├── visitarCamioneta(Camioneta c)
├── visitarSUV(SUV s)
└── visitarAuto(Auto a)

Implementaciones Visitor:
├── CalculadorEstadisticas
└── MostradorResultados
```

## Formulas Clave:

**Calculo de eficiencia segun modo:**
```java
// Eco: consume 10% menos (es mas eficiente)
eficienciaReal = eficienciaNominal * 1.10;

// Normal: consume lo nominal
eficienciaReal = eficienciaNominal * 1.00;

// Sport: consume 25% mas (es menos eficiente)
eficienciaReal = eficienciaNominal * 0.75;
```

**Calculo de consumo por viaje:**
```java
consumo = distancia / eficienciaReal;
```

**Ejemplo completo:**
- Vehiculo: 10 km/l nominal
- Modo: Sport
- Distancias: [100, 150, 200]

Calculos:
```
eficienciaReal = 10 * 0.75 = 7.5 km/l
consumo1 = 100 / 7.5 = 13.33 litros
consumo2 = 150 / 7.5 = 20.00 litros
consumo3 = 200 / 7.5 = 26.67 litros
consumoTotal = 60.00 litros
odometro = 450 km
```

## Consejos para el Examen:

1. **Lee TODO el enunciado DOS veces** antes de empezar a programar
2. **Planifica tu arquitectura** en papel primero
3. **Implementa por fases:**
   - Fase 1: Jerarquia de vehiculos
   - Fase 2: Lectura de archivo
   - Fase 3: Patron Strategy
   - Fase 4: Patron Visitor
   - Fase 5: Sistema y estadisticas
4. **Compila frecuentemente** para detectar errores temprano
5. **Usa nombres descriptivos** - el codigo debe ser legible
6. **No uses ciclos anidados** - separa logica en metodos
7. **Maneja excepciones** apropiadamente

## Tiempo Sugerido:

- Analisis y planificacion: 15-20 minutos
- Implementacion: 2 horas - 2 horas 20 minutos
- Pruebas y depuracion: 20-30 minutos
- **Total: ~3 horas**

---

**ESTE ES EL EJERCICIO MAS IMPORTANTE. Replicalo completamente para estar preparado para el examen.**
