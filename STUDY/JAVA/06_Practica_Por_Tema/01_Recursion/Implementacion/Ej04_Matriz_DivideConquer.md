# Ejercicio 4: Suma de Matriz con Divide and Conquer

**Dificultad:** ⭐⭐⭐⭐⭐⭐
**Tiempo estimado:** 60 minutos
**Conceptos:** Recursión, divide and conquer, matrices, Math.pow()

**REPLICA EXACTA: Problema 2 del examen real (25 puntos)**

---

## Contexto

Utilizando la técnica de **divide and conquer (dividir para conquistar)**, se pide sumar los elementos de una matriz de N × N, donde N = 2^i (es decir, N es potencia de 2).

El valor de N se debe generar automáticamente considerando N = 2^i, donde i >= 0 e i <= 8.

Los valores de la matriz se generan automáticamente con valores enteros entre 0 y 9, ambos inclusive.

**En Java 2^i se escribe**: `Math.pow(2, i)`. El resultado es `double`.

---

## Requisitos

### Método principal a implementar:

```java
public static int sumarMatriz(int[][] matriz, int fila, int columna, int tamaño)
```

**Parámetros**:
- `matriz`: La matriz N×N con valores enteros
- `fila`: Fila de inicio de la submatriz a procesar
- `columna`: Columna de inicio de la submatriz a procesar
- `tamaño`: Tamaño de la submatriz (N para la matriz completa)

**Retorna**: La suma de todos los elementos de la submatriz

**Algoritmo Divide and Conquer**:
1. **Caso base**: Si tamaño == 1, retornar el elemento en (fila, columna)
2. **Caso recursivo**: Dividir la matriz en 4 cuadrantes:
   - Cuadrante superior izquierdo
   - Cuadrante superior derecho
   - Cuadrante inferior izquierdo
   - Cuadrante inferior derecho
3. **Sumar** los resultados de los 4 cuadrantes recursivamente

### Clase completa:

```java
public class Ej04_Matriz_DivideConquer {
    public static void main(String[] args) {
        // 1. Leer valor de i (entre 0 y 8)
        // 2. Calcular N = 2^i usando Math.pow()
        // 3. Crear matriz N×N
        // 4. Llenar matriz con valores aleatorios entre 0 y 9
        // 5. Imprimir matriz
        // 6. Calcular suma usando divide and conquer
        // 7. Imprimir resultado
    }

    public static int sumarMatriz(int[][] matriz, int fila, int columna, int tamaño) {
        // TODO: Implementar divide and conquer
    }
}
```

---

## Ejemplo de Ejecución

### Ejemplo 1: N = 2 (i = 1)

```
Ingrese el valor de i (0-8): 1
N = 2

Matriz 2×2:
3 7
2 8

Suma total: 20
```

**Explicación**: 3 + 7 + 2 + 8 = 20

### Ejemplo 2: N = 4 (i = 2)

```
Ingrese el valor de i (0-8): 2
N = 4

Matriz 4×4:
1 4 2 9
5 3 7 1
8 2 4 6
0 3 5 2

Suma total: 62
```

**Explicación**: 1+4+2+9 + 5+3+7+1 + 8+2+4+6 + 0+3+5+2 = 62

### Ejemplo 3: N = 8 (i = 3)

```
Ingrese el valor de i (0-8): 3
N = 8

Matriz 8×8:
[matriz 8×8 con valores aleatorios]

Suma total: 287
```

---

## Debe entregar:

- [ ] Clase `Ej04_Matriz_DivideConquer` con main()
- [ ] Método `sumarMatriz()` con divide and conquer
- [ ] Lectura de i con Scanner
- [ ] Generación de N usando Math.pow(2, i)
- [ ] Llenado de matriz con valores aleatorios (0-9)
- [ ] Impresión de la matriz
- [ ] Cálculo e impresión del resultado

---

## Consideraciones:

1. **N = 2^i**: Usa `int n = (int) Math.pow(2, i);` para calcular N
2. **Validación**: Verifica que 0 <= i <= 8
3. **Valores aleatorios**: Usa `Math.random() * 10` para generar valores 0-9
4. **Divide and conquer obligatorio**: No uses loops para sumar
5. **Conversión de double a int**: Math.pow() retorna double, necesitas casting
6. **Índices**: Ten cuidado con los índices al dividir en cuadrantes

---

## Pistas (si estás atascado):

<details>
<summary>Pista 1: Estructura del método divide and conquer</summary>

