# Ejercicio 3: Sistema Bancario con Singleton (Nivel 2)
**Dificultad:** Medio
**Tiempo estimado:** 40 minutos
**Conceptos:** Singleton Pattern, Encapsulamiento, ArrayList

---

## Contexto

Un banco necesita un sistema centralizado para gestionar todas las cuentas bancarias. Solo debe existir UNA instancia del sistema bancario en toda la aplicacion (patron Singleton).

## Requisitos

### Cuenta Bancaria:

Cada cuenta tiene:
- Numero de cuenta (String) - UNICO
- Titular (String)
- Saldo (double)

Operaciones de cuenta:
- Depositar dinero (aumenta el saldo)
- Retirar dinero (disminuye el saldo, solo si hay fondos suficientes)
- Consultar saldo

### Sistema Bancario (SINGLETON):

El sistema bancario debe:
- **Ser unico en toda la aplicacion** (patron Singleton)
- Almacenar todas las cuentas en una lista
- Crear nuevas cuentas (verificando que el numero no exista)
- Buscar cuenta por numero
- Realizar transferencias entre cuentas
- Mostrar resumen de todas las cuentas
- Calcular el saldo total del banco

## Ejemplo de Ejecucion

```
=== SISTEMA BANCARIO ===
Creando cuentas...
Cuenta creada: CTA001 - Juan Perez - $5000.00
Cuenta creada: CTA002 - Maria Lopez - $3000.00
Cuenta creada: CTA003 - Carlos Ruiz - $7500.00
ERROR: Ya existe una cuenta con numero CTA001

=== OPERACIONES ===
Juan Perez deposita $1000.00
Nuevo saldo: $6000.00

Maria Lopez retira $500.00
Nuevo saldo: $2500.00

Transferencia: CTA001 -> CTA002 por $2000.00
Transferencia exitosa.
Saldo CTA001: $4000.00
Saldo CTA002: $4500.00

=== RESUMEN BANCARIO ===
CTA001 - Juan Perez: $4000.00
CTA002 - Maria Lopez: $4500.00
CTA003 - Carlos Ruiz: $7500.00

Saldo total del banco: $16000.00

=== VERIFICACION SINGLETON ===
Sistema 1: SistemaBancario@1a2b3c4d
Sistema 2: SistemaBancario@1a2b3c4d
Son la misma instancia: true
```

## Debe entregar:

- Clase `CuentaBancaria` con sus atributos y metodos
- Clase `SistemaBancario` implementando el **patron Singleton**:
  - Constructor privado
  - Instancia estatica privada
  - Metodo `getInstance()` estatico publico
- Clase `Main` que demuestre:
  - Creacion de cuentas
  - Operaciones bancarias
  - Transferencias
  - Resumen del sistema
  - Verificacion de que solo existe una instancia

## Consideraciones:

- **DEBE implementar Singleton correctamente**
- No debe ser posible crear multiples instancias de `SistemaBancario`
- Validar que no se retiren mas fondos de los disponibles
- Validar que no existan numeros de cuenta duplicados
- Validar que la cuenta origen y destino existan antes de transferir
- Usar mensajes claros para errores y confirmaciones

## Pistas - Implementacion Singleton:

```java
public class SistemaBancario {
    private static SistemaBancario instance;

    // Constructor privado - nadie puede crear instancias directamente
    private SistemaBancario() {
        // Inicializar atributos
    }

    // Metodo para obtener la unica instancia
    public static SistemaBancario getInstance() {
        if (instance == null) {
            instance = new SistemaBancario();
        }
        return instance;
    }

    // ... resto de metodos
}
```

## Preguntas para reflexionar:

1. ¿Por que es util que el sistema bancario sea Singleton?
2. ¿Que pasaria si pudieramos crear multiples instancias del sistema?
3. ¿Como se compara la direccion de memoria de dos instancias?

---

## PASO A PASO: COMO RESOLVER ESTE EJERCICIO

Este ejercicio te ensenara el **Patron Singleton**, uno de los patrones de diseno mas importantes que puedes elegir usar en el examen.

### PASO 1: Entender el Patron Singleton

**Pregunta clave:** ¿Por que Solo UNA instancia?

Imagina si hubiera multiples sistemas bancarios:
- Sistema1 tiene cuentas {A, B, C}
- Sistema2 tiene cuentas {D, E}
- Sistema3 tiene cuentas {F}

