# Ejercicio 1: Sistema de Biblioteca Basica (Nivel 1)
**Dificultad:** Facil-Medio
**Tiempo estimado:** 30-40 minutos
**Conceptos:** Herencia, Polimorfismo, ArrayList

---

## Contexto

Una biblioteca necesita un sistema simple para gestionar su coleccion de materiales. La biblioteca tiene tres tipos de materiales: Libros, Revistas y DVDs.

## Requisitos

### Informacion a almacenar:

**Todos los materiales tienen:**
- Codigo unico (String)
- Titulo (String)
- Anio de publicacion (int)

**Especificos de cada tipo:**

- **Libro:** autor (String), numero de paginas (int)
- **Revista:** mes de publicacion (String), numero de edicion (int)
- **DVD:** duracion en minutos (int), director (String)

### Funcionalidades requeridas:

1. **Calcular antiguedad:** Todos los materiales deben poder calcular cuantos anios tienen desde su publicacion (usar anio actual 2024).

2. **Mostrar informacion:** Cada tipo de material debe mostrar su informacion de manera especifica:
   - Libro: "LIBRO [codigo] - 'titulo' por autor (paginas pags.) - antiguedad anios"
   - Revista: "REVISTA [codigo] - 'titulo' Ed.numero (mes) - antiguedad anios"
   - DVD: "DVD [codigo] - 'titulo' dirigido por director (duracion min.) - antiguedad anios"

3. **Sistema de gestion:** Crear una clase `Biblioteca` que:
   - Almacene todos los materiales en una sola lista
   - Permita agregar materiales
   - Muestre todos los materiales
   - Encuentre el material mas antiguo

## Ejemplo de Ejecucion

```
=== CATALOGO BIBLIOTECA ===
LIBRO [L001] - 'Cien Anios de Soledad' por Gabriel Garcia Marquez (417 pags.) - 57 anios
REVISTA [R001] - 'National Geographic' Ed.245 (Marzo) - 2 anios
DVD [D001] - 'Inception' dirigido por Christopher Nolan (148 min.) - 14 anios
LIBRO [L002] - 'El Quijote' por Miguel de Cervantes (863 pags.) - 419 anios

Material mas antiguo:
LIBRO [L002] - 'El Quijote' por Miguel de Cervantes (863 pags.) - 419 anios
```

## Debe entregar:

- Clase abstracta o superclase `Material`
- Clases `Libro`, `Revista`, `DVD`
- Clase `Biblioteca` con la lista y metodos
- Clase `Main` con el programa principal que demuestre todas las funcionalidades

## Consideraciones:

- Use herencia apropiadamente
- El metodo para mostrar informacion debe ser polimorfismo
- La lista debe almacenar todos los tipos de materiales
- Use nombres descriptivos para variables y metodos
- Maneje casos donde la lista este vacia

## Pistas:

1. Piensa en que metodos deberian ser abstractos
2. El anio actual (2024) podria ser una constante
3. Usa `@Override` cuando sobrescribas metodos
4. Considera usar un constructor en la clase padre para inicializar atributos comunes

---

## PASO A PASO: COMO RESOLVER ESTE EJERCICIO

Este ejercicio te ensenara herencia, polimorfismo y uso de listas heterogeneas. Vamos a resolverlo juntos paso por paso.

### PASO 1: Analizar el Problema

Antes de escribir codigo, analiza:
- Tienes 3 tipos de materiales que comparten caracteristicas comunes
- Todos tienen: codigo, titulo, anio
- Cada uno tiene atributos especificos
- Todos deben calcular antiguedad
- Todos deben mostrar su informacion (pero de forma diferente)3

**Conclusion:** Necesitas HERENCIA porque hay caracteristicas comunes y especificas.

### PASO 2: Crear la Clase Base Material

Comienza con lo COMUN a todos los materiales:

```java
public abstract class Material {
    // Atributos comunes
    protected String codigo;
    protected String titulo;
    protected int anioPublicacion;

    // Constante para el anio actual
    protected static final int AN3IO_ACTUAL = 2024;

    // Constructor - inicializa lo comun
    public Material(String codigo, String titulo, int anioPublicacion) {
        this.codigo = codigo;
        this.titulo = titulo;
        this.anioPublicacion = anioPublicacion;
    }

    // Metodo concreto - todos lo usan igual
    public int calcularAntiguedad() {
        return ANIO_ACTUAL - anioPublicacion;
    }

    // Metodo abstracto - cada clase lo implementa diferente
    public abstract String mostrarInformacion();

    // Getters
    public String getCodigo() { return codigo; }
    public String getTitulo() { return titulo; }
    public int getAnioPublicacion() { return anioPublicacion; }
}
```

