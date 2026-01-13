/**
 * =================================================================
 * CLASE: Mensaje
 * =================================================================
 *
 * QUE ES ESTA CLASE?
 * ------------------
 * Esta clase representa un MENSAJE enviado en un chat.
 *
 * ANALOGIA: Piensa en un mensaje de WhatsApp que enviaste.
 * Ese mensaje tiene:
 * - Un ID oculto (que WhatsApp usa internamente)
 * - Pertenece a un chat especifico (chat familiar, con amigo, etc.)
 * - Tiene fecha y hora de envio
 * - Lo envio alguien (el remitente)
 * - Tiene contenido (el texto que escribiste)
 *
 * POR QUE EXISTE ESTA CLASE?
 * ---------------------------
 * Para representar los mensajes que se envian en los chats.
 * Cada mensaje es un objeto de esta clase.
 *
 * QUE CONTIENE?
 * -------------
 * 1. ATRIBUTOS: id, chat, fecha, remitente, contenido
 * 2. CONSTRUCTOR: para crear nuevos mensajes
 * 3. GETTERS: para leer los datos del mensaje
 * 4. toString(): para mostrar el mensaje formateado
 *
 * =================================================================
 */
class Mensaje {

    // ============================================================
    // SECCION 1: ATRIBUTOS (LAS CARACTERISTICAS DEL MENSAJE)
    // ============================================================

    /**
     * ATRIBUTO: id
     * -------------
     * Identificador UNICO del mensaje.
     *
     * ANALOGIA: Como el numero de seguimiento de un paquete.
     * Cada mensaje tiene un numero unico que lo identifica.
     *
     * TIPO: int
     * Esto significa que es un numero entero (1, 2, 3, 100, etc.)
     *
     * MODIFICADORES:
     * - private: Solo esta clase puede verlo directamente
     * - final: No puede cambiar una vez asignado
     *
     * POR QUE final?
     * Un mensaje enviado tiene un ID fijo que no cambia nunca.
     */
    private final int id;

    /**
     * ATRIBUTO: chat
     * ---------------
     * El CHAT al que pertenece este mensaje.
     *
     * TIPO: Chat
     * Esto NO es un tipo primitivo (como int, boolean, double),
     * sino que es una REFERENCIA a un objeto de la clase Chat.
     *
     * QUE SIGNIFICA ESTO?
     * -------------------
     * Este atributo "apunta" a un objeto Chat que existe en
     * alguna parte de la memoria. Es como tener la direccion
     * de una casa en vez de la casa completa.
     *
     * EJEMPLO VISUAL:
     * ┌──────────────┐       apunta a      ┌──────────────┐
     * │   Mensaje    │ ───────────────────→ │    Chat      │
     * │  chat: ref   │                      │  id: 1       │
     * └──────────────┘                      │  titulo: ... │
     *                                       └──────────────┘
     *
     * POR QUE ES IMPORTANTE?
     * Asi sabemos a que conversacion pertenece cada mensaje.
     */
    private final Chat chat;

    /**
     * ATRIBUTO: fecha
     * ----------------
     * Fecha y hora en que se envio el mensaje.
     *
     * TIPO: String
     * Aunque parezca raro, la fecha esta guardada como texto.
     *
     * FORMATO: "hh:mm dd/MM/yyyy"
     * - hh: hora (00-23)
     * - mm: minutos (00-59)
     * - dd: dia (01-31)
     * - MM: mes (01-12)
     * - yyyy: año (2023, 2024, etc.)
     *
     * EJEMPLO: "14:30 15/10/2023"
     * Esto significa: 2:30 PM del 15 de octubre de 2023
     *
     * NOTA PARA PRINCIPIANTES:
     * En un sistema real, usariamos un tipo de dato especial
     * para fechas (como LocalDateTime), pero aqui usamos String
     * por simplicidad.
     */
    private final String fecha;

    /**
     * ATRIBUTO: remitente
     * --------------------
     * El USUARIO que envio este mensaje.
     *
     * TIPO: Usuario
     * Es una REFERENCIA a un objeto Usuario.
     *
     * ANALOGIA: Es como el "De:" en un correo electronico.
     * Te dice quien envio el mensaje.
     *
     * EJEMPLO VISUAL:
     * ┌──────────────┐       apunta a      ┌──────────────┐
     * │   Mensaje    │ ───────────────────→ │   Usuario    │
     * │ remitente:ref│                      │  id: 1       │
     * └──────────────┘                      │  nombre:Juan │
     *                                       └──────────────┘
     */
    private final Usuario remitente;

    /**
     * ATRIBUTO: contenido
     * --------------------
     * El TEXTO del mensaje (lo que escribiste).
     *
     * TIPO: String (texto)
     *
     * EJEMPLO: "Hola, como estas?"
     *          "Nos vemos mañana a las 3pm"
     *          "😊" (puede contener emojis si el sistema lo permite)
     *
     * POR QUE ES "private final"?
     * - private: Proteccion (solo se accede via getter)
     * - final: Un mensaje enviado no se puede editar
     *          (como en WhatsApp cuando no tienes opcion de editar)
     */
    private final String contenido;

