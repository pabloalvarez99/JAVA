# Ejercicio 14: Restaurante Multi-Cocina con Strategy y Visitor (Nivel 2)
**Dificultad:** Intermedio
**Tiempo estimado:** 90 minutos
**Conceptos:** Strategy Pattern, Visitor Pattern, Combinacion de Patrones, Herencia

---

## Contexto

Este ejercicio esta basado DIRECTAMENTE en el **Ejercicio Patrones.pdf** del material oficial.

Estas desarrollando el software para una "cocina fantasma" (restaurante que solo hace domicilios y maneja multiples tipos de cocina). El sistema debe gestionar la **preparacion** y **facturacion** de platos.

El restaurante ofrece tres tipos de cocina: **Italiana, Mexicana y Japonesa**.

---

## Requisitos

### Tipos de Platos:

Todos los platos tienen:
- Nombre (String)

Cada tipo tiene atributos especificos:

**PlatoItaliano** (Ej: Pasta):
- Tipo de pasta (String): "penne", "spaghetti"
- Tipo de salsa (String): "bolognesa", "carbonara"

**PlatoMexicano** (Ej: Tacos):
- Tipo de tortilla (String): "maiz", "trigo"
- Nivel de picante (String): "bajo", "medio", "alto"

**PlatoJapones** (Ej: Sushi):
- Tipo de pescado (String): "salmon", "atun"
- Incluye wasabi (boolean)

### Clase Pedido:

Un Pedido simplemente contiene:
- Lista de platos: `List<Plato> platos`
- Metodos para agregar platos y obtener la lista

---

## DESAFIO 1: El Arte de la Preparacion (PATRON STRATEGY)

El restaurante puede cambiar su **estrategia de preparacion** dinamicamente segun la demanda o hora del dia.

### Estrategias de Preparacion:

**1. EstrategiaPorPrioridad (Horno primero):**
- Prepara primero los platos que requieren coccion larga
- Platos italianos van primero
- Luego mexicanos
- Al final japoneses
- Muestra: "Preparando [nombre del plato] - [tipo]"

**2. EstrategiaEquilibrada (Un plato de cada tipo):**
- Para mantener a todos los chefs ocupados
- Prepara un plato italiano, uno mexicano, uno japones
- Luego repite el ciclo
- Formato ronda: "Ronda 1: [plato italiano], [plato mexicano], [plato japones]"

**3. EstrategiaRapida (Sushi primero):**
- Durante hora pico, prioridad a platos frios/rapidos
- Todos los platos japoneses primero
- Luego mexicanos
- Al final italianos
- Muestra: "Express: [nombre del plato] - [tipo]"

### Clase Restaurante:

Debe tener:
- `setEstrategiaPreparacion(IEstrategiaPreparacion estrategia)`
- `cocinarPedido(Pedido pedido)` - delega a la estrategia activa

---

## DESAFIO 2: La Complejidad de la Facturacion (PATRON VISITOR)

Necesitas calcular diferentes metricas sobre un pedido **SIN modificar las clases de platos**.

### Visitantes a Implementar:

**1. VisitorCalculoPrecio:**
- visit(PlatoItaliano): $10.000 + 20% extra si salsa es "carbonara"
- visit(PlatoMexicano): $6.000 + 10% si picante es "alto"
- visit(PlatoJapones): $16.000 + 35% si pescado es "atun" + 5% si lleva wasabi

**2. VisitorTiempoEstimado:**
- visit(PlatoItaliano): 15 min + 5 min si salsa es "bolognesa"
- visit(PlatoMexicano): 10 min (sin importar picante)
- visit(PlatoJapones): 20 min, pero 15 min si es solo de atun

### Interface IPlatoVisitable:

Todos los platos deben implementar:
```java
double accept(IVisitorPlato visitor);
```

---

## Ejemplo de Ejecucion

