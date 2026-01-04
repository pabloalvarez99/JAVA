"""
Ejercicios avanzado - Datos y visualizacion
"""

try:
    import pandas as pd
except ImportError:  # pragma: no cover
    pd = None


def zscore(df, col):
    """Calcula z-score de una columna."""
    # TODO: implementa la logica
    return None


def rolling_mean(df, col, window):
    """Calcula promedio movil."""
    # TODO: implementa la logica
    return None



def min_max_scale(df, col):
    """Escala columna a rango 0-1."""
    # TODO: implementa la logica
    return None

def main():
    if pd is None:
        print("pandas no instalado")
        return

    df = pd.DataFrame({"ventas": [1, 2, 3, 4, 5]})
    print("z:", zscore(df, "ventas"))
    print("roll:", rolling_mean(df, "ventas", 3))


if __name__ == "__main__":
    main()

