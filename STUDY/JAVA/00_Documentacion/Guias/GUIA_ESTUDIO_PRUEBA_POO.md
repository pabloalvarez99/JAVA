# GUÍA DE ESTUDIO - PRUEBA DE PROGRAMACIÓN ORIENTADA A OBJETOS

## ANÁLISIS DE LA PRUEBA

La prueba consta de 2 problemas principales:

### **Problema 1: Ruteo de Código (0.33 puntos)**
Requiere seguir la ejecución de un programa que implementa una lista enlazada circular de estaciones de metro/tren.

### **Problema 2: Sistema de Chat (0.67 puntos)**
Desarrollar un sistema completo de chat con usuarios, chats y mensajes, incluyendo:
- Lectura de archivos de texto
- Gestión de datos con arreglos
- Menú interactivo con múltiples funcionalidades
- Manipulación de fechas
- Ordenamiento de datos
- Estadísticas y análisis de datos

---

## PARTE 1: CONCEPTOS FUNDAMENTALES DE JAVA

### 1. SINTAXIS BÁSICA Y ESTRUCTURA DEL PROGRAMA

#### 1.1 Estructura de una Clase Java
```java
public class NombreClase {
    // Atributos
    // Constructores
    // Métodos
}
```

**Por qué lo necesitas:**
- El Problema 1 tiene tres clases: `App`, `Station`, `Line`
- El Problema 2 requiere crear clases: `Usuario`, `Chat`, `Mensaje`

#### 1.2 Método Main
```java
public static void main(String[] args) {
    // Punto de entrada del programa
}
```

**Por qué lo necesitas:**
- Ambos problemas requieren un punto de inicio para la ejecución
- El Problema 2 necesita un menú que se ejecuta desde el main

#### 1.3 Modificadores de Acceso
- `public`: Accesible desde cualquier clase
- `private`: Accesible solo dentro de la clase
- `protected`: Accesible en la clase y subclases

**Por qué lo necesitas:**
- El Problema 1 usa `private` para atributos: `private String name`, `private Station previousStation`
- El Problema 2 requiere encapsulación apropiada de datos de Usuario, Chat y Mensaje

---

### 2. TIPOS DE DATOS Y VARIABLES

#### 2.1 Tipos Primitivos
```java
int numero = 10;           // Números enteros
boolean esVerdadero = true; // Valores booleanos
```

**Aplicación en la prueba:**
- Problema 1: `int number` (línea 57), `int stationCount` (línea 65), `int i` (línea 71)
- Problema 2: Necesitas `int` para IDs de usuarios, chats y mensajes

#### 2.2 Tipos de Referencia
```java
String texto = "Hola";
String[] arreglo = new String[10];
```

**Aplicación en la prueba:**
- Problema 1: `String name`, `String[] stationNames`, `String[] args`
- Problema 2: `String nombreUsuario`, `String correo`, `String contenido`, `String titulo`

#### 2.3 Arreglos (Arrays)
```java
// Declaración e inicialización
String[] nombres = new String[5];
int[] numeros = {1, 2, 3, 4, 5};

// Acceso y modificación
nombres[0] = "Juan";
int longitud = nombres.length;
```

**Aplicación en la prueba:**
- Problema 1: `String[] stationNames` (línea 64) - arreglo de nombres de estaciones
- Problema 2: "Debe tener un arreglo principal de Usuarios y uno de Chats"

---

### 3. ESTRUCTURAS DE CONTROL

#### 3.1 Condicionales IF-ELSE
```java
if (condicion) {
    // código si es verdadero
} else if (otraCondicion) {
    // código si otra condición es verdadera
} else {
    // código si ninguna condición es verdadera
}
```

**Aplicación en la prueba:**
- Problema 1:
  - Línea 66-67: `if (stationCount < 3) { throw new IllegalArgumentException(...); }`
  - Línea 103: `if (aux.getName().equals(station)) { return aux; }`
  - Línea 125: `if (aux.getInterchange() == null) { aux = aux.getNextStation(); }`
- Problema 2: Validar que el usuario pertenece a todos los chats antes de enviar mensaje

#### 3.2 Bucles (Loops)

**Bucle FOR tradicional:**
```java
for (int i = 0; i < 10; i++) {
    // código que se repite
}
```

**Aplicación en la prueba:**
- Problema 1: Línea 71-74: Crear estaciones en un bucle
```java
for (int i = 1; i < stationNames.length - 1; i++) {
    aux.setNextStation(new Station(stationNames[i]));
    aux.getNextStation().setPreviousStation(aux);
    aux = aux.getNextStation();
}
```

