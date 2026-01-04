"""
Solucion - Proyecto integrador
"""
import csv
from pathlib import Path


def agregar(tareas, titulo):
    """Agrega tarea y retorna la lista."""
    tareas.append({"id": len(tareas) + 1, "titulo": titulo, "hecha": False})
    return tareas


def completar(tareas, task_id):
    """Marca tarea como hecha y retorna True/False."""
    for t in tareas:
        if t["id"] == task_id:
            t["hecha"] = True
            return True
    return False


def listar(tareas, estado=None):
    """Retorna tareas filtradas por estado si se pasa."""
    if estado is None:
        return list(tareas)
    return [t for t in tareas if t.get("hecha") == estado]


def exportar_csv(tareas, ruta):
    """Exporta tareas a CSV."""
    ruta = Path(ruta)
    with open(ruta, "w", newline="", encoding="utf-8") as f:
        writer = csv.DictWriter(f, fieldnames=["id", "titulo", "hecha"])
        writer.writeheader()
        writer.writerows(tareas)


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
