/*
 * ========================================
 * EJERCICIO 34: Patrones Builder y Observer - Patrones de Diseño Avanzados
 * DIFICULTAD: ⭐⭐⭐⭐⭐⭐⭐⭐⭐⭐ (Experto)
 * ========================================
 *
 * OBJETIVO:
 * Dominar dos patrones de diseño fundamentales: Builder (construcción fluida
 * de objetos complejos) y Observer (sistema de notificaciones y eventos)
 *
 * ========================================
 * PATRÓN BUILDER - CONSTRUCCIÓN FLUIDA
 * ========================================
 *
 * CONCEPTO CLAVE:
 * Builder permite construir objetos complejos paso a paso, con sintaxis fluida
 * y parámetros opcionales, evitando constructores con muchos parámetros.
 *
 * PROBLEMA QUE RESUELVE:
 * Sin Builder, para crear objetos complejos necesitarías:
 *
 * // Constructor telescópico (anti-pattern)
 * Pizza pizza1 = new Pizza("Grande", "Delgada", true, false, true, false);
 * Pizza pizza2 = new Pizza("Mediana", "Gruesa", false, true, false, true);
 * // ¿Qué significa cada boolean? Difícil de leer.
 *
 * // Muchos constructores (también malo)
 * Pizza(String tamano)
 * Pizza(String tamano, String masa)
 * Pizza(String tamano, String masa, boolean queso)
 * // ¡Explosión combinatoria!
 *
 * CON BUILDER:
 * Pizza pizza = new Pizza.Builder("Grande")
 *     .masa("Delgada")
 *     .queso(true)
 *     .pepperoni(true)
 *     .champinones(false)
 *     .build();
 *
 * VENTAJAS:
 * ✓ Sintaxis fluida y legible
 * ✓ Parámetros opcionales claros
 * ✓ Validación antes de construir
 * ✓ Objetos inmutables
 * ✓ Fácil de mantener
 *
 * ESTRUCTURA:
 * 1. Clase externa (objeto a construir)
 * 2. Clase interna estática Builder
 * 3. Constructor privado (solo Builder puede crear)
 * 4. Métodos fluidos en Builder (retornan this)
 * 5. Método build() que crea el objeto final
 *
 * IMPLEMENTACIÓN:
 * class Producto {
 *     // Campos final (inmutables)
 *     private final String nombre;
 *     private final double precio;
 *
 *     // Constructor privado
 *     private Producto(Builder builder) {
 *         this.nombre = builder.nombre;
 *         this.precio = builder.precio;
 *     }
 *
 *     // Builder interno estático
 *     public static class Builder {
 *         // Campos requeridos
 *         private final String nombre;
 *         // Campos opcionales
 *         private double precio = 0.0;
 *
 *         public Builder(String nombre) {
 *             this.nombre = nombre;
 *         }
 *
 *         public Builder precio(double precio) {
 *             this.precio = precio;
 *             return this; // Permite encadenar
 *         }
 *
 *         public Producto build() {
 *             // Validación aquí si es necesario
 *             return new Producto(this);
 *         }
 *     }
 * }
 *
 * ========================================
 * PATRÓN OBSERVER - SISTEMA DE EVENTOS
 * ========================================
 *
 * CONCEPTO CLAVE:
 * Observer define una dependencia uno-a-muchos entre objetos: cuando un
 * objeto (Subject) cambia de estado, todos sus observadores son notificados
 * y actualizados automáticamente.
 *
 * ANALOGÍA:
 * Es como suscribirse a un canal de YouTube:
 * - Canal (Subject): publica videos
 * - Suscriptores (Observers): reciben notificaciones
 * - Cuando hay video nuevo → todos los suscriptores son notificados
 *
 * PARTICIPANTES:
 * 1. Subject (Observable): Objeto observado
 *    - Mantiene lista de observers
 *    - Métodos: attach(observer), detach(observer), notify()
 *
 * 2. Observer: Interface de observadores
 *    - Método: update() o onNotify()
 *
 * 3. ConcreteObserver: Implementaciones específicas
 *    - Implementan update() con su lógica
 *
 * FLUJO:
 * 1. Observers se SUSCRIBEN al Subject
 * 2. Subject cambia de estado
 * 3. Subject NOTIFICA a todos los observers
 * 4. Cada observer REACCIONA a la notificación
 *
 * IMPLEMENTACIÓN:
 * // Interface Observer
 * interface Observer {
 *     void update(String mensaje);
 * }
 *
 * // Subject (Observable)
 * class Subject {
 *     private List<Observer> observers = new ArrayList<>();
 *
 *     public void attach(Observer observer) {
 *         observers.add(observer);
 *     }
 *
 *     public void detach(Observer observer) {
 *         observers.remove(observer);
 *     }
 *
 *     public void notifyObservers(String mensaje) {
 *         for (Observer obs : observers) {
 *             obs.update(mensaje);
 *         }
 *     }
 * }
 *
 * VENTAJAS:
 * ✓ Bajo acoplamiento (Subject no conoce observers concretos)
 * ✓ Fácil añadir/remover observers
 * ✓ Comunicación dinámica
 * ✓ Base para event-driven programming
 *
 * APLICACIONES:
 * ✓ GUIs (botones, eventos)
 * ✓ Model-View-Controller (MVC)
 * ✓ Sistemas de notificaciones
 * ✓ Event listeners
 * ✓ Reactive programming (RxJava)
 *
 * INSTRUCCIONES:
 * 1. Implementa patrón Builder:
 *    - Clase Computadora con: CPU, RAM, almacenamiento, GPU, SO
 *    - Builder interno para construir paso a paso
 *    - Validaciones en build()
 *
 * 2. Implementa patrón Observer:
 *    - Interface Observer con método update()
 *    - Clase CanalYouTube (Subject) con suscriptores
 *    - Clases Suscriptor (Observers concretos)
 *    - Notificaciones cuando se publica nuevo video
 *
 * 3. Demuestra ambos patrones con ejemplos prácticos
 *
 * SALIDA ESPERADA:
 * === PATRONES BUILDER Y OBSERVER ===
 *
 * === PATRÓN BUILDER: CONSTRUCCIÓN DE COMPUTADORAS ===
 * Construyendo computadora gaming...
 * ✓ Computadora Gaming creada:
 * Computadora{CPU='Intel i9', RAM=32GB, Almacenamiento=1000GB, GPU='RTX 4090', SO='Windows 11'}
 *
 * Construyendo computadora de oficina...
 * ✓ Computadora Oficina creada:
 * Computadora{CPU='Intel i5', RAM=8GB, Almacenamiento=500GB, GPU='Integrada', SO='Windows 10'}
 *
 * Construyendo laptop básica...
 * ✓ Laptop creada:
 * Computadora{CPU='Intel i3', RAM=4GB, Almacenamiento=256GB, GPU='Integrada', SO='Linux'}
 *
 * === PATRÓN OBSERVER: CANAL DE YOUTUBE ===
 * Canal 'TechMaster' creado
 *
 * Suscribiéndose al canal...
 * ✓ Juan se suscribió
 * ✓ María se suscribió
 * ✓ Carlos se suscribió
 *
 * Publicando nuevo video...
 * 📹 Nuevo video: 'Tutorial de Java'
 *
 * Notificaciones enviadas:
 * 📧 Juan recibió: Nuevo video disponible - 'Tutorial de Java'
 * 📧 María recibió: Nuevo video disponible - 'Tutorial de Java'
 * 📧 Carlos recibió: Nuevo video disponible - 'Tutorial de Java'
 *
 * María se desinscribe del canal...
 * ✓ María se desinscribió
 *
 * Publicando otro video...
 * 📹 Nuevo video: 'Patrones de Diseño'
 *
 * Notificaciones enviadas:
 * 📧 Juan recibió: Nuevo video disponible - 'Patrones de Diseño'
 * 📧 Carlos recibió: Nuevo video disponible - 'Patrones de Diseño'
 * (María NO recibió notificación - desuscrita)
 *
 * === PATRÓN OBSERVER: BOLSA DE VALORES ===
 * Acción 'TECH' creada con precio inicial: $100.00
 *
 * Inversores registrados:
 * ✓ Inversor Ana registrado
 * ✓ Inversor Pedro registrado
 *
 * Cambio de precio: $100.00 → $105.00
 * 📈 Ana notificada: TECH cambió a $105.00 (▲ +5.00)
 * 📈 Pedro notificado: TECH cambió a $105.00 (▲ +5.00)
 *
 * Cambio de precio: $105.00 → $98.00
 * 📉 Ana notificada: TECH cambió a $98.00 (▼ -7.00)
 * 📉 Pedro notificado: TECH cambió a $98.00 (▼ -7.00)
 *
 * CONCEPTOS NUEVOS:
 * - Builder Pattern: Construcción fluida de objetos
 * - Fluent API: Métodos que retornan this
 * - Method chaining: Encadenamiento de métodos
 * - Observer Pattern: Sistema de notificaciones
 * - Subject (Observable): Objeto observado
 * - Observer: Objeto que observa cambios
 * - attach/detach: Suscribir/desuscribir
 * - notify: Notificar a observers
 * - Event-driven: Programación basada en eventos
 * - Loose coupling: Bajo acoplamiento
 *
 * CUÁNDO USAR BUILDER:
 * ✓ Objetos con muchos parámetros (>4)
 * ✓ Varios parámetros opcionales
 * ✓ Quieres objetos inmutables
 * ✓ Necesitas validación compleja
 * ✓ Construcción paso a paso
 *
 * CUÁNDO USAR OBSERVER:
 * ✓ Cambios en un objeto deben reflejarse en otros
 * ✓ Sistema de notificaciones
 * ✓ Event listeners
 * ✓ MVC (Model-View-Controller)
 * ✓ Reactive programming
 *
 */

