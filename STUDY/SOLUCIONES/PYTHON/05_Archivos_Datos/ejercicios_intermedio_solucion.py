"""
Solucion intermedio - Archivos y datos
"""
import csv
import json
from pathlib import Path


def read_csv_dicts(path):
    """Retorna lista de dicts desde CSV."""
    with open(path, newline="", encoding="utf-8") as f:
        return list(csv.DictReader(f))


def sum_csv_column(path, col):
    """Suma columna numerica de CSV."""
    total = 0
    with open(path, newline="", encoding="utf-8") as f:
        reader = csv.DictReader(f)
        for row in reader:
            total += float(row[col])
    return int(total) if total.is_integer() else total


def write_json(path, data):
    """Guarda JSON con indentacion."""
    Path(path).write_text(json.dumps(data, indent=2), encoding="utf-8")



def filter_csv_rows(path, col, value):
    """Filtra filas de CSV por valor."""
    out = []
    with Path(path).open(encoding="utf-8", newline="") as f:
        reader = csv.DictReader(f)
        for row in reader:
            if row.get(col) == str(value):
                out.append(row)
    return out


def write_csv_dicts(path, rows):
    """Escribe lista de dicts a CSV."""
    path = Path(path)
    if not rows:
        path.write_text("", encoding="utf-8")
        return
    fieldnames = list(rows[0].keys())
    with path.open("w", encoding="utf-8", newline="") as f:
        writer = csv.DictWriter(f, fieldnames=fieldnames)
        writer.writeheader()
        writer.writerows(rows)

def main():
    base = Path(__file__).parent
    csv_path = base / "mini.csv"
    csv_path.write_text("nombre,valor\nA,1\nB,2\n", encoding="utf-8")
    print("dicts:", read_csv_dicts(csv_path))
    print("sum:", sum_csv_column(csv_path, "valor"))

    json_path = base / "data.json"
    write_json(json_path, {"ok": True})
    print("json:", json_path.name)


if __name__ == "__main__":
    main()

