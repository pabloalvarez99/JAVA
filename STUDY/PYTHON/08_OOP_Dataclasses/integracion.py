"""
Integracion - OOP y dataclasses
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
        # TODO: implementa la logica
        pass

    def resumen(self):
        """Retorna dict con total, hechas, pendientes."""
        # TODO: implementa la logica
        return {}

