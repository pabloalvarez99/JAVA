# Ejercicios Tipo Prueba - Preparación Examen POO

Colección completa de **82 ejercicios + 5 exámenes simulacro** basados en exámenes reales universitarios de Programación Orientada a Objetos.

---

## Estructura del Repositorio

### 📚 Carpetas de Conceptos (8 carpetas)

| Carpeta | Ejercicios | Conceptos Cubiertos |
|---------|-----------|---------------------|
| **01_Recursion** | 12 | Recursión simple, Math.pow(), divide & conquer, torres de Hanoi |
| **02_Herencia** | 12 | Herencia simple/múltiple niveles, polimorfismo, clases abstractas |
| **03_Colecciones** | 12 | ArrayList, HashMap, HashSet, TreeSet, PriorityQueue |
| **04_Patrones_Diseno** | 12 | Strategy, Visitor, Singleton, Factory, Observer |
| **05_File_IO_Persistencia** | 12 | Lectura/escritura archivos, parsing CSV, serialización |
| **06_Generics** | 10 | Clases genéricas, bounded types, wildcards |
| **07_Excepciones** | 10 | Try-catch, throws, custom exceptions, finally |
| **08_Estructuras_Datos** | 12 | Listas enlazadas, pilas, colas, árboles binarios, grafos |

### 🎯 Exámenes Simulacro

| Examen | Duración | Problema 1 | Problema 2 |
|--------|----------|------------|------------|
| **Examen01_TipoA** | 3 horas | Code Tracing (30 pts) | Sistema de torneos (70 pts) |
| **Examen02_TipoB** | 3 horas | Code Tracing (30 pts) | Sistema de hospital (70 pts) |
| **Examen03_TipoC** | 3 horas | ClubDeYates (30 pts) | Mapaches Celulares (70 pts) - **REPLICA EXACTA** |
| **Examen04_TipoD** | 3 horas | Code Tracing (30 pts) | Restaurante con patrones (70 pts) |
| **Examen05_TipoE** | 3 horas | Recursión avanzada (30 pts) | RentaCar completo (70 pts) |

---

## Tipos de Ejercicios

Cada carpeta de concepto contiene 4 tipos de ejercicios:

### 🔨 Implementación (40% - archivos .md)
Escribir código desde cero siguiendo especificaciones detalladas. Similar a la parte 2 del examen (70 puntos).

**Formato**: Archivo `.md` con contexto, requisitos, ejemplo de ejecución y pistas.

**Ejemplo**: `01_Recursion/Implementacion/Ej01_Factorial_Fibonacci.md`

### 🐛 Debug (25% - archivos .java)
Código con bugs intencionados que debes encontrar y corregir.

**Formato**: Archivo `.java` compilable con bugs documentados y solución en carpeta Soluciones/.

**Ejemplo**: `01_Recursion/Debug/Debug01_Recursion_StackOverflow.java`

### 🔍 Code Tracing (20% - archivos .java)
Predecir la salida del código sin ejecutarlo. Similar a la parte 1 del examen (20-30 puntos).

**Formato**: Archivo `.java` con sección para escribir predicción y respuesta correcta al final.

**Ejemplo**: `01_Recursion/Tracing/Tracing01_Recursion_Simple.java`

### 📐 Diseño (15% - archivos .md)
Diseñar arquitectura de sistemas antes de implementar (diagramas UML, patrones).

**Formato**: Archivo `.md` con requisitos y tareas de diseño.

**Ejemplo**: `01_Recursion/Diseno/Diseno01_Sistema_Archivos_Recursivo.md`

---

## Dificultad Progresiva

Todos los ejercicios usan el sistema de estrellas:

| Nivel | Estrellas | Descripción | Tiempo estimado |
|-------|-----------|-------------|-----------------|
| **Básico** | ⭐⭐⭐ | Fundamentos del concepto | 25-35 min |
| **Intermedio** | ⭐⭐⭐⭐⭐ | Aplicación práctica | 40-50 min |
| **Avanzado** | ⭐⭐⭐⭐⭐⭐⭐ | Nivel examen universitario | 60-90 min |
| **Examen** | ⭐⭐⭐⭐⭐⭐⭐⭐⭐⭐ | Simulacro completo de examen | 3 horas |

**Progresión recomendada**: Dentro de cada carpeta, los ejercicios están ordenados de menor a mayor dificultad (Ej01 es más fácil que Ej05).

---

## Ejercicios Réplica de Exámenes Reales

Estos ejercicios son **réplicas exactas** de problemas de exámenes universitarios reales:

### Alta Prioridad (practicar primero)

