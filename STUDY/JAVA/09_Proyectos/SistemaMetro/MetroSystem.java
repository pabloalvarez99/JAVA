/*
 * ============================================================================
 * SISTEMA DE ESTACIONES DE METRO - PROGRAMACIÓN ORIENTADA A OBJETOS
 * ============================================================================
 *
 * Este programa modela una red de metro usando LISTAS DOBLEMENTE ENLAZADAS.
 *
 * ESTRUCTURA DE DATOS:
 * -------------------
 * Cada estación (Station) es un NODO que apunta a:
 *   - previousStation: la estación anterior en la línea
 *   - nextStation: la estación siguiente en la línea
 *   - interchange: otra estación en una línea diferente (trasbordo)
 *
 * VISUALIZACIÓN:
 * -------------
 * Línea 1:  [San Pablo] <-> [Los Heroes] <-> [Baquedano] <-> [Los Leones]
 *                               |                                  |
 *                           (intercambio)                     (intercambio)
 *                               |                                  |
 * Línea 2:           [Vespucio Norte] <-> [Los Heroes] <-> [Franklin]
 *                                                                |
 *                                                          (intercambio)
 *                                                                |
 * Línea 6:                                              [Cerrillos] <-> [Franklin] <-> [Bio Bio]
 *
 */

// ============================================================================
// CLASE STATION: Representa una estación individual del metro
// ============================================================================
class Station {
    // ATRIBUTOS PRIVADOS (Encapsulación)
    // -----------------------------------
    private String name;                    // Nombre de la estación (ej: "Los Heroes")
    private Station previousStation;        // Apuntador a la estación ANTERIOR
    private Station nextStation;            // Apuntador a la estación SIGUIENTE
    private Station interchange;            // Apuntador a estación de OTRA línea (trasbordo)

    // CONSTRUCTOR
    // -----------
    // Se llama automáticamente al crear una nueva estación: new Station("Los Heroes")
    // Inicializa el nombre, los otros atributos quedan en null por defecto
    public Station(String name) {
        this.name = name;
        // previousStation, nextStation e interchange se inicializan en null automáticamente
    }

    // GETTERS Y SETTERS
    // -----------------
    // Permiten acceder y modificar atributos privados desde fuera de la clase
    // Esto es ENCAPSULACIÓN: controlamos cómo se accede a los datos

    // Retorna la referencia a la estación anterior
    public Station getPreviousStation() {
        return previousStation;
    }

    // Establece cuál es la estación anterior (crea el enlace hacia atrás)
    public void setPreviousStation(Station previousStation) {
        this.previousStation = previousStation;
    }

    // Retorna la referencia a la estación siguiente
    public Station getNextStation() {
        return nextStation;
    }

    // Establece cuál es la estación siguiente (crea el enlace hacia adelante)
    public void setNextStation(Station nextStation) {
        this.nextStation = nextStation;
    }

    // Retorna la estación de intercambio (puede ser null si no hay trasbordo)
    public Station getInterchange() {
        return interchange;
    }

    // Establece la estación de intercambio para hacer trasbordo a otra línea
    public void setInterchange(Station interchange) {
        this.interchange = interchange;
    }

    // Retorna el nombre de la estación
    public String getName() {
        return name;
    }
}

// ============================================================================
// CLASE LINE: Representa una línea de metro completa (lista enlazada)
// ============================================================================
class Line {
    // ATRIBUTOS PRIVADOS
    // ------------------
    private int number;                         // Número de la línea (1, 2, 6, etc.)
    private Station terminalStationBegin;       // Primera estación de la línea
    private Station terminalStationEnd;         // Última estación de la línea

    // CONSTRUCTOR
    // -----------
    public Line(int number) {
        this.number = number;
    }

