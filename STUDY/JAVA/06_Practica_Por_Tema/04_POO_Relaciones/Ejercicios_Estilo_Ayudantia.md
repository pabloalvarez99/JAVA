# Ejercicios de POO - Estilo Ayudantía (60 puntos cada uno)

Estos ejercicios siguen el mismo formato del problema de la UCN: modelo de dominio, relaciones entre clases, menú interactivo y reportabilidad.

---

## Problema 1: Sistema de Biblioteca (60 puntos)

En una biblioteca hay muchos libros y muchos socios. Un socio puede pedir prestados varios libros simultáneamente. Cada préstamo tiene una fecha de inicio y una fecha de devolución esperada. Los libros se identifican por su ISBN, título y autor. Los socios se identifican por su RUT y nombre.

Cuando un socio pide un libro, se registra el préstamo con las fechas correspondientes. Un libro puede ser prestado múltiples veces (a diferentes socios en diferentes fechas), pero no puede estar prestado a dos socios al mismo tiempo.

**Qué debe hacer:**

Construya un programa en Java que presente un menú de opciones que permita realizar las siguientes acciones:

a. Agregar un libro
b. Agregar un socio
c. Registrar un préstamo (asociar socio con libro entre ciertas fechas)

d. Reportabilidad:
   i. Dada una fecha, mostrar todos los libros prestados en ese momento, indicando a quién está prestado cada uno
   ii. Dada una fecha, mostrar los libros disponibles (no prestados)
   iii. Dado un RUT de socio, mostrar su historial de préstamos ordenado por fecha
   iv. Dado un ISBN, mostrar el historial de préstamos de ese libro
   v. Estadísticas generales:
      1. El socio que más libros ha pedido prestados (en total histórico)
      2. El libro más popular (más veces prestado)

**Debe entregar:**
- Modelo de Dominio (10%)
- Diagrama de Clases (20%)
- Código Java (70%)

---

## Problema 2: Sistema de Hospital (60 puntos)

En un hospital hay médicos y pacientes. Un médico puede atender a muchos pacientes y un paciente puede ser atendido por varios médicos (diferentes especialidades). Cada atención médica tiene una fecha, un diagnóstico y un tratamiento indicado.

Los médicos se identifican por su RUT, nombre y especialidad. Los pacientes se identifican por su RUT, nombre y fecha de nacimiento. Las fechas se representan con año, mes y día.

**Qué debe hacer:**

Construya un programa en Java que presente un menú de opciones que permita realizar las siguientes acciones:

a. Agregar un médico
b. Agregar un paciente
c. Registrar una atención médica (asociar médico con paciente en una fecha con diagnóstico)

d. Reportabilidad:
   i. Dado un RUT de paciente, mostrar todas las atenciones que ha recibido ordenadas por fecha
   ii. Dado un RUT de médico, mostrar todos los pacientes que ha atendido
   iii. Dada una fecha, mostrar todas las atenciones realizadas ese día
   iv. Dada una especialidad, mostrar todos los diagnósticos realizados por médicos de esa especialidad
   v. Estadísticas generales:
      1. El médico que más pacientes ha atendido
      2. El paciente que más atenciones ha recibido
      3. La especialidad con más atenciones

**Debe entregar:**
- Modelo de Dominio (10%)
- Diagrama de Clases (20%)
- Código Java (70%)

---

## Problema 3: Sistema de Aerolínea (60 puntos)

Una aerolínea tiene aviones y pilotos. Cada avión tiene una matrícula, modelo y capacidad de pasajeros. Cada piloto tiene un RUT, nombre y cantidad de horas de vuelo acumuladas.

Un piloto puede volar diferentes aviones en diferentes fechas. Cada vuelo tiene un avión asignado, un piloto, una fecha, una ciudad de origen y una ciudad de destino. Un piloto no puede tener dos vuelos el mismo día. Un avión no puede tener dos vuelos el mismo día.

**Qué debe hacer:**

Construya un programa en Java que presente un menú de opciones que permita realizar las siguientes acciones:

a. Agregar un avión
b. Agregar un piloto
c. Registrar un vuelo (asociar piloto con avión en una fecha, con origen y destino)

d. Reportabilidad:
   i. Dada una fecha, mostrar todos los vuelos programados
   ii. Dado un RUT de piloto, mostrar su historial de vuelos ordenado por fecha
   iii. Dada una matrícula de avión, mostrar todos los vuelos que ha realizado
   iv. Dada una ciudad, mostrar todos los vuelos que tienen esa ciudad como origen o destino
   v. Estadísticas generales:
      1. El piloto con más vuelos realizados
      2. El avión más utilizado
      3. La ruta más frecuente (par origen-destino)

**Debe entregar:**
- Modelo de Dominio (10%)
- Diagrama de Clases (20%)
- Código Java (70%)

