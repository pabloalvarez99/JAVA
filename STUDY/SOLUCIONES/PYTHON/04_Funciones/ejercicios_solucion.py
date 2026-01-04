"""
Solucion - Funciones
"""

def es_primo(n):
    """Retorna True si n es primo."""
    if n < 2:
        return False
    i = 2
    while i * i <= n:
        if n % i == 0:
            return False
        i += 1
    return True


def promedio(*nums):
    """Retorna el promedio de los numeros."""
    if not nums:
        return 0.0
    return sum(nums) / len(nums)


def safe_div(a, b):
    """Divide a/b o retorna None si b == 0."""
    if b == 0:
        return None
    return a / b


def normalizar(texto):
    """Lower + trim + reemplaza espacios multiples por uno."""
    return " ".join(texto.strip().lower().split())


def contar_palabras(texto):
    """Cuenta palabras y retorna un dict."""
    conteo = {}
    for palabra in texto.split():
        conteo[palabra] = conteo.get(palabra, 0) + 1
    return conteo


def main():
    print("primo 11:", es_primo(11))
    print("promedio:", promedio(2, 4, 6))
    print("safe_div:", safe_div(10, 0))
    print("normalizar:", normalizar("  Hola   Mundo  "))
    print("palabras:", contar_palabras("hola hola mundo"))


if __name__ == "__main__":
    main()
