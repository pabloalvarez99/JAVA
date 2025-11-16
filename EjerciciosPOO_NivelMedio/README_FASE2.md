# FASE 2: Ejercicios de Practica Independiente (11-20)

## Bienvenido a la Fase 2

Has completado los ejercicios 01-10 con tutoriales completos. Ahora es momento de **practicar de forma independiente**.

Los ejercicios 11-20 **NO incluyen soluciones**. Son para que demuestres que has aprendido los conceptos y puedas aplicarlos por tu cuenta.

---

## Estructura de la Fase 2

### Ejercicios Basicos (11-13)
Practican conceptos individuales de forma mas simple:
- **Ejercicio 11:** Interface Exportable (CSV/TXT/JSON)
- **Ejercicio 12:** Strategy basico (Descuentos en tienda)
- **Ejercicio 13:** Visitor basico (Estadisticas de zoologico)

**Tiempo estimado:** 45-55 minutos cada uno
**Dificultad:** Similar a ejercicios 1-4

### Ejercicios Intermedios (14-16)
Combinan multiples conceptos:
- **Ejercicio 14:** Restaurante Multi-Cocina (Strategy + Visitor) - **Del material oficial**
- **Ejercicio 15:** Sistema Empleados (Singleton + Herencia)
- **Ejercicio 16:** Factory de Productos (Factory + Validaciones)

**Tiempo estimado:** 65-90 minutos cada uno
**Dificultad:** Similar a ejercicios 5-7

### Ejercicios Avanzados (17-19)
Proyectos completos con multiples patrones:
- **Ejercicio 17:** Sistema Hospitalario (Singleton + Strategy + Visitor)
- **Ejercicio 18:** Parque Nacional con Archivo (File I/O + Visitor) - **Del material oficial**
- **Ejercicio 19:** Sistema Universitario con GUI (Singleton + Strategy + Swing)

**Tiempo estimado:** 100-120 minutos cada uno
**Dificultad:** Similar a ejercicios 8-10

### Ejercicio Final (20)
Simulacro completo de examen:
- **Ejercicio 20:** SIMULACRO EXAMEN (Todos los conceptos)

**Tiempo estimado:** 3 horas (limite de examen)
**Dificultad:** Nivel examen real

---

## Como Usar Esta Fase

### 1. Secuencia Recomendada

**Opcion A: Secuencial (Recomendado para principiantes)**
- Haz los ejercicios en orden: 11, 12, 13, 14, ...
- No avances al siguiente hasta dominar el actual
- Tiempo total estimado: 2-3 semanas

**Opcion B: Por Concepto (Recomendado para repaso)**
- Primero todos los de Strategy: 12, 14, 17, 19
- Luego todos los de Visitor: 13, 14, 17, 18
- Luego File I/O: 18, 20
- Luego GUI: 19
- Finalmente el simulacro: 20

**Opcion C: Pre-Examen (Ultima semana)**
- Ejercicios 14 y 18 (material oficial)
- Ejercicio 17 (combinacion completa)
- Ejercicio 20 (simulacro) - **Hacerlo 2-3 veces**

### 2. Metodologia de Trabajo

Para cada ejercicio:

1. **Leer completamente** el enunciado DOS veces
2. **Planificar** la estructura de clases en papel
3. **Identificar** que patrones se requieren
4. **Programar** paso a paso, compilando frecuentemente
5. **Probar** con datos de prueba
6. **Revisar** tu codigo:
   - Compila sin errores?
   - Funciona correctamente?
   - Usa los patrones requeridos?
   - Codigo es legible?

### 3. Cuando te Atasques

Si llevas mas de 30 minutos atascado en algo:

1. **Lee los ejercicios 01-10** relacionados (estan en las pistas)
2. **Consulta GUIA_ESTUDIO.md** para repasar conceptos
3. **Consulta REFERENCIA_RAPIDA.md** para templates de codigo
4. **Revisa el material oficial** en C:\Users\Pablo\Downloads\materialPOO
5. **Descansa 10 minutos** y vuelve con mente fresca

**NO busques soluciones en internet.** El objetivo es que TU resuelvas los problemas.

### 4. Auto-Evaluacion

Despues de cada ejercicio, preguntate:

- [ ] Implemente todos los patrones requeridos?
- [ ] Use herencia y polimorfismo correctamente?
- [ ] El codigo compila sin errores?
- [ ] El programa funciona como se espera?
- [ ] Use nombres descriptivos?
- [ ] Maneje excepciones apropiadamente?
- [ ] Evite ciclos anidados?
- [ ] El codigo es legible y mantenible?

Si respondes "No" a mas de 2 preguntas, repite el ejercicio.

---

## Archivos de Datos

Los ejercicios que requieren archivos tienen datos de prueba en:
```
datos/fauna.txt              (Ejercicio 18)
datos/fleet_transport.txt    (Ejercicio 20)
```

Para otros ejercicios, DEBES crear tus propios archivos de datos segun las especificaciones.

---

## Cronograma Sugerido (4 semanas)

