"""
Solucion - Integracion - Archivos y datos
"""
from pathlib import Path


def load_numbers(path):
    """Lee numeros (uno por linea)."""
    nums = []
    for line in Path(path).read_text(encoding="utf-8").splitlines():
        line = line.strip()
        if line:
            nums.append(int(line))
    return nums


def save_summary(path, nums):
    """Guarda min, max y promedio en un archivo."""
    path = Path(path)
    if not nums:
        contenido = "min=0\nmax=0\navg=0\n"
    else:
        avg = sum(nums) / len(nums)
        contenido = f"min={min(nums)}\nmax={max(nums)}\navg={avg}\n"
    path.write_text(contenido, encoding="utf-8")

