# Java Quick Reference

Complete syntax reference for all concepts in this course.

---

## 1. BASICS

### Variables & Types
```java
// Primitives
int numero = 10;
double decimal = 3.14;
boolean verdadero = true;
char letra = 'A';

// Reference types
String texto = "Hola";
int[] array = {1, 2, 3};
Integer wrapper = 10;  // Autoboxing
```

### Operators
```java
// Arithmetic: + - * / %
int resultado = 10 % 3;  // 1 (modulo)

// Comparison: == != < > <= >=
boolean igual = (a == b);

// Logical: && || !
boolean ambos = (a > 0 && b > 0);

// Ternary
String msg = (edad >= 18) ? "adulto" : "menor";
```

### Control Flow
```java
// If-else
if (condicion) {
    // ...
} else if (otra) {
    // ...
} else {
    // ...
}

// Switch (traditional)
switch (valor) {
    case 1:
        // ...
        break;
    default:
        // ...
}

// Switch (modern - Java 14+)
String result = switch (dia) {
    case 1, 2, 3, 4, 5 -> "laborable";
    case 6, 7 -> "fin de semana";
    default -> "invalido";
};
```

### Loops
```java
// For
for (int i = 0; i < 10; i++) { }

// Enhanced for (foreach)
for (String item : lista) { }

// While
while (condicion) { }

// Do-while
do { } while (condicion);

// Break & Continue
for (int i = 0; i < 10; i++) {
    if (i == 5) break;     // Exit loop
    if (i == 3) continue;  // Skip iteration
}
```

---

## 2. ARRAYS

```java
// Declaration
int[] nums = new int[5];
int[] nums = {1, 2, 3, 4, 5};
int[][] matrix = new int[3][3];

// Access
int first = nums[0];
int last = nums[nums.length - 1];

// Iterate
for (int i = 0; i < nums.length; i++) {
    System.out.println(nums[i]);
}

// 2D iteration
for (int i = 0; i < matrix.length; i++) {
    for (int j = 0; j < matrix[i].length; j++) {
        System.out.println(matrix[i][j]);
    }
}
```

---

## 3. METHODS

```java
// Basic method
public void saludar() {
    System.out.println("Hola");
}

// With parameters
public int sumar(int a, int b) {
    return a + b;
}

// Static method
public static double calcular(double x) {
    return x * 2;
}

// Varargs
public int sumarTodos(int... numeros) {
    int total = 0;
    for (int n : numeros) total += n;
    return total;
}
```

---

## 4. OOP - CLASSES & OBJECTS

```java
public class Persona {
    // Attributes (private = encapsulation)
    private String nombre;
    private int edad;

    // Constructor
    public Persona(String nombre, int edad) {
        this.nombre = nombre;
        this.edad = edad;
    }

    // Getters
    public String getNombre() { return nombre; }
    public int getEdad() { return edad; }

    // Setters
    public void setNombre(String nombre) { this.nombre = nombre; }
    public void setEdad(int edad) {
        if (edad >= 0) this.edad = edad;
    }

    // Methods
    public void saludar() {
        System.out.println("Hola, soy " + nombre);
    }

    // toString
    @Override
    public String toString() {
        return "Persona{nombre='" + nombre + "', edad=" + edad + "}";
    }
}

// Usage
Persona p = new Persona("Juan", 25);
p.saludar();
```

---

## 5. INHERITANCE

```java
// Parent class
public class Animal {
    protected String nombre;

    public Animal(String nombre) {
        this.nombre = nombre;
    }

    public void hacerSonido() {
        System.out.println("...");
    }
}

// Child class
public class Perro extends Animal {
    private String raza;

    public Perro(String nombre, String raza) {
        super(nombre);  // Call parent constructor
        this.raza = raza;
    }

    @Override
    public void hacerSonido() {
        System.out.println("Guau!");
    }
}

// Usage
Animal a = new Perro("Rex", "Labrador");  // Polymorphism
a.hacerSonido();  // "Guau!"
```

---

## 6. ABSTRACT CLASSES

```java
public abstract class Figura {
    protected String color;

    public Figura(String color) {
        this.color = color;
    }

    // Abstract method (no body)
    public abstract double calcularArea();

    // Concrete method
    public void mostrarColor() {
        System.out.println("Color: " + color);
    }
}

public class Circulo extends Figura {
    private double radio;

    public Circulo(String color, double radio) {
        super(color);
        this.radio = radio;
    }

    @Override
    public double calcularArea() {
        return Math.PI * radio * radio;
    }
}
```

---

## 7. INTERFACES

```java
public interface Volador {
    void volar();  // Abstract by default

    default void aterrizar() {  // Default method
        System.out.println("Aterrizando...");
    }
}

public interface Nadador {
    void nadar();
}

// Multiple interfaces
public class Pato implements Volador, Nadador {
    @Override
    public void volar() {
        System.out.println("Pato volando");
    }

    @Override
    public void nadar() {
        System.out.println("Pato nadando");
    }
}
```

