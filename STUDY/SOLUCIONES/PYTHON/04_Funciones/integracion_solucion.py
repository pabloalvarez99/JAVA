"""
Solucion - Integracion - Funciones
"""

def apply_pipeline(value, fns):
    """Aplica secuencialmente funciones."""
    out = value
    for fn in fns:
        out = fn(out)
    return out


def make_power(exp):
    """Retorna funcion potencia."""
    def inner(x):
        return x ** exp
    return inner

