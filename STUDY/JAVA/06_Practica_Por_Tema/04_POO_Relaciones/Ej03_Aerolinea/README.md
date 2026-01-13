# Ejercicio 3: Sistema de Aerolínea

## Clases a crear:

1. **Fecha.java** - Copiar del ejercicio anterior
2. **Avion.java** - matricula, modelo, capacidad, lista de vuelos
3. **Piloto.java** - RUT, nombre, horasVuelo, lista de vuelos
4. **Vuelo.java** - CLASE DE ASOCIACIÓN (avion, piloto, fecha, origen, destino)
5. **Aerolinea.java** - Clase gestora
6. **Main.java** - Menú

## Diagrama de clases:

```
┌─────────────┐        ┌─────────────────┐        ┌─────────────┐
│   Piloto    │───────<│     Vuelo       │>───────│   Avion     │
├─────────────┤    *   ├─────────────────┤    *   ├─────────────┤
│ - rut       │        │ - piloto        │        │ - matricula │
│ - nombre    │        │ - avion         │        │ - modelo    │
│ - horasVuelo│        │ - fecha         │        │ - capacidad │
│ - vuelos    │        │ - origen        │        │ - vuelos    │
└─────────────┘        │ - destino       │        └─────────────┘
                       └─────────────────┘
```

## Validaciones importantes:
- Un piloto NO puede tener dos vuelos el mismo día
- Un avión NO puede tener dos vuelos el mismo día

## Método de validación sugerido:
```java
public boolean pilotoDisponible(Piloto p, Fecha fecha) {
    for (Vuelo v : vuelos) {
        if (v.getPiloto().equals(p) && v.getFecha().esIgual(fecha)) {
            return false;
        }
    }
    return true;
}
```

## Estadística especial: Ruta más frecuente
Debes contar cuántas veces aparece cada par (origen, destino)
