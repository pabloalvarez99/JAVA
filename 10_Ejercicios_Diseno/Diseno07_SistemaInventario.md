# EJERCICIO DISENO #7: Sistema de Inventario
**Dificultad: ⭐⭐⭐**

## Requerimientos

Disenar un sistema de control de inventario:

1. **Productos**
   - SKU (codigo unico)
   - Nombre, descripcion, categoria
   - Precio de compra y venta
   - Stock minimo (para alertas)

2. **Movimientos de Stock**
   - Entrada (compra a proveedor)
   - Salida (venta)
   - Ajuste (inventario fisico)
   - Transferencia entre almacenes

3. **Almacenes**
   - Multiples ubicaciones
   - Stock por producto por almacen

4. **Alertas**
   - Stock bajo (< minimo)
   - Producto agotado
   - Proximo a vencer (para perecederos)

---

## PARTE 1: Tu Diseno

### 1.1 Modelar Stock
```
Opcion A: Stock como atributo de Producto
Opcion B: Clase Stock separada (producto + almacen + cantidad)

Cual elegir y por que?
_______________
```

### 1.2 Historial de Movimientos
```
Como garantizar trazabilidad de cambios?
_______________
```

---

## PARTE 2: Solucion Propuesta (NO MIRAR ANTES)

### Codigo Esqueleto

