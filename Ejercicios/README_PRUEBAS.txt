================================================================================
  SISTEMA DE PRUEBAS AUTOMATIZADO - RESUMEN RÁPIDO
================================================================================

¡HE CREADO UN SISTEMA COMPLETO DE PRUEBAS PARA TODOS TUS EJERCICIOS!

Ya no tendrás que inventar datos de prueba cada vez que hagas un ejercicio.
Todo está listo para usar.

================================================================================
  ARCHIVOS CREADOS
================================================================================

1. TestRunner.java
   → Sistema básico de testing (assertEquals, assertTrue, etc.)

2. DatosPrueba.java
   → Datos de prueba para ejercicios 1-10 (básicos)

3. DatosPruebaAvanzados.java
   → Datos de prueba para ejercicios 11-20 (intermedios)

4. DatosPruebaMuyAvanzados.java
   → Datos de prueba para ejercicios 21-36 (avanzados)

5. EjemploPrueba.java
   → Ejemplo completo mostrando cómo usar el sistema

6. VerDatosPrueba.java
   → Herramienta interactiva para ver datos de cualquier ejercicio

7. GUIA_PRUEBAS.md
   → Guía completa con ejemplos y explicaciones

================================================================================
  CÓMO EMPEZAR (3 COMANDOS)
================================================================================

1. Compilar todo:
   javac *.java

2. Ver ejemplo funcionando:
   java EjemploPrueba

3. Ver datos de un ejercicio específico:
   java VerDatosPrueba

================================================================================
  USO RÁPIDO
================================================================================

OPCIÓN 1: Ver datos disponibles
--------------------------------
java VerDatosPrueba
→ Interfaz interactiva para ver datos de cualquier ejercicio

OPCIÓN 2: Ver datos de un ejercicio específico
-----------------------------------------------
Crea un archivo temporal:

// MostrarDatos.java
public class MostrarDatos {
    public static void main(String[] args) {
        DatosPrueba.Ejercicio7.mostrarDatos();
    }
}

Luego ejecuta:
javac MostrarDatos.java
java MostrarDatos

OPCIÓN 3: Usar datos directamente en tu código
-----------------------------------------------
// Ejercicio7.java
import java.util.Arrays;

public class Ejercicio7 {
    public static void main(String[] args) {
        // Usar datos predefinidos
        int[] numeros = DatosPrueba.Ejercicio7.NUMEROS;

        System.out.println("Array: " + Arrays.toString(numeros));

        // Tu código aquí...
        int suma = 0;
        for (int num : numeros) {
            suma += num;
        }

        System.out.println("Suma: " + suma);

        // Verificar resultado
        TestRunner.assertEquals("Suma correcta", 120, suma);
    }
}

================================================================================
  DATOS DISPONIBLES POR EJERCICIO
================================================================================

EJERCICIOS BÁSICOS (1-10):
---------------------------
Ej 1:  Variables (nombre, edad, altura)
Ej 2:  Operaciones matemáticas (números para sumar, restar, etc.)
Ej 3:  Intercambio de variables (valores a y b)
Ej 4:  Condicionales (números positivo, negativo, cero)
Ej 6:  Tabla de multiplicar (número base)
Ej 7:  Arrays (array de 10 números con suma, promedio, max, min calculados)
Ej 8:  Métodos (datos para área y perímetro)
Ej 9:  Arrays de Strings (array de nombres)
Ej 10: Clase Persona (datos de 3 personas)

EJERCICIOS INTERMEDIOS (11-20):
--------------------------------
Ej 11: Estudiante (datos de 3 estudiantes con notas)
Ej 12: Aula (nombre del aula + 4 estudiantes con notas)
Ej 13: Biblioteca (3 autores + 5 libros)
Ej 14: ArrayList (5 tareas predefinidas)
Ej 15: Empresa (2 departamentos con empleados y salarios)

EJERCICIOS AVANZADOS (21-36):
------------------------------
Ej 21-23: Arrays para ordenamiento (pequeño, mediano, grande, ordenado, inverso)
Ej 24-25: Arrays para búsqueda (valores a buscar, índices esperados)
Ej 17-18: Datos para listas enlazadas
Ej 19-20: Datos para colas y sets
Ej 32:    Datos para Binary Search Tree
Ej 33:    Datos para File I/O
Ej 34:    Datos para patrones de diseño
Ej 35:    Datos para threads
Ej 36:    Datos para collections avanzadas

================================================================================
  EJEMPLOS RÁPIDOS
================================================================================

EJEMPLO 1: Ver datos del Ejercicio 7
-------------------------------------
java -cp . -c "DatosPrueba.Ejercicio7.mostrarDatos()"

EJEMPLO 2: Usar en tu código
-----------------------------
int[] numeros = DatosPrueba.Ejercicio7.NUMEROS;
// Ahora trabajas con numeros[]

EJEMPLO 3: Verificar con tests
-------------------------------
int resultado = miCalculo();
TestRunner.assertEquals("Mi cálculo", valorEsperado, resultado);
TestRunner.imprimirResumen();

================================================================================
  CASOS DE PRUEBA ESPECIALES
================================================================================

Para algoritmos de ordenamiento:
- ARRAY_PEQUEÑO    → Para visualizar paso a paso
- ARRAY_MEDIANO    → Caso general
- ARRAY_GRANDE     → Probar rendimiento
- ARRAY_ORDENADO   → Mejor caso
- ARRAY_INVERSO    → Peor caso
- ARRAY_DUPLICADOS → Con valores repetidos

Para algoritmos de búsqueda:
- VALOR_PRESENTE   → Está en el array
- VALOR_AUSENTE    → No está en el array
- VALOR_PRIMERO    → Primer elemento
- VALOR_ULTIMO     → Último elemento

================================================================================
  COMANDOS ÚTILES
================================================================================

Compilar todo:
javac *.java

Ver ejemplo completo:
java EjemploPrueba

Ver datos interactivamente:
java VerDatosPrueba

Ver datos de un ejercicio:
DatosPrueba.Ejercicio#.mostrarDatos();

Compilar y ejecutar un ejercicio:
javac Ejercicio7.java DatosPrueba.java
java Ejercicio7

================================================================================
  VENTAJAS
================================================================================

✓ Ya no tienes que inventar datos de prueba cada vez
✓ Datos consistentes para comparar resultados
✓ Casos especiales ya preparados (mejor/peor caso, duplicados, etc.)
✓ Verificación automática con TestRunner
✓ Salidas esperadas ya calculadas
✓ Ejemplos completos listos para usar

================================================================================
  SOPORTE
================================================================================

Para más información, consulta:
- GUIA_PRUEBAS.md (guía completa con ejemplos)
- EjemploPrueba.java (ejemplo funcionando)
- VerDatosPrueba.java (ver datos interactivamente)

¡Feliz programación! 🚀

================================================================================