**Por que abstracta?** Porque nunca crearemos un "Material" generico, solo Libros, Revistas y DVDs.

**Por que `protected`?** Para que las subclases puedan acceder directamente a estos atributos.

**Por que `mostrarInformacion()` es abstracto?** Porque cada tipo muestra su informacion diferente.

### PASO 3: Crear la Clase Libro

Ahora extiende Material con caracteristicas especificas:

```java
public class Libro extends Material {
    // Atributos ESPECIFICOS de Libro
    private String autor;
    private int numeroPaginas;

    // Constructor
    public class Libro extends Material {
        private String autor;
        private int numeroPaginas;
    }

    public Libro(String codigo, String titulo, int anioPublicacion, String autor, int numeroPaginas) {
        super(codigo, titulo, anioPublicacion);  // Llama al constructor padre
        this.autor = autor;
        this.numeroPaginas = numeroPaginas;
    }

    @Override
    public String mostrarInformacion() {
        return String.format("LIBRO [%s] - '%s' por %s (%d pags.) - %d anios", codigo, titulo, autor, numeroPaginas, calcularAntiguedad());
    }

    // Getters para atributos especificos
    public String getAutor() { return autor; }
    public int getNumeroPaginas() { return numeroPaginas; }
}
```

**Puntos clave:**
- `extends Material` establece la herencia
- `super(...)` llama al constructor del padre para inicializar atributos comunes
- `@Override` indica que estamos sobrescribiendo un metodo abstracto
- `calcularAntiguedad()` es heredado, no necesitas reimplementarlo

### PASO 4: Crear Revista y DVD

Siguiendo el mismo patron:

```java
public class Revista extends Material {
    private String mesPublicacion;
    private int numeroEdicion;

    public Revista(String codigo, String titulo, int anioPublicacion, String mesPublicacion, int numeroEdicion) {
        super(codigo, titulo, anioPublicacion);
        this.mesPublicacion = mesPublicacion;
        this.numeroEdicion = numeroEdicion;
    }

    @Override
    public String mostrarInformacion() {
        return String.format("REVISTA [%s] - '%s' Ed.%d (%s) - %d anios", codigo, titulo, numeroEdicion, mesPublicacion, calcularAntiguedad());
    }

    public String getMesPublicacion() { return mesPublicacion; }
    public int getNumeroEdicion() { return numeroEdicion; }
}
```

```java
public class DVD extends Material {
    private int duracionMinutos;
    private String director;

    public DVD(String codigo, String titulo, int anioPublicacion, int duracionMinutos, String director) {
        super(codigo, titulo, anioPublicacion);
        this.duracionMinutos = duracionMinutos;
        this.director = director;
    }

    @Override
    public String mostrarInformacion() {
        return String.format("DVD [%s] - '%s' dirigido por %s (%d min.) - %d anios",codigo, titulo, director, duracionMinutos,calcularAntiguedad());
    }

    public int getDuracionMinutos() { return duracionMinutos; }
    public String getDirector() { return director; }
}
```

### PASO 5: Crear la Clase Biblioteca

Esta clase gestiona TODOS los materiales en UNA SOLA lista:

```java
import java.util.ArrayList;

public class Biblioteca {
    // Lista heterogenea - puede contener Libros, Revistas y DVDs
    private ArrayList<Material> materiales;

    public Biblioteca() {
        materiales = new ArrayList<>();
    }

    // Agregar cualquier tipo de material
    public void agregarMaterial(Material material) {
        materiales.add(material);
        System.out.println("Material agregado: " + material.getTitulo());
    }

    // Mostrar todos los materiales usando polimorfismo
    public void mostrarCatalogo() {
        System.out.println("=== CATALOGO BIBLIOTECA ===");
        for (Material material : materiales) {
            // Polimorfismo en accion: cada material muestra su info diferente
            System.out.println(material.mostrarInformacion());
        }
    }

    // Encontrar el material mas antiguo
    public Material encontrarMasAntiguo() {
        if (materiales.isEmpty()) {
            return null;
        }

        Material masAntiguo = materiales.get(0);
        for (Material material : materiales) {
            if (material.calcularAntiguedad() > masAntiguo.calcularAntiguedad()) {
                masAntiguo = material;
            }
        }
        return masAntiguo;
    }

    public int getTotalMateriales() {
        return materiales.size();
    }
}
```

