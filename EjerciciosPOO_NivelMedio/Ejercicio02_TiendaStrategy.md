# Ejercicio 2: Tienda con Estrategias de Descuento (Nivel 2)
**Dificultad:** Medio
**Tiempo estimado:** 45 minutos
**Conceptos:** Strategy Pattern, Herencia, Polimorfismo

---

## Contexto

Una tienda online necesita implementar diferentes estrategias de descuento para sus productos. Los descuentos varian segun promociones especiales y el tipo de cliente.

## Requisitos

### Clases de Productos:

Todos los productos tienen:
- Codigo (String)
- Nombre (String)
- Precio base (double)

Tipos de productos:
- **Electronico:** garantia en meses (int)
- **Ropa:** talla (String)
- **Alimento:** fecha de vencimiento (String)

### Estrategias de Descuento:

La tienda maneja 3 estrategias de descuento diferentes:

1. **Sin Descuento:** El precio final es igual al precio base.

2. **Descuento Porcentual:** Aplica un porcentaje de descuento sobre el precio base.
   - Formula: precioFinal = precioBase * (1 - porcentaje/100)
   - Ejemplo: 20% de descuento sobre $100 = $80

3. **Descuento por Monto Fijo:** Resta un monto fijo del precio base.
   - Formula: precioFinal = precioBase - montoDescuento
   - Ejemplo: $15 de descuento sobre $100 = $85
   - Si el descuento es mayor que el precio, el precio final es $0

### Funcionalidades:

1. **Carrito de Compras:** Debe poder:
   - Agregar productos
   - Establecer la estrategia de descuento a usar
   - Calcular el total sin descuento
   - Calcular el total con descuento aplicado
   - Mostrar resumen de compra

2. **Cambio dinamico de estrategia:** El carrito debe poder cambiar de estrategia de descuento en cualquier momento.

## Ejemplo de Ejecucion

```
=== CARRITO DE COMPRAS ===
Estrategia actual: Sin Descuento

Productos en el carrito:
1. [E001] Laptop - $799.99 (Electronico, 24 meses garantia)
2. [R001] Camisa - $29.99 (Ropa, talla M)
3. [A001] Leche - $2.50 (Alimento, vence: 2024-12-15)

Subtotal: $832.48
Descuento: $0.00
TOTAL: $832.48

--- Cambiando a Descuento del 15% ---

Subtotal: $832.48
Descuento: $124.87
TOTAL: $707.61

--- Cambiando a Descuento Fijo de $50 ---

Subtotal: $832.48
Descuento: $50.00
TOTAL: $782.48
```

## Debe entregar:

- Clase abstracta `Producto` y subclases `Electronico`, `Ropa`, `Alimento`
- **Interface `EstrategiaDescuento`** con metodo `calcularPrecioFinal(double precioBase)`
- Tres clases que implementen la interface: `SinDescuento`, `DescuentoPorcentual`, `DescuentoFijo`
- Clase `CarritoCompras` que use la estrategia
- Clase `Main` que demuestre el cambio dinamico de estrategias

## Consideraciones:

- **DEBE usar el patron Strategy correctamente**
- El carrito debe tener una referencia a `EstrategiaDescuento`
- Debe poder cambiar la estrategia en tiempo de ejecucion
- Los calculos deben ser precisos (usa `double`)
- Formatee los precios a 2 decimales al mostrar

## Pistas:

1. La interface `EstrategiaDescuento` es la clave del patron Strategy
2. El carrito debe tener un metodo `setEstrategiaDescuento(EstrategiaDescuento estrategia)`
3. Para formatear decimales: `String.format("%.2f", numero)`
4. Cada estrategia concreta necesita sus propios atributos (porcentaje, monto)

---

## PASO A PASO: COMO RESOLVER ESTE EJERCICIO

Este ejercicio te ensenara el **Patron Strategy**, fundamental para el examen. Strategy permite cambiar algoritmos/comportamientos dinamicamente en tiempo de ejecucion.

