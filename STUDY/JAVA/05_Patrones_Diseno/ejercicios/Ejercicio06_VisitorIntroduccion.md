# Ejercicio 6: Introduccion al Patron Visitor (Nivel 3)
**Dificultad:** Medio-Avanzado
**Tiempo estimado:** 75 minutos
**Conceptos:** Visitor Pattern, Double Dispatch, Polimorfismo

---

## Contexto

Una empresa de logistica necesita calcular costos de envio para diferentes tipos de paquetes. El calculo depende del tipo de paquete y del metodo de calculo que se use.

## Requisitos

### Tipos de Paquetes:

Todos los paquetes tienen:
- Codigo (String)
- Peso en kg (double)

Tipos especificos:

- **PaqueteDocumento:** numero de hojas (int)
  - Muy ligero, contiene documentos

- **PaqueteCaja:** dimensiones en cm: largo, ancho, alto (double cada uno)
  - Tiene volumen que afecta el costo

- **PaqueteFragil:** valor asegurado (double)
  - Requiere manejo especial

### Patron Visitor - Metodos de Calculo:

Implementar **dos Visitors** diferentes para calcular costos:

**1. CalculadorCostoEstandar:**
- Documento: $2 por kg + $0.10 por cada 10 hojas
- Caja: $3 por kg + $0.05 por cada 100 cm³ de volumen
- Fragil: $5 por kg + 2% del valor asegurado

**2. CalculadorCostoExpress:**
- Documento: $5 por kg + $0.20 por cada 10 hojas
- Caja: $8 por kg + $0.10 por cada 100 cm³ de volumen
- Fragil: $12 por kg + 5% del valor asegurado

### Funcionalidades:

1. Crear diferentes tipos de paquetes
2. Aplicar diferentes visitors para calcular costos
3. Mostrar comparacion entre metodos estandar y express

## Ejemplo de Ejecucion

```
=== SISTEMA DE ENVIOS ===

Paquetes registrados:
1. [DOC001] PaqueteDocumento - 0.5 kg - 50 hojas
2. [CAJ001] PaqueteCaja - 3.2 kg - 30x40x25 cm (30000 cm³)
3. [FRG001] PaqueteFragil - 1.5 kg - Valor asegurado: $500.00

=== CALCULO CON METODO ESTANDAR ===
[DOC001] Costo: $1.50 (peso: $1.00 + hojas: $0.50)
[CAJ001] Costo: $24.60 (peso: $9.60 + volumen: $15.00)
[FRG001] Costo: $17.50 (peso: $7.50 + seguro: $10.00)
TOTAL ESTANDAR: $43.60

=== CALCULO CON METODO EXPRESS ===
[DOC001] Costo: $3.50 (peso: $2.50 + hojas: $1.00)
[CAJ001] Costo: $55.60 (peso: $25.60 + volumen: $30.00)
[FRG001] Costo: $43.00 (peso: $18.00 + seguro: $25.00)
TOTAL EXPRESS: $102.10

=== COMPARACION ===
Ahorro usando Estandar: $58.50 (57.3%)
```

## Debe entregar:

- **Interface `Paquete`** con metodo: `double accept(VisitorCosto visitor)`
- Clases concretas: `PaqueteDocumento`, `PaqueteCaja`, `PaqueteFragil`
  - Cada una implementa `accept()`
- **Interface `VisitorCosto`** con metodos:
  ```java
  double visitarDocumento(PaqueteDocumento doc);
  double visitarCaja(PaqueteCaja caja);
  double visitarFragil(PaqueteFragil fragil);
  ```
- Clases visitors: `CalculadorCostoEstandar`, `CalculadorCostoExpress`
- Clase `SistemaEnvios` que gestione la lista de paquetes
- Clase `Main` que demuestre el patron

## Consideraciones:

- **DEBE implementar el patron Visitor correctamente**
- Usar "double dispatch" (llamar al visitor desde accept)
- Los calculos deben ser precisos
- Mostrar desglose de costos cuando sea posible
- El patron permite agregar nuevos metodos de calculo sin modificar las clases de paquetes

## Pistas - Implementacion Visitor:

```java
// Interface Paquete
public interface Paquete {
    double accept(VisitorCosto visitor);
}

// Clase concreta
public class PaqueteDocumento implements Paquete {
    private String codigo;
    private double peso;
    private int numeroHojas;

    @Override
    public double accept(VisitorCosto visitor) {
        return visitor.visitarDocumento(this);  // Double dispatch
    }

    // Getters...
}

// Interface Visitor
public interface VisitorCosto {
    double visitarDocumento(PaqueteDocumento doc);
    double visitarCaja(PaqueteCaja caja);
    double visitarFragil(PaqueteFragil fragil);
}

// Visitor concreto
public class CalculadorCostoEstandar implements VisitorCosto {
    @Override
    public double visitarDocumento(PaqueteDocumento doc) {
        double costoPeso = doc.getPeso() * 2;
        double costoHojas = (doc.getNumeroHojas() / 10) * 0.10;
        return costoPeso + costoHojas;
    }

    // Otros metodos...
}
```

## Formula para Volumen de Caja:

Volumen (cm³) = largo × ancho × alto

Ejemplo: 30 × 40 × 25 = 30,000 cm³

## Preguntas para reflexionar:

1. ¿Por que se llama "double dispatch"?
2. ¿Cual es la ventaja de usar Visitor en este caso?
3. ¿Como agregarias un tercer metodo de calculo (por ejemplo, "Internacional") sin modificar las clases de paquetes?

---

**El patron Visitor es OBLIGATORIO en el examen. Este ejercicio es esencial para dominarlo.**

---

## PASO A PASO: COMO RESOLVER ESTE EJERCICIO

El patron Visitor puede parecer complejo al principio, pero sigue una estructura muy definida. Vamos a construirlo paso por paso para que entiendas el "por que" detras de cada parte.

### PASO 1: Entender el Problema

El problema es:
- Tenemos diferentes tipos de paquetes (Documento, Caja, Fragil)
- Necesitamos calcular costos de DIFERENTES MANERAS (Estandar, Express)
- Podrian agregar mas metodos de calculo en el futuro (Internacional, Premium, etc.)

**Problema tradicional:** Si usas herencia normal, cada vez que agregas un nuevo metodo de calculo, tendrias que modificar TODAS las clases de paquetes.

**Solucion Visitor:** Separa la operacion (calculo de costo) de la estructura de objetos (paquetes). Puedes agregar nuevos Visitors sin tocar las clases de paquetes.

### PASO 2: Crear las Interfaces Base

Comienza con las dos interfaces fundamentales:

```java
// Interface para todos los paquetes
public interface Paquete {
    // El metodo accept es la clave del patron Visitor
    double accept(VisitorCosto visitor);

    // Metodo para mostrar informacion
    String getInformacion();
}
```

```java
// Interface para todos los visitors
public interface VisitorCosto {
    // Un metodo para CADA tipo de paquete
    double visitarDocumento(PaqueteDocumento doc);
    double visitarCaja(PaqueteCaja caja);
    double visitarFragil(PaqueteFragil fragil);
}
```

**Por que dos interfaces?**
- `Paquete`: Define que todos los paquetes pueden ser "visitados"
- `VisitorCosto`: Define que todos los visitors pueden visitar cada tipo de paquete

### PASO 3: Implementar PaqueteDocumento

Ahora crea el primer tipo de paquete concreto:

```java
public class PaqueteDocumento implements Paquete {
    private String codigo;
    private double peso;
    private int numeroHojas;

    public PaqueteDocumento(String codigo, double peso, int numeroHojas) {
        this.codigo = codigo;
        this.peso = peso;
        this.numeroHojas = numeroHojas;
    }

    @Override
    public double accept(VisitorCosto visitor) {
        // DOUBLE DISPATCH: El paquete se pasa a si mismo al visitor
        return visitor.visitarDocumento(this);
    }

    @Override
    public String getInformacion() {
        return String.format("[%s] PaqueteDocumento - %.1f kg - %d hojas",
                           codigo, peso, numeroHojas);
    }

    // Getters necesarios para que el visitor acceda a los datos
    public String getCodigo() { return codigo; }
    public double getPeso() { return peso; }
    public int getNumeroHojas() { return numeroHojas; }
}
```

**Concepto clave - Double Dispatch:**
1. Cuando llamas `paquete.accept(visitor)`, el paquete decide que TIPO es
2. Luego llama `visitor.visitarDocumento(this)`, pasandose a si mismo
3. El visitor ahora SABE que es un PaqueteDocumento y puede acceder a sus metodos especificos

### PASO 4: Implementar PaqueteCaja y PaqueteFragil

Sigue el mismo patron:

```java
public class PaqueteCaja implements Paquete {
    private String codigo;
    private double peso;
    private double largo;
    private double ancho;
    private double alto;

    public PaqueteCaja(String codigo, double peso, double largo, double ancho, double alto) {
        this.codigo = codigo;
        this.peso = peso;
        this.largo = largo;
        this.ancho = ancho;
        this.alto = alto;
    }

    @Override
    public double accept(VisitorCosto visitor) {
        return visitor.visitarCaja(this);  // Double dispatch
    }

    // Metodo de conveniencia para calcular volumen
    public double calcularVolumen() {
        return largo * ancho * alto;
    }

    @Override
    public String getInformacion() {
        return String.format("[%s] PaqueteCaja - %.1f kg - %.0fx%.0fx%.0f cm (%.0f cm³)",
                           codigo, peso, largo, ancho, alto, calcularVolumen());
    }

    public String getCodigo() { return codigo; }
    public double getPeso() { return peso; }
    public double getLargo() { return largo; }
    public double getAncho() { return ancho; }
    public double getAlto() { return alto; }
}
```

```java
public class PaqueteFragil implements Paquete {
    private String codigo;
    private double peso;
    private double valorAsegurado;

    public PaqueteFragil(String codigo, double peso, double valorAsegurado) {
        this.codigo = codigo;
        this.peso = peso;
        this.valorAsegurado = valorAsegurado;
    }

    @Override
    public double accept(VisitorCosto visitor) {
        return visitor.visitarFragil(this);  // Double dispatch
    }

    @Override
    public String getInformacion() {
        return String.format("[%s] PaqueteFragil - %.1f kg - Valor asegurado: $%.2f",
                           codigo, peso, valorAsegurado);
    }

    public String getCodigo() { return codigo; }
    public double getPeso() { return peso; }
    public double getValorAsegurado() { return valorAsegurado; }
}
```

### PASO 5: Implementar CalculadorCostoEstandar

Ahora implementa el primer Visitor:

```java
public class CalculadorCostoEstandar implements VisitorCosto {

    @Override
    public double visitarDocumento(PaqueteDocumento doc) {
        // Documento: $2 por kg + $0.10 por cada 10 hojas
        double costoPeso = doc.getPeso() * 2;
        double costoHojas = (doc.getNumeroHojas() / 10.0) * 0.10;
        return costoPeso + costoHojas;
    }

    @Override
    public double visitarCaja(PaqueteCaja caja) {
        // Caja: $3 por kg + $0.05 por cada 100 cm³
        double costoPeso = caja.getPeso() * 3;
        double volumen = caja.calcularVolumen();
        double costoVolumen = (volumen / 100.0) * 0.05;
        return costoPeso + costoVolumen;
    }

    @Override
    public double visitarFragil(PaqueteFragil fragil) {
        // Fragil: $5 por kg + 2% del valor asegurado
        double costoPeso = fragil.getPeso() * 5;
        double costoSeguro = fragil.getValorAsegurado() * 0.02;
        return costoPeso + costoSeguro;
    }
}
```

**Observa:** Cada metodo tiene acceso completo a los atributos especificos de cada tipo de paquete.

### PASO 6: Implementar CalculadorCostoExpress

```java
public class CalculadorCostoExpress implements VisitorCosto {

    @Override
    public double visitarDocumento(PaqueteDocumento doc) {
        // Documento: $5 por kg + $0.20 por cada 10 hojas
        double costoPeso = doc.getPeso() * 5;
        double costoHojas = (doc.getNumeroHojas() / 10.0) * 0.20;
        return costoPeso + costoHojas;
    }

    @Override
    public double visitarCaja(PaqueteCaja caja) {
        // Caja: $8 por kg + $0.10 por cada 100 cm³
        double costoPeso = caja.getPeso() * 8;
        double volumen = caja.calcularVolumen();
        double costoVolumen = (volumen / 100.0) * 0.10;
        return costoPeso + costoVolumen;
    }

    @Override
    public double visitarFragil(PaqueteFragil fragil) {
        // Fragil: $12 por kg + 5% del valor asegurado
        double costoPeso = fragil.getPeso() * 12;
        double costoSeguro = fragil.getValorAsegurado() * 0.05;
        return costoPeso + costoSeguro;
    }
}
```

**Ventaja del patron:** Agregaste un nuevo metodo de calculo SIN modificar ninguna clase de paquete.

### PASO 7: Crear la Clase SistemaEnvios