**Concepto clave - Polimorfismo:**
- La lista es de tipo `ArrayList<Material>`
- Puede contener Libros, Revistas y DVDs
- Cuando llamas `material.mostrarInformacion()`, Java automaticamente usa la version correcta segun el tipo real del objeto

### PASO 6: Crear el Main

```java
public class Main {
    public static void main(String[] args) {
        // Crear biblioteca
        Biblioteca biblioteca = new Biblioteca();

        // Crear y agregar materiales
        Libro libro1 = new Libro("L001", "Cien Anios de Soledad", 1967,
                                 "Gabriel Garcia Marquez", 417);
        biblioteca.agregarMaterial(libro1);

        Revista revista1 = new Revista("R001", "National Geographic", 2022,
                                       "Marzo", 245);
        biblioteca.agregarMaterial(revista1);

        DVD dvd1 = new DVD("D001", "Inception", 2010, 148, "Christopher Nolan");
        biblioteca.agregarMaterial(dvd1);

        Libro libro2 = new Libro("L002", "El Quijote", 1605,
                                 "Miguel de Cervantes", 863);
        biblioteca.agregarMaterial(libro2);

        // Mostrar catalogo completo
        System.out.println();
        biblioteca.mostrarCatalogo();

        // Encontrar mas antiguo
        System.out.println("\nMaterial mas antiguo:");
        Material antiguo = biblioteca.encontrarMasAntiguo();
        if (antiguo != null) {
            System.out.println(antiguo.mostrarInformacion());
        }
    }
}
```

### PASO 7: Compilar y Ejecutar

```bash
# Compilar todas las clases
javac Material.java Libro.java Revista.java DVD.java Biblioteca.java Main.java

# Ejecutar
java Main
```

### ERRORES COMUNES A EVITAR

1. **No llamar a super() en constructores:**
   ```java
   // INCORRECTO
   public Libro(...) {
       this.autor = autor;  // Falta inicializar codigo, titulo, anio
   }

   // CORRECTO
   public Libro(...) {
       super(codigo, titulo, anio);
       this.autor = autor;
   }
   ```

2. **No usar @Override:**
   - Siempre usa `@Override` cuando sobrescribas metodos
   - Te ayuda a detectar errores (si escribes mal el nombre, el compilador avisa)

3. **Olvidar importar ArrayList:**
   ```java
   import java.util.ArrayList;  // Necesario!
   ```

4. **No validar lista vacia:**
   ```java
   // Siempre valida antes de buscar
   if (materiales.isEmpty()) {
       return null;
   }
   ```

### CONCEPTOS APRENDIDOS

1. **Herencia:** Material es la clase padre, Libro/Revista/DVD son hijos
2. **Polimorfismo:** Un ArrayList<Material> puede almacenar cualquier subclase
3. **Clases abstractas:** Material nunca se instancia directamente
4. **Metodos abstractos:** Obligan a las subclases a implementar
5. **super():** Llama al constructor de la clase padre
6. **@Override:** Marca metodos que sobrescriben otros

### DESAFIOS ADICIONALES

Una vez que funcione, intenta:
1. Agregar un metodo para buscar materiales por codigo
2. Filtrar materiales por tipo (solo libros, solo DVDs, etc.)
3. Ordenar el catalogo por antiguedad
4. Agregar un contador estatico de materiales totales creados

---

## 🎓 VENTAJAS DE ESTA ARQUITECTURA

### Sin Herencia (enfoque ingenuo):

