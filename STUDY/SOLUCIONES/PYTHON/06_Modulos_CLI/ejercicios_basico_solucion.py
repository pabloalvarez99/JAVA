"""
Solucion basico - Modulos y CLI
"""
import argparse


def build_parser():
    parser = argparse.ArgumentParser()
    parser.add_argument("--archivo", required=True)
    parser.add_argument("--palabra", required=True)
    return parser



def count_args(argv):
    """Retorna cantidad de argumentos."""
    return len(argv) if argv else 0


def has_flag(argv, flag):
    """Retorna True si flag esta en argv."""
    return flag in (argv or [])

def main(argv=None):
    args = build_parser().parse_args(argv)
    print("archivo:", getattr(args, "archivo", None))
    print("palabra:", getattr(args, "palabra", None))


if __name__ == "__main__":
    main(["--archivo", "a.txt", "--palabra", "hola"])

