# Ejercicio 12: Tienda de Articulos Deportivos (PRACTICA INDEPENDIENTE)
**Dificultad:** Basica
**Tiempo estimado:** 40 minutos
**Conceptos:** Factory Pattern, Herencia, Polimorfismo
**Fase:** 2 (SIN SOLUCIONES - PRACTICA INDEPENDIENTE)

---

## IMPORTANTE

**Este ejercicio NO incluye soluciones ni tutoriales paso a paso.**

Debes resolverlo de forma independiente aplicando los conceptos aprendidos en la Fase 1.

**Si te atascas:** Revisa el Ejercicio 04 (Factory Pattern) de la Fase 1.

---

## CONTEXTO

Una tienda de deportes vende tres categorias de productos: Calzado, Ropa y Equipamiento. Necesitas un sistema que use el patron Factory para crear paquetes promocionales predefinidos.

## TIPOS DE PRODUCTOS

Todos los productos tienen:
- Nombre (String)
- Precio (double)
- Marca (String)

Categorias especificas:

**Calzado:**
- Talla (int)
- Tipo: "Running", "Futbol", "Basketball"

**Ropa:**
- Talla (String): "S", "M", "L", "XL"
- Material: "Algodon", "Poliester", "Lycra"

**Equipamiento:**
- Deporte (String): "Futbol", "Tenis", "Basketball"
- Peso en gramos (int)

## PAQUETES PROMOCIONALES (FACTORY PATTERN)

La tienda ofrece 3 paquetes promocionales:

**Paquete Runner:** ($180)
- Calzado: "Nike Air Zoom" - $120 - Talla 42 - Running
- Ropa: "Camiseta Dri-Fit" - $35 - Talla M - Poliester
- Equipamiento: "Botella Deportiva" - $25 - Running - 500g

**Paquete Futbolista:** ($250)
- Calzado: "Adidas Predator" - $150 - Talla 41 - Futbol
- Ropa: "Short Deportivo" - $40 - Talla L - Poliester
- Equipamiento: "Balon Profesional" - $60 - Futbol - 450g

**Paquete Basketball:** ($280)
- Calzado: "Jordan Retro" - $180 - Talla 43 - Basketball
- Ropa: "Jersey NBA" - $50 - Talla XL - Poliester
- Equipamiento: "Balon Spalding" - $50 - Basketball - 600g

## REQUISITOS FUNCIONALES

1. Crear jerarquia de productos (clase abstracta Producto, subclases Calzado, Ropa, Equipamiento)
2. Crear clase PaquetePromocional que contenga 3 productos
3. Implementar PaqueteFactory con metodo estatico `crearPaquete(String tipo)`
4. El factory debe crear el paquete completo con los productos especificados
5. Calcular precio total del paquete
6. Mostrar detalle de todos los productos del paquete
7. Calcular peso total del paquete (solo de los Equipamientos)

## REQUISITOS TECNICOS

**OBLIGATORIO:**
- Usar herencia (clase abstracta Producto)
- Implementar Factory Pattern correctamente
- El factory debe ser una clase con metodos estaticos (NO se instancia)
- Los paquetes deben estar predefinidos
- Validar que el tipo de paquete sea valido ("Runner", "Futbolista", "Basketball")

## FORMATO DE SALIDA ESPERADO

```
=== TIENDA DE DEPORTES - PAQUETES PROMOCIONALES ===

--- PAQUETE RUNNER ---
Calzado: Nike Air Zoom ($120.00) - Marca: Nike - Talla: 42 - Tipo: Running
Ropa: Camiseta Dri-Fit ($35.00) - Marca: Nike - Talla: M - Material: Poliester
Equipamiento: Botella Deportiva ($25.00) - Marca: Nike - Deporte: Running - Peso: 500g

Precio Total: $180.00
Peso Total Equipamiento: 500g

--- PAQUETE FUTBOLISTA ---
Calzado: Adidas Predator ($150.00) - Marca: Adidas - Talla: 41 - Tipo: Futbol
Ropa: Short Deportivo ($40.00) - Marca: Adidas - Talla: L - Material: Poliester
Equipamiento: Balon Profesional ($60.00) - Marca: Adidas - Deporte: Futbol - Peso: 450g

Precio Total: $250.00
Peso Total Equipamiento: 450g

--- PAQUETE BASKETBALL ---
Calzado: Jordan Retro ($180.00) - Marca: Jordan - Talla: 43 - Tipo: Basketball
Ropa: Jersey NBA ($50.00) - Marca: Nike - Talla: XL - Material: Poliester
Equipamiento: Balon Spalding ($50.00) - Marca: Spalding - Deporte: Basketball - Peso: 600g

Precio Total: $280.00
Peso Total Equipamiento: 600g

--- PAQUETE INVALIDO ---
ERROR: Tipo de paquete no existe: Natacion
```

## DATOS DE PRUEBA

Tu Main debe intentar crear los 3 paquetes validos y uno invalido:

```java
PaqueteFactory factory = new PaqueteFactory(); // Si usas metodos estaticos, no necesitas esto

PaquetePromocional runner = PaqueteFactory.crearPaquete("Runner");
runner.mostrarDetalle();

PaquetePromocional futbolista = PaqueteFactory.crearPaquete("Futbolista");
futbolista.mostrarDetalle();

PaquetePromocional basketball = PaqueteFactory.crearPaquete("Basketball");
basketball.mostrarDetalle();

// Intentar crear paquete invalido
PaquetePromocional invalido = PaqueteFactory.crearPaquete("Natacion");
if (invalido == null) {
    System.out.println("ERROR: Tipo de paquete no existe: Natacion");
}
```

## CONSIDERACIONES

1. El Factory debe retornar `null` si el tipo de paquete no existe
2. La marca de los productos puede variar segun el paquete
3. Todos los precios deben mostrarse con 2 decimales
4. El peso total solo incluye Equipamientos (no calzado ni ropa)

## ESTRUCTURA SUGERIDA

```
Producto (abstract)
├── Calzado
├── Ropa
└── Equipamiento

PaquetePromocional
├── Producto calzado
├── Producto ropa
├── Producto equipamiento
├── calcularPrecioTotal()
├── calcularPesoTotal()
└── mostrarDetalle()

PaqueteFactory
└── static crearPaquete(String tipo)
```

## CRITERIO DE EXITO

Tu programa funciona correctamente si:
- [x] La salida coincide EXACTAMENTE con la esperada
- [x] Los 3 paquetes se crean correctamente
- [x] El paquete invalido retorna null
- [x] Los calculos de precio y peso son correctos
- [x] El factory usa metodos estaticos
- [x] El codigo compila sin errores

---

**RECUERDA:** Este es un ejercicio de PRACTICA INDEPENDIENTE. No hay soluciones proporcionadas.

**TIEMPO MAXIMO:** 40 minutos.

---

*Ejercicio de Practica Independiente - Fase 2*