```java
public static int sumarMatriz(int[][] matriz, int fila, int columna, int tamaño) {
    // Caso base: celda individual
    if (tamaño == 1) {
        return matriz[fila][columna];
    }

    // Dividir tamaño a la mitad
    int mitad = tamaño / 2;

    // Calcular suma de 4 cuadrantes recursivamente
    int cuadranteSuperiorIzq = sumarMatriz(matriz, fila, columna, mitad);
    int cuadranteSuperiorDer = sumarMatriz(matriz, fila, columna + mitad, mitad);
    int cuadranteInferiorIzq = sumarMatriz(matriz, fila + mitad, columna, mitad);
    int cuadranteInferiorDer = sumarMatriz(matriz, fila + mitad, columna + mitad, mitad);

    // Retornar suma total
    return cuadranteSuperiorIzq + cuadranteSuperiorDer +
           cuadranteInferiorIzq + cuadranteInferiorDer;
}
```
</summary>
</details>

<details>
<summary>Pista 2: Generación de matriz con valores aleatorios</summary>

```java
import java.util.Random;

// En main()
int n = (int) Math.pow(2, i);
int[][] matriz = new int[n][n];

// Llenar con valores aleatorios entre 0 y 9
Random random = new Random();
for (int f = 0; f < n; f++) {
    for (int c = 0; c < n; c++) {
        matriz[f][c] = random.nextInt(10); // 0 a 9
    }
}

// Alternativa sin Random:
// matriz[f][c] = (int)(Math.random() * 10);
```
</summary>
</details>

<details>
<summary>Pista 3: Imprimir matriz formateada</summary>

```java
public static void imprimirMatriz(int[][] matriz) {
    System.out.println("\nMatriz " + matriz.length + "×" + matriz.length + ":");
    for (int f = 0; f < matriz.length; f++) {
        for (int c = 0; c < matriz[f].length; c++) {
            System.out.print(matriz[f][c] + " ");
        }
        System.out.println();
    }
}
```
</summary>
</details>

<details>
<summary>Pista 4: Llamada inicial del método</summary>

```java
// En main(), después de crear y llenar la matriz
int suma = sumarMatriz(matriz, 0, 0, n);
System.out.println("\nSuma total: " + suma);
```

**Explicación de parámetros**:
- `matriz`: La matriz completa
- `0`: Fila de inicio (esquina superior izquierda)
- `0`: Columna de inicio (esquina superior izquierda)
- `n`: Tamaño completo de la matriz
</summary>
</details>

<details>
<summary>Pista 5: Visualización de divide and conquer para matriz 4×4</summary>

```
Matriz 4×4 original:
1 4 | 2 9
5 3 | 7 1
----+----
8 2 | 4 6
0 3 | 5 2

Se divide en 4 cuadrantes de 2×2:

Cuadrante Superior Izq:    Cuadrante Superior Der:
1 4                        2 9
5 3                        7 1
Suma: 13                   Suma: 19

Cuadrante Inferior Izq:    Cuadrante Inferior Der:
8 2                        4 6
0 3                        5 2
Suma: 13                   Suma: 17

Suma total: 13 + 19 + 13 + 17 = 62
```

Cada cuadrante 2×2 se divide nuevamente en 4 cuadrantes 1×1 (caso base).
</summary>
</details>

---

## Relación con el Examen

Este ejercicio es una **REPLICA EXACTA del Problema 2 del examen real** (25 puntos).

En el examen, este problema requiere:
- ✅ Generar N automáticamente con Math.pow(2, i)
- ✅ Crear matriz N×N con valores aleatorios
- ✅ Implementar divide and conquer (recursión obligatoria)
- ✅ Imprimir la matriz y el resultado

**Tiempo asignado en examen**: 25-30 minutos

### Habilidades evaluadas:
1. Algoritmo divide and conquer (divide, conquer, combine)
2. Recursión con múltiples llamadas (4 cuadrantes)
3. Manipulación de matrices (índices, submatrices)
4. Uso de Math.pow() y conversión de tipos
5. Generación de valores aleatorios

### Errores fatales que debes evitar:
1. ❌ No usar divide and conquer (usar loops) → 0 puntos
2. ❌ Índices incorrectos en cuadrantes → respuesta incorrecta
3. ❌ No dividir tamaño a la mitad → recursión infinita
4. ❌ No castear Math.pow() a int → error de compilación
5. ❌ Olvidar caso base → StackOverflowError

---

## Checklist de dominio:

- [ ] Entiendo qué es divide and conquer
- [ ] Puedo identificar los 4 cuadrantes de una matriz
- [ ] Entiendo cómo calcular los índices de cada cuadrante
- [ ] Puedo explicar el caso base (tamaño == 1)
- [ ] Entiendo por qué se divide tamaño/2
- [ ] Probé con diferentes valores de i (0, 1, 2, 3)
- [ ] El programa funciona correctamente con N = 8 (i = 3)
- [ ] Puedo trazar la recursión para matriz 2×2

---

## Conceptos aprendidos:

- Algoritmo divide and conquer
- Recursión con múltiples llamadas (4 ramas)
- Manipulación de submatrices
- Math.pow() y conversión de tipos
- Generación de valores aleatorios
- Complejidad O(N²) con divide and conquer

---

## Análisis de Complejidad

### Complejidad temporal:
- **T(N) = 4·T(N/2) + O(1)**
- Resolviendo con Master Theorem: **O(N²)**
- Cada celda se visita exactamente 1 vez

### Complejidad espacial:
- **O(log N)** por la pila de recursión
- Profundidad de recursión: log₂(N) niveles

### ¿Por qué divide and conquer si loops es O(N²) también?
- Didáctica: Practicar recursión y divide and conquer
- En problemas reales, divide and conquer permite:
  - Paralelización (procesar cuadrantes en paralelo)
  - Optimizaciones (ej: no procesar cuadrantes si todos son 0)

---

## Desafíos Adicionales (opcional):

1. **Máximo en lugar de suma**:
   ```java
   public static int maximoMatriz(int[][] matriz, int fila, int columna, int tamaño)
   ```
   Encuentra el valor máximo usando divide and conquer

2. **Suma solo de elementos pares**:
   Modifica el caso base para sumar solo si el elemento es par

3. **Imprimir árbol de recursión**:
   Agrega parámetro `nivel` y imprime indentación para visualizar las llamadas

4. **Contar llamadas recursivas**:
   Usa una variable estática para contar cuántas llamadas se hacen
   - Para N=4, ¿cuántas llamadas hay?
   - Para N=8, ¿cuántas llamadas hay?

5. **Verificar si matriz es simétrica**:
   Usa divide and conquer para verificar simetría

---

## Variaciones de Examen

**Variación 1**: Producto en lugar de suma
```java
// Multiplicar todos los elementos de la matriz
public static int productoMatriz(int[][] matriz, int fila, int columna, int tamaño)
```

**Variación 2**: Contar elementos mayores a X
```java
// Contar elementos mayores a un umbral
public static int contarMayores(int[][] matriz, int fila, int columna, int tamaño, int umbral)
```

**Variación 3**: Suma de diferencias entre cuadrantes
```java
// Calcular |sumaCuad1 - sumaCuad2| + |sumaCuad3 - sumaCuad4|
```

---

## Debugging Tips

### Error común 1: ArrayIndexOutOfBoundsException
```java
// ❌ INCORRECTO
int mitad = tamaño / 2;
sumarMatriz(matriz, fila + mitad, columna + mitad, mitad);
// Problema: Si fila=4, columna=4, mitad=2, intenta acceder a [6][6] en matriz 8×8

// ✅ CORRECTO
// Los índices nunca deben exceder las dimensiones originales
// Verifica: fila + tamaño <= matriz.length
```

### Error común 2: StackOverflowError
```java
// ❌ INCORRECTO - olvida reducir tamaño
sumarMatriz(matriz, fila, columna, tamaño); // recursión infinita

// ✅ CORRECTO
sumarMatriz(matriz, fila, columna, tamaño / 2);
```

### Error común 3: Resultado incorrecto
```java
// ❌ INCORRECTO - suma solo 3 cuadrantes
return cuad1 + cuad2 + cuad3; // falta cuad4

// ✅ CORRECTO
return cuad1 + cuad2 + cuad3 + cuad4;
```

---

## Ejercicios Relacionados:

Para practicar más divide and conquer:
- `Ej05_Torres_Hanoi.md` (recursión compleja)
- `Tracing03_MathPow.java` (recursión con Math.pow)
- `08_Estructuras_Datos/Ej04_Arbol_Binario_Busqueda.md` (divide and conquer en árboles)

Para practicar matrices:
- `03_Colecciones/Ej05_PriorityQueue_Urgencias.md` (estructuras 2D)

---

**Siguiente ejercicio**: `Ej05_Torres_Hanoi.md` (recursión muy avanzada)

**Solución completa**: Ver `Soluciones/01_Recursion/Implementacion/Ej04_Solucion.java`
