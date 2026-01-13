# Ejercicios de POO - Estilo Ayudantía PARTE 2 (60 puntos cada uno)

Más ejercicios con el mismo formato: modelo de dominio, relaciones entre clases, menú interactivo y reportabilidad.

---

## Problema 9: Sistema de Cine (60 puntos)

Un cine tiene múltiples salas y proyecta películas. Cada sala tiene un número, capacidad y tipo (2D, 3D, IMAX). Cada película tiene un código, título, duración en minutos y clasificación (TE, +14, +18).

Se programan funciones donde se asigna una película a una sala en una fecha y hora específica. Los clientes compran entradas para funciones específicas. Cada entrada tiene un precio y número de asiento.

**Qué debe hacer:**

Construya un programa en Java que presente un menú de opciones:

a. Agregar una sala
b. Agregar una película
c. Programar una función (película + sala + fecha + hora)
d. Vender entrada (cliente + función + asiento)

e. Reportabilidad:
   i. Dada una fecha, mostrar todas las funciones programadas ordenadas por hora
   ii. Dada una película, mostrar todas las funciones donde se proyecta
   iii. Dada una función, mostrar los asientos disponibles
   iv. Dada una sala, mostrar el historial de películas proyectadas
   v. Estadísticas generales:
      1. La película con más entradas vendidas
      2. La sala con mayor recaudación
      3. El horario más popular (mañana/tarde/noche)

---

## Problema 10: Sistema de Hotel (60 puntos)

Un hotel tiene habitaciones y huéspedes. Cada habitación tiene un número, tipo (simple, doble, suite) y precio por noche. Cada huésped tiene RUT, nombre y teléfono.

Los huéspedes hacen reservas de habitaciones. Cada reserva tiene fecha de check-in, fecha de check-out y estado (pendiente, activa, completada, cancelada). Una habitación no puede tener dos reservas activas que se traslapen en fechas.

**Qué debe hacer:**

Construya un programa en Java que presente un menú de opciones:

a. Agregar una habitación
b. Agregar un huésped
c. Realizar una reserva (verificar disponibilidad)
d. Hacer check-in (cambiar estado a activa)
e. Hacer check-out (cambiar estado a completada)

f. Reportabilidad:
   i. Dada una fecha, mostrar habitaciones disponibles
   ii. Dada una fecha, mostrar habitaciones ocupadas y por quién
   iii. Dado un RUT de huésped, mostrar historial de reservas con monto total gastado
   iv. Dado un número de habitación, mostrar historial de huéspedes
   v. Estadísticas generales:
      1. El huésped que más noches ha reservado
      2. La habitación con mayor ocupación
      3. El mes con más reservas

---

## Problema 11: Sistema de Delivery de Comida (60 puntos)

Una app de delivery tiene restaurantes, repartidores y clientes. Cada restaurante tiene un RUT, nombre y tipo de cocina. Cada repartidor tiene RUT, nombre y vehículo (moto, bicicleta, auto). Cada cliente tiene RUT, nombre y dirección.

Los clientes hacen pedidos a restaurantes. Cada pedido tiene un cliente, restaurante, repartidor asignado, fecha, hora, estado (pendiente, en preparación, en camino, entregado) y monto total.

**Qué debe hacer:**

Construya un programa en Java que presente un menú de opciones:

a. Agregar restaurante
b. Agregar repartidor
c. Agregar cliente
d. Crear pedido
e. Asignar repartidor a pedido
f. Actualizar estado de pedido

g. Reportabilidad:
   i. Dada una fecha, mostrar todos los pedidos con su estado
   ii. Dado un RUT de cliente, mostrar historial de pedidos
   iii. Dado un RUT de repartidor, mostrar pedidos entregados y total de entregas
   iv. Dado un restaurante, mostrar estadísticas de ventas
   v. Estadísticas generales:
      1. El repartidor con más entregas
      2. El restaurante con más ventas
      3. El cliente más frecuente
      4. Promedio de pedidos por día

---

## Problema 12: Sistema de Estacionamiento (60 puntos)

Un estacionamiento tiene espacios numerados de diferentes tipos (auto, moto, camioneta). Cada espacio tiene un número, tipo y tarifa por hora.

Los vehículos ingresan y salen del estacionamiento. Cada registro de estacionamiento tiene el vehículo (patente, tipo), espacio asignado, fecha/hora de entrada y fecha/hora de salida. Al salir se calcula el monto a pagar.

**Qué debe hacer:**

Construya un programa en Java que presente un menú de opciones:

a. Agregar espacio
b. Registrar entrada de vehículo (asignar espacio disponible del tipo correcto)
c. Registrar salida de vehículo (calcular monto)

d. Reportabilidad:
   i. Mostrar espacios disponibles por tipo
   ii. Mostrar espacios ocupados actualmente con información del vehículo
   iii. Dada una patente, mostrar historial de visitas
   iv. Dada una fecha, mostrar total recaudado
   v. Estadísticas generales:
      1. El vehículo que más veces ha visitado
      2. El espacio más utilizado
      3. Promedio de tiempo de estadía
      4. Hora pico (hora con más vehículos)

---

## Problema 13: Sistema de Tienda de Videojuegos (60 puntos)

Una tienda vende videojuegos y tiene clientes con membresía. Cada videojuego tiene código, nombre, plataforma (PC, PS5, Xbox, Switch) y precio. Cada cliente tiene RUT, nombre, email y tipo de membresía (básica, premium, VIP).

Los clientes compran videojuegos. Cada compra tiene cliente, fecha, lista de videojuegos y descuento aplicado según membresía (básica 0%, premium 10%, VIP 20%).

**Qué debe hacer:**

Construya un programa en Java que presente un menú de opciones:

a. Agregar videojuego
b. Agregar cliente
c. Realizar compra (aplicar descuento según membresía)
d. Cambiar membresía de cliente

e. Reportabilidad:
   i. Dado un RUT de cliente, mostrar historial de compras con ahorro por descuentos
   ii. Dada una plataforma, mostrar videojuegos disponibles
   iii. Dada una fecha, mostrar ventas del día
   iv. Dado un videojuego, mostrar cuántas veces se ha vendido
   v. Estadísticas generales:
      1. El videojuego más vendido
      2. La plataforma más popular
      3. El cliente que más ha gastado
      4. Promedio de compra por tipo de membresía

---

## Problema 14: Sistema de Taller Mecánico (60 puntos)

Un taller tiene mecánicos y recibe vehículos para reparación. Cada mecánico tiene RUT, nombre y especialidad (motor, frenos, electricidad, carrocería). Cada vehículo se identifica por patente, marca, modelo y año.

Los clientes llevan sus vehículos al taller. Cada orden de trabajo tiene vehículo, mecánico asignado, fecha de ingreso, fecha de entrega estimada, descripción del problema, diagnóstico, reparación realizada, estado (recibido, en diagnóstico, en reparación, listo, entregado) y costo.

**Qué debe hacer:**

Construya un programa en Java que presente un menú de opciones:

a. Agregar mecánico
b. Registrar vehículo
c. Crear orden de trabajo
d. Actualizar estado de orden
e. Registrar diagnóstico y reparación

f. Reportabilidad:
   i. Mostrar vehículos actualmente en el taller (no entregados)
   ii. Dado un mecánico, mostrar sus órdenes activas
   iii. Dada una patente, mostrar historial de reparaciones
   iv. Dada una especialidad, mostrar todas las reparaciones de ese tipo
   v. Estadísticas generales:
      1. El mecánico con más reparaciones completadas
      2. El tipo de reparación más común
      3. Promedio de días en reparación
      4. Total facturado por mes

---

## Problema 15: Sistema de Adopción de Mascotas (60 puntos)

Un refugio de animales tiene mascotas disponibles para adopción y personas interesadas en adoptar. Cada mascota tiene código, nombre, especie (perro, gato, conejo, etc.), raza, edad y estado de salud.

Las personas (RUT, nombre, teléfono, dirección) pueden adoptar mascotas. Cada adopción tiene mascota, adoptante, fecha de adopción, y requiere seguimiento. Los seguimientos se registran con fecha y observaciones sobre el bienestar de la mascota.

**Qué debe hacer:**

Construya un programa en Java que presente un menú de opciones:

a. Agregar mascota al refugio
b. Registrar persona interesada
c. Realizar adopción
d. Registrar seguimiento post-adopción

e. Reportabilidad:
   i. Mostrar mascotas disponibles para adopción por especie
   ii. Dado un RUT, mostrar mascotas adoptadas por esa persona
   iii. Dada una mascota adoptada, mostrar historial de seguimientos
   iv. Mostrar adopciones del último mes
   v. Estadísticas generales:
      1. La especie más adoptada
      2. La persona que más mascotas ha adoptado
      3. Promedio de tiempo que una mascota espera ser adoptada
      4. Cantidad de adopciones por mes

---

