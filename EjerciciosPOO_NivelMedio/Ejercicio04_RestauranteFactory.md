# Ejercicio 4: Sistema de Restaurante con Factory (Nivel 2)
**Dificultad:** Medio
**Tiempo estimado:** 45 minutos
**Conceptos:** Factory Pattern, Herencia, Encapsulamiento

---

## Contexto

Una cadena de restaurantes necesita un sistema para gestionar pedidos. Los restaurantes ofrecen tres tipos de menu: Desayuno, Almuerzo y Cena. Cada tipo de menu tiene diferentes platos disponibles.

## Requisitos

### Platos:

Todos los platos tienen:
- Nombre (String)
- Precio (double)
- Tiempo de preparacion en minutos (int)

Tipos de platos:
- **Entrada:** porcion (String) - ejemplos: "Individual", "Para compartir"
- **PlatoPrincipal:** tipo de proteina (String) - ejemplos: "Pollo", "Res", "Pescado"
- **Postre:** calorias (int)

### Factory Pattern:

Implementar una **Factory** que cree menus completos segun el tipo:

**Menu Desayuno:** (Total ~$15)
- Entrada: "Frutas Frescas" - $5.00 - 5 min - "Individual"
- Principal: "Huevos Revueltos" - $7.00 - 10 min - "Huevo"
- Postre: "Yogurt" - $3.00 - 2 min - 150 calorias

**Menu Almuerzo:** (Total ~$25)
- Entrada: "Ensalada Cesar" - $8.00 - 8 min - "Individual"
- Principal: "Pollo a la Parrilla" - $15.00 - 20 min - "Pollo"
- Postre: "Helado" - $4.00 - 3 min - 250 calorias

**Menu Cena:** (Total ~$35)
- Entrada: "Tabla de Quesos" - $12.00 - 10 min - "Para compartir"
- Principal: "Salmon al Horno" - $22.00 - 25 min - "Pescado"
- Postre: "Torta de Chocolate" - $6.00 - 15 min - 400 calorias

### Funcionalidades:

1. **Crear menus** usando la Factory segun el tipo solicitado
2. **Calcular precio total** del menu
3. **Calcular tiempo total** de preparacion
4. **Mostrar detalle** de cada plato del menu

## Ejemplo de Ejecucion

```
=== SISTEMA DE RESTAURANTE ===

Creando Menu de Desayuno...
--- MENU DESAYUNO ---
Entrada: Frutas Frescas ($5.00, 5 min) - Porcion: Individual
Principal: Huevos Revueltos ($7.00, 10 min) - Proteina: Huevo
Postre: Yogurt ($3.00, 2 min) - 150 calorias
Precio Total: $15.00
Tiempo de Preparacion: 17 minutos

Creando Menu de Almuerzo...
--- MENU ALMUERZO ---
Entrada: Ensalada Cesar ($8.00, 8 min) - Porcion: Individual
Principal: Pollo a la Parrilla ($15.00, 20 min) - Proteina: Pollo
Postre: Helado ($4.00, 3 min) - 250 calorias
Precio Total: $27.00
Tiempo de Preparacion: 31 minutos

Creando Menu de Cena...
--- MENU CENA ---
Entrada: Tabla de Quesos ($12.00, 10 min) - Porcion: Para compartir
Principal: Salmon al Horno ($22.00, 25 min) - Proteina: Pescado
Postre: Torta de Chocolate ($6.00, 15 min) - 400 calorias
Precio Total: $40.00
Tiempo de Preparacion: 50 minutos
```

## Debe entregar:

- Clase abstracta `Plato` con subclases `Entrada`, `PlatoPrincipal`, `Postre`
- Clase `Menu` que contenga 3 platos (entrada, principal, postre)
- Clase **`MenuFactory`** con metodo estatico `crearMenu(String tipo)` que:
  - Recibe "Desayuno", "Almuerzo" o "Cena"
  - Retorna un objeto `Menu` completo con los platos correspondientes
- Clase `Main` que demuestre la creacion de los 3 tipos de menu

## Consideraciones:

- **DEBE usar el patron Factory correctamente**
- La Factory debe tener un metodo estatico (no se instancia)
- Cada tipo de menu debe tener platos especificos predefinidos
- Validar que el tipo de menu sea valido
- Los calculos deben ser correctos

## Pistas - Estructura Factory:

```java
public class MenuFactory {
    public static Menu crearMenu(String tipo) {
        Menu menu = new Menu();

        switch(tipo.toLowerCase()) {
            case "desayuno":
                // Crear y agregar platos de desayuno
                break;
            case "almuerzo":
                // Crear y agregar platos de almuerzo
                break;
            case "cena":
                // Crear y agregar platos de cena
                break;
            default:
                throw new IllegalArgumentException("Tipo de menu invalido");
        }

        return menu;
    }
}
```

## Preguntas para reflexionar:

1. ¿Cual es la ventaja de usar Factory en lugar de crear los menus manualmente?
2. ¿Que pasa si quieres agregar un nuevo tipo de menu (por ejemplo, "Brunch")?
3. ¿Por que el metodo de la Factory es estatico?

---

## PASO A PASO: COMO RESOLVER ESTE EJERCICIO

Este ejercicio te ensenara el **Patron Factory**, otro patron importante que puedes elegir en el examen (alternativa al Singleton).

### PASO 1: Entender el Patron Factory

**Problema sin Factory:**
```java
// Codigo malo - if-else gigante
if (tipo.equals("desayuno")) {
    entrada = new Entrada("Frutas Frescas", 5.00, 5, "Individual");
    principal = new PlatoPrincipal("Huevos Revueltos", 7.00, 10, "Huevo");
    postre = new Postre("Yogurt", 3.00, 2, 150);
} else if (tipo.equals("almuerzo")) {
    // ... repetir codigo similar
}
```

**Solucion con Factory:**
```java
// Codigo limpio - delega la creacion a una Factory
Menu menu = MenuFactory.crearMenu("desayuno");
```

**Ventajas:**
- Centraliza la logica de creacion
- Facilita agregar nuevos tipos de menu
- Codigo mas limpio y mantenible

### PASO 2: Crear la Jerarquia de Platos

```java
// Clase base abstracta
public abstract class Plato {
    protected String nombre;
    protected double precio;
    protected int tiempoPreparacion;

    public Plato(String nombre, double precio, int tiempoPreparacion) {
        this.nombre = nombre;
        this.precio = precio;
        this.tiempoPreparacion = tiempoPreparacion;
    }

    public abstract String obtenerDetalles();

    public String getNombre() { return nombre; }
    public double getPrecio() { return precio; }
    public int getTiempoPreparacion() { return tiempoPreparacion; }
}
```

```java
public class Entrada extends Plato {
    private String porcion;

    public Entrada(String nombre, double precio, int tiempo, String porcion) {
        super(nombre, precio, tiempo);
        this.porcion = porcion;
    }

    @Override
    public String obtenerDetalles() {
        return String.format("Entrada: %s ($%.2f, %d min) - Porcion: %s",
                           nombre, precio, tiempoPreparacion, porcion);
    }
}
```

```java
public class PlatoPrincipal extends Plato {
    private String tipoProteina;

    public PlatoPrincipal(String nombre, double precio, int tiempo, String proteina) {
        super(nombre, precio, tiempo);
        this.tipoProteina = proteina;
    }

    @Override
    public String obtenerDetalles() {
        return String.format("Principal: %s ($%.2f, %d min) - Proteina: %s",
                           nombre, precio, tiempoPreparacion, tipoProteina);
    }
}
```

```java
public class Postre extends Plato {
    private int calorias;

    public Postre(String nombre, double precio, int tiempo, int calorias) {
        super(nombre, precio, tiempo);
        this.calorias = calorias;
    }

    @Override
    public String obtenerDetalles() {
        return String.format("Postre: %s ($%.2f, %d min) - %d calorias",
                           nombre, precio, tiempoPreparacion, calorias);
    }
}
```

### PASO 3: Crear la Clase Menu

```java
public class Menu {
    private Entrada entrada;
    private PlatoPrincipal principal;
    private Postre postre;
    private String tipoMenu;

    public Menu(String tipoMenu) {
        this.tipoMenu = tipoMenu;
    }

    // Setters para agregar platos
    public void setEntrada(Entrada entrada) {
        this.entrada = entrada;
    }

    public void setPrincipal(PlatoPrincipal principal) {
        this.principal = principal;
    }

    public void setPostre(Postre postre) {
        this.postre = postre;
    }

    // Calcular precio total
    public double calcularPrecioTotal() {
        double total = 0;
        if (entrada != null) total += entrada.getPrecio();
        if (principal != null) total += principal.getPrecio();
        if (postre != null) total += postre.getPrecio();
        return total;
    }

    // Calcular tiempo total
    public int calcularTiempoTotal() {
        int total = 0;
        if (entrada != null) total += entrada.getTiempoPreparacion();
        if (principal != null) total += principal.getTiempoPreparacion();
        if (postre != null) total += postre.getTiempoPreparacion();
        return total;
    }

    // Mostrar menu completo
    public void mostrarMenu() {
        System.out.println("--- MENU " + tipoMenu.toUpperCase() + " ---");
        if (entrada != null) System.out.println(entrada.obtenerDetalles());
        if (principal != null) System.out.println(principal.obtenerDetalles());
        if (postre != null) System.out.println(postre.obtenerDetalles());
        System.out.println(String.format("Precio Total: $%.2f", calcularPrecioTotal()));
        System.out.println(String.format("Tiempo de Preparacion: %d minutos", calcularTiempoTotal()));
        System.out.println();
    }
}
```

### PASO 4: Crear el MenuFactory (CORAZON DEL PATRON)

