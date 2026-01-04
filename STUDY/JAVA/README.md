# Java Learning Project - Complete Progression

A comprehensive Java learning system from basics to advanced OOP, design patterns, and exam preparation.

## Quick Start

```bash
# Compile & run an exercise
compilar.bat 01_Fundamentos 1

# Or manually
cd 01_Fundamentos && javac Ejercicio1.java && java Ejercicio1
```

**First time?** Open the project in VS Code - recommended extensions will be suggested automatically.

## Essential Resources

| Resource | Purpose |
|----------|---------|
| `PROGRESO.md` | Track completed exercises with checkboxes |
| `REFERENCIA_RAPIDA.md` | Complete Java syntax reference |
| `MAPA_APRENDIZAJE.md` | Visual concept dependency map |
| `ERRORES_COMUNES.md` | Common errors and solutions |

## Project Structure

```
JAVA/
├── 01_Fundamentos/           # Exercises 1-9: Basics
├── 02_POO_Basico/            # Exercises 10-15: OOP
├── 03_Colecciones/           # Exercises 16-20: Collections
├── 04_Avanzado/              # Exercises 21-36: Advanced
├── 05_Patrones_Diseno/       # 22 pattern exercises + exam prep
│   ├── ejercicios/           # Exercise files
│   ├── guias/                # Pattern guides
│   ├── preparacion_examen/   # Cheat sheets, flashcards
│   └── datos/                # Data files
├── 06_Proyectos_Complejos/   # 10 full-system projects
├── Proyectos/
│   ├── SistemaChat/          # Chat system implementation
│   ├── SistemaMetro/         # Metro system
│   └── RentaCar/             # Exam solution (patterns demo)
├── Documentacion/            # Guides, PDFs, references
├── Utilidades/               # Test runners, utilities
├── .vscode/                  # VS Code configuration (auto-setup)
│
├── PROGRESO.md               # Progress tracker
├── REFERENCIA_RAPIDA.md      # Complete syntax reference
├── MAPA_APRENDIZAJE.md       # Concept dependency map
├── ERRORES_COMUNES.md        # Troubleshooting guide
├── compilar.bat              # Compile & run
├── verificar.bat             # Validate exercises compile
└── limpiar.bat               # Clean .class files
```

## Learning Path

```
01_Fundamentos (9 exercises)         WEEK 1-2
    │ Variables, loops, arrays, methods
    ▼
02_POO_Basico (6 exercises)          WEEK 3-4
    │ Classes, inheritance, polymorphism
    ▼
03_Colecciones (5 exercises)         WEEK 5
    │ ArrayList, HashMap, exceptions
    ▼
04_Avanzado (16 exercises)           WEEK 6-8
    │ Algorithms, Streams, Generics
    ▼
05_Patrones_Diseno (22 exercises)    WEEK 9-10
    │ Strategy, Visitor, Singleton, Factory
    ▼
06_Proyectos_Complejos (10 projects) WEEK 11-12
    │ Full system implementations
```

**Total: 68 exercises + 3 projects = ~80-100 hours**

## Utility Scripts

| Script | Purpose | Example |
|--------|---------|---------|
| `compilar.bat` | Compile & run | `compilar.bat 02_POO_Basico 10` |
| `verificar.bat` | Check all compile | `verificar.bat all` |
| `limpiar.bat` | Remove .class files | `limpiar.bat` |

## Exercise Overview

### 01_Fundamentos (1-9)
| # | Topic | | # | Topic |
|---|-------|-|---|-------|
| 1 | Variables | | 6 | Switch |
| 2 | Scanner | | 7 | Arrays |
| 3 | If-else | | 8 | Methods |
| 4 | While | | 9 | 2D Arrays |
| 5 | For | | | |

### 02_POO_Basico (10-15)
Classes, Constructors, Linked List, Inheritance, Polymorphism, Interfaces

### 03_Colecciones (16-20)
ArrayList, Exceptions, HashMap, Queue, HashSet/TreeSet

### 04_Avanzado (21-36)
Sorting, Recursion, Generics, Stack, Binary Search, MergeSort,
Enum/Optional, Streams/Lambdas, Patterns, Comparator, QuickSort,
BST, File I/O, Builder/Observer, Threads, Advanced Collections

### 05_Patrones_Diseno (22 exercises)
- **Guided (1-10):** Complete tutorials
- **Independent (11-22):** Self-practice
- **Ejercicio10:** Exact exam replica!

### 06_Proyectos_Complejos
10 full-system implementations for advanced practice

## Key Concepts Covered

| Category | Topics |
|----------|--------|
| **Basics** | Variables, types, operators, control flow |
| **OOP** | Classes, encapsulation, inheritance, polymorphism |
| **Collections** | ArrayList, HashMap, HashSet, TreeSet, Queue |
| **Algorithms** | Sorting (Bubble, Merge, Quick), Binary Search |
| **Structures** | Stack, Queue, Linked List, BST |
| **Patterns** | Singleton, Factory, Strategy, Visitor, Builder, Observer |
| **Modern Java** | Streams, Lambdas, Optional, Generics |
| **Advanced** | Threads, File I/O, Serialization |

## VS Code Setup

The project includes pre-configured VS Code settings:
- Java extension recommendations
- Debug configurations
- Code formatting
- Run configurations

**Just open the folder in VS Code and accept the extension recommendations.**

## Troubleshooting

Having issues? Check `ERRORES_COMUNES.md` for:
- Compilation errors and fixes
- Runtime exceptions explained
- Logic error patterns
- Debugging tips

## Requirements

- **Java:** JDK 17+ recommended
- **Editor:** VS Code (with Java Extension Pack), IntelliJ, or Eclipse

## Documentation

| Folder | Content |
|--------|---------|
| `Documentacion/Guias/` | Study guides, tutorials |
| `Documentacion/Examenes/` | PDF exam papers |
| `Documentacion/CheatSheets/` | Quick references |

---

**Start here:** `01_Fundamentos/Ejercicio1.java`

**Track progress:** `PROGRESO.md`

**Need syntax?** `REFERENCIA_RAPIDA.md`

**Stuck?** `ERRORES_COMUNES.md`

---

**"The best way to learn programming is by programming"**
