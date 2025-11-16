# EJERCICIOS DE COMPLETA EL CÓDIGO

**Objetivo:** Practicar completando código parcial, simulando situaciones de examen.

**Tiempo estimado:** 5-10 minutos por ejercicio

**Cuándo usarlo:**
- Calentamiento antes de ejercicios completos
- Práctica enfocada de patrones específicos
- Revisión rápida de sintaxis

**Instrucciones:** Completa las partes marcadas con `// TODO` o `___`

---

## EJERCICIO 1: Strategy Pattern - Sistema de Envío

**Contexto:** Sistema de cálculo de costos de envío con diferentes estrategias.

**Completa el código:**

```java
// TODO: Define la interface ShippingStrategy
interface ___ {
    double ___(double weight);
}

// Estrategia de envío estándar: $5 por kg
class StandardShipping ___ ShippingStrategy {
    @Override
    public double ___(double weight) {
        return weight * ___;
    }
}

// Estrategia de envío express: $10 por kg
class ExpressShipping ___ ShippingStrategy {
    @Override
    public double ___(double weight) {
        return weight * 10;
    }
}

// TODO: Implementa FreeShipping (retorna 0)
class FreeShipping ___ ___ {
    // Completa aquí
}

class Order {
    private double weight;
    private ShippingStrategy ____;  // TODO: campo strategy

    public Order(double weight) {
        this.weight = weight;
    }

    // TODO: Completa el setter
    public void setShippingStrategy(___ strategy) {
        if (strategy == ___) {
            throw new ___("Strategy cannot be null");
        }
        this.___ = strategy;
    }

    public double calculateShippingCost() {
        // TODO: Usa la estrategia para calcular costo
        return ____.calculateCost(____);
    }
}
```

<details>
<summary>Ver solución</summary>

```java
interface ShippingStrategy {
    double calculateCost(double weight);
}

class StandardShipping implements ShippingStrategy {
    @Override
    public double calculateCost(double weight) {
        return weight * 5;
    }
}

class ExpressShipping implements ShippingStrategy {
    @Override
    public double calculateCost(double weight) {
        return weight * 10;
    }
}

class FreeShipping implements ShippingStrategy {
    @Override
    public double calculateCost(double weight) {
        return 0;
    }
}

class Order {
    private double weight;
    private ShippingStrategy strategy;

    public Order(double weight) {
        this.weight = weight;
    }

    public void setShippingStrategy(ShippingStrategy strategy) {
        if (strategy == null) {
            throw new IllegalArgumentException("Strategy cannot be null");
        }
        this.strategy = strategy;
    }

    public double calculateShippingCost() {
        return strategy.calculateCost(weight);
    }
}
```

</details>

---

## EJERCICIO 2: Visitor Pattern - Procesador de Formas

**Contexto:** Sistema de procesamiento de formas geométricas con Visitor.

**Completa el código:**

```java
// TODO: Define la interface Visitor
interface ShapeVisitor {
    void visit(___ circle);
    void visit(Rectangle ___);
}

// TODO: Define la interface Element
interface ___ {
    void ___(ShapeVisitor visitor);
}

class Circle implements ___ {
    private double radius;

    public Circle(double radius) {
        this.radius = radius;
    }

    // TODO: Implementa accept() correctamente
    @Override
    public void accept(___ visitor) {
        visitor.___(__);  // Double dispatch
    }

    public double getRadius() {
        return radius;
    }
}

class Rectangle implements Shape {
    private double width;
    private double height;

    public Rectangle(double width, double height) {
        this.width = width;
        this.height = height;
    }

    @Override
    public void accept(ShapeVisitor visitor) {
        // TODO: Implementa accept()
        ____.visit(____);
    }

    public double getWidth() { return width; }
    public double getHeight() { return height; }
}

// Visitor que calcula área
class AreaCalculator implements ___ {
    private double totalArea = 0;

    @Override
    public void visit(Circle circle) {
        // TODO: Calcula área del círculo (π * r²)
        double area = Math.PI * ___ * ___;
        totalArea += area;
    }

    @Override
    public void visit(___ rectangle) {
        // TODO: Calcula área del rectángulo
        double area = rectangle.___() * rectangle.getHeight();
        totalArea += ___;
    }

    public double getTotalArea() {
        return totalArea;
    }
}
```

