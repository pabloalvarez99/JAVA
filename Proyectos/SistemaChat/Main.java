import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * Clase principal del sistema de gestión de chats.
 * Implementa un menú interactivo que permite:
 * - Ver chats y sus mensajes
 * - Consultar estadísticas (top usuarios, top horas)
 * - Editar chats (título y participantes)
 * - Enviar mensajes a múltiples chats
 * Los datos se cargan desde archivos de texto al inicio del programa.
 */
public class Main {

    // Lista estática que almacena todos los usuarios del sistema
    // Se usa static para que sea accesible desde todos los métodos de la clase
    private static List<Usuario> usuarios = new ArrayList<>();

    // Lista estática que almacena todos los chats del sistema
    private static List<Chat> chats = new ArrayList<>();

    // Variable que lleva el control del ID más alto de mensaje (para generar nuevos IDs)
    // Nota: Esto no se consideró en la evaluación original
    private static int maxMensajeId = 0;

    // Constante que define el formato de fecha usado en el sistema
    // Nota: Esto no se consideró en la evaluación original
    private static final String FORMATO = "hh:mm dd/MM/yyyy";

    /**
     * Método principal que inicia la aplicación.
     * Carga los datos desde archivos y muestra el menú interactivo.
     * @param args Argumentos de línea de comandos (no utilizados)
     */
    public static void main(String[] args) {
        // Crear un Scanner para leer la entrada del usuario desde la consola
        Scanner sc = new Scanner(System.in);

        // Bloque try-catch para manejar posibles errores al cargar los archivos
        try {
            // Cargar usuarios desde el archivo users.txt
            cargarUsuarios("users.txt");
            // Cargar chats desde el archivo chats.txt
            cargarChats("chats.txt");
            // Cargar mensajes desde el archivo msj.txt
            cargarMensajes("msj.txt");
        } catch (IOException e) {
            // Si hay error al leer los archivos, mostrar mensaje y terminar el programa
            System.out.println("Error cargando archivos: " + e.getMessage());
            return;
        }

        // Variable para almacenar la opción seleccionada por el usuario
        int opcion;

        // Bucle principal del menú (se repite hasta que el usuario elija salir)
        do {
            // Mostrar el menú de opciones
            System.out.println("\n=== MENU CHAT ===");
            System.out.println("1) Ver Chat");
            System.out.println("2) Top 3 usuarios por mensajes enviados");
            System.out.println("3) Top 3 horas con más mensajes");
            System.out.println("4) Editar chat (cambiar título / agregar usuario)");
            System.out.println("5) Enviar un mensaje a varios chats");
            System.out.println("0) Salir");
            System.out.print("Opción: ");

            // Leer la opción del usuario (con validación de entrada)
            opcion = leerEntero(sc);

            // Switch expression (característica moderna de Java) para ejecutar la acción correspondiente
            switch (opcion) {
                case 1 -> verChat(sc);                    // Ver detalles de un chat
                case 2 -> top3Usuarios();                 // Mostrar top 3 usuarios más activos
                case 3 -> top3Horas();                    // Mostrar top 3 horas con más mensajes
                case 4 -> editarChat(sc);                 // Editar título o agregar participante
                case 5 -> enviarMensajeVariosChats(sc);   // Enviar mensaje a múltiples chats
                case 0 -> System.out.println("Adiós.");   // Salir del programa
                default -> System.out.println("Opción inválida."); // Opción no reconocida
            }
        } while (opcion != 0); // Continuar mientras el usuario no elija salir (0)
    }

    /*
     * =========================
     * SECCIÓN: CARGA DE ARCHIVOS
     * =========================
     * Los siguientes métodos se encargan de leer archivos de texto
     * y cargar los datos en las estructuras de datos del programa.
     */

