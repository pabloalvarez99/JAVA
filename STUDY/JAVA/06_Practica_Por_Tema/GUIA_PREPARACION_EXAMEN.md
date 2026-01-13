# Guía de Preparación para Examen POO

Esta guía te ayudará a prepararte estratégicamente para rendir el examen de Programación Orientada a Objetos basándote en exámenes reales.

---

## Estructura del Examen Real

### Distribución de Puntos (100 puntos total, 3 horas)

| Problema | Puntos | Tiempo | Tipo | Conceptos |
|----------|--------|--------|------|-----------|
| **Problema 1** | 20-30 | 30-45 min | Code Tracing / Ruteo | Recursión, POO, state tracking |
| **Problema 2** | 70-80 | 2-2.5 horas | Implementación completa | File I/O, POO, Patrones, Algoritmos |

### Entregables del Problema 2

| Entregable | Puntos | Descripción |
|-----------|--------|-------------|
| Diagrama de Dominio | 10% (7 pts) | Entidades principales y relaciones conceptuales |
| Diagrama de Clases UML | 15% (10-11 pts) | Clases, atributos, métodos, herencia |
| Código Java | 75% (52-53 pts) | Implementación funcional completa |

---

## Problema 1: Code Tracing / Ruteo de Código

### Descripción

Dado un código Java completo, debes:
1. **Predecir la salida** sin ejecutarlo
2. **Rastrear cambios de estado** de objetos línea por línea
3. **Identificar qué líneas** generan cada cambio

### Ejemplos Reales de Exámenes

**Tipo A**: Recursión con Math.pow()
```java
public static double proc(int m, int n) {
    if (m == 0) {
        return Math.pow(10, n-1);
    } else {
        n++;
        return ((m/10), n) + Math.pow(m, n-1);
    }
}
// Pregunta: ¿Qué imprime proc(25, 1)?
```

**Tipo B**: Ruteo con POO (ClubDeYates, Velero)
```java
// Código con clases ClubDeYates, Velero
// Métodos: zarpar(), atracar(), asignarMembresia()
// Pregunta: Rastrear cambios de estado por línea
```

### Estrategia de Resolución (30-45 minutos)

**Minutos 0-5: Lectura sin escribir**
1. Lee el código completo 2 veces
2. No escribas nada aún, solo entiende la estructura
3. Identifica:
   - Clases y sus atributos
   - Métodos y sus parámetros
   - Orden de ejecución en main()

**Minutos 5-10: Preparar tabla de estado**
1. Dibuja tabla para trackear objetos:
```
| Línea | Objeto | Atributo | Valor Anterior | Valor Nuevo | Observaciones |
|-------|--------|----------|----------------|-------------|---------------|
|   3   | vc1    | codigo   | -              | V1          | Constructor   |
|   3   | vc1    | peso     | -              | 2500        | Constructor   |
```

2. Para recursión, usa pila de llamadas:
```
Llamada  | m  | n  | Retorna
---------|----|----|--------
proc(25,1)| 25| 1  | ?
  proc(2,2)| 2| 2  | ?
    proc(0,3)| 0| 3  | 100
```

**Minutos 10-35: Ejecutar mentalmente**
1. Ejecuta línea por línea del main()
2. Para cada línea que modifica estado:
   - Anota en la tabla
   - Calcula nuevos valores
   - Verifica condiciones (if, loops)
3. Para llamadas a métodos:
   - Entra al método
   - Ejecuta su contenido
   - Retorna al llamador

**Minutos 35-45: Verificar y escribir respuesta**
1. Revisa tu tabla completa
2. Verifica cálculos matemáticos
3. Escribe respuesta final limpia
4. Revisa una última vez

### Errores Fatales a Evitar

❌ **Error 1**: Empezar a escribir sin entender el código
- Consecuencia: Confusión, pérdida de tiempo
- Solución: Lee 2 veces primero

❌ **Error 2**: Olvidar que super() se llama primero en constructores
- Consecuencia: Orden incorrecto de inicialización
- Solución: Siempre ejecuta constructor padre primero

❌ **Error 3**: No verificar caso base en recursión
- Consecuencia: Stack overflow mental o cálculo infinito
- Solución: Identifica caso base antes de empezar

❌ **Error 4**: Confundir tipo de compilación vs tipo de ejecución
- Consecuencia: Predicción incorrecta de polimorfismo
- Solución: El método ejecutado depende del tipo REAL del objeto

