"""
Solucion basico - Entorno y ejecucion
"""
import sys
from pathlib import Path


def python_version_tuple():
    """Retorna (major, minor, micro)."""
    info = sys.version_info
    return (info.major, info.minor, info.micro)


def is_venv_active():
    """Retorna True si un venv esta activo."""
    base = getattr(sys, "base_prefix", sys.prefix)
    return sys.prefix != base


def script_dir():
    """Retorna el directorio del script."""
    return Path(__file__).parent


def main():
    print("version:", python_version_tuple())
    print("venv:", is_venv_active())
    print("dir:", script_dir())


if __name__ == "__main__":
    main()
