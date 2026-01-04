"""
Ejercicios avanzado - HTTP y APIs
"""
from urllib.parse import urlencode


def cache_key(url, params):
    """Construye clave de cache estable."""
    # TODO: ordena params y concatena
    return ""


def should_retry(status):
    """Retorna True si se debe reintentar."""
    # TODO: implementa la logica
    return False



def backoff_delays(retries, base=1):
    """Retorna lista de delays exponenciales."""
    # TODO: implementa la logica
    return []

def main():
    print("key:", cache_key("/items", {"b": 2, "a": 1}))
    print("retry:", should_retry(503))


if __name__ == "__main__":
    main()

