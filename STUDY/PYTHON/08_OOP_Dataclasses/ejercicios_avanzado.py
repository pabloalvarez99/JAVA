"""
Ejercicios avanzado - OOP y dataclasses
"""

class Repositorio:
    def __init__(self):
        self.items = []

    def agregar(self, item):
        # TODO: agrega item
        pass

    def buscar_por_id(self, item_id):
        # TODO: retorna item por id o None
        return None

    def eliminar(self, item_id):
        # TODO: elimina y retorna True/False
        return False



def actualizar_item(items, item_id, data):
    """Actualiza item por id y retorna True/False."""
    # TODO: implementa la logica
    return False

def main():
    repo = Repositorio()
    repo.agregar({"id": 1, "nombre": "A"})
    print("buscar:", repo.buscar_por_id(1))
    print("elim:", repo.eliminar(1))


if __name__ == "__main__":
    main()

