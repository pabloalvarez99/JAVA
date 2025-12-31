# Resumen de Creacion - Ejercicios POO Nivel Medio

**Fecha de creacion:** 15 de noviembre de 2024
**Carpeta:** C:\Users\Pablo\Documents\Build\1\EjerciciosPOO_NivelMedio

---

## Analisis del Examen Original

He analizado el PDF del examen "Prueba 2 - POO" y identifique los siguientes conceptos clave:

### Problema 1: Ruteo de Codigo (0.3 puntos)
- **Patrones identificados:** Singleton, Strategy
- **Tecnologias:** Java Swing (GUI con JFrame, JPanel, JButton)
- **Layouts:** BoxLayout (Horizontal y Vertical)
- **Validacion:** Entrada de RUT con excepciones
- **Habilidades evaluadas:**
  - Tracing de codigo complejo
  - Comprension de flujo de ejecucion
  - Identificacion de patrones
  - Prediccion de GUI resultante

### Problema 2: Rent a Car (0.7 puntos)
- **Conceptos core:**
  - Jerarquia de clases: Vehiculo > {Camioneta, SUV, Auto}
  - File I/O: Lectura de archivo estructurado (fleet.txt)
  - Modos de manejo que afectan eficiencia
  - Calculos de consumo y odometro

- **Patrones OBLIGATORIOS:**
  - Visitor Pattern (obligatorio)
  - Strategy Pattern (obligatorio)
  - Singleton O Factory (elegir uno)

- **Arquitectura requerida:**
  - Sistema centralizado
  - Una sola lista para toda la flota
  - No ciclos anidados
  - Manejo de excepciones

- **Calculos complejos:**
  - Eficiencia variable segun modo (Eco/Normal/Sport)
  - Consumo de combustible por viaje
  - Estadisticas por categoria
  - Mayor consumo por tipo de vehiculo

---

## Estructura de Carpeta Creada

```
EjerciciosPOO_NivelMedio/
│
├── datos/                          # Archivos de prueba
│   ├── estudiantes.txt             # Para Ejercicio 5
│   ├── flota.txt                   # Para Ejercicio 7
│   ├── fleet_simple.txt            # Para Ejercicio 8
│   └── fleet.txt                   # Para Ejercicio 10 (examen completo)
│
├── Ejercicios (10 archivos .md):
│   ├── Ejercicio01_BibliotecaBasica.md
│   ├── Ejercicio02_TiendaStrategy.md
│   ├── Ejercicio03_BancoSingleton.md
│   ├── Ejercicio04_RestauranteFactory.md
│   ├── Ejercicio05_LecturaArchivos.md
│   ├── Ejercicio06_VisitorIntroduccion.md
│   ├── Ejercicio07_FlotaTaxis.md
│   ├── Ejercicio08_RentaCarSimplificado.md
│   ├── Ejercicio09_RuteoGUI.md
│   └── Ejercicio10_RentaCarCompleto.md
│
└── Documentacion (4 archivos .md):
    ├── README.md                   # Estructura general
    ├── INICIO_AQUI.md              # Punto de partida
    ├── GUIA_ESTUDIO.md             # Conceptos y estrategia
    └── REFERENCIA_RAPIDA.md        # Cheat sheet
```

**Total:** 18 archivos creados

---

## Progresion de Dificultad

Los ejercicios fueron disenados con dificultad creciente gradual:

### NIVEL 1: Fundamentos (Ejercicios 1-4)
**Objetivo:** Dominar conceptos basicos y patrones individuales

**Ejercicio 1: Biblioteca Basica**
- Dificultad: ★★☆☆☆ (Facil-Medio)
- Herencia simple (Material > Libro/Revista/DVD)
- Polimorfismo basico
- ArrayList
- NO requiere patrones avanzados

**Ejercicio 2: Tienda con Strategy**
- Dificultad: ★★★☆☆ (Medio)
- Introduccion al patron Strategy
- Tres estrategias de descuento
- Cambio dinamico de estrategia
- Practica con interfaces

**Ejercicio 3: Banco con Singleton**
- Dificultad: ★★★☆☆ (Medio)
- Patron Singleton completo
- Verificacion de instancia unica
- Operaciones bancarias
- Validaciones

**Ejercicio 4: Restaurante con Factory**
- Dificultad: ★★★☆☆ (Medio)
- Patron Factory
- Creacion de objetos complejos (menus)
- Herencia de platos
- Metodos estaticos

