"""
Solucion - OOP y dataclasses
"""
from dataclasses import dataclass


@dataclass
class Tarea:
    titulo: str
    hecha: bool = False

    def marcar(self):
        """Marca la tarea como hecha."""
        self.hecha = True


class CuentaBancaria:
    def __init__(self, saldo=0):
        self.saldo = saldo

    def depositar(self, monto):
        if monto <= 0:
            raise ValueError("monto invalido")
        self.saldo += monto

    def retirar(self, monto):
        if monto <= 0:
            raise ValueError("monto invalido")
        if monto > self.saldo:
            raise ValueError("saldo insuficiente")
        self.saldo -= monto


def main():
    t = Tarea("leer")
    t.marcar()
    print("tarea:", t)

    c = CuentaBancaria(100)
    c.depositar(50)
    c.retirar(30)
    print("saldo:", c.saldo)


if __name__ == "__main__":
    main()
