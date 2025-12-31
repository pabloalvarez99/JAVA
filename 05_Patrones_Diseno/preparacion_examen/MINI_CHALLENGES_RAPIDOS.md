# MINI-CHALLENGES RAPIDOS - Practica Enfocada

**Objetivo:** Ejercicios cortos (10-15 minutos) para practicar conceptos específicos.

**Tiempo estimado:** 10-15 minutos por challenge

**Cuándo usarlo:**
- Sesiones de estudio cortas
- Calentamiento antes de ejercicios largos
- Práctica diaria de conceptos
- Validación rápida de conocimiento

**Formato:** Cada challenge es independiente y enfocado en un solo concepto.

---

## CHALLENGE 1: Strategy - Sistema de Impuestos (10 min)

**Objetivo:** Implementar Strategy para cálculo de impuestos.

**Requerimientos:**
1. Interface `TaxStrategy` con método `calculateTax(double amount)`
2. Tres estrategias:
   - `NoTax`: retorna 0
   - `StandardTax`: aplica 15% de impuesto
   - `LuxuryTax`: aplica 30% de impuesto
3. Clase `Product` que:
   - Tiene precio base
   - Usa TaxStrategy para calcular precio final
   - Permite cambiar estrategia

**Test tu código:**
```java
Product phone = new Product(1000);
phone.setTaxStrategy(new StandardTax());
System.out.println(phone.getFinalPrice());  // Debe ser 1150

phone.setTaxStrategy(new LuxuryTax());
System.out.println(phone.getFinalPrice());  // Debe ser 1300
```

**Criterios de éxito:**
- [ ] Compila sin errores
- [ ] Usa interface TaxStrategy
- [ ] Permite cambiar estrategia en runtime
- [ ] Cálculos correctos

<details>
<summary>Ver solución</summary>

```java
// Interface
interface TaxStrategy {
    double calculateTax(double amount);
}

// Estrategias concretas
class NoTax implements TaxStrategy {
    @Override
    public double calculateTax(double amount) {
        return 0;
    }
}

class StandardTax implements TaxStrategy {
    @Override
    public double calculateTax(double amount) {
        return amount * 0.15;
    }
}

class LuxuryTax implements TaxStrategy {
    @Override
    public double calculateTax(double amount) {
        return amount * 0.30;
    }
}

// Context
class Product {
    private double basePrice;
    private TaxStrategy taxStrategy;

    public Product(double basePrice) {
        this.basePrice = basePrice;
        this.taxStrategy = new NoTax();  // Default
    }

    public void setTaxStrategy(TaxStrategy taxStrategy) {
        if (taxStrategy == null) {
            throw new IllegalArgumentException("Tax strategy cannot be null");
        }
        this.taxStrategy = taxStrategy;
    }

    public double getFinalPrice() {
        return basePrice + taxStrategy.calculateTax(basePrice);
    }

    public double getBasePrice() {
        return basePrice;
    }
}

// Test
public class Main {
    public static void main(String[] args) {
        Product phone = new Product(1000);

        phone.setTaxStrategy(new NoTax());
        System.out.println("No tax: " + phone.getFinalPrice());  // 1000

        phone.setTaxStrategy(new StandardTax());
        System.out.println("Standard tax: " + phone.getFinalPrice());  // 1150

        phone.setTaxStrategy(new LuxuryTax());
        System.out.println("Luxury tax: " + phone.getFinalPrice());  // 1300
    }
}
```

</details>

---

## CHALLENGE 2: Visitor - Análisis de Empleados (15 min)

**Objetivo:** Implementar Visitor para calcular estadísticas de empleados.

**Requerimientos:**
1. Interface `Employee` con `accept(Visitor visitor)`
2. Clases `Manager` y `Developer` implementan Employee
   - Manager: tiene salario y bonus
   - Developer: tiene salario y horas extra
3. Interface `Visitor` con métodos visit para cada tipo
4. `SalaryCalculatorVisitor` que calcula salario total:
   - Manager: salario + bonus
   - Developer: salario + (horas extra * 50)

**Test tu código:**
```java
List<Employee> employees = List.of(
    new Manager("Ana", 5000, 1000),
    new Developer("Bob", 4000, 20),
    new Developer("Carol", 4500, 10)
);

SalaryCalculatorVisitor calc = new SalaryCalculatorVisitor();
for (Employee emp : employees) {
    emp.accept(calc);
}

System.out.println("Total: " + calc.getTotal());  // 16500
```

**Criterios de éxito:**
- [ ] Double dispatch correcto (accept llama a visit)
- [ ] Visitor calcula totales correctamente
- [ ] Funciona con List de Employee

