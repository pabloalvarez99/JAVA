# FLASHCARDS DE REPASO - Conceptos Clave POO

**Objetivo:** Repaso rápido de conceptos fundamentales mediante preguntas y respuestas.

**Tiempo estimado:** 30-45 minutos (completo) o 5-10 minutos (por sección)

**Cuándo usarlo:**
- Día antes del examen (repaso final)
- En transporte/tiempos muertos
- Para validar conocimiento rápidamente
- Antes de hacer ejercicios (warm-up)

**Cómo usarlo:**
1. Lee la pregunta
2. Intenta responder mentalmente
3. Verifica con la respuesta
4. Si fallas, marca para revisar después

---

## SECCIÓN 1: STRATEGY PATTERN (15 flashcards)

### Flashcard 1
**P:** ¿Qué problema resuelve el patrón Strategy?

<details>
<summary>Ver respuesta</summary>

**R:** Permite definir una familia de algoritmos, encapsular cada uno y hacerlos intercambiables. Strategy permite que el algoritmo varíe independientemente de los clientes que lo usan.

**Ejemplo práctico:** Sistema de descuentos donde cada estrategia calcula descuentos de forma diferente (por estudiante, por cantidad, por temporada).
</details>

---

### Flashcard 2
**P:** ¿Cuáles son los 3 componentes principales del patrón Strategy?

<details>
<summary>Ver respuesta</summary>

**R:**
1. **Strategy (Interface):** Define la operación común
2. **ConcreteStrategy (Clases):** Implementan diferentes algoritmos
3. **Context (Clase):** Mantiene referencia a Strategy y delega operaciones

```java
// Strategy
interface DiscountStrategy {
    double applyDiscount(double price);
}

// ConcreteStrategy
class StudentDiscount implements DiscountStrategy {
    public double applyDiscount(double price) {
        return price * 0.8;
    }
}

// Context
class ShoppingCart {
    private DiscountStrategy strategy;
    public void setStrategy(DiscountStrategy strategy) {
        this.strategy = strategy;
    }
}
```
</details>

---

### Flashcard 3
**P:** ¿Cuándo NO deberías usar Strategy?

<details>
<summary>Ver respuesta</summary>

**R:**
- Cuando solo tienes 1-2 algoritmos simples
- Cuando los algoritmos nunca cambian
- Cuando la lógica es trivial (if-else simple)
- Cuando agregar clases complica más que ayuda

**Regla de oro:** Si no hay variación de comportamiento, no necesitas Strategy.
</details>

---

### Flashcard 4
**P:** ¿Cómo se cambia de estrategia en tiempo de ejecución?

<details>
<summary>Ver respuesta</summary>

**R:** Mediante un método setter en el Context:

```java
class Context {
    private Strategy strategy;

    public void setStrategy(Strategy strategy) {
        this.strategy = strategy;
    }

    public void executeStrategy() {
        strategy.execute();
    }
}

// Uso
Context ctx = new Context();
ctx.setStrategy(new StrategyA());
ctx.executeStrategy();  // Usa StrategyA

ctx.setStrategy(new StrategyB());
ctx.executeStrategy();  // Usa StrategyB
```
</details>

---

### Flashcard 5
**P:** ¿Qué ventaja tiene Strategy sobre if-else o switch?

<details>
<summary>Ver respuesta</summary>

**R:**
1. **Open/Closed Principle:** Puedes agregar nuevas estrategias sin modificar código existente
2. **Testeable:** Cada estrategia se puede testear independientemente
3. **Mantenible:** Cada algoritmo está encapsulado en su clase
4. **Reutilizable:** Las estrategias pueden usarse en diferentes contextos

**Ejemplo:**
```java
// ❌ Difícil de mantener
if (type.equals("student")) {
    price *= 0.8;
} else if (type.equals("senior")) {
    price *= 0.7;
} else if (type.equals("employee")) {
    price *= 0.85;
}

// ✅ Fácil de extender
strategy.applyDiscount(price);
```
</details>

---

### Flashcard 6
**P:** ¿Es obligatorio que Strategy sea una interface? ¿Puede ser clase abstracta?

<details>
<summary>Ver respuesta</summary>

**R:** Puede ser clase abstracta si:
- Hay comportamiento común entre estrategias
- Quieres proveer implementación por defecto
- Necesitas campos compartidos

**Ejemplo válido:**
```java
abstract class PaymentStrategy {
    protected String transactionId;

    public abstract boolean pay(double amount);

    protected void logTransaction() {
        System.out.println("Transaction: " + transactionId);
    }
}
```

**Pero:** Interface es más común y flexible (una clase puede implementar múltiples interfaces).
</details>

---

### Flashcard 7
**P:** ¿Cómo validar que una estrategia no sea null?

<details>
<summary>Ver respuesta</summary>

**R:** Opciones:

**Opción 1 - Validar en setter:**
```java
public void setStrategy(Strategy strategy) {
    if (strategy == null) {
        throw new IllegalArgumentException("Strategy cannot be null");
    }
    this.strategy = strategy;
}
```

