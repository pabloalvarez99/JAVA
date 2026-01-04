# 11 - Ejercicios de Algoritmos

## Objetivo
Dominar algoritmos clasicos: recursion avanzada, backtracking, programacion dinamica, y grafos.

## Categorias de Algoritmos

### 1. Recursion
- **Concepto**: Funcion que se llama a si misma
- **Clave**: Identificar caso base y caso recursivo
- **Ejemplos**: Factorial, Fibonacci, Torres de Hanoi

### 2. Backtracking
- **Concepto**: Explorar todas las soluciones, retroceder si no funciona
- **Patron**: Elegir -> Explorar -> Deshacer
- **Ejemplos**: N-Reinas, Sudoku, Laberinto

### 3. Programacion Dinamica (DP)
- **Concepto**: Dividir en subproblemas, guardar resultados
- **Tipos**: Top-down (memoization) vs Bottom-up (tabulation)
- **Ejemplos**: Fibonacci, Mochila, Subsecuencia comun

### 4. Grafos
- **Representacion**: Lista de adyacencia vs Matriz
- **Traversals**: BFS (anchura), DFS (profundidad)
- **Ejemplos**: Camino mas corto, Componentes conexas

## Ejercicios

| # | Nombre | Categoria | Complejidad |
|---|--------|-----------|-------------|
| 1 | Torres de Hanoi | Recursion | O(2^n) |
| 2 | Laberinto Backtrack | Backtracking | - |
| 3 | Mochila Greedy | Greedy | O(n log n) |
| 4 | Fibonacci Memo | DP | O(n) |
| 5 | Grafo BFS | Grafos | O(V+E) |
| 6 | Grafo DFS | Grafos | O(V+E) |
| 7 | Dijkstra Basico | Shortest Path | O(V^2) |
| 8 | Subsecuencia Comun | DP Clasico | O(nm) |
| 9 | N Reinas | Backtracking | O(n!) |
| 10 | Suma Subconjuntos | DP/Backtrack | O(2^n) |

## Complejidad Temporal

```
O(1)        Constante       Acceso a array
O(log n)    Logaritmica     Busqueda binaria
O(n)        Lineal          Recorrer array
O(n log n)  Linearitmica    Merge sort, Quick sort
O(n^2)      Cuadratica      Bubble sort, 2 loops anidados
O(2^n)      Exponencial     Subconjuntos, recursion sin memo
O(n!)       Factorial       Permutaciones
```

## Template: Backtracking

```java
void backtrack(Estado estado, Solucion parcial) {
    if (esSolucion(parcial)) {
        guardarSolucion(parcial);
        return;
    }

    for (Opcion opcion : getOpciones(estado)) {
        if (esValida(opcion, parcial)) {
            // Elegir
            aplicar(opcion, parcial);

            // Explorar
            backtrack(nuevoEstado, parcial);

            // Deshacer (backtrack)
            deshacer(opcion, parcial);
        }
    }
}
```

## Template: Programacion Dinamica

```java
// Top-down (Memoization)
Map<Estado, Resultado> memo = new HashMap<>();

int resolver(Estado estado) {
    if (memo.containsKey(estado)) {
        return memo.get(estado);
    }

    if (esCasoBase(estado)) {
        return valorBase;
    }

    int resultado = calcular(resolver(subproblemas));
    memo.put(estado, resultado);
    return resultado;
}

// Bottom-up (Tabulation)
int[] dp = new int[n + 1];
dp[0] = valorBase;

for (int i = 1; i <= n; i++) {
    dp[i] = calcular(dp[subproblemas]);
}
return dp[n];
```

## Consejos

1. **Dibuja ejemplos** antes de codificar
2. **Identifica subproblemas** repetidos
3. **Empieza con fuerza bruta**, luego optimiza
4. **Prueba con casos pequenos** primero