<details>
<summary>Ver solución</summary>

```java
import java.util.List;

// Visitor interface
interface EmployeeVisitor {
    void visit(Manager manager);
    void visit(Developer developer);
}

// Element interface
interface Employee {
    void accept(EmployeeVisitor visitor);
}

// Concrete Elements
class Manager implements Employee {
    private String name;
    private double salary;
    private double bonus;

    public Manager(String name, double salary, double bonus) {
        this.name = name;
        this.salary = salary;
        this.bonus = bonus;
    }

    @Override
    public void accept(EmployeeVisitor visitor) {
        visitor.visit(this);
    }

    public String getName() { return name; }
    public double getSalary() { return salary; }
    public double getBonus() { return bonus; }
}

class Developer implements Employee {
    private String name;
    private double salary;
    private int overtimeHours;

    public Developer(String name, double salary, int overtimeHours) {
        this.name = name;
        this.salary = salary;
        this.overtimeHours = overtimeHours;
    }

    @Override
    public void accept(EmployeeVisitor visitor) {
        visitor.visit(this);
    }

    public String getName() { return name; }
    public double getSalary() { return salary; }
    public int getOvertimeHours() { return overtimeHours; }
}

// Concrete Visitor
class SalaryCalculatorVisitor implements EmployeeVisitor {
    private double total = 0;

    @Override
    public void visit(Manager manager) {
        total += manager.getSalary() + manager.getBonus();
    }

    @Override
    public void visit(Developer developer) {
        total += developer.getSalary() + (developer.getOvertimeHours() * 50);
    }

    public double getTotal() {
        return total;
    }

    public void reset() {
        total = 0;
    }
}

// Test
public class Main {
    public static void main(String[] args) {
        List<Employee> employees = List.of(
            new Manager("Ana", 5000, 1000),        // 6000
            new Developer("Bob", 4000, 20),        // 5000
            new Developer("Carol", 4500, 10)       // 5000
        );

        SalaryCalculatorVisitor calc = new SalaryCalculatorVisitor();
        for (Employee emp : employees) {
            emp.accept(calc);
        }

        System.out.println("Total salaries: " + calc.getTotal());  // 16000
    }
}
```

</details>

---

## CHALLENGE 3: Singleton - Configuración Global (10 min)

**Objetivo:** Implementar Singleton thread-safe para configuración.

**Requerimientos:**
1. Clase `Config` como Singleton
2. Debe almacenar propiedades (Map<String, String>)
3. Métodos:
   - `setProperty(String key, String value)`
   - `getProperty(String key)` - retorna String o null
   - `getProperty(String key, String defaultValue)` - retorna default si no existe
4. Thread-safe (usar eager initialization)

**Test tu código:**
```java
Config config = Config.getInstance();
config.setProperty("app.name", "MyApp");
config.setProperty("app.version", "1.0");

String name = config.getProperty("app.name");  // "MyApp"
String timeout = config.getProperty("timeout", "30");  // "30" (default)

Config config2 = Config.getInstance();
System.out.println(config == config2);  // true
```

**Criterios de éxito:**
- [ ] Constructor privado
- [ ] getInstance() retorna siempre la misma instancia
- [ ] Thread-safe
- [ ] Funciona con defaults

<details>
<summary>Ver solución</summary>

```java
import java.util.HashMap;
import java.util.Map;

public class Config {
    // Eager initialization - thread-safe
    private static final Config INSTANCE = new Config();

    private Map<String, String> properties;

    // Constructor privado
    private Config() {
        this.properties = new HashMap<>();
    }

    public static Config getInstance() {
        return INSTANCE;
    }

    public void setProperty(String key, String value) {
        if (key == null || key.isEmpty()) {
            throw new IllegalArgumentException("Key cannot be null or empty");
        }
        properties.put(key, value);
    }

    public String getProperty(String key) {
        return properties.get(key);
    }

    public String getProperty(String key, String defaultValue) {
        return properties.getOrDefault(key, defaultValue);
    }

    // Útil para testing
    public void clear() {
        properties.clear();
    }
}

// Test
class Main {
    public static void main(String[] args) {
        Config config = Config.getInstance();
        config.setProperty("app.name", "MyApp");
        config.setProperty("app.version", "1.0");

        System.out.println("Name: " + config.getProperty("app.name"));
        System.out.println("Timeout: " + config.getProperty("timeout", "30"));

        Config config2 = Config.getInstance();
        System.out.println("Same instance? " + (config == config2));  // true
        System.out.println("Name from config2: " + config2.getProperty("app.name"));
    }
}
```

</details>

---

## CHALLENGE 4: Factory - Creador de Animales (12 min)

