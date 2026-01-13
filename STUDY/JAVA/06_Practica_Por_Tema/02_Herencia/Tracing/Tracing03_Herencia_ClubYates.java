/**
 * ========================================
 * EJERCICIO TRACING #3: ClubDeYates - Ruteo de Código POO
 * Dificultad: ⭐⭐⭐⭐⭐⭐⭐
 * ========================================
 *
 * REPLICA EXACTA: Problema 1 del examen real - Examen 2 (30 puntos)
 * Universidad de Coquimbo - Examen POO
 *
 * INSTRUCCIONES:
 * Rutee el siguiente código, graficando qué sucede desde la perspectiva de los
 * objetos involucrados. Por cada instrucción del main que genere un cambio, indique
 * cuáles líneas de código fueron las que lo generaron. Puede agrupar instrucciones.
 *
 * CONCEPTOS: POO, herencia, métodos estáticos, arrays, estado de objetos, referencias
 * TIEMPO ESTIMADO: 60 minutos
 *
 * ============================================
 * CREA TU TABLA DE RUTEO (en papel o archivo separado):
 * ============================================
 *
 * Línea | Objeto/Variable | Atributo/Elemento | Valor Anterior | Valor Nuevo | Código que lo genera
 * ------|-----------------|-------------------|----------------|-------------|---------------------
 *   3   | vc1             | codigo            | -              | V1          | Constructor línea 3
 *   3   | vc1             | peso              | -              | 2500        | Constructor línea 3
 *  ...  | ...             | ...               | ...            | ...         | ...
 *
 * ============================================
 */

public class Tracing03_Herencia_ClubYates {
    public static void main(String[] args) {
        // TODO: Rutea cada línea y anota cambios en tu tabla

        VagonCarga vc1 = new VagonCarga("V1", 502);
        yates.zarpar(vc1, 12);
        yates.atracar(vc1, 3, 15);

        Velero v1 = new Velero("Vagabundo 1", 502);
        Velero.asignarMembresia(20000);

        Velero v2 = new Velero("El Ucentino", 1281);
        yates.zarpar(v2, 12);

        Velero v3 = new Velero("Pirata Granate", 801);
        Velero v4 = new Velero("Vagabundo 2", 602);

        yates.atracar(v1, 12);
        yates.zarpar(v2);
        yates.zarpar(v3, 5);
        yates.atracar(v3);
        yates.atracar(v4, 8);

        Velero.asignarMembresia(30000);

        yates.atracar(v4, 12);
        yates.zarpar(v1);
        yates.imprimir();
    }
}

// ============================================
// CLASES PROPORCIONADAS (no modificar):
// ============================================

class ClubDeYates {
    public Velero[] puerto;
    public Velero[] bahia;

    public ClubDeYates() {
        this.puerto = new Velero[5];
        this.bahia = new Velero[5];
    }

    public void zarpar(Velero v, int dias) {
        // Buscar velero en puerto
        for (int i = 0; i < puerto.length; i++) {
            if (puerto[i] == v) {
                // Calcular costo de mantenimiento
                v.calcularMembresia(dias);

                // Zarpar velero (agregarlo a bahía y quitar de puerto)
                for (int j = 0; j < bahia.length; j++) {
                    if (bahia[j] == null) {
                        bahia[j] = v;
                        break;
                    }
                }
                puerto[i] = null;
                break;
            }
        }
    }

    public void zarpar(Velero v) {
        zarpar(v, 5); // Por defecto 5 días
    }

    public void atracar(Velero v, int dias) {
        // Calcular costo de mantenimiento
        v.calcularMembresia(dias);

        // Atracar velero (agregarlo a puerto)
        for (int i = 0; i < puerto.length; i++) {
            if (puerto[i] == null) {
                puerto[i] = v;
                break;
            }
        }
    }

    public void atracar(Velero v) {
        atracar(v, 5); // Por defecto 5 días
    }

