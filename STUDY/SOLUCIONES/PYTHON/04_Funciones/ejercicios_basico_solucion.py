"""
Solucion basico - Funciones
"""

def area_rect(w, h):
    """Area de un rectangulo."""
    return w * h


def safe_div(a, b):
    """Divide o retorna None si b == 0."""
    if b == 0:
        return None
    return a / b


def repeat(texto, n):
    """Repite texto n veces."""
    return texto * n


def main():
    print("area:", area_rect(2, 3))
    print("div:", safe_div(10, 0))
    print("rep:", repeat("hi", 3))


if __name__ == "__main__":
    main()
