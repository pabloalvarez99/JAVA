"""
Ejercicios - Tipos y colecciones
"""

def sum_stats(nums):
    """Retorna (suma, minimo, maximo)."""
    # TODO: implementa la logica
    return 0, 0, 0


def count_letters(word):
    """Cuenta ocurrencias de letras y retorna un dict."""
    # TODO: implementa la logica
    return {}


def unique_preserve(items):
    """Elimina duplicados preservando el orden."""
    # TODO: implementa la logica
    return []


def matrix_row_sums(matrix):
    """Retorna una lista con la suma de cada fila."""
    # TODO: implementa la logica
    return []


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