**Problema:** Los datos estan fragmentados. No puedes transferir entre sistemas diferentes.

**Solucion Singleton:** UN SOLO sistema bancario que gestiona TODAS las cuentas.

**Reglas del Singleton:**
1. Constructor PRIVADO - nadie puede hacer `new SistemaBancario()`
2. Instancia estatica PRIVADA - guardada dentro de la clase
3. Metodo publico `getInstance()` - unica forma de obtener la instancia

### PASO 2: Crear la Clase CuentaBancaria

Primero la clase simple - una cuenta bancaria:

```java
public class CuentaBancaria {
    private String numeroCuenta;
    private String titular;
    private double saldo;

    public CuentaBancaria(String numeroCuenta, String titular, double saldoInicial) {
        this.numeroCuenta = numeroCuenta;
        this.titular = titular;
        this.saldo = saldoInicial;
    }

    // Depositar dinero
    public void depositar(double monto) {
        if (monto > 0) {
            saldo += monto;
            System.out.println(String.format("%s deposita $%.2f", titular, monto));
            System.out.println(String.format("Nuevo saldo: $%.2f", saldo));
        } else {
            System.out.println("ERROR: Monto invalido");
        }
    }

    // Retirar dinero (solo si hay fondos)
    public boolean retirar(double monto) {
        if (monto <= 0) {
            System.out.println("ERROR: Monto invalido");
            return false;
        }

        if (monto > saldo) {
            System.out.println("ERROR: Fondos insuficientes");
            return false;
        }

        saldo -= monto;
        System.out.println(String.format("%s retira $%.2f", titular, monto));
        System.out.println(String.format("Nuevo saldo: $%.2f", saldo));
        return true;
    }

    // Mostrar informacion
    public String obtenerResumen() {
        return String.format("%s - %s: $%.2f", numeroCuenta, titular, saldo);
    }

    // Getters
    public String getNumeroCuenta() { return numeroCuenta; }
    public String getTitular() { return titular; }
    public double getSaldo() { return saldo; }
}
```

### PASO 3: Crear el SistemaBancario con Patron Singleton

Aqui esta la CLAVE del patron:

```java
import java.util.ArrayList;

public class SistemaBancario {
    // PASO 1: Instancia estatica privada (UNICA instancia)
    private static SistemaBancario instance = null;

    // PASO 2: Atributos normales del sistema
    private ArrayList<CuentaBancaria> cuentas;

    // PASO 3: Constructor PRIVADO (nadie puede hacer new desde afuera)
    private SistemaBancario() {
        cuentas = new ArrayList<>();
        System.out.println("=== SISTEMA BANCARIO INICIALIZADO ===");
    }

    // PASO 4: Metodo publico para obtener la UNICA instancia
    public static SistemaBancario getInstance() {
        if (instance == null) {
            instance = new SistemaBancario();
        }
        return instance;
    }

    // Crear nueva cuenta
    public boolean crearCuenta(String numeroCuenta, String titular, double saldoInicial) {
        // Validar que no exista
        if (buscarCuenta(numeroCuenta) != null) {
            System.out.println("ERROR: Ya existe una cuenta con numero " + numeroCuenta);
            return false;
        }

        CuentaBancaria nuevaCuenta = new CuentaBancaria(numeroCuenta, titular, saldoInicial);
        cuentas.add(nuevaCuenta);
        System.out.println(String.format("Cuenta creada: %s - %s - $%.2f",
                                        numeroCuenta, titular, saldoInicial));
        return true;
    }

    // Buscar cuenta por numero
    public CuentaBancaria buscarCuenta(String numeroCuenta) {
        for (CuentaBancaria cuenta : cuentas) {
            if (cuenta.getNumeroCuenta().equals(numeroCuenta)) {
                return cuenta;
            }
        }
        return null;
    }

    // Transferir entre cuentas
    public boolean transferir(String cuentaOrigen, String cuentaDestino, double monto) {
        CuentaBancaria origen = buscarCuenta(cuentaOrigen);
        CuentaBancaria destino = buscarCuenta(cuentaDestino);

        // Validar que existan ambas cuentas
        if (origen == null) {
            System.out.println("ERROR: Cuenta origen no existe");
            return false;
        }
        if (destino == null) {
            System.out.println("ERROR: Cuenta destino no existe");
            return false;
        }

        // Intentar retirar de origen
        System.out.println(String.format("\nTransferencia: %s -> %s por $%.2f",
                                        cuentaOrigen, cuentaDestino, monto));

        if (!origen.retirar(monto)) {
            System.out.println("Transferencia fallida.");
            return false;
        }

        // Depositar en destino
        destino.depositar(monto);
        System.out.println("Transferencia exitosa.");
        System.out.println(String.format("Saldo %s: $%.2f", cuentaOrigen, origen.getSaldo()));
        System.out.println(String.format("Saldo %s: $%.2f", cuentaDestino, destino.getSaldo()));

        return true;
    }

    // Mostrar resumen de todas las cuentas
    public void mostrarResumen() {
        System.out.println("\n=== RESUMEN BANCARIO ===");
        for (CuentaBancaria cuenta : cuentas) {
            System.out.println(cuenta.obtenerResumen());
        }
    }

    // Calcular saldo total del banco
    public double calcularSaldoTotal() {
        double total = 0;
        for (CuentaBancaria cuenta : cuentas) {
            total += cuenta.getSaldo();
        }
        return total;
    }

    public int getTotalCuentas() {
        return cuentas.size();
    }
}
```

