"""
Ejercicios intermedio - Proyecto integrador
"""
import csv
from pathlib import Path


def export_csv(tareas, path):
    """Exporta tareas a CSV."""
    # TODO: implementa la logica
    pass


def import_csv(path):
    """Importa tareas desde CSV."""
    # TODO: implementa la logica
    return []



def filter_done(tareas):
    """Retorna tareas hechas."""
    # TODO: implementa la logica
    return []

def main():
    path = Path(__file__).with_name("tareas.csv")
    export_csv([{"id": 1, "titulo": "leer"}], path)
    print("import:", import_csv(path))


if __name__ == "__main__":
    main()