### PASO 1: Entender el Patron Strategy

**Pregunta clave:** ¿Por que usar Strategy aqui?

El carrito de compras necesita calcular descuentos de DIFERENTES formas:
- A veces sin descuento
- A veces descuento porcentual (15%, 20%, etc.)
- A veces descuento fijo ($50, $100, etc.)

**Problema sin Strategy:** Tendrias que usar muchos `if-else` y modificar el CarritoCompras cada vez que agregas un nuevo tipo de descuento.

**Solucion con Strategy:** Encapsulas cada tipo de descuento en una clase separada y cambias la estrategia cuando quieras.

### PASO 2: Crear la Jerarquia de Productos

Primero lo simple - la herencia de productos:

```java
public abstract class Producto {
    protected String codigo;
    protected String nombre;
    protected double precioBase;

    public Producto(String codigo, String nombre, double precioBase) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.precioBase = precioBase;
    }

    public abstract String obtenerDetalles();

    public String getCodigo() { return codigo; }
    public String getNombre() { return nombre; }
    public double getPrecioBase() { return precioBase; }
}
```

```java
public class Electronico extends Producto {
    private int garantiaMeses;

    public Electronico(String codigo, String nombre, double precioBase, int garantiaMeses) {
        super(codigo, nombre, precioBase);
        this.garantiaMeses = garantiaMeses;
    }

    @Override
    public String obtenerDetalles() {
        return String.format("[%s] %s - $%.2f (Electronico, %d meses garantia)",
                           codigo, nombre, precioBase, garantiaMeses);
    }
}
```

```java
public class Ropa extends Producto {
    private String talla;

    public Ropa(String codigo, String nombre, double precioBase, String talla) {
        super(codigo, nombre, precioBase);
        this.talla = talla;
    }

    @Override
    public String obtenerDetalles() {
        return String.format("[%s] %s - $%.2f (Ropa, talla %s)",
                           codigo, nombre, precioBase, talla);
    }
}
```

```java
public class Alimento extends Producto {
    private String fechaVencimiento;

    public Alimento(String codigo, String nombre, double precioBase, String fechaVencimiento) {
        super(codigo, nombre, precioBase);
        this.fechaVencimiento = fechaVencimiento;
    }

    @Override
    public String obtenerDetalles() {
        return String.format("[%s] %s - $%.2f (Alimento, vence: %s)",
                           codigo, nombre, precioBase, fechaVencimiento);
    }
}
```

### PASO 3: Crear la Interface EstrategiaDescuento (CLAVE DEL PATRON)

Esta es la **interface Strategy** - el corazon del patron:

```java
public interface EstrategiaDescuento {
    /**
     * Calcula el precio final despues de aplicar el descuento
     * @param precioBase El precio original
     * @return El precio final con descuento aplicado
     */
    double calcularPrecioFinal(double precioBase);

    /**
     * Retorna una descripcion de la estrategia para mostrar al usuario
     */
    String obtenerDescripcion();
}
```

**Por que una interface?** Para que todas las estrategias tengan el mismo "contrato" - todas deben implementar estos metodos.

### PASO 4: Crear las Estrategias Concretas

**Estrategia 1: Sin Descuento**

```java
public class SinDescuento implements EstrategiaDescuento {
    @Override
    public double calcularPrecioFinal(double precioBase) {
        return precioBase;  // Sin cambios
    }

    @Override
    public String obtenerDescripcion() {
        return "Sin Descuento";
    }
}
```

**Estrategia 2: Descuento Porcentual**

```java
public class DescuentoPorcentual implements EstrategiaDescuento {
    private double porcentaje;  // Atributo especifico de esta estrategia

    public DescuentoPorcentual(double porcentaje) {
        this.porcentaje = porcentaje;
    }

    @Override
    public double calcularPrecioFinal(double precioBase) {
        // Formula: precioFinal = precioBase * (1 - porcentaje/100)
        // Ejemplo: 100 * (1 - 20/100) = 100 * 0.8 = 80
        return precioBase * (1 - porcentaje / 100);
    }

    @Override
    public String obtenerDescripcion() {
        return String.format("Descuento del %.0f%%", porcentaje);
    }

    public double getPorcentaje() {
        return porcentaje;
    }
}
```

