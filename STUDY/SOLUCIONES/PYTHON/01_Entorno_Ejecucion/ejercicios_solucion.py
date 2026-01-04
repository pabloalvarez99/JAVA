"""
Solucion - Entorno y ejecucion
"""
from pathlib import Path
import os
import sys


def entorno_info():
    """Devuelve un dict con version, executable y cwd."""
    return {"version": sys.version, "executable": sys.executable, "cwd": os.getcwd()}


def venv_activo():
    """Retorna True si un venv esta activo."""
    base = getattr(sys, "base_prefix", sys.prefix)
    return sys.prefix != base


def guardar_sys_path(ruta):
    """Guarda sys.path en un archivo, una linea por entrada."""
    ruta = Path(ruta)
    ruta.write_text("\n".join(sys.path), encoding="utf-8")


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
