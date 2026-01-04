"""
Ejercicios - Stdlib y automatizacion
"""
from collections import Counter, defaultdict, deque
import bisect
import heapq


def top_words(texto, n=3):
    """Retorna las n palabras mas comunes."""
    # TODO: usa Counter
    return []


def group_by_first(items):
    """Agrupa strings por su primer caracter."""
    # TODO: usa defaultdict(list)
    return {}


def queue_simulation(items):
    """Procesa una cola y retorna el orden de salida."""
    # TODO: usa deque
    return []


def smallest_n(nums, n):
    """Retorna los n menores elementos."""
    # TODO: usa heapq.nsmallest
    return []


def insert_sorted(lst, value):
    """Inserta value en lista ordenada."""
    # TODO: usa bisect.insort
    return lst


def main():
    print("top:", top_words("hola hola mundo mundo mundo", 2))
    print("grupo:", group_by_first(["ana", "alfa", "beto"]))
    print("cola:", queue_simulation([1, 2, 3]))
    print("min:", smallest_n([5, 1, 4, 2, 3], 2))
    print("insert:", insert_sorted([1, 3, 5], 4))


if __name__ == "__main__":
    main()
