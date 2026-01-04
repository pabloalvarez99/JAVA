# CHEAT SHEET - Patrones de Diseno POO

**Referencia rapida para el examen**

---

## SINGLETON

### Cuando Usarlo
- Necesitas **UNA SOLA INSTANCIA** de una clase
- Acceso global a esa instancia

### Codigo Basico

```java
public class MiClase {
    // 1. Instancia estatica privada
    private static MiClase instance;

    // 2. Constructor PRIVADO
    private MiClase() {
        // Inicializacion
    }

    // 3. Metodo estatico publico para obtener instancia
    public static MiClase getInstance() {
        if (instance == null) {
            instance = new MiClase();
        }
        return instance;
    }

    // Metodos de negocio
    public void hacerAlgo() {
        // ...
    }
}
```

### Uso

```java
// NUNCA: MiClase obj = new MiClase(); // ERROR - constructor privado

// SIEMPRE:
MiClase obj = MiClase.getInstance();
obj.hacerAlgo();
```

### Checklist
- [ ] Atributo `private static MiClase instance`
- [ ] Constructor `private MiClase()`
- [ ] Metodo `public static MiClase getInstance()`
- [ ] `if (instance == null)` antes de crear

---

## FACTORY

### Cuando Usarlo
- Necesitas **crear objetos** de diferentes tipos
- La creacion depende de un parametro

### Codigo Basico

```java
// PRODUCTOS
public abstract class Producto {
    protected String nombre;
    public abstract void usar();
}

public class ProductoA extends Producto {
    public ProductoA() {
        nombre = "Producto A";
    }
    public void usar() { System.out.println("Usando A"); }
}

public class ProductoB extends Producto {
    public ProductoB() {
        nombre = "Producto B";
    }
    public void usar() { System.out.println("Usando B"); }
}

// FACTORY
public class ProductoFactory {
    public static Producto crearProducto(String tipo) {
        switch (tipo.toUpperCase()) {
            case "A":
                return new ProductoA();
            case "B":
                return new ProductoB();
            default:
                throw new IllegalArgumentException("Tipo desconocido");
        }
    }
}
```

### Uso

```java
Producto p1 = ProductoFactory.crearProducto("A");
p1.usar(); // "Usando A"

Producto p2 = ProductoFactory.crearProducto("B");
p2.usar(); // "Usando B"
```

### Checklist
- [ ] Clase abstracta/interface base
- [ ] Clases concretas que heredan
- [ ] Clase Factory con metodo `crear()`
- [ ] Switch o if/else segun tipo

---

## STRATEGY

### Cuando Usarlo
- Necesitas **cambiar comportamiento** en runtime
- Evitar muchos if/else

### Codigo Basico

```java
// INTERFAZ STRATEGY
public interface IEstrategia {
    void ejecutar();
}

// ESTRATEGIAS CONCRETAS
public class EstrategiaA implements IEstrategia {
    public void ejecutar() {
        System.out.println("Estrategia A");
    }
}

public class EstrategiaB implements IEstrategia {
    public void ejecutar() {
        System.out.println("Estrategia B");
    }
}

// CONTEXTO
public class Contexto {
    private IEstrategia estrategia;

    public void setEstrategia(IEstrategia e) {
        this.estrategia = e;
    }

    public void hacerAlgo() {
        if (estrategia == null) {
            throw new IllegalStateException("Sin estrategia");
        }
        estrategia.ejecutar(); // DELEGA
    }
}
```

### Uso

```java
Contexto ctx = new Contexto();

ctx.setEstrategia(new EstrategiaA());
ctx.hacerAlgo(); // "Estrategia A"

ctx.setEstrategia(new EstrategiaB());
ctx.hacerAlgo(); // "Estrategia B"
```

### Checklist
- [ ] Interface `IEstrategia` con metodos abstractos
- [ ] 2-3 clases que implementan `IEstrategia`
- [ ] Contexto con atributo `private IEstrategia`
- [ ] Metodo `setEstrategia()`
- [ ] Contexto DELEGA a la estrategia

---

## VISITOR

### Cuando Usarlo
- Agregar **operaciones** sin modificar clases
- Diferentes operaciones sobre misma estructura

### Codigo Basico

```java
// INTERFAZ VISITOR
public interface IVisitor {
    void visit(ElementoA elem);
    void visit(ElementoB elem);
}

// INTERFAZ VISITABLE
public interface IVisitable {
    void accept(IVisitor visitor);
}

// ELEMENTOS
public class ElementoA implements IVisitable {
    private int valor;

    public ElementoA(int valor) {
        this.valor = valor;
    }

    public void accept(IVisitor visitor) {
        visitor.visit(this); // Double dispatch
    }

    public int getValor() { return valor; }
}

public class ElementoB implements IVisitable {
    private String nombre;

    public ElementoB(String nombre) {
        this.nombre = nombre;
    }

    public void accept(IVisitor visitor) {
        visitor.visit(this);
    }

    public String getNombre() { return nombre; }
}

// VISITOR CONCRETO
public class VisitorImpresion implements IVisitor {
    public void visit(ElementoA elem) {
        System.out.println("Elemento A: " + elem.getValor());
    }

    public void visit(ElementoB elem) {
        System.out.println("Elemento B: " + elem.getNombre());
    }
}
```

### Uso

```java
List<IVisitable> elementos = new ArrayList<>();
elementos.add(new ElementoA(42));
elementos.add(new ElementoB("Hola"));

VisitorImpresion visitor = new VisitorImpresion();

for (IVisitable elem : elementos) {
    elem.accept(visitor);
}
// Salida:
// Elemento A: 42
// Elemento B: Hola
```