❌ **Error 5**: Errores aritméticos
- Consecuencia: Resultado final incorrecto
- Solución: Usa calculadora si es necesario, verifica 2 veces

### Ejercicios de Práctica

Practica con estos ejercicios del repositorio:

**Nivel Básico** (⭐⭐⭐)
- `01_Recursion/Tracing/Tracing01_Recursion_Simple.java`
- `02_Herencia/Tracing/Tracing01_Herencia_Constructores.java`

**Nivel Intermedio** (⭐⭐⭐⭐⭐)
- `01_Recursion/Tracing/Tracing02_Recursion_DobleCall.java`
- `02_Herencia/Tracing/Tracing02_Herencia_Polimorfismo.java`
- `03_Colecciones/Tracing/Tracing01_ArrayList_Operations.java`

**Nivel Examen** (⭐⭐⭐⭐⭐⭐⭐)
- `01_Recursion/Tracing/Tracing03_MathPow.java` (REPLICA EXACTA)
- `02_Herencia/Tracing/Tracing03_Herencia_ClubYates.java` (REPLICA EXACTA)
- `04_Patrones_Diseno/Tracing/Tracing01_Strategy_ModoManejo.java`

---

## Problema 2: Implementación Completa

### Descripción

Implementar un sistema completo que incluye:
1. **File I/O**: Leer 1-2 archivos con datos
2. **POO**: Herencia, polimorfismo, encapsulación
3. **Patrones de diseño**: Strategy, Visitor, Singleton o Factory
4. **Lógica de negocio**: Cálculos, validaciones, algoritmos
5. **Diagramas**: Dominio (10%) + Clases UML (15%)

### Ejemplos Reales de Exámenes

**Ejemplo 1: Mapaches Celulares (70 puntos)**
- Leer `mapaches.txt` (6 mapaches: código, nombre, peso)
- Leer `mapaches_posiciones.txt` (matriz 5×5 con posiciones)
- Implementar juego por turnos entre 2 jugadores
- Acciones: Rendirse, Mover, Alimentar, Ver información
- Lógica de batalla entre mapaches
- Condición de victoria: 1 mapache con mayor peso

**Ejemplo 2: RentaCar (70 puntos)**
- Leer `fleet.txt` (vehículos + viajes)
- Herencia: Vehiculo → Auto/SUV/Camioneta
- Strategy: ModoManejo → Eco/Normal/Sport
- Visitor: Calcular consumo total de flota
- Singleton: Sistema único de gestión

### Estrategia de Resolución (2-2.5 horas)

#### Fase 1: Lectura y Comprensión (15 minutos)

**Minutos 0-5: Primera lectura rápida**
- Lee el enunciado completo sin detenerte
- Identifica: ¿Qué sistema debo hacer? ¿Qué archivos leer? ¿Qué calcular?

**Minutos 5-10: Segunda lectura detallada**
- Lee cada requisito con atención
- Marca con colores:
  - 🔵 Azul: Clases principales
  - 🟢 Verde: Relaciones (herencia, composición)
  - 🟡 Amarillo: Cálculos y algoritmos
  - 🔴 Rojo: Patrones de diseño requeridos

**Minutos 10-15: Tercera lectura con preguntas**
- ¿Qué entidades existen? (Mapache, Jugador, Mundo)
- ¿Qué relaciones hay? (Jugador TIENE mapaches, Mundo CONTIENE celdas)
- ¿Qué patrones debo usar? (¿Strategy? ¿Visitor? ¿Singleton?)
- ¿Qué archivos leer y qué formato tienen?
- ¿Qué debe hacer el programa al ejecutarse?

#### Fase 2: Diagrama de Dominio (15 minutos)

**Minutos 15-25: Dibujar en papel**

Identifica entidades principales y relaciones conceptuales:

```
Ejemplo: Mapaches Celulares

┌─────────┐      posee     ┌─────────┐
│ Jugador │───────────────>│ Mapache │
└─────────┘    1      *    └─────────┘
                                |
                           ubicado en
                                |
                                v
┌─────────┐   contiene    ┌─────────┐
│  Mundo  │──────────────>│  Celda  │
└─────────┘    1      *   └─────────┘
```