**Objetivo:** Implementar Factory con validación robusta.

**Requerimientos:**
1. Interface `Animal` con método `makeSound()`
2. Clases: `Dog`, `Cat`, `Bird` implementan Animal
3. Clase `AnimalFactory` con:
   - Método `createAnimal(String type)` - lanza excepción si tipo inválido
   - Método estático (no requiere instancia)
   - Validación de null/empty

**Test tu código:**
```java
Animal dog = AnimalFactory.createAnimal("dog");
dog.makeSound();  // "Woof!"

try {
    Animal invalid = AnimalFactory.createAnimal("dragon");
} catch (IllegalArgumentException e) {
    System.out.println("Error: " + e.getMessage());
}
```

**Criterios de éxito:**
- [ ] Lanza excepción con mensaje claro para tipo inválido
- [ ] Valida null y string vacío
- [ ] Método es estático
- [ ] Comparación de Strings correcta (equals, no ==)

<details>
<summary>Ver solución</summary>

```java
// Interface
interface Animal {
    void makeSound();
}

// Implementaciones
class Dog implements Animal {
    @Override
    public void makeSound() {
        System.out.println("Woof!");
    }
}

class Cat implements Animal {
    @Override
    public void makeSound() {
        System.out.println("Meow!");
    }
}

class Bird implements Animal {
    @Override
    public void makeSound() {
        System.out.println("Tweet!");
    }
}

// Factory
class AnimalFactory {
    public static Animal createAnimal(String type) {
        // Validación de entrada
        if (type == null || type.isEmpty()) {
            throw new IllegalArgumentException("Animal type cannot be null or empty");
        }

        // Normalizar (case-insensitive)
        type = type.toLowerCase().trim();

        // Crear según tipo
        switch (type) {
            case "dog":
                return new Dog();
            case "cat":
                return new Cat();
            case "bird":
                return new Bird();
            default:
                throw new IllegalArgumentException(
                    "Unknown animal type: " + type + ". Valid types: dog, cat, bird"
                );
        }
    }
}

// Test
public class Main {
    public static void main(String[] args) {
        // Casos válidos
        Animal dog = AnimalFactory.createAnimal("dog");
        dog.makeSound();  // Woof!

        Animal cat = AnimalFactory.createAnimal("CAT");  // Case-insensitive
        cat.makeSound();  // Meow!

        Animal bird = AnimalFactory.createAnimal("  bird  ");  // Trimmed
        bird.makeSound();  // Tweet!

        // Casos inválidos
        try {
            AnimalFactory.createAnimal("dragon");
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }

        try {
            AnimalFactory.createAnimal(null);
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
```

</details>

---

## CHALLENGE 5: Collections - Filtrado de Estudiantes (12 min)

**Objetivo:** Usar Collections y Streams correctamente.

**Requerimientos:**
1. Clase `Student` con: nombre, edad, promedio
2. Clase `StudentManager` con:
   - `List<Student> students`
   - `addStudent(Student s)`
   - `getTopStudents(int n)` - retorna los n estudiantes con mejor promedio
   - `getStudentsAbove(double minGrade)` - filtra por promedio mínimo
   - `getAverageGrade()` - promedio de todos los estudiantes

**Test tu código:**
```java
StudentManager manager = new StudentManager();
manager.addStudent(new Student("Ana", 20, 9.5));
manager.addStudent(new Student("Bob", 21, 8.0));
manager.addStudent(new Student("Carol", 19, 9.8));

List<Student> top2 = manager.getTopStudents(2);  // Carol, Ana
System.out.println("Average: " + manager.getAverageGrade());  // 9.1
```

**Criterios de éxito:**
- [ ] Usa generics correctamente
- [ ] getTopStudents ordena correctamente
- [ ] Maneja lista vacía sin errores
- [ ] Usa streams para cálculos

<details>
<summary>Ver solución</summary>

