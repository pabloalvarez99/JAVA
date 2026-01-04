"""
Solucion - Integracion - Proyecto integrador
"""
import json
from pathlib import Path


def add_task(tareas, titulo):
    """Agrega tarea y retorna dict."""
    next_id = max((t.get("id", 0) for t in tareas), default=0) + 1
    task = {"id": next_id, "titulo": titulo, "hecha": False}
    tareas.append(task)
    return task


def save_tasks(path, tareas):
    """Guarda tareas en JSON."""
    Path(path).write_text(json.dumps(tareas, indent=2), encoding="utf-8")


def load_tasks(path):
    """Carga tareas o retorna []."""
    path = Path(path)
    if not path.exists():
        return []
    return json.loads(path.read_text(encoding="utf-8"))