**Opción 2 - Validar antes de usar:**
```java
public void execute() {
    if (strategy == null) {
        throw new IllegalStateException("Strategy not set");
    }
    strategy.doSomething();
}
```

**Opción 3 - Requerir en constructor:**
```java
public Context(Strategy strategy) {
    if (strategy == null) {
        throw new IllegalArgumentException("Strategy required");
    }
    this.strategy = strategy;
}
```
</details>

---

### Flashcard 8
**P:** ¿Puede una estrategia tener estado (atributos)?

<details>
<summary>Ver respuesta</summary>

**R:** Sí, puede tener estado.

**Ejemplo válido:**
```java
class PercentageDiscount implements DiscountStrategy {
    private double percentage;

    public PercentageDiscount(double percentage) {
        this.percentage = percentage;
    }

    public double applyDiscount(double price) {
        return price * (1 - percentage);
    }
}

// Uso
new PercentageDiscount(0.2);  // 20% descuento
new PercentageDiscount(0.3);  // 30% descuento
```

**Cuidado:** Si tiene estado mutable, puede no ser thread-safe.
</details>

---

### Flashcard 9
**P:** ¿Strategy viola el principio de encapsulación?

<details>
<summary>Ver respuesta</summary>

**R:** Puede violarlo si la estrategia necesita acceder a datos privados del Context.

**Soluciones:**
1. Pasar datos como parámetros al método
2. Proveer getters en Context
3. Mover datos relacionados a la estrategia

```java
// ✅ Buena práctica - pasar lo necesario
interface TaxStrategy {
    double calculateTax(double price, String region);
}

// Context solo pasa datos, no expone estructura interna
```
</details>

---

### Flashcard 10
**P:** ¿Puedes tener una estrategia por defecto?

<details>
<summary>Ver respuesta</summary>

**R:** Sí, es buena práctica:

```java
class Context {
    private Strategy strategy = new DefaultStrategy();

    public void setStrategy(Strategy strategy) {
        this.strategy = strategy;
    }
}
```

O usar Null Object Pattern:
```java
class NoOpStrategy implements Strategy {
    public void execute() {
        // No hace nada
    }
}
```
</details>

---

### Flashcard 11
**P:** ¿Cómo se diferencia Strategy de State pattern?

<details>
<summary>Ver respuesta</summary>

**R:**

**Strategy:**
- El cliente elige qué estrategia usar
- Las estrategias son intercambiables
- Se usa para algoritmos variables
- No hay transiciones entre estrategias

**State:**
- El Context cambia de estado según su lógica interna
- Los estados representan diferentes comportamientos según el estado del objeto
- Hay transiciones automáticas entre estados
- El cliente no elige el estado directamente

```java
// Strategy - cliente elige
cart.setStrategy(new StudentDiscount());

// State - objeto cambia solo
door.open();  // Door cambia de ClosedState a OpenState internamente
```
</details>

---

### Flashcard 12
**P:** ¿Puede Context tener múltiples estrategias?

<details>
<summary>Ver respuesta</summary>

**R:** Sí, si necesitas diferentes tipos de comportamiento:

```java
class ShoppingCart {
    private DiscountStrategy discountStrategy;
    private TaxStrategy taxStrategy;
    private ShippingStrategy shippingStrategy;

    public double calculateTotal(double basePrice) {
        double afterDiscount = discountStrategy.apply(basePrice);
        double withTax = taxStrategy.apply(afterDiscount);
        double withShipping = shippingStrategy.apply(withTax);
        return withShipping;
    }
}
```
</details>

---

### Flashcard 13
**P:** ¿Qué pasa si llamas al método de estrategia sin haberla establecido?

<details>
<summary>Ver respuesta</summary>

**R:** NullPointerException

**Prevención:**
```java
public void execute() {
    if (strategy == null) {
        throw new IllegalStateException("Strategy must be set before execution");
    }
    strategy.doWork();
}
```

**Mejor:** Requerir estrategia en constructor:
```java
public Context(Strategy strategy) {
    if (strategy == null) {
        throw new IllegalArgumentException("Strategy cannot be null");
    }
    this.strategy = strategy;
}
```
</details>

---

### Flashcard 14
**P:** ¿Las estrategias deberían conocerse entre sí?

<details>
<summary>Ver respuesta</summary>

**R:** NO. Cada estrategia debe ser independiente.

**❌ Mal diseño:**
```java
class StrategyA implements Strategy {
    private StrategyB otherStrategy;  // ¡No!
}
```

**✅ Buen diseño:**
- Cada estrategia es autónoma
- No dependen entre sí
- Se pueden combinar pero no se conocen

Si necesitas combinar estrategias, usa Composite o Decorator.
</details>

---

### Flashcard 15
**P:** ¿Cómo testas el patrón Strategy?

<details>
<summary>Ver respuesta</summary>

**R:**

**Test de estrategias individuales:**
```java
@Test
public void testStudentDiscount() {
    DiscountStrategy strategy = new StudentDiscount();
    assertEquals(80.0, strategy.apply(100.0), 0.01);
}
```

**Test del Context:**
```java
@Test
public void testContextWithStrategy() {
    Context ctx = new Context();
    ctx.setStrategy(new MockStrategy());
    ctx.execute();
    // Verificar comportamiento
}
```