<details>
<summary>Ver solución</summary>

```java
interface ShapeVisitor {
    void visit(Circle circle);
    void visit(Rectangle rectangle);
}

interface Shape {
    void accept(ShapeVisitor visitor);
}

class Circle implements Shape {
    private double radius;

    public Circle(double radius) {
        this.radius = radius;
    }

    @Override
    public void accept(ShapeVisitor visitor) {
        visitor.visit(this);
    }

    public double getRadius() {
        return radius;
    }
}

class Rectangle implements Shape {
    private double width;
    private double height;

    public Rectangle(double width, double height) {
        this.width = width;
        this.height = height;
    }

    @Override
    public void accept(ShapeVisitor visitor) {
        visitor.visit(this);
    }

    public double getWidth() { return width; }
    public double getHeight() { return height; }
}

class AreaCalculator implements ShapeVisitor {
    private double totalArea = 0;

    @Override
    public void visit(Circle circle) {
        double area = Math.PI * circle.getRadius() * circle.getRadius();
        totalArea += area;
    }

    @Override
    public void visit(Rectangle rectangle) {
        double area = rectangle.getWidth() * rectangle.getHeight();
        totalArea += area;
    }

    public double getTotalArea() {
        return totalArea;
    }
}
```

</details>

---

## EJERCICIO 3: Singleton - Logger Thread-Safe

**Contexto:** Implementar un logger Singleton thread-safe.

**Completa el código:**

```java
public class Logger {
    // TODO: Eager initialization - instancia privada estática final
    private static final Logger ___ = new Logger();

    // TODO: Constructor privado
    ___ Logger() {
        // Constructor privado previene instanciación externa
    }

    // TODO: Método getInstance()
    public static Logger ___() {
        return ___;
    }

    public void log(String message) {
        System.out.println("[LOG] " + message);
    }

    public void error(String message) {
        System.err.println("[ERROR] " + message);
    }
}

// Uso
public class Main {
    public static void main(String[] args) {
        // TODO: Obtén la instancia del logger
        Logger logger = Logger.___();
        logger.log("Application started");

        // TODO: Obtén otra referencia
        Logger logger2 = ____.getInstance();

        // TODO: Verifica que son la misma instancia
        System.out.println("Same instance? " + (logger ___ logger2));
    }
}
```

<details>
<summary>Ver solución</summary>

```java
public class Logger {
    private static final Logger INSTANCE = new Logger();

    private Logger() {
        // Constructor privado
    }

    public static Logger getInstance() {
        return INSTANCE;
    }

    public void log(String message) {
        System.out.println("[LOG] " + message);
    }

    public void error(String message) {
        System.err.println("[ERROR] " + message);
    }
}

public class Main {
    public static void main(String[] args) {
        Logger logger = Logger.getInstance();
        logger.log("Application started");

        Logger logger2 = Logger.getInstance();

        System.out.println("Same instance? " + (logger == logger2));  // true
    }
}
```

</details>

---

## EJERCICIO 4: Factory Pattern - Creador de Bebidas

**Contexto:** Factory para crear diferentes tipos de bebidas.

**Completa el código:**

