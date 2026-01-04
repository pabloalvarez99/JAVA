# EJERCICIO DISENO #1: Sistema de Biblioteca
**Dificultad: ⭐⭐**

## Requerimientos

Disenar un sistema de gestion de biblioteca que permita:

1. **Gestion de Libros**
   - Agregar nuevos libros al catalogo
   - Buscar libros por titulo, autor o ISBN
   - Ver disponibilidad de un libro

2. **Gestion de Miembros**
   - Registrar nuevos miembros
   - Cada miembro tiene un limite de libros (max 5)
   - Historial de prestamos por miembro

3. **Prestamos**
   - Prestar libro a miembro (si disponible y no excede limite)
   - Devolver libro
   - Calcular multa por retraso ($1 por dia)
   - Duracion maxima de prestamo: 14 dias

4. **Reportes**
   - Libros mas prestados
   - Miembros con multas pendientes

---

## PARTE 1: Tu Diseno

### 1.1 Identifica las Clases
```
Clases principales:
1. _______________
2. _______________
3. _______________
4. _______________
5. _______________
```

### 1.2 Define Atributos de Cada Clase
```
Clase: _______________
- _______________
- _______________
- _______________

Clase: _______________
- _______________
- _______________
```

### 1.3 Define Metodos Principales
```
Clase: _______________
+ _______________()
+ _______________()

Clase: _______________
+ _______________()
```

### 1.4 Dibuja las Relaciones
```
(Dibuja flechas entre clases)
- Herencia: ----▷
- Composicion: ◆----
- Agregacion: ◇----
```

---

## PARTE 2: Implementacion Minima

Despues de disenar, implementa las clases principales.
Guarda tu codigo en: `Diseno01_Biblioteca.java`

---

## PARTE 3: Solucion Propuesta (NO MIRAR ANTES)

### Clases Identificadas

```
+------------------+     +------------------+
|      Libro       |     |     Miembro      |
+------------------+     +------------------+
| - isbn: String   |     | - id: String     |
| - titulo: String |     | - nombre: String |
| - autor: String  |     | - prestamos: List|
| - disponible: bool     | - multaPendiente |
+------------------+     +------------------+
| + prestar()      |     | + puedePrestar() |
| + devolver()     |     | + agregarPrestamo|
+------------------+     +------------------+
        |                        |
        +----------+-------------+
                   |
           +------------------+
           |    Prestamo      |
           +------------------+
           | - libro: Libro   |
           | - miembro: Miembro
           | - fechaPrestamo  |
           | - fechaDevolucion|
           +------------------+
           | + calcularMulta()|
           | + estaAtrasado() |
           +------------------+
                   |
           +------------------+
           |   Biblioteca     |
           +------------------+
           | - libros: Map    |
           | - miembros: Map  |
           | - prestamos: List|
           +------------------+
           | + buscarLibro()  |
           | + prestarLibro() |
           | + devolverLibro()|
           +------------------+
```

### Codigo Esqueleto

```java
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.*;

class Libro {
    private String isbn;
    private String titulo;
    private String autor;
    private boolean disponible = true;

    public Libro(String isbn, String titulo, String autor) {
        this.isbn = isbn;
        this.titulo = titulo;
        this.autor = autor;
    }

    public boolean estaDisponible() { return disponible; }
    public void marcarPrestado() { disponible = false; }
    public void marcarDevuelto() { disponible = true; }

    // getters...
}

class Miembro {
    private String id;
    private String nombre;
    private List<Prestamo> prestamosActivos = new ArrayList<>();
    private double multaPendiente = 0;
    private static final int MAX_PRESTAMOS = 5;

    public boolean puedePrestar() {
        return prestamosActivos.size() < MAX_PRESTAMOS;
    }

    public void agregarPrestamo(Prestamo p) {
        prestamosActivos.add(p);
    }

    public void removerPrestamo(Prestamo p) {
        prestamosActivos.remove(p);
    }
}

class Prestamo {
    private Libro libro;
    private Miembro miembro;
    private LocalDate fechaPrestamo;
    private LocalDate fechaDevolucion;
    private static final int DIAS_PRESTAMO = 14;
    private static final double MULTA_POR_DIA = 1.0;

    public Prestamo(Libro libro, Miembro miembro) {
        this.libro = libro;
        this.miembro = miembro;
        this.fechaPrestamo = LocalDate.now();
    }

    public boolean estaAtrasado() {
        LocalDate limite = fechaPrestamo.plusDays(DIAS_PRESTAMO);
        return LocalDate.now().isAfter(limite);
    }

    public double calcularMulta() {
        if (!estaAtrasado()) return 0;
        long diasAtraso = ChronoUnit.DAYS.between(
            fechaPrestamo.plusDays(DIAS_PRESTAMO),
            LocalDate.now()
        );
        return diasAtraso * MULTA_POR_DIA;
    }
}

class Biblioteca {
    private Map<String, Libro> libros = new HashMap<>();
    private Map<String, Miembro> miembros = new HashMap<>();
    private List<Prestamo> prestamosActivos = new ArrayList<>();

    public void agregarLibro(Libro libro) {
        libros.put(libro.getIsbn(), libro);
    }

    public Prestamo prestarLibro(String isbn, String miembroId) {
        Libro libro = libros.get(isbn);
        Miembro miembro = miembros.get(miembroId);

        if (libro == null || miembro == null) {
            throw new IllegalArgumentException("Libro o miembro no encontrado");
        }
        if (!libro.estaDisponible()) {
            throw new IllegalStateException("Libro no disponible");
        }
        if (!miembro.puedePrestar()) {
            throw new IllegalStateException("Miembro excede limite de prestamos");
        }

        Prestamo prestamo = new Prestamo(libro, miembro);
        libro.marcarPrestado();
        miembro.agregarPrestamo(prestamo);
        prestamosActivos.add(prestamo);

        return prestamo;
    }
}
```

### Patrones Aplicados
- **Repository Pattern**: Biblioteca centraliza acceso a datos
- **Single Responsibility**: Cada clase tiene un proposito claro
- **Encapsulation**: Estados internos protegidos

### Reflexion
- Que pasaria si quisieras diferentes tipos de miembros (estudiante, profesor)?
- Como manejarias reservas de libros?
- Como implementarias notificaciones de vencimiento?
