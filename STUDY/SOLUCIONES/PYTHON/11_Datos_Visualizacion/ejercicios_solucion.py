"""
Solucion - Datos y visualizacion
"""

try:
    import pandas as pd
except ImportError:  # pragma: no cover
    pd = None


def ventas_por_categoria(df):
    """Agrupa por categoria y suma ventas."""
    return df.groupby("categoria")["ventas"].sum().to_dict()


def limpiar_nulos(df):
    """Reemplaza nulos con 0."""
    return df.fillna(0)


def main():
    if pd is None:
        print("pandas no instalado")
        return

    df = pd.DataFrame(
        [
            {"categoria": "A", "ventas": 10},
            {"categoria": "A", "ventas": 5},
            {"categoria": "B", "ventas": 7},
        ]
    )
    print("ventas:", ventas_por_categoria(df))
    print("limpio:", limpiar_nulos(df))


if __name__ == "__main__":
    main()
