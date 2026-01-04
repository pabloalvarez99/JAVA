"""
Ejercicios - Proyecto integrador
"""
import csv
import json
from pathlib import Path


def agregar(tareas, titulo):
    """Agrega tarea y retorna la lista."""
    # TODO: implementa la logica
    return tareas


def completar(tareas, task_id):
    """Marca tarea como hecha y retorna True/False."""
    # TODO: implementa la logica
    return False


def listar(tareas, estado=None):
    """Retorna tareas filtradas por estado si se pasa."""
    # TODO: implementa la logica
    return []


def exportar_csv(tareas, ruta):
    """Exporta tareas a CSV."""
    # TODO: implementa la logica
    pass


def main():
    tareas = []
    tareas = agregar(tareas, "leer")
    tareas = agregar(tareas, "escribir")
    completar(tareas, 1)
    print("tareas:", listar(tareas))

    csv_path = Path(__file__).with_name("tareas.csv")
    exportar_csv(tareas, csv_path)
    print("exportado:", csv_path.name)


if __name__ == "__main__":
    main()
