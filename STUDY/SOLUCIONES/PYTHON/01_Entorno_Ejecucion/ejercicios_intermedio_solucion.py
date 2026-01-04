"""
Solucion intermedio - Entorno y ejecucion
"""
import importlib.util
from pathlib import Path
import sys


def module_exists(name):
    """Retorna True si el modulo existe."""
    return importlib.util.find_spec(name) is not None


def save_env_report(path):
    """Guarda un reporte simple del entorno."""
    path = Path(path)
    contenido = [
        f"version: {sys.version}",
        f"executable: {sys.executable}",
        f"cwd: {Path.cwd()}",
    ]
    path.write_text("\n".join(contenido), encoding="utf-8")


def read_env_report(path):
    """Lee el reporte y retorna una lista de lineas."""
    return Path(path).read_text(encoding="utf-8").splitlines()


def main():
    print("json existe:", module_exists("json"))
    report = Path(__file__).with_name("env_report.txt")
    save_env_report(report)
    print("lineas:", read_env_report(report))


if __name__ == "__main__":
    main()
