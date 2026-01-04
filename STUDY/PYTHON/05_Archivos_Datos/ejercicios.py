"""
Ejercicios - Archivos y datos
"""
from pathlib import Path
import csv
import json


def resumen_texto(ruta):
    """Retorna (lineas, palabras, caracteres)."""
    # TODO: implementa la logica
    return 0, 0, 0


def guardar_json(ruta, data):
    """Guarda data en JSON."""
    # TODO: implementa la logica
    pass


def sumar_columna_csv(ruta, columna):
    """Suma una columna numerica de un CSV."""
    # TODO: implementa la logica
    return 0


def filtrar_lineas_vacias(ruta_in, ruta_out):
    """Copia solo lineas no vacias."""
    # TODO: implementa la logica
    return 0


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
