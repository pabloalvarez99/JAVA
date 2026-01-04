"""
Solucion avanzado - Funciones
"""

def memo_fib(n, memo=None):
    """Fibonacci con memoizacion."""
    if memo is None:
        memo = {}
    if n in memo:
        return memo[n]
    if n <= 1:
        memo[n] = n
    else:
        memo[n] = memo_fib(n - 1, memo) + memo_fib(n - 2, memo)
    return memo[n]


def make_counter():
    """Retorna una funcion que incrementa un contador."""
    count = 0
    def inc():
        nonlocal count
        count += 1
        return count
    return inc


def call_n_times(fn, n, value):
    """Llama fn n veces sobre value."""
    for _ in range(n):
        value = fn(value)
    return value


def main():
    print("fib:", memo_fib(6))
    counter = make_counter()
    print("count:", counter() if counter else None)
    print("call:", call_n_times(lambda x: x + 1, 3, 0))


if __name__ == "__main__":
    main()
