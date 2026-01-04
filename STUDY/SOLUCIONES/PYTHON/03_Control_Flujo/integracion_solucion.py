"""
Solucion - Integracion - Control de flujo
"""

def collatz_sequence(n):
    """Retorna la secuencia de Collatz hasta 1."""
    seq = [n]
    while n > 1:
        if n % 2 == 0:
            n //= 2
        else:
            n = n * 3 + 1
        seq.append(n)
    return seq


def count_transitions(nums):
    """Cuenta cambios entre elementos consecutivos."""
    if not nums:
        return 0
    cambios = 0
    for i in range(1, len(nums)):
        if nums[i] != nums[i - 1]:
            cambios += 1
    return cambios

