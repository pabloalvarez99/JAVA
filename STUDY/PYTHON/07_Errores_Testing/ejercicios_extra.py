"""
Ejercicios extra - Errores y testing
"""

class ValidacionError(Exception):
    pass


def validar_rango(valor, minimo, maximo):
    """Valida rango o lanza ValidacionError."""
    # TODO: implementa la logica
    return True


def dividir_seguro(a, b):
    """Divide y maneja ZeroDivisionError."""
    # TODO: implementa la logica
    return None


def parse_int_safe(texto, default=None):
    """Retorna int(texto) o default si falla."""
    # TODO: implementa la logica
    return default


def assert_non_empty(texto):
    """Lanza ValidacionError si texto esta vacio."""
    # TODO: implementa la logica
    return True


def promedio(nums):
    """Retorna el promedio o lanza ValidacionError si vacio."""
    # TODO: implementa la logica
    return 0.0


def require_keys(d, keys):
    """Valida que d tenga todas las keys."""
    # TODO: implementa la logica
    return True


def safe_get(d, key, default=None):
    """Retorna d.get o default si falta."""
    # TODO: implementa la logica
    return default



def assert_type(value, expected_type):
    """Valida tipo o lanza ValidacionError."""
    # TODO: implementa la logica
    return True


def parse_float_safe(texto, default=None):
    """Retorna float(texto) o default."""
    # TODO: implementa la logica
    return default

def main():
    print("rango:", validar_rango(5, 1, 10))
    print("div:", dividir_seguro(10, 0))


if __name__ == "__main__":
    main()