```java
// Codigo horrible con duplicacion masiva
public class Biblioteca {
    private ArrayList<Libro> libros;
    private ArrayList<Revista> revistas;
    private ArrayList<DVD> dvds;

    public void mostrarCatalogo() {
        // Duplicacion 1
        for (Libro l : libros) {
            System.out.println("LIBRO [" + l.getCodigo() + "] - '" +
                             l.getTitulo() + "' por " + l.getAutor() + "...");
        }
        // Duplicacion 2
        for (Revista r : revistas) {
            System.out.println("REVISTA [" + r.getCodigo() + "] - '" +
                             r.getTitulo() + "' Ed." + r.getNumero() + "...");
        }
        // Duplicacion 3
        for (DVD d : dvds) {
            System.out.println("DVD [" + d.getCodigo() + "] - '" +
                             d.getTitulo() + "' dirigido por " + d.getDirector() + "...");
        }
    }

    public Material encontrarMasAntiguo() {
        // Codigo HORRIBLE: comparar entre 3 listas diferentes
        Libro libroAntiguo = null;
        for (Libro l : libros) {
            if (libroAntiguo == null || l.getAnio() < libroAntiguo.getAnio()) {
                libroAntiguo = l;
            }
        }
        // ... repetir para revistas y dvds
        // ... luego comparar los 3 resultados
        // ¡MUCHO codigo duplicado!
    }
}
```