**Test de cambio de estrategia:**
```java
@Test
public void testStrategyChange() {
    Context ctx = new Context();
    ctx.setStrategy(new StrategyA());
    assertEquals(resultA, ctx.execute());

    ctx.setStrategy(new StrategyB());
    assertEquals(resultB, ctx.execute());
}
```
</details>

---

## SECCIÓN 2: VISITOR PATTERN (15 flashcards)

### Flashcard 16
**P:** ¿Qué problema resuelve el patrón Visitor?

<details>
<summary>Ver respuesta</summary>

**R:** Permite agregar nuevas operaciones a una estructura de objetos sin modificar las clases de esos objetos.

**Problema que resuelve:**
- Tienes una estructura de objetos (jerarquía de clases)
- Necesitas realizar diferentes operaciones sobre esos objetos
- No quieres contaminar las clases con múltiples métodos no relacionados

**Ejemplo:** Procesar documentos PDF, Word, Excel con operaciones de imprimir, exportar, comprimir sin agregar estos métodos a cada clase de documento.
</details>

---

### Flashcard 17
**P:** ¿Qué es el "double dispatch" en Visitor?

<details>
<summary>Ver respuesta</summary>

**R:** Es el mecanismo que permite que la operación ejecutada dependa tanto del tipo del Visitor como del tipo del elemento visitado.

**Funcionamiento:**
1. Cliente llama: `element.accept(visitor)`
2. Element determina su tipo y llama: `visitor.visit(this)`
3. Visitor ejecuta el método específico para ese tipo

```java
// Primera dispatch: según el elemento
pdfDoc.accept(printer);  // PDFDocument

// Segunda dispatch: según el tipo concreto del elemento
public void accept(Visitor v) {
    v.visit(this);  // this es PDFDocument, llama visit(PDFDocument)
}
```

Por eso "double" - dos niveles de polimorfismo.
</details>

---

### Flashcard 18
**P:** ¿Cuáles son los componentes del patrón Visitor?

<details>
<summary>Ver respuesta</summary>

**R:**

1. **Visitor (Interface):** Declara visit() para cada tipo de elemento
2. **ConcreteVisitor:** Implementa operaciones específicas
3. **Element (Interface):** Declara accept(Visitor)
4. **ConcreteElement:** Implementa accept() llamando a visit()
5. **ObjectStructure:** Colección de elementos que se pueden visitar

```java
// Visitor
interface Visitor {
    void visit(ElementA a);
    void visit(ElementB b);
}

// Element
interface Element {
    void accept(Visitor v);
}

// ConcreteElement
class ElementA implements Element {
    public void accept(Visitor v) {
        v.visit(this);
    }
}
```
</details>

---

### Flashcard 19
**P:** ¿Cuándo NO deberías usar Visitor?

<details>
<summary>Ver respuesta</summary>

**R:**

**No usar cuando:**
- La jerarquía de elementos cambia frecuentemente (cada nuevo elemento requiere modificar todos los Visitors)
- Solo tienes 1-2 operaciones (no vale la complejidad)
- Los elementos no tienen estructura estable
- Las operaciones están muy acopladas a la estructura interna de los elementos

**Usar cuando:**
- Estructura de objetos es estable
- Necesitas agregar muchas operaciones nuevas
- Las operaciones no están relacionadas entre sí
- Quieres mantener operaciones relacionadas juntas
</details>

---

### Flashcard 20
**P:** ¿Qué debe retornar el método accept()?

<details>
<summary>Ver respuesta</summary>

**R:** Típicamente void, pero puede retornar un valor si el Visitor lo genera:

**Opción 1 - Void (común):**
```java
public void accept(Visitor v) {
    v.visit(this);
}
```

**Opción 2 - Con retorno:**
```java
public <T> T accept(Visitor<T> v) {
    return v.visit(this);
}

interface Visitor<T> {
    T visit(ElementA a);
    T visit(ElementB b);
}
```

**Ejemplo de uso con retorno:**
```java
// Visitor que calcula área
Double area = shape.accept(areaCalculator);
```
</details>

---

### Flashcard 21
**P:** ¿Puede un Visitor tener estado?

<details>
<summary>Ver respuesta</summary>

**R:** Sí, y es común:

```java
class SumVisitor implements Visitor {
    private double total = 0;

    @Override
    public void visit(Product p) {
        total += p.getPrice();
    }

    @Override
    public void visit(Service s) {
        total += s.getCost();
    }

    public double getTotal() {
        return total;
    }
}

// Uso
SumVisitor sum = new SumVisitor();
for (Item item : items) {
    item.accept(sum);
}
System.out.println("Total: " + sum.getTotal());
```

**Cuidado:** Si reutilizas el visitor, resetea el estado.
</details>

---

### Flashcard 22
**P:** ¿Qué pasa si agregas un nuevo tipo de elemento?

<details>
<summary>Ver respuesta</summary>

**R:** Debes modificar TODOS los Visitors existentes.

