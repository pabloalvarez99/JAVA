"""
Ejercicios basico - HTTP y APIs
"""
from urllib.parse import urlencode


def build_query(params):
    """Retorna query string desde dict."""
    # TODO: usa urlencode
    return ""


def build_headers(token=None):
    """Retorna headers basicos."""
    # TODO: agrega Authorization si hay token
    return {"User-Agent": "client"}



def normalize_headers(headers):
    """Normaliza headers a minusculas."""
    # TODO: implementa la logica
    return {}

def main():
    print("query:", build_query({"q": "python"}))
    print("headers:", build_headers("abc"))


if __name__ == "__main__":
    main()

