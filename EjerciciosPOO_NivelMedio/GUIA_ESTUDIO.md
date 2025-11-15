# Guia de Estudio - Preparacion Examen POO

## Resumen del Examen Real

**Estructura del examen:**
- **Problema 1 (0.3 puntos):** Ruteo de codigo con GUI y patrones
- **Problema 2 (0.7 puntos):** Proyecto completo con multiples patrones

**Duracion:** 3 horas
**Puntaje aprobatorio:** 60% = 0.6 puntos = Nota 4.0

---

## Conceptos Clave a Dominar

### 1. Design Patterns (CRITICO)

#### Patron Strategy (OBLIGATORIO en examen)
**Cuando usarlo:** Cuando necesitas cambiar algoritmos o comportamientos en tiempo de ejecucion.

**Estructura:**
```java
// Interface
public interface Strategy {
    void ejecutar();
}

// Implementaciones concretas
public class StrategyA implements Strategy {
    public void ejecutar() { /* ... */ }
}

public class StrategyB implements Strategy {
    public void ejecutar() { /* ... */ }
}

// Contexto que usa la estrategia
public class Contexto {
    private Strategy estrategia;

    public void setEstrategia(Strategy estrategia) {
        this.estrategia = estrategia;
    }

    public void ejecutarEstrategia() {
        estrategia.ejecutar();
    }
}
```

**Ejemplos en ejercicios:**
- Ejercicio 2: Descuentos en tienda
- Ejercicio 7: Tarifas de taxis
- Ejercicio 8 y 10: Modos de manejo

#### Patron Visitor (OBLIGATORIO en examen)
**Cuando usarlo:** Cuando necesitas realizar operaciones sobre una jerarquia de clases sin modificarlas.

**Estructura:**
```java
// Interface Visitor
public interface Visitor {
    void visitarClaseA(ClaseA a);
    void visitarClaseB(ClaseB b);
}

// Interface Elemento (acepta visitors)
public interface Elemento {
    void accept(Visitor visitor);
}

// Clases concretas
public class ClaseA implements Elemento {
    public void accept(Visitor visitor) {
        visitor.visitarClaseA(this);  // Double dispatch
    }
}

// Visitor concreto
public class VisitorConcreto implements Visitor {
    public void visitarClaseA(ClaseA a) {
        // Operacion especifica para ClaseA
    }

    public void visitarClaseB(ClaseB b) {
        // Operacion especifica para ClaseB
    }
}
```

**Ejemplos en ejercicios:**
- Ejercicio 6: Calculo de costos de envio
- Ejercicio 7: Calculos de ganancias y costos
- Ejercicio 8 y 10: Estadisticas de vehiculos

#### Patron Singleton (OPCIONAL - elegir entre Singleton o Factory)
**Cuando usarlo:** Cuando necesitas garantizar que solo exista una instancia de una clase.

**Estructura:**
```java
public class Singleton {
    private static Singleton instance;

    // Constructor privado
    private Singleton() {
        // Inicializacion
    }

    // Metodo para obtener la unica instancia
    public static Singleton getInstance() {
        if (instance == null) {
            instance = new Singleton();
        }
        return instance;
    }

    // Metodos de la clase...
}
```

**Ejemplos en ejercicios:**
- Ejercicio 3: Sistema bancario
- Ejercicio 8 y 10: Sistema de renta de autos

#### Patron Factory (OPCIONAL - elegir entre Singleton o Factory)
**Cuando usarlo:** Cuando necesitas crear objetos complejos sin exponer la logica de creacion.

**Estructura:**
```java
public class Factory {
    public static Producto crearProducto(String tipo) {
        switch(tipo) {
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

**Ejemplos en ejercicios:**
- Ejercicio 4: Menus de restaurante

---

### 2. Herencia y Polimorfismo

**Principios fundamentales:**
- Usar clase abstracta o interface para la jerarquia base
- Sobrescribir metodos con `@Override`
- Aprovechar polimorfismo: `List<Vehiculo>` puede contener Auto, SUV, Camioneta

**Ejemplo:**
```java
public abstract class Vehiculo {
    protected String vin;
    protected String marca;

