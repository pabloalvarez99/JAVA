"""
Solucion basico - Errores y testing
"""

def to_int_or_none(texto):
    """Convierte texto a int o retorna None."""
    try:
        return int(texto)
    except ValueError:
        return None


def validate_non_empty(texto):
    """Lanza ValueError si texto esta vacio."""
    if not texto:
        raise ValueError("texto vacio")
    return True



def safe_int(texto, default=0):
    """Convierte texto a int o retorna default."""
    try:
        return int(texto)
    except (TypeError, ValueError):
        return default

def main():
    print("int:", to_int_or_none("12"))
    print("ok:", validate_non_empty("hola"))


if __name__ == "__main__":
    main()

