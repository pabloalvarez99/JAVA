# Ejercicio 18: Sistema de Ventas con GUI (PRACTICA INDEPENDIENTE)
**Dificultad:** Avanzada
**Tiempo estimado:** 2 horas
**Conceptos:** Todos los patrones + Swing GUI (BONUS)
**Fase:** 2 (SIN SOLUCIONES - PRACTICA INDEPENDIENTE)

---

## IMPORTANTE

**Este ejercicio agrega GUI al sistema completo. Es preparacion para el BONUS del examen.**

**Si te atascas:** Revisa el Ejercicio 09 de la Fase 1.

---

## CONTEXTO

Una cadena de tiendas necesita un sistema de ventas con interfaz grafica que gestione productos, calcule descuentos, y genere reportes.

## FORMATO DEL ARCHIVO: ventas.txt

```
6
P001,Laptop,Electronica,1200.00,15
P002,Mouse,Accesorio,25.00,50
P003,Teclado,Accesorio,75.00,30
P004,Monitor,Electronica,350.00,20
P005,Camara,Electronica,800.00,10
P006,Auriculares,Accesorio,120.00,25
```

## TIPOS DE PRODUCTOS (Herencia)

**Electronica:**
- Garantia (meses): int
- Voltaje: String

**Accesorio:**
- Compatible con: String
- Material: String

## ESTRATEGIAS DE DESCUENTO

**Descuento Normal:**
- 0-500: Sin descuento
- 501-1000: 5%
- 1001+: 10%

**Descuento Black Friday:**
- 0-500: 10%
- 501-1000: 20%
- 1001+: 30%

**Descuento Mayorista:**
- Descuento fijo: 15% en todo

## PATRON VISITOR

**VisitorInventario:**
- Calcula valor total del stock
- Identifica productos con stock bajo

**VisitorVentas:**
- Calcula totales de ventas
- Agrupa por categoria

## GUI REQUIREMENTS

Crear interfaz con:
1. Boton "Cargar Inventario"
2. JTable mostrando productos
3. ComboBox para seleccionar estrategia de descuento
4. Boton "Calcular Totales"
5. Area de texto para mostrar estadisticas

## FORMATO DE SALIDA (En GUI)

```
=== INVENTARIO CARGADO ===
6 productos en el sistema

Codigo    Nombre         Categoria     Precio    Stock
P001      Laptop         Electronica   $1200.00  15
P002      Mouse          Accesorio     $25.00    50
P003      Teclado        Accesorio     $75.00    30
...

=== APLICANDO DESCUENTO BLACK FRIDAY ===
Laptop: Precio original $1200.00 -> Con descuento: $840.00
Mouse: Precio original $25.00 -> Con descuento: $22.50
...

=== ESTADISTICAS ===
Valor total inventario: $34,750.00
Productos Electronica: 3
Productos Accesorios: 3
Productos con stock bajo (<20): 2
```

## REQUISITOS TECNICOS

**OBLIGATORIO:**
- Herencia (Producto abstracto)
- Strategy (Descuentos)
- Visitor (Inventario y Ventas)
- GUI con Swing
- File chooser para seleccionar archivo
- Event listeners para botones
- Actualizacion dinamica de la interfaz

## COMPONENTES GUI MINIMOS

```java
JFrame principal
├── JPanel superior
│   ├── JButton cargarInventario
│   └── JComboBox<String> estrategias
├── JTable tablaProductos
├── JPanel inferior
│   └── JButton calcularTotales
└── JTextArea areaEstadisticas
```

## CONSIDERACIONES

1. La GUI debe ser responsive
2. Los datos deben actualizarse al cambiar la estrategia
3. Usar JFileChooser para abrir archivos
4. Capturar excepciones y mostrar JOptionPane con errores
5. Validar que se haya cargado el inventario antes de calcular

## CRITERIO DE EXITO

- [x] GUI funcional y responsive
- [x] Todos los patrones implementados
- [x] File chooser funciona
- [x] Calculos correctos
- [x] Interfaz intuitiva
- [x] Manejo de errores con dialogs

**TIEMPO MAXIMO:** 2 horas.

**NOTA:** La GUI es compleja. Si no has usado Swing, estudia el Ejercicio 09 primero.

---

*Ejercicio de Practica Independiente - Fase 2 - NIVEL EXAMEN + GUI*
