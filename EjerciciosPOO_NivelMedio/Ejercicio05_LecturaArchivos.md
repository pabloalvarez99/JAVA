# Ejercicio 5: Lectura de Archivo de Estudiantes (Nivel 3)
**Dificultad:** Medio
**Tiempo estimado:** 60 minutos
**Conceptos:** File I/O, Parsing, Collections, Exception Handling

---

## Contexto

Una universidad necesita procesar un archivo con informacion de estudiantes y sus calificaciones para generar estadisticas.

## Formato del Archivo: estudiantes.txt

```
5
Juan,Perez,20567890-1,Ingenieria
85,90,78,92
Maria,Lopez,21234567-8,Medicina
95,88,91,87
Carlos,Ruiz,19876543-2,Derecho
70,75,72,68
Ana,Martinez,20111222-3,Ingenieria
88,92,85,90
Luis,Gomez,21333444-5,Medicina
65,70,68,72
```

**Estructura:**
- Primera linea: cantidad N de estudiantes
- Luego N pares de lineas:
  - Linea 1: Nombre,Apellido,RUT,Carrera
  - Linea 2: Nota1,Nota2,Nota3,Nota4 (cantidad variable de notas)

## Requisitos

### Clase Estudiante:

Atributos:
- Nombre (String)
- Apellido (String)
- RUT (String)
- Carrera (String)
- Notas (ArrayList<Integer>)

Metodos:
- Calcular promedio de notas
- Obtener nota maxima
- Obtener nota minima
- Mostrar informacion completa

### Sistema de Procesamiento:

1. **Leer archivo** y crear objetos Estudiante
2. **Validar datos:**
   - RUT debe tener formato correcto (########-#)
   - Notas deben estar entre 0 y 100
3. **Generar estadisticas:**
   - Estudiante con mejor promedio
   - Estudiante con peor promedio
   - Promedio general de todos los estudiantes
   - Cantidad de estudiantes por carrera
   - Estudiantes con promedio >= 85 (Lista de Honor)

## Ejemplo de Ejecucion

```
=== CARGANDO DATOS ===
Leyendo archivo: estudiantes.txt
5 estudiantes cargados exitosamente.

=== INFORMACION DE ESTUDIANTES ===
Juan Perez (20567890-1) - Ingenieria
Notas: [85, 90, 78, 92]
Promedio: 86.25 | Min: 78 | Max: 92

Maria Lopez (21234567-8) - Medicina
Notas: [95, 88, 91, 87]
Promedio: 90.25 | Min: 87 | Max: 95

Carlos Ruiz (19876543-2) - Derecho
Notas: [70, 75, 72, 68]
Promedio: 71.25 | Min: 68 | Max: 75

Ana Martinez (20111222-3) - Ingenieria
Notas: [88, 92, 85, 90]
Promedio: 88.75 | Min: 85 | Max: 92

Luis Gomez (21333444-5) - Medicina
Notas: [65, 70, 68, 72]
Promedio: 68.75 | Min: 65 | Max: 72

=== ESTADISTICAS ===
Mejor promedio: Maria Lopez (90.25)
Peor promedio: Luis Gomez (68.75)
Promedio general: 81.05

Estudiantes por carrera:
- Ingenieria: 2 estudiantes
- Medicina: 2 estudiantes
- Derecho: 1 estudiante

=== LISTA DE HONOR (Promedio >= 85) ===
1. Maria Lopez - 90.25
2. Ana Martinez - 88.75
3. Juan Perez - 86.25
```

## Debe entregar:

- Clase `Estudiante` con todos los atributos y metodos
- Clase `SistemaUniversidad` que:
  - Lee el archivo
  - Almacena estudiantes en un ArrayList
  - Genera todas las estadisticas
- Clase `Main` que ejecute el programa
- Archivo `estudiantes.txt` de prueba

## Consideraciones:

- **Manejo de excepciones:** Usa try-catch para File I/O
- **Validacion de datos:** Verifica formato de RUT y rango de notas
- **Parsing:** Usa `String.split(",")` para separar datos
- **Formato de numeros:** Muestra promedios con 2 decimales
- Si el archivo no existe, mostrar mensaje de error apropiado
- Evitar ciclos anidados cuando sea posible (usa metodos auxiliares)

## Pistas - Lectura de Archivo:

```java
import java.io.*;
import java.util.*;

try (Scanner scanner = new Scanner(new File("estudiantes.txt"))) {
    int cantidad = Integer.parseInt(scanner.nextLine());

    for (int i = 0; i < cantidad; i++) {
        String lineaDatos = scanner.nextLine();
        String lineaNotas = scanner.nextLine();

        String[] datos = lineaDatos.split(",");
        String[] notasStr = lineaNotas.split(",");

        // Procesar...
    }
} catch (FileNotFoundException e) {
    System.out.println("Error: Archivo no encontrado");
}
```

## Validacion RUT:

El RUT debe tener exactamente 8 digitos, un guion y 1 digito verificador.
Ejemplo valido: `12345678-9`

---

**Este ejercicio es fundamental para prepararte para la lectura de archivos estructurados del examen.**

---

## PASO A PASO: COMO RESOLVER ESTE EJERCICIO

Este ejercicio te ensenara a leer archivos, procesar datos con formato CSV, manejar excepciones y generar estadisticas. Vamos paso por paso.

### PASO 1: Entender el Formato del Archivo

Antes de programar, analiza la estructura:
```
5                                  <- Numero total de estudiantes
Juan,Perez,20567890-1,Ingenieria  <- Linea de datos personales
85,90,78,92                        <- Linea de notas
Maria,Lopez,21234567-8,Medicina   <- Siguiente estudiante...
95,88,91,87
...
```

**Patron:**
- Primera linea: cantidad N
- Luego N bloques de 2 lineas (datos + notas)

### PASO 2: Crear la Clase Estudiante

Comienza con la clase que representa un estudiante:

```java
import java.util.ArrayList;

public class Estudiante {
    // Atributos
    private String nombre;
    private String apellido;
    private String rut;
    private String carrera;
    private ArrayList<Integer> notas;

    // Constructor
    public Estudiante(String nombre, String apellido, String rut, String carrera) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.rut = rut;
        this.carrera = carrera;
        this.notas = new ArrayList<>();
    }

    // Agregar una nota
    public void agregarNota(int nota) {
        if (nota >= 0 && nota <= 100) {
            notas.add(nota);
        } else {
            System.out.println("Advertencia: Nota fuera de rango ignorada");
        }
    }

    // Calcular promedio
    public double calcularPromedio() {
        if (notas.isEmpty()) {
            return 0.0;
        }
        int suma = 0;
        for (int nota : notas) {
            suma += nota;
        }
        return (double) suma / notas.size();
    }

    // Obtener nota maxima
    public int obtenerNotaMaxima() {
        if (notas.isEmpty()) return 0;
        int max = notas.get(0);
        for (int nota : notas) {
            if (nota > max) {
                max = nota;
            }
        }
        return max;
    }

    // Obtener nota minima
    public int obtenerNotaMinima() {
        if (notas.isEmpty()) return 0;
        int min = notas.get(0);
        for (int nota : notas) {
            if (nota < min) {
                min = nota;
            }
        }
        return min;
    }

    // Mostrar informacion completa
    public void mostrarInformacion() {
        System.out.printf("%s %s (%s) - %s%n", nombre, apellido, rut, carrera);
        System.out.println("Notas: " + notas);
        System.out.printf("Promedio: %.2f | Min: %d | Max: %d%n",
                         calcularPromedio(), obtenerNotaMinima(), obtenerNotaMaxima());
    }

    // Getters
    public String getNombre() { return nombre; }
    public String getApellido() { return apellido; }
    public String getRut() { return rut; }
    public String getCarrera() { return carrera; }
    public ArrayList<Integer> getNotas() { return notas; }
}
```

**Puntos clave:**
- Las notas se almacenan en un ArrayList (cantidad variable)
- Validamos que las notas esten entre 0 y 100
- Usamos casting `(double)` para division correcta en promedio
- Validamos lista vacia antes de buscar min/max

### PASO 3: Crear la Clase SistemaUniversidad

Esta clase maneja la lectura del archivo y las estadisticas:

```java
import java.io.*;
import java.util.*;

public class SistemaUniversidad {
    private ArrayList<Estudiante> estudiantes;

    public SistemaUniversidad() {
        estudiantes = new ArrayList<>();
    }

    // METODO PRINCIPAL: Leer archivo
    public void cargarDesdeArchivo(String nombreArchivo) {
        System.out.println("=== CARGANDO DATOS ===");
        System.out.println("Leyendo archivo: " + nombreArchivo);

        try (Scanner scanner = new Scanner(new File(nombreArchivo))) {
            // Leer cantidad de estudiantes
            int cantidad = Integer.parseInt(scanner.nextLine().trim());

            // Leer cada estudiante
            for (int i = 0; i < cantidad; i++) {
                // Leer linea de datos personales
                String lineaDatos = scanner.nextLine();
                String[] datos = lineaDatos.split(",");

                String nombre = datos[0].trim();
                String apellido = datos[1].trim();
                String rut = datos[2].trim();
                String carrera = datos[3].trim();

                // Validar RUT
                if (!validarRUT(rut)) {
                    System.out.println("Advertencia: RUT invalido - " + rut);
                    scanner.nextLine(); // Saltar linea de notas
                    continue;
                }

                // Crear estudiante
                Estudiante estudiante = new Estudiante(nombre, apellido, rut, carrera);

                // Leer linea de notas
                String lineaNotas = scanner.nextLine();
                String[] notasStr = lineaNotas.split(",");

                for (String notaStr : notasStr) {
                    int nota = Integer.parseInt(notaStr.trim());
                    estudiante.agregarNota(nota);
                }

                // Agregar a la lista
                estudiantes.add(estudiante);
            }

            System.out.println(estudiantes.size() + " estudiantes cargados exitosamente.\n");

        } catch (FileNotFoundException e) {
            System.out.println("Error: Archivo no encontrado - " + nombreArchivo);
        } catch (NumberFormatException e) {
            System.out.println("Error: Formato de numero invalido en el archivo");
        } catch (Exception e) {
            System.out.println("Error al leer archivo: " + e.getMessage());
        }
    }

    // Validar formato de RUT: ########-#
    private boolean validarRUT(String rut) {
        String patron = "\\d{8}-\\d";
        return rut.matches(patron);
    }

    // Mostrar todos los estudiantes
    public void mostrarEstudiantes() {
        System.out.println("=== INFORMACION DE ESTUDIANTES ===");
        for (Estudiante est : estudiantes) {
            est.mostrarInformacion();
            System.out.println();
        }
    }

    // Encontrar estudiante con mejor promedio
    public Estudiante obtenerMejorPromedio() {
        if (estudiantes.isEmpty()) return null;

        Estudiante mejor = estudiantes.get(0);
        for (Estudiante est : estudiantes) {
            if (est.calcularPromedio() > mejor.calcularPromedio()) {
                mejor = est;
            }
        }
        return mejor;
    }

    // Encontrar estudiante con peor promedio
    public Estudiante obtenerPeorPromedio() {
        if (estudiantes.isEmpty()) return null;

        Estudiante peor = estudiantes.get(0);
        for (Estudiante est : estudiantes) {
            if (est.calcularPromedio() < peor.calcularPromedio()) {
                peor = est;
            }
        }
        return peor;
    }

    // Calcular promedio general
    public double calcularPromedioGeneral() {
        if (estudiantes.isEmpty()) return 0.0;

        double suma = 0;
        for (Estudiante est : estudiantes) {
            suma += est.calcularPromedio();
        }
        return suma / estudiantes.size();
    }

    // Contar estudiantes por carrera
    public Map<String, Integer> contarPorCarrera() {
        Map<String, Integer> conteo = new HashMap<>();

        for (Estudiante est : estudiantes) {
            String carrera = est.getCarrera();
            conteo.put(carrera, conteo.getOrDefault(carrera, 0) + 1);
        }

        return conteo;
    }

    // Obtener lista de honor (promedio >= 85)
    public ArrayList<Estudiante> obtenerListaHonor() {
        ArrayList<Estudiante> listaHonor = new ArrayList<>();

        for (Estudiante est : estudiantes) {
            if (est.calcularPromedio() >= 85) {
                listaHonor.add(est);
            }
        }

        // Ordenar de mayor a menor promedio
        listaHonor.sort((e1, e2) -> Double.compare(e2.calcularPromedio(), e1.calcularPromedio()));

        return listaHonor;
    }

    // Generar estadisticas completas
    public void mostrarEstadisticas() {
        System.out.println("=== ESTADISTICAS ===");

        Estudiante mejor = obtenerMejorPromedio();
        Estudiante peor = obtenerPeorPromedio();

        if (mejor != null) {
            System.out.printf("Mejor promedio: %s %s (%.2f)%n",
                            mejor.getNombre(), mejor.getApellido(), mejor.calcularPromedio());
        }

        if (peor != null) {
            System.out.printf("Peor promedio: %s %s (%.2f)%n",
                            peor.getNombre(), peor.getApellido(), peor.calcularPromedio());
        }

        System.out.printf("Promedio general: %.2f%n", calcularPromedioGeneral());

        System.out.println("\nEstudiantes por carrera:");
        Map<String, Integer> conteo = contarPorCarrera();
        for (Map.Entry<String, Integer> entry : conteo.entrySet()) {
            System.out.printf("- %s: %d estudiante%s%n",
                            entry.getKey(), entry.getValue(),
                            entry.getValue() == 1 ? "" : "s");
        }

        System.out.println("\n=== LISTA DE HONOR (Promedio >= 85) ===");
        ArrayList<Estudiante> honor = obtenerListaHonor();
        int posicion = 1;
        for (Estudiante est : honor) {
            System.out.printf("%d. %s %s - %.2f%n",
                            posicion++, est.getNombre(), est.getApellido(),
                            est.calcularPromedio());
        }
    }
}
```

**Conceptos importantes:**
- **try-with-resources:** Cierra el Scanner automaticamente
- **split(","):** Separa datos por comas
- **trim():** Elimina espacios en blanco
- **matches():** Valida patron con regex
- **Map:** Estructura para contar por categoria
- **Lambda:** `(e1, e2) -> ...` para ordenar

### PASO 4: Crear el Archivo de Datos

Crea `estudiantes.txt` en el mismo directorio:

```
5
Juan,Perez,20567890-1,Ingenieria
85,90,78,92
Maria,Lopez,21234567-8,Medicina
95,88,91,87
Carlos,Ruiz,19876543-2,Derecho
70,75,72,68
Ana,Martinez,20111222-3,Ingenieria
88,92,85,90
Luis,Gomez,21333444-5,Medicina
65,70,68,72
```

**Importante:** No dejes espacios al inicio/final de cada linea.

### PASO 5: Crear el Main

```java
public class Main {
    public static void main(String[] args) {
        SistemaUniversidad sistema = new SistemaUniversidad();

        // Cargar datos desde archivo
        sistema.cargarDesdeArchivo("estudiantes.txt");

        // Mostrar informacion de estudiantes
        sistema.mostrarEstudiantes();

        // Mostrar estadisticas
        sistema.mostrarEstadisticas();
    }
}
```

### PASO 6: Compilar y Ejecutar

```bash
# Asegurate de que estudiantes.txt este en el mismo directorio
javac Estudiante.java SistemaUniversidad.java Main.java
java Main
```

### ERRORES COMUNES A EVITAR

1. **FileNotFoundException - Archivo no encontrado:**
   ```java
   // SOLUCION: Verifica la ubicacion del archivo
   // El archivo debe estar en el directorio donde ejecutas java Main
   // O usa ruta absoluta: "C:/ruta/completa/estudiantes.txt"
   ```

2. **ArrayIndexOutOfBoundsException al hacer split:**
   ```java
   // PROBLEMA: Linea mal formateada en el archivo
   String[] datos = lineaDatos.split(",");
   // SOLUCION: Verifica que cada linea tenga 4 campos
   if (datos.length != 4) {
       System.out.println("Error: Linea con formato incorrecto");
       continue;
   }
   ```

3. **Division por cero en promedio:**
   ```java
   // Siempre valida lista vacia
   if (notas.isEmpty()) {
       return 0.0;
   }
   ```

4. **Olvidas cerrar el Scanner:**
   ```java
   // INCORRECTO
   Scanner scanner = new Scanner(new File("..."));
   // ... usar scanner
   scanner.close();  // Puede olvidarse

   // CORRECTO - Se cierra automaticamente
   try (Scanner scanner = new Scanner(new File("..."))) {
       // ... usar scanner
   }  // Se cierra automaticamente aqui
   ```

5. **No usar trim() al parsear:**
   ```java
   // PROBLEMA: "85 " (con espacio) no se parsea bien
   int nota = Integer.parseInt(notaStr);

   // SOLUCION
   int nota = Integer.parseInt(notaStr.trim());
   ```

### MEJORAS AVANZADAS

Una vez que funcione, intenta:

1. **Agregar opcion de menu interactivo:**
   ```java
   // 1. Cargar archivo
   // 2. Mostrar estudiantes
   // 3. Mostrar estadisticas
   // 4. Buscar por RUT
   // 5. Salir
   ```

2. **Exportar estadisticas a archivo:**
   ```java
   public void exportarEstadisticas(String nombreArchivo) {
       try (PrintWriter writer = new PrintWriter(nombreArchivo)) {
           writer.println("=== REPORTE ESTADISTICO ===");
           // ... escribir datos
       } catch (FileNotFoundException e) {
           System.out.println("Error al crear archivo");
       }
   }
   ```

3. **Usar Streams (Java 8+):**
   ```java
   // Promedio general con streams
   double promedioGeneral = estudiantes.stream()
       .mapToDouble(Estudiante::calcularPromedio)
       .average()
       .orElse(0.0);

   // Lista de honor con streams
   List<Estudiante> honor = estudiantes.stream()
       .filter(e -> e.calcularPromedio() >= 85)
       .sorted((e1, e2) -> Double.compare(e2.calcularPromedio(), e1.calcularPromedio()))
       .collect(Collectors.toList());
   ```

### CONCEPTOS APRENDIDOS

1. **File I/O:** Leer archivos con Scanner
2. **Exception Handling:** try-catch y try-with-resources
3. **String Processing:** split(), trim(), matches()
4. **Data Validation:** Validar formato de RUT y rango de notas
5. **Collections:** ArrayList, HashMap, sorting
6. **Statistical Processing:** Promedios, maximos, minimos, conteos
7. **Lambda Expressions:** Para ordenamiento y filtrado

### CHECKLIST DE VERIFICACION

Antes de considerar completo el ejercicio, verifica:
- [ ] El archivo se lee correctamente sin errores
- [ ] Los RUT invalidos son rechazados
- [ ] Las notas fuera de rango (0-100) son rechazadas
- [ ] Se calculan correctamente todos los promedios
- [ ] Se identifica correctamente el mejor y peor estudiante
- [ ] El conteo por carrera es exacto
- [ ] La lista de honor incluye solo estudiantes con promedio >= 85
- [ ] La lista de honor esta ordenada de mayor a menor
- [ ] Si el archivo no existe, se muestra un mensaje claro
- [ ] El formato de salida coincide con el ejemplo

---

**Este ejercicio es esencial para el examen. Practica variando el archivo de datos y agregando mas validaciones.**
