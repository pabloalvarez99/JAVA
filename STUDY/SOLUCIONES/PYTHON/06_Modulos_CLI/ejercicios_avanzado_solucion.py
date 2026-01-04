"""
Solucion avanzado - Modulos y CLI
"""
import json
from pathlib import Path


def load_config(path):
    """Carga JSON y retorna dict."""
    path = Path(path)
    if not path.exists():
        return {}
    return json.loads(path.read_text(encoding="utf-8"))


def save_config(path, data):
    """Guarda JSON en disco."""
    path = Path(path)
    path.write_text(json.dumps(data, indent=2), encoding="utf-8")


def main():
    path = Path(__file__).with_name("config.json")
    save_config(path, {"tema": "claro"})
    print("config:", load_config(path))


if __name__ == "__main__":
    main()
