"""
Ejercicios extra - Control de flujo
"""

def find_index(items, target):
    """Retorna indice de target o -1."""
    # TODO: implementa con for
    return -1


def menu_loop(actions):
    """Procesa acciones hasta encontrar "salir"."""
    # TODO: usa while y break
    return []


def is_prime_loop(n):
    """Determina si n es primo usando while."""
    # TODO: implementa la logica
    return False


def sum_until(nums, limit):
    """Suma numeros hasta alcanzar o superar limit."""
    # TODO: usa break cuando se cumpla
    return 0


def count_even_odd(nums):
    """Retorna (cantidad_pares, cantidad_impares)."""
    # TODO: implementa la logica
    return (0, 0)


def fizzbuzz(n):
    """Retorna lista 1..n con Fizz/Buzz/FizzBuzz."""
    # TODO: implementa la logica
    return []


def first_greater(nums, threshold):
    """Retorna el primer numero > threshold o None."""
    # TODO: implementa la logica
    return None



def collatz_steps(n):
    """Retorna cantidad de pasos para llegar a 1."""
    # TODO: implementa la logica
    return 0


def first_multiple(nums, k):
    """Retorna primer multiplo de k o None."""
    # TODO: implementa la logica
    return None

def main():
    print("index:", find_index([1, 2, 3], 2))
    print("menu:", menu_loop(["a", "b", "salir", "c"]))
    print("prime:", is_prime_loop(13))


if __name__ == "__main__":
    main()

