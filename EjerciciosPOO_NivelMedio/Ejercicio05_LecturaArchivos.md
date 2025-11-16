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

---

## 🎓 VENTAJAS DE ESTA ARQUITECTURA

### Sin File I/O estructurado (enfoque ingenuo):

```java
// CODIGO MALO: Datos hardcodeados en el codigo
public class Main {
    public static void main(String[] args) {
        SistemaUniversidad sistema = new SistemaUniversidad();

        // PROBLEMA 1: Datos embebidos en el codigo (hardcoded)
        Estudiante e1 = new Estudiante("Juan", "Perez", "20567890-1", "Ingenieria");
        e1.agregarNota(85);
        e1.agregarNota(90);
        e1.agregarNota(78);
        e1.agregarNota(92);
        sistema.agregarEstudiante(e1);

        Estudiante e2 = new Estudiante("Maria", "Lopez", "21234567-8", "Medicina");
        e2.agregarNota(95);
        e2.agregarNota(88);
        e2.agregarNota(91);
        e2.agregarNota(87);
        sistema.agregarEstudiante(e2);

        // PROBLEMA 2: Para agregar mas estudiantes, recompilas el programa
        // PROBLEMA 3: No puedes compartir datos facilmente
        // PROBLEMA 4: Dificil de testear con diferentes conjuntos de datos
        // PROBLEMA 5: Imposible que usuarios finales agreguen datos
    }
}

// Alternativa con arrays (igualmente mala)
String[][] datosEstudiantes = {
    {"Juan", "Perez", "20567890-1", "Ingenieria", "85,90,78,92"},
    {"Maria", "Lopez", "21234567-8", "Medicina", "95,88,91,87"}
    // Arrays gigantes en el codigo - horrible!
};
```

**Problemas criticos:**
- Datos y logica mezclados (viola separacion de concerns)
- Imposible modificar datos sin recompilar
- No escalable (agregar 1000 estudiantes es impráctico)
- No reutilizable (cada programa necesita su propio dataset)
- Dificil de testear (no puedes cambiar datos facilmente)
- No apto para usuarios finales

### Con File I/O y Parsing (nuestra solucion):

```java
// CODIGO BUENO: Datos separados en archivo externo
public class SistemaUniversidad {
    public void cargarDesdeArchivo(String nombreArchivo) {
        try (Scanner scanner = new Scanner(new File(nombreArchivo))) {
            int cantidad = Integer.parseInt(scanner.nextLine().trim());

            for (int i = 0; i < cantidad; i++) {
                // Leer y parsear datos
                String lineaDatos = scanner.nextLine();
                String[] datos = lineaDatos.split(",");

                String nombre = datos[0].trim();
                String apellido = datos[1].trim();
                String rut = datos[2].trim();
                String carrera = datos[3].trim();

                // Validar antes de crear
                if (!validarRUT(rut)) {
                    System.out.println("RUT invalido: " + rut);
                    scanner.nextLine();  // Saltar notas
                    continue;
                }

                Estudiante estudiante = new Estudiante(nombre, apellido, rut, carrera);

                // Leer notas
                String lineaNotas = scanner.nextLine();
                String[] notasStr = lineaNotas.split(",");

                for (String notaStr : notasStr) {
                    int nota = Integer.parseInt(notaStr.trim());
                    estudiante.agregarNota(nota);
                }

                estudiantes.add(estudiante);
            }
        } catch (FileNotFoundException e) {
            System.out.println("Error: Archivo no encontrado");
        }
    }
}

// En Main.java
public class Main {
    public static void main(String[] args) {
        SistemaUniversidad sistema = new SistemaUniversidad();

        // VENTAJA: Una sola linea carga todos los datos
        sistema.cargarDesdeArchivo("estudiantes.txt");

        // Ahora puedes procesar los datos
        sistema.mostrarEstadisticas();
    }
}
```

**Ventajas:**
- Separacion completa entre datos y codigo
- Modificar datos sin recompilar (editar archivo .txt)
- Escalable (millones de registros posibles)
- Reutilizable (mismo programa, diferentes datasets)
- Testeable (creas archivos de prueba facilmente)
- Apto para usuarios finales (editan archivo .txt)
- Profesional (asi funcionan sistemas reales)

---

## ✅ CHECKLIST DE DOMINIO

Puedes considerar que dominas este ejercicio cuando:

### Conceptos File I/O:
- [ ] Entiendes la diferencia entre FileReader, BufferedReader y Scanner
- [ ] Sabes por que usar try-with-resources para archivos
- [ ] Comprendes que es parsing y por que es necesario
- [ ] Identificas formatos CSV, TSV y otros delimitados

### Implementacion de Lectura:
- [ ] Usas Scanner con try-with-resources correctamente
- [ ] Lees la primera linea para obtener cantidad
- [ ] Iteras el numero exacto de veces
- [ ] Parseas con split(",") y trim()
- [ ] Manejas FileNotFoundException apropiadamente
- [ ] Manejas NumberFormatException para datos invalidos

### Validacion de Datos:
- [ ] Validas formato de RUT con regex (\\d{8}-\\d)
- [ ] Verificas que notas esten en rango 0-100
- [ ] Manejas lineas mal formateadas sin crashear
- [ ] Continuas procesando despues de un error
- [ ] Informas al usuario sobre datos invalidos

### Procesamiento de Datos:
- [ ] Calculas promedios correctamente (division double)
- [ ] Encuentras minimos y maximos
- [ ] Usas HashMap para contar por categoria
- [ ] Filtras listas segun criterios
- [ ] Ordenas resultados apropiadamente

