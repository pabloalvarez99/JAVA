"""
Solucion - Modulos y CLI
"""
import argparse


def build_parser():
    """Crea y retorna el parser."""
    parser = argparse.ArgumentParser()
    parser.add_argument("--archivo", required=True)
    parser.add_argument("--palabra", required=True)
    parser.add_argument("--verbose", action="store_true")
    parser.add_argument("--salida")
    return parser


def main(argv=None):
    parser = build_parser()
    args = parser.parse_args(argv)
    print("archivo:", getattr(args, "archivo", None))
    print("palabra:", getattr(args, "palabra", None))
    print("verbose:", getattr(args, "verbose", None))
    print("salida:", getattr(args, "salida", None))


if __name__ == "__main__":
    main(["--archivo", "datos.txt", "--palabra", "hola", "--verbose"])
