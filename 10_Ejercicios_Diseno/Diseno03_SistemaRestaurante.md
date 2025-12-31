# EJERCICIO DISENO #3: Sistema de Restaurante
**Dificultad: ⭐⭐⭐**

## Requerimientos

Disenar un sistema para gestionar un restaurante:

1. **Menu**
   - Items con nombre, descripcion, precio
   - Categorias: Entrada, Principal, Postre, Bebida
   - Items pueden estar disponibles o no

2. **Mesas**
   - Numero de mesa y capacidad
   - Estados: Libre, Ocupada, Reservada

3. **Pedidos**
   - Asociado a una mesa
   - Multiple items con cantidades
   - Estados: Pendiente, En Preparacion, Listo, Entregado, Pagado

4. **Cuenta**
   - Calcular total del pedido
   - Aplicar propina sugerida (10%, 15%, 20%)
   - Dividir cuenta entre comensales

---

## PARTE 1: Tu Diseno

### 1.1 Identifica Clases y Estados
```
Clases principales:
1. _______________
2. _______________
3. _______________
4. _______________

Enums (estados):
1. _______________
2. _______________
```

### 1.2 Flujo del Sistema
```
1. Cliente llega -> _______________
2. Mesero toma pedido -> _______________
3. Cocina prepara -> _______________
4. Cliente paga -> _______________
```

---

## PARTE 2: Preguntas de Diseno

1. **Como manejas modificaciones al pedido?**
   (Agregar item, quitar item, cambiar cantidad)

2. **Pedido vs LineaPedido - por que separar?**

3. **Como notificarias a la cocina de nuevos pedidos?**

---

## PARTE 3: Solucion Propuesta (NO MIRAR ANTES)

### Diagrama de Clases

```
+------------------+
|   Categoria      | <<enum>>
+------------------+
| ENTRADA          |
| PRINCIPAL        |
| POSTRE           |
| BEBIDA           |
+------------------+

+------------------+
|   EstadoMesa     | <<enum>>
+------------------+
| LIBRE            |
| OCUPADA          |
| RESERVADA        |
+------------------+

+------------------+
|  EstadoPedido    | <<enum>>
+------------------+
| PENDIENTE        |
| EN_PREPARACION   |
| LISTO            |
| ENTREGADO        |
| PAGADO           |
+------------------+

+------------------+     +------------------+
|    MenuItem      |     |      Mesa        |
+------------------+     +------------------+
| - id: String     |     | - numero: int    |
| - nombre: String |     | - capacidad: int |
| - precio: double |     | - estado: Estado |
| - categoria      |     +------------------+
| - disponible     |     | + ocupar()       |
+------------------+     | + liberar()      |
                         +------------------+
        |                        |
        v                        v
+------------------+     +------------------+
|   LineaPedido    |---->|     Pedido       |
+------------------+     +------------------+
| - item: MenuItem |     | - id: String     |
| - cantidad: int  |     | - mesa: Mesa     |
| - notas: String  |     | - lineas: List   |
+------------------+     | - estado: Estado |
| + getSubtotal()  |     | - horaCreacion   |
+------------------+     +------------------+
                         | + agregarItem()  |
                         | + calcularTotal()|
                         | + cambiarEstado()|
                         +------------------+
                                 |
                                 v
                         +------------------+
                         |     Cuenta       |
                         +------------------+
                         | - pedido: Pedido |
                         | - propina: double|
                         +------------------+
                         | + getTotal()     |
                         | + dividirEntre() |
                         +------------------+
```

### Codigo Esqueleto