    // ============================================================
    // SECCION 2: CONSTRUCTOR
    // ============================================================

    /**
     * CONSTRUCTOR DE LA CLASE Mensaje
     * ================================
     *
     * Este constructor INICIALIZA un nuevo mensaje con todos sus datos.
     *
     * CUANDO SE USA?
     * --------------
     * Cuando alguien envia un mensaje en el sistema.
     *
     * EJEMPLO DE USO:
     * ---------------
     * Mensaje m = new Mensaje(
     *     1,                           // id del mensaje
     *     chatAmigos,                  // el chat donde se envia
     *     "14:30 15/10/2023",          // fecha y hora
     *     juan,                        // quien lo envia
     *     "Hola a todos"               // el texto del mensaje
     * );
     *
     * QUE HACE EL CONSTRUCTOR?
     * ------------------------
     * 1. Recibe los 5 parametros
     * 2. Asigna cada parametro a su atributo correspondiente
     * 3. Devuelve el objeto Mensaje listo para usar
     *
     * PARAMETROS:
     * -----------
     * @param id - Numero identificador unico del mensaje
     * @param chat - El chat al que pertenece el mensaje
     * @param fecha - Fecha y hora en formato "hh:mm dd/MM/yyyy"
     * @param remitente - El usuario que envia el mensaje
     * @param contenido - El texto del mensaje
     *
     * NOTA SOBRE "this":
     * ------------------
     * "this" se refiere al objeto actual que estamos creando.
     * Se usa para diferenciar entre el parametro y el atributo:
     * - this.id → el atributo de la clase
     * - id → el parametro recibido
     */
    public Mensaje(int id, Chat chat, String fecha, Usuario remitente, String contenido) {
        // Asignar el ID recibido al atributo id
        this.id = id;

        // Asignar la referencia al Chat recibida al atributo chat
        // IMPORTANTE: No estamos copiando el chat, solo guardamos
        // una referencia (apuntador) al objeto Chat existente
        this.chat = chat;

        // Asignar la fecha (como String) al atributo fecha
        this.fecha = fecha;

        // Asignar la referencia al Usuario remitente al atributo remitente
        this.remitente = remitente;

        // Asignar el contenido (texto) al atributo contenido
        this.contenido = contenido;

        // Despues de estas 5 asignaciones, el mensaje esta completamente
        // inicializado y puede ser usado en el sistema
    }

    // ============================================================
    // SECCION 3: METODOS GETTER (PARA LEER LOS ATRIBUTOS)
    // ============================================================

    /**
     * METODO GETTER: getId()
     * =======================
     *
     * Devuelve el ID del mensaje.
     *
     * EJEMPLO DE USO:
     * ---------------
     * Mensaje m = new Mensaje(...);
     * int idDelMensaje = m.getId();  // Obtiene el ID
     * System.out.println(idDelMensaje);  // Imprime el ID
     *
     * @return El identificador unico del mensaje
     */
    public int getId() {
        return id;
    }

    /**
     * METODO GETTER: getChat()
     * =========================
     *
     * Devuelve el CHAT al que pertenece este mensaje.
     *
     * QUE DEVUELVE?
     * -------------
     * Devuelve una REFERENCIA al objeto Chat.
     * No es una copia, es el objeto original.
     *
     * EJEMPLO DE USO:
     * ---------------
     * Mensaje m = new Mensaje(...);
     * Chat chatDelMensaje = m.getChat();
     * System.out.println(chatDelMensaje.getTitulo());
     * // Imprime el titulo del chat donde esta el mensaje
     *
     * @return El objeto Chat donde se envio el mensaje
     */
    public Chat getChat() {
        return chat;
    }

    /**
     * METODO GETTER: getFecha()
     * ==========================
     *
     * Devuelve la fecha y hora del mensaje como String.
     *
     * FORMATO: "hh:mm dd/MM/yyyy"
     *
     * EJEMPLO DE USO:
     * ---------------
     * Mensaje m = new Mensaje(...);
     * String cuandoSeEnvio = m.getFecha();
     * System.out.println(cuandoSeEnvio);
     * // Imprime algo como: "14:30 15/10/2023"
     *
     * @return La fecha y hora en formato String "hh:mm dd/MM/yyyy"
     */
    public String getFecha() {
        return fecha;
    }

