"""
Ejercicios - OOP y dataclasses
"""
from dataclasses import dataclass


@dataclass
class Tarea:
    titulo: str
    hecha: bool = False

    def marcar(self):
        """Marca la tarea como hecha."""
        # TODO: implementa la logica
        pass


class CuentaBancaria:
    def __init__(self, saldo=0):
        self.saldo = saldo

    def depositar(self, monto):
        # TODO: valida monto y suma al saldo
        pass

    def retirar(self, monto):
        # TODO: valida monto y resta del saldo
        pass


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
