# Examen Tipo C - Simulacro Completo

**Duración:** 3 horas (180 minutos)
**Puntaje Total:** 100 puntos
**Dificultad:** ⭐⭐⭐⭐⭐⭐⭐⭐⭐⭐

**REPLICA EXACTA: Examen real completo**
**Universidad de Coquimbo - Escuela de Ingeniería Civil en Computación e Informática**

---

## ⚠️ INSTRUCCIONES IMPORTANTES

### Antes de Comenzar

1. **Tiempo total**: 3 horas (180 minutos)
2. **No consultar**: Internet, apuntes, ni código previo
3. **Solo puedes usar**: Java standard library (no librerías externas)
4. **Materiales permitidos**: Papel, lápiz, calculadora, agua
5. **Entregables**:
   - Diagrama de dominio (papel)
   - Diagrama de clases UML (papel)
   - Código Java (.zip con archivos .java)

### Distribución del Tiempo Recomendada

| Minutos | Actividad | Problema |
|---------|-----------|----------|
| 0-10 | Leer ambos problemas completos | Ambos |
| 10-45 | Resolver Problema 1 (Ruteo) | P1 |
| 45-60 | Leer P2, comprensión profunda | P2 |
| 60-75 | Diagrama de dominio | P2 |
| 75-95 | Diagrama de clases UML | P2 |
| 95-155 | Implementar código | P2 |
| 155-170 | Probar y debuggear | P2 |
| 170-180 | Revisar ambos problemas | Ambos |

### Criterios de Evaluación

- **Problema 1**: 30 puntos (ruteo correcto, claridad en tabla de estado)
- **Problema 2**:
  - Diagrama de dominio: 7 puntos (10%)
  - Diagrama de clases: 10 puntos (15%)
  - Código Java funcional: 53 puntos (75%)

---

## Problema 1: Ruteo de Código - ClubDeYates (30 puntos)

**Tiempo estimado**: 30-45 minutos

### Enunciado

Rutee el siguiente código, graficando qué sucede desde la perspectiva de los objetos involucrados. Por cada instrucción del `main` que genere un cambio, indique cuáles líneas de código fueron las que lo generaron. Puede agrupar instrucciones.

### Código a Rutear

Ver archivo: `Problema1_ClubYates.java`

(El código es idéntico al de `02_Herencia/Tracing/Tracing03_Herencia_ClubYates.java`)

### Qué Entregar

1. **Tabla de ruteo** con las siguientes columnas:
   - Línea del main
   - Objeto/Variable afectada
   - Atributo modificado
   - Valor anterior
   - Valor nuevo
   - Líneas de código que generaron el cambio

2. **Diagrama de estado final** mostrando:
   - Estado del array `puerto`
   - Estado del array `bahia`
   - Valor de `Velero.costoMembresia` (estático)
   - Estado de cada objeto Velero (atributos actuales)

### Consejos

- Lee el código completo 2 veces antes de empezar a rutear
- Presta especial atención a las variables estáticas
- Verifica que las referencias en arrays son correctas
- No olvides que `zarpar()` solo funciona si el velero está en puerto

---

## Problema 2: Juego Mapaches Celulares (70 puntos)

**Tiempo estimado**: 2 horas 15 minutos

### Contexto

En un mundo paralelo, los mapaches conocidos como mapaches se comportan de un modo diferente y especial. En primer lugar, su mundo es una cuadrícula, donde cada celda de la cuadrícula tiene una posición dada por una fila y columna, y en cada celda puede vivir un mapache.

### Archivos de Entrada

#### Archivo 1: `mapaches.txt`

Lista todos los mapaches que existen en el mundo:

```
6
2,PEDRO,1500
30,RENATA,2000
501,FRANCISCA,1100
6,CRISTINA,900
```

- Primera línea: cantidad de mapaches
- Líneas siguientes: RUT, Nombre, Masa (en gramos)

#### Archivo 2: `mapaches_posiciones.txt`

Indica dónde vive cada mapache:

```
5
0,0,0,0,0
0,0,0,30,501
0,0,0,6,2
0,0,0,0,0
0,0,0,0,0
```

- Primera línea: tamaño del mundo (N×N)
- Siguientes N líneas: matriz con RUT de mapaches (0 = celda vacía)

### Reglas del Juego

1. **Dos jugadores** (Jugador 0 y Jugador 1) juegan por turnos alternadamente

