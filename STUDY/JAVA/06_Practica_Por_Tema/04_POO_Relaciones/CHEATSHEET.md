# 📚 CHEATSHEET - POO con Relaciones en Java

Guía de referencia rápida para resolver ejercicios estilo ayudantía.

---

## 🏗️ ESTRUCTURA BASE DE UN PROYECTO

```
MiProyecto/
├── Fecha.java           ← Clase auxiliar (copiar siempre)
├── EntidadA.java        ← Primera entidad principal
├── EntidadB.java        ← Segunda entidad principal
├── ClaseAsociacion.java ← Vincula A con B
├── Gestora.java         ← Administra todo + reportes
└── Main.java            ← Menú interactivo
```

---

## 📅 CLASE FECHA (Copiar en todos los proyectos)

```java
public class Fecha {
    private int anio, mes, dia;
    
    public Fecha(int anio, int mes, int dia) {
        this.anio = anio;
        this.mes = mes;
        this.dia = dia;
    }
    
    // Getters
    public int getAnio() { return anio; }
    public int getMes() { return mes; }
    public int getDia() { return dia; }
    
    // Comparar: -1 si this < otra, 0 si iguales, 1 si this > otra
    public int comparar(Fecha otra) {
        if (this.anio != otra.anio) return this.anio - otra.anio;
        if (this.mes != otra.mes) return this.mes - otra.mes;
        return this.dia - otra.dia;
    }
    
    public boolean esAnterior(Fecha otra) { return comparar(otra) < 0; }
    public boolean esPosterior(Fecha otra) { return comparar(otra) > 0; }
    public boolean esIgual(Fecha otra) { return comparar(otra) == 0; }
    
    // Verificar si esta fecha está entre inicio y fin (inclusive)
    public boolean estaEntre(Fecha inicio, Fecha fin) {
        return comparar(inicio) >= 0 && comparar(fin) <= 0;
    }
    
    @Override
    public String toString() {
        return String.format("%02d/%02d/%04d", dia, mes, anio);
    }
}
```

---

## 🔗 PATRÓN: CLASE DE ASOCIACIÓN

### Diagrama
```
┌──────────────┐         ┌─────────────────┐         ┌──────────────┐
│  EntidadA    │────────<│   Asociacion    │>────────│  EntidadB    │
├──────────────┤    *    ├─────────────────┤    *    ├──────────────┤
│ - id         │         │ - entidadA      │         │ - id         │
│ - nombre     │         │ - entidadB      │         │ - nombre     │
│ - asociacs   │         │ - fecha         │         │ - asociacs   │
└──────────────┘         │ - datosExtra    │         └──────────────┘
                         └─────────────────┘
```

### Código de la Asociación
```java
public class Asociacion {
    private EntidadA entidadA;
    private EntidadB entidadB;
    private Fecha fechaInicio;
    private Fecha fechaTermino;
    private String datosExtra;
    
    public Asociacion(EntidadA a, EntidadB b, Fecha inicio, Fecha termino, String datos) {
        this.entidadA = a;
        this.entidadB = b;
        this.fechaInicio = inicio;
        this.fechaTermino = termino;
        this.datosExtra = datos;
    }
    
    // Getters y Setters...
    
    // Método clave: ¿Está activo en una fecha?
    public boolean estaActivoEn(Fecha fecha) {
        return fecha.estaEntre(fechaInicio, fechaTermino);
    }
}
```

---

## 📦 PATRÓN: ENTIDAD CON LISTA DE ASOCIACIONES

