"""
Solucion intermedio - Proyecto integrador
"""
import csv
from pathlib import Path


def export_csv(tareas, path):
    """Exporta tareas a CSV."""
    with open(path, "w", newline="", encoding="utf-8") as f:
        writer = csv.DictWriter(f, fieldnames=["id", "titulo", "hecha"])
        writer.writeheader()
        writer.writerows(tareas)


def import_csv(path):
    """Importa tareas desde CSV."""
    with open(path, newline="", encoding="utf-8") as f:
        return list(csv.DictReader(f))



def filter_done(tareas):
    """Retorna tareas hechas."""
    return [t for t in tareas if t.get("hecha")]

def main():
    path = Path(__file__).with_name("tareas.csv")
    export_csv([{"id": 1, "titulo": "leer", "hecha": False}], path)
    print("import:", import_csv(path))


if __name__ == "__main__":
    main()

