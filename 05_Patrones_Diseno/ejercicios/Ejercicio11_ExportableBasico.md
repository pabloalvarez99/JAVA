# Ejercicio 11: Sistema Exportable - Objetos a Multiples Formatos (Nivel 1)
**Dificultad:** Basico
**Tiempo estimado:** 45 minutos
**Conceptos:** Interfaces, File I/O, Exportacion CSV/TXT/JSON, Polimorfismo

---

## Contexto

Necesitas crear un sistema que permita a diferentes tipos de objetos exportar su informacion en multiples formatos: CSV, TXT y JSON. Ademas, todos deben poder agregar su informacion a un archivo comun.

Este ejercicio esta basado en el **Ejercicio_Interfaces_POO.pdf** del material oficial del curso.

---

## Requisitos

### Parte 1: Crear 4 clases a gusto

Debes crear 4 clases diferentes (ejemplos: Persona, Auto, Producto, Mascota). Cada clase debe:
- Tener 2 o mas atributos
- Tener un metodo especifico propio (distintos entre si)

Ejemplos:
- `Persona`: nombre, edad → metodo: `hablar()`
- `Auto`: marca, patente → metodo: `acelerar(int velocidad)`
- `Producto`: nombre, precio → metodo: `aplicarDescuento(double porcentaje)`
- `Mascota`: nombre, tipo → metodo: `hacerSonido()`

### Parte 2: Interface Exportable

Todas las clases deben implementar una interface `Exportable` que tenga:

```java
public interface Exportable {
    void exportCSV();
    void exportTXT();
    void exportJSON();
    void append(String nombreArchivo);
}
```

### Comportamiento de cada metodo:

**exportCSV():**
- Genera un archivo `.csv` con el nombre del objeto
- Primera linea: nombres de atributos separados por comas
- Segunda linea: valores separados por comas

**exportTXT():**
- Genera un archivo `.txt` con el nombre del objeto
- Cada linea: `atributo,valor`

**exportJSON():**
- Genera un archivo `.json` con el nombre del objeto
- Formato: `{"atributo1":"valor1", "atributo2":"valor2"}`

**append(String nombreArchivo):**
- Agrega la informacion del objeto al FINAL del archivo especificado
- Formato: todos los atributos y valores separados por comas en una linea

---

## Ejemplo de Ejecucion

```java
Persona p = new Persona("Pepe", 20);
Auto a = new Auto("Suzuki", "FL-666");

p.exportCSV();   // Crea pepe.csv
p.exportTXT();   // Crea pepe.txt
p.exportJSON();  // Crea pepe.json

a.exportCSV();   // Crea suzuki.csv
a.exportTXT();   // Crea suzuki.txt
a.exportJSON();  // Crea suzuki.json

a.append("datos.txt");
p.append("datos.txt");
```

### Contenido de pepe.csv:
```
nombre,edad
Pepe,20
```

### Contenido de pepe.txt:
```
nombre,Pepe
edad,20
```

### Contenido de pepe.json:
```json
{"nombre":"Pepe", "edad": 20}
```

### Contenido de datos.txt:
```
marca,Suzuki,patente,FL-666
nombre,Pepe,edad,20
```

---

## Debe entregar:

1. **Interface Exportable** con los 4 metodos
2. **4 clases concretas** que implementen Exportable:
   - Cada una con al menos 2 atributos
   - Cada una con un metodo especifico propio
   - Implementacion completa de los 4 metodos de exportacion
3. **Clase Main** que demuestre:
   - Creacion de al menos 2 objetos de cada tipo (8 objetos total)
   - Exportacion a CSV, TXT, JSON de varios objetos
   - Uso de append() para crear archivo comun
   - Iteracion sobre un array de objetos Exportable

---

## Consideraciones:

- Usa `FileWriter` o `PrintWriter` para escribir archivos
- Para append, usa `FileWriter(nombreArchivo, true)` (el `true` activa modo append)
- Usa nombres de archivo basados en algun atributo del objeto (ej: nombre.csv)
- Maneja excepciones con try-catch
- TODOS los metodos deben estar implementados en TODAS las clases
- El formato de salida debe ser EXACTO como en los ejemplos

---

## Pistas:

1. Para CSV: usa `\n` para nueva linea y `,` para separar valores
2. Para JSON: presta atencion a las comillas y espacios
3. Para append: usa `FileWriter` con segundo parametro `true`
4. Puedes crear un metodo privado auxiliar para obtener el nombre base del archivo
5. Usa polimorfismo: `Exportable[] objetos = new Exportable[]{p1, a1, pr1, m1}`

---

## Desafio Extra (Opcional):

1. Crea un metodo en Main que reciba un array de Exportable y exporte todos a CSV
2. Agrega validacion: no sobreescribir archivos existentes (preguntar al usuario)
3. Implementa un metodo `exportAll()` que exporte a los 3 formatos de una vez

---

**NOTA:** Este es un ejercicio de PRACTICA INDEPENDIENTE. NO hay solucion incluida.
Debes resolverlo por tu cuenta. Si te atascas, revisa:
- Ejercicio 5 (File I/O basico)
- Conceptos de interfaces en Ejercicio 1-4
- Material oficial: Ejercicio_Interfaces_POO.pdf
