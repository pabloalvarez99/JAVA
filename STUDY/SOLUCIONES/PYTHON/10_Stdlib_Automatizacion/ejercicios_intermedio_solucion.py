"""
Solucion intermedio - Stdlib y automatizacion
"""
import bisect
import heapq


def smallest_n(nums, n):
    """Retorna n menores elementos."""
    return heapq.nsmallest(n, nums)


def insert_sorted(lst, value):
    """Inserta value en lista ordenada."""
    bisect.insort(lst, value)
    return lst



def bisect_left_index(sorted_list, value):
    """Retorna indice de insercion."""
    return bisect.bisect_left(sorted_list, value)

def main():
    print("small:", smallest_n([5, 1, 4, 2], 2))
    print("insert:", insert_sorted([1, 3, 5], 4))


if __name__ == "__main__":
    main()

