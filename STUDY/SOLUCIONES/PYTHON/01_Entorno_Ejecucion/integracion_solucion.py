"""
Solucion - Integracion - Entorno y ejecucion
"""
import json
import sys
from pathlib import Path


def env_report():
    """Retorna dict con info del entorno."""
    base = getattr(sys, "base_prefix", sys.prefix)
    return {
        "executable": sys.executable,
        "version": sys.version,
        "cwd": str(Path.cwd()),
        "venv": sys.prefix != base,
    }


def write_report(path, data):
    """Guarda reporte en JSON."""
    path = Path(path)
    path.write_text(json.dumps(data, indent=2), encoding="utf-8")

