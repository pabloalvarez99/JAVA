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



def binary_search(nums, target):
    """Busca target en lista ordenada."""
    lo = 0
    hi = len(nums) - 1
    while lo <= hi:
        mid = (lo + hi) // 2
        if nums[mid] == target:
            return mid
        if nums[mid] < target:
            lo = mid + 1
        else:
            hi = mid - 1
    return -1


def merge_sorted(a, b):
    """Merge de listas ordenadas."""
    out = []
    i = 0
    j = 0
    while i < len(a) and j < len(b):
        if a[i] <= b[j]:
            out.append(a[i])
            i += 1
        else:
            out.append(b[j])
            j += 1
    out.extend(a[i:])
    out.extend(b[j:])
    return out

def main():
    print("orden:", bubble_sort([4, 3, 2, 1]))
    print("prime:", is_prime(11))
    print("chunks:", chunk_list([1, 2, 3, 4, 5], 2))


if __name__ == "__main__":
    main()

