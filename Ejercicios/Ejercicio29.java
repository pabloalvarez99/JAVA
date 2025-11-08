/*
 * ========================================
 * EJERCICIO 29: Patrones de Diseño - Singleton y Factory
 * DIFICULTAD: ⭐⭐⭐⭐⭐⭐⭐⭐⭐ (Maestro)
 * ========================================
 *
 * OBJETIVO:
 * Aprender sobre Patrones de Diseño (Design Patterns), soluciones probadas
 * a problemas comunes en el desarrollo de software
 *
 * CONCEPTO CLAVE:
 * Los Patrones de Diseño son plantillas reutilizables que resuelven problemas
 * recurrentes en el diseño de software. Son "mejores prácticas" documentadas
 * que los desarrolladores expertos han identificado a lo largo del tiempo.
 *
 * CATEGORÍAS DE PATRONES:
 * 1. CREACIONALES: Cómo crear objetos
 *    - Singleton, Factory, Builder, Prototype
 *
 * 2. ESTRUCTURALES: Cómo componer objetos
 *    - Adapter, Decorator, Facade, Proxy
 *
 * 3. COMPORTAMIENTO: Cómo interactúan objetos
 *    - Observer, Strategy, Command, Iterator
 *
 * ========================================
 * PATRÓN 1: SINGLETON
 * ========================================
 *
 * PROPÓSITO:
 * Garantizar que una clase tenga UNA SOLA INSTANCIA en toda la aplicación
 * y proporcionar un punto de acceso global a ella.
 *
 * ANALOGÍA:
 * Es como un gobierno: solo puede haber UN presidente al mismo tiempo.
 * Todos acceden al mismo presidente, no a copias diferentes.
 *
 * CUÁNDO USAR:
 * ✓ Configuración global (Config.getInstance())
 * ✓ Pool de conexiones a base de datos
 * ✓ Logger de aplicación
 * ✓ Caché global
 * ✓ Gestor de recursos compartidos
 *
 * CARACTERÍSTICAS:
 * - Constructor PRIVADO (nadie puede hacer new)
 * - Variable estática que guarda la única instancia
 * - Método estático getInstance() que retorna la instancia
 *
 * IMPLEMENTACIÓN:
 * public class Singleton {
 *     private static Singleton instance;
 *
 *     private Singleton() { }  // Constructor privado
 *
 *     public static Singleton getInstance() {
 *         if (instance == null) {
 *             instance = new Singleton();
 *         }
 *         return instance;
 *     }
 * }
 *
 * USO:
 * Singleton obj1 = Singleton.getInstance();
 * Singleton obj2 = Singleton.getInstance();
 * // obj1 == obj2 (misma instancia)
 *
 * ========================================
 * PATRÓN 2: FACTORY
 * ========================================
 *
 * PROPÓSITO:
 * Proporcionar una interfaz para crear objetos, pero permitir a las
 * subclases decidir qué clase instanciar.
 *
 * ANALOGÍA:
 * Es como una fábrica de vehículos: le dices qué tipo quieres
 * (auto, moto, camión) y la fábrica crea el vehículo correcto.
 *
 * CUÁNDO USAR:
 * ✓ Creación de objetos complejos
 * ✓ Diferentes tipos de objetos que comparten interfaz
 * ✓ Lógica de creación centralizada
 * ✓ Ocultar detalles de implementación
 *
 * VENTAJAS:
 * ✓ Separa creación de uso
 * ✓ Fácil añadir nuevos tipos
 * ✓ Código más limpio
 * ✓ Single Responsibility Principle
 *
 * IMPLEMENTACIÓN:
 * // Interfaz común
 * interface Vehiculo { void conducir(); }
 *
 * // Implementaciones
 * class Auto implements Vehiculo { ... }
 * class Moto implements Vehiculo { ... }
 *
 * // Factory
 * class VehiculoFactory {
 *     public static Vehiculo crear(String tipo) {
 *         switch (tipo) {
 *             case "auto": return new Auto();
 *             case "moto": return new Moto();
 *         }
 *     }
 * }
 *
 * INSTRUCCIONES:
 * 1. Implementa un SINGLETON "ConfiguracionApp" que:
 *    - Sea thread-safe (usa sincronización)
 *    - Tenga propiedades: appName, version, debugMode
 *    - Métodos para obtener/actualizar configuración
 *    - Método para mostrar configuración
 *
 * 2. Implementa un FACTORY "NotificacionFactory" que cree:
 *    - Interface Notificacion con método enviar(String mensaje)
 *    - EmailNotificacion
 *    - SMSNotificacion
 *    - PushNotificacion
 *    - Método estático crear(String tipo) que retorne la notificación correcta
 *
 * 3. Implementa un FACTORY "FiguraFactory" que cree:
 *    - Interface Figura con métodos: calcularArea(), dibujar()
 *    - Circulo (radio)
 *    - Rectangulo (ancho, alto)
 *    - Triangulo (base, altura)
 *
 * 4. Demuestra el uso de ambos patrones
 *
 * SALIDA ESPERADA:
 * === PATRONES DE DISEÑO - SINGLETON Y FACTORY ===
 *
 * === PATRÓN SINGLETON: CONFIGURACIÓN ===
 * Configuración inicial:
 * App: MiApp v1.0.0 (Debug: true)
 *
 * Obteniendo instancia 1...
 * Obteniendo instancia 2...
 * ¿Son la misma instancia? true ✓
 *
 * Actualizando configuración...
 * Configuración actualizada:
 * App: MiApp v2.0.0 (Debug: false)
 *
 * === PATRÓN FACTORY: NOTIFICACIONES ===
 * Enviando notificación por EMAIL...
 * [EMAIL] Enviando a destinatarios: Bienvenido al sistema
 *
 * Enviando notificación por SMS...
 * [SMS] Enviando a números: Tu código es: 1234
 *
 * Enviando notificación por PUSH...
 * [PUSH] Enviando a dispositivos: Nueva actualización disponible
 *
 * === PATRÓN FACTORY: FIGURAS GEOMÉTRICAS ===
 * Creando Círculo (radio: 5.0):
 * ○ Círculo (radio: 5.0)
 * Área: 78.54
 *
 * Creando Rectángulo (5.0 x 3.0):
 * ▭ Rectángulo (5.0 x 3.0)
 * Área: 15.00
 *
 * Creando Triángulo (base: 4.0, altura: 6.0):
 * △ Triángulo (base: 4.0, altura: 6.0)
 * Área: 12.00
 *
 * CONCEPTOS NUEVOS:
 * - Design Patterns: Patrones de diseño
 * - Singleton: Una sola instancia global
 * - Factory: Creación centralizada de objetos
 * - Thread-safe: Seguro para múltiples hilos
 * - Lazy initialization: Crear solo cuando se necesita
 * - Creational patterns: Patrones de creación
 *
 * VENTAJAS DE PATRONES:
 * ✓ Soluciones probadas
 * ✓ Vocabulario común entre desarrolladores
 * ✓ Código más mantenible
 * ✓ Mejores prácticas documentadas
 * ✓ Facilita comunicación en equipos
 *
 * SINGLETON - VENTAJAS:
 * ✓ Control de acceso a recurso único
 * ✓ Ahorra memoria (una sola instancia)
 * ✓ Punto de acceso global
 *
 * SINGLETON - DESVENTAJAS:
 * ✗ Puede complicar testing
 * ✗ Estado global (puede causar problemas)
 * ✗ Violación de Single Responsibility
 *
 * FACTORY - VENTAJAS:
 * ✓ Separa creación de uso
 * ✓ Fácil añadir nuevos tipos
 * ✓ Centraliza lógica de creación
 * ✓ Reduce acoplamiento
 *
 * PISTAS:
 * - Singleton: constructor privado + getInstance()
 * - Thread-safe: synchronized o doble-check locking
 * - Factory: método estático que retorna interface
 * - Usa switch o if-else para decidir qué crear
 */

