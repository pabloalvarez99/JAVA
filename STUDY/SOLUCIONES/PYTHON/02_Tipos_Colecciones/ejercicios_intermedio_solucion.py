"""
Solucion intermedio - Tipos y colecciones
"""

def merge_dicts_sum(a, b):
    """Combina dicts sumando valores."""
    res = dict(a)
    for k, v in b.items():
        res[k] = res.get(k, 0) + v
    return res


def unique_preserve(items):
    """Elimina duplicados preservando orden."""
    vistos = set()
    out = []
    for item in items:
        if item in vistos:
            continue
        vistos.add(item)
        out.append(item)
    return out


def pairs_with_squares(n):
    """Retorna lista de tuplas (i, i**2)."""
    return [(i, i ** 2) for i in range(1, n + 1)]


def main():
    print("merge:", merge_dicts_sum({"a": 1}, {"a": 2, "b": 3}))
    print("unique:", unique_preserve([1, 2, 2, 3]))
    print("pairs:", pairs_with_squares(5))


if __name__ == "__main__":
    main()
