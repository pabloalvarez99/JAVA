# Ejercicio 16: Factory de Productos con Configuracion (Nivel 2)
**Dificultad:** Intermedio
**Tiempo estimado:** 65 minutos
**Conceptos:** Factory Pattern, Herencia, Enums (opcional), Validaciones

---

## Contexto

Una tienda de electronica necesita crear diferentes tipos de productos de manera consistente y validada. El patron Factory asegurara que los productos se creen correctamente segun especificaciones.

---

## Requisitos

### Jerarquia de Productos:

Todos los productos tienen:
- Codigo (String)
- Marca (String)
- Precio base (double)

Tipos especificos:

**Laptop:**
- RAM en GB (int): 4, 8, 16, 32
- Almacenamiento en GB (int): 256, 512, 1024, 2048
- Procesador (String): "i3", "i5", "i7", "i9"
- Precio final = base + (RAM × $5.000) + (almacenamiento/256 × $10.000)

**Smartphone:**
- Tamano pantalla en pulgadas (double): 5.5, 6.0, 6.5, 7.0
- Capacidad bateria en mAh (int)
- Camara megapixeles (int): 12, 48, 64, 108
- Precio final = base + (camaras × $2.000) + (bateria/1000 × $3.000)

**Tablet:**
- Tamano pantalla en pulgadas (double): 8.0, 10.0, 12.0
- Tiene stylus (boolean)
- Almacenamiento en GB (int): 64, 128, 256
- Precio final = base + (almacenamiento × $200) + ($50.000 si tiene stylus)

---

## Patron Factory

### Clase ProductoFactory

Debe tener metodos estaticos para crear productos:

```java
public static Laptop crearLaptop(String marca, int ram, int almacenamiento, String procesador)
public static Smartphone crearSmartphone(String marca, double pantalla, int bateria, int camara)
public static Tablet crearTablet(String marca, double pantalla, boolean stylus, int almacenamiento)
```

### Validaciones en la Factory:

La factory debe validar parametros:
- **Laptop:** RAM debe ser 4, 8, 16 o 32. Almacenamiento 256, 512, 1024 o 2048. Procesador valido.
- **Smartphone:** Pantalla entre 5.5 y 7.0. Bateria minimo 2000 mAh. Camara 12, 48, 64 o 108 MP.
- **Tablet:** Pantalla 8.0, 10.0 o 12.0. Almacenamiento 64, 128 o 256.

Si validacion falla, lanzar `IllegalArgumentException` con mensaje descriptivo.

### Generacion Automatica de Codigos:

La factory debe generar codigos unicos automaticamente:
- Laptops: "LAP-001", "LAP-002", ...
- Smartphones: "PHN-001", "PHN-002", ...
- Tablets: "TAB-001", "TAB-002", ...

---

## Ejemplo de Ejecucion

```
=== TIENDA DE ELECTRONICA ===

Creando productos con Factory...

[OK] Laptop creada: LAP-001
  Marca: Dell
  Procesador: i7, RAM: 16GB, Almacenamiento: 512GB
  Precio: $660.000 ($500.000 + $80.000 RAM + $80.000 storage)

[OK] Smartphone creado: PHN-001
  Marca: Samsung
  Pantalla: 6.5", Bateria: 5000mAh, Camara: 64MP
  Precio: $543.000 ($400.000 + $128.000 camara + $15.000 bateria)

[OK] Tablet creada: TAB-001
  Marca: Apple
  Pantalla: 12.0", Stylus: SI, Almacenamiento: 256GB
  Precio: $601.200 ($500.000 + $51.200 storage + $50.000 stylus)

[ERROR] Fallo al crear Laptop: RAM invalida. Valores permitidos: 4, 8, 16, 32
[ERROR] Fallo al crear Smartphone: Pantalla debe estar entre 5.5 y 7.0 pulgadas

[OK] Laptop creada: LAP-002
  Marca: HP
  Procesador: i5, RAM: 8GB, Almacenamiento: 256GB
  Precio: $550.000 ($500.000 + $40.000 RAM + $10.000 storage)

=== CATALOGO DE PRODUCTOS ===

Total productos: 4

LAPTOPS (2):
1. [LAP-001] Dell i7 - 16GB RAM - 512GB → $660.000
2. [LAP-002] HP i5 - 8GB RAM - 256GB → $550.000

SMARTPHONES (1):
1. [PHN-001] Samsung 6.5" - 64MP - 5000mAh → $543.000

TABLETS (1):
1. [TAB-001] Apple 12.0" - 256GB - Con Stylus → $601.200

=== ESTADISTICAS ===
Precio promedio: $588.550
Producto mas caro: TAB-001 ($601.200)
Producto mas barato: LAP-002 ($550.000)
```

---

## Debe entregar:

1. **Clase abstracta Producto** con:
   - Atributos comunes
   - Constructor
   - Metodo abstracto: `double calcularPrecioFinal()`
   - Metodo abstracto: `String mostrarInfo()`

2. **3 clases concretas:**
   - Laptop
   - Smartphone
   - Tablet

3. **Clase ProductoFactory:**
   - 3 metodos estaticos para crear productos
   - Validaciones completas
   - Generacion automatica de codigos
   - Contadores estaticos para cada tipo

4. **Clase Tienda** que:
   - Almacene todos los productos
   - Agrupe productos por tipo
   - Calcule estadisticas

5. **Clase Main** que demuestre:
   - Creacion exitosa de productos
   - Manejo de errores (validaciones)
   - Uso del catalogo y estadisticas

---

## Consideraciones:

- DEBE usar Factory Pattern correctamente
- Metodos factory son ESTATICOS
- Validaciones deben ser COMPLETAS y lanzar excepciones
- Codigos deben incrementarse automaticamente
- Usar variables estaticas para contadores
- Formatear precios correctamente: $XXX.XXX

---

## Pistas:

1. Contadores estaticos en la factory:
   ```java
   private static int contadorLaptops = 0;
   private static int contadorSmartphones = 0;
   private static int contadorTablets = 0;
   ```

2. Generar codigo:
   ```java
   String codigo = String.format("LAP-%03d", ++contadorLaptops);
   ```

3. Validacion con array:
   ```java
   int[] ramsValidas = {4, 8, 16, 32};
   boolean valido = false;
   for (int r : ramsValidas) {
       if (ram == r) { valido = true; break; }
   }
   if (!valido) throw new IllegalArgumentException("RAM invalida...");
   ```

4. Para agrupar productos, usa 3 listas o metodo con instanceof

---

## Desafio Extra (Opcional):

1. Agrega un 4to tipo: Monitor (con resolucion, tasa de refresco, tamano)
2. Implementa un metodo `crearProductoDesdeString(String tipo, String params)`
3. Agrega configuraciones predefinidas: `crearLaptopGamer()`, `crearSmartphonePremium()`
4. Implementa descuento por volumen: 10% si compras 3+ productos del mismo tipo

---

**NOTA:** Este es un ejercicio de PRACTICA INDEPENDIENTE. NO hay solucion incluida.
Si te atascas:
- Revisa Ejercicio 4 (Factory basico)
- GUIA_ESTUDIO.md seccion Factory Pattern
- Documentacion de IllegalArgumentException
