"""
Solucion avanzado - HTTP y APIs
"""
from urllib.parse import urlencode


def cache_key(url, params):
    """Construye clave de cache estable."""
    items = sorted(params.items())
    query = urlencode(items)
    return f"{url}?{query}" if query else url


def should_retry(status):
    """Retorna True si se debe reintentar."""
    return status in {429, 500, 502, 503, 504}



def backoff_delays(retries, base=1):
    """Retorna lista de delays exponenciales."""
    return [base * (2 ** i) for i in range(retries)]

def main():
    print("key:", cache_key("/items", {"b": 2, "a": 1}))
    print("retry:", should_retry(503))


if __name__ == "__main__":
    main()

