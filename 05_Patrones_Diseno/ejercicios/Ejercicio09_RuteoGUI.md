# Ejercicio 9: Ruteo de Codigo con GUI y Patrones (Nivel 5)
**Dificultad:** Medio
**Tiempo estimado:** 45 minutos
**Conceptos:** Code Tracing, Singleton, Strategy, Swing GUI

---

## Contexto

Este ejercicio es similar al **Problema 1 del examen** (Ruteo). Debes trazar el codigo y responder preguntas sobre su ejecucion.

## Codigo a Rutear

```java
import javax.swing.*;
import java.awt.*;

public class Main {
    public static void main(String[] args) {
        ConfiguradorVentana config = ConfiguradorVentana.getInstance();
        config.setTamanioPantalla(600);
        config.aplicarConfiguracion();
    }
}

class ConfiguradorVentana {
    private static ConfiguradorVentana instance;
    private EstrategiaLayout estrategia;
    private int tamanio;

    private ConfiguradorVentana() {
        this.tamanio = 400;
    }

    public static ConfiguradorVentana getInstance() {
        if (instance == null) {
            instance = new ConfiguradorVentana();
        }
        return instance;
    }

    public void setTamanioPantalla(int tamanio) {
        this.tamanio = tamanio;
        System.out.println("Tamanio configurado: " + tamanio + "px");

        if (tamanio >= 800) {
            estrategia = new LayoutHorizontal();
        } else if (tamanio >= 400 && tamanio < 800) {
            estrategia = new LayoutVertical();
        } else {
            System.out.println("Tamanio muy pequenio. Usando layout vertical por defecto.");
            estrategia = new LayoutVertical();
        }
    }

    public void aplicarConfiguracion() {
        if (estrategia == null) {
            System.out.println("Estrategia no configurada. Usando vertical por defecto.");
            estrategia = new LayoutVertical();
        }

        JFrame frame = new JFrame("Aplicacion con Layout");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(tamanio, tamanio);

        JPanel panel = estrategia.crearPanel();
        frame.add(panel);

        frame.setVisible(true);
    }
}

interface EstrategiaLayout {
    JPanel crearPanel();
}

class LayoutHorizontal implements EstrategiaLayout {
    public JPanel crearPanel() {
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.X_AXIS));
        agregarBotones(panel);
        return panel;
    }

    private void agregarBotones(JPanel panel) {
        for (int i = 1; i <= 4; i++) {
            panel.add(new JButton("Boton " + i));
        }
    }
}

class LayoutVertical implements EstrategiaLayout {
    public JPanel crearPanel() {
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        agregarBotones(panel);
        return panel;
    }

    private void agregarBotones(JPanel panel) {
        for (int i = 1; i <= 4; i++) {
            panel.add(new JButton("Boton " + i));
        }
    }
}
```

## Preguntas (Responde en un archivo de texto)

### 1. Traza la ejecucion (10 puntos)
Describe paso a paso que sucede cuando se ejecuta el programa:
- ¿Que metodos se llaman y en que orden?
- ¿Que valores toman las variables importantes?
- ¿Que objetos se crean?

### 2. Dibuja la interfaz grafica (5 puntos)
Dibuja como se vera la ventana cuando se ejecute el programa.
Incluye:
- Tamanio de la ventana
- Posicion y orientacion de los botones
- Texto de cada boton

### 3. Patron Singleton (3 puntos)
a) ¿Cuantas instancias de `ConfiguradorVentana` se crean durante la ejecucion?
b) ¿Que pasaria si llamamos `getInstance()` dos veces?
c) ¿Por que el constructor es privado?

### 4. Patron Strategy (4 puntos)
a) ¿Que estrategia se usa en este caso? (Horizontal o Vertical)
b) ¿Que pasaria si cambiamos `setTamanioPantalla(600)` por `setTamanioPantalla(900)`?
c) ¿Como cambiaria la interfaz grafica?

### 5. Modificacion del codigo (5 puntos)
a) ¿Que sucede al presionar el boton "X" de la ventana?
b) ¿Como agregarias una tercera estrategia "LayoutCuadricula" (GridLayout 2x2)?

