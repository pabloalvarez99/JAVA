"""
Ejercicios intermedio - HTTP y APIs
"""
import json


def parse_json_safe(texto):
    """Retorna dict o None si falla."""
    # TODO: implementa la logica
    return None


def select_fields(data, fields):
    """Retorna dict con solo los campos dados."""
    # TODO: implementa la logica
    return {}



def merge_params(a, b):
    """Combina params (b sobreescribe)."""
    # TODO: implementa la logica
    return {}

def main():
    print("parse:", parse_json_safe('{"ok": true}'))
    print("fields:", select_fields({"a": 1, "b": 2}, ["b"]))


if __name__ == "__main__":
    main()