**Analisis del Singleton:**

1. **`private static SistemaBancario instance`**: Guarda LA UNICA instancia
2. **`private SistemaBancario()`**: Constructor privado - NADIE puede crear instancias
3. **`public static getInstance()`**: Unica forma de obtener la instancia
   - Si no existe (`null`), la crea
   - Si ya existe, retorna la misma

### PASO 4: Crear el Main y Demostrar el Singleton

```java
public class Main {
    public static void main(String[] args) {
        // Obtener la instancia del sistema (primera vez - se crea)
        SistemaBancario sistema = SistemaBancario.getInstance();

        System.out.println("\n=== CREANDO CUENTAS ===");
        sistema.crearCuenta("CTA001", "Juan Perez", 5000.00);
        sistema.crearCuenta("CTA002", "Maria Lopez", 3000.00);
        sistema.crearCuenta("CTA003", "Carlos Ruiz", 7500.00);

        // Intentar crear cuenta duplicada
        sistema.crearCuenta("CTA001", "Pedro Gomez", 1000.00);  // Debe fallar

        System.out.println("\n=== OPERACIONES ===");

        // Buscar y operar cuenta
        CuentaBancaria cuenta1 = sistema.buscarCuenta("CTA001");
        if (cuenta1 != null) {
            cuenta1.depositar(1000.00);
        }

        CuentaBancaria cuenta2 = sistema.buscarCuenta("CTA002");
        if (cuenta2 != null) {
            cuenta2.retirar(500.00);
        }

        // Transferencia
        sistema.transferir("CTA001", "CTA002", 2000.00);

        // Mostrar resumen
        sistema.mostrarResumen();

        System.out.println(String.format("\nSaldo total del banco: $%.2f",
                                        sistema.calcularSaldoTotal()));

        // VERIFICAR QUE ES SINGLETON
        System.out.println("\n=== VERIFICACION SINGLETON ===");

        // Obtener "otra" instancia
        SistemaBancario sistema2 = SistemaBancario.getInstance();

        // Comparar direcciones de memoria
        System.out.println("Sistema 1: " + sistema);
        System.out.println("Sistema 2: " + sistema2);
        System.out.println("Son la misma instancia: " + (sistema == sistema2));

        // Verificar que tienen las mismas cuentas
        System.out.println("Total cuentas en sistema1: " + sistema.getTotalCuentas());
        System.out.println("Total cuentas en sistema2: " + sistema2.getTotalCuentas());
    }
}
```

### PASO 5: Compilar y Ejecutar

```bash
javac CuentaBancaria.java SistemaBancario.java Main.java
java Main
```

### ERRORES COMUNES A EVITAR

1. **Constructor publico (ERROR CRITICO):**
   ```java
   // INCORRECTO - rompe el patron Singleton
   public SistemaBancario() { }

   // CORRECTO
   private SistemaBancario() { }
   ```