// ========================================
// PATRÓN SINGLETON
// ========================================

// TODO: Implementa la clase Singleton ConfiguracionApp
class ConfiguracionApp {
    // Única instancia (static)
    private static ConfiguracionApp instance;

    // Atributos de configuración
    private String appName;
    private String version;
    private boolean debugMode;

    // Constructor PRIVADO (nadie puede hacer new ConfiguracionApp())
    private ConfiguracionApp() {
        // Valores por defecto
        this.appName = "MiApp";
        this.version = "1.0.0";
        this.debugMode = true;
    }

    // Método para obtener la instancia (thread-safe)
    public static synchronized ConfiguracionApp getInstance() {
        if (instance == null) {
            instance = new ConfiguracionApp();
        }
        return instance;
    }

    // Getters
    public String getAppName() { return appName; }
    public String getVersion() { return version; }
    public boolean isDebugMode() { return debugMode; }

    // Setters
    public void setAppName(String appName) { this.appName = appName; }
    public void setVersion(String version) { this.version = version; }
    public void setDebugMode(boolean debugMode) { this.debugMode = debugMode; }

    // Método para mostrar configuración
    public void mostrarConfig() {
        System.out.printf("App: %s v%s (Debug: %s)\n", appName, version, debugMode);
    }
}

// ========================================
// PATRÓN FACTORY: NOTIFICACIONES
// ========================================

// Interface común
interface Notificacion {
    void enviar(String mensaje);
}