### 6. Analisis de flujo (3 puntos)
¿Que se imprime por consola cuando se ejecuta el programa?

---

## Como resolver:

1. **Lee el codigo DOS veces completas**
2. Traza la ejecucion linea por linea en papel
3. Anota los valores de variables importantes
4. Identifica los patrones usados
5. Dibuja la interfaz resultante
6. Responde cada pregunta con detalle

## Archivo a entregar:

Crea un archivo `respuestas_ejercicio09.txt` con todas tus respuestas.

## Solucion esperada:

Al completar este ejercicio, deberias ser capaz de:
- Trazar codigo con patrones complejos
- Visualizar interfaces GUI sin ejecutar
- Identificar patrones en codigo existente
- Predecir comportamiento de programas

---

## SOLUCION COMPLETA Y EXPLICACION DETALLADA

### Pregunta 1: Traza Completa de la Ejecucion (10 puntos)

**Traza paso a paso:**

```
PASO 1: main() inicia
├─ Linea 21: Se llama a ConfiguradorVentana.getInstance()

PASO 2: getInstance() (primera llamada)
├─ Linea 36: Verifica if (instance == null)
├─ instance es null (primera vez)
├─ Linea 37: Crea nueva instancia → instance = new ConfiguradorVentana()

PASO 3: Constructor privado ConfiguradorVentana()
├─ Linea 32: Inicializa this.tamanio = 400
├─ Retorna al getInstance()
├─ Linea 39: getInstance() retorna instance
├─ Variable config ahora referencia al Singleton

PASO 4: main() continua
├─ Linea 22: config.setTamanioPantalla(600)

PASO 5: setTamanioPantalla(600)
├─ Linea 43: this.tamanio = 600
├─ Linea 44: System.out.println("Tamanio configurado: 600px")
│   SALIDA CONSOLA: "Tamanio configurado: 600px"
├─ Linea 46: Evalua if (600 >= 800) → FALSE
├─ Linea 48: Evalua else if (600 >= 400 && 600 < 800) → TRUE
├─ Linea 49: estrategia = new LayoutVertical()
│   Crea instancia de LayoutVertical y la asigna
├─ Retorna a main()

PASO 6: main() continua
├─ Linea 23: config.aplicarConfiguracion()

PASO 7: aplicarConfiguracion()
├─ Linea 57: Evalua if (estrategia == null) → FALSE
│   (estrategia ya fue asignada en setTamanioPantalla)
├─ Linea 62: Crea JFrame frame = new JFrame("Aplicacion con Layout")
├─ Linea 63: frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE)
├─ Linea 64: frame.setSize(600, 600)
│   Tamanio de ventana: 600x600 pixeles
├─ Linea 66: panel = estrategia.crearPanel()
│   Llama a LayoutVertical.crearPanel()

PASO 8: LayoutVertical.crearPanel()
├─ Linea 94: Crea JPanel panel = new JPanel()
├─ Linea 95: panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS))
│   Layout vertical (eje Y)
├─ Linea 96: Llama agregarBotones(panel)

PASO 9: LayoutVertical.agregarBotones(panel)
├─ Linea 101: Ciclo for (i = 1; i <= 4; i++)
│   Iteracion 1: panel.add(new JButton("Boton 1"))
│   Iteracion 2: panel.add(new JButton("Boton 2"))
│   Iteracion 3: panel.add(new JButton("Boton 3"))
│   Iteracion 4: panel.add(new JButton("Boton 4"))
├─ Retorna a crearPanel()
├─ Linea 97: return panel
├─ Retorna a aplicarConfiguracion()

PASO 10: aplicarConfiguracion() continua
├─ Linea 67: frame.add(panel)
│   Agrega el panel con los 4 botones verticales
├─ Linea 69: frame.setVisible(true)
│   LA VENTANA SE HACE VISIBLE
├─ Retorna a main()

PASO 11: main() termina
├─ Programa queda esperando eventos GUI
```