import java.util.*;

// ========================================
// PATRÓN BUILDER: COMPUTADORA
// ========================================

// TODO: Implementa clase Computadora con patrón Builder
class Computadora {
    // Atributos finales (inmutables)
    private final String cpu;
    private final int ram;
    private final int almacenamiento;
    private final String gpu;
    private final String sistemaOperativo;

    // Constructor PRIVADO (solo Builder puede crear)
    private Computadora(Builder builder) {
        this.cpu = builder.cpu;
        this.ram = builder.ram;
        this.almacenamiento = builder.almacenamiento;
        this.gpu = builder.gpu;
        this.sistemaOperativo = builder.sistemaOperativo;
    }

    @Override
    public String toString() {
        return String.format("Computadora{CPU='%s', RAM=%dGB, Almacenamiento=%dGB, GPU='%s', SO='%s'}",
            cpu, ram, almacenamiento, gpu, sistemaOperativo);
    }

    // TODO: Implementa Builder interno estático
    public static class Builder {
        // Atributos requeridos
        private final String cpu;

        // Atributos opcionales con valores por defecto
        private int ram = 8;
        private int almacenamiento = 256;
        private String gpu = "Integrada";
        private String sistemaOperativo = "Windows 10";

        // Constructor con parámetros requeridos
        public Builder(String cpu) {
            this.cpu = cpu;
        }

