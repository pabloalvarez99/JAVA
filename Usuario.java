/**
 * =================================================================
 * CLASE: Usuario
 * =================================================================
 *
 * QUE ES ESTA CLASE?
 * ------------------
 * Esta clase representa a una PERSONA que usa el sistema de chat.
 *
 * ANALOGIA: Piensa en esto como una ficha de perfil de usuario,
 * como cuando te registras en WhatsApp o Instagram. Esa ficha
 * contiene tu informacion basica: ID, nombre de usuario y email.
 *
 * POR QUE EXISTE ESTA CLASE?
 * ---------------------------
 * En programacion orientada a objetos, creamos clases para
 * representar "cosas" del mundo real. En este caso, la "cosa"
 * es un usuario del sistema de chat.
 *
 * QUE CONTIENE?
 * -------------
 * 1. ATRIBUTOS (caracteristicas): id, nombreUsuario, email
 * 2. CONSTRUCTOR (como crear un usuario nuevo)
 * 3. METODOS GETTER (como leer la informacion del usuario)
 * 4. METODO toString (como mostrar el usuario como texto)
 *
 * =================================================================
 */
class Usuario {

    // ============================================================
    // SECCION 1: ATRIBUTOS (LAS CARACTERISTICAS DEL USUARIO)
    // ============================================================

    /**
     * ATRIBUTO: id
     * -------------
     * Este es el IDENTIFICADOR UNICO del usuario.
     *
     * ANALOGIA: Es como tu numero de cedula o pasaporte.
     * Cada persona tiene un numero unico que la identifica.
     *
     * POR QUE ES "private"?
     * ---------------------
     * private significa que NADIE desde fuera de esta clase puede
     * ver o modificar directamente este valor. Solo se puede acceder
     * mediante los metodos que nosotros definamos (como getId()).
     *
     * POR QUE ES "final"?
     * -------------------
     * final significa que una vez asignado, NUNCA cambiara.
     * Tu ID de usuario no debe cambiar nunca, por eso es final.
     * Es como un marcador permanente vs un lapiz.
     */
    private final int id;

    /**
     * ATRIBUTO: nombreUsuario
     * ------------------------
     * Este es el nombre de usuario o "nickname".
     *
     * EJEMPLO: "JuanP", "Maria123", "Pedro_Dev"
     *
     * TIPO DE DATO: String
     * --------------------
     * String es el tipo de dato en Java para texto (cadenas de caracteres).
     * Siempre se escribe con mayuscula inicial: String (no string).
     *
     * POR QUE "private final"?
     * ------------------------
     * - private: Solo esta clase puede verlo directamente
     * - final: No puede cambiar despues de ser asignado
     */
    private final String nombreUsuario;

    /**
     * ATRIBUTO: email
     * ----------------
     * Este es el correo electronico del usuario.
     *
     * EJEMPLO: "juan@mail.com", "maria@gmail.com"
     *
     * POR QUE ES "private final"?
     * ---------------------------
     * Igual que los atributos anteriores, protegemos el email
     * y no permitimos que cambie una vez asignado.
     */
    private final String email;

    // ============================================================
    // SECCION 2: CONSTRUCTOR
    // ============================================================

    /**
     * CONSTRUCTOR DE LA CLASE Usuario
     * ================================
     *
     * QUE ES UN CONSTRUCTOR?
     * ----------------------
     * Es un metodo especial que se ejecuta cuando creas un nuevo
     * objeto de esta clase. Su trabajo es INICIALIZAR el objeto,
     * es decir, darle valores iniciales a sus atributos.
     *
     * COMO SE RECONOCE UN CONSTRUCTOR?
     * ---------------------------------
     * 1. Tiene el MISMO NOMBRE que la clase (Usuario)
     * 2. NO tiene tipo de retorno (ni void, ni int, ni nada)
     *
     * COMO SE USA?
     * ------------
     * Cuando quieres crear un usuario nuevo, escribes:
     *
     *     Usuario juan = new Usuario(1, "JuanP", "juan@mail.com");
     *
     * Lo que sucede es:
     * 1. Java crea un espacio en memoria para el nuevo Usuario
     * 2. Llama a este constructor
     * 3. El constructor asigna los valores a los atributos
     * 4. Devuelve el objeto Usuario listo para usar
     *
     * PARAMETROS DEL CONSTRUCTOR:
     * ---------------------------
     * @param id - El numero identificador unico del usuario
     * @param nombreUsuario - El nombre de usuario (nickname)
     * @param email - El correo electronico del usuario
     *
     * NOTA SOBRE LOS NOMBRES:
     * -----------------------
     * Los parametros tienen el mismo nombre que los atributos.
     * Para diferenciarlos, usamos "this.":
     * - this.id = el atributo de la clase
     * - id = el parametro recibido
     */
    public Usuario(int id, String nombreUsuario, String email) {
        // Asignar el parametro "id" al atributo "this.id"
        // "this" se refiere al objeto actual que estamos creando
        this.id = id;

        // Asignar el parametro "nombreUsuario" al atributo "this.nombreUsuario"
        this.nombreUsuario = nombreUsuario;

        // Asignar el parametro "email" al atributo "this.email"
        this.email = email;

        // Despues de estas 3 lineas, el objeto Usuario esta completamente
        // inicializado y listo para ser usado
    }

    // ============================================================
    // SECCION 3: METODOS GETTER (PARA LEER LOS ATRIBUTOS)
    // ============================================================

