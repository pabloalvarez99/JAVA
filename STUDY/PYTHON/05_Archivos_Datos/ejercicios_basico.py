"""
Ejercicios basico - Archivos y datos
"""
from pathlib import Path


def read_lines(path):
    """Lee lineas y retorna lista sin saltos."""
    # TODO: implementa la logica
    return []


def write_lines(path, lines):
    """Escribe lineas en un archivo."""
    # TODO: implementa la logica
    pass


def count_words(path):
    """Cuenta palabras en el archivo."""
    # TODO: implementa la logica
    return 0


def main():
    base = Path(__file__).parent
    p = base / "demo.txt"
    write_lines(p, ["hola mundo", "python"])
    print("lines:", read_lines(p))
    print("words:", count_words(p))


if __name__ == "__main__":
    main()
