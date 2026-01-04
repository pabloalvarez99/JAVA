"""
Solucion - Control de flujo
"""

def semaforo(color):
    """Retorna accion segun el color."""
    color = color.lower()
    if color == "rojo":
        return "alto"
    if color == "verde":
        return "avance"
    if color == "amarillo":
        return "precaucion"
    return "desconocido"


def first_multiple_of_7(start, end):
    """Retorna el primer multiplo de 7 en el rango o None."""
    for n in range(start, end + 1):
        if n % 7 == 0:
            return n
    return None


def bubble_sort(nums):
    """Ordena una lista con burbuja y retorna una nueva lista."""
    arr = list(nums)
    n = len(arr)
    for i in range(n):
        for j in range(0, n - i - 1):
            if arr[j] > arr[j + 1]:
                arr[j], arr[j + 1] = arr[j + 1], arr[j]
    return arr


def chunks(items, size):
    """Divide una lista en partes de tamano fijo."""
    return [items[i : i + size] for i in range(0, len(items), size)]


def main():
    print("semaforo:", semaforo("verde"))
    print("primer 7:", first_multiple_of_7(10, 30))
    print("ordenado:", bubble_sort([5, 3, 1, 4, 2]))
    print("chunks:", chunks([1, 2, 3, 4, 5, 6, 7], 3))


if __name__ == "__main__":
    main()