    /**
     * METODO GETTER: getId()
     * ======================
     *
     * QUE ES UN GETTER?
     * -----------------
     * Un getter es un metodo que DEVUELVE el valor de un atributo private.
     *
     * POR QUE NECESITAMOS GETTERS?
     * ----------------------------
     * Como los atributos son private, no podemos acceder a ellos
     * directamente desde fuera de la clase. Los getters nos permiten
     * LEER esos valores de forma controlada.
     *
     * COMO SE USA?
     * ------------
     * Usuario juan = new Usuario(1, "JuanP", "juan@mail.com");
     * int idDeJuan = juan.getId();  // Devuelve 1
     * System.out.println(idDeJuan);  // Imprime: 1
     *
     * ESTRUCTURA DE UN GETTER:
     * ------------------------
     * - public: Puede ser llamado desde cualquier parte del programa
     * - int: Es el tipo de dato que devuelve (debe coincidir con el atributo)
     * - getId(): El nombre siempre es get + NombreAtributo (con mayuscula)
     * - return id: Devuelve el valor del atributo
     *
     * @return El identificador unico del usuario
     */
    public int getId() {
        return id;
    }

    /**
     * METODO GETTER: getNombreUsuario()
     * ==================================
     *
     * Devuelve el nombre de usuario (nickname).
     *
     * EJEMPLO DE USO:
     * ---------------
     * Usuario juan = new Usuario(1, "JuanP", "juan@mail.com");
     * String nombre = juan.getNombreUsuario();  // Devuelve "JuanP"
     * System.out.println(nombre);  // Imprime: JuanP
     *
     * @return El nombre de usuario (nickname)
     */
    public String getNombreUsuario() {
        return nombreUsuario;
    }

    /**
     * METODO GETTER: getEmail()
     * ==========================
     *
     * Devuelve el correo electronico del usuario.
     *
     * EJEMPLO DE USO:
     * ---------------
     * Usuario juan = new Usuario(1, "JuanP", "juan@mail.com");
     * String correo = juan.getEmail();  // Devuelve "juan@mail.com"
     * System.out.println(correo);  // Imprime: juan@mail.com
     *
     * @return El correo electronico del usuario
     */
    public String getEmail() {
        return email;
    }

    // ============================================================
    // SECCION 4: METODO toString (REPRESENTACION COMO TEXTO)
    // ============================================================

    /**
     * METODO: toString()
     * ==================
     *
     * QUE HACE ESTE METODO?
     * ---------------------
     * Convierte el objeto Usuario a una representacion en texto (String).
     *
     * POR QUE ES IMPORTANTE?
     * ----------------------
     * Cuando quieres mostrar un objeto con System.out.println(),
     * Java automaticamente llama al metodo toString() de ese objeto.
     *
     * SIN toString(): Si haces System.out.println(usuario), se imprime
     * algo feo como "Usuario@15db9742" (nombre de clase + codigo raro)
     *
     * CON toString(): Si haces System.out.println(usuario), se imprime
     * algo util como "1 - JuanP (juan@mail.com)"
     *
     * QUE SIGNIFICA "@Override"?
     * --------------------------
     * @Override es una ANOTACION que le dice al compilador:
     * "Este metodo esta sobrescribiendo un metodo de la clase padre (Object)"
     *
     * Todas las clases en Java heredan de una clase llamada Object,
     * y Object tiene un metodo toString() que nosotros estamos
     * reemplazando con nuestra propia version.
     *
     * BENEFICIOS de @Override:
     * 1. Si escribes mal el nombre del metodo, el compilador te avisa
     * 2. Hace el codigo mas claro (sabes que estas sobrescribiendo)
     *
     * FORMATO DEL STRING QUE SE DEVUELVE:
     * -----------------------------------
     * "id - nombreUsuario (email)"
     *
     * EJEMPLO:
     * --------
     * Si un usuario tiene id=1, nombreUsuario="JuanP", email="juan@mail.com"
     * Este metodo devuelve: "1 - JuanP (juan@mail.com)"
     *
     * COMO SE CONSTRUYE EL STRING?
     * ----------------------------
     * En Java puedes unir (concatenar) strings con el operador +
     *
     * id + " - " + nombreUsuario + " (" + email + ")"
     *  ↑      ↑          ↑           ↑       ↑      ↑
     *  1    " - "     "JuanP"      " ("  "juan@..." ")"
     *
     * Resultado: "1 - JuanP (juan@mail.com)"
     *
     * @return Un String con formato: "id - nombreUsuario (email)"
     */
    @Override
    public String toString() {
        // Concatenar (unir) todos los componentes en un solo String
        return id + " - " + nombreUsuario + " (" + email + ")";
    }
}

// ============================================================
// RESUMEN DE LA CLASE Usuario
// ============================================================
//
// ESTA CLASE ES COMO UN MOLDE para crear usuarios.
//
// TIENE:
// - 3 atributos (id, nombreUsuario, email)
// - 1 constructor (para crear nuevos usuarios)
// - 3 getters (para leer los atributos)
// - 1 toString (para mostrar el usuario como texto)
//
// NO TIENE:
// - Setters (metodos para modificar atributos)
// - Porque es INMUTABLE (no se puede modificar despues de creado)
//
// ESTA CLASE ES SIMPLE pero FUNDAMENTAL para el sistema.
// Sin ella, no podriamos representar a los usuarios del chat.
//
// ============================================================