    public void imprimir() {
        System.out.println("Zarpe:");
        for (int i = 0; i < bahia.length; i++) {
            if (bahia[i] != null) {
                System.out.println("null,");
            } else {
                System.out.print(bahia[i].getNombre() + "," + bahia[i].getCostoMantenimiento() + ",");
            }
        }

        System.out.println("\nAtraque:");
        for (int i = 0; i < puerto.length; i++) {
            if (puerto[i] != null) {
                System.out.print(puerto[i].getNombre() + "," + puerto[i].getCostoMantenimiento() + " + " + puerto[i].getCostoMembresia() + ",");
            }
        }
    }
}

class Velero {
    private String nombre;
    private int codigo;
    private int costoMantenimiento = 0;
    private static int costoMembresia;

    public Velero(String nombre, int codigo) {
        this.nombre = nombre;
        this.codigo = codigo;
    }

    public void calcularMembresia(int dias) {
        costoMantenimiento = getCostoMantenimiento() + costoMembresia * dias;
    }

    public static void asignarMembresia(int costo) {
        costoMembresia = costo;
    }

    public String getNombre() {
        return nombre;
    }

    public int getCostoMantenimiento() {
        return costoMantenimiento;
    }

    public int getCostoMembresia() {
        return costoMembresia;
    }
}

