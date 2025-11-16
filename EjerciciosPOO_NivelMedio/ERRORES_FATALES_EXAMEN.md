# ERRORES FATALES EN EXAMEN - Qué NO Hacer

**Objetivo:** Identificar y evitar los errores que cuestan la mayoría de los puntos en exámenes.

**Tiempo estimado:** 15-20 minutos de lectura

**Cuándo usarlo:**
- 1 hora antes del examen (lectura final)
- Después de hacer ejercicios (para evitar repetir errores)
- Como referencia rápida durante práctica

**Formato:** Cada error incluye:
- Por qué es fatal
- Ejemplo incorrecto
- Solución correcta
- Cómo detectarlo

---

## CATEGORÍA 1: ERRORES DE SINTAXIS SILENCIOSOS

### ERROR FATAL #1: Usar `=` en lugar de `==` en condiciones

**Por qué es fatal:** Compila sin error pero asigna en lugar de comparar.

**Incorrecto:**
```java
if (instance = null) {  // ❌ ASIGNA null, no compara
    instance = new Singleton();
}
```

**Correcto:**
```java
if (instance == null) {  // ✅ Compara
    instance = new Singleton();
}
```

**Consecuencia:** El código siempre entra al if (o nunca, dependiendo del valor asignado).

**Cómo detectarlo:**
- Busca `if (variable = valor)`
- Compilador puede dar warning: "The assignment to variable has no effect"
- Revisa TODOS los if antes de entregar

---

### ERROR FATAL #2: Comparar Strings con `==` en lugar de `equals()`

**Por qué es fatal:** Compara referencias, no contenido. Puede funcionar a veces (String pool) pero fallará en casos reales.

**Incorrecto:**
```java
if (type == "car") {  // ❌ Compara referencias
    return new Car();
}
```

**Correcto:**
```java
if ("car".equals(type)) {  // ✅ Compara contenido + evita NullPointer
    return new Car();
}

// O si confías que type no es null:
if (type.equals("car")) {  // ✅ También correcto
    return new Car();
}
```

**Consecuencia:** La condición puede ser falsa incluso cuando los strings son "iguales" visualmente.

**Cómo detectarlo:**
- Busca `if (stringVar == "valor")`
- Busca `if (stringVar == otraStringVar)`
- SIEMPRE usar `.equals()` para Strings

**Regla de oro:** `==` para primitivos y referencias, `.equals()` para objetos.

---

### ERROR FATAL #3: Olvidar `this.` en setters

**Por qué es fatal:** Asigna el parámetro a sí mismo, no al campo.

**Incorrecto:**
```java
public void setStrategy(Strategy strategy) {
    strategy = strategy;  // ❌ Asigna parámetro a sí mismo
}
```

**Correcto:**
```java
public void setStrategy(Strategy strategy) {
    this.strategy = strategy;  // ✅ Asigna al campo de instancia
}
```

**Consecuencia:** El campo de instancia nunca se actualiza. Quedará null o con valor anterior.

**Cómo detectarlo:**
- Busca setters donde parámetro y campo tienen mismo nombre
- IDE puede dar warning: "Assignment to itself"
- Compila tu código y piensa: "¿Esto realmente cambia el estado?"

---

## CATEGORÍA 2: ERRORES DE PATRONES

### ERROR FATAL #4: Singleton con constructor público

**Por qué es fatal:** Rompe completamente el patrón Singleton.

**Incorrecto:**
```java
public class Singleton {
    private static Singleton instance;

    public Singleton() { }  // ❌ Cualquiera puede crear instancias

    public static Singleton getInstance() {
        if (instance == null) {
            instance = new Singleton();
        }
        return instance;
    }
}

// Cliente puede hacer:
Singleton s1 = new Singleton();  // Segunda instancia!
```

**Correcto:**
```java
public class Singleton {
    private static final Singleton INSTANCE = new Singleton();

    private Singleton() { }  // ✅ Privado

    public static Singleton getInstance() {
        return INSTANCE;
    }
}
```

**Consecuencia:** Múltiples instancias pueden existir, violando la garantía de Singleton.

**Cómo detectarlo:**
- Busca `public class Singleton`
- Verifica que constructor sea `private`
- Pregunta: "¿Alguien puede hacer `new Singleton()`?"

---

### ERROR FATAL #5: Visitor sin pasar `this` en accept()