**Ejemplo:**
```java
// Antes
interface Visitor {
    void visit(PDF pdf);
    void visit(Word word);
}

// Agregar nuevo elemento Excel
interface Visitor {
    void visit(PDF pdf);
    void visit(Word word);
    void visit(Excel excel);  // ¡Todos los visitors deben implementar esto!
}
```

**Por eso:** Visitor funciona bien cuando la estructura es estable pero las operaciones cambian frecuentemente.

**Solución parcial:** Default methods en Java 8+
```java
default void visit(Excel excel) {
    // Comportamiento por defecto
}
```
</details>

---

### Flashcard 23
**P:** ¿Cómo manejas jerarquías profundas con Visitor?

<details>
<summary>Ver respuesta</summary>

**R:** Tienes dos opciones:

**Opción 1 - Visitor para cada nivel:**
```java
interface Visitor {
    void visit(Animal a);
    void visit(Dog d);
    void visit(Cat c);
    void visit(GoldenRetriever gr);
}
```
Problema: Explotan los métodos visit()

**Opción 2 - Visitor solo para clases concretas:**
```java
interface Visitor {
    void visit(GoldenRetriever gr);
    void visit(Poodle p);
    void visit(Siamese s);
}
```
Mejor: Solo las hojas de la jerarquía

**Opción 3 - Visitor por nivel de abstracción:**
```java
interface Visitor {
    void visit(Dog d);
    void visit(Cat c);
}
```
Más balanceado.
</details>

---

### Flashcard 24
**P:** ¿Visitor viola el principio de encapsulación?

<details>
<summary>Ver respuesta</summary>

**R:** Puede violarlo si el Visitor necesita acceder a datos privados del elemento.

**Soluciones:**

**1. Proveer getters públicos:**
```java
class Employee {
    private double salary;

    public double getSalary() {
        return salary;
    }
}

class SalaryVisitor {
    public void visit(Employee e) {
        double sal = e.getSalary();  // Usa getter
    }
}
```

**2. Métodos específicos para el visitor:**
```java
class Employee {
    private double salary;

    public void acceptSalaryCalculation(SalaryVisitor v) {
        v.processSalary(this.salary);  // Pasa dato privado
    }
}
```

**Trade-off:** Visitor prioriza separación de operaciones sobre encapsulación perfecta.
</details>

---

### Flashcard 25
**P:** ¿Puede un elemento aceptar múltiples visitors simultáneamente?

<details>
<summary>Ver respuesta</summary>

**R:** Sí, los elementos no mantienen estado del visitor:

```java
List<Employee> employees = getEmployees();

SalaryVisitor salaryCalc = new SalaryVisitor();
TaxVisitor taxCalc = new TaxVisitor();
ReportVisitor reporter = new ReportVisitor();

for (Employee emp : employees) {
    emp.accept(salaryCalc);
    emp.accept(taxCalc);
    emp.accept(reporter);
}
```

Cada visitor opera independientemente.
</details>

---

### Flashcard 26
**P:** ¿Cómo recorres una estructura con Visitor?

<details>
<summary>Ver respuesta</summary>

**R:** Tienes dos opciones:

**Opción 1 - El visitor recorre:**
```java
class TreeVisitor {
    public void visit(Node node) {
        processNode(node);
        for (Node child : node.getChildren()) {
            child.accept(this);  // Recursivo
        }
    }
}
```

**Opción 2 - El elemento recorre:**
```java
class Node {
    public void accept(Visitor v) {
        v.visit(this);
        for (Node child : children) {
            child.accept(v);  // Cada hijo se visita
        }
    }
}
```

**Opción 2 es más común:** El elemento controla su estructura.
</details>

---

### Flashcard 27
**P:** ¿Visitor funciona con Composite pattern?

<details>
<summary>Ver respuesta</summary>

**R:** Sí, son muy complementarios:

```java
// Composite
interface Component {
    void accept(Visitor v);
}

class Composite implements Component {
    private List<Component> children;

    public void accept(Visitor v) {
        v.visit(this);
        for (Component child : children) {
            child.accept(v);  // Visita estructura completa
        }
    }
}

class Leaf implements Component {
    public void accept(Visitor v) {
        v.visit(this);
    }
}
```

Visitor permite operaciones sobre toda la estructura Composite.
</details>

---

### Flashcard 28
**P:** ¿Qué es mejor: instanceof o Visitor?

<details>
<summary>Ver respuesta</summary>

**R:**

**❌ instanceof (anti-pattern):**
```java
if (element instanceof TypeA) {
    ((TypeA) element).specificMethod();
} else if (element instanceof TypeB) {
    ((TypeB) element).otherMethod();
}
```
Problemas: No extensible, viola OCP, propenso a errores

**✅ Visitor:**
```java
element.accept(visitor);
```
Ventajas: Extensible, type-safe, polimórfico

**Cuándo instanceof es aceptable:**
- Casos muy simples (1-2 tipos)
- Código de infraestructura/framework
- Cuando agregar accept() no es posible (clases de biblioteca)
</details>

---

### Flashcard 29
**P:** ¿Cómo testas el patrón Visitor?

<details>
<summary>Ver respuesta</summary>

**R:**

