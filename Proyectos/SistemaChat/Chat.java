// ============================================================
// IMPORTS: Bibliotecas que necesitamos usar
// ============================================================

// ArrayList: Una lista que puede crecer y encogerse dinamicamente
// List: La interfaz (contrato) que define como funciona una lista
import java.util.ArrayList;
import java.util.List;

/**
 * =================================================================
 * CLASE: Chat
 * =================================================================
 *
 * QUE ES ESTA CLASE?
 * ------------------
 * Esta clase representa una CONVERSACION o GRUPO de chat.
 *
 * ANALOGIA: Piensa en un grupo de WhatsApp o Telegram.
 * Ese grupo tiene:
 * - Un nombre/titulo (ej: "Familia", "Amigos", "Trabajo")
 * - Varios participantes (las personas que estan en el grupo)
 * - Muchos mensajes (todo lo que se ha escrito en el grupo)
 *
 * POR QUE EXISTE ESTA CLASE?
 * ---------------------------
 * Para representar los chats/conversaciones del sistema.
 * Es la clase mas compleja de las 4, porque:
 * 1. Almacena colecciones (listas) de Usuarios y Mensajes
 * 2. Tiene logica de negocio (agregar participantes, ordenar mensajes)
 * 3. Tiene validaciones para mantener la integridad de los datos
 *
 * QUE CONTIENE?
 * -------------
 * 1. ATRIBUTOS: id, titulo, lista de participantes, lista de mensajes
 * 2. CONSTRUCTOR: para crear nuevos chats
 * 3. GETTERS/SETTERS: para leer y modificar datos
 * 4. METODOS DE NEGOCIO: addParticipante, agregarMensaje, etc.
 * 5. ALGORITMOS: ordenamiento de mensajes por fecha
 *
 * =================================================================
 */
class Chat {

    // ============================================================
    // SECCION 1: ATRIBUTOS (LAS CARACTERISTICAS DEL CHAT)
    // ============================================================

    /**
     * ATRIBUTO: id
     * -------------
     * Identificador UNICO del chat.
     *
     * ANALOGIA: Como el numero de grupo en WhatsApp (que no ves,
     * pero existe internamente).
     *
     * MODIFICADORES:
     * - private: Solo esta clase puede verlo
     * - final: No puede cambiar (un chat siempre tiene el mismo ID)
     *
     * TIPO: int (numero entero)
     */
    private final int id;

    /**
     * ATRIBUTO: titulo
     * -----------------
     * El NOMBRE del chat.
     *
     * EJEMPLO: "Amigos", "Familia", "Proyecto Java", "Equipo Futbol"
     *
     * MODIFICADORES:
     * - private: Solo esta clase puede verlo directamente
     * - NO es final: Puede cambiar (puedes renombrar un chat)
     *
     * TIPO: String (texto)
     *
     * DIFERENCIA CON Usuario y Mensaje:
     * En Usuario y Mensaje, todo es "final" (inmutable).
     * Aqui el titulo NO es final porque queremos poder cambiarlo
     * despues de creado el chat (por eso tenemos un setter).
     */
    private String titulo;

    /**
     * ATRIBUTO: participantes
     * ------------------------
     * Lista de USUARIOS que pertenecen a este chat.
     *
     * TIPO: List<Usuario>
     * ---------------------
     * - List: Es una interfaz (como un contrato) que define operaciones
     *   de lista (add, remove, get, size, etc.)
     * - <Usuario>: Los elementos de la lista son objetos Usuario
     *   Esto se llama "Generics" (tipos genericos)
     *
     * QUE ES UN GENERIC?
     * ------------------
     * List<Usuario> significa: "Una lista que SOLO puede contener Usuarios"
     * No puedes agregar un String o un int a esta lista, solo Usuarios.
     *
     * POR QUE SE INICIALIZA AQUI?
     * ---------------------------
     * = new ArrayList<>();
     *
     * La inicializamos aqui (al declarar el atributo) para evitar
     * errores de NullPointerException.
     *
     * QUE ES NullPointerException?
     * Si no inicializamos, participantes seria null.
     * Si intentamos hacer participantes.add(...) cuando es null,
     * el programa CRASHEA con NullPointerException.
     *
     * Al inicializar con new ArrayList<>(), creamos una lista VACIA
     * pero NO null. Ahora podemos agregar elementos sin problemas.
     *
     * NOTA: <> se llama "diamond operator" (operador diamante)
     * Java infiere el tipo automaticamente del lado izquierdo.
     */
    private List<Usuario> participantes = new ArrayList<>();

