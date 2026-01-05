"""
Ejercicios intermedio - Entorno y ejecucion
"""
import importlib.util
import os
from pathlib import Path
import sys


def module_exists(name):
    """Retorna True si el modulo existe."""
    # TODO: usa importlib.util.find_spec
    return False


def save_env_report(path):
    """Guarda un reporte simple del entorno."""
    # TODO: escribe version, executable y cwd
    pass


def read_env_report(path):
    """Lee el reporte y retorna una lista de lineas."""
    # TODO: lee el archivo y separa por lineas
    return []



def env_to_dict(prefix):
    """Retorna dict con variables que inician con prefix."""
    # TODO: usa os.environ
    return {}


def resolve_relative(path):
    """Retorna ruta absoluta resuelta."""
    # TODO: usa Path(path).expanduser().resolve()
    return ""

def main():
    print("json existe:", module_exists("json"))
    report = Path(__file__).with_name("env_report.txt")
    save_env_report(report)
    print("lineas:", read_env_report(report))


if __name__ == "__main__":
    main()

