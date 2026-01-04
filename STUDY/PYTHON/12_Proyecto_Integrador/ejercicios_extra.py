"""
Ejercicios extra - Proyecto integrador
"""
import json
from pathlib import Path


def guardar_tareas(path, tareas):
    """Guarda tareas en JSON."""
    # TODO: implementa la logica
    pass


def cargar_tareas(path):
    """Carga tareas o retorna lista vacia."""
    # TODO: implementa la logica
    return []


def borrar_tarea(tareas, task_id):
    """Elimina tarea por id y retorna True/False."""
    # TODO: implementa la logica
    return False


def next_id(tareas):
    """Retorna el siguiente id disponible."""
    # TODO: implementa la logica
    return 1


def buscar_tarea(tareas, task_id):
    """Retorna tarea por id o None."""
    # TODO: implementa la logica
    return None


def marcar_hecha(tareas, task_id):
    """Marca tarea como hecha y retorna True/False."""
    # TODO: implementa la logica
    return False


def filtrar_pendientes(tareas):
    """Retorna lista de tareas no hechas."""
    # TODO: implementa la logica
    return []


def resumen_tareas(tareas):
    """Retorna dict con conteos."""
    # TODO: implementa la logica
    return {}



def actualizar_titulo(tareas, task_id, nuevo):
    """Actualiza titulo de tarea y retorna True/False."""
    # TODO: implementa la logica
    return False


def ordenar_tareas(tareas, key="id"):
    """Retorna lista ordenada por key."""
    # TODO: implementa la logica
    return []

def main():
    base = Path(__file__).parent
    path = base / "tareas.json"
    tareas = [{"id": 1, "titulo": "leer", "hecha": False}]
    guardar_tareas(path, tareas)
    print("cargar:", cargar_tareas(path))
    print("borrar:", borrar_tarea(tareas, 1))


if __name__ == "__main__":
    main()