**Entidades**:
- Jugador (id, nombre, mapaches)
- Mapache (codigo, nombre, peso, posicion)
- Mundo (matriz de celdas, dimensiones)
- Celda (fila, columna, mapache ocupante)

**Relaciones**:
- Jugador POSEE 1..* Mapaches
- Mundo CONTIENE 1..* Celdas
- Mapache UBICADO_EN 1 Celda

#### Fase 3: Diagrama de Clases UML (20 minutos)

**Minutos 25-45: Diseñar estructura completa**

Para cada entidad:
1. **Atributos** (con tipos):
```java
Mapache
---------------------------------
- codigo: int
- nombre: String
- peso: int
- fila: int
- columna: int
---------------------------------
```

2. **Métodos** (con firma completa):
```java
+ Mapache(int codigo, String nombre, int peso)
+ mover(int nuevaFila, int nuevaColumna): void
+ alimentar(int incremento): void
+ getPeso(): int
+ getNombre(): String
```

3. **Relaciones** (flechas):
   - Herencia: flecha hueca (→)
   - Composición: rombo relleno (♦)
   - Agregación: rombo vacío (◇)
   - Asociación: línea simple (─)

**Ejemplo de jerarquía con herencia**:
```
         ┌──────────┐
         │ Vehiculo │ (abstracta)
         └──────────┘
               △
               │
       ┌───────┼───────┐
       │       │       │
   ┌───┴──┐ ┌──┴──┐ ┌──┴────┐
   │ Auto │ │ SUV │ │Camioneta│
   └──────┘ └─────┘ └────────┘
```

**Checklist del diagrama**:
- [ ] Todas las clases identificadas
- [ ] Atributos con tipos (int, String, double, etc.)
- [ ] Métodos con firma completa (tipo retorno, nombre, parámetros)
- [ ] Relaciones dibujadas claramente
- [ ] Multiplicidades indicadas (1, *, 0..1, 1..*)
- [ ] Clases abstractas marcadas (cursiva o <<abstract>>)
- [ ] Interfaces indicadas si hay

#### Fase 4: Identificar Patrones (5 minutos)

**Minutos 45-50: Detectar patrones requeridos**

Pregúntate:

**¿Necesito Strategy?**
- ¿Hay comportamientos que cambian en runtime?
- ¿Hay diferentes "modos" o "algoritmos"?
- Ejemplo: ModoManejo (Eco, Normal, Sport)

**¿Necesito Visitor?**
- ¿Debo realizar operaciones sobre una jerarquía sin modificar las clases?
- ¿Necesito calcular algo agregado de múltiples tipos?
- Ejemplo: Calcular consumo total de Auto + SUV + Camioneta

**¿Necesito Singleton?**
- ¿Hay una clase que debe tener UNA SOLA INSTANCIA?
- ¿Hay un "gestor" o "sistema" central?
- Ejemplo: Sistema, Mundo, ClubDeYates

**¿Necesito Factory?**
- ¿Debo crear objetos sin exponer lógica de creación?
- ¿El tipo de objeto depende de datos leídos?
- Ejemplo: Crear Auto/SUV/Camioneta según archivo

#### Fase 5: Implementación del Código (60 minutos)

**Minutos 50-70: Fase 5a - Clases Base (Herencia)**

1. Crear clase abstracta base:
```java
public abstract class Vehiculo {
    protected String vin;
    protected String marca;
    protected String modelo;

    public Vehiculo(String vin, String marca, String modelo) {
        this.vin = vin;
        this.marca = marca;
        this.modelo = modelo;
    }

    // Método concreto (heredado por todos)
    public String getInfo() {
        return marca + " " + modelo + " (" + vin + ")";
    }

    // Método abstracto (cada subclase implementa)
    public abstract String getCategoria();
}
```

2. Crear subclases concretas:
```java
public class Auto extends Vehiculo {
    public Auto(String vin, String marca, String modelo) {
        super(vin, marca, modelo);
    }

    @Override
    public String getCategoria() {
        return "Auto";
    }
}
```

3. Probar compilación:
```bash
javac Vehiculo.java Auto.java
```

**Minutos 70-90: Fase 5b - File I/O y Parsing**

