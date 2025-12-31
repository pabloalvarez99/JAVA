# 03 - Colecciones

Java Collections Framework and exception handling.

## Exercises

| # | Topic | Difficulty | Key Concepts |
|---|-------|------------|--------------|
| 16 | ArrayList | ⭐⭐⭐⭐⭐⭐ | dynamic lists, add/remove/get |
| 17 | Exceptions | ⭐⭐⭐⭐⭐⭐ | try-catch, throw, custom exceptions |
| 18 | HashMap | ⭐⭐⭐⭐⭐⭐ | key-value pairs, O(1) lookup |
| 19 | LinkedList & Queue | ⭐⭐⭐⭐⭐⭐⭐ | FIFO, offer/poll/peek |
| 20 | HashSet & TreeSet | ⭐⭐⭐⭐⭐⭐⭐ | unique elements, equals/hashCode |

## Collections Hierarchy

```
         Collection
         /        \
       List       Set
       /  \      /   \
ArrayList LinkedList HashSet TreeSet

         Map
        /   \
   HashMap  TreeMap
```

## Key Operations

| Collection | Add | Get | Remove | Search |
|-----------|-----|-----|--------|--------|
| ArrayList | add(e) | get(i) | remove(i) | contains(e) |
| HashMap | put(k,v) | get(k) | remove(k) | containsKey(k) |
| HashSet | add(e) | - | remove(e) | contains(e) |
| Queue | offer(e) | peek() | poll() | - |

## Compile & Run

```bash
javac Ejercicio16.java
java Ejercicio16
```

## Learning Goals

After completing these exercises, you should be able to:
- Use ArrayList for dynamic lists
- Handle exceptions properly with try-catch
- Store key-value pairs with HashMap
- Implement queues with LinkedList
- Use Sets for unique elements

## Next Steps

Continue to `04_Avanzado/` for advanced algorithms and data structures.
