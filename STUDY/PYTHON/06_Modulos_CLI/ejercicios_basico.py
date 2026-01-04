"""
Ejercicios basico - Modulos y CLI
"""
import argparse


def build_parser():
    parser = argparse.ArgumentParser()
    # TODO: agrega --archivo y --palabra
    return parser


def main(argv=None):
    args = build_parser().parse_args(argv)
    print("archivo:", getattr(args, "archivo", None))
    print("palabra:", getattr(args, "palabra", None))


if __name__ == "__main__":
    main(["--archivo", "a.txt", "--palabra", "hola"])