    /**
     * ATRIBUTO: mensajes
     * -------------------
     * Lista de MENSAJES enviados en este chat.
     *
     * TIPO: List<Mensaje>
     * Una lista que solo puede contener objetos Mensaje.
     *
     * IGUAL QUE PARTICIPANTES:
     * La inicializamos con new ArrayList<>() para evitar null.
     * Empieza vacia y se van agregando mensajes con agregarMensaje().
     *
     * POR QUE USAMOS ARRAYLIST?
     * -------------------------
     * ArrayList es perfecto para esto porque:
     * 1. No sabemos cuantos mensajes habra (pueden ser 0, 10, 1000...)
     * 2. Necesitamos agregar mensajes dinamicamente
     * 3. Es eficiente para acceder a mensajes por indice
     * 4. Mantiene el orden de insercion
     */
    private List<Mensaje> mensajes = new ArrayList<>();

    // ============================================================
    // SECCION 2: CONSTRUCTOR
    // ============================================================

    /**
     * CONSTRUCTOR DE LA CLASE Chat
     * =============================
     *
     * Crea un nuevo chat con ID y titulo.
     *
     * NOTA IMPORTANTE:
     * ----------------
     * El constructor NO recibe participantes ni mensajes.
     * Por que? Porque un chat nuevo:
     * 1. Empieza sin participantes (se agregan despues con addParticipante)
     * 2. Empieza sin mensajes (se agregan despues con agregarMensaje)
     *
     * Las listas ya estan inicializadas (vacias) por las declaraciones
     * de los atributos arriba.
     *
     * EJEMPLO DE USO:
     * ---------------
     * Chat chatAmigos = new Chat(1, "Amigos");
     * // Ahora chatAmigos existe, tiene ID 1, titulo "Amigos"
     * // y listas vacias de participantes y mensajes
     *
     * PARAMETROS:
     * -----------
     * @param id - El identificador unico del chat
     * @param titulo - El nombre/titulo del chat
     */
    public Chat(int id, String titulo) {
        // Asignar el ID recibido al atributo id
        this.id = id;

        // Asignar el titulo recibido al atributo titulo
        this.titulo = titulo;

        // NO necesitamos inicializar participantes y mensajes aqui
        // porque ya los inicializamos al declarar los atributos
        // (= new ArrayList<>())
    }

    // ============================================================
    // SECCION 3: GETTERS Y SETTERS
    // ============================================================

    /**
     * METODO GETTER: getId()
     * =======================
     *
     * Devuelve el ID del chat.
     *
     * @return El identificador unico del chat
     */
    public int getId() {
        return id;
    }

    /**
     * METODO GETTER: getTitulo()
     * ===========================
     *
     * Devuelve el titulo (nombre) del chat.
     *
     * EJEMPLO DE USO:
     * ---------------
     * Chat c = new Chat(1, "Amigos");
     * String nombre = c.getTitulo();  // Devuelve "Amigos"
     *
     * @return El titulo o nombre del chat
     */
    public String getTitulo() {
        return titulo;
    }

