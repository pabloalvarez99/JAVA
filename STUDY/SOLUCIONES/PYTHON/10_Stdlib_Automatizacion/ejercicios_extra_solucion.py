"""
Solucion - Stdlib y automatizacion (extra)
"""
from collections import Counter, deque
import heapq
import statistics


def most_common(texto, n):
    """Retorna las n palabras mas comunes."""
    return Counter(texto.split()).most_common(n)


def rotate_queue(items, k):
    """Rota una cola k posiciones."""
    q = deque(items)
    q.rotate(k)
    return list(q)


def top_k(nums, k):
    """Retorna los k mayores elementos."""
    return heapq.nlargest(k, nums)


def top_k_smallest(nums, k):
    """Retorna los k menores elementos."""
    return heapq.nsmallest(k, nums)


def unique_words(texto):
    """Retorna palabras unicas preservando orden."""
    seen = set()
    out = []
    for word in texto.split():
        if word not in seen:
            seen.add(word)
            out.append(word)
    return out


def median(nums):
    """Retorna la mediana o None si vacio."""
    if not nums:
        return None
    return statistics.median(nums)


def histogram(nums):
    """Retorna un Counter con conteos."""
    return Counter(nums)



def rolling_sum(nums, window):
    """Retorna sumas por ventana."""
    if window <= 0:
        return []
    out = []
    for i in range(len(nums) - window + 1):
        out.append(sum(nums[i : i + window]))
    return out


def group_by_length(words):
    """Agrupa palabras por longitud."""
    out = {}
    for w in words:
        out.setdefault(len(w), []).append(w)
    return out

def main():
    print("common:", most_common("a b a c b a", 2))
    print("rotate:", rotate_queue([1, 2, 3, 4], 1))
    print("top:", top_k([1, 5, 2, 9, 3], 2))


if __name__ == "__main__":
    main()