**Bucle WHILE:**
```java
while (condicion) {
    // código mientras la condición sea verdadera
}
```

**Aplicación en la prueba:**
- Problema 1:
  - Línea 83: `while (aux.getNextStation() != null)`
  - Línea 93: `while (aux.getPreviousStation() != null)`
  - Línea 102: `while (aux.getNextStation() != null)`
  - Línea 123: `while (aux.getNextStation() != null && stationCounter < stops - 1)`
- Problema 2: Recorrer arreglos de usuarios, chats, mensajes

#### 3.3 Try-Catch (Manejo de Excepciones)
```java
try {
    // código que puede lanzar una excepción
} catch (TipoExcepcion e) {
    // código para manejar la excepción
}
```

**Aplicación en la prueba:**
- Problema 1: Línea 19-21: Captura de Exception y uso de `getMessage()`
```java
} catch (Exception e) {
    System.out.println(e.getMessage());
}
```
- Problema 2: Manejar errores al leer archivos

---

### 4. ENTRADA/SALIDA (I/O)

#### 4.1 Salida por Consola
```java
System.out.println("Texto con salto de línea");
System.out.print("Texto sin salto de línea");
```

**Aplicación en la prueba:**
- Problema 1: Múltiples líneas de impresión (81, 84, 87, 88, 91, 94, 97, 98, etc.)
- Problema 2: Mostrar menú, resultados, mensajes de chat

#### 4.2 Lectura de Archivos de Texto
```java
import java.io.*;
import java.util.Scanner;

// Opción 1: BufferedReader
BufferedReader br = new BufferedReader(new FileReader("archivo.txt"));
String linea = br.readLine();
br.close();

// Opción 2: Scanner
Scanner scanner = new Scanner(new File("archivo.txt"));
while (scanner.hasNextLine()) {
    String linea = scanner.nextLine();
}
scanner.close();
```

**Aplicación en la prueba:**
- Problema 2: Leer tres archivos: `users.txt`, `chats.txt`, `msj.txt`

#### 4.3 Entrada por Consola (Scanner)
```java
import java.util.Scanner;

Scanner scanner = new Scanner(System.in);
String texto = scanner.nextLine();
int numero = scanner.nextInt();
scanner.close();
```

**Aplicación en la prueba:**
- Problema 2: Leer opciones del menú, IDs de usuarios, contenido de mensajes, etc.

---

### 5. MANIPULACIÓN DE STRINGS

#### 5.1 Métodos Importantes de String
```java
String texto = "Hola,Mundo,Java";

// Dividir string
String[] partes = texto.split(","); // ["Hola", "Mundo", "Java"]

// Comparar strings
boolean iguales = texto.equals("Hola,Mundo,Java"); // true
boolean ignorarMayusculas = texto.equalsIgnoreCase("hola,mundo,java"); // true

// Obtener longitud
int longitud = texto.length();

// Concatenar
String nuevo = texto + " 2024";
```

**Aplicación en la prueba:**
- Problema 1:
  - Línea 64: `String[] stationNames = names.split(",");` - Dividir string en partes
  - Línea 65: `int stationCount = stationNames.length;` - Obtener cantidad
  - Línea 103: `if (aux.getName().equals(station))` - Comparar strings
- Problema 2:
  - Parsear archivos CSV: `linea.split(",")` para separar los campos
  - Comparar IDs, nombres de usuario, etc.

#### 5.2 Concatenación de Strings
```java
String nombre = "Juan";
int edad = 25;
String mensaje = "Nombre: " + nombre + ", Edad: " + edad;
```

**Aplicación en la prueba:**
- Problema 1: Línea 81, 91, 120: Concatenación para imprimir información
- Problema 2: Construir mensajes de salida formateados

---

## PARTE 2: CONCEPTOS DE PROGRAMACIÓN ORIENTADA A OBJETOS

### 6. CLASES Y OBJETOS

#### 6.1 Definición de Clase
Una clase es un "molde" o "plantilla" que define las características (atributos) y comportamientos (métodos) de un tipo de objeto.

```java
public class Usuario {
    // Atributos (características)
    private int id;
    private String nombre;
    private String correo;

    // Constructor (cómo crear el objeto)
    public Usuario(int id, String nombre, String correo) {
        this.id = id;
        this.nombre = nombre;
        this.correo = correo;
    }

    // Métodos (comportamientos)
    public String getNombre() {
        return nombre;
    }
}
```

#### 6.2 Creación de Objetos (Instanciación)
```java
// Crear un objeto usando 'new'
Usuario usuario1 = new Usuario(1, "Juan", "juan@mail.com");
Usuario usuario2 = new Usuario(2, "María", "maria@mail.com");
```

