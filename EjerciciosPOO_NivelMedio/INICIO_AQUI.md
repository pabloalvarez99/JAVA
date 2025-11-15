# BIENVENIDO - Ejercicios de Preparacion POO

## Empieza Aqui

Este conjunto de ejercicios te preparara progresivamente para rendir el examen de Programacion Orientada a Objetos.

---

## Pasos para Comenzar

### 1. Lee Primero
- [ ] **README.md** - Estructura general de los ejercicios
- [ ] **GUIA_ESTUDIO.md** - Conceptos clave y estrategia de estudio
- [ ] Este archivo (INICIO_AQUI.md)

### 2. Familiarizate con el Examen Real
- [ ] Revisa el PDF del examen original: `Prueba 2 - POO (1).pdf`
- [ ] Identifica los dos problemas principales
- [ ] Nota los patrones requeridos: Visitor + Strategy + (Singleton o Factory)

### 3. Orden de Estudio Recomendado

**NIVEL 1 - Fundamentos (Semana 1)**
```
Ejercicio 01: Biblioteca Basica
├─ Conceptos: Herencia, Polimorfismo, ArrayList
├─ Dificultad: Facil-Medio
└─ Tiempo: 30-40 minutos

Ejercicio 02: Tienda con Strategy
├─ Conceptos: Strategy Pattern
├─ Dificultad: Medio
└─ Tiempo: 45 minutos

Ejercicio 03: Banco con Singleton
├─ Conceptos: Singleton Pattern
├─ Dificultad: Medio
└─ Tiempo: 40 minutos

Ejercicio 04: Restaurante con Factory
├─ Conceptos: Factory Pattern
├─ Dificultad: Medio
└─ Tiempo: 45 minutos
```

**NIVEL 2 - File I/O y Visitor (Semana 2)**
```
Ejercicio 05: Lectura de Archivos
├─ Conceptos: File I/O, Parsing, Collections
├─ Dificultad: Medio
└─ Tiempo: 60 minutos

Ejercicio 06: Patron Visitor
├─ Conceptos: Visitor Pattern, Double Dispatch
├─ Dificultad: Medio-Avanzado
└─ Tiempo: 75 minutos
```

**NIVEL 3 - Integracion (Semana 3)**
```
Ejercicio 07: Flota de Taxis
├─ Conceptos: File I/O + Strategy + Visitor
├─ Dificultad: Medio-Avanzado
└─ Tiempo: 90 minutos

Ejercicio 08: Rent a Car Simplificado
├─ Conceptos: Todos los patrones integrados
├─ Dificultad: Avanzado
└─ Tiempo: 90 minutos
```

**NIVEL 4 - Examen (Semana 4)**
```
Ejercicio 09: Ruteo de Codigo GUI
├─ Conceptos: Code Tracing, Singleton, Strategy, Swing
├─ Dificultad: Medio
└─ Tiempo: 45 minutos
└─ SIMILAR A PROBLEMA 1 DEL EXAMEN

Ejercicio 10: Rent a Car Completo
├─ Conceptos: REPLICA EXACTA DEL EXAMEN
├─ Dificultad: Avanzado (Nivel Examen)
└─ Tiempo: 3 horas
└─ REPLICA DEL PROBLEMA 2 DEL EXAMEN
```

---

## Archivos de Datos

Los archivos de prueba estan en la carpeta `datos/`:
- `estudiantes.txt` - Para Ejercicio 5
- `flota.txt` - Para Ejercicio 7
- `fleet_simple.txt` - Para Ejercicio 8
- `fleet.txt` - Para Ejercicio 10 (datos completos del examen)

---

## Como Trabajar Cada Ejercicio

### Metodologia Recomendada:

1. **Lee el enunciado COMPLETO** del ejercicio DOS veces
2. **Planifica en papel:**
   - Que clases necesitas
   - Que patrones vas a usar
   - Como se relacionan las clases
3. **Implementa por fases:**
   - Primero las clases base (herencia)
   - Luego los patrones
   - Finalmente la logica principal
4. **Compila frecuentemente** - No esperes a terminar todo
5. **Prueba con datos pequenos** primero
6. **Refactoriza** si ves codigo repetido

### Antes de Mirar Soluciones:

- Intenta resolver el ejercicio completamente por ti mismo
- Si te atascas, relee el enunciado y las pistas
- Solo mira la solucion si llevas mas de 30 minutos atascado en el mismo punto
- Cuando veas una solucion, **entiende el POR QUE** de cada decision

---

## Patrones de Diseno - Referencia Rapida

