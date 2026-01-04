# Ejercicio 22: Sistema de Gestion de Museo

**Nivel**: Avanzado
**Tiempo estimado**: 90-120 minutos
**Patrones**: Visitor + Strategy + Factory
**Archivo**: `museo.txt`

---

## DESCRIPCION

Un museo necesita un sistema para gestionar su coleccion de obras de arte y calcular diferentes metricas. El museo tiene tres tipos de obras:

1. **Pinturas**: Tienen autor, anio, dimensiones (alto x ancho en cm)
2. **Esculturas**: Tienen autor, anio, material, peso (kg)
3. **Fotografias**: Tienen autor, anio, tecnica, resolucion (megapixeles)

---

## FUNCIONALIDADES REQUERIDAS

### 1. Calcular Valor de Seguro (Visitor)

Cada tipo de obra tiene una formula diferente para calcular su valor de seguro:

**Pinturas**:
```
Valor base: $1,000,000
+ $50,000 por cada anio de antiguedad (2024 - anio)
+ $100 por cada cm^2 de superficie (alto * ancho)
```

**Esculturas**:
```
Valor base: $2,000,000
+ $75,000 por cada anio de antiguedad
+ Multiplicador por material:
  - Bronce: x1.5
  - Marmol: x2.0
  - Madera: x1.0
```

**Fotografias**:
```
Valor base: $500,000
+ $30,000 por cada anio de antiguedad
+ $50,000 por cada megapixel de resolucion
```

### 2. Estrategia de Exhibicion (Strategy)

El museo puede exhibir las obras de tres formas diferentes:

**Cronologica**: Ordena por anio (mas antiguo primero)

**Por Valor**: Ordena por valor de seguro (mas valioso primero)

**Por Autor**: Ordena alfabeticamente por autor

### 3. Factory para Crear Obras

Usar Factory para crear las obras segun su tipo.

---

## FORMATO DEL ARCHIVO

El archivo `museo.txt` tiene la siguiente estructura:

```
N
Tipo,Autor,Anio,Dato1,Dato2[,Dato3]
...
```

**Pinturas**: `P,Autor,Anio,Alto,Ancho`
**Esculturas**: `E,Autor,Anio,Material,Peso`
**Fotografias**: `F,Autor,Anio,Tecnica,Resolucion`

### Ejemplo `museo.txt`

```
6
P,Leonardo da Vinci,1503,77,53
E,Miguel Angel,1504,Marmol,6000
F,Ansel Adams,1941,Blanco y Negro,12
P,Vincent van Gogh,1889,73,92
E,Auguste Rodin,1902,Bronce,180
F,Diane Arbus,1967,Color,8
```

---

## REQUERIMIENTOS TECNICOS

### Arquitectura

```
ISistemaMuseo (interface)
  └─> SistemaMuseoImpl

IObra (interface o abstract class)
  ├─> Pintura
  ├─> Escultura
  └─> Fotografia

IVisitorObra
  └─> VisitorValorSeguro

IEstrategiaExhibicion
  ├─> ExhibicionCronologica
  ├─> ExhibicionPorValor
  └─> ExhibicionPorAutor

ObraFactory (metodo estatico)
```

### Metodos Requeridos

**ISistemaMuseo**:
```java
void registrarObra(String[] datos);
void setEstrategiaExhibicion(IEstrategiaExhibicion estrategia);
List<IObra> obtenerExhibicion();
double calcularValorTotalSeguro();
```

**IObra**:
```java
String getAutor();
int getAnio();
void accept(IVisitorObra visitor);
String toString();
```

**IVisitorObra**:
```java
void visit(Pintura p);
void visit(Escultura e);
void visit(Fotografia f);
```

---

## EJEMPLO DE EJECUCION

```
=== MUSEO - SISTEMA DE GESTION ===

Obras registradas: 6

--- Exhibicion Cronologica ---
1. "Gioconda" - Leonardo da Vinci (1503) - Pintura
2. "David" - Miguel Angel (1504) - Escultura
3. "Noche estrellada" - Vincent van Gogh (1889) - Pintura
4. "El Pensador" - Auguste Rodin (1902) - Escultura
5. "Moonrise" - Ansel Adams (1941) - Fotografia
6. "Identical Twins" - Diane Arbus (1967) - Fotografia

--- Exhibicion Por Valor ---
1. "David" - Miguel Angel (1504) - Escultura - $82,000,000
2. "El Pensador" - Auguste Rodin (1902) - Escultura - $16,575,000
3. "Gioconda" - Leonardo da Vinci (1503) - Pintura - $27,258,100
4. "Noche estrellada" - Vincent van Gogh (1889) - Pintura - $14,501,600
5. "Moonrise" - Ansel Adams (1941) - Fotografia - $3,690,000
6. "Identical Twins" - Diane Arbus (1967) - Fotografia - $2,610,000

--- Exhibicion Por Autor ---
1. "Moonrise" - Ansel Adams (1941) - Fotografia
2. "El Pensador" - Auguste Rodin (1902) - Escultura
3. "Identical Twins" - Diane Arbus (1967) - Fotografia
4. "Gioconda" - Leonardo da Vinci (1503) - Pintura
5. "David" - Miguel Angel (1504) - Escultura
6. "Noche estrellada" - Vincent van Gogh (1889) - Pintura

Valor total del seguro: $146,634,700
```

