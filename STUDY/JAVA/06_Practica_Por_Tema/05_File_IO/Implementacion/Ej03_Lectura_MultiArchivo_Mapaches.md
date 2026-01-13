# Ejercicio 3: Sistema de Juego Mapaches Celulares

**Dificultad:** ⭐⭐⭐⭐⭐⭐⭐
**Tiempo estimado:** 90 minutos
**Conceptos:** File I/O múltiple, parsing, matriz 2D, juego por turnos, POO

**REPLICA PARCIAL: Problema 2 del examen real - Examen 2 (70 puntos)**

---

## Contexto

En un mundo paralelo, los mapaches se conocemos como mapaches se comportan de un modo diferente y especial. En primer lugar, su mundo es una cuadrícula, donde cada celda de la cuadrícula tiene una posición dada por una fila y columna, y en cada celda puede vivir un mapache. Cuando el mundo se inicia, los mapaches se crean tomando en cuenta dos archivos:

1. **El archivo `mapaches.txt`** lista todos los mapaches que existen en el mundo, de la siguiente forma:

```
6
2,PEDRO,1500
30,RENATA,2000
501,FRANCISCA,1100
6,CRISTINA,900
```

La primera línea indica la cantidad de mapaches del mundo. Cada línea siguiente especifica a un mapache, indicando su RUT (entero), su nombre (String) y su masa en gramos (entero).

2. **Además, el mundo se inicializa leyendo el archivo `mapaches_posiciones.txt`**, que indica dónde vive cada mapache:

```
5
0,0,0,0,0
0,0,0,30,501
0,0,0,6,2
0,0,0,0,0
0,0,0,0,0
```

El primer número indica la cantidad de filas y columnas del mundo (N). Después, hay N filas, cada una con N columnas, y cada número indica el RUT del mapache que vive en dicha celda (en gramos). **Si el número es CERO, significa que nadie vive ahí.**

---

## Requisitos del Juego

### Reglas del Juego

Lo que sí se puede construir es un juego en que dos jugadores pueden simular lo que pasaría al mover los mapaches por el mundo, y poder saber quién gana el juego. **Las reglas de este juego son simples**:

1. **Existen solo 2 jugadores**, que juegan por turnos, alternadamente. El primer jugador es el **"jugador 0"**, y el segundo jugador es el **"jugador 1"**.

2. **En cada turno de un jugador**, éste hace una acción. Las **acciones posibles** son:
   - **Rendirse**: El jugador se rinde y automáticamente gana el otro jugador.
   - **Mover un mapache**: El jugador debe preguntar por la dirección en la que quiere mover el mapache. Si la dirección de destino es válida (o sea, está dentro del mundo cuadriculado), el mapache se mueve. Pero, si la celda a la que tenía ocupante, los mapaches batallan y solo habrá un ganador: el mapache con mayor masa. Se asume que siempre habrá un ganador (nunca un empate).

   - **Alimentar un mapache**: El jugador gana un 10% de su masa actual.

   - **Ver la información de un mapache**: El jugador puede preguntar por ver información de un mapache en particular.

3. Después que un jugador realiza una acción, su turno termina y le toca al otro jugador realizar una jugada. **El juego continúa hasta que sucede alguna de estas situaciones**:
   - **Un jugador se rinde**: En ese caso, automática gana el otro jugador.
   - **Después de realizada una acción, solo queda un mapache en el mundo**: En ese caso, gana automáticamente el jugador que posee dicho mapache. El

 juego continúa hasta que se cumpla alguna de estas condiciones.

---

## Debe entregar:

- [ ] **Diagrama de dominio (10%)**: Entidades principales y relaciones conceptuales
- [ ] **Diagrama de clases (15%)**: Clases, atributos, métodos, herencia/composición
- [ ] **Código Java (75%)**: Implementación funcional completa

### Clases mínimas sugeridas:

#### Clase Mapache
```java
public class Mapache {
    private int rut;
    private String nombre;
    private int masa; // en gramos
    private int fila;
    private int columna;

    // Constructor, getters, setters
    // Métodos: alimentar(), batallar(Mapache otro), mover(dirección)
}
```

