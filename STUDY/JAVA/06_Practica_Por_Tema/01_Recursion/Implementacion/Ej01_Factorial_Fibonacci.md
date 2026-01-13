# Ejercicio 1: Factorial y Fibonacci Recursivos

**Dificultad:** ⭐⭐⭐
**Tiempo estimado:** 30 minutos
**Conceptos:** Recursión básica, caso base, llamadas recursivas

---

## Contexto

El factorial de un número N (escrito N!) es el producto de todos los números desde 1 hasta N.
- Ejemplo: 5! = 5 × 4 × 3 × 2 × 1 = 120

La secuencia de Fibonacci es una serie donde cada número es la suma de los dos anteriores:
- 0, 1, 1, 2, 3, 5, 8, 13, 21, 34, ...
- Fibonacci(0) = 0
- Fibonacci(1) = 1
- Fibonacci(n) = Fibonacci(n-1) + Fibonacci(n-2)

---

## Requisitos

Implementa dos métodos recursivos:

### Método 1: Factorial
```java
public static int factorial(int n)
```
- Retorna el factorial de n
- Usa recursión (no loops)
- Caso base: factorial(0) = 1, factorial(1) = 1

### Método 2: Fibonacci
```java
public static int fibonacci(int n)
```
- Retorna el n-ésimo número de Fibonacci
- Usa recursión (no loops)
- Caso base: fibonacci(0) = 0, fibonacci(1) = 1

---

## Ejemplo de Ejecución

```
=== CALCULADORA RECURSIVA ===

Factorial de 5: 120
Factorial de 0: 1
Factorial de 10: 3628800

Fibonacci de 0: 0
Fibonacci de 1: 1
Fibonacci de 5: 5
Fibonacci de 10: 55
Fibonacci de 15: 610
```

---

## Debe entregar:

- [ ] Método `factorial(int n)` recursivo
- [ ] Método `fibonacci(int n)` recursivo
- [ ] Main() que prueba ambos métodos con varios valores
- [ ] Comparación con versión iterativa (opcional)

---

## Pistas:

<details>
<summary>Pista 1: Factorial recursivo</summary>

```java
public static int factorial(int n) {
    // Caso base
    if (n <= 1) {
        return 1;
    }

    // Caso recursivo: n! = n × (n-1)!
    return n * factorial(n - 1);
}
```

Ejemplo de ejecución para factorial(5):
- factorial(5) = 5 × factorial(4)
- factorial(4) = 4 × factorial(3)
- factorial(3) = 3 × factorial(2)
- factorial(2) = 2 × factorial(1)
- factorial(1) = 1 (caso base)

Desenrollando: 2×1 = 2, 3×2 = 6, 4×6 = 24, 5×24 = 120
</details>

<details>
<summary>Pista 2: Fibonacci recursivo</summary>

```java
public static int fibonacci(int n) {
    // Casos base
    if (n == 0) {
        return 0;
    }
    if (n == 1) {
        return 1;
    }

    // Caso recursivo: fib(n) = fib(n-1) + fib(n-2)
    return fibonacci(n - 1) + fibonacci(n - 2);
}
```

Ejemplo de ejecución para fibonacci(4):
- fib(4) = fib(3) + fib(2)
- fib(3) = fib(2) + fib(1)
- fib(2) = fib(1) + fib(0)
- fib(1) = 1, fib(0) = 0 (casos base)

Resultado: fib(4) = 3
</details>

---

## Checklist de dominio:

- [ ] Entiendo qué es un caso base
- [ ] Puedo identificar la llamada recursiva
- [ ] Entiendo cómo la recursión se desenrolla
- [ ] Puedo trazar la ejecución en papel
- [ ] Probé con n=0, n=1, y valores mayores

---

## Conceptos aprendidos:

- Recursión básica
- Caso base
- Caso recursivo
- Pila de llamadas

---

**Siguiente ejercicio**: `Ej02_Suma_Digitos_Recursiva.md`
