"""
Ejercicios basico - OOP y dataclasses
"""

class CuentaBancaria:
    def __init__(self, saldo=0):
        self.saldo = saldo

    def depositar(self, monto):
        # TODO: valida monto y suma
        pass

    def retirar(self, monto):
        # TODO: valida monto y resta
        pass



def transferir(origen, destino, monto):
    """Transfiere monto entre cuentas y retorna True/False."""
    # TODO: implementa la logica
    return False

def main():
    c = CuentaBancaria(100)
    c.depositar(50)
    c.retirar(30)
    print("saldo:", c.saldo)


if __name__ == "__main__":
    main()