### Checklist
- [ ] Interface `IVisitor` con `visit()` por cada tipo
- [ ] Interface `IVisitable` con `accept(IVisitor)`
- [ ] Elementos implementan `accept()` llamando a `visitor.visit(this)`
- [ ] Visitor concreto implementa logica en cada `visit()`
- [ ] NO modificar elementos, solo leer

---

## ARQUITECTURA SISTEMA

### Estructura Obligatoria

```java
// INTERFACE
public interface ISistema {
    void registrar(String[] datos);
    String consultar();
    // Otros metodos segun el problema
}

// IMPLEMENTACION
public class SistemaImpl implements ISistema {
    private List<Item> items;

    public SistemaImpl() {
        items = new ArrayList<>();
    }

    @Override
    public void registrar(String[] datos) {
        // Parsear datos y crear item
        Item item = new Item(datos[0], datos[1]);
        items.add(item);
    }

    @Override
    public String consultar() {
        StringBuilder sb = new StringBuilder();
        for (Item item : items) {
            sb.append(item.toString()).append("\n");
        }
        return sb.toString();
    }
}
```

### Uso

```java
ISistema sistema = new SistemaImpl();
sistema.registrar(new String[]{"dato1", "dato2"});
System.out.println(sistema.consultar());
```

### Checklist
- [ ] Interface con metodos del sistema
- [ ] Clase Impl que implementa la interface
- [ ] Lista/coleccion de items
- [ ] Metodos de registro y consulta

---

## LECTURA DE ARCHIVO

### Estructura Tipica

```
N                    <- Primera linea: cantidad
Item1,dato1,dato2    <- N lineas de items
Item2,dato1,dato2
...
Transaccion1,datos   <- Resto: transacciones (variable)
Transaccion2,datos
...
```

### Codigo Basico

```java
import java.io.*;
import java.util.Scanner;

public class Lector {
    public static void leerArchivo(ISistema sistema, String archivo)
            throws IOException {
        Scanner sc = new Scanner(new File(archivo));

        // Leer cantidad de items
        int N = Integer.parseInt(sc.nextLine());

        // Leer N items
        for (int i = 0; i < N; i++) {
            String linea = sc.nextLine();
            String[] partes = linea.split(",");
            sistema.registrarItem(partes);
        }

        // Leer transacciones (resto del archivo)
        while (sc.hasNextLine()) {
            String linea = sc.nextLine();
            String[] partes = linea.split(",");
            sistema.registrarTransaccion(partes);
        }

        sc.close();
    }
}
```

### Checklist
- [ ] `import java.io.*; import java.util.Scanner;`
- [ ] `Scanner sc = new Scanner(new File("archivo.txt"))`
- [ ] `int N = Integer.parseInt(sc.nextLine())`
- [ ] Loop `for (i = 0; i < N; i++)`
- [ ] Loop `while (sc.hasNextLine())`
- [ ] `String[] partes = linea.split(",")`
- [ ] `sc.close()` al final

---

## FORMULAS COMUNES

### Calculos con Strategy

```java
// Modo Eco: 10% MENOS eficiente (MAS consumo)
double eficiencia = nominal * 0.9;  // o nominal / 1.1

// Modo Sport: 25% MAS consumo
double eficiencia = nominal * 1.25;

// Consumo de combustible
double litros = distancia / eficiencia;
```

### Calculos con Visitor

```java
// Precio con recargo
double total = base * 1.20;  // +20%

// Precio con descuento
double total = base * 0.85;  // -15%

// Precio condicional
if (condicion) {
    total += extra;
}
```

---

## TEMPLATE MAIN COMPLETO

```java
import java.io.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        // 1. Crear sistema
        ISistema sistema = new SistemaImpl();

        // 2. Leer archivo
        leerArchivo(sistema, "datos.txt");

        // 3. Aplicar visitor (si aplica)
        VisitorCalculo visitor = new VisitorCalculo();
        sistema.aplicarVisitor(visitor);

        // 4. Mostrar resultados
        System.out.println(sistema.mostrarResultados());
        System.out.println(visitor.obtenerResultado());
    }

    public static void leerArchivo(ISistema s, String archivo)
            throws IOException {
        Scanner sc = new Scanner(new File(archivo));
        int N = Integer.parseInt(sc.nextLine());

        for (int i = 0; i < N; i++) {
            String[] partes = sc.nextLine().split(",");
            s.registrarItem(partes);
        }

        while (sc.hasNextLine()) {
            String[] partes = sc.nextLine().split(",");
            s.procesarTransaccion(partes);
        }

        sc.close();
    }
}
```

---

## ERRORES CRITICOS A EVITAR

### Singleton
- Constructor publico (debe ser privado)
- No validar `if (instance == null)`

### Factory
- No usar herencia/interface
- Hardcodear tipos en lugar de usar parametro

### Strategy
- No tener metodo `setEstrategia()`
- Hacer logica en el contexto en lugar de delegar

### Visitor
- Olvidar el metodo `accept()`
- `accept()` que no llama a `visitor.visit(this)`
- Modificar elementos en el visitor

### Archivo
- No cerrar el Scanner
- No validar `hasNextLine()`
- Parsear mal (no usar `split()`)

---

## ESTIMACION DE TIEMPO

| Componente | Tiempo |
|------------|--------|
| Clases de datos | 15 min |
| Singleton | 5 min |
| Factory | 10 min |
| Strategy completo | 15 min |
| Visitor completo | 20 min |
| Sistema (interface + impl) | 15 min |
| Lectura archivo | 10 min |
| Main y testing | 10 min |
| **TOTAL** | **100 min** |

---

**IMPRIME ESTA HOJA Y LLEVALA AL EXAMEN (si esta permitido)**
