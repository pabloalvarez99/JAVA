"""
Solucion - Integracion - OOP y dataclasses
"""
from dataclasses import dataclass


@dataclass
class Tarea:
    id: int
    titulo: str
    hecha: bool = False


class ListaTareas:
    def __init__(self):
        self.items = []

    def agregar(self, titulo):
        """Agrega una tarea con id incremental."""
        next_id = max((t.id for t in self.items), default=0) + 1
        tarea = Tarea(id=next_id, titulo=titulo, hecha=False)
        self.items.append(tarea)
        return tarea

    def resumen(self):
        """Retorna dict con total, hechas, pendientes."""
        total = len(self.items)
        hechas = sum(1 for t in self.items if t.hecha)
        return {"total": total, "hechas": hechas, "pendientes": total - hechas}