2. **Olvidar validar si instance es null:**
   ```java
   // INCORRECTO
   public static SistemaBancario getInstance() {
       return instance;  // Puede retornar null la primera vez!
   }

   // CORRECTO
   public static SistemaBancario getInstance() {
       if (instance == null) {
           instance = new SistemaBancario();
       }
       return instance;
   }
   ```

3. **No validar cuenta duplicada:**
   ```java
   // Siempre verifica antes de crear
   if (buscarCuenta(numeroCuenta) != null) {
       return false;
   }
   ```

4. **No validar fondos en transferencia:**
   ```java
   // Siempre valida que el retiro sea exitoso
   if (!origen.retirar(monto)) {
       return false;
   }
   ```

### CONCEPTOS APRENDIDOS

1. **Patron Singleton:** Garantiza UNA SOLA instancia de una clase
2. **Constructor privado:** Previene creacion externa de instancias
3. **Metodo estatico:** `getInstance()` es accesible sin instancia
4. **Lazy initialization:** La instancia se crea solo cuando se necesita
5. **Centralizacion de datos:** Todas las cuentas en un solo lugar

### COMPARACION: CON Y SIN SINGLETON

**Sin Singleton (MALO):**
```java
public class Main {
    public static void main(String[] args) {
        SistemaBancario sistema1 = new SistemaBancario();  // Permitido!
        sistema1.crearCuenta("CTA001", "Juan", 1000);

        SistemaBancario sistema2 = new SistemaBancario();  // Otro sistema!
        sistema2.crearCuenta("CTA002", "Maria", 2000);

        // PROBLEMA: No puedes transferir entre CTA001 y CTA002
        // porque estan en sistemas diferentes!
    }
}
```

**Con Singleton (BUENO):**
```java
public class Main {
    public static void main(String[] args) {
        SistemaBancario sistema1 = SistemaBancario.getInstance();
        sistema1.crearCuenta("CTA001", "Juan", 1000);

        SistemaBancario sistema2 = SistemaBancario.getInstance();
        sistema2.crearCuenta("CTA002", "Maria", 2000);

        // sistema1 y sistema2 son EL MISMO objeto
        // Puedes transferir sin problema!
        sistema1.transferir("CTA001", "CTA002", 500);
    }
}
```

### PREGUNTAS PARA REFLEXION

1. **¿Que pasa si dos partes del codigo llaman getInstance() simultaneamente?**
   - En programacion multi-hilo, podrian crearse dos instancias
   - Solucion avanzada: usar `synchronized` o inicializacion eagre

2. **¿Cuando NO deberias usar Singleton?**
   - Cuando necesitas multiples instancias independientes
   - Cuando dificulta las pruebas unitarias
   - Cuando crea acoplamiento global

3. **¿Como probarias que es realmente Singleton?**
   - Compara referencias con `==`
   - Verifica que datos se comparten entre "diferentes" instancias

### VARIANTES DEL PATRON SINGLETON

**Eager Initialization (Inicializacion temprana):**
```java
public class SistemaBancario {
    // Se crea inmediatamente al cargar la clase
    private static SistemaBancario instance = new SistemaBancario();

    private SistemaBancario() { }

    public static SistemaBancario getInstance() {
        return instance;  // Ya existe siempre
    }
}
```

**Lazy Initialization (Inicializacion perezosa) - la que usamos:**
```java
public class SistemaBancario {
    private static SistemaBancario instance = null;

    private SistemaBancario() { }

    public static SistemaBancario getInstance() {
        if (instance == null) {  // Crea solo cuando se necesita
            instance = new SistemaBancario();
        }
        return instance;
    }
}
```

### DESAFIOS ADICIONALES

1. Agrega un metodo para cerrar una cuenta
2. Implementa un sistema de prestamos entre cuentas
3. Agrega tipos de cuenta (Ahorro, Corriente) con reglas diferentes
4. Implementa un log de todas las transacciones
5. Agrega autenticacion con PIN para operaciones

---

**El patron Singleton es uno de los patrones que debes elegir en el examen (Singleton o Factory).**

---

## 🎓 VENTAJAS DE ESTA ARQUITECTURA

### Sin Singleton (enfoque ingenuo):

