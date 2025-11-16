# CHECKLIST PRE-EXAMEN - Revisión Final

**Objetivo:** Verificación completa antes del examen para asegurar que dominas todos los conceptos clave.

**Tiempo estimado:** 45-60 minutos

**Cuándo usarlo:**
- 2-3 horas antes del examen
- Como último repaso
- Para identificar puntos débiles de última hora

**Instrucciones:** Marca cada item SOLO si puedes hacerlo/explicarlo sin ayuda.

---

## PARTE 1: STRATEGY PATTERN (10 items)

### Conceptos Fundamentales
- [ ] Puedo explicar qué problema resuelve Strategy
- [ ] Puedo dibujar el diagrama UML de Strategy
- [ ] Sé cuándo usar Strategy vs if-else
- [ ] Conozco las ventajas de Strategy (al menos 3)

### Implementación
- [ ] Puedo crear una interface Strategy desde cero
- [ ] Puedo implementar 2+ estrategias concretas
- [ ] Puedo crear un Context que use Strategy
- [ ] Sé cómo cambiar estrategias en runtime

### Detalles Técnicos
- [ ] Sé validar que strategy no sea null
- [ ] Puedo pasar parámetros a las estrategias
- [ ] Entiendo cuándo usar interface vs abstract class
- [ ] Sé testear el patrón Strategy

**Si marcaste menos de 8:** Repasa GUIA_PATRON_STRATEGY.md

---

## PARTE 2: VISITOR PATTERN (10 items)

### Conceptos Fundamentales
- [ ] Puedo explicar qué es double dispatch
- [ ] Puedo dibujar el diagrama UML de Visitor
- [ ] Sé cuándo usar Visitor (estructura estable + operaciones variables)
- [ ] Conozco la desventaja principal (agregar elementos es costoso)

### Implementación
- [ ] Puedo crear interface Visitor con métodos visit()
- [ ] Puedo crear interface Element con método accept()
- [ ] Sé implementar accept() correctamente: `visitor.visit(this)`
- [ ] Puedo crear un ConcreteVisitor que procese elementos

### Detalles Técnicos
- [ ] Entiendo por qué accept() debe pasar `this`
- [ ] Puedo hacer que Visitor retorne valores
- [ ] Sé cómo dar estado a un Visitor (acumuladores)
- [ ] Puedo aplicar Visitor a una estructura tipo árbol

**Si marcaste menos de 8:** Repasa GUIA_PATRON_VISITOR.md

---

## PARTE 3: SINGLETON PATTERN (10 items)

### Conceptos Fundamentales
- [ ] Puedo listar las 3 características de Singleton
- [ ] Sé cuándo usar Singleton apropiadamente
- [ ] Conozco los problemas de Singleton (testing, global state)

### Implementación - Eager Initialization
- [ ] Puedo escribir Singleton con eager initialization
- [ ] Sé por qué eager es thread-safe automáticamente
- [ ] Entiendo cuándo usar eager vs lazy

### Implementación - Thread-Safe
- [ ] Sé hacer Singleton thread-safe con synchronized
- [ ] Conozco double-checked locking
- [ ] Sé por qué necesito `volatile` en double-checked locking
- [ ] Conozco Initialization-on-demand holder

### Casos Especiales
- [ ] Sé cómo hacer Singleton serializable (readResolve)
- [ ] Conozco cómo usar enum para Singleton

**Si marcaste menos de 7:** Repasa teoría de Singleton

---

## PARTE 4: FACTORY PATTERN (8 items)

### Conceptos Fundamentales
- [ ] Puedo explicar qué problema resuelve Factory
- [ ] Sé la diferencia entre Simple Factory y Factory Method
- [ ] Conozco Abstract Factory

### Implementación
- [ ] Puedo crear un método factory estático
- [ ] Sé validar entrada y lanzar excepciones apropiadas
- [ ] Puedo usar switch o if-else para crear objetos
- [ ] NO uso `==` para comparar Strings (uso equals)

### Mejores Prácticas
- [ ] Sé cuándo Factory debe lanzar excepción vs retornar null
- [ ] Puedo usar Map/Registry para factory extensible

**Si marcaste menos de 6:** Repasa ejemplos de Factory

---

## PARTE 5: FILE I/O (12 items)

### Lectura de Archivos
- [ ] Sé usar BufferedReader para leer archivos
- [ ] Puedo leer línea por línea con readLine()
- [ ] Entiendo el patrón: `while ((line = reader.readLine()) != null)`
- [ ] Sé especificar charset (StandardCharsets.UTF_8)

