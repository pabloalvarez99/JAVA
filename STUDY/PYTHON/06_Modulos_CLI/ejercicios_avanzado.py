"""
Ejercicios avanzado - Modulos y CLI
"""
import json
from pathlib import Path


def load_config(path):
    """Carga JSON y retorna dict."""
    # TODO: implementa la logica
    return {}


def save_config(path, data):
    """Guarda JSON en disco."""
    # TODO: implementa la logica
    pass


def main():
    path = Path(__file__).with_name("config.json")
    save_config(path, {"tema": "claro"})
    print("config:", load_config(path))


if __name__ == "__main__":
    main()
