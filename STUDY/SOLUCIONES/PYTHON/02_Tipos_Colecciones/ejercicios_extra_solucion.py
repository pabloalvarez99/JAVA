"""
Solucion - Tipos y colecciones (extra)
"""

def merge_counts(a, b):
    """Combina dos dicts de conteo sumando valores."""
    res = dict(a)
    for k, v in b.items():
        res[k] = res.get(k, 0) + v
    return res


def top_n(items, n):
    """Retorna los n mas frecuentes como lista de tuplas."""
    conteo = {}
    for item in items:
        conteo[item] = conteo.get(item, 0) + 1
    ordenado = sorted(conteo.items(), key=lambda kv: (-kv[1], kv[0]))
    return ordenado[:n]


def invert_dict(d):
    """Invierte un dict: valor -> lista de claves."""
    inv = {}
    for k, v in d.items():
        inv.setdefault(v, []).append(k)
    return inv


def unique_preserve_order(items):
    """Retorna items unicos preservando el orden."""
    seen = set()
    out = []
    for item in items:
        if item not in seen:
            seen.add(item)
            out.append(item)
    return out


def chunk_list(items, size):
    """Divide items en listas de tamanio size."""
    if size <= 0:
        return []
    out = []
    for i in range(0, len(items), size):
        out.append(items[i : i + size])
    return out


def flatten(nested):
    """Aplana una lista de listas (un nivel)."""
    out = []
    for group in nested:
        out.extend(group)
    return out


def list_diff(a, b):
    """Retorna elementos de a que no estan en b."""
    ban = set(b)
    return [item for item in a if item not in ban]



def rotate_list(items, k):
    """Rota lista k posiciones a la derecha."""
    if not items:
        return []
    k = k % len(items)
    return items[-k:] + items[:-k]


def pairwise(items):
    """Retorna pares consecutivos (a, b)."""
    return [(items[i], items[i + 1]) for i in range(len(items) - 1)]

def main():
    print("merge:", merge_counts({"a": 2}, {"a": 1, "b": 3}))
    print("top:", top_n(["a", "b", "a", "c", "b", "a"], 2))
    print("invert:", invert_dict({"x": 1, "y": 1, "z": 2}))


if __name__ == "__main__":
    main()

