"""
Solucion basico - Archivos y datos
"""
from pathlib import Path


def read_lines(path):
    """Lee lineas y retorna lista sin saltos."""
    return Path(path).read_text(encoding="utf-8").splitlines()


def write_lines(path, lines):
    """Escribe lineas en un archivo."""
    Path(path).write_text("\n".join(lines) + "\n", encoding="utf-8")


def count_words(path):
    """Cuenta palabras en el archivo."""
    texto = Path(path).read_text(encoding="utf-8")
    return len(texto.split())



def file_exists(path):
    """Retorna True si el archivo existe."""
    return Path(path).exists()


def read_text(path):
    """Lee texto o retorna "" si no existe."""
    path = Path(path)
    if not path.exists():
        return ""
    return path.read_text(encoding="utf-8")

def main():
    base = Path(__file__).parent
    p = base / "demo.txt"
    write_lines(p, ["hola mundo", "python"])
    print("lines:", read_lines(p))
    print("words:", count_words(p))


if __name__ == "__main__":
    main()

