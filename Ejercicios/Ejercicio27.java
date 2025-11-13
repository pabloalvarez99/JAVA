/*
 * ========================================
 * EJERCICIO 27: Enum y Optional - Java Moderno
 * DIFICULTAD: ⭐⭐⭐⭐⭐⭐⭐⭐⭐ (Maestro)
 * ========================================
 *
 * OBJETIVO:
 * Aprender sobre ENUMS (tipos enumerados) y OPTIONAL (manejo moderno de null)
 * dos características fundamentales del Java moderno
 *
 * CONCEPTO CLAVE 1: ENUMS
 * Un Enum es un tipo especial que representa un grupo FIJO de constantes.
 * Es como tener un conjunto limitado de opciones predefinidas.
 *
 * ANTES DE ENUMS (problemático):
 * public static final int LUNES = 1;
 * public static final int MARTES = 2;
 * // Problema: puedes asignar cualquier int, no solo 1-7
 * int dia = 99;  // ❌ No hay validación
 *
 * CON ENUMS (seguro):
 * enum DiaSemana { LUNES, MARTES, MIERCOLES, ... }
 * DiaSemana dia = DiaSemana.LUNES;  // ✓ Solo valores válidos
 * // dia = 99;  // ❌ ERROR de compilación
 *
 * CONCEPTO CLAVE 2: OPTIONAL
 * Optional<T> es un contenedor que puede o no contener un valor no-null.
 * Ayuda a evitar NullPointerException y hace el código más explícito.
 *
 * ANTES DE OPTIONAL (peligroso):
 * String nombre = buscarUsuario(id);
 * System.out.println(nombre.toUpperCase());  // ❌ Puede ser null → crash
 *
 * CON OPTIONAL (seguro):
 * Optional<String> nombre = buscarUsuario(id);
 * nombre.ifPresent(n -> System.out.println(n.toUpperCase()));  // ✓ Seguro
 *
 * ANALOGÍA ENUM:
 * Es como los colores de un semáforo: solo puede ser ROJO, AMARILLO o VERDE.
 * No puede ser "azul" ni "42" ni cualquier otro valor.
 *
 * ANALOGÍA OPTIONAL:
 * Es como una caja que puede estar vacía o tener algo dentro.
 * Siempre verificas si hay algo antes de usarlo.
 *
 * VENTAJAS DE ENUMS:
 * ✓ Type-safe: El compilador valida los valores
 * ✓ Legible: Nombres descriptivos en vez de números
 * ✓ Pueden tener métodos y atributos
 * ✓ Pueden implementar interfaces
 * ✓ Switch-case exhaustivo
 *
 * VENTAJAS DE OPTIONAL:
 * ✓ Evita NullPointerException
 * ✓ Hace explícito que un valor puede estar ausente
 * ✓ API funcional (map, flatMap, filter, etc.)
 * ✓ Código más limpio y expresivo
 *
 * INSTRUCCIONES:
 * 1. Crea un Enum "Prioridad" con: BAJA, MEDIA, ALTA, CRITICA
 *    - Cada valor tiene: nivel (int), descripción (String)
 *    - Método getNivel() y getDescripcion()
 *    - Método estático fromNivel(int) que retorna Optional<Prioridad>
 *
 * 2. Crea un Enum "EstadoPedido" con: PENDIENTE, PROCESANDO, ENVIADO, ENTREGADO, CANCELADO
 *    - Método puedeTransicionar(EstadoPedido nuevo) - valida transiciones válidas
 *    - Método siguienteEstado() - retorna Optional del siguiente estado
 *
 * 3. Crea una clase "Usuario" con:
 *    - nombre (String)
 *    - email (Optional<String>) - puede no tener email
 *    - telefono (Optional<String>) - puede no tener teléfono
 *    - Métodos para obtener email/teléfono con valores por defecto
 *
 * 4. Crea una clase "RepositorioUsuarios" con:
 *    - Método buscarPorId(int id) → Optional<Usuario>
 *    - Método buscarPorNombre(String nombre) → Optional<Usuario>
 *
 * 5. Demuestra el uso de Optional:
 *    - ifPresent(), orElse(), orElseGet(), orElseThrow()
 *    - map(), flatMap(), filter()
 *    - isPresent(), isEmpty()
 *
 * SALIDA ESPERADA:
 * === ENUMS Y OPTIONAL - JAVA MODERNO ===
 *
 * === ENUM: PRIORIDADES ===
 * Prioridad.BAJA: nivel 1 - No urgente
 * Prioridad.MEDIA: nivel 2 - Importante
 * Prioridad.ALTA: nivel 3 - Urgente
 * Prioridad.CRITICA: nivel 4 - Emergencia
 *
 * Buscar prioridad por nivel 3: ALTA
 * Buscar prioridad por nivel 99: No encontrado
 *
 * === ENUM: ESTADOS DE PEDIDO ===
 * Estado actual: PENDIENTE
 * ¿Puede pasar a PROCESANDO? true
 * ¿Puede pasar a ENTREGADO? false
 * Siguiente estado: PROCESANDO
 *
 * === OPTIONAL: MANEJO DE VALORES NULOS ===
 * Usuario 1: Juan (Email: juan@email.com, Teléfono: 555-1234)
 * Usuario 2: María (Email: maria@email.com, Teléfono: No disponible)
 * Usuario 3: Pedro (Email: No disponible, Teléfono: 555-5678)
 *
 * === OPTIONAL: OPERACIONES ===
 * Buscando usuario por ID 1...
 * Usuario encontrado: Juan
 * Email en mayúsculas: JUAN@EMAIL.COM
 *
 * Buscando usuario por ID 999...
 * Usuario no encontrado. Usando default: Desconocido
 *
 * === OPTIONAL: ENCADENAMIENTO ===
 * Usuario 1 - Email disponible: juan@email.com
 * Usuario 2 - Email disponible: maria@email.com
 * Usuario 3 - Email NO disponible
 *
 * CONCEPTOS NUEVOS:
 * - Enum: Tipo enumerado con valores fijos
 * - Optional<T>: Contenedor para valores que pueden ser null
 * - Type safety: Seguridad de tipos en compilación
 * - Fluent API: Métodos encadenables
 * - ifPresent(), orElse(), map(): Operaciones de Optional
 * - Null safety: Evitar NullPointerException
 *
 * USO DE ENUMS EN LA VIDA REAL:
 * - Estados de orden: PENDING, SHIPPED, DELIVERED
 * - Niveles de log: DEBUG, INFO, WARN, ERROR
 * - Roles de usuario: ADMIN, USER, GUEST
 * - Tipos de pago: CASH, CREDIT_CARD, PAYPAL
 * - Días de la semana, meses, etc.
 *
 * USO DE OPTIONAL EN LA VIDA REAL:
 * - Resultados de búsqueda en base de datos
 * - Configuraciones opcionales
 * - Parámetros opcionales en APIs
 * - Cadenas de transformación seguras
 *
 */