### NIVEL 2: Conceptos Intermedios (Ejercicios 5-6)
**Objetivo:** File I/O y Visitor Pattern

**Ejercicio 5: Lectura de Archivos**
- Dificultad: ★★★☆☆ (Medio)
- File I/O con Scanner
- Parsing de datos CSV
- Exception handling
- Validaciones (RUT, rangos)
- Estadisticas complejas
- NO requiere patrones avanzados (enfoque en I/O)

**Ejercicio 6: Visitor - Introduccion**
- Dificultad: ★★★★☆ (Medio-Avanzado)
- Patron Visitor completo
- Double dispatch
- Jerarquia de paquetes
- Dos visitors diferentes
- Calculos complejos

### NIVEL 3: Integracion (Ejercicios 7-8)
**Objetivo:** Combinar multiples conceptos

**Ejercicio 7: Flota de Taxis**
- Dificultad: ★★★★☆ (Medio-Avanzado)
- File I/O + Strategy + Visitor
- Tres tipos de taxis con herencia
- Dos estrategias de tarifa
- Dos visitors (ganancias y costos)
- Calculos de rentabilidad
- PRACTICA COMPLETA de multiples patrones

**Ejercicio 8: Rent a Car Simplificado**
- Dificultad: ★★★★★ (Avanzado)
- VERSION SIMPLIFICADA del examen
- Misma estructura que el examen
- Datos mas simples
- Tres patrones obligatorios
- Sistema centralizado
- PREPARACION DIRECTA para Ejercicio 10

### NIVEL 4: Examen Real (Ejercicios 9-10)
**Objetivo:** Replicar condiciones de examen

**Ejercicio 9: Ruteo de Codigo GUI**
- Dificultad: ★★★☆☆ (Medio)
- Code tracing
- Singleton + Strategy
- Java Swing GUI
- SIMILAR A PROBLEMA 1 del examen
- Preguntas de analisis

**Ejercicio 10: Rent a Car Completo**
- Dificultad: ★★★★★ (Nivel Examen)
- REPLICA EXACTA del Problema 2
- 20 vehiculos
- Datos reales del examen
- Tres patrones obligatorios
- Arquitectura completa
- 3 horas de duracion
- EJERCICIO MAS IMPORTANTE

---

## Conceptos Cubiertos

### Design Patterns
- [x] Strategy Pattern (Obligatorio en examen)
- [x] Visitor Pattern (Obligatorio en examen)
- [x] Singleton Pattern (Opcional - elegir 1)
- [x] Factory Pattern (Opcional - elegir 1)

### OOP Fundamentals
- [x] Herencia (abstract classes)
- [x] Polimorfismo
- [x] Encapsulamiento
- [x] Interfaces
- [x] @Override
- [x] Constructores y super()

### Java Core
- [x] Collections (ArrayList, HashMap)
- [x] File I/O (Scanner, File)
- [x] Exception Handling (try-catch)
- [x] String manipulation (split, parsing)
- [x] Type conversions

### Advanced Topics
- [x] Java Swing GUI (JFrame, JPanel, JButton, Layouts)
- [x] Code tracing
- [x] Double dispatch (Visitor)
- [x] Software architecture (Sistema)
- [x] Avoiding nested loops
- [x] Data validation

### Problem-Solving
- [x] File parsing
- [x] Complex calculations
- [x] Statistics generation
- [x] Category-based analysis
- [x] Finding max/min values
- [x] Data aggregation

---

## Caracteristicas Especiales

### 1. Progresion Pedagogica
Cada ejercicio construye sobre los anteriores:
- Ejercicio 1 → Herencia basica
- Ejercicio 2 → + Strategy
- Ejercicio 3 → + Singleton
- Ejercicio 6 → + Visitor
- Ejercicio 7 → Strategy + Visitor juntos
- Ejercicio 10 → TODO combinado

### 2. Estructura Consistente
Todos los ejercicios siguen el mismo formato:
- Titulo con dificultad y tiempo
- Contexto del problema
- Requisitos detallados
- Ejemplo de ejecucion
- Que entregar
- Consideraciones importantes
- Pistas y ayudas

### 3. Similitud con Examen
- Ejercicio 9 replica Problema 1 (Ruteo)
- Ejercicio 10 replica Problema 2 (Rent a Car)
- Mismo formato de archivo
- Mismas formulas
- Mismos patrones requeridos

