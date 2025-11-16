# GUIA DE ESTRATEGIAS PARA EL EXAMEN POO

## Como Aprobar con Nota Sobresaliente - Prueba 2 POO

**Duracion**: 3 horas
**Puntaje aprobatorio (4.0)**: 60% = 0.6 puntos de 1.0
**Puntaje para nota maxima**: 100% = 1.0 punto

---

## INDICE

1. [Estructura del Examen](#estructura-del-examen)
2. [Problema 1: Ruteo (0.3 puntos)](#problema-1-ruteo)
3. [Problema 2: Implementacion (0.7 puntos)](#problema-2-implementacion)
4. [Gestion del Tiempo](#gestion-del-tiempo)
5. [Errores que Cuestan Puntos](#errores-que-cuestan-puntos)
6. [Checklist Pre-Entrega](#checklist-pre-entrega)

---

## Estructura del Examen

### Distribucion de Puntaje

| Problema | Puntaje | % del Total | Tiempo Sugerido |
|----------|---------|-------------|-----------------|
| Problema 1: Ruteo (Code Tracing) | 0.3 | 30% | 30-40 min |
| Problema 2: Implementacion (Coding) | 0.7 | 70% | 140-150 min |
| **TOTAL** | **1.0** | **100%** | **180 min** |

### Patrones Obligatorios

**SIEMPRE se piden**:
- **Visitor** (obligatorio)
- **Strategy** (obligatorio)
- **Singleton O Factory** (elegir uno)

**Extras opcionales**:
- **GUI** (puntaje extra)
- **Arquitectura Sistema** (obligatorio - interface + implementacion)

---

## Problema 1: Ruteo (0.3 puntos)

### Que es Ruteo?

**Ruteo = Code Tracing = Ejecutar codigo manualmente**

Te dan codigo Java y debes:
1. Dibujar la interfaz grafica resultante
2. Responder preguntas sobre el comportamiento

### Estrategia para Resolver

#### PASO 1: Lee el codigo DOS veces (5 min)
- Primera lectura: General, identifica clases y patrones
- Segunda lectura: Detallada, sigue el flujo del `main()`

#### PASO 2: Identifica el punto de entrada (2 min)
```java
public static void main(String[] args) {
    // AQUI EMPIEZA TODO
}
```

#### PASO 3: Sigue el flujo linea por linea (15 min)

**Ejemplo del Examen Real**:

```java
public static void main(String[] args) {
    Configurator configurator = Configurator.getInstance(); // 1. Singleton
    configurator.setStrategyBasedOnRut();                   // 2. Pide RUT
    configurator.applyLayout();                             // 3. Crea GUI
}
```

**Ruteo**:
1. `Configurator.getInstance()` - Crea instancia unica (Singleton)
2. `setStrategyBasedOnRut()` - Pide RUT con `Scanner`, valida formato
   - Si RUT tiene 4to digito entre 0-5: `HorizontalLayoutStrategy`
   - Si RUT tiene 4to digito entre 6-9: `VerticalLayoutStrategy`
   - Sino: Mensaje de error y usa `HorizontalLayoutStrategy`
3. `applyLayout()` - Crea JFrame y aplica la estrategia de layout

#### PASO 4: Dibuja la GUI (10 min)

**Consejos para dibujar**:
- No tiene que ser perfecto, pero SI reconocible
- Etiqueta los componentes (Boton 1, Boton 2, etc.)
- Indica la orientacion (horizontal vs vertical)
- Marca el tamanio de la ventana si se especifica

**Ejemplo de dibujo aceptable**:

```
┌─────────────────────────────┐
│   Ventana con Layout        │
├─────────────────────────────┤
│  [Boton 1] [Boton 2]        │
│  [Boton 3] [Boton 4]        │
│  [Boton 5]                  │
└─────────────────────────────┘
     (Horizontal Layout)
```

#### PASO 5: Responde las preguntas (5 min)

**Tipo de preguntas comunes**:
- "Al presionar que boton aparece un mensaje?"
  - Busca `ActionListener` o logica asociada a botones
- "Que sucede al presionar el boton X?"
  - Sigue el codigo del evento del boton
- "Cuantos botones se crean?"
  - Cuenta los `new JButton()` o loops que los crean

### Errores Comunes en Ruteo

| Error | Impacto | Como Evitarlo |
|-------|---------|---------------|
| No validar RUT correctamente | 20-30% del puntaje | Lee BIEN la logica de validacion |
| Dibujar layout incorrecto | 30-40% del puntaje | Identifica si es BoxLayout.X_AXIS o Y_AXIS |
| No seguir el flujo de metodos | 50% del puntaje | Anota cada llamada a metodo |
| Olvidar componentes ocultos | 10-20% del puntaje | Revisa `setVisible(false)` |

### Checklist Problema 1

- [ ] Leer codigo completo 2 veces
- [ ] Identificar patron Singleton (getInstance)
- [ ] Identificar patron Strategy (setStrategy)
- [ ] Seguir flujo del main() paso a paso
- [ ] Anotar valor de variables importantes (RUT, layout seleccionado)
- [ ] Dibujar GUI con componentes correctos
- [ ] Verificar orientacion del layout
- [ ] Responder preguntas con codigo de respaldo

**Tiempo total**: 30-40 minutos

---

## Problema 2: Implementacion (0.7 puntos)

### Que se Pide?

**Estructura tipica**:
1. Sistema de gestion (flota de vehiculos, restaurante, etc.)
2. Lectura de archivo de texto
3. Implementacion de 3 patrones (Visitor + Strategy + Singleton/Factory)
4. Arquitectura Sistema (interface + implementacion)
5. Calculo de metricas
6. Salida formateada

### Estrategia para Resolver

#### FASE 1: PLANIFICACION (15 min)

**PASO 1: Lee el problema COMPLETO**
- No empieces a codear todavia
- Subraya lo importante

**PASO 2: Identifica las entidades**
- Cuales son las clases principales?
- Que atributos tiene cada una?
- Que relaciones hay? (herencia, composicion)

**Ejemplo Rent a Car**:
```
Entidades:
- Vehicle (abstracta)
  - Car
  - SUV
  - Pickup
- DrivingStrategy (interface)
  - EcoMode
  - NormalMode
  - SportMode
- Visitor (interface)
  - UsageVisitor (para calcular max consumo)
- FleetSystem (interface)
- SystemImpl (implementacion)
```

**PASO 3: Dibuja diagrama de clases rapido**

```
         Vehicle (abstract)
         /    |     \
       Car   SUV   Pickup
        |     |      |
        v     v      v
    accept(Visitor)

    DrivingStrategy (interface)
       /     |      \
   Eco   Normal   Sport
```

**PASO 4: Identifica formato de archivo**

```
N                           <- Cantidad de items
Item1_data                  <- N lineas con datos
Item2_data
...
Transaction1_data           <- Transacciones (variable)
Transaction2_data
...
```

#### FASE 2: IMPLEMENTACION (120 min)

**ORDEN RECOMENDADO DE IMPLEMENTACION**:

1. **Clases de Datos (20 min)**
   - Entidades principales con atributos
   - Getters y constructores
   - toString() si es necesario

2. **Herencia (10 min)**
   - Clase abstracta o interface base
   - Clases hijas con override

3. **Patron Strategy (15 min)**
   - Interface Strategy
   - 3 implementaciones concretas
   - Metodo para setear estrategia

4. **Patron Visitor (20 min)**
   - Interface Visitor
   - Metodos visit() para cada tipo
   - Interface Visitable con accept()
   - Implementar accept() en clases concretas
   - Visitor concreto con logica

5. **Patron Singleton o Factory (10 min)**
   - Si usas Singleton: getInstance()
   - Si usas Factory: createVehicle(tipo)

6. **Sistema (Interface + Implementacion) (20 min)**
   - Interface del sistema
   - Implementacion con lista de items
   - Metodos de registro
   - Metodos de consulta

7. **Lectura de Archivo (15 min)**
   - Scanner con File
   - Parseo de lineas
   - Registro en sistema

8. **Main y Demostracion (10 min)**
   - Llamar readFile()
   - Aplicar visitor
   - Mostrar resultados

#### FASE 3: TESTING Y AJUSTES (25 min)

**PASO 1: Compila (5 min)**
```bash
javac *.java
```
- Corrige errores de sintaxis

**PASO 2: Ejecuta con archivo de prueba (5 min)**
```bash
java Main
```
- Verifica que no hay NullPointerException
- Verifica que lee el archivo

**PASO 3: Compara salida con ejemplo (10 min)**
- Los numeros deben coincidir
- El formato debe ser similar
- No tiene que ser identico, pero cercano

**PASO 4: Revisa codigo (5 min)**
- Nombres de variables en ingles
- Sin codigo comentado
- Sin prints de debug

### Distribucion de Puntaje (Estimada)

| Aspecto | Puntaje Aprox | Notas |
|---------|---------------|-------|
| Clases con herencia correcta | 10% | Debe haber clase abstracta/interface |
| Patron Strategy | 20% | Interface + 3 implementaciones + uso |
| Patron Visitor | 25% | Interface + accept() + visitor concreto |
| Singleton o Factory | 10% | Correctamente implementado |
| Sistema (arquitectura) | 10% | Interface + implementacion |
| Lectura de archivo | 10% | Parseo correcto |
| Calculos correctos | 10% | Resultados coinciden con ejemplo |
| Codigo limpio | 5% | Nombres, formato, sin errores |
| **TOTAL** | **100%** | = 0.7 puntos |

---

## Gestion del Tiempo

### Timeline Recomendado

| Tiempo | Actividad | Objetivo |
|--------|-----------|----------|
| 0:00 - 0:10 | Leer TODO el examen 2 veces | Entender scope |
| 0:10 - 0:40 | Problema 1: Ruteo | Completar y verificar |
| 0:40 - 0:55 | Planificar Problema 2 | Diagrama de clases, entidades |
| 0:55 - 2:15 | Implementar Problema 2 | Codear en orden recomendado |
| 2:15 - 2:40 | Testing y ajustes | Compilar, ejecutar, comparar |
| 2:40 - 3:00 | Revision final y exportar | Checklist, crear .zip |

### Manejo de Problemas

**Si te atascas (15+ min en un problema)**:
1. DEJA un comentario TODO
2. CONTINUA con la siguiente parte
3. VUELVE al final si hay tiempo

**Ejemplo**:
```java
// TODO: Implementar logica de descuento por categoria
// Por ahora retorno 0
public double calcularDescuento() {
    return 0;
}
```

**Razon**: Es mejor entregar 80% funcionando que 50% perfecto.

---

## Errores que Cuestan Puntos

### Errores Criticos (Pierdes 30-50% del puntaje)

1. **No usar los patrones pedidos**
   - Si no usas Visitor: -25%
   - Si no usas Strategy: -20%
   - Si no usas Singleton/Factory: -10%

2. **No crear la arquitectura Sistema**
   - Debes tener interface + implementacion
   - -15% si falta

3. **No leer el archivo correctamente**
   - Si el programa no procesa el archivo: -15%

4. **Herencia incorrecta o ausente**
   - Si no hay clase abstracta/interface base: -10%

### Errores Moderados (Pierdes 10-20% del puntaje)

5. **Calculos incorrectos**
   - Si los numeros no coinciden: -10-15%

6. **No seguir formato de salida**
   - Si la salida es muy diferente: -10%

7. **Codigo que no compila**
   - ERROR FATAL: Puede ser 0
   - Asegurate que compile!

### Errores Menores (Pierdes 5-10% del puntaje)

8. **Variables en espanol**
   - Deberian estar en ingles: -5%

9. **Codigo sucio (mucho codigo comentado, prints de debug)**
   - -5%

10. **No exportar como .zip**
    - Puede no ser revisado!

---

## Checklist Pre-Entrega

### Codigo

- [ ] El codigo **COMPILA** sin errores
- [ ] El codigo **EJECUTA** sin excepciones
- [ ] La salida es **SIMILAR** al ejemplo (no tiene que ser identica)

### Patrones

- [ ] **Visitor**: Interface + visit() por tipo + accept() + visitor concreto
- [ ] **Strategy**: Interface + 3 implementaciones + setStrategy() + uso
- [ ] **Singleton O Factory**: Correctamente implementado

### Arquitectura

- [ ] Interface **Sistema** con metodos principales
- [ ] Clase **SistemaImpl** que implementa la interface
- [ ] Uso del Sistema en el Main

### Herencia

- [ ] Clase abstracta o interface base
- [ ] Al menos 2-3 clases que heredan/implementan
- [ ] Override de metodos abstractos

### Archivo

- [ ] Lectura correcta del archivo
- [ ] Parseo de lineas (split, parseInt, etc.)
- [ ] Registro en el sistema

### Limpieza

- [ ] Variables y metodos en **INGLES**
- [ ] Sin codigo comentado masivo
- [ ] Sin prints de debug (`System.out.println("DEBUG: ...")`)
- [ ] Nombres descriptivos

### Exportacion

- [ ] Proyecto exportado como **.zip** (opcion "Archive File" en Eclipse)
- [ ] Archivo de texto incluido en el .zip
- [ ] Nombre y RUT en alguna parte del codigo o en un comentario

---

## Tips Profesionales

### Tip 1: Empieza por lo que sabes
Si te sientes inseguro, empieza por las partes faciles:
- Clases de datos
- Getters/setters
- Lectura de archivo

### Tip 2: Usa el ejemplo de salida como guia
El ejemplo te dice EXACTAMENTE que calcular y como formatear.

### Tip 3: No te preocupes por optimizacion
El examen NO evalua eficiencia, evalua:
- Correcto uso de patrones
- Codigo que funciona
- Arquitectura clara

### Tip 4: Comenta lo complejo
Si tienes una formula complicada, agrega un comentario:
```java
// Formula: Eficiencia en modo Eco es 10% menor que nominal
double efficiency = v.getEfficiency() * 0.9;
```

### Tip 5: Revisa el material oficial
El examen suele tener estructura SIMILAR a ejemplos vistos en clase.

---

## Resumen Ejecutivo

### Para aprobar (4.0 - 60%):
- Problema 1 completo (0.3)
- Problema 2 con patrones basicos (0.3 de 0.7)
- Codigo que compila y ejecuta

### Para nota alta (6.0+ - 85%):
- Problema 1 perfecto (0.3)
- Problema 2 con todos los patrones (0.55 de 0.7)
- Calculos correctos
- Codigo limpio

### Para nota maxima (7.0 - 100%):
- Problema 1 perfecto (0.3)
- Problema 2 completo con GUI (0.7+)
- Arquitectura impecable
- Codigo profesional

---

## Practica Recomendada

1. Resuelve **Ejercicio20_SimulacroExamen.md** en 3 horas
2. Analiza el examen real PDF y compara con tu solucion
3. Practica ruteo con **Ejercicio09_RuteoGUI.md**
4. Revisa las guias de patrones antes del examen

---

**Recuerda**: El examen evalua tu capacidad de aplicar patrones y resolver problemas, NO de memorizar codigo. Entiende los conceptos y practica!

**Tiempo de estudio de esta guia**: 30 minutos
**Relee antes del examen**: 15 minutos