    /**
     * METODO SETTER: setTitulo(String t)
     * ===================================
     *
     * MODIFICA el titulo del chat.
     *
     * QUE ES UN SETTER?
     * -----------------
     * Un setter es un metodo que CAMBIA el valor de un atributo.
     *
     * POR QUE ESTA CLASE TIENE SETTER PERO Usuario NO?
     * -------------------------------------------------
     * Porque Usuario es INMUTABLE (no se modifica despues de creado).
     * Chat NO es completamente inmutable: podemos cambiar el titulo
     * y agregar participantes/mensajes.
     *
     * EJEMPLO DE USO:
     * ---------------
     * Chat c = new Chat(1, "Amigos");
     * c.setTitulo("Mejores Amigos");  // Cambia el titulo
     *
     * @param t - El nuevo titulo del chat
     */
    public void setTitulo(String t) {
        // Asignar el nuevo titulo al atributo titulo
        this.titulo = t;
    }

    /**
     * METODO GETTER: getParticipantes()
     * ==================================
     *
     * Devuelve un ARRAY con todos los participantes del chat.
     *
     * PUNTO IMPORTANTE - POR QUE DEVOLVEMOS ARRAY Y NO LA LISTA?
     * -----------------------------------------------------------
     * Internamente usamos una List<Usuario>, pero este metodo
     * devuelve un Usuario[].
     *
     * POR QUE?
     * --------
     * ENCAPSULAMIENTO y PROTECCION.
     *
     * Si devolvieramos la lista directamente:
     *   public List<Usuario> getParticipantes() { return participantes; }
     *
     * Alguien podria hacer:
     *   chat.getParticipantes().add(usuarioMalo);
     *
     * Y estaria modificando la lista interna del chat SIN VALIDACIONES!
     * Esto romperia la integridad del sistema.
     *
     * Al devolver un ARRAY (una copia), protegemos la lista original.
     * Si modificas el array, no afectas la lista interna del chat.
     *
     * COMO SE CONVIERTE List A ARRAY?
     * --------------------------------
     * participantes.toArray(new Usuario[0])
     *
     * - toArray(): metodo de List que convierte a array
     * - new Usuario[0]: especifica el tipo de array (array de Usuario)
     * - El [0] significa: "Java, tu decide el tamaño correcto"
     *
     * @return Un array de Usuario con todos los participantes
     */
    public Usuario[] getParticipantes() {
        // Convertir la lista interna a un array nuevo
        // Esto crea una COPIA, protegiendo la lista original
        return participantes.toArray(new Usuario[0]);
    }

    /**
     * METODO GETTER: getMensajes()
     * =============================
     *
     * Devuelve un ARRAY con todos los mensajes del chat.
     *
     * MISMA LOGICA QUE getParticipantes():
     * Devolvemos un array (copia) en vez de la lista original
     * para proteger el encapsulamiento.
     *
     * @return Un array de Mensaje con todos los mensajes
     */
    public Mensaje[] getMensajes() {
        // Convertir la lista interna a un array nuevo
        return mensajes.toArray(new Mensaje[0]);
    }

    // ============================================================
    // SECCION 4: METODOS DE NEGOCIO (LOGICA DEL CHAT)
    // ============================================================