```java
public class Entidad {
    private String id;
    private String nombre;
    private ArrayList<Asociacion> asociaciones;
    
    public Entidad(String id, String nombre) {
        this.id = id;
        this.nombre = nombre;
        this.asociaciones = new ArrayList<Asociacion>();
    }
    
    // Agregar asociación
    public void agregarAsociacion(Asociacion a) {
        asociaciones.add(a);
    }
    
    // Obtener asociaciones activas en una fecha
    public ArrayList<Asociacion> getActivasEn(Fecha fecha) {
        ArrayList<Asociacion> activas = new ArrayList<Asociacion>();
        for (Asociacion a : asociaciones) {
            if (a.estaActivoEn(fecha)) {
                activas.add(a);
            }
        }
        return activas;
    }
    
    // Contar total
    public int getCantidadAsociaciones() {
        return asociaciones.size();
    }
    
    // Getters...
}
```

---

## 🏢 PATRÓN: CLASE GESTORA

```java
public class Sistema {
    private ArrayList<EntidadA> entidadesA;
    private ArrayList<EntidadB> entidadesB;
    private ArrayList<Asociacion> asociaciones;
    
    public Sistema() {
        this.entidadesA = new ArrayList<EntidadA>();
        this.entidadesB = new ArrayList<EntidadB>();
        this.asociaciones = new ArrayList<Asociacion>();
    }
    
    // ========== AGREGAR ==========
    public void agregarA(EntidadA a) { entidadesA.add(a); }
    public void agregarB(EntidadB b) { entidadesB.add(b); }
    
    // Crear asociación (¡agregar a las 3 listas!)
    public void crearAsociacion(EntidadA a, EntidadB b, Fecha inicio, Fecha fin, String datos) {
        Asociacion asoc = new Asociacion(a, b, inicio, fin, datos);
        a.agregarAsociacion(asoc);
        b.agregarAsociacion(asoc);
        asociaciones.add(asoc);
    }
    
    // ========== BUSCAR ==========
    public EntidadA buscarAPorId(String id) {
        for (EntidadA a : entidadesA) {
            if (a.getId().equals(id)) return a;
        }
        return null;
    }
    
    // ========== REPORTES ==========
    // Ver siguiente sección...
}
```

---

## 📊 PATRONES DE REPORTABILIDAD

### 1. Filtrar por Fecha
```java
public void reportePorFecha(Fecha fecha) {
    System.out.println("=== ACTIVOS EN " + fecha + " ===");
    for (Asociacion a : asociaciones) {
        if (a.estaActivoEn(fecha)) {
            System.out.println(a);
        }
    }
}
```

### 2. Historial de una Entidad
```java
public void reporteHistorial(String id) {
    EntidadA entidad = buscarAPorId(id);
    if (entidad == null) {
        System.out.println("No encontrado");
        return;
    }
    
    System.out.println("=== HISTORIAL DE " + entidad.getNombre() + " ===");
    for (Asociacion a : entidad.getAsociaciones()) {
        System.out.println("- " + a);
    }
}
```

### 3. Historial Ordenado por Fecha
```java
public ArrayList<Asociacion> getHistorialOrdenado(ArrayList<Asociacion> lista) {
    ArrayList<Asociacion> ordenado = new ArrayList<Asociacion>(lista);
    
    // Ordenamiento burbuja por fecha
    for (int i = 0; i < ordenado.size() - 1; i++) {
        for (int j = 0; j < ordenado.size() - i - 1; j++) {
            if (ordenado.get(j).getFechaInicio().esPosterior(
                ordenado.get(j + 1).getFechaInicio())) {
                // Intercambiar
                Asociacion temp = ordenado.get(j);
                ordenado.set(j, ordenado.get(j + 1));
                ordenado.set(j + 1, temp);
            }
        }
    }
    return ordenado;
}
```

### 4. Encontrar el Máximo (más X)
```java
public EntidadA getConMasAsociaciones() {
    if (entidadesA.isEmpty()) return null;
    
    EntidadA maximo = entidadesA.get(0);
    for (EntidadA a : entidadesA) {
        if (a.getCantidadAsociaciones() > maximo.getCantidadAsociaciones()) {
            maximo = a;
        }
    }
    return maximo;
}
```

