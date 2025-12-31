# EJERCICIO DISENO #4: Sistema Bancario
**Dificultad: ⭐⭐⭐**

## Requerimientos

Disenar un sistema bancario basico:

1. **Clientes**
   - Datos personales (nombre, documento, contacto)
   - Un cliente puede tener multiples cuentas

2. **Cuentas**
   - Tipos: Ahorro, Corriente
   - Numero de cuenta unico
   - Saldo actual
   - Ahorro: genera interes mensual (0.5%)
   - Corriente: permite sobregiro hasta $500

3. **Transacciones**
   - Deposito
   - Retiro (validar saldo/sobregiro)
   - Transferencia entre cuentas
   - Historial de movimientos

4. **Reglas de Negocio**
   - Retiro minimo: $10
   - Transferencia maxima diaria: $5000
   - Cada transaccion genera registro inmutable

---

## PARTE 1: Tu Diseno

### 1.1 Clases y Herencia
```
Cuenta (abstracta?)
  |
  +-- CuentaAhorro
  |
  +-- CuentaCorriente

Otras clases:
1. _______________
2. _______________
```

### 1.2 Transacciones
```
Como modelarias las transacciones?
- Una clase Transaccion con tipo?
- Clases separadas por tipo?
- Patron Command?
```

---

## PARTE 2: Preguntas de Diseno

1. **Cuenta abstracta vs interfaz?**

2. **Como garantizas atomicidad en transferencias?**
   (Si falla el deposito despues del retiro?)

3. **Como implementarias el historial inmutable?**

---

## PARTE 3: Solucion Propuesta (NO MIRAR ANTES)

### Diagrama de Clases

```
+------------------+
|     Cliente      |
+------------------+
| - id: String     |
| - nombre: String |
| - documento: Str |
| - cuentas: List  |
+------------------+
        |
        v
+------------------+
|     Cuenta       | <<abstract>>
+------------------+
| - numero: String |
| - saldo: double  |
| - titular: Client|
| - transacciones  |
+------------------+
| + depositar()    |
| + retirar()      |
| # validarRetiro()|
+------------------+
        ^
        |
   +----+----+
   |         |
+--------+ +--------+
|Ahorro  | |Corrient|
+--------+ +--------+
|        | |-limite |
+--------+ +--------+
|+interes| |+validar|
+--------+ +--------+

+------------------+
|   Transaccion    |
+------------------+
| - id: String     |
| - tipo: TipoTx   |
| - monto: double  |
| - fecha: DateTime|
| - cuentaOrigen   |
| - cuentaDestino  |
+------------------+
```

### Codigo Esqueleto

