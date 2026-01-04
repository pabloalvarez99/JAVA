"""
Solucion - HTTP y APIs (extra)
"""
from urllib.parse import urlencode, parse_qsl


def paginate(base, page, size):
    """Retorna URL con paginacion."""
    query = urlencode({"page": page, "size": size})
    return f"{base}?{query}"


def cache_key(url, params):
    """Crea una clave de cache estable."""
    items = sorted(params.items())
    query = urlencode(items)
    return f"{url}?{query}" if query else url


def join_url(base, path):
    """Une base y path con una sola barra."""
    if base.endswith("/"):
        base = base[:-1]
    if not path.startswith("/"):
        path = "/" + path
    return base + path


def normalize_params(params):
    """Normaliza params (valores a str, orden estable)."""
    return [(k, str(params[k])) for k in sorted(params.keys())]


def sanitize_params(params):
    """Retorna params sin valores None."""
    return {k: v for k, v in params.items() if v is not None}


def build_headers(token=None, extra=None):
    """Crea headers base y opcionales."""
    headers = {"Accept": "application/json"}
    if token:
        headers["Authorization"] = f"Bearer {token}"
    if extra:
        headers.update(extra)
    return headers


def is_success(status_code):
    """Retorna True si status_code es 2xx."""
    return 200 <= status_code < 300



def build_query(params):
    """Retorna query string ordenado."""
    return urlencode(sorted(params.items()))


def parse_query(query):
    """Convierte query a dict."""
    return dict(parse_qsl(query))

def main():
    print("page:", paginate("https://api.example.com", 2, 50))
    print("key:", cache_key("/items", {"q": "a"}))


if __name__ == "__main__":
    main()

