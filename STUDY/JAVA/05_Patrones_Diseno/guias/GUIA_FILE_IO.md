# GUÍA COMPLETA: FILE I/O EN JAVA

**Objetivo:** Dominar lectura y escritura de archivos en Java.

**Tiempo de estudio:** 30-40 minutos

---

## CONCEPTOS FUNDAMENTALES

### ¿Por qué File I/O?
- Guardar datos persistentes
- Cargar configuraciones
- Procesar archivos de entrada
- Generar reportes
- Exportar/importar datos

### Clases principales
- **FileReader / FileWriter:** Lectura/escritura de caracteres
- **BufferedReader / BufferedWriter:** Buffering para mejor performance
- **Files (Java 7+):** Utilidades modernas para archivos

---

## LECTURA DE ARCHIVOS

### Patrón básico con try-with-resources

```java
import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.*;

public List<String> readLines(String filename) throws IOException {
    List<String> lines = new ArrayList<>();

    try (BufferedReader reader = new BufferedReader(
            new FileReader(filename, StandardCharsets.UTF_8))) {

        String line;
        while ((line = reader.readLine()) != null) {
            lines.add(line);
        }
    }  // reader se cierra automáticamente

    return lines;
}
```

**Elementos clave:**
1. `try (...)` - try-with-resources
2. `BufferedReader` - lectura eficiente
3. `FileReader` - lee archivo de caracteres
4. `StandardCharsets.UTF_8` - encoding explícito
5. `readLine()` - lee línea por línea
6. Retorna `null` cuando llega al final

---

### Ejemplo completo: Lector de archivo de estudiantes

```java
import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.*;

class Student {
    private String name;
    private double grade;

    public Student(String name, double grade) {
        this.name = name;
        this.grade = grade;
    }

    public String getName() { return name; }
    public double getGrade() { return grade; }

    @Override
    public String toString() {
        return String.format("%s: %.2f", name, grade);
    }
}

class StudentFileReader {

    public List<Student> readStudents(String filename) throws IOException {
        List<Student> students = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(
                new FileReader(filename, StandardCharsets.UTF_8))) {

            String line;
            while ((line = reader.readLine()) != null) {
                // Ignora líneas vacías y comentarios
                if (line.trim().isEmpty() || line.startsWith("#")) {
                    continue;
                }

                // Parse: "Name,Grade"
                String[] parts = line.split(",");
                if (parts.length == 2) {
                    String name = parts[0].trim();
                    double grade = Double.parseDouble(parts[1].trim());
                    students.add(new Student(name, grade));
                }
            }
        }

        return students;
    }
}
```

**Mejores prácticas aplicadas:**
- Try-with-resources
- Ignora líneas vacías/comentarios
- Valida formato antes de parsear
- Maneja espacios con trim()
- Lanza IOException (deja que caller maneje)

---

### Alternativa: Leer todo el archivo de una vez (Java 8+)

```java
import java.nio.file.*;
import java.util.List;

public List<String> readAllLines(String filename) throws IOException {
    Path path = Paths.get(filename);
    return Files.readAllLines(path, StandardCharsets.UTF_8);
}
```

**Cuándo usar:**
- Archivos pequeños (<1 MB)
- Necesitas todas las líneas en memoria
- Código más simple

**Cuándo NO usar:**
- Archivos grandes (puede causar OutOfMemoryError)
- Procesamiento línea por línea es suficiente

---

## ESCRITURA DE ARCHIVOS

### Patrón básico

```java
import java.io.*;
import java.nio.charset.StandardCharsets;

public void writeLines(String filename, List<String> lines) throws IOException {
    try (BufferedWriter writer = new BufferedWriter(
            new FileWriter(filename, StandardCharsets.UTF_8))) {

        for (String line : lines) {
            writer.write(line);
            writer.newLine();  // IMPORTANTE: agrega salto de línea
        }
    }  // writer se cierra automáticamente
}
```

**Elementos clave:**
1. `BufferedWriter` - escritura eficiente
2. `FileWriter` - escribe caracteres a archivo
3. `write()` - escribe String
4. `newLine()` - agrega salto de línea (usa el del SO)
5. Try-with-resources cierra automáticamente

---

### Ejemplo completo: Escritor de estudiantes

```java
class StudentFileWriter {

    public void writeStudents(String filename, List<Student> students) throws IOException {
        if (students == null) {
            throw new IllegalArgumentException("Students list cannot be null");
        }

        try (BufferedWriter writer = new BufferedWriter(
                new FileWriter(filename, StandardCharsets.UTF_8))) {

            // Escribir header
            writer.write("# Student Grades Report");
            writer.newLine();
            writer.write("# Name,Grade");
            writer.newLine();
            writer.newLine();

            // Escribir estudiantes
            for (Student student : students) {
                writer.write(student.getName() + "," + student.getGrade());
                writer.newLine();
            }
        }
    }
}
```

---

### Append mode (agregar al final)

