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

**Este tipo de ejercicio es exactamente como el Problema 1 del examen. Practica varios similares.**
