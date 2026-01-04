# DEBUGGING CHALLENGES - Encuentra y Corrige los Errores

**Objetivo:** Desarrollar la habilidad de detectar errores sutiles que se cometen frecuentemente en exámenes.

**Tiempo estimado:** 60-90 minutos total (10-15 min por challenge)

**Cuándo usarlo:**
- 3-4 días antes del examen
- Para afinar el "ojo clínico" de detección de errores
- Después de completar ejercicios, como validación

---

## CHALLENGE 1: Strategy Pattern - Errores de Implementación

**Instrucciones:** Este código tiene 5 errores. Encuéntralos y corrígelos.

```java
// Sistema de notificaciones con diferentes estrategias de envío

// Interface de estrategia
interface NotificationStrategy {
    void send(String message);
}

// Estrategia Email
class EmailNotification extends NotificationStrategy {
    @Override
    public void send(String message) {
        System.out.println("Sending email: " + message);
    }
}

// Estrategia SMS
class SMSNotification implements NotificationStrategy {
    @Override
    public void send(String message) {
        System.out.println("Sending SMS: " + message);
    }
}

// Contexto
class NotificationService {
    private NotificationStrategy strategy;

    public void setStrategy(NotificationStrategy strategy) {
        strategy = strategy;
    }

    public void notifyUser(String message) {
        strategy.send(message);
    }
}

// Uso
public class Main {
    public static void main(String[] args) {
        NotificationService service = new NotificationService();
        service.setStrategy(new EmailNotification());
        service.notifyUser("Hello!");
    }
}
```

**Errores a encontrar:**
1. ❌ Error en EmailNotification
2. ❌ Error en el setter de NotificationService
3. ❌ Error potencial en notifyUser
4. ❌ Error de diseño en la estrategia
5. ❌ Error en Main

---

## CHALLENGE 2: Visitor Pattern - Errores de Estructura

**Instrucciones:** Este código tiene 6 errores. Encuéntralos y corrígelos.

```java
// Sistema de procesamiento de documentos

interface Visitor {
    void visit(PDFDocument pdf);
    void visit(WordDocument word);
}

interface Document {
    void accept(Visitor visitor);
}

class PDFDocument implements Document {
    private String content;

    public PDFDocument(String content) {
        this.content = content;
    }

    @Override
    public void accept(Visitor visitor) {
        visitor.visit();
    }

    public String getContent() {
        return content;
    }
}

class WordDocument implements Document {
    private String content;

    public WordDocument(String content) {
        this.content = content;
    }

    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public String getContent() {
        return content;
    }
}

class PrintVisitor implements Visitor {
    @Override
    public void visit(PDFDocument pdf) {
        System.out.println("Printing PDF: " + pdf.content);
    }

    @Override
    public void visit(WordDocument word) {
        System.out.println("Printing Word: " + word.getContent());
    }
}

public class Main {
    public static void main(String[] args) {
        List<Document> documents = new ArrayList<>();
        documents.add(new PDFDocument("PDF content"));
        documents.add(new WordDocument("Word content"));

        PrintVisitor printer = new PrintVisitor();
        for (Document doc : documents) {
            printer.visit(doc);
        }
    }
}
```

**Errores a encontrar:**
1. ❌ Error en accept() de PDFDocument
2. ❌ Error de acceso en PrintVisitor para PDF
3. ❌ Error en el main
4. ❌ Falta imports
5. ❌ Error de arquitectura Visitor
6. ❌ Inconsistencia entre las dos clases Document

---

## CHALLENGE 3: Singleton Pattern - Errores de Thread-Safety

**Instrucciones:** Este código tiene 4 errores graves. Encuéntralos.

```java
public class DatabaseConnection {
    private static DatabaseConnection instance;
    private String connectionString;

    public DatabaseConnection() {
        this.connectionString = "jdbc:mysql://localhost:3306/mydb";
    }

    public static DatabaseConnection getInstance() {
        if (instance = null) {
            instance = new DatabaseConnection();
        }
        return instance;
    }

    public void connect() {
        System.out.println("Connecting to: " + connectionString);
    }

    public static void main(String[] args) {
        DatabaseConnection db1 = new DatabaseConnection();
        DatabaseConnection db2 = DatabaseConnection.getInstance();

        db1.connect();
        db2.connect();

        System.out.println("Same instance? " + (db1 == db2));
    }
}
```

