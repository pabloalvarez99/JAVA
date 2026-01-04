"""
Solucion - Archivos y datos
"""
from pathlib import Path
import csv
import json


def resumen_texto(ruta):
    """Retorna (lineas, palabras, caracteres)."""
    texto = Path(ruta).read_text(encoding="utf-8")
    lineas = texto.splitlines()
    palabras = texto.split()
    return len(lineas), len(palabras), len(texto)


def guardar_json(ruta, data):
    """Guarda data en JSON."""
    ruta = Path(ruta)
    ruta.write_text(json.dumps(data, ensure_ascii=False, indent=2), encoding="utf-8")


def sumar_columna_csv(ruta, columna):
    """Suma una columna numerica de un CSV."""
    total = 0
    with open(ruta, newline="", encoding="utf-8") as f:
        reader = csv.DictReader(f)
        for row in reader:
            total += float(row[columna])
    return int(total) if total.is_integer() else total


def filtrar_lineas_vacias(ruta_in, ruta_out):
    """Copia solo lineas no vacias."""
    texto = Path(ruta_in).read_text(encoding="utf-8").splitlines()
    filtradas = [linea for linea in texto if linea.strip()]
    Path(ruta_out).write_text("\n".join(filtradas) + ("\n" if filtradas else ""), encoding="utf-8")
    return len(filtradas)


def main():
    base = Path(__file__).parent

    txt = base / "sample.txt"
    txt.write_text("uno dos\n\n tres cuatro\n", encoding="utf-8")
    print("resumen:", resumen_texto(txt))

    data = {"a": 1, "b": 2}
    json_path = base / "sample.json"
    guardar_json(json_path, data)
    print("json guardado:", json_path.name)

    csv_path = base / "sample.csv"
    csv_path.write_text("nombre,valor\nA,10\nB,20\n", encoding="utf-8")
    print("suma csv:", sumar_columna_csv(csv_path, "valor"))

    out_path = base / "sample_filtrado.txt"
    print("lineas copiadas:", filtrar_lineas_vacias(txt, out_path))


if __name__ == "__main__":
    main()