1. Leer archivo con Scanner:
```java
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.ArrayList;

public class Sistema {
    private ArrayList<Vehiculo> flota;

    public void cargarDesdeArchivo(String rutaArchivo) {
        try {
            Scanner scanner = new Scanner(new File(rutaArchivo));

            // Primera línea: cantidad
            int cantidad = scanner.nextInt();
            scanner.nextLine(); // Consumir salto de línea

            // Leer cada vehículo
            for (int i = 0; i < cantidad; i++) {
                String linea = scanner.nextLine();
                String[] datos = linea.split(",");

                String vin = datos[0];
                String marca = datos[1];
                String modelo = datos[2];
                String categoria = datos[3];

                // Crear vehículo según categoría
                Vehiculo v = null;
                if (categoria.equals("Auto")) {
                    v = new Auto(vin, marca, modelo);
                } else if (categoria.equals("SUV")) {
                    v = new SUV(vin, marca, modelo);
                }

                flota.add(v);
            }

            scanner.close();
        } catch (FileNotFoundException e) {
            System.out.println("Error: archivo no encontrado");
        }
    }
}
```

2. Probar con archivo de ejemplo
3. Imprimir datos leídos para verificar

**Minutos 90-105: Fase 5c - Patrones de Diseño**

**Implementar Strategy**:
```java
// 1. Interfaz
public interface ModoManejo {
    double calcularConsumo(double distancia, double eficiencia);
}

// 2. Implementaciones concretas
public class ModoEco implements ModoManejo {
    @Override
    public double calcularConsumo(double distancia, double eficiencia) {
        return distancia / (eficiencia * 1.2); // 20% más eficiente
    }
}

public class ModoNormal implements ModoManejo {
    @Override
    public double calcularConsumo(double distancia, double eficiencia) {
        return distancia / eficiencia;
    }
}

// 3. Uso en clase
public class Viaje {
    private ModoManejo modo;
    private double distancia;

    public Viaje(ModoManejo modo, double distancia) {
        this.modo = modo;
        this.distancia = distancia;
    }

    public double calcularConsumo(double eficiencia) {
        return modo.calcularConsumo(distancia, eficiencia);
    }
}
```

**Implementar Visitor**:
```java
// 1. Interfaz Visitor
public interface VehicleVisitor {
    void visitAuto(Auto a);
    void visitSUV(SUV s);
    void visitCamioneta(Camioneta c);
}

// 2. Agregar accept() en jerarquía
public abstract class Vehiculo {
    // ... atributos y métodos ...

    public abstract void accept(VehicleVisitor visitor);
}

public class Auto extends Vehiculo {
    @Override
    public void accept(VehicleVisitor visitor) {
        visitor.visitAuto(this);
    }
}

// 3. Implementación concreta de Visitor
public class ConsumoCalculator implements VehicleVisitor {
    private double consumoTotal = 0;

    @Override
    public void visitAuto(Auto a) {
        consumoTotal += a.calcularConsumo();
    }

    @Override
    public void visitSUV(SUV s) {
        consumoTotal += s.calcularConsumo();
    }

    @Override
    public void visitCamioneta(Camioneta c) {
        consumoTotal += c.calcularConsumo();
    }

    public double getConsumoTotal() {
        return consumoTotal;
    }
}

// 4. Uso
ConsumoCalculator calculator = new ConsumoCalculator();
for (Vehiculo v : flota) {
    v.accept(calculator);
}
System.out.println("Consumo total: " + calculator.getConsumoTotal());
```

**Implementar Singleton**:
```java
public class Sistema {
    private static Sistema instancia = null;
    private ArrayList<Vehiculo> flota;

    // Constructor privado
    private Sistema() {
        flota = new ArrayList<>();
    }

    // Método estático para obtener instancia
    public static Sistema getInstance() {
        if (instancia == null) {
            instancia = new Sistema();
        }
        return instancia;
    }

    // Métodos de negocio
    public void agregarVehiculo(Vehiculo v) {
        flota.add(v);
    }
}
```

**Minutos 105-110: Fase 5d - Lógica de Negocio**

Implementar cálculos y algoritmos específicos del problema:

```java
// Ejemplo: Calcular promedio de edad de nodos sin descendientes (árbol)
public double promEdadSinDescendientes() {
    return promEdadSinDescendientesRecursivo(raiz);
}

private double promEdadSinDescendientesRecursivo(Nodo nodo) {
    if (nodo == null) {
        return 0;
    }

    // Nodo sin descendientes (hoja)
    if (nodo.izquierdo == null && nodo.derecho == null) {
        return nodo.persona.getEdad();
    }

    // Nodo con descendientes: calcular promedio de hijos
    double sumaIzq = promEdadSinDescendientesRecursivo(nodo.izquierdo);
    double sumaDer = promEdadSinDescendientesRecursivo(nodo.derecho);

    return (sumaIzq + sumaDer) / 2;
}
```