**Test del Visitor:**
```java
@Test
public void testPrintVisitor() {
    PrintVisitor visitor = new PrintVisitor();
    PDFDocument pdf = new PDFDocument("content");

    pdf.accept(visitor);

    // Verificar que imprimió correctamente
}
```

**Test de elementos:**
```java
@Test
public void testElementAccept() {
    MockVisitor visitor = new MockVisitor();
    Element element = new ConcreteElement();

    element.accept(visitor);

    assertTrue(visitor.wasVisitCalled());
    assertEquals(element, visitor.getVisitedElement());
}
```

**Test de estructura completa:**
```java
@Test
public void testVisitorOnStructure() {
    CountVisitor counter = new CountVisitor();

    for (Element e : structure) {
        e.accept(counter);
    }

    assertEquals(expectedCount, counter.getCount());
}
```
</details>

---

### Flashcard 30
**P:** ¿Puede un Visitor modificar el elemento visitado?

<details>
<summary>Ver respuesta</summary>

**R:** Sí, pero con cuidado:

**Modificación permitida:**
```java
class UpdateVisitor implements Visitor {
    public void visit(Employee emp) {
        emp.setSalary(emp.getSalary() * 1.1);  // Aumenta 10%
    }
}
```

**Cuidados:**
- Documenta que el visitor modifica
- Considera thread-safety
- Puede ser confuso (visitors normalmente solo leen)

**Alternativa - retornar nuevo objeto:**
```java
interface Visitor<T> {
    T visit(Employee emp);
}

class CopyVisitor implements Visitor<Employee> {
    public Employee visit(Employee emp) {
        return new Employee(emp.getName(), emp.getSalary() * 1.1);
    }
}
```
</details>

---

## SECCIÓN 3: SINGLETON PATTERN (10 flashcards)

### Flashcard 31
**P:** ¿Cuáles son las 3 características clave de Singleton?

<details>
<summary>Ver respuesta</summary>

**R:**
1. **Constructor privado:** Nadie puede crear instancias con `new`
2. **Instancia estática privada:** Solo una instancia existe
3. **Método getInstance() público:** Provee acceso global a la instancia

```java
public class Singleton {
    private static Singleton instance;

    private Singleton() { }  // 1

    public static Singleton getInstance() {  // 3
        if (instance == null) {
            instance = new Singleton();
        }
        return instance;  // 2
    }
}
```
</details>

---

### Flashcard 32
**P:** ¿Cuál es la diferencia entre eager y lazy initialization?

<details>
<summary>Ver respuesta</summary>

**R:**

**Eager (ansiosa) - crea al inicio:**
```java
public class Singleton {
    private static final Singleton INSTANCE = new Singleton();

    private Singleton() { }

    public static Singleton getInstance() {
        return INSTANCE;
    }
}
```
- Ventaja: Thread-safe automáticamente
- Desventaja: Se crea aunque no se use

**Lazy (perezosa) - crea cuando se necesita:**
```java
public class Singleton {
    private static Singleton instance;

    private Singleton() { }

    public static Singleton getInstance() {
        if (instance == null) {
            instance = new Singleton();
        }
        return instance;
    }
}
```
- Ventaja: Solo se crea si se usa
- Desventaja: No es thread-safe (necesita sincronización)
</details>

---

### Flashcard 33
**P:** ¿Cómo haces Singleton thread-safe?

<details>
<summary>Ver respuesta</summary>

**R:** Tres opciones principales:

**Opción 1 - Synchronized method:**
```java
public static synchronized Singleton getInstance() {
    if (instance == null) {
        instance = new Singleton();
    }
    return instance;
}
```
Problema: Lento (sincroniza siempre)

**Opción 2 - Double-checked locking:**
```java
private static volatile Singleton instance;

public static Singleton getInstance() {
    if (instance == null) {
        synchronized (Singleton.class) {
            if (instance == null) {
                instance = new Singleton();
            }
        }
    }
    return instance;
}
```
Mejor: Solo sincroniza la primera vez

**Opción 3 - Eager initialization:**
```java
private static final Singleton INSTANCE = new Singleton();
```
Más simple y thread-safe automáticamente
</details>

---

### Flashcard 34
**P:** ¿Por qué necesitas `volatile` en double-checked locking?

<details>
<summary>Ver respuesta</summary>

**R:** Para prevenir problemas de reordenamiento de instrucciones.

**Sin volatile:**
1. Thread A crea instancia
2. Thread B ve instancia != null ANTES de que esté completamente inicializada
3. Thread B usa instancia parcialmente construida (ERROR)

**Con volatile:**
- Garantiza que todos los threads ven la instancia completamente inicializada
- Previene reordenamiento de instrucciones
- Asegura visibilidad de cambios entre threads

```java
// ✅ Correcto
private static volatile Singleton instance;

// ❌ Incorrecto (puede fallar en multi-threading)
private static Singleton instance;
```
</details>

---

### Flashcard 35
**P:** ¿Puede Singleton tener subclases?

<details>
<summary>Ver respuesta</summary>

**R:** No de forma directa, pero hay técnicas:

**Problema - constructor privado previene herencia:**
```java
public class Singleton {
    private Singleton() { }  // ❌ No se puede extender
}
```