### Buenas Practicas:
- [ ] Cierras recursos automaticamente (try-with-resources)
- [ ] Validas archivo existe antes de procesarlo
- [ ] Muestras mensajes de error descriptivos
- [ ] Formateas numeros con printf/String.format
- [ ] Tu codigo es robusto ante datos incorrectos

### Tiempo:
- [ ] Implementas la solucion completa en < 60 minutos
- [ ] Puedes agregar una nueva estadistica en < 10 minutos
- [ ] Explicas el flujo de lectura linea por linea

---

## 🔗 RELACION CON EL EXAMEN

La lectura de archivos es OBLIGATORIA en el examen - todos los datos vienen de un archivo.

### Comparacion: Este Ejercicio vs Examen

| Aspecto | Ejercicio 05 | Examen Real |
|---------|--------------|-------------|
| **Lectura archivo** | Si (estudiantes.txt) | Si (datos.txt o similar) |
| | Estudiantes + Notas | Vehiculos + Viajes |
| **Formato** | N lineas, pares datos/notas | N lineas, datos + viajes |
| **Parsing** | split(",") + trim() | Identico |
| **Validaciones** | RUT, rango notas | Patente, consumo, distancias |
| **Estructuras** | ArrayList, HashMap | ArrayList, HashMap |
| **Excepciones** | FileNotFoundException | Identico |
| **Complejidad** | Media | Media |
| **Tiempo estimado** | 60 minutos | 15-20 minutos (parte archivo) |
| **Porcentaje del examen** | ~20% | File I/O es ~20% del total |

### Como se usa File I/O en el examen:

**En el examen (Ejercicio 10 - RentaCarCompleto):**
```java
public void cargarVehiculos(String archivo) {
    try (Scanner sc = new Scanner(new File(archivo))) {
        int n = Integer.parseInt(sc.nextLine().trim());

        for (int i = 0; i < n; i++) {
            // Leer datos del vehiculo
            String linea = sc.nextLine();
            String[] datos = linea.split(",");

            String tipo = datos[0].trim();
            String patente = datos[1].trim();
            String marca = datos[2].trim();
            double consumo = Double.parseDouble(datos[3].trim());

            // CREAR VEHICULO (usando Factory o constructor)
            Vehiculo v = VehiculoFactory.crearVehiculo(tipo, patente, marca, consumo);

            // Leer viajes (siguiente linea)
            String lineaViajes = sc.nextLine();
            String[] viajesStr = lineaViajes.split(",");
            String patenteViajes = viajesStr[0].trim();

            for (int j = 1; j < viajesStr.length; j++) {
                double distancia = Double.parseDouble(viajesStr[j].trim());
                v.agregarViaje(distancia);
            }

            vehiculos.add(v);
        }
    } catch (FileNotFoundException e) {
        System.out.println("Error: Archivo no encontrado");
    }
}
```

**Similitudes con este ejercicio:**
1. **Estructura identica:** Primera linea = cantidad, luego pares de lineas
2. **Parsing identico:** split(",") + trim() + casting
3. **Validaciones similares:** Verificar formatos y rangos
4. **Excepciones identicas:** FileNotFoundException, NumberFormatException

### Que cubre este ejercicio:

- ✅ **20% del examen:** Lectura y parsing de archivos
- ✅ **Scanner:** Uso correcto con try-with-resources
- ✅ **Parsing:** split(), trim(), Integer.parseInt()
- ✅ **Validaciones:** Regex, rangos, formatos
- ✅ **HashMap:** Contar elementos por categoria
- ✅ **Estadisticas:** Promedios, min, max, filtrado
- ❌ **No cubre:** Visitor, Strategy (ver Ejercicios 06, 07)

### Diferencias clave con el examen:

1. **Integracion con patrones:**
   - Este ejercicio: File I/O aislado
   - Examen: File I/O + Factory/Singleton + Visitor + Strategy

2. **Tipos de objetos:**
   - Este ejercicio: Una clase simple (Estudiante)
   - Examen: Jerarquia (Vehiculo → Auto/SUV/Camioneta)

3. **Procesamiento:**
   - Este ejercicio: Estadisticas simples
   - Examen: Aplicar Visitors para calculos complejos

### Proximos pasos sugeridos:

1. **Ruta completa hacia el examen:**
   - ✅ Ejercicio 05 (este) - Dominar File I/O
   - ➡️ Ejercicio 06 - Aprender Visitor
   - ➡️ Ejercicio 07 - Integrar File I/O + Visitor + Strategy
   - ➡️ Ejercicio 10 - Simulacro completo de examen

2. **Practica adicional recomendada:**
   - Crea variantes del archivo estudiantes.txt
   - Agrega datos invalidos para testear validaciones
   - Implementa exportacion a archivo (inverso de lectura)

### Errores comunes en el examen relacionados con File I/O:

1. **No usar try-with-resources** → Scanner no se cierra, leak de recursos
2. **No validar archivo existe** → FileNotFoundException crashea programa
3. **No usar trim()** → Espacios causan parsing incorrecto
4. **Division entera en promedios** → 85/2 = 42 en lugar de 42.5
5. **No manejar cantidad variable** → Codigo rigido para 4 notas exactas

### Tips para el examen:

- ⏱️ **Tiempo:** Dedica MAX 20 minutos a la lectura de archivo
- 📝 **Plantilla:** Memoriza la estructura try-with-resources + for loop
- ✅ **Validacion:** Siempre valida ANTES de crear objetos
- 🔍 **Debug:** Si falla, imprime cada linea leida para verificar formato
- 💡 **Orden:** Lee archivo PRIMERO, luego aplica Visitors

---

**Si dominas este ejercicio, tienes el 20% del examen garantizado. La lectura de archivos es CRITICA - no puedes aprobar sin dominarla.**