import java.util.Optional;
import java.util.HashMap;

// TODO: Crea el Enum Prioridad
enum Prioridad {
    BAJA(1, "No urgente"),
    MEDIA(2, "Importante"),
    ALTA(3, "Urgente"),
    CRITICA(4, "Emergencia");

    // Atributos del enum
    private final int nivel;
    private final String descripcion;

    // Constructor (siempre privado en enums)
    Prioridad(int nivel, String descripcion) {
        this.nivel = nivel;
        this.descripcion = descripcion;
    }

    // Getters
    public int getNivel() {
        return nivel;
    }

    public String getDescripcion() {
        return descripcion;
    }

    // Método estático para buscar por nivel
    public static Optional<Prioridad> fromNivel(int nivel) {
        // TODO: Busca la prioridad con ese nivel
        for (Prioridad p : Prioridad.values()) {
            if (p.nivel == nivel) {
                return Optional.of(p);  // Encontrado
            }
        }
        return Optional.empty();  // No encontrado
    }

    @Override
    public String toString() {
        return name() + ": nivel " + nivel + " - " + descripcion;
    }
}

// TODO: Crea el Enum EstadoPedido
enum EstadoPedido {
    PENDIENTE,
    PROCESANDO,
    ENVIADO,
    ENTREGADO,
    CANCELADO;

    // Método para validar transiciones
    public boolean puedeTransicionar(EstadoPedido nuevo) {
        // TODO: Define transiciones válidas
        switch (this) {
            case PENDIENTE:
                return nuevo == PROCESANDO || nuevo == CANCELADO;
            case PROCESANDO:
                return nuevo == ENVIADO || nuevo == CANCELADO;
            case ENVIADO:
                return nuevo == ENTREGADO;
            case ENTREGADO:
            case CANCELADO:
                return false;  // Estados finales
            default:
                return false;
        }
    }

    // Método para obtener el siguiente estado
    public Optional<EstadoPedido> siguienteEstado() {
        // TODO: Retorna el siguiente estado lógico
        switch (this) {
            case PENDIENTE:
                return Optional.of(PROCESANDO);
            case PROCESANDO:
                return Optional.of(ENVIADO);
            case ENVIADO:
                return Optional.of(ENTREGADO);
            case ENTREGADO:
            case CANCELADO:
                return Optional.empty();  // No hay siguiente
            default:
                return Optional.empty();
        }
    }
}

