"""
Solucion - Archivos y datos (extra)
"""
from pathlib import Path
import csv
import json


def read_numbers(path):
    """Lee numeros (uno por linea) y retorna lista de int."""
    nums = []
    for line in Path(path).read_text(encoding="utf-8").splitlines():
        line = line.strip()
        if line:
            nums.append(int(line))
    return nums


def write_numbers(path, nums):
    """Escribe numeros (uno por linea)."""
    Path(path).write_text("\n".join(str(n) for n in nums) + "\n", encoding="utf-8")


def merge_files(a, b, out):
    """Copia contenido de a y b en out."""
    texto = Path(a).read_text(encoding="utf-8") + Path(b).read_text(encoding="utf-8")
    Path(out).write_text(texto, encoding="utf-8")


def load_json(path):
    """Carga JSON o retorna {} si falla."""
    try:
        return json.loads(Path(path).read_text(encoding="utf-8"))
    except (FileNotFoundError, json.JSONDecodeError):
        return {}


def count_lines(path):
    """Retorna cantidad de lineas del archivo."""
    total = 0
    with Path(path).open(encoding="utf-8") as f:
        for _ in f:
            total += 1
    return total


def filter_lines(path, keyword):
    """Retorna lineas que contienen keyword."""
    out = []
    with Path(path).open(encoding="utf-8") as f:
        for line in f:
            line = line.rstrip("\n")
            if keyword in line:
                out.append(line)
    return out


def write_json(path, data, pretty=False):
    """Escribe JSON en un archivo."""
    path = Path(path)
    if pretty:
        contenido = json.dumps(data, indent=2, sort_keys=True)
    else:
        contenido = json.dumps(data)
    path.write_text(contenido, encoding="utf-8")


def read_csv_simple(path):
    """Lee CSV y retorna lista de dicts."""
    path = Path(path)
    with path.open(encoding="utf-8", newline="") as f:
        reader = csv.DictReader(f)
        return [row for row in reader]



def append_line(path, text):
    """Agrega una linea al final del archivo."""
    path = Path(path)
    with path.open("a", encoding="utf-8") as f:
        f.write(text + "\n")


def read_first_line(path):
    """Retorna primera linea o "" si esta vacio."""
    path = Path(path)
    if not path.exists():
        return ""
    with path.open(encoding="utf-8") as f:
        line = f.readline()
    return line.rstrip("\n")

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

