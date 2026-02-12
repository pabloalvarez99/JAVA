# Módulo 02 - Tipos y Colecciones

## Descripción

Este módulo profundiza en los tipos de datos y estructuras de colecciones de Python, explorando sus características, métodos y aplicaciones prácticas.

## Objetivos de Aprendizaje

Al completar este módulo serás capaz de:
- Dominar todos los tipos de datos básicos de Python
- Utilizar eficientemente colecciones (listas, tuplas, diccionarios, conjuntos)
- Comprender la mutabilidad e inmutabilidad
- Aplicar métodos de colecciones de forma óptima
- Seleccionar la estructura adecuada para cada problema
- Trabajar con colecciones anidadas
- Optimizar el manejo de datos en memoria

## Estructura de Archivos

```
02_Tipos_Colecciones/
├── ejercicios_solucion.py          # Ejercicios principales de tipos y colecciones
├── ejercicios_basico_solucion.py   # Tipos básicos y operaciones
├── ejercicios_intermedio_solucion.py  # Colecciones complejas
├── ejercicios_avanzado_solucion.py    # Optimización y patrones
├── ejercicios_extra_solucion.py    # Práctica intensiva
├── integracion_solucion.py         # Proyecto: Sistema de Gestión de Datos
└── README.md                       # Este archivo
```

## Contenido Detallado

### ejercicios_solucion.py

Conceptos fundamentales:
- Tipos numéricos (int, float, complex)
- Strings y métodos avanzados
- Booleanos y operaciones lógicas
- Listas: creación, acceso, modificación
- Tuplas: inmutabilidad y casos de uso
- Diccionarios: clave-valor y métodos
- Conjuntos: operaciones matemáticas

### ejercicios_basico_solucion.py

Fundamentos de tipos y colecciones:
- Conversión entre tipos
- Operaciones aritméticas avanzadas
- Manipulación de strings
- Indexación y slicing
- Métodos básicos de colecciones
- Iteración simple sobre colecciones

### ejercicios_intermedio_solucion.py

Técnicas intermedias:
- List comprehensions avanzadas
- Dictionary comprehensions
- Set comprehensions
- Colecciones anidadas
- Métodos de ordenamiento
- Filtrado y transformación de datos
- Copia superficial vs profunda

### ejercicios_avanzado_solucion.py

Conceptos avanzados y optimización:
- Collections module (Counter, defaultdict, OrderedDict)
- Manejo eficiente de memoria
- Algoritmos de búsqueda en colecciones
- Estructuras de datos personalizadas
- Serialización de colecciones
- Patrones de diseño con colecciones
- Rendimiento y complejidad algorítmica

### ejercicios_extra_solucion.py

Práctica adicional especializada:
- Procesamiento de datos reales
- Análisis de texto avanzado
- Estructuras de datos para algoritmos
- Optimización de consultas
- Manipulación de grandes volúmenes de datos
- Casos de uso industriales

### integracion_solucion.py

**Proyecto Final: Sistema de Gestión de Datos**

Aplicación completa que incluye:
- Gestión de inventario con múltiples colecciones
- Análisis de datos de ventas
- Sistema de reportes dinámicos
- Optimización de consultas
- Exportación en múltiples formatos
- Validación y limpieza de datos

## Cómo Usar Este Módulo

### 1. Orden Recomendado

```
1. Domina los tipos básicos (ejercicios_solucion.py)
2. Practica con operaciones fundamentales
3. Avanza a técnicas intermedias
4. Explora conceptos avanzados
5. Completa la práctica extra
6. Desarrolla el proyecto integrador
```

### 2. Método de Estudio

- **Experimenta activamente**: Prueba cada método con diferentes datos
- **Compara rendimiento**: Mide tiempo de ejecución de diferentes enfoques
- **Visualiza datos**: Usa prints para entender estructuras complejas
- **Resuelve problemas**: Aplica conceptos a casos reales

### 3. Tiempo Estimado

- **Tipos básicos**: 2-3 días
- **Colecciones fundamentales**: 3-4 días
- **Técnicas intermedias**: 3-4 días
- **Conceptos avanzados**: 3-4 días
- **Práctica extra**: 2-3 días (opcional)
- **Proyecto integrador**: 4-5 días

**Total estimado**: 3-4 semanas para completar el módulo

## Prerrequisitos

- Módulo 01 completado (Entorno y Ejecución)
- Comprensión básica de sintaxis Python
- Familiaridad con la línea de comandos

## Conceptos Clave

### Mutabilidad vs Inmutabilidad
- **Mutable**: Listas, diccionarios, conjuntos
- **Inmutable**: Tuplas, strings, números
- Implicaciones en rendimiento y uso de memoria

### Complejidad Algorítmica
- O(1) - Acceso directo en listas/diccionarios
- O(n) - Búsqueda lineal en listas
- O(log n) - Búsqueda binaria en datos ordenados

### Patrones Comunes
- **Data aggregation**: Reducir colecciones a valores únicos
- **Filtering**: Seleccionar elementos por criterio
- **Mapping**: Transformar cada elemento

## Cómo Ejecutar

```bash
# Navegar al directorio
cd STUDY/SOLUCIONES/PYTHON/02_Tipos_Colecciones

# Ejecutar ejercicios principales
python ejercicios_solucion.py

# Ejecutar diferentes niveles
python ejercicios_basico_solucion.py
python ejercicios_intermedio_solucion.py
python ejercicios_avanzado_solucion.py
python ejercicios_extra_solucion.py

# Ejecutar proyecto integrador
python integracion_solucion.py
```

## Errores Comunes y Soluciones

### 1. IndexError en listas
- **Causa**: Acceder fuera de rango
- **Solución**: Verificar límites con `len()` o usar try/except

### 2. KeyError en diccionarios
- **Causa**: Acceder a clave inexistente
- **Solución**: Usar `.get()` o verificar con `in`

### 3. Modificación durante iteración
- **Causa**: Cambiar tamaño de colección mientras se itera
- **Solución**: Crear copia o iterar sobre índices

### 4. Confusión entre copia y referencia
- **Causa**: Asignación no copia objetos mutables
- **Solución**: Usar `.copy()` o `deepcopy()`

## Proximos Pasos

Al completar este módulo, estarás listo para:
- Módulo 03: Control de Flujo
- Módulo 04: Funciones
- Estructuras de datos más complejas
- Algoritmos de ordenamiento y búsqueda

## Recursos Adicionales

- **Python Docs**: https://docs.python.org/es/3/tutorial/datastructures.html
- **Real Python - Data Structures**: https://realpython.com/python-data-structures/
- **Algorithmic Complexity**: https://wiki.python.org/moin/TimeComplexity

## Nota del Instructor

> Las colecciones son el corazón de Python. Dominarlas no solo te hace más productivo, sino que te permite escribir código más eficiente y legible. Dedica tiempo a entender cuándo usar cada estructura.

---

**Versión**: 1.0  
**Última actualización**: Febrero 2026  
**Autor**: Proyecto de Estudio Multi-lenguaje