// TODO: Crea la clase Usuario
class Usuario {
    private String nombre;
    private Optional<String> email;
    private Optional<String> telefono;

    // Constructor
    public Usuario(String nombre, String email, String telefono) {
        this.nombre = nombre;
        // TODO: Usa Optional.ofNullable para email y teléfono
        this.email = Optional.ofNullable(email);
        this.telefono = Optional.ofNullable(telefono);
    }

    // Getters
    public String getNombre() {
        return nombre;
    }

    public Optional<String> getEmail() {
        return email;
    }

    public Optional<String> getTelefono() {
        return telefono;
    }

    // Métodos con valores por defecto
    public String getEmailOrDefault() {
        // TODO: Retorna email o "No disponible" si no tiene
        return email.orElse("No disponible");
    }

    public String getTelefonoOrDefault() {
        // TODO: Retorna teléfono o "No disponible" si no tiene
        return telefono.orElse("No disponible");
    }

    @Override
    public String toString() {
        return nombre + " (Email: " + getEmailOrDefault() +
               ", Teléfono: " + getTelefonoOrDefault() + ")";
    }
}

// TODO: Crea la clase RepositorioUsuarios
class RepositorioUsuarios {
    private HashMap<Integer, Usuario> usuarios;

    public RepositorioUsuarios() {
        usuarios = new HashMap<>();
        // Datos de ejemplo
        usuarios.put(1, new Usuario("Juan", "juan@email.com", "555-1234"));
        usuarios.put(2, new Usuario("María", "maria@email.com", null));
        usuarios.put(3, new Usuario("Pedro", null, "555-5678"));
    }

    // Buscar por ID
    public Optional<Usuario> buscarPorId(int id) {
        // TODO: Retorna Optional del usuario
        return Optional.ofNullable(usuarios.get(id));
    }

    // Buscar por nombre
    public Optional<Usuario> buscarPorNombre(String nombre) {
        // TODO: Busca usuario por nombre
        for (Usuario u : usuarios.values()) {
            if (u.getNombre().equalsIgnoreCase(nombre)) {
                return Optional.of(u);
            }
        }
        return Optional.empty();
    }
}

