"""
Ejercicios basico - Proyecto integrador
"""

def add_task(tareas, titulo):
    """Agrega tarea con id incremental."""
    # TODO: implementa la logica
    return tareas


def list_tasks(tareas):
    """Retorna lista de tareas."""
    # TODO: implementa la logica
    return []



def mark_done(tareas, task_id):
    """Marca tarea como hecha y retorna True/False."""
    # TODO: implementa la logica
    return False

def main():
    tareas = []
    tareas = add_task(tareas, "leer")
    print("list:", list_tasks(tareas))


if __name__ == "__main__":
    main()

