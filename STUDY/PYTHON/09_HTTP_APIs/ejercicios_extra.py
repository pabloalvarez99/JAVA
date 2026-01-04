"""
Ejercicios extra - HTTP y APIs
"""
from urllib.parse import urlencode, parse_qsl


def paginate(base, page, size):
    """Retorna URL con paginacion."""
    # TODO: usa urlencode
    return base


def cache_key(url, params):
    """Crea una clave de cache estable."""
    # TODO: implementa la logica
    return ""


def join_url(base, path):
    """Une base y path con una sola barra."""
    # TODO: implementa la logica
    return ""


def normalize_params(params):
    """Normaliza params (valores a str, orden estable)."""
    # TODO: implementa la logica
    return []


def sanitize_params(params):
    """Retorna params sin valores None."""
    # TODO: implementa la logica
    return {}


def build_headers(token=None, extra=None):
    """Crea headers base y opcionales."""
    # TODO: implementa la logica
    return {}


def is_success(status_code):
    """Retorna True si status_code es 2xx."""
    # TODO: implementa la logica
    return False



def build_query(params):
    """Retorna query string ordenado."""
    # TODO: implementa la logica
    return ""


def parse_query(query):
    """Convierte query a dict."""
    # TODO: implementa la logica
    return {}

def main():
    print("page:", paginate("https://api.example.com", 2, 50))
    print("key:", cache_key("/items", {"q": "a"}))


if __name__ == "__main__":
    main()

