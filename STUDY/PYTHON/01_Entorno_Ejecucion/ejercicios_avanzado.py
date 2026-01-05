"""
Ejercicios avanzado - Entorno y ejecucion
"""
import os
import sys


def check_version(min_major, min_minor):
    """Retorna True si la version actual cumple el minimo."""
    # TODO: usa sys.version_info
    return False


def env_summary():
    """Retorna un dict con datos del entorno."""
    # TODO: llena con version, executable, prefix
    return {}


def venv_message():
    """Retorna un mensaje sobre el estado del venv."""
    # TODO: compara sys.prefix y sys.base_prefix
    return ""



def is_windows():
    """Retorna True si el SO es Windows."""
    # TODO: usa sys.platform u os.name
    return False


def path_separator():
    """Retorna separador de rutas del sistema."""
    # TODO: usa os.sep
    return ""

def main():
    print("ok:", check_version(3, 11))
    print("summary:", env_summary())
    print("venv:", venv_message())


if __name__ == "__main__":
    main()