```java
import java.time.*;
import java.util.*;

enum TipoMovimiento { ENTRADA, SALIDA, AJUSTE, TRANSFERENCIA }
enum TipoAlerta { STOCK_BAJO, AGOTADO, PROXIMO_VENCER }

class Producto {
    private String sku;
    private String nombre;
    private String descripcion;
    private String categoria;
    private double precioCompra;
    private double precioVenta;
    private int stockMinimo;
    private LocalDate fechaVencimiento; // null si no aplica

    public Producto(String sku, String nombre) {
        this.sku = sku;
        this.nombre = nombre;
        this.stockMinimo = 10; // default
    }

    public double getMargen() {
        return precioVenta - precioCompra;
    }

    public double getPorcentajeMargen() {
        return (getMargen() / precioCompra) * 100;
    }

    // getters, setters...
}

class Almacen {
    private String id;
    private String nombre;
    private String direccion;

    public Almacen(String id, String nombre) {
        this.id = id;
        this.nombre = nombre;
    }
}

// Relacion Producto-Almacen con cantidad
class Stock {
    private Producto producto;
    private Almacen almacen;
    private int cantidad;
    private LocalDateTime ultimaActualizacion;

    public Stock(Producto producto, Almacen almacen) {
        this.producto = producto;
        this.almacen = almacen;
        this.cantidad = 0;
        this.ultimaActualizacion = LocalDateTime.now();
    }

    public void aumentar(int cant) {
        this.cantidad += cant;
        this.ultimaActualizacion = LocalDateTime.now();
    }

    public void disminuir(int cant) {
        if (cant > this.cantidad) {
            throw new IllegalStateException("Stock insuficiente");
        }
        this.cantidad -= cant;
        this.ultimaActualizacion = LocalDateTime.now();
    }

    public void ajustar(int nuevaCantidad) {
        this.cantidad = nuevaCantidad;
        this.ultimaActualizacion = LocalDateTime.now();
    }

    public boolean estaBajo() {
        return cantidad < producto.getStockMinimo();
    }

    public boolean estaAgotado() {
        return cantidad == 0;
    }
}

// Registro inmutable de movimientos
record MovimientoStock(
    String id,
    TipoMovimiento tipo,
    Producto producto,
    Almacen almacenOrigen,  // null para ENTRADA
    Almacen almacenDestino, // null para SALIDA
    int cantidad,
    String motivo,
    String usuarioId,
    LocalDateTime fecha
) {
    public MovimientoStock {
        if (id == null) id = "MOV-" + System.currentTimeMillis();
        if (fecha == null) fecha = LocalDateTime.now();
    }
}

class Alerta {
    private String id;
    private TipoAlerta tipo;
    private Producto producto;
    private Almacen almacen;
    private String mensaje;
    private LocalDateTime fecha;
    private boolean leida;

    public Alerta(TipoAlerta tipo, Producto producto, Almacen almacen, String mensaje) {
        this.id = "ALT-" + System.currentTimeMillis();
        this.tipo = tipo;
        this.producto = producto;
        this.almacen = almacen;
        this.mensaje = mensaje;
        this.fecha = LocalDateTime.now();
        this.leida = false;
    }
}

class SistemaInventario {
    private Map<String, Producto> productos = new HashMap<>();
    private Map<String, Almacen> almacenes = new HashMap<>();
    private Map<String, Stock> stocks = new HashMap<>(); // key: "sku-almacenId"
    private List<MovimientoStock> movimientos = new ArrayList<>();
    private List<Alerta> alertas = new ArrayList<>();

    // Clave compuesta para stock
    private String stockKey(String sku, String almacenId) {
        return sku + "-" + almacenId;
    }

    public void registrarEntrada(String sku, String almacenId, int cantidad,
                                 String motivo, String usuarioId) {
        Stock stock = obtenerOCrearStock(sku, almacenId);
        stock.aumentar(cantidad);

        movimientos.add(new MovimientoStock(
            null, TipoMovimiento.ENTRADA,
            productos.get(sku), null, almacenes.get(almacenId),
            cantidad, motivo, usuarioId, null
        ));
    }

    public void registrarSalida(String sku, String almacenId, int cantidad,
                                String motivo, String usuarioId) {
        Stock stock = stocks.get(stockKey(sku, almacenId));
        if (stock == null) {
            throw new IllegalStateException("No hay stock registrado");
        }

        stock.disminuir(cantidad);

        movimientos.add(new MovimientoStock(
            null, TipoMovimiento.SALIDA,
            productos.get(sku), almacenes.get(almacenId), null,
            cantidad, motivo, usuarioId, null
        ));

        verificarAlertas(stock);
    }

    public void transferir(String sku, String almacenOrigen, String almacenDestino,
                          int cantidad, String usuarioId) {
        Stock stockOrigen = stocks.get(stockKey(sku, almacenOrigen));
        Stock stockDestino = obtenerOCrearStock(sku, almacenDestino);

        stockOrigen.disminuir(cantidad);
        stockDestino.aumentar(cantidad);

        movimientos.add(new MovimientoStock(
            null, TipoMovimiento.TRANSFERENCIA,
            productos.get(sku),
            almacenes.get(almacenOrigen),
            almacenes.get(almacenDestino),
            cantidad, "Transferencia", usuarioId, null
        ));

        verificarAlertas(stockOrigen);
    }

    public void ajustarInventario(String sku, String almacenId, int cantidadReal,
                                  String motivo, String usuarioId) {
        Stock stock = obtenerOCrearStock(sku, almacenId);
        int diferencia = cantidadReal - stock.getCantidad();

        stock.ajustar(cantidadReal);

        movimientos.add(new MovimientoStock(
            null, TipoMovimiento.AJUSTE,
            productos.get(sku), almacenes.get(almacenId), null,
            diferencia, motivo, usuarioId, null
        ));

        verificarAlertas(stock);
    }

    private Stock obtenerOCrearStock(String sku, String almacenId) {
        String key = stockKey(sku, almacenId);
        return stocks.computeIfAbsent(key,
            k -> new Stock(productos.get(sku), almacenes.get(almacenId)));
    }

    private void verificarAlertas(Stock stock) {
        if (stock.estaAgotado()) {
            alertas.add(new Alerta(
                TipoAlerta.AGOTADO, stock.getProducto(), stock.getAlmacen(),
                "Producto agotado: " + stock.getProducto().getNombre()
            ));
        } else if (stock.estaBajo()) {
            alertas.add(new Alerta(
                TipoAlerta.STOCK_BAJO, stock.getProducto(), stock.getAlmacen(),
                "Stock bajo: " + stock.getCantidad() + " unidades"
            ));
        }
    }

    // Reportes
    public int getStockTotal(String sku) {
        return stocks.values().stream()
            .filter(s -> s.getProducto().getSku().equals(sku))
            .mapToInt(Stock::getCantidad)
            .sum();
    }

    public List<Producto> getProductosBajoStock() {
        return stocks.values().stream()
            .filter(Stock::estaBajo)
            .map(Stock::getProducto)
            .distinct()
            .toList();
    }

    public double getValorInventario(String almacenId) {
        return stocks.values().stream()
            .filter(s -> s.getAlmacen().getId().equals(almacenId))
            .mapToDouble(s -> s.getCantidad() * s.getProducto().getPrecioCompra())
            .sum();
    }
}
```

### Patrones Aplicados
- **Audit Trail**: MovimientoStock como record inmutable
- **Observer (simplificado)**: Sistema de alertas

### Extensiones
- Lotes con fecha vencimiento
- Numeros de serie
- Codigo de barras/QR
- Integracion con punto de venta