// Implementaciones concretas
class EmailNotificacion implements Notificacion {
    @Override
    public void enviar(String mensaje) {
        System.out.println("[EMAIL] Enviando a destinatarios: " + mensaje);
    }
}

class SMSNotificacion implements Notificacion {
    @Override
    public void enviar(String mensaje) {
        System.out.println("[SMS] Enviando a números: " + mensaje);
    }
}

class PushNotificacion implements Notificacion {
    @Override
    public void enviar(String mensaje) {
        System.out.println("[PUSH] Enviando a dispositivos: " + mensaje);
    }
}

// TODO: Factory para crear notificaciones
class NotificacionFactory {
    public static Notificacion crear(String tipo) {
        // TODO: Retorna la notificación según el tipo
        switch (tipo.toLowerCase()) {
            case "email":
                return new EmailNotificacion();
            case "sms":
                return new SMSNotificacion();
            case "push":
                return new PushNotificacion();
            default:
                throw new IllegalArgumentException("Tipo de notificación desconocido: " + tipo);
        }
    }
}

// ========================================
// PATRÓN FACTORY: FIGURAS GEOMÉTRICAS
// ========================================

// Interface común
interface Figura {
    double calcularArea();
    void dibujar();
}

// Implementaciones concretas
class Circulo implements Figura {
    private double radio;

    public Circulo(double radio) {
        this.radio = radio;
    }

    @Override
    public double calcularArea() {
        return Math.PI * radio * radio;
    }

    @Override
    public void dibujar() {
        System.out.println("○ Círculo (radio: " + radio + ")");
    }
}

class Rectangulo implements Figura {
    private double ancho;
    private double alto;

    public Rectangulo(double ancho, double alto) {
        this.ancho = ancho;
        this.alto = alto;
    }

    @Override
    public double calcularArea() {
        return ancho * alto;
    }

    @Override
    public void dibujar() {
        System.out.println("▭ Rectángulo (" + ancho + " x " + alto + ")");
    }
}

class Triangulo implements Figura {
    private double base;
    private double altura;

    public Triangulo(double base, double altura) {
        this.base = base;
        this.altura = altura;
    }

    @Override
    public double calcularArea() {
        return (base * altura) / 2;
    }

    @Override
    public void dibujar() {
        System.out.println("△ Triángulo (base: " + base + ", altura: " + altura + ")");
    }
}

// TODO: Factory para crear figuras
class FiguraFactory {
    public static Figura crearCirculo(double radio) {
        return new Circulo(radio);
    }

    public static Figura crearRectangulo(double ancho, double alto) {
        return new Rectangulo(ancho, alto);
    }

    public static Figura crearTriangulo(double base, double altura) {
        return new Triangulo(base, altura);
    }
}