        // Métodos fluidos (retornan this para encadenar)
        public Builder ram(int ram) {
            this.ram = ram;
            return this;
        }

        public Builder almacenamiento(int almacenamiento) {
            this.almacenamiento = almacenamiento;
            return this;
        }

        public Builder gpu(String gpu) {
            this.gpu = gpu;
            return this;
        }

        public Builder sistemaOperativo(String so) {
            this.sistemaOperativo = so;
            return this;
        }

        // Método build() que crea el objeto final
        public Computadora build() {
            // Validaciones
            if (ram < 4) {
                throw new IllegalStateException("RAM debe ser mínimo 4GB");
            }
            if (almacenamiento < 128) {
                throw new IllegalStateException("Almacenamiento debe ser mínimo 128GB");
            }

            return new Computadora(this);
        }
    }
}

// ========================================
// PATRÓN OBSERVER: YOUTUBE
// ========================================

// TODO: Interface Observer
interface Observer {
    void update(String mensaje);
    String getNombre();
}

// TODO: Clase Suscriptor (Observer concreto)
class Suscriptor implements Observer {
    private String nombre;

    public Suscriptor(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public void update(String mensaje) {
        System.out.println("📧 " + nombre + " recibió: " + mensaje);
    }

    @Override
    public String getNombre() {
        return nombre;
    }
}

// TODO: Clase CanalYouTube (Subject/Observable)
class CanalYouTube {
    private String nombreCanal;
    private List<Observer> suscriptores;

    public CanalYouTube(String nombreCanal) {
        this.nombreCanal = nombreCanal;
        this.suscriptores = new ArrayList<>();
    }

