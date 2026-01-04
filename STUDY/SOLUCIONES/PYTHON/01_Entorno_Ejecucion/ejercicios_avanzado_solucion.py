"""
Solucion avanzado - Entorno y ejecucion
"""
import os
import sys


def check_version(min_major, min_minor):
    """Retorna True si la version actual cumple el minimo."""
    info = sys.version_info
    return (info.major, info.minor) >= (min_major, min_minor)


def env_summary():
    """Retorna un dict con datos del entorno."""
    return {
        "version": sys.version,
        "executable": sys.executable,
        "prefix": sys.prefix,
    }


def venv_message():
    """Retorna un mensaje sobre el estado del venv."""
    base = getattr(sys, "base_prefix", sys.prefix)
    return "venv activo" if sys.prefix != base else "venv no activo"


def main():
    print("ok:", check_version(3, 11))
    print("summary:", env_summary())
    print("venv:", venv_message())


if __name__ == "__main__":
    main()
