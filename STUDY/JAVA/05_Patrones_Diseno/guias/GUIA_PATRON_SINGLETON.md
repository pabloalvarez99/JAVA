# GUIA COMPLETA: PATRON SINGLETON

## INDICE
1. [Definicion y Proposito](#definicion)
2. [Cuando Usar Singleton](#cuando-usar)
3. [Implementacion Clasica](#implementacion-clasica)
4. [Variantes del Patron](#variantes)
5. [Ventajas y Desventajas](#ventajas-desventajas)
6. [Errores Comunes](#errores-comunes)
7. [Ejemplos Practicos](#ejemplos-practicos)
8. [Ejercicios de Practica](#ejercicios)
9. [Checklist de Implementacion](#checklist)

---

## 1. DEFINICION Y PROPOSITO {#definicion}

### ¿Que es Singleton?

**DEFINICION FORMAL:**
El patron Singleton asegura que una clase tenga **exactamente UNA instancia** y proporciona un **punto de acceso global** a esa instancia.

**ANALOGIA:**
Piensa en el Presidente de un pais:
- Solo puede haber UN presidente a la vez
- Todos en el pais saben quien es (acceso global)
- No puedes crear tu propio presidente

**PROBLEMA QUE RESUELVE:**
```
PROBLEMA: Necesito que ciertos objetos existan UNA SOLA VEZ en toda la aplicacion
          (como configuracion, logger, conexion a BD)

SOLUCION: Singleton controla la creacion del objeto y garantiza que solo exista uno
```

### Estructura Basica

```
┌─────────────────────────────┐
│      Singleton              │
├─────────────────────────────┤
│ - instance: Singleton       │  <- Instancia unica (static)
├─────────────────────────────┤
│ - Singleton()               │  <- Constructor PRIVADO
│ + getInstance(): Singleton  │  <- Metodo de acceso (static)
│ + operacion()               │  <- Metodos de negocio
└─────────────────────────────┘
```

---

## 2. CUANDO USAR SINGLETON {#cuando-usar}

### ✅ CASOS IDEALES PARA SINGLETON

1. **Configuracion de la Aplicacion**
   - Parametros que se leen una vez
   - Acceso desde toda la aplicacion

2. **Loggers (Registros)**
   - Un solo archivo de log
   - Acceso desde multiples clases

3. **Gestor de Conexiones**
   - Pool de conexiones a BD
   - Control centralizado

4. **Cache Global**
   - Datos compartidos
   - Evitar duplicacion

5. **Coordinadores/Gestores**
   - GestorDeTransacciones
   - AdministradorDeRecursos

### ❌ CUANDO NO USAR SINGLETON

1. **Objetos que necesitan multiples instancias**
   - Usuarios, productos, pedidos

2. **Testing**
   - Singleton dificulta las pruebas unitarias
   - Mejor usar Dependency Injection

3. **Cuando se necesita herencia flexible**
   - Singleton limita extension

---

## 3. IMPLEMENTACION CLASICA {#implementacion-clasica}

### Implementacion Basica (Eager Initialization)

```java
public class Configuracion {
    // 1. INSTANCIA UNICA (se crea al cargar la clase)
    private static final Configuracion INSTANCE = new Configuracion();

    // Atributos de configuracion
    private String urlBaseDatos;
    private int timeout;

    // 2. CONSTRUCTOR PRIVADO (nadie puede hacer new Configuracion())
    private Configuracion() {
        // Cargar configuracion desde archivo o valores por defecto
        this.urlBaseDatos = "jdbc:mysql://localhost:3306/midb";
        this.timeout = 30;
    }

    // 3. METODO DE ACCESO PUBLICO Y ESTATICO
    public static Configuracion getInstance() {
        return INSTANCE;
    }

    // Metodos de negocio
    public String getUrlBaseDatos() {
        return urlBaseDatos;
    }

    public int getTimeout() {
        return timeout;
    }

    public void setUrlBaseDatos(String url) {
        this.urlBaseDatos = url;
    }
}
```

### Uso del Singleton

```java
public class Main {
    public static void main(String[] args) {
        // TODAS estas llamadas obtienen LA MISMA instancia
        Configuracion config1 = Configuracion.getInstance();
        Configuracion config2 = Configuracion.getInstance();
        Configuracion config3 = Configuracion.getInstance();

        // Verificacion: todos apuntan al mismo objeto
        System.out.println(config1 == config2);  // true
        System.out.println(config2 == config3);  // true

        // Cambio en uno afecta a todos (porque es el mismo objeto)
        config1.setUrlBaseDatos("jdbc:mysql://servidor:3306/produccion");
        System.out.println(config2.getUrlBaseDatos());  // Muestra la nueva URL

        // ESTO NO COMPILA (constructor es privado):
        // Configuracion config4 = new Configuracion();  // ERROR!
    }
}
```

---

## 4. VARIANTES DEL PATRON {#variantes}

### A) Eager Initialization (Inicializacion Temprana)

**CARACTERISTICA:** La instancia se crea al cargar la clase

```java
public class Logger {
    private static final Logger INSTANCE = new Logger();

    private Logger() {
        // Inicializar logger
    }

    public static Logger getInstance() {
        return INSTANCE;
    }
}
```

**VENTAJAS:**
- Simple y thread-safe automaticamente
- No requiere sincronizacion

**DESVENTAJAS:**
- La instancia se crea aunque no se use
- No puede manejar excepciones en el constructor

**CUANDO USAR:**
- El objeto es ligero
- Sabes que se usara con seguridad

---

### B) Lazy Initialization (Inicializacion Perezosa)

**CARACTERISTICA:** La instancia se crea solo cuando se solicita por primera vez

```java
public class GestorConexion {
    private static GestorConexion instance;

    private GestorConexion() {
        // Configuracion pesada
        System.out.println("Inicializando conexion a BD...");
    }

    public static GestorConexion getInstance() {
        if (instance == null) {
            instance = new GestorConexion();
        }
        return instance;
    }
}
```

**VENTAJAS:**
- Ahorra recursos si no se usa
- Retrasa inicializacion costosa

**DESVENTAJAS:**
- NO es thread-safe (problemas en multi-threading)
- Mas complejo

**PROBLEMA CON THREADS:**
```java
// Thread 1 llama getInstance() y entra al if
// Thread 2 llama getInstance() antes de que Thread 1 termine
// RESULTADO: Se crean DOS instancias! (viola Singleton)
```

---

### C) Thread-Safe Lazy Initialization (Con Sincronizacion)

**CARACTERISTICA:** Lazy initialization segura para multi-threading

```java
public class GestorTransacciones {
    private static GestorTransacciones instance;

    private GestorTransacciones() {
        // Configuracion
    }

    // synchronized garantiza que solo un thread acceda a la vez
    public static synchronized GestorTransacciones getInstance() {
        if (instance == null) {
            instance = new GestorTransacciones();
        }
        return instance;
    }
}
```

**VENTAJAS:**
- Thread-safe
- Lazy initialization

**DESVENTAJAS:**
- LENTO: synchronized en CADA llamada (incluso despues de crear la instancia)
- Overhead de sincronizacion

---

### D) Double-Checked Locking (Optimizado)

**CARACTERISTICA:** Sincroniza solo durante la creacion

```java
public class CacheGlobal {
    // volatile garantiza visibilidad entre threads
    private static volatile CacheGlobal instance;

    private CacheGlobal() {
        // Inicializar cache
    }

    public static CacheGlobal getInstance() {
        // Primera verificacion (sin sincronizar) - RAPIDO
        if (instance == null) {
            // Sincronizar solo si instance es null
            synchronized (CacheGlobal.class) {
                // Segunda verificacion (dentro del bloque sincronizado)
                if (instance == null) {
                    instance = new CacheGlobal();
                }
            }
        }
        return instance;
    }
}
```

**VENTAJAS:**
- Thread-safe
- Alto rendimiento (sincroniza solo una vez)

**DESVENTAJAS:**
- Mas complejo
- Requiere Java 5+ (para volatile correcto)

**CUANDO USAR:**
- Aplicaciones multi-threaded
- Inicializacion costosa

---

### E) Bill Pugh Singleton (Recomendado)

**CARACTERISTICA:** Usa clase interna estatica (Initialization-on-demand holder)

```java
public class DatabaseManager {

    private DatabaseManager() {
        // Inicializar BD
        System.out.println("Conectando a base de datos...");
    }

    // Clase interna estatica (se carga solo cuando se referencia)
    private static class Holder {
        private static final DatabaseManager INSTANCE = new DatabaseManager();
    }

    public static DatabaseManager getInstance() {
        return Holder.INSTANCE;
    }

    public void ejecutarConsulta(String sql) {
        System.out.println("Ejecutando: " + sql);
    }
}
```

**VENTAJAS:**
- Thread-safe SIN sincronizacion
- Lazy initialization (Holder se carga al primer acceso)
- Simple y eficiente
- **ESTA ES LA MEJOR IMPLEMENTACION**

**COMO FUNCIONA:**
1. La clase `Holder` no se carga hasta que se llama `getInstance()`
2. La JVM garantiza thread-safety al cargar clases
3. No requiere synchronized ni volatile

---

## 5. VENTAJAS Y DESVENTAJAS {#ventajas-desventajas}

### ✅ VENTAJAS

1. **Control estricto sobre la instancia**
   - Garantiza una sola instancia
   - Punto de acceso global

2. **Ahorro de recursos**
   - No se crean objetos duplicados
   - Memoria eficiente

3. **Inicializacion perezosa (lazy)**
   - Solo se crea cuando se necesita

4. **Estado compartido**
   - Todos acceden a los mismos datos
   - Consistencia garantizada

### ❌ DESVENTAJAS

1. **Viola el Single Responsibility Principle**
   - La clase controla su creacion Y su logica de negocio

2. **Dificulta testing**
   - No puedes crear mocks facilmente
   - Estado persiste entre pruebas

3. **Acoplamiento global**
   - Clases dependientes del Singleton
   - Dificil de refactorizar

4. **Problemas con herencia**
   - Constructor privado impide subclases

5. **Estado global oculto**
   - Dependencias no evidentes
   - Dificil seguir flujo de datos

---

## 6. ERRORES COMUNES {#errores-comunes}

### ❌ ERROR 1: Constructor No Privado

```java
// MAL - Cualquiera puede crear instancias
public class MalSingleton {
    private static MalSingleton instance;

    public MalSingleton() { }  // PUBLICO!

    public static MalSingleton getInstance() {
        if (instance == null) {
            instance = new MalSingleton();
        }
        return instance;
    }
}

// Resultado: puedes hacer esto
MalSingleton obj1 = new MalSingleton();  // Nueva instancia!
MalSingleton obj2 = MalSingleton.getInstance();  // Otra instancia!
// Ahora hay DOS instancias (viola Singleton)
```

**SOLUCION:**
```java
// BIEN - Constructor privado
private MalSingleton() { }
```

---

### ❌ ERROR 2: No Thread-Safe

```java
// MAL - Problemas en multi-threading
public static GestorConexion getInstance() {
    if (instance == null) {  // Dos threads pueden entrar aqui simultaneamente
        instance = new GestorConexion();
    }
    return instance;
}
```

**SOLUCION:**
Usar Bill Pugh Singleton o Double-Checked Locking

---

### ❌ ERROR 3: Olvidar volatile en Double-Checked Locking

```java
// MAL
private static CacheGlobal instance;  // Falta volatile

// BIEN
private static volatile CacheGlobal instance;
```

**POR QUE:** Sin volatile, otros threads pueden ver instancia parcialmente construida

---

### ❌ ERROR 4: Singleton con Estado Mutable Publico

```java
// MAL - Estado puede corromperse
public class Config {
    private static Config instance = new Config();

    public List<String> configuraciones = new ArrayList<>();  // PUBLICO Y MUTABLE!

    private Config() { }

    public static Config getInstance() {
        return instance;
    }
}

// Cualquiera puede modificar:
Config.getInstance().configuraciones.clear();  // Borra todo!
```

**SOLUCION:**
```java
// BIEN - Encapsulacion
private List<String> configuraciones = new ArrayList<>();

public List<String> getConfiguraciones() {
    return new ArrayList<>(configuraciones);  // Retorna copia
}
```

---

## 7. EJEMPLOS PRACTICOS {#ejemplos-practicos}

### Ejemplo 1: Logger de Aplicacion

```java
import java.io.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Logger {

    private Logger() {
        // Inicializar archivo de log
    }

    private static class Holder {
        private static final Logger INSTANCE = new Logger();
    }

    public static Logger getInstance() {
        return Holder.INSTANCE;
    }

    public void log(String mensaje) {
        String timestamp = LocalDateTime.now()
            .format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));

        String logLine = "[" + timestamp + "] " + mensaje;

        try (PrintWriter writer = new PrintWriter(
                new FileWriter("app.log", true))) {
            writer.println(logLine);
        } catch (IOException e) {
            System.err.println("Error escribiendo log: " + e.getMessage());
        }

        // Tambien imprimir en consola
        System.out.println(logLine);
    }

    public void error(String mensaje) {
        log("ERROR: " + mensaje);
    }

    public void info(String mensaje) {
        log("INFO: " + mensaje);
    }
}

// USO:
class Aplicacion {
    public void iniciar() {
        Logger.getInstance().info("Aplicacion iniciada");

        try {
            // ... codigo ...
        } catch (Exception e) {
            Logger.getInstance().error("Fallo: " + e.getMessage());
        }
    }
}
```

---

### Ejemplo 2: Gestor de Configuracion

```java
import java.io.*;
import java.util.Properties;

public class ConfiguracionApp {

    private Properties propiedades;

    private ConfiguracionApp() {
        propiedades = new Properties();
        cargarConfiguracion();
    }

    private static class Holder {
        private static final ConfiguracionApp INSTANCE = new ConfiguracionApp();
    }

    public static ConfiguracionApp getInstance() {
        return Holder.INSTANCE;
    }

    private void cargarConfiguracion() {
        try (InputStream input = new FileInputStream("config.properties")) {
            propiedades.load(input);
        } catch (IOException e) {
            // Valores por defecto
            propiedades.setProperty("db.url", "jdbc:mysql://localhost:3306/mydb");
            propiedades.setProperty("db.user", "root");
            propiedades.setProperty("max.connections", "10");
        }
    }

    public String get(String clave) {
        return propiedades.getProperty(clave);
    }

    public int getInt(String clave) {
        return Integer.parseInt(propiedades.getProperty(clave));
    }

    public void set(String clave, String valor) {
        propiedades.setProperty(clave, valor);
    }
}

// USO:
class BaseDatos {
    public void conectar() {
        ConfiguracionApp config = ConfiguracionApp.getInstance();
        String url = config.get("db.url");
        String user = config.get("db.user");

        System.out.println("Conectando a " + url + " como " + user);
    }
}
```

---

### Ejemplo 3: Banco (Caso Real)

```java
import java.util.*;

public class Banco {

    private String nombre;
    private Map<String, Double> cuentas;

    private Banco() {
        this.nombre = "Banco Nacional";
        this.cuentas = new HashMap<>();
    }

    private static class Holder {
        private static final Banco INSTANCE = new Banco();
    }

    public static Banco getInstance() {
        return Holder.INSTANCE;
    }

    public void crearCuenta(String titular, double saldoInicial) {
        if (cuentas.containsKey(titular)) {
            throw new IllegalArgumentException("La cuenta ya existe");
        }
        cuentas.put(titular, saldoInicial);
        Logger.getInstance().info("Cuenta creada: " + titular);
    }

    public void depositar(String titular, double monto) {
        if (!cuentas.containsKey(titular)) {
            throw new IllegalArgumentException("Cuenta no existe");
        }
        double saldoActual = cuentas.get(titular);
        cuentas.put(titular, saldoActual + monto);
        Logger.getInstance().info("Deposito de " + monto + " en cuenta " + titular);
    }

    public void retirar(String titular, double monto) {
        if (!cuentas.containsKey(titular)) {
            throw new IllegalArgumentException("Cuenta no existe");
        }
        double saldoActual = cuentas.get(titular);
        if (saldoActual < monto) {
            throw new IllegalArgumentException("Saldo insuficiente");
        }
        cuentas.put(titular, saldoActual - monto);
        Logger.getInstance().info("Retiro de " + monto + " de cuenta " + titular);
    }

    public double consultarSaldo(String titular) {
        if (!cuentas.containsKey(titular)) {
            throw new IllegalArgumentException("Cuenta no existe");
        }
        return cuentas.get(titular);
    }

    public void mostrarTodasCuentas() {
        System.out.println("\n=== " + nombre + " ===");
        for (Map.Entry<String, Double> entry : cuentas.entrySet()) {
            System.out.printf("%s: $%.2f\n", entry.getKey(), entry.getValue());
        }
    }
}

// USO:
class Main {
    public static void main(String[] args) {
        Banco banco = Banco.getInstance();

        banco.crearCuenta("Juan Perez", 1000.0);
        banco.crearCuenta("Maria Lopez", 2500.0);

        banco.depositar("Juan Perez", 500.0);
        banco.retirar("Maria Lopez", 300.0);

        banco.mostrarTodasCuentas();

        // Otra clase tambien accede al MISMO banco
        ProcesadorTransacciones procesador = new ProcesadorTransacciones();
        procesador.procesarTransferencia("Maria Lopez", "Juan Perez", 200.0);

        banco.mostrarTodasCuentas();
    }
}

class ProcesadorTransacciones {
    public void procesarTransferencia(String origen, String destino, double monto) {
        Banco banco = Banco.getInstance();  // MISMO banco

        banco.retirar(origen, monto);
        banco.depositar(destino, monto);

        Logger.getInstance().info("Transferencia completada");
    }
}
```

---

## 8. EJERCICIOS DE PRACTICA {#ejercicios}

### Ejercicio 1: Cache de Productos (15 min)

Crea un Singleton `CacheProductos` que:
- Almacene productos en un `HashMap<Integer, Producto>`
- Metodos: `agregarProducto`, `obtenerProducto`, `eliminarProducto`
- Usa Bill Pugh Singleton
- Incluye Logger para operaciones

**Clase Producto:**
```java
class Producto {
    private int id;
    private String nombre;
    private double precio;

    // Constructor, getters, setters
}
```

---

### Ejercicio 2: Gestor de Turnos (20 min)

Implementa un Singleton `GestorTurnos` para un consultorio:
- Atributo: `int ultimoTurno = 0`
- Metodo `int siguienteTurno()` incrementa y retorna el numero
- Metodo `int getTurnoActual()` retorna sin incrementar
- Usa Eager Initialization
- Debe ser thread-safe

**Prueba:**
```java
GestorTurnos gestor1 = GestorTurnos.getInstance();
GestorTurnos gestor2 = GestorTurnos.getInstance();

System.out.println(gestor1.siguienteTurno());  // 1
System.out.println(gestor2.siguienteTurno());  // 2 (mismo objeto!)
```

---

### Ejercicio 3: Analizador de Configuracion (25 min)

Crea `ConfiguracionSistema` que:
- Carga un archivo `sistema.properties`
- Si no existe, crea uno con valores default
- Metodos: `get(String)`, `set(String, String)`, `guardar()`
- Singleton con Double-Checked Locking

**Archivo sistema.properties:**
```
app.nombre=MiAplicacion
app.version=1.0
max.usuarios=100
modo.debug=true
```

---

## 9. CHECKLIST DE IMPLEMENTACION {#checklist}

Cuando implementes Singleton, verifica:

### ESTRUCTURA BASICA
- [ ] Constructor es PRIVADO
- [ ] Instancia estatica (private static)
- [ ] Metodo getInstance() publico y estatico
- [ ] getInstance() retorna SIEMPRE la misma instancia

### THREAD-SAFETY (si multi-threading)
- [ ] Usar Bill Pugh Singleton (recomendado)
- [ ] O usar Eager Initialization
- [ ] O implementar Double-Checked Locking con volatile

### ENCAPSULACION
- [ ] Atributos privados
- [ ] Getters/setters apropiados
- [ ] No exponer colecciones mutables directamente

### LOGGING/DEBUGGING
- [ ] Considera agregar logging en getInstance()
- [ ] Mensaje en constructor para debugging

### TESTING
- [ ] Verifica que getInstance() == getInstance()
- [ ] Prueba concurrencia si aplica
- [ ] Considera metodo reset() para testing

---

## RESUMEN EJECUTIVO

### ¿Cuando Usar Singleton?

| SITUACION | USAR SINGLETON? |
|-----------|----------------|
| Logger de aplicacion | ✅ SI |
| Configuracion global | ✅ SI |
| Pool de conexiones | ✅ SI |
| Cache global | ✅ SI |
| Objetos de negocio (usuarios, productos) | ❌ NO |
| Cuando necesitas testing facil | ❌ NO |
| Cuando necesitas herencia | ❌ NO |

### Implementaciones Recomendadas

1. **MEJOR (uso general):** Bill Pugh Singleton
2. **SIMPLE:** Eager Initialization
3. **MULTI-THREADING:** Double-Checked Locking

### Formula Basica

```java
public class MiSingleton {
    private MiSingleton() { }

    private static class Holder {
        private static final MiSingleton INSTANCE = new MiSingleton();
    }

    public static MiSingleton getInstance() {
        return Holder.INSTANCE;
    }
}
```

---

## RECURSOS ADICIONALES

- Ver: `Ejercicio03_BancoSingleton.md` (ejercicio completo)
- Ver: `CHEAT_SHEET_PATRONES.md` (comparacion con otros patrones)
- Ver: `GUIA_PATRON_FACTORY.md` (patron complementario)

---

**TIEMPO ESTIMADO DE ESTUDIO:** 90 minutos
**NIVEL:** Intermedio
**PREREQUISITOS:** POO basico, clases, objetos

**PROXIMOS PASOS:**
1. Leer guia completa
2. Implementar ejercicios 1-3
3. Revisar Ejercicio03 completo
4. Comparar con Factory pattern