    /**
     * Método que carga los usuarios desde un archivo de texto.
     * Formato esperado del archivo: id,nombreUsuario,email
     * Ejemplo: 1,Juan,juan@mail.com
     * @param path Ruta del archivo a cargar
     * @throws IOException Si hay error al leer el archivo
     */
    private static void cargarUsuarios(String path) throws IOException {
        // try-with-resources: garantiza que el BufferedReader se cierre automáticamente
        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
            String line;
            // Leer el archivo línea por línea
            while ((line = br.readLine()) != null) {
                // Eliminar espacios en blanco al inicio y final de la línea
                line = line.trim();
                // Si la línea está vacía, saltarla
                if (line.isEmpty())
                    continue;

                // Separar la línea por comas (split con -1 para preservar campos vacíos)
                String[] parts = line.split(",", -1);
                // Si no tiene al menos 3 campos, ignorar esta línea
                if (parts.length < 3)
                    continue;

                // Extraer y limpiar cada campo
                int id = parseIntSeguro(parts[0].trim());      // ID del usuario
                String nombre = parts[1].trim();               // Nombre de usuario
                String email = parts[2].trim();                // Email

                // Crear objeto Usuario y agregarlo a la lista
                usuarios.add(new Usuario(id, nombre, email));
            }
        }
    }

    /**
     * Método que carga los chats desde un archivo de texto.
     * Formato esperado: chatId,titulo,participante1Id,participante2Id,...
     * Ejemplo: 1,Amigos,1,2,3,4
     * @param path Ruta del archivo a cargar
     * @throws IOException Si hay error al leer el archivo
     */
    private static void cargarChats(String path) throws IOException {
        // try-with-resources: garantiza que el BufferedReader se cierre automáticamente
        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
            String line;
            // Leer el archivo línea por línea
            while ((line = br.readLine()) != null) {
                // Eliminar espacios en blanco
                line = line.trim();
                // Saltar líneas vacías
                if (line.isEmpty())
                    continue;

                // Separar por comas
                String[] parts = line.split(",", -1);
                // Validar que tenga al menos 3 campos (id, título, al menos 1 participante)
                if (parts.length < 3)
                    continue;

                // Extraer ID y título del chat
                int chatId = parseIntSeguro(parts[0].trim());
                String titulo = parts[1].trim();
                // Crear el objeto Chat
                Chat c = new Chat(chatId, titulo);

                // Agregar participantes (los IDs están desde la posición 2 en adelante)
                for (int i = 2; i < parts.length; i++) {
                    int uid = parseIntSeguro(parts[i].trim());
                    // Buscar el usuario por ID
                    Usuario u = findUsuarioById(uid);
                    // Si el usuario existe, agregarlo al chat
                    if (u != null)
                        c.addParticipante(u);
                }
                // Agregar el chat a la lista de chats
                chats.add(c);
            }
        }
    }

    /**
     * Método que carga los mensajes desde un archivo de texto.
     * Formato esperado: mensajeId,chatId,fecha,remitenteId,contenido
     * Ejemplo: 1,1,14:30 15/10/2023,1,Hola a todos
     * Nota: El contenido puede contener comas, por eso se maneja desde posición 4 en adelante
     * @param path Ruta del archivo a cargar
     * @throws IOException Si hay error al leer el archivo
     */
    private static void cargarMensajes(String path) throws IOException {
        // try-with-resources: garantiza que el BufferedReader se cierre automáticamente
        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
            String line;
            // Leer el archivo línea por línea
            while ((line = br.readLine()) != null) {
                // Eliminar espacios en blanco
                line = line.trim();
                // Saltar líneas vacías
                if (line.isEmpty())
                    continue;

                // Separar por comas
                String[] parts = line.split(",", -1);
                // Validar que tenga al menos 5 campos
                if (parts.length < 5)
                    continue;

                // Extraer los campos del mensaje
                int mid = parseIntSeguro(parts[0].trim());          // ID del mensaje
                int chatId = parseIntSeguro(parts[1].trim());       // ID del chat
                String fechaStr = parts[2].trim();                  // Fecha en formato "hh:mm dd/MM/yyyy"
                int remitenteId = parseIntSeguro(parts[3].trim());  // ID del remitente

                // Unir todas las partes desde la posición 4 en adelante (el contenido puede tener comas)
                String contenido = String.join(",", Arrays.copyOfRange(parts, 4, parts.length)).trim();

                // Buscar el chat y el usuario remitente
                Chat chat = findChatById(chatId);
                Usuario remitente = findUsuarioById(remitenteId);

                // Si no existen el chat o el remitente, ignorar este mensaje
                if (chat == null || remitente == null)
                    continue;

                // Crear el objeto Mensaje
                Mensaje m = new Mensaje(mid, chat, fechaStr, remitente, contenido);
                // Agregar el mensaje al chat correspondiente
                chat.agregarMensaje(m);

                // Actualizar el ID máximo de mensaje (para generar nuevos IDs)
                if (mid > maxMensajeId)
                    maxMensajeId = mid;
            }
        }
    }

    /*
     * =========================
     * SECCIÓN: OPCIONES DE MENÚ
     * =========================
     * Los siguientes métodos implementan cada una de las funcionalidades
     * del menú principal del sistema.
     */

    /**
     * Opción 1 del menú: Ver Chat
     * Muestra todos los chats disponibles y permite al usuario seleccionar uno
     * para ver sus detalles (participantes y mensajes ordenados por fecha).
     * @param sc Scanner para leer la entrada del usuario
     */
    private static void verChat(Scanner sc) {
        // Validar que existan chats en el sistema
        if (chats.isEmpty()) {
            System.out.println("No hay chats.");
            return;
        }

        // Mostrar lista de todos los chats
        System.out.println("\n== CHATS ==");
        for (Chat c : chats)
            System.out.println(c);

        // Solicitar al usuario el ID del chat a visualizar
        System.out.print("Ingrese ID del chat a ver: ");
        int id = leerEntero(sc);

        // Buscar el chat por ID
        Chat c = findChatById(id);
        if (c == null) {
            System.out.println("Chat no encontrado.");
            return;
        }

        // Mostrar información del chat
        System.out.println("\nTítulo: " + c.getTitulo());

        // Mostrar lista de participantes
        System.out.println("Participantes:");
        for (Usuario u : c.getParticipantes())
            System.out.println("  - " + u);

        // Mostrar mensajes ordenados cronológicamente
        System.out.println("Mensajes (ordenados por fecha):");
        Mensaje[] ordenados = c.mensajesOrdenadosPorFecha();
        if (ordenados.length == 0) {
            System.out.println("  (sin mensajes)");
        } else {
            for (Mensaje m : ordenados)
                System.out.println("  " + m);
        }
    }

    /**
     * Opción 2 del menú: Top 3 usuarios por mensajes enviados
     * Cuenta cuántos mensajes ha enviado cada usuario en todos los chats
     * y muestra los 3 usuarios más activos ordenados de mayor a menor.
     * Utiliza Selection Sort para ordenar.
     */
    private static void top3Usuarios() {
        // Validar que existan usuarios
        if (usuarios.isEmpty()) {
            System.out.println("No hay usuarios.");
            return;
        }

        int n = usuarios.size();
        // Array paralelo a la lista de usuarios para contar mensajes
        // Ejemplo: conteo[0] tiene los mensajes del usuarios.get(0)
        int[] conteo = new int[n];

        // Recorrer todos los chats y todos los mensajes para contar
        for (Chat ch : chats) {
            for (Mensaje m : ch.getMensajes()) {
                int uid = m.getRemitente().getId();
                // Encontrar el índice del usuario en la lista
                int idx = indexUsuarioById(uid);
                // Si el usuario existe, incrementar su contador
                if (idx >= 0)
                    conteo[idx]++;
            }
        }

        // Crear un array de índices para ordenar sin modificar las listas originales
        int[] idxs = new int[n];
        for (int i = 0; i < n; i++)
            idxs[i] = i;

        // Algoritmo Selection Sort (ordenamiento por selección)
        // Ordena los índices según el conteo de mensajes (de mayor a menor)
        for (int i = 0; i < n - 1; i++) {
            // Buscar la posición del máximo en la porción no ordenada
            int maxPos = i;
            for (int j = i + 1; j < n; j++) {
                if (conteo[idxs[j]] > conteo[idxs[maxPos]])
                    maxPos = j;
            }
            // Intercambiar el máximo con la posición actual
            int tmp = idxs[i];
            idxs[i] = idxs[maxPos];
            idxs[maxPos] = tmp;
        }

        // Mostrar el top 3 (o menos si hay menos de 3 usuarios)
        System.out.println("\nTop 3 usuarios con más mensajes:");
        int limite = Math.min(3, n);
        for (int k = 0; k < limite; k++) {
            int i = idxs[k]; // Obtener el índice del k-ésimo usuario con más mensajes
            System.out.printf("%d) %s -> %d mensajes%n", k + 1, usuarios.get(i).getNombreUsuario(), conteo[i]);
        }
    }

    /**
     * Opción 3 del menú: Top 3 horas con más mensajes
     * Analiza todos los mensajes del sistema y cuenta cuántos fueron enviados
     * en cada hora del día (00:00-23:59), luego muestra las 3 horas con mayor actividad.
     * Utiliza Insertion Sort para ordenar.
     */
    private static void top3Horas() {
        // Array que cuenta mensajes por hora (índice 0 = 00:00-00:59, índice 23 = 23:00-23:59)
        int[] horas = new int[24];

        // Recorrer todos los mensajes de todos los chats
        for (Chat c : chats) {
            for (Mensaje m : c.getMensajes()) {
                // Extraer la hora del mensaje (formato fecha: "hh:mm dd/MM/yyyy")
                int h = extraerHora(m.getFecha());
                // Si la hora es válida (0-23), incrementar el contador de esa hora
                if (h >= 0 && h < 24)
                    horas[h]++;
            }
        }

        // Crear matriz de pares [hora, conteo] para poder ordenar manteniendo ambos datos
        int[][] pares = new int[24][2];
        for (int h = 0; h < 24; h++) {
            pares[h][0] = h;         // Primera columna: número de hora
            pares[h][1] = horas[h];  // Segunda columna: cantidad de mensajes en esa hora
        }

        // Algoritmo Insertion Sort para ordenar por conteo descendente
        for (int i = 1; i < 24; i++) {
            // Guardar el par actual como "clave"
            int[] key = pares[i];
            int j = i - 1;

            // Mover elementos con menor conteo hacia adelante
            while (j >= 0 && pares[j][1] < key[1]) {
                pares[j + 1] = pares[j];
                j--;
            }
            // Insertar la clave en su posición correcta
            pares[j + 1] = key;
        }

        // Mostrar las 3 horas con más mensajes
        System.out.println("\nTop 3 horas con más mensajes:");
        for (int i = 0; i < 3; i++) {
            System.out.printf("%d) %02d:00 -> %d mensajes%n", i + 1, pares[i][0], pares[i][1]);
        }
    }

    /**
     * Opción 4 del menú: Editar chat
     * Permite modificar el título de un chat o agregar un nuevo participante.
     * Realiza validaciones para asegurar la integridad de los datos.
     * @param sc Scanner para leer la entrada del usuario
     */
    private static void editarChat(Scanner sc) {
        // Solicitar el ID del chat a editar
        System.out.print("ID del chat a editar: ");
        int cid = leerEntero(sc);

        // Buscar el chat por ID
        Chat c = findChatById(cid);
        if (c == null) {
            System.out.println("Chat no encontrado.");
            return;
        }

        // Mostrar submenú de opciones de edición
        System.out.println("Editar chat: " + c.getTitulo());
        System.out.println("a) Cambiar título");
        System.out.println("b) Agregar usuario");
        System.out.print("Elija opción: ");
        String op = sc.nextLine().trim().toLowerCase();

        // Opción a: Cambiar título del chat
        if ("a".equals(op)) {
            System.out.print("Nuevo título: ");
            String nuevo = sc.nextLine().trim();
            // Validar que el nuevo título no esté vacío
            if (!nuevo.isEmpty()) {
                c.setTitulo(nuevo);
                System.out.println("Título actualizado.");
            } else
                System.out.println("Título no modificado (vacío).");
        }
        // Opción b: Agregar usuario al chat
        else if ("b".equals(op)) {
            System.out.print("ID del usuario a agregar: ");
            int uid = leerEntero(sc);

            // Buscar el usuario por ID
            Usuario u = findUsuarioById(uid);
            if (u == null) {
                System.out.println("Usuario no existe.");
                return;
            }

            // Validar que el usuario no esté ya en el chat
            if (c.contieneUsuario(uid)) {
                System.out.println("El usuario ya pertenece al chat.");
                return;
            }

            // Agregar el usuario al chat
            c.addParticipante(u);
            System.out.println("Usuario agregado.");
        }
        // Opción no válida
        else {
            System.out.println("Opción inválida.");
        }
    }

    /**
     * Opción 5 del menú: Enviar un mensaje a varios chats
     * Permite a un usuario enviar el mismo mensaje a múltiples chats simultáneamente.
     * Valida que el usuario sea participante de todos los chats donde enviará el mensaje.
     * Nota: Parte de esta funcionalidad no se consideró en la evaluación original.
     * @param sc Scanner para leer la entrada del usuario
     */
    private static void enviarMensajeVariosChats(Scanner sc) {
        // Solicitar el ID del usuario que enviará el mensaje
        System.out.print("ID del usuario remitente: ");
        int uid = leerEntero(sc);

        // Buscar el usuario
        Usuario remitente = findUsuarioById(uid);
        if (remitente == null) {
            System.out.println("Usuario remitente no existe.");
            return;
        }

        // Solicitar el contenido del mensaje
        System.out.print("Contenido del mensaje: ");
        String contenido = sc.nextLine().trim();
        if (contenido.isEmpty()) {
            System.out.println("Mensaje vacío. Operación cancelada.");
            return;
        }

        // Solicitar la fecha del mensaje (no se consideró en evaluación original)
        System.out.print("Fecha (formato " + FORMATO + "): ");
        String fecha = sc.nextLine().trim();
        // Validar longitud mínima de la fecha
        if (fecha.length() < 16) {
            System.out.println("Fecha no válida. Operación cancelada.");
            return;
        }

        // Leer los IDs de los chats donde se enviará el mensaje
        // El usuario ingresa IDs uno por uno, y termina con -1
        List<Integer> ids = new ArrayList<>();
        System.out.println("Ingrese IDs de chat (termine con -1):");
        while (true) {
            int cid = leerEntero(sc);
            if (cid == -1)
                break;
            ids.add(cid);
        }
        // Validar que se haya ingresado al menos un chat
        if (ids.isEmpty()) {
            System.out.println("Sin chats. Cancelado.");
            return;
        }

        // VALIDACIÓN CRÍTICA: verificar que el remitente pertenezca a TODOS los chats
        for (int cid : ids) {
            Chat c = findChatById(cid);
            // Si el chat no existe o el usuario no es participante, cancelar toda la operación
            if (c == null || !c.contieneUsuario(uid)) {
                System.out
                        .println("Cancelado: el remitente NO pertenece a todos los chats (falla en chat " + cid + ").");
                return;
            }
        }

        // Si pasó todas las validaciones, crear el mensaje en cada chat
        for (int cid : ids) {
            Chat c = findChatById(cid);
            // Generar un nuevo ID único para cada mensaje
            int nuevoId = ++maxMensajeId;
            // Crear el mensaje
            Mensaje m = new Mensaje(nuevoId, c, fecha, remitente, contenido);
            // Agregarlo al chat correspondiente
            c.agregarMensaje(m);
        }
        System.out.println("Mensaje enviado a " + ids.size() + " chat(s).");
    }

    /*
     * =========================
     * SECCIÓN: MÉTODOS AUXILIARES (HELPERS)
     * =========================
     * Métodos utilitarios que facilitan operaciones comunes en el programa.
     */

    /**
     * Método que extrae la hora (0-23) de una fecha en formato "hh:mm dd/MM/yyyy".
     * @param fecha String con formato "hh:mm dd/MM/yyyy"
     * @return Un número entre 0 y 23 representando la hora, o -1 si hay error
     */
    private static int extraerHora(String fecha) {
        try {
            // Extraer los primeros 2 caracteres que corresponden a la hora
            String hh = fecha.substring(0, 2);
            // Convertir a entero y retornar
            return Integer.parseInt(hh);
        } catch (Exception e) {
            // Si hay error (formato inválido), retornar -1
            return -1;
        }
    }

    /**
     * Método que busca un usuario por su ID en la lista de usuarios.
     * Realiza una búsqueda lineal en la lista.
     * @param id El ID del usuario a buscar
     * @return El objeto Usuario si se encuentra, null si no existe
     */
    private static Usuario findUsuarioById(int id) {
        // Recorrer todos los usuarios
        for (Usuario u : usuarios)
            // Si encuentra el usuario con el ID buscado, retornarlo
            if (u.getId() == id)
                return u;
        // Si no se encontró, retornar null
        return null;
    }

    /**
     * Método que busca el índice de un usuario en la lista por su ID.
     * Útil cuando se necesita la posición del usuario en la lista, no solo el objeto.
     * @param id El ID del usuario a buscar
     * @return El índice (posición) del usuario en la lista, o -1 si no existe
     */
    private static int indexUsuarioById(int id) {
        // Recorrer la lista por índices
        for (int i = 0; i < usuarios.size(); i++)
            // Si encuentra el usuario, retornar su índice
            if (usuarios.get(i).getId() == id)
                return i;
        // Si no se encontró, retornar -1
        return -1;
    }

    /**
     * Método que busca un chat por su ID en la lista de chats.
     * Realiza una búsqueda lineal en la lista.
     * @param id El ID del chat a buscar
     * @return El objeto Chat si se encuentra, null si no existe
     */
    private static Chat findChatById(int id) {
        // Recorrer todos los chats
        for (Chat c : chats)
            // Si encuentra el chat con el ID buscado, retornarlo
            if (c.getId() == id)
                return c;
        // Si no se encontró, retornar null
        return null;
    }

    /**
     * Método que intenta convertir un String a int de forma segura.
     * Si falla la conversión, retorna 0 en lugar de lanzar excepción.
     * Útil al parsear datos de archivos que podrían estar mal formateados.
     * @param s El String a convertir
     * @return El número entero parseado, o 0 si hay error
     */
    private static int parseIntSeguro(String s) {
        try {
            return Integer.parseInt(s);
        } catch (Exception e) {
            // Si no se puede parsear, retornar 0 por defecto
            return 0;
        }
    }

    /**
     * Método que lee un número entero desde el Scanner con validación.
     * Si el usuario ingresa un valor no numérico, pide reingresar hasta obtener un número válido.
     * Esto mejora la experiencia de usuario y previene errores de entrada.
     * @param sc Scanner para leer la entrada del usuario
     * @return El número entero ingresado por el usuario
     */
    private static int leerEntero(Scanner sc) {
        // Bucle infinito hasta que se ingrese un número válido
        while (true) {
            String line = sc.nextLine().trim();
            try {
                // Intentar parsear el String a int
                return Integer.parseInt(line);
            } catch (Exception e) {
                // Si falla, pedir que ingrese nuevamente
                System.out.print("Ingrese un número válido: ");
            }
        }
    }

}