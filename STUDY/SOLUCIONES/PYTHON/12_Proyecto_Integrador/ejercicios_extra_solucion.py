"""
Solucion - Proyecto integrador (extra)
"""
import json
from pathlib import Path


def guardar_tareas(path, tareas):
    """Guarda tareas en JSON."""
    Path(path).write_text(json.dumps(tareas, indent=2), encoding="utf-8")


def cargar_tareas(path):
    """Carga tareas o retorna lista vacia."""
    path = Path(path)
    if not path.exists():
        return []
    return json.loads(path.read_text(encoding="utf-8"))


def borrar_tarea(tareas, task_id):
    """Elimina tarea por id y retorna True/False."""
    for i, t in enumerate(tareas):
        if t.get("id") == task_id:
            tareas.pop(i)
            return True
    return False


def next_id(tareas):
    """Retorna el siguiente id disponible."""
    if not tareas:
        return 1
    return max(t.get("id", 0) for t in tareas) + 1


def buscar_tarea(tareas, task_id):
    """Retorna tarea por id o None."""
    for t in tareas:
        if t.get("id") == task_id:
            return t
    return None


def marcar_hecha(tareas, task_id):
    """Marca tarea como hecha y retorna True/False."""
    t = buscar_tarea(tareas, task_id)
    if t is None:
        return False
    t["hecha"] = True
    return True


def filtrar_pendientes(tareas):
    """Retorna lista de tareas no hechas."""
    return [t for t in tareas if not t.get("hecha")]


def resumen_tareas(tareas):
    """Retorna dict con conteos."""
    total = len(tareas)
    hechas = sum(1 for t in tareas if t.get("hecha"))
    return {"total": total, "hechas": hechas, "pendientes": total - hechas}



def actualizar_titulo(tareas, task_id, nuevo):
    """Actualiza titulo de tarea y retorna True/False."""
    for t in tareas:
        if t.get("id") == task_id:
            t["titulo"] = nuevo
            return True
    return False


def ordenar_tareas(tareas, key="id"):
    """Retorna lista ordenada por key."""
    return sorted(tareas, key=lambda t: t.get(key))

def main():
    base = Path(__file__).parent
    path = base / "tareas.json"
    tareas = [{"id": 1, "titulo": "leer", "hecha": False}]
    guardar_tareas(path, tareas)
    print("cargar:", cargar_tareas(path))
    print("borrar:", borrar_tarea(tareas, 1))


if __name__ == "__main__":
    main()