#### Clase Mundo
```java
public class Mundo {
    private int tamaño;
    private Mapache[][] cuadricula;

    // Métodos: cargarMapaches(), cargarPosiciones()
    // moverMapache(), batallar(), verificarGanador()
}
```

#### Clase Juego
```java
public class Juego {
    private Mundo mundo;
    private int jugadorActual; // 0 o 1

    // Métodos: iniciar(), procesarTurno(), cambiarTurno()
    // verificarCondicionVictoria()
}
```

---

## Ejemplo de Ejecución

```
=== JUEGO MAPACHES CELULARES ===

Cargando mapaches desde archivo...
6 mapaches cargados exitosamente.

Cargando posiciones desde archivo...
Mundo 5×5 creado.

Estado inicial del mundo:
[ ][ ][ ][ ][ ]
[ ][ ][ ][30][501]
[ ][ ][ ][6][2]
[ ][ ][ ][ ][ ]
[ ][ ][ ][ ][ ]

=== TURNO DEL JUGADOR 0 ===

Acciones disponibles:
1. Rendirse
2. Mover mapache
3. Alimentar mapache
4. Ver información de mapache

Seleccione acción: 4

Ingrese RUT del mapache: 30

Información de mapache:
RUT: 30
Nombre: RENATA
Masa: 2000 g
Posición: (1, 3)

=== TURNO DEL JUGADOR 1 ===

Acciones disponibles:
1. Rendirse
2. Mover mapache
3. Alimentar mapache
4. Ver información de mapache

Seleccione acción: 2

Ingrese RUT del mapache a mover: 501

Dirección (Norte/Sur/Este/Oeste): Sur

RENATA (30) y FRANCISCA (501) batallan en (2, 4)!
Ganador: FRANCISCA (501) con 1100 g vs 2000 g
RENATA ha sido eliminado del mundo.

=== TURNO DEL JUGADOR 0 ===

[... juego continúa ...]

=== FIN DEL JUEGO ===

¡GANADOR: JUGADOR 1!
Mapache sobreviviente: FRANCISCA (RUT: 501, Masa: 1210 g)
```

---

## Consideraciones Importantes:

1. **File I/O**:
   - Usar Scanner con `new Scanner(new File("ruta"))`
   - Parsear líneas con `.split(",")`
   - Manejar FileNotFoundException con try-catch
   - Cerrar Scanner después de leer

2. **Matriz 2D**:
   - Usar `Mapache[][] cuadricula = new Mapache[n][n]`
   - null en celda significa celda vacía

3. **Batalla**:
   - Mapache con mayor masa gana
   - Mapache perdedor se elimina del mundo (null en cuadricula)

4. **Movimiento**:
   - Norte: fila-1
   - Sur: fila+1
   - Este: columna+1
   - Oeste: columna-1
   - Verificar límites antes de mover

5. **Alimentar**:
   - Aumenta masa en 10%: `masa = masa + (masa * 0.1)`
   - Redondear a entero

6. **Condición de victoria**:
   - Solo queda 1 mapache total
   - Un jugador se rinde

7. **Organización de código**:
   - Usar orientación a objeto
   - Funciones para hacerse la vida más fácil
   - El código fuente debe comprimirse en solo un archivo .zip
   - Archivos .txt NO se revisarán
   - Hojas sin nombre no se revisarán

---

## Pistas (si estás atascado):

<details>
<summary>Pista 1: Leer archivo mapaches.txt</summary>

```java
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.ArrayList;

public ArrayList<Mapache> cargarMapaches(String rutaArchivo) {
    ArrayList<Mapache> mapaches = new ArrayList<>();

    try {
        Scanner scanner = new Scanner(new File(rutaArchivo));

        // Leer cantidad
        int cantidad = scanner.nextInt();
        scanner.nextLine(); // Consumir salto de línea

        // Leer cada mapache
        for (int i = 0; i < cantidad; i++) {
            String linea = scanner.nextLine();
            String[] datos = linea.split(",");

            int rut = Integer.parseInt(datos[0]);
            String nombre = datos[1];
            int masa = Integer.parseInt(datos[2]);

            Mapache m = new Mapache(rut, nombre, masa);
            mapaches.add(m);
        }

        scanner.close();
    } catch (FileNotFoundException e) {
        System.out.println("Error: Archivo no encontrado");
    }

    return mapaches;
}
```
</summary>
</details>