**Estrategia 3: Descuento Fijo**

```java
public class DescuentoFijo implements EstrategiaDescuento {
    private double montoDescuento;

    public DescuentoFijo(double montoDescuento) {
        this.montoDescuento = montoDescuento;
    }

    @Override
    public double calcularPrecioFinal(double precioBase) {
        double precioFinal = precioBase - montoDescuento;
        // Validar que no sea negativo
        return precioFinal < 0 ? 0 : precioFinal;
    }

    @Override
    public String obtenerDescripcion() {
        return String.format("Descuento fijo de $%.2f", montoDescuento);
    }

    public double getMontoDescuento() {
        return montoDescuento;
    }
}
```

### PASO 5: Crear el CarritoCompras (USA LA ESTRATEGIA)

```java
import java.util.ArrayList;

public class CarritoCompras {
    private ArrayList<Producto> productos;
    private EstrategiaDescuento estrategiaActual;  // CLAVE: Referencia a la estrategia

    public CarritoCompras() {
        productos = new ArrayList<>();
        estrategiaActual = new SinDescuento();  // Estrategia por defecto
    }

    // Cambiar estrategia dinamicamente (PATRON STRATEGY EN ACCION)
    public void setEstrategiaDescuento(EstrategiaDescuento estrategia) {
        this.estrategiaActual = estrategia;
        System.out.println("--- Cambiando a " + estrategia.obtenerDescripcion() + " ---\n");
    }

    public void agregarProducto(Producto producto) {
        productos.add(producto);
    }

    // Calcular subtotal (sin descuento)
    public double calcularSubtotal() {
        double subtotal = 0;
        for (Producto producto : productos) {
            subtotal += producto.getPrecioBase();
        }
        return subtotal;
    }

    // Calcular total con descuento (USA LA ESTRATEGIA)
    public double calcularTotal() {
        double subtotal = calcularSubtotal();
        // POLIMORFISMO: llama al metodo correcto segun la estrategia actual
        return estrategiaActual.calcularPrecioFinal(subtotal);
    }

    // Calcular cuanto se descontó
    public double calcularMontoDescontado() {
        return calcularSubtotal() - calcularTotal();
    }

    public void mostrarResumen() {
        System.out.println("=== CARRITO DE COMPRAS ===");
        System.out.println("Estrategia actual: " + estrategiaActual.obtenerDescripcion());
        System.out.println("\nProductos en el carrito:");

        int contador = 1;
        for (Producto producto : productos) {
            System.out.println(contador + ". " + producto.obtenerDetalles());
            contador++;
        }

        double subtotal = calcularSubtotal();
        double descuento = calcularMontoDescontado();
        double total = calcularTotal();

        System.out.println(String.format("\nSubtotal: $%.2f", subtotal));
        System.out.println(String.format("Descuento: $%.2f", descuento));
        System.out.println(String.format("TOTAL: $%.2f\n", total));
    }
}
```

**Concepto clave del Patron Strategy:**
- El carrito tiene una referencia a `EstrategiaDescuento` (la interface)
- Puede ser SinDescuento, DescuentoPorcentual o DescuentoFijo
- Cambias la estrategia llamando `setEstrategiaDescuento()`
- El carrito NO necesita saber QUE estrategia es - solo la usa

### PASO 6: Crear el Main (Demostrar el Patron)