```java
import java.util.ArrayList;

public class SistemaEnvios {
    private ArrayList<Paquete> paquetes;

    public SistemaEnvios() {
        paquetes = new ArrayList<>();
    }

    public void agregarPaquete(Paquete paquete) {
        paquetes.add(paquete);
    }

    public void mostrarPaquetes() {
        System.out.println("\nPaquetes registrados:");
        for (int i = 0; i < paquetes.size(); i++) {
            System.out.println((i + 1) + ". " + paquetes.get(i).getInformacion());
        }
    }

    // Calcular costos usando un visitor especifico
    public double calcularCostoTotal(VisitorCosto visitor) {
        double total = 0;
        for (Paquete paquete : paquetes) {
            // Aqui es donde se aplica el patron Visitor
            double costo = paquete.accept(visitor);
            total += costo;
        }
        return total;
    }

    // Mostrar desglose de costos
    public void mostrarDesglose(VisitorCosto visitor, String nombreMetodo) {
        System.out.println("\n=== CALCULO CON METODO " + nombreMetodo.toUpperCase() + " ===");
        double total = 0;

        for (Paquete paquete : paquetes) {
            double costo = paquete.accept(visitor);
            System.out.printf("%s Costo: $%.2f%n",
                            paquete.getInformacion().split(" - ")[0], costo);
            total += costo;
        }

        System.out.printf("TOTAL %s: $%.2f%n", nombreMetodo.toUpperCase(), total);
    }

    // Comparar dos metodos
    public void compararMetodos(VisitorCosto v1, String nombre1,
                               VisitorCosto v2, String nombre2) {
        double costo1 = calcularCostoTotal(v1);
        double costo2 = calcularCostoTotal(v2);

        System.out.println("\n=== COMPARACION ===");
        if (costo1 < costo2) {
            double ahorro = costo2 - costo1;
            double porcentaje = (ahorro / costo2) * 100;
            System.out.printf("Ahorro usando %s: $%.2f (%.1f%%)%n",
                            nombre1, ahorro, porcentaje);
        } else {
            double ahorro = costo1 - costo2;
            double porcentaje = (ahorro / costo1) * 100;
            System.out.printf("Ahorro usando %s: $%.2f (%.1f%%)%n",
                            nombre2, ahorro, porcentaje);
        }
    }

    public int getCantidadPaquetes() {
        return paquetes.size();
    }
}
```

### PASO 8: Crear el Main

```java
public class Main {
    public static void main(String[] args) {
        System.out.println("=== SISTEMA DE ENVIOS ===");

        // Crear sistema
        SistemaEnvios sistema = new SistemaEnvios();

        // Crear paquetes
        PaqueteDocumento doc = new PaqueteDocumento("DOC001", 0.5, 50);
        PaqueteCaja caja = new PaqueteCaja("CAJ001", 3.2, 30, 40, 25);
        PaqueteFragil fragil = new PaqueteFragil("FRG001", 1.5, 500);

        // Agregar al sistema
        sistema.agregarPaquete(doc);
        sistema.agregarPaquete(caja);
        sistema.agregarPaquete(fragil);

        // Mostrar paquetes
        sistema.mostrarPaquetes();

        // Crear visitors
        VisitorCosto estandar = new CalculadorCostoEstandar();
        VisitorCosto express = new CalculadorCostoExpress();

        // Mostrar desglose de cada metodo
        sistema.mostrarDesglose(estandar, "Estandar");
        sistema.mostrarDesglose(express, "Express");

        // Comparar metodos
        sistema.compararMetodos(estandar, "Estandar", express, "Express");
    }
}
```

### PASO 9: Compilar y Ejecutar

```bash
javac Paquete.java VisitorCosto.java
javac PaqueteDocumento.java PaqueteCaja.java PaqueteFragil.java
javac CalculadorCostoEstandar.java CalculadorCostoExpress.java
javac SistemaEnvios.java Main.java
java Main
```

### ENTENDIENDO EL FLUJO

Cuando ejecutas `paquete.accept(visitor)`, esto es lo que sucede:

```
1. Main: paquete.accept(estandar)
2. PaqueteDocumento: return visitor.visitarDocumento(this)
3. CalculadorCostoEstandar: visitarDocumento(PaqueteDocumento doc) {...}
4. Calcula y retorna el costo
```

**Por que es "double dispatch"?**
1. Primera dispatch: `paquete.accept()` - despacha segun el tipo de paquete
2. Segunda dispatch: `visitor.visitarXXX()` - despacha segun el tipo de visitor

### ERRORES COMUNES A EVITAR