**Aplicación en la prueba:**
- Problema 1:
  - Línea 3-6: Crear objetos Line
  - Línea 69: `this.terminalStationBegin = new Station(stationNames[0]);`
  - Línea 72: `aux.setNextStation(new Station(stationNames[i]));`
- Problema 2: Crear objetos Usuario, Chat, Mensaje al leer los archivos

---

### 7. ENCAPSULACIÓN

#### 7.1 Principio de Encapsulación
Ocultar los detalles internos de una clase y proporcionar acceso controlado a través de métodos públicos (getters y setters).

```java
public class Persona {
    // Atributos PRIVADOS
    private String nombre;
    private int edad;

    // Métodos PÚBLICOS para acceder y modificar
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        if (edad >= 0) {  // Validación
            this.edad = edad;
        }
    }
}
```

**Aplicación en la prueba:**
- Problema 1 - Clase Station:
  - Atributos privados: `private String name`, `private Station previousStation`, etc.
  - Getters: `getName()` (línea 51), `getPreviousStation()` (línea 33), `getNextStation()` (línea 39), `getInterchange()` (línea 45)
  - Setters: `setPreviousStation()` (línea 36), `setNextStation()` (línea 42), `setInterchange()` (línea 48)

**Por qué es importante:**
- Protege los datos de modificaciones no autorizadas
- Permite validar los datos antes de asignarlos
- Facilita el mantenimiento del código

---

### 8. CONSTRUCTORES

#### 8.1 ¿Qué es un Constructor?
Un método especial que se ejecuta cuando se crea un objeto. Inicializa los atributos del objeto.

```java
public class Producto {
    private String nombre;
    private double precio;

    // Constructor sin parámetros
    public Producto() {
        this.nombre = "Sin nombre";
        this.precio = 0.0;
    }

    // Constructor con parámetros
    public Producto(String nombre, double precio) {
        this.nombre = nombre;
        this.precio = precio;
    }
}
```

**Aplicación en la prueba:**
- Problema 1:
  - Constructor de Station (línea 30-32): `public Station(String name) { this.name = name; }`
  - Constructor de Line (línea 60-62): `public Line(int number) { this.number = number; }`
- Problema 2: Necesitarás constructores para Usuario, Chat y Mensaje

---

### 9. REFERENCIAS Y RELACIONES ENTRE OBJETOS

#### 9.1 Referencias de Objetos
En Java, las variables de tipo objeto almacenan REFERENCIAS (direcciones de memoria), no los objetos en sí.

```java
// Crear un objeto
Usuario usuario1 = new Usuario(1, "Juan", "juan@mail.com");

// usuario2 es una REFERENCIA al mismo objeto
Usuario usuario2 = usuario1;

// Modificar a través de usuario2 afecta a usuario1
usuario2.setNombre("Pedro");
System.out.println(usuario1.getNombre()); // Imprime "Pedro"
```

**Aplicación en la prueba:**
- Problema 1: Uso extensivo de referencias para navegar entre estaciones
  - Línea 70: `Station aux = this.terminalStationBegin;` - aux es una referencia
  - Línea 73: `aux.getNextStation().setPreviousStation(aux);` - Referencias encadenadas
  - Línea 74: `aux = aux.getNextStation();` - Mover la referencia
- Problema 2: "Debe usar referencias" según las consideraciones

#### 9.2 Relaciones de Composición
Un objeto contiene referencias a otros objetos como parte de su estructura.

```java
public class Chat {
    private int id;
    private String titulo;
    private Usuario[] participantes;  // Arreglo de referencias a objetos Usuario
    private Mensaje[] mensajes;       // Arreglo de referencias a objetos Mensaje
}
```

**Aplicación en la prueba:**
- Problema 1 - Clase Line:
  - `private Station terminalStationBegin;` - Line contiene referencias a Station
  - `private Station terminalStationEnd;`
- Problema 1 - Clase Station:
  - `private Station previousStation;` - Una estación referencia a otra
  - `private Station nextStation;`
  - `private Station interchange;`

#### 9.3 Listas Enlazadas
Una estructura donde cada objeto tiene referencias al siguiente (y posiblemente al anterior).

```java
// Nodo de lista enlazada simple
public class Nodo {
    private String dato;
    private Nodo siguiente;

    public Nodo getSiguiente() {
        return siguiente;
    }

    public void setSiguiente(Nodo siguiente) {
        this.siguiente = siguiente;
    }
}

// Recorrer la lista
Nodo actual = primero;
while (actual != null) {
    System.out.println(actual.getDato());
    actual = actual.getSiguiente();
}
```