    // ========================================================================
    // MÉTODO: addStations
    // ========================================================================
    // PROPÓSITO: Crear una línea completa a partir de un String con nombres
    //
    // PARÁMETROS:
    //   - names: String con nombres separados por comas
    //            Ejemplo: "San Pablo,Los Heroes,Baquedano,Los Leones"
    //
    // PROCESO:
    //   1. Divide el String por comas usando split()
    //   2. Valida que haya al menos 3 estaciones
    //   3. Crea la primera estación (terminalStationBegin)
    //   4. Crea estaciones intermedias conectándolas bidireccialmente
    //   5. Crea la última estación (terminalStationEnd)
    //
    // VISUALIZACIÓN DEL PROCESO:
    //   Paso 1: [San Pablo]
    //   Paso 2: [San Pablo] <-> [Los Heroes]
    //   Paso 3: [San Pablo] <-> [Los Heroes] <-> [Baquedano]
    //   Paso 4: [San Pablo] <-> [Los Heroes] <-> [Baquedano] <-> [Los Leones]
    // ========================================================================
    public void addStations(String names) {
        // PASO 1: Dividir el String en un array de nombres
        // ------------------------------------------------
        // Ejemplo: "A,B,C" -> ["A", "B", "C"]
        String[] stationNames = names.split(",");
        int stationCount = stationNames.length;

        // PASO 2: Validación - debe haber mínimo 3 estaciones
        // ---------------------------------------------------
        // Si hay menos de 3, lanza una excepción que interrumpe el flujo
        if (stationCount < 3) {
            throw new IllegalArgumentException("Faltan estaciones");
        }

        // PASO 3: Crear la PRIMERA estación de la línea
        // ----------------------------------------------
        // Esta será nuestro punto de partida para construir la línea
        this.terminalStationBegin = new Station(stationNames[0]);

        // Variable auxiliar para recorrer y construir la línea
        // "aux" siempre apunta a la última estación creada
        Station aux = this.terminalStationBegin;

        // PASO 4: Crear y conectar ESTACIONES INTERMEDIAS
        // -----------------------------------------------
        // Nota: el loop va desde i=1 hasta length-2 (no incluye la última)
        // Esto es porque la última estación se crea después de forma especial
        for (int i = 1; i < stationNames.length - 1; i++) {
            // 4a. Crear nueva estación y conectarla HACIA ADELANTE
            aux.setNextStation(new Station(stationNames[i]));

            // 4b. Conectar la nueva estación HACIA ATRÁS (bidireccional)
            // aux.getNextStation() retorna la estación recién creada
            aux.getNextStation().setPreviousStation(aux);

            // 4c. Mover "aux" a la nueva estación para continuar construyendo
            aux = aux.getNextStation();
        }

        // PASO 5: Crear la ÚLTIMA estación de la línea
        // ---------------------------------------------
        // Se crea separadamente para asignarla a terminalStationEnd
        this.terminalStationEnd = new Station(stationNames[stationCount - 1]);

        // Conectar la última estación bidireccialmente
        aux.setNextStation(terminalStationEnd);                  // Enlace hacia adelante
        this.terminalStationEnd.setPreviousStation(aux);        // Enlace hacia atrás
    }

    // ========================================================================
    // MÉTODO: printStationsForward
    // ========================================================================
    // PROPÓSITO: Imprimir todas las estaciones desde el INICIO hasta el FIN
    //
    // ALGORITMO:
    //   1. Imprime el encabezado con número de línea y dirección
    //   2. Recorre la lista desde terminalStationBegin usando getNextStation()
    //   3. Imprime cada estación con el formato: "A > B > C > D"
    //
    // EJEMPLO DE SALIDA:
    //   Línea 1 - Dirección Los Dominicos
    //   San Pablo > Los Heroes > Baquedano > Los Leones > El Golf > Los Dominicos
    // ========================================================================
    public void printStationsForward() {
        // Encabezado: muestra la dirección final (última estación)
        System.out.println("Línea " + this.number + " - Dirección " + terminalStationEnd.getName());

        // Variable auxiliar para recorrer la lista
        Station aux = terminalStationBegin;

        // Recorrer hasta que no haya más estaciones
        // El loop continúa mientras aux.getNextStation() no sea null
        while (aux.getNextStation() != null) {
            System.out.print(aux.getName() + " > ");    // Imprime nombre con flecha
            aux = aux.getNextStation();                  // Avanza a la siguiente
        }

        // Imprimir la última estación (sin flecha al final)
        System.out.print(aux.getName());
        System.out.println();  // Salto de línea al final
    }

    // ========================================================================
    // MÉTODO: printStationsBackward
    // ========================================================================
    // PROPÓSITO: Imprimir todas las estaciones en REVERSA (desde el fin al inicio)
    //
    // DIFERENCIA CON printStationsForward:
    //   - Empieza desde terminalStationEnd (no terminalStationBegin)
    //   - Usa getPreviousStation() en lugar de getNextStation()
    //   - La dirección mostrada es hacia el inicio
    //
    // EJEMPLO DE SALIDA:
    //   Línea 2 - Dirección Vespucio Norte
    //   Hospital El Pino > Franklin > Los Heroes > Vespucio Norte
    // ========================================================================
    public void printStationsBackward() {
        // Encabezado: muestra la dirección inicial (primera estación)
        System.out.println("Línea " + this.number + " - Dirección " + terminalStationBegin.getName());

        // Empezar desde la ÚLTIMA estación
        Station aux = terminalStationEnd;

        // Recorrer HACIA ATRÁS usando getPreviousStation()
        while (aux.getPreviousStation() != null) {
            System.out.print(aux.getName() + " > ");    // Imprime nombre con flecha
            aux = aux.getPreviousStation();              // Retrocede a la anterior
        }

        // Imprimir la primera estación (sin flecha al final)
        System.out.print(aux.getName());
        System.out.println();
    }

