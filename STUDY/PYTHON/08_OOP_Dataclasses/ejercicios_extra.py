"""
Ejercicios extra - OOP y dataclasses
"""
from dataclasses import dataclass


@dataclass
class Producto:
    nombre: str
    precio: float

    def aplicar_descuento(self, porcentaje):
        """Reduce el precio por porcentaje."""
        # TODO: implementa la logica
        pass


class Inventario:
    def __init__(self):
        self.items = []

    def agregar(self, producto):
        # TODO: agrega producto
        pass

    def buscar(self, nombre):
        """Retorna el primer producto con nombre o None."""
        # TODO: implementa la logica
        return None

    def eliminar(self, nombre):
        """Elimina primer producto por nombre y retorna True/False."""
        # TODO: implementa la logica
        return False

    def contar(self):
        """Retorna cantidad de productos."""
        # TODO: implementa la logica
        return 0

    def total(self):
        # TODO: suma precios
        return 0.0


@dataclass
class Cuenta:
    titular: str
    saldo: float = 0.0

    def depositar(self, monto):
        """Suma al saldo."""
        # TODO: implementa la logica
        pass

    def retirar(self, monto):
        """Resta saldo si hay fondos, o lanza ValueError."""
        # TODO: implementa la logica
        pass


def promedio_precios(productos):
    """Retorna promedio de precios o 0.0 si vacio."""
    # TODO: implementa la logica
    return 0.0



@dataclass
class Cliente:
    nombre: str
    nivel: str

    def es_vip(self):
        """Retorna True si nivel es "vip"."""
        # TODO: implementa la logica
        return False


def aplicar_impuesto(producto, porcentaje):
    """Retorna precio con impuesto."""
    # TODO: implementa la logica
    return 0.0

def main():
    inv = Inventario()
    p = Producto("A", 10.0)
    p.aplicar_descuento(10)
    inv.agregar(p)
    print("total:", inv.total())


if __name__ == "__main__":
    main()

