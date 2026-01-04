"""
Ejercicios - Entorno y ejecucion
Completa los TODOs y ejecuta este archivo.
"""
from pathlib import Path
import os
import sys


def entorno_info():
    """Devuelve un dict con version, executable y cwd."""
    # TODO: completa los valores reales
    return {"version": "", "executable": "", "cwd": ""}


def venv_activo():
    """Retorna True si un venv esta activo."""
    # TODO: compara sys.prefix y sys.base_prefix
    return False


def guardar_sys_path(ruta):
    """Guarda sys.path en un archivo, una linea por entrada."""
    # TODO: escribe sys.path en ruta
    pass


def main():
    info = entorno_info()
    print("version:", info.get("version"))
    print("executable:", info.get("executable"))
    print("cwd:", info.get("cwd"))
    print("venv activo:", venv_activo())

    destino = Path(__file__).with_name("sys_path.txt")
    guardar_sys_path(destino)
    print("sys.path guardado en:", destino.name)


if __name__ == "__main__":
    main()
