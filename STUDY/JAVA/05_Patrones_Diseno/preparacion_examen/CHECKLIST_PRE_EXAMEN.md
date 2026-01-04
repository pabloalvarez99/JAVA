si# CHECKLIST PRE-EXAMEN - Revisión Final

**Objetivo:** Verificación completa antes del examen para asegurar que dominas todos los conceptos clave.

**Tiempo estimado:** 45-60 minutos

**Cuándo usarlo:**
- 2-3 horas antes del examen
- Como último repaso
- Para identificar puntos débiles de última hora

**Instrucciones:** Marca cada item SOLO si puedes hacerlo/explicarlo sin ayuda.

---

## PARTE 1: STRATEGY PATTERN (10 items)

### ¿Qué es Strategy?

**Definición:**
El patrón Strategy permite encapsular diferentes algoritmos (estrategias) en clases separadas que implementan una interfaz común, permitiendo cambiar el comportamiento de un objeto en tiempo de ejecución sin modificar su código.

**Problema que resuelve:**
Evita tener largas cadenas de if-else o switch cuando necesitas diferentes variaciones de un algoritmo.

**Código de ejemplo:**

```java
// Interface Strategy
public interface EstrategiaDescuento {
    double calcularPrecioFinal(double precio);
}

// Estrategia Concreta 1
public class DescuentoPorcentual implements EstrategiaDescuento {
    private double porcentaje;

    public DescuentoPorcentual(double porcentaje) {
        this.porcentaje = porcentaje;
    }

    @Override
    public double calcularPrecioFinal(double precio) {
        return precio * (1 - porcentaje/100);
    }
}

// Estrategia Concreta 2
public class DescuentoFijo implements EstrategiaDescuento {
    private double monto;

    public DescuentoFijo(double monto) {
        this.monto = monto;
    }

    @Override
    public double calcularPrecioFinal(double precio) {
        double resultado = precio - monto;
        return resultado < 0 ? 0 : resultado;
    }
}

// Context que usa la estrategia
public class CarritoCompras {
    private EstrategiaDescuento estrategia;

    public void setEstrategia(EstrategiaDescuento estrategia) {
        this.estrategia = estrategia;
    }

    public double calcularTotal(double subtotal) {
        // Usa la estrategia actual
        return estrategia.calcularPrecioFinal(subtotal);
    }
}

// Uso en Main
CarritoCompras carrito = new CarritoCompras();
carrito.setEstrategia(new DescuentoPorcentual(15));  // 15% descuento
double total1 = carrito.calcularTotal(100);  // $85

carrito.setEstrategia(new DescuentoFijo(20));  // $20 descuento
double total2 = carrito.calcularTotal(100);  // $80
```

**Errores comunes:**

- NO implementar todos los métodos de la interface
- NO validar si la estrategia es null antes de usarla
- Usar if-else en lugar de Strategy cuando deberías usar el patrón
- Olvidar que cada estrategia puede tener sus propios atributos (porcentaje, monto, etc.)
- No usar `@Override` al implementar la interface
- Confundir Strategy con Factory

**Cuándo usar Strategy vs if-else:**

USAR STRATEGY cuando:
- Tienes 3+ variaciones del mismo algoritmo
- Las variaciones pueden cambiar en runtime
- Quieres código extensible (agregar nuevas estrategias sin modificar código existente)

USAR IF-ELSE cuando:
- Solo tienes 2 opciones simples
- La lógica nunca cambia en runtime
- No planeas agregar más opciones

### Conceptos Fundamentales
- [ ] Puedo explicar qué problema resuelve Strategy
- [ ] Puedo dibujar el diagrama UML de Strategy
- [ ] Sé cuándo usar Strategy vs if-else
- [ ] Conozco las ventajas de Strategy (al menos 3)

### Implementación
- [ ] Puedo crear una interface Strategy desde cero
- [ ] Puedo implementar 2+ estrategias concretas
- [ ] Puedo crear un Context que use Strategy
- [ ] Sé cómo cambiar estrategias en runtime

