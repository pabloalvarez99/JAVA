"""
Solucion - Funciones (extra)
"""

def apply(fn, items):
    """Aplica fn a cada item y retorna lista."""
    return [fn(x) for x in items]


def compose(f, g):
    """Retorna una funcion compuesta f(g(x))."""
    def h(x):
        return f(g(x))
    return h


def memo_factorial(n, memo=None):
    """Factorial con memoizacion."""
    if memo is None:
        memo = {}
    if n in memo:
        return memo[n]
    if n <= 1:
        memo[n] = 1
    else:
        memo[n] = n * memo_factorial(n - 1, memo)
    return memo[n]


def variadic_sum(*nums):
    """Suma todos los numeros recibidos."""
    total = 0
    for num in nums:
        total += num
    return total


def apply_twice(fn, x):
    """Aplica fn dos veces sobre x."""
    return fn(fn(x))


def make_multiplier(factor):
    """Retorna funcion que multiplica por factor."""
    def inner(x):
        return x * factor
    return inner


def safe_divide(a, b, default=None):
    """Divide a/b o retorna default si b es 0."""
    if b == 0:
        return default
    return a / b



def curry_add(n):
    """Retorna funcion que suma n."""
    def inner(x):
        return x + n
    return inner


def apply_until(fn, x, predicate, max_iter=100):
    """Aplica fn hasta que predicate sea True o max_iter."""
    value = x
    for _ in range(max_iter):
        if predicate(value):
            return value
        value = fn(value)
    return value

def main():
    print("apply:", apply(lambda x: x * 2, [1, 2, 3]))
    doble_mas_1 = compose(lambda x: x + 1, lambda x: x * 2)
    print("compose:", doble_mas_1(3) if doble_mas_1 else None)
    print("fact:", memo_factorial(5))


if __name__ == "__main__":
    main()