    public abstract String getTipo();  // Cada subclase implementa

    public void mostrarInfo() {
        System.out.println(marca + " - " + getTipo());
    }
}

public class Auto extends Vehiculo {
    @Override
    public String getTipo() {
        return "Auto";
    }
}
```

---

### 3. File I/O (CRITICO)

**Lectura basica:**
```java
import java.io.*;
import java.util.*;

try (Scanner scanner = new Scanner(new File("archivo.txt"))) {
    while (scanner.hasNextLine()) {
        String linea = scanner.nextLine();
        String[] datos = linea.split(",");
        // Procesar datos...
    }
} catch (FileNotFoundException e) {
    System.out.println("Archivo no encontrado: " + e.getMessage());
}
```

**Parsing de datos:**
```java
String linea = "VIN001,Toyota,Camry,Auto,14.5";
String[] datos = linea.split(",");

String vin = datos[0];
String marca = datos[1];
String modelo = datos[2];
String tipo = datos[3];
double eficiencia = Double.parseDouble(datos[4]);
```

**Manejo de arrays variables:**
```java
String linea = "VIN001,Normal,120,80,95,110";
String[] partes = linea.split(",");

String vin = partes[0];
String modo = partes[1];

// Las distancias comienzan en index 2
for (int i = 2; i < partes.length; i++) {
    int distancia = Integer.parseInt(partes[i]);
    // Procesar distancia...
}
```

---

### 4. Collections Framework

**ArrayList - Usado en casi todos los ejercicios:**
```java
List<Vehiculo> flota = new ArrayList<>();

// Agregar
flota.add(new Auto("VIN001", "Toyota", "Camry"));

// Iterar
for (Vehiculo v : flota) {
    System.out.println(v.getMarca());
}

// Buscar
Vehiculo encontrado = null;
for (Vehiculo v : flota) {
    if (v.getVin().equals("VIN001")) {
        encontrado = v;
        break;
    }
}
```

**HashMap - Util para busquedas rapidas:**
```java
Map<String, Vehiculo> mapVehiculos = new HashMap<>();

// Agregar
mapVehiculos.put("VIN001", vehiculo);

// Buscar (O(1) en promedio)
Vehiculo v = mapVehiculos.get("VIN001");
```

---

### 5. Exception Handling

**Siempre manejar excepciones en File I/O:**
```java
try {
    // Codigo que puede fallar
    Scanner scanner = new Scanner(new File("archivo.txt"));
} catch (FileNotFoundException e) {
    System.out.println("Error: " + e.getMessage());
} catch (NumberFormatException e) {
    System.out.println("Error al parsear numero: " + e.getMessage());
}
```

---

### 6. Java Swing (GUI) - Para Problema 1 y puntos extra

**Componentes basicos:**
```java
import javax.swing.*;
import java.awt.*;

JFrame frame = new JFrame("Titulo");
frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
frame.setSize(400, 400);

JPanel panel = new JPanel();
panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

for (int i = 1; i <= 5; i++) {
    panel.add(new JButton("Boton " + i));
}

