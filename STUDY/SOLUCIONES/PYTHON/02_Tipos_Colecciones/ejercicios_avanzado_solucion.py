"""
Solucion avanzado - Tipos y colecciones
"""

def rank_scores(scores):
    """Retorna lista ordenada por puntaje desc."""
    return sorted(scores, key=lambda kv: (-kv[1], kv[0]))


def comb2(items):
    """Retorna combinaciones de 2 elementos."""
    res = []
    for i in range(len(items)):
        for j in range(i + 1, len(items)):
            res.append((items[i], items[j]))
    return res


def top_k_dict(d, k):
    """Retorna top k por valor."""
    ordenado = sorted(d.items(), key=lambda kv: (-kv[1], kv[0]))
    return ordenado[:k]



def histogram(nums):
    """Retorna dict numero -> conteo."""
    res = {}
    for n in nums:
        res[n] = res.get(n, 0) + 1
    return res


def dict_diff(a, b):
    """Retorna pares de a que no estan en b."""
    return {k: v for k, v in a.items() if k not in b}

def main():
    print("rank:", rank_scores([("ana", 3), ("bob", 5), ("zoe", 4)]))
    print("comb:", comb2([1, 2, 3]))
    print("top:", top_k_dict({"a": 2, "b": 5, "c": 1}, 2))


if __name__ == "__main__":
    main()

