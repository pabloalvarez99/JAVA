# Ejercicio 12: Tienda con Estrategias de Descuento (Nivel 1)
**Dificultad:** Basico-Intermedio
**Tiempo estimado:** 50 minutos
**Conceptos:** Strategy Pattern, Herencia, Collections

---

## Contexto

Una tienda online necesita aplicar diferentes estrategias de descuento segun la temporada o eventos especiales. Los descuentos cambian frecuentemente y deben poder intercambiarse en tiempo real.

---

## Requisitos

### Productos:

Todos los productos tienen:
- Codigo (String)
- Nombre (String)
- Precio base (double)
- Categoria (String): "Electronica", "Ropa", "Alimentos"

### Estrategias de Descuento:

Implementa **Patron Strategy** con 3 estrategias diferentes:

**1. EstrategiaDescuentoPorcentaje:**
- Aplica un porcentaje fijo de descuento a todos los productos
- Ej: 15% de descuento → producto de $100 queda en $85

**2. EstrategiaDescuentoPorCategoria:**
- Electronica: 20% descuento
- Ropa: 30% descuento
- Alimentos: 10% descuento

**3. EstrategiaDescuento2x1:**
- Si el carrito tiene 2 o mas productos, el de menor precio es gratis
- Si tiene 4 o mas, los 2 de menor precio son gratis
- Formula general: cada 2 productos, el mas barato es gratis

---

## Ejemplo de Ejecucion

```
=== TIENDA ONLINE ===

Productos en carrito:
1. [E001] Laptop - $800.00 (Electronica)
2. [R001] Camisa - $25.00 (Ropa)
3. [A001] Arroz - $5.00 (Alimentos)
4. [E002] Mouse - $15.00 (Electronica)

Total sin descuento: $845.00

=== ESTRATEGIA: Descuento Porcentaje (15%) ===
Laptop: $800.00 → $680.00 (15% desc.)
Camisa: $25.00 → $21.25 (15% desc.)
Arroz: $5.00 → $4.25 (15% desc.)
Mouse: $15.00 → $12.75 (15% desc.)
TOTAL CON DESCUENTO: $718.25
Ahorro: $126.75

=== ESTRATEGIA: Descuento Por Categoria ===
Laptop: $800.00 → $640.00 (20% desc. Electronica)
Camisa: $25.00 → $17.50 (30% desc. Ropa)
Arroz: $5.00 → $4.50 (10% desc. Alimentos)
Mouse: $15.00 → $12.00 (20% desc. Electronica)
TOTAL CON DESCUENTO: $674.00
Ahorro: $171.00

=== ESTRATEGIA: 2x1 ===
Laptop: $800.00 (paga completo)
Camisa: $25.00 (paga completo)
Arroz: $5.00 → GRATIS (producto mas barato #1)
Mouse: $15.00 → GRATIS (producto mas barato #2)
TOTAL CON DESCUENTO: $825.00
Ahorro: $20.00

=== MEJOR OPCION ===
Estrategia recomendada: Descuento Por Categoria
Ahorro maximo: $171.00 (20.2%)
```

---

## Debe entregar:

1. **Clase Producto** con atributos y metodos basicos
2. **Interface IEstrategiaDescuento** con metodo:
   ```java
   double calcularDescuento(List<Producto> carrito);
   ```
3. **3 clases estrategia concretas** que implementen la interface
4. **Clase CarritoCompras** que:
   - Almacene lista de productos
   - Tenga referencia a una estrategia actual
   - Permita cambiar estrategia: `setEstrategia(IEstrategiaDescuento estrategia)`
   - Calcule total sin descuento
   - Calcule total con descuento usando estrategia
   - Muestre detalles del descuento aplicado
5. **Clase Main** que demuestre:
   - Creacion de carrito con 4-5 productos
   - Aplicacion de las 3 estrategias diferentes
   - Comparacion de resultados
   - Recomendacion de mejor estrategia

---

## Consideraciones:

- DEBE usar Patron Strategy correctamente
- La estrategia debe ser intercambiable en tiempo de ejecucion
- Calculos de descuento deben ser precisos (usar double)
- Mostrar desglose detallado de cada producto
- Para 2x1: debes identificar los productos mas baratos (usar sorting o busqueda)

---

## Pistas:

1. Usa `List<Producto>` para el carrito
2. Para la estrategia 2x1, ordena productos por precio
3. Puedes crear metodos auxiliares en el Carrito para mostrar informacion
4. La interface solo necesita UN metodo: calcular el descuento total
5. Cada estrategia puede tener logica diferente pero todas devuelven un double

---

## Desafio Extra (Opcional):

1. Agrega una 4ta estrategia: "Black Friday" - 50% en Electronica, 40% en Ropa, 5% en Alimentos
2. Crea un metodo que encuentre automaticamente la mejor estrategia para el carrito actual
3. Implementa un sistema de puntos: cada $10 gastados = 1 punto, usa Strategy para calcular puntos

---

**NOTA:** Este es un ejercicio de PRACTICA INDEPENDIENTE. NO hay solucion incluida.
Debes resolverlo por tu cuenta. Si te atascas, revisa:
- Ejercicio 2 (Strategy basico)
- Ejercicio 7 (Strategy con tarifas)
- GUIA_ESTUDIO.md seccion Strategy Pattern
