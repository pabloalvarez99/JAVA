# Ejercicio 9: Sistema de Cine

## Clases a crear:

1. **Fecha.java** y **Hora.java** - Manejo de fechas y horas
2. **Sala.java** - número, capacidad, tipo (2D, 3D, IMAX)
3. **Pelicula.java** - código, título, duración, clasificación
4. **Funcion.java** - ASOCIACIÓN (película, sala, fecha, hora)
5. **Cliente.java** - RUT, nombre
6. **Entrada.java** - ASOCIACIÓN (función, cliente, asiento, precio)
7. **Cine.java** - Clase gestora
8. **Main.java** - Menú

## Diagrama de clases:

```
┌─────────────┐        ┌─────────────────┐        ┌─────────────┐
│    Sala     │───────<│    Funcion      │>───────│  Pelicula   │
├─────────────┤    *   ├─────────────────┤    *   ├─────────────┤
│ - numero    │        │ - sala          │        │ - codigo    │
│ - capacidad │        │ - pelicula      │        │ - titulo    │
│ - tipo      │        │ - fecha         │        │ - duracion  │
│ - funciones │        │ - hora          │        │ - clasific. │
└─────────────┘        │ - entradas      │        └─────────────┘
                       └────────┬────────┘
                                │ *
                                ▼
                       ┌─────────────────┐        ┌─────────────┐
                       │    Entrada      │>───────│   Cliente   │
                       ├─────────────────┤    *   ├─────────────┤
                       │ - funcion       │        │ - rut       │
                       │ - cliente       │        │ - nombre    │
                       │ - asiento       │        │ - entradas  │
                       │ - precio        │        └─────────────┘
                       └─────────────────┘
```

## Clase Hora sugerida:
```java
public class Hora {
    private int hora;    // 0-23
    private int minuto;  // 0-59
    
    public Hora(int hora, int minuto) {
        this.hora = hora;
        this.minuto = minuto;
    }
    
    public String getTurno() {
        if (hora < 12) return "mañana";
        if (hora < 18) return "tarde";
        return "noche";
    }
    
    @Override
    public String toString() {
        return String.format("%02d:%02d", hora, minuto);
    }
}
```

## Validaciones:
- Una sala no puede tener dos funciones que se traslapen
- Verificar que el asiento no esté ya vendido en esa función
- Verificar capacidad de la sala

## Métodos útiles en Funcion:
```java
public boolean asientoDisponible(int asiento) {
    for (Entrada e : entradas) {
        if (e.getAsiento() == asiento) return false;
    }
    return true && asiento <= sala.getCapacidad();
}

public int getEntradasVendidas() {
    return entradas.size();
}
```