```java
import java.util.*;
import java.util.stream.Collectors;

class Student {
    private String name;
    private int age;
    private double grade;

    public Student(String name, int age, double grade) {
        this.name = name;
        this.age = age;
        this.grade = grade;
    }

    public String getName() { return name; }
    public int getAge() { return age; }
    public double getGrade() { return grade; }

    @Override
    public String toString() {
        return String.format("%s (%.1f)", name, grade);
    }
}

class StudentManager {
    private List<Student> students;

    public StudentManager() {
        this.students = new ArrayList<>();
    }

    public void addStudent(Student student) {
        if (student == null) {
            throw new IllegalArgumentException("Student cannot be null");
        }
        students.add(student);
    }

    public List<Student> getTopStudents(int n) {
        if (n < 0) {
            throw new IllegalArgumentException("n cannot be negative");
        }

        return students.stream()
            .sorted(Comparator.comparingDouble(Student::getGrade).reversed())
            .limit(n)
            .collect(Collectors.toList());
    }

    public List<Student> getStudentsAbove(double minGrade) {
        return students.stream()
            .filter(s -> s.getGrade() >= minGrade)
            .collect(Collectors.toList());
    }

    public double getAverageGrade() {
        if (students.isEmpty()) {
            return 0.0;
        }

        return students.stream()
            .mapToDouble(Student::getGrade)
            .average()
            .orElse(0.0);
    }

    public int getCount() {
        return students.size();
    }
}

// Test
public class Main {
    public static void main(String[] args) {
        StudentManager manager = new StudentManager();

        manager.addStudent(new Student("Ana", 20, 9.5));
        manager.addStudent(new Student("Bob", 21, 8.0));
        manager.addStudent(new Student("Carol", 19, 9.8));
        manager.addStudent(new Student("David", 22, 7.5));

        System.out.println("Top 2 students:");
        manager.getTopStudents(2).forEach(System.out::println);

        System.out.println("\nStudents above 9.0:");
        manager.getStudentsAbove(9.0).forEach(System.out::println);

        System.out.println("\nAverage grade: " + manager.getAverageGrade());
    }
}
```

</details>

---

## CHALLENGE 6: File I/O - Procesador de Datos (15 min)

**Objetivo:** Leer y escribir archivos con manejo correcto de recursos.

**Requerimientos:**
1. Clase `DataProcessor` con:
   - `List<String> readLines(String filename)` - lee todas las líneas
   - `void writeLines(String filename, List<String> lines)` - escribe líneas
   - Usar try-with-resources
   - Manejar IOExceptions correctamente

**Test tu código:**
Crea archivo "input.txt" con:
```
Alice,25
Bob,30
Carol,28
```

```java
DataProcessor processor = new DataProcessor();
List<String> lines = processor.readLines("input.txt");
System.out.println("Read " + lines.size() + " lines");

List<String> modified = lines.stream()
    .map(line -> line.toUpperCase())
    .collect(Collectors.toList());

processor.writeLines("output.txt", modified);
```

**Criterios de éxito:**
- [ ] Usa try-with-resources
- [ ] Maneja FileNotFoundException
- [ ] Escribe con newlines
- [ ] Cierra recursos automáticamente

<details>
<summary>Ver solución</summary>

```java
import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

class DataProcessor {

    public List<String> readLines(String filename) throws IOException {
        List<String> lines = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(
                new FileReader(filename, StandardCharsets.UTF_8))) {

            String line;
            while ((line = reader.readLine()) != null) {
                lines.add(line);
            }
        }

        return lines;
    }

    public void writeLines(String filename, List<String> lines) throws IOException {
        if (lines == null) {
            throw new IllegalArgumentException("Lines cannot be null");
        }

        try (BufferedWriter writer = new BufferedWriter(
                new FileWriter(filename, StandardCharsets.UTF_8))) {

            for (String line : lines) {
                writer.write(line);
                writer.newLine();
            }
        }
    }

    public int countLines(String filename) throws IOException {
        int count = 0;

        try (BufferedReader reader = new BufferedReader(
                new FileReader(filename, StandardCharsets.UTF_8))) {

            while (reader.readLine() != null) {
                count++;
            }
        }

        return count;
    }
}

// Test
public class Main {
    public static void main(String[] args) {
        DataProcessor processor = new DataProcessor();

        try {
            // Crear archivo de prueba
            List<String> testData = List.of(
                "Alice,25",
                "Bob,30",
                "Carol,28"
            );
            processor.writeLines("input.txt", testData);

            // Leer
            List<String> lines = processor.readLines("input.txt");
            System.out.println("Read " + lines.size() + " lines");

            // Procesar y escribir
            List<String> modified = lines.stream()
                .map(String::toUpperCase)
                .toList();

            processor.writeLines("output.txt", modified);
            System.out.println("Wrote modified data to output.txt");

            // Verificar
            System.out.println("\nModified content:");
            processor.readLines("output.txt").forEach(System.out::println);

        } catch (IOException e) {
            System.err.println("Error: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
```

</details>

---

## CHALLENGE 7: Excepciones - Validación de Usuario (10 min)

**Objetivo:** Crear y lanzar excepciones personalizadas.

**Requerimientos:**
1. Excepción `InvalidUserException` (checked exception)
2. Clase `User` con: username, email, age
3. Método `validateUser(User user)` que lanza InvalidUserException si:
   - Username es null o vacío
   - Email no contiene "@"
   - Age es menor a 18