**Aplicación en la prueba:**
- Problema 1: La clase Station implementa una lista doblemente enlazada circular
  - Cada Station tiene `nextStation` y `previousStation`
  - Recorrido hacia adelante: Líneas 82-86
  - Recorrido hacia atrás: Líneas 92-96

---

### 10. MÉTODOS

#### 10.1 Métodos con Retorno
```java
public TipoRetorno nombreMetodo(parametros) {
    // código
    return valorDelTipoRetorno;
}
```

**Aplicación en la prueba:**
- Problema 1:
  - `public Station getPreviousStation()` - retorna Station (línea 33)
  - `public String getName()` - retorna String (línea 51)
  - `public Station findStation(String station)` - retorna Station (línea 100)

#### 10.2 Métodos void (sin retorno)
```java
public void nombreMetodo(parametros) {
    // código
    // no retorna nada
}
```

**Aplicación en la prueba:**
- Problema 1:
  - `public void setPreviousStation(Station previousStation)` (línea 36)
  - `public void addStations(String names)` (línea 63)
  - `public void printStationsForward()` (línea 80)
  - `public void roam(int stops)` (línea 119)

#### 10.3 Palabra Clave 'this'
Referencia al objeto actual.

```java
public class Persona {
    private String nombre;

    public Persona(String nombre) {
        this.nombre = nombre;  // this.nombre es el atributo, nombre es el parámetro
    }

    public void mostrar() {
        System.out.println(this.nombre);  // acceder al atributo del objeto actual
    }
}
```

**Aplicación en la prueba:**
- Problema 1: Uso constante de `this` para acceder a atributos y métodos del objeto actual
  - Línea 31: `this.name = name;`
  - Línea 70: `Station aux = this.terminalStationBegin;`
  - Línea 114: `Station stationA = this.findStation(name);`

---

### 11. VALIDACIONES Y EXCEPCIONES

#### 11.1 Lanzar Excepciones
```java
public void setEdad(int edad) {
    if (edad < 0) {
        throw new IllegalArgumentException("La edad no puede ser negativa");
    }
    this.edad = edad;
}
```

**Aplicación en la prueba:**
- Problema 1: Línea 66-68
```java
if (stationCount < 3) {
    throw new IllegalArgumentException("Faltan estaciones");
}
```

#### 11.2 Capturar Excepciones
```java
try {
    // código que puede fallar
    int resultado = dividir(10, 0);
} catch (ArithmeticException e) {
    System.out.println("Error: " + e.getMessage());
}
```

**Aplicación en la prueba:**
- Problema 1: Línea 7-21 - El main captura excepciones que pueden ocurrir
- Problema 2: Necesario para manejar errores de lectura de archivos

---

### 12. RECORRIDO Y NAVEGACIÓN EN ESTRUCTURAS

#### 12.1 Recorrido de Arreglos
```java
String[] nombres = {"Ana", "Luis", "Carlos"};

// Opción 1: For tradicional
for (int i = 0; i < nombres.length; i++) {
    System.out.println(nombres[i]);
}

// Opción 2: For-each
for (String nombre : nombres) {
    System.out.println(nombre);
}
```

**Aplicación en la prueba:**
- Problema 2: Recorrer arreglos de Usuarios, Chats y Mensajes

#### 12.2 Recorrido de Listas Enlazadas
```java
// Avanzar hasta encontrar un elemento o llegar al final
Nodo actual = inicio;
while (actual != null) {
    if (actual.getDato().equals(buscado)) {
        return actual;
    }
    actual = actual.getSiguiente();
}
return null;  // No encontrado
```

**Aplicación en la prueba:**
- Problema 1 - Método findStation (líneas 100-111):
```java
public Station findStation(String station) {
    Station aux = terminalStationBegin;
    while (aux.getNextStation() != null) {
        if (aux.getName().equals(station)) {
            return aux;
        }
        aux = aux.getNextStation();
    }
    return null;
}
```

---

## PARTE 3: CONCEPTOS ESPECÍFICOS PARA EL PROBLEMA 2

### 13. MENÚS INTERACTIVOS

#### 13.1 Estructura de un Menú
```java
import java.util.Scanner;

Scanner scanner = new Scanner(System.in);
boolean continuar = true;

while (continuar) {
    System.out.println("===== MENÚ PRINCIPAL =====");
    System.out.println("1. Opción 1");
    System.out.println("2. Opción 2");
    System.out.println("3. Salir");
    System.out.print("Seleccione una opción: ");

    int opcion = scanner.nextInt();
    scanner.nextLine(); // Limpiar buffer

    switch (opcion) {
        case 1:
            // código para opción 1
            break;
        case 2:
            // código para opción 2
            break;
        case 3:
            continuar = false;
            break;
        default:
            System.out.println("Opción inválida");
    }
}
scanner.close();
```

