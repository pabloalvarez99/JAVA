"""
Solucion avanzado - Archivos y datos
"""
import csv
from pathlib import Path


def merge_csv_by_key(path_a, path_b, key):
    """Une dos CSV por una clave y retorna lista de dicts."""
    def load_map(path):
        with open(path, newline="", encoding="utf-8") as f:
            return {row[key]: row for row in csv.DictReader(f)}

    a_map = load_map(path_a)
    b_map = load_map(path_b)

    result = []
    for k, row in a_map.items():
        merged = dict(row)
        if k in b_map:
            merged.update(b_map[k])
        result.append(merged)
    return result


def replace_in_file(path, mapping):
    """Reemplaza valores segun mapping."""
    texto = Path(path).read_text(encoding="utf-8")
    for k, v in mapping.items():
        texto = texto.replace(k, v)
    Path(path).write_text(texto, encoding="utf-8")


def main():
    base = Path(__file__).parent
    a = base / "a.csv"
    b = base / "b.csv"
    a.write_text("id,nombre\n1,A\n2,B\n", encoding="utf-8")
    b.write_text("id,edad\n1,10\n2,20\n", encoding="utf-8")
    print("merge:", merge_csv_by_key(a, b, "id"))

    txt = base / "reemplazar.txt"
    txt.write_text("hola mundo", encoding="utf-8")
    replace_in_file(txt, {"hola": "hello"})
    print("texto:", txt.read_text(encoding="utf-8"))


if __name__ == "__main__":
    main()
