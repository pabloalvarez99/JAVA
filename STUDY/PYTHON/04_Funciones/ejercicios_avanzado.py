"""
Ejercicios avanzado - Funciones
"""

def memo_fib(n, memo=None):
    """Fibonacci con memoizacion."""
    # TODO: implementa la logica
    return 0


def make_counter():
    """Retorna una funcion que incrementa un contador."""
    # TODO: usa nonlocal
    return None


def call_n_times(fn, n, value):
    """Llama fn n veces sobre value."""
    # TODO: implementa la logica
    return value


def main():
    print("fib:", memo_fib(6))
    counter = make_counter()
    print("count:", counter() if counter else None)
    print("call:", call_n_times(lambda x: x + 1, 3, 0))


if __name__ == "__main__":
    main()