### 5. Encontrar el Más Antiguo
```java
public EntidadA getMasAntiguo() {
    EntidadA masAntiguo = null;
    Fecha fechaMasAntigua = null;
    
    for (EntidadA a : entidadesA) {
        Fecha primeraFecha = a.getPrimeraFecha(); // Implementar en EntidadA
        if (primeraFecha != null) {
            if (fechaMasAntigua == null || primeraFecha.esAnterior(fechaMasAntigua)) {
                masAntiguo = a;
                fechaMasAntigua = primeraFecha;
            }
        }
    }
    return masAntiguo;
}
```

### 6. Contar por Categoría
```java
public void reporteCantidadPorCategoria() {
    // Usar un enfoque simple sin HashMap
    ArrayList<String> categorias = new ArrayList<String>();
    ArrayList<Integer> conteos = new ArrayList<Integer>();
    
    for (Asociacion a : asociaciones) {
        String cat = a.getCategoria();
        int idx = categorias.indexOf(cat);
        
        if (idx == -1) {
            categorias.add(cat);
            conteos.add(1);
        } else {
            conteos.set(idx, conteos.get(idx) + 1);
        }
    }
    
    for (int i = 0; i < categorias.size(); i++) {
        System.out.println(categorias.get(i) + ": " + conteos.get(i));
    }
}
```

---

## ✅ VALIDACIONES COMUNES

### Verificar Disponibilidad (sin traslape)
```java
public boolean estaDisponible(Fecha inicio, Fecha fin) {
    for (Asociacion a : asociaciones) {
        if (a.seTraslapa(inicio, fin)) {
            return false;
        }
    }
    return true;
}

// En la clase Asociacion:
public boolean seTraslapa(Fecha otroInicio, Fecha otroFin) {
    // NO se traslapan si: uno termina antes de que empiece el otro
    boolean noTraslapa = this.fechaTermino.esAnterior(otroInicio) || 
                         this.fechaInicio.esPosterior(otroFin);
    return !noTraslapa;
}
```

### Verificar Capacidad
```java
public boolean hayCapacidad(int capacidadMaxima) {
    return asociaciones.size() < capacidadMaxima;
}
```

### Verificar Duplicados
```java
public boolean existeId(String id) {
    for (EntidadA a : entidadesA) {
        if (a.getId().equals(id)) return true;
    }
    return false;
}
```

---

## 🖥️ PATRÓN: MENÚ INTERACTIVO

```java
public class Main {
    private static Sistema sistema = new Sistema();
    private static Scanner scanner = new Scanner(System.in);
    
    public static void main(String[] args) {
        cargarDatosPrueba();  // Opcional pero útil
        
        int opcion;
        do {
            mostrarMenu();
            opcion = leerEntero("Opción: ");
            procesarOpcion(opcion);
        } while (opcion != 0);
        
        System.out.println("¡Hasta luego!");
        scanner.close();
    }
    
    private static void mostrarMenu() {
        System.out.println("\n=============================");
        System.out.println("      SISTEMA XYZ");
        System.out.println("=============================");
        System.out.println("1. Agregar A");
        System.out.println("2. Agregar B");
        System.out.println("3. Crear asociación");
        System.out.println("-----------------------------");
        System.out.println("4. Reporte por fecha");
        System.out.println("5. Historial de A");
        System.out.println("6. Estadísticas");
        System.out.println("-----------------------------");
        System.out.println("0. Salir");
    }
    
    private static void procesarOpcion(int opcion) {
        switch (opcion) {
            case 1: agregarA(); break;
            case 2: agregarB(); break;
            case 3: crearAsociacion(); break;
            case 4: reporteFecha(); break;
            case 5: historialA(); break;
            case 6: sistema.reporteEstadisticas(); break;
            case 0: break;
            default: System.out.println("Opción inválida");
        }
    }
    
    // ========== MÉTODOS DE LECTURA ==========
    
    private static String leerTexto(String mensaje) {
        System.out.print(mensaje);
        return scanner.nextLine();
    }
    
    private static int leerEntero(String mensaje) {
        System.out.print(mensaje);
        while (!scanner.hasNextInt()) {
            System.out.print("Número inválido. " + mensaje);
            scanner.next();
        }
        int valor = scanner.nextInt();
        scanner.nextLine();  // Limpiar buffer
        return valor;
    }
    
    private static Fecha leerFecha() {
        int anio = leerEntero("  Año: ");
        int mes = leerEntero("  Mes: ");
        int dia = leerEntero("  Día: ");
        return new Fecha(anio, mes, dia);
    }
    
    // ========== MÉTODOS DEL MENÚ ==========
    
    private static void agregarA() {
        System.out.println("\n--- AGREGAR A ---");
        String id = leerTexto("ID: ");
        String nombre = leerTexto("Nombre: ");
        sistema.agregarA(new EntidadA(id, nombre));
        System.out.println("Agregado exitosamente.");
    }
    
    // ... más métodos ...
}
```

