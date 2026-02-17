"""
Progresivos - 05_Archivos_Datos (Python2)
20 ejercicios progresivos sobre archivos y datos.
"""


def progresivos():
    tasks = [
        {
            "id": 1,
            "titulo": "Lectura de un archivo de texto",
            "descripcion": "read() y readline()",
        },
        {
            "id": 2,
            "titulo": "Escritura de un archivo",
            "descripcion": "with open(..., 'w')",
        },
        {
            "id": 3,
            "titulo": "Lectura por linea en bucle",
            "descripcion": "for line in f",
        },
        {
            "id": 4,
            "titulo": "Escritura de datos estructurados",
            "descripcion": "json.dump",
        },
        {"id": 5, "titulo": "Uso de CSV", "descripcion": "csv.reader/use csv.writer"},
        {
            "id": 6,
            "titulo": "Manejo de rutas",
            "descripcion": "Pathlib para resolver rutas",
        },
        {"id": 7, "titulo": "Lectura binaria", "descripcion": "open(..., 'rb')"},
        {"id": 8, "titulo": "Serializacion JSON", "descripcion": "json.dumps y loads"},
        {
            "id": 9,
            "titulo": "Carga de datos con pandas (opcional)",
            "descripcion": "import pandas as pd",
        },
        {
            "id": 10,
            "titulo": "Esquemas de validacion",
            "descripcion": "validacion basica de datos",
        },
        {
            "id": 11,
            "titulo": "Manejo de excepciones en IO",
            "descripcion": "try/except around IO",
        },
        {
            "id": 12,
            "titulo": "Manejo de pequeños logs",
            "descripcion": "archivo de log simple",
        },
        {
            "id": 13,
            "titulo": "Cache en memoria",
            "descripcion": "dict como cache simple",
        },
        {"id": 14, "titulo": "Lectura perezosa", "descripcion": "lazy load"},
        {
            "id": 15,
            "titulo": "Persistencia simple",
            "descripcion": "guardar en archivo",
        },
        {"id": 16, "titulo": "Changelog simple", "descripcion": "append file"},
        {"id": 17, "titulo": "Manipular datos de texto", "descripcion": "split/join"},
        {
            "id": 18,
            "titulo": "Parquet/Orc (opcional)",
            "descripcion": "lectura de formatos columnados",
        },
        {
            "id": 19,
            "titulo": "Procesamiento por lotes",
            "descripcion": "procesar en chunks",
        },
        {"id": 20, "titulo": "Resumen Archivos y Datos", "descripcion": " resumen"},
    ]
    for t in tasks:
        print(f"{t['id']}. {t['titulo']} - {t['descripcion']}")
    return tasks


if __name__ == "__main__":
    progresivos()
