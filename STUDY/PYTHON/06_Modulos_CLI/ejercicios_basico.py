"""
Ejercicios basico - Modulos y CLI
"""
import argparse


def build_parser():
    parser = argparse.ArgumentParser()
    # TODO: agrega --archivo y --palabra
    return parser



def count_args(argv):
    """Retorna cantidad de argumentos."""
    # TODO: implementa la logica
    return 0


def has_flag(argv, flag):
    """Retorna True si flag esta en argv."""
    # TODO: implementa la logica
    return False

def main(argv=None):
    args = build_parser().parse_args(argv)
    print("archivo:", getattr(args, "archivo", None))
    print("palabra:", getattr(args, "palabra", None))


if __name__ == "__main__":
    main(["--archivo", "a.txt", "--palabra", "hola"])

