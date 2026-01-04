"""
Ejercicios extra - Funciones
"""

def apply(fn, items):
    """Aplica fn a cada item y retorna lista."""
    # TODO: implementa la logica
    return []


def compose(f, g):
    """Retorna una funcion compuesta f(g(x))."""
    # TODO: retorna funcion interna
    return None


def memo_factorial(n, memo=None):
    """Factorial con memoizacion."""
    # TODO: implementa la logica
    return 0


def variadic_sum(*nums):
    """Suma todos los numeros recibidos."""
    # TODO: implementa la logica
    return 0


def apply_twice(fn, x):
    """Aplica fn dos veces sobre x."""
    # TODO: implementa la logica
    return None


def make_multiplier(factor):
    """Retorna funcion que multiplica por factor."""
    # TODO: retorna funcion interna
    return None


def safe_divide(a, b, default=None):
    """Divide a/b o retorna default si b es 0."""
    # TODO: implementa la logica
    return default



def curry_add(n):
    """Retorna funcion que suma n."""
    # TODO: implementa la logica
    return None


def apply_until(fn, x, predicate, max_iter=100):
    """Aplica fn hasta que predicate sea True o max_iter."""
    # TODO: implementa la logica
    return x

def main():
    print("apply:", apply(lambda x: x * 2, [1, 2, 3]))
    doble_mas_1 = compose(lambda x: x + 1, lambda x: x * 2)
    print("compose:", doble_mas_1(3) if doble_mas_1 else None)
    print("fact:", memo_factorial(5))


if __name__ == "__main__":
    main()

