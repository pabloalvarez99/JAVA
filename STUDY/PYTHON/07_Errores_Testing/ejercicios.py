"""
Ejercicios - Errores y testing
"""

class DatoInvalidoError(Exception):
    pass


def parse_int(texto):
    """Convierte texto a int o lanza DatoInvalidoError."""
    # TODO: implementa la logica
    return 0


def validar_edad(edad):
    """Valida que edad sea >= 0 y <= 120."""
    # TODO: implementa la logica
    return True


def dividir(a, b):
    """Divide a/b o lanza DatoInvalidoError si b == 0."""
    # TODO: implementa la logica
    return 0


def safe_read(path):
    """Lee archivo y retorna contenido o None si no existe."""
    # TODO: implementa la logica
    return None


def main():
    print("parse_int:", parse_int("42"))
    print("validar_edad:", validar_edad(20))
    print("dividir:", dividir(10, 2))
    print("safe_read:", safe_read("no_existe.txt"))


if __name__ == "__main__":
    main()
