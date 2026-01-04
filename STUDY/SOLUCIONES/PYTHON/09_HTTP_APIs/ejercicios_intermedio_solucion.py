"""
Solucion intermedio - HTTP y APIs
"""
import json


def parse_json_safe(texto):
    """Retorna dict o None si falla."""
    try:
        return json.loads(texto)
    except json.JSONDecodeError:
        return None


def select_fields(data, fields):
    """Retorna dict con solo los campos dados."""
    return {k: data[k] for k in fields if k in data}



def merge_params(a, b):
    """Combina params (b sobreescribe)."""
    res = dict(a)
    res.update(b)
    return res

def main():
    print("parse:", parse_json_safe('{"ok": true}'))
    print("fields:", select_fields({"a": 1, "b": 2}, ["b"]))


if __name__ == "__main__":
    main()

