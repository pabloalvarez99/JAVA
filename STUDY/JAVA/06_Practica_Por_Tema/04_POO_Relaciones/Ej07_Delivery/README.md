# Ejercicio 11: Sistema de Delivery

## Clases a crear:

1. **Fecha.java** y **Hora.java** - Manejo de fechas y horas
2. **Restaurante.java** - RUT, nombre, tipoCocina
3. **Repartidor.java** - RUT, nombre, vehiculo
4. **Cliente.java** - RUT, nombre, direccion
5. **Pedido.java** - ASOCIACIÓN TRIPLE (restaurante, repartidor, cliente, fecha, hora, estado, monto)
6. **AppDelivery.java** - Clase gestora
7. **Main.java** - Menú

## Diagrama de clases:

```
┌─────────────────┐
│  Restaurante    │
├─────────────────┤
│ - rut           │
│ - nombre        │◄────────┐
│ - tipoCocina    │         │
│ - pedidos       │         │
└─────────────────┘         │
                            │
┌─────────────────┐    ┌────┴────────────┐    ┌─────────────────┐
│   Repartidor    │    │     Pedido      │    │    Cliente      │
├─────────────────┤    ├─────────────────┤    ├─────────────────┤
│ - rut           │◄───│ - restaurante   │───>│ - rut           │
│ - nombre        │    │ - repartidor    │    │ - nombre        │
│ - vehiculo      │    │ - cliente       │    │ - direccion     │
│ - pedidos       │    │ - fecha         │    │ - pedidos       │
└─────────────────┘    │ - hora          │    └─────────────────┘
                       │ - estado        │
                       │ - montoTotal    │
                       └─────────────────┘
```

## Estados del pedido:
- `pendiente` - Pedido creado, esperando asignación
- `asignado` - Repartidor asignado
- `en_preparacion` - Restaurante preparando
- `en_camino` - Repartidor recogió el pedido
- `entregado` - Pedido entregado al cliente

## Flujo típico:
1. Cliente crea pedido → estado: `pendiente`
2. Se asigna repartidor → estado: `asignado`
3. Restaurante prepara → estado: `en_preparacion`
4. Repartidor recoge → estado: `en_camino`
5. Entrega al cliente → estado: `entregado`

## Tipos de vehículo:
- Bicicleta
- Moto
- Auto

## Tipos de cocina:
- Comida rápida
- Italiana
- Japonesa
- Mexicana
- China
- Peruana

## Métodos útiles:
```java
// En Repartidor - contar entregas
public int getTotalEntregas() {
    int count = 0;
    for (Pedido p : pedidos) {
        if (p.getEstado().equals("entregado")) {
            count++;
        }
    }
    return count;
}

// En Restaurante - total ventas
public int getTotalVentas() {
    int total = 0;
    for (Pedido p : pedidos) {
        if (p.getEstado().equals("entregado")) {
            total += p.getMontoTotal();
        }
    }
    return total;
}

// En AppDelivery - promedio pedidos por día
public double getPromedioPedidosPorDia() {
    // Contar días únicos y dividir
}
```