```java
interface Beverage {
    void serve();
}

class Coffee implements Beverage {
    @Override
    public void serve() {
        System.out.println("Serving hot coffee");
    }
}

class Tea implements Beverage {
    @Override
    public void serve() {
        System.out.println("Serving hot tea");
    }
}

class Juice implements Beverage {
    @Override
    public void serve() {
        System.out.println("Serving cold juice");
    }
}

class BeverageFactory {
    // TODO: Método factory estático
    public static Beverage ___(String type) {
        // TODO: Valida que type no sea null o vacío
        if (type == ___ || type.isEmpty()) {
            throw new ___("Type cannot be null or empty");
        }

        // TODO: Normaliza el tipo (lowercase, trim)
        type = type.___().___();

        // TODO: Crea la bebida según el tipo
        switch (type) {
            case "coffee":
                return new ___();
            case "tea":
                return new Tea();
            case "juice":
                return new ___();
            default:
                // TODO: Lanza excepción para tipo desconocido
                throw new IllegalArgumentException("Unknown beverage: " + ___);
        }
    }
}

// Uso
public class Main {
    public static void main(String[] args) {
        // TODO: Crea bebidas usando factory
        Beverage coffee = BeverageFactory.___(___);
        coffee.serve();

        Beverage tea = BeverageFactory.createBeverage("TEA");  // Case-insensitive
        tea.serve();

        // TODO: Intenta crear bebida inválida (debe lanzar excepción)
        try {
            BeverageFactory.createBeverage("soda");
        } catch (___ e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
```

<details>
<summary>Ver solución</summary>

```java
interface Beverage {
    void serve();
}

class Coffee implements Beverage {
    @Override
    public void serve() {
        System.out.println("Serving hot coffee");
    }
}

class Tea implements Beverage {
    @Override
    public void serve() {
        System.out.println("Serving hot tea");
    }
}

class Juice implements Beverage {
    @Override
    public void serve() {
        System.out.println("Serving cold juice");
    }
}

class BeverageFactory {
    public static Beverage createBeverage(String type) {
        if (type == null || type.isEmpty()) {
            throw new IllegalArgumentException("Type cannot be null or empty");
        }

        type = type.toLowerCase().trim();

        switch (type) {
            case "coffee":
                return new Coffee();
            case "tea":
                return new Tea();
            case "juice":
                return new Juice();
            default:
                throw new IllegalArgumentException("Unknown beverage: " + type);
        }
    }
}

public class Main {
    public static void main(String[] args) {
        Beverage coffee = BeverageFactory.createBeverage("coffee");
        coffee.serve();

        Beverage tea = BeverageFactory.createBeverage("TEA");
        tea.serve();

        try {
            BeverageFactory.createBeverage("soda");
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
```

</details>

---

## EJERCICIO 5: File I/O - Lector de Configuración

**Contexto:** Leer un archivo de configuración (clave=valor).

**Completa el código:**

```java
import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.*;

class ConfigReader {

    // TODO: Método que lee archivo y retorna Map
    public Map<String, String> readConfig(String filename) ___ IOException {
        Map<String, String> config = new HashMap<>();

        // TODO: Usa try-with-resources para BufferedReader
        try (BufferedReader reader = new BufferedReader(
                new FileReader(___, StandardCharsets.UTF_8))) {

            String line;
            // TODO: Lee línea por línea
            while ((line = reader.___()) != null) {
                // Ignora líneas vacías y comentarios
                if (line.trim().isEmpty() || line.startsWith("#")) {
                    continue;
                }

                // TODO: Separa por '='
                String[] parts = line.split("___");
                if (parts.length == ___) {
                    String key = parts[0].trim();
                    String value = parts[1].trim();
                    config.___(key, value);
                }
            }
        }  // TODO: reader se cierra automáticamente aquí

        return config;
    }

    // TODO: Método que escribe configuración
    public void writeConfig(String filename, Map<String, String> config) throws ___ {
        // TODO: Valida que config no sea null
        if (config == ___) {
            throw new IllegalArgumentException("Config cannot be null");
        }

        // TODO: Try-with-resources para BufferedWriter
        try (BufferedWriter writer = new ___(
                new FileWriter(filename, StandardCharsets.UTF_8))) {

            // TODO: Itera sobre el Map
            for (Map.Entry<String, String> entry : config.___()) {
                // TODO: Escribe "key=value"
                writer.write(entry.getKey() + "=" + entry.___());
                writer.___();  // Nueva línea
            }
        }
    }
}

// Uso
public class Main {
    public static void main(String[] args) {
        ConfigReader reader = new ConfigReader();

        // TODO: Maneja IOException
        try {
            // Crear archivo de prueba
            Map<String, String> config = new HashMap<>();
            config.put("app.name", "MyApp");
            config.put("app.version", "1.0");
            config.put("app.port", "8080");

            // TODO: Escribe configuración
            reader.___(___config.txt___, config);

            // TODO: Lee configuración
            Map<String, String> loaded = reader.readConfig("config.txt");

            System.out.println("Loaded config:");
            loaded.forEach((k, v) -> System.out.println(k + " = " + v));

        } catch (___ e) {
            System.err.println("Error: " + e.getMessage());
        }
    }
}
```