    // ========================================================================
    // MÉTODO: findStation
    // ========================================================================
    // PROPÓSITO: Buscar una estación por su nombre en esta línea
    //
    // PARÁMETROS:
    //   - station: nombre de la estación a buscar (String)
    //
    // RETORNA:
    //   - La referencia a la estación si se encuentra
    //   - null si no existe en esta línea
    //
    // ALGORITMO:
    //   Búsqueda lineal: recorre la lista comparando nombres
    //   Complejidad temporal: O(n) donde n es el número de estaciones
    //
    // NOTA IMPORTANTE:
    //   La verificación dentro del loop está duplicada:
    //   - Primero verifica aux
    //   - Luego avanza
    //   - Luego verifica aux nuevamente
    //   Esto asegura que la última estación también se verifique
    // ========================================================================
    public Station findStation(String station) {
        // Empezar desde el inicio de la línea
        Station aux = terminalStationBegin;

        // Recorrer toda la lista
        while (aux.getNextStation() != null) {
            // Verificar si el nombre coincide (primera verificación)
            if (aux.getName().equals(station)) {
                return aux;  // Encontrada! Retornar inmediatamente
            }

            // Avanzar a la siguiente estación
            aux = aux.getNextStation();

            // Verificar nuevamente (segunda verificación)
            // Esta línea asegura que la ÚLTIMA estación también se verifique
            if (aux.getName().equals(station)) {
                return aux;  // Encontrada!
            }
        }

        // Si llegamos aquí, no se encontró la estación
        return null;
    }

    // ========================================================================
    // MÉTODO: setInterchangeStations
    // ========================================================================
    // PROPÓSITO: Conectar dos líneas en una estación común (crear trasbordo)
    //
    // PARÁMETROS:
    //   - line: la otra línea con la que queremos conectar
    //   - name: nombre de la estación donde se hace el trasbordo
    //
    // PROCESO:
    //   1. Busca la estación "name" en la línea actual (this)
    //   2. Busca la estación "name" en la otra línea (line)
    //   3. Conecta ambas estaciones BIDIRECCIALMENTE usando setInterchange()
    //
    // EJEMPLO:
    //   Línea 1: ... <-> [Los Heroes] <-> ...
    //                          |
    //                    (interchange)
    //                          |
    //   Línea 2: ... <-> [Los Heroes] <-> ...
    //
    // DESPUÉS DE LLAMAR: line1.setInterchangeStations(line2, "Los Heroes")
    //   - La estación "Los Heroes" de L1 apunta a "Los Heroes" de L2
    //   - La estación "Los Heroes" de L2 apunta a "Los Heroes" de L1
    // ========================================================================
    public void setInterchangeStations(Line line, String name) {
        // Buscar la estación en ESTA línea
        Station stationA = this.findStation(name);

        // Buscar la estación en la OTRA línea
        Station stationB = line.findStation(name);

        // Crear conexión BIDIRECCIONAL entre ambas estaciones
        stationA.setInterchange(stationB);    // A -> B
        stationB.setInterchange(stationA);    // B -> A

        // Ahora ambas estaciones apuntan una a la otra
        // Esto permite "saltar" entre líneas durante el recorrido
    }

