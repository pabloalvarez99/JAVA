"""
Solucion intermedio - Modulos y CLI
"""
import argparse


def build_parser():
    parser = argparse.ArgumentParser()
    sub = parser.add_subparsers(dest="cmd")

    add = sub.add_parser("add")
    add.add_argument("--titulo", required=True)

    ls = sub.add_parser("list")
    ls.add_argument("--hechas", action="store_true")

    return parser


def main(argv=None):
    args = build_parser().parse_args(argv)
    print("cmd:", args.cmd)


if __name__ == "__main__":
    main(["add", "--titulo", "leer"])