```java
import java.time.*;
import java.util.*;

enum TipoTransaccion { DEPOSITO, RETIRO, TRANSFERENCIA, INTERES }

// Transaccion inmutable
record Transaccion(
    String id,
    TipoTransaccion tipo,
    double monto,
    LocalDateTime fecha,
    String cuentaOrigen,
    String cuentaDestino,
    String descripcion
) {
    public Transaccion {
        if (id == null) id = UUID.randomUUID().toString();
        if (fecha == null) fecha = LocalDateTime.now();
    }
}

abstract class Cuenta {
    protected String numero;
    protected double saldo;
    protected Cliente titular;
    protected List<Transaccion> transacciones = new ArrayList<>();

    public Cuenta(String numero, Cliente titular) {
        this.numero = numero;
        this.titular = titular;
        this.saldo = 0;
    }

    public void depositar(double monto) {
        if (monto <= 0) throw new IllegalArgumentException("Monto debe ser positivo");

        saldo += monto;
        registrarTransaccion(TipoTransaccion.DEPOSITO, monto, null, "Deposito");
    }

    public void retirar(double monto) {
        if (monto < 10) throw new IllegalArgumentException("Retiro minimo: $10");
        validarRetiro(monto);

        saldo -= monto;
        registrarTransaccion(TipoTransaccion.RETIRO, monto, null, "Retiro");
    }

    protected abstract void validarRetiro(double monto);

    protected void registrarTransaccion(TipoTransaccion tipo, double monto,
                                       String destino, String desc) {
        transacciones.add(new Transaccion(
            null, tipo, monto, null, this.numero, destino, desc
        ));
    }

    public List<Transaccion> getHistorial() {
        return Collections.unmodifiableList(transacciones);
    }

    public double getSaldo() { return saldo; }
    public String getNumero() { return numero; }
}

class CuentaAhorro extends Cuenta {
    private static final double TASA_INTERES_MENSUAL = 0.005; // 0.5%

    public CuentaAhorro(String numero, Cliente titular) {
        super(numero, titular);
    }

    @Override
    protected void validarRetiro(double monto) {
        if (monto > saldo) {
            throw new IllegalStateException(
                "Saldo insuficiente. Disponible: $" + saldo
            );
        }
    }

    public void aplicarInteresMensual() {
        double interes = saldo * TASA_INTERES_MENSUAL;
        saldo += interes;
        registrarTransaccion(TipoTransaccion.INTERES, interes, null,
            "Interes mensual " + (TASA_INTERES_MENSUAL * 100) + "%");
    }
}

class CuentaCorriente extends Cuenta {
    private double limiteSobregiro;
    private static final double SOBREGIRO_DEFAULT = 500;

    public CuentaCorriente(String numero, Cliente titular) {
        super(numero, titular);
        this.limiteSobregiro = SOBREGIRO_DEFAULT;
    }

    @Override
    protected void validarRetiro(double monto) {
        double disponible = saldo + limiteSobregiro;
        if (monto > disponible) {
            throw new IllegalStateException(
                "Excede limite. Disponible (con sobregiro): $" + disponible
            );
        }
    }

    public boolean estaEnSobregiro() {
        return saldo < 0;
    }
}

class Cliente {
    private String id;
    private String nombre;
    private String documento;
    private List<Cuenta> cuentas = new ArrayList<>();

    public void agregarCuenta(Cuenta cuenta) {
        cuentas.add(cuenta);
    }

    public double getPatrimonioTotal() {
        return cuentas.stream()
            .mapToDouble(Cuenta::getSaldo)
            .sum();
    }
}

class Banco {
    private Map<String, Cuenta> cuentas = new HashMap<>();
    private Map<String, Double> transferenciasHoy = new HashMap<>();
    private static final double LIMITE_TRANSFERENCIA_DIARIA = 5000;

    public void transferir(String origen, String destino, double monto) {
        Cuenta cuentaOrigen = cuentas.get(origen);
        Cuenta cuentaDestino = cuentas.get(destino);

        if (cuentaOrigen == null || cuentaDestino == null) {
            throw new IllegalArgumentException("Cuenta no encontrada");
        }

        // Validar limite diario
        double transferidoHoy = transferenciasHoy.getOrDefault(origen, 0.0);
        if (transferidoHoy + monto > LIMITE_TRANSFERENCIA_DIARIA) {
            throw new IllegalStateException(
                "Excede limite diario de transferencias"
            );
        }

        // Ejecutar transferencia atomica
        try {
            cuentaOrigen.retirar(monto);
            cuentaDestino.depositar(monto);

            // Registrar transferencia
            cuentaOrigen.registrarTransaccion(
                TipoTransaccion.TRANSFERENCIA, monto, destino,
                "Transferencia a " + destino
            );

            transferenciasHoy.merge(origen, monto, Double::sum);

        } catch (Exception e) {
            // Si algo falla, revertir
            // En un sistema real, usarias transacciones de BD
            throw new RuntimeException("Transferencia fallida: " + e.getMessage());
        }
    }
}
```

### Patrones Aplicados
- **Template Method**: validarRetiro() en clase abstracta
- **Immutable Object**: Transaccion como record
- **Strategy (implicit)**: Diferentes validaciones por tipo de cuenta

### Extensiones Posibles
- Tarjetas de debito/credito
- Prestamos
- Inversiones
- Notificaciones
- Multi-moneda
