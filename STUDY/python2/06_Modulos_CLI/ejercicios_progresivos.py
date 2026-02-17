"""
Progresivos - 06_Modulos_CLI (Python2)
20 ejercicios progresivos con CLI.
"""


def progresivos():
    tasks = [
        {
            "id": 1,
            "titulo": "Argumentos simples",
            "descripcion": "parsear args con argparse",
        },
        {"id": 2, "titulo": "Subparsers", "descripcion": "crear subcomandos"},
        {"id": 3, "titulo": "Leer flags", "descripcion": "flags booleanos"},
        {
            "id": 4,
            "titulo": "Archivo de configuracion",
            "descripcion": "usar configparser",
        },
        {"id": 5, "titulo": "Ayuda de CLI", "descripcion": "custom help"},
        {"id": 6, "titulo": "Entrada por teclado", "descripcion": "input()"},
        {"id": 7, "titulo": "Validacion de argumentos", "descripcion": "type=int"},
        {"id": 8, "titulo": "Salida a stdout", "descripcion": "print()"},
        {"id": 9, "titulo": "Salida a archivo", "descripcion": "redirect a file"},
        {"id": 10, "titulo": "CLI amigable", "descripcion": "mensajes de usuario"},
        {
            "id": 11,
            "titulo": "Uso de colors en CLI",
            "descripcion": "ANSI escape codes",
        },
        {"id": 12, "titulo": "Comprobacion de errores", "descripcion": "excepts"},
        {
            "id": 13,
            "titulo": "Integracion con others",
            "descripcion": "invocar subprocess",
        },
        {"id": 14, "titulo": "Argparse vs click", "descripcion": "comparar enfoque"},
        {"id": 15, "titulo": "Documentacion de CLI", "descripcion": "docstring"},
        {"id": 16, "titulo": "Serialization de configs", "descripcion": "json/yaml"},
        {"id": 17, "titulo": "Testing de CLI", "descripcion": "pytest -k cli"},
        {
            "id": 18,
            "titulo": "Pruebas de rendimiento",
            "descripcion": "lineas de comando",
        },
        {"id": 19, "titulo": "CLI segura", "descripcion": "sanitizar inputs"},
        {"id": 20, "titulo": "Resumen CLI", "descripcion": "resumen de conceptos"},
    ]
    for t in tasks:
        print(f"{t['id']}. {t['titulo']} - {t['descripcion']}")
    return tasks


if __name__ == "__main__":
    progresivos()
