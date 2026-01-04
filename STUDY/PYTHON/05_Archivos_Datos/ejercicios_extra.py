"""
Ejercicios extra - Archivos y datos
"""
from pathlib import Path
import csv
import json


def read_numbers(path):
    """Lee numeros (uno por linea) y retorna lista de int."""
    # TODO: implementa la logica
    return []


def write_numbers(path, nums):
    """Escribe numeros (uno por linea)."""
    # TODO: implementa la logica
    pass


def merge_files(a, b, out):
    """Copia contenido de a y b en out."""
    # TODO: implementa la logica
    pass


def load_json(path):
    """Carga JSON o retorna {} si falla."""
    # TODO: implementa la logica
    return {}


def count_lines(path):
    """Retorna cantidad de lineas del archivo."""
    # TODO: implementa la logica
    return 0


def filter_lines(path, keyword):
    """Retorna lineas que contienen keyword."""
    # TODO: implementa la logica
    return []


def write_json(path, data, pretty=False):
    """Escribe JSON en un archivo."""
    # TODO: implementa la logica
    pass


def read_csv_simple(path):
    """Lee CSV y retorna lista de dicts."""
    # TODO: implementa la logica
    return []



def append_line(path, text):
    """Agrega una linea al final del archivo."""
    # TODO: implementa la logica
    pass


def read_first_line(path):
    """Retorna primera linea o "" si esta vacio."""
    # TODO: implementa la logica
    return ""

def main():
    base = Path(__file__).parent
    p = base / "nums.txt"
    write_numbers(p, [1, 2, 3])
    print("nums:", read_numbers(p))

    a = base / "a.txt"
    b = base / "b.txt"
    a.write_text("A\n", encoding="utf-8")
    b.write_text("B\n", encoding="utf-8")
    out = base / "ab.txt"
    merge_files(a, b, out)
    print("merge:", out.read_text(encoding="utf-8").strip())

    j = base / "data.json"
    j.write_text("{\"ok\": true}", encoding="utf-8")
    print("json:", load_json(j))


if __name__ == "__main__":
    main()

