"""
Solucion basico - Control de flujo
"""

def countdown(n):
    """Retorna una lista desde n hasta 1."""
    return list(range(n, 0, -1))


def first_negative(nums):
    """Retorna indice del primer negativo o -1."""
    for i, val in enumerate(nums):
        if val < 0:
            return i
    return -1


def multiples_of(n, limit):
    """Retorna multiples de n hasta limit."""
    return [x for x in range(n, limit + 1, n)]


def main():
    print("countdown:", countdown(5))
    print("neg:", first_negative([1, 2, -1, 3]))
    print("mult:", multiples_of(3, 10))


if __name__ == "__main__":
    main()