<details>
<summary>Ver solución</summary>

```java
import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.*;

class ConfigReader {

    public Map<String, String> readConfig(String filename) throws IOException {
        Map<String, String> config = new HashMap<>();

        try (BufferedReader reader = new BufferedReader(
                new FileReader(filename, StandardCharsets.UTF_8))) {

            String line;
            while ((line = reader.readLine()) != null) {
                if (line.trim().isEmpty() || line.startsWith("#")) {
                    continue;
                }

                String[] parts = line.split("=");
                if (parts.length == 2) {
                    String key = parts[0].trim();
                    String value = parts[1].trim();
                    config.put(key, value);
                }
            }
        }

        return config;
    }

    public void writeConfig(String filename, Map<String, String> config) throws IOException {
        if (config == null) {
            throw new IllegalArgumentException("Config cannot be null");
        }

        try (BufferedWriter writer = new BufferedWriter(
                new FileWriter(filename, StandardCharsets.UTF_8))) {

            for (Map.Entry<String, String> entry : config.entrySet()) {
                writer.write(entry.getKey() + "=" + entry.getValue());
                writer.newLine();
            }
        }
    }
}

public class Main {
    public static void main(String[] args) {
        ConfigReader reader = new ConfigReader();

        try {
            Map<String, String> config = new HashMap<>();
            config.put("app.name", "MyApp");
            config.put("app.version", "1.0");
            config.put("app.port", "8080");

            reader.writeConfig("config.txt", config);

            Map<String, String> loaded = reader.readConfig("config.txt");

            System.out.println("Loaded config:");
            loaded.forEach((k, v) -> System.out.println(k + " = " + v));

        } catch (IOException e) {
            System.err.println("Error: " + e.getMessage());
        }
    }
}
```

</details>

---

## EJERCICIO 6: Collections - Gestor de Tareas

**Contexto:** Sistema de gestión de tareas con prioridades.

**Completa el código:**

