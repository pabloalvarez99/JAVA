"""
Solucion basico - Proyecto integrador
"""

def add_task(tareas, titulo):
    """Agrega tarea con id incremental."""
    tareas.append({"id": len(tareas) + 1, "titulo": titulo, "hecha": False})
    return tareas


def list_tasks(tareas):
    """Retorna lista de tareas."""
    return list(tareas)



def mark_done(tareas, task_id):
    """Marca tarea como hecha y retorna True/False."""
    for t in tareas:
        if t.get("id") == task_id:
            t["hecha"] = True
            return True
    return False

def main():
    tareas = []
    tareas = add_task(tareas, "leer")
    print("list:", list_tasks(tareas))


if __name__ == "__main__":
    main()