### 4. Archivos de Datos Incluidos
Todos los archivos .txt necesarios estan creados y listos para usar.

### 5. Documentacion Completa
- README.md: Vision general
- INICIO_AQUI.md: Por donde empezar
- GUIA_ESTUDIO.md: Conceptos profundos
- REFERENCIA_RAPIDA.md: Cheat sheet imprimible

---

## Tiempos Estimados

**Total de horas de practica:** ~12-15 horas

Desglose:
- Nivel 1 (Ejercicios 1-4): 2.5-3 horas
- Nivel 2 (Ejercicios 5-6): 2.5-3 horas
- Nivel 3 (Ejercicios 7-8): 3-3.5 horas
- Nivel 4 (Ejercicios 9-10): 4-5 horas

**Recomendacion:** Distribuir en 3-4 semanas de estudio.

---

## Formulas y Calculos Clave

### Rent a Car - Eficiencia por Modo

**IMPORTANTE:** El enunciado del examen es confuso. Aclaro:

**Modo Eco:** "10% menor consumo" = MAS eficiente
```
eficienciaReal = eficienciaNominal × 1.10
```

**Modo Normal:** Sin cambios
```
eficienciaReal = eficienciaNominal × 1.00
```

**Modo Sport:** "25% mayor consumo" = MENOS eficiente
```
eficienciaReal = eficienciaNominal × 0.75
```

### Consumo de Combustible
```
consumo (litros) = distancia (km) / eficiencia (km/l)
```

### Ejemplo Completo
```
Vehiculo: Eficiencia nominal = 10 km/l
Modo: Sport
Distancias: [100, 150, 200]

Calculo:
1. eficienciaReal = 10 × 0.75 = 7.5 km/l
2. consumo1 = 100 / 7.5 = 13.33 litros
3. consumo2 = 150 / 7.5 = 20.00 litros
4. consumo3 = 200 / 7.5 = 26.67 litros
5. consumoTotal = 60.00 litros
6. odometro = 450 km
```

---

## Consejos para Usar los Ejercicios

### Metodologia Recomendada:

1. **Lee enunciado DOS veces** completas
2. **Planifica en papel** antes de programar
3. **Implementa por fases** (clases → patrones → logica)
4. **Compila frecuentemente** (cada 10-15 lineas)
5. **Prueba con datos pequenos** primero
6. **Solo mira soluciones** si estas atascado >30 min

### Para Maximizar Aprendizaje:

- Haz cada ejercicio al menos DOS veces
- La segunda vez sin mirar tu codigo anterior
- Cronometrate para mejorar velocidad
- Toma notas de errores comunes
- Practica el Ejercicio 10 hasta dominarlo

---

## Archivos Mas Importantes

**Para empezar:**
1. INICIO_AQUI.md (lee primero)
2. Ejercicio01_BibliotecaBasica.md (primer ejercicio)

**Para estudiar conceptos:**
3. GUIA_ESTUDIO.md (teoria y estrategia)
4. REFERENCIA_RAPIDA.md (imprimir)

**Para practicar examen:**
5. Ejercicio09_RuteoGUI.md (Problema 1)
6. Ejercicio10_RentaCarCompleto.md (Problema 2)

---

## Siguiente Paso Recomendado

**AHORA:**
1. Abre `INICIO_AQUI.md`
2. Lee la seccion "Como Trabajar Cada Ejercicio"
3. Empieza con `Ejercicio01_BibliotecaBasica.md`

**Meta inmediata:**
Completar Ejercicios 1-4 en la primera semana.

**Meta final:**
Poder completar Ejercicio 10 en menos de 2.5 horas sin ayuda.

---

## Resumen

He creado una coleccion completa y progresiva de 10 ejercicios que te prepararan sistematicamente para el examen de POO. Los ejercicios:

- Aumentan gradualmente en dificultad
- Cubren TODOS los conceptos del examen
- Incluyen los mismos patrones requeridos
- Replican la estructura y formato del examen real
- Vienen con datos de prueba listos para usar
- Incluyen documentacion completa

**El Ejercicio 10 es una replica casi exacta del Problema 2 del examen real.**

**Total:** 18 archivos creados en `C:\Users\Pablo\Documents\Build\1\EjerciciosPOO_NivelMedio`

---

**Mucha suerte en tu preparacion y en el examen!**