```java
import java.util.*;

class Task {
    private String name;
    private int priority;

    public Task(String name, int priority) {
        this.name = name;
        this.priority = priority;
    }

    public String getName() { return name; }
    public int getPriority() { return priority; }

    @Override
    public String toString() {
        return name + " (Priority: " + priority + ")";
    }
}

class TaskManager {
    // TODO: Lista de tareas con tipo genérico
    private List<___> tasks;

    public TaskManager() {
        // TODO: Inicializa la lista
        this.tasks = new ___<>();
    }

    // TODO: Agrega una tarea
    public void addTask(Task task) {
        if (task == ___) {
            throw new ___("Task cannot be null");
        }
        tasks.___(task);
    }

    // TODO: Obtiene tareas ordenadas por prioridad (mayor a menor)
    public List<Task> getTasksByPriority() {
        return tasks.___()
            .sorted(Comparator.comparingInt(Task::getPriority).___())
            .collect(Collectors.___());
    }

    // TODO: Filtra tareas con prioridad mayor o igual a mínima
    public List<Task> getHighPriorityTasks(int minPriority) {
        return tasks.stream()
            .___(t -> t.___() >= minPriority)
            .collect(Collectors.toList());
    }

    // TODO: Cuenta cuántas tareas hay
    public int getTaskCount() {
        return tasks.___();
    }

    // TODO: Obtiene la tarea con mayor prioridad
    public Task getTopPriorityTask() {
        if (tasks.___()) {
            return null;
        }

        return tasks.stream()
            .max(Comparator.___(___).___)
            .orElse(null);
    }
}

// Uso
public class Main {
    public static void main(String[] args) {
        TaskManager manager = new TaskManager();

        // TODO: Agrega tareas
        manager.addTask(new Task("Fix bug", 5));
        manager.___(new Task("Write documentation", 2));
        manager.addTask(new Task("Implement feature", 4));

        // TODO: Obtén tareas por prioridad
        System.out.println("Tasks by priority:");
        manager.___().forEach(System.out::println);

        // TODO: Filtra tareas de alta prioridad (>= 4)
        System.out.println("\nHigh priority tasks:");
        manager.getHighPriorityTasks(___).forEach(System.out::println);

        // TODO: Obtén la tarea más importante
        Task top = manager.___();
        System.out.println("\nTop priority task: " + top);
    }
}
```

<details>
<summary>Ver solución</summary>

```java
import java.util.*;
import java.util.stream.Collectors;

class Task {
    private String name;
    private int priority;

    public Task(String name, int priority) {
        this.name = name;
        this.priority = priority;
    }

    public String getName() { return name; }
    public int getPriority() { return priority; }

    @Override
    public String toString() {
        return name + " (Priority: " + priority + ")";
    }
}

class TaskManager {
    private List<Task> tasks;

    public TaskManager() {
        this.tasks = new ArrayList<>();
    }

    public void addTask(Task task) {
        if (task == null) {
            throw new IllegalArgumentException("Task cannot be null");
        }
        tasks.add(task);
    }

    public List<Task> getTasksByPriority() {
        return tasks.stream()
            .sorted(Comparator.comparingInt(Task::getPriority).reversed())
            .collect(Collectors.toList());
    }

    public List<Task> getHighPriorityTasks(int minPriority) {
        return tasks.stream()
            .filter(t -> t.getPriority() >= minPriority)
            .collect(Collectors.toList());
    }

    public int getTaskCount() {
        return tasks.size();
    }

    public Task getTopPriorityTask() {
        if (tasks.isEmpty()) {
            return null;
        }

        return tasks.stream()
            .max(Comparator.comparingInt(Task::getPriority))
            .orElse(null);
    }
}

public class Main {
    public static void main(String[] args) {
        TaskManager manager = new TaskManager();

        manager.addTask(new Task("Fix bug", 5));
        manager.addTask(new Task("Write documentation", 2));
        manager.addTask(new Task("Implement feature", 4));

        System.out.println("Tasks by priority:");
        manager.getTasksByPriority().forEach(System.out::println);

        System.out.println("\nHigh priority tasks:");
        manager.getHighPriorityTasks(4).forEach(System.out::println);

        Task top = manager.getTopPriorityTask();
        System.out.println("\nTop priority task: " + top);
    }
}
```

</details>

---

## EJERCICIO 7: Excepciones - Validador de Edad

**Contexto:** Validador que lanza excepción personalizada.

**Completa el código:**