**Errores a encontrar:**
1. ❌ Error crítico en constructor
2. ❌ Error de sintaxis en getInstance()
3. ❌ Error de uso en main
4. ❌ Falta protección thread-safe

---

## CHALLENGE 4: File I/O - Errores de Manejo de Recursos

**Instrucciones:** Este código tiene 5 errores. Encuéntralos y corrígelos.

```java
import java.io.*;
import java.util.*;

public class StudentDataProcessor {

    public List<String> readStudents(String filename) {
        List<String> students = new ArrayList<>();
        BufferedReader reader = new BufferedReader(new FileReader(filename));

        String line;
        while ((line = reader.readLine()) != null) {
            students.add(line);
        }

        reader.close();
        return students;
    }

    public void writeStudents(String filename, List<String> students) {
        BufferedWriter writer = new BufferedWriter(new FileWriter(filename));

        for (String student : students) {
            writer.write(student);
        }

        writer.close();
    }

    public static void main(String[] args) {
        StudentDataProcessor processor = new StudentDataProcessor();

        List<String> students = processor.readStudents("students.txt");
        students.add("New Student");
        processor.writeStudents("students_updated.txt", students);

        System.out.println("Processing complete!");
    }
}
```

**Errores a encontrar:**
1. ❌ Falta manejo de excepciones
2. ❌ No usa try-with-resources
3. ❌ Error en writeStudents (falta newline)
4. ❌ Posible problema si archivo no existe
5. ❌ Falta especificar encoding

---

## CHALLENGE 5: Factory Pattern - Errores de Diseño

**Instrucciones:** Este código tiene 5 errores. Encuéntralos y corrígelos.

```java
// Sistema de creación de vehículos

class Vehicle {
    protected String type;

    public void display() {
        System.out.println("Vehicle type: " + type);
    }
}

class Car extends Vehicle {
    public Car() {
        type = "Car";
    }
}

class Motorcycle extends Vehicle {
    public Motorcycle() {
        type = "Motorcycle";
    }
}

class VehicleFactory {
    public Vehicle createVehicle(String type) {
        if (type == "car") {
            return new Car();
        } else if (type == "motorcycle") {
            return new Motorcycle();
        }
        return null;
    }
}

public class Main {
    public static void main(String[] args) {
        VehicleFactory factory = new VehicleFactory();

        Vehicle v1 = factory.createVehicle("car");
        Vehicle v2 = factory.createVehicle("motorcycle");
        Vehicle v3 = factory.createVehicle("truck");

        v1.display();
        v2.display();
        v3.display();
    }
}
```

**Errores a encontrar:**
1. ❌ Error con comparación de Strings
2. ❌ Factory retorna null (mal diseño)
3. ❌ No valida entrada
4. ❌ Error en main (v3 es null)
5. ❌ Falta case para tipo desconocido

---

## CHALLENGE 6: Collections y Generics - Errores Comunes

**Instrucciones:** Este código tiene 6 errores. Encuéntralos y corrígelos.

```java
import java.util.*;

public class StudentManager {
    private List students;
    private Map<String, Integer> grades;

    public StudentManager() {
        students = new ArrayList();
        grades = new HashMap();
    }

    public void addStudent(String name) {
        students.add(name);
    }

    public void addGrade(String name, int grade) {
        grades.put(name, grade);
    }

    public void printTopStudent() {
        String topStudent = "";
        int maxGrade = 0;

        for (String name : grades.keySet()) {
            if (grades.get(name) > maxGrade) {
                maxGrade = grades.get(name);
                topStudent = name;
            }
        }

        System.out.println("Top student: " + topStudent);
    }

    public List getStudentsAbove(int threshold) {
        List result = new ArrayList();

        for (int i = 0; i < students.size(); i++) {
            String student = students.get(i);
            if (grades.get(student) > threshold) {
                result.add(student);
            }
        }

        return result;
    }
}
```

