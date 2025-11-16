# Ejercicio 19: Sistema Universitario Completo con GUI (Nivel 3)
**Dificultad:** Avanzado
**Tiempo estimado:** 110 minutos
**Conceptos:** Strategy, Singleton, GUI (Swing), Herencia, Collections, Validaciones

---

## Contexto

Una universidad necesita un sistema para gestionar estudiantes, calcular sus aranceles segun diferentes planes de pago, y mostrar la informacion en una interfaz grafica.

Combinaras **Singleton, Strategy y GUI**.

---

## Requisitos

### Jerarquia de Estudiantes:

Todos los estudiantes tienen:
- RUT (String): formato "########-#"
- Nombre completo (String)
- Carrera (String): "Informatica", "Civil", "Medicina"
- Creditos inscritos (int)

Tipos de estudiantes:

**EstudianteRegular:**
- Promedio de notas (double): 1.0 - 7.0
- Numero de semestres cursados (int)
- Arancel base = creditos × $35.000

**EstudianteIntercambio:**
- Pais de origen (String)
- Universidad de origen (String)
- Arancel base = creditos × $50.000 (sin descuentos)

**EstudianteBecado:**
- Tipo de beca (String): "Excelencia", "Socioecononomica", "Deportiva"
- Porcentaje de beca (int): 25, 50, 75, 100
- Arancel base = creditos × $35.000

---

## PATRON 1: SINGLETON - SistemaUniversidad

El sistema debe ser Singleton y gestionar:
- Lista de estudiantes
- Estrategia de pago actual
- Metodos de consulta y estadisticas

**Metodos requeridos:**
- `getInstance()`
- `agregarEstudiante(Estudiante e)`
- `setEstrategiaPago(IEstrategiaPago estrategia)`
- `calcularArancelTotal()` - suma de aranceles con estrategia actual
- `buscarPorRUT(String rut)`
- `obtenerPorCarrera(String carrera)`
- `getEstudiantes()` - retorna lista completa

---

## PATRON 2: STRATEGY - Planes de Pago

### Interface IEstrategiaPago:
```java
double calcularArancel(EstudianteRegular e);
double calcularArancel(EstudianteIntercambio e);
double calcularArancel(EstudianteBecado e);
```

### Estrategias a Implementar:

**1. PlanContado:**
- Regular: base - 15% descuento
- Intercambio: base (sin descuento)
- Becado: (base × (100 - %beca) / 100) - 10% descuento adicional

**2. PlanCuotas:**
- Regular: base (sin descuento)
- Intercambio: base + 5% recargo
- Becado: (base × (100 - %beca) / 100)

**3. PlanMerito:**
- Regular: base - (promedio × 5%) descuento. Ej: promedio 6.0 = 30% desc.
- Intercambio: base - 10% si es de convenio (Brasil, Argentina, Colombia)
- Becado: (base × (100 - %beca) / 100) - 5% adicional

---

## PARTE 3: GUI (Swing)

Debes crear una interfaz grafica con:

### Ventana Principal:
- Titulo: "Sistema Universitario"
- Tamano: 600x500
- Layout: BorderLayout

### Panel Norte:
- Titulo grande: "SISTEMA DE GESTION UNIVERSITARIA"
- Layout: FlowLayout

### Panel Centro:
- Lista de estudiantes con scroll
- Mostrar: RUT, Nombre, Carrera, Tipo
- Usar JList o JTextArea con scroll

### Panel Sur:
- 3 botones para cambiar estrategia:
  * "Plan Contado"
  * "Plan Cuotas"
  * "Plan Merito"
- 1 boton: "Calcular Aranceles"
- 1 boton: "Mostrar Estadisticas"
- Layout: GridLayout(2, 3) o FlowLayout

### Funcionalidad de Botones:

**Botones de Plan:**
- Cambian la estrategia activa del Singleton
- Muestran mensaje: "Plan X activado"

**Boton Calcular Aranceles:**
- Aplica estrategia actual a todos
- Muestra en dialogo: lista de aranceles individuales y total

**Boton Mostrar Estadisticas:**
- Muestra en dialogo:
  * Total estudiantes
  * Distribucion por carrera
  * Distribucion por tipo
  * Arancel promedio
  * Arancel total

---

## Ejemplo de Ejecucion (Consola + GUI)

