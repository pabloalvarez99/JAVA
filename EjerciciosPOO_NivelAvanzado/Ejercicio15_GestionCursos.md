# Ejercicio 15: Gestion de Cursos Universitarios (PRACTICA INDEPENDIENTE)
**Dificultad:** Media
**Tiempo estimado:** 80 minutos
**Conceptos:** Visitor Pattern, Herencia, Collections
**Fase:** 2 (SIN SOLUCIONES - PRACTICA INDEPENDIENTE)

---

## IMPORTANTE

**Este ejercicio NO incluye soluciones ni tutoriales paso a paso.**

**Si te atascas:** Revisa el Ejercicio 06 (Visitor Pattern) de la Fase 1.

---

## CONTEXTO

Una universidad necesita un sistema para gestionar cursos de diferentes facultades y generar reportes usando el patron Visitor.

## TIPOS DE CURSOS

Todos los cursos tienen:
- Codigo (String)
- Nombre (String)
- Creditos (int)
- Inscritos (int)

Tipos especificos:

**CursoTeorico:**
- Horas de clase por semana (int)
- Requiere examen final (boolean)

**CursoPractico:**
- Horas de laboratorio por semana (int)
- Requiere proyecto final (boolean)

**CursoHibrido:**
- Horas teoricas (int)
- Horas practicas (int)
- Modalidad (String): "Presencial", "Online", "Mixto"

## PATRON VISITOR

Implementar 2 visitors:

**CalculadorEstadisticas:**
- Cuenta cursos por tipo
- Suma total de inscritos
- Calcula promedio de creditos
- Cuenta cursos que requieren examen/proyecto

**GeneradorReporte:**
- Muestra informacion detallada de cada curso
- Formatea diferente segun el tipo
- Incluye totales al final

## REQUISITOS FUNCIONALES

1. Crear jerarquia de cursos (Curso abstracto, 3 subclases)
2. Implementar interface VisitorCurso
3. Implementar 2 visitors concretos
4. Crear lista de cursos variados
5. Aplicar ambos visitors a la lista
6. Mostrar estadisticas y reportes

## FORMATO DE SALIDA ESPERADO

```
=== SISTEMA DE GESTION DE CURSOS ===

=== REPORTE DETALLADO ===
[TEORICO] POO-101 - Programacion Orientada a Objetos (4 creditos)
  Inscritos: 45 | Clase: 6 hrs/semana | Examen Final: Si

[PRACTICO] LAB-201 - Laboratorio de Redes (3 creditos)
  Inscritos: 30 | Lab: 8 hrs/semana | Proyecto Final: Si

[HIBRIDO] WEB-301 - Desarrollo Web (5 creditos)
  Inscritos: 38 | Teoria: 4 hrs | Practica: 6 hrs | Modalidad: Mixto

[TEORICO] MAT-102 - Calculo II (4 creditos)
  Inscritos: 52 | Clase: 5 hrs/semana | Examen Final: Si

[PRACTICO] DB-202 - Bases de Datos (4 creditos)
  Inscritos: 40 | Lab: 6 hrs/semana | Proyecto Final: Si

[HIBRIDO] IA-401 - Inteligencia Artificial (6 creditos)
  Inscritos: 25 | Teoria: 3 hrs | Practica: 5 hrs | Modalidad: Presencial

=== ESTADISTICAS ===
Total de cursos: 6
- Cursos Teoricos: 2
- Cursos Practicos: 2
- Cursos Hibridos: 2

Total de inscritos: 230 estudiantes
Promedio de creditos: 4.33

Cursos con examen final: 2
Cursos con proyecto final: 2
```

## DATOS DE PRUEBA

```java
// Crear cursos
Curso c1 = new CursoTeorico("POO-101", "Programacion Orientada a Objetos", 4, 45, 6, true);
Curso c2 = new CursoPractico("LAB-201", "Laboratorio de Redes", 3, 30, 8, true);
Curso c3 = new CursoHibrido("WEB-301", "Desarrollo Web", 5, 38, 4, 6, "Mixto");
Curso c4 = new CursoTeorico("MAT-102", "Calculo II", 4, 52, 5, true);
Curso c5 = new CursoPractico("DB-202", "Bases de Datos", 4, 40, 6, true);
Curso c6 = new CursoHibrido("IA-401", "Inteligencia Artificial", 6, 25, 3, 5, "Presencial");

// Agregar a lista
List<Curso> cursos = new ArrayList<>();
// ...

// Aplicar visitors
VisitorCurso generador = new GeneradorReporte();
VisitorCurso calculador = new CalculadorEstadisticas();

for (Curso curso : cursos) {
    curso.accept(generador);
}

for (Curso curso : cursos) {
    curso.accept(calculador);
}

calculador.mostrarEstadisticas();
```

## ESTRUCTURA SUGERIDA

```
Curso (abstract)
├── CursoTeorico
├── CursoPractico
└── CursoHibrido

VisitorCurso (interface)
├── visitarTeorico(CursoTeorico)
├── visitarPractico(CursoPractico)
└── visitarHibrido(CursoHibrido)

GeneradorReporte implements VisitorCurso
CalculadorEstadisticas implements VisitorCurso
```

## CRITERIO DE EXITO

- [x] Patron Visitor implementado correctamente
- [x] Salida coincide EXACTAMENTE con la esperada
- [x] Estadisticas calculadas correctamente
- [x] Codigo compila sin errores

**TIEMPO MAXIMO:** 80 minutos.

---

*Ejercicio de Practica Independiente - Fase 2*
