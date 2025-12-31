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

---

## 🎓 VENTAJAS DE ESTA ARQUITECTURA

### Sin Factory (enfoque ingenuo):

```java
// CODIGO MALO: If-else gigante repetido en cada lugar
public class Main {
    public static void main(String[] args) {
        String tipoMenu = "desayuno";
        Menu menu = new Menu(tipoMenu);

        // PROBLEMA 1: Codigo duplicado y repetitivo
        if (tipoMenu.equals("desayuno")) {
            Entrada entrada = new Entrada("Frutas Frescas", 5.00, 5, "Individual");
            PlatoPrincipal principal = new PlatoPrincipal("Huevos Revueltos", 7.00, 10, "Huevo");
            Postre postre = new Postre("Yogurt", 3.00, 2, 150);
            menu.setEntrada(entrada);
            menu.setPrincipal(principal);
            menu.setPostre(postre);
        } else if (tipoMenu.equals("almuerzo")) {
            Entrada entrada = new Entrada("Ensalada Cesar", 8.00, 8, "Individual");
            PlatoPrincipal principal = new PlatoPrincipal("Pollo a la Parrilla", 15.00, 20, "Pollo");
            Postre postre = new Postre("Helado", 4.00, 3, 250);
            menu.setEntrada(entrada);
            menu.setPrincipal(principal);
            menu.setPostre(postre);
        } else if (tipoMenu.equals("cena")) {
            Entrada entrada = new Entrada("Tabla de Quesos", 12.00, 10, "Para compartir");
            PlatoPrincipal principal = new PlatoPrincipal("Salmon al Horno", 22.00, 25, "Pescado");
            Postre postre = new Postre("Torta de Chocolate", 6.00, 15, 400);
            menu.setEntrada(entrada);
            menu.setPrincipal(principal);
            menu.setPostre(postre);
        }

        // PROBLEMA 2: Si necesitas crear otro menu, copias TODO el if-else
        // PROBLEMA 3: Para agregar "brunch", modificas CADA lugar con este codigo
        // PROBLEMA 4: Facil cometer errores (olvidar un plato, precio equivocado)
    }
}

// Metodo alternativo igualmente malo
public class Menu {
    public void crearDesayuno() {
        this.entrada = new Entrada(...);
        this.principal = new PlatoPrincipal(...);
        this.postre = new Postre(...);
    }

    public void crearAlmuerzo() {
        // Codigo duplicado...
    }

    public void crearCena() {
        // Mas codigo duplicado...
    }
}
```

**Problemas criticos:**
- Codigo altamente repetitivo (viola DRY)
- Dificil de mantener (cambios requieren editar multiples lugares)
- Propenso a errores (copiar-pegar bugs)
- Agregar nuevo tipo de menu requiere modificar multiples clases
- Viola Open/Closed Principle
- No hay separacion de responsabilidades

### Con Factory (nuestra solucion):

```java
// CODIGO BUENO: Una sola linea crea el menu completo
public class Main {
    public static void main(String[] args) {
        // VENTAJA 1: Creacion simple y elegante
        Menu desayuno = MenuFactory.crearMenu("desayuno");
        Menu almuerzo = MenuFactory.crearMenu("almuerzo");
        Menu cena = MenuFactory.crearMenu("cena");

        // VENTAJA 2: Toda la logica de creacion esta centralizada
        // VENTAJA 3: Para agregar "brunch", solo modificas MenuFactory
        // VENTAJA 4: Codigo limpio y facil de entender
    }
}

// Factory centraliza TODA la logica de creacion
public class MenuFactory {
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
                throw new IllegalArgumentException("Tipo de menu invalido");
        }

        return menu;
    }

    // VENTAJA 5: Agregar "brunch" es facil
    // Solo agregas un nuevo case - no tocas nada mas
}
```

**Ventajas:**
- Centralizacion: toda la logica de creacion en UN solo lugar
- Simplicidad: una linea crea un menu completo
- Mantenibilidad: cambios en un solo archivo
- Extensibilidad: agregar nuevos tipos es trivial
- Validacion: errores detectados en un solo punto
- Testeable: facil hacer pruebas unitarias del factory

---

## ✅ CHECKLIST DE DOMINIO

Puedes considerar que dominas este ejercicio cuando:

### Conceptos Factory:
- [ ] Entiendes por que Factory centraliza la creacion de objetos
- [ ] Sabes cuando usar Factory vs creacion directa con `new`
- [ ] Puedes explicar la diferencia entre Factory Method y Abstract Factory
- [ ] Identificas casos donde Factory simplifica el codigo

### Implementacion:
- [ ] Implementas metodo estatico `crearMenu(String tipo)`
- [ ] Usas switch/if para determinar que tipo crear
- [ ] Lanzas excepcion para tipos invalidos
- [ ] Retornas un objeto completamente configurado
- [ ] No necesitas instanciar la Factory (metodo estatico)

### Jerarquia de Platos:
- [ ] Creas clase abstracta `Plato` correctamente
- [ ] Implementas tres subclases (Entrada, PlatoPrincipal, Postre)
- [ ] Cada subclase tiene atributos especificos
- [ ] Sobrescribes `obtenerDetalles()` en cada subclase
- [ ] Usas `super()` correctamente en constructores