1. **01_Recursion/Tracing/Tracing03_MathPow.java** ⭐⭐⭐⭐⭐
   - Réplica: Problema 1 del examen (20 pts)
   - Concepto: Recursión con Math.pow()

2. **01_Recursion/Implementacion/Ej03_Palindromo_Recursivo.md** ⭐⭐⭐⭐⭐
   - Réplica: Problema 3 del examen (20 pts)
   - Concepto: Palíndromo con recursión + Scanner

3. **01_Recursion/Implementacion/Ej04_Matriz_DivideConquer.md** ⭐⭐⭐⭐⭐⭐
   - Réplica: Problema 2 del examen (25 pts)
   - Concepto: Divide and conquer en matriz N×N

4. **08_Estructuras_Datos/Implementacion/Ej05_Arbol_Promedio_SinDescendientes.md** ⭐⭐⭐⭐⭐⭐⭐
   - Réplica: Problema 4 del examen (35 pts)
   - Concepto: Árbol binario con recursión

5. **02_Herencia/Tracing/Tracing03_Herencia_ClubYates.java** ⭐⭐⭐⭐⭐⭐⭐
   - Réplica: Problema 1 del examen 2 (30 pts)
   - Concepto: Ruteo de código con POO (ClubDeYates, Velero)

6. **05_File_IO_Persistencia/Implementacion/Ej03_Lectura_MultiArchivo_Mapaches.md** ⭐⭐⭐⭐⭐⭐⭐
   - Réplica parcial: Problema 2 del examen 2 (70 pts)
   - Concepto: File I/O con parsing de múltiples archivos