```
=== RESTAURANTE MULTI-COCINA ===

Creando pedido con 5 platos:
1. Pasta Carbonara (Italiano - spaghetti, carbonara)
2. Tacos Picantes (Mexicano - maiz, alto)
3. Sushi Premium (Japones - atun, con wasabi)
4. Pasta Bolognesa (Italiano - penne, bolognesa)
5. Sushi Salmon (Japones - salmon, sin wasabi)

=== PREPARACION: Estrategia Rapida (Sushi primero) ===
Express: Sushi Premium - Japones
Express: Sushi Salmon - Japones
Express: Tacos Picantes - Mexicano
Express: Pasta Carbonara - Italiano
Express: Pasta Bolognesa - Italiano

=== PREPARACION: Estrategia Por Prioridad (Horno primero) ===
Preparando Pasta Carbonara - Italiano
Preparando Pasta Bolognesa - Italiano
Preparando Tacos Picantes - Mexicano
Preparando Sushi Premium - Japones
Preparando Sushi Salmon - Japones

=== PREPARACION: Estrategia Equilibrada ===
Ronda 1: Pasta Carbonara (Italiano), Tacos Picantes (Mexicano), Sushi Premium (Japones)
Ronda 2: Pasta Bolognesa (Italiano), Sushi Salmon (Japones)

=== FACTURACION ===

Calculo de Precio:
- Pasta Carbonara: $12.000 ($10.000 + 20% por carbonara)
- Tacos Picantes: $6.600 ($6.000 + 10% por picante alto)
- Sushi Premium: $22.560 ($16.000 + 35% atun + 5% wasabi)
- Pasta Bolognesa: $10.000
- Sushi Salmon: $16.000
TOTAL: $67.160

Tiempo Estimado:
- Pasta Carbonara: 15 min
- Tacos Picantes: 10 min
- Sushi Premium: 15 min (atun es mas rapido)
- Pasta Bolognesa: 20 min (15 + 5 por bolognesa)
- Sushi Salmon: 20 min
TOTAL: 80 minutos
```

---

## Debe entregar:

### Para Strategy:
1. **Interface IEstrategiaPreparacion** con metodo `void preparar(Pedido pedido)`
2. **3 clases estrategia:** EstrategiaPorPrioridad, EstrategiaEquilibrada, EstrategiaRapida
3. **Clase Restaurante** (contexto del Strategy)

### Para Visitor:
4. **Interface o clase abstracta Plato** con metodo `double accept(IVisitorPlato visitor)`
5. **3 clases platos:** PlatoItaliano, PlatoMexicano, PlatoJapones (implementan IPlatoVisitable)
6. **Interface IVisitorPlato** con 3 metodos visit()
7. **2 clases visitor:** VisitorCalculoPrecio, VisitorTiempoEstimado

### Integracion:
8. **Clase Pedido** con lista de platos
9. **Clase Main** que demuestre:
   - Creacion de pedido con 5 platos (2 italianos, 1 mexicano, 2 japoneses)
   - Las 3 estrategias de preparacion
   - Los 2 visitors de facturacion

---

## Consideraciones:

- DEBE implementar AMBOS patrones correctamente
- Strategy y Visitor son INDEPENDIENTES (preparacion vs facturacion)
- Usa polimorfismo: los platos estan en una sola lista
- Para EstrategiaEquilibrada: agrupa por tipo y alterna
- Los visitors deben usar double dispatch
- Calculos de precio deben ser exactos (usar double)

---

## Pistas:

1. Para agrupar platos por tipo, puedes usar 3 listas temporales o instanceof
2. EstrategiaEquilibrada requiere logica de "rondas"
3. Los visitors acumulan totales iterando sobre el pedido
4. El restaurante NO modifica el pedido, solo cambia como se prepara
5. Cada plato debe implementar accept() llamando al metodo correcto del visitor

---

**NOTA:** Este ejercicio es PRACTICA INDEPENDIENTE basado en material oficial.
NO hay solucion incluida. Si te atascas:
- Revisa Ejercicio 2 (Strategy)
- Revisa Ejercicio 6 (Visitor)
- Lee **Ejercicio Patrones.pdf** del material oficial