    /**
     * METODO: addParticipante(Usuario u)
     * ===================================
     *
     * Agrega un usuario como participante del chat.
     *
     * IMPORTANTE: TIENE VALIDACIONES
     * -------------------------------
     * No simplemente agrega el usuario a la lista.
     * Primero verifica que:
     * 1. El usuario no sea null (para evitar NullPointerException)
     * 2. El usuario no este ya en el chat (para evitar duplicados)
     *
     * POR QUE VALIDAR?
     * ----------------
     * Para mantener la INTEGRIDAD de los datos.
     * No queremos:
     * - Usuarios null en la lista (causaria errores)
     * - Usuarios duplicados (no tiene sentido que estes 2 veces en un grupo)
     *
     * EJEMPLO DE USO:
     * ---------------
     * Chat chat = new Chat(1, "Amigos");
     * Usuario juan = new Usuario(1, "Juan", "juan@mail.com");
     * chat.addParticipante(juan);  // Agrega a Juan al chat
     * chat.addParticipante(juan);  // No hace nada (ya esta agregado)
     * chat.addParticipante(null);  // No hace nada (null no es valido)
     *
     * @param u - El usuario a agregar al chat
     */
    public void addParticipante(Usuario u) {
        // VALIDACION 1: Verificar que el usuario no sea null
        // Si es null, salir del metodo (no hacer nada)
        // "return" sin valor = salir del metodo inmediatamente
        if (u == null) return;

        // VALIDACION 2: Verificar que el usuario NO este ya en el chat
        // Usamos el metodo contieneUsuario() para verificar
        // Si ya esta, salir del metodo (no agregar duplicados)
        if (contieneUsuario(u.getId())) return;

        // Si pasa ambas validaciones, agregar el usuario a la lista
        // add() es un metodo de ArrayList que agrega al final de la lista
        participantes.add(u);
    }

    /**
     * METODO: contieneUsuario(int usuarioId)
     * =======================================
     *
     * Verifica si un usuario (identificado por su ID) es participante del chat.
     *
     * COMO FUNCIONA?
     * --------------
     * Recorre la lista de participantes buscando un usuario con el ID dado.
     *
     * RETORNA:
     * --------
     * - true si el usuario esta en el chat
     * - false si el usuario NO esta en el chat
     *
     * ALGORITMO:
     * ----------
     * 1. Recorrer cada participante de la lista
     * 2. Si alguno tiene el ID buscado, retornar true
     * 3. Si termina el recorrido sin encontrarlo, retornar false
     *
     * EJEMPLO DE USO:
     * ---------------
     * if (chat.contieneUsuario(1)) {
     *     System.out.println("El usuario 1 esta en el chat");
     * } else {
     *     System.out.println("El usuario 1 NO esta en el chat");
     * }
     *
     * @param usuarioId - El ID del usuario a buscar
     * @return true si el usuario esta en el chat, false en caso contrario
     */
    public boolean contieneUsuario(int usuarioId) {
        // BUCLE FOR-EACH (for mejorado)
        // ------------------------------
        // Sintaxis: for (TipoElemento nombreVariable : coleccion)
        //
        // Esto significa: "Para cada Usuario p en la lista participantes"
        //
        // En cada iteracion:
        // - p toma el valor del siguiente elemento de la lista
        // - Se ejecuta el codigo del bloque {}
        //
        // EJEMPLO DE EJECUCION:
        // Si participantes tiene: [usuario1, usuario2, usuario3]
        // 1ra iteracion: p = usuario1
        // 2da iteracion: p = usuario2
        // 3ra iteracion: p = usuario3
        for (Usuario p : participantes)
            // Para cada participante, verificar si su ID coincide con el buscado
            // Si coincide, retornar true inmediatamente (no seguir buscando)
            if (p.getId() == usuarioId) return true;

        // Si el bucle termino sin encontrar el usuario, retornar false
        // (Llegamos aqui solo si ninguna iteracion hizo "return true")
        return false;
    }

    /**
     * METODO: agregarMensaje(Mensaje m)
     * ==================================
     *
     * Agrega un mensaje al chat.
     *
     * VALIDACION:
     * -----------
     * Verifica que el mensaje no sea null antes de agregarlo.
     * Si es null, no hace nada (evita NullPointerException).
     *
     * EJEMPLO DE USO:
     * ---------------
     * Mensaje m = new Mensaje(1, chat, "14:30 15/10/2023", juan, "Hola");
     * chat.agregarMensaje(m);  // Agrega el mensaje al chat
     *
     * @param m - El mensaje a agregar
     */
    public void agregarMensaje(Mensaje m) {
        // VALIDACION: Si el mensaje es null, salir sin hacer nada
        if (m == null) return;

        // Si el mensaje es valido, agregarlo a la lista de mensajes
        mensajes.add(m);
    }