---

## Problema 4: Sistema de Gimnasio (60 puntos)

En un gimnasio hay entrenadores y clientes. Los entrenadores se identifican por su RUT, nombre y especialidad (musculación, cardio, yoga, etc.). Los clientes se identifican por su RUT, nombre y fecha de inscripción.

Un cliente puede contratar sesiones de entrenamiento con diferentes entrenadores. Cada sesión tiene un entrenador, un cliente, una fecha, una hora de inicio y una duración en minutos. Un entrenador puede tener múltiples sesiones al día con diferentes clientes, pero no puede tener dos sesiones a la misma hora.

**Qué debe hacer:**

Construya un programa en Java que presente un menú de opciones que permita realizar las siguientes acciones:

a. Agregar un entrenador
b. Agregar un cliente
c. Registrar una sesión de entrenamiento

d. Reportabilidad:
   i. Dada una fecha, mostrar todas las sesiones programadas ordenadas por hora
   ii. Dado un RUT de cliente, mostrar todas sus sesiones ordenadas por fecha
   iii. Dado un RUT de entrenador, mostrar todos sus clientes (sin repetir)
   iv. Dada una especialidad, mostrar cuántas sesiones se han realizado de esa especialidad
   v. Estadísticas generales:
      1. El entrenador con más sesiones
      2. El cliente más activo (más sesiones)
      3. La especialidad más demandada

**Debe entregar:**
- Modelo de Dominio (10%)
- Diagrama de Clases (20%)
- Código Java (70%)

---

## Problema 5: Sistema de Arriendo de Vehículos (60 puntos)

Una empresa de arriendo tiene vehículos y clientes. Los vehículos se identifican por su patente, marca, modelo y tarifa diaria. Los clientes se identifican por su RUT, nombre y licencia de conducir.

Un cliente puede arrendar múltiples vehículos en diferentes períodos. Cada arriendo tiene un vehículo, un cliente, una fecha de inicio, una fecha de término y un monto total. Un vehículo no puede estar arrendado a dos clientes en fechas que se traslapen.

**Qué debe hacer:**

Construya un programa en Java que presente un menú de opciones que permita realizar las siguientes acciones:

a. Agregar un vehículo
b. Agregar un cliente
c. Registrar un arriendo (verificar disponibilidad del vehículo)

d. Reportabilidad:
   i. Dada una fecha, mostrar los vehículos disponibles para arriendo
   ii. Dada una fecha, mostrar los vehículos actualmente arrendados y a quién
   iii. Dado un RUT de cliente, mostrar su historial de arriendos con el monto total gastado
   iv. Dada una patente, mostrar el historial de arriendos de ese vehículo
   v. Estadísticas generales:
      1. El cliente que más dinero ha gastado en arriendos
      2. El vehículo que más ingresos ha generado
      3. El vehículo con más días arrendado

**Debe entregar:**
- Modelo de Dominio (10%)
- Diagrama de Clases (20%)
- Código Java (70%)

---

## Problema 6: Sistema de Torneos Deportivos (60 puntos)

En una liga deportiva hay equipos y jugadores. Cada equipo tiene un nombre, ciudad y año de fundación. Cada jugador tiene un RUT, nombre y posición (arquero, defensa, mediocampista, delantero).

Un jugador puede pertenecer a diferentes equipos a lo largo del tiempo (transferencias), pero solo a uno a la vez. Cada contrato entre jugador y equipo tiene una fecha de inicio, fecha de término y salario mensual.

**Qué debe hacer:**

Construya un programa en Java que presente un menú de opciones que permita realizar las siguientes acciones:

a. Agregar un equipo
b. Agregar un jugador
c. Registrar un contrato (transferir jugador a equipo)

d. Reportabilidad:
   i. Dada una fecha, mostrar la plantilla actual de cada equipo
   ii. Dado un nombre de equipo, mostrar el historial de todos los jugadores que han pasado por él
   iii. Dado un RUT de jugador, mostrar su carrera (equipos por los que ha pasado) ordenada por fecha
   iv. Dada una posición, mostrar todos los jugadores de esa posición y su equipo actual
   v. Estadísticas generales:
      1. El equipo con más jugadores actualmente
      2. El jugador que ha pasado por más equipos
      3. El jugador con el salario más alto actualmente

**Debe entregar:**
- Modelo de Dominio (10%)
- Diagrama de Clases (20%)
- Código Java (70%)

---

## Problema 7: Sistema de Restaurante (60 puntos)

En un restaurante hay meseros y mesas. Cada mesero tiene un RUT, nombre y turno (mañana, tarde, noche). Cada mesa tiene un número y capacidad de personas.