1. **Olvidar el `this` en accept:**
   ```java
   // INCORRECTO
   public double accept(VisitorCosto visitor) {
       return visitor.visitarDocumento();  // Falta this
   }

   // CORRECTO
   public double accept(VisitorCosto visitor) {
       return visitor.visitarDocumento(this);
   }
   ```

2. **No implementar todos los metodos del visitor:**
   ```java
   // El compilador te obligara a implementar TODOS los metodos
   // de la interface VisitorCosto
   ```

3. **Confundir division entera con double:**
   ```java
   // INCORRECTO - Division entera
   double costoHojas = (numeroHojas / 10) * 0.10;  // Si numeroHojas=55, da 5

   // CORRECTO - Division con decimales
   double costoHojas = (numeroHojas / 10.0) * 0.10;  // Da 5.5
   ```

4. **Getters faltantes:**
   ```java
   // Los visitors NECESITAN getters para acceder a los datos
   // Si no los tienes, no compilara
   ```

### VENTAJAS DEL PATRON VISITOR

1. **Agregar nuevas operaciones es facil:**
   - Crea un nuevo Visitor (ej: `CalculadorCostoInternacional`)
   - No tocas las clases de paquetes

2. **Codigo organizado:**
   - Cada visitor tiene toda su logica en un solo lugar
   - No dispersas el calculo entre multiples clases

3. **Cumple con Open/Closed Principle:**
   - Abierto para extension (nuevos visitors)
   - Cerrado para modificacion (paquetes no cambian)

### DESVENTAJA DEL PATRON VISITOR

Si agregas un NUEVO TIPO de paquete (ej: `PaqueteCongelado`):
- Tienes que modificar la interface `VisitorCosto`
- Tienes que actualizar TODOS los visitors existentes

**Conclusion:** Visitor es ideal cuando:
- Los tipos de objetos son estables (no cambian mucho)
- Las operaciones sobre ellos cambian frecuentemente

### EJERCICIO DE EXTENSION

Para practicar, intenta agregar:

1. **Un tercer Visitor - CalculadorCostoInternacional:**
   - Documento: $10 por kg + $0.50 por cada 10 hojas
   - Caja: $15 por kg + $0.20 por cada 100 cm³
   - Fragil: $25 por kg + 10% del valor asegurado

2. **Un nuevo metodo en SistemaEnvios:**
   ```java
   public Paquete encontrarMasCaro(VisitorCosto visitor) {
       // Retorna el paquete con mayor costo segun el visitor dado
   }
   ```

3. **Visitor para generar reportes:**
   ```java
   public class GeneradorReporte implements VisitorCosto {
       // En lugar de retornar double, imprime un reporte detallado
       // (Nota: Tendrias que cambiar el tipo de retorno o usar otro approach)
   }
   ```

### CONCEPTOS APRENDIDOS

1. **Patron Visitor:** Separar operaciones de estructuras de objetos
2. **Double Dispatch:** Dos niveles de polimorfismo
3. **Open/Closed Principle:** Extensible sin modificacion
4. **Interface Segregation:** Interfaces especificas para cada rol
5. **Polimorfismo avanzado:** Combinacion de interfaces y herencia

### PREGUNTAS DE REFLEXION - RESPUESTAS

**1. Por que se llama "double dispatch"?**
Porque hay dos llamadas polimorficas:
- Primera: `paquete.accept(visitor)` - polimorfismo basado en tipo de paquete
- Segunda: `visitor.visitarXXX(this)` - polimorfismo basado en tipo de visitor

**2. Cual es la ventaja de usar Visitor?**
Puedes agregar nuevas operaciones (nuevos visitors) sin modificar las clases de paquetes. Mantienes el codigo de cada operacion agrupado en un solo lugar.

**3. Como agregarias un tercer metodo de calculo sin modificar las clases de paquetes?**
Simplemente creas una nueva clase que implemente `VisitorCosto`. Las clases de paquetes no necesitan cambiar porque ya tienen el metodo `accept()`.

---

**El patron Visitor es complejo pero muy poderoso. Practica este ejercicio hasta que el flujo de double dispatch sea natural para ti.**

---

## 🎓 VENTAJAS DE ESTA ARQUITECTURA

### Sin Visitor (enfoque ingenuo):