### Strategy Pattern
**Cuando:** Necesitas cambiar algoritmos/comportamiento en tiempo de ejecucion
**Ejemplo:** Diferentes tarifas, modos de manejo, descuentos

### Visitor Pattern
**Cuando:** Necesitas realizar operaciones sobre jerarquia de clases sin modificarlas
**Ejemplo:** Calculos estadisticos, reportes, procesamiento de datos

### Singleton Pattern
**Cuando:** Solo debe existir una instancia de una clase
**Ejemplo:** Sistema centralizado, configuracion global

### Factory Pattern
**Cuando:** Crear objetos complejos sin exponer logica de creacion
**Ejemplo:** Crear menus, crear vehiculos segun tipo

---

## Conceptos Fundamentales

### Herencia
```java
public abstract class Padre {
    protected String atributo;

    public abstract void metodoAbstracto();

    public void metodoConcreto() {
        // Implementacion
    }
}

public class Hijo extends Padre {
    @Override
    public void metodoAbstracto() {
        // Implementacion especifica
    }
}
```

### Polimorfismo
```java
List<Vehiculo> flota = new ArrayList<>();
flota.add(new Auto(...));
flota.add(new SUV(...));
flota.add(new Camioneta(...));

// Todos se tratan como Vehiculo
for (Vehiculo v : flota) {
    v.mostrarInfo();  // Cada uno ejecuta su version
}
```

### File I/O Basico
```java
try (Scanner scanner = new Scanner(new File("archivo.txt"))) {
    String linea = scanner.nextLine();
    String[] datos = linea.split(",");
} catch (FileNotFoundException e) {
    System.out.println("Error: " + e.getMessage());
}
```

---

## Checklist de Progreso

Marca cada ejercicio cuando lo completes:

- [ ] Ejercicio 01 - Biblioteca Basica
- [ ] Ejercicio 02 - Tienda con Strategy
- [ ] Ejercicio 03 - Banco con Singleton
- [ ] Ejercicio 04 - Restaurante con Factory
- [ ] Ejercicio 05 - Lectura de Archivos
- [ ] Ejercicio 06 - Patron Visitor
- [ ] Ejercicio 07 - Flota de Taxis
- [ ] Ejercicio 08 - Rent a Car Simplificado
- [ ] Ejercicio 09 - Ruteo de Codigo GUI
- [ ] Ejercicio 10 - Rent a Car Completo (EXAMEN)
- [ ] **REPETIR Ejercicio 10 sin ayuda**

---

## Indicadores de que Estas Listo para el Examen

Estas listo cuando puedas:

1. **Implementar cualquier patron de memoria** sin consultar apuntes
2. **Leer y parsear archivos** estructurados sin errores
3. **Disenar arquitectura completa** en menos de 15 minutos
4. **Completar Ejercicio 10** en menos de 2.5 horas
5. **Trazar codigo complejo** y predecir su comportamiento
6. **Evitar ciclos anidados** naturalmente
7. **Explicar las decisiones** de diseno que tomas

---

## Consejos Finales

### En el Examen:
1. Lee TODO dos veces antes de programar
2. Planifica en papel (15-20 minutos)
3. Implementa por fases
4. Compila frecuentemente
5. Usa nombres descriptivos
6. Maneja excepciones
7. Evita ciclos anidados
8. Deja tiempo para pruebas (30 minutos)

### Al Estudiar:
1. Practica cada patron hasta dominarlo
2. Entiende el "por que", no solo el "como"
3. Resuelve problemas sin mirar soluciones
4. Repite ejercicios dificiles
5. Toma apuntes de errores comunes
6. Cronometrate para gestionar tiempo

---

## Contacto y Recursos

**Documentacion oficial:**
- Java Collections: https://docs.oracle.com/javase/tutorial/collections/
- File I/O: https://docs.oracle.com/javase/tutorial/essential/io/
- Swing GUI: https://docs.oracle.com/javase/tutorial/uiswing/

**Design Patterns:**
- Refactoring Guru: https://refactoring.guru/design-patterns

---

## Siguiente Paso

**Ahora que has leido esto:**

1. Abre `Ejercicio01_BibliotecaBasica.md`
2. Lee el enunciado completo DOS veces
3. Planifica tu solucion en papel
4. Implementa el ejercicio
5. Compila y prueba
6. Continua con el siguiente

**Mucha suerte en tu preparacion!**

---

**Recuerda:** El exito en POO viene de la practica constante y la comprension profunda de los conceptos, no de memorizar codigo.

**Practica, practica, practica.**
