# 09 - Ejercicios de Tracing (Prediccion de Salida)

## Objetivo
Desarrollar la habilidad de "ejecutar codigo mentalmente" - una skill esencial para debugging, entrevistas tecnicas y comprension profunda de Java.

## Como usar estos ejercicios

1. **Lee el codigo SIN ejecutarlo**
2. **Escribe tu prediccion** en el espacio indicado
3. **Ejecuta el codigo** y compara
4. **Analiza las diferencias** - Si te equivocaste, entiende POR QUE

## Ejercicios

| # | Nombre | Concepto | Dificultad |
|---|--------|----------|------------|
| 1 | VariableScope | Ambito y shadowing | ⭐⭐ |
| 2 | MethodOverloading | Sobrecarga de metodos | ⭐⭐ |
| 3 | InheritanceChain | Cadena de herencia | ⭐⭐⭐ |
| 4 | PolymorphismPuzzle | Polimorfismo runtime | ⭐⭐⭐ |
| 5 | StaticVsInstance | Orden de ejecucion | ⭐⭐⭐ |
| 6 | ExceptionFlow | Try-catch-finally | ⭐⭐⭐ |
| 7 | RecursionTrace | Pila de llamadas | ⭐⭐⭐ |
| 8 | StreamPipeline | Evaluacion perezosa | ⭐⭐⭐⭐ |
| 9 | ComparatorOrder | Ordenamiento multiple | ⭐⭐⭐ |
| 10 | ThreadInterleaving | Posibles salidas | ⭐⭐⭐⭐⭐ |

## Consejos para Tracing

### Tecnica del "Papel y Lapiz"
```
1. Dibuja una tabla de variables
2. Actualiza valores en cada linea
3. Sigue el flujo de control (if, loops, calls)
4. Anota cada System.out.println
```

### Errores Comunes al Predecir
- Olvidar que Java es pass-by-value (para referencias, copia la referencia)
- Confundir tipo de compilacion vs tipo de ejecucion
- No considerar el orden de inicializacion estatica
- Asumir orden en threads

## Puntuacion

- **10/10 correctos**: Experto en Java
- **7-9 correctos**: Muy buen nivel
- **4-6 correctos**: Necesitas mas practica
- **0-3 correctos**: Revisa los conceptos basicos

## Siguientes Pasos

Despues de dominar tracing:
- `07_Ejercicios_Debug/` - Aplicar para encontrar bugs
- `04_Avanzado/` - Conceptos mas complejos