```java
// CODIGO MALO: Multiples instancias del sistema bancario
public class SistemaBancario {
    private ArrayList<CuentaBancaria> cuentas;

    // Constructor PUBLICO - cualquiera puede crear instancias
    public SistemaBancario() {
        cuentas = new ArrayList<>();
    }
}

// En Main.java
public class Main {
    public static void main(String[] args) {
        // PROBLEMA 1: Multiples sistemas independientes
        SistemaBancario sistema1 = new SistemaBancario();
        sistema1.crearCuenta("CTA001", "Juan", 1000);

        SistemaBancario sistema2 = new SistemaBancario();
        sistema2.crearCuenta("CTA002", "Maria", 2000);

        // PROBLEMA 2: No puedes transferir entre CTA001 y CTA002
        // porque estan en sistemas diferentes!
        sistema1.transferir("CTA001", "CTA002", 500);  // ERROR!

        // PROBLEMA 3: Datos fragmentados
        System.out.println("Total cuentas sistema1: " + sistema1.getTotalCuentas());  // 1
        System.out.println("Total cuentas sistema2: " + sistema2.getTotalCuentas());  // 1
        // ¿Cual es el total REAL? ¿2? ¿Pero estan en sistemas diferentes!

        // PROBLEMA 4: Cuentas duplicadas posibles
        SistemaBancario sistema3 = new SistemaBancario();
        sistema3.crearCuenta("CTA001", "Pedro", 3000);  // Mismo numero que en sistema1!
    }
}
```

**Problemas criticos:**
- Datos fragmentados en multiples instancias
- Imposible realizar operaciones entre sistemas
- Numeros de cuenta pueden duplicarse
- No hay control centralizado
- Desperdicio de memoria (multiples listas)
- Viola el principio de responsabilidad unica

### Con Singleton (nuestra solucion):

```java
public class SistemaBancario {
    private static SistemaBancario instance = null;
    private ArrayList<CuentaBancaria> cuentas;

    // Constructor PRIVADO - nadie puede crear instancias
    private SistemaBancario() {
        cuentas = new ArrayList<>();
    }

    // Unico punto de acceso
    public static SistemaBancario getInstance() {
        if (instance == null) {
            instance = new SistemaBancario();
        }
        return instance;
    }
}

// En Main.java
public class Main {
    public static void main(String[] args) {
        // VENTAJA 1: Siempre obtienes la MISMA instancia
        SistemaBancario sistema1 = SistemaBancario.getInstance();
        sistema1.crearCuenta("CTA001", "Juan", 1000);

        SistemaBancario sistema2 = SistemaBancario.getInstance();
        sistema2.crearCuenta("CTA002", "Maria", 2000);

        // VENTAJA 2: Las transferencias funcionan sin problema
        sistema1.transferir("CTA001", "CTA002", 500);  // FUNCIONA!

        // VENTAJA 3: Datos centralizados
        System.out.println("Total cuentas: " + sistema1.getTotalCuentas());  // 2
        System.out.println("Son el mismo: " + (sistema1 == sistema2));  // true

        // VENTAJA 4: Imposible duplicar numeros de cuenta
        sistema2.crearCuenta("CTA001", "Pedro", 3000);  // ERROR detectado!
    }
}
```

**Ventajas:**
- UNA sola instancia garantizada
- Datos centralizados en un solo lugar
- Control global sobre todas las cuentas
- Validaciones efectivas (no duplicados)
- Ahorro de memoria
- Acceso global consistente

---

## ✅ CHECKLIST DE DOMINIO

Puedes considerar que dominas este ejercicio cuando:

### Conceptos Singleton:
- [ ] Entiendes por que se necesita UNA sola instancia del sistema bancario
- [ ] Sabes explicar que es "lazy initialization" vs "eager initialization"
- [ ] Puedes identificar casos de uso apropiados para Singleton
- [ ] Entiendes las tres partes: constructor privado, instancia estatica, getInstance()

### Implementacion:
- [ ] Implementas el constructor PRIVADO correctamente
- [ ] Creas la instancia estatica privada
- [ ] Implementas getInstance() con validacion de null
- [ ] Puedes verificar que dos variables apuntan a la misma instancia (con ==)

### Logica Bancaria:
- [ ] Validas que no existan cuentas duplicadas antes de crear
- [ ] Implementas transferencias con validacion de fondos
- [ ] Manejas correctamente depositos y retiros
- [ ] Calculas el saldo total del banco
- [ ] Buscas cuentas por numero eficientemente

