"""
Solucion basico - Datos y visualizacion
"""

try:
    import pandas as pd
except ImportError:  # pragma: no cover
    pd = None


def sum_column(df, col):
    """Suma una columna."""
    return df[col].sum()



def mean_column(df, col):
    """Promedio de una columna."""
    return df[col].mean()

def main():
    if pd is None:
        print("pandas no instalado")
        return

    df = pd.DataFrame({"ventas": [1, 2, 3]})
    print("sum:", sum_column(df, "ventas"))


if __name__ == "__main__":
    main()