### Escritura de Archivos
- [ ] Sé usar BufferedWriter para escribir archivos
- [ ] Recuerdo usar newLine() después de cada línea
- [ ] Entiendo append mode vs overwrite mode

### Manejo de Recursos
- [ ] SIEMPRE uso try-with-resources
- [ ] Sé que los recursos se cierran automáticamente
- [ ] Puedo manejar IOException correctamente
- [ ] Sé lanzar vs catchear excepciones

### Casos Especiales
- [ ] Sé manejar FileNotFoundException
- [ ] Puedo validar si un archivo existe antes de leer
- [ ] Conozco Files.exists(), Files.createDirectories()

**Si marcaste menos de 9:** Repasa ejercicios de File I/O

---

## PARTE 6: COLLECTIONS & GENERICS (15 items)

### Generics Básicos
- [ ] Puedo crear clase genérica `class Box<T>`
- [ ] Sé usar bounded type parameters `<T extends Comparable<T>>`
- [ ] Entiendo NUNCA usar raw types
- [ ] Sé especificar tipos en constructores: `new ArrayList<>()`

### List
- [ ] Sé cuándo usar ArrayList vs LinkedList
- [ ] Puedo iterar con for-each y con índices
- [ ] Conozco List.of() para listas inmutables
- [ ] Sé usar add(), get(), remove(), size()

### Map
- [ ] Entiendo que Map usa key-value pairs
- [ ] Sé usar put(), get(), containsKey()
- [ ] Puedo iterar con entrySet() o keySet()
- [ ] Conozco getOrDefault()

### Set
- [ ] Sé que Set no permite duplicados
- [ ] Conozco add(), contains(), remove()

### Streams (Java 8+)
- [ ] Puedo usar filter(), map(), collect()
- [ ] Sé usar Collectors.toList()
- [ ] Conozco forEach() para iteración

**Si marcaste menos de 11:** Repasa ejercicios de Collections

---

## PARTE 7: EXCEPTION HANDLING (10 items)

### Conceptos
- [ ] Sé la diferencia entre checked y unchecked exceptions
- [ ] Entiendo cuándo usar try-catch vs throws
- [ ] Conozco finally y cuándo usarlo

### Crear Excepciones
- [ ] Puedo crear excepción personalizada extendiendo Exception
- [ ] Sé crear constructor que acepte mensaje
- [ ] Puedo lanzar excepción con throw new

### Manejo
- [ ] Sé capturar excepciones específicas primero, genéricas después
- [ ] Puedo usar multi-catch: `catch (IOException | SQLException e)`
- [ ] Sé re-lanzar excepciones cuando es apropiado

### Mejores Prácticas
- [ ] NO trago excepciones (catch vacío)
- [ ] Siempre incluyo mensaje descriptivo
- [ ] Prefiero try-with-resources sobre try-finally

**Si marcaste menos de 7:** Repasa manejo de excepciones

---

## PARTE 8: OOP FUNDAMENTALS (12 items)

### Interfaces
- [ ] Sé crear interface con métodos abstractos
- [ ] Puedo implementar interface con `implements`
- [ ] Entiendo que una clase puede implementar múltiples interfaces
- [ ] Sé usar default methods (Java 8+)

### Herencia
- [ ] Puedo extender clase con `extends`
- [ ] Sé usar `super()` para llamar constructor padre
- [ ] Entiendo `@Override` y cuándo usarlo
- [ ] Conozco la diferencia entre extends e implements

### Polimorfismo
- [ ] Entiendo: `Animal a = new Dog();`
- [ ] Sé que se llama al método de la clase real (Dog), no declarada (Animal)
- [ ] Puedo usar instanceof para verificar tipos
- [ ] Entiendo casting: `((Dog) a).dogSpecificMethod()`

### Encapsulación
- [ ] Sé usar private para campos
- [ ] Creo getters/setters apropiados
- [ ] Entiendo cuándo NO crear setter (inmutabilidad)

**Si marcaste menos de 9:** Repasa fundamentos OOP

---

## PARTE 9: CODING BEST PRACTICES (10 items)

### Nombres
- [ ] Uso camelCase para métodos/variables
- [ ] Uso PascalCase para clases/interfaces
- [ ] Uso UPPER_SNAKE_CASE para constantes
- [ ] Nombres son descriptivos y en inglés