**Test tu código:**
```java
try {
    User user = new User("", "test@email.com", 25);
    validateUser(user);  // Debe lanzar excepción
} catch (InvalidUserException e) {
    System.out.println("Error: " + e.getMessage());
}
```

**Criterios de éxito:**
- [ ] Excepción personalizada
- [ ] Mensaje descriptivo en la excepción
- [ ] Validaciones correctas
- [ ] Manejo apropiado de null

<details>
<summary>Ver solución</summary>

```java
// Excepción personalizada
class InvalidUserException extends Exception {
    public InvalidUserException(String message) {
        super(message);
    }
}

// Clase User
class User {
    private String username;
    private String email;
    private int age;

    public User(String username, String email, int age) {
        this.username = username;
        this.email = email;
        this.age = age;
    }

    public String getUsername() { return username; }
    public String getEmail() { return email; }
    public int getAge() { return age; }
}

// Validador
class UserValidator {

    public static void validateUser(User user) throws InvalidUserException {
        if (user == null) {
            throw new InvalidUserException("User cannot be null");
        }

        // Validar username
        if (user.getUsername() == null || user.getUsername().trim().isEmpty()) {
            throw new InvalidUserException("Username cannot be null or empty");
        }

        // Validar email
        if (user.getEmail() == null || !user.getEmail().contains("@")) {
            throw new InvalidUserException("Email must contain @ symbol");
        }

        // Validar age
        if (user.getAge() < 18) {
            throw new InvalidUserException("User must be at least 18 years old");
        }
    }
}

// Test
public class Main {
    public static void main(String[] args) {
        testUser(new User("john", "john@email.com", 25), "Valid user");
        testUser(new User("", "test@email.com", 25), "Empty username");
        testUser(new User("alice", "invalid-email", 30), "Invalid email");
        testUser(new User("bob", "bob@email.com", 16), "Underage user");
        testUser(null, "Null user");
    }

    private static void testUser(User user, String testName) {
        try {
            UserValidator.validateUser(user);
            System.out.println(testName + ": VALID");
        } catch (InvalidUserException e) {
            System.out.println(testName + ": INVALID - " + e.getMessage());
        }
    }
}
```

</details>

---

## CHALLENGE 8: Generics - Caja Genérica (12 min)

**Objetivo:** Crear clase genérica con restricciones de tipo.

**Requerimientos:**
1. Clase `Box<T>` que:
   - Almacena un valor de tipo T
   - `set(T value)` - establece valor
   - `T get()` - obtiene valor
   - `boolean isEmpty()` - verifica si hay valor
   - `void clear()` - limpia el valor
2. Clase `ComparableBox<T extends Comparable<T>>` que:
   - Extiende funcionalidad de Box
   - `boolean isGreaterThan(T other)` - compara con otro valor

**Test tu código:**
```java
Box<String> stringBox = new Box<>();
stringBox.set("Hello");
System.out.println(stringBox.get());  // "Hello"

ComparableBox<Integer> intBox = new ComparableBox<>();
intBox.set(10);
System.out.println(intBox.isGreaterThan(5));  // true
```

**Criterios de éxito:**
- [ ] Usa generics correctamente
- [ ] ComparableBox tiene bounded type parameter
- [ ] Maneja null apropiadamente
- [ ] isEmpty() funciona correctamente

<details>
<summary>Ver solución</summary>

```java
// Box genérico simple
class Box<T> {
    private T value;

    public void set(T value) {
        this.value = value;
    }

    public T get() {
        return value;
    }

    public boolean isEmpty() {
        return value == null;
    }

    public void clear() {
        value = null;
    }

    @Override
    public String toString() {
        return isEmpty() ? "Empty box" : "Box containing: " + value;
    }
}

// Box con restricción Comparable
class ComparableBox<T extends Comparable<T>> extends Box<T> {

    public boolean isGreaterThan(T other) {
        if (get() == null) {
            throw new IllegalStateException("Box is empty");
        }
        if (other == null) {
            throw new IllegalArgumentException("Cannot compare with null");
        }

        return get().compareTo(other) > 0;
    }

    public boolean isLessThan(T other) {
        if (get() == null) {
            throw new IllegalStateException("Box is empty");
        }
        if (other == null) {
            throw new IllegalArgumentException("Cannot compare with null");
        }

        return get().compareTo(other) < 0;
    }

    public T getMax(T other) {
        if (get() == null) {
            return other;
        }
        if (other == null) {
            return get();
        }

        return get().compareTo(other) > 0 ? get() : other;
    }
}

// Test
public class Main {
    public static void main(String[] args) {
        // Test Box<String>
        Box<String> stringBox = new Box<>();
        System.out.println("Empty? " + stringBox.isEmpty());  // true

        stringBox.set("Hello");
        System.out.println(stringBox.get());  // Hello
        System.out.println("Empty? " + stringBox.isEmpty());  // false

        stringBox.clear();
        System.out.println("Empty after clear? " + stringBox.isEmpty());  // true

        // Test ComparableBox<Integer>
        ComparableBox<Integer> intBox = new ComparableBox<>();
        intBox.set(10);

        System.out.println("\nInteger box:");
        System.out.println("10 > 5? " + intBox.isGreaterThan(5));   // true
        System.out.println("10 < 20? " + intBox.isLessThan(20));    // true
        System.out.println("Max(10, 15): " + intBox.getMax(15));    // 15

        // Test ComparableBox<String>
        ComparableBox<String> strBox = new ComparableBox<>();
        strBox.set("Banana");

        System.out.println("\nString box:");
        System.out.println("Banana > Apple? " + strBox.isGreaterThan("Apple"));  // true
        System.out.println("Banana < Cherry? " + strBox.isLessThan("Cherry"));   // true
    }
}
```

