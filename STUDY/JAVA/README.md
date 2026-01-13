****# Java Learning Project - Complete Progression

Sistema completo de aprendizaje de Java desde fundamentos hasta POO avanzada, patrones de diseño y preparación de exámenes.

## Quick Start

```bash
# Compilar y ejecutar un ejercicio
Utilidades\compilar.bat 01_Fundamentos 1

# O manualmente
cd 01_Fundamentos && javac Ejercicio1.java && java Ejercicio1
```

**¿Primera vez?** Abre el proyecto en VS Code - las extensiones recomendadas se sugerirán automáticamente.

## Recursos Esenciales

| Recurso | Propósito |
|---------|-----------|
| `PROGRESO.md` | Seguimiento de ejercicios completados |
| `00_Documentacion/REFERENCIA_RAPIDA.md` | Referencia completa de sintaxis Java |
| `MAPA_APRENDIZAJE.md` | Mapa visual de dependencias de conceptos |
| `00_Documentacion/ERRORES_COMUNES.md` | Errores comunes y soluciones |

## Estructura del Proyecto

```
JAVA/
│
├── 00_Documentacion/           # Referencias y guías
│   ├── Guias/                  # Tutoriales y guías de estudio
│   ├── CheatSheets/            # Referencias rápidas
│   ├── Examenes_PDF/           # PDFs de exámenes
│   ├── REFERENCIA_RAPIDA.md    # Sintaxis Java completa
│   └── ERRORES_COMUNES.md      # Troubleshooting
│
├── 01_Fundamentos/             # Ejercicios 1-9: Básicos
├── 02_POO_Basico/              # Ejercicios 10-15: POO
├── 03_Colecciones/             # Ejercicios 16-20: Colecciones
├── 04_POO_Avanzado/            # Ejercicios 21-36: Avanzado
├── 05_Patrones_Diseno/         # 22 ejercicios + guías de patrones
│
├── 06_Practica_Por_Tema/       # Ejercicios estilo examen por tema
│   ├── 01_Recursion/
│   ├── 02_Herencia/
│   ├── 03_Colecciones/
│   ├── 04_POO_Relaciones/      # 20 ejercicios + CHEATSHEET
│   ├── 05_File_IO/
│   ├── 06_Generics/
│   ├── 07_Excepciones/
│   └── 08_Estructuras_Datos/
│
├── 07_Practica_Por_Tipo/       # Ejercicios por tipo de habilidad
│   ├── Debug/                  # Encontrar y corregir bugs
│   ├── Tracing/                # Predecir salida de código
│   ├── Diseno/                 # Diseño de **sistemas**
│   ├── Algoritmos/             # Algoritmos **varios**
│   └── Strings/                # Manipulación de strings
│
├── 08_Examenes_Simulacro/      # 5 exámenes completos (3h cada uno)
│
├── 09_Proyectos/               # Proyectos completos
│   ├── RentaCar/               # Sistema de arriendo (patrones)
│   ├── SistemaChat/            # Sistema de chat
│   ├── SistemaMetro/           # Sistema de metro
│   ├── UCN_Ay4/                # Sistema UCN personas-unidades
│   ├── Biblioteca/             # Sistema de biblioteca
│   └── Descripciones/          # 10 proyectos complejos (guías)
│
├── Utilidades/                 # Scripts y herramientas
│   ├── compilar.bat            # Compilar y ejecutar
│   ├── verificar.bat           # Validar que todo compila
│   ├── limpiar.bat             # Limpiar archivos .class
│   └── helpers/                # Utilidades Java
│
├── README.md                   # Este archivo
├── PROGRESO.md                 # Seguimiento de progreso
└── MAPA_APRENDIZAJE.md         # Mapa de conceptos
```

## Ruta de Aprendizaje

```
FASE 1: FUNDAMENTOS (Semana 1-2)
┌─────────────────────────────────────────┐
│  01_Fundamentos (9 ejercicios)          │
│  Variables, loops, arrays, métodos      │
└─────────────────┬───────────────────────┘
                  ▼
FASE 2: POO BÁSICO (Semana 3-4)
┌─────────────────────────────────────────┐
│  02_POO_Basico (6 ejercicios)           │
│  Clases, herencia, polimorfismo         │
└─────────────────┬───────────────────────┘
                  ▼
FASE 3: COLECCIONES (Semana 5)
┌─────────────────────────────────────────┐
│  03_Colecciones (5 ejercicios)          │
│  ArrayList, HashMap, excepciones        │
└─────────────────┬───────────────────────┘
                  ▼
FASE 4: AVANZADO (Semana 6-8)
┌─────────────────────────────────────────┐
│  04_POO_Avanzado (16 ejercicios)        │
│  Algoritmos, Streams, Generics          │
└─────────────────┬───────────────────────┘
                  ▼
FASE 5: PATRONES (Semana 9-10)
┌─────────────────────────────────────────┐
│  05_Patrones_Diseno (22 ejercicios)     │
│  Strategy, Visitor, Singleton, Factory  │
└─────────────────┬───────────────────────┘
                  ▼
FASE 6: PRÁCTICA EXAMEN (Semana 11-12)
┌─────────────────────────────────────────┐
│  06_Practica_Por_Tema                   │
│  07_Practica_Por_Tipo                   │
│  08_Examenes_Simulacro                  │
└─────────────────────────────────────────┘
```