### Validaciones
- [ ] Valido parámetros null
- [ ] Valido Strings vacíos
- [ ] Valido números negativos cuando no tienen sentido
- [ ] Lanzo IllegalArgumentException para parámetros inválidos

### Código Limpio
- [ ] Métodos pequeños con responsabilidad única
- [ ] NO tengo código duplicado
- [ ] Uso constantes en lugar de magic numbers
- [ ] Código es legible sin comentarios excesivos

**Si marcaste menos de 7:** Repasa principios de clean code

---

## PARTE 10: ERRORES FATALES A EVITAR (10 items)

### Comparaciones
- [ ] NUNCA uso `==` para comparar Strings (uso equals)
- [ ] NUNCA uso `=` en lugar de `==` en condiciones
- [ ] Pongo constante primero: `"valor".equals(variable)` para evitar NullPointer

### Recursos
- [ ] SIEMPRE uso try-with-resources para archivos
- [ ] NUNCA olvido newLine() al escribir archivos
- [ ] SIEMPRE especifico charset

### Patrones
- [ ] En Strategy: uso `this.field = param`, NO `field = field`
- [ ] En Visitor: accept() llama `visitor.visit(this)`, NO `visitor.visit()`
- [ ] En Singleton: constructor es PRIVADO

### Generics
- [ ] NUNCA uso raw types: `List list` → `List<String> list`
- [ ] Especifico tipo en constructor: `new ArrayList<>()` (diamond operator)

**Si marcaste menos de 8:** Revisa DEBUGGING_CHALLENGES.md

---

## VERIFICACIÓN PRÁCTICA RÁPIDA

### Ejercicio 1: Strategy en 5 minutos
Escribe de memoria (sin ver ejemplos):
- Interface con un método
- Dos clases que implementan
- Context que usa la interface

**¿Pudiste?** Si no, repasa Strategy AHORA.

### Ejercicio 2: Visitor en 5 minutos
Escribe de memoria:
- Interface Visitor con visit(ElementA), visit(ElementB)
- Interface Element con accept(Visitor)
- Implementación de accept() en ElementA

**¿Pudiste?** Si no, repasa Visitor AHORA.

### Ejercicio 3: File I/O en 3 minutos
Escribe de memoria:
- Código para leer todas las líneas de un archivo

**¿Pudiste?** Si no, repasa File I/O AHORA.

---

## SCORECARD FINAL

**Cuenta tus checkmarks:**

- 97-107 (90%+): Excelente preparación
- 86-96 (80-89%): Buena preparación, repasa débiles
- 75-85 (70-79%): Preparación aceptable, REPASA URGENTE
- <75 (<70%): ALERTA - repasa todo el material

**Áreas con <70% de checks:** Estas son tus DEBILIDADES. Enfócate aquí las próximas horas.

---

## PLAN DE ACCIÓN SEGÚN RESULTADO

### Si tienes >3 horas antes del examen:
1. Identifica tus 2 secciones más débiles
2. Repasa las guías correspondientes (30 min c/u)
3. Haz ejercicios relacionados (30 min c/u)
4. Vuelve a hacer este checklist
5. Descansa 15 min antes del examen

### Si tienes 1-3 horas:
1. Identifica tu sección MÁS débil
2. Repasa la guía (20 min)
3. Haz 1-2 mini-challenges (20 min)
4. Repasa flashcards de esa sección (10 min)
5. Lee ERRORES_FATALES_EXAMEN.md (10 min)

### Si tienes <1 hora:
1. Lee ERRORES_FATALES_EXAMEN.md (5 min)
2. Repasa flashcards de tu sección más débil (15 min)
3. Lee CHEAT_SHEET_PATRONES.md (10 min)
4. Respira y confía en tu preparación

---

## RECORDATORIOS FINALES

**Antes de empezar el examen:**
- Lee TODO el enunciado antes de escribir código
- Identifica qué patrón(es) pide
- Planea la estructura antes de codificar
- Deja tiempo para revisar

**Durante el examen:**
- Compila mentalmente cada línea
- Valida null SIEMPRE
- Usa try-with-resources para archivos
- Revisa `==` vs `equals`
- Verifica que accept() pase `this`
- Confirma que Singleton tiene constructor privado

**En los últimos 10 minutos:**
- Busca `==` en lugar de `equals` para Strings
- Busca `=` en lugar de `==` en if
- Verifica imports necesarios
- Confirma que todos los recursos se cierran

**Confía en tu preparación. Has trabajado duro. Lo harás excelente.**
