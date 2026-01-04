# Ejercicio 13: Zoologico con Visitor para Estadisticas (Nivel 1)
**Dificultad:** Basico-Intermedio
**Tiempo estimado:** 55 minutos
**Conceptos:** Visitor Pattern, Herencia, Double Dispatch

---

## Contexto

Un zoologico necesita calcular diferentes estadisticas sobre sus animales sin modificar las clases de los animales constantemente. Usaras el Patron Visitor para separar la logica de calculo de las clases de datos.

---

## Requisitos

### Tipos de Animales:

Todos los animales tienen:
- Nombre (String)
- Edad en anios (int)

Tipos especificos:

**Mamifero:**
- Peso en kg (double)
- Tipo de pelaje (String): "corto", "largo", "sin pelaje"

**Ave:**
- Envergadura de alas en metros (double)
- Puede volar (boolean)

**Reptil:**
- Longitud en metros (double)
- Es venenoso (boolean)

### Patron Visitor - Calculadores:

Implementa **3 Visitors diferentes**:

**1. VisitorCalculoComida:**
- Calcula cantidad diaria de comida en kg
- Mamifero: peso × 0.03 (3% de su peso)
- Ave: envergadura × 0.5 kg (si vuela) o 0.3 kg (si no vuela)
- Reptil: longitud × 0.2 kg

**2. VisitorCalculoEspacioMinimo:**
- Calcula espacio minimo de habitat en m²
- Mamifero: peso × 2 m²
- Ave: envergadura² × 10 m² (si vuela) o 5 m² (si no vuela)
- Reptil: longitud² × 3 m²

**3. VisitorCalculoCostoVeterinario:**
- Calcula costo anual estimado de veterinario
- Mamifero: $50.000 base + $2.000 por cada anio de edad
- Ave: $30.000 base + $1.500 por cada anio + $10.000 extra si vuela
- Reptil: $40.000 base + $1.000 por cada anio + $20.000 extra si es venenoso

---

## Ejemplo de Ejecucion

```
=== ZOOLOGICO MUNICIPAL ===

Animales registrados:
1. Leon (Mamifero) - 5 anios, 190 kg, pelaje corto
2. Aguila (Ave) - 3 anios, envergadura 2.5 m, vuela: SI
3. Cocodrilo (Reptil) - 12 anios, 3.5 m, venenoso: NO
4. Oso (Mamifero) - 8 anios, 250 kg, pelaje largo

=== CALCULO DE COMIDA DIARIA ===
Leon: 5.70 kg/dia
Aguila: 1.25 kg/dia
Cocodrilo: 0.70 kg/dia
Oso: 7.50 kg/dia
TOTAL: 15.15 kg/dia

=== CALCULO DE ESPACIO MINIMO ===
Leon: 380.00 m²
Aguila: 62.50 m²
Cocodrilo: 36.75 m²
Oso: 500.00 m²
TOTAL: 979.25 m²

=== CALCULO DE COSTO VETERINARIO ANUAL ===
Leon: $60.000 ($50.000 base + $10.000 por edad)
Aguila: $54.500 ($30.000 base + $4.500 por edad + $10.000 vuela)
Cocodrilo: $52.000 ($40.000 base + $12.000 por edad)
Oso: $66.000 ($50.000 base + $16.000 por edad)
TOTAL: $232.500

=== RESUMEN ===
Total animales: 4
Comida diaria total: 15.15 kg
Espacio total requerido: 979.25 m²
Presupuesto veterinario anual: $232.500
```

---

## Debe entregar:

1. **Interface o clase abstracta Animal** con metodo `accept(VisitorAnimal visitor)`
2. **Clases concretas:** `Mamifero`, `Ave`, `Reptil`
   - Cada una implementa `accept()` con double dispatch
3. **Interface VisitorAnimal** con metodos:
   ```java
   double visitarMamifero(Mamifero m);
   double visitarAve(Ave a);
   double visitarReptil(Reptil r);
   ```
4. **3 clases Visitor concretas:**
   - VisitorCalculoComida
   - VisitorCalculoEspacioMinimo
   - VisitorCalculoCostoVeterinario
   - Cada una implementa la logica especifica de calculo
5. **Clase Zoologico** que:
   - Almacene lista de animales
   - Aplique visitors a todos los animales
   - Muestre estadisticas completas
6. **Clase Main** que demuestre todo el sistema

---

## Consideraciones:

- DEBE implementar Patron Visitor correctamente
- Usar double dispatch: `visitor.visitarTipoEspecifico(this)`
- Los 3 visitors deben poder aplicarse a los mismos animales
- Acumular totales correctamente
- Formatear salida de dinero: $XX.XXX
- El patron permite agregar nuevos calculos sin modificar las clases de animales

---

## Pistas:

1. En el metodo `accept()` de cada animal: `return visitor.visitarX(this);`
2. Usa un acumulador en el Zoologico para sumar resultados
3. Itera sobre la lista aplicando el visitor a cada animal
4. Cada visitor puede tener atributos para acumular resultados
5. Recuerda: el visitor VISITA los animales, no al reves

---

## Desafio Extra (Opcional):

1. Agrega un 4to visitor: `VisitorTiempoAtencionDiaria` que calcule minutos de atencion necesarios
2. Crea un visitor que identifique el animal mas caro de mantener
3. Implementa un metodo que compare costos entre diferentes tipos de animales

---

**NOTA:** Este es un ejercicio de PRACTICA INDEPENDIENTE. NO hay solucion incluida.
Debes resolverlo por tu cuenta. Si te atascas, revisa:
- Ejercicio 6 (Visitor introduccion)
- Ejercicio 7 (Visitor con multiples calculos)
- GUIA_ESTUDIO.md seccion Visitor Pattern
