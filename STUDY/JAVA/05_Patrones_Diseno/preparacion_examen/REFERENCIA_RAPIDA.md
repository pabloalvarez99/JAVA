# Referencia Rapida - Examen POO

**Imprime esta hoja para tener a mano durante la practica**

---

## Patrones Obligatorios en el Examen

### Strategy Pattern ✓ OBLIGATORIO
```java
// Interface
public interface Strategy {
    TipoRetorno ejecutar(parametros);
}

// Implementaciones
public class StrategyA implements Strategy {
    public TipoRetorno ejecutar(parametros) { /* ... */ }
}

// Uso en contexto
public class Contexto {
    private Strategy estrategia;

    public void setEstrategia(Strategy e) {
        this.estrategia = e;
    }

    public void usarEstrategia() {
        estrategia.ejecutar(params);
    }
}
```

### Visitor Pattern ✓ OBLIGATORIO
```java
// Interface Visitor
public interface Visitor {
    void visitarTipo1(Tipo1 obj);
    void visitarTipo2(Tipo2 obj);
}

// Interface Elemento
public interface Elemento {
    void accept(Visitor visitor);
}

// Implementacion
public class Tipo1 implements Elemento {
    @Override
    public void accept(Visitor visitor) {
        visitor.visitarTipo1(this);  // Double dispatch!
    }
}

// Visitor concreto
public class VisitorConcreto implements Visitor {
    @Override
    public void visitarTipo1(Tipo1 obj) {
        // Operacion especifica para Tipo1
    }
}
```

### Singleton ✓ OPCIONAL (Singleton O Factory)
```java
public class Singleton {
    private static Singleton instance;

    private Singleton() { }  // Constructor privado

    public static Singleton getInstance() {
        if (instance == null) {
            instance = new Singleton();
        }
        return instance;
    }
}
```

### Factory ✓ OPCIONAL (Singleton O Factory)
```java
public class Factory {
    public static Producto crear(String tipo) {
        switch(tipo) {
            case "A": return new ProductoA();
            case "B": return new ProductoB();
            default: throw new IllegalArgumentException();
        }
    }
}
```

---

## File I/O - Template

```java
import java.io.*;
import java.util.*;

try (Scanner scanner = new Scanner(new File("archivo.txt"))) {
    // Leer primera linea (cantidad)
    int n = Integer.parseInt(scanner.nextLine());

    // Leer n elementos
    for (int i = 0; i < n; i++) {
        String linea = scanner.nextLine();
        String[] datos = linea.split(",");

        // Procesar datos
        String campo1 = datos[0];
        double campo2 = Double.parseDouble(datos[1]);
    }

    // Leer lineas variables
    while (scanner.hasNextLine()) {
        String linea = scanner.nextLine();
        String[] partes = linea.split(",");
        // Procesar...
    }

} catch (FileNotFoundException e) {
    System.out.println("Archivo no encontrado");
} catch (NumberFormatException e) {
    System.out.println("Error al parsear numero");
}
```

---

## Herencia - Template

```java
// Clase abstracta base
public abstract class Base {
    protected String atributoComun;

    public Base(String atributo) {
        this.atributoComun = atributo;
    }

    // Metodo abstracto - subclases DEBEN implementar
    public abstract String getTipo();

    // Metodo concreto - subclases pueden usar
    public void metodoComun() {
        System.out.println("Implementacion base");
    }
}

// Subclase
public class Derivada extends Base {
    private String atributoPropio;

    public Derivada(String comun, String propio) {
        super(comun);  // Llamar constructor padre
        this.atributoPropio = propio;
    }

    @Override
    public String getTipo() {
        return "Derivada";
    }
}
```

---

## Collections - Operaciones Comunes

```java
// ArrayList - Lista dinamica
List<Tipo> lista = new ArrayList<>();
lista.add(elemento);
lista.get(indice);
lista.size();
lista.remove(elemento);

// Iterar
for (Tipo elemento : lista) {
    // Procesar elemento
}

// HashMap - Busqueda rapida por clave
Map<String, Tipo> mapa = new HashMap<>();
mapa.put(clave, valor);
mapa.get(clave);
mapa.containsKey(clave);

// Iterar
for (Map.Entry<String, Tipo> entry : mapa.entrySet()) {
    String clave = entry.getKey();
    Tipo valor = entry.getValue();
}
```

---

## Formulas Rent a Car (EXAMEN)

