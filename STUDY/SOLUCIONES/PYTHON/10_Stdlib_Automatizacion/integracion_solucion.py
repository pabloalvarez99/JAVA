"""
Solucion - Integracion - Stdlib y automatizacion
"""
from collections import Counter


def top_n_words(text, n):
    """Retorna top n palabras."""
    return Counter(text.split()).most_common(n)


def moving_average(nums, window):
    """Retorna lista de promedios por ventana."""
    if window <= 0:
        return []
    out = []
    for i in range(len(nums) - window + 1):
        out.append(sum(nums[i : i + window]) / window)
    return out

