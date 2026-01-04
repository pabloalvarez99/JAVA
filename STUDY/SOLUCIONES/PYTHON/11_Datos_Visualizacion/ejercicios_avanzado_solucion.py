"""
Solucion avanzado - Datos y visualizacion
"""

try:
    import pandas as pd
except ImportError:  # pragma: no cover
    pd = None


def zscore(df, col):
    """Calcula z-score de una columna."""
    mean = df[col].mean()
    std = df[col].std()
    return (df[col] - mean) / std


def rolling_mean(df, col, window):
    """Calcula promedio movil."""
    return df[col].rolling(window).mean()



def min_max_scale(df, col):
    """Escala columna a rango 0-1."""
    df = df.copy()
    min_val = df[col].min()
    max_val = df[col].max()
    denom = max_val - min_val
    if denom == 0:
        df[col] = 0
    else:
        df[col] = (df[col] - min_val) / denom
    return df

def main():
    if pd is None:
        print("pandas no instalado")
        return

    df = pd.DataFrame({"ventas": [1, 2, 3, 4, 5]})
    print("z:", zscore(df, "ventas"))
    print("roll:", rolling_mean(df, "ventas", 3))


if __name__ == "__main__":
    main()

