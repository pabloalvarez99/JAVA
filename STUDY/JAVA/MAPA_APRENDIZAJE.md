# Learning Map - Concept Dependencies

Visual map showing how concepts build on each other.

---

## Concept Dependency Tree

```
                            ┌─────────────────────────────────┐
                            │         PROGRAMMING             │
                            │          FOUNDATION             │
                            └───────────────┬─────────────────┘
                                            │
                    ┌───────────────────────┼───────────────────────┐
                    │                       │                       │
                    ▼                       ▼                       ▼
            ┌───────────────┐       ┌───────────────┐       ┌───────────────┐
            │   Variables   │       │   Operators   │       │    Types      │
            │   (Ex. 1)     │       │   (Ex. 1-2)   │       │   (Ex. 1)     │
            └───────┬───────┘       └───────┬───────┘       └───────┬───────┘
                    │                       │                       │
                    └───────────────────────┼───────────────────────┘
                                            │
                                            ▼
                                    ┌───────────────┐
                                    │  Conditionals │
                                    │   (Ex. 3-4)   │
                                    └───────┬───────┘
                                            │
                            ┌───────────────┴───────────────┐
                            │                               │
                            ▼                               ▼
                    ┌───────────────┐               ┌───────────────┐
                    │     Loops     │               │    Switch     │
                    │   (Ex. 4-5)   │               │   (Ex. 6)     │
                    └───────┬───────┘               └───────────────┘
                            │
            ┌───────────────┴───────────────┐
            │                               │
            ▼                               ▼
    ┌───────────────┐               ┌───────────────┐
    │    Arrays     │               │    Methods    │
    │   (Ex. 7,9)   │               │   (Ex. 8)     │
    └───────┬───────┘               └───────┬───────┘
            │                               │
            └───────────────┬───────────────┘
                            │
                            ▼
            ┌───────────────────────────────┐
            │            CLASSES            │
            │           (Ex. 10)            │
            └───────────────┬───────────────┘
                            │
        ┌───────────────────┼───────────────────┐
        │                   │                   │
        ▼                   ▼                   ▼
┌───────────────┐   ┌───────────────┐   ┌───────────────┐
│ Constructors  │   │ Encapsulation │   │     this      │
│  (Ex. 10-11)  │   │  (Ex. 10-11)  │   │   (Ex. 11)    │
└───────┬───────┘   └───────┬───────┘   └───────────────┘
        │                   │
        └─────────┬─────────┘
                  │
                  ▼
        ┌───────────────────────────────┐
        │         INHERITANCE           │
        │          (Ex. 13)             │
        └───────────────┬───────────────┘
                        │
        ┌───────────────┼───────────────┐
        │               │               │
        ▼               ▼               ▼
┌───────────────┐ ┌───────────────┐ ┌───────────────┐
│  Polymorphism │ │   Abstract    │ │  Interfaces   │
│   (Ex. 14)    │ │   (Ex. 14)    │ │   (Ex. 15)    │
└───────┬───────┘ └───────┬───────┘ └───────┬───────┘
        │               │               │
        └───────────────┼───────────────┘
                        │
                        ▼
        ┌───────────────────────────────┐
        │        COLLECTIONS            │
        │        (Ex. 16-20)            │
        └───────────────┬───────────────┘
                        │
    ┌───────────────────┼───────────────────┐
    │                   │                   │
    ▼                   ▼                   ▼
┌─────────┐       ┌─────────┐       ┌─────────┐
│ArrayList│       │ HashMap │       │  Sets   │
│(Ex. 16) │       │(Ex. 18) │       │(Ex. 20) │
└────┬────┘       └────┬────┘       └────┬────┘
     │                 │                 │
     │                 │                 │
     ▼                 ▼                 ▼
┌─────────┐       ┌─────────┐       ┌─────────┐
│  Queue  │       │Exception│       │equals() │
│LinkedLst│       │Handling │       │hashCode │
│(Ex. 19) │       │(Ex. 17) │       │(Ex. 20) │
└────┬────┘       └─────────┘       └─────────┘
     │
     └──────────────────┐
                        │
                        ▼
        ┌───────────────────────────────┐
        │          ALGORITHMS           │
        │          (Ex. 21-26)          │
        └───────────────┬───────────────┘
                        │
    ┌───────────────────┼───────────────────┐
    │                   │                   │
    ▼                   ▼                   ▼
┌─────────┐       ┌─────────┐       ┌─────────┐
│ Sorting │       │Recursion│       │ Search  │
│(21,26,31)       │ (Ex.22) │       │(Ex. 25) │
└─────────┘       └─────────┘       └─────────┘
                        │
                        ▼
        ┌───────────────────────────────┐
        │       DATA STRUCTURES         │
        │        (Ex. 12, 24, 32)       │
        └───────────────┬───────────────┘
                        │
    ┌───────────────────┼───────────────────┐
    │                   │                   │
    ▼                   ▼                   ▼
┌─────────┐       ┌─────────┐       ┌─────────┐
│ Linked  │       │  Stack  │       │   BST   │
│  List   │       │(Ex. 24) │       │(Ex. 32) │
│(Ex. 12) │       └─────────┘       └─────────┘
└─────────┘
                        │
                        ▼
        ┌───────────────────────────────┐
        │         MODERN JAVA           │
        │        (Ex. 23, 27-28)        │
        └───────────────┬───────────────┘
                        │
    ┌───────────────────┼───────────────────┐
    │                   │                   │
    ▼                   ▼                   ▼
┌─────────┐       ┌─────────┐       ┌─────────┐
│Generics │       │ Streams │       │ Lambdas │
│(Ex. 23) │       │(Ex. 28) │       │(Ex. 28) │
└─────────┘       └─────────┘       └─────────┘
                        │
                        ▼
        ┌───────────────────────────────┐
        │       DESIGN PATTERNS         │
        │        (Ex. 29, 34)           │
        │     + 05_Patrones_Diseno      │
        └───────────────┬───────────────┘
                        │
    ┌───────────┬───────┼───────┬───────────┐
    │           │       │       │           │
    ▼           ▼       ▼       ▼           ▼
┌───────┐   ┌───────┐ ┌───────┐ ┌───────┐ ┌───────┐
│Single-│   │Factory│ │Strate-│ │Visitor│ │Builder│
│  ton  │   │       │ │  gy   │ │       │ │Observ.│
└───────┘   └───────┘ └───────┘ └───────┘ └───────┘
                        │
                        ▼
        ┌───────────────────────────────┐
        │          ADVANCED             │
        │       (Ex. 33, 35-36)         │
        └───────────────┬───────────────┘
                        │
    ┌───────────────────┼───────────────────┐
    │                   │                   │
    ▼                   ▼                   ▼
┌─────────┐       ┌─────────┐       ┌─────────┐
│ File I/O│       │ Threads │       │Advanced │
│(Ex. 33) │       │(Ex. 35) │       │Collectns│
└─────────┘       └─────────┘       │(Ex. 36) │
                                    └─────────┘
```