### Detalles Técnicos
- [ ] Sé validar que strategy no sea null
- [ ] Puedo pasar parámetros a las estrategias
- [ ] Entiendo cuándo usar interface vs abstract class
- [ ] Sé testear el patrón Strategy

**Verificación práctica:**
Escribe de memoria (sin ver ejemplos) una interface con un método, dos clases que la implementen con lógica diferente, y un Context que use la estrategia. Si no puedes, repasa GUIA_PATRON_STRATEGY.md

**Si marcaste menos de 8:** Repasa GUIA_PATRON_STRATEGY.md

---

## PARTE 2: VISITOR PATTERN (10 items)

### ¿Qué es Visitor?

**Definición:**
El patrón Visitor permite agregar nuevas operaciones a una jerarquía de clases sin modificar esas clases. Separa los algoritmos de los objetos sobre los que operan.

**Concepto clave - Double Dispatch:**
El método correcto se selecciona DOS veces:
1. Primera vez: cuando llamas `elemento.accept(visitor)`
2. Segunda vez: cuando accept() llama `visitor.visit(this)` - Java determina qué método visit usar según el tipo REAL de `this`

**Código de ejemplo:**

```java
// Interface Visitor
public interface VisitorCosto {
    double visitarAuto(Auto auto);
    double visitarSUV(SUV suv);
    double visitarCamioneta(Camioneta camioneta);
}

// Interface Element
public interface Vehiculo {
    double accept(VisitorCosto visitor);
}

// Elemento Concreto 1
public class Auto implements Vehiculo {
    private double kilometraje;

    public Auto(double kilometraje) {
        this.kilometraje = kilometraje;
    }

    @Override
    public double accept(VisitorCosto visitor) {
        // CLAVE: pasa "this" al visitor
        return visitor.visitarAuto(this);
    }

    public double getKilometraje() {
        return kilometraje;
    }
}

// Elemento Concreto 2
public class SUV implements Vehiculo {
    private double kilometraje;

    public SUV(double kilometraje) {
        this.kilometraje = kilometraje;
    }

    @Override
    public double accept(VisitorCosto visitor) {
        return visitor.visitarSUV(this);  // Pasa THIS
    }

    public double getKilometraje() {
        return kilometraje;
    }
}

// Visitor Concreto
public class CalculadorMantenimiento implements VisitorCosto {
    @Override
    public double visitarAuto(Auto auto) {
        // Auto: $0.05 por km
        return auto.getKilometraje() * 0.05;
    }

    @Override
    public double visitarSUV(SUV suv) {
        // SUV: $0.08 por km (más costoso)
        return suv.getKilometraje() * 0.08;
    }

    @Override
    public double visitarCamioneta(Camioneta camioneta) {
        // Camioneta: $0.10 por km (aún más costoso)
        return camioneta.getKilometraje() * 0.10;
    }
}

// Uso en Main
List<Vehiculo> flota = new ArrayList<>();
flota.add(new Auto(10000));
flota.add(new SUV(15000));

VisitorCosto calculador = new CalculadorMantenimiento();

for (Vehiculo v : flota) {
    double costo = v.accept(calculador);  // Polimorfismo
    System.out.println("Costo: $" + costo);
}
```

**Errores comunes:**

- ERROR FATAL: Olvidar pasar `this` en accept(): `visitor.visit()` en lugar de `visitor.visit(this)`
- NO implementar todos los métodos visitXXX() en la interface Visitor
- NO usar @Override en accept()
- Confundir cuál clase llama a cuál (Element llama a Visitor, NO al revés)
- Agregar nuevos elementos es costoso (tienes que modificar TODAS las interfaces/visitors)
- No retornar valores cuando el visitor necesita calcular algo

**Cuándo usar Visitor:**

USAR VISITOR cuando:
- Tu estructura de clases es ESTABLE (raramente agregas nuevos tipos)
- Necesitas MUCHAS operaciones diferentes sobre la misma estructura
- Quieres separar algoritmos de la estructura de datos

