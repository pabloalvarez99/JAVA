"""
Solucion - Integracion - Errores y testing
"""

class ConfigError(Exception):
    pass


def parse_pairs(text):
    """Parsea lineas "k=v" en dict."""
    data = {}
    for line in text.splitlines():
        line = line.strip()
        if not line:
            continue
        if "=" not in line:
            raise ConfigError("linea invalida")
        key, value = line.split("=", 1)
        key = key.strip()
        value = value.strip()
        if not key:
            raise ConfigError("clave vacia")
        data[key] = value
    return data


def safe_ratio(a, b):
    """Retorna a/b o None si falla."""
    try:
        return a / b
    except (TypeError, ZeroDivisionError):
        return None

