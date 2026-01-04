"""
Ejercicios intermedio - Errores y testing
"""

class ValidacionError(Exception):
    pass


def parse_range(texto):
    """Parsea 'min-max' y retorna (min, max)."""
    # TODO: implementa la logica
    return (0, 0)


def safe_index(items, idx):
    """Retorna item o None si idx invalido."""
    # TODO: implementa la logica
    return None



def validate_keys(data, keys):
    """Valida keys requeridas o lanza ValidacionError."""
    # TODO: implementa la logica
    return True

def main():
    print("range:", parse_range("3-7"))
    print("index:", safe_index([1, 2, 3], 5))


if __name__ == "__main__":
    main()

