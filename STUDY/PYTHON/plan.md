# Plan practico de aprendizaje: Python

Formato: cada modulo incluye Conceptos, Ejemplos y muchos Ejercicios.
Soluciones: ver `STUDY/SOLUCIONES/PYTHON` (usar solo para autocorreccion).

## Indice por conceptos (carpetas)
- `STUDY/PYTHON/01_Entorno_Ejecucion` - README.md + ejercicios.py + ejercicios_extra.py + ejercicios_basico.py + ejercicios_intermedio.py + ejercicios_avanzado.py
- `STUDY/PYTHON/02_Tipos_Colecciones` - README.md + ejercicios.py + ejercicios_extra.py + ejercicios_basico.py + ejercicios_intermedio.py + ejercicios_avanzado.py
- `STUDY/PYTHON/03_Control_Flujo` - README.md + ejercicios.py + ejercicios_extra.py + ejercicios_basico.py + ejercicios_intermedio.py + ejercicios_avanzado.py
- `STUDY/PYTHON/04_Funciones` - README.md + ejercicios.py + ejercicios_extra.py + ejercicios_basico.py + ejercicios_intermedio.py + ejercicios_avanzado.py
- `STUDY/PYTHON/05_Archivos_Datos` - README.md + ejercicios.py + ejercicios_extra.py + ejercicios_basico.py + ejercicios_intermedio.py + ejercicios_avanzado.py
- `STUDY/PYTHON/06_Modulos_CLI` - README.md + ejercicios.py + ejercicios_extra.py + ejercicios_basico.py + ejercicios_intermedio.py + ejercicios_avanzado.py
- `STUDY/PYTHON/07_Errores_Testing` - README.md + ejercicios.py + ejercicios_extra.py + ejercicios_basico.py + ejercicios_intermedio.py + ejercicios_avanzado.py
- `STUDY/PYTHON/08_OOP_Dataclasses` - README.md + ejercicios.py + ejercicios_extra.py + ejercicios_basico.py + ejercicios_intermedio.py + ejercicios_avanzado.py
- `STUDY/PYTHON/09_HTTP_APIs` - README.md + ejercicios.py + ejercicios_extra.py + ejercicios_basico.py + ejercicios_intermedio.py + ejercicios_avanzado.py
- `STUDY/PYTHON/10_Stdlib_Automatizacion` - README.md + ejercicios.py + ejercicios_extra.py + ejercicios_basico.py + ejercicios_intermedio.py + ejercicios_avanzado.py
- `STUDY/PYTHON/11_Datos_Visualizacion` - README.md + ejercicios.py + ejercicios_extra.py + ejercicios_basico.py + ejercicios_intermedio.py + ejercicios_avanzado.py
- `STUDY/PYTHON/12_Proyecto_Integrador` - README.md + ejercicios.py + ejercicios_extra.py + ejercicios_basico.py + ejercicios_intermedio.py + ejercicios_avanzado.py

## Modulo 0: Puesta a punto y ejecucion
Conceptos:
- Versiones de Python, `python` vs `python -m`.
- Entornos virtuales con `venv`.
- `pip` y archivos `requirements.txt`.
- Estructura minima de proyecto.
Ejemplos:
- Crear y activar un `venv`, instalar una dependencia.
- Ejecutar `python -m modulo` y un script simple.
Ejercicios:
- Ver archivos de ejercicios en la carpeta correspondiente.

## Modulo 1: Tipos y control de flujo
Conceptos:
- Tipos basicos: int, float, str, bool, None.
- Colecciones: list, tuple, dict, set.
- Slicing y operaciones comunes en colecciones.
- Condicionales, bucles, `range`, `enumerate`.
- Comprensiones de listas y diccionarios.
Ejemplos:
- Filtrar una lista de numeros pares.
- Transformar una lista de nombres a mayusculas.
Ejercicios:
- Ver archivos de ejercicios en la carpeta correspondiente.

## Modulo 2: Funciones y archivos
Conceptos:
- `def`, argumentos por defecto, `*args`, `**kwargs`.
- Retorno de valores y alcance de variables.
- Docstrings basicos.
- Lectura y escritura de archivos con `with`.
- Formatos CSV y JSON.
Ejemplos:
- Funcion que devuelve estadisticas (min, max, promedio).
- Leer un CSV simple y generar un JSON de salida.
Ejercicios:
- Ver archivos de ejercicios en la carpeta correspondiente.

## Modulo 3: Modulos, paquetes y CLI
Conceptos:
- Modulos y paquetes, `__init__.py`.
- `__name__ == "__main__"` y ejecucion como modulo.
- Imports absolutos y relativos.
- `argparse` para CLI.
- `pathlib` para rutas.
Ejemplos:
- Paquete `utils` con funciones reutilizables.
- CLI que recibe un archivo y cuenta lineas.
Ejercicios:
- Ver archivos de ejercicios en la carpeta correspondiente.

## Modulo 4: Errores, testing y calidad
Conceptos:
- Excepciones y `try/except/else/finally`.
- `raise` y excepciones personalizadas.
- Aserciones y pruebas con `pytest`.
- `type hints` basicos.
Ejemplos:
- Validacion de entrada con errores controlados.
- Test simple para una funcion matematica.
Ejercicios:
- Ver archivos de ejercicios en la carpeta correspondiente.

## Modulo 5: OOP y dataclasses
Conceptos:
- Clases, `__init__`, metodos de instancia.
- Propiedades y validaciones simples.
- Composicion vs herencia (basico).
- `@dataclass` para datos.
Ejemplos:
- Clase `Libro` con titulo, autor y anio.
- `@dataclass` para una tarea con estado.
Ejercicios:
- Ver archivos de ejercicios en la carpeta correspondiente.

## Modulo 6: Colecciones avanzadas y stdlib util
Conceptos:
- `collections`: Counter, defaultdict, deque.
- `itertools` y `functools`.
- `heapq` y `bisect`.
- `datetime`, `random`, `statistics`.
Ejemplos:
- Contar palabras con `Counter`.
- Cola simple con `deque`.
Ejercicios:
- Ver archivos de ejercicios en la carpeta correspondiente.

## Modulo 7: HTTP, APIs y automatizacion
Conceptos:
- HTTP basico: GET, POST, status codes.
- JSON y serializacion.
- `requests`, timeouts y manejo de errores.
- Variables de entorno para tokens.
Ejemplos:
- Consumir una API publica y guardar JSON.
- Enviar datos a un endpoint de prueba.
Ejercicios:
- Ver archivos de ejercicios en la carpeta correspondiente.

## Modulo 8: Datos y visualizacion
Conceptos:
- `pandas` DataFrame, `read_csv`.
- Limpieza de datos: nulos, tipos, duplicados.
- `groupby` y agregaciones.
- `matplotlib` basico.
Ejemplos:
- Cargar un CSV y generar un grafico de barras.
- Limpiar filas con valores nulos.
Ejercicios:
- Ver archivos de ejercicios en la carpeta correspondiente.

## Modulo 9: Integracion practica (solo ejercicios)
Ejercicios:
- Ver archivos de ejercicios en la carpeta correspondiente.

