"""
Ejercicios basico - Entorno y ejecucion
"""
import sys
from pathlib import Path


def python_version_tuple():
    """Retorna (major, minor, micro)."""
    # TODO: usa sys.version_info
    return (0, 0, 0)


def is_venv_active():
    """Retorna True si un venv esta activo."""
    # TODO: compara sys.prefix y sys.base_prefix
    return False


def script_dir():
    """Retorna el directorio del script."""
    # TODO: usa Path(__file__).parent
    return Path(".")


def main():
    print("version:", python_version_tuple())
    print("venv:", is_venv_active())
    print("dir:", script_dir())


if __name__ == "__main__":
    main()
