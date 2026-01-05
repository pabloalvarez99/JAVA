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



def file_exists(path):
    """Retorna True si el archivo existe."""
    # TODO: implementa la logica
    return False


def read_text(path):
    """Lee texto o retorna "" si no existe."""
    # TODO: implementa la logica
    return ""

def main():
    base = Path(__file__).parent
    p = base / "demo.txt"
    write_lines(p, ["hola mundo", "python"])
    print("lines:", read_lines(p))
    print("words:", count_words(p))


if __name__ == "__main__":
    main()