```java
// TODO: Crea excepción personalizada (checked)
class ___ extends ___ {
    public InvalidAgeException(String message) {
        super(___);
    }
}

class Person {
    private String name;
    private int age;

    // TODO: Constructor que valida edad
    public Person(String name, int age) ___ InvalidAgeException {
        // TODO: Valida nombre
        if (name == null || name.trim().___()) {
            throw new ___("Name cannot be null or empty");
        }

        // TODO: Valida edad (debe estar entre 0 y 150)
        if (age < ___ || age > 150) {
            throw new ___("Age must be between 0 and 150, got: " + age);
        }

        this.name = name;
        this.age = age;
    }

    public String getName() { return name; }
    public int getAge() { return age; }
}

class AgeValidator {
    // TODO: Valida si es mayor de edad
    public static void validateAdult(Person person) throws ___ {
        if (person == ___) {
            throw new IllegalArgumentException("Person cannot be null");
        }

        if (person.getAge() < ___) {
            throw new InvalidAgeException(
                person.getName() + " must be at least 18 years old"
            );
        }
    }
}

// Uso
public class Main {
    public static void main(String[] args) {
        // TODO: Maneja excepciones
        try {
            // Caso válido
            Person adult = new Person("Alice", 25);
            AgeValidator.___(adult);
            System.out.println(adult.getName() + " is an adult");

            // TODO: Caso inválido - menor de edad
            Person minor = new Person("Bob", ___);
            AgeValidator.validateAdult(minor);

        } catch (___ e) {
            System.out.println("Age error: " + e.getMessage());
        }

        // TODO: Caso inválido - edad fuera de rango
        try {
            Person invalid = new Person("Carol", ___);
        } catch (InvalidAgeException e) {
            System.out.println("Error: " + e.___());
        }
    }
}
```

<details>
<summary>Ver solución</summary>

```java
class InvalidAgeException extends Exception {
    public InvalidAgeException(String message) {
        super(message);
    }
}

class Person {
    private String name;
    private int age;

    public Person(String name, int age) throws InvalidAgeException {
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("Name cannot be null or empty");
        }

        if (age < 0 || age > 150) {
            throw new InvalidAgeException("Age must be between 0 and 150, got: " + age);
        }

        this.name = name;
        this.age = age;
    }

    public String getName() { return name; }
    public int getAge() { return age; }
}

class AgeValidator {
    public static void validateAdult(Person person) throws InvalidAgeException {
        if (person == null) {
            throw new IllegalArgumentException("Person cannot be null");
        }

        if (person.getAge() < 18) {
            throw new InvalidAgeException(
                person.getName() + " must be at least 18 years old"
            );
        }
    }
}

public class Main {
    public static void main(String[] args) {
        try {
            Person adult = new Person("Alice", 25);
            AgeValidator.validateAdult(adult);
            System.out.println(adult.getName() + " is an adult");

            Person minor = new Person("Bob", 15);
            AgeValidator.validateAdult(minor);

        } catch (InvalidAgeException e) {
            System.out.println("Age error: " + e.getMessage());
        }

        try {
            Person invalid = new Person("Carol", 200);
        } catch (InvalidAgeException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
```

</details>

---

## RESUMEN DE EJERCICIOS

| Ejercicio | Concepto | Dificultad | Tiempo |
|-----------|----------|------------|--------|
| 1 | Strategy Pattern | Fácil | 5-7 min |
| 2 | Visitor Pattern | Media | 8-10 min |
| 3 | Singleton | Fácil | 3-5 min |
| 4 | Factory | Fácil | 5-7 min |
| 5 | File I/O | Media | 8-10 min |
| 6 | Collections | Media | 8-10 min |
| 7 | Excepciones | Media | 7-9 min |

**Total:** 44-58 minutos

**Estrategia de uso:**
1. Intenta completar SIN ver la solución
2. Si te atascas >2 min en un blank, mira la solución
3. Después de completar, compara con la solución
4. Compila y ejecuta tu código
5. Si fallas en un patrón, repasa la guía correspondiente

**Beneficios:**
- Práctica enfocada de sintaxis
- Simula presión de examen (espacios en blanco)
- Refuerza patrones comunes
- Rápido feedback