---

## Prerequisite Chain

Before starting an exercise, make sure you understand its prerequisites:

| Exercise | Prerequisites |
|----------|--------------|
| **1-3** | None |
| **4-6** | Variables (1), Conditionals (3) |
| **7-9** | Loops (4-5), Methods (8) |
| **10-11** | Arrays (7), Methods (8) |
| **12** | Classes (10), this (11) |
| **13-15** | Classes (10), Constructors (11) |
| **16-20** | Inheritance (13), Interfaces (15) |
| **21-26** | Collections (16-20), Recursion requires loops |
| **27-28** | Collections (16-20), Interfaces (15) |
| **29** | Interfaces (15), Polymorphism (14) |
| **30** | Interfaces (15), Generics (23) |
| **31-32** | Recursion (22), Generics (23) |
| **33** | Exceptions (17), try-with-resources |
| **34** | Patterns (29), Interfaces (15) |
| **35** | All previous concepts |
| **36** | Collections (16-20), Comparator (30) |

---

## Skill Progression Chart

```
BEGINNER                    INTERMEDIATE                 ADVANCED
   │                             │                           │
   │  Variables                  │  Classes                  │  Streams
   │  Types                      │  Objects                  │  Lambdas
   │  Operators                  │  Inheritance              │  Generics
   │  If-else                    │  Polymorphism             │  Patterns
   │  Loops                      │  Interfaces               │  Threads
   │  Arrays                     │  Collections              │  File I/O
   │  Methods                    │  Exceptions               │  BST
   │                             │  Algorithms               │
   │                             │                           │
   ▼                             ▼                           ▼
Week 1-2                    Week 3-6                    Week 7-10
(~20 hours)                (~40 hours)                 (~40 hours)
```

---

## Pattern Recognition

### When to use each collection:

| Need | Use |
|------|-----|
| Ordered list with duplicates | `ArrayList` |
| Fast key-value lookup | `HashMap` |
| Unique elements | `HashSet` |
| Sorted unique elements | `TreeSet` |
| FIFO queue | `LinkedList` as `Queue` |
| LIFO stack | `Stack` or `Deque` |
| Priority ordering | `PriorityQueue` |
| Sorted key-value | `TreeMap` |

### When to use each pattern:

| Problem | Pattern |
|---------|---------|
| Need exactly one instance | **Singleton** |
| Create objects without specifying class | **Factory** |
| Change behavior at runtime | **Strategy** |
| Operations on object structure | **Visitor** |
| Build complex objects step by step | **Builder** |
| Notify multiple objects of changes | **Observer** |
