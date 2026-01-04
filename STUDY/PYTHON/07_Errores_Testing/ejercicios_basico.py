"""
Ejercicios basico - Errores y testing
"""

def to_int_or_none(texto):
    """Convierte texto a int o retorna None."""
    # TODO: implementa la logica
    return None


def validate_non_empty(texto):
    """Lanza ValueError si texto esta vacio."""
    # TODO: implementa la logica
    return True



def safe_int(texto, default=0):
    """Convierte texto a int o retorna default."""
    # TODO: implementa la logica
    return default

def main():
    print("int:", to_int_or_none("12"))
    print("ok:", validate_non_empty("hola"))


if __name__ == "__main__":
    main()