    // Suscribir observer
    public void suscribir(Observer observer) {
        suscriptores.add(observer);
        System.out.println("✓ " + observer.getNombre() + " se suscribió");
    }

    // Desuscribir observer
    public void desuscribir(Observer observer) {
        suscriptores.remove(observer);
        System.out.println("✓ " + observer.getNombre() + " se desinscribió");
    }

    // Notificar a todos los suscriptores
    public void publicarVideo(String tituloVideo) {
        System.out.println("\n📹 Nuevo video: '" + tituloVideo + "'");
        System.out.println("\nNotificaciones enviadas:");

        String mensaje = "Nuevo video disponible - '" + tituloVideo + "'";
        for (Observer suscriptor : suscriptores) {
            suscriptor.update(mensaje);
        }
    }

    public String getNombreCanal() {
        return nombreCanal;
    }
}

// ========================================
// PATRÓN OBSERVER: BOLSA DE VALORES
// ========================================

// TODO: Interface Observer para acciones
interface ObservadorAccion {
    void actualizar(String nombreAccion, double precioAnterior, double precioNuevo);
}

// TODO: Clase Inversor (Observer concreto)
class Inversor implements ObservadorAccion {
    private String nombre;

    public Inversor(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public void actualizar(String nombreAccion, double precioAnterior, double precioNuevo) {
        double cambio = precioNuevo - precioAnterior;
        String indicador = cambio > 0 ? "▲" : "▼";
        String emoji = cambio > 0 ? "📈" : "📉";

        System.out.printf("%s %s notificado: %s cambió a $%.2f (%s %+.2f)%n",
            emoji, nombre, nombreAccion, precioNuevo, indicador, cambio);
    }

    public String getNombre() {
        return nombre;
    }
}

// TODO: Clase Accion (Subject/Observable)
class Accion {
    private String nombre;
    private double precio;
    private List<ObservadorAccion> inversores;

    public Accion(String nombre, double precioInicial) {
        this.nombre = nombre;
        this.precio = precioInicial;
        this.inversores = new ArrayList<>();
    }

    public void registrarInversor(ObservadorAccion inversor) {
        inversores.add(inversor);
    }

    public void removerInversor(ObservadorAccion inversor) {
        inversores.remove(inversor);
    }

    // Cambiar precio y notificar
    public void cambiarPrecio(double nuevoPrecio) {
        double precioAnterior = this.precio;
        this.precio = nuevoPrecio;

        System.out.printf("\nCambio de precio: $%.2f → $%.2f%n", precioAnterior, nuevoPrecio);

        // Notificar a todos los inversores
        for (ObservadorAccion inversor : inversores) {
            inversor.actualizar(nombre, precioAnterior, nuevoPrecio);
        }
    }

