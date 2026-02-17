"""
Progresivos - 03_Control_Flujo (Python2)
20 ejercicios progresivos sobre control de flujo.
"""


def progresivos():
    tasks = [
        {"id": 1, "titulo": "If/else básico", "descripcion": "condicionando salida"},
        {"id": 2, "titulo": "If anidados", "descripcion": "anidar if para rango"},
        {
            "id": 3,
            "titulo": "Operadores ternarios",
            "descripcion": "expr if cond else expr",
        },
        {"id": 4, "titulo": "While simple", "descripcion": "contador con while"},
        {
            "id": 5,
            "titulo": "While con break/continue",
            "descripcion": "control de bucle",
        },
        {"id": 6, "titulo": "For con rango", "descripcion": "for i in range(n)"},
        {
            "id": 7,
            "titulo": "Switch simulado",
            "descripcion": "dict_dispatch como switch",
        },
        {
            "id": 8,
            "titulo": "Comprension de listas condicionadas",
            "descripcion": "listas cond",
        },
        {"id": 9, "titulo": "Bucle anidado", "descripcion": "for anidado"},
        {
            "id": 10,
            "titulo": "Comprobacion de excepciones",
            "descripcion": "try/except",
        },
        {
            "id": 11,
            "titulo": "Validar entrada usuario",
            "descripcion": "if isinstance() y entradas",
        },
        {
            "id": 12,
            "titulo": "Continuar en bucle",
            "descripcion": "usar continue cuando aplica",
        },
        {
            "id": 13,
            "titulo": "Pasos de control de flujo",
            "descripcion": "flag variables",
        },
        {
            "id": 14,
            "titulo": "Ciclos infinitos controlados",
            "descripcion": "while True con break",
        },
        {"id": 15, "titulo": "Condicionales encadenados", "descripcion": "elif/else"},
        {
            "id": 16,
            "titulo": "Condicionales anidadas",
            "descripcion": "condiciones complejas",
        },
        {
            "id": 17,
            "titulo": "Operadores lógicos",
            "descripcion": "and/or/not en condiciones",
        },
        {
            "id": 18,
            "titulo": "Expresión de múltiples rutas",
            "descripcion": "logica combinada",
        },
        {"id": 19, "titulo": "Tipografías de bucles", "descripcion": "bucle con else"},
        {"id": 20, "titulo": "Resumen flujo", "descripcion": "resumen de conceptos"},
    ]
    for t in tasks:
        print(f"{t['id']}. {t['titulo']} - {t['descripcion']}")
    return tasks


if __name__ == "__main__":
    progresivos()
