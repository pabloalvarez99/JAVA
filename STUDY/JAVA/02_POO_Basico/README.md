# 02 - POO Basico

Object-Oriented Programming fundamentals: classes, encapsulation, and relationships.

## Exercises

| # | Topic | Difficulty | Key Concepts |
|---|-------|------------|--------------|
| 10 | Classes & Objects | ⭐⭐⭐⭐ | class definition, attributes, methods |
| 11 | Constructors & this | ⭐⭐⭐⭐⭐ | constructors, this keyword, overloading |
| 12 | Linked List | ⭐⭐⭐⭐⭐ | nodes, references, data structures |
| 13 | Inheritance | ⭐⭐⭐⭐⭐ | extends, super, IS-A relationship |
| 14 | Polymorphism | ⭐⭐⭐⭐⭐ | abstract classes, method overriding |
| 15 | Interfaces | ⭐⭐⭐⭐⭐ | implements, contracts, multiple inheritance |

## Core OOP Concepts

```
┌─────────────────────────────────────────┐
│           ENCAPSULATION                 │
│  private fields + public getters/setters│
└─────────────────────────────────────────┘
              ↓
┌─────────────────────────────────────────┐
│           INHERITANCE                   │
│     class Child extends Parent          │
└─────────────────────────────────────────┘
              ↓
┌─────────────────────────────────────────┐
│           POLYMORPHISM                  │
│  Parent obj = new Child();              │
│  obj.method(); // Child's implementation│
└─────────────────────────────────────────┘
              ↓
┌─────────────────────────────────────────┐
│           ABSTRACTION                   │
│  abstract classes + interfaces          │
└─────────────────────────────────────────┘
```

## Compile & Run

```bash
javac Ejercicio10.java
java Ejercicio10
```

## Learning Goals

After completing these exercises, you should be able to:
- Create classes with attributes and methods
- Implement encapsulation with private/public
- Use inheritance to extend classes
- Understand polymorphism and abstract classes
- Define and implement interfaces

## Next Steps

Continue to `03_Colecciones/` for Java Collections Framework.