```java
// CODIGO MALO: Calculos embebidos en cada clase de paquete
public class PaqueteDocumento {
    private String codigo;
    private double peso;
    private int numeroHojas;

    // PROBLEMA 1: Cada paquete tiene multiples metodos de calculo
    public double calcularCostoEstandar() {
        return peso * 2 + (numeroHojas / 10.0) * 0.10;
    }

    public double calcularCostoExpress() {
        return peso * 5 + (numeroHojas / 10.0) * 0.20;
    }

    public double calcularCostoInternacional() {
        return peso * 10 + (numeroHojas / 10.0) * 0.50;
    }

    public double calcularCostoPremium() {
        return peso * 15 + (numeroHojas / 10.0) * 1.00;
    }

    // PROBLEMA 2: Cada nuevo metodo de calculo requiere modificar TODAS las clases
    // PROBLEMA 3: Logica de calculo dispersa en multiples archivos
}

// Lo mismo para PaqueteCaja y PaqueteFragil - codigo MASIVAMENTE duplicado
public class PaqueteCaja {
    public double calcularCostoEstandar() { ... }
    public double calcularCostoExpress() { ... }
    public double calcularCostoInternacional() { ... }
    public double calcularCostoPremium() { ... }
    // Y asi sucesivamente...
}

// En Main.java - decide manualmente que metodo llamar
public class Main {
    public static void main(String[] args) {
        ArrayList<Object> paquetes = new ArrayList<>();
        paquetes.add(new PaqueteDocumento(...));
        paquetes.add(new PaqueteCaja(...));

        // PROBLEMA 4: If-else gigante para cada calculo
        String metodo = "estandar";
        for (Object obj : paquetes) {
            if (obj instanceof PaqueteDocumento) {
                PaqueteDocumento doc = (PaqueteDocumento) obj;
                if (metodo.equals("estandar")) {
                    System.out.println(doc.calcularCostoEstandar());
                } else if (metodo.equals("express")) {
                    System.out.println(doc.calcularCostoExpress());
                }
            } else if (obj instanceof PaqueteCaja) {
                PaqueteCaja caja = (PaqueteCaja) obj;
                if (metodo.equals("estandar")) {
                    System.out.println(caja.calcularCostoEstandar());
                } else if (metodo.equals("express")) {
                    System.out.println(caja.calcularCostoExpress());
                }
            }
            // Horror absoluto...
        }
    }
}
```

**Problemas criticos:**
- Viola Open/Closed Principle (modificas clases existentes constantemente)
- Logica de calculo dispersa en multiples clases
- Agregar nuevo metodo = modificar TODAS las clases de paquetes
- If-else monstruoso en codigo cliente
- Casting inseguro (instanceof everywhere)
- Dificil de mantener y testear

### Con Visitor (nuestra solucion):

```java
// CODIGO BUENO: Paquetes simples y estables
public class PaqueteDocumento implements Paquete {
    private String codigo;
    private double peso;
    private int numeroHojas;

    @Override
    public double accept(VisitorCosto visitor) {
        return visitor.visitarDocumento(this);  // Double dispatch
    }

    // Solo getters - NO logica de calculo
}

// Visitors centralizan TODA la logica de calculo
public class CalculadorCostoEstandar implements VisitorCosto {
    @Override
    public double visitarDocumento(PaqueteDocumento doc) {
        return doc.getPeso() * 2 + (doc.getNumeroHojas() / 10.0) * 0.10;
    }

    @Override
    public double visitarCaja(PaqueteCaja caja) {
        return caja.getPeso() * 3 + (caja.calcularVolumen() / 100.0) * 0.05;
    }

    @Override
    public double visitarFragil(PaqueteFragil fragil) {
        return fragil.getPeso() * 5 + fragil.getValorAsegurado() * 0.02;
    }
}

// NUEVO metodo de calculo = NUEVA clase Visitor
// NO tocas ninguna clase de paquete!
public class CalculadorCostoInternacional implements VisitorCosto {
    @Override
    public double visitarDocumento(PaqueteDocumento doc) {
        return doc.getPeso() * 10 + (doc.getNumeroHojas() / 10.0) * 0.50;
    }
    // ... otros metodos
}

// En Main.java - codigo elegante y limpio
public class Main {
    public static void main(String[] args) {
        ArrayList<Paquete> paquetes = new ArrayList<>();
        paquetes.add(new PaqueteDocumento(...));
        paquetes.add(new PaqueteCaja(...));

        // VENTAJA: Cambiar de metodo es trivial
        VisitorCosto visitor = new CalculadorCostoEstandar();

        for (Paquete paquete : paquetes) {
            double costo = paquete.accept(visitor);  // Una sola linea!
            System.out.println(costo);
        }

        // Cambiar a Express - una sola linea!
        visitor = new CalculadorCostoExpress();
        // Reutilizar el mismo loop
    }
}
```