**Variables importantes y sus valores:**
- `instance`: null → ConfiguradorVentana@123abc (objeto Singleton)
- `tamanio`: 400 (constructor) → 600 (setTamanioPantalla)
- `estrategia`: null → LayoutVertical@456def
- `frame`: JFrame 600x600 con titulo "Aplicacion con Layout"
- `panel`: JPanel con BoxLayout.Y_AXIS y 4 botones

**Objetos creados:**
1. ConfiguradorVentana (Singleton) - 1 instancia
2. LayoutVertical (Strategy concreta) - 1 instancia
3. JFrame - 1 instancia
4. JPanel - 1 instancia
5. JButton - 4 instancias ("Boton 1", "Boton 2", "Boton 3", "Boton 4")

---

### Pregunta 2: Dibujo de la Interfaz Grafica (5 puntos)

```
┌─────────────────────────────────────────────┐
│  Aplicacion con Layout               [_][□][X]│
├─────────────────────────────────────────────┤
│                                             │
│          ┌───────────────────┐              │
│          │     Boton 1       │              │
│          └───────────────────┘              │
│                                             │
│          ┌───────────────────┐              │
│          │     Boton 2       │              │
│          └───────────────────┘              │
│                                             │
│          ┌───────────────────┐              │
│          │     Boton 3       │              │
│          └───────────────────┘              │
│                                             │
│          ┌───────────────────┐              │
│          │     Boton 4       │              │
│          └───────────────────┘              │
│                                             │
│                                             │
└─────────────────────────────────────────────┘
 Tamanio: 600x600 pixels
```

**Caracteristicas:**
- **Tamanio:** 600 x 600 pixeles
- **Orientacion:** Vertical (BoxLayout.Y_AXIS)
- **Botones:** 4 botones apilados verticalmente
- **Texto:** "Boton 1", "Boton 2", "Boton 3", "Boton 4"
- **Centrado:** Los botones estan centrados horizontalmente

---

### Pregunta 3: Patron Singleton (3 puntos)

**a) Cuantas instancias se crean?**

**Respuesta:** Se crea **EXACTAMENTE 1 instancia** de ConfiguradorVentana.

**Explicacion:**
- Primera llamada a `getInstance()`: `instance` es null, se crea el objeto
- El campo `static instance` guarda la referencia
- Todas las llamadas siguientes retornan la misma instancia

**b) Que pasaria si llamamos getInstance() dos veces?**

```java
ConfiguradorVentana config1 = ConfiguradorVentana.getInstance(); // Primera llamada
ConfiguradorVentana config2 = ConfiguradorVentana.getInstance(); // Segunda llamada

// config1 == config2 → TRUE (misma instancia)
```

**Resultado:**
- Primera llamada: Crea la instancia
- Segunda llamada: `instance` NO es null, retorna la instancia existente
- Ambas variables apuntan al MISMO objeto
- `config1 == config2` es `true`

**c) Por que el constructor es privado?**

**Respuesta:** El constructor es privado para **impedir** que se creen instancias desde fuera de la clase.

**Si fuera publico:**
```java
// Esto seria posible y romperia el patron
ConfiguradorVentana ventana1 = new ConfiguradorVentana(); // Instancia 1
ConfiguradorVentana ventana2 = new ConfiguradorVentana(); // Instancia 2 (mal!)
```

**Al ser privado:**
```java
// Esto da ERROR de compilacion
ConfiguradorVentana ventana = new ConfiguradorVentana(); // ❌ Constructor privado
```

**Garantiza:** Solo puede haber UNA instancia (creada dentro de getInstance())

---

### Pregunta 4: Patron Strategy (4 puntos)

**a) Que estrategia se usa en este caso?**

**Respuesta:** Se usa **LayoutVertical**

**Razon:**
```java
setTamanioPantalla(600);
// 600 >= 400 && 600 < 800 → TRUE
// estrategia = new LayoutVertical();
```

El tamanio 600 esta en el rango [400, 800), por lo que se selecciona LayoutVertical.

**b) Que pasaria si cambiamos setTamanioPantalla(600) por setTamanioPantalla(900)?**