**Solución 1 - Constructor protected:**
```java
public class Singleton {
    protected Singleton() { }  // Permite subclases
}
```
Pero pierde garantía de instancia única

**Solución 2 - Registry of Singletons:**
```java
public class SingletonRegistry {
    private static Map<Class, Object> instances = new HashMap<>();

    public static <T> T getInstance(Class<T> clazz) {
        if (!instances.containsKey(clazz)) {
            // Crear instancia de la clase específica
        }
        return (T) instances.get(clazz);
    }
}
```

**En general:** Singleton + herencia = mala combinación
</details>

---

### Flashcard 36
**P:** ¿Qué problemas tiene Singleton para testing?

<details>
<summary>Ver respuesta</summary>

**R:**

**Problemas:**
1. **Estado global persistente** entre tests
2. **Difícil de mockear** (instancia única)
3. **Acoplamiento fuerte** (hard-coded dependencies)
4. **Tests no aislados** (un test afecta a otros)

**Soluciones:**

**1. Reset entre tests:**
```java
public class Singleton {
    public static void reset() {  // Solo para testing
        instance = null;
    }
}
```

**2. Inyección de dependencias:**
```java
// En lugar de:
DatabaseConnection db = DatabaseConnection.getInstance();

// Mejor:
class Service {
    private DatabaseConnection db;

    public Service(DatabaseConnection db) {
        this.db = db;
    }
}
```

**3. Usar interface:**
```java
interface Connection {
    void connect();
}

class DatabaseConnection implements Connection {
    // Singleton implementation
}

// En tests: usa mock de Connection
```
</details>

---

### Flashcard 37
**P:** ¿Cuándo NO deberías usar Singleton?

<details>
<summary>Ver respuesta</summary>

**R:**

**No usar cuando:**
- Necesitas múltiples instancias en el futuro
- La clase tiene estado mutable que varía
- Dificulta el testing
- Solo lo usas para "organizar código" (usa clase con métodos estáticos)
- Es solo para evitar pasar parámetros

**Anti-pattern común:**
```java
// ❌ No es buen uso de Singleton
class Utils {
    private static Utils instance;
    public void helperMethod() { }
}

// ✅ Mejor: métodos estáticos
class Utils {
    public static void helperMethod() { }
}
```

**Usar Singleton solo cuando:**
- Genuinamente necesitas UNA sola instancia (conexión BD, configuración, logger)
- El recurso debe ser compartido globalmente
- Crear múltiples instancias causaría problemas
</details>

---

### Flashcard 38
**P:** ¿Puede Singleton ser serializable?

<details>
<summary>Ver respuesta</summary>

**R:** Sí, pero requiere código especial:

**Problema - deserializar crea nueva instancia:**
```java
class Singleton implements Serializable {
    // ... código normal singleton
}

// ❌ Esto crea SEGUNDA instancia al deserializar
```

**Solución - readResolve():**
```java
public class Singleton implements Serializable {
    private static final Singleton INSTANCE = new Singleton();

    private Singleton() { }

    public static Singleton getInstance() {
        return INSTANCE;
    }

    // ✅ Previene creación de nueva instancia al deserializar
    protected Object readResolve() {
        return INSTANCE;
    }
}
```

`readResolve()` reemplaza el objeto deserializado con la instancia única.
</details>

---

### Flashcard 39
**P:** ¿Qué es "Initialization-on-demand holder"?

<details>
<summary>Ver respuesta</summary>

**R:** Una técnica thread-safe que usa lazy initialization sin synchronized:

```java
public class Singleton {
    private Singleton() { }

    private static class Holder {
        private static final Singleton INSTANCE = new Singleton();
    }

    public static Singleton getInstance() {
        return Holder.INSTANCE;
    }
}
```

**Ventajas:**
- Thread-safe (JVM garantiza inicialización única de clases)
- Lazy (Holder se carga solo cuando se llama getInstance())
- Sin synchronized (mejor performance)
- Simple y elegante

**Funciona por:** ClassLoader garantiza que la clase interna solo se carga una vez, thread-safe.
</details>

---

### Flashcard 40
**P:** ¿Puede Reflection romper Singleton?

<details>
<summary>Ver respuesta</summary>

**R:** Sí, Reflection puede crear segunda instancia:

**Ataque con Reflection:**
```java
Constructor<Singleton> constructor = Singleton.class.getDeclaredConstructor();
constructor.setAccessible(true);
Singleton secondInstance = constructor.newInstance();  // ❌ Segunda instancia!
```

**Defensa:**
```java
public class Singleton {
    private static final Singleton INSTANCE = new Singleton();

    private Singleton() {
        if (INSTANCE != null) {
            throw new IllegalStateException("Instance already created");
        }
    }

    public static Singleton getInstance() {
        return INSTANCE;
    }
}
```

**Mejor defensa - usar Enum:**
```java
public enum Singleton {
    INSTANCE;

    public void doSomething() {
        // ...
    }
}
```
Enums son inmunes a Reflection y Serialization.
</details>

---

## SECCIÓN 4: FACTORY PATTERN (10 flashcards)

### Flashcard 41
**P:** ¿Qué problema resuelve Factory Pattern?