**Aplicación en la prueba:**
- Problema 2: Implementar un menú con 5 opciones principales y submenús

---

### 14. PARSEO DE ARCHIVOS CSV

#### 14.1 Lectura y Procesamiento
```java
import java.io.*;

BufferedReader br = new BufferedReader(new FileReader("users.txt"));
String linea;

while ((linea = br.readLine()) != null) {
    String[] partes = linea.split(",");

    // Formato: ID Usuario, Nombre de Usuario, Correo Electrónico
    int id = Integer.parseInt(partes[0].trim());
    String nombre = partes[1].trim();
    String correo = partes[2].trim();

    // Crear objeto y agregarlo al arreglo
    Usuario usuario = new Usuario(id, nombre, correo);
    usuarios[contador++] = usuario;
}
br.close();
```

**Aplicación en la prueba:**
- Problema 2: Leer tres archivos diferentes con formatos CSV

#### 14.2 Conversión de Tipos (Parsing)
```java
// String a int
String texto = "123";
int numero = Integer.parseInt(texto);

// String a double
String textoDecimal = "45.67";
double decimal = Double.parseDouble(textoDecimal);
```

**Aplicación en la prueba:**
- Problema 2: Convertir IDs de String a int al leer los archivos

---

### 15. MANEJO DE FECHAS

#### 15.1 Formato de Fecha del Problema
Formato: `hh:mm dd/mm/aaaa`

```java
import java.text.SimpleDateFormat;
import java.util.Date;

// Parsear fecha desde String
String fechaTexto = "14:30 15/10/2024";
SimpleDateFormat formato = new SimpleDateFormat("HH:mm dd/MM/yyyy");
Date fecha = formato.parse(fechaTexto);

// Obtener solo la hora
String[] partes = fechaTexto.split(" ");
String horaCompleta = partes[0]; // "14:30"
String[] horaPartes = horaCompleta.split(":");
int hora = Integer.parseInt(horaPartes[0]); // 14
```

**Aplicación en la prueba:**
- Problema 2: Opción 3 del menú - "Mostrar las 3 horas del día con más mensajes enviados"

#### 15.2 Comparación de Fechas
```java
// Opción 1: Comparar objetos Date
if (fecha1.before(fecha2)) {
    // fecha1 es anterior a fecha2
}

// Opción 2: Comparar strings si están en formato estándar
// Solo funciona si el formato permite comparación lexicográfica
```

**Aplicación en la prueba:**
- Problema 2: Opción 1c - "Mensajes: Contenido, fecha, remitente. Deben verse de manera ordenada por fecha"

---

### 16. ALGORITMOS DE BÚSQUEDA

#### 16.1 Búsqueda Lineal
```java
public Usuario buscarUsuarioPorId(Usuario[] usuarios, int id) {
    for (int i = 0; i < usuarios.length; i++) {
        if (usuarios[i] != null && usuarios[i].getId() == id) {
            return usuarios[i];
        }
    }
    return null; // No encontrado
}
```

**Aplicación en la prueba:**
- Problema 2: Buscar usuarios por ID, chats por ID, verificar si un usuario pertenece a un chat

#### 16.2 Verificar Múltiples Condiciones
```java
public boolean usuarioEnTodosLosChats(int idUsuario, int[] idsChats, Chat[] chats) {
    for (int i = 0; i < idsChats.length; i++) {
        Chat chat = buscarChatPorId(chats, idsChats[i]);
        if (chat == null || !chat.tieneUsuario(idUsuario)) {
            return false; // Usuario no está en uno de los chats
        }
    }
    return true; // Usuario está en todos los chats
}
```

**Aplicación en la prueba:**
- Problema 2: Opción 5c - "El usuario remitente debe pertenecer a todos los chats para enviar el mensaje"

---

### 17. ALGORITMOS DE ORDENAMIENTO

#### 17.1 Ordenamiento Burbuja (Bubble Sort)
```java
public void ordenarMensajesPorFecha(Mensaje[] mensajes, int cantidad) {
    for (int i = 0; i < cantidad - 1; i++) {
        for (int j = 0; j < cantidad - i - 1; j++) {
            if (mensajes[j].getFecha().after(mensajes[j + 1].getFecha())) {
                // Intercambiar
                Mensaje temp = mensajes[j];
                mensajes[j] = mensajes[j + 1];
                mensajes[j + 1] = temp;
            }
        }
    }
}
```

