# GUIA PATRON VISITOR - Operaciones sin Contaminar Clases

## Indice
1. [Que es Visitor](#que-es-visitor)
2. [Cuando Usarlo](#cuando-usarlo)
3. [Estructura](#estructura)
4. [Ejemplo Paso a Paso](#ejemplo-paso-a-paso)
5. [Double Dispatch](#double-dispatch)
6. [Errores Comunes](#errores-comunes)
7. [Patron en el Examen](#patron-en-el-examen)

---

## Que es Visitor

**Visitor** permite **agregar operaciones nuevas a objetos existentes SIN modificar sus clases**.

### Analogia del Mundo Real
Imagina un museo con diferentes tipos de arte:
- Pinturas
- Esculturas
- Fotografias

Diferentes visitantes hacen cosas diferentes:
- **Tasador**: Calcula el valor de cada obra
- **Fotografo**: Toma fotos de cada obra
- **Restaurador**: Evalua el estado de conservacion

Las **obras NO cambian**, pero los **visitantes** realizan operaciones diferentes sobre ellas.

---

## Cuando Usarlo

Usa Visitor cuando:
- Tienes una **estructura de objetos estable** (no cambian mucho)
- Necesitas **agregar operaciones nuevas frecuentemente**
- NO quieres **contaminar** las clases con logica que no les corresponde
- Las operaciones no estan relacionadas entre si

### Problema que Resuelve

```java
// SIN Visitor - CONTAMINACION de clases
public class Producto {
    private String nombre;
    private double precio;

    // Metodo de negocio
    public double calcularPrecio() { ... }

    // CONTAMINACION: Logica de exportacion
    public String exportarCSV() { ... }
    public String exportarJSON() { ... }
    public String exportarXML() { ... }

    // CONTAMINACION: Logica de impresion
    public void imprimirTicket() { ... }
    public void imprimirFactura() { ... }

    // MAS CONTAMINACION: Logica de estadisticas
    public void calcularImpuesto() { ... }
    public void calcularDescuento() { ... }
}
```

**Problema**: La clase `Producto` tiene demasiadas responsabilidades!

**Solucion**: Usar Visitor para sacar toda esa logica fuera.

---

## Estructura

### Componentes del Patron

```
1. INTERFAZ VISITOR
   └─> Define metodos visit() para cada tipo de elemento

2. VISITANTES CONCRETOS
   └─> Implementan las operaciones especificas

3. INTERFAZ VISITABLE (o Element)
   └─> Define el metodo accept(Visitor)

4. ELEMENTOS CONCRETOS
   └─> Implementan accept() para aceptar visitantes
```

### Diagrama de Clases Simplificado

```
┌─────────────────────┐
│   <<interface>>     │
│   IVisitor          │
├─────────────────────┤
│ + visit(ElementoA)  │
│ + visit(ElementoB)  │
│ + visit(ElementoC)  │
└─────────────────────┘
        △
        │ implements
        │
┌───────┴──────┐
│ VisitorPrecio│
├──────────────┤
│ + visit(A)   │
│ + visit(B)   │
│ + visit(C)   │
└──────────────┘

┌─────────────────────┐
│   <<interface>>     │
│   IVisitable        │
├─────────────────────┤
│ + accept(IVisitor)  │
└─────────────────────┘
        △
        │ implements
   ┌────┴────┐
   │         │
┌──┴───┐ ┌──┴────┐
│ ElemA│ │ ElemB │
├──────┤ ├───────┤
│accept│ │accept │
└──────┘ └───────┘
```

---

## Ejemplo Paso a Paso

### Problema
Tienes un sistema de biblioteca con diferentes tipos de items:
- Libros
- Revistas
- DVDs

Necesitas calcular:
- Precio de prestamo
- Dias maximos de prestamo

Pero NO quieres agregar estos metodos a las clases de items.

### Paso 1: Crear la Interfaz Visitor

```java
public interface IVisitorBiblioteca {
    // Un metodo visit() por cada tipo de elemento
    void visit(Libro libro);
    void visit(Revista revista);
    void visit(DVD dvd);
}
```

**CLAVE**: Necesitas un metodo `visit()` para CADA tipo de elemento diferente.

### Paso 2: Crear la Interfaz Visitable

```java
public interface IItemVisitable {
    void accept(IVisitorBiblioteca visitor);
}
```

### Paso 3: Crear los Elementos Concretos

```java
public class Libro implements IItemVisitable {
    private String titulo;
    private String autor;
    private int paginas;

    public Libro(String titulo, String autor, int paginas) {
        this.titulo = titulo;
        this.autor = autor;
        this.paginas = paginas;
    }

    // PATRON VISITOR: Accept
    @Override
    public void accept(IVisitorBiblioteca visitor) {
        visitor.visit(this); // "Visita" este libro
    }

    // Getters
    public String getTitulo() { return titulo; }
    public String getAutor() { return autor; }
    public int getPaginas() { return paginas; }
}

public class Revista implements IItemVisitable {
    private String nombre;
    private int numero;

    public Revista(String nombre, int numero) {
        this.nombre = nombre;
        this.numero = numero;
    }

    @Override
    public void accept(IVisitorBiblioteca visitor) {
        visitor.visit(this); // "Visita" esta revista
    }

    public String getNombre() { return nombre; }
    public int getNumero() { return numero; }
}

public class DVD implements IItemVisitable {
    private String titulo;
    private int duracion; // en minutos

    public DVD(String titulo, int duracion) {
        this.titulo = titulo;
        this.duracion = duracion;
    }

    @Override
    public void accept(IVisitorBiblioteca visitor) {
        visitor.visit(this); // "Visita" este DVD
    }

    public String getTitulo() { return titulo; }
    public int getDuracion() { return duracion; }
}
```

### Paso 4: Crear Visitantes Concretos

```java
// VISITANTE 1: Calcula precio de prestamo
public class VisitorPrecioPrestamo implements IVisitorBiblioteca {
    private double precioTotal = 0;

    @Override
    public void visit(Libro libro) {
        // Libros: $5 por semana + $0.01 por pagina
        precioTotal += 5.0 + (libro.getPaginas() * 0.01);
    }

    @Override
    public void visit(Revista revista) {
        // Revistas: $2 por semana
        precioTotal += 2.0;
    }

    @Override
    public void visit(DVD dvd) {
        // DVDs: $3 por semana + $0.05 por minuto
        precioTotal += 3.0 + (dvd.getDuracion() * 0.05);
    }

    public double getPrecioTotal() {
        return precioTotal;
    }
}

// VISITANTE 2: Calcula dias maximos de prestamo
public class VisitorDiasPrestamo implements IVisitorBiblioteca {
    private int diasMaximos = 0;

    @Override
    public void visit(Libro libro) {
        // Libros: 14 dias
        diasMaximos = Math.max(diasMaximos, 14);
    }

    @Override
    public void visit(Revista revista) {
        // Revistas: 7 dias
        diasMaximos = Math.max(diasMaximos, 7);
    }

    @Override
    public void visit(DVD dvd) {
        // DVDs: 3 dias
        diasMaximos = Math.max(diasMaximos, 3);
    }

    public int getDiasMaximos() {
        return diasMaximos;
    }
}
```

### Paso 5: Usar el Patron

```java
public class Main {
    public static void main(String[] args) {
        // Crear items
        List<IItemVisitable> items = new ArrayList<>();
        items.add(new Libro("Clean Code", "Robert Martin", 464));
        items.add(new Revista("National Geographic", 245));
        items.add(new DVD("Matrix", 136));

        // Crear visitantes
        VisitorPrecioPrestamo vPrecio = new VisitorPrecioPrestamo();
        VisitorDiasPrestamo vDias = new VisitorDiasPrestamo();

        // VISITAR todos los items
        for (IItemVisitable item : items) {
            item.accept(vPrecio); // Calcula precio
            item.accept(vDias);   // Calcula dias
        }

        // Mostrar resultados
        System.out.println("Precio total: $" + vPrecio.getPrecioTotal());
        System.out.println("Dias maximos: " + vDias.getDiasMaximos());
    }
}
```

**Salida:**
```
Precio total: $16.64
Dias maximos: 14
```

---

## Double Dispatch

**Concepto CLAVE del patron Visitor**.

### Que es Double Dispatch?

Es el mecanismo que permite que el visitante correcto llame al metodo correcto.

```java
item.accept(visitor);  // Primera llamada
  └─> visitor.visit(this);  // Segunda llamada (sabe el tipo exacto)
```

### Por que es Necesario?

```java
// SIN Double Dispatch - NO FUNCIONA
List<IItemVisitable> items = new ArrayList<>();
items.add(new Libro(...));
items.add(new Revista(...));

for (IItemVisitable item : items) {
    // Java NO sabe si item es Libro, Revista o DVD
    // Solo sabe que es IItemVisitable
    visitor.visit(item); // ERROR: No existe visit(IItemVisitable)
}

// CON Double Dispatch - FUNCIONA
for (IItemVisitable item : items) {
    item.accept(visitor); // item sabe su tipo exacto
      └─> visitor.visit(this); // Llama al visit() correcto
}
```

### Diagrama de Secuencia

```
Main           Item (Libro)      Visitor
 │                 │                │
 │──accept(v)────> │                │
 │                 │──visit(this)──>│
 │                 │                │ (sabe que es Libro)
 │                 │ <──────────────│
 │ <───────────────│                │
```

---

## Errores Comunes

### Error 1: Olvidar el metodo accept()

```java
// MAL - Falta accept()
public class Libro implements IItemVisitable {
    private String titulo;
    // FALTA: public void accept(IVisitorBiblioteca v) { ... }
}
```

### Error 2: Accept incorrecto

```java
// MAL - No delega al visitor
@Override
public void accept(IVisitorBiblioteca visitor) {
    // Hace nada o hace logica aqui
}

// BIEN - Delega al visitor
@Override
public void accept(IVisitorBiblioteca visitor) {
    visitor.visit(this); // CLAVE: "this" es el objeto actual
}
```

### Error 3: Visitor que modifica estado de elementos

```java
// MAL - El visitor NO debe modificar los elementos
@Override
public void visit(Libro libro) {
    libro.setPaginas(100); // MAL!
}

// BIEN - El visitor solo LEE
@Override
public void visit(Libro libro) {
    int paginas = libro.getPaginas(); // Leer
    // Usar el dato para calcular algo
}
```

### Error 4: No tener un visit() para cada tipo

```java
// MAL - Falta visit(DVD)
public interface IVisitor {
    void visit(Libro libro);
    void visit(Revista revista);
    // FALTA: void visit(DVD dvd);
}
```

---

## Patron en el Examen

### Ejemplo del Examen Real (Prueba 2 - Rent a Car)

**Problema**: Calcular el vehiculo con mayor consumo por categoria (Pickup, SUV, Car).

**Solucion con Visitor**:

```java
// VISITOR
public class UsageVisitor implements Visitor {
    double maxCarUsage, maxPickupUsage, maxSUVUsage;
    String VINCarUsage, VINPickupUsage, VINSUVUsage;

    @Override
    public void visit(Car v) {
        if (v.getGasUsage() > maxCarUsage) {
            maxCarUsage = v.getGasUsage();
            VINCarUsage = v.getRegistration();
        }
    }

    @Override
    public void visit(SUV v) {
        if (v.getGasUsage() > maxSUVUsage) {
            maxSUVUsage = v.getGasUsage();
            VINSUVUsage = v.getRegistration();
        }
    }

    @Override
    public void visit(Pickup v) {
        if (v.getGasUsage() > maxPickupUsage) {
            maxPickupUsage = v.getGasUsage();
            VINPickupUsage = v.getRegistration();
        }
    }

    public String showInfo() {
        return "Mayor consumo: \n"
            + "Camioneta: " + VINPickupUsage + "\n"
            + "SUV: " + VINSUVUsage + "\n"
            + "Auto: " + VINCarUsage;
    }
}

// ELEMENTOS (Vehiculos)
public abstract class Vehicle {
    public abstract void accept(Visitor v);
}

public class Car extends Vehicle {
    @Override
    public void accept(Visitor v) {
        v.visit(this); // Double dispatch
    }
}
```

### Checklist para el Examen

Cuando veas que piden Visitor, asegurate de:

- [ ] Crear interfaz `IVisitor` con metodos `visit()` para CADA tipo de elemento
- [ ] Crear interfaz `IVisitable` con metodo `accept(IVisitor)`
- [ ] Cada clase de elemento implementa `accept()` llamando a `visitor.visit(this)`
- [ ] Los visitantes concretos implementan la logica en cada `visit()`
- [ ] El visitante NO modifica los elementos, solo los lee
- [ ] Demostrar en Main que creas un visitor y lo pasas a los elementos

---

## Resumen en 30 Segundos

**Visitor = Agregar operaciones sin modificar clases**

1. Creas interfaz **IVisitor** con `visit()` para cada tipo
2. Creas interfaz **IVisitable** con `accept(IVisitor)`
3. Los elementos implementan `accept()` llamando a `visitor.visit(this)`
4. Los visitantes concretos implementan la logica
5. **Double dispatch** hace la magia

**Ventaja clave**: SEPARACION de operaciones de la estructura de datos.

---

## Practica Recomendada

1. Resuelve **Ejercicio06_VisitorIntroduccion.md**
2. Resuelve **Ejercicio13_ZoologicoVisitor.md**
3. Analiza el codigo del examen real en `materialPOO/p2/p2/src/p2/`
4. Intenta resolver el **Ejercicio20_SimulacroExamen.md**

---

**Tiempo de estudio estimado**: 60-75 minutos para dominar el patron.

**IMPORTANTE**: Visitor es el patron MAS DIFICIL del curso. Practica mucho!