<details>
<summary>Ver respuesta</summary>

**R:** Encapsula la creación de objetos, separando la lógica de creación del código cliente.

**Problemas que resuelve:**
1. Cliente no debe conocer clases concretas
2. Lógica de creación compleja centralizada
3. Facilita cambiar tipos de objetos creados
4. Cumple Open/Closed Principle

**Sin Factory:**
```java
// ❌ Cliente acoplado a clases concretas
if (type.equals("car")) {
    return new Car();
} else if (type.equals("truck")) {
    return new Truck();
}
```

**Con Factory:**
```java
// ✅ Cliente solo conoce la factory
Vehicle v = VehicleFactory.createVehicle(type);
```
</details>

---

### Flashcard 42
**P:** ¿Cuál es la diferencia entre Simple Factory y Factory Method?

<details>
<summary>Ver respuesta</summary>

**R:**

**Simple Factory (no es patrón GoF oficial):**
```java
class VehicleFactory {
    public static Vehicle create(String type) {
        switch (type) {
            case "car": return new Car();
            case "truck": return new Truck();
            default: throw new IllegalArgumentException();
        }
    }
}
```
- Un método estático
- Viola Open/Closed (modificas para agregar tipos)

**Factory Method (patrón GoF):**
```java
abstract class VehicleFactory {
    public abstract Vehicle createVehicle();

    public void deliverVehicle() {
        Vehicle v = createVehicle();  // Template Method
        v.deliver();
    }
}

class CarFactory extends VehicleFactory {
    public Vehicle createVehicle() {
        return new Car();
    }
}
```
- Método abstracto sobrescrito en subclases
- Cumple Open/Closed (extiendes para agregar tipos)
- Más flexible pero más complejo
</details>

---

### Flashcard 43
**P:** ¿Factory debe lanzar excepción o retornar null si el tipo es inválido?

<details>
<summary>Ver respuesta</summary>

**R:** Lanzar excepción es mejor práctica:

**❌ Retornar null:**
```java
public Vehicle create(String type) {
    if (type.equals("car")) return new Car();
    return null;  // Cliente debe validar null
}

// Cliente
Vehicle v = factory.create("invalid");
v.start();  // NullPointerException!
```

**✅ Lanzar excepción:**
```java
public Vehicle create(String type) {
    if (type.equals("car")) return new Car();
    throw new IllegalArgumentException("Unknown type: " + type);
}

// Cliente
try {
    Vehicle v = factory.create("invalid");
} catch (IllegalArgumentException e) {
    // Manejo explícito del error
}
```

**Ventajas de excepción:**
- Falla rápido (fail-fast)
- Error explícito
- No permite código defectuoso continuar
</details>

---

### Flashcard 44
**P:** ¿Puede Factory crear objetos de diferentes jerarquías?

<details>
<summary>Ver respuesta</summary>

**R:** Sí, se llama Abstract Factory:

**Simple Factory - una jerarquía:**
```java
interface Vehicle { }
class Car implements Vehicle { }
class Truck implements Vehicle { }
```

**Abstract Factory - múltiples jerarquías:**
```java
interface GUIFactory {
    Button createButton();
    TextField createTextField();
}

class WindowsFactory implements GUIFactory {
    public Button createButton() { return new WindowsButton(); }
    public TextField createTextField() { return new WindowsTextField(); }
}

class MacFactory implements GUIFactory {
    public Button createButton() { return new MacButton(); }
    public TextField createTextField() { return new MacTextField(); }
}
```

Crea familias de objetos relacionados.
</details>

---

### Flashcard 45
**P:** ¿Factory debe ser Singleton?

<details>
<summary>Ver respuesta</summary>

**R:** Depende del caso:

**Factory SIN estado - puede ser Singleton:**
```java
public class VehicleFactory {
    private static final VehicleFactory INSTANCE = new VehicleFactory();

    private VehicleFactory() { }

    public static VehicleFactory getInstance() {
        return INSTANCE;
    }

    public Vehicle create(String type) {
        // Lógica sin estado
    }
}
```

**Factory CON estado - NO debería ser Singleton:**
```java
public class VehicleFactory {
    private int vehiclesCreated = 0;  // Estado

    public Vehicle create(String type) {
        vehiclesCreated++;
        // ...
    }
}
```

**Alternativa - métodos estáticos:**
```java
public class VehicleFactory {
    public static Vehicle create(String type) {
        // Sin necesidad de instancia
    }
}
```
</details>

---

### Flashcard 46
**P:** ¿Cómo registras nuevos tipos en Factory sin modificar código?

<details>
<summary>Ver respuesta</summary>

**R:** Usa un registro (registry/map):

```java
public class VehicleFactory {
    private Map<String, Supplier<Vehicle>> registry = new HashMap<>();

    public void register(String type, Supplier<Vehicle> creator) {
        registry.put(type, creator);
    }

    public Vehicle create(String type) {
        Supplier<Vehicle> creator = registry.get(type);
        if (creator == null) {
            throw new IllegalArgumentException("Unknown type: " + type);
        }
        return creator.get();
    }
}

// Uso
VehicleFactory factory = new VehicleFactory();
factory.register("car", Car::new);
factory.register("truck", Truck::new);
factory.register("motorcycle", Motorcycle::new);

Vehicle v = factory.create("car");
```