**Nueva traza:**
```java
setTamanioPantalla(900);
// Linea 46: if (900 >= 800) → TRUE
// Linea 47: estrategia = new LayoutHorizontal();
```

**Resultado:**
- Se crea instancia de **LayoutHorizontal** en lugar de LayoutVertical
- `estrategia` apunta a LayoutHorizontal
- El panel tendra layout horizontal (BoxLayout.X_AXIS)

**c) Como cambiaria la interfaz grafica?**

**Con tamanio 900:**

```
┌───────────────────────────────────────────────────────────────────────┐
│  Aplicacion con Layout                                    [_][□][X]    │
├───────────────────────────────────────────────────────────────────────┤
│                                                                        │
│  ┌─────────┐  ┌─────────┐  ┌─────────┐  ┌─────────┐                  │
│  │ Boton 1 │  │ Boton 2 │  │ Boton 3 │  │ Boton 4 │                  │
│  └─────────┘  └─────────┘  └─────────┘  └─────────┘                  │
│                                                                        │
│                                                                        │
└───────────────────────────────────────────────────────────────────────┘
 Tamanio: 900x900 pixels
```

**Cambios:**
- **Tamanio:** 900 x 900 pixels (mas grande)
- **Orientacion:** HORIZONTAL (botones en fila, no en columna)
- **BoxLayout:** BoxLayout.X_AXIS en lugar de Y_AXIS
- **Botones:** Alineados horizontalmente de izquierda a derecha

---

### Pregunta 5: Modificacion del Codigo (5 puntos)

**a) Que sucede al presionar el boton "X" de la ventana?**

**Respuesta:**

```java
frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
```

**Comportamiento:**
- Al presionar [X], se ejecuta la operacion EXIT_ON_CLOSE
- **Termina la aplicacion COMPLETAMENTE**
- Llama a `System.exit(0)` internamente
- La JVM se cierra

**Alternativas comunes:**
- `HIDE_ON_CLOSE`: Solo oculta la ventana
- `DISPOSE_ON_CLOSE`: Destruye la ventana pero no termina la aplicacion
- `DO_NOTHING_ON_CLOSE`: Ignora el click en X

**b) Como agregarias una tercera estrategia "LayoutCuadricula" (GridLayout 2x2)?**

**Paso 1: Crear la clase LayoutCuadricula**

```java
class LayoutCuadricula implements EstrategiaLayout {
    @Override
    public JPanel crearPanel() {
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(2, 2, 10, 10)); // 2 filas, 2 columnas, gap de 10px
        agregarBotones(panel);
        return panel;
    }

    private void agregarBotones(JPanel panel) {
        for (int i = 1; i <= 4; i++) {
            panel.add(new JButton("Boton " + i));
        }
    }
}
```

**Paso 2: Modificar setTamanioPantalla para incluir la nueva estrategia**

```java
public void setTamanioPantalla(int tamanio) {
    this.tamanio = tamanio;
    System.out.println("Tamanio configurado: " + tamanio + "px");

    if (tamanio >= 800) {
        estrategia = new LayoutHorizontal();
    } else if (tamanio >= 400 && tamanio < 800) {
        estrategia = new LayoutVertical();
    } else if (tamanio >= 200 && tamanio < 400) {
        estrategia = new LayoutCuadricula();  // NUEVO
    } else {
        System.out.println("Tamanio muy pequenio. Usando cuadricula por defecto.");
        estrategia = new LayoutCuadricula();
    }
}
```

**Paso 3: Ejemplo de uso**

```java
config.setTamanioPantalla(300);  // Usara LayoutCuadricula
```

**Resultado visual:**

```
┌─────────────────────────────┐
│  Aplicacion con Layout  [X] │
├─────────────────────────────┤
│  ┌──────────┐ ┌──────────┐  │
│  │ Boton 1  │ │ Boton 2  │  │
│  └──────────┘ └──────────┘  │
│  ┌──────────┐ ┌──────────┐  │
│  │ Boton 3  │ │ Boton 4  │  │
│  └──────────┘ └──────────┘  │
└─────────────────────────────┘
```