---

## PASOS SUGERIDOS

### Paso 1: Crear Jerarquia de Obras (20 min)

1. Interface/clase abstracta `IObra`
2. Clases `Pintura`, `Escultura`, `Fotografia`
3. Implementar `accept(IVisitorObra visitor)`

### Paso 2: Implementar Visitor (25 min)

1. Interface `IVisitorObra`
2. Clase `VisitorValorSeguro`
3. Implementar formulas de calculo

### Paso 3: Implementar Strategy (20 min)

1. Interface `IEstrategiaExhibicion`
2. Tres clases de estrategias
3. Implementar ordenamiento (usar `Collections.sort()` con `Comparator`)

### Paso 4: Implementar Factory (10 min)

1. Clase `ObraFactory`
2. Metodo `crearObra(String[] datos)`

### Paso 5: Implementar Sistema (20 min)

1. Interface `ISistemaMuseo`
2. Clase `SistemaMuseoImpl`
3. Metodos de registro y consulta

### Paso 6: Main y Lectura de Archivo (15 min)

1. Leer archivo
2. Demostrar las 3 estrategias
3. Aplicar visitor
4. Mostrar resultados

---

## CONSEJOS

### Para el Visitor

```java
public class VisitorValorSeguro implements IVisitorObra {
    private double valorTotal = 0;

    @Override
    public void visit(Pintura p) {
        int antiguedad = 2024 - p.getAnio();
        double superficie = p.getAlto() * p.getAncho();
        double valor = 1_000_000 + (antiguedad * 50_000) + (superficie * 100);
        valorTotal += valor;
    }

    // ... otros visit()

    public double getValorTotal() {
        return valorTotal;
    }
}
```

### Para Strategy con Comparator

```java
public class ExhibicionCronologica implements IEstrategiaExhibicion {
    @Override
    public List<IObra> ordenar(List<IObra> obras) {
        List<IObra> copia = new ArrayList<>(obras);
        Collections.sort(copia, new Comparator<IObra>() {
            public int compare(IObra o1, IObra o2) {
                return Integer.compare(o1.getAnio(), o2.getAnio());
            }
        });
        return copia;
    }
}
```

O con lambda (Java 8+):

```java
Collections.sort(copia, (o1, o2) -> Integer.compare(o1.getAnio(), o2.getAnio()));
```

### Para Factory

```java
public class ObraFactory {
    public static IObra crearObra(String[] datos) {
        String tipo = datos[0];
        switch (tipo) {
            case "P":
                return new Pintura(datos[1], Integer.parseInt(datos[2]),
                                   Double.parseDouble(datos[3]),
                                   Double.parseDouble(datos[4]));
            case "E":
                return new Escultura(datos[1], Integer.parseInt(datos[2]),
                                     datos[3], Double.parseDouble(datos[4]));
            case "F":
                return new Fotografia(datos[1], Integer.parseInt(datos[2]),
                                      datos[3], Double.parseDouble(datos[4]));
            default:
                throw new IllegalArgumentException("Tipo desconocido: " + tipo);
        }
    }
}
```

---

## BONUS (Opcional)

### Bonus 1: Visitor Adicional

Implementa `VisitorTiempoRestauracion` que calcula el tiempo estimado de restauracion:

- **Pinturas**: 2 horas por cada 100 cm^2
- **Esculturas**: 5 horas por cada 100 kg
- **Fotografias**: 1 hora por cada megapixel

### Bonus 2: Estrategia Adicional

Implementa `ExhibicionPorTipo` que agrupa primero Pinturas, luego Esculturas, luego Fotografias.

### Bonus 3: GUI

Crea una interfaz grafica que muestre:
- Lista de obras
- Botones para cambiar estrategia
- Boton para calcular valor de seguro

---

## ARCHIVO DE DATOS

Crea el archivo `museo.txt`:

```
10
P,Leonardo da Vinci,1503,77,53
E,Miguel Angel,1504,Marmol,6000
F,Ansel Adams,1941,Blanco y Negro,12
P,Vincent van Gogh,1889,73,92
E,Auguste Rodin,1902,Bronce,180
F,Diane Arbus,1967,Color,8
P,Pablo Picasso,1937,349,776
E,Donatello,1440,Bronce,95
F,Henri Cartier-Bresson,1932,Blanco y Negro,6
P,Frida Kahlo,1939,40,56
```

---

## RUBRICA DE EVALUACION

| Criterio | Puntaje |
|----------|---------|
| Jerarquia de clases correcta | 15% |
| Patron Visitor implementado | 25% |
| Patron Strategy implementado | 20% |
| Patron Factory implementado | 10% |
| Sistema con interface | 10% |
| Lectura de archivo | 10% |
| Calculos correctos | 10% |
| **TOTAL** | **100%** |

---

## SOLUCION

**NO mires la solucion hasta haber intentado el ejercicio!**

La solucion se encuentra en: `Ejercicio22_SistemaMuseo_SOLUCION.md`

---

**Tiempo estimado**: 90-120 minutos
**Dificultad**: Alta - Combina 3 patrones
**Siguiente**: Ejercicio23_CentroMedicoVisitor.md