### Buenas Practicas:
- [ ] Usas mensajes de error claros y descriptivos
- [ ] Retornas boolean en operaciones que pueden fallar
- [ ] Validas fondos suficientes antes de retirar
- [ ] Usas String.format() para formatear salida con 2 decimales
- [ ] Tu codigo compila sin errores y warnings

### Tiempo:
- [ ] Implementas la solucion completa en < 40 minutos
- [ ] Puedes explicar el flujo de getInstance() paso a paso
- [ ] Identificas inmediatamente si un Singleton esta mal implementado

---

## 🔗 RELACION CON EL EXAMEN

Este patron es CRITICO para el examen - es una de las dos opciones principales que debes elegir.

### Comparacion: Este Ejercicio vs Examen

| Aspecto | Ejercicio 03 | Examen Real |
|---------|--------------|-------------|
| **Patron usado** | Singleton | Singleton O Factory (tu eliges) |
| | Sistema Bancario | Sistema de Vehiculos/Envios |
| **Estructura** | Una clase Singleton | Singleton + Visitor + Strategy |
| **Complejidad** | Basica (solo Singleton) | Media (3 patrones combinados) |
| **Tiempo estimado** | 40 minutos | 20-25 minutos (parte Singleton) |
| **Validaciones** | Cuentas duplicadas, fondos | Similar + validaciones de archivo |
| **Lectura archivo** | No | Si (lectura de datos.txt) |
| **Porcentaje del examen** | ~25% | Singleton es ~30% del total |

### Como se usa Singleton en el examen:

**En el examen (Ejercicio 10 - RentaCarCompleto):**
```java
public class SistemaRentaCar {
    private static SistemaRentaCar instance;
    private ArrayList<Vehiculo> vehiculos;

    private SistemaRentaCar() {
        vehiculos = new ArrayList<>();
    }

    public static SistemaRentaCar getInstance() {
        if (instance == null) {
            instance = new SistemaRentaCar();
        }
        return instance;
    }

    // Combina con Visitor y Strategy
    public void cargarVehiculos(String archivo) { ... }
    public void calcularCostos(VisitorCostos visitor) { ... }
}
```

**Diferencias clave con este ejercicio:**
1. **Mas complejo:** El Singleton del examen tambien gestiona:
   - Lectura de archivos
   - Aplicacion de Visitors
   - Cambio de Strategies

2. **Mas integracion:** No es solo Singleton aislado, sino:
   - Singleton como contenedor
   - Visitor para calculos
   - Strategy para tarifas

### Que cubre este ejercicio:

- ✅ **30% del examen:** Patron Singleton completo
- ✅ **Validaciones:** Evitar duplicados (similar a validar patentes)
- ✅ **Busqueda:** Encontrar elementos por ID
- ✅ **Operaciones:** Transferencias (similar a calculos en examen)
- ❌ **No cubre:** Visitor, Strategy, File I/O (ver Ejercicios 06, 07)

### Proximos pasos sugeridos:

1. **Si elegiste Singleton para el examen:**
   - ✅ Ejercicio 03 (este) - Dominar Singleton puro
   - ➡️ Ejercicio 05 - Agregar lectura de archivos
   - ➡️ Ejercicio 06 - Aprender Visitor
   - ➡️ Ejercicio 07 - Combinar Singleton + Visitor + Strategy
   - ➡️ Ejercicio 10 - Simulacro completo de examen

2. **Si elegiste Factory para el examen:**
   - Puedes saltar al Ejercicio 04 (Factory Pattern)
   - Pero IGUAL debes entender Singleton (se usa en Ejercicio 10)

### Errores comunes en el examen relacionados con Singleton:

1. **Constructor publico** → 0 puntos en patron Singleton
2. **No validar null en getInstance()** → NullPointerException
3. **Crear multiples instancias** → Pierde sentido el patron
4. **No usar instancia estatica** → No funciona como Singleton

### Tips para el examen:

- ⏱️ **Tiempo:** Dedica MAX 15 minutos al Singleton
- 📝 **Plantilla:** Memoriza la estructura basica (3 partes)
- ✅ **Verificacion:** Siempre prueba con `sistema1 == sistema2`
- 🔍 **Prioridad:** El Singleton es FACIL - no pierdas puntos aqui

---

**Si dominas este ejercicio, tienes el 30% del examen garantizado. El Singleton es tu base solida - construye el resto sobre ella.**
