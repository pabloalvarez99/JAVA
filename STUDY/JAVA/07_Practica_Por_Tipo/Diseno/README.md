# 10 - Ejercicios de Diseno (System Design)

## Objetivo
Practicar el DISENO antes de codificar. Aprender a pensar en clases, relaciones, y arquitectura antes de escribir la primera linea de codigo.

## Metodologia

### Paso 1: Analizar Requerimientos
- Que debe hacer el sistema?
- Cuales son las entidades principales?
- Que acciones puede realizar cada entidad?

### Paso 2: Identificar Clases
- Sustantivos del problema -> posibles clases
- Verbos -> posibles metodos
- Adjetivos -> posibles atributos

### Paso 3: Definir Relaciones
```
HERENCIA (es-un):     Perro ES-UN Animal
COMPOSICION (tiene):  Carro TIENE Motor
AGREGACION (usa):     Biblioteca USA Libros
DEPENDENCIA (usa temporalmente): Impresora USA Documento
```

### Paso 4: Dibujar UML Basico
```
+------------------+
|     Clase        |
+------------------+
| - atributo1      |  (- privado)
| # atributo2      |  (# protegido)
| + atributo3      |  (+ publico)
+------------------+
| + metodo1()      |
| - metodo2()      |
+------------------+
```

## Ejercicios

| # | Sistema | Entidades Principales | Dificultad |
|---|---------|----------------------|------------|
| 1 | Biblioteca | Libro, Miembro, Prestamo | ⭐⭐ |
| 2 | Estacionamiento | Vehiculo, Espacio, Ticket | ⭐⭐ |
| 3 | Restaurante | Mesa, Pedido, MenuItem | ⭐⭐⭐ |
| 4 | Banco | Cuenta, Transaccion, Cliente | ⭐⭐⭐ |
| 5 | Elevador | Elevador, Solicitud, Piso | ⭐⭐⭐ |
| 6 | Reservas | Recurso, TimeSlot, Reserva | ⭐⭐⭐ |
| 7 | Inventario | Producto, Stock, Alerta | ⭐⭐⭐ |
| 8 | Chat | Usuario, Mensaje, Sala | ⭐⭐⭐⭐ |
| 9 | Votacion | Candidato, Votante, Resultado | ⭐⭐⭐ |
| 10 | Subasta | Articulo, Puja, Subastador | ⭐⭐⭐⭐ |

## Preguntas Guia (para cada ejercicio)

1. **Clases**: Que clases necesitas?
2. **Atributos**: Que datos guarda cada clase?
3. **Metodos**: Que acciones realiza cada clase?
4. **Relaciones**: Como se conectan las clases?
5. **Patrones**: Que patrones de diseno aplicarias?

## Errores Comunes de Diseno

### God Class (Clase Dios)
```java
// MAL: Una clase que hace todo
class Sistema {
    void agregarLibro() {}
    void prestarLibro() {}
    void registrarMiembro() {}
    void generarReporte() {}
    void enviarNotificacion() {}
}

// BIEN: Responsabilidad unica
class Biblioteca { void prestarLibro() {} }
class GestorMiembros { void registrar() {} }
class GeneradorReportes { void generar() {} }
```

### Anemic Domain Model
```java
// MAL: Clase sin comportamiento
class Libro {
    String titulo;
    String autor;
    // solo getters/setters
}

// BIEN: Comportamiento encapsulado
class Libro {
    private String titulo;
    private EstadoLibro estado;

    public void prestar() {
        if (estado != DISPONIBLE) throw new IllegalStateException();
        estado = PRESTADO;
    }
}
```

## Siguientes Pasos

1. Completa el diseno en papel primero
2. Luego implementa en codigo
3. Compara tu diseno con las soluciones
4. Reflexiona: que harias diferente?
