"""
Ejercicios extra - Entorno y ejecucion
"""
import importlib.util
import os
import shutil
import sys
from pathlib import Path


def version_major():
    """Retorna la version mayor de Python."""
    # TODO: usa sys.version_info
    return 0


def is_module_available(name):
    """Retorna True si el modulo se puede importar."""
    # TODO: intenta importar y retorna True/False
    return False


def write_info(path):
    """Guarda sys.executable y sys.version en un archivo."""
    # TODO: escribe contenido con Path.write_text
    pass


def is_venv_active():
    """Retorna True si hay un entorno virtual activo."""
    # TODO: usa sys.prefix y sys.base_prefix
    return False


def module_path(name):
    """Retorna ruta del modulo o None si no existe."""
    # TODO: usa importlib.util.find_spec
    return None


def safe_which(exe):
    """Retorna ruta de un ejecutable o None si no existe."""
    # TODO: usa shutil.which
    return None


def normalize_path(path):
    """Retorna ruta absoluta expandiendo ~."""
    # TODO: usa Path(path).expanduser().absolute()
    return ""



def read_env_var(name, default=None):
    """Retorna variable de entorno o default."""
    # TODO: usa os.environ.get
    return default


def current_working_dir():
    """Retorna el directorio actual."""
    # TODO: usa Path.cwd
    return ""

def main():
    print("major:", version_major())
    print("has_json:", is_module_available("json"))
    out = Path(__file__).with_name("info.txt")
    write_info(out)
    print("wrote:", out.name)


if __name__ == "__main__":
    main()

