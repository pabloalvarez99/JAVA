"""
Ejercicios - Datos y visualizacion
"""

try:
    import pandas as pd
except ImportError:  # pragma: no cover
    pd = None


def ventas_por_categoria(df):
    """Agrupa por categoria y suma ventas."""
    # TODO: implementa la logica
    return None


def limpiar_nulos(df):
    """Reemplaza nulos con 0."""
    # TODO: implementa la logica
    return None


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