**Total: ~100 ejercicios + 5 proyectos + 5 exámenes = ~100-120 horas**

## Scripts de Utilidad

| Script | Propósito | Ejemplo |
|--------|-----------|---------|
| `compilar.bat` | Compilar y ejecutar | `Utilidades\compilar.bat 02_POO_Basico 10` |
| `verificar.bat` | Verificar compilación | `Utilidades\verificar.bat all` |
| `limpiar.bat` | Limpiar .class | `Utilidades\limpiar.bat` |

## Resumen de Ejercicios

### Aprendizaje Progresivo (01-05)

| Carpeta | Ejercicios | Temas |
|---------|------------|-------|
| 01_Fundamentos | 1-9 | Variables, tipos, loops, arrays, métodos |
| 02_POO_Basico | 10-15 | Clases, herencia, polimorfismo, interfaces |
| 03_Colecciones | 16-20 | ArrayList, HashMap, HashSet, Queue |
| 04_POO_Avanzado | 21-36 | Algoritmos, Generics, Streams, Threads |
| 05_Patrones_Diseno | 22 | Strategy, Visitor, Singleton, Factory, Builder |

### Práctica para Examen (06-08)

| Carpeta | Contenido | Propósito |
|---------|-----------|-----------|
| 06_Practica_Por_Tema | 8 temas, ~12 ejercicios c/u | Dominar conceptos específicos |
| 07_Practica_Por_Tipo | 5 tipos de ejercicio | Practicar habilidades específicas |
| 08_Examenes_Simulacro | 5 exámenes completos | Simular condiciones reales (3h) |

### Proyectos (09)

| Proyecto | Descripción | Patrones |
|----------|-------------|----------|
| RentaCar | Sistema de arriendo de vehículos | Strategy, Visitor |
| SistemaChat | Sistema de mensajería | Observer |
| SistemaMetro | Sistema de transporte | - |
| UCN_Ay4 | Gestión personas-unidades | Asociación |
| Biblioteca | Sistema de préstamos | Asociación |

## Conceptos Cubiertos

| Categoría | Temas |
|-----------|-------|
| **Básicos** | Variables, tipos, operadores, control de flujo |
| **POO** | Clases, encapsulamiento, herencia, polimorfismo |
| **Colecciones** | ArrayList, HashMap, HashSet, TreeSet, Queue |
| **Algoritmos** | Ordenamiento (Bubble, Merge, Quick), Búsqueda binaria |
| **Estructuras** | Stack, Queue, Linked List, BST |
| **Patrones** | Singleton, Factory, Strategy, Visitor, Builder, Observer |
| **Java Moderno** | Streams, Lambdas, Optional, Generics |
| **Avanzado** | Threads, File I/O, Serialización |

## Configuración VS Code

El proyecto incluye configuración preconfigurada de VS Code:
- Recomendaciones de extensiones Java
- Configuraciones de debug
- Formato de código
- Configuraciones de ejecución

**Solo abre la carpeta en VS Code y acepta las recomendaciones de extensiones.**

## Troubleshooting

¿Tienes problemas? Revisa `00_Documentacion/ERRORES_COMUNES.md` para:
- Errores de compilación y soluciones
- Excepciones de runtime explicadas
- Patrones de errores lógicos
- Tips de debugging

## Requisitos

- **Java:** JDK 17+ recomendado
- **Editor:** VS Code (con Java Extension Pack), IntelliJ, o Eclipse

---

**Empezar aquí:** `01_Fundamentos/Ejercicio1.java`

**Seguir progreso:** `PROGRESO.md`

**¿Necesitas sintaxis?** `00_Documentacion/REFERENCIA_RAPIDA.md`

**¿Atascado?** `00_Documentacion/ERRORES_COMUNES.md`

---

**"La mejor forma de aprender a programar es programando"**
