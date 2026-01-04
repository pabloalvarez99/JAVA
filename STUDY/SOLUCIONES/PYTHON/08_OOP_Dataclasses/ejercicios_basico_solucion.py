"""
Solucion basico - OOP y dataclasses
"""

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



def transferir(origen, destino, monto):
    """Transfiere monto entre cuentas y retorna True/False."""
    if monto <= 0 or monto > origen.saldo:
        return False
    origen.retirar(monto)
    destino.depositar(monto)
    return True

def main():
    c = CuentaBancaria(100)
    c.depositar(50)
    c.retirar(30)
    print("saldo:", c.saldo)


if __name__ == "__main__":
    main()

