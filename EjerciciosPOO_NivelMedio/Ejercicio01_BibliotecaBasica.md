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

    public Libro(String codigo, String titulo, int anioPublicacion,
                 String autor, int numeroPaginas) {
        super(codigo, titulo, anioPublicacion);  // Llama al constructor padre
        this.autor = autor;
        this.numeroPaginas = numeroPaginas;
    }

    @Override
    public String mostrarInformacion() {
        return String.format("LIBRO [%s] - '%s' por %s (%d pags.) - %d anios",
                           codigo, titulo, autor, numeroPaginas, calcularAntiguedad());
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

    public Revista(String codigo, String titulo, int anioPublicacion,
                   String mesPublicacion, int numeroEdicion) {
        super(codigo, titulo, anioPublicacion);
        this.mesPublicacion = mesPublicacion;
        this.numeroEdicion = numeroEdicion;
    }

    @Override
    public String mostrarInformacion() {
        return String.format("REVISTA [%s] - '%s' Ed.%d (%s) - %d anios",
                           codigo, titulo, numeroEdicion, mesPublicacion,
                           calcularAntiguedad());
    }

    public String getMesPublicacion() { return mesPublicacion; }
    public int getNumeroEdicion() { return numeroEdicion; }
}
```

```java
public class DVD extends Material {
    private int duracionMinutos;
    private String director;

    public DVD(String codigo, String titulo, int anioPublicacion,
               int duracionMinutos, String director) {
        super(codigo, titulo, anioPublicacion);
        this.duracionMinutos = duracionMinutos;
        this.director = director;
    }

    @Override
    public String mostrarInformacion() {
        return String.format("DVD [%s] - '%s' dirigido por %s (%d min.) - %d anios",
                           codigo, titulo, director, duracionMinutos,
                           calcularAntiguedad());
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