**Problemas:**
- Tres listas separadas (difícil de mantener)
- Código duplicado en CADA método
- Agregar un nuevo tipo requiere modificar TODA la clase
- Viola DRY (Don't Repeat Yourself)
- Viola Open/Closed Principle

### Con Herencia (nuestra solución):

```java
public class Biblioteca {
    private ArrayList<Material> materiales;  // UNA sola lista

    public void mostrarCatalogo() {
        for (Material m : materiales) {
            System.out.println(m.mostrarInformacion());  // Polimorfismo!
        }
    }

    public Material encontrarMasAntiguo() {
        Material antiguo = null;
        for (Material m : materiales) {
            if (antiguo == null || m.calcularAntiguedad() > antiguo.calcularAntiguedad()) {
                antiguo = m;
            }
        }
        return antiguo;
    }
}
```

**Ventajas:**
- UNA sola lista (más simple)
- Sin duplicación de código
- Agregar nuevo tipo: solo crear una nueva clase que herede de Material
- Sigue DRY
- Sigue Open/Closed Principle
- Código más legible y mantenible

---

## ✅ CHECKLIST DE DOMINIO

Puedes considerar que dominas este ejercicio cuando:

### Conceptos Básicos:
- [ ] Entiendes qué es una clase abstracta y por qué Material es abstracta
- [ ] Sabes cuándo usar `abstract` vs clase concreta
- [ ] Puedes explicar qué es herencia con un ejemplo
- [ ] Entiendes la diferencia entre `extends` e `implements`

### Implementación:
- [ ] Puedes crear una jerarquía de clases (padre → hijos)
- [ ] Usas correctamente `super()` en constructores
- [ ] Implementas métodos abstractos en las subclases
- [ ] Usas `@Override` apropiadamente

### Polimorfismo:
- [ ] Entiendes por qué `ArrayList<Material>` puede contener Libro/Revista/DVD
- [ ] Sabes cómo funciona el polimorfismo en tiempo de ejecución
- [ ] Puedes agregar un cuarto tipo (ej: AudioLibro) fácilmente

### Buenas Prácticas:
- [ ] Validas listas vacías antes de buscar elementos
- [ ] Usas nombres descriptivos para variables y métodos
- [ ] Tu código compila sin errores
- [ ] Produces la salida esperada

### Tiempo:
- [ ] Implementas la solución completa en < 45 minutos
- [ ] Puedes explicar tu código línea por línea

---

## 🔗 RELACIÓN CON EL EXAMEN

Este ejercicio es la BASE de todo el sistema POO que verás en el examen.

**Conceptos que reaparecen en el examen:**
- ✅ **Herencia:** Vehiculo → Auto/SUV/Camioneta (igual que Material → Libro/Revista/DVD)
- ✅ **Polimorfismo:** `List<Vehiculo>` (igual que `List<Material>`)
- ✅ **Clases abstractas:** Vehiculo es abstracto (igual que Material)
- ✅ **Métodos abstractos:** `aceptar(visitor)` (similar a `mostrarInformacion()`)

**Diferencia clave:**
- Este ejercicio: herencia simple
- Examen: herencia + 3 patrones (Strategy + Visitor + Singleton/Factory)

**Si dominas este ejercicio:**
- Tienes la base sólida para entender el examen
- 30% del camino completado
- Listo para aprender patrones de diseño

---

**Ahora que entiendes como resolverlo, compila y ejecuta tu solucion para verificar que funciona correctamente.**

---

## NIVEL AVANZADO: AGREGANDO FILE I/O, MENU INTERACTIVO Y MANEJO DE EXCEPCIONES

Una vez que dominas la version basica, es hora de agregar funcionalidades profesionales que veras en el examen.

### PARTE 1: Lectura de Archivo biblioteca.txt

**Objetivo:** Cargar los materiales desde un archivo en lugar de crearlos manualmente en el codigo.

**Formato del archivo datos/biblioteca.txt:**

```
4
L001,Cien Años de Soledad,1967,Libro,Gabriel Garcia Marquez,417
R001,National Geographic,2022,Revista,Marzo,245
D001,Inception,2010,DVD,148,Christopher Nolan
L002,El Quijote,1605,Libro,Miguel de Cervantes,863
```

**Estructura:**
- Linea 1: Cantidad N de materiales
- Siguientes N lineas: Codigo,Titulo,Anio,Tipo,Dato1,Dato2
  - Si Tipo=Libro: Dato1=Autor, Dato2=NumPaginas
  - Si Tipo=Revista: Dato1=Mes, Dato2=NumEdicion
  - Si Tipo=DVD: Dato1=Duracion, Dato2=Director

**Codigo para cargar archivo:**

```java
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

public class Biblioteca {
    private ArrayList<Material> materiales;

    public Biblioteca() {
        materiales = new ArrayList<>();
    }

    // NUEVO METODO: Cargar desde archivo
    public void cargarDesdeArchivo(String rutaArchivo) {
        try (BufferedReader reader = new BufferedReader(
                new FileReader(rutaArchivo, StandardCharsets.UTF_8))) {

            // 1. Leer cantidad de materiales
            int cantidad = Integer.parseInt(reader.readLine());
            System.out.println("Cargando " + cantidad + " materiales...");

            // 2. Leer cada material
            for (int i = 0; i < cantidad; i++) {
                String linea = reader.readLine();

                if (linea == null || linea.trim().isEmpty()) {
                    System.out.println("ADVERTENCIA: Linea vacia en archivo");
                    continue;
                }

                parsearYAgregarMaterial(linea);
            }

            System.out.println("Archivo cargado exitosamente.");

        } catch (FileNotFoundException e) {
            System.out.println("ERROR: Archivo no encontrado: " + rutaArchivo);
        } catch (IOException e) {
            System.out.println("ERROR al leer archivo: " + e.getMessage());
        } catch (NumberFormatException e) {
            System.out.println("ERROR: Formato de numero invalido en archivo");
        }
    }

    // Parsear linea CSV y crear material correspondiente
    private void parsearYAgregarMaterial(String linea) {
        try {
            String[] datos = linea.split(",");

            // Validar que tenemos suficientes datos
            if (datos.length < 6) {
                System.out.println("ERROR: Linea con datos insuficientes: " + linea);
                return;
            }

            String codigo = datos[0].trim();
            String titulo = datos[1].trim();
            int anio = Integer.parseInt(datos[2].trim());
            String tipo = datos[3].trim();

            Material material = null;

            // Crear el tipo correcto segun los datos
            switch (tipo.toLowerCase()) {
                case "libro":
                    String autor = datos[4].trim();
                    int paginas = Integer.parseInt(datos[5].trim());
                    material = new Libro(codigo, titulo, anio, autor, paginas);
                    break;

                case "revista":
                    String mes = datos[4].trim();
                    int edicion = Integer.parseInt(datos[5].trim());
                    material = new Revista(codigo, titulo, anio, mes, edicion);
                    break;

                case "dvd":
                    int duracion = Integer.parseInt(datos[4].trim());
                    String director = datos[5].trim();
                    material = new DVD(codigo, titulo, anio, duracion, director);
                    break;

                default:
                    System.out.println("ERROR: Tipo desconocido: " + tipo);
                    return;
            }

            if (material != null) {
                materiales.add(material);
            }

        } catch (NumberFormatException e) {
            System.out.println("ERROR al parsear numeros en: " + linea);
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("ERROR: Datos faltantes en: " + linea);
        }
    }

    // Resto de metodos existentes...
    public void agregarMaterial(Material material) { /* ... */ }
    public void mostrarCatalogo() { /* ... */ }
    public Material encontrarMasAntiguo() { /* ... */ }
}
```

**Puntos clave del manejo de excepciones:**

1. **try-with-resources:** El archivo se cierra automaticamente
2. **Multiples catch:** Manejamos diferentes tipos de errores especificamente
3. **Validacion:** Verificamos lineas vacias y datos suficientes
4. **Mensajes claros:** El usuario sabe exactamente que fallo

### PARTE 2: Menu Interactivo con Scanner

**Objetivo:** Crear un menu que permita al usuario interactuar con el sistema.

```java
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Biblioteca biblioteca = new Biblioteca();

        // Cargar datos iniciales desde archivo
        System.out.println("=== SISTEMA DE BIBLIOTECA ===");
        biblioteca.cargarDesdeArchivo("datos/biblioteca.txt");

        boolean continuar = true;

        while (continuar) {
            mostrarMenu();

            try {
                int opcion = Integer.parseInt(scanner.nextLine());

                switch (opcion) {
                    case 1:
                        mostrarCatalogo(biblioteca);
                        break;

                    case 2:
                        agregarMaterialManual(scanner, biblioteca);
                        break;

                    case 3:
                        buscarPorCodigo(scanner, biblioteca);
                        break;

                    case 4:
                        mostrarMasAntiguo(biblioteca);
                        break;

                    case 5:
                        filtrarPorTipo(scanner, biblioteca);
                        break;

                    case 0:
                        System.out.println("Saliendo del sistema...");
                        continuar = false;
                        break;

                    default:
                        System.out.println("Opcion invalida. Intenta de nuevo.");
                }

            } catch (NumberFormatException e) {
                System.out.println("ERROR: Debes ingresar un numero.");
            } catch (Exception e) {
                System.out.println("ERROR inesperado: " + e.getMessage());
            }

            System.out.println();  // Linea en blanco
        }

        scanner.close();
    }

    private static void mostrarMenu() {
        System.out.println("\n--- MENU PRINCIPAL ---");
        System.out.println("1. Mostrar catalogo completo");
        System.out.println("2. Agregar nuevo material");
        System.out.println("3. Buscar por codigo");
        System.out.println("4. Mostrar material mas antiguo");
        System.out.println("5. Filtrar por tipo");
        System.out.println("0. Salir");
        System.out.print("Selecciona una opcion: ");
    }

    private static void mostrarCatalogo(Biblioteca biblioteca) {
        biblioteca.mostrarCatalogo();
    }

    private static void agregarMaterialManual(Scanner scanner, Biblioteca biblioteca) {
        System.out.println("\n=== AGREGAR NUEVO MATERIAL ===");
        System.out.println("Tipo: 1=Libro, 2=Revista, 3=DVD");
        System.out.print("Selecciona tipo: ");

        try {
            int tipo = Integer.parseInt(scanner.nextLine());

            System.out.print("Codigo: ");
            String codigo = scanner.nextLine();

            System.out.print("Titulo: ");
            String titulo = scanner.nextLine();

            System.out.print("Anio de publicacion: ");
            int anio = Integer.parseInt(scanner.nextLine());

            Material material = null;

            switch (tipo) {
                case 1:  // Libro
                    System.out.print("Autor: ");
                    String autor = scanner.nextLine();
                    System.out.print("Numero de paginas: ");
                    int paginas = Integer.parseInt(scanner.nextLine());
                    material = new Libro(codigo, titulo, anio, autor, paginas);
                    break;

                case 2:  // Revista
                    System.out.print("Mes de publicacion: ");
                    String mes = scanner.nextLine();
                    System.out.print("Numero de edicion: ");
                    int edicion = Integer.parseInt(scanner.nextLine());
                    material = new Revista(codigo, titulo, anio, mes, edicion);
                    break;

                case 3:  // DVD
                    System.out.print("Duracion (minutos): ");
                    int duracion = Integer.parseInt(scanner.nextLine());
                    System.out.print("Director: ");
                    String director = scanner.nextLine();
                    material = new DVD(codigo, titulo, anio, duracion, director);
                    break;

                default:
                    System.out.println("Tipo invalido.");
                    return;
            }

            biblioteca.agregarMaterial(material);
            System.out.println("Material agregado exitosamente!");

        } catch (NumberFormatException e) {
            System.out.println("ERROR: Numero invalido.");
        }
    }

    private static void buscarPorCodigo(Scanner scanner, Biblioteca biblioteca) {
        System.out.print("\nIngresa el codigo a buscar: ");
        String codigo = scanner.nextLine();

        // Necesitas agregar este metodo a Biblioteca
        Material encontrado = biblioteca.buscarPorCodigo(codigo);

        if (encontrado != null) {
            System.out.println("Material encontrado:");
            System.out.println(encontrado.mostrarInformacion());
        } else {
            System.out.println("No se encontro material con codigo: " + codigo);
        }
    }

    private static void mostrarMasAntiguo(Biblioteca biblioteca) {
        Material antiguo = biblioteca.encontrarMasAntiguo();
        if (antiguo != null) {
            System.out.println("\nMaterial mas antiguo:");
            System.out.println(antiguo.mostrarInformacion());
        } else {
            System.out.println("No hay materiales en la biblioteca.");
        }
    }

    private static void filtrarPorTipo(Scanner scanner, Biblioteca biblioteca) {
        System.out.println("\n1=Libros, 2=Revistas, 3=DVDs");
        System.out.print("Tipo a mostrar: ");

        try {
            int tipo = Integer.parseInt(scanner.nextLine());
            String nombreTipo = "";

            switch (tipo) {
                case 1: nombreTipo = "Libro"; break;
                case 2: nombreTipo = "Revista"; break;
                case 3: nombreTipo = "DVD"; break;
                default:
                    System.out.println("Tipo invalido.");
                    return;
            }

            biblioteca.filtrarPorTipo(nombreTipo);

        } catch (NumberFormatException e) {
            System.out.println("ERROR: Numero invalido.");
        }
    }
}
```

### PARTE 3: Uso de Arrays Basicos (Ademas de ArrayList)

**Objetivo:** Demostrar uso de arrays nativos de Java para operaciones especificas.

Agrega estos metodos a la clase Biblioteca:

```java
public class Biblioteca {
    private ArrayList<Material> materiales;

    // ... metodos existentes ...

    // Convertir ArrayList a Array nativo
    public Material[] obtenerMaterialesComoArray() {
        Material[] arrayMateriales = new Material[materiales.size()];

        // Forma 1: con bucle
        for (int i = 0; i < materiales.size(); i++) {
            arrayMateriales[i] = materiales.get(i);
        }

        // Forma 2: con toArray (mas simple)
        // arrayMateriales = materiales.toArray(new Material[0]);

        return arrayMateriales;
    }

    // Ordenar por antiguedad usando array nativo
    public Material[] obtenerMaterialesOrdenadosPorAntiguedad() {
        Material[] array = obtenerMaterialesComoArray();

        // Bubble sort simple
        for (int i = 0; i < array.length - 1; i++) {
            for (int j = 0; j < array.length - i - 1; j++) {
                if (array[j].calcularAntiguedad() < array[j+1].calcularAntiguedad()) {
                    // Intercambiar
                    Material temp = array[j];
                    array[j] = array[j+1];
                    array[j+1] = temp;
                }
            }
        }

        return array;
    }

    // Mostrar usando array
    public void mostrarTop3MasAntiguos() {
        Material[] ordenados = obtenerMaterialesOrdenadosPorAntiguedad();

        System.out.println("\n=== TOP 3 MATERIALES MAS ANTIGUOS ===");
        int limite = Math.min(3, ordenados.length);

        for (int i = 0; i < limite; i++) {
            System.out.println((i+1) + ". " + ordenados[i].mostrarInformacion());
        }
    }
}
```

### CONCEPTOS APRENDIDOS EN NIVEL AVANZADO

1. **File I/O:** Lectura de archivos CSV con try-with-resources
2. **Exception Handling:** FileNotFoundException, IOException, NumberFormatException
3. **Menu Interactivo:** Scanner, loops while, switch-case
4. **Validaciones:** Verificar datos nulos, vacios, formatos incorrectos
5. **Arrays nativos:** Conversion ArrayList a Array[], ordenamiento manual
6. **Separation of Concerns:** Main maneja UI, Biblioteca maneja logica

### EJERCICIO DE PRACTICA

Implementa estas mejoras adicionales:

1. Agregar metodo para GUARDAR cambios a un archivo
2. Implementar busqueda por titulo (parcial)
3. Agregar estadistica: promedio de antiguedad por tipo
4. Validar que no se agreguen codigos duplicados
5. Implementar menu de confirmacion antes de salir

**Este nivel avanzado te prepara directamente para el File I/O del examen.**