```java
public class MenuFactory {

    // Metodo estatico - no necesitas instancia para usarlo
    public static Menu crearMenu(String tipo) {
        Menu menu = new Menu(tipo);

        switch(tipo.toLowerCase()) {
            case "desayuno":
                menu.setEntrada(new Entrada("Frutas Frescas", 5.00, 5, "Individual"));
                menu.setPrincipal(new PlatoPrincipal("Huevos Revueltos", 7.00, 10, "Huevo"));
                menu.setPostre(new Postre("Yogurt", 3.00, 2, 150));
                break;

            case "almuerzo":
                menu.setEntrada(new Entrada("Ensalada Cesar", 8.00, 8, "Individual"));
                menu.setPrincipal(new PlatoPrincipal("Pollo a la Parrilla", 15.00, 20, "Pollo"));
                menu.setPostre(new Postre("Helado", 4.00, 3, 250));
                break;

            case "cena":
                menu.setEntrada(new Entrada("Tabla de Quesos", 12.00, 10, "Para compartir"));
                menu.setPrincipal(new PlatoPrincipal("Salmon al Horno", 22.00, 25, "Pescado"));
                menu.setPostre(new Postre("Torta de Chocolate", 6.00, 15, 400));
                break;

            default:
                throw new IllegalArgumentException("Tipo de menu invalido: " + tipo);
        }

        return menu;
    }
}
```

**Puntos clave del Factory:**
- Metodo `static` - se llama sin crear instancia: `MenuFactory.crearMenu(...)`
- Centraliza TODA la logica de creacion de menus
- Retorna un objeto Menu completamente configurado
- Usa `switch` para determinar que platos crear

### PASO 5: Crear el Main

```java
public class Main {
    public static void main(String[] args) {
        System.out.println("=== SISTEMA DE RESTAURANTE ===\n");

        // Crear menu de desayuno usando Factory
        System.out.println("Creando Menu de Desayuno...");
        Menu desayuno = MenuFactory.crearMenu("desayuno");
        desayuno.mostrarMenu();

        // Crear menu de almuerzo usando Factory
        System.out.println("Creando Menu de Almuerzo...");
        Menu almuerzo = MenuFactory.crearMenu("almuerzo");
        almuerzo.mostrarMenu();

        // Crear menu de cena usando Factory
        System.out.println("Creando Menu de Cena...");
        Menu cena = MenuFactory.crearMenu("cena");
        cena.mostrarMenu();

        // Intentar crear un menu invalido
        try {
            System.out.println("Intentando crear menu invalido...");
            Menu invalido = MenuFactory.crearMenu("brunch");
        } catch (IllegalArgumentException e) {
            System.out.println("ERROR: " + e.getMessage());
        }
    }
}
```

### PASO 6: Compilar y Ejecutar

```bash
javac Plato.java Entrada.java PlatoPrincipal.java Postre.java Menu.java MenuFactory.java Main.java
java Main
```

### ERRORES COMUNES

1. **Factory NO estatica:**
   ```java
   // INCORRECTO
   public Menu crearMenu(String tipo) { }

   // CORRECTO
   public static Menu crearMenu(String tipo) { }
   ```

2. **No validar tipo de menu:**
   ```java
   // Siempre usa default en switch
   default:
       throw new IllegalArgumentException("Tipo invalido");
   ```

3. **Olvidar retornar el menu:**
   ```java
   // INCORRECTO
   public static Menu crearMenu(String tipo) {
       Menu menu = new Menu(tipo);
       // ... configurar platos
       // Falta return!
   }

   // CORRECTO
   return menu;
   ```

### CONCEPTOS APRENDIDOS

1. **Patron Factory:** Centraliza la creacion de objetos complejos
2. **Metodos estaticos:** Se llaman sin instancia de la clase
3. **Encapsulacion:** La logica de creacion esta oculta del cliente
4. **Manejo de excepciones:** Lanzar excepciones para entradas invalidas

### COMPARACION: FACTORY VS CREACION MANUAL

**Sin Factory (codigo malo):**
```java
Menu desayuno = new Menu("desayuno");
desayuno.setEntrada(new Entrada("Frutas Frescas", 5.00, 5, "Individual"));
desayuno.setPrincipal(new PlatoPrincipal("Huevos Revueltos", 7.00, 10, "Huevo"));
desayuno.setPostre(new Postre("Yogurt", 3.00, 2, 150));
// Repetir esto para cada menu... codigo duplicado!
```

**Con Factory (codigo bueno):**
```java
Menu desayuno = MenuFactory.crearMenu("desayuno");
// Una sola linea - limpio y facil!
```

### DESAFIOS ADICIONALES

1. Agrega un nuevo tipo de menu: "Brunch" con platos diferentes
2. Agrega validacion de precios (no negativos)
3. Implementa un menu vegetariano con proteina vegetal
4. Agrega bebidas como cuarto componente del menu
5. Crea una Factory para diferentes tipos de restaurante (Italiano, Mexicano, etc.)

---

**El patron Factory es uno de los patrones que puedes elegir en el examen (Singleton o Factory).**