    // ============================================================
    // SECCION 5: ORDENAMIENTO DE MENSAJES
    // ============================================================

    /**
     * METODO: mensajesOrdenadosPorFecha()
     * ====================================
     *
     * Devuelve los mensajes del chat ordenados cronologicamente
     * (del mas antiguo al mas reciente).
     *
     * ALGORITMO USADO: INSERTION SORT
     * --------------------------------
     *
     * QUE ES INSERTION SORT?
     * ----------------------
     * Es un algoritmo de ordenamiento que funciona como cuando
     * ordenas cartas de juego en tu mano:
     *
     * 1. Tomas la primera carta (ya esta "ordenada")
     * 2. Tomas la segunda carta
     * 3. La comparas con la primera y la insertas en su lugar
     * 4. Tomas la tercera carta
     * 5. La comparas con las anteriores (ya ordenadas) y la insertas
     * 6. Repites hasta ordenar todas las cartas
     *
     * EJEMPLO VISUAL:
     * ---------------
     * Queremos ordenar: [5, 2, 4, 1, 3]
     *
     * Inicio: [5, 2, 4, 1, 3]
     *         ↑
     *         Ya ordenado
     *
     * i=1: Tomar 2, insertar antes de 5
     *      [2, 5, 4, 1, 3]
     *       ------
     *       Ordenado
     *
     * i=2: Tomar 4, insertar entre 2 y 5
     *      [2, 4, 5, 1, 3]
     *       ---------
     *       Ordenado
     *
     * i=3: Tomar 1, insertar al principio
     *      [1, 2, 4, 5, 3]
     *       ------------
     *       Ordenado
     *
     * i=4: Tomar 3, insertar entre 2 y 4
     *      [1, 2, 3, 4, 5]
     *       ---------------
     *       TODO ordenado!
     *
     * POR QUE HACEMOS UNA COPIA?
     * --------------------------
     * No queremos modificar el orden original de los mensajes
     * en el chat. Creamos una copia y ordenamos la copia.
     *
     * @return Un array de Mensaje ordenado por fecha
     */
    public Mensaje[] mensajesOrdenadosPorFecha() {
        // PASO 1: Crear una COPIA del array de mensajes
        // -----------------------------------------------
        // toArray() convierte la lista a array
        // Es una copia, no el array original
        Mensaje[] copia = mensajes.toArray(new Mensaje[0]);

        // PASO 2: Ordenar la copia con Insertion Sort
        // --------------------------------------------

        // BUCLE EXTERNO: Recorre desde el segundo elemento hasta el final
        // (El primer elemento ya se considera "ordenado")
        for (int i = 1; i < copia.length; i++) {
            // "key" es el elemento actual que vamos a insertar
            // en su posicion correcta
            Mensaje key = copia[i];

            // j es el indice del elemento inmediatamente anterior
            int j = i - 1;

            // BUCLE INTERNO: Mover elementos mayores hacia la derecha
            // --------------------------------------------------------
            // Mientras:
            // 1. j >= 0 (no nos salimos del array por la izquierda)
            // 2. El mensaje en posicion j es POSTERIOR (mayor) que key
            //
            // Hacemos:
            // - Mover el mensaje en j una posicion a la derecha
            // - Decrementar j (ir hacia la izquierda)
            //
            // QUE HACE compararFecha()?
            // -------------------------
            // Compara dos fechas (como Strings) y retorna:
            // - Numero negativo si fecha1 < fecha2 (fecha1 es mas antigua)
            // - 0 si son iguales
            // - Numero positivo si fecha1 > fecha2 (fecha1 es mas reciente)
            //
            // Entonces "compararFecha(...) > 0" significa:
            // "La fecha de copia[j] es POSTERIOR a la fecha de key"
            while (j >= 0 && compararFecha(copia[j].getFecha(), key.getFecha()) > 0) {
                // Mover el elemento una posicion a la derecha
                copia[j + 1] = copia[j];

                // Ir al elemento anterior
                j--;
            }

            // Insertar "key" en su posicion correcta
            // (j+1 porque el while bajo j una posicion de mas)
            copia[j + 1] = key;
        }

        // PASO 3: Retornar el array ordenado
        return copia;
    }

