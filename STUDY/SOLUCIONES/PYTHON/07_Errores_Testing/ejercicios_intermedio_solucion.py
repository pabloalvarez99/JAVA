"""
Solucion intermedio - Errores y testing
"""

class ValidacionError(Exception):
    pass


def parse_range(texto):
    """Parsea 'min-max' y retorna (min, max)."""
    try:
        a, b = texto.split("-")
        return int(a), int(b)
    except (ValueError, TypeError) as exc:
        raise ValidacionError(str(exc))


def safe_index(items, idx):
    """Retorna item o None si idx invalido."""
    if 0 <= idx < len(items):
        return items[idx]
    return None



def validate_keys(data, keys):
    """Valida keys requeridas o lanza ValidacionError."""
    faltan = [k for k in keys if k not in data]
    if faltan:
        raise ValidacionError(f"faltan keys: {faltan}")
    return True

def main():
    print("range:", parse_range("3-7"))
    print("index:", safe_index([1, 2, 3], 5))


if __name__ == "__main__":
    main()

