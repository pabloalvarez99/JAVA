"""
Solucion - Tipos y colecciones
"""

def sum_stats(nums):
    """Retorna (suma, minimo, maximo)."""
    if not nums:
        return 0, 0, 0
    return sum(nums), min(nums), max(nums)


def count_letters(word):
    """Cuenta ocurrencias de letras y retorna un dict."""
    conteo = {}
    for ch in word:
        conteo[ch] = conteo.get(ch, 0) + 1
    return conteo


def unique_preserve(items):
    """Elimina duplicados preservando el orden."""
    vistos = set()
    out = []
    for item in items:
        if item in vistos:
            continue
        vistos.add(item)
        out.append(item)
    return out


def matrix_row_sums(matrix):
    """Retorna una lista con la suma de cada fila."""
    return [sum(row) for row in matrix]


def main():
    nums = list(range(1, 21))
    total, minimo, maximo = sum_stats(nums)
    print("stats:", total, minimo, maximo)

    print("conteo:", count_letters("banana"))
    print("unicos:", unique_preserve([1, 2, 2, 3, 1, 4]))

    matriz = [
        [1, 2, 3],
        [4, 5, 6],
        [7, 8, 9],
    ]
    print("sumas filas:", matrix_row_sums(matriz))


if __name__ == "__main__":
    main()
