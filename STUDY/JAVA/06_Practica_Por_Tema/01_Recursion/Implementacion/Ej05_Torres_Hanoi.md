# Ejercicio 5: Torres de Hanoi

**Dificultad:** ⭐⭐⭐⭐⭐⭐⭐
**Tiempo estimado:** 75 minutos
**Conceptos:** Recursión compleja, múltiples llamadas recursivas, divide and conquer

---

## Contexto

Las Torres de Hanoi es un rompecabezas matemático clásico que consiste en:
- 3 torres (A, B, C)
- N discos de diferentes tamaños
- Los discos empiezan apilados en la torre A (del más grande abajo al más pequeño arriba)
- **Objetivo**: Mover todos los discos a la torre C

**Reglas**:
1. Solo se puede mover un disco a la vez
2. Solo se puede mover el disco superior de una pila
3. Un disco más grande nunca puede estar sobre uno más pequeño

---

## Requisitos

### Método principal:
```java
public static void hanoi(int n, char origen, char destino, char auxiliar)
```

**Parámetros**:
- `n`: Número de discos
- `origen`: Torre origen (ej: 'A')
- `destino`: Torre destino (ej: 'C')
- `auxiliar`: Torre auxiliar (ej: 'B')

**Funcionalidad**:
- Imprime los movimientos necesarios para resolver el puzzle
- Usa recursión
- Número mínimo de movimientos: 2^n - 1

**Algoritmo**:
1. Mover n-1 discos de origen a auxiliar (usando destino como auxiliar)
2. Mover el disco más grande de origen a destino
3. Mover n-1 discos de auxiliar a destino (usando origen como auxiliar)

---

## Ejemplo de Ejecución

### Con 2 discos:
```
Torres de Hanoi con 2 discos:

Movimiento 1: Mover disco de A a B
Movimiento 2: Mover disco de A a C
Movimiento 3: Mover disco de B a C

Total de movimientos: 3
```

### Con 3 discos:
```
Torres de Hanoi con 3 discos:

Movimiento 1: Mover disco de A a C
Movimiento 2: Mover disco de A a B
Movimiento 3: Mover disco de C a B
Movimiento 4: Mover disco de A a C
Movimiento 5: Mover disco de B a A
Movimiento 6: Mover disco de B a C
Movimiento 7: Mover disco de A a C

Total de movimientos: 7
```

### Con 4 discos:
```
Total de movimientos: 15
```

---

## Debe entregar:

- [ ] Método `hanoi(int n, char origen, char destino, char auxiliar)` recursivo
- [ ] Contador de movimientos
- [ ] Main() que prueba con n=1, 2, 3, 4, 5
- [ ] Formato de salida claro

---

## Pistas:

<details>
<summary>Pista 1: Caso base</summary>

```java
if (n == 1) {
    System.out.println("Mover disco de " + origen + " a " + destino);
    return;
}
```

Si solo hay 1 disco, simplemente muévelo de origen a destino.
</details>

<details>
<summary>Pista 2: Estructura recursiva completa</summary>

```java
public static void hanoi(int n, char origen, char destino, char auxiliar) {
    // Caso base
    if (n == 1) {
        System.out.println("Mover disco de " + origen + " a " + destino);
        return;
    }

    // Paso 1: Mover n-1 discos de origen a auxiliar (usando destino como auxiliar)
    hanoi(n - 1, origen, auxiliar, destino);

    // Paso 2: Mover el disco más grande de origen a destino
    System.out.println("Mover disco de " + origen + " a " + destino);

    // Paso 3: Mover n-1 discos de auxiliar a destino (usando origen como auxiliar)
    hanoi(n - 1, auxiliar, destino, origen);
}
```
</details>

<details>
<summary>Pista 3: Con contador de movimientos</summary>

```java
private static int contadorMovimientos = 0;

public static void hanoi(int n, char origen, char destino, char auxiliar) {
    if (n == 1) {
        contadorMovimientos++;
        System.out.println("Movimiento " + contadorMovimientos + ": Mover disco de " + origen + " a " + destino);
        return;
    }

    hanoi(n - 1, origen, auxiliar, destino);

    contadorMovimientos++;
    System.out.println("Movimiento " + contadorMovimientos + ": Mover disco de " + origen + " a " + destino);

    hanoi(n - 1, auxiliar, destino, origen);
}
```
</details>

<details>
<summary>Pista 4: Visualización del problema con 3 discos</summary>

```
Estado inicial:
Torre A: [3, 2, 1]  (3=grande, 1=pequeño)
Torre B: []
Torre C: []

Objetivo final:
Torre A: []
Torre B: []
Torre C: [3, 2, 1]

Estrategia:
1. Mover 2 discos (1, 2) de A a B usando C
2. Mover disco grande (3) de A a C
3. Mover 2 discos (1, 2) de B a C usando A
```
</details>

---

## Análisis del Algoritmo

### Complejidad temporal:
- **T(n) = 2·T(n-1) + 1**
- Resolviendo: **O(2^n)**
- Número exacto de movimientos: **2^n - 1**

### Complejidad espacial:
- **O(n)** por la profundidad de la recursión

### Tabla de movimientos:

| Discos | Movimientos | Tiempo (1 mov/seg) |
|--------|-------------|---------------------|
| 1 | 1 | 1 segundo |
| 2 | 3 | 3 segundos |
| 3 | 7 | 7 segundos |
| 4 | 15 | 15 segundos |
| 5 | 31 | 31 segundos |
| 10 | 1023 | ~17 minutos |
| 20 | 1,048,575 | ~12 días |
| 64 | 18,446,744,073,709,551,615 | ~585 mil millones de años |

---

## Checklist de dominio:

- [ ] Entiendo el problema de Torres de Hanoi
- [ ] Entiendo por qué hay 3 llamadas recursivas
- [ ] Puedo explicar qué hace cada paso del algoritmo
- [ ] Entiendo por qué los parámetros se intercambian en las llamadas
- [ ] Puedo calcular el número de movimientos para n discos
- [ ] Probé con n=1, 2, 3

---

## Desafíos adicionales:

1. **Visualización gráfica**: Mostrar el estado de las torres después de cada movimiento
2. **Versión iterativa**: Implementar Torres de Hanoi sin recursión (muy difícil)
3. **4 torres**: Resolver con 4 torres en lugar de 3 (algoritmo de Frame-Stewart)
4. **Movimientos mínimos entre dos configuraciones**: Dado un estado inicial y final, encontrar los movimientos

---

## Relación con Exámenes

Torres de Hanoi es un problema clásico de recursión que puede aparecer en exámenes avanzados de POO o algoritmos.

Demuestra:
- Comprensión profunda de recursión
- Habilidad para resolver problemas complejos dividiéndolos
- Manejo de múltiples llamadas recursivas

---

**Ejercicios relacionados**:
- `Ej04_Matriz_DivideConquer.md` (divide and conquer)
- `08_Estructuras_Datos/Ej04_Arbol_Binario_Busqueda.md` (recursión en árboles)
