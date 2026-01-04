"""
Ejercicios - HTTP y APIs
"""
import json
from urllib.parse import urlencode


def build_headers(token=None):
    """Construye headers basicos para una API."""
    # TODO: agrega Authorization si hay token
    return {"User-Agent": "python-client"}


def build_url(base, params):
    """Construye una URL con query params."""
    # TODO: usa urlencode para generar la query
    return base


def is_json_content(headers):
    """Retorna True si Content-Type contiene application/json."""
    # TODO: implementa la logica
    return False


def parse_json_safe(texto):
    """Parsea JSON y retorna dict o None si falla."""
    # TODO: implementa la logica
    return None


def main():
    print("headers:", build_headers("token123"))
    print("url:", build_url("https://api.example.com", {"q": "python"}))
    print("is_json:", is_json_content({"Content-Type": "application/json"}))
    print("parse:", parse_json_safe('{"ok": true}'))


if __name__ == "__main__":
    main()