    /**
     * METODO PRIVADO: compararFecha(String f1, String f2)
     * ====================================================
     *
     * Compara dos fechas representadas como String.
     *
     * POR QUE ES "private static"?
     * ----------------------------
     * - private: Solo esta clase puede usarlo (es un metodo auxiliar interno)
     * - static: No depende de un objeto especifico de Chat
     *           Es una utilidad general para comparar fechas
     *
     * COMO FUNCIONA?
     * --------------
     * No podemos comparar las fechas directamente como Strings porque
     * el formato "hh:mm dd/MM/yyyy" no se ordena correctamente alfabeticamente.
     *
     * EJEMPLO DEL PROBLEMA:
     * "09:00 20/10/2023" vs "18:00 15/10/2023"
     * Alfabeticamente "09" < "18", pero la segunda fecha es MAS ANTIGUA!
     *
     * SOLUCION:
     * Usamos claveFecha() que convierte las fechas a formato "yyyyMMddhhmm"
     * que SI se puede comparar correctamente como String.
     *
     * @param f1 - Primera fecha en formato "hh:mm dd/MM/yyyy"
     * @param f2 - Segunda fecha en formato "hh:mm dd/MM/yyyy"
     * @return Negativo si f1<f2, 0 si iguales, positivo si f1>f2
     */
    private static int compararFecha(String f1, String f2) {
        // Convertir ambas fechas a "claves" comparables
        String k1 = claveFecha(f1);
        String k2 = claveFecha(f2);

        // Comparar las claves lexicograficamente (como Strings)
        // compareTo() es un metodo de String que retorna:
        // - Negativo si k1 < k2
        // - 0 si k1 == k2
        // - Positivo si k1 > k2
        return k1.compareTo(k2);
    }

    /**
     * METODO PRIVADO: claveFecha(String f)
     * =====================================
     *
     * Convierte una fecha del formato "hh:mm dd/MM/yyyy"
     * al formato "yyyyMMddhhmm" para poder compararla.
     *
     * TRANSFORMACION:
     * ---------------
     * Entrada:  "14:30 15/10/2023"
     * Salida:   "202310151430"
     *
     * POR QUE ESTE FORMATO?
     * ---------------------
     * "yyyyMMddhhmm" se puede comparar alfabeticamente porque:
     * - Empieza con el año (lo mas significativo)
     * - Luego mes, dia, hora, minuto (en orden de importancia)
     *
     * EJEMPLO:
     * "202310151430" < "202310201800"
     *  2023 Oct 15    2023 Oct 20
     *  14:30          18:00
     *
     * El 15 de octubre es anterior al 20 de octubre, correcto!
     *
     * COMO FUNCIONA?
     * --------------
     * Usamos substring() para extraer partes especificas del String.
     *
     * STRING DE ENTRADA: "14:30 15/10/2023"
     * Posiciones:         0123456789012345
     *
     * substring(inicio, fin) extrae caracteres desde "inicio"
     * hasta "fin-1" (el fin NO se incluye).
     *
     * @param f - La fecha en formato "hh:mm dd/MM/yyyy"
     * @return String con formato "yyyyMMddhhmm" para comparacion
     */
    private static String claveFecha(String f) {
        try {
            // Bloque try-catch para manejar posibles errores
            // (si la fecha no tiene el formato esperado)

            // EXTRAER LAS PARTES DE LA FECHA
            // -------------------------------

            // Hora: posiciones 0-1 (los primeros 2 caracteres)
            // "14:30 15/10/2023"
            //  ^^
            String hh = f.substring(0, 2);      // "14"

            // Minutos: posiciones 3-4 (despues de los ":")
            // "14:30 15/10/2023"
            //     ^^
            String min = f.substring(3, 5);     // "30"

            // Dia: posiciones 6-7 (despues del espacio)
            // "14:30 15/10/2023"
            //        ^^
            String dd = f.substring(6, 8);      // "15"

            // Mes: posiciones 9-10 (despues del primer "/")
            // "14:30 15/10/2023"
            //           ^^
            String MM = f.substring(9, 11);     // "10"

            // Año: posiciones 12-15 (despues del segundo "/")
            // "14:30 15/10/2023"
            //              ^^^^
            String yyyy = f.substring(12, 16);  // "2023"

            // REORDENAR AL FORMATO yyyyMMddhhmm
            // ----------------------------------
            // Concatenamos en el orden correcto:
            // año + mes + dia + hora + minuto
            //
            // "2023" + "10" + "15" + "14" + "30" = "202310151430"
            return yyyy + MM + dd + hh + min;

        } catch (Exception e) {
            // Si hubo algun error (fecha mal formateada, muy corta, etc.)
            // retornar un valor muy alto
            //
            // POR QUE "999999999999"?
            // Esto hace que fechas invalidas se ordenen al FINAL
            // (porque "999999999999" es mayor que cualquier fecha valida)
            return "999999999999";
        }
    }

