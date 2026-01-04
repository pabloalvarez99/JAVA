"""
Solucion - Entorno y ejecucion (extra)
"""
import importlib.util
import os
import shutil
import sys
from pathlib import Path


def version_major():
    """Retorna la version mayor de Python."""
    return sys.version_info.major


def is_module_available(name):
    """Retorna True si el modulo se puede importar."""
    return importlib.util.find_spec(name) is not None


def write_info(path):
    """Guarda sys.executable y sys.version en un archivo."""
    path = Path(path)
    contenido = f"{sys.executable}\n{sys.version}\n"
    path.write_text(contenido, encoding="utf-8")


def is_venv_active():
    """Retorna True si hay un entorno virtual activo."""
    base = getattr(sys, "base_prefix", sys.prefix)
    return sys.prefix != base


def module_path(name):
    """Retorna ruta del modulo o None si no existe."""
    spec = importlib.util.find_spec(name)
    if spec is None or spec.origin is None:
        return None
    return spec.origin


def safe_which(exe):
    """Retorna ruta de un ejecutable o None si no existe."""
    return shutil.which(exe)


def normalize_path(path):
    """Retorna ruta absoluta expandiendo ~."""
    return str(Path(path).expanduser().absolute())



def read_env_var(name, default=None):
    """Retorna variable de entorno o default."""
    return os.environ.get(name, default)


def current_working_dir():
    """Retorna el directorio actual."""
    return str(Path.cwd())

def main():
    print("major:", version_major())
    print("has_json:", is_module_available("json"))
    out = Path(__file__).with_name("info.txt")
    write_info(out)
    print("wrote:", out.name)


if __name__ == "__main__":
    main()

