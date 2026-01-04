# Guía de Uso - Sistema de Pruebas Automatizado

## Archivos Creados

Se han creado los siguientes archivos de prueba para facilitarte el desarrollo:

### 1. `TestRunner.java`
Sistema básico de testing que proporciona funciones útiles:
- `assertEquals()` - Compara valores esperados vs actuales
- `assertTrue()` / `assertFalse()` - Verifica condiciones booleanas
- `imprimirResumen()` - Muestra resultado final de las pruebas

### 2. `DatosPrueba.java`
Datos de prueba para **ejercicios básicos (1-10)**:
- Variables, operaciones matemáticas
- Arrays y métodos
- Primera clase (Persona)

### 3. `DatosPruebaAvanzados.java`
Datos de prueba para **ejercicios intermedios (11-20)**:
- Clases con encapsulación (Estudiante)
- Composición de objetos (Aula, Biblioteca)
- ArrayList (ListaTareas)
- Relaciones entre objetos (Empresa-Departamento-Empleado)

### 4. `DatosPruebaMuyAvanzados.java`
Datos de prueba para **ejercicios avanzados (21-36)**:
- Algoritmos de ordenamiento y búsqueda
- Estructuras de datos (listas enlazadas, pilas, colas, árboles)
- Colecciones avanzadas (HashSet, TreeSet, LinkedList, Queue)
- Patrones de diseño (Builder, Observer)
- File I/O y serialización
- Threads y concurrencia
- Collections avanzadas (TreeMap, PriorityQueue, Deque)

## Cómo Usar los Datos de Prueba

### Opción 1: Ver los datos disponibles

Ejecuta el archivo de datos para ver qué información está disponible:

```bash
# Para ejercicios básicos
javac DatosPrueba.java
java DatosPrueba

# Para ejercicios avanzados
javac DatosPruebaAvanzados.java
java DatosPruebaAvanzados

# Para ejercicios muy avanzados
javac DatosPruebaMuyAvanzados.java
java DatosPruebaMuyAvanzados
```

### Opción 2: Ver datos de un ejercicio específico

Llama al método `mostrarDatos()` de la clase correspondiente:

```bash
# Ejemplo para Ejercicio 1
javac DatosPrueba.java
java -c "DatosPrueba.Ejercicio1.mostrarDatos()"
```

O crea un pequeño programa:

```java
public class VerDatos {
    public static void main(String[] args) {
        // Ver datos del Ejercicio 7
        DatosPrueba.Ejercicio7.mostrarDatos();
    }
}
```

### Opción 3: Usar los datos en tu código

Simplemente referencia las constantes desde tu ejercicio:

```java
public class Ejercicio7 {
    public static void main(String[] args) {
        // Usar los datos predefinidos
        int[] numeros = DatosPrueba.Ejercicio7.NUMEROS;

        // Tu código aquí...
        System.out.println("Array: " + Arrays.toString(numeros));

        // Calcular suma, promedio, etc.
    }
}
```

## Ejemplos Prácticos

### Ejemplo 1: Ejercicio 1 (Variables)

```java
public class Ejercicio1 {
    public static void main(String[] args) {
        // Opción A: Usar tus propios datos
        String nombre = "Pablo";
        int edad = 20;
        double altura = 1.75;

        // Opción B: Usar datos predefinidos
        String nombre = DatosPrueba.Ejercicio1.NOMBRE;
        int edad = DatosPrueba.Ejercicio1.EDAD;
        double altura = DatosPrueba.Ejercicio1.ALTURA;

        // Imprimir
        System.out.println("Hola, me llamo " + nombre);
        System.out.println("Tengo " + edad + " años");
        System.out.println("Mido " + altura + " metros");
    }
}
```

### Ejemplo 2: Ejercicio 7 (Arrays)

