"""
Ejercicios extra - Stdlib y automatizacion
"""
from collections import Counter, deque
import heapq
import statistics


def most_common(texto, n):
    """Retorna las n palabras mas comunes."""
    # TODO: usa Counter
    return []


def rotate_queue(items, k):
    """Rota una cola k posiciones."""
    # TODO: usa deque.rotate
    return []


def top_k(nums, k):
    """Retorna los k mayores elementos."""
    # TODO: usa heapq.nlargest
    return []


def top_k_smallest(nums, k):
    """Retorna los k menores elementos."""
    # TODO: usa heapq.nsmallest
    return []


def unique_words(texto):
    """Retorna palabras unicas preservando orden."""
    # TODO: implementa la logica
    return []


def median(nums):
    """Retorna la mediana o None si vacio."""
    # TODO: usa statistics.median
    return None


def histogram(nums):
    """Retorna un Counter con conteos."""
    # TODO: implementa la logica
    return Counter()



def rolling_sum(nums, window):
    """Retorna sumas por ventana."""
    # TODO: implementa la logica
    return []


def group_by_length(words):
    """Agrupa palabras por longitud."""
    # TODO: implementa la logica
    return {}

def main():
    print("common:", most_common("a b a c b a", 2))
    print("rotate:", rotate_queue([1, 2, 3, 4], 1))
    print("top:", top_k([1, 5, 2, 9, 3], 2))


if __name__ == "__main__":
    main()

