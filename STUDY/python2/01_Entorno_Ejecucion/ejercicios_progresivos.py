"""
Progresivos - 01_Entorno_Ejecucion (Python2)
20 ejercicios progresivos para entender el entorno y ejecucion de Python.
"""


def progresivos():
    tasks = [
        {
            "id": 1,
            "titulo": "Mostrar versión de Python",
            "descripcion": "print(sys.version)",
        },
        {
            "id": 2,
            "titulo": "Mostrar ejecutable de Python",
            "descripcion": "print(sys.executable)",
        },
        {
            "id": 3,
            "titulo": "Ruta del script actual",
            "descripcion": "print(Path(__file__).resolve())",
        },
        {"id": 4, "titulo": "Directorio home", "descripcion": "print(Path.home())"},
        {
            "id": 5,
            "titulo": "Listado de directorio actual",
            "descripcion": "print(os.listdir('.'))",
        },
        {
            "id": 6,
            "titulo": "Cambiar directorio",
            "descripcion": "import os; os.chdir('..')",
        },
        {
            "id": 7,
            "titulo": "Crear directorio temporal",
            "descripcion": "os.makedirs('temp', exist_ok=True)",
        },
        {
            "id": 8,
            "titulo": "Leer variable de entorno",
            "descripcion": "print(os.getenv('PATH',''))",
        },
        {"id": 9, "titulo": "Pathlib cwd", "descripcion": "print(Path.cwd())"},
        {
            "id": 10,
            "titulo": "Parsear argumentos simples",
            "descripcion": "simular parseo de ['--verbose', 'archivo.txt']",
        },
        {
            "id": 11,
            "titulo": "Formato de impresión",
            "descripcion": "print(f'Versión: {sys.version}')",
        },
        {
            "id": 12,
            "titulo": "Manejo de excepciones simples",
            "descripcion": "try/except para dividir por cero",
        },
        {
            "id": 13,
            "titulo": "Fecha actual",
            "descripcion": "from datetime import datetime; print(datetime.now())",
        },
        {
            "id": 14,
            "titulo": "Configuracion básica",
            "descripcion": "config = {'debug': True}; print(config['debug'])",
        },
        {
            "id": 15,
            "titulo": "Listas y for",
            "descripcion": "for i in [1,2,3]: print(i)",
        },
        {
            "id": 16,
            "titulo": "Funciones simples",
            "descripcion": "def saludar(n): return f'Hola {n}'",
        },
        {
            "id": 17,
            "titulo": "Logging básico",
            "descripcion": "import logging; logging.info('info')",
        },
        {"id": 18, "titulo": "Mini CLI", "descripcion": "def main(args): print(args)"},
        {
            "id": 19,
            "titulo": "Prueba de import",
            "descripcion": "import math; print(math.sqrt(16))",
        },
        {
            "id": 20,
            "titulo": "Resumen aprendizaje",
            "descripcion": "Imprimir resumen de lo aprendido",
        },
    ]
    for t in tasks:
        print(f"{t['id']}. {t['titulo']} - {t['descripcion']}")
    return tasks


if __name__ == "__main__":
    progresivos()
