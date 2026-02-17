"""
Progresivos - 10_Stdlib_Automatizacion (Python2)
20 ejercicios progresivos con stdlib para automatizacion.
"""


def progresivos():
    tasks = [
        {
            "id": 1,
            "titulo": "Subprocess simple",
            "descripcion": "ejecutar comando shell",
        },
        {"id": 2, "titulo": "Uso de glob", "descripcion": "listar archivos por patron"},
        {"id": 3, "titulo": "Serializar JSON", "descripcion": "json.dumps"},
        {"id": 4, "titulo": "Manejo de fechas", "descripcion": "datetime"},
        {"id": 5, "titulo": "Tiempo de ejecucion", "descripcion": "time.time()"},
        {"id": 6, "titulo": "Temporizador simple", "descripcion": "time.sleep"},
        {"id": 7, "titulo": "Cipher simple (hash)", "descripcion": "hashlib"},
        {"id": 8, "titulo": "Archivo temporal", "descripcion": "tmpfile"},
        {"id": 9, "titulo": "Persistencia", "descripcion": "pickle"},
        {"id": 10, "titulo": "HTTP client basico", "descripcion": "urllib"},
        {"id": 11, "titulo": "Config parsing", "descripcion": "configparser"},
        {"id": 12, "titulo": "XML processing", "descripcion": "xml.etree.ElementTree"},
        {"id": 13, "titulo": "XML/JSON dual", "descripcion": "yaml or json"},
        {"id": 14, "titulo": "Logging avanzado", "descripcion": "logging module"},
        {"id": 15, "titulo": "Data compression", "descripcion": "zlib"},
        {"id": 16, "titulo": "Date parsing", "descripcion": "dateutil"},
        {"id": 17, "titulo": "CLI helper", "descripcion": "argparse"},
        {"id": 18, "titulo": "File checksum", "descripcion": "hashlib.sha256"},
        {"id": 19, "titulo": "Progress bar", "descripcion": "tqdm"},
        {"id": 20, "titulo": "Resumen", "descripcion": "recap"},
    ]
    for t in tasks:
        print(f"{t['id']}. {t['titulo']} - {t['descripcion']}")
    return tasks


if __name__ == "__main__":
    progresivos()
