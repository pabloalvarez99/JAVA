# Modulo 00 - Fundamentos Absolutos

## Descripcion

Este modulo es el **punto de partida absoluto** para quienes nunca han programado. A diferencia del Modulo 01 que asume conocimientos basicos, aqui partimos desde cero.

## Objetivos de Aprendizaje

Al completar este modulo seras capaz de:
- Entender que es programar y como funciona Python
- Crear variables y usar diferentes tipos de datos
- Realizar operaciones matematicas basicas
- Usar condicionales (if/else) para tomar decisiones
- Crear bucles (for, while) para repetir tareas
- Trabajar con listas y diccionarios
- Crear funciones reutilizables
- Manejar errores basicos
- Crear un programa completo y funcional

## Estructura de Archivos

```
00_Fundamentos_Absolutos/
├── ejercicios_solucion.py          # 20 ejercicios introductorios
├── ejercicios_basico_solucion.py   # Ejercicios de consolidacion
├── ejercicios_intermedio_solucion.py  # Preparacion modulo 01
├── ejercicios_avanzado_solucion.py    # Nivel avanzado - puente al modulo 01
├── ejercicios_extra_solucion.py    # Practica adicional
└── integracion_solucion.py         # Proyecto: Agenda de Contactos
```

## Contenido Detallado

### ejercicios_solucion.py (20 Ejercicios)

1. **Tu primer programa** - Imprimir "Hola Mundo"
2. **Variables y tipos** - int, float, string, bool
3. **Operaciones matematicas** - +, -, *, /, //, %, **
4. **Input del usuario** - funcion input()
5. **Conversion de tipos** - int(), float(), str()
6. **Formato de strings** - concatenacion, f-strings
7. **Condicionales simples** - if, elif, else
8. **Operadores logicos** - and, or, not
9. **Bucles for** - range(), iteraciones
10. **Listas basicas** - crear, acceder, modificar
11. **Recorrer listas** - for con listas
12. **While loop** - bucles condicionales
13. **Tabla de multiplicar** - bucles anidados
14. **Diccionarios** - clave:valor, metodos
15. **Metodos de strings** - upper, lower, strip, replace
16. **Funciones simples** - definir y llamar
17. **List comprehension** - sintaxis concisa
18. **Manejo de errores** - try, except
19. **Tuplas y conjuntos** - estructuras especiales
20. **Calculadora** - integracion de conceptos

### ejercicios_basico_solucion.py

Ejercicios para consolidar conceptos:
- Calculo de areas y perimetros
- Conversion de temperaturas (Celsius/Fahrenheit)
- Clasificacion de numeros (positivo/negativo/par/impar)
- Años bisiestos
- Suma de naturales y factorial
- Numeros primos
- Operaciones con listas (max, min, promedio, invertir)
- Manipulacion de strings (vocales, palindromos)
- Frecuencia de caracteres
- Validaciones basicas

### ejercicios_intermedio_solucion.py

Preparacion para el Modulo 01:
- Manipulacion de paths con pathlib
- Informacion del sistema (simulada)
- Parseo de argumentos de linea de comandos
- Lectura de archivos
- Variables de entorno
- Modulos de la libreria estandar
- Estructura de proyectos Python
- Entornos virtuales (concepto)

### ejercicios_extra_solucion.py

Practica adicional intensiva:
- Calculo de IMC
- Interes compuesto
- Numeros perfectos
- Serie Fibonacci
- Juegos (adivina el numero, piedra-papel-tijeras)
- Manejo de fechas
- Ordenamiento y agrupacion de datos
- Analisis completo de texto

### ejercicios_avanzado_solucion.py

**Nivel Avanzado - Puente al Modulo 01**

Conceptos avanzados que preparan para el siguiente modulo:
- Funciones de orden superior (map, filter, reduce)
- Comprensiones anidadas
- Manejo de datos complejos y analisis
- Decoradores simples
- Generadores (yield)
- Recursividad
- Manejo de JSON
- Simulacion de clases con diccionarios
- Algoritmos de busqueda y ordenamiento
- Manejo avanzado de fechas

