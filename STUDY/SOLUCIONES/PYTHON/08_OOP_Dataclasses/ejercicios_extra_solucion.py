"""
Solucion - OOP y dataclasses (extra)
"""
from dataclasses import dataclass


@dataclass
class Producto:
    nombre: str
    precio: float

    def aplicar_descuento(self, porcentaje):
        """Reduce el precio por porcentaje."""
        self.precio = self.precio * (1 - porcentaje / 100)


class Inventario:
    def __init__(self):
        self.items = []

    def agregar(self, producto):
        self.items.append(producto)

    def buscar(self, nombre):
        """Retorna el primer producto con nombre o None."""
        for item in self.items:
            if item.nombre == nombre:
                return item
        return None

    def eliminar(self, nombre):
        """Elimina primer producto por nombre y retorna True/False."""
        for idx, item in enumerate(self.items):
            if item.nombre == nombre:
                del self.items[idx]
                return True
        return False

    def contar(self):
        """Retorna cantidad de productos."""
        return len(self.items)

    def total(self):
        return sum(p.precio for p in self.items)


@dataclass
class Cuenta:
    titular: str
    saldo: float = 0.0

    def depositar(self, monto):
        """Suma al saldo."""
        if monto < 0:
            raise ValueError("monto negativo")
        self.saldo += monto

    def retirar(self, monto):
        """Resta saldo si hay fondos, o lanza ValueError."""
        if monto < 0:
            raise ValueError("monto negativo")
        if monto > self.saldo:
            raise ValueError("fondos insuficientes")
        self.saldo -= monto


def promedio_precios(productos):
    """Retorna promedio de precios o 0.0 si vacio."""
    if not productos:
        return 0.0
    return sum(p.precio for p in productos) / len(productos)



@dataclass
class Cliente:
    nombre: str
    nivel: str

    def es_vip(self):
        """Retorna True si nivel es "vip"."""
        return self.nivel.strip().lower() == "vip"


def aplicar_impuesto(producto, porcentaje):
    """Retorna precio con impuesto."""
    return producto.precio * (1 + porcentaje / 100)

def main():
    inv = Inventario()
    p = Producto("A", 10.0)
    p.aplicar_descuento(10)
    inv.agregar(p)
    print("total:", inv.total())


if __name__ == "__main__":
    main()