**Errores a encontrar:**
1. ❌ Falta especificar tipos genéricos
2. ❌ Warning de raw types
3. ❌ Problema en printTopStudent si grades está vacío
4. ❌ Error de casting necesario
5. ❌ Posible NullPointerException en getStudentsAbove
6. ❌ Uso ineficiente de collections

---

## SOLUCIONES

<details>
<summary>CHALLENGE 1 - SOLUCIONES</summary>

### Errores encontrados:

1. **EmailNotification usa `extends` en lugar de `implements`**
   ```java
   // ❌ Incorrecto
   class EmailNotification extends NotificationStrategy

   // ✅ Correcto
   class EmailNotification implements NotificationStrategy
   ```

2. **Setter asigna el parámetro a sí mismo**
   ```java
   // ❌ Incorrecto
   public void setStrategy(NotificationStrategy strategy) {
       strategy = strategy;  // Esto asigna el parámetro a sí mismo
   }

   // ✅ Correcto
   public void setStrategy(NotificationStrategy strategy) {
       this.strategy = strategy;  // Asigna al campo de instancia
   }
   ```

3. **No valida null en notifyUser**
   ```java
   // ❌ Incorrecto
   public void notifyUser(String message) {
       strategy.send(message);  // NullPointerException si strategy es null
   }

   // ✅ Correcto
   public void notifyUser(String message) {
       if (strategy == null) {
           throw new IllegalStateException("Strategy not set");
       }
       strategy.send(message);
   }
   ```

4. **Falta validación de message null**
   ```java
   // ✅ Mejor
   public void notifyUser(String message) {
       if (strategy == null) {
           throw new IllegalStateException("Strategy not set");
       }
       if (message == null || message.isEmpty()) {
           throw new IllegalArgumentException("Message cannot be null or empty");
       }
       strategy.send(message);
   }
   ```

5. **No inicializa la estrategia (el servicio se crea sin estrategia)**
   ```java
   // ✅ Mejor práctica: inicializar con estrategia o validar siempre
   class NotificationService {
       private NotificationStrategy strategy;

       public NotificationService(NotificationStrategy strategy) {
           if (strategy == null) {
               throw new IllegalArgumentException("Strategy cannot be null");
           }
           this.strategy = strategy;
       }
   }
   ```

</details>

<details>
<summary>CHALLENGE 2 - SOLUCIONES</summary>

### Errores encontrados:

1. **accept() de PDFDocument no pasa `this`**
   ```java
   // ❌ Incorrecto
   public void accept(Visitor visitor) {
       visitor.visit();  // Falta el parámetro
   }

   // ✅ Correcto
   public void accept(Visitor visitor) {
       visitor.visit(this);
   }
   ```

2. **PrintVisitor accede directamente al campo privado `content`**
   ```java
   // ❌ Incorrecto
   System.out.println("Printing PDF: " + pdf.content);

   // ✅ Correcto
   System.out.println("Printing PDF: " + pdf.getContent());
   ```

3. **Main llama a visit() en lugar de accept()**
   ```java
   // ❌ Incorrecto
   printer.visit(doc);  // Rompe el patrón Visitor

   // ✅ Correcto
   doc.accept(printer);  // El documento acepta al visitor
   ```

4. **Faltan imports**
   ```java
   // ✅ Agregar
   import java.util.List;
   import java.util.ArrayList;
   ```

5. **La arquitectura no permite polimorfismo correcto en visit()**
   - El problema es que `printer.visit(doc)` no funciona porque `doc` es de tipo `Document`
   - El Visitor necesita que el documento llame a `accept()` para hacer double dispatch

6. **Inconsistencia: PDFDocument no llamaba a visit(this)**
   - Ya corregido en el punto 1

</details>

<details>
<summary>CHALLENGE 3 - SOLUCIONES</summary>

### Errores encontrados:

1. **Constructor es público (rompe Singleton)**
   ```java
   // ❌ Incorrecto
   public DatabaseConnection()

   // ✅ Correcto
   private DatabaseConnection()
   ```

2. **Usa `=` en lugar de `==` en la comparación**
   ```java
   // ❌ Incorrecto
   if (instance = null)  // Esto asigna, no compara

   // ✅ Correcto
   if (instance == null)
   ```