NO USAR VISITOR cuando:
- Agregas nuevos tipos de elementos frecuentemente
- Solo tienes 1-2 operaciones simples

**Ventajas:**
- Agregar nuevas operaciones es fácil (solo creas un nuevo Visitor)
- Separa la lógica de la estructura
- Toda la lógica de una operación está en una clase

**Desventajas:**
- Agregar nuevos elementos requiere modificar TODOS los Visitors
- Más complejo que otros patrones

### Conceptos Fundamentales
- [ ] Puedo explicar qué es double dispatch
- [ ] Puedo dibujar el diagrama UML de Visitor
- [ ] Sé cuándo usar Visitor (estructura estable + operaciones variables)
- [ ] Conozco la desventaja principal (agregar elementos es costoso)

### Implementación
- [ ] Puedo crear interface Visitor con métodos visit()
- [ ] Puedo crear interface Element con método accept()
- [ ] Sé implementar accept() correctamente: `visitor.visit(this)`
- [ ] Puedo crear un ConcreteVisitor que procese elementos

### Detalles Técnicos
- [ ] Entiendo por qué accept() debe pasar `this`
- [ ] Puedo hacer que Visitor retorne valores
- [ ] Sé cómo dar estado a un Visitor (acumuladores)
- [ ] Puedo aplicar Visitor a una estructura tipo árbol

**Verificación práctica:**
Escribe de memoria: (1) Interface Visitor con visit(ElementA), visit(ElementB), (2) Interface Element con accept(Visitor), (3) Implementación de accept() en ElementA que pase `this`. Si fallas en el paso 3, REPASA AHORA.

**Si marcaste menos de 8:** Repasa GUIA_PATRON_VISITOR.md

---

## PARTE 3: SINGLETON PATTERN (10 items)

### ¿Qué es Singleton?

**Definición:**
El patrón Singleton garantiza que una clase tenga UNA SOLA instancia en toda la aplicación y provee un punto de acceso global a esa instancia.

**Tres características obligatorias:**
1. Constructor PRIVADO (nadie puede hacer `new`)
2. Instancia estática PRIVADA (guardada dentro de la clase)
3. Método público getInstance() estático (única forma de obtener la instancia)

**Código de ejemplo - Lazy Initialization:**

```java
public class SistemaBancario {
    // 1. Instancia estática privada
    private static SistemaBancario instance = null;

    // 2. Constructor PRIVADO
    private SistemaBancario() {
        System.out.println("Sistema inicializado");
    }

    // 3. Método público getInstance()
    public static SistemaBancario getInstance() {
        if (instance == null) {
            instance = new SistemaBancario();
        }
        return instance;
    }

    // Métodos normales del sistema
    public void procesar() {
        System.out.println("Procesando...");
    }
}

// Uso en Main
SistemaBancario sistema1 = SistemaBancario.getInstance();
SistemaBancario sistema2 = SistemaBancario.getInstance();

System.out.println(sistema1 == sistema2);  // true - MISMA instancia
```

**Código de ejemplo - Eager Initialization:**

```java
public class ConfiguracionGlobal {
    // Instancia se crea INMEDIATAMENTE al cargar la clase
    private static ConfiguracionGlobal instance = new ConfiguracionGlobal();

    private ConfiguracionGlobal() {
        // Constructor privado
    }

    public static ConfiguracionGlobal getInstance() {
        return instance;  // Ya existe, solo retorna
    }
}
```

**Errores comunes:**

- ERROR FATAL: Constructor PÚBLICO (rompe completamente el patrón)
- NO validar si instance es null en getInstance() (retorna null la primera vez)
- Olvidar hacer getInstance() estático
- Olvidar hacer la instancia estática
- Usar `==` en lugar de equals() para comparar... ESPERA NO, en Singleton SÍ usas `==` para verificar que son la misma instancia
- No inicializar atributos en el constructor privado

**Cuándo usar Singleton:**