#### Fase 6: Prueba y Debugging (20 minutos)

**Minutos 110-130: Probar con datos del enunciado**

1. **Compilar todo**:
```bash
javac *.java
```

2. **Ejecutar con datos de ejemplo**:
```bash
java Main
```

3. **Verificar salida esperada**:
   - ¿Los datos se leen correctamente?
   - ¿Los cálculos son correctos?
   - ¿Los patrones funcionan?

4. **Debugging común**:
   - NullPointerException → Olvidaste inicializar objeto
   - FileNotFoundException → Ruta incorrecta
   - ArrayIndexOutOfBoundsException → Split mal usado o archivo con formato incorrecto
   - ClassCastException → Casting incorrecto de polimorfismo

#### Fase 7: Revisión Final (10 minutos)

**Minutos 130-140: Checklist pre-entrega**

- [ ] **Código compila sin errores**
- [ ] **Probado con datos del enunciado**
- [ ] **Patrones requeridos implementados**
- [ ] **File I/O funciona (archivos se leen correctamente)**
- [ ] **Excepciones manejadas (try-catch para FileNotFoundException)**
- [ ] **Diagramas entregados en papel**
- [ ] **Código comentado en partes clave**
- [ ] **Nombre y RUT en todas las hojas**
- [ ] **Archivos empaquetados en .zip** (sin carpetas de IDE)
- [ ] **Sin archivos .class en el .zip** (solo .java)

---

## Timeline Completo de 3 Horas

| Minuto | Actividad | Problema | Acumulado |
|--------|-----------|----------|-----------|
| 0-10 | Leer ambos problemas completos | Ambos | 10 min |
| 10-45 | Resolver Problema 1 (Tracing) | P1 | 45 min |
| 45-60 | Leer P2, comprensión profunda | P2 | 1h 0min |
| 60-75 | Diagrama de dominio | P2 | 1h 15min |
| 75-95 | Diagrama de clases UML | P2 | 1h 35min |
| 95-100 | Identificar patrones | P2 | 1h 40min |
| 100-160 | Implementar código (4 fases) | P2 | 2h 40min |
| 160-170 | Probar y debuggear | P2 | 2h 50min |
| 170-180 | Revisar ambos problemas | Ambos | 3h 0min |

---

## Conceptos Críticos del Examen

### 1. Recursión (muy frecuente - 80% de exámenes)

**Concepto clave**: Siempre definir caso base

```java
// ✅ CORRECTO
public int suma(int n) {
    if (n == 0) return 0;        // Caso base
    return n + suma(n - 1);      // Caso recursivo
}

// ❌ INCORRECTO - falta caso base
public int suma(int n) {
    return n + suma(n - 1);      // Stack overflow!
}
```

**Errores comunes**:
- Olvidar caso base → StackOverflowError
- Caso recursivo no converge al caso base
- Usar Math.pow() incorrectamente: `Math.pow(10, n-1)` NO es `10^(n-1)`

### 2. POO - Herencia y Polimorfismo (90% de exámenes)

**Concepto clave**: Clase abstracta con métodos abstractos + concretos

```java
public abstract class Empleado {
    protected String nombre;
    protected double salarioBase;

    // Método concreto (heredado por todos)
    public String getNombre() {
        return nombre;
    }

    // Método abstracto (cada subclase implementa)
    public abstract double calcularSueldo();
}
```

**Errores comunes**:
- Olvidar super() en constructor de subclase
- No implementar todos los métodos abstractos
- Confundir tipo de compilación vs ejecución en polimorfismo

### 3. File I/O (70% de exámenes)

**Concepto clave**: Scanner + split() + try-catch

```java
try {
    Scanner scanner = new Scanner(new File("datos.txt"));
    int cantidad = scanner.nextInt();
    scanner.nextLine(); // IMPORTANTE: consumir salto de línea

    while (scanner.hasNextLine()) {
        String linea = scanner.nextLine();
        String[] datos = linea.split(",");
        // Procesar datos...
    }

    scanner.close(); // IMPORTANTE: cerrar recurso
} catch (FileNotFoundException e) {
    System.out.println("Error: " + e.getMessage());
}
```