```java
public class Main {
    public static void main(String[] args) {
        // Crear carrito
        CarritoCompras carrito = new CarritoCompras();

        // Agregar productos
        carrito.agregarProducto(new Electronico("E001", "Laptop", 799.99, 24));
        carrito.agregarProducto(new Ropa("R001", "Camisa", 29.99, "M"));
        carrito.agregarProducto(new Alimento("A001", "Leche", 2.50, "2024-12-15"));

        // Mostrar con estrategia por defecto (Sin Descuento)
        carrito.mostrarResumen();

        // Cambiar a descuento porcentual del 15%
        carrito.setEstrategiaDescuento(new DescuentoPorcentual(15));
        carrito.mostrarResumen();

        // Cambiar a descuento fijo de $50
        carrito.setEstrategiaDescuento(new DescuentoFijo(50));
        carrito.mostrarResumen();

        // Probar con otros porcentajes
        System.out.println("=== PROBANDO OTROS DESCUENTOS ===\n");
        carrito.setEstrategiaDescuento(new DescuentoPorcentual(25));
        System.out.println("Total con 25% descuento: $" +
                         String.format("%.2f", carrito.calcularTotal()));

        carrito.setEstrategiaDescuento(new DescuentoFijo(100));
        System.out.println("Total con $100 descuento: $" +
                         String.format("%.2f", carrito.calcularTotal()));
    }
}
```

### PASO 7: Compilar y Ejecutar

```bash
# Compilar todo
javac Producto.java Electronico.java Ropa.java Alimento.java EstrategiaDescuento.java SinDescuento.java DescuentoPorcentual.java DescuentoFijo.java CarritoCompras.java Main.java

# Ejecutar
java Main
```

### ERRORES COMUNES A EVITAR

1. **Olvidar inicializar la estrategia:**
   ```java
   // INCORRECTO
   private EstrategiaDescuento estrategia;  // null!

   // CORRECTO
   private EstrategiaDescuento estrategia = new SinDescuento();
   ```

2. **No validar precio negativo en DescuentoFijo:**
   ```java
   // INCORRECTO
   return precioBase - monto;  // Puede ser negativo!

   // CORRECTO
   double resultado = precioBase - monto;
   return resultado < 0 ? 0 : resultado;
   ```

3. **Confundir porcentaje con decimal:**
   ```java
   // INCORRECTO
   return precioBase * (1 - porcentaje);  // Si porcentaje es 15, esto da negativo

   // CORRECTO
   return precioBase * (1 - porcentaje / 100);
   ```

4. **No implementar todos los metodos de la interface:**
   ```java
   // Si olvidas implementar obtenerDescripcion(), el compilador dara error
   ```

### CONCEPTOS APRENDIDOS

1. **Patron Strategy:** Encapsula algoritmos en clases separadas e intercambiables
2. **Polimorfismo con interfaces:** EstrategiaDescuento puede ser cualquier implementacion
3. **Cambio dinamico de comportamiento:** Cambias la estrategia en tiempo de ejecucion
4. **Separacion de responsabilidades:** Cada estrategia tiene SU logica
5. **Open/Closed Principle:** Puedes agregar nuevas estrategias sin modificar CarritoCompras

### VENTAJAS DEL PATRON STRATEGY

**Sin Strategy (codigo malo):**
```java
public double calcularTotal(String tipoDescuento, double valor) {
    if (tipoDescuento.equals("ninguno")) {
        return subtotal;
    } else if (tipoDescuento.equals("porcentual")) {
        return subtotal * (1 - valor/100);
    } else if (tipoDescuento.equals("fijo")) {
        return subtotal - valor;
    }
    // Necesitas modificar esto cada vez que agregas un descuento nuevo
}
```

**Con Strategy (codigo bueno):**
```java
public double calcularTotal() {
    return estrategia.calcularPrecioFinal(subtotal);
    // Nunca necesitas modificar esto
}
```

### DESAFIOS ADICIONALES

1. Agrega una nueva estrategia: `DescuentoPorCantidad` (descuento si compras 5+ items)
2. Agrega `DescuentoProgresivo` (10% si total > $100, 20% si total > $500)
3. Implementa un sistema de cupones con codigos
4. Combina estrategias (primero porcentual, luego fijo)

---

**Este ejercicio es fundamental para entender el patron Strategy, que es OBLIGATORIO en el examen.**