---

## 8. COLLECTIONS

### ArrayList
```java
import java.util.ArrayList;

ArrayList<String> lista = new ArrayList<>();
lista.add("uno");
lista.add("dos");
lista.get(0);           // "uno"
lista.set(0, "primero");
lista.remove(0);
lista.size();           // 1
lista.contains("dos");  // true
lista.isEmpty();        // false
lista.clear();

// Iterate
for (String s : lista) {
    System.out.println(s);
}
```

### HashMap
```java
import java.util.HashMap;

HashMap<String, Integer> mapa = new HashMap<>();
mapa.put("uno", 1);
mapa.put("dos", 2);
mapa.get("uno");           // 1
mapa.getOrDefault("tres", 0);  // 0
mapa.containsKey("uno");   // true
mapa.containsValue(1);     // true
mapa.remove("uno");
mapa.size();

// Iterate
for (String key : mapa.keySet()) {
    System.out.println(key + ": " + mapa.get(key));
}

for (Map.Entry<String, Integer> entry : mapa.entrySet()) {
    System.out.println(entry.getKey() + ": " + entry.getValue());
}
```

### HashSet
```java
import java.util.HashSet;

HashSet<String> set = new HashSet<>();
set.add("a");
set.add("b");
set.add("a");  // Ignored (duplicate)
set.contains("a");  // true
set.size();         // 2
```

### LinkedList / Queue
```java
import java.util.LinkedList;
import java.util.Queue;

Queue<String> cola = new LinkedList<>();
cola.offer("primero");  // Add to end
cola.offer("segundo");
cola.peek();   // "primero" (see first, don't remove)
cola.poll();   // "primero" (remove first)
```

### Stack
```java
import java.util.Stack;

Stack<Integer> pila = new Stack<>();
pila.push(1);
pila.push(2);
pila.peek();  // 2 (see top)
pila.pop();   // 2 (remove top)
pila.empty(); // false
```

---

## 9. EXCEPTIONS

```java
// Try-catch
try {
    int result = 10 / 0;
} catch (ArithmeticException e) {
    System.out.println("Error: " + e.getMessage());
} finally {
    System.out.println("Siempre se ejecuta");
}

// Multiple catches
try {
    // ...
} catch (IOException | SQLException e) {
    // Handle both
}

// Throw
public void validar(int edad) {
    if (edad < 0) {
        throw new IllegalArgumentException("Edad invalida");
    }
}

// Custom exception
public class MiException extends Exception {
    public MiException(String mensaje) {
        super(mensaje);
    }
}
```

---

## 10. FILE I/O

```java
import java.io.*;

// Read file
try (BufferedReader br = new BufferedReader(new FileReader("file.txt"))) {
    String linea;
    while ((linea = br.readLine()) != null) {
        System.out.println(linea);
    }
} catch (IOException e) {
    e.printStackTrace();
}

// Write file
try (BufferedWriter bw = new BufferedWriter(new FileWriter("file.txt"))) {
    bw.write("Linea 1");
    bw.newLine();
    bw.write("Linea 2");
} catch (IOException e) {
    e.printStackTrace();
}

// Parse CSV line
String linea = "nombre,edad,ciudad";
String[] partes = linea.split(",");
String nombre = partes[0];
int edad = Integer.parseInt(partes[1]);
```

---

## 11. GENERICS

```java
// Generic class
public class Caja<T> {
    private T contenido;

    public void guardar(T item) {
        this.contenido = item;
    }

    public T obtener() {
        return contenido;
    }
}

// Usage
Caja<String> cajaTexto = new Caja<>();
cajaTexto.guardar("Hola");
String texto = cajaTexto.obtener();

// Generic method
public static <T> void imprimir(T item) {
    System.out.println(item);
}

// Bounded
public class Contenedor<T extends Comparable<T>> { }
```

---

## 12. LAMBDAS & STREAMS

```java
import java.util.List;
import java.util.stream.Collectors;

List<String> nombres = List.of("Ana", "Juan", "Pedro", "Maria");

// Filter
List<String> conA = nombres.stream()
    .filter(n -> n.startsWith("A"))
    .collect(Collectors.toList());

// Map
List<Integer> longitudes = nombres.stream()
    .map(String::length)
    .collect(Collectors.toList());

// Reduce
int totalLetras = nombres.stream()
    .mapToInt(String::length)
    .sum();

// Sort
List<String> ordenados = nombres.stream()
    .sorted()
    .collect(Collectors.toList());

// ForEach
nombres.forEach(System.out::println);

// Combined
nombres.stream()
    .filter(n -> n.length() > 3)
    .map(String::toUpperCase)
    .sorted()
    .forEach(System.out::println);
```