    // ============================================================
    // SECCION 6: METODO toString
    // ============================================================

    /**
     * METODO: toString()
     * ===================
     *
     * Convierte el chat a una representacion en texto.
     *
     * FORMATO:
     * --------
     * "id - titulo (participantes: X, mensajes: Y)"
     *
     * EJEMPLO:
     * --------
     * "1 - Amigos (participantes: 5, mensajes: 127)"
     *
     * DESGLOSE:
     * ---------
     * - id: El ID del chat
     * - titulo: El nombre del chat
     * - participantes.size(): Cantidad de participantes
     * - mensajes.size(): Cantidad de mensajes
     *
     * size() es un metodo de ArrayList que retorna cuantos
     * elementos tiene la lista.
     *
     * @return String con formato: "id - titulo (participantes: X, mensajes: Y)"
     */
    @Override
    public String toString() {
        // Concatenar todas las partes del String
        return id + " - " + titulo + " (participantes: " + participantes.size() + ", mensajes: " + mensajes.size() + ")";
    }
}

// ============================================================
// RESUMEN DE LA CLASE Chat
// ============================================================
//
// PROPOSITO:
// Representar una conversacion/grupo de chat con sus participantes
// y mensajes.
//
// ATRIBUTOS:
// - id (final): Identificador unico
// - titulo: Nombre del chat (puede cambiar)
// - participantes: Lista de Usuarios en el chat
// - mensajes: Lista de Mensajes enviados
//
// METODOS PRINCIPALES:
// - addParticipante(): Agregar usuario al chat (con validaciones)
// - contieneUsuario(): Verificar si un usuario esta en el chat
// - agregarMensaje(): Agregar mensaje al chat
// - mensajesOrdenadosPorFecha(): Obtener mensajes ordenados cronologicamente
//
// ALGORITMOS:
// - Insertion Sort: Para ordenar mensajes por fecha
// - Busqueda lineal: Para verificar si un usuario esta en el chat
//
// VALIDACIONES:
// - No agregar usuarios null
// - No agregar usuarios duplicados
// - No agregar mensajes null
//
// CARACTERISTICAS AVANZADAS:
// - Usa Generics: List<Usuario>, List<Mensaje>
// - Encapsulamiento: Devuelve arrays en vez de listas
// - Metodos privados auxiliares: compararFecha, claveFecha
// - Manejo de errores: try-catch en claveFecha
//
// ESTA ES LA CLASE MAS COMPLEJA DEL SISTEMA
// Combina estructuras de datos, algoritmos y logica de negocio.
//
// ============================================================