### integracion_solucion.py

**Proyecto Final: Agenda de Contactos**

Un sistema completo que incluye:
- Clases y objetos (Contacto, Agenda)
- CRUD completo (Crear, Leer, Actualizar, Eliminar)
- Busqueda y filtros
- Marcado de favoritos
- Exportacion de datos
- Estadisticas

## Como Usar Este Modulo

### 1. Orden Recomendado

```
1. Lee cada ejercicio en ejercicios_solucion.py
2. Intenta hacerlo solo primero
3. Compara con la solucion proporcionada
4. Practica modificando los ejemplos
5. Completa ejercicios_basico_solucion.py
6. Revisa ejercicios_intermedio_solucion.py
7. Practica con ejercicios_extra_solucion.py
8. Estudia ejercicios_avanzado_solucion.py (opcional pero recomendado)
9. Estudia el proyecto integrador
```

### 2. Metodo de Estudio

- **No copies y pegues**: Escribe cada linea tu mismo
- **Experimenta**: Cambia valores y observa resultados
- **Comete errores**: Aprende de los mensajes de error
- **Toma notas**: Escribe lo que aprendes
- **Practica diariamente**: 30 minutos al dia es mejor que 3 horas una vez por semana

### 3. Tiempo Estimado

- **Ejercicios 1-10**: 2-3 dias
- **Ejercicios 11-20**: 2-3 dias
- **Ejercicios basicos**: 2-3 dias
- **Ejercicios intermedios**: 2 dias
- **Ejercicios extra**: 3-4 dias (opcional pero recomendado)
- **Ejercicios avanzados**: 3-4 dias (opcional, preparacion modulo 01)
- **Proyecto integrador**: 2-3 dias

**Total estimado**: 2-4 semanas para completar el modulo (incluyendo avanzado)

## Requisitos Previos

- Python 3.7 o superior instalado
- Editor de texto (VS Code recomendado)
- Terminal/Consola basica

## Como Ejecutar

```bash
# Navegar al directorio
cd STUDY/SOLUCIONES/PYTHON/00_Fundamentos_Absolutos

# Ejecutar ejercicios principales
python ejercicios_solucion.py

# Ejecutar nivel avanzado (puente al modulo 01)
python ejercicios_avanzado_solucion.py

# Ejecutar proyecto integrador
python integracion_solucion.py

# Ejecutar otros niveles
python ejercicios_basico_solucion.py
python ejercicios_intermedio_solucion.py
python ejercicios_extra_solucion.py
```

## Errores Comunes a Evitar

1. **Confundir == con =**
   - `=` es asignacion
   - `==` es comparacion

2. **Olvidar convertir tipos**
   - input() siempre retorna string
   - Usar int() o float() para operaciones matematicas

3. **Indices fuera de rango**
   - Listas empiezan en indice 0
   - Ultimo elemento es len(lista) - 1

4. **Indentacion incorrecta**
   - Python usa espacios/tabs para estructura
   - Ser consistente (4 espacios recomendado)

5. **Nombres de variables**
   - No usar palabras reservadas
   - Ser descriptivo

## Proximos Pasos

Al completar este modulo, estas listo para:
- Modulo 01: Entorno y Ejecucion
- Modulo 02: Tipos y Colecciones (repaso + profundizacion)
- Modulo 03: Control de Flujo
- Modulo 04: Funciones

## Recursos Adicionales

- Documentacion oficial de Python: https://docs.python.org/es/3/
- Python Tutor (visualizador): https://pythontutor.com/
- Ejercicios online: https://www.hackerrank.com/domains/python

## Nota del Instructor

> Este modulo fue creado especificamente para que cualquier persona, sin importar su experiencia previa, pueda aprender a programar desde cero. Toma tu tiempo, no hay prisa. La programacion es una habilidad que se desarrolla con practica constante.

---

**Version**: 1.0  
**Ultima actualizacion**: Febrero 2026  
**Autor**: Proyecto de Estudio Multi-lenguaje