**Por qué es fatal:** Rompe el double dispatch del patrón Visitor.

**Incorrecto:**
```java
class PDFDocument implements Document {
    @Override
    public void accept(Visitor visitor) {
        visitor.visit();  // ❌ No pasa referencia al documento
    }
}
```

**Correcto:**
```java
class PDFDocument implements Document {
    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);  // ✅ Pasa referencia a sí mismo
    }
}
```

**Consecuencia:** El visitor no puede procesar el elemento específico. Error de compilación o comportamiento incorrecto.

**Cómo detectarlo:**
- Busca `accept()` methods
- Verifica que llamen `visitor.visit(this)`, NO `visitor.visit()`
- El parámetro de visit() debe ser el tipo concreto: `visit(PDFDocument pdf)`

---

### ERROR FATAL #6: Strategy con `extends` en lugar de `implements`

**Por qué es fatal:** Las estrategias deben implementar una interface, no extender otra clase.

**Incorrecto:**
```java
class StudentDiscount extends DiscountStrategy {  // ❌ extends
    @Override
    public double applyDiscount(double price) {
        return price * 0.9;
    }
}
```

**Correcto:**
```java
// DiscountStrategy debe ser interface
interface DiscountStrategy {
    double applyDiscount(double price);
}

class StudentDiscount implements DiscountStrategy {  // ✅ implements
    @Override
    public double applyDiscount(double price) {
        return price * 0.9;
    }
}
```

**Consecuencia:** Si DiscountStrategy es interface, error de compilación. Si es clase, limita flexibilidad.

**Cómo detectarlo:**
- Strategy pattern siempre usa interface (o abstract class en casos especiales)
- Verifica: `interface Strategy`, no `class Strategy`
- Implementaciones: `class Concrete implements Strategy`

---

## CATEGORÍA 3: ERRORES DE FILE I/O

### ERROR FATAL #7: No usar try-with-resources

**Por qué es fatal:** Recursos no se cierran correctamente, puede causar memory leaks.

**Incorrecto:**
```java
public List<String> readFile(String filename) throws IOException {
    BufferedReader reader = new BufferedReader(new FileReader(filename));
    List<String> lines = new ArrayList<>();

    String line;
    while ((line = reader.readLine()) != null) {
        lines.add(line);
    }

    reader.close();  // ❌ No se ejecuta si hay excepción antes
    return lines;
}
```

**Correcto:**
```java
public List<String> readFile(String filename) throws IOException {
    List<String> lines = new ArrayList<>();

    try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
        String line;
        while ((line = reader.readLine()) != null) {
            lines.add(line);
        }
    }  // ✅ reader se cierra automáticamente

    return lines;
}
```

**Consecuencia:** En examen puede no ser evidente, pero es mala práctica que cuesta puntos.

**Cómo detectarlo:**
- Busca `new BufferedReader`, `new BufferedWriter`
- Verifica que estén dentro de `try ( ... )`
- NUNCA uses `reader.close()` manual, usa try-with-resources

---

### ERROR FATAL #8: Olvidar `newLine()` al escribir archivos

**Por qué es fatal:** Todas las líneas se escriben en una sola línea.

**Incorrecto:**
```java
try (BufferedWriter writer = new BufferedWriter(new FileWriter(filename))) {
    for (String line : lines) {
        writer.write(line);  // ❌ No agrega salto de línea
    }
}

// Resultado en archivo:
// Line1Line2Line3
```

**Correcto:**
```java
try (BufferedWriter writer = new BufferedWriter(new FileWriter(filename))) {
    for (String line : lines) {
        writer.write(line);
        writer.newLine();  // ✅ Agrega salto de línea
    }
}

// Resultado en archivo:
// Line1
// Line2
// Line3
```

**Consecuencia:** Archivo ilegible, datos corruptos.

**Cómo detectarlo:**
- Busca `writer.write(`
- Verifica que le siga `writer.newLine()`
- O usa `writer.write(line + System.lineSeparator())`

---

### ERROR FATAL #9: No especificar charset

**Por qué es fatal:** Puede causar problemas con caracteres especiales (acentos, ñ, etc.).

**Incorrecto:**
```java
new BufferedReader(new FileReader(filename))  // ❌ Usa charset del sistema
```

**Correcto:**
```java
import java.nio.charset.StandardCharsets;

new BufferedReader(new FileReader(filename, StandardCharsets.UTF_8))  // ✅ Explícito
```

