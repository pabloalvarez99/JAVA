"""
Solucion - Errores y testing (extra)
"""

class ValidacionError(Exception):
    pass


def validar_rango(valor, minimo, maximo):
    """Valida rango o lanza ValidacionError."""
    if valor < minimo or valor > maximo:
        raise ValidacionError("fuera de rango")
    return True


def dividir_seguro(a, b):
    """Divide y maneja ZeroDivisionError."""
    try:
        return a / b
    except ZeroDivisionError:
        return None


def parse_int_safe(texto, default=None):
    """Retorna int(texto) o default si falla."""
    try:
        return int(texto)
    except (TypeError, ValueError):
        return default


def assert_non_empty(texto):
    """Lanza ValidacionError si texto esta vacio."""
    if texto is None or texto == "":
        raise ValidacionError("texto vacio")
    return True


def promedio(nums):
    """Retorna el promedio o lanza ValidacionError si vacio."""
    if not nums:
        raise ValidacionError("lista vacia")
    return sum(nums) / len(nums)


def require_keys(d, keys):
    """Valida que d tenga todas las keys."""
    faltantes = [k for k in keys if k not in d]
    if faltantes:
        raise ValidacionError(f"faltan keys: {faltantes}")
    return True


def safe_get(d, key, default=None):
    """Retorna d.get o default si falta."""
    if d is None:
        return default
    return d.get(key, default)



def assert_type(value, expected_type):
    """Valida tipo o lanza ValidacionError."""
    if not isinstance(value, expected_type):
        raise ValidacionError("tipo invalido")
    return True


def parse_float_safe(texto, default=None):
    """Retorna float(texto) o default."""
    try:
        return float(texto)
    except (TypeError, ValueError):
        return default

def main():
    print("rango:", validar_rango(5, 1, 10))
    print("div:", dividir_seguro(10, 0))


if __name__ == "__main__":
    main()

