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