<details>
<summary>Pista 2: Leer archivo mapaches_posiciones.txt y crear matriz</summary>

```java
public void cargarPosiciones(String rutaArchivo, ArrayList<Mapache> mapaches) {
    try {
        Scanner scanner = new Scanner(new File(rutaArchivo));

        // Leer tamaño
        int n = scanner.nextInt();
        scanner.nextLine();

        cuadricula = new Mapache[n][n];

        // Leer matriz
        for (int fila = 0; fila < n; fila++) {
            String linea = scanner.nextLine();
            String[] datos = linea.split(",");

            for (int col = 0; col < n; col++) {
                int rut = Integer.parseInt(datos[col]);

                if (rut != 0) {
                    // Buscar mapache con ese RUT
                    Mapache m = buscarMapachePorRut(mapaches, rut);
                    if (m != null) {
                        m.setPosicion(fila, col);
                        cuadricula[fila][col] = m;
                    }
                }
            }
        }

        scanner.close();
    } catch (FileNotFoundException e) {
        System.out.println("Error: Archivo no encontrado");
    }
}

private Mapache buscarMapachePorRut(ArrayList<Mapache> mapaches, int rut) {
    for (Mapache m : mapaches) {
        if (m.getRut() == rut) {
            return m;
        }
    }
    return null;
}
```
</summary>
</details>

<details>
<summary>Pista 3: Mover mapache con batalla</summary>

```java
public void moverMapache(int rut, String direccion) {
    // 1. Encontrar mapache en cuadricula
    Mapache mapache = null;
    int filaActual = -1, colActual = -1;

    for (int f = 0; f < tamaño; f++) {
        for (int c = 0; c < tamaño; c++) {
            if (cuadricula[f][c] != null && cuadricula[f][c].getRut() == rut) {
                mapache = cuadricula[f][c];
                filaActual = f;
                colActual = c;
                break;
            }
        }
    }

    if (mapache == null) {
        System.out.println("Mapache no encontrado");
        return;
    }

    // 2. Calcular nueva posición
    int nuevaFila = filaActual;
    int nuevaCol = colActual;

    if (direccion.equalsIgnoreCase("Norte")) {
        nuevaFila--;
    } else if (direccion.equalsIgnoreCase("Sur")) {
        nuevaFila++;
    } else if (direccion.equalsIgnoreCase("Este")) {
        nuevaCol++;
    } else if (direccion.equalsIgnoreCase("Oeste")) {
        nuevaCol--;
    }

    // 3. Verificar límites
    if (nuevaFila < 0 || nuevaFila >= tamaño || nuevaCol < 0 || nuevaCol >= tamaño) {
        System.out.println("Movimiento inválido: fuera de límites");
        return;
    }

    // 4. Verificar si hay mapache en destino
    if (cuadricula[nuevaFila][nuevaCol] != null) {
        // BATALLA
        Mapache oponente = cuadricula[nuevaFila][nuevaCol];
        Mapache ganador = batallar(mapache, oponente);

        // Eliminar perdedor
        if (ganador == mapache) {
            cuadricula[nuevaFila][nuevaCol] = mapache;
            cuadricula[filaActual][colActual] = null;
        } else {
            // mapache perdió, se queda donde está oponente
            cuadricula[filaActual][colActual] = null;
        }
    } else {
        // Celda vacía, mover directamente
        cuadricula[nuevaFila][nuevaCol] = mapache;
        cuadricula[filaActual][colActual] = null;
    }

    mapache.setPosicion(nuevaFila, nuevaCol);
}

private Mapache batallar(Mapache m1, Mapache m2) {
    System.out.println(m1.getNombre() + " vs " + m2.getNombre() + " batallan!");

    if (m1.getMasa() > m2.getMasa()) {
        System.out.println("Ganador: " + m1.getNombre());
        return m1;
    } else {
        System.out.println("Ganador: " + m2.getNombre());
        return m2;
    }
}
```
</summary>
</details>

<details>
<summary>Pista 4: Loop principal del juego</summary>

