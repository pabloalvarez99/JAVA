# GUIA DEFINITIVA DEL SISTEMA DE CHAT EN JAVA
## Documentacion Completa y Profesional

---

## TABLA DE CONTENIDOS

1. [Introduccion](#introduccion)
2. [Descripcion del Sistema](#descripcion)
3. [Conceptos Fundamentales de Java](#conceptos)
4. [Arquitectura del Sistema](#arquitectura)
5. [Clases del Sistema](#clases)
6. [Funcionalidades Principales](#funcionalidades)
7. [Algoritmos Implementados](#algoritmos)
8. [Ejecucion del Programa](#ejecucion)
9. [Guia de Estudio](#estudio)

---

## 1. INTRODUCCION {#introduccion}

Este sistema de chat es una aplicacion de consola desarrollada en Java que gestiona usuarios, conversaciones y mensajes. El codigo que tienes fue desarrollado previamente y esta documentado para facilitar tu comprension completa del sistema.

### Proposito de esta Documentacion

Esta guia te ayudara a entender completamente el funcionamiento del sistema, los conceptos de Java aplicados y las decisiones de diseno implementadas. Esta dirigida especificamente a estudiantes que NO escribieron el codigo original.

### Estructura de Archivos

**Codigo Java (con comentarios detallados):**
- `Usuario.java` - Representa un usuario del sistema
- `Mensaje.java` - Representa un mensaje enviado
- `Chat.java` - Representa una conversacion
- `Main.java` - Punto de entrada y logica principal

**Archivos de Datos:**
- `users.txt` - Base de datos de usuarios (formato CSV)
- `chats.txt` - Base de datos de chats (formato CSV)
- `msj.txt` - Base de datos de mensajes (formato CSV)

---

## 2. DESCRIPCION DEL SISTEMA {#descripcion}

### Que Hace el Sistema

El sistema permite:
- Gestionar usuarios con identificacion unica
- Crear chats con multiples participantes
- Almacenar y ordenar mensajes cronologicamente
- Ver conversaciones completas
- Analizar estadisticas de uso
- Editar propiedades de chats
- Enviar mensajes a multiples chats

### Flujo General del Programa

```
1. Inicio del programa (java Main)
2. Carga de datos desde archivos
   - Usuarios (users.txt)
   - Chats (chats.txt)
   - Mensajes (msj.txt)
3. Presentacion del menu interactivo
4. Ejecucion de funcionalidades
5. Retorno al menu (bucle)
6. Salida del programa
```

---

## 3. CONCEPTOS FUNDAMENTALES DE JAVA {#conceptos}

### 3.1 Clases y Objetos

**Clase:** Plantilla o molde que define la estructura y comportamiento de un tipo de objeto.

**Objeto:** Instancia concreta de una clase con datos especificos.

**Ejemplo:**
```java
// Clase (el molde)
class Usuario {
    private final int id;
    private final String nombreUsuario;
    // ... constructor y metodos
}

// Objetos (instancias concretas)
Usuario juan = new Usuario(1, "Juan", "juan@mail.com");
Usuario maria = new Usuario(2, "Maria", "maria@mail.com");
```

### 3.2 Modificadores de Acceso

- **private:** Solo accesible dentro de la misma clase
- **public:** Accesible desde cualquier parte del programa
- **protected:** Accesible desde subclases y mismo paquete
- **(default):** Accesible solo dentro del mismo paquete

El sistema usa correctamente `private` para atributos y `public` para metodos de acceso (encapsulamiento).

### 3.3 Inmutabilidad (final)

**final** indica que un valor no puede cambiar despues de su inicializacion.

**Ejemplo:**
```java
private final int id;  // Una vez asignado, nunca cambia
```

**Ventajas:**
- Seguridad en entornos concurrentes
- Previsibilidad del codigo
- Previene modificaciones accidentales

### 3.4 Modificador static

**static** indica que un elemento pertenece a la clase, no a instancias individuales.

**Ejemplo:**
```java
private static List<Usuario> usuarios;  // Compartida por todo el programa
```

**Uso en Main.java:**
- Datos globales del sistema
- Metodos utilitarios que no requieren instancia

### 3.5 Colecciones: ArrayList

**ArrayList** es una lista dinamica que puede crecer o reducirse automaticamente.

**Diferencias con arrays:**
```java
// Array: tamano fijo
String[] nombres = new String[5];  // Exactamente 5 elementos

// ArrayList: tamano dinamico
List<String> nombres = new ArrayList<>();  // Crece segun necesidad
nombres.add("Juan");
nombres.add("Maria");
```

---

## 4. ARQUITECTURA DEL SISTEMA {#arquitectura}

### Diagrama de Componentes

```
┌─────────────────────────────────────┐
│          Main.java                  │
│    (Controlador Principal)          │
│                                     │
│  - Carga datos de archivos          │
│  - Gestiona menu y opciones         │
│  - Coordina todas las operaciones   │
└────────────┬────────────────────────┘
             │ utiliza
             ↓
┌────────────────────────────────────────┐
│          Usuario.java                  │
│     (Modelo de Usuario)                │
│                                        │
│  Atributos: id, nombreUsuario, email  │
│  Caracteristica: INMUTABLE (final)    │
└────────────────────────────────────────┘
             │ usado por
             ↓
┌────────────────────────────────────────┐
│          Mensaje.java                  │
│      (Modelo de Mensaje)               │
│                                        │
│  Atributos: id, chat, fecha,          │
│             remitente, contenido       │
│  Caracteristica: INMUTABLE (final)    │
└────────────────────────────────────────┘
             │ pertenece a
             ↓
┌────────────────────────────────────────┐
│          Chat.java                     │
│      (Modelo de Chat)                  │
│                                        │
│  Atributos: id, titulo,               │
│             participantes, mensajes    │
│  Caracteristica: MUTABLE              │
│  Metodos: agregar participantes,      │
│           agregar mensajes,           │
│           ordenar por fecha           │
└────────────────────────────────────────┘
```

### Relaciones Entre Clases

- Un **Chat** contiene muchos **Usuarios** (participantes)
- Un **Chat** contiene muchos **Mensajes**
- Un **Mensaje** tiene un **Usuario** remitente
- Un **Mensaje** pertenece a un **Chat**

---

## 5. CLASES DEL SISTEMA {#clases}

### 5.1 Clase Usuario

**Responsabilidad:** Representar a una persona que usa el sistema.

**Atributos:**
```java
private final int id;              // Identificador unico
private final String nombreUsuario; // Nombre o nickname
private final String email;        // Correo electronico
```

**Metodos Principales:**
- `Usuario(int, String, String)` - Constructor
- `getId()` - Obtener ID
- `getNombreUsuario()` - Obtener nombre
- `getEmail()` - Obtener email
- `toString()` - Representacion textual

**Caracteristica Clave:** Completamente inmutable. Una vez creado, no puede modificarse.

### 5.2 Clase Mensaje

**Responsabilidad:** Representar un mensaje enviado en un chat.

**Atributos:**
```java
private final int id;              // Identificador unico
private final Chat chat;           // Chat al que pertenece
private final String fecha;        // Fecha y hora de envio
private final Usuario remitente;   // Quien envio el mensaje
private final String contenido;    // Texto del mensaje
```

**Metodos Principales:**
- `Mensaje(int, Chat, String, Usuario, String)` - Constructor
- `getId()`, `getChat()`, `getFecha()`, `getRemitente()`, `getContenido()` - Getters
- `toString()` - Formato: `[fecha] remitente: contenido`

**Caracteristica Clave:** Inmutable. Los mensajes no se editan despues de enviados.

### 5.3 Clase Chat

**Responsabilidad:** Representar una conversacion o grupo de chat.

**Atributos:**
```java
private final int id;                      // Identificador unico
private String titulo;                     // Nombre del chat (modificable)
private List<Usuario> participantes;       // Lista de usuarios
private List<Mensaje> mensajes;            // Lista de mensajes
```

**Metodos Principales:**

**Gestion de Participantes:**
- `addParticipante(Usuario u)` - Agregar usuario al chat
- `contieneUsuario(int id)` - Verificar si usuario participa
- `getParticipantes()` - Obtener array de participantes

**Gestion de Mensajes:**
- `agregarMensaje(Mensaje m)` - Agregar mensaje
- `getMensajes()` - Obtener array de mensajes
- `mensajesOrdenadosPorFecha()` - Obtener mensajes ordenados cronologicamente

**Otros:**
- `getTitulo()`, `setTitulo(String)` - Obtener/modificar titulo
- `toString()` - Informacion resumida del chat

**Caracteristica Clave:** Mutable. Permite agregar participantes y mensajes dinamicamente.

### 5.4 Clase Main

**Responsabilidad:** Controlar todo el flujo del programa.

**Atributos Estaticos:**
```java
private static List<Usuario> usuarios;  // Todos los usuarios del sistema
private static List<Chat> chats;        // Todos los chats del sistema
private static int maxMensajeId;        // Control de IDs de mensajes
```

**Metodos de Carga:**
- `cargarUsuarios(String path)` - Leer users.txt
- `cargarChats(String path)` - Leer chats.txt
- `cargarMensajes(String path)` - Leer msj.txt

**Metodos del Menu:**
- `verChat(Scanner)` - Opcion 1: Ver conversacion completa
- `top3Usuarios()` - Opcion 2: Usuarios mas activos
- `top3Horas()` - Opcion 3: Horas con mas mensajes
- `editarChat(Scanner)` - Opcion 4: Modificar chat
- `enviarMensajeVariosChats(Scanner)` - Opcion 5: Mensaje multiple

**Metodos Auxiliares:**
- `findUsuarioById(int)` - Buscar usuario por ID
- `findChatById(int)` - Buscar chat por ID
- `parseIntSeguro(String)` - Conversion segura a entero
- `leerEntero(Scanner)` - Lectura validada de enteros

---

## 6. FUNCIONALIDADES PRINCIPALES {#funcionalidades}

### 6.1 Ver Chat (Opcion 1)

**Proposito:** Mostrar todos los participantes y mensajes de un chat.

**Flujo:**
1. Mostrar lista de chats disponibles
2. Solicitar ID del chat a visualizar
3. Validar que el chat exista
4. Mostrar titulo y participantes
5. Obtener mensajes ordenados por fecha
6. Mostrar cada mensaje con formato

**Salida Ejemplo:**
```
Titulo: Amigos
Participantes:
  - 1 - Juan (juan@mail.com)
  - 2 - Maria (maria@mail.com)
Mensajes (ordenados por fecha):
  [14:30 15/10/2023] Juan: Hola a todos
  [14:32 15/10/2023] Maria: Hola Juan!
```

### 6.2 Top 3 Usuarios (Opcion 2)

**Proposito:** Identificar los usuarios mas activos del sistema.

**Algoritmo:**
1. Crear array de contadores (uno por usuario)
2. Recorrer todos los chats y mensajes
3. Incrementar contador del remitente de cada mensaje
4. Ordenar usuarios por cantidad de mensajes (Selection Sort, descendente)
5. Mostrar los 3 primeros

**Complejidad:** O(c × m + n²) donde c=chats, m=mensajes, n=usuarios

### 6.3 Top 3 Horas (Opcion 3)

**Proposito:** Identificar las horas del dia con mas actividad.

**Algoritmo:**
1. Crear array de 24 posiciones (una por hora del dia)
2. Recorrer todos los mensajes
3. Extraer hora de cada mensaje
4. Incrementar contador de esa hora
5. Ordenar horas por cantidad de mensajes
6. Mostrar las 3 primeras

### 6.4 Editar Chat (Opcion 4)

**Proposito:** Modificar propiedades de un chat existente.

**Opciones:**
- **a) Cambiar titulo:** Modificar el nombre del chat
- **b) Agregar usuario:** Incluir nuevo participante

**Validaciones:**
- Titulo no puede estar vacio
- Usuario debe existir en el sistema
- Usuario no debe estar ya en el chat

### 6.5 Enviar Mensaje a Varios Chats (Opcion 5)

**Proposito:** Distribuir el mismo mensaje a multiples chats.

**Validacion Critica:** El usuario remitente DEBE ser participante de TODOS los chats seleccionados. Si no cumple esta condicion, la operacion se cancela completamente.

**Flujo:**
1. Solicitar ID del remitente
2. Solicitar contenido del mensaje
3. Solicitar fecha
4. Solicitar IDs de chats (terminar con -1)
5. VALIDAR que el usuario participe en todos los chats
6. Si valida, crear el mensaje en cada chat
7. Confirmar operacion

---

## 7. ALGORITMOS IMPLEMENTADOS {#algoritmos}

### 7.1 Insertion Sort (Ordenamiento por Insercion)

**Ubicacion:** Chat.java - `mensajesOrdenadosPorFecha()`

**Proposito:** Ordenar mensajes cronologicamente.

**Como Funciona:**
1. Dividir array en parte ordenada (izquierda) y sin ordenar (derecha)
2. Tomar elemento de la parte sin ordenar
3. Insertarlo en su posicion correcta en la parte ordenada
4. Repetir hasta completar

**Analogia:** Como ordenar cartas en tu mano - tomas cada carta y la colocas donde corresponde.

**Complejidad Temporal:**
- Mejor caso: O(n) - lista ya ordenada
- Peor caso: O(n²) - lista ordenada al reves
- Caso promedio: O(n²)

**Ventajas:**
- Simple de implementar
- Eficiente para listas pequenas
- Estable (mantiene orden relativo de elementos iguales)

### 7.2 Selection Sort (Ordenamiento por Seleccion)

**Ubicacion:** Main.java - `top3Usuarios()`

**Proposito:** Ordenar usuarios por cantidad de mensajes.

**Como Funciona:**
1. Encontrar el elemento maximo en la parte sin ordenar
2. Intercambiarlo con el primer elemento de esa parte
3. Reducir la parte sin ordenar
4. Repetir hasta completar

**Analogia:** Como seleccionar al estudiante mas alto - lo encuentras y lo pones al frente, luego repites con los restantes.

**Complejidad Temporal:**
- Todos los casos: O(n²)

**Ventajas:**
- Simple de implementar
- Minimo numero de intercambios
- No requiere memoria adicional

### 7.3 Busqueda Lineal

**Ubicacion:** Multiple metodos en Main.java

**Proposito:** Encontrar elementos en listas no ordenadas.

**Como Funciona:**
1. Recorrer la coleccion elemento por elemento
2. Comparar cada elemento con el buscado
3. Retornar al encontrar coincidencia
4. Retornar null/-1 si no se encuentra

**Ejemplos en el Codigo:**
```java
private static Usuario findUsuarioById(int id) {
    for (Usuario u : usuarios) {
        if (u.getId() == id) return u;
    }
    return null;
}
```

**Complejidad Temporal:**
- Mejor caso: O(1) - elemento al inicio
- Peor caso: O(n) - elemento al final o no existe
- Caso promedio: O(n)

### 7.4 Comparacion de Fechas

**Problema:** Las fechas estan almacenadas como String en formato "hh:mm dd/MM/yyyy"

**Solucion:** Convertir a formato comparable antes de ordenar.

**Metodo claveFecha():**
```java
"14:30 15/10/2023" → "202310151430"
```

**Por que Funciona:**
- Formato yyyyMMddhhmm permite comparacion lexicografica correcta
- Componentes mas significativos (anio, mes, dia) aparecen primero
- Comparacion de strings funciona correctamente

---

## 8. EJECUCION DEL PROGRAMA {#ejecucion}

### Requisitos

- Java JDK 11 o superior
- Archivos de datos en el mismo directorio:
  - `users.txt`
  - `chats.txt`
  - `msj.txt`

### Compilacion

Abrir terminal en el directorio del proyecto:

```bash
cd C:\Users\Pablo\Documents\Build\1
javac Usuario.java Mensaje.java Chat.java Main.java
```

### Ejecucion

```bash
java Main
```

### Formato de Archivos de Datos

**users.txt:**
```
id,nombreUsuario,email
1,Juan,juan@mail.com
2,Maria,maria@mail.com
```

**chats.txt:**
```
chatId,titulo,participante1,participante2,...
1,Amigos,1,2,3
2,Trabajo,1,2
```

**msj.txt:**
```
mensajeId,chatId,fecha,remitenteId,contenido
1,1,14:30 15/10/2023,1,Hola a todos
2,1,14:32 15/10/2023,2,Hola Juan!
```

### Ejemplo de Interaccion

```
=== MENU CHAT ===
1) Ver Chat
2) Top 3 usuarios por mensajes enviados
3) Top 3 horas con más mensajes
4) Editar chat (cambiar título / agregar usuario)
5) Enviar un mensaje a varios chats
0) Salir
Opción: 1

Chats:
1 - Amigos (participantes: 3, mensajes: 5)
2 - Trabajo (participantes: 2, mensajes: 10)

Ingrese ID del chat a ver: 1

Titulo: Amigos
Participantes:
  - 1 - Juan (juan@mail.com)
  - 2 - Maria (maria@mail.com)
  - 3 - Pedro (pedro@mail.com)
Mensajes (ordenados por fecha):
  [14:30 15/10/2023] Juan: Hola a todos
  [14:32 15/10/2023] Maria: Como estan?
  [15:00 15/10/2023] Pedro: Bien gracias!
```

---

## 9. GUIA DE ESTUDIO {#estudio}

### Rutas de Aprendizaje

#### NIVEL 1: Principiante Total

**Objetivo:** Entender los fundamentos de Java y POO

**Orden de Estudio:**
1. Leer esta guia completamente (secciones 1-3)
2. Estudiar Usuario.java con todos sus comentarios
3. Estudiar Mensaje.java
4. Estudiar Chat.java
5. Estudiar Main.java

**Tiempo estimado:** 2-3 semanas (1-2 horas diarias)

**Conceptos a dominar:**
- Clases y objetos
- Atributos y metodos
- Constructores
- Modificadores de acceso
- final vs no-final
- ArrayList basico

#### NIVEL 2: Con Conocimientos Basicos

**Objetivo:** Entender el sistema completo y algoritmos

**Orden de Estudio:**
1. Leer secciones 4-7 de esta guia
2. Leer los archivos .java en orden
3. Enfocarse en los algoritmos de ordenamiento
4. Analizar el flujo del programa completo

**Tiempo estimado:** 1 semana

**Conceptos a dominar:**
- Relaciones entre clases
- Algoritmos de ordenamiento
- Manejo de archivos
- Validaciones
- Try-catch

#### NIVEL 3: Desarrollador Intermedio

**Objetivo:** Analisis critico y mejoras

**Orden de Estudio:**
1. Revisar decisiones de diseno
2. Analizar complejidad de algoritmos
3. Identificar mejoras posibles
4. Proponer extensiones del sistema

**Tiempo estimado:** 2-3 dias

**Conceptos a dominar:**
- Patrones de diseno aplicados
- Complejidad algoritmica
- Optimizaciones posibles
- Alternativas de implementacion

### Ejercicios Practicos Sugeridos

#### Nivel Basico
1. Agregar un getter adicional en Usuario
2. Modificar el formato de toString() en alguna clase
3. Cambiar el orden de opciones en el menu

#### Nivel Intermedio
4. Implementar metodo para eliminar un participante de un chat
5. Agregar validacion de formato de email en Usuario
6. Crear metodo para buscar usuarios por nombre (no solo ID)

#### Nivel Avanzado
7. Implementar busqueda de mensajes por contenido
8. Agregar persistencia: guardar cambios en archivos
9. Implementar QuickSort como alternativa de ordenamiento
10. Crear sistema de notificaciones de mensajes

### Conceptos Clave que Debes Dominar

**Fundamentos:**
- Diferencia entre clase y objeto
- Encapsulamiento y modificadores de acceso
- Inmutabilidad con final
- Referencias vs valores primitivos

**Intermedio:**
- ArrayList y operaciones basicas
- Lectura de archivos con BufferedReader
- Manejo de excepciones con try-catch
- Algoritmos de ordenamiento O(n²)

**Avanzado:**
- Complejidad algoritmica (Big O)
- Programacion defensiva (validaciones)
- Conversion entre List y Array
- Try-with-resources

### Recursos Adicionales

**Documentacion Oficial:**
- Oracle Java Tutorials: https://docs.oracle.com/javase/tutorial/
- Java API Documentation: https://docs.oracle.com/en/java/javase/17/docs/api/

**Plataformas de Practica:**
- HackerRank - Java track
- LeetCode - Problemas de algoritmos
- Codewars - Katas de Java

**Libros Recomendados:**
- "Head First Java" - Kathy Sierra & Bert Bates
- "Effective Java" - Joshua Bloch
- "Clean Code" - Robert C. Martin

---

## CONCLUSIONES

Este sistema de chat representa un proyecto completo que integra conceptos fundamentales de Java:

**Fortalezas del Diseno:**
- Separacion clara de responsabilidades
- Encapsulamiento correcto
- Uso apropiado de inmutabilidad
- Validaciones defensivas
- Codigo bien estructurado

**Conceptos Aplicados:**
- Programacion Orientada a Objetos (POO)
- Estructuras de datos (ArrayList, arrays)
- Algoritmos de ordenamiento y busqueda
- Manejo de archivos (I/O)
- Manejo de excepciones
- Validacion de datos

**Oportunidades de Mejora:**
- Usar HashMap para busquedas O(1)
- Implementar algoritmos mas eficientes (O(n log n))
- Agregar persistencia de cambios
- Usar LocalDateTime en lugar de String para fechas
- Implementar interfaces para abstracciones

### Palabras Finales

La comprension completa de este sistema te proporciona una base solida en Java. Los conceptos aqui aplicados son fundamentales para el desarrollo de software profesional en Data Science, DevOps y Software Engineering.

**Recuerda:**
- La programacion se aprende haciendo, no solo leyendo
- Experimenta modificando el codigo
- No temas cometer errores - son parte del aprendizaje
- La practica constante es la clave del dominio

**Proximos Pasos:**
1. Ejecuta el programa y prueba todas las funcionalidades
2. Modifica el codigo para agregar nuevas caracteristicas
3. Implementa los ejercicios sugeridos
4. Crea tu propio proyecto similar desde cero

---

**Documento creado para:** Pablo
**Fecha:** Noviembre 2025
**Proposito:** Documentacion definitiva del Sistema de Chat en Java para estudiantes

---

*Esta documentacion consolida y reemplaza todos los documentos previos. Contiene toda la informacion esencial para comprender, ejecutar y extender el sistema.*
