"""
Solucion basico - Tipos y colecciones
"""

def sum_even(nums):
    """Suma numeros pares."""
    return sum(n for n in nums if n % 2 == 0)


def count_vowels(texto):
    """Cuenta vocales en el texto."""
    vocales = set("aeiouAEIOU")
    return sum(1 for ch in texto if ch in vocales)


def reverse_list(items):
    """Retorna una nueva lista invertida."""
    return list(reversed(items))


def main():
    print("pares:", sum_even([1, 2, 3, 4]))
    print("vocales:", count_vowels("banana"))
    print("reverse:", reverse_list([1, 2, 3]))


if __name__ == "__main__":
    main()
