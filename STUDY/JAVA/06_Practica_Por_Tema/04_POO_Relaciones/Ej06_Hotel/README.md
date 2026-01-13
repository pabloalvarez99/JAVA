# Ejercicio 10: Sistema de Hotel

## Clases a crear:

1. **Fecha.java** - Manejo de fechas
2. **Habitacion.java** - número, tipo, precioPorNoche
3. **Huesped.java** - RUT, nombre, teléfono
4. **Reserva.java** - ASOCIACIÓN (habitación, huésped, checkIn, checkOut, estado)
5. **Hotel.java** - Clase gestora
6. **Main.java** - Menú

## Diagrama de clases:

```
┌─────────────────┐        ┌─────────────────┐        ┌─────────────────┐
│   Habitacion    │───────<│     Reserva     │>───────│    Huesped      │
├─────────────────┤    *   ├─────────────────┤    *   ├─────────────────┤
│ - numero        │        │ - habitacion    │        │ - rut           │
│ - tipo          │        │ - huesped       │        │ - nombre        │
│ - precioPorNoche│        │ - fechaCheckIn  │        │ - telefono      │
│ - reservas      │        │ - fechaCheckOut │        │ - reservas      │
└─────────────────┘        │ - estado        │        └─────────────────┘
                           │ - montoTotal    │
                           └─────────────────┘
```

## Estados de reserva:
- `pendiente` - Reserva hecha, aún no llega el huésped
- `activa` - Huésped hizo check-in, está hospedado
- `completada` - Huésped hizo check-out
- `cancelada` - Reserva cancelada

## Método clave: Verificar traslape de fechas
```java
public boolean seTraslapa(Fecha otroCheckIn, Fecha otroCheckOut) {
    // Dos reservas NO se traslapan si:
    // - Una termina antes de que empiece la otra
    // - O una empieza después de que termine la otra
    boolean noSeTraslapa = this.fechaCheckOut.esAnterior(otroCheckIn) || 
                           this.fechaCheckIn.esPosterior(otroCheckOut);
    return !noSeTraslapa;
}
```

## Verificar disponibilidad:
```java
// En clase Habitacion:
public boolean estaDisponible(Fecha checkIn, Fecha checkOut) {
    for (Reserva r : reservas) {
        // Solo considerar reservas no canceladas y no completadas
        if (!r.getEstado().equals("cancelada") && !r.getEstado().equals("completada")) {
            if (r.seTraslapa(checkIn, checkOut)) {
                return false;
            }
        }
    }
    return true;
}
```

## Calcular monto:
```java
public int calcularMonto() {
    int noches = calcularNochesEntre(fechaCheckIn, fechaCheckOut);
    return noches * habitacion.getPrecioPorNoche();
}

private int calcularNochesEntre(Fecha inicio, Fecha fin) {
    // Simplificación: usar días
    int diasInicio = inicio.getAnio() * 365 + inicio.getMes() * 30 + inicio.getDia();
    int diasFin = fin.getAnio() * 365 + fin.getMes() * 30 + fin.getDia();
    return diasFin - diasInicio;
}
```

## Tipos de habitación:
- Simple ($50.000/noche)
- Doble ($80.000/noche)
- Suite ($150.000/noche)