    // ========================================================================
    // MÉTODO: roam
    // ========================================================================
    // PROPÓSITO: "Deambular" por la red de metro haciendo hasta 'stops' paradas
    //            Si encuentra un INTERCAMBIO, automáticamente cambia de línea
    //
    // PARÁMETROS:
    //   - stops: número máximo de paradas a realizar
    //
    // COMPORTAMIENTO:
    //   - Empieza desde terminalStationBegin de esta línea
    //   - En cada estación, verifica si hay intercambio (trasbordo)
    //   - Si NO hay intercambio: sigue en la misma línea (getNextStation)
    //   - Si SÍ hay intercambio: salta a la otra línea (getInterchange().getNextStation())
    //   - Se detiene al alcanzar 'stops' paradas o al llegar al final
    //
    // EJEMPLO DE RECORRIDO:
    //   L1: San Pablo -> Los Heroes (intercambio a L2) ->
    //   L2: Franklin (intercambio a L6) ->
    //   L6: Bio Bio -> Ñuble -> ...
    //
    // SALIDA:
    //   Deambulando desde San Pablo
    //   San Pablo - Los Heroes - Franklin - Bio Bio - Ñuble
    // ========================================================================
    public void roam(int stops) {
        // Mensaje inicial: desde dónde empezamos
        System.out.println("Deambulando desde " + terminalStationBegin.getName());

        // Empezar desde la primera estación de esta línea
        Station aux = terminalStationBegin;

        // Contador de estaciones visitadas
        int stationCounter = 0;

        // CONDICIONES DEL LOOP:
        // 1. Que haya una siguiente estación (aux.getNextStation() != null)
        // 2. Que no hayamos alcanzado el límite de paradas (stationCounter < stops - 1)
        //    Nota: stops - 1 porque el contador empieza en 0
        while (aux.getNextStation() != null && stationCounter < stops - 1) {
            // Imprimir la estación actual
            System.out.print(aux.getName() + " - ");

            // DECISIÓN: ¿Hay intercambio en esta estación?
            if (aux.getInterchange() == null) {
                // CASO 1: NO hay intercambio
                // ---------------------------
                // Simplemente avanzamos a la siguiente estación de la misma línea
                aux = aux.getNextStation();
            }
            else {
                // CASO 2: SÍ hay intercambio
                // ---------------------------
                // Saltamos a la OTRA línea:
                // 1. aux.getInterchange() -> nos da la estación en la otra línea
                // 2. .getNextStation() -> avanzamos una estación en esa línea
                aux = aux.getInterchange().getNextStation();

                // EFECTO: hemos cambiado de línea y avanzado una estación
            }

            // Incrementar el contador de paradas
            stationCounter++;
        }

        // Imprimir la estación final (sin guión al final)
        System.out.print(aux.getName());
        System.out.println();  // Salto de línea
    }
}

// ============================================================================
// CLASE APP: Programa principal (punto de entrada)
// ============================================================================
public class App {
    // ========================================================================
    // MÉTODO MAIN: Donde empieza la ejecución del programa
    // ========================================================================
    public static void main(String[] args) {
        try {
            // ================================================================
            // PARTE 1: CREAR LÍNEAS DE METRO
            // ================================================================
            System.out.println("=== CREANDO LÍNEAS DE METRO ===\n");

            // Crear 4 objetos Line (líneas vacías por ahora)
            Line one = new Line(1);      // Línea 1
            Line two = new Line(2);      // Línea 2
            Line six = new Line(6);      // Línea 6
            Line four = new Line(4);     // Línea 4

            // ================================================================
            // PARTE 2: AGREGAR ESTACIONES A CADA LÍNEA
            // ================================================================
            // Cada llamada a addStations crea la lista enlazada completa

            // Línea 1: 6 estaciones
            one.addStations("San Pablo,Los Heroes,Baquedano,Los Leones,El Golf,Los Dominicos");

            // Línea 2: 4 estaciones
            two.addStations("Vespucio Norte,Los Heroes,Franklin,Hospital El Pino");

            // Línea 6: 6 estaciones
            six.addStations("Cerrillos,Franklin,Bio Bio,Ñuble,Ñuñoa,Los Leones");

            // ================================================================
            // PARTE 3: IMPRIMIR LÍNEAS EN AMBAS DIRECCIONES
            // ================================================================
            System.out.println("=== IMPRIMIENDO LÍNEAS ===\n");

            // Imprimir L1 en dirección normal (inicio -> fin)
            one.printStationsForward();

            // Imprimir L2 en dirección reversa (fin -> inicio)
            two.printStationsBackward();

            System.out.println();

            // ================================================================
            // PARTE 4: CONFIGURAR INTERCAMBIOS (trasbordos entre líneas)
            // ================================================================
            System.out.println("=== CONFIGURANDO INTERCAMBIOS ===\n");

            // Intercambio 1: Línea 1 <-> Línea 2 en "Los Heroes"
            one.setInterchangeStations(two, "Los Heroes");
            System.out.println("Intercambio configurado: L1 <-> L2 en 'Los Heroes'");

            // Intercambio 2: Línea 2 <-> Línea 6 en "Franklin"
            two.setInterchangeStations(six, "Franklin");
            System.out.println("Intercambio configurado: L2 <-> L6 en 'Franklin'");

            // Intercambio 3: Línea 6 <-> Línea 1 en "Los Leones"
            six.setInterchangeStations(one, "Los Leones");
            System.out.println("Intercambio configurado: L6 <-> L1 en 'Los Leones'");

            System.out.println();

            // ================================================================
            // PARTE 5: RECORRER LÍNEAS CON INTERCAMBIOS AUTOMÁTICOS
            // ================================================================
            System.out.println("=== DEAMBULANDO POR LA RED ===\n");

            // Recorrido 1: 8 paradas desde L1
            // Puede saltar automáticamente a L2 en "Los Heroes" si hay intercambio
            one.roam(8);
            System.out.println();

            // Recorrido 2: 5 paradas desde L6
            // Puede saltar a L2 en "Franklin" o a L1 en "Los Leones"
            six.roam(5);
            System.out.println();

            // ================================================================
            // PARTE 6: PROVOCAR UNA EXCEPCIÓN (manejo de errores)
            // ================================================================
            System.out.println("=== INTENTANDO CREAR LÍNEA INVÁLIDA ===\n");

            // Esta línea causará una IllegalArgumentException porque solo tiene 2 estaciones
            // El método addStations requiere mínimo 3 estaciones
            four.addStations("Tobalaba,Plaza de Puente Alto");

            // Si llegamos aquí, no hubo error (no debería pasar con los datos actuales)
            System.out.println("Línea 4 creada exitosamente");

        } catch (Exception e) {
            // CAPTURA DE EXCEPCIÓN
            // --------------------
            // Si algo sale mal (como crear una línea con < 3 estaciones)
            // el flujo salta aquí y captura el error
            System.out.println("ERROR: " + e.getMessage());

            // Salida esperada: "ERROR: Faltan estaciones"
        }
    }
}

