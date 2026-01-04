"""
Solucion intermedio - Datos y visualizacion
"""

try:
    import pandas as pd
except ImportError:  # pragma: no cover
    pd = None


def group_sum(df, group_col, sum_col):
    """Agrupa y suma."""
    return df.groupby(group_col)[sum_col].sum()


def filter_by_value(df, col, value):
    """Filtra por valor exacto."""
    return df[df[col] == value]



def sort_by(df, col, desc=False):
    """Ordena por columna."""
    return df.sort_values(by=col, ascending=not desc)

def main():
    if pd is None:
        print("pandas no instalado")
        return

    df = pd.DataFrame(
        [
            {"cat": "A", "ventas": 5},
            {"cat": "A", "ventas": 2},
            {"cat": "B", "ventas": 3},
        ]
    )
    print("group:", group_sum(df, "cat", "ventas"))
    print("filter:", filter_by_value(df, "cat", "A"))


if __name__ == "__main__":
    main()