```java
public void appendLine(String filename, String line) throws IOException {
    // Segundo parámetro 'true' = append mode
    try (BufferedWriter writer = new BufferedWriter(
            new FileWriter(filename, StandardCharsets.UTF_8, true))) {

        writer.write(line);
        writer.newLine();
    }
}
```

**Diferencia:**
- Sin `true`: sobrescribe archivo completo
- Con `true`: agrega al final del archivo existente

---

## MANEJO DE EXCEPCIONES

### Opción 1: Lanzar excepciones (recomendado para métodos)

```java
public List<String> readFile(String filename) throws IOException {
    // Si falla, la excepción se propaga al caller
    try (BufferedReader reader = new BufferedReader(
            new FileReader(filename, StandardCharsets.UTF_8))) {
        // ...
    }
}
```

**Ventajas:**
- Caller decide cómo manejar
- Método no tiene lógica de manejo de errores
- Más flexible

---

### Opción 2: Capturar y manejar

```java
public List<String> readFileSafe(String filename) {
    try {
        return readFile(filename);
    } catch (FileNotFoundException e) {
        System.err.println("File not found: " + filename);
        return Collections.emptyList();
    } catch (IOException e) {
        System.err.println("Error reading file: " + e.getMessage());
        e.printStackTrace();
        return Collections.emptyList();
    }
}
```

**Ventajas:**
- Manejo específico por tipo de error
- Retorna valor por defecto en caso de error
- Usuario del método no necesita try-catch

---

### Validar si archivo existe

```java
import java.nio.file.*;

public boolean fileExists(String filename) {
    return Files.exists(Paths.get(filename));
}

public List<String> readFileIfExists(String filename) throws IOException {
    Path path = Paths.get(filename);

    if (!Files.exists(path)) {
        throw new FileNotFoundException("File does not exist: " + filename);
    }

    return readFile(filename);
}
```

---

## TRY-WITH-RESOURCES EN PROFUNDIDAD

### ¿Qué es?

Estructura que garantiza cierre automático de recursos (archivos, conexiones, etc.)

### Sintaxis

```java
try (ResourceType resource = createResource()) {
    // Usar resource
}  // resource.close() se llama automáticamente
```

---

### Comparación: Con y sin try-with-resources

**Sin try-with-resources (mal):**
```java
BufferedReader reader = null;
try {
    reader = new BufferedReader(new FileReader("file.txt"));
    // usar reader
} catch (IOException e) {
    e.printStackTrace();
} finally {
    if (reader != null) {
        try {
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
```

**Con try-with-resources (bien):**
```java
try (BufferedReader reader = new BufferedReader(new FileReader("file.txt"))) {
    // usar reader
} catch (IOException e) {
    e.printStackTrace();
}  // reader.close() automático
```

**Ventajas:**
- Menos código
- No se olvida cerrar
- Manejo correcto incluso si hay excepciones

---

### Múltiples recursos

```java
try (BufferedReader reader = new BufferedReader(new FileReader("input.txt"));
     BufferedWriter writer = new BufferedWriter(new FileWriter("output.txt"))) {

    String line;
    while ((line = reader.readLine()) != null) {
        writer.write(line.toUpperCase());
        writer.newLine();
    }
}  // Ambos se cierran en orden inverso: writer, luego reader
```

---

## PATRONES COMUNES

### Patrón 1: Copiar archivo

```java
public void copyFile(String source, String destination) throws IOException {
    try (BufferedReader reader = new BufferedReader(
            new FileReader(source, StandardCharsets.UTF_8));
         BufferedWriter writer = new BufferedWriter(
            new FileWriter(destination, StandardCharsets.UTF_8))) {

        String line;
        while ((line = reader.readLine()) != null) {
            writer.write(line);
            writer.newLine();
        }
    }
}
```

---

### Patrón 2: Filtrar líneas

```java
public void filterFile(String input, String output, String filterKeyword) throws IOException {
    try (BufferedReader reader = new BufferedReader(
            new FileReader(input, StandardCharsets.UTF_8));
         BufferedWriter writer = new BufferedWriter(
            new FileWriter(output, StandardCharsets.UTF_8))) {

        String line;
        while ((line = reader.readLine()) != null) {
            if (line.contains(filterKeyword)) {
                writer.write(line);
                writer.newLine();
            }
        }
    }
}
```

---

### Patrón 3: Contar líneas

```java
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
```

---

### Patrón 4: Leer archivo clave-valor

```java
public Map<String, String> readKeyValueFile(String filename) throws IOException {
    Map<String, String> map = new HashMap<>();

    try (BufferedReader reader = new BufferedReader(
            new FileReader(filename, StandardCharsets.UTF_8))) {

        String line;
        while ((line = reader.readLine()) != null) {
            if (line.trim().isEmpty() || line.startsWith("#")) {
                continue;
            }

            String[] parts = line.split("=");
            if (parts.length == 2) {
                map.put(parts[0].trim(), parts[1].trim());
            }
        }
    }

    return map;
}
```

---

