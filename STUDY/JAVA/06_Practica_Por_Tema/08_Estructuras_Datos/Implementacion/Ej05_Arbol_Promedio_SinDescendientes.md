# Ejercicio 5: Promedio de Edad en Árbol Binario

**Dificultad:** ⭐⭐⭐⭐⭐⭐⭐
**Tiempo estimado:** 90 minutos
**Conceptos:** Árbol binario de búsqueda, recursión, nodos hoja, promedio

**REPLICA EXACTA: Problema 4 del examen real (35 puntos)**

---

## Contexto

Considere la organización de datos de personas en una **estructura de árbol binario de búsqueda**. Considere que:
- Cada nodo en el árbol contiene **exactamente una persona**
- El árbol está ordenado por **RUT de la persona**

Se pide un programa Java que utilizando **recursión**:
- Imprime el **promedio de la edad** de las personas **sin descendientes** (nodos hoja)

**Nota**: Utilice el código ya hecho y agregue todo lo necesario.

---

## Requisitos

### Clase Persona:

```java
public class Persona {
    private String rut;
    private String nombre;
    private int edad;

    public Persona(String rut, String nombre, int edad) {
        this.rut = rut;
        this.nombre = nombre;
        this.edad = edad;
    }

    public String getRut() { return rut; }
    public String getNombre() { return nombre; }
    public int getEdad() { return edad; }

    @Override
    public String toString() {
        return nombre + " (RUT: " + rut + ", Edad: " + edad + ")";
    }
}
```

### Clase Nodo:

```java
public class Nodo {
    Persona persona;
    Nodo izquierdo;
    Nodo derecho;

    public Nodo(Persona persona) {
        this.persona = persona;
        this.izquierdo = null;
        this.derecho = null;
    }
}
```

### Clase ArbolBinario:

```java
public class ArbolBinario {
    private Nodo raiz;

    public ArbolBinario() {
        this.raiz = null;
    }

    // Insertar persona ordenando por RUT
    public void insertar(Persona p) {
        raiz = insertarRecursivo(raiz, p);
    }

    private Nodo insertarRecursivo(Nodo nodo, Persona p) {
        // TODO: Implementar inserción en BST por RUT
    }

    // Calcular promedio de edad de nodos sin descendientes
    public double promEdadSinDescendientes() {
        // TODO: Implementar con recursión
    }

    // Método auxiliar recursivo
    private ResultadoPromed promEdadSinDescendientesRecursivo(Nodo nodo) {
        // TODO: Implementar
    }
}
```

### Clase ResultadoPromed (auxiliar):

```java
// Clase para retornar suma y cantidad de nodos hoja
class ResultadoPromed {
    int sumaEdades;
    int cantidadNodos;

    public ResultadoPromed(int suma, int cantidad) {
        this.sumaEdades = suma;
        this.cantidadNodos = cantidad;
    }
}
```

---

## Ejemplo de Ejecución

### Árbol de ejemplo:

```
                  P4 (RUT: 15000000, Edad: 45)
                 /                            \
        P5 (RUT: 12000000, Edad: 30)      P3 (RUT: 18000000, Edad: 28)
       /                                 /                              \
P1 (RUT: 10000000, Edad: 25)   P2 (RUT: 16000000, Edad: 35)   P6 (RUT: 20000000, Edad: 40)
```

**Nodos sin descendientes (hojas)**:
- P1: Edad 25
- P2: Edad 35
- P6: Edad 40

**Cálculo**:
- Suma de edades: 25 + 35 + 40 = 100
- Cantidad de nodos hoja: 3
- Promedio: 100 / 3 = 33.33...

**Salida esperada**:
```
Árbol creado con 6 personas.

Nodos sin descendientes:
- P1 (RUT: 10000000, Edad: 25)
- P2 (RUT: 16000000, Edad: 35)
- P6 (RUT: 20000000, Edad: 40)

Promedio de edad de nodos sin descendientes: 33.33
```

---

## Debe entregar:

- [ ] Clase `Persona` con atributos rut, nombre, edad
- [ ] Clase `Nodo` con persona, izquierdo, derecho
- [ ] Clase `ArbolBinario` con raíz
- [ ] Método `insertar()` que ordena por RUT
- [ ] Método `promEdadSinDescendientes()` **recursivo**
- [ ] Clase `ResultadoPromed` auxiliar (o alternativa similar)
- [ ] Main() que crea árbol, inserta personas y calcula promedio
- [ ] Imprimir promedio con 2 decimales

---

## Consideraciones:

1. **BST por RUT**: El árbol debe estar ordenado por RUT (comparación alfabética de Strings)
2. **Nodo sin descendientes**: Un nodo hoja cumple `izquierdo == null && derecho == null`
3. **Recursión obligatoria**: No usar loops para calcular promedio
4. **Promedio = suma / cantidad**: Calcular en un solo recorrido recursivo
5. **Formato**: Imprimir con 2 decimales usando `String.format("%.2f", promedio)`

---

## Pistas (si estás atascado):

<details>
<summary>Pista 1: Inserción en BST por RUT</summary>