USAR SINGLETON cuando:
- Necesitas exactamente UNA instancia (configuración global, sistema central)
- Quieres control centralizado sobre un recurso compartido
- Necesitas acceso global a esa instancia

NO USAR SINGLETON cuando:
- Necesitas múltiples instancias independientes
- Dificulta testing (estado global compartido)
- Crea acoplamiento excesivo

**Lazy vs Eager:**

Lazy (crea cuando se necesita):
```java
private static Singleton instance = null;  // No existe aún
public static Singleton getInstance() {
    if (instance == null) {
        instance = new Singleton();  // Crea cuando se pide
    }
    return instance;
}
```

Eager (crea inmediatamente):
```java
private static Singleton instance = new Singleton();  // Ya existe
public static Singleton getInstance() {
    return instance;  // Solo retorna
}
```

### Conceptos Fundamentales
- [ ] Puedo listar las 3 características de Singleton
- [ ] Sé cuándo usar Singleton apropiadamente
- [ ] Conozco los problemas de Singleton (testing, global state)

### Implementación - Eager Initialization
- [ ] Puedo escribir Singleton con eager initialization
- [ ] Sé por qué eager es thread-safe automáticamente
- [ ] Entiendo cuándo usar eager vs lazy

### Implementación - Thread-Safe
- [ ] Sé hacer Singleton thread-safe con synchronized
- [ ] Conozco double-checked locking
- [ ] Sé por qué necesito `volatile` en double-checked locking
- [ ] Conozco Initialization-on-demand holder

### Casos Especiales
- [ ] Sé cómo hacer Singleton serializable (readResolve)
- [ ] Conozco cómo usar enum para Singleton

**Verificación práctica:**
Escribe de memoria las 3 partes: (1) instancia estática privada, (2) constructor privado, (3) getInstance(). Si olvidas hacer el constructor privado, has FALLADO. Repasa antes del examen.

**Si marcaste menos de 7:** Repasa GUIA_PATRON_SINGLETON.md

---

## PARTE 4: FACTORY PATTERN (8 items)

### Conceptos Fundamentales
- [ ] Puedo explicar qué problema resuelve Factory
- [ ] Sé la diferencia entre Simple Factory y Factory Method
- [ ] Conozco Abstract Factory

### Implementación
- [ ] Puedo crear un método factory estático
- [ ] Sé validar entrada y lanzar excepciones apropiadas
- [ ] Puedo usar switch o if-else para crear objetos
- [ ] NO uso `==` para comparar Strings (uso equals)

### Mejores Prácticas
- [ ] Sé cuándo Factory debe lanzar excepción vs retornar null
- [ ] Puedo usar Map/Registry para factory extensible

**Si marcaste menos de 6:** Repasa ejemplos de Factory

---

## PARTE 5: FILE I/O (12 items)

### ¿Qué es File I/O?

**Definición:**
File I/O (Input/Output) es la capacidad de leer datos desde archivos y escribir datos a archivos. Es OBLIGATORIO en el examen para cargar la flota de vehículos.

**Código de ejemplo - Lectura con try-with-resources:**

```java
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

public class LectorArchivo {
    public void leerArchivo(String rutaArchivo) {
        // try-with-resources - cierra automáticamente
        try (BufferedReader reader = new BufferedReader(
                new FileReader(rutaArchivo, StandardCharsets.UTF_8))) {

            String linea;
            // Patrón estándar de lectura
            while ((linea = reader.readLine()) != null) {
                System.out.println("Leí: " + linea);

                // Parsear CSV
                String[] datos = linea.split(",");
                String codigo = datos[0];
                String nombre = datos[1];
                double precio = Double.parseDouble(datos[2]);
            }

        } catch (FileNotFoundException e) {
            System.out.println("ERROR: Archivo no encontrado");
        } catch (IOException e) {
            System.out.println("ERROR: al leer archivo");
        }
    }
}
```

**Ejemplo archivo fleet.txt (formato del examen):**
```
3
VIN001,Toyota,Camry,Auto,14.5
VIN002,Ford,Explorer,SUV,10.2
VIN003,Chevrolet,Silverado,Camioneta,8.5
VIN001,Normal,120,80,95
VIN002,Sport,200,150
VIN003,Eco,180,90,110,75
```