**Errores comunes**:
- No usar scanner.nextLine() después de scanner.nextInt()
- No cerrar Scanner → resource leak
- Split mal usado: `split(" ")` vs `split(",")`
- No manejar FileNotFoundException

### 4. Patrones de Diseño (60% de exámenes)

**Strategy**: Cambiar comportamiento en runtime
```java
interfaz ModoManejo {
    double calcular();
}
// Uso: viaje.setModo(new ModoEco());
```

**Visitor**: Operaciones sobre jerarquía sin modificar clases
```java
interface Visitor {
    void visitAuto(Auto a);
    void visitSUV(SUV s);
}
// Uso: vehiculo.accept(new ConsumoCalculator());
```

**Singleton**: Instancia única
```java
private static Sistema instancia = null;
private Sistema() {}
public static Sistema getInstance() {
    if (instancia == null) instancia = new Sistema();
    return instancia;
}
```

**Errores comunes**:
- Olvidar implementar accept() en Visitor
- Constructor público en Singleton (debe ser privado)
- No usar interfaz en Strategy

### 5. Estructuras de Datos - Árboles (50% de exámenes)

**Concepto clave**: Árbol binario de búsqueda con recursión

```java
class Nodo {
    Persona persona;
    Nodo izquierdo;
    Nodo derecho;
}

public void insertar(Persona p) {
    raiz = insertarRecursivo(raiz, p);
}

private Nodo insertarRecursivo(Nodo nodo, Persona p) {
    if (nodo == null) {
        return new Nodo(p);
    }

    if (p.getRut() < nodo.persona.getRut()) {
        nodo.izquierdo = insertarRecursivo(nodo.izquierdo, p);
    } else {
        nodo.derecho = insertarRecursivo(nodo.derecho, p);
    }

    return nodo;
}
```

**Errores comunes**:
- Olvidar retornar nodo en recursión
- No verificar si nodo es null antes de acceder
- Confundir recorridos: InOrder, PreOrder, PostOrder

---

## Errores Fatales que Cuestan Muchos Puntos

### Error 1: No leer el enunciado completo (pérdida: 20-30 pts)
**Consecuencia**: Implementas sistema incorrecto o sin requisitos clave
**Solución**: Lee 3 veces, marca requisitos con colores

### Error 2: Empezar a codear sin diseñar (pérdida: 10-15 pts + tiempo)
**Consecuencia**: Arquitectura desordenada, necesitas refactorizar todo
**Solución**: Invierte 30-40 minutos en diagramas

### Error 3: No probar con datos del enunciado (pérdida: 15-25 pts)
**Consecuencia**: Errores de lógica no detectados
**Solución**: Deja 20 minutos al final para probar

### Error 4: Olvidar cerrar archivos (pérdida: 5-10 pts)
**Consecuencia**: Resource leak, -puntos en calidad de código
**Solución**: Siempre usa try-finally o try-with-resources

### Error 5: No usar patrones requeridos (pérdida: 20-30 pts)
**Consecuencia**: No cumples requisitos del problema 2
**Solución**: Identifica patrones en minuto 45-50, implementa en fase 5c

### Error 6: Entregar código que no compila (pérdida: TODO)
**Consecuencia**: 0 puntos en código (52-53 pts perdidos)
**Solución**: Compila frecuentemente, prueba antes de entregar

### Error 7: Recursión sin caso base (pérdida: 20 pts en problema 1)
**Consecuencia**: StackOverflowError, respuesta incorrecta
**Solución**: Siempre identifica caso base primero

### Error 8: No manejar excepciones de File I/O (pérdida: código no compila)
**Consecuencia**: Compilador rechaza el código
**Solución**: Siempre usa try-catch para FileNotFoundException

---

## Checklist Pre-Examen

### Conocimientos que DEBES dominar

#### Recursión
- [ ] Escribir caso base correctamente
- [ ] Identificar cuándo usar recursión vs iteración
- [ ] Trazar ejecución de función recursiva con pila de llamadas
- [ ] Usar Math.pow() correctamente

#### POO
- [ ] Diseñar jerarquía de herencia con clase abstracta
- [ ] Distinguir métodos abstractos vs concretos
- [ ] Implementar polimorfismo con ArrayList<ClaseBase>
- [ ] Usar super() en constructores