2. **Acciones posibles** en cada turno:
   - **Rendirse**: El otro jugador gana automáticamente
   - **Mover mapache**:
     - Elegir dirección (Norte, Sur, Este, Oeste)
     - Si la celda destino tiene otro mapache → batalla
     - En batalla: el de mayor masa gana, el perdedor es eliminado
   - **Alimentar mapache**: Gana 10% de su masa actual
   - **Ver información**: Mostrar datos de un mapache

3. **Condiciones de victoria**:
   - Un jugador se rinde
   - Solo queda 1 mapache en el mundo (gana su dueño)

### Qué Entregar

#### 1. Diagrama de Dominio (10% - 7 puntos)

Identifica las entidades principales del sistema y sus relaciones conceptuales:
- Mapache
- Mundo/Cuadrícula
- Jugador
- Juego

Dibuja en papel las entidades como cajas y las relaciones con flechas etiquetadas (ej: "vive en", "controla", "contiene").

#### 2. Diagrama de Clases UML (15% - 10 puntos)

Diseña la estructura completa del sistema:

**Clases mínimas**:
- `Mapache` (atributos: rut, nombre, masa, fila, columna)
- `Mundo` (atributos: tamaño, cuadricula[][])
- `Juego` (atributos: mundo, jugadorActual)
- Clase principal con `main()`

Para cada clase especifica:
- Nombre de la clase
- Atributos con tipos (private/public)
- Métodos con firma completa (tipo retorno, nombre, parámetros)
- Relaciones entre clases (composición, agregación, asociación)

#### 3. Código Java (75% - 53 puntos)

Implementa el sistema completo con las siguientes características:

**Requisitos funcionales**:
- [ ] Leer archivo `mapaches.txt` correctamente
- [ ] Leer archivo `mapaches_posiciones.txt` correctamente
- [ ] Crear matriz 2D con mapaches en posiciones correctas
- [ ] Implementar movimiento con validación de límites
- [ ] Implementar batalla (mayor masa gana)
- [ ] Implementar alimentación (+10% masa)
- [ ] Implementar ver información
- [ ] Alternar turnos entre jugadores
- [ ] Detectar condición de victoria
- [ ] Manejo de excepciones (FileNotFoundException)

**Requisitos de calidad**:
- Código compilable sin errores
- Uso de orientación a objetos
- Métodos bien organizados
- Variables con nombres descriptivos
- Cerrar recursos (Scanner)

### Consideraciones Técnicas

1. **File I/O**:
```java
Scanner scanner = new Scanner(new File("mapaches.txt"));
try {
    // leer archivo
} catch (FileNotFoundException e) {
    System.out.println("Error: Archivo no encontrado");
} finally {
    scanner.close();
}
```

2. **Parsing**:
```java
String linea = scanner.nextLine();
String[] datos = linea.split(",");
int rut = Integer.parseInt(datos[0]);
```

3. **Matriz 2D**:
```java
Mapache[][] cuadricula = new Mapache[n][n];
cuadricula[fila][columna] = mapache; // asignar
cuadricula[fila][columna] = null; // eliminar
```

4. **Batalla**:
```java
if (mapache1.getMasa() > mapache2.getMasa()) {
    // mapache1 gana, eliminar mapache2
} else {
    // mapache2 gana, eliminar mapache1
}
```

5. **Alimentación**:
```java
int masaActual = mapache.getMasa();
int nuevaMasa = (int)(masaActual * 1.1); // +10%
mapache.setMasa(nuevaMasa);
```

### Archivos de Datos

Los archivos `mapaches.txt` y `mapaches_posiciones.txt` están disponibles en la carpeta `datos/` del examen.

**IMPORTANTE**:
- Los archivos .txt NO se revisarán
- Solo se evalúa el código .java
- Comprimir todo en un solo archivo .zip
- Hojas sin nombre no se revisarán

---

## Entrega del Examen

### Formato de Entrega

1. **Diagramas** (papel):
   - Diagrama de dominio en hoja separada
   - Diagrama de clases UML en hoja(s) separada(s)
   - Ambos con nombre y RUT

2. **Código** (.zip):
   - Crear carpeta con tu nombre: `Apellido_Nombre/`
   - Incluir todos los archivos `.java`
   - NO incluir archivos `.class`
   - NO incluir carpetas de IDE (.idea, .vscode, etc.)
   - Comprimir en `Apellido_Nombre.zip`

### Ejemplo de Estructura del .zip

```
Perez_Juan.zip
├── Mapache.java
├── Mundo.java
├── Juego.java
└── Main.java
```

---

## Checklist Pre-Entrega (Muy Importante)

Antes de entregar, verifica:

### Problema 1 (Ruteo)
- [ ] Tabla de ruteo completa con todas las columnas
- [ ] Estado final de arrays puerto y bahía
- [ ] Valor final de Velero.costoMembresia
- [ ] Identificadas todas las líneas que generan cambios
- [ ] Nombre y RUT en la hoja