**Ventaja del Patron Strategy:**
- Agregaste un nuevo layout SIN modificar las clases existentes
- Solo creaste una nueva clase que implementa EstrategiaLayout
- El ConfiguradorVentana puede usar cualquiera sin cambios

---

### Pregunta 6: Analisis de Flujo - Salida por Consola (3 puntos)

**Respuesta:**

La salida EXACTA por consola es:

```
Tamanio configurado: 600px
```

**Explicacion:**
- **Linea 44 de setTamanioPantalla:** Es el UNICO `System.out.println` que se ejecuta
- Imprime: `"Tamanio configurado: " + tamanio + "px"`
- Con tamanio = 600: `"Tamanio configurado: 600px"`

**NO se imprime:**
- Linea 51: "Tamanio muy pequenio..." → NO se ejecuta (600 >= 400)
- Linea 58: "Estrategia no configurada..." → NO se ejecuta (estrategia NO es null)

---

## CONCEPTOS CLAVE APRENDIDOS

### 1. Patron Singleton
```java
// Caracteristicas:
- Constructor privado
- Variable static que guarda la instancia
- Metodo getInstance() que controla la creacion
- Solo existe UNA instancia en toda la aplicacion
```

### 2. Patron Strategy
```java
// Caracteristicas:
- Interface EstrategiaLayout
- Multiples implementaciones (Horizontal, Vertical)
- El contexto (ConfiguradorVentana) puede cambiar de estrategia
- Comportamiento se selecciona en tiempo de ejecucion
```

### 3. Componentes Swing
```java
JFrame → Ventana principal
JPanel → Contenedor para componentes
JButton → Boton interactivo
BoxLayout → Layout que apila componentes (X o Y)
GridLayout → Layout de cuadricula (filas x columnas)
```

### 4. Ruteo de Codigo
**Tecnicas importantes:**
- Trazar linea por linea
- Anotar valores de variables clave
- Identificar objetos creados
- Seguir el flujo de llamadas a metodos
- Distinguir entre creacion e invocacion

---

## ERRORES COMUNES AL RUTEAR CODIGO

**Error 1: No seguir el constructor**
```
✗ Asumir que tamanio es 600 desde el inicio
✓ tamanio inicia en 400 (constructor), luego cambia a 600
```

**Error 2: Confundir creacion con invocacion**
```
✗ "Se crea LayoutVertical y se llama crearPanel()"
✓ "Se crea LayoutVertical" es DIFERENTE de "Se invoca crearPanel()"
   Crearla: linea 49
   Invocarla: linea 66
```

**Error 3: No identificar el double dispatch**
```
✗ "config tiene la estrategia"
✓ "config tiene UNA REFERENCIA a LayoutVertical, y cuando llama
   estrategia.crearPanel(), polimorficamente se ejecuta el metodo
   de LayoutVertical"
```

**Error 4: Olvidar que getInstance() puede llamarse multiples veces**
```
✗ "getInstance() crea una instancia"
✓ "getInstance() crea UNA instancia la PRIMERA VEZ, luego retorna
   la misma instancia en llamadas posteriores"
```

---

## PRACTICA ADICIONAL

Para dominar el ruteo de codigo:

**1. Modifica el tamanio y vuelve a rutear:**
```java
config.setTamanioPantalla(150);  // Que estrategia se usa?
config.setTamanioPantalla(1000); // Como cambia la GUI?
```

**2. Llama a getInstance() dos veces:**
```java
ConfiguradorVentana config1 = ConfiguradorVentana.getInstance();
config1.setTamanioPantalla(800);
ConfiguradorVentana config2 = ConfiguradorVentana.getInstance();
config2.aplicarConfiguracion();
// Que ventana se muestra? Por que?
```

**3. Agrega una tercera estrategia y rutea con ella:**
```java
config.setTamanioPantalla(300); // Usa LayoutCuadricula
```

---

**Este tipo de ejercicio es exactamente como el Problema 1 del examen. Practica varios similares.**