### Semana 1: Basicos
- Lunes: Ejercicio 11 (Exportable)
- Miercoles: Ejercicio 12 (Strategy)
- Viernes: Ejercicio 13 (Visitor)
- Sabado/Domingo: Repasar conceptos debiles

### Semana 2: Intermedios
- Lunes: Ejercicio 14 (Restaurante - Material Oficial)
- Miercoles: Ejercicio 15 (Singleton Empleados)
- Viernes: Ejercicio 16 (Factory)
- Sabado/Domingo: Repetir ejercicios con errores

### Semana 3: Avanzados
- Lunes-Martes: Ejercicio 17 (Hospital completo)
- Miercoles-Jueves: Ejercicio 18 (Fauna con archivo)
- Viernes-Sabado: Ejercicio 19 (Universidad con GUI)
- Domingo: Descanso y repaso

### Semana 4: Simulacro Final
- Lunes: Ejercicio 20 (intento 1) - anotar tiempo y puntaje
- Martes: Revisar errores del intento 1
- Miercoles: Ejercicio 20 (intento 2) - mejorar tiempo
- Jueves: Ejercicio 20 (intento 3) - objetivo: <3 horas, >60%
- Viernes: Repasar GUIA_ESTUDIO.md completa
- Sabado: Repasar conceptos debiles
- Domingo: Descanso antes del examen

---

## Objetivos de Aprendizaje

Al completar la Fase 2, deberas ser capaz de:

### Patrones de Diseno
- [ ] Implementar Strategy Pattern desde cero sin ayuda
- [ ] Implementar Visitor Pattern desde cero sin ayuda
- [ ] Implementar Singleton correctamente
- [ ] Implementar Factory basica
- [ ] Combinar multiples patrones en un proyecto

### Programacion OOP
- [ ] Disenar jerarquias de clases efectivas
- [ ] Usar herencia y polimorfismo correctamente
- [ ] Trabajar con listas heterogeneas (List<ClaseBase>)
- [ ] Aplicar principios de encapsulamiento

### File I/O y Parsing
- [ ] Leer archivos estructurados con Scanner
- [ ] Parsear datos con split()
- [ ] Manejar formatos variables
- [ ] Escribir archivos (CSV, TXT, JSON)

### Collections y Estructuras de Datos
- [ ] Usar ArrayList efectivamente
- [ ] Usar HashMap para busquedas rapidas
- [ ] Iterar y filtrar colecciones
- [ ] Ordenar y buscar datos

### Desarrollo Completo
- [ ] Resolver problemas complejos paso a paso
- [ ] Gestionar tiempo efectivamente (3 horas limite)
- [ ] Depurar codigo sistematicamente
- [ ] Escribir codigo limpio y mantenible

---

## Consejos Finales

1. **No te rindas** - Estos ejercicios son desafiantes intencionalmente
2. **Aprende de los errores** - Cada bug es una leccion
3. **Practica, practica, practica** - Repetir ejercicios mejora la velocidad
4. **Gestiona el tiempo** - En el examen real, 3 horas pasan rapido
5. **Lee bien** - Muchos errores vienen de no leer completamente el enunciado
6. **Compila frecuentemente** - No esperes al final para compilar
7. **Comenta tu codigo** - Ayuda a ti y al revisor
8. **Usa nombres descriptivos** - `vehiculo` es mejor que `v`
9. **Maneja excepciones** - Siempre usa try-catch para File I/O
10. **Confía en ti** - Ya tienes los conocimientos, solo falta practica

---

## Material de Apoyo

### Dentro de este repositorio:
- **GUIA_ESTUDIO.md** - Conceptos detallados con ejemplos
- **REFERENCIA_RAPIDA.md** - Templates y formulas
- **Ejercicios 01-10** - Tutoriales completos (para consultar)
- **datos/** - Archivos de datos de prueba

### Material oficial del curso:
- **C:\Users\Pablo\Downloads\materialPOO/**
  - Ejercicio Patrones.pdf (Restaurante)
  - Ejercicio_Interfaces_POO.pdf (Exportable)
  - Prueba 2 - POO (1).pdf (Examen real)
  - Ejercicio Visitor-20251115/ (Fauna)
  - ejemplo sistema/ (Arquitectura)

---

## Cuando Estes Listo para el Examen

Sabras que estas listo cuando:
- [ ] Puedas completar Ejercicio 20 en menos de 3 horas
- [ ] Obtengas mas de 60% en el simulacro
- [ ] Puedas explicar cuando usar cada patron
- [ ] Puedas implementar Strategy y Visitor sin consultar
- [ ] Puedas leer y parsear archivos estructurados
- [ ] Te sientas confiado con herencia y polimorfismo

---

**Recuerda: El examen es dificil pero TU PUEDES APROBAR.**

**La clave es PRACTICA CONSTANTE y GESTION DEL TIEMPO.**

**MUCHA SUERTE EN TU PREPARACION!**

---

*Creado para preparacion de Prueba 2 - Programacion Orientada a Objetos*
*Sistema de Aprendizaje Dual: Fase 1 (Tutoriales) + Fase 2 (Practica)*
