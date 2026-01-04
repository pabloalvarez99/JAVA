"""
Solucion avanzado - Proyecto integrador
"""
from pathlib import Path
import json


def backup_file(path):
    """Crea una copia del archivo con extension .bak."""
    path = Path(path)
    backup = path.with_suffix(path.suffix + ".bak")
    backup.write_text(path.read_text(encoding="utf-8"), encoding="utf-8")
    return backup


def migrate_v1_to_v2(data):
    """Migra datos a un nuevo formato."""
    out = []
    for item in data:
        nuevo = dict(item)
        nuevo.setdefault("hecha", False)
        out.append(nuevo)
    return out



def restore_backup(path):
    """Restaura backup y retorna datos o None."""
    path = Path(path)
    backup = path.with_suffix(path.suffix + ".bak")
    if not backup.exists():
        return None
    return json.loads(backup.read_text(encoding="utf-8"))

def main():
    base = Path(__file__).parent
    path = base / "tareas.json"
    path.write_text("[]", encoding="utf-8")
    print("backup:", backup_file(path))
    print("migrate:", migrate_v1_to_v2([]))


if __name__ == "__main__":
    main()