</details>

---

## CHALLENGE 9: Refactoring - Eliminar Code Smell (15 min)

**Objetivo:** Refactorizar código problemático aplicando patrones.

**Código original (tiene múltiples problemas):**
```java
public class OrderProcessor {
    public double processOrder(String type, double amount, String customer) {
        double finalAmount = amount;

        if (type.equals("PREMIUM")) {
            finalAmount = amount * 0.9;
            System.out.println("Premium discount applied");
        } else if (type.equals("REGULAR")) {
            finalAmount = amount * 0.95;
            System.out.println("Regular discount applied");
        } else if (type.equals("VIP")) {
            finalAmount = amount * 0.8;
            System.out.println("VIP discount applied");
        }

        if (customer.equals("gold")) {
            finalAmount -= 100;
        }

        System.out.println("Processing order for " + customer);
        return finalAmount;
    }
}
```

**Tareas:**
1. Identificar code smells
2. Aplicar Strategy para descuentos
3. Separar responsabilidades (SRP)
4. Mejorar nombres de variables
5. Agregar validaciones

**Criterios de éxito:**
- [ ] Usa Strategy pattern
- [ ] Valida entradas null/vacías
- [ ] Separa logging de lógica de negocio
- [ ] Código más mantenible y extensible

<details>
<summary>Ver solución</summary>

