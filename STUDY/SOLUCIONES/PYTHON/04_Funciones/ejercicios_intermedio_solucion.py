"""
Solucion intermedio - Funciones
"""

def apply(fn, items):
    """Aplica fn a cada item."""
    return [fn(x) for x in items]


def compose(f, g):
    """Devuelve f(g(x))."""
    def h(x):
        return f(g(x))
    return h


def filter_by(fn, items):
    """Filtra items segun fn."""
    return [x for x in items if fn(x)]


def main():
    print("apply:", apply(lambda x: x + 1, [1, 2, 3]))
    doble_mas_1 = compose(lambda x: x + 1, lambda x: x * 2)
    print("compose:", doble_mas_1(3) if doble_mas_1 else None)
    print("filter:", filter_by(lambda x: x % 2 == 0, [1, 2, 3, 4]))


if __name__ == "__main__":
    main()