**Código de ejemplo - Escritura:**

```java
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class EscritorArchivo {
    public void escribirArchivo(String rutaArchivo) {
        try (BufferedWriter writer = new BufferedWriter(
                new FileWriter(rutaArchivo, StandardCharsets.UTF_8))) {

            writer.write("Linea 1");
            writer.newLine();  // IMPORTANTE: nueva línea
            writer.write("Linea 2");
            writer.newLine();

        } catch (IOException e) {
            System.out.println("ERROR: al escribir archivo");
        }
    }
}
```

**Errores comunes:**

- NO usar try-with-resources (olvidas cerrar el archivo → memory leak)
- NO incluir newLine() después de escribir (todo queda en una línea)
- Olvidar importar `java.io.*` y `java.nio.charset.StandardCharsets`
- NO validar que la línea no sea null antes de parsear
- NO manejar FileNotFoundException separado de IOException
- Usar `new FileReader(archivo)` sin especificar charset
- NO validar que el array tiene suficientes elementos después de split()
- Parsear números sin try-catch (NumberFormatException)

**Patrón de lectura estándar del examen:**

```java
try (BufferedReader reader = new BufferedReader(
        new FileReader("fleet.txt", StandardCharsets.UTF_8))) {

    // 1. Leer cantidad de vehículos
    int n = Integer.parseInt(reader.readLine());

    // 2. Leer N vehículos
    for (int i = 0; i < n; i++) {
        String linea = reader.readLine();
        String[] datos = linea.split(",");

        String vin = datos[0];
        String marca = datos[1];
        String modelo = datos[2];
        String tipo = datos[3];
        double eficiencia = Double.parseDouble(datos[4]);

        // Crear vehículo con Factory
        Vehiculo v = VehiculoFactory.crear(tipo, vin, marca, modelo, eficiencia);
        flota.add(v);
    }

    // 3. Leer viajes (cantidad variable de líneas)
    String linea;
    while ((linea = reader.readLine()) != null) {
        String[] datos = linea.split(",");
        String vin = datos[0];
        String modo = datos[1];

        // Resto son distancias
        for (int i = 2; i < datos.length; i++) {
            double distancia = Double.parseDouble(datos[i]);
            // Procesar viaje...
        }
    }

} catch (FileNotFoundException e) {
    System.out.println("ERROR: Archivo fleet.txt no encontrado");
} catch (IOException e) {
    System.out.println("ERROR: al leer archivo");
}
```

### Lectura de Archivos
- [ ] Sé usar BufferedReader para leer archivos
- [ ] Puedo leer línea por línea con readLine()
- [ ] Entiendo el patrón: `while ((line = reader.readLine()) != null)`
- [ ] Sé especificar charset (StandardCharsets.UTF_8)

### Escritura de Archivos
- [ ] Sé usar BufferedWriter para escribir archivos
- [ ] Recuerdo usar newLine() después de cada línea
- [ ] Entiendo append mode vs overwrite mode

### Manejo de Recursos
- [ ] SIEMPRE uso try-with-resources
- [ ] Sé que los recursos se cierran automáticamente
- [ ] Puedo manejar IOException correctamente
- [ ] Sé lanzar vs catchear excepciones

### Casos Especiales
- [ ] Sé manejar FileNotFoundException
- [ ] Puedo validar si un archivo existe antes de leer
- [ ] Conozco Files.exists(), Files.createDirectories()

**Verificación práctica:**
Escribe de memoria el código para leer un archivo línea por línea con try-with-resources. Si olvidas cerrar el archivo automáticamente, REPASA. File I/O es el 20% del examen.

**Si marcaste menos de 9:** Repasa GUIA_FILE_IO.md y Ejercicio 05

---

## PARTE 6: COLLECTIONS & GENERICS (15 items)