---

## 🔢 CÁLCULOS ÚTILES

### Calcular Días Entre Fechas (aproximado)
```java
public int calcularDiasEntre(Fecha inicio, Fecha fin) {
    int diasInicio = inicio.getAnio() * 365 + inicio.getMes() * 30 + inicio.getDia();
    int diasFin = fin.getAnio() * 365 + fin.getMes() * 30 + fin.getDia();
    return diasFin - diasInicio;
}
```

### Calcular Monto Total
```java
public int calcularMontoTotal() {
    return calcularDiasEntre(fechaInicio, fechaTermino) * precioPorDia;
}
```

### Calcular Promedio
```java
public double calcularPromedio() {
    if (asociaciones.isEmpty()) return 0;
    
    int suma = 0;
    for (Asociacion a : asociaciones) {
        suma += a.getValor();
    }
    return (double) suma / asociaciones.size();
}
```

---

## 📝 CHECKLIST ANTES DE ENTREGAR

- [ ] Todas las clases tienen constructor
- [ ] Todas las clases tienen getters (y setters si necesario)
- [ ] Todas las clases tienen toString()
- [ ] La clase de asociación tiene método `estaActivoEn(Fecha)`
- [ ] Las entidades tienen lista de asociaciones
- [ ] La gestora tiene los 3 ArrayList
- [ ] La gestora crea asociaciones agregando a las 3 listas
- [ ] Todos los reportes del enunciado están implementados
- [ ] Las estadísticas están implementadas
- [ ] El menú tiene todas las opciones
- [ ] Hay datos de prueba cargados

---

## 🚀 TIPS DE VELOCIDAD

1. **Copiar la clase Fecha** al inicio (siempre es igual)
2. **Empezar por las entidades simples** (sin listas)
3. **Crear la clase de asociación** con referencias a las entidades
4. **Agregar ArrayList** a las entidades
5. **Crear la clase gestora** con los 3 ArrayList
6. **Implementar el menú** básico
7. **Agregar reportes** uno por uno
8. **Probar con datos de prueba**

---

## ⚠️ ERRORES COMUNES

| Error | Solución |
|-------|----------|
| `NullPointerException` al buscar | Verificar si `buscarPorId()` retorna null antes de usar |
| Lista vacía en entidad | Inicializar en constructor: `lista = new ArrayList<>()` |
| Asociación no aparece en entidad | Agregar a las 3 listas (entidadA, entidadB, gestora) |
| Fechas comparadas mal | Usar métodos de Fecha, no comparar directamente |
| Scanner no lee bien | Agregar `scanner.nextLine()` después de `nextInt()` |

---

## 📖 EJEMPLO RÁPIDO COMPLETO

Ver carpeta `Ejemplos_Resueltos/Biblioteca/` para un ejemplo completamente funcional.