```java
// Strategy para descuentos por tipo de orden
interface OrderDiscountStrategy {
    double applyDiscount(double amount);
    String getDiscountDescription();
}

class PremiumDiscount implements OrderDiscountStrategy {
    @Override
    public double applyDiscount(double amount) {
        return amount * 0.9;  // 10% descuento
    }

    @Override
    public String getDiscountDescription() {
        return "Premium discount (10%)";
    }
}

class RegularDiscount implements OrderDiscountStrategy {
    @Override
    public double applyDiscount(double amount) {
        return amount * 0.95;  // 5% descuento
    }

    @Override
    public String getDiscountDescription() {
        return "Regular discount (5%)";
    }
}

class VIPDiscount implements OrderDiscountStrategy {
    @Override
    public double applyDiscount(double amount) {
        return amount * 0.8;  // 20% descuento
    }

    @Override
    public String getDiscountDescription() {
        return "VIP discount (20%)";
    }
}

// Enum para customer tiers
enum CustomerTier {
    GOLD(100),
    SILVER(50),
    BRONZE(0);

    private final double loyaltyDiscount;

    CustomerTier(double loyaltyDiscount) {
        this.loyaltyDiscount = loyaltyDiscount;
    }

    public double getLoyaltyDiscount() {
        return loyaltyDiscount;
    }
}

// Logger separado (SRP)
interface OrderLogger {
    void logDiscount(String description);
    void logProcessing(String customerName);
    void logFinalAmount(double amount);
}

class ConsoleOrderLogger implements OrderLogger {
    @Override
    public void logDiscount(String description) {
        System.out.println("Applied: " + description);
    }

    @Override
    public void logProcessing(String customerName) {
        System.out.println("Processing order for customer: " + customerName);
    }

    @Override
    public void logFinalAmount(double amount) {
        System.out.println("Final amount: $" + String.format("%.2f", amount));
    }
}

// Procesador refactorizado
class OrderProcessor {
    private OrderLogger logger;

    public OrderProcessor(OrderLogger logger) {
        this.logger = logger;
    }

    public double processOrder(
            OrderDiscountStrategy discountStrategy,
            double baseAmount,
            CustomerTier customerTier,
            String customerName) {

        // Validaciones
        if (discountStrategy == null) {
            throw new IllegalArgumentException("Discount strategy cannot be null");
        }
        if (baseAmount < 0) {
            throw new IllegalArgumentException("Amount cannot be negative");
        }
        if (customerTier == null) {
            throw new IllegalArgumentException("Customer tier cannot be null");
        }
        if (customerName == null || customerName.trim().isEmpty()) {
            throw new IllegalArgumentException("Customer name cannot be null or empty");
        }

        // Aplicar descuento de tipo de orden
        double amountAfterOrderDiscount = discountStrategy.applyDiscount(baseAmount);
        logger.logDiscount(discountStrategy.getDiscountDescription());

        // Aplicar descuento de lealtad
        double finalAmount = amountAfterOrderDiscount - customerTier.getLoyaltyDiscount();
        if (customerTier.getLoyaltyDiscount() > 0) {
            logger.logDiscount("Loyalty discount: $" + customerTier.getLoyaltyDiscount());
        }

        // Log procesamiento
        logger.logProcessing(customerName);
        logger.logFinalAmount(finalAmount);

        return finalAmount;
    }
}

// Test
public class Main {
    public static void main(String[] args) {
        OrderLogger logger = new ConsoleOrderLogger();
        OrderProcessor processor = new OrderProcessor(logger);

        System.out.println("=== Order 1: Premium, Gold Customer ===");
        double total1 = processor.processOrder(
            new PremiumDiscount(),
            1000,
            CustomerTier.GOLD,
            "Alice Johnson"
        );
        System.out.println("Total: $" + total1 + "\n");

        System.out.println("=== Order 2: VIP, Silver Customer ===");
        double total2 = processor.processOrder(
            new VIPDiscount(),
            2000,
            CustomerTier.SILVER,
            "Bob Smith"
        );
        System.out.println("Total: $" + total2 + "\n");

        System.out.println("=== Order 3: Regular, Bronze Customer ===");
        double total3 = processor.processOrder(
            new RegularDiscount(),
            500,
            CustomerTier.BRONZE,
            "Carol White"
        );
        System.out.println("Total: $" + total3);
    }
}
```

**Mejoras aplicadas:**
1. Strategy Pattern para descuentos de orden
2. Enum para customer tiers (más seguro que strings)
3. Interface para logging (SRP, testeable)
4. Validaciones robustas
5. Nombres descriptivos
6. Código extensible (fácil agregar nuevos descuentos)
7. Separación de concerns

</details>

---

## CHALLENGE 10: Testing - Pruebas Unitarias (15 min)

**Objetivo:** Escribir tests unitarios efectivos.

**Código a testear:**
```java
class Calculator {
    public double divide(double a, double b) {
        if (b == 0) {
            throw new ArithmeticException("Division by zero");
        }
        return a / b;
    }

    public List<Integer> getEvenNumbers(List<Integer> numbers) {
        if (numbers == null) {
            throw new IllegalArgumentException("Numbers cannot be null");
        }
        return numbers.stream()
            .filter(n -> n % 2 == 0)
            .collect(Collectors.toList());
    }
}
```

**Requerimientos:**
Escribe tests para:
1. divide() - caso normal
2. divide() - división por cero
3. getEvenNumbers() - lista con números pares e impares
4. getEvenNumbers() - lista vacía
5. getEvenNumbers() - lista null

**Criterios de éxito:**
- [ ] Tests cubren casos normales
- [ ] Tests cubren casos edge
- [ ] Tests verifican excepciones
- [ ] Usa assertions apropiadas

<details>
<summary>Ver solución (pseudo-JUnit)</summary>

