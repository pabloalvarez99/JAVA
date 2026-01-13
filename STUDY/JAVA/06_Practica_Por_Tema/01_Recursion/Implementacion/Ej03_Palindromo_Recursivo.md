# Ejercicio 3: Verificador de Palíndromos Recursivo

**Dificultad:** ⭐⭐⭐⭐⭐
**Tiempo estimado:** 45 minutos
**Conceptos:** Recursión, String, Scanner, casos base, subcadenas

**REPLICA EXACTA: Problema 3 del examen real (20 puntos)**

---

## Contexto

Un palíndromo es una palabra que se lee igual de izquierda a derecha que de derecha a izquierda. Ejemplos: "ana", "abba", "reconocer".

En este ejercicio debes crear un programa que:
1. Lee una palabra desde teclado usando Scanner
2. Determina si es palíndromo usando **recursión obligatoriamente**
3. Imprime el resultado

**IMPORTANTE**: Debes usar recursión. Una solución iterativa (con loops) NO es válida para este ejercicio.

---

## Requisitos

### Método recursivo a implementar:

```java
public static boolean esPalindromo(String palabra)
```

**Funcionalidad**:
- Retorna `true` si la palabra es palíndromo
- Retorna `false` si no lo es
- Debe usar recursión (sin loops)

**Casos base**:
1. Palabra vacía ("") → es palíndromo (retorna `true`)
2. Palabra de 1 letra → es palíndromo (retorna `true`)

**Caso recursivo**:
- Comparar primera y última letra
- Si son iguales, verificar recursivamente la subcadena sin esas letras
- Si son diferentes, retornar `false`

### Clase principal:

```java
public class Ej03_Palindromo_Recursivo {
    public static void main(String[] args) {
        // 1. Crear Scanner para leer desde teclado
        // 2. Pedir palabra al usuario
        // 3. Llamar a esPalindromo()
        // 4. Imprimir resultado
        // 5. Cerrar Scanner
    }

    public static boolean esPalindromo(String palabra) {
        // TODO: Implementar recursivamente
    }
}
```

---

## Ejemplo de Ejecución

### Ejemplo 1 - Palíndromo
```
Ingrese una palabra: ana
"ana" es palindromo
```

### Ejemplo 2 - No palíndromo
```
Ingrese una palabra: casa
"casa" NO es palindromo
```

### Ejemplo 3 - Palíndromo largo
```
Ingrese una palabra: reconocer
"reconocer" es palindromo
```

### Ejemplo 4 - Una letra
```
Ingrese una palabra: a
"a" es palindromo
```

### Ejemplo 5 - Vacío
```
Ingrese una palabra:
"" es palindromo
```

---

## Debe entregar:

- [ ] Clase `Ej03_Palindromo_Recursivo` con main()
- [ ] Método `esPalindromo(String)` implementado **recursivamente**
- [ ] Uso de Scanner para leer desde teclado
- [ ] Pruebas con al menos 3 palabras diferentes

---

## Consideraciones:

1. **Recursión obligatoria**: No uses loops (for, while, do-while)
2. **Scanner**: Usa `new Scanner(System.in)` para leer teclado
3. **Casos base**: Verifica palabra vacía y palabra de 1 letra
4. **Subcadenas**: Usa `substring(inicio, fin)` para extraer subcadenas
5. **Comparación**: Usa `charAt(indice)` para obtener caracteres
6. **Cierre de recursos**: Cierra el Scanner al final con `scanner.close()`

---

## Pistas (si estás atascado):

<details>
<summary>Pista 1: Estructura del método recursivo</summary>

```java
public static boolean esPalindromo(String palabra) {
    // Caso base 1: palabra vacía o de 1 letra
    if (palabra.length() <= 1) {
        return true;
    }

    // Comparar primer y último caracter
    char primero = palabra.charAt(0);
    char ultimo = palabra.charAt(palabra.length() - 1);

    if (primero != ultimo) {
        return false; // No es palíndromo
    }

    // Caso recursivo: verificar subcadena sin primer y último caracter
    String subcadena = palabra.substring(1, palabra.length() - 1);
    return esPalindromo(subcadena);
}
```
</summary>
</details>

<details>
<summary>Pista 2: Uso de Scanner</summary>

```java
import java.util.Scanner;

public class Ej03_Palindromo_Recursivo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Ingrese una palabra: ");
        String palabra = scanner.nextLine();

        boolean resultado = esPalindromo(palabra);

        if (resultado) {
            System.out.println("\"" + palabra + "\" es palindromo");
        } else {
            System.out.println("\"" + palabra + "\" NO es palindromo");
        }

        scanner.close();
    }

    // Método esPalindromo aquí...
}
```
</summary>
</details>