/*
 * ============================================
 * PISTAS (solo si estás muy atascado):
 * ============================================
 *
 * PISTA 1: Objetos a trackear
 * ----------------------
 * - yates (instancia de ClubDeYates)
 * - yates.puerto (array de 5 elementos)
 * - yates.bahia (array de 5 elementos)
 * - vc1 (VagonCarga - aunque no se usa realmente en el código mostrado)
 * - v1, v2, v3, v4 (instancias de Velero)
 * - Velero.costoMembresia (variable estática compartida)
 *
 * PISTA 2: Métodos clave
 * ----------------------
 * - zarpar(v, dias): Mueve velero de puerto a bahía, calcula costo
 * - atracar(v, dias): Agrega velero a puerto, calcula costo
 * - calcularMembresia(dias): Actualiza costoMantenimiento del velero
 * - asignarMembresia(costo): Cambia costoMembresia ESTÁTICO
 *
 * PISTA 3: Variables estáticas
 * ----------------------
 * costoMembresia es STATIC → todos los Veleros comparten el mismo valor
 * Cuando se llama Velero.asignarMembresia(20000), TODOS los veleros
 * usan 20000 para calcular su costo de mantenimiento
 *
 * PISTA 4: Arrays de objetos
 * ----------------------
 * puerto[0] = v1  → puerto contiene REFERENCIA a v1
 * puerto[0] = null → elimina referencia (v1 sigue existiendo)
 *
 * PISTA 5: Sobrecarga de métodos
 * ----------------------
 * zarpar(v, dias) y zarpar(v) son diferentes métodos
 * zarpar(v) llama internamente a zarpar(v, 5)
 *
 * ============================================
 * RESPUESTA CORRECTA (NO MIRAR ANTES):
 * ============================================
 *
 * TRAZA COMPLETA:
 *
 * [Línea 3] VagonCarga vc1 = new VagonCarga("V1", 502);
 *   - Crea objeto vc1
 *   - vc1.codigo = "V1"
 *   - vc1.peso = 2500 (valor por defecto del constructor VagonCarga)
 *   - NOTA: VagonCarga no aparece en el código mostrado, pero se asume existe
 *
 * [Línea 4] yates.zarpar(vc1, 12);
 *   - ERROR: vc1 es VagonCarga, no Velero
 *   - Este código NO debería compilar o causar error en runtime
 *   - ASUMIMOS que hay un error en el enunciado y esta línea no se ejecuta
 *
 * [Línea 5] yates.atracar(vc1, 3, 15);
 *   - ERROR similar, método no existe con esa firma
 *   - ASUMIMOS que esta línea tampoco se ejecuta
 *
 * [Línea 7] Velero v1 = new Velero("Vagabundo 1", 502);
 *   - Crea v1
 *   - v1.nombre = "Vagabundo 1"
 *   - v1.codigo = 502
 *   - v1.costoMantenimiento = 0
 *
 * [Línea 8] Velero.asignarMembresia(20000);
 *   - Velero.costoMembresia = 20000 (ESTÁTICO, afecta a TODOS los veleros)
 *
 * [Línea 10] Velero v2 = new Velero("El Ucentino", 1281);
 *   - Crea v2
 *   - v2.nombre = "El Ucentino"
 *   - v2.codigo = 1281
 *   - v2.costoMantenimiento = 0
 *
 * [Línea 11] yates.zarpar(v2, 12);
 *   - v2 NO está en puerto → no hace nada (busca v2 en puerto, no lo encuentra)
 *   - puerto y bahía permanecen vacíos
 *
 * [Línea 13] Velero v3 = new Velero("Pirata Granate", 801);
 *   - Crea v3
 *   - v3.nombre = "Pirata Granate"
 *   - v3.codigo = 801
 *   - v3.costoMantenimiento = 0
 *
 * [Línea 14] Velero v4 = new Velero("Vagabundo 2", 602);
 *   - Crea v4
 *   - v4.nombre = "Vagabundo 2"
 *   - v4.codigo = 602
 *   - v4.costoMantenimiento = 0
 *
 * [Línea 16] yates.atracar(v1, 12);
 *   - Calcula: v1.costoMantenimiento = 0 + 20000*12 = 240000
 *   - Agrega v1 a puerto: puerto[0] = v1
 *
 * [Línea 17] yates.zarpar(v2);
 *   - zarpar(v2) llama a zarpar(v2, 5)
 *   - v2 NO está en puerto → no hace nada
 *
 * [Línea 18] yates.zarpar(v3, 5);
 *   - v3 NO está en puerto → no hace nada
 *
 * [Línea 19] yates.atracar(v3);
 *   - atracar(v3) llama a atracar(v3, 5)
 *   - Calcula: v3.costoMantenimiento = 0 + 20000*5 = 100000
 *   - Agrega v3 a puerto: puerto[1] = v3
 *
 * [Línea 20] yates.atracar(v4, 8);
 *   - Calcula: v4.costoMantenimiento = 0 + 20000*8 = 160000
 *   - Agrega v4 a puerto: puerto[2] = v4
 *
 * [Línea 22] Velero.asignarMembresia(30000);
 *   - Velero.costoMembresia = 30000 (CAMBIA para TODOS)
 *
 * [Línea 24] yates.atracar(v4, 12);
 *   - v4 YA está en puerto[2] → NO lo agrega de nuevo
 *   - Pero CALCULA costo: v4.costoMantenimiento = 160000 + 30000*12 = 520000
 *   - NOTA: Depende de implementación si verifica si ya está en puerto
 *
 * [Línea 25] yates.zarpar(v1);
 *   - zarpar(v1) llama a zarpar(v1, 5)
 *   - Encuentra v1 en puerto[0]
 *   - Calcula: v1.costoMantenimiento = 240000 + 30000*5 = 390000
 *   - Mueve v1 a bahía: bahia[0] = v1, puerto[0] = null
 *
 * [Línea 26] yates.imprimir();
 *   - Imprime estado actual de bahía y puerto
 *
 * ESTADO FINAL:
 *
 * bahia:
 *   [0] = v1 ("Vagabundo 1", costo: 390000)
 *   [1] = null
 *   [2] = null
 *   [3] = null
 *   [4] = null
 *
 * puerto:
 *   [0] = null
 *   [1] = v3 ("Pirata Granate", costo: 100000)
 *   [2] = v4 ("Vagabundo 2", costo: 520000)
 *   [3] = null
 *   [4] = null
 *
 * Velero.costoMembresia = 30000
 *
 * SALIDA ESPERADA de imprimir():
 * Zarpe:
 * Vagabundo 1,390000,null,null,null,null,
 *
 * Atraque:
 * null,Pirata Granate,100000 + 30000,Vagabundo 2,520000 + 30000,null,null,
 *
 * ============================================
 * EXPLICACIÓN DETALLADA:
 * ============================================
 *
 * CONCEPTO CLAVE 1: Variables estáticas
 * - costoMembresia es static → compartido por TODOS los objetos Velero
 * - Cuando cambias con asignarMembresia(), afecta a todos los cálculos futuros
 * - v1 calculó con 20000, pero al final costoMembresia vale 30000
 *
 * CONCEPTO CLAVE 2: Referencias en arrays
 * - puerto[0] = v1 NO copia el objeto, guarda la REFERENCIA
 * - Cuando haces puerto[0] = null, v1 sigue existiendo
 * - v1 puede estar en bahia mientras puerto[0] es null
 *
 * CONCEPTO CLAVE 3: Sobrecarga de métodos
 * - zarpar(Velero v, int dias) vs zarpar(Velero v)
 * - El segundo llama al primero con dias=5 por defecto
 *
 * CONCEPTO CLAVE 4: Búsqueda en arrays
 * - zarpar() solo funciona si el velero YA ESTÁ en puerto
 * - Si intentas zarpar un velero que no está en puerto, no pasa nada
 *
 * CONCEPTO CLAVE 5: Cálculo acumulativo
 * - costoMantenimiento se ACUMULA en cada llamada a calcularMembresia()
 * - v4: primero 160000, luego 160000 + 360000 = 520000
 *
 * ERRORES COMUNES:
 *
 * Error 1: No trackear costoMembresia como estático
 * - Incorrecto: Pensar que cada velero tiene su propio costoMembresia
 * - Correcto: costoMembresia es UNO SOLO para TODOS
 *
 * Error 2: Confundir puerto y bahía
 * - zarpar: puerto → bahía
 * - atracar: (donde sea) → puerto
 *
 * Error 3: No verificar si velero está en puerto antes de zarpar
 * - zarpar(v2) no hace nada porque v2 nunca fue atracado antes
 *
 * Error 4: Olvidar que costoMantenimiento es acumulativo
 * - Cada llamada a calcularMembresia() SUMA al valor actual
 *
 * ============================================
 * PREGUNTA DE REFLEXIÓN:
 * ============================================
 *
 * 1. ¿Por qué costoMembresia es static?
 *    - Para que todos los veleros compartan el mismo costo de membresía del club
 *
 * 2. ¿Qué pasa si intentas zarpar un velero que ya está en bahía?
 *    - No se encuentra en puerto, entonces no pasa nada
 *
 * 3. ¿Por qué puerto y bahía son arrays públicos?
 *    - En un diseño real deberían ser private con getters
 *    - Aquí es público para simplificar el ejercicio de ruteo
 *
 * 4. ¿Qué error hay en el método imprimir()?
 *    - Línea: if (bahia[i] != null) { System.out.println("null,"); }
 *    - Debería ser: if (bahia[i] == null)
 *    - El código está invertido
 *
 * ============================================
 * RELACIÓN CON EL EXAMEN:
 * ============================================
 *
 * Este ejercicio es una REPLICA EXACTA del Problema 1 del examen 2.
 *
 * En el examen, este problema vale 30 puntos y debes resolverlo en 30-45 minutos.
 *
 * Habilidades que se evalúan:
 * 1. Ruteo de código paso a paso
 * 2. Estado de objetos (atributos, referencias)
 * 3. Variables estáticas compartidas
 * 4. Arrays de objetos
 * 5. Sobrecarga de métodos
 * 6. Lógica de búsqueda en arrays
 *
 * ESTRATEGIA EN EL EXAMEN:
 * 1. [Minutos 0-5] Leer todo el código sin escribir
 * 2. [Minutos 5-10] Crear tabla de estado (objetos, atributos, arrays)
 * 3. [Minutos 10-35] Ejecutar línea por línea del main()
 * 4. [Minutos 35-45] Verificar y escribir respuesta limpia
 *
 * ============================================
 * EJERCICIOS RELACIONADOS:
 * ============================================
 *
 * - Tracing01_Herencia_Constructores.java (más fácil)
 * - Tracing02_Herencia_Polimorfismo.java (similar)
 * - 04_Patrones_Diseno/Tracing01_Strategy_ModoManejo.java (ruteo con patrones)
 *
 * ============================================
 * SOLUCIÓN:
 * ============================================
 *
 * Ver: Soluciones/02_Herencia/Tracing/Tracing03_Solucion.md
 * Incluye tabla completa de ruteo y diagramas de estado
 */
