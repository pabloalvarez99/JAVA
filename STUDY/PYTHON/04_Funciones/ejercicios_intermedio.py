"""
Ejercicios intermedio - Funciones
"""

def apply(fn, items):
    """Aplica fn a cada item."""
    # TODO: implementa la logica
    return []


def compose(f, g):
    """Devuelve f(g(x))."""
    # TODO: retorna una funcion
    return None


def filter_by(fn, items):
    """Filtra items segun fn."""
    # TODO: implementa la logica
    return []


def main():
    print("apply:", apply(lambda x: x + 1, [1, 2, 3]))
    doble_mas_1 = compose(lambda x: x + 1, lambda x: x * 2)
    print("compose:", doble_mas_1(3) if doble_mas_1 else None)
    print("filter:", filter_by(lambda x: x % 2 == 0, [1, 2, 3, 4]))


if __name__ == "__main__":
    main()