```java
import java.util.*;
import java.time.LocalDateTime;

enum Categoria { ENTRADA, PRINCIPAL, POSTRE, BEBIDA }
enum EstadoMesa { LIBRE, OCUPADA, RESERVADA }
enum EstadoPedido { PENDIENTE, EN_PREPARACION, LISTO, ENTREGADO, PAGADO }

class MenuItem {
    private String id;
    private String nombre;
    private String descripcion;
    private double precio;
    private Categoria categoria;
    private boolean disponible = true;

    public MenuItem(String nombre, double precio, Categoria categoria) {
        this.id = UUID.randomUUID().toString().substring(0, 6);
        this.nombre = nombre;
        this.precio = precio;
        this.categoria = categoria;
    }

    // getters, setters...
}

class Mesa {
    private int numero;
    private int capacidad;
    private EstadoMesa estado = EstadoMesa.LIBRE;

    public void ocupar() {
        if (estado != EstadoMesa.LIBRE)
            throw new IllegalStateException("Mesa no disponible");
        estado = EstadoMesa.OCUPADA;
    }

    public void liberar() {
        estado = EstadoMesa.LIBRE;
    }
}

class LineaPedido {
    private MenuItem item;
    private int cantidad;
    private String notas; // "sin cebolla", "extra picante"

    public LineaPedido(MenuItem item, int cantidad) {
        this.item = item;
        this.cantidad = cantidad;
    }

    public double getSubtotal() {
        return item.getPrecio() * cantidad;
    }
}

class Pedido {
    private String id;
    private Mesa mesa;
    private List<LineaPedido> lineas = new ArrayList<>();
    private EstadoPedido estado = EstadoPedido.PENDIENTE;
    private LocalDateTime horaCreacion;

    public Pedido(Mesa mesa) {
        this.id = "PED-" + System.currentTimeMillis();
        this.mesa = mesa;
        this.horaCreacion = LocalDateTime.now();
    }

    public void agregarItem(MenuItem item, int cantidad) {
        agregarItem(item, cantidad, null);
    }

    public void agregarItem(MenuItem item, int cantidad, String notas) {
        if (!item.isDisponible())
            throw new IllegalStateException("Item no disponible");

        // Buscar si ya existe el item
        for (LineaPedido linea : lineas) {
            if (linea.getItem().equals(item)) {
                linea.setCantidad(linea.getCantidad() + cantidad);
                return;
            }
        }

        LineaPedido nuevaLinea = new LineaPedido(item, cantidad);
        nuevaLinea.setNotas(notas);
        lineas.add(nuevaLinea);
    }

    public void quitarItem(MenuItem item) {
        lineas.removeIf(l -> l.getItem().equals(item));
    }

    public double calcularTotal() {
        return lineas.stream()
            .mapToDouble(LineaPedido::getSubtotal)
            .sum();
    }

    public void cambiarEstado(EstadoPedido nuevoEstado) {
        // Validar transicion valida
        if (!esTransicionValida(this.estado, nuevoEstado)) {
            throw new IllegalStateException(
                "No se puede pasar de " + this.estado + " a " + nuevoEstado
            );
        }
        this.estado = nuevoEstado;
    }

    private boolean esTransicionValida(EstadoPedido actual, EstadoPedido nuevo) {
        return switch (actual) {
            case PENDIENTE -> nuevo == EstadoPedido.EN_PREPARACION;
            case EN_PREPARACION -> nuevo == EstadoPedido.LISTO;
            case LISTO -> nuevo == EstadoPedido.ENTREGADO;
            case ENTREGADO -> nuevo == EstadoPedido.PAGADO;
            case PAGADO -> false;
        };
    }
}

class Cuenta {
    private Pedido pedido;
    private double porcentajePropina;

    public Cuenta(Pedido pedido) {
        this.pedido = pedido;
        this.porcentajePropina = 0.15; // 15% default
    }

    public double getSubtotal() {
        return pedido.calcularTotal();
    }

    public double getPropina() {
        return getSubtotal() * porcentajePropina;
    }

    public double getTotal() {
        return getSubtotal() + getPropina();
    }

    public List<Double> dividirEntre(int personas) {
        double porPersona = getTotal() / personas;
        List<Double> montos = new ArrayList<>();
        for (int i = 0; i < personas; i++) {
            montos.add(Math.round(porPersona * 100.0) / 100.0);
        }
        return montos;
    }

    public void setPropina(double porcentaje) {
        this.porcentajePropina = porcentaje;
    }
}

class Restaurante {
    private List<Mesa> mesas;
    private Menu menu;
    private List<Pedido> pedidosActivos = new ArrayList<>();

    public Pedido nuevoPedido(int numeroMesa) {
        Mesa mesa = buscarMesa(numeroMesa);
        mesa.ocupar();
        Pedido pedido = new Pedido(mesa);
        pedidosActivos.add(pedido);
        return pedido;
    }

    public Cuenta cerrarPedido(Pedido pedido) {
        pedido.cambiarEstado(EstadoPedido.PAGADO);
        pedido.getMesa().liberar();
        pedidosActivos.remove(pedido);
        return new Cuenta(pedido);
    }
}
```

### Patrones Aplicados
- **State Pattern**: EstadoPedido con transiciones validas
- **Composite (light)**: Pedido tiene LineaPedidos

### Extensiones Posibles
- Sistema de reservas
- Diferentes menus (almuerzo, cena, especiales)
- Integracion con cocina (pantalla de pedidos)
- Descuentos y promociones