frame.add(panel);
frame.setVisible(true);
```

**Layouts comunes:**
- `BoxLayout.X_AXIS`: Horizontal
- `BoxLayout.Y_AXIS`: Vertical
- `GridLayout(filas, columnas)`: Cuadricula
- `BorderLayout`: Norte, Sur, Este, Oeste, Centro

---

## Estrategia de Estudio Recomendada

### Semana 1: Fundamentos
- Dia 1-2: Ejercicio 1 (Herencia basica)
- Dia 3-4: Ejercicio 2 (Strategy)
- Dia 5-6: Ejercicio 3 (Singleton)
- Dia 7: Ejercicio 4 (Factory)

### Semana 2: Conceptos Intermedios
- Dia 1-2: Ejercicio 5 (File I/O)
- Dia 3-5: Ejercicio 6 (Visitor)
- Dia 6-7: Repasar patrones

### Semana 3: Integracion
- Dia 1-3: Ejercicio 7 (Taxis - multiples patrones)
- Dia 4-6: Ejercicio 8 (Rent a Car simplificado)
- Dia 7: Repasar y hacer apuntes

### Semana 4: Preparacion Final
- Dia 1-2: Ejercicio 9 (Ruteo de codigo)
- Dia 3-5: Ejercicio 10 (Rent a Car completo - EXAMEN)
- Dia 6: Repetir Ejercicio 10 sin mirar solucion
- Dia 7: Repasar conceptos debiles

---

## Checklist Pre-Examen

Antes del examen, asegurate de poder:

### Patrones de Diseno
- [ ] Implementar Strategy desde cero
- [ ] Implementar Visitor desde cero
- [ ] Implementar Singleton correctamente
- [ ] Implementar Factory basica
- [ ] Explicar cuando usar cada patron

### Programacion
- [ ] Crear jerarquia de clases con herencia
- [ ] Usar polimorfismo efectivamente
- [ ] Leer archivos estructurados con Scanner
- [ ] Parsear datos con split()
- [ ] Usar ArrayList y HashMap
- [ ] Manejar excepciones apropiadamente

### Code Tracing
- [ ] Trazar codigo con patrones
- [ ] Identificar patrones en codigo existente
- [ ] Predecir salida de programas
- [ ] Dibujar GUI resultante

### Arquitectura
- [ ] Disenar sistema con multiples clases
- [ ] Evitar ciclos anidados
- [ ] Separar logica en metodos pequenos
- [ ] Usar nombres descriptivos

---

## Errores Comunes a Evitar

1. **No leer el enunciado completo** - Lee DOS veces antes de programar
2. **Ciclos anidados** - Usa metodos auxiliares
3. **No usar los patrones requeridos** - Son OBLIGATORIOS
4. **Confundir eficiencia con consumo** - Lee bien las formulas
5. **No manejar excepciones** - Siempre usa try-catch para archivos
6. **Nombres poco descriptivos** - `v` vs `vehiculo`, `c` vs `consumo`
7. **No probar el codigo** - Compila y ejecuta frecuentemente
8. **Mezclar vehiculos en listas separadas** - Debe ser UNA SOLA LISTA
9. **No implementar double dispatch en Visitor** - `visitor.visitarX(this)`
10. **Olvidar @Override** - Siempre marca metodos sobrescritos

---

## Formulas Importantes - Rent a Car

**Eficiencia segun modo:**
```
Eco:    eficienciaReal = nominal * 1.10  (10% mejor)
Normal: eficienciaReal = nominal * 1.00  (sin cambios)
Sport:  eficienciaReal = nominal * 0.75  (25% peor)
```

**Consumo de combustible:**
```
consumo (litros) = distancia (km) / eficiencia (km/l)
```

**Odometro:**
```
odometro = suma de todas las distancias
```

---

## Recursos Adicionales

**Documentacion oficial Java:**
- Collections: https://docs.oracle.com/javase/tutorial/collections/
- File I/O: https://docs.oracle.com/javase/tutorial/essential/io/
- Swing: https://docs.oracle.com/javase/tutorial/uiswing/

**Design Patterns:**
- Strategy: https://refactoring.guru/design-patterns/strategy
- Visitor: https://refactoring.guru/design-patterns/visitor
- Singleton: https://refactoring.guru/design-patterns/singleton
- Factory: https://refactoring.guru/design-patterns/factory-method

---

**Recuerda: La practica hace al maestro. Resuelve los ejercicios multiples veces hasta que puedas hacerlos sin ayuda.**

**Mucha suerte en tu examen!**