## CHECKLIST DE EXAMEN

### Al leer archivos:
- [ ] Uso try-with-resources
- [ ] Especifico charset (StandardCharsets.UTF_8)
- [ ] Leo línea por línea con readLine()
- [ ] Verifico null para detectar fin de archivo
- [ ] Manejo IOException (throws o try-catch)
- [ ] Valido/filtro líneas vacías si es necesario

### Al escribir archivos:
- [ ] Uso try-with-resources
- [ ] Especifico charset
- [ ] Llamo newLine() después de write()
- [ ] Decido si necesito append mode
- [ ] Manejo IOException

### Errores fatales a evitar:
- [ ] NO olvido newLine() al escribir
- [ ] NO uso close() manual (uso try-with-resources)
- [ ] NO olvido especificar charset
- [ ] NO leo archivo en bucle infinito (verifico null)

---

## TEMPLATE PARA EXAMEN

### Lectura básica

```java
import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.*;

public List<String> readFile(String filename) throws IOException {
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
```

### Escritura básica

```java
import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.List;

public void writeFile(String filename, List<String> lines) throws IOException {
    try (BufferedWriter writer = new BufferedWriter(
            new FileWriter(filename, StandardCharsets.UTF_8))) {

        for (String line : lines) {
            writer.write(line);
            writer.newLine();
        }
    }
}
```

---

## EJERCICIO DE PRÁCTICA

**Crea un programa que:**
1. Lea un archivo "students.txt" con formato "Name,Grade"
2. Calcule el promedio de las calificaciones
3. Escriba un archivo "report.txt" con:
   - Lista de estudiantes
   - Promedio general
   - Estudiantes sobre el promedio

**Archivo de entrada (students.txt):**
```
Alice,9.5
Bob,8.0
Carol,9.8
David,7.5
```

**Archivo de salida esperado (report.txt):**
```
=== STUDENT REPORT ===

Students:
Alice: 9.50
Bob: 8.00
Carol: 9.80
David: 7.50

Average Grade: 8.70

Students Above Average:
Alice: 9.50
Carol: 9.80
```

<details>
<summary>Ver solución</summary>

```java
import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.*;

class Student {
    private String name;
    private double grade;

    public Student(String name, double grade) {
        this.name = name;
        this.grade = grade;
    }

    public String getName() { return name; }
    public double getGrade() { return grade; }
}

public class StudentReportGenerator {

    public List<Student> readStudents(String filename) throws IOException {
        List<Student> students = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(
                new FileReader(filename, StandardCharsets.UTF_8))) {

            String line;
            while ((line = reader.readLine()) != null) {
                if (line.trim().isEmpty()) continue;

                String[] parts = line.split(",");
                if (parts.length == 2) {
                    String name = parts[0].trim();
                    double grade = Double.parseDouble(parts[1].trim());
                    students.add(new Student(name, grade));
                }
            }
        }

        return students;
    }

    public double calculateAverage(List<Student> students) {
        if (students.isEmpty()) return 0;

        double sum = 0;
        for (Student student : students) {
            sum += student.getGrade();
        }
        return sum / students.size();
    }

    public void writeReport(String filename, List<Student> students, double average)
            throws IOException {

        try (BufferedWriter writer = new BufferedWriter(
                new FileWriter(filename, StandardCharsets.UTF_8))) {

            writer.write("=== STUDENT REPORT ===");
            writer.newLine();
            writer.newLine();

            writer.write("Students:");
            writer.newLine();
            for (Student student : students) {
                writer.write(String.format("%s: %.2f", student.getName(), student.getGrade()));
                writer.newLine();
            }
            writer.newLine();

            writer.write(String.format("Average Grade: %.2f", average));
            writer.newLine();
            writer.newLine();

            writer.write("Students Above Average:");
            writer.newLine();
            for (Student student : students) {
                if (student.getGrade() > average) {
                    writer.write(String.format("%s: %.2f", student.getName(), student.getGrade()));
                    writer.newLine();
                }
            }
        }
    }

    public static void main(String[] args) {
        StudentReportGenerator generator = new StudentReportGenerator();

        try {
            List<Student> students = generator.readStudents("students.txt");
            double average = generator.calculateAverage(students);
            generator.writeReport("report.txt", students, average);

            System.out.println("Report generated successfully!");
            System.out.println("Average: " + average);

        } catch (IOException e) {
            System.err.println("Error: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
```

</details>

---

## RESUMEN DE CONCEPTOS CLAVE

**Para leer:**
- BufferedReader + FileReader
- try-with-resources
- readLine() en while
- Verificar null para fin de archivo

**Para escribir:**
- BufferedWriter + FileWriter
- try-with-resources
- write() + newLine()
- Append mode si necesario

**Siempre:**
- StandardCharsets.UTF_8
- Manejo de IOException
- Validación de entrada

**Nunca:**
- Raw FileReader/Writer sin BufferedReader/Writer
- Olvidar newLine()
- close() manual (usa try-with-resources)
- Olvidar charset
