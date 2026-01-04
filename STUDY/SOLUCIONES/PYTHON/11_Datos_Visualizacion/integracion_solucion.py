"""
Solucion - Integracion - Datos y visualizacion
"""
try:
    import pandas as pd
except ImportError:  # pragma: no cover
    pd = None


def clean_df(df):
    """Rellena nulos con 0."""
    return df.fillna(0)


def top_por(df, columna, n):
    """Retorna top n por columna."""
    return df.sort_values(by=columna, ascending=False).head(n)

