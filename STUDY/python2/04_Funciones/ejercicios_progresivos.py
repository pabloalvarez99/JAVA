"""
Progresivos - 04_Funciones (Python2)
20 ejercicios progresivos sobre funciones.
"""


def progresivos():
    tasks = [
        {
            "id": 1,
            "titulo": "Declarar una función simple",
            "descripcion": "def suma(a,b): return a+b",
        },
        {
            "id": 2,
            "titulo": "Funciones con retorno",
            "descripcion": "usar return para valores",
        },
        {
            "id": 3,
            "titulo": "Parámetros por defecto",
            "descripcion": "def saludo(nombre='Mundo')",
        },
        {"id": 4, "titulo": "Funciones con *args", "descripcion": "def f(*args)"},
        {"id": 5, "titulo": "Funciones con **kwargs", "descripcion": "def f(**kwargs)"},
        {
            "id": 6,
            "titulo": "Funciones recursivas simples",
            "descripcion": "fibonacci recursivo",
        },
        {"id": 7, "titulo": "Funciones anidadas", "descripcion": "closure simple"},
        {
            "id": 8,
            "titulo": "Decoradores simples",
            "descripcion": "def deco(fn): return wrapper",
        },
        {"id": 9, "titulo": "Uso de lambda", "descripcion": "lambda x: x*2"},
        {"id": 10, "titulo": "Mapa simple", "descripcion": "list(map(func, lista))"},
        {
            "id": 11,
            "titulo": "Filtrar con filter",
            "descripcion": "list(filter(cond, lista))",
        },
        {
            "id": 12,
            "titulo": "Reduce",
            "descripcion": "from functools import reduce; reduce(func, lista)",
        },
        {
            "id": 13,
            "titulo": "Comprension de listas en funciones",
            "descripcion": "[f(x) for x in lista]",
        },
        {
            "id": 14,
            "titulo": "Funciones puras",
            "descripcion": "evitar efectos colaterales",
        },
        {"id": 15, "titulo": "Docstrings", "descripcion": "documentar funcioan"},
        {
            "id": 16,
            "titulo": "Trazabilidad",
            "descripcion": "anotar entradas y salidas",
        },
        {
            "id": 17,
            "titulo": "Excepciones en funciones",
            "descripcion": "try/except en funciones",
        },
        {"id": 18, "titulo": "Función generadora", "descripcion": "yield"},
        {
            "id": 19,
            "titulo": "Funciones de alto orden",
            "descripcion": "pasar funciones como argumentos",
        },
        {
            "id": 20,
            "titulo": "Resumen funciones",
            "descripcion": "resumen de conceptos",
        },
    ]
    for t in tasks:
        print(f"{t['id']}. {t['titulo']} - {t['descripcion']}")
    return tasks


if __name__ == "__main__":
    progresivos()