## Problema 16: Sistema de Eventos y Conferencias (60 puntos)

Una empresa organiza eventos. Cada evento tiene código, nombre, fecha, lugar, capacidad máxima y precio de entrada. Hay expositores (RUT, nombre, empresa, tema de expertise) y asistentes (RUT, nombre, email, empresa).

Los expositores participan en eventos con charlas. Cada charla tiene expositor, evento, título, hora y duración. Los asistentes se inscriben a eventos completos.

**Qué debe hacer:**

Construya un programa en Java que presente un menú de opciones:

a. Crear evento
b. Agregar expositor
c. Agregar asistente
d. Programar charla en evento
e. Inscribir asistente a evento (verificar capacidad)

f. Reportabilidad:
   i. Dado un evento, mostrar programa de charlas ordenado por hora
   ii. Dado un evento, mostrar lista de asistentes inscritos
   iii. Dado un expositor, mostrar todas las charlas que ha dado
   iv. Dado un asistente, mostrar eventos a los que ha asistido
   v. Estadísticas generales:
      1. El evento con más asistentes
      2. El expositor con más charlas
      3. El tema más frecuente en charlas
      4. Total recaudado por evento

---

## Problema 17: Sistema de Préstamos Bancarios (60 puntos)

Un banco tiene clientes y ofrece préstamos. Cada cliente tiene RUT, nombre, ingreso mensual y score crediticio (0-1000). Hay diferentes tipos de préstamo (consumo, hipotecario, automotriz) con diferentes tasas de interés.

Los clientes solicitan préstamos. Cada préstamo tiene cliente, tipo, monto solicitado, plazo en meses, tasa de interés, cuota mensual, fecha de otorgamiento y estado (solicitado, aprobado, rechazado, activo, pagado).

**Qué debe hacer:**

Construya un programa en Java que presente un menú de opciones:

a. Agregar cliente
b. Solicitar préstamo (calcular cuota mensual)
c. Aprobar/Rechazar préstamo (según score crediticio)
d. Registrar pago de cuota

e. Reportabilidad:
   i. Dado un cliente, mostrar todos sus préstamos con estado
   ii. Mostrar préstamos pendientes de aprobación
   iii. Mostrar préstamos activos con monto restante por pagar
   iv. Dado un tipo de préstamo, mostrar estadísticas (cantidad, monto total)
   v. Estadísticas generales:
      1. El cliente con más préstamos
      2. El tipo de préstamo más solicitado
      3. Monto total prestado activo
      4. Tasa de aprobación (aprobados vs total)

---

## Problema 18: Sistema de Inventario de Bodega (60 puntos)

Una bodega almacena productos de diferentes proveedores. Cada producto tiene código, nombre, categoría y stock mínimo requerido. Cada proveedor tiene RUT, nombre y teléfono.

Se registran movimientos de inventario: entradas (compras a proveedores) y salidas (ventas o despachos). Cada movimiento tiene producto, tipo (entrada/salida), cantidad, fecha, y para entradas: proveedor y costo unitario.

**Qué debe hacer:**

Construya un programa en Java que presente un menú de opciones:

a. Agregar producto
b. Agregar proveedor
c. Registrar entrada de inventario (compra)
d. Registrar salida de inventario (venta/despacho)

e. Reportabilidad:
   i. Mostrar stock actual de todos los productos
   ii. Mostrar productos bajo stock mínimo (alerta de reposición)
   iii. Dado un producto, mostrar historial de movimientos
   iv. Dado un proveedor, mostrar todas las compras realizadas
   v. Estadísticas generales:
      1. El producto con más movimientos
      2. El proveedor con más compras
      3. Valor total del inventario actual
      4. Producto más vendido (más salidas)

---

## Problema 19: Sistema de Transporte Público (60 puntos)

Un sistema de transporte tiene buses y recorridos. Cada bus tiene patente, capacidad y estado (operativo, en mantención). Cada recorrido tiene código, nombre (ej: "Línea 101"), origen, destino y frecuencia en minutos.

Se programan servicios diarios: cada servicio asigna un bus a un recorrido en una fecha con un chofer específico. Los choferes tienen RUT, nombre y licencia.

**Qué debe hacer:**

Construya un programa en Java que presente un menú de opciones:

a. Agregar bus
b. Agregar recorrido
c. Agregar chofer
d. Programar servicio (bus + recorrido + chofer + fecha)

