"""
Solucion avanzado - OOP y dataclasses
"""

class Repositorio:
    def __init__(self):
        self.items = []

    def agregar(self, item):
        self.items.append(item)

    def buscar_por_id(self, item_id):
        for item in self.items:
            if item.get("id") == item_id:
                return item
        return None

    def eliminar(self, item_id):
        for i, item in enumerate(self.items):
            if item.get("id") == item_id:
                self.items.pop(i)
                return True
        return False



def actualizar_item(items, item_id, data):
    """Actualiza item por id y retorna True/False."""
    for item in items:
        if item.get("id") == item_id:
            item.update(data)
            return True
    return False

def main():
    repo = Repositorio()
    repo.agregar({"id": 1, "nombre": "A"})
    print("buscar:", repo.buscar_por_id(1))
    print("elim:", repo.eliminar(1))


if __name__ == "__main__":
    main()