### Eficiencia segun Modo
```
Eco:    eficienciaReal = nominal × 1.10  (10% MEJOR)
Normal: eficienciaReal = nominal × 1.00  (sin cambios)
Sport:  eficienciaReal = nominal × 0.75  (25% PEOR)
```

### Calculo de Consumo
```
consumo (litros) = distancia (km) / eficiencia (km/l)
```

### Ejemplo Completo
```
Vehiculo: 10 km/l nominal
Modo: Sport
Distancias: [100, 150, 200]

Paso 1: eficienciaReal = 10 × 0.75 = 7.5 km/l
Paso 2: consumo1 = 100 / 7.5 = 13.33 l
        consumo2 = 150 / 7.5 = 20.00 l
        consumo3 = 200 / 7.5 = 26.67 l
Paso 3: consumoTotal = 60.00 litros
        odometro = 450 km
```

---

## Swing GUI - Componentes Basicos

```java
import javax.swing.*;
import java.awt.*;

// Frame principal
JFrame frame = new JFrame("Titulo");
frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
frame.setSize(400, 400);

// Panel con layout
JPanel panel = new JPanel();
panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

// Agregar componentes
panel.add(new JButton("Boton"));
panel.add(new JLabel("Etiqueta"));

// Mostrar
frame.add(panel);
frame.setVisible(true);
```

**Layouts:**
- `BoxLayout.X_AXIS` - Horizontal
- `BoxLayout.Y_AXIS` - Vertical
- `new GridLayout(filas, cols)` - Cuadricula

---

## Validaciones Comunes

```java
// Validar RUT (########-#)
boolean rutValido(String rut) {
    return rut.matches("\\d{8}-\\d");
}

// Validar rango numerico
if (nota < 0 || nota > 100) {
    throw new IllegalArgumentException("Nota invalida");
}

// Validar archivo existe
File archivo = new File("datos.txt");
if (!archivo.exists()) {
    throw new FileNotFoundException("Archivo no existe");
}
```

---

## Formateo de Salida

```java
// Formato de decimales (2 decimales)
String formato = String.format("%.2f", numero);
System.out.printf("Precio: $%.2f\n", precio);

// Formato de salida examen
System.out.println(marca + " " + modelo + " CONSUMO: "
    + consumo + " l ODOMETRO: " + odometro + " km");

// Ejemplo: Toyota Camry CONSUMO: 45.67 l ODOMETRO: 1234 km
```

---

## Evitar Ciclos Anidados - Tecnicas

### MAL - Ciclos anidados
```java
for (Vehiculo v : flota) {
    for (Double distancia : v.getDistancias()) {
        // Procesar
    }
}
```

### BIEN - Metodos auxiliares
```java
for (Vehiculo v : flota) {
    v.procesarViajes();  // Metodo que procesa internamente
}

// En la clase Vehiculo
public void procesarViajes() {
    for (Double distancia : distancias) {
        // Procesar
    }
}
```

---

## Checklist Pre-Compilacion

Antes de compilar, verifica:
- [ ] Todos los imports necesarios
- [ ] @Override en metodos sobrescritos
- [ ] Constructores llaman a super() si heredan
- [ ] Try-catch para File I/O
- [ ] Cerrar recursos (usa try-with-resources)
- [ ] Nombres descriptivos de variables
- [ ] Comentarios en codigo no obvio

---

## Estructura Archivo Examen

```
fleet.txt estructura:
Linea 1: N (cantidad vehiculos)
Lineas 2 a N+1: VIN,Marca,Modelo,Tipo,Eficiencia
Lineas N+2 en adelante: VIN,Modo,Dist1,Dist2,...,DistN
```

---

## Errores Mas Comunes

1. No leer enunciado completo
2. Usar ciclos anidados
3. No usar patrones requeridos
4. Confundir eficiencia con consumo
5. No manejar excepciones
6. Nombres poco descriptivos
7. No probar antes de entregar
8. Listas separadas en vez de una sola
9. No hacer double dispatch en Visitor
10. Olvidar @Override

---

## Gestion del Tiempo (3 horas)

```
Minutos 0-20:   Leer y planificar
Minutos 20-40:  Crear jerarquia de clases
Minutos 40-60:  Implementar patrones
Minutos 60-120: Logica principal y File I/O
Minutos 120-150: Estadisticas y calculos
Minutos 150-180: Pruebas, correccion, exportar
```

---

**Imprime esta referencia y tenla a mano durante la practica!**