e. Reportabilidad:
   i. Dada una fecha, mostrar todos los servicios programados
   ii. Dado un chofer, mostrar sus servicios asignados
   iii. Dado un bus, mostrar historial de servicios
   iv. Dado un recorrido, mostrar qué buses lo han cubierto
   v. Estadísticas generales:
      1. El chofer con más servicios
      2. El recorrido más frecuente
      3. El bus más utilizado
      4. Servicios por día de la semana

---

## Problema 20: Sistema de Clínica Veterinaria (60 puntos)

Una clínica veterinaria atiende mascotas de dueños registrados. Cada mascota tiene código, nombre, especie, raza, fecha de nacimiento y dueño asociado. Cada dueño tiene RUT, nombre y teléfono.

Los veterinarios (RUT, nombre, especialidad) realizan consultas. Cada consulta tiene mascota, veterinario, fecha, motivo, diagnóstico, tratamiento y costo. También se registran vacunas aplicadas a cada mascota.

**Qué debe hacer:**

Construya un programa en Java que presente un menú de opciones:

a. Agregar dueño
b. Agregar mascota (asociada a dueño)
c. Agregar veterinario
d. Registrar consulta
e. Registrar vacuna aplicada

f. Reportabilidad:
   i. Dado un dueño, mostrar todas sus mascotas con última consulta
   ii. Dada una mascota, mostrar historial médico completo
   iii. Dado un veterinario, mostrar consultas realizadas
   iv. Mostrar mascotas con vacunas pendientes o vencidas
   v. Estadísticas generales:
      1. El veterinario con más consultas
      2. La especie más atendida
      3. El tratamiento más común
      4. Ingreso total por veterinario

---

## Tabla Resumen - Parte 2

| # | Problema | Entidades Principales | Clase(s) de Asociación |
|---|----------|----------------------|------------------------|
| 9 | Cine | Sala, Película, Cliente | Función, Entrada |
| 10 | Hotel | Habitación, Huésped | Reserva |
| 11 | Delivery | Restaurante, Repartidor, Cliente | Pedido |
| 12 | Estacionamiento | Espacio, Vehículo | RegistroEstacionamiento |
| 13 | Videojuegos | Videojuego, Cliente | Compra, DetalleCompra |
| 14 | Taller | Mecánico, Vehículo | OrdenTrabajo |
| 15 | Adopción | Mascota, Persona | Adopción, Seguimiento |
| 16 | Eventos | Evento, Expositor, Asistente | Charla, Inscripción |
| 17 | Préstamos | Cliente, TipoPrestamo | Préstamo, Pago |
| 18 | Inventario | Producto, Proveedor | MovimientoInventario |
| 19 | Transporte | Bus, Recorrido, Chofer | Servicio |
| 20 | Veterinaria | Mascota, Dueño, Veterinario | Consulta, Vacuna |

---

## Tips para problemas con múltiples asociaciones

Algunos problemas tienen más de una clase de asociación. Ejemplo Cine:

```
┌──────────┐      ┌──────────┐      ┌──────────┐
│   Sala   │─────<│ Función  │>─────│ Película │
└──────────┘      └────┬─────┘      └──────────┘
                       │
                       │ *
                       ▼
                 ┌──────────┐
                 │ Entrada  │>─────┌──────────┐
                 └──────────┘      │ Cliente  │
                                   └──────────┘
```

**Patrón**: Una función tiene muchas entradas, cada entrada pertenece a un cliente.

---

## Validaciones Comunes a Implementar

### 1. Verificar disponibilidad en fechas
```java
public boolean estaDisponible(Fecha inicio, Fecha fin) {
    for (Reserva r : reservas) {
        if (r.seTraslapa(inicio, fin)) {
            return false;
        }
    }
    return true;
}

// En clase Reserva:
public boolean seTraslapa(Fecha inicio, Fecha fin) {
    return !(this.fechaFin.esAnterior(inicio) || this.fechaInicio.esPosterior(fin));
}
```

### 2. Verificar capacidad
```java
public boolean hayCapacidad() {
    return getInscritos().size() < capacidadMaxima;
}
```

### 3. Calcular montos
```java
public int calcularMonto() {
    int dias = calcularDiasEntre(fechaInicio, fechaFin);
    return dias * precioPorDia;
}
```

### 4. Filtrar por estado
```java
public ArrayList<Pedido> getPedidosActivos() {
    ArrayList<Pedido> activos = new ArrayList<>();
    for (Pedido p : pedidos) {
        if (!p.getEstado().equals("entregado") && !p.getEstado().equals("cancelado")) {
            activos.add(p);
        }
    }
    return activos;
}
```
