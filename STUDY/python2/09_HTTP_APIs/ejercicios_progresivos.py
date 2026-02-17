"""
Progresivos - 09_HTTP_APIs (Python2)
20 ejercicios progresivos sobre APIs HTTP simples.
"""


def progresivos():
    tasks = [
        {"id": 1, "titulo": "Fetch simple", "descripcion": "usar requests.get"},
        {"id": 2, "titulo": "Parsear JSON", "descripcion": "response.json()"},
        {"id": 3, "titulo": "Handling status", "descripcion": "ver codes"},
        {"id": 4, "titulo": "Headers basicos", "descripcion": "custom headers"},
        {
            "id": 5,
            "titulo": "Error handling",
            "descripcion": "try/except para requests",
        },
        {"id": 6, "titulo": "Timeouts", "descripcion": "set timeout"},
        {"id": 7, "titulo": "Query params", "descripcion": "build query string"},
        {"id": 8, "titulo": "Post request", "descripcion": "requests.post"},
        {"id": 9, "titulo": "Pagination", "descripcion": "iterate pages"},
        {"id": 10, "titulo": "Auth simple", "descripcion": "basic auth"},
        {"id": 11, "titulo": "Rate limiting", "descripcion": "respect limits"},
        {"id": 12, "titulo": "Streaming", "descripcion": "stream content"},
        {"id": 13, "titulo": "Caching", "descripcion": "cache responses"},
        {"id": 14, "titulo": "Websocket (conceptual)", "descripcion": "concepto"},
        {"id": 15, "titulo": "Testing de API", "descripcion": "pytest + requests-mock"},
        {"id": 16, "titulo": "Documentation", "descripcion": "manual README de API"},
        {
            "id": 17,
            "titulo": "Formato de respuesta",
            "descripcion": "serialize to dict",
        },
        {"id": 18, "titulo": "Error de red", "descripcion": "simulate network error"},
        {"id": 19, "titulo": "Manejo de SSL", "descripcion": "disable warnings"},
        {"id": 20, "titulo": "Resumen API", "descripcion": "resumen de conceptos"},
    ]
    for t in tasks:
        print(f"{t['id']}. {t['titulo']} - {t['descripcion']}")
    return tasks


if __name__ == "__main__":
    progresivos()