---

## 13. COMPARATOR & COMPARABLE

```java
// Comparable (natural order)
public class Persona implements Comparable<Persona> {
    private String nombre;
    private int edad;

    @Override
    public int compareTo(Persona otra) {
        return this.nombre.compareTo(otra.nombre);
    }
}

// Comparator (custom order)
import java.util.Comparator;

Comparator<Persona> porEdad = (p1, p2) -> p1.getEdad() - p2.getEdad();

// Or using method reference
Comparator<Persona> porEdad = Comparator.comparingInt(Persona::getEdad);

// Multiple criteria
Comparator<Persona> compuesto = Comparator
    .comparing(Persona::getNombre)
    .thenComparingInt(Persona::getEdad);

// Sort
Collections.sort(lista, porEdad);
lista.sort(porEdad);
lista.sort(porEdad.reversed());  // Descending
```

---

## 14. DESIGN PATTERNS

### Singleton
```java
public class Singleton {
    private static Singleton instancia;

    private Singleton() { }

    public static Singleton getInstance() {
        if (instancia == null) {
            instancia = new Singleton();
        }
        return instancia;
    }
}
```

### Factory
```java
public class VehiculoFactory {
    public static Vehiculo crear(String tipo) {
        return switch (tipo) {
            case "auto" -> new Auto();
            case "moto" -> new Moto();
            default -> throw new IllegalArgumentException("Tipo desconocido");
        };
    }
}
```

### Strategy
```java
// Interface
public interface EstrategiaDescuento {
    double aplicar(double precio);
}

// Implementations
public class SinDescuento implements EstrategiaDescuento {
    public double aplicar(double precio) { return precio; }
}

public class Descuento10 implements EstrategiaDescuento {
    public double aplicar(double precio) { return precio * 0.9; }
}

// Context
public class Tienda {
    private EstrategiaDescuento estrategia;

    public void setEstrategia(EstrategiaDescuento e) {
        this.estrategia = e;
    }

    public double calcularPrecio(double precio) {
        return estrategia.aplicar(precio);
    }
}
```

### Visitor
```java
// Visitor interface
public interface Visitor {
    void visitar(Auto auto);
    void visitar(Moto moto);
}

// Visitable interface
public interface Visitable {
    void accept(Visitor v);
}

// Implementation
public class Auto implements Visitable {
    public void accept(Visitor v) {
        v.visitar(this);
    }
}

// Concrete visitor
public class CalculadorConsumo implements Visitor {
    public void visitar(Auto auto) {
        // Calculate for auto
    }
    public void visitar(Moto moto) {
        // Calculate for moto
    }
}
```

---

## 15. USEFUL METHODS

### String
```java
String s = "Hola Mundo";
s.length();           // 10
s.charAt(0);          // 'H'
s.substring(0, 4);    // "Hola"
s.toLowerCase();      // "hola mundo"
s.toUpperCase();      // "HOLA MUNDO"
s.trim();             // Remove spaces
s.split(" ");         // ["Hola", "Mundo"]
s.contains("Mundo");  // true
s.startsWith("Hola"); // true
s.endsWith("Mundo");  // true
s.replace("o", "0");  // "H0la Mund0"
s.equals("Hola Mundo"); // true (use this, not ==)
```

### Math
```java
Math.max(5, 10);      // 10
Math.min(5, 10);      // 5
Math.abs(-5);         // 5
Math.sqrt(16);        // 4.0
Math.pow(2, 3);       // 8.0
Math.round(3.7);      // 4
Math.floor(3.7);      // 3.0
Math.ceil(3.2);       // 4.0
Math.random();        // 0.0 to 1.0
```

### Arrays (utility class)
```java
import java.util.Arrays;

int[] arr = {3, 1, 4, 1, 5};
Arrays.sort(arr);             // {1, 1, 3, 4, 5}
Arrays.binarySearch(arr, 3);  // index of 3
Arrays.fill(arr, 0);          // All zeros
Arrays.toString(arr);         // "[0, 0, 0, 0, 0]"
Arrays.equals(arr1, arr2);    // Compare arrays
```

### Collections (utility class)
```java
import java.util.Collections;

Collections.sort(lista);
Collections.reverse(lista);
Collections.shuffle(lista);
Collections.max(lista);
Collections.min(lista);
Collections.frequency(lista, "a");
```

---

## KEYBOARD SHORTCUTS (VS Code)

| Action | Shortcut |
|--------|----------|
| Run file | `Ctrl+F5` |
| Debug | `F5` |
| Format code | `Shift+Alt+F` |
| Go to definition | `F12` |
| Find all references | `Shift+F12` |
| Rename | `F2` |
| Quick fix | `Ctrl+.` |
| Comment line | `Ctrl+/` |
| Duplicate line | `Shift+Alt+Down` |
| Move line | `Alt+Up/Down` |