```java
import java.util.*;
import java.util.stream.Collectors;

class Calculator {
    public double divide(double a, double b) {
        if (b == 0) {
            throw new ArithmeticException("Division by zero");
        }
        return a / b;
    }

    public List<Integer> getEvenNumbers(List<Integer> numbers) {
        if (numbers == null) {
            throw new IllegalArgumentException("Numbers cannot be null");
        }
        return numbers.stream()
            .filter(n -> n % 2 == 0)
            .collect(Collectors.toList());
    }
}

// Tests (pseudo-JUnit style)
class CalculatorTest {

    public void testDivide_NormalCase() {
        Calculator calc = new Calculator();
        double result = calc.divide(10, 2);

        assert result == 5.0 : "Expected 5.0, got " + result;
        System.out.println("✓ testDivide_NormalCase passed");
    }

    public void testDivide_ByZero() {
        Calculator calc = new Calculator();

        try {
            calc.divide(10, 0);
            assert false : "Should have thrown ArithmeticException";
        } catch (ArithmeticException e) {
            assert e.getMessage().equals("Division by zero");
            System.out.println("✓ testDivide_ByZero passed");
        }
    }

    public void testDivide_NegativeNumbers() {
        Calculator calc = new Calculator();
        double result = calc.divide(-10, 2);

        assert result == -5.0 : "Expected -5.0, got " + result;
        System.out.println("✓ testDivide_NegativeNumbers passed");
    }

    public void testGetEvenNumbers_MixedList() {
        Calculator calc = new Calculator();
        List<Integer> input = List.of(1, 2, 3, 4, 5, 6);
        List<Integer> expected = List.of(2, 4, 6);

        List<Integer> result = calc.getEvenNumbers(input);

        assert result.equals(expected) : "Expected " + expected + ", got " + result;
        System.out.println("✓ testGetEvenNumbers_MixedList passed");
    }

    public void testGetEvenNumbers_EmptyList() {
        Calculator calc = new Calculator();
        List<Integer> input = List.of();

        List<Integer> result = calc.getEvenNumbers(input);

        assert result.isEmpty() : "Expected empty list, got " + result;
        System.out.println("✓ testGetEvenNumbers_EmptyList passed");
    }

    public void testGetEvenNumbers_AllOdd() {
        Calculator calc = new Calculator();
        List<Integer> input = List.of(1, 3, 5, 7);

        List<Integer> result = calc.getEvenNumbers(input);

        assert result.isEmpty() : "Expected empty list, got " + result;
        System.out.println("✓ testGetEvenNumbers_AllOdd passed");
    }

    public void testGetEvenNumbers_AllEven() {
        Calculator calc = new Calculator();
        List<Integer> input = List.of(2, 4, 6, 8);
        List<Integer> expected = List.of(2, 4, 6, 8);

        List<Integer> result = calc.getEvenNumbers(input);

        assert result.equals(expected) : "Expected " + expected + ", got " + result;
        System.out.println("✓ testGetEvenNumbers_AllEven passed");
    }

    public void testGetEvenNumbers_NullList() {
        Calculator calc = new Calculator();

        try {
            calc.getEvenNumbers(null);
            assert false : "Should have thrown IllegalArgumentException";
        } catch (IllegalArgumentException e) {
            assert e.getMessage().equals("Numbers cannot be null");
            System.out.println("✓ testGetEvenNumbers_NullList passed");
        }
    }

    public void runAllTests() {
        System.out.println("Running Calculator tests...\n");

        testDivide_NormalCase();
        testDivide_ByZero();
        testDivide_NegativeNumbers();
        testGetEvenNumbers_MixedList();
        testGetEvenNumbers_EmptyList();
        testGetEvenNumbers_AllOdd();
        testGetEvenNumbers_AllEven();
        testGetEvenNumbers_NullList();

        System.out.println("\nAll tests passed!");
    }
}

// Main
public class Main {
    public static void main(String[] args) {
        CalculatorTest tests = new CalculatorTest();
        tests.runAllTests();
    }
}
```

**Principios de testing aplicados:**
1. Cada test prueba un solo escenario
2. Nombres descriptivos (qué se prueba + escenario esperado)
3. AAA pattern: Arrange, Act, Assert
4. Tests de casos normales y edge cases
5. Verificación de excepciones
6. Independencia entre tests

</details>

---

## RESUMEN DE MINI-CHALLENGES

| Challenge | Concepto | Tiempo | Dificultad |
|-----------|----------|--------|------------|
| 1 | Strategy Pattern | 10 min | Fácil |
| 2 | Visitor Pattern | 15 min | Media |
| 3 | Singleton | 10 min | Fácil |
| 4 | Factory | 12 min | Fácil |
| 5 | Collections & Streams | 12 min | Media |
| 6 | File I/O | 15 min | Media |
| 7 | Excepciones Personalizadas | 10 min | Fácil |
| 8 | Generics | 12 min | Media |
| 9 | Refactoring | 15 min | Alta |
| 10 | Testing | 15 min | Media |

**Total:** 126 minutos (~2 horas)

**Estrategia de uso:**
- Día 1: Challenges 1-3 (patrones básicos)
- Día 2: Challenges 4-6 (factory, collections, I/O)
- Día 3: Challenges 7-8 (excepciones, generics)
- Día 4: Challenges 9-10 (refactoring, testing)

**Tips:**
1. Intenta resolver sin ver la solución primero
2. Compila y ejecuta tu código
3. Si te atoras >5 min, mira pistas en la solución
4. Después de resolver, compara con la solución
5. Anota conceptos que te cuesten