7. **09_Examenes_Completos/Examen03_TipoC/** ⭐⭐⭐⭐⭐⭐⭐⭐⭐⭐
   - Réplica completa: Examen real completo (100 pts)
   - Incluye: ClubDeYates + Mapaches Celulares

---

## Navegación y Uso

### Para Empezar

1. **Lee primero**: `GUIA_PREPARACION_EXAMEN.md` - Estrategias y consejos
2. **Revisa**: `INDICE_POR_DIFICULTAD.md` - Orden recomendado de estudio
3. **Trackea tu progreso**: `PROGRESO.md` - Marca ejercicios completados

### Orden Recomendado de Estudio

#### Semana 1-2: Fundamentos
```
01_Recursion/        → Ejercicios 1-3 (básicos)
02_Herencia/         → Ejercicios 1-2 (básicos)
03_Colecciones/      → Ejercicios 1-2 (básicos)
07_Excepciones/      → Ejercicios 1-2 (básicos)
```

#### Semana 3-4: Intermedio
```
01_Recursion/        → Ejercicios 4-5 (avanzados)
02_Herencia/         → Ejercicios 3-4 (avanzados)
03_Colecciones/      → Ejercicios 3-5 (avanzados)
04_Patrones_Diseno/  → Ejercicios 1-3 (Strategy, Visitor, Singleton)
05_File_IO/          → Ejercicios 1-2 (lectura básica)
```

#### Semana 5-6: Avanzado
```
04_Patrones_Diseno/  → Ejercicios 4-5 (Factory, Observer)
05_File_IO/          → Ejercicios 3-5 (parsing complejo)
06_Generics/         → Ejercicios 1-4 (todos)
08_Estructuras_Datos/ → Ejercicios 1-5 (listas, árboles)
```

#### Semana 7-8: Preparación Examen
```
Ejercicios REPLICA (practicar 7 ejercicios réplica)
09_Examenes_Completos/ → Examen01, Examen02 (simulacros)
```

#### Semana 9-10: Simulacros Finales
```
09_Examenes_Completos/ → Examen03, Examen04, Examen05
Tiempo real: 3 horas por examen, sin ayuda
```

### Cómo Usar Cada Tipo de Ejercicio

#### Implementación (.md)
1. Leer enunciado completo 2 veces
2. Planificar en papel (clases, métodos, relaciones)
3. Implementar en archivo `.java` separado
4. Probar con datos del ejemplo
5. Comparar con solución en `Soluciones/`

#### Debug (.java)
1. Leer código completo sin ejecutar
2. Intentar identificar bugs solo con inspección
3. Ejecutar y observar error
4. Corregir bugs
5. Verificar con solución

#### Tracing (.java)
1. **NO EJECUTAR** el código primero
2. Leer y predecir salida línea por línea
3. Escribir predicción en sección indicada
4. Ejecutar y comparar
5. Analizar diferencias si hubo errores

#### Diseño (.md)
1. Leer requisitos completos
2. Dibujar diagrama de dominio
3. Diseñar diagrama de clases UML
4. Identificar patrones de diseño
5. Verificar con solución de referencia

---

## Estructura de Soluciones

Cada ejercicio tiene su solución en la carpeta `Soluciones/`:

```
Soluciones/
├── 01_Recursion/
│   ├── Implementacion/
│   │   ├── Ej01_Solucion.java          # Código completo
│   │   └── Ej01_Explicacion.md         # Explicación del razonamiento
│   ├── Debug/
│   │   ├── Debug01_Solucion.java       # Código corregido
│   │   └── Debug01_Explicacion.md      # Qué estaba mal y por qué
│   └── ...
```

**Importante**: Intenta resolver el ejercicio ANTES de ver la solución. Las soluciones incluyen:
- Código completo y funcional
- Explicación del razonamiento
- Conceptos clave aplicados
- Errores comunes a evitar

---

## Archivos de Datos

Algunos ejercicios de File I/O requieren archivos de datos de prueba:

```
05_File_IO_Persistencia/datos/
├── estudiantes.csv
├── mapaches.txt
├── mapaches_posiciones.txt
└── fleet.txt

09_Examenes_Completos/ExamenXX/datos/
├── [archivos específicos del examen]
```

Estos archivos están incluidos y listos para usar en los ejercicios correspondientes.

---

## Relación con Exámenes Reales

### Estructura típica de examen (100 pts, 3 horas)

**Problema 1 (20-30 puntos, 30-45 min)**
- Tipo: Code Tracing o ruteo de código
- Practica con: Carpetas `/Tracing/` de cada concepto

**Problema 2 (70-80 puntos, 2-2.5 horas)**
- Tipo: Implementación completa
- Incluye: File I/O + POO + Patrones de diseño
- Entregables: Diagrama de dominio (10%), Diagrama de clases (15%), Código (75%)
- Practica con: Carpetas `/Implementacion/` y `09_Examenes_Completos/`

### Conceptos más frecuentes en exámenes

1. **Recursión** (aparece en 80% de los exámenes)
2. **File I/O con parsing** (70% de los exámenes)
3. **Herencia y polimorfismo** (90% de los exámenes)
4. **Patrones Strategy + Visitor** (60% de los exámenes)
5. **Estructuras de datos (árboles)** (50% de los exámenes)

---

## Checklist de Preparación

Antes del examen, verifica que puedes:

### Recursión
- [ ] Escribir caso base correctamente
- [ ] Identificar cuándo usar recursión
- [ ] Trazar ejecución de función recursiva

### POO
- [ ] Diseñar jerarquía de herencia con clase abstracta
- [ ] Implementar métodos abstractos y concretos
- [ ] Usar polimorfismo con ArrayList<ClaseBase>

### File I/O
- [ ] Leer archivo con Scanner
- [ ] Parsear líneas con split()
- [ ] Manejar FileNotFoundException
- [ ] Cerrar recursos correctamente

### Patrones de Diseño
- [ ] Implementar Strategy pattern
- [ ] Implementar Visitor pattern (double dispatch)
- [ ] Implementar Singleton
- [ ] Saber cuándo usar cada patrón

### Estructuras de Datos
- [ ] Implementar árbol binario de búsqueda
- [ ] Recorrer árbol con recursión
- [ ] Implementar lista enlazada con nodos

---

## Estadísticas del Repositorio

- **Total de ejercicios**: 82
- **Total de exámenes simulacro**: 5 (15 horas de práctica)
- **Archivos de código**: ~150 archivos .java/.md
- **Tiempo estimado de completar todo**: 80-100 horas
- **Ejercicios réplica de exámenes reales**: 7
- **Conceptos cubiertos**: 8 áreas principales

---

## Contribuciones y Feedback

Si encuentras errores o tienes sugerencias:
1. Revisa la carpeta `Documentacion/` del proyecto principal
2. Consulta `ERRORES_COMUNES.md` para debugging
3. Usa `REFERENCIA_RAPIDA.md` para sintaxis Java

---

## Enlaces Útiles

- **Plan de aprendizaje**: `../05_Patrones_Diseno/INICIO_AQUI.md`
- **Referencia Java**: `../REFERENCIA_RAPIDA.md`
- **Errores comunes**: `../ERRORES_COMUNES.md`
- **Mapa de conceptos**: `../MAPA_APRENDIZAJE.md`
- **Proyecto de referencia**: `../Proyectos/RentaCar/`

---

## Licencia y Uso

Este material es para uso educativo personal. Los ejercicios están basados en exámenes reales de la Universidad de Coquimbo (UCN) - Escuela de Ingeniería Civil en Computación e Informática.

---

**Última actualización**: 2026-01-13
**Versión**: 1.0
**Estado**: Completo - 87 recursos listos para usar

---

**¡Éxito en tu preparación para el examen! 🎯📚**