3. **Main crea instancia con `new` (rompe Singleton)**
   ```java
   // ❌ Incorrecto
   DatabaseConnection db1 = new DatabaseConnection();

   // ✅ Correcto
   DatabaseConnection db1 = DatabaseConnection.getInstance();
   ```

4. **No es thread-safe**
   ```java
   // ✅ Correcto (opción 1 - eager initialization)
   private static final DatabaseConnection instance = new DatabaseConnection();

   public static DatabaseConnection getInstance() {
       return instance;
   }

   // ✅ Correcto (opción 2 - synchronized)
   public static synchronized DatabaseConnection getInstance() {
       if (instance == null) {
           instance = new DatabaseConnection();
       }
       return instance;
   }

   // ✅ Correcto (opción 3 - double-checked locking)
   private static volatile DatabaseConnection instance;

   public static DatabaseConnection getInstance() {
       if (instance == null) {
           synchronized (DatabaseConnection.class) {
               if (instance == null) {
                   instance = new DatabaseConnection();
               }
           }
       }
       return instance;
   }
   ```

</details>

<details>
<summary>CHALLENGE 4 - SOLUCIONES</summary>

### Errores encontrados:

1. **No usa try-with-resources**
   ```java
   // ❌ Incorrecto
   BufferedReader reader = new BufferedReader(new FileReader(filename));
   // ...
   reader.close();

   // ✅ Correcto
   try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
       // ...
   }
   ```

2. **No maneja excepciones**
   ```java
   // ✅ Correcto
   public List<String> readStudents(String filename) throws IOException {
       // O usar try-catch interno
   }
   ```

3. **writeStudents no agrega newlines**
   ```java
   // ❌ Incorrecto
   writer.write(student);

   // ✅ Correcto
   writer.write(student);
   writer.newLine();
   ```

4. **No especifica encoding**
   ```java
   // ✅ Correcto
   new BufferedReader(new FileReader(filename, StandardCharsets.UTF_8))
   new BufferedWriter(new FileWriter(filename, StandardCharsets.UTF_8))
   ```

5. **main no maneja excepciones**
   ```java
   // ✅ Correcto
   public static void main(String[] args) {
       try {
           StudentDataProcessor processor = new StudentDataProcessor();
           // ...
       } catch (IOException e) {
           System.err.println("Error: " + e.getMessage());
           e.printStackTrace();
       }
   }
   ```

**Código completo corregido:**
```java
import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.*;

public class StudentDataProcessor {

    public List<String> readStudents(String filename) throws IOException {
        List<String> students = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(
                new FileReader(filename, StandardCharsets.UTF_8))) {

            String line;
            while ((line = reader.readLine()) != null) {
                students.add(line);
            }
        }

        return students;
    }

    public void writeStudents(String filename, List<String> students) throws IOException {
        try (BufferedWriter writer = new BufferedWriter(
                new FileWriter(filename, StandardCharsets.UTF_8))) {

            for (String student : students) {
                writer.write(student);
                writer.newLine();
            }
        }
    }

    public static void main(String[] args) {
        StudentDataProcessor processor = new StudentDataProcessor();

        try {
            List<String> students = processor.readStudents("students.txt");
            students.add("New Student");
            processor.writeStudents("students_updated.txt", students);

            System.out.println("Processing complete!");
        } catch (IOException e) {
            System.err.println("Error processing files: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
```

</details>

<details>
<summary>CHALLENGE 5 - SOLUCIONES</summary>

### Errores encontrados:

1. **Compara Strings con `==` en lugar de `equals()`**
   ```java
   // ❌ Incorrecto
   if (type == "car")

   // ✅ Correcto
   if (type.equals("car"))
   // O mejor aún
   if ("car".equals(type))  // Evita NullPointerException
   ```

2. **Factory retorna null (mal diseño)**
   ```java
   // ❌ Incorrecto
   return null;

   // ✅ Correcto - lanzar excepción
   throw new IllegalArgumentException("Unknown vehicle type: " + type);
   ```