```java
private Nodo insertarRecursivo(Nodo nodo, Persona p) {
    // Caso base: posición encontrada
    if (nodo == null) {
        return new Nodo(p);
    }

    // Comparar RUTs alfabéticamente
    int comparacion = p.getRut().compareTo(nodo.persona.getRut());

    if (comparacion < 0) {
        // p.rut < nodo.rut → insertar a la izquierda
        nodo.izquierdo = insertarRecursivo(nodo.izquierdo, p);
    } else if (comparacion > 0) {
        // p.rut > nodo.rut → insertar a la derecha
        nodo.derecho = insertarRecursivo(nodo.derecho, p);
    }
    // Si comparacion == 0, ya existe (no insertar duplicados)

    return nodo;
}
```
</summary>
</details>

<details>
<summary>Pista 2: Detectar nodo sin descendientes</summary>

```java
private boolean esNodoHoja(Nodo nodo) {
    return nodo.izquierdo == null && nodo.derecho == null;
}
```
</summary>
</details>

<details>
<summary>Pista 3: Método recursivo con ResultadoPromed</summary>

```java
private ResultadoPromed promEdadSinDescendientesRecursivo(Nodo nodo) {
    // Caso base: nodo nulo
    if (nodo == null) {
        return new ResultadoPromed(0, 0);
    }

    // Caso: nodo sin descendientes (hoja)
    if (nodo.izquierdo == null && nodo.derecho == null) {
        return new ResultadoPromed(nodo.persona.getEdad(), 1);
    }

    // Caso recursivo: nodo con descendientes
    ResultadoPromed resIzq = promEdadSinDescendientesRecursivo(nodo.izquierdo);
    ResultadoPromed resDer = promEdadSinDescendientesRecursivo(nodo.derecho);

    // Combinar resultados de subárboles
    int sumaTotal = resIzq.sumaEdades + resDer.sumaEdades;
    int cantidadTotal = resIzq.cantidadNodos + resDer.cantidadNodos;

    return new ResultadoPromed(sumaTotal, cantidadTotal);
}
```
</summary>
</details>

<details>
<summary>Pista 4: Método público que llama al recursivo</summary>

```java
public double promEdadSinDescendientes() {
    ResultadoPromed resultado = promEdadSinDescendientesRecursivo(raiz);

    if (resultado.cantidadNodos == 0) {
        return 0.0; // Evitar división por cero
    }

    return (double) resultado.sumaEdades / resultado.cantidadNodos;
}
```
</summary>
</details>

<details>
<summary>Pista 5: Main() de ejemplo</summary>

```java
public class Ej05_Arbol_Promedio_SinDescendientes {
    public static void main(String[] args) {
        ArbolBinario arbol = new ArbolBinario();

        // Crear personas
        Persona p1 = new Persona("10000000", "P1", 25);
        Persona p2 = new Persona("16000000", "P2", 35);
        Persona p3 = new Persona("18000000", "P3", 28);
        Persona p4 = new Persona("15000000", "P4", 45);
        Persona p5 = new Persona("12000000", "P5", 30);
        Persona p6 = new Persona("20000000", "P6", 40);

        // Insertar en árbol (orden de inserción afecta estructura)
        arbol.insertar(p4); // Raíz
        arbol.insertar(p5);
        arbol.insertar(p3);
        arbol.insertar(p1);
        arbol.insertar(p2);
        arbol.insertar(p6);

        // Calcular promedio
        double promedio = arbol.promEdadSinDescendientes();

        // Imprimir resultado
        System.out.printf("Promedio de edad de nodos sin descendientes: %.2f\n", promedio);
    }
}
```
</summary>
</details>

---

## Relación con el Examen

Este ejercicio es una **REPLICA EXACTA del Problema 4 del examen real** (35 puntos).

Es el problema **más difícil** del examen y vale la mayor cantidad de puntos.

En el examen, este problema requiere:
- ✅ Implementar árbol binario de búsqueda ordenado por RUT
- ✅ Insertar personas en el árbol
- ✅ Calcular promedio de edad de nodos hoja **usando recursión**
- ✅ Retornar el resultado correctamente

**Tiempo asignado en examen**: 45-60 minutos (es el que más tiempo consume)

### Habilidades evaluadas:
1. Estructuras de datos (árbol binario de búsqueda)
2. Recursión en árboles (recorrido, cálculos)
3. Identificar nodos hoja
4. Combinar resultados de subárboles
5. Ordenamiento por atributo (RUT)
6. Cálculo de promedio en un solo recorrido

### Errores fatales que debes evitar:
1. ❌ No usar recursión (usar loops) → 0 puntos
2. ❌ No ordenar por RUT correctamente → árbol incorrecto
3. ❌ Incluir nodos intermedios en el cálculo → respuesta incorrecta
4. ❌ Recorrer el árbol múltiples veces → ineficiente
5. ❌ División por cero si no hay nodos hoja → error de ejecución
6. ❌ No retornar información suficiente de subárboles → lógica incorrecta

---

## Checklist de dominio:

- [ ] Entiendo qué es un árbol binario de búsqueda
- [ ] Puedo insertar elementos ordenados por un atributo
- [ ] Entiendo la diferencia entre nodo hoja y nodo interno
- [ ] Puedo recorrer un árbol recursivamente
- [ ] Entiendo cómo combinar resultados de subárboles
- [ ] Entiendo por qué se necesita ResultadoPromed (o alternativa)
- [ ] Puedo calcular el promedio en un solo recorrido
- [ ] Probé con árbol vacío y con 1 solo nodo

---

## Conceptos aprendidos:

- Árbol binario de búsqueda (BST)
- Inserción ordenada por atributo
- Identificación de nodos hoja
- Recursión en árboles
- Patrón de retornar múltiples valores (clase auxiliar)
- Recorrido postorder implícito
- Cálculo de promedios con recursión

---

## Variaciones del Problema

### Variación 1: Máxima edad en lugar de promedio
```java
public int maxEdadSinDescendientes()
```

### Variación 2: Contar nodos hoja por rango de edad
```java
public int contarHojasEnRango(int edadMin, int edadMax)
```

### Variación 3: Suma de edades de nodos con 1 solo hijo
```java
public int sumaEdadNodosConUnHijo()
```

### Variación 4: Listar todas las hojas
```java
public List<Persona> obtenerPersonasSinDescendientes()
```

---

## Alternativas a ResultadoPromed

Si no quieres crear una clase auxiliar, hay otras opciones:

### Opción 1: Usar array de 2 elementos
```java
private int[] promEdadSinDescendientesRecursivo(Nodo nodo) {
    // Retorna: [sumaEdades, cantidadNodos]
    if (nodo == null) {
        return new int[]{0, 0};
    }
    // ... resto del código
}
```

### Opción 2: Variable de instancia (menos elegante)
```java
private int sumaTotal = 0;
private int cantidadTotal = 0;

private void calcularRecursivo(Nodo nodo) {
    if (nodo == null) return;
    if (esNodoHoja(nodo)) {
        sumaTotal += nodo.persona.getEdad();
        cantidadTotal++;
        return;
    }
    calcularRecursivo(nodo.izquierdo);
    calcularRecursivo(nodo.derecho);
}
```

---

## Debugging Tips

### Error común 1: NullPointerException
```java
// ❌ INCORRECTO - no verifica null
if (nodo.izquierdo == null && nodo.derecho == null) { ... }

// ✅ CORRECTO - verifica nodo null primero
if (nodo == null) { return ...; }
if (nodo.izquierdo == null && nodo.derecho == null) { ... }
```

### Error común 2: No combinar resultados correctamente
```java
// ❌ INCORRECTO - solo retorna resultado izquierdo
return promEdadSinDescendientesRecursivo(nodo.izquierdo);

// ✅ CORRECTO - combina ambos subárboles
ResultadoPromed resIzq = promEdadSinDescendientesRecursivo(nodo.izquierdo);
ResultadoPromed resDer = promEdadSinDescendientesRecursivo(nodo.derecho);
return new ResultadoPromed(resIzq.suma + resDer.suma, resIzq.cantidad + resDer.cantidad);
```

### Error común 3: Incluir nodos intermedios
```java
// ❌ INCORRECTO - cuenta todos los nodos
ResultadoPromed resultado = new ResultadoPromed(nodo.persona.getEdad(), 1);

// ✅ CORRECTO - solo cuenta nodos hoja
if (nodo.izquierdo == null && nodo.derecho == null) {
    return new ResultadoPromed(nodo.persona.getEdad(), 1);
}
```

---

## Análisis de Complejidad

### Complejidad temporal:
- **O(N)** donde N es el número de nodos
- Cada nodo se visita exactamente 1 vez

### Complejidad espacial:
- **O(h)** donde h es la altura del árbol (pila de recursión)
- En el peor caso (árbol desbalanceado): O(N)
- En el mejor caso (árbol balanceado): O(log N)

---

## Desafíos Adicionales (opcional):

1. **Imprimir estructura del árbol**:
   Visualiza el árbol con indentación

2. **Calcular altura del árbol**:
   ```java
   public int altura()
   ```

3. **Verificar si es BST válido**:
   Verifica que el árbol esté correctamente ordenado

4. **Balancear el árbol**:
   Implementa rotaciones para balancear el BST

5. **Estadísticas completas**:
   - Promedio de edad de todos los nodos
   - Promedio de edad de nodos internos
   - Comparar ambos promedios

---

## Ejercicios Relacionados:

Para practicar más árboles:
- `Ej04_Arbol_Binario_Busqueda.md` (BST básico)
- `08_Estructuras_Datos/Tracing/Tracing02_Arbol_Recorridos.java` (recorridos)
- `08_Estructuras_Datos/Tracing/Tracing03_Arbol_Recursion.java` (tracing árbol)
- `08_Estructuras_Datos/Debug/Debug02_Arbol_InfiniteLoop.java` (debugging)

Para practicar recursión:
- `01_Recursion/Ej04_Matriz_DivideConquer.md` (divide and conquer)
- `01_Recursion/Ej05_Torres_Hanoi.md` (recursión compleja)

---

**Solución completa**: Ver `Soluciones/08_Estructuras_Datos/Implementacion/Ej05_Solucion.java`
