"""
Solucion basico - HTTP y APIs
"""
from urllib.parse import urlencode


def build_query(params):
    """Retorna query string desde dict."""
    return urlencode(params)


def build_headers(token=None):
    """Retorna headers basicos."""
    headers = {"User-Agent": "client"}
    if token:
        headers["Authorization"] = f"Bearer {token}"
    return headers



def normalize_headers(headers):
    """Normaliza headers a minusculas."""
    if headers is None:
        return {}
    return {k.lower(): v for k, v in headers.items()}

def main():
    print("query:", build_query({"q": "python"}))
    print("headers:", build_headers("abc"))


if __name__ == "__main__":
    main()