**Aplicación en la prueba:**
- Problema 2: Opción 1c - Ordenar mensajes por fecha antes de mostrarlos

#### 17.2 Ordenamiento por Selección
```java
public void ordenarPorSeleccion(int[] arr) {
    for (int i = 0; i < arr.length - 1; i++) {
        int minIndex = i;
        for (int j = i + 1; j < arr.length; j++) {
            if (arr[j] < arr[minIndex]) {
                minIndex = j;
            }
        }
        // Intercambiar
        int temp = arr[i];
        arr[i] = arr[minIndex];
        arr[minIndex] = temp;
    }
}
```

---

### 18. ESTADÍSTICAS Y CONTEO

#### 18.1 Contar Ocurrencias
```java
public int contarMensajesPorUsuario(Mensaje[] mensajes, int idUsuario) {
    int contador = 0;
    for (int i = 0; i < mensajes.length; i++) {
        if (mensajes[i] != null && mensajes[i].getIdRemitente() == idUsuario) {
            contador++;
        }
    }
    return contador;
}
```

**Aplicación en la prueba:**
- Problema 2: Opción 2 - "Mostrar a los 3 usuarios que más mensajes han enviado"

#### 18.2 Encontrar Top N Elementos
```java
// Estructura para almacenar contador
class ContadorUsuario {
    int idUsuario;
    int cantidad;
}

// Encontrar top 3
public void mostrarTop3Usuarios(Usuario[] usuarios, Mensaje[] mensajes) {
    ContadorUsuario[] contadores = new ContadorUsuario[cantidadUsuarios];

    // Contar mensajes por usuario
    for (int i = 0; i < cantidadUsuarios; i++) {
        contadores[i].idUsuario = usuarios[i].getId();
        contadores[i].cantidad = contarMensajesPorUsuario(mensajes, usuarios[i].getId());
    }

    // Ordenar por cantidad (descendente)
    // ... código de ordenamiento ...

    // Mostrar top 3
    for (int i = 0; i < 3 && i < cantidadUsuarios; i++) {
        System.out.println(usuarios[i].getNombre() + ": " + contadores[i].cantidad);
    }
}
```

**Aplicación en la prueba:**
- Problema 2: Opciones 2 y 3 - Top 3 usuarios y top 3 horas

---

### 19. DISEÑO DE CLASES PARA EL PROBLEMA 2

#### 19.1 Clase Usuario
```java
public class Usuario {
    private int id;
    private String nombreUsuario;
    private String correoElectronico;

    // Constructor
    public Usuario(int id, String nombreUsuario, String correoElectronico) {
        this.id = id;
        this.nombreUsuario = nombreUsuario;
        this.correoElectronico = correoElectronico;
    }

    // Getters y Setters
    public int getId() { return id; }
    public String getNombreUsuario() { return nombreUsuario; }
    public String getCorreoElectronico() { return correoElectronico; }
}
```

#### 19.2 Clase Chat
```java
public class Chat {
    private int id;
    private String titulo;
    private int[] idsParticipantes;
    private int cantidadParticipantes;

    // Constructor
    public Chat(int id, String titulo) {
        this.id = id;
        this.titulo = titulo;
        this.idsParticipantes = new int[100]; // Tamaño máximo
        this.cantidadParticipantes = 0;
    }

    // Agregar participante
    public void agregarParticipante(int idUsuario) {
        idsParticipantes[cantidadParticipantes++] = idUsuario;
    }

    // Verificar si un usuario es participante
    public boolean tieneUsuario(int idUsuario) {
        for (int i = 0; i < cantidadParticipantes; i++) {
            if (idsParticipantes[i] == idUsuario) {
                return true;
            }
        }
        return false;
    }

    // Getters y Setters
    public int getId() { return id; }
    public String getTitulo() { return titulo; }
    public void setTitulo(String titulo) { this.titulo = titulo; }
}
```

#### 19.3 Clase Mensaje
```java
import java.util.Date;

public class Mensaje {
    private int id;
    private int idChat;
    private String fecha; // o Date fecha;
    private int idRemitente;
    private String contenido;

    // Constructor
    public Mensaje(int id, int idChat, String fecha, int idRemitente, String contenido) {
        this.id = id;
        this.idChat = idChat;
        this.fecha = fecha;
        this.idRemitente = idRemitente;
        this.contenido = contenido;
    }

    // Getters
    public int getId() { return id; }
    public int getIdChat() { return idChat; }
    public String getFecha() { return fecha; }
    public int getIdRemitente() { return idRemitente; }
    public String getContenido() { return contenido; }
}
```

