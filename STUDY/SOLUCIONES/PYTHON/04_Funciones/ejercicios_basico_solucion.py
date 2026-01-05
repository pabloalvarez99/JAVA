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



def clamp(n, min_value, max_value):
    """Limita n al rango."""
    if n < min_value:
        return min_value
    if n > max_value:
        return max_value
    return n


def mean(nums):
    """Retorna promedio o 0 si vacio."""
    if not nums:
        return 0
    return sum(nums) / len(nums)

def main():
    print("area:", area_rect(2, 3))
    print("div:", safe_div(10, 0))
    print("rep:", repeat("hi", 3))


if __name__ == "__main__":
    main()