    public double getPrecio() {
        return precio;
    }
}

// ========================================
// CLASE PRINCIPAL
// ========================================

public class Ejercicio34 {
    public static void main(String[] args) {
        System.out.println("=== PATRONES BUILDER Y OBSERVER ===\n");

        // ========================================
        // DEMOSTRACIÓN: PATRÓN BUILDER
        // ========================================
        System.out.println("=== PATRÓN BUILDER: CONSTRUCCIÓN DE COMPUTADORAS ===");

        // Computadora gaming (todas las opciones)
        System.out.println("Construyendo computadora gaming...");
        Computadora gaming = new Computadora.Builder("Intel i9")
            .ram(32)
            .almacenamiento(1000)
            .gpu("RTX 4090")
            .sistemaOperativo("Windows 11")
            .build();
        System.out.println("✓ Computadora Gaming creada:");
        System.out.println(gaming);
        System.out.println();

        // Computadora de oficina (opciones limitadas)
        System.out.println("Construyendo computadora de oficina...");
        Computadora oficina = new Computadora.Builder("Intel i5")
            .ram(8)
            .almacenamiento(500)
            .build(); // GPU y SO usan valores por defecto
        System.out.println("✓ Computadora Oficina creada:");
        System.out.println(oficina);
        System.out.println();

        // Laptop básica (mínimas especificaciones)
        System.out.println("Construyendo laptop básica...");
        Computadora laptop = new Computadora.Builder("Intel i3")
            .ram(4)
            .sistemaOperativo("Linux")
            .build();
        System.out.println("✓ Laptop creada:");
        System.out.println(laptop);
        System.out.println();

        // ========================================
        // DEMOSTRACIÓN: PATRÓN OBSERVER - YOUTUBE
        // ========================================
        System.out.println("=== PATRÓN OBSERVER: CANAL DE YOUTUBE ===");

        // Crear canal
        CanalYouTube canal = new CanalYouTube("TechMaster");
        System.out.println("Canal '" + canal.getNombreCanal() + "' creado\n");

        // Crear suscriptores
        Suscriptor juan = new Suscriptor("Juan");
        Suscriptor maria = new Suscriptor("María");
        Suscriptor carlos = new Suscriptor("Carlos");

        // Suscribirse al canal
        System.out.println("Suscribiéndose al canal...");
        canal.suscribir(juan);
        canal.suscribir(maria);
        canal.suscribir(carlos);

        // Publicar video (notifica a todos)
        System.out.println("\nPublicando nuevo video...");
        canal.publicarVideo("Tutorial de Java");

        // Desuscribirse
        System.out.println("\nMaría se desinscribe del canal...");
        canal.desuscribir(maria);

        // Publicar otro video (María NO recibe notificación)
        System.out.println("\nPublicando otro video...");
        canal.publicarVideo("Patrones de Diseño");
        System.out.println("(María NO recibió notificación - desuscrita)");

        // ========================================
        // DEMOSTRACIÓN: PATRÓN OBSERVER - BOLSA
        // ========================================
        System.out.println("\n=== PATRÓN OBSERVER: BOLSA DE VALORES ===");

        // Crear acción
        Accion accionTech = new Accion("TECH", 100.0);
        System.out.printf("Acción '%s' creada con precio inicial: $%.2f%n",
            "TECH", accionTech.getPrecio());

        // Crear inversores
        Inversor ana = new Inversor("Ana");
        Inversor pedro = new Inversor("Pedro");

        // Registrar inversores
        System.out.println("\nInversores registrados:");
        accionTech.registrarInversor(ana);
        System.out.println("✓ Inversor " + ana.getNombre() + " registrado");
        accionTech.registrarInversor(pedro);
        System.out.println("✓ Inversor " + pedro.getNombre() + " registrado");

        // Cambiar precio (sube)
        accionTech.cambiarPrecio(105.0);

        // Cambiar precio (baja)
        accionTech.cambiarPrecio(98.0);

        // Cambiar precio (sube mucho)
        accionTech.cambiarPrecio(120.0);

        // ========================================
        // EJEMPLO AVANZADO: CLIMA (OBSERVER)
        // ========================================
        System.out.println("\n=== PATRÓN OBSERVER: ESTACIÓN METEOROLÓGICA ===");

        EstacionMeteorologica estacion = new EstacionMeteorologica();

        // Crear displays (observers)
        DisplayTemperatura displayTemp = new DisplayTemperatura();
        DisplayEstadisticas displayEstadisticas = new DisplayEstadisticas();

        // Registrar displays
        estacion.registrarObservador(displayTemp);
        estacion.registrarObservador(displayEstadisticas);

        // Actualizar mediciones (notifica a observers)
        System.out.println("\nActualizando mediciones...");
        estacion.actualizarMediciones(25.5, 65, 1013.2);

        System.out.println("\nActualizando mediciones...");
        estacion.actualizarMediciones(23.8, 70, 1012.8);

        // REFLEXIÓN FINAL:
        // ¿Por qué usar Builder?
        // ✓ Código más legible y mantenible
        // ✓ Objetos inmutables (thread-safe)
        // ✓ Validación centralizada
        // ✓ Parámetros opcionales claros
        // ✓ Evita constructores telescópicos
        //
        // ¿Por qué usar Observer?
        // ✓ Bajo acoplamiento (Subject no conoce observers concretos)
        // ✓ Fácil añadir/remover observers dinámicamente
        // ✓ Broadcast de cambios automático
        // ✓ Base para programación reactiva
        // ✓ Separación de concerns (responsabilidades)
        //
        // EN LA VIDA REAL:
        //
        // BUILDER:
        // - StringBuilder/StringBuffer: construcción de strings
        // - Retrofit (Android): construcción de clientes HTTP
        // - Lombok @Builder: genera builder automáticamente
        // - Spring Boot: configuración de aplicaciones
        // - Configuración de queries complejas
        //
        // OBSERVER:
        // - Java Swing/JavaFX: ActionListener, PropertyChangeListener
        // - Android: OnClickListener, LiveData
        // - RxJava/RxAndroid: programación reactiva
        // - Event-driven systems: Node.js, JavaScript
        // - MVC: Model notifica a Views cuando cambia
        //
        // VARIACIONES DE OBSERVER:
        //
        // 1. PUSH MODEL (lo que usamos):
        //    Subject envía datos al observer
        //    observer.update(datos)
        //
        // 2. PULL MODEL:
        //    Observer obtiene datos del subject
        //    observer.update() → observer.getData(subject)
        //
        // 3. EVENT BUS:
        //    Sistema centralizado de eventos (Guava EventBus)
        //
        // OBSERVER EN JAVA:
        // Java tiene java.util.Observable y java.util.Observer
        // PERO están @Deprecated desde Java 9
        // Razón: no thread-safe, diseño inflexible
        // Alternativas: PropertyChangeListener, event libraries
        //
        // BUILDER - MEJORES PRÁCTICAS:
        // ✓ Campos required en constructor de Builder
        // ✓ Campos optional con defaults
        // ✓ Validar en build()
        // ✓ Objeto final inmutable
        // ✓ Builder puede reutilizarse o no (según diseño)
        //
        // OBSERVER - MEJORES PRÁCTICAS:
        // ✓ Interface Observer permite múltiples implementaciones
        // ✓ Weak references para evitar memory leaks
        // ✓ Thread-safe si múltiples hilos modifican
        // ✓ Considerar orden de notificación
        // ✓ Manejar excepciones en observers
        //
        // PATRONES RELACIONADOS:
        //
        // BUILDER:
        // - Abstract Factory: familia de objetos relacionados
        // - Prototype: clonación de objetos
        //
        // OBSERVER:
        // - Mediator: comunicación entre objetos
        // - Command: encapsular acciones como objetos
        // - Publish-Subscribe: similar pero con canal intermedio
        //
        // DIFERENCIA OBSERVER vs PUBLISH-SUBSCRIBE:
        //
        // Observer:
        // - Acoplamiento directo Subject-Observer
        // - Subject mantiene lista de observers
        //
        // Pub-Sub:
        // - Desacoplamiento total via Event Channel
        // - Publishers y subscribers no se conocen
        // - Ejemplo: Kafka, RabbitMQ, Redis Pub/Sub
        //
        // CUÁNDO NO USAR:
        //
        // Builder:
        // ✗ Objetos simples (<4 parámetros)
        // ✗ Si no hay parámetros opcionales
        // ✗ Over-engineering para casos simples
        //
        // Observer:
        // ✗ Relación uno-a-uno simple
        // ✗ Si los cambios son raros
        // ✗ Complejidad innecesaria para casos simples
        //
        // CONCLUSIÓN:
        // Builder y Observer son patrones fundamentales que todo
        // desarrollador Java debe dominar. Son ampliamente usados
        // en frameworks modernos y facilitan código mantenible.
    }
}

// ========================================
// EJEMPLO ADICIONAL: ESTACIÓN METEOROLÓGICA
// ========================================

interface ObservadorClima {
    void actualizar(double temperatura, int humedad, double presion);
}

class DisplayTemperatura implements ObservadorClima {
    @Override
    public void actualizar(double temperatura, int humedad, double presion) {
        System.out.println("🌡️  Display Temperatura: " + temperatura + "°C");
    }
}

class DisplayEstadisticas implements ObservadorClima {
    @Override
    public void actualizar(double temperatura, int humedad, double presion) {
        System.out.printf("📊 Display Estadísticas: Temp=%.1f°C, Humedad=%d%%, Presión=%.1f mb%n",
            temperatura, humedad, presion);
    }
}

class EstacionMeteorologica {
    private List<ObservadorClima> observadores = new ArrayList<>();
    private double temperatura;
    private int humedad;
    private double presion;

    public void registrarObservador(ObservadorClima obs) {
        observadores.add(obs);
    }

    public void removerObservador(ObservadorClima obs) {
        observadores.remove(obs);
    }

    public void actualizarMediciones(double temp, int hum, double pres) {
        this.temperatura = temp;
        this.humedad = hum;
        this.presion = pres;
        notificarObservadores();
    }

    private void notificarObservadores() {
        for (ObservadorClima obs : observadores) {
            obs.actualizar(temperatura, humedad, presion);
        }
    }
}
