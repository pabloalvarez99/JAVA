"""
Solucion - Integracion - HTTP y APIs
"""
from urllib.parse import urlencode


def build_url(base, path, params):
    """Construye URL con query."""
    if base.endswith("/"):
        base = base[:-1]
    if not path.startswith("/"):
        path = "/" + path
    query = urlencode(sorted(params.items()))
    return base + path + ("?" + query if query else "")


def is_retryable(status):
    """Retorna True si status es 429 o 5xx."""
    return status == 429 or 500 <= status < 600