```java
public void iniciar() {
    Scanner scanner = new Scanner(System.in);
    int jugadorActual = 0;
    boolean juegoTerminado = false;

    while (!juegoTerminado) {
        System.out.println("\n=== TURNO DEL JUGADOR " + jugadorActual + " ===");

        System.out.println("1. Rendirse");
        System.out.println("2. Mover mapache");
        System.out.println("3. Alimentar mapache");
        System.out.println("4. Ver información");

        int accion = scanner.nextInt();

        switch (accion) {
            case 1:
                System.out.println("¡Jugador " + jugadorActual + " se rinde!");
                System.out.println("¡Ganador: Jugador " + (1 - jugadorActual) + "!");
                juegoTerminado = true;
                break;

            case 2:
                // Mover mapache
                System.out.print("Ingrese RUT: ");
                int rut = scanner.nextInt();
                scanner.nextLine();
                System.out.print("Dirección: ");
                String dir = scanner.nextLine();
                mundo.moverMapache(rut, dir);
                break;

            case 3:
                // Alimentar mapache
                System.out.print("Ingrese RUT: ");
                rut = scanner.nextInt();
                mundo.alimentarMapache(rut);
                break;

            case 4:
                // Ver información
                System.out.print("Ingrese RUT: ");
                rut = scanner.nextInt();
                mundo.verInformacion(rut);
                break;
        }

        // Verificar condición de victoria
        int mapachesVivos = mundo.contarMapachesVivos();
        if (mapachesVivos == 1) {
            System.out.println("\n¡Solo queda 1 mapache!");
            System.out.println("¡Ganador: Jugador " + jugadorActual + "!");
            juegoTerminado = true;
        }

        // Cambiar turno
        jugadorActual = 1 - jugadorActual; // Alterna entre 0 y 1
    }

    scanner.close();
}
```
</summary>
</details>

---

## Relación con el Examen

Este ejercicio es una **REPLICA PARCIAL del Problema 2 del examen real** (70 puntos).

Es el problema **más complejo y largo** del examen.

**Tiempo asignado en examen**: 2-2.5 horas

### Habilidades evaluadas:
1. File I/O con múltiples archivos
2. Parsing de datos (split, parseInt)
3. Matriz 2D de objetos
4. Lógica de juego (turnos, acciones)
5. POO (clases, métodos, encapsulación)
6. Validaciones (límites, null)
7. Algoritmos (buscar, contar, verificar)

### Errores fatales que debes evitar:
1. ❌ No manejar FileNotFoundException → no compila
2. ❌ No cerrar Scanner → resource leak
3. ❌ IndexOutOfBoundsException en matriz → no valida límites
4. ❌ NullPointerException → no verifica null antes de acceder
5. ❌ Lógica de batalla incorrecta → juego no funciona
6. ❌ No alternar turnos → juego injusto

---

## Checklist de dominio:

- [ ] Puedo leer 2 archivos diferentes con Scanner
- [ ] Puedo parsear CSV con split(",")
- [ ] Entiendo cómo crear y manejar matriz 2D
- [ ] Puedo buscar objeto en matriz por atributo
- [ ] Entiendo lógica de batalla (comparar atributos)
- [ ] Puedo mover objetos en matriz validando límites
- [ ] Entiendo cómo alternar entre jugadores
- [ ] Puedo verificar condiciones de victoria
- [ ] El juego funciona de principio a fin sin errores

---

## Desafíos Adicionales (opcional):

1. **Interfaz gráfica**:
   - Representar mundo con GUI (Swing o JavaFX)

2. **Habilidades especiales**:
   - Mapaches con habilidades únicas

3. **Guardar partida**:
   - Serializar estado del juego

4. **IA simple**:
   - Jugador automático con estrategia básica

5. **Más acciones**:
   - Dividir mapache (crear 2 mapaches más pequeños)
   - Saltar sobre obstáculos

---

**Solución completa**: Ver `Soluciones/05_File_IO_Persistencia/Implementacion/Ej03_Solucion.java`

**Archivos de datos**: Ver `05_File_IO_Persistencia/datos/mapaches.txt` y `mapaches_posiciones.txt`
