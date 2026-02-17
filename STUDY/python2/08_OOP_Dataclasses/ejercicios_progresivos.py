"""
Progresivos - 08_OOP_Dataclasses (Python2)
20 ejercicios progresivos con dataclasses y OO.
"""


def progresivos():
    tasks = [
        {
            "id": 1,
            "titulo": "Dataclass simple",
            "descripcion": "@dataclass class P: a:int",
        },
        {
            "id": 2,
            "titulo": "Herencia basica",
            "descripcion": "class A: pass; class B(A): pass",
        },
        {"id": 3, "titulo": "Propiedades", "descripcion": "@property"},
        {
            "id": 4,
            "titulo": "Encapsulacion",
            "descripcion": "private attributes via naming",
        },
        {"id": 5, "titulo": "Representacion", "descripcion": "__str__"},
        {
            "id": 6,
            "titulo": "Comparadores",
            "descripcion": "__lt__ or rich comparisons",
        },
        {
            "id": 7,
            "titulo": "Patron Builder (simulado)",
            "descripcion": "builder pattern",
        },
        {
            "id": 8,
            "titulo": "Data validation",
            "descripcion": "pydantic-like validation",
        },
        {"id": 9, "titulo": "Composite simple", "descripcion": "composite pattern"},
        {"id": 10, "titulo": "Factory simple", "descripcion": "factory method"},
        {
            "id": 11,
            "titulo": "Singleton simple",
            "descripcion": "class Singleton: pass",
        },
        {"id": 12, "titulo": "Enum usage", "descripcion": "from enum import Enum"},
        {
            "id": 13,
            "titulo": "Mutable default",
            "descripcion": "avoid mutable defaults",
        },
        {
            "id": 14,
            "titulo": "Dataclasses with default factory",
            "descripcion": "field(default_factory=...)",
        },
        {
            "id": 15,
            "titulo": "Dataclass inheritance",
            "descripcion": "inheritance with dataclasses",
        },
        {"id": 16, "titulo": "Equality methods", "descripcion": "__eq__"},
        {"id": 17, "titulo": "Serialization", "descripcion": "to/from dict"},
        {"id": 18, "titulo": "Validation in dataclass", "descripcion": "__post_init__"},
        {
            "id": 19,
            "titulo": "Unit testing dataclasses",
            "descripcion": "pytest dataclass",
        },
        {"id": 20, "titulo": "Resumen OO", "descripcion": "Resumen de conceptos"},
    ]
    for t in tasks:
        print(f"{t['id']}. {t['titulo']} - {t['descripcion']}")
    return tasks


if __name__ == "__main__":
    progresivos()