```
=== SISTEMA UNIVERSITARIO ===
[SINGLETON] Sistema inicializado

Agregando estudiantes...
[+] 12345678-9 - Juan Perez (Regular - Informatica) - 50 creditos
[+] 98765432-1 - Maria Lopez (Becado - Medicina) - 60 creditos, Beca Excelencia 75%
[+] 11223344-5 - Pedro Silva (Intercambio - Civil) - 45 creditos, Brasil
[+] 55667788-9 - Ana Torres (Regular - Informatica) - 55 creditos
[+] 99887766-5 - Luis Garcia (Becado - Informatica) - 50 creditos, Beca Deportiva 50%

[GUI] Ventana iniciada

--- Usuario presiona "Plan Contado" ---
Estrategia cambiada: Plan Contado

--- Usuario presiona "Calcular Aranceles" ---

ARANCELES CON PLAN CONTADO:

12345678-9 - Juan Perez (Regular):
  Base: $1.750.000 (50 creditos × $35.000)
  Descuento contado: -$262.500 (15%)
  TOTAL: $1.487.500

98765432-1 - Maria Lopez (Becado 75%):
  Base: $2.100.000 (60 creditos × $35.000)
  Despues de beca: $525.000 (25% del base)
  Descuento contado: -$52.500 (10%)
  TOTAL: $472.500

11223344-5 - Pedro Silva (Intercambio):
  Base: $2.250.000 (45 creditos × $50.000)
  TOTAL: $2.250.000 (sin descuentos)

55667788-9 - Ana Torres (Regular):
  Base: $1.925.000 (55 creditos × $35.000)
  Descuento contado: -$288.750 (15%)
  TOTAL: $1.636.250

99887766-5 - Luis Garcia (Becado 50%):
  Base: $1.750.000 (50 creditos × $35.000)
  Despues de beca: $875.000 (50% del base)
  Descuento contado: -$87.500 (10%)
  TOTAL: $787.500

TOTAL ARANCELES: $6.633.750

--- Usuario presiona "Mostrar Estadisticas" ---

ESTADISTICAS:
Total estudiantes: 5

Por carrera:
- Informatica: 3 (60.0%)
- Medicina: 1 (20.0%)
- Civil: 1 (20.0%)

Por tipo:
- Regular: 2 (40.0%)
- Becado: 2 (40.0%)
- Intercambio: 1 (20.0%)

Arancel promedio: $1.326.750
Arancel total: $6.633.750
```

---

## Debe entregar:

### Singleton + Strategy:
1. **Clase SistemaUniversidad (Singleton)**
2. **Clase abstracta Estudiante**
3. **3 clases concretas** de estudiantes
4. **Interface IEstrategiaPago** con metodos sobrecargados
5. **3 estrategias** de pago

### GUI:
6. **Clase VentanaPrincipal extends JFrame**
   - Configuracion de ventana
   - Paneles Norte, Centro, Sur
   - Botones con ActionListeners
   - Dialogs para mostrar resultados

7. **Clase Main** que:
   - Inicializa el Singleton
   - Agrega estudiantes de prueba
   - Lanza la GUI

---

## Consideraciones:

- DEBE ser Singleton correctamente implementado
- DEBE usar Strategy para calcular aranceles
- GUI debe ser funcional y clara
- Validar formato de RUT (opcional pero recomendado)
- Los botones deben cambiar el estado del sistema
- Usar JOptionPane para mostrar resultados
- Calculos deben ser precisos (double)

---

## Pistas:

1. ActionListener para botones:
   ```java
   botonContado.addActionListener(e -> {
       SistemaUniversidad.getInstance()
           .setEstrategiaPago(new PlanContado());
       JOptionPane.showMessageDialog(this, "Plan Contado activado");
   });
   ```

2. Para mostrar aranceles, itera sobre estudiantes:
   ```java
   StringBuilder sb = new StringBuilder("ARANCELES:\n\n");
   for (Estudiante est : sistema.getEstudiantes()) {
       double arancel = sistema.calcularArancel(est);
       sb.append(est.getNombre()).append(": $").append(arancel).append("\n");
   }
   JOptionPane.showMessageDialog(this, sb.toString());
   ```

3. Para JList con scroll:
   ```java
   DefaultListModel<String> model = new DefaultListModel<>();
   for (Estudiante e : estudiantes) {
       model.addElement(e.toString());
   }
   JList<String> lista = new JList<>(model);
   JScrollPane scroll = new JScrollPane(lista);
   ```

---

## Desafio Extra (Opcional):

1. Agrega campo de texto para buscar por RUT en la GUI
2. Implementa un grafico de barras para mostrar distribucion por carrera
3. Agrega boton para exportar resultados a archivo CSV
4. Implementa validacion de RUT con digito verificador

---

**NOTA:** Este ejercicio es AVANZADO. NO hay solucion incluida.
Si te atascas:
- Revisa Ejercicio 3 (Singleton)
- Revisa Ejercicio 2 y 7 (Strategy)
- Revisa Ejercicio 9 (GUI basica)
- GUIA_ESTUDIO.md seccion GUI
