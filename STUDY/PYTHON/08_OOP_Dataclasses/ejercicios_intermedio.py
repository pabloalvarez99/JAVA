"""
Ejercicios intermedio - OOP y dataclasses
"""
from dataclasses import dataclass


@dataclass
class Producto:
    nombre: str
    precio: float

    def precio_final(self, impuesto):
        """Retorna precio con impuesto."""
        # TODO: implementa la logica
        return 0.0

    @classmethod
    def from_dict(cls, data):
        """Crea producto desde dict."""
        # TODO: implementa la logica
        return cls("", 0.0)



def total_precio(productos):
    """Suma precios de productos."""
    # TODO: implementa la logica
    return 0.0

def main():
    p = Producto("A", 10.0)
    print("final:", p.precio_final(0.19))
    print("dict:", Producto.from_dict({"nombre": "B", "precio": 5.0}))


if __name__ == "__main__":
    main()

