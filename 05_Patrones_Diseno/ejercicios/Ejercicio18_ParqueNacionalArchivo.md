# Ejercicio 18: Parque Nacional con Lectura de Archivo (Nivel 3)
**Dificultad:** Avanzado
**Tiempo estimado:** 100 minutos
**Conceptos:** File I/O, Visitor Pattern, Herencia, Parsing, Collections

---

## Contexto

Un parque nacional registra datos de fauna en un archivo estructurado. Debes leer el archivo, crear los objetos correspondientes y calcular estadisticas usando el Patron Visitor.

Este ejercicio esta inspirado en los archivos **fauna.txt** del material oficial.

---

## Formato del Archivo: fauna.txt

```
N
ID,Especie,Peso,Altura,Velocidad,Zona,AtributoEspecifico
ID,Especie,Peso,Altura,Velocidad,Zona,AtributoEspecifico
...
ID,Especie,Peso,Altura,Velocidad,Zona,AtributoEspecifico
```

### Estructura:
- **Linea 1:** Cantidad total de animales (N)
- **Lineas 2 a N+1:** Datos de cada animal separados por comas

### Campos:
- **ID:** Codigo unico (String) en formato MAC: "A1-B2-C3-D4-E5-F6"
- **Especie:** Nombre de la especie (String)
- **Peso:** En kg (int)
- **Altura:** En metros (double)
- **Velocidad:** En km/h (int)
- **Zona:** "Norte" o "Sur" (String)
- **AtributoEspecifico:** Depende de la especie

### Especies y AtributoEspecifico:

**Brachiosaurus (herbivoro):**
- AtributoEspecifico: Toneladas de vegetacion consumida por dia (double)

**Tiranosaurio (carnivoro):**
- AtributoEspecifico: Numero de presas cazadas por semana (int)

**Triceratops (herbivoro):**
- AtributoEspecifico: Tipo de planta preferida (String): "Helechos" o "Cicadaceas"

**Velociraptor (carnivoro):**
- AtributoEspecifico: Calorias consumidas por dia (int)

### Ejemplo de fauna.txt:
```
5
A1-B2-C3-D4-E5-01,Brachiosaurus,65000,25.5,35,Norte,20.5
A1-B2-C3-D4-E5-02,Tiranosaurio,7000,5.5,40,Sur,5
A1-B2-C3-D4-E5-03,Triceratops,9000,3.0,25,Norte,Helechos
A1-B2-C3-D4-E5-04,Velociraptor,25,1.8,65,Sur,45000
A1-B2-C3-D4-E5-05,Brachiosaurus,70000,27.0,32,Sur,22.0
```

---

## Requisitos

### Jerarquia de Animales:

**Clase abstracta Animal:**
- id, especie, peso, altura, velocidad, zona

**Subclases concretas:**
- Brachiosaurus (herbivoro)
- Tiranosaurio (carnivoro)
- Triceratops (herbivoro)
- Velociraptor (carnivoro)

Todos implementan: `double accept(IVisitorAnimal visitor)`

---

## Patron Visitor - Calculos Requeridos:

### 1. VisitorContadorZona:
- Cuenta animales por zona (Norte vs Sur)
- Cuenta animales por especie
- Muestra distribucion

### 2. VisitorExtremos:
- Encuentra el animal mas pesado
- Encuentra el animal mas alto
- Encuentra el animal mas rapido

### 3. VisitorAdaptacion:
- Calcula indice de adaptacion por especie
- Brachiosaurus: (vegetacion × peso / 10000)
- Tiranosaurio: (presas × velocidad / 10)
- Triceratops: 100 si prefiere Helechos, 80 si Cicadaceas
- Velociraptor: (calorias / peso)
- El animal con MAYOR indice es el mejor adaptado

---

## Ejemplo de Ejecucion