3. **No valida entrada null**
   ```java
   // ✅ Correcto
   public Vehicle createVehicle(String type) {
       if (type == null || type.isEmpty()) {
           throw new IllegalArgumentException("Type cannot be null or empty");
       }
       // ...
   }
   ```

4. **Main intenta usar v3 que sería null**
   ```java
   // ❌ Incorrecto
   v3.display();  // NullPointerException

   // ✅ Con el cambio de lanzar excepción, esto se resuelve
   ```

5. **Mejor usar enum o constantes**
   ```java
   // ✅ Mejor diseño
   public enum VehicleType {
       CAR, MOTORCYCLE, TRUCK
   }

   public Vehicle createVehicle(VehicleType type) {
       switch (type) {
           case CAR:
               return new Car();
           case MOTORCYCLE:
               return new Motorcycle();
           case TRUCK:
               return new Truck();
           default:
               throw new IllegalArgumentException("Unknown type: " + type);
       }
   }
   ```

</details>

<details>
<summary>CHALLENGE 6 - SOLUCIONES</summary>

### Errores encontrados:

1. **No especifica tipos genéricos (raw types)**
   ```java
   // ❌ Incorrecto
   private List students;
   private Map grades;

   // ✅ Correcto
   private List<String> students;
   private Map<String, Integer> grades;
   ```

2. **Constructor usa raw types**
   ```java
   // ❌ Incorrecto
   students = new ArrayList();

   // ✅ Correcto
   students = new ArrayList<>();
   ```

3. **printTopStudent falla si grades está vacío**
   ```java
   // ✅ Correcto
   public void printTopStudent() {
       if (grades.isEmpty()) {
           System.out.println("No grades available");
           return;
       }

       String topStudent = "";
       int maxGrade = Integer.MIN_VALUE;  // Cambiar a MIN_VALUE

       for (Map.Entry<String, Integer> entry : grades.entrySet()) {
           if (entry.getValue() > maxGrade) {
               maxGrade = entry.getValue();
               topStudent = entry.getKey();
           }
       }

       System.out.println("Top student: " + topStudent + " with grade: " + maxGrade);
   }
   ```

4. **getStudentsAbove necesita casting con raw types**
   ```java
   // Con genéricos no necesita casting
   ```

5. **Posible NullPointerException en getStudentsAbove**
   ```java
   // ✅ Correcto
   public List<String> getStudentsAbove(int threshold) {
       List<String> result = new ArrayList<>();

       for (String student : students) {
           Integer grade = grades.get(student);
           if (grade != null && grade > threshold) {
               result.add(student);
           }
       }

       return result;
   }
   ```

6. **Uso ineficiente - mejor usar entrySet()**
   ```java
   // ✅ Mejor
   public List<String> getStudentsAbove(int threshold) {
       List<String> result = new ArrayList<>();

       for (Map.Entry<String, Integer> entry : grades.entrySet()) {
           if (entry.getValue() > threshold) {
               result.add(entry.getKey());
           }
       }

       return result;
   }
   ```

</details>

---

## CHECKLIST DE VERIFICACIÓN

Después de completar cada challenge, verifica:

- [ ] ¿Compilaría el código?
- [ ] ¿Hay warnings del compilador?
- [ ] ¿Hay posibles NullPointerExceptions?
- [ ] ¿Se manejan correctamente las excepciones?
- [ ] ¿Se usan los tipos genéricos correctamente?
- [ ] ¿Se siguen las buenas prácticas del patrón?
- [ ] ¿El código es thread-safe si es necesario?
- [ ] ¿Se liberan correctamente los recursos?

---

## NOTAS IMPORTANTES

**Errores más comunes en exámenes:**
1. Usar `=` en lugar de `==` en comparaciones
2. Comparar Strings con `==` en lugar de `equals()`
3. Olvidar `this.` en setters
4. Constructores públicos en Singleton
5. No usar try-with-resources para File I/O
6. Raw types en Collections
7. No validar null
8. Romper el patrón Visitor llamando visit() directamente

**Consejos:**
- Lee el código línea por línea
- Piensa: "¿Qué pasaría si...?"
- Verifica siempre casos edge (null, vacío, etc.)
- Compila mentalmente el código
