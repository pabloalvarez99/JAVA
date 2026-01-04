"""
Solucion - Errores y testing
"""

class DatoInvalidoError(Exception):
    pass


def parse_int(texto):
    """Convierte texto a int o lanza DatoInvalidoError."""
    try:
        return int(texto)
    except ValueError as exc:
        raise DatoInvalidoError(str(exc))


def validar_edad(edad):
    """Valida que edad sea >= 0 y <= 120."""
    if edad < 0 or edad > 120:
        raise DatoInvalidoError("edad fuera de rango")
    return True


def dividir(a, b):
    """Divide a/b o lanza DatoInvalidoError si b == 0."""
    if b == 0:
        raise DatoInvalidoError("division por cero")
    return a / b


def safe_read(path):
    """Lee archivo y retorna contenido o None si no existe."""
    try:
        with open(path, encoding="utf-8") as f:
            return f.read()
    except FileNotFoundError:
        return None


def main():
    print("parse_int:", parse_int("42"))
    print("validar_edad:", validar_edad(20))
    print("dividir:", dividir(10, 2))
    print("safe_read:", safe_read("no_existe.txt"))


if __name__ == "__main__":
    main()
