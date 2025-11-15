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

public class Ejercicio27 {
    // TODO: Lee las instrucciones arriba y escribe TODO el código
    // TODO: Implementa todas las clases, métodos y lógica necesaria
}