```java
import java.util.Arrays;

public class Ejercicio7 {
    public static void main(String[] args) {
        // Usar datos de prueba predefinidos
        int[] numeros = DatosPrueba.Ejercicio7.NUMEROS;

        System.out.println("Array: " + Arrays.toString(numeros));

        // Tu código aquí - calcular suma
        int suma = 0;
        for (int num : numeros) {
            suma += num;
        }
        System.out.println("Suma: " + suma);

        // Verificar con TestRunner
        TestRunner.assertEquals("Suma correcta", 120, suma);
    }
}
```

### Ejemplo 3: Ejercicio 10 (Clase Persona)

```java
public class Ejercicio10 {
    public static void main(String[] args) {
        // Ver los datos de prueba disponibles
        DatosPrueba.Ejercicio10.mostrarDatos();

        // Luego crear tus objetos Persona basándote en esos datos
        // ...
    }
}
```

### Ejemplo 4: Ejercicio 21 (Bubble Sort)

```java
public class Ejercicio21 {
    public static void main(String[] args) {
        // Obtener array de prueba
        int[] array = DatosPruebaMuyAvanzados.AlgoritmosOrdenamiento.ARRAY_PEQUEÑO.clone();

        System.out.println("Array original: " + Arrays.toString(array));

        // Tu implementación de bubble sort aquí
        // bubbleSort(array);

        // Verificar resultado
        int[] esperado = {11, 12, 22, 25, 34, 64, 90};
        TestRunner.assertEquals("Array ordenado correctamente",
                               Arrays.toString(esperado),
                               Arrays.toString(array));
    }
}
```

## Compilar y Ejecutar

### Compilar todo

```bash
# Desde el directorio de ejercicios
javac *.java
```

### Ejecutar un ejercicio

```bash
java Ejercicio1
java Ejercicio7
# etc...
```

### Ver datos de prueba

```bash
java DatosPrueba
java DatosPruebaAvanzados
java DatosPruebaMuyAvanzados
```

### Ver datos de un ejercicio específico

Crea un archivo temporal:

```java
// VerDatosEj7.java
public class VerDatosEj7 {
    public static void main(String[] args) {
        DatosPrueba.Ejercicio7.mostrarDatos();
    }
}
```

Luego ejecuta:

```bash
javac VerDatosEj7.java
java VerDatosEj7
```

## Consejos

1. **Primero mira los datos**: Ejecuta `mostrarDatos()` para ver qué datos tienes disponibles
2. **Usa .clone()**: Si vas a modificar un array, usa `.clone()` para no alterar el original
3. **Verifica tu salida**: Compara tu salida con la salida esperada que muestran los datos
4. **Experimenta**: Usa diferentes casos de prueba (pequeño, mediano, grande, ordenado, etc.)

## Casos de Prueba Especiales

Los archivos de datos incluyen casos especiales útiles:

### Para Algoritmos de Ordenamiento:
- `ARRAY_PEQUEÑO` - Para visualizar el proceso paso a paso
- `ARRAY_MEDIANO` - Caso general
- `ARRAY_GRANDE` - Probar rendimiento
- `ARRAY_ORDENADO` - Mejor caso
- `ARRAY_INVERSO` - Peor caso
- `ARRAY_DUPLICADOS` - Caso con valores repetidos

### Para Búsqueda:
- `VALOR_PRESENTE` - Valor que existe en el array
- `VALOR_AUSENTE` - Valor que no existe
- `VALOR_PRIMERO` - Primer elemento
- `VALOR_ULTIMO` - Último elemento

## Preguntas Frecuentes

**P: ¿Debo usar estos datos obligatoriamente?**
R: No, son opcionales. Puedes usar tus propios datos o estos.

**P: ¿Puedo modificar los archivos de datos?**
R: Sí, puedes agregar tus propios casos de prueba.

**P: ¿Cómo compilo múltiples archivos?**
R: `javac *.java` compila todos los archivos .java en el directorio.

**P: ¿TestRunner es JUnit?**
R: No, es una versión simplificada para no requerir dependencias externas.

---

¡Feliz programación! 🚀
