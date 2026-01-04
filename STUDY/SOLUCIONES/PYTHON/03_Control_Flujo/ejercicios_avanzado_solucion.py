"""
Solucion avanzado - Control de flujo
"""

def bubble_sort(nums):
    """Ordena con burbuja."""
    arr = list(nums)
    n = len(arr)
    for i in range(n):
        for j in range(0, n - i - 1):
            if arr[j] > arr[j + 1]:
                arr[j], arr[j + 1] = arr[j + 1], arr[j]
    return arr


def is_prime(n):
    """Retorna True si n es primo."""
    if n < 2:
        return False
    i = 2
    while i * i <= n:
        if n % i == 0:
            return False
        i += 1
    return True


def chunk_list(items, size):
    """Divide items en chunks de tamano size."""
    return [items[i : i + size] for i in range(0, len(items), size)]


def main():
    print("orden:", bubble_sort([4, 3, 2, 1]))
    print("prime:", is_prime(11))
    print("chunks:", chunk_list([1, 2, 3, 4, 5], 2))


if __name__ == "__main__":
    main()
