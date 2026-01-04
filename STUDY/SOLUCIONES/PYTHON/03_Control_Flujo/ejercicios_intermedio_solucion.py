"""
Solucion intermedio - Control de flujo
"""

def menu_process(actions):
    """Procesa acciones hasta encontrar 'salir'."""
    out = []
    i = 0
    while i < len(actions):
        accion = actions[i]
        if accion == "salir":
            break
        out.append(accion)
        i += 1
    return out


def find_first_multiple(n, start, end):
    """Retorna el primer multiplo de n en el rango."""
    for val in range(start, end + 1):
        if val % n == 0:
            return val
    return None


def fizzbuzz(n):
    """Retorna lista de fizzbuzz hasta n."""
    out = []
    for i in range(1, n + 1):
        if i % 15 == 0:
            out.append("fizzbuzz")
        elif i % 3 == 0:
            out.append("fizz")
        elif i % 5 == 0:
            out.append("buzz")
        else:
            out.append(str(i))
    return out


def main():
    print("menu:", menu_process(["a", "b", "salir", "c"]))
    print("first:", find_first_multiple(7, 10, 30))
    print("fizz:", fizzbuzz(15))


if __name__ == "__main__":
    main()
