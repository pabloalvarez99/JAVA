"""
Solucion - Datos y visualizacion (extra)
"""

try:
    import pandas as pd
except ImportError:  # pragma: no cover
    pd = None


def resumen(df):
    """Retorna un dict con suma y promedio de la columna ventas."""
    return {"suma": df["ventas"].sum(), "promedio": df["ventas"].mean()}


def agregar_margen(df):
    """Agrega columna margen = ventas - costo."""
    df = df.copy()
    df["margen"] = df["ventas"] - df["costo"]
    return df


def filtrar_min_ventas(df, minimo):
    """Retorna filas con ventas >= minimo."""
    return df[df["ventas"] >= minimo]


def ordenar_por(df, columna, desc=False):
    """Retorna df ordenado por columna."""
    return df.sort_values(by=columna, ascending=not desc)


def agregar_pct_margen(df):
    """Agrega columna margen_pct = margen / ventas."""
    df = df.copy()
    df["margen"] = df["ventas"] - df["costo"]
    df["margen_pct"] = df["margen"] / df["ventas"]
    return df


def seleccionar_columnas(df, columnas):
    """Retorna df con columnas seleccionadas."""
    return df[columnas]


def resumen_por_columna(df, columna):
    """Retorna dict con suma y promedio de columna."""
    return {"suma": df[columna].sum(), "promedio": df[columna].mean()}



def fill_missing(df, columna, value):
    """Rellena nulos en columna."""
    df = df.copy()
    df[columna] = df[columna].fillna(value)
    return df


def renombrar_columnas(df, mapping):
    """Renombra columnas segun mapping."""
    return df.rename(columns=mapping)

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