### Generics Básicos
- [ ] Puedo crear clase genérica `class Box<T>`
- [ ] Sé usar bounded type parameters `<T extends Comparable<T>>`
- [ ] Entiendo NUNCA usar raw types
- [ ] Sé especificar tipos en constructores: `new ArrayList<>()`

### List
- [ ] Sé cuándo usar ArrayList vs LinkedList
- [ ] Puedo iterar con for-each y con índices
- [ ] Conozco List.of() para listas inmutables
- [ ] Sé usar add(), get(), remove(), size()

### Map
- [ ] Entiendo que Map usa key-value pairs
- [ ] Sé usar put(), get(), containsKey()
- [ ] Puedo iterar con entrySet() o keySet()
- [ ] Conozco getOrDefault()

### Set
- [ ] Sé que Set no permite duplicados
- [ ] Conozco add(), contains(), remove()

### Streams (Java 8+)
- [ ] Puedo usar filter(), map(), collect()
- [ ] Sé usar Collectors.toList()
- [ ] Conozco forEach() para iteración

**Si marcaste menos de 11:** Repasa ejercicios de Collections

---

## PARTE 7: EXCEPTION HANDLING (10 items)

### Conceptos
- [ ] Sé la diferencia entre checked y unchecked exceptions
- [ ] Entiendo cuándo usar try-catch vs throws
- [ ] Conozco finally y cuándo usarlo

### Crear Excepciones
- [ ] Puedo crear excepción personalizada extendiendo Exception
- [ ] Sé crear constructor que acepte mensaje
- [ ] Puedo lanzar excepción con throw new

### Manejo
- [ ] Sé capturar excepciones específicas primero, genéricas después
- [ ] Puedo usar multi-catch: `catch (IOException | SQLException e)`
- [ ] Sé re-lanzar excepciones cuando es apropiado

### Mejores Prácticas
- [ ] NO trago excepciones (catch vacío)
- [ ] Siempre incluyo mensaje descriptivo
- [ ] Prefiero try-with-resources sobre try-finally

**Si marcaste menos de 7:** Repasa manejo de excepciones

---

## PARTE 8: OOP FUNDAMENTALS (12 items)

### Interfaces
- [ ] Sé crear interface con métodos abstractos
- [ ] Puedo implementar interface con `implements`
- [ ] Entiendo que una clase puede implementar múltiples interfaces
- [ ] Sé usar default methods (Java 8+)

### Herencia
- [ ] Puedo extender clase con `extends`
- [ ] Sé usar `super()` para llamar constructor padre
- [ ] Entiendo `@Override` y cuándo usarlo
- [ ] Conozco la diferencia entre extends e implements

### Polimorfismo
- [ ] Entiendo: `Animal a = new Dog();`
- [ ] Sé que se llama al método de la clase real (Dog), no declarada (Animal)
- [ ] Puedo usar instanceof para verificar tipos
- [ ] Entiendo casting: `((Dog) a).dogSpecificMethod()`

### Encapsulación
- [ ] Sé usar private para campos
- [ ] Creo getters/setters apropiados
- [ ] Entiendo cuándo NO crear setter (inmutabilidad)

**Si marcaste menos de 9:** Repasa fundamentos OOP

---

## PARTE 9: CODING BEST PRACTICES (10 items)

### Nombres
- [ ] Uso camelCase para métodos/variables
- [ ] Uso PascalCase para clases/interfaces
- [ ] Uso UPPER_SNAKE_CASE para constantes
- [ ] Nombres son descriptivos y en inglés

### Validaciones
- [ ] Valido parámetros null
- [ ] Valido Strings vacíos
- [ ] Valido números negativos cuando no tienen sentido
- [ ] Lanzo IllegalArgumentException para parámetros inválidos

### Código Limpio
- [ ] Métodos pequeños con responsabilidad única
- [ ] NO tengo código duplicado
- [ ] Uso constantes en lugar de magic numbers
- [ ] Código es legible sin comentarios excesivos

**Si marcaste menos de 7:** Repasa principios de clean code

---

