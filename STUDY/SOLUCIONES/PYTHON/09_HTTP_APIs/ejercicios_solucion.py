"""
Solucion - HTTP y APIs
"""
import json
from urllib.parse import urlencode


def build_headers(token=None):
    """Construye headers basicos para una API."""
    headers = {"User-Agent": "python-client"}
    if token:
        headers["Authorization"] = f"Bearer {token}"
    return headers


def build_url(base, params):
    """Construye una URL con query params."""
    if not params:
        return base
    return f"{base}?{urlencode(params)}"


def is_json_content(headers):
    """Retorna True si Content-Type contiene application/json."""
    value = headers.get("Content-Type", "")
    return "application/json" in value


def parse_json_safe(texto):
    """Parsea JSON y retorna dict o None si falla."""
    try:
        return json.loads(texto)
    except json.JSONDecodeError:
        return None


def main():
    print("headers:", build_headers("token123"))
    print("url:", build_url("https://api.example.com", {"q": "python"}))
    print("is_json:", is_json_content({"Content-Type": "application/json"}))
    print("parse:", parse_json_safe('{"ok": true}'))


if __name__ == "__main__":
    main()