### Logica de Negocio:
- [ ] Calculas precio total sumando todos los platos
- [ ] Calculas tiempo total de preparacion
- [ ] Muestras detalles completos del menu
- [ ] Validas que los platos no sean null
- [ ] Formateas precios con 2 decimales

### Tiempo:
- [ ] Implementas la solucion completa en < 45 minutos
- [ ] Puedes agregar un nuevo tipo de menu en < 5 minutos
- [ ] Explicas las ventajas de Factory vs creacion manual

---

## 🔗 RELACION CON EL EXAMEN

Este patron es una ALTERNATIVA a Singleton - debes elegir uno de los dos para el examen.

### Comparacion: Este Ejercicio vs Examen

| Aspecto | Ejercicio 04 | Examen Real |
|---------|--------------|-------------|
| **Patron usado** | Factory | Factory O Singleton (tu eliges) |
| | MenuFactory | VehiculoFactory (si eliges Factory) |
| **Estructura** | Factory + Herencia | Factory + Visitor + Strategy |
| **Complejidad** | Basica (solo Factory) | Media (3 patrones combinados) |
| **Tiempo estimado** | 45 minutos | 20-25 minutos (parte Factory) |
| **Tipos creados** | 3 tipos de menu | 3 tipos de vehiculo |
| **Metodo estatico** | Si | Si |
| **Lectura archivo** | No | Si (vehiculos desde archivo) |
| **Porcentaje del examen** | ~25% | Factory es ~30% del total |

### Como se usa Factory en el examen:

**En el examen (si eliges Factory):**
```java
public class VehiculoFactory {
    public static Vehiculo crearVehiculo(String tipo, String patente,
                                        String marca, double consumo) {
        switch(tipo.toLowerCase()) {
            case "auto":
                return new Auto(patente, marca, consumo);
            case "suv":
                return new SUV(patente, marca, consumo);
            case "camioneta":
                return new Camioneta(patente, marca, consumo);
            default:
                throw new IllegalArgumentException("Tipo invalido: " + tipo);
        }
    }
}

// En SistemaRentaCar al leer archivo
public void cargarVehiculos(String archivo) {
    // ... leer linea
    String[] datos = linea.split(",");
    String tipo = datos[0];
    String patente = datos[1];
    // ...

    // USAR EL FACTORY
    Vehiculo v = VehiculoFactory.crearVehiculo(tipo, patente, marca, consumo);
    vehiculos.add(v);
}
```

**Diferencias clave con este ejercicio:**
1. **Parametros dinamicos:** En el examen, los datos vienen del archivo
2. **Integracion:** Factory se usa DENTRO del sistema principal
3. **Combinacion:** Factory + Visitor + Strategy trabajando juntos

### Que cubre este ejercicio:

- ✅ **30% del examen:** Patron Factory completo
- ✅ **Herencia:** Plato → Entrada/Principal/Postre (similar a Vehiculo → Auto/SUV/Camioneta)
- ✅ **Metodo estatico:** Como debe implementarse
- ✅ **Validacion:** Detectar tipos invalidos
- ❌ **No cubre:** Visitor, Strategy, File I/O (ver Ejercicios 05, 06, 07)

### Factory vs Singleton - ¿Cual elegir en el examen?

**Elige Factory si:**
- Te sientes comodo creando objetos dinamicamente
- Prefieres codigo mas "orientado a objetos"
- Quieres practicar herencia + factory juntos

**Elige Singleton si:**
- Prefieres un patron mas simple
- Quieres control centralizado del sistema
- Te sientes mas seguro con menos complejidad

**AMBOS son igualmente validos en el examen.**

### Proximos pasos sugeridos:

1. **Si elegiste Factory para el examen:**
   - ✅ Ejercicio 04 (este) - Dominar Factory puro
   - ➡️ Ejercicio 05 - Agregar lectura de archivos
   - ➡️ Ejercicio 06 - Aprender Visitor
   - ➡️ Ejercicio 07 - Combinar Factory + Visitor + Strategy
   - ➡️ Ejercicio 10 - Simulacro completo (adaptar con Factory)

2. **Si elegiste Singleton para el examen:**
   - Puedes saltar al Ejercicio 05
   - Pero IGUAL entiende Factory (concepto importante POO)

### Errores comunes en el examen relacionados con Factory:

1. **Factory no estatica** → Tienes que instanciarla (innecesario)
2. **No validar tipo invalido** → NullPointerException
3. **Olvidar retornar el objeto** → Error de compilacion
4. **Factory dentro de Main** → Mala separacion de responsabilidades

### Tips para el examen:

- ⏱️ **Tiempo:** Dedica MAX 20 minutos al Factory
- 📝 **Plantilla:** Memoriza la estructura switch/case
- ✅ **Validacion:** Siempre incluye `default` con excepcion
- 🔍 **Integracion:** El Factory se usa en `cargarVehiculos()`

---

**Si dominas este ejercicio, tienes el 30% del examen garantizado (alternativa a Singleton). Elige el patron que mas te guste y dominalo completamente.**