public class Ejercicio29 {
    public static void main(String[] args) {
        System.out.println("=== PATRONES DE DISEÑO - SINGLETON Y FACTORY ===\n");

        // ========================================
        // DEMOSTRACIÓN: SINGLETON
        // ========================================
        System.out.println("=== PATRÓN SINGLETON: CONFIGURACIÓN ===");

        // Obtener la instancia
        ConfiguracionApp config1 = ConfiguracionApp.getInstance();
        System.out.println("Configuración inicial:");
        config1.mostrarConfig();
        System.out.println();

        // Obtener otra "instancia"
        System.out.println("Obteniendo instancia 1...");
        ConfiguracionApp config2 = ConfiguracionApp.getInstance();
        System.out.println("Obteniendo instancia 2...");

        // Verificar que son la MISMA instancia
        System.out.println("¿Son la misma instancia? " + (config1 == config2) + " ✓");
        System.out.println();

        // Modificar configuración desde config2
        System.out.println("Actualizando configuración...");
        config2.setVersion("2.0.0");
        config2.setDebugMode(false);

        // Ver que config1 también cambió (porque es la misma instancia)
        System.out.println("Configuración actualizada:");
        config1.mostrarConfig();
        System.out.println();

        // ========================================
        // DEMOSTRACIÓN: FACTORY - NOTIFICACIONES
        // ========================================
        System.out.println("=== PATRÓN FACTORY: NOTIFICACIONES ===");

        // Crear diferentes tipos de notificaciones sin saber los detalles
        System.out.println("Enviando notificación por EMAIL...");
        Notificacion email = NotificacionFactory.crear("email");
        email.enviar("Bienvenido al sistema");
        System.out.println();

        System.out.println("Enviando notificación por SMS...");
        Notificacion sms = NotificacionFactory.crear("sms");
        sms.enviar("Tu código es: 1234");
        System.out.println();

        System.out.println("Enviando notificación por PUSH...");
        Notificacion push = NotificacionFactory.crear("push");
        push.enviar("Nueva actualización disponible");
        System.out.println();

        // ========================================
        // DEMOSTRACIÓN: FACTORY - FIGURAS
        // ========================================
        System.out.println("=== PATRÓN FACTORY: FIGURAS GEOMÉTRICAS ===");

        // Crear círculo
        System.out.println("Creando Círculo (radio: 5.0):");
        Figura circulo = FiguraFactory.crearCirculo(5.0);
        circulo.dibujar();
        System.out.printf("Área: %.2f\n\n", circulo.calcularArea());

        // Crear rectángulo
        System.out.println("Creando Rectángulo (5.0 x 3.0):");
        Figura rectangulo = FiguraFactory.crearRectangulo(5.0, 3.0);
        rectangulo.dibujar();
        System.out.printf("Área: %.2f\n\n", rectangulo.calcularArea());

        // Crear triángulo
        System.out.println("Creando Triángulo (base: 4.0, altura: 6.0):");
        Figura triangulo = FiguraFactory.crearTriangulo(4.0, 6.0);
        triangulo.dibujar();
        System.out.printf("Área: %.2f\n\n", triangulo.calcularArea());

        // ========================================
        // EJEMPLO PRÁCTICO: Sistema de notificaciones
        // ========================================
        System.out.println("=== EJEMPLO PRÁCTICO: SISTEMA DE ALERTAS ===");

        String[] eventos = {"login", "compra", "error"};
        String[] tiposNotif = {"email", "sms", "push"};

        for (int i = 0; i < eventos.length; i++) {
            String evento = eventos[i];
            String tipo = tiposNotif[i];

            System.out.println("Evento: " + evento.toUpperCase());
            Notificacion notif = NotificacionFactory.crear(tipo);
            notif.enviar("Evento " + evento + " detectado");
            System.out.println();
        }

        // REFLEXIÓN:
        // ¿Por qué usar patrones de diseño?
        // ✓ Soluciones probadas a problemas comunes
        // ✓ Vocabulario común entre desarrolladores
        // ✓ Código más mantenible y escalable
        // ✓ Facilita el trabajo en equipo
        // ✓ Mejores prácticas de la industria
        //
        // SINGLETON EN LA VIDA REAL:
        // - Logger: Log4j, SLF4J
        // - Configuración: Properties, Config
        // - Database Connection Pool
        // - Caché global
        // - Spring: Beans por defecto son Singleton
        //
        // FACTORY EN LA VIDA REAL:
        // - JDBC: DriverManager.getConnection()
        // - Calendar.getInstance()
        // - NumberFormat.getInstance()
        // - Frameworks: Spring, Hibernate
        // - Creación de objetos complejos
        //
        // OTROS PATRONES IMPORTANTES:
        //
        // BUILDER: Construcción paso a paso
        // StringBuilder sb = new StringBuilder()
        //     .append("Hello")
        //     .append(" ")
        //     .append("World");
        //
        // OBSERVER: Notificaciones de cambios
        // - Event listeners en GUIs
        // - Reactive programming (RxJava)
        //
        // STRATEGY: Algoritmos intercambiables
        // - Comparator en Collections.sort()
        // - Payment methods (CreditCard, PayPal)
        //
        // DECORATOR: Añadir funcionalidad
        // - Java I/O: BufferedReader(new FileReader())
        // - InputStream wrapping
        //
        // ADAPTER: Convertir interfaces
        // - Arrays.asList() - array a List
        // - Legacy code integration
        //
        // CUÁNDO USAR CADA PATRÓN:
        //
        // Singleton:
        // ✓ Recurso único compartido
        // ✓ Configuración global
        // ✗ Evitar en testing (dificulta mocking)
        //
        // Factory:
        // ✓ Creación compleja
        // ✓ Múltiples tipos similares
        // ✓ Ocultar detalles de implementación
        // ✗ Si solo hay un tipo, usar new directamente
        //
        // ANTI-PATTERNS (patrones MALOS):
        // ✗ God Object: Clase que hace todo
        // ✗ Spaghetti Code: Código sin estructura
        // ✗ Magic Numbers: Números sin explicación
        // ✗ Copy-Paste Programming: Duplicar código
        //
        // PRINCIPIOS SOLID:
        // S - Single Responsibility: Una responsabilidad
        // O - Open/Closed: Abierto a extensión, cerrado a modificación
        // L - Liskov Substitution: Subclases sustituibles
        // I - Interface Segregation: Interfaces pequeñas
        // D - Dependency Inversion: Depender de abstracciones
        //
        // RECOMENDACIÓN:
        // No uses patrones porque sí. Úsalos cuando realmente
        // resuelvan un problema. "Keep it simple" es importante.
    }
}
