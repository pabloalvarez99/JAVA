# Ejercicio 21: Ruteo - Sistema de Pagos con Strategy

**Nivel**: Intermedio
**Tiempo estimado**: 25-30 minutos
**Objetivo**: Practicar code tracing (ruteo) con patron Strategy
**Tipo**: Solo ruteo, NO programar

---

## INSTRUCCIONES

**NO ESCRIBAS CODIGO**. Este es un ejercicio de **RUTEO** (code tracing).

Lee el codigo que se presenta a continuacion y responde las preguntas al final.

---

## CODIGO A RUTEAR

```java
// Archivo: Main.java
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Ingresa el monto a pagar: ");
        double monto = Double.parseDouble(sc.nextLine());

        ProcesadorPagos procesador = ProcesadorPagos.getInstance();
        procesador.configurarEstrategia(monto);
        String resultado = procesador.procesarPago(monto);

        System.out.println(resultado);
        sc.close();
    }
}

// Archivo: ProcesadorPagos.java
public class ProcesadorPagos {
    private static ProcesadorPagos instance;
    private IEstrategiaPago estrategia;

    private ProcesadorPagos() {}

    public static ProcesadorPagos getInstance() {
        if (instance == null) {
            instance = new ProcesadorPagos();
        }
        return instance;
    }

    public void configurarEstrategia(double monto) {
        if (monto < 10000) {
            estrategia = new PagoEfectivo();
        } else if (monto >= 10000 && monto < 50000) {
            estrategia = new PagoTarjetaDebito();
        } else {
            estrategia = new PagoTarjetaCredito();
        }
    }

    public String procesarPago(double monto) {
        if (estrategia == null) {
            return "ERROR: No hay estrategia configurada";
        }
        return estrategia.pagar(monto);
    }
}

// Archivo: IEstrategiaPago.java
public interface IEstrategiaPago {
    String pagar(double monto);
}

// Archivo: PagoEfectivo.java
public class PagoEfectivo implements IEstrategiaPago {
    @Override
    public String pagar(double monto) {
        double cambio = calcularCambio(monto);
        return "PAGO EN EFECTIVO\n" +
               "Monto: $" + monto + "\n" +
               "Cambio: $" + cambio;
    }

    private double calcularCambio(double monto) {
        // Redondea al multiplo de 1000 superior
        double montoRedondeado = Math.ceil(monto / 1000) * 1000;
        return montoRedondeado - monto;
    }
}

// Archivo: PagoTarjetaDebito.java
public class PagoTarjetaDebito implements IEstrategiaPago {
    @Override
    public String pagar(double monto) {
        double recargo = monto * 0.02; // 2% de recargo
        double total = monto + recargo;
        return "PAGO CON TARJETA DE DEBITO\n" +
               "Subtotal: $" + monto + "\n" +
               "Recargo (2%): $" + recargo + "\n" +
               "Total: $" + total;
    }
}

// Archivo: PagoTarjetaCredito.java
public class PagoTarjetaCredito implements IEstrategiaPago {
    @Override
    public String pagar(double monto) {
        double descuento = monto * 0.05; // 5% de descuento
        double total = monto - descuento;
        int cuotas = calcularCuotas(monto);
        double montoCuota = total / cuotas;

        return "PAGO CON TARJETA DE CREDITO\n" +
               "Subtotal: $" + monto + "\n" +
               "Descuento (5%): $" + descuento + "\n" +
               "Total: $" + total + "\n" +
               "Cuotas: " + cuotas + " x $" + montoCuota;
    }

    private int calcularCuotas(double monto) {
        if (monto >= 100000) {
            return 12;
        } else if (monto >= 50000) {
            return 6;
        } else {
            return 3;
        }
    }
}
```

---

## PREGUNTAS

### Pregunta 1: Ruteo con monto = 5000
Si el usuario ingresa **5000**, cual sera la salida del programa?

**Tu respuesta**:
```
[Escribe aqui la salida completa]





```

---

### Pregunta 2: Ruteo con monto = 25000
Si el usuario ingresa **25000**, cual sera la salida del programa?

**Tu respuesta**:
```
[Escribe aqui la salida completa]







```

---

### Pregunta 3: Ruteo con monto = 75000
Si el usuario ingresa **75000**, cual sera la salida del programa?

**Tu respuesta**:
```
[Escribe aqui la salida completa]








```

---

### Pregunta 4: Identificacion de Patrones