public class Ejercicio27 {
    public static void main(String[] args) {
        System.out.println("=== ENUMS Y OPTIONAL - JAVA MODERNO ===\n");

        // === ENUM: PRIORIDADES ===
        System.out.println("=== ENUM: PRIORIDADES ===");
        for (Prioridad p : Prioridad.values()) {
            System.out.println("Prioridad." + p);
        }
        System.out.println();

        // Buscar prioridad por nivel
        Optional<Prioridad> p1 = Prioridad.fromNivel(3);
        System.out.print("Buscar prioridad por nivel 3: ");
        p1.ifPresentOrElse(
            prioridad -> System.out.println(prioridad.name()),
            () -> System.out.println("No encontrado")
        );

        Optional<Prioridad> p2 = Prioridad.fromNivel(99);
        System.out.print("Buscar prioridad por nivel 99: ");
        p2.ifPresentOrElse(
            prioridad -> System.out.println(prioridad.name()),
            () -> System.out.println("No encontrado")
        );
        System.out.println();

        // === ENUM: ESTADOS DE PEDIDO ===
        System.out.println("=== ENUM: ESTADOS DE PEDIDO ===");
        EstadoPedido estadoActual = EstadoPedido.PENDIENTE;
        System.out.println("Estado actual: " + estadoActual);
        System.out.println("¿Puede pasar a PROCESANDO? " + estadoActual.puedeTransicionar(EstadoPedido.PROCESANDO));
        System.out.println("¿Puede pasar a ENTREGADO? " + estadoActual.puedeTransicionar(EstadoPedido.ENTREGADO));

        Optional<EstadoPedido> siguiente = estadoActual.siguienteEstado();
        System.out.print("Siguiente estado: ");
        siguiente.ifPresent(System.out::println);
        System.out.println();

        // === OPTIONAL: MANEJO DE VALORES NULOS ===
        System.out.println("=== OPTIONAL: MANEJO DE VALORES NULOS ===");
        RepositorioUsuarios repo = new RepositorioUsuarios();

        System.out.println("Usuario 1: " + repo.buscarPorId(1).get());
        System.out.println("Usuario 2: " + repo.buscarPorId(2).get());
        System.out.println("Usuario 3: " + repo.buscarPorId(3).get());
        System.out.println();

        // === OPTIONAL: OPERACIONES ===
        System.out.println("=== OPTIONAL: OPERACIONES ===");

        // ifPresent - ejecuta acción si está presente
        System.out.println("Buscando usuario por ID 1...");
        repo.buscarPorId(1).ifPresent(u -> {
            System.out.println("Usuario encontrado: " + u.getNombre());
            // TODO: Usa map para transformar el email a mayúsculas
            u.getEmail().map(String::toUpperCase)
                       .ifPresent(email -> System.out.println("Email en mayúsculas: " + email));
        });
        System.out.println();

        // orElse - valor por defecto
        System.out.println("Buscando usuario por ID 999...");
        Usuario usuario = repo.buscarPorId(999)
                             .orElse(new Usuario("Desconocido", null, null));
        System.out.println("Usuario no encontrado. Usando default: " + usuario.getNombre());
        System.out.println();

        // === OPTIONAL: ENCADENAMIENTO ===
        System.out.println("=== OPTIONAL: ENCADENAMIENTO ===");

        // Ejemplo: Obtener email en mayúsculas o mensaje por defecto
        for (int id = 1; id <= 3; id++) {
            final int userId = id;
            String resultado = repo.buscarPorId(id)
                                  .flatMap(Usuario::getEmail)  // Optional<String>
                                  .map(String::toLowerCase)     // transforma si existe
                                  .orElse("Email NO disponible");

            if (resultado.equals("Email NO disponible")) {
                System.out.println("Usuario " + userId + " - " + resultado);
            } else {
                System.out.println("Usuario " + userId + " - Email disponible: " + resultado);
            }
        }
        System.out.println();

        // === OPTIONAL: FILTER ===
        System.out.println("=== OPTIONAL: FILTER ===");
        // Busca usuarios con email que contenga "juan"
        repo.buscarPorId(1)
            .flatMap(Usuario::getEmail)
            .filter(email -> email.contains("juan"))
            .ifPresentOrElse(
                email -> System.out.println("Email encontrado con 'juan': " + email),
                () -> System.out.println("No se encontró email con 'juan'")
            );
        System.out.println();

        // === ENUM EN SWITCH ===
        System.out.println("=== ENUM EN SWITCH ===");
        Prioridad prioridadTarea = Prioridad.ALTA;
        String accion = switch (prioridadTarea) {
            case CRITICA -> "¡ATENDER INMEDIATAMENTE!";
            case ALTA -> "Atender pronto";
            case MEDIA -> "Programar para hoy";
            case BAJA -> "Programar para esta semana";
        };
        System.out.println("Tarea con prioridad " + prioridadTarea.name() + ": " + accion);
        System.out.println();

        // REFLEXIÓN:
        // ¿Por qué usar Enums?
        // ✓ Type-safe: Solo valores válidos
        // ✓ Legible: Nombres en vez de números mágicos
        // ✓ Mantenible: Cambios centralizados
        // ✓ Switch exhaustivo: El compilador valida todos los casos
        //
        // ¿Por qué usar Optional?
        // ✓ Evita NullPointerException
        // ✓ Hace explícito que un valor puede no existir
        // ✓ API funcional: map, flatMap, filter
        // ✓ Código más expresivo y seguro
        //
        // ENUMS EN LA VIDA REAL:
        // - HTTP Status: 200 OK, 404 NOT_FOUND, 500 ERROR
        // - Logging levels: DEBUG, INFO, WARN, ERROR
        // - User roles: ADMIN, MODERATOR, USER
        // - Payment methods: CREDIT_CARD, PAYPAL, CRYPTO
        //
        // OPTIONAL EN LA VIDA REAL:
        // - Database queries: findById() → Optional<User>
        // - Configuration: getProperty() → Optional<String>
        // - Stream API: findFirst() → Optional<T>
        // - REST APIs: Optional fields
        //
        // MEJORES PRÁCTICAS:
        // ✓ NUNCA retornar Optional.of(null) → usa Optional.empty()
        // ✓ NUNCA usar Optional en parámetros de método
        // ✓ NUNCA usar Optional en campos de clase (usa null directamente)
        // ✓ USA Optional solo en valores de retorno
        // ✓ USA orElseThrow() para casos donde el valor debe existir
        //
        // OPERACIONES DE OPTIONAL:
        // - isPresent() / isEmpty(): Verificar si tiene valor
        // - ifPresent(Consumer): Ejecutar si tiene valor
        // - map(Function): Transformar valor
        // - flatMap(Function): Transformar a otro Optional
        // - filter(Predicate): Filtrar por condición
        // - orElse(T): Valor por defecto
        // - orElseGet(Supplier): Valor por defecto lazy
        // - orElseThrow(): Lanzar excepción si vacío
        //
        // ANTI-PATTERNS A EVITAR:
        // ❌ if (optional.isPresent()) { optional.get() } → usa ifPresent()
        // ❌ optional.orElse(new Object()) → usa orElseGet(() -> new Object())
        // ❌ Optional<Optional<T>> → usa flatMap en vez de map
    }
}