    /**
     * METODO GETTER: getRemitente()
     * ==============================
     *
     * Devuelve el USUARIO que envio este mensaje.
     *
     * QUE DEVUELVE?
     * -------------
     * Devuelve una REFERENCIA al objeto Usuario.
     *
     * EJEMPLO DE USO:
     * ---------------
     * Mensaje m = new Mensaje(...);
     * Usuario quienEnvio = m.getRemitente();
     * System.out.println(quienEnvio.getNombreUsuario());
     * // Imprime el nombre del usuario que envio el mensaje
     *
     * CASO DE USO REAL:
     * -----------------
     * Este metodo es util cuando quieres saber quien escribio
     * cada mensaje en un chat. Por ejemplo, al mostrar el historial
     * de mensajes.
     *
     * @return El objeto Usuario que envio el mensaje
     */
    public Usuario getRemitente() {
        return remitente;
    }

    /**
     * METODO GETTER: getContenido()
     * ==============================
     *
     * Devuelve el TEXTO del mensaje.
     *
     * EJEMPLO DE USO:
     * ---------------
     * Mensaje m = new Mensaje(...);
     * String texto = m.getContenido();
     * System.out.println(texto);
     * // Imprime: "Hola, como estas?" (o lo que diga el mensaje)
     *
     * @return El texto del mensaje
     */
    public String getContenido() {
        return contenido;
    }

    // ============================================================
    // SECCION 4: METODO toString (REPRESENTACION COMO TEXTO)
    // ============================================================

    /**
     * METODO: toString()
     * ===================
     *
     * Convierte el mensaje a un formato de texto bonito y legible,
     * como si fuera un mensaje en una app de chat real.
     *
     * FORMATO DE SALIDA:
     * ------------------
     * "[fecha] nombreUsuario: contenido"
     *
     * EJEMPLO:
     * --------
     * Si un mensaje tiene:
     * - fecha: "14:30 15/10/2023"
     * - remitente: Usuario con nombre "Juan"
     * - contenido: "Hola, como estas?"
     *
     * Este metodo devuelve:
     * "[14:30 15/10/2023] Juan: Hola, como estas?"
     *
     * COMO SE CONSTRUYE?
     * ------------------
     * Se concatenan (unen) varias partes:
     *
     * "[" + fecha + "] " + remitente.getNombreUsuario() + ": " + contenido
     *  ↑      ↑      ↑              ↑                      ↑        ↑
     *  "["   fecha  "] "       nombre del usuario        ": "   el texto
     *
     * DESGLOSE PASO A PASO:
     * ---------------------
     * 1. "[" → abre corchete
     * 2. fecha → "14:30 15/10/2023"
     * 3. "] " → cierra corchete + espacio
     * 4. remitente.getNombreUsuario() → llama al metodo del Usuario
     *                                    para obtener su nombre
     * 5. ": " → dos puntos + espacio
     * 6. contenido → el texto del mensaje
     *
     * POR QUE LLAMAMOS remitente.getNombreUsuario()?
     * -----------------------------------------------
     * Porque "remitente" es un objeto Usuario completo, no solo
     * el nombre. El objeto Usuario tiene id, nombre y email.
     * Nosotros solo queremos el nombre, entonces llamamos al
     * metodo getNombreUsuario() para obtenerlo.
     *
     * POR QUE @Override?
     * ------------------
     * Porque estamos sobrescribiendo el metodo toString() de
     * la clase Object (la clase padre de todas las clases en Java).
     *
     * @return Un String con el formato: "[fecha] nombreUsuario: contenido"
     */
    @Override
    public String toString() {
        // Construir el String concatenando todas las partes
        // NOTA: Esto se hace en una sola linea, pero mentalmente
        // puedes verlo como:
        // String resultado = "[";
        // resultado = resultado + fecha;
        // resultado = resultado + "] ";
        // resultado = resultado + remitente.getNombreUsuario();
        // resultado = resultado + ": ";
        // resultado = resultado + contenido;
        // return resultado;
        return "[" + fecha + "] " + remitente.getNombreUsuario() + ": " + contenido;
    }
}

// ============================================================
// RESUMEN DE LA CLASE Mensaje
// ============================================================
//
// PROPOSITO:
// Representar un mensaje enviado en un chat, con toda su
// informacion: quien lo envio, cuando, donde y que dice.
//
// ATRIBUTOS (5):
// 1. id - Identificador unico
// 2. chat - En que chat se envio
// 3. fecha - Cuando se envio
// 4. remitente - Quien lo envio
// 5. contenido - Que dice el mensaje
//
// METODOS:
// - Constructor: Para crear nuevos mensajes
// - 5 Getters: Para leer cada atributo
// - toString: Para mostrar el mensaje formateado
//
// CARACTERISTICAS:
// - Es INMUTABLE (todos los atributos son final)
// - Una vez creado un mensaje, no se puede modificar
// - Esto tiene sentido: un mensaje enviado no se edita
//   (al menos en este sistema simple)
//
// RELACIONES CON OTRAS CLASES:
// - Cada Mensaje pertenece a un CHAT
// - Cada Mensaje fue enviado por un USUARIO
// - El Chat almacena una lista de Mensajes
//
// ============================================================
