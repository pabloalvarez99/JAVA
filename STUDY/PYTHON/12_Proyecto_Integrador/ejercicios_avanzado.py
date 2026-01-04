"""
Ejercicios avanzado - Proyecto integrador
"""
from pathlib import Path
import json


def backup_file(path):
    """Crea una copia del archivo con extension .bak."""
    # TODO: implementa la logica
    return None


def migrate_v1_to_v2(data):
    """Migra datos a un nuevo formato."""
    # TODO: implementa la logica
    return data



def restore_backup(path):
    """Restaura backup y retorna datos o None."""
    # TODO: implementa la logica
    return None

def main():
    base = Path(__file__).parent
    path = base / "tareas.json"
    path.write_text("[]", encoding="utf-8")
    print("backup:", backup_file(path))
    print("migrate:", migrate_v1_to_v2([]))


if __name__ == "__main__":
    main()