a) Que patron de diseno se utiliza en la clase `ProcesadorPagos`?

**Tu respuesta**: _______________________________________________

b) Que patron de diseno se utiliza para cambiar la forma de pago?

**Tu respuesta**: _______________________________________________

c) Cuantas clases concretas implementan `IEstrategiaPago`?

**Tu respuesta**: _______________________________________________

---

### Pregunta 5: Analisis de Flujo

Dibuja un diagrama de flujo mostrando que sucede cuando el usuario ingresa un monto:

```
[Dibuja aqui el flujo desde Main hasta la salida]














```

---

### Pregunta 6: Modificacion Hipotetica

Si se agregara una nueva estrategia `PagoCriptomoneda` que se usa cuando el monto es mayor a 200000, donde deberia modificarse el codigo?

**Tu respuesta**:
```
[Indica los archivos y metodos que deberian cambiar]




```

---

## AUTOEVALUACION

Despues de responder, compara tus respuestas con las soluciones:

### Solucion Pregunta 1 (monto = 5000)
```
Ingresa el monto a pagar: 5000
PAGO EN EFECTIVO
Monto: $5000.0
Cambio: $1000.0
```

**Explicacion**:
- 5000 < 10000, se usa `PagoEfectivo`
- Redondea a 6000 (multiplo de 1000 superior)
- Cambio = 6000 - 5000 = 1000

---

### Solucion Pregunta 2 (monto = 25000)
```
Ingresa el monto a pagar: 25000
PAGO CON TARJETA DE DEBITO
Subtotal: $25000.0
Recargo (2%): $500.0
Total: $25500.0
```

**Explicacion**:
- 10000 <= 25000 < 50000, se usa `PagoTarjetaDebito`
- Recargo = 25000 * 0.02 = 500
- Total = 25000 + 500 = 25500

---

### Solucion Pregunta 3 (monto = 75000)
```
Ingresa el monto a pagar: 75000
PAGO CON TARJETA DE CREDITO
Subtotal: $75000.0
Descuento (5%): $3750.0
Total: $71250.0
Cuotas: 6 x $11875.0
```

**Explicacion**:
- 75000 >= 50000, se usa `PagoTarjetaCredito`
- Descuento = 75000 * 0.05 = 3750
- Total = 75000 - 3750 = 71250
- 50000 <= 75000 < 100000, cuotas = 6
- Monto por cuota = 71250 / 6 = 11875

---

### Solucion Pregunta 4
a) **Singleton** (getInstance, instancia unica)
b) **Strategy** (IEstrategiaPago con implementaciones intercambiables)
c) **3 clases** (PagoEfectivo, PagoTarjetaDebito, PagoTarjetaCredito)

---

### Solucion Pregunta 5
```
[Usuario ingresa monto]
        |
        v
[getInstance() - Singleton]
        |
        v
[configurarEstrategia(monto)]
        |
   ┌────┴────┐
   v         v
< 10000?   >= 10000?
   |         |
Efectivo   ┌─┴─┐
         Debito Credito
           |
           v
   [procesarPago(monto)]
           |
           v
   [estrategia.pagar(monto)]
           |
           v
      [Salida]
```

---

### Solucion Pregunta 6
Archivos a modificar:
1. **Crear**: `PagoCriptomoneda.java` (nueva clase)
2. **Modificar**: `ProcesadorPagos.java`, metodo `configurarEstrategia()`:
```java
public void configurarEstrategia(double monto) {
    if (monto < 10000) {
        estrategia = new PagoEfectivo();
    } else if (monto >= 10000 && monto < 50000) {
        estrategia = new PagoTarjetaDebito();
    } else if (monto >= 50000 && monto < 200000) { // NUEVO
        estrategia = new PagoTarjetaCredito();
    } else { // NUEVO
        estrategia = new PagoCriptomoneda();
    }
}
```

---

## REFLEXION

### Que aprendiste?
- Como seguir el flujo de ejecucion de un programa
- Como identificar patrones Singleton y Strategy
- Como calcular valores basados en condiciones
- Como el patron Strategy permite agregar comportamientos sin modificar mucho codigo

### Errores comunes
- Olvidar que Math.ceil() redondea hacia arriba
- Confundir los rangos de los if/else
- No seguir el flujo completo desde Main

---

**Tiempo de solucion**: 20-25 minutos
**Siguiente ejercicio**: Ejercicio22_RuteoVisitor.md