Los clientes (identificados por nombre y teléfono) hacen reservas para una mesa específica. Cada reserva tiene una fecha, hora, cantidad de personas y un mesero asignado. Una mesa no puede tener dos reservas que se traslapen (considere que cada reserva dura 2 horas).

**Qué debe hacer:**

Construya un programa en Java que presente un menú de opciones que permita realizar las siguientes acciones:

a. Agregar un mesero
b. Agregar una mesa
c. Agregar un cliente
d. Registrar una reserva (verificar disponibilidad de mesa)

e. Reportabilidad:
   i. Dada una fecha y hora, mostrar las mesas disponibles
   ii. Dada una fecha, mostrar todas las reservas del día ordenadas por hora
   iii. Dado un número de mesa, mostrar el historial de reservas
   iv. Dado un RUT de mesero, mostrar todas las reservas que ha atendido
   v. Estadísticas generales:
      1. La mesa más popular (más reservas)
      2. El mesero con más reservas atendidas
      3. El cliente más frecuente

**Debe entregar:**
- Modelo de Dominio (10%)
- Diagrama de Clases (20%)
- Código Java (70%)

---

## Problema 8: Sistema de Cursos Online (60 puntos)

Una plataforma de cursos online tiene profesores y estudiantes. Cada profesor tiene un RUT, nombre y área de expertise. Cada estudiante tiene un RUT, nombre y email.

Un profesor puede crear múltiples cursos. Cada curso tiene un código, nombre, profesor y fecha de creación. Los estudiantes pueden inscribirse en múltiples cursos. Cada inscripción tiene una fecha de inscripción, una nota final (puede ser null si no ha terminado) y un estado (en curso, aprobado, reprobado, abandonado).

**Qué debe hacer:**

Construya un programa en Java que presente un menú de opciones que permita realizar las siguientes acciones:

a. Agregar un profesor
b. Agregar un estudiante
c. Crear un curso (asignado a un profesor)
d. Inscribir estudiante en curso
e. Registrar nota final de un estudiante en un curso

f. Reportabilidad:
   i. Dado un código de curso, mostrar todos los estudiantes inscritos con su estado
   ii. Dado un RUT de estudiante, mostrar todos sus cursos con notas
   iii. Dado un RUT de profesor, mostrar todos sus cursos y cantidad de estudiantes en cada uno
   iv. Mostrar el promedio de notas por curso
   v. Estadísticas generales:
      1. El curso con más estudiantes inscritos
      2. El estudiante con mejor promedio de notas
      3. El profesor con más estudiantes totales (sumando todos sus cursos)

**Debe entregar:**
- Modelo de Dominio (10%)
- Diagrama de Clases (20%)
- Código Java (70%)

---

## Consideraciones Generales (Aplican a todos los problemas)

- Debe usar orientación al objeto
- En el diagrama de clases debe especificar **TODO** (atributos, métodos, relaciones, multiplicidad)
- Tanto el modelo del dominio como el diagrama de clases debe escribirlos en papel y entregarlos junto a la prueba
- El código fuente debe comprimirlo en un solo archivo .zip y subirlo a Campus Virtual
- Hojas sin nombre no se revisarán

---

## Tips para resolver estos ejercicios

### 1. Identificar las entidades principales
- Busca los sustantivos principales en el enunciado
- Estos serán tus clases principales

### 2. Identificar la clase de asociación
- Cuando dos entidades se relacionan con datos adicionales (fechas, estados, etc.)
- Crea una clase intermedia que "vincule" ambas entidades

### 3. Estructura típica de clases

```
┌─────────────┐        ┌─────────────────┐        ┌─────────────┐
│  Entidad A  │───────<│ Clase Asociación│>───────│  Entidad B  │
└─────────────┘    *   └─────────────────┘    *   └─────────────┘
                        - atributos extra
                        - fechas
                        - estados
```

### 4. Clase gestora
- Crea una clase que contenga ArrayList de todas las entidades
- Esta clase implementa los métodos de reportabilidad
- Es el "cerebro" del sistema

### 5. Patrón común para reportabilidad
```java
public void reportePorFecha(Fecha fecha) {
    for (Asociacion a : asociaciones) {
        if (a.estaActivoEn(fecha)) {
            // mostrar información
        }
    }
}
```

---

## Ejercicio de Práctica Rápida

Antes de resolver un problema completo, practica identificando:

1. **Entidades principales** - ¿Cuáles son las clases?
2. **Clase de asociación** - ¿Qué las conecta?
3. **Atributos de la asociación** - ¿Qué datos extra tiene la relación?
4. **Reportes** - ¿Qué consultas debo responder?

Ejemplo con el Problema 1 (Biblioteca):
1. Entidades: `Libro`, `Socio`
2. Asociación: `Prestamo`
3. Atributos asociación: `fechaInicio`, `fechaDevolucion`
4. Reportes: libros prestados por fecha, historial por socio, etc.
