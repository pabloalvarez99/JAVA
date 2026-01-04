"""
Solucion - Control de flujo (extra)
"""

def find_index(items, target):
    """Retorna indice de target o -1."""
    for i, val in enumerate(items):
        if val == target:
            return i
    return -1


def menu_loop(actions):
    """Procesa acciones hasta encontrar "salir"."""
    out = []
    i = 0
    while i < len(actions):
        accion = actions[i]
        if accion == "salir":
            break
        out.append(accion)
        i += 1
    return out


def is_prime_loop(n):
    """Determina si n es primo usando while."""
    if n < 2:
        return False
    i = 2
    while i * i <= n:
        if n % i == 0:
            return False
        i += 1
    return True


def sum_until(nums, limit):
    """Suma numeros hasta alcanzar o superar limit."""
    total = 0
    for num in nums:
        total += num
        if total >= limit:
            break
    return total


def count_even_odd(nums):
    """Retorna (cantidad_pares, cantidad_impares)."""
    pares = 0
    impares = 0
    for num in nums:
        if num % 2 == 0:
            pares += 1
        else:
            impares += 1
    return (pares, impares)


def fizzbuzz(n):
    """Retorna lista 1..n con Fizz/Buzz/FizzBuzz."""
    out = []
    for i in range(1, n + 1):
        if i % 15 == 0:
            out.append("FizzBuzz")
        elif i % 3 == 0:
            out.append("Fizz")
        elif i % 5 == 0:
            out.append("Buzz")
        else:
            out.append(i)
    return out


def first_greater(nums, threshold):
    """Retorna el primer numero > threshold o None."""
    for num in nums:
        if num > threshold:
            return num
    return None



def collatz_steps(n):
    """Retorna cantidad de pasos para llegar a 1."""
    steps = 0
    while n > 1:
        if n % 2 == 0:
            n //= 2
        else:
            n = n * 3 + 1
        steps += 1
    return steps


def first_multiple(nums, k):
    """Retorna primer multiplo de k o None."""
    if k == 0:
        for num in nums:
            if num == 0:
                return 0
        return None
    for num in nums:
        if num % k == 0:
            return num
    return None

def main():
    print("index:", find_index([1, 2, 3], 2))
    print("menu:", menu_loop(["a", "b", "salir", "c"]))
    print("prime:", is_prime_loop(13))


if __name__ == "__main__":
    main()

