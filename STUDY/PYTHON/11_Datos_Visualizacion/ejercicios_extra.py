"""
Ejercicios extra - Datos y visualizacion
"""

try:
    import pandas as pd
except ImportError:  # pragma: no cover
    pd = None


def resumen(df):
    """Retorna un dict con suma y promedio de la columna ventas."""
    # TODO: implementa la logica
    return {}


def agregar_margen(df):
    """Agrega columna margen = ventas - costo."""
    # TODO: implementa la logica
    return df


def filtrar_min_ventas(df, minimo):
    """Retorna filas con ventas >= minimo."""
    # TODO: implementa la logica
    return df


def ordenar_por(df, columna, desc=False):
    """Retorna df ordenado por columna."""
    # TODO: implementa la logica
    return df


def agregar_pct_margen(df):
    """Agrega columna margen_pct = margen / ventas."""
    # TODO: implementa la logica
    return df


def seleccionar_columnas(df, columnas):
    """Retorna df con columnas seleccionadas."""
    # TODO: implementa la logica
    return df


def resumen_por_columna(df, columna):
    """Retorna dict con suma y promedio de columna."""
    # TODO: implementa la logica
    return {}



def fill_missing(df, columna, value):
    """Rellena nulos en columna."""
    # TODO: implementa la logica
    return df


def renombrar_columnas(df, mapping):
    """Renombra columnas segun mapping."""
    # TODO: implementa la logica
    return df

def main():
    if pd is None:
        print("pandas no instalado")
        return

    df = pd.DataFrame(
        [
            {"ventas": 10, "costo": 4},
            {"ventas": 5, "costo": 2},
        ]
    )
    print("resumen:", resumen(df))
    print("margen:", agregar_margen(df))


if __name__ == "__main__":
    main()