#### File I/O
- [ ] Leer archivo línea por línea con Scanner
- [ ] Parsear líneas con split(",")
- [ ] Manejar FileNotFoundException con try-catch
- [ ] Cerrar recursos con scanner.close()
- [ ] Consumir salto de línea después de nextInt()

#### Patrones de Diseño
- [ ] Implementar Strategy pattern (interfaz + implementaciones)
- [ ] Implementar Visitor pattern (double dispatch + accept)
- [ ] Implementar Singleton (constructor privado + getInstance)
- [ ] Saber cuándo usar cada patrón

#### Estructuras de Datos
- [ ] Implementar nodo de árbol binario
- [ ] Insertar en árbol binario de búsqueda (recursión)
- [ ] Recorrer árbol con recursión
- [ ] Calcular propiedades de árbol (altura, promedio, etc.)

#### Colecciones
- [ ] Usar ArrayList<Tipo> correctamente
- [ ] Iterar con for-each: `for (Tipo t : lista)`
- [ ] Usar HashMap<K, V> para búsquedas eficientes
- [ ] Override equals() y hashCode() cuando sea necesario

---

## Material de Práctica Recomendado

### Semana 1-2: Fundamentos
- `01_Recursion/` - Ejercicios 1-3 (básicos)
- `02_Herencia/` - Ejercicios 1-2
- `03_Colecciones/` - Ejercicios 1-2

### Semana 3-4: Intermedio
- `01_Recursion/` - Ejercicios 4-5 (avanzados)
- `04_Patrones_Diseno/` - Ejercicios 1-3 (Strategy, Visitor, Singleton)
- `05_File_IO/` - Ejercicios 1-3

### Semana 5-6: Avanzado
- `08_Estructuras_Datos/` - Ejercicios 1-5 (árboles)
- `04_Patrones_Diseno/` - Ejercicios 4-5 (Factory, Observer)
- `05_File_IO/` - Ejercicios 4-5 (parsing complejo)

### Semana 7-8: Réplicas de Exámenes (CRÍTICO)
1. `01_Recursion/Tracing/Tracing03_MathPow.java` (Problema 1 examen)
2. `01_Recursion/Implementacion/Ej03_Palindromo_Recursivo.md` (Problema 3 examen)
3. `01_Recursion/Implementacion/Ej04_Matriz_DivideConquer.md` (Problema 2 examen)
4. `08_Estructuras_Datos/Implementacion/Ej05_Arbol_Promedio_SinDescendientes.md` (Problema 4 examen)
5. `02_Herencia/Tracing/Tracing03_Herencia_ClubYates.java` (Problema 1 examen 2)
6. `05_File_IO/Implementacion/Ej03_Lectura_MultiArchivo_Mapaches.md` (Problema 2 examen 2)

### Semana 9-10: Simulacros Completos
- `09_Examenes_Completos/Examen01_TipoA/` (3 horas cronometradas)
- `09_Examenes_Completos/Examen02_TipoB/` (3 horas cronometradas)
- `09_Examenes_Completos/Examen03_TipoC/` (3 horas cronometradas) - **REPLICA EXACTA**
- `09_Examenes_Completos/Examen04_TipoD/` (3 horas cronometradas)
- `09_Examenes_Completos/Examen05_TipoE/` (3 horas cronometradas)

**Importante**: Simula condiciones reales:
- Sin internet
- Sin consultar apuntes
- Cronómetro de 3 horas
- Solo papel, lápiz y computador

---

## Día del Examen

### Antes del Examen
- [ ] Dormir 8 horas
- [ ] Desayunar bien
- [ ] Llegar 15 minutos antes
- [ ] Llevar: lápiz, goma, calculadora, agua
- [ ] Verificar que el computador funciona

### Durante el Examen
- [ ] Leer ambos problemas completos primero (10 min)
- [ ] Empezar por el más fácil (generalmente Problema 1)
- [ ] No atorarse: si no sabes algo, sigue y vuelve después
- [ ] Verificar compilación frecuentemente
- [ ] Dejar 20 minutos al final para revisión

### Después del Examen
- [ ] No comparar respuestas con compañeros inmediatamente
- [ ] Descansar
- [ ] Revisar qué conceptos debes reforzar para próxima vez

---

**¡Éxito en tu examen! 🎯**

Con práctica sistemática y siguiendo esta guía, estarás bien preparado.