/*
 * ============================================================================
 * CONCEPTOS CLAVE DE POO EN ESTE CÓDIGO
 * ============================================================================
 *
 * 1. ENCAPSULACIÓN
 *    - Atributos privados (private)
 *    - Acceso controlado mediante getters/setters públicos
 *    - Oculta la implementación interna
 *
 * 2. LISTA DOBLEMENTE ENLAZADA
 *    - Cada Station apunta a previousStation y nextStation
 *    - Permite recorrer en ambas direcciones
 *    - Estructura dinámica (no necesita tamaño fijo)
 *
 * 3. REFERENCIAS BIDIRECCIONALES
 *    - setInterchange conecta dos estaciones en ambas direcciones
 *    - Permite "saltar" entre estructuras de datos diferentes
 *
 * 4. MANEJO DE EXCEPCIONES
 *    - throw lanza una excepción cuando los datos son inválidos
 *    - try-catch captura y maneja el error sin que el programa crash
 *
 * 5. BÚSQUEDA LINEAL
 *    - findStation recorre la lista secuencialmente
 *    - Complejidad O(n) - podría mejorarse con HashMap
 *
 * 6. NAVEGACIÓN CON SALTOS
 *    - roam usa intercambios para cambiar dinámicamente de línea
 *    - Demuestra polimorfismo estructural (misma interfaz, diferente camino)
 *
 * 7. SEPARACIÓN DE RESPONSABILIDADES
 *    - Station: maneja datos de una estación
 *    - Line: maneja lógica de la lista enlazada
 *    - App: coordina la creación y uso de objetos
 *
 * ============================================================================
 * SALIDA ESPERADA DEL PROGRAMA
 * ============================================================================
 *
 * === CREANDO LÍNEAS DE METRO ===
 *
 * === IMPRIMIENDO LÍNEAS ===
 *
 * Línea 1 - Dirección Los Dominicos
 * San Pablo > Los Heroes > Baquedano > Los Leones > El Golf > Los Dominicos
 * Línea 2 - Dirección Vespucio Norte
 * Hospital El Pino > Franklin > Los Heroes > Vespucio Norte
 *
 * === CONFIGURANDO INTERCAMBIOS ===
 *
 * Intercambio configurado: L1 <-> L2 en 'Los Heroes'
 * Intercambio configurado: L2 <-> L6 en 'Franklin'
 * Intercambio configurado: L6 <-> L1 en 'Los Leones'
 *
 * === DEAMBULANDO POR LA RED ===
 *
 * Deambulando desde San Pablo
 * San Pablo - Los Heroes - Franklin - Bio Bio - Ñuble - Ñuñoa - Los Leones - El Golf
 *
 * Deambulando desde Cerrillos
 * Cerrillos - Franklin - Bio Bio - Ñuble - Ñuñoa
 *
 * === INTENTANDO CREAR LÍNEA INVÁLIDA ===
 *
 * ERROR: Faltan estaciones
 *
 * ============================================================================
 */