**Ventajas:**
- Open/Closed: agregar operaciones sin modificar paquetes
- Logica centralizada: cada Visitor tiene TODA su logica
- Extensible: nuevo Visitor = nueva clase (no modificas existentes)
- Sin if-else: polimorfismo maneja todo
- Sin casting: compilador garantiza tipos correctos
- Facil de testear: cada Visitor se prueba independientemente

---

## ✅ CHECKLIST DE DOMINIO

Puedes considerar que dominas este ejercicio cuando:

### Conceptos Visitor:
- [ ] Entiendes que es "double dispatch" y por que se llama asi
- [ ] Sabes explicar las dos interfaces (Paquete y VisitorCosto)
- [ ] Comprendes por que Visitor separa operaciones de estructuras
- [ ] Identificas cuando Visitor es apropiado vs cuando no lo es

### Implementacion de Paquetes:
- [ ] Creas interface Paquete con metodo accept()
- [ ] Implementas tres clases concretas (Documento, Caja, Fragil)
- [ ] Cada clase llama al metodo correcto del visitor en accept()
- [ ] Pasas `this` al visitor (double dispatch)
- [ ] Provees getters para que visitor acceda a datos

### Implementacion de Visitors:
- [ ] Creas interface VisitorCosto con un metodo por tipo
- [ ] Implementas dos visitors concretos (Estandar, Express)
- [ ] Cada metodo visitarXXX() tiene acceso completo al paquete
- [ ] Retornas el resultado del calculo
- [ ] Puedes agregar un tercer visitor sin modificar paquetes

### Double Dispatch:
- [ ] Explicas el flujo: paquete.accept() → visitor.visitarXXX()
- [ ] Entiendes que el tipo de paquete determina que metodo se llama
- [ ] Sabes por que se necesitan DOS llamadas polimorficas
- [ ] Puedes diagramar el flujo completo

### Buenas Practicas:
- [ ] Usas nombres descriptivos (visitarDocumento, no visitar1)
- [ ] Cada visitor implementa TODOS los metodos de la interface
- [ ] No mezclas logica de negocio en accept()
- [ ] Formateas numeros correctamente
- [ ] Tu codigo compila sin warnings

### Tiempo:
- [ ] Implementas la solucion completa en < 75 minutos
- [ ] Puedes agregar un nuevo Visitor en < 15 minutos
- [ ] Explicas double dispatch sin mirar apuntes

---

## 🔗 RELACION CON EL EXAMEN

El patron Visitor es OBLIGATORIO en el examen - no puedes aprobar sin dominarlo.

### Comparacion: Este Ejercicio vs Examen

| Aspecto | Ejercicio 06 | Examen Real |
|---------|--------------|-------------|
| **Patron usado** | Visitor | Visitor (OBLIGATORIO) |
| | VisitorCosto | VisitorCalculos |
| **Jerarquia** | Paquete → 3 tipos | Vehiculo → 3 tipos |
| **Visitors implementados** | 2 (Estandar, Express) | 2-3 (Ganancias, Costos, etc.) |
| **Complejidad** | Media | Media-Alta |
| **Tiempo estimado** | 75 minutos | 30-35 minutos (parte Visitor) |
| **Double dispatch** | Si | Si |
| **Integracion** | Standalone | Con Strategy + File I/O |
| **Porcentaje del examen** | ~30% | Visitor es ~35% del total |

### Como se usa Visitor en el examen:

**En el examen (Ejercicio 10 - RentaCarCompleto):**
```java
// Interface Vehiculo
public interface Vehiculo {
    double accept(VisitorCalculos visitor);
}

// Clases concretas
public class Auto implements Vehiculo {
    @Override
    public double accept(VisitorCalculos visitor) {
        return visitor.visitarAuto(this);
    }
}

// Interface Visitor
public interface VisitorCalculos {
    double visitarAuto(Auto auto);
    double visitarSUV(SUV suv);
    double visitarCamioneta(Camioneta camioneta);
}

// Visitor de Ganancias (usa Strategy)
public class CalculadorGanancias implements VisitorCalculos {
    @Override
    public double visitarAuto(Auto auto) {
        // Usa la tarifa actual (Strategy Pattern)
        TarifaStrategy tarifa = auto.getTarifa();
        return tarifa.calcularTarifa(auto);
    }
    // ... otros metodos
}

// Visitor de Costos
public class CalculadorCostos implements VisitorCalculos {
    @Override
    public double visitarAuto(Auto auto) {
        return auto.calcularCostoCombustible();
    }
    // ... otros metodos
}

// En Main.java - aplicar visitors
public static void main(String[] args) {
    SistemaRentaCar sistema = SistemaRentaCar.getInstance();
    sistema.cargarVehiculos("datos.txt");

    // Establecer tarifa (Strategy)
    sistema.establecerTarifa(new TarifaDiurna());

    // Aplicar Visitor de Ganancias
    VisitorCalculos visitorGanancias = new CalculadorGanancias();
    double totalGanancias = sistema.calcularTotal(visitorGanancias);

    // Aplicar Visitor de Costos
    VisitorCalculos visitorCostos = new CalculadorCostos();
    double totalCostos = sistema.calcularTotal(visitorCostos);

    // Calcular ganancia neta
    double ganancia = totalGanancias - totalCostos;
}
```

**Diferencias clave con este ejercicio:**
1. **Integracion con Strategy:** Visitor de Ganancias usa la Strategy actual
2. **Jerarquia diferente:** Vehiculos en lugar de Paquetes
3. **Mas visitors:** Ganancias, Costos, posiblemente mas
4. **Mas complejidad:** Combinar 3 patrones (Visitor + Strategy + Singleton/Factory)

### Que cubre este ejercicio:

- ✅ **35% del examen:** Patron Visitor completo
- ✅ **Double Dispatch:** Flujo accept() → visitarXXX()
- ✅ **Dos interfaces:** Paquete y VisitorCosto
- ✅ **Multiples visitors:** Estandar, Express (similar a Ganancias, Costos)
- ✅ **Polimorfismo:** ArrayList<Paquete> con diferentes tipos
- ❌ **No cubre:** Strategy, File I/O (ver Ejercicio 07)

### Por que Visitor es el patron MAS IMPORTANTE:

1. **Obligatorio:** No puedes aprobar sin implementarlo
2. **Mas puntos:** Vale 35% del examen (mas que cualquier otro)
3. **Mas dificil:** Double dispatch confunde a muchos estudiantes
4. **Base para todo:** Strategy se integra CON Visitor

### Proximos pasos sugeridos:

1. **Ruta completa hacia el examen:**
   - ✅ Ejercicio 06 (este) - DOMINAR Visitor puro
   - ➡️ Ejercicio 07 - Integrar Visitor + Strategy + File I/O
   - ➡️ Ejercicio 10 - Simulacro completo de examen
   - 🔁 Repetir Ejercicio 06 hasta que sea automatico

2. **Practica adicional CRITICA:**
   - Implementa un tercer Visitor (CalculadorCostoInternacional)
   - Agrega un cuarto tipo de paquete (PaqueteCongelado)
   - Dibuja diagramas de flujo del double dispatch
   - Explica Visitor a alguien en voz alta

### Errores FATALES en el examen relacionados con Visitor:

1. **Olvidar `this` en accept()** → Visitor no puede acceder a datos → 0 puntos
2. **No implementar todos los metodos visitarXXX()** → Error compilacion → 0 puntos
3. **Poner logica en accept()** → No es double dispatch → Puntos parciales
4. **Confundir nombre de metodos** → visitarDocumento vs visitDocument → Error
5. **No retornar valor** → Visitor no funciona → 0 puntos

### Tips para el examen:

- ⏱️ **Tiempo:** Dedica MIN 30 minutos al Visitor (no apures esto)
- 📝 **Plantilla:** Memoriza la estructura de ambas interfaces
- ✅ **Verificacion:** Prueba CADA visitor con CADA tipo de objeto
- 🔍 **Prioridad:** Si falla algo, que NO sea Visitor
- 💡 **Estrategia:** Implementa Visitor PRIMERO, luego Strategy

### Relacion Visitor - Strategy:

```
Strategy: CUAL tarifa usar (Diurna vs Nocturna)
Visitor: COMO calcular usando esa tarifa

En el examen:
1. Estableces Strategy (tarifa diurna)
2. Aplicas Visitor Ganancias (usa la tarifa actual)
3. Cambias Strategy (tarifa nocturna)
4. Aplicas Visitor Ganancias OTRA VEZ (usa la nueva tarifa)
```

---

**Si dominas este ejercicio, tienes el 35% del examen garantizado. Visitor es EL patron mas importante - dedica el tiempo necesario para dominarlo COMPLETAMENTE.**