**Ventajas:**
- Open/Closed Principle
- Configuración dinámica
- Extensible sin modificar Factory
</details>

---

### Flashcard 47
**P:** ¿Puede Factory pasar parámetros al constructor del objeto creado?

<details>
<summary>Ver respuesta</summary>

**R:** Sí, es común:

**Opción 1 - Parámetros fijos:**
```java
public Vehicle create(String type, String color, int year) {
    switch (type) {
        case "car":
            return new Car(color, year);
        case "truck":
            return new Truck(color, year);
        default:
            throw new IllegalArgumentException();
    }
}
```

**Opción 2 - Objeto de configuración:**
```java
class VehicleConfig {
    String color;
    int year;
    String model;
    // constructor, getters
}

public Vehicle create(String type, VehicleConfig config) {
    switch (type) {
        case "car":
            return new Car(config);
        case "truck":
            return new Truck(config);
        default:
            throw new IllegalArgumentException();
    }
}
```

**Opción 3 - Builder con Factory:**
```java
public VehicleBuilder createBuilder(String type) {
    switch (type) {
        case "car": return new CarBuilder();
        case "truck": return new TruckBuilder();
        default: throw new IllegalArgumentException();
    }
}

// Uso
Vehicle v = factory.createBuilder("car")
    .setColor("red")
    .setYear(2024)
    .build();
```
</details>

---

### Flashcard 48
**P:** ¿Factory puede retornar instancias cacheadas en lugar de crear nuevas?

<details>
<summary>Ver respuesta</summary>

**R:** Sí, es el patrón Flyweight combinado con Factory:

```java
public class VehicleFactory {
    private Map<String, Vehicle> cache = new HashMap<>();

    public Vehicle create(String model) {
        if (!cache.containsKey(model)) {
            cache.put(model, new Vehicle(model));
        }
        return cache.get(model);
    }
}

// Uso
Vehicle v1 = factory.create("ModelX");
Vehicle v2 = factory.create("ModelX");
System.out.println(v1 == v2);  // true - misma instancia
```

**Casos de uso:**
- Objetos inmutables
- Objetos costosos de crear
- Pool de conexiones
- Recursos limitados

**Cuidado:** Solo si los objetos son seguros de compartir (sin estado mutable).
</details>

---

### Flashcard 49
**P:** ¿Cómo testas Factory?

<details>
<summary>Ver respuesta</summary>

**R:**

**Test de creación correcta:**
```java
@Test
public void testCreateCar() {
    VehicleFactory factory = new VehicleFactory();
    Vehicle v = factory.create("car");

    assertNotNull(v);
    assertTrue(v instanceof Car);
}
```

**Test de tipo inválido:**
```java
@Test(expected = IllegalArgumentException.class)
public void testInvalidType() {
    VehicleFactory factory = new VehicleFactory();
    factory.create("invalid");
}
```

**Test de parámetros:**
```java
@Test
public void testCreateWithParams() {
    VehicleFactory factory = new VehicleFactory();
    Vehicle v = factory.create("car", "red", 2024);

    assertEquals("red", v.getColor());
    assertEquals(2024, v.getYear());
}
```

**Test de instancia única (si es Singleton):**
```java
@Test
public void testSingletonFactory() {
    VehicleFactory f1 = VehicleFactory.getInstance();
    VehicleFactory f2 = VehicleFactory.getInstance();

    assertSame(f1, f2);
}
```
</details>

---

### Flashcard 50
**P:** ¿Cuándo usar Factory vs constructor normal?

<details>
<summary>Ver respuesta</summary>

**R:**

**Usar Constructor cuando:**
- Creación simple y directa
- Solo hay una implementación
- No hay lógica de decisión
- El tipo es conocido en compile-time

```java
// ✅ Bien - creación simple
Car car = new Car("red", 2024);
```

**Usar Factory cuando:**
- Lógica de creación compleja
- Múltiples implementaciones de una interface
- Decisión en runtime sobre qué crear
- Quieres encapsular la creación
- Necesitas cache/pool de objetos

```java
// ✅ Bien - decisión en runtime
Vehicle v = factory.create(userInput);
```

**Regla general:** Si `new` es suficiente y claro, úsalo. Factory solo cuando agrega valor real.
</details>

---

## RESUMEN DE USO

**Repaso por Sección:**
- Strategy: 15 flashcards, ~15-20 minutos
- Visitor: 15 flashcards, ~15-20 minutos
- Singleton: 10 flashcards, ~10-15 minutos
- Factory: 10 flashcards, ~10-15 minutos

**Total:** 50 flashcards, 50-70 minutos completo

**Estrategia de repaso:**
1. Primera pasada: Lee todo
2. Segunda pasada: Solo los que fallaste
3. Tercera pasada: Aleatorio de los difíciles

**Cuándo usar:**
- Día antes del examen: Repasa sección que te cueste más
- 2 horas antes del examen: Repaso rápido de todos
- Durante el estudio: Para validar comprensión
- Después de ejercicios: Como autoevaluación
