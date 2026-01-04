"""
Solucion avanzado - Stdlib y automatizacion
"""
from collections import deque


def dedupe_preserve(items):
    """Elimina duplicados preservando orden."""
    vistos = set()
    out = []
    for item in items:
        if item in vistos:
            continue
        vistos.add(item)
        out.append(item)
    return out


def rolling_window(items, size):
    """Retorna ventanas de tamano fijo."""
    q = deque(maxlen=size)
    out = []
    for item in items:
        q.append(item)
        if len(q) == size:
            out.append(list(q))
    return out



def rotate_steps(items, k):
    """Rota lista k posiciones."""
    q = deque(items)
    q.rotate(k)
    return list(q)

def main():
    print("dedupe:", dedupe_preserve([1, 2, 2, 3, 1]))
    print("roll:", rolling_window([1, 2, 3, 4], 3))


if __name__ == "__main__":
    main()