```
=== PARQUE NACIONAL - SISTEMA DE FAUNA ===

Leyendo archivo: fauna.txt...
[OK] Archivo leido: 5 animales cargados

=== CONTEO POR ZONA (VisitorContadorZona) ===

En el hemisferio Norte hay:
Brachiosaurus: 1
Tiranosaurio: 0
Triceratops: 1
Velociraptor: 0
TOTAL NORTE: 2 animales

En el hemisferio Sur hay:
Brachiosaurus: 1
Tiranosaurio: 1
Triceratops: 0
Velociraptor: 1
TOTAL SUR: 3 animales

=== EXTREMOS (VisitorExtremos) ===

El mas pesado es: A1-B2-C3-D4-E5-05 (Brachiosaurus, 70000 kg)
El mas alto es: A1-B2-C3-D4-E5-05 (Brachiosaurus, 27.0 m)
El mas rapido es: A1-B2-C3-D4-E5-04 (Velociraptor, 65 km/h)

=== ADAPTACION (VisitorAdaptacion) ===

Indices de adaptacion:
A1-B2-C3-D4-E5-01 (Brachiosaurus): 133.25
A1-B2-C3-D4-E5-02 (Tiranosaurio): 20.0
A1-B2-C3-D4-E5-03 (Triceratops): 100.0
A1-B2-C3-D4-E5-04 (Velociraptor): 1800.0
A1-B2-C3-D4-E5-05 (Brachiosaurus): 154.0

El animal mejor adaptado es:
A1-B2-C3-D4-E5-04 - Velociraptor (indice: 1800.0)

=== ESTADISTICAS GENERALES ===
Total animales: 5
Peso promedio: 30205.0 kg
Altura promedio: 12.56 m
Velocidad promedia: 39.4 km/h
Distribucion Norte/Sur: 40% / 60%
```

---

## Debe entregar:

1. **Clase abstracta Animal** con:
   - Atributos comunes
   - Constructor
   - Metodo abstracto: `double accept(IVisitorAnimal visitor)`
   - Getters necesarios

2. **4 clases concretas de animales** con sus atributos especificos

3. **Interface IVisitorAnimal** con 4 metodos visit()

4. **3 clases Visitor:**
   - VisitorContadorZona
   - VisitorExtremos
   - VisitorAdaptacion

5. **Clase ParqueNacional** que:
   - Lea el archivo fauna.txt
   - Cree los objetos Animal correspondientes segun especie
   - Almacene en lista
   - Aplique los 3 visitors
   - Muestre resultados

6. **Clase Main** que ejecute todo

7. **Archivo fauna.txt** con al menos 10 animales de prueba

---

## Consideraciones:

- DEBE leer archivo correctamente con Scanner
- Parsear cada linea con split(",")
- Crear el objeto correcto segun campo "Especie"
- Manejar excepciones (FileNotFoundException, NumberFormatException)
- Los visitors deben acumular resultados
- Usar double dispatch en accept()
- Validar que el archivo existe antes de leer

---

## Pistas:

1. Lectura del archivo:
   ```java
   Scanner sc = new Scanner(new File("fauna.txt"));
   int n = Integer.parseInt(sc.nextLine());
   for (int i = 0; i < n; i++) {
       String linea = sc.nextLine();
       String[] datos = linea.split(",");
       // Crear animal segun datos[1] (especie)
   }
   ```

2. Creacion segun especie:
   ```java
   Animal animal;
   switch(datos[1]) {
       case "Brachiosaurus":
           animal = new Brachiosaurus(...);
           break;
       // ...
   }
   ```

3. Para visitor de extremos, necesitas variables para acumular maximo
4. Para conteo, usa HashMap<String, Integer> o variables individuales

---

## Desafio Extra (Opcional):

1. Agrega validacion del formato del ID (XX-XX-XX-XX-XX-XX)
2. Implementa un 4to visitor: VisitorExportador que genere reporte en archivo
3. Agrega filtrado: mostrar solo animales de una zona especifica
4. Implementa busqueda por ID

---

**NOTA:** Este es un ejercicio AVANZADO de practica independiente. NO hay solucion.
Si te atascas:
- Revisa Ejercicio 5 (File I/O basico)
- Revisa Ejercicio 6 y 7 (Visitor)
- Revisa Ejercicio 10 (lectura de archivo con formato variable)
- Analiza fauna.txt del material oficial
