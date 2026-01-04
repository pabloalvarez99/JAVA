# 12 - Ejercicios de Strings (Manipulacion de Cadenas)

## Objetivo
Dominar las operaciones con Strings - uno de los temas mas frecuentes en entrevistas tecnicas y desarrollo diario.

## Metodos Clave de String

```java
// Informacion
str.length()                    // Longitud
str.isEmpty()                   // Es vacia?
str.charAt(i)                   // Caracter en posicion i

// Busqueda
str.indexOf("x")                // Primera ocurrencia (-1 si no existe)
str.lastIndexOf("x")            // Ultima ocurrencia
str.contains("x")               // Contiene substring?
str.startsWith("x")             // Empieza con?
str.endsWith("x")               // Termina con?

// Extraccion
str.substring(start)            // Desde start hasta el final
str.substring(start, end)       // Desde start hasta end-1

// Transformacion
str.toLowerCase()               // Minusculas
str.toUpperCase()               // Mayusculas
str.trim()                      // Quitar espacios extremos
str.replace("a", "b")           // Reemplazar
str.replaceAll(regex, repl)     // Reemplazar con regex

// Conversion
str.split(",")                  // Dividir por separador
String.join(",", array)         // Unir array con separador
str.toCharArray()               // Convertir a char[]

// Comparacion
str.equals(other)               // Igualdad (case-sensitive)
str.equalsIgnoreCase(other)     // Igualdad (ignore case)
str.compareTo(other)            // Orden lexicografico
```

## Ejercicios

| # | Nombre | Operaciones | Dificultad |
|---|--------|-------------|------------|
| 1 | InvertirPalabras | split, reverse, join | ⭐⭐ |
| 2 | ContarVocales | iteration, conditions | ⭐ |
| 3 | Palindromo | two-pointer technique | ⭐⭐ |
| 4 | AnagramaChecker | character counting | ⭐⭐ |
| 5 | CompresionBasica | run-length encoding | ⭐⭐⭐ |
| 6 | ValidarParentesis | stack for matching | ⭐⭐⭐ |
| 7 | CamelCaseConverter | case manipulation | ⭐⭐ |
| 8 | BuscarPatron | simple pattern matching | ⭐⭐⭐ |
| 9 | FormatearTexto | word wrap, justify | ⭐⭐⭐ |
| 10 | ParsearCSV | split with edge cases | ⭐⭐⭐ |

## Tips de Rendimiento

- **StringBuilder** para concatenacion en loops (no usar +)
- **String pool**: "abc" == "abc" es true (mismo objeto)
- **Inmutabilidad**: cada operacion crea NUEVO String
- **toCharArray()** para modificar caracteres individualmente

## Errores Comunes

```java
// MAL: Concatenacion en loop (O(n^2))
String result = "";
for (String s : lista) {
    result += s;  // Crea nuevo String cada vez!
}

// BIEN: StringBuilder (O(n))
StringBuilder sb = new StringBuilder();
for (String s : lista) {
    sb.append(s);
}
String result = sb.toString();
```

## Siguientes Pasos

- `11_Ejercicios_Algoritmos/` - Algoritmos mas complejos
- `07_Ejercicios_Debug/` - Bugs comunes con Strings
