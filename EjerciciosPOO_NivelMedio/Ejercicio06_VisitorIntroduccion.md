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