**Consecuencia:** En examen local puede funcionar, pero es mala práctica.

**Cómo detectarlo:**
- Busca `new FileReader(`
- Verifica segundo parámetro: `StandardCharsets.UTF_8`
- Importa: `java.nio.charset.StandardCharsets`

---

## CATEGORÍA 4: ERRORES DE COLLECTIONS

### ERROR FATAL #10: Usar raw types (sin generics)

**Por qué es fatal:** Pierde type safety, puede causar ClassCastException.

**Incorrecto:**
```java
List students = new ArrayList();  // ❌ Raw type
students.add("Alice");
students.add(123);  // Compila pero es error lógico

String name = (String) students.get(0);  // ❌ Casting necesario
```

**Correcto:**
```java
List<String> students = new ArrayList<>();  // ✅ Con generics
students.add("Alice");
// students.add(123);  // ❌ Error de compilación - ¡bien!

String name = students.get(0);  // ✅ No necesita casting
```

**Consecuencia:** Warnings del compilador, posibles ClassCastException en runtime.

**Cómo detectarlo:**
- Busca `List `, `Map `, `Set ` (sin `<>`)
- SIEMPRE especifica tipo: `List<String>`, `Map<String, Integer>`
- Usa diamond operator: `new ArrayList<>()`

---

### ERROR FATAL #11: No validar null en Collections

**Por qué es fatal:** NullPointerException al iterar o procesar.

**Incorrecto:**
```java
public List<Student> getTopStudents(List<Student> students, int n) {
    return students.stream()  // ❌ Si students es null → NullPointerException
        .sorted(Comparator.comparingDouble(Student::getGrade).reversed())
        .limit(n)
        .collect(Collectors.toList());
}
```

**Correcto:**
```java
public List<Student> getTopStudents(List<Student> students, int n) {
    if (students == null) {
        throw new IllegalArgumentException("Students list cannot be null");
    }
    if (n < 0) {
        throw new IllegalArgumentException("n cannot be negative");
    }

    return students.stream()
        .sorted(Comparator.comparingDouble(Student::getGrade).reversed())
        .limit(n)
        .collect(Collectors.toList());
}
```

**Consecuencia:** Crash en runtime.

**Cómo detectarlo:**
- SIEMPRE valida parámetros al inicio del método
- Especialmente: Collections, Strings, objetos críticos
- Lanza `IllegalArgumentException` para parámetros inválidos

---

## CATEGORÍA 5: ERRORES DE VALIDACIÓN

### ERROR FATAL #12: Factory que retorna null

**Por qué es fatal:** El cliente debe validar null siempre, propenso a NullPointerException.

**Incorrecto:**
```java
public static Vehicle createVehicle(String type) {
    if (type.equals("car")) {
        return new Car();
    } else if (type.equals("truck")) {
        return new Truck();
    }
    return null;  // ❌ Tipo desconocido retorna null
}

// Cliente
Vehicle v = VehicleFactory.createVehicle("motorcycle");
v.start();  // NullPointerException!
```

**Correcto:**
```java
public static Vehicle createVehicle(String type) {
    if (type == null || type.isEmpty()) {
        throw new IllegalArgumentException("Type cannot be null or empty");
    }

    switch (type.toLowerCase()) {
        case "car":
            return new Car();
        case "truck":
            return new Truck();
        default:
            throw new IllegalArgumentException("Unknown vehicle type: " + type);
    }
}
```

**Consecuencia:** NullPointerException silencioso, difícil de debuggear.

**Cómo detectarlo:**
- Busca `return null` en factories
- NUNCA retornes null, lanza excepción
- Valida entrada antes de procesar

---

### ERROR FATAL #13: No validar parámetros en constructores

**Por qué es fatal:** Objeto se crea en estado inválido.

**Incorrecto:**
```java
public class Student {
    private String name;
    private int age;

    public Student(String name, int age) {
        this.name = name;  // ❌ No valida null
        this.age = age;    // ❌ No valida negativo
    }
}

// Uso
Student s = new Student(null, -5);  // Objeto en estado inválido
```

**Correcto:**
```java
public class Student {
    private String name;
    private int age;

    public Student(String name, int age) {
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("Name cannot be null or empty");
        }
        if (age < 0) {
            throw new IllegalArgumentException("Age cannot be negative");
        }

        this.name = name;
        this.age = age;
    }
}
```

