"""
Ejercicios - Funciones
"""

def es_primo(n):
    """Retorna True si n es primo."""
    # TODO: implementa la logica
    return False


def promedio(*nums):
    """Retorna el promedio de los numeros."""
    # TODO: implementa la logica
    return 0.0


def safe_div(a, b):
    """Divide a/b o retorna None si b == 0."""
    # TODO: implementa la logica
    return None


def normalizar(texto):
    """Lower + trim + reemplaza espacios multiples por uno."""
    # TODO: implementa la logica
    return ""


def contar_palabras(texto):
    """Cuenta palabras y retorna un dict."""
    # TODO: implementa la logica
    return {}


def main():
    print("primo 11:", es_primo(11))
    print("promedio:", promedio(2, 4, 6))
    print("safe_div:", safe_div(10, 0))
    print("normalizar:", normalizar("  Hola   Mundo  "))
    print("palabras:", contar_palabras("hola hola mundo"))


if __name__ == "__main__":
    main()
