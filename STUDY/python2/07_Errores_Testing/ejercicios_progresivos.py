"""
Progresivos - 07_Errores_Testing (Python2)
20 ejercicios progresivos de manejo de errores y testing.
"""


def progresivos():
    tasks = [
        {
            "id": 1,
            "titulo": "Captura de ZeroDivisionError",
            "descripcion": "try/except en division",
        },
        {
            "id": 2,
            "titulo": "Captura de ValueError",
            "descripcion": "conversión de tipos",
        },
        {"id": 3, "titulo": "Aserciones simples", "descripcion": "assert"},
        {
            "id": 4,
            "titulo": "Pruebas unitarias básicas",
            "descripcion": "escribir un test simple",
        },
        {"id": 5, "titulo": "Fixtures en pytest", "descripcion": "setup/teardown"},
        {
            "id": 6,
            "titulo": "Parametrización de tests",
            "descripcion": "@pytest.mark.parametrize",
        },
        {"id": 7, "titulo": "Mocking básico", "descripcion": "unittest.mock"},
        {"id": 8, "titulo": "Pruebas de rendimiento", "descripcion": "timeit simple"},
        {
            "id": 9,
            "titulo": "Manejo de errores de IO",
            "descripcion": "except IOErrors",
        },
        {"id": 10, "titulo": "Validación de entradas", "descripcion": "type checks"},
        {"id": 11, "titulo": "Ensayo de cobertura", "descripcion": "cobertura simple"},
        {"id": 12, "titulo": "Assert fail", "descripcion": "provocar assertion"},
        {
            "id": 13,
            "titulo": "Tests de integración",
            "descripcion": "pytest integration",
        },
        {
            "id": 14,
            "titulo": "Manejo de excepciones en funciones",
            "descripcion": "raise/try",
        },
        {
            "id": 15,
            "titulo": "Validaciones de validacion",
            "descripcion": "valida estructuras",
        },
        {"id": 16, "titulo": "Logs en tests", "descripcion": "logger"},
        {
            "id": 17,
            "titulo": "Pruebas con data",
            "descripcion": "parametrizada YAML/JSON",
        },
        {
            "id": 18,
            "titulo": "Pruebas de compatibilidad",
            "descripcion": "py3 vs py2 compat",
        },
        {"id": 19, "titulo": "Mockeo de time", "descripcion": "patch temporal"},
        {
            "id": 20,
            "titulo": "Resumen testing",
            "descripcion": "resumen de errores comunes",
        },
    ]
    for t in tasks:
        print(f"{t['id']}. {t['titulo']} - {t['descripcion']}")
    return tasks


if __name__ == "__main__":
    progresivos()