**Consecuencia:** Objeto con datos inválidos, bugs difíciles de rastrear.

**Cómo detectarlo:**
- SIEMPRE valida en constructor
- Falla rápido (fail-fast): lanza excepción inmediatamente
- No permitas crear objetos en estado inválido

---

## CATEGORÍA 6: ERRORES CONCEPTUALES

### ERROR FATAL #14: Confundir `extends` e `implements`

**Por qué es fatal:** Error de compilación o diseño incorrecto.

**Incorrecto:**
```java
interface Animal { }
class Dog extends Animal { }  // ❌ Interface se implementa, no se extiende

class Vehicle { }
class Car implements Vehicle { }  // ❌ Clase se extiende, no se implementa
```

**Correcto:**
```java
interface Animal { }
class Dog implements Animal { }  // ✅ Interface → implements

class Vehicle { }
class Car extends Vehicle { }  // ✅ Clase → extends

// Puedes hacer ambos:
class ElectricCar extends Car implements Rechargeable { }  // ✅ OK
```

**Regla:**
- Interface → `implements`
- Class → `extends`
- Puedes: extends 1 clase + implements N interfaces

**Cómo detectarlo:**
- Verifica definiciones de interfaces y clases
- Recuerda: Java no permite herencia múltiple de clases

---

### ERROR FATAL #15: Olvidar `@Override`

**Por qué es fatal:** Puedes crear método nuevo en lugar de sobrescribir, error silencioso.

**Incorrecto:**
```java
class Dog implements Animal {
    // Typo en nombre del método
    public void makesound() {  // ❌ Falta 'S' mayúscula, no sobrescribe
        System.out.println("Woof");
    }
}
```

**Correcto:**
```java
class Dog implements Animal {
    @Override  // ✅ Compilador verifica que realmente sobrescribe
    public void makeSound() {
        System.out.println("Woof");
    }
}
```

**Consecuencia:** Método de interface no implementado, error de compilación o comportamiento incorrecto.

**Cómo detectarlo:**
- SIEMPRE usa `@Override` al implementar o sobrescribir
- Compilador te avisará si hay error en nombre/parámetros

---

## ERRORES RÁPIDOS - LISTA DE VERIFICACIÓN

**Antes de entregar, busca estos patrones:**

1. `if (variable = valor)` → Cambiar a `==`
2. `if (string == "valor")` → Cambiar a `.equals()`
3. `field = field` en setter → Cambiar a `this.field = field`
4. `public Singleton()` → Cambiar a `private`
5. `visitor.visit()` → Cambiar a `visitor.visit(this)`
6. `extends Interface` → Cambiar a `implements`
7. `BufferedReader` sin try-with-resources → Rodear con `try ( )`
8. `writer.write()` sin `newLine()` → Agregar `newLine()`
9. `List students` → Cambiar a `List<Student> students`
10. `return null` en factory → Cambiar a `throw new IllegalArgumentException`

---

## METODOLOGÍA DE REVISIÓN (3 minutos)

**Paso 1 (1 min):** Buscar visualmente
- `==` cerca de Strings
- `=` en condiciones if
- `new` sin try-with-resources (para archivos)

**Paso 2 (1 min):** Verificar patrones
- Singleton: constructor privado
- Visitor: accept pasa this
- Strategy: usa implements

**Paso 3 (1 min):** Compilación mental
- Cada if: ¿realmente compara?
- Cada setter: ¿realmente asigna al campo?
- Cada archivo: ¿se cierra correctamente?

---

## CONSEJOS FINALES

**Durante el examen:**
- Lee el código que escribes en VOZ ALTA (mentalmente)
- Pregunta en cada línea: "¿Esto hace lo que creo?"
- Si tienes duda, valida (null, negativo, vacío)
- Cuando en duda: lanza excepción, no retornes null

**Reglas de oro:**
1. Strings → `.equals()`, NUNCA `==`
2. Archivos → try-with-resources, SIEMPRE
3. Collections → generics, SIEMPRE
4. Parámetros → validar, SIEMPRE
5. Singleton → constructor privado, SIEMPRE
6. Visitor → accept pasa `this`, SIEMPRE

**Si encuentras uno de estos errores en examen:**
Felicidades, acabas de salvar puntos valiosos. Los errores pequeños cuestan caro.

**Confianza + Cuidado = Excelencia**
