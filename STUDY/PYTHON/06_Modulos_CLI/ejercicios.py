"""
Ejercicios - Modulos y CLI
"""
import argparse


def build_parser():
    """Crea y retorna el parser."""
    parser = argparse.ArgumentParser()
    # TODO: agrega --archivo y --palabra
    # TODO: agrega --verbose y --salida opcional
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