## PARTE 10: ERRORES FATALES A EVITAR (10 items)

### Comparaciones
- [ ] NUNCA uso `==` para comparar Strings (uso equals)
- [ ] NUNCA uso `=` en lugar de `==` en condiciones
- [ ] Pongo constante primero: `"valor".equals(variable)` para evitar NullPointer

### Recursos
- [ ] SIEMPRE uso try-with-resources para archivos
- [ ] NUNCA olvido newLine() al escribir archivos
- [ ] SIEMPRE especifico charset

### Patrones
- [ ] En Strategy: uso `this.field = param`, NO `field = field`
- [ ] En Visitor: accept() llama `visitor.visit(this)`, NO `visitor.visit()`
- [ ] En Singleton: constructor es PRIVADO

### Generics
- [ ] NUNCA uso raw types: `List list` → `List<String> list`
- [ ] Especifico tipo en constructor: `new ArrayList<>()` (diamond operator)

**Si marcaste menos de 8:** Revisa DEBUGGING_CHALLENGES.md

---

## VERIFICACIÓN PRÁCTICA RÁPIDA

### Ejercicio 1: Strategy en 5 minutos
Escribe de memoria (sin ver ejemplos):
- Interface con un método
- Dos clases que implementan
- Context que usa la interface

**¿Pudiste?** Si no, repasa Strategy AHORA.

### Ejercicio 2: Visitor en 5 minutos
Escribe de memoria:
- Interface Visitor con visit(ElementA), visit(ElementB)
- Interface Element con accept(Visitor)
- Implementación de accept() en ElementA

**¿Pudiste?** Si no, repasa Visitor AHORA.

### Ejercicio 3: File I/O en 3 minutos
Escribe de memoria:
- Código para leer todas las líneas de un archivo

**¿Pudiste?** Si no, repasa File I/O AHORA.

---

## SCORECARD FINAL

**Cuenta tus checkmarks:**

- 97-107 (90%+): Excelente preparación
- 86-96 (80-89%): Buena preparación, repasa débiles
- 75-85 (70-79%): Preparación aceptable, REPASA URGENTE
- <75 (<70%): ALERTA - repasa todo el material

**Áreas con <70% de checks:** Estas son tus DEBILIDADES. Enfócate aquí las próximas horas.

---

## PLAN DE ACCIÓN SEGÚN RESULTADO

### Si tienes >3 horas antes del examen:
1. Identifica tus 2 secciones más débiles
2. Repasa las guías correspondientes (30 min c/u)
3. Haz ejercicios relacionados (30 min c/u)
4. Vuelve a hacer este checklist
5. Descansa 15 min antes del examen

### Si tienes 1-3 horas:
1. Identifica tu sección MÁS débil
2. Repasa la guía (20 min)
3. Haz 1-2 mini-challenges (20 min)
4. Repasa flashcards de esa sección (10 min)
5. Lee ERRORES_FATALES_EXAMEN.md (10 min)

### Si tienes <1 hora:
1. Lee ERRORES_FATALES_EXAMEN.md (5 min)
2. Repasa flashcards de tu sección más débil (15 min)
3. Lee CHEAT_SHEET_PATRONES.md (10 min)
4. Respira y confía en tu preparación

---

## RECORDATORIOS FINALES

**Antes de empezar el examen:**
- Lee TODO el enunciado antes de escribir código
- Identifica qué patrón(es) pide
- Planea la estructura antes de codificar
- Deja tiempo para revisar

**Durante el examen:**
- Compila mentalmente cada línea
- Valida null SIEMPRE
- Usa try-with-resources para archivos
- Revisa `==` vs `equals`
- Verifica que accept() pase `this`
- Confirma que Singleton tiene constructor privado

**En los últimos 10 minutos:**
- Busca `==` en lugar de `equals` para Strings
- Busca `=` en lugar de `==` en if
- Verifica imports necesarios
- Confirma que todos los recursos se cierran

**Confía en tu preparación. Has trabajado duro. Lo harás excelente.**