---

## PARTE 4: TÉCNICAS DE RUTEO (PROBLEMA 1)

### 20. CÓMO RUTEAR CÓDIGO

#### 20.1 Pasos para Rutear
1. **Identificar las clases y sus atributos**
2. **Seguir la ejecución línea por línea desde el main**
3. **Dibujar los objetos en memoria (opcional pero muy útil)**
4. **Anotar el valor de cada variable en cada paso**
5. **Seguir las llamadas a métodos y retornos**
6. **Anotar las salidas esperadas**

#### 20.2 Ejemplo de Ruteo del Problema 1

**Paso 1: Crear objetos Line**
```
Línea 3: Line one = new Line(1);
  - Crea objeto Line con number = 1

Línea 4: Line two = new Line(2);
  - Crea objeto Line con number = 2

Línea 5: Line six = new Line(6);
  - Crea objeto Line con number = 6

Línea 6: Line four = new Line(4);
  - Crea objeto Line con number = 4
```

**Paso 2: Ejecutar try-catch**
```
Línea 8: one.addStations("San Pablo,Los Heroes,Baquedano,Los Leones,El Golf,Los Dominicos");
  - Llama a addStations con el string de estaciones
  - Va al método addStations (línea 63)
```

**Paso 3: Dentro de addStations**
```
Línea 64: String[] stationNames = names.split(",");
  - stationNames = ["San Pablo", "Los Heroes", "Baquedano", "Los Leones", "El Golf", "Los Dominicos"]

Línea 65: int stationCount = stationNames.length;
  - stationCount = 6

Línea 66: if (stationCount < 3)
  - 6 < 3 es false, no lanza excepción

Línea 69: this.terminalStationBegin = new Station(stationNames[0]);
  - Crea Station con name = "San Pablo"
  - terminalStationBegin apunta a este objeto
```

Y así sucesivamente...

#### 20.3 Técnica de Dibujo de Objetos
```
[Line one]
number: 1
terminalStationBegin: --> [Station: "San Pablo"]
                           nextStation: --> [Station: "Los Heroes"]
                                            nextStation: --> [Station: "Baquedano"]
                                                             ...
```

---

## PARTE 5: RESUMEN DE CONCEPTOS POR PROBLEMA

### PROBLEMA 1 (Ruteo) - Conceptos Necesarios:

1. **Clases y objetos**: Entender cómo se crean y relacionan
2. **Referencias**: Seguir las referencias entre objetos
3. **Listas enlazadas**: Estructura con nextStation y previousStation
4. **Recorrido de estructuras**: Bucles while para navegar
5. **Métodos y retornos**: Seguir llamadas a métodos
6. **Excepciones**: try-catch y throw
7. **Arreglos y split**: Procesamiento de strings
8. **Encapsulación**: Getters y setters
9. **this**: Referencia al objeto actual
10. **null**: Verificar referencias nulas

**Práctica recomendada:**
- Dibujar los objetos Station y sus conexiones
- Seguir paso a paso la ejecución
- Anotar el estado de cada variable
- Identificar qué imprime cada System.out.println()

---

### PROBLEMA 2 (Chat) - Conceptos Necesarios:

**Fundamentos Java:**
1. Arreglos de objetos
2. Lectura de archivos (BufferedReader/Scanner)
3. Parseo de CSV con split()
4. Conversión String a int (Integer.parseInt)
5. Entrada por consola (Scanner)
6. Bucles for y while
7. Condicionales if-else y switch
8. Manejo de excepciones

**POO:**
9. Diseño de clases (Usuario, Chat, Mensaje)
10. Encapsulación (private + getters/setters)
11. Constructores
12. Referencias entre objetos
13. Composición (Chat contiene referencias a Usuarios y Mensajes)

**Algoritmos:**
14. Búsqueda lineal (encontrar por ID)
15. Ordenamiento (mensajes por fecha)
16. Conteo y estadísticas
17. Top N elementos

**Funcionalidades específicas:**
18. Menús interactivos con switch
19. Validaciones (usuario en todos los chats)
20. Formateo de salida
21. Manejo de fechas (parseo y comparación)

---

## PARTE 6: CONSEJOS PARA LA PRUEBA

### 21. ESTRATEGIAS DE RESOLUCIÓN

#### Para el Problema 1 (Ruteo):
1. Lee el código DOS veces completas antes de empezar
2. Identifica las clases y sus relaciones
3. Dibuja un diagrama de los objetos si es necesario
4. Sigue la ejecución línea por línea desde el main
5. Anota cada salida esperada (System.out.println)
6. Presta atención a las referencias y cómo cambian
7. Ten cuidado con los bucles y sus condiciones de parada
8. Verifica las comparaciones con equals() vs ==

