"""
Progresivos - 02_Tipos_Colecciones (Python2)
20 ejercicios progresivos sobre listas, diccionarios y sets.
"""


def progresivos():
    tasks = [
        {
            "id": 1,
            "titulo": "Listas simples",
            "descripcion": "crear lista y recorrerla",
        },
        {
            "id": 2,
            "titulo": "Acceso a elementos",
            "descripcion": "acceder a primer y ultimo elemento",
        },
        {"id": 3, "titulo": "Comprobacion de longitud", "descripcion": "len(lista)"},
        {
            "id": 4,
            "titulo": "Añadir elementos con append",
            "descripcion": "lista.append(x)",
        },
        {
            "id": 5,
            "titulo": "Comprehension de listas",
            "descripcion": "n^2 para n en [1..5]",
        },
        {
            "id": 6,
            "titulo": "Diccionarios simples",
            "descripcion": "crear y acceder a claves",
        },
        {
            "id": 7,
            "titulo": "Recorrido de diccionarios",
            "descripcion": "for k,v in d.items()",
        },
        {
            "id": 8,
            "titulo": "Conjuntos",
            "descripcion": "crear conjunto y operaciones basicas",
        },
        {
            "id": 9,
            "titulo": "Buscar en diccionario",
            "descripcion": "get con valor por defecto",
        },
        {"id": 10, "titulo": "Merge de diccionarios", "descripcion": "{**d1, **d2}"},
        {
            "id": 11,
            "titulo": "Copias de estructuras",
            "descripcion": "copias superficiales vs profundas",
        },
        {"id": 12, "titulo": "Ordenar listas", "descripcion": "sorted(lista)"},
        {
            "id": 13,
            "titulo": "Filtrar con comprensión",
            "descripcion": "[x for x in lista if cond]",
        },
        {"id": 14, "titulo": "Buscar maximo y minimo", "descripcion": "max, min"},
        {"id": 15, "titulo": "Suma de elementos", "descripcion": "sum(lista)"},
        {"id": 16, "titulo": "Unificar listas", "descripcion": "zip y comprehension"},
        {"id": 17, "titulo": "Unir diccionarios", "descripcion": "update"},
        {"id": 18, "titulo": "Set operations", "descripcion": "intersection/union"},
        {"id": 19, "titulo": "Indexación inversa", "descripcion": "lista[::-1]"},
        {"id": 20, "titulo": "Resumen", "descripcion": "resumen de lo aprendido"},
    ]
    for t in tasks:
        print(f"{t['id']}. {t['titulo']} - {t['descripcion']}")
    return tasks


if __name__ == "__main__":
    progresivos()