<details>
<summary>Pista 3: Métodos útiles de String</summary>

```java
String palabra = "ana";

// Longitud
palabra.length();           // 3

// Obtener caracter en posición
palabra.charAt(0);          // 'a' (primer caracter)
palabra.charAt(2);          // 'a' (último caracter)

// Subcadena (inicio incluido, fin excluido)
palabra.substring(1, 2);    // "n" (sin primer y último)

// Para el último índice
int ultimoIndice = palabra.length() - 1;  // 2
```
</summary>
</details>

<details>
<summary>Pista 4: Traza de ejecución para "ana"</summary>

```
Llamada 1: esPalindromo("ana")
  - primero = 'a', ultimo = 'a'
  - Son iguales, entonces:
  - Llamar esPalindromo("n")

Llamada 2: esPalindromo("n")
  - length = 1 (caso base)
  - Retornar true

Retorno a llamada 1: true
Resultado final: "ana" es palíndromo
```
</summary>
</details>

---

## Relación con el Examen

Este ejercicio es una **REPLICA EXACTA del Problema 3 del examen real** (20 puntos).

En el examen, este problema te pide:
- ✅ Leer palabra desde teclado con Scanner
- ✅ Verificar si es palíndromo usando **recursión obligatoriamente**
- ✅ Imprimir resultado

**Tiempo asignado en examen**: 15-20 minutos (es relativamente rápido si dominas recursión)

### Habilidades evaluadas:
1. Recursión con casos base claros
2. Manipulación de Strings (substring, charAt, length)
3. Uso de Scanner para entrada de usuario
4. Lógica de comparación

### Errores fatales que debes evitar:
1. ❌ Usar loops en lugar de recursión (0 puntos)
2. ❌ No verificar casos base (programa falla o recursión infinita)
3. ❌ Comparar Strings con == en lugar de comparar caracteres
4. ❌ Índices incorrectos en substring (IndexOutOfBoundsException)

---

## Checklist de dominio:

- [ ] Puedo escribir el método recursivo sin consultar pistas
- [ ] Entiendo por qué los casos base son necesarios
- [ ] Puedo explicar cómo funciona la recursión paso a paso
- [ ] Puedo trazar la ejecución para "abba" en papel
- [ ] Entiendo qué hace substring(1, length-1)
- [ ] Probé con palabras vacías y de 1 letra
- [ ] El programa no tiene errores de compilación

---

## Conceptos aprendidos:

- Recursión con Strings
- Casos base múltiples (vacío y 1 letra)
- Reducción del problema (subcadena sin extremos)
- Scanner para entrada de usuario
- Manipulación de Strings (charAt, substring, length)

---

## Desafíos Adicionales (opcional):

Si ya dominaste el ejercicio básico, intenta:

1. **Ignorar mayúsculas/minúsculas**:
   - "Ana" y "ana" deben ser considerados palíndromos
   - Pista: Usa `toLowerCase()` antes de verificar

2. **Ignorar espacios**:
   - "anita lava la tina" es palíndromo
   - Pista: Usa `replaceAll(" ", "")` para quitar espacios

3. **Múltiples palabras**:
   - Pedir al usuario cuántas palabras verificar
   - Usar un loop en main() para leer múltiples palabras
   - El método esPalindromo() sigue siendo recursivo

4. **Contar llamadas recursivas**:
   - Agregar un contador estático que se incremente en cada llamada
   - Imprimir cuántas llamadas recursivas se hicieron

---

## Variaciones de Examen

En exámenes reales, este problema puede aparecer con variaciones:

**Variación 1**: Verificar si un número es palíndromo
```java
// Ejemplo: 12321 es palíndromo, 12345 no lo es
public static boolean esPalindromoNumero(int numero)
```

**Variación 2**: Contar palíndromos en un array
```java
// Contar cuántas palabras del array son palíndromos
public static int contarPalindromos(String[] palabras)
```

**Variación 3**: Palíndromo más largo
```java
// Encontrar el palíndromo más largo de un array
public static String palindromoMasLargo(String[] palabras)
```

---

## Ejercicios Relacionados:

Para practicar más recursión:
- `Ej01_Factorial_Fibonacci.md` (recursión básica)
- `Ej02_Suma_Digitos_Recursiva.md` (recursión con números)
- `Ej04_Matriz_DivideConquer.md` (recursión avanzada)
- `Tracing01_Recursion_Simple.java` (entender ejecución)
- `Tracing03_MathPow.java` (tracing complejo)

---

**Siguiente ejercicio**: `Ej04_Matriz_DivideConquer.md` (más difícil)

**Solución completa**: Ver `Soluciones/01_Recursion/Implementacion/Ej03_Solucion.java`