### Problema 2 (Mapaches)
- [ ] Diagrama de dominio dibujado y etiquetado
- [ ] Diagrama de clases UML completo (atributos + métodos)
- [ ] Código compila sin errores (`javac *.java`)
- [ ] Probado con archivos de datos proporcionados
- [ ] Archivos cerrados correctamente (scanner.close())
- [ ] Excepciones manejadas (try-catch FileNotFoundException)
- [ ] Código comentado en partes clave
- [ ] Archivos .java comprimidos en .zip
- [ ] Sin archivos .class ni carpetas de IDE
- [ ] Nombre y RUT en diagramas

---

## Estrategia de Resolución

### Problema 1 (30-45 minutos)

1. **[Minutos 0-5]** Leer código completo 2 veces sin escribir
2. **[Minutos 5-10]** Crear tabla de estado (objetos, atributos, arrays)
3. **[Minutos 10-35]** Ejecutar mentalmente línea por línea del main()
4. **[Minutos 35-45]** Verificar y dibujar estado final

### Problema 2 (2 horas 15 minutos)

1. **[Minutos 45-60]** Leer enunciado 3 veces, entender reglas
2. **[Minutos 60-75]** Diagrama de dominio (entidades, relaciones)
3. **[Minutos 75-95]** Diagrama de clases (atributos, métodos, relaciones)
4. **[Minutos 95-105]** Planificar estructura de código
5. **[Minutos 105-125]** Implementar clases base (Mapache, Mundo)
6. **[Minutos 125-140]** Implementar File I/O
7. **[Minutos 140-155]** Implementar lógica del juego
8. **[Minutos 155-170]** Probar con datos de ejemplo, debuggear
9. **[Minutos 170-180]** Revisar checklist, comentar código, empaquetar

---

## Errores Fatales a Evitar

### Que Causan 0 Puntos

1. ❌ Código que NO compila
2. ❌ No entregar diagramas
3. ❌ No usar File I/O (hardcodear datos)
4. ❌ Entregar solo parcialmente (ej: solo Problema 1)

### Que Quitan Muchos Puntos

5. ❌ No manejar FileNotFoundException (-10 pts)
6. ❌ No cerrar Scanner (-5 pts)
7. ❌ Lógica de batalla incorrecta (-15 pts)
8. ❌ No validar límites de matriz (-10 pts)
9. ❌ No alternar turnos correctamente (-10 pts)
10. ❌ Diagramas incompletos o incorrectos (-15 pts)

---

## Material de Apoyo

### Ejercicios de Práctica

Antes de hacer este examen, practica:

1. `02_Herencia/Tracing/Tracing03_Herencia_ClubYates.java` (Problema 1)
2. `05_File_IO_Persistencia/Implementacion/Ej03_Lectura_MultiArchivo_Mapaches.md` (Problema 2)
3. `01_Recursion/Tracing/Tracing03_MathPow.java` (ruteo con recursión)
4. `05_File_IO_Persistencia/Implementacion/Ej02_Parsing_CSV_Estudiantes.md` (parsing básico)

### Recursos Útiles

- `GUIA_PREPARACION_EXAMEN.md` - Estrategias detalladas
- `REFERENCIA_RAPIDA.md` - Sintaxis Java
- `ERRORES_COMUNES.md` - Troubleshooting

---

## Simulación del Examen

Para practicar en condiciones reales:

1. **Imprime este enunciado**
2. **Prepara los archivos de datos** (`mapaches.txt`, `mapaches_posiciones.txt`)
3. **Configura temporizador de 3 horas**
4. **Desconecta internet**
5. **Cierra apuntes y referencias**
6. **Solo usa Java estándar (sin IDE autocompletion)**
7. **Resuelve ambos problemas**
8. **Al terminar, compara con solución**

---

## Después del Examen

Una vez terminado el simulacro:

1. **Compara tu solución** con `SOLUCION.md`
2. **Anota conceptos difíciles** que necesitas reforzar
3. **Calcula tu puntaje estimado** usando la rúbrica
4. **Revisa errores comunes** que cometiste
5. **Practica de nuevo** los conceptos débiles

---

**¡Éxito en tu examen! 🎯**

---

**Archivos del examen**:
- `Problema1_ClubYates.java` - Código a rutear
- `datos/mapaches.txt` - Datos de mapaches
- `datos/mapaches_posiciones.txt` - Posiciones iniciales
- `SOLUCION.md` - Solución completa (ver después de intentar)