#### Para el Problema 2 (Chat):
1. Lee TODOS los requerimientos dos veces
2. Diseña las clases ANTES de codificar
3. Dibuja el diagrama de clases en papel (vale 25%)
4. Identifica qué atributos y métodos necesita cada clase
5. Implementa paso a paso:
   - Primero las clases básicas
   - Luego la lectura de archivos
   - Después el menú principal
   - Finalmente cada funcionalidad
6. Prueba cada parte antes de continuar
7. Maneja los errores con try-catch
8. Valida los datos de entrada

### 22. ERRORES COMUNES A EVITAR

1. **Confundir == con equals() para Strings**
   - INCORRECTO: `if (nombre == "Juan")`
   - CORRECTO: `if (nombre.equals("Juan"))`

2. **No inicializar arreglos**
   - INCORRECTO: `Usuario[] usuarios;`
   - CORRECTO: `Usuario[] usuarios = new Usuario[100];`

3. **No cerrar Scanner o archivos**
   - Siempre cerrar: `scanner.close();` y `br.close();`

4. **Olvidar scanner.nextLine() después de nextInt()**
   ```java
   int opcion = scanner.nextInt();
   scanner.nextLine(); // NECESARIO para limpiar el buffer
   ```

5. **No validar null en referencias**
   ```java
   if (usuario != null && usuario.getNombre().equals("Juan")) {
       // ...
   }
   ```

6. **Confundir índices de arreglos** (empiezan en 0, no en 1)

7. **No usar trim() al parsear CSV**
   ```java
   String nombre = partes[1].trim(); // Elimina espacios en blanco
   ```

---

## CHECKLIST DE ESTUDIO

Marca cada concepto cuando lo domines:

### Fundamentos Java
- [ ] Estructura de clases y métodos
- [ ] Tipos de datos (primitivos y referencia)
- [ ] Arreglos (declaración, inicialización, recorrido)
- [ ] Strings (split, equals, concatenación, trim)
- [ ] Estructuras de control (if, for, while, switch)
- [ ] Try-catch y excepciones
- [ ] Scanner (nextLine, nextInt, close)
- [ ] System.out.println y print
- [ ] Lectura de archivos (BufferedReader/Scanner)
- [ ] Integer.parseInt()

### POO
- [ ] Clases y objetos
- [ ] Atributos privados
- [ ] Constructores
- [ ] Getters y Setters
- [ ] Encapsulación
- [ ] Referencias de objetos
- [ ] Palabra clave 'this'
- [ ] Relaciones entre objetos (composición)
- [ ] null y verificación de referencias

### Estructuras de Datos
- [ ] Arreglos de objetos
- [ ] Listas enlazadas simples
- [ ] Listas doblemente enlazadas
- [ ] Recorrido de estructuras

### Algoritmos
- [ ] Búsqueda lineal
- [ ] Ordenamiento (burbuja o selección)
- [ ] Conteo de elementos
- [ ] Encontrar Top N

### Específico del Problema
- [ ] Ruteo de código paso a paso
- [ ] Dibujo de objetos en memoria
- [ ] Parseo de CSV
- [ ] Menús interactivos
- [ ] Validaciones múltiples
- [ ] Formateo de salida

---

## EJERCICIOS DE PRÁCTICA RECOMENDADOS

### Para Ruteo (Problema 1):
1. Rutea código con listas enlazadas simples
2. Rutea código con arreglos y bucles
3. Practica seguir referencias entre objetos
4. Identifica salidas de programas con System.out.println

### Para Implementación (Problema 2):
1. Crea una clase Persona con atributos y métodos
2. Lee un archivo CSV y crea objetos
3. Implementa un menú con Scanner y switch
4. Ordena un arreglo de objetos por un criterio
5. Busca elementos en arreglos
6. Cuenta ocurrencias y encuentra el máximo

---

## RECURSOS FINALES

**Documentación útil:**
- String methods: split(), equals(), trim(), length()
- Array: declaración, inicialización, length
- Scanner: nextLine(), nextInt(), close()
- BufferedReader: readLine(), close()

**Plantillas de código:**
- Menú con switch
- Lectura de archivo CSV
- Búsqueda en arreglo
- Ordenamiento burbuja
- Clase con getters/setters

---

Buena suerte en tu prueba! Recuerda:
1. Lee TODO dos veces antes de empezar
2. Planifica antes de codificar
3. Prueba tu código paso a paso
4. Maneja los errores apropiadamente
5. Revisa tu trabajo antes de entregar
