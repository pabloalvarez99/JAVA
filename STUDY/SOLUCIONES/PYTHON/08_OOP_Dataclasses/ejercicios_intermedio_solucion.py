"""
Solucion intermedio - OOP y dataclasses
"""
from dataclasses import dataclass


@dataclass
class Producto:
    nombre: str
    precio: float

    def precio_final(self, impuesto):
        """Retorna precio con impuesto."""
        return self.precio * (1 + impuesto)

    @classmethod
    def from_dict(cls, data):
        """Crea producto desde dict."""
        return cls(data.get("nombre", ""), data.get("precio", 0.0))



def total_precio(productos):
    """Suma precios de productos."""
    return sum(p.precio for p in productos)

def main():
    p = Producto("A", 10.0)
    print("final:", p.precio_final(0.19))
    print("dict:", Producto.from_dict({"nombre": "B", "precio": 5.0}))


if __name__ == "__main__":
    main()